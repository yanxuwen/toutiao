function _getNewsArticleVersion() {
var e = /NewsArticle\/([\d\.]*)/i.exec(navigator.userAgent);
return e ? e[1] : "";
}

function _getAndroidVersion() {
var e = /android ([0-9\.]*)/i.exec(navigator.userAgent);
return e ? e[1] : "";
}

function _getIOSVersion() {
var e = /iPhone OS ([0-9_]*)/i.exec(navigator.userAgent);
return e ? e[1].replace(/_/g, ".") : "";
}

function _isNewsArticleVersionNoLessThan(e) {
var t = client.newsArticleVersion;
return t ? (e = e.split(".").slice(0, 3), t = +t.split(".").slice(0, e.length).join(""), 
t >= +e.join("")) : !1;
}

function hash2string(e) {
var t = "#";
for (var a in e) t += a + "=" + e[a] + "&";
return "&" == t.substr(-1) ? t = t.slice(0, -1) : "#" == t.substr(-1) && (t = ""), 
t;
}

function formatCount(e, t, a) {
var n = "";
if ("number" != typeof t || 0 === t) n = a || "赞"; else if (1e4 > t) n = t; else if (1e8 > t) {
var i = (Math.floor(t / 1e3) / 10).toFixed(1);
n = (i.indexOf(".0") > -1 || i >= 10 ? i.slice(0, -2) : i) + "万";
} else {
var i = (Math.floor(t / 1e7) / 10).toFixed(1);
n = (i.indexOf(".0") > -1 || i >= 10 ? i.slice(0, -2) : i) + "亿";
}
return e && $(e).each(function() {
$(this).attr("realnum", t).html(n);
}), n;
}

function commentTimeFormat(e) {
var t, a = new Date(), n = "";
try {
if (t = new Date(1e3 * e), isNaN(t.getTime())) throw new Error("Invalid Date");
} catch (i) {
return "";
}
return n += t.getFullYear() < a.getFullYear() ? t.getFullYear() + "-" : "", n += t.getMonth() >= 9 ? t.getMonth() + 1 : "0" + (t.getMonth() + 1), 
n += "-", n += t.getDate() > 9 ? t.getDate() : "0" + t.getDate(), n += " ", n += t.getHours() > 9 ? t.getHours() : "0" + t.getHours(), 
n += ":", n += t.getMinutes() > 9 ? t.getMinutes() : "0" + t.getMinutes();
}

function formatDuration(e) {
if (isNaN(Number(e))) return "00:00";
var t = [ Math.floor(e / 60), ":", Math.ceil(e % 60) ];
return t[2] <= 9 && t.splice(2, 0, 0), t[0] <= 9 && t.unshift(0), t.join("");
}

function formatTime(e) {
var t = 6e4, a = 60 * t, n = new Date(), i = n.getTime(), r = new Date(n.getFullYear(), n.getMonth(), n.getDate()), o = new Date(+e);
if (isNaN(o.getTime())) return "";
var s = i - e;
if (0 > s) return "";
if (t > s) return "刚刚";
if (a > s) return Math.floor(s / t) + "分钟前";
if (24 * a > s) return Math.floor(s / a) + "小时前";
for (var l = (o.getHours() > 9 ? o.getHours() : "0" + o.getHours()) + ":" + (o.getMinutes() > 9 ? o.getMinutes() : "0" + o.getMinutes()), c = 0; c++ <= 8; ) if (r.setDate(r.getDate() - 1), 
e > r.getTime()) return 1 === c ? "昨天 " + l : 2 === c ? "前天 " + l : c + "天前";
return (o.getFullYear() < n.getFullYear() ? o.getFullYear() + "年" : "") + (o.getMonth() + 1) + "月" + o.getDate() + "日";
}

function send_umeng_event(e, t, a) {
var n = "bytedance://" + event_type + "?category=umeng&tag=" + e + "&label=" + t;
if (a) for (var i in a) {
var r = a[i];
if ("extra" === i && "object" == typeof r) if (client.isAndroid) n += "&extra=" + JSON.stringify(r); else {
var o = "";
for (var s in r) o += "object" == typeof r[s] ? "&" + s + "=" + JSON.stringify(r[s]) : "&" + s + "=" + r[s];
n += o;
} else n += "&" + i + "=" + r;
}
try {
window.webkit.messageHandlers.observe.postMessage(n);
} catch (l) {
console.log(n);
}
}

function sendUmengEventV3(e, t, a) {
if ("string" == typeof e && "" !== e) {
var n = "log_event_v3?event=" + e + "&params=" + JSON.stringify(t || {}) + "&is_double_sending=" + (a ? "1" : "0");
sendBytedanceRequest(n);
}
}

function send_request(e, t) {
var a = "bytedance://" + e;
if (t) {
a += "?";
for (var n in t) a += n + "=" + t[n] + "&";
a = a.slice(0, -1);
}
location.href = a;
}

function send_exposure_event_once(e, t, a) {
function n() {
r && clearTimeout(r), r = setTimeout(function() {
var a = i(e, o);
console.info(a, e), a && (t(), document.removeEventListener("scroll", n, !1));
}, 50);
}
function i(e, t) {
var n = e.getBoundingClientRect(), i = n.top, r = n.height || n.bottom - n.top, o = i;
return a && (o = i + r), t >= o;
}
if (e && "function" == typeof t) {
var r = 0, o = window.innerHeight;
i(e, o) ? t() : document.addEventListener("scroll", n, !1);
}
}

function isElementInViewportY(e, t) {
var a = e.getBoundingClientRect(), n = window.innerHeight || document.body.clientHeight;
return t ? a.height < n ? a.top >= 0 && a.top <= n && a.bottom >= 0 && a.bottom <= n : a.top <= 0 && a.bottom >= n : a.top <= n && a.bottom >= 0;
}

function sendUmengWhenTargetShown(e, t, a, n, i, r) {
e && (isElementInViewportY(e, i) ? r && 3 === r.version ? sendUmengEventV3(t, n, !!r.isDoubleSend) : send_umeng_event(t, a, n) : imprProcessQueue.push(arguments));
}

function wendaCacheAdd(e) {
WendaCacheUmeng.push(e);
}

function wendaCacheRemove() {
var e, t;
for (e = 0, t = WendaCacheUmeng.length; t > e; e++) "function" == typeof WendaCacheUmeng[e] && WendaCacheUmeng[e]();
WendaCacheUmeng = [];
}

function buildServerVIcon(e, t) {
var a = Page.h5_settings.user_verify_info_conf["" + e];
if (!a) return "";
if (a = a[t], !a) return "";
var t = a.icon;
return t = client.isIOS ? a.web_icon_ios : client.isSeniorAndroid ? a.web_icon_android : a.icon_png, 
'<i class="server-v-icon" style="background-image: url(' + t + ');">&nbsp;</i>';
}

function buildServerVIcon2(e, t) {
var a = Page.h5_settings.user_verify_info_conf["" + e];
if (!a) return "";
if (a = a[t], !a) return "";
var t = a.icon;
return t = client.isIOS ? a.web_icon_ios : parseFloat(client.osVersion) > 4.4 ? a.web_icon_android : a.icon_png, 
'<div class="server-v-icon-wrap"><i class="server-v-icon" style="background-image: url(' + t + ');">&nbsp;</i></div>';
}

function trans_v_info(e) {
var t = {};
if (Array.isArray(e.type_config)) for (var a = 0; a < e.type_config.length; a++) {
var n = e.type_config[a];
t[n.type] = n;
}
return t;
}

function nz_closest(e, t) {
for (var a = e.matches || e.webkitMatchesSelector || e.mozMatchesSelector || e.msMatchesSelector; e; ) {
if (a.call(e, t)) return e;
e = e.parentElement;
}
return null;
}

function buildScoreByStar(e) {
var t = "";
e = parseInt(e), 0 > e ? e = 0 : e > 10 && (e = 10);
for (var a = 0; 10 > a; a++) {
var n;
a % 2 === 1 && (n = a > e ? "empty" : a === e ? "half" : "full", t += '<span class="score-star ' + n + '"></span>');
}
return t;
}

function buildPage(e) {
function t() {
var t = e.h5_extra, a = {
font_size: t.font_size || "m",
image_type: t.image_type || "thumb",
is_daymode: !!t.is_daymode,
use_lazyload: !!t.use_lazyload,
url_prefix: t.url_prefix || "content://com.ss.android.article.base.ImageProvider/",
group_id: t.str_group_id || t.group_id || ""
};
return a;
}
function a() {
var e = {
font_size: getMeta("font_size") || "m",
image_type: getMeta("load_image") || "thumb",
is_daymode: getMeta("night_mode") ? !1 : !0,
use_lazyload: "undefined" == typeof window.close_lazyload ? !0 : !1,
url_prefix: "undefined" == typeof window.url_prefix ? "content://com.ss.android.article.base.ImageProvider/" : window.url_prefix,
group_id: getMeta("group_id") || ""
};
return e;
}
function n() {
var e = {
font_size: hash("tt_font") || "m",
image_type: hash("tt_image") || "thumb",
is_daymode: "1" == hash("tt_daymode"),
use_lazyload: !!parseInt(getMeta("lazy_load")),
url_prefix: "",
group_id: ""
};
return e;
}
var i = {
v55: {
android: a,
ios: n
},
v60: {
ios: t,
android: t
}
}, r = {
article: {},
author: {},
tags: [],
h5_settings: {},
statistics: {},
pageSettings: {}
}, o = {
getArticleType: function() {
var t = "zhuanma";
if ("object" == typeof e.wenda_extra) t = "wenda"; else if ("object" == typeof e.forum_extra) t = "forum"; else if ("object" == typeof e.h5_extra) {
var a = e.h5_extra.media;
"object" == typeof a && null !== a && 0 != a.id && (t = "pgc");
}
return t;
},
wenda: function() {
var t = e.wenda_extra, a = t.user || {};
e.wenda_extra.title = _.escape(e.wenda_extra.title), r.article = {
title: t.title,
publishTime: t.show_time
}, r.author = {
userId: a.user_id,
name: a.user_name,
link: r.h5_settings.is_liteapp ? "javascript:;" : a.schema + "&group_id=" + t.ansid + "&from_page=detail_answer_wenda",
intro: a.user_intro,
avatar: a.user_profile_image_url,
isAuthorSelf: !1,
verifiedContent: a.is_verify ? "PLACE_HOLDER" : "",
medals: a.medals
};
var n = {
auth_type: "",
auth_info: ""
};
try {
n = JSON.parse(a.user_auth_info);
} catch (i) {}
r.author.auth_type = a.user_auth_info ? n.auth_type || 0 : "", r.author.auth_info = n.auth_info, 
"is_following" in t && (r.author.followState = t.is_following ? "following" : ""), 
r.wenda_extra = t, r.wenda_extra.aniok = client.isSeniorAndroid, r.statistics.group_id = t.ansid;
},
forum: function() {
var t = e.forum_extra, a = t.user_info || {};
t.forum_info || {}, r.article = {
title: t.thread_title || "",
publishTime: formatTime(1e3 * t.publish_timestamp)
}, r.author = {
userId: a.id,
name: a.name,
link: a.schema + "&group_id=" + t.thread_id + "&from_page=detail_topic" + (t.category_name ? "&category_name=" + t.category_name : ""),
avatar: a.avatar_url,
isAuthorSelf: !!t.is_author,
verifiedContent: a.verified_content,
medals: a.medals,
remarkName: a.remark_name
};
var n = {
auth_type: "",
auth_info: ""
};
try {
n = JSON.parse(a.user_auth_info);
} catch (i) {}
r.author.auth_type = a.user_auth_info ? n.auth_type || "0" : "", r.author.auth_info = n.auth_info, 
"is_following" in t && (r.author.followState = t.is_following ? "following" : "");
var o = [];
"object" == typeof a.media && a.media.name && o.push(a.media.name), a.verified_content && o.push(a.verified_content), 
r.author.intro = o.join("，"), r.tags = t.label_list, r.forum_extra = t, r.forumStatisticsParams = {
value: t.thread_id,
ext_value: t.forum_id,
extra: {
enter_from: t.enter_from,
concern_id: t.concern_id,
refer: t.refer,
group_type: t.group_type,
category_id: t.category_id
}
};
},
pgc: function() {
var t = e.h5_extra, a = t.media || {};
r.article = {
title: t.title,
publishTime: t.publish_stamp ? formatTime(1e3 * t.publish_stamp) : t.publish_time
}, r.author = {
userId: t.media_user_id,
mediaId: a.id,
name: a.name,
link: "sslocal://profile?refer=all&source=article_top_author&uid=" + t.media_user_id + "&group_id=" + r.statistics.group_id + "&from_page=detail_article" + (t.category_name ? "&category_name=" + t.category_name : ""),
intro: a.description,
avatar: a.avatar_url,
isAuthorSelf: !!t.is_author
}, (r.h5_settings.is_liteapp || !t.media_user_id) && (r.author.link = "bytedance://media_account?refer=all&media_id=" + a.id + "&loc=0&entry_id=" + a.id);
var n = {
auth_type: "",
auth_info: ""
};
try {
n = JSON.parse(a.user_auth_info);
} catch (i) {}
r.author.auth_type = a.user_auth_info ? n.auth_type || 0 : "", r.author.auth_info = n.auth_info, 
r.author.verifiedContent = a.user_verified && r.author.auth_info || "", "is_subscribed" in t && (r.author.followState = t.is_subscribed ? "following" : ""), 
t.is_original && r.tags.push("原创"), t.category_name && (r.category_name = t.category_name), 
t.log_pb && (r.log_pb = t.log_pb);
},
zhuanma: function() {
var t = e.h5_extra;
r.article = {
title: t.title,
publishTime: t.publish_time || "0000-00-00 00:00"
}, r.author.name = t.source;
},
common: function() {
var t = e.h5_extra;
if ("custom_style" in e && (r.customStyle = e.custom_style), "pay_status" in t && (r.pay_status = Page && Page.pay_status && -1 != Page.pay_status && -1 == t.pay_status.status ? Page.pay_status : t.pay_status.status, 
r.auto_pay_status = t.pay_status.auto_pay_status), "novel_data" in t) {
if ("object" == typeof t.novel_data) r.novel_data = t.novel_data; else if ("string" == typeof t.novel_data) try {
r.novel_data = JSON.parse(t.novel_data);
} catch (a) {}
r.novel_data.can_read = 0 == t.novel_data.book_free_status || 1 == r.pay_status || 3 == r.pay_status;
}
var n = t.ab_client || [];
r.topbuttonType = "pgc" !== r.article.type || n.indexOf("f7") > -1 ? "concern" : "digg";
try {
r.h5_settings = "object" == typeof t.h5_settings ? t.h5_settings : JSON.parse(t.h5_settings);
} catch (a) {
r.h5_settings = {};
}
r.h5_settings.pgc_over_head = !!r.h5_settings.pgc_over_head && "pgc" === r.article.type, 
r.h5_settings.is_liteapp = !!t.is_lite;
try {
r.isRedFocusButton = "red" === r.h5_settings.tt_follow_button_template.color_style;
} catch (a) {
r.isRedFocusButton = !1;
}
if (r.h5_settings.user_verify_info_conf) {
if ("string" == typeof r.h5_settings.user_verify_info_conf) try {
r.h5_settings.user_verify_info_conf = JSON.parse(r.h5_settings.user_verify_info_conf);
} catch (a) {
r.h5_settings.user_verify_info_conf = {};
}
r.h5_settings.user_verify_info_conf = trans_v_info(r.h5_settings.user_verify_info_conf), 
r.useServerV = !0;
} else r.useServerV = !1;
r.hasExtraSpace = !r.h5_settings.is_liteapp && client.isSeniorAndroid, r.hideFollowButton = !!t.hideFollowButton, 
r.statistics = {
group_id: t.str_group_id || t.group_id || "",
item_id: t.str_item_id || t.item_id || ""
};
}
};
"object" != typeof e && (e = window);
var s = o.getArticleType();
return r.article.type = s, o.common(), window.OldPage && (r.hasExtraSpace = OldPage.hasExtraSpace), 
o[s](), r.pageSettings = i[APP_VERSION][CLIENT_VERSION](), r.article.type = s, r;
}

function buildHeader(e) {
var t = renderHeader({
data: e
}), a = $("header");
a.length <= 0 ? $(document.body).prepend(t) : a.replaceWith(t);
}

function buildArticle(e) {
document.body.classList.add(Page.article.type), document.body.classList.add(CLIENT_VERSION), 
document.body.classList.add(APP_VERSION), "string" == typeof e && $("article").html(e), 
"wenda" === Page.article.type && processWendaArticle(), "forum" === Page.article.type && processForumArticle2();
}

function buildFooter(e) {
var t = renderFooter({
data: e
}), a = $("footer");
a.length > 0 ? a.replaceWith(t) : $(document.body).append(t), Page.novel_data && processNovelFooter(e.is_login);
}

function processWendaArticle() {
var e, t = Page.wenda_extra, a = t.show_post_answer_strategy || {}, n = t.wd_version || 0, i = Page.h5_settings.is_liteapp, r = "show_top" in a && !i, o = "show_default" in a && !i, s = [ "wt" ];
if (window.wendaStatisticsParams = {
value: t.qid,
ext_value: t.nice_ans_count,
extra: {
enter_from: t.enter_from,
ansid: t.ansid,
parent_enterfrom: t.parent_enterfrom || ""
}
}, window.assignThroughWendaNiceanscount = function(e) {
wendaStatisticsParams.ext_value = e;
}, 1 > n || n >= 3 && 1 == t.showMode) $("header").find(".tt-title").remove(); else {
t.wd_version >= 13 && s.push("no-icon"), e = $(r ? '<div class="' + s.join(" ") + '">' + t.title + '</div><div class="ft"><span class="see-all-answers" id="total-answer-count">个回答</span><span class="hide-placeholder">&nbsp;</span></div><a class="big-answer-buttoon go-to-answer" data-type="big" href="' + urlAddQueryParams(a.show_top.schema, {
source: "answer_detail_top_write_answer"
}) + '">' + a.show_top.text + '</a><div class="big-answer-buttoon-gap"></div>' : o ? '<div class="' + s.join(" ") + '">' + t.title + '</div><div class="ft"><a class="go-to-answer go-to-answer-small" data-type="small" href="' + urlAddQueryParams(a.show_default.schema, {
source: "answer_detail_write_answer"
}) + '">回答</a><span class="see-all-answers" id="total-answer-count">个回答</span></div>' : '<div class="' + s.join(" ") + '">' + t.title + '</div><div class="ft"><span class="see-all-answers" id="total-answer-count">个回答</span><span class="hide-placeholder">&nbsp;</span></div>');
var l = r ? "bigans" : o ? "smlans" : "noans";
$("header").find(".tt-title").removeClass("tt-title").addClass("wenda-title " + l + " title-type" + (t.answer_detail_type || 0)).html(e).on("click", function() {
return "wenda_title_handle" in t && t.wenda_title_handle ? void (ToutiaoJSBridge && ToutiaoJSBridge.call("clickWendaDetailHeader")) : void ("need_return" in t ? t.need_return ? ToutiaoJSBridge && ToutiaoJSBridge.call("close") : t.list_schema && (window.location.href = t.list_schema) : [ "click_answer", "click_answer_fold" ].indexOf(t.enter_from) > -1 ? ToutiaoJSBridge && ToutiaoJSBridge.call("close") : t.list_schema && (window.location.href = t.list_schema));
}), new PressState({
bindSelector: ".wenda-title,.big-answer-buttoon",
exceptSelector: ".go-to-answer-small,.see-all-answers",
pressedClass: "pressing",
removeLatency: 500
}), r ? (send_umeng_event("answer_detail", "top_write_answer_show", wendaStatisticsParams), 
$(".go-to-answer").on("click", function(e) {
e.stopPropagation(), send_umeng_event("answer_detail", "top_write_answer", wendaStatisticsParams);
})) : o && (window.wenda_extra && window.wenda_extra.answer_detail_type ? wendaCacheAdd(function() {
send_umeng_event("answer_detail", "wirte_answer_show", wendaStatisticsParams);
}) : send_umeng_event("answer_detail", "wirte_answer_show", wendaStatisticsParams), 
$(".go-to-answer").on("click", function(e) {
e.stopPropagation(), send_umeng_event("answer_detail", "wirte_answer", wendaStatisticsParams);
}));
}
$("#wenda_index_link").on("click", function() {
[ "click_answer", "click_answer_fold" ].indexOf(t.enter_from) > -1 ? ToutiaoJSBridge.call("close") : location.href = t.list_schema;
});
}

function processWendaFooter() {
var wenda_extra = Page.wenda_extra, ansStrategy = wenda_extra.show_post_answer_strategy || {}, wdVersion = wenda_extra.wd_version || 0, isLiteApp = Page.h5_settings.is_liteapp;
if (!(1 > wdVersion || wdVersion >= 3 && 1 == wenda_extra.showMode)) {
var isShowBottomUser = 0, wendaUserTmpl = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="wenda-bt-user" topbutton-type="' + (null == (__t = data.topbuttonType) ? "" : __t) + '"><div class="authorbar wenda">', 
__p += '<a class="author-avatar-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><div class="author-avatar"><img class="author-avatar-img" src="' + (null == (__t = data.author.avatar) ? "" : __t) + '"></div>', 
data.useServerV && data.author.auth_info && (__p += "" + (null == (__t = buildServerVIcon2(data.author.auth_type, "avatar_icon")) ? "" : __t)), 
__p += "</a>", __p += '<div class="author-function-buttons"><button class="subscribe-button-bottom follow-button ' + (null == (__t = "followState" in data.author ? data.author.followState : "disabled") ? "" : __t) + " " + (null == (__t = data.isRedFocusButton ? "red-follow-button" : "") ? "" : __t) + '"data-user-id="' + (null == (__t = data.author.userId) ? "" : __t) + '"data-media-id="' + (null == (__t = data.author.mediaId) ? "" : __t) + '"style="display: ' + (null == (__t = data.author.isAuthorSelf || "wenda" === data.article.type && data.h5_settings.is_liteapp || "forum" === data.article.type && "following" === data.author.followState || data.hideFollowButton ? "none" : "block") ? "" : __t) + ';"id="subscribe"><i class="iconfont focusicon">&nbsp;</i><i class="redpack"></i></button></div>', 
__p += '<div class="author-bar ' + (null == (__t = "" !== data.author.intro ? " auth-intro" : "") ? "" : __t) + '"><div class="name-link-wrap"><div class="name-link-w"><a class="author-name-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '">' + (null == (__t = data.author.name) ? "" : __t) + "</a></div></div>", 
"" !== data.author.intro && (__p += '<a class="sub-title-w" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><span class="sub-title">' + (null == (__t = data.author.intro) ? "" : __t) + "</span></a>"), 
__p += '<a class="sub-title-w" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><span class="sub-title" id="wenda-user-intro"></span></a></div></div></div>';
return __p;
};
if (!Page.author.isAuthorSelf && "following" !== Page.author.followState && "is_show_bottom_user" in wenda_extra && wenda_extra.is_show_bottom_user && $("article").height() > 1.5 * window.innerHeight && !isLiteApp) {
isShowBottomUser = 1;
var wendaUser = wendaUserTmpl({
data: Page
});
$("footer").append(wendaUser).css({
overflow: "initial"
});
}
if (!isShowBottomUser && "show_bottom" in ansStrategy && $("article").height() > 2 * window.innerHeight && !isLiteApp) {
var $btc = $('<a href="' + urlAddQueryParams(ansStrategy.show_bottom.schema, {
source: "answer_detail_bottom_write_answer"
}) + '" class="bottom-big-answer-button"><div class="pr"><div class="wdq"><span>' + wenda_extra.title + '</span></div><div class="bottom-answer-btn"><div class="btn-text"><i>&#xe645;</i>' + ansStrategy.show_bottom.text + '</div></div><i class="left-quote" >&#xe619;</i><i class="right-quote" >&#xe618;</i></div></a>');
$("footer").append($btc).css({
overflow: "initial"
}), $btc.on("click", function() {
send_umeng_event("answer_detail", "bottom_write_answer", wendaStatisticsParams);
}), send_exposure_event_once($btc.get(0), function() {
send_umeng_event("answer_detail", "bottom_write_answer_show", wendaStatisticsParams);
}, !0);
}
}
}

function buildUIStyle(settings) {
if ("forum" !== Page.article.type && settings.font_size_ui_test) {
if (1 !== settings.font_size_ui_test && 2 !== settings.font_size_ui_test && 3 !== settings.font_size_ui_test) return;
var CustomStyleTemplateFunction = function(obj) {
var __p = "";
with (Array.prototype.join, obj || {}) __p += "", "1" == plane ? (__p += ".font_s article p, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6, .font_s article ul, .font_s article ol, .font_s article hr, .font_s article .image-wrap {margin-top: 18px;margin-bottom: 18px;}article p, article h1, article h2, article h3, article h4, article h5, article h6, article blockquote, article ul, article ol, article hr, .font_m article p, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6, .font_m article ul, .font_m article ol, .font_m article hr, .font_m article .image-wrap {margin-top: 20px;margin-bottom: 20px;}.font_l article p, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6, .font_l article ul, .font_l article ol, .font_l article hr, .font_s article .image-wrap {margin-top: 22px;margin-bottom: 22px;}.font_xl article p, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6, .font_xl article ul, .font_xl article ol, .font_xl article hr, .font_s article .image-wrap {margin-top: 25px;margin-bottom: 25px;}", 
client.isIOS && (__p += "@media(max-device-width: 374px){.font_s article p, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6, .font_s article ul, .font_s article ol, .font_s article hr, .font_s article .image-wrap {margin-top: 16px;margin-bottom: 16px;}article p, article h1, article h2, article h3, article h4, article h5, article h6, article blockquote, article ul, article ol, article hr, .font_m article p, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6, .font_m article ul, .font_m article ol, .font_m article hr, .font_m article .image-wrap {margin-top: 18px;margin-bottom: 18px;}.font_l article p, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6, .font_l article ul, .font_l article ol, .font_l article hr, .font_s article .image-wrap {margin-top: 20px;margin-bottom: 20px;}.font_xl article p, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6, .font_xl article ul, .font_xl article ol, .font_xl article hr, .font_s article .image-wrap {margin-top: 23px;margin-bottom: 23px;}}"), 
__p += "") : "2" == plane ? (__p += "", __p += client.isIOS ? ".font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 28px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 30px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 32px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 35px;}@media(max-device-width: 374px){.font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 23px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 25px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 27px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 30px;}}" : ".font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 26px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 28px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 30px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 33px;}", 
__p += "") : "3" == plane && (__p += "", __p += client.isIOS ? ".font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 28px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 30px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 32px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 35px;}.font_s article p, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6, .font_s article ul, .font_s article ol, .font_s article hr, .font_s article .image-wrap {margin-top: 18px;margin-bottom: 18px;}article p, article h1, article h2, article h3, article h4, article h5, article h6, article blockquote, article ul, article ol, article hr, .font_m article p, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6, .font_m article ul, .font_m article ol, .font_m article hr, .font_m article .image-wrap {margin-top: 20px;margin-bottom: 20px;}.font_l article p, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6, .font_l article ul, .font_l article ol, .font_l article hr, .font_s article .image-wrap {margin-top: 22px;margin-bottom: 22px;}.font_xl article p, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6, .font_xl article ul, .font_xl article ol, .font_xl article hr, .font_s article .image-wrap {margin-top: 25px;margin-bottom: 25px;}@media(max-device-width: 374px){.font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 23px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 25px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 27px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 30px;}.font_s article p, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6, .font_s article ul, .font_s article ol, .font_s article hr, .font_s article .image-wrap {margin-top: 16px;margin-bottom: 16px;}article p, article h1, article h2, article h3, article h4, article h5, article h6, article blockquote, article ul, article ol, article hr, .font_m article p, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6, .font_m article ul, .font_m article ol, .font_m article hr, .font_m article .image-wrap {margin-top: 18px;margin-bottom: 18px;}.font_l article p, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6, .font_l article ul, .font_l article ol, .font_l article hr, .font_s article .image-wrap {margin-top: 20px;margin-bottom: 20px;}.font_xl article p, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6, .font_xl article ul, .font_xl article ol, .font_xl article hr, .font_s article .image-wrap {margin-top: 23px;margin-bottom: 23px;}}" : ".font_s article, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6 {line-height: 26px;}article, article h1, article h2, article h3, article h4, article h5, article h6, .font_m article, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6 {line-height: 28px;}.font_l article, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6 {line-height: 30px;}.font_xl article, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6 {line-height: 33px;}.font_s article p, .font_s article h1, .font_s article h2, .font_s article h3, .font_s article h4, .font_s article h5, .font_s article h6, .font_s article ul, .font_s article ol, .font_s article hr, .font_s article .image-wrap {margin-top: 18px;margin-bottom: 18px;}article p, article h1, article h2, article h3, article h4, article h5, article h6, article blockquote, article ul, article ol, article hr, .font_m article p, .font_m article h1, .font_m article h2, .font_m article h3, .font_m article h4, .font_m article h5, .font_m article h6, .font_m article ul, .font_m article ol, .font_m article hr, .font_m article .image-wrap {margin-top: 20px;margin-bottom: 20px;}.font_l article p, .font_l article h1, .font_l article h2, .font_l article h3, .font_l article h4, .font_l article h5, .font_l article h6, .font_l article ul, .font_l article ol, .font_l article hr, .font_s article .image-wrap {margin-top: 22px;margin-bottom: 22px;}.font_xl article p, .font_xl article h1, .font_xl article h2, .font_xl article h3, .font_xl article h4, .font_xl article h5, .font_xl article h6, .font_xl article ul, .font_xl article ol, .font_xl article hr, .font_s article .image-wrap {margin-top: 25px;margin-bottom: 25px;}", 
__p += ""), __p += "";
return __p;
}, CustomStyleTemplateString = CustomStyleTemplateFunction({
plane: settings.font_size_ui_test,
client: client
}), originStyle = document.querySelector("head").querySelectorAll("style[source=abtest]");
if (0 === originStyle.length) {
var style = document.createElement("style");
style.setAttribute("source", "abtest"), style.setAttribute("plane", "plane" + settings.font_size_ui_test), 
style.innerHTML = CustomStyleTemplateString, document.querySelector("head").appendChild(style), 
style = null;
} else for (var i = 0; i < originStyle.length; i++) {
var item = originStyle[i];
if (item.getAttribute("plane") === "plane" + settings.font_size_ui_test) return;
item.setAttribute("plane", "plane" + settings.font_size_ui_test), item.innerHTML = CustomStyleTemplateString;
}
} else $("style[source=abtest]").remove();
}

function processNovelFooter(e) {
var t = "https://ic.snssdk.com/novel/book/pay/v1/single_payment/page/?book_id=" + Page.novel_data.book_id + "&item_id=" + Page.statistics.item_id + "&group_id=" + Page.statistics.group_id;
document.querySelector(".update") && (document.querySelector(".update").addEventListener("click", function() {
client.isAndroid ? location.href = "http://app.toutiao.com/news_article/" : client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6") && getCommonParams(function(e) {
switch (e.app_name) {
case "news_article_social":
t = "itms-apps://itunes.apple.com/cn/app/id582528844";
break;

case "explore_article":
t = "itms-apps://itunes.apple.com/cn/app/id672151725";
break;

default:
t = "itms-apps://itunes.apple.com/cn/app/id529092160";
}
ToutiaoJSBridge.call("openApp", {
url: t
}, null);
}), sendUmengEventV3("click_version_update", {
group_id: Page.statistics.group_id,
item_id: Page.statistics.item_id,
enter_from: "detail",
category_name: "novel_channel",
novel_id: Page.novel_data.book_id,
concern_id: Page.novel_data.concern_id,
log_pb: ""
}, !1);
}, !1), sendUmengEventV3("go_version_update", {
group_id: Page.statistics.group_id,
item_id: Page.statistics.item_id,
enter_from: "version_update",
category_name: "novel_channel",
novel_id: Page.novel_data.book_id,
concern_id: Page.novel_data.concern_id,
type: 0,
log_pb: ""
}, !1)), document.querySelector(".buy") && (document.querySelector(".buy").addEventListener("click", function() {
e ? location.href = "sslocal://popup_browser?url=" + encodeURIComponent(t) + "&pull_close=1" : ToutiaoJSBridge.call("login", {
platform: ""
}), sendUmengEventV3("click_purchase_read", {
group_id: Page.statistics.group_id,
item_id: Page.statistics.item_id,
enter_from: "purchase_reminder",
category_name: "novel_channel",
novel_id: Page.novel_data.book_id,
log_pb: ""
}, !1);
}, !1), sendUmengEventV3("go_purchase_reminder", {
group_id: Page.statistics.group_id,
item_id: Page.statistics.item_id,
enter_from: "detail",
category_name: "novel_channel",
novel_id: Page.novel_data.book_id,
type: 0,
log_pb: ""
}, !1)), 1 == Page.pay_status && 1 == Page.auto_pay_status && 1 == Page.novel_data.book_free_status && $.ajax({
url: "https://ic.snssdk.com/novel/trade/purchase/v1/auto_pay/",
dataType: "jsonp",
data: {
book_id: Page.novel_data.book_id,
item_id: Page.statistics.item_id,
device_platform: client.isIOS ? 1 : 2
},
error: function() {},
success: function(e) {
console.info("fhru", e);
}
}), 255 == Page.pay_status && 1 == Page.novel_data.book_free_status && ToutiaoJSBridge.call("toast", {
text: "系统异常 请稍后再试",
icon_type: "icon_error"
});
}

function update_forum_tags(e) {
"string" == typeof e && (e = e.split(","));
var t = $('<div class="article-tags">');
e.forEach(function(e) {
"" !== e && t.append($('<div class="article-tag">').html(e));
}), e.length >= 1 ? $(".name-link-w").removeClass("no-intro") : "" === $(".sub-title").text() && $(".name-link-w").addClass("no-intro"), 
$(".article-tags").replaceWith(t);
}

function on_page_disappear() {
"object" == typeof window.mediasugScroll && null !== window.mediasugScroll && "function" == typeof window.mediasugScroll.pushimpr && window.mediasugScroll.pushimpr(!1);
}

function set_info(e) {
if ("string" == typeof e) e = JSON.parse(e); else if ("object" != typeof e) return;
$.extend(window.globalWendaStates, e), "is_concern_user" in e && change_following_state(!!e.is_concern_user), 
"brow_count" in e && ($(".brow-count").text(e.brow_count), formatCount(".brow-count", e.brow_count, "0")), 
"is_digg" in e && "digg_count" in e && (e.is_digg && $("#digg").attr({
"wenda-state": "digged",
aniok: "false"
}), formatCount(".digg-count", e.digg_count, "赞"), formatCount(".digg-count-special", e.digg_count, "0")), 
"is_buryed" in e && "bury_count" in e && (e.is_buryed && $("#bury").attr({
"wenda-state": "buryed",
aniok: "false"
}), formatCount(".bury-count", e.bury_count, "踩")), "is_show_bury" in e && e.is_show_bury && $("#bury").show().parent().removeClass("only-one").addClass("only-two");
}

function getElementPosition(e) {
var t = /^.image:nth-child\((\d+)\)$/, a = e.match(t);
a && (e = ".image-container:nth-child(" + a[1] + ")>.image");
var n = "{{0,0},{0,0}}", i = document.querySelector(e);
if (i) {
var r = i.getBoundingClientRect();
n = "{{" + (r.left + window.pageXOffset) + "," + (r.top + window.pageYOffset) + "},{" + r.width + "," + r.height + "}}";
}
return n;
}

function setFontSize(e) {
var t = e.split("_")[0], a = (e.split("_")[1], [ "s", "m", "l", "xl" ]), n = $.map(a, function(e) {
return "font_" + e;
}).join(" ");
a.indexOf(t) > -1 && $("body").removeClass(n).addClass("font_" + t);
}

function setDayMode(e) {
var t = [ 0, 1, "0", "1" ];
t.indexOf(e) > -1 && (e = parseInt(e), $(document.body)[e ? "removeClass" : "addClass"]("night"));
}

function appCloseVideoNoticeWeb(e) {
var t = $('[data-vid="' + e + '"]');
t.each(function() {
$(this).css("display", "block"), $(this).next(".cv-wd-info-wrapper").show();
}), $("body").css("margin-top", "0px");
}

function getVideoFrame(e) {
var t = document.querySelector('[data-vid="' + e + '"]'), a = "{{0,0},{0,0}}";
if (t) {
var n = t.getBoundingClientRect();
a = "{{" + n.left + "," + t.offsetTop + "},{" + n.width + "," + n.height + "}}";
}
return a;
}

function processMenuItemPressEvent() {
ToutiaoJSBridge.call("typos", {
strings: getThreeStrings()
});
}

function getThreeStrings() {
var e = "", t = "", a = "", n = document.getSelection();
if ("Range" !== n.type) return [ e, t, a ];
var i = n.getRangeAt(0);
if (!i) return [ e, t, a ];
try {
e = i.startContainer.textContent.substring(0, i.startOffset).substr(-20), t = i.toString(), 
a = i.endContainer.textContent.substring(i.endOffset).substring(0, 20);
} catch (r) {}
return i.detach(), i = null, [ e, t, a ];
}

function subscribe_switch(e) {
"pgc" == Page.article.type && change_following_state(!!e);
}

function dealNovelButton(e, t, a, n) {
e.preventDefault(), send_umeng_event("detail", t.is_concerned ? "click_fictioncard_discare" : "click_fictioncard_care", n), 
$.ajax({
url: "http://ic.snssdk.com/concern/v1/commit/" + (t.is_concerned ? "discare/" : "care/"),
dataType: "jsonp",
data: {
concern_id: t.concern_id
},
beforeSend: function() {
return t.isclicking ? !1 : void (t.isclicking = !0);
},
complete: function() {
t.isclicking = !1;
},
error: function() {
ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
icon_type: "icon_error"
});
},
success: function(e) {
return 0 != e.err_no ? (ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
con_type: "icon_error"
}), !1) : (t.is_concerned = !t.is_concerned, a.attr("is-concerned", Boolean(t.is_concerned)).html(t.is_concerned ? "已加入" : "加入书架"), 
ToutiaoJSBridge.call("page_state_change", {
type: "concern_action",
id: t.concern_id,
status: t.is_concerned ? 1 : 0
}), ToutiaoJSBridge.call("page_state_change", {
type: "forum_action",
id: t.forum_id,
status: t.is_concerned ? 1 : 0
}), send_umeng_event(t.is_concerned ? "concern_novel" : "unconcern_novel", "detail", {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id,
novel_id: t.id
}
}), void sendUmengEventV3(t.is_concerned ? "concern_novel_detail" : "unconcern_novel_detail", {
item_id: +Page.statistics.item_id,
group_id: +Page.statistics.group_id,
novel_id: t.id
}, !0));
}
});
}

function dealOptionalStockButton(e, t, a, n, i) {
e.stopPropagation(), send_umeng_event("stock", "article_add_stock", i);
var r, o = 0, s = t.attr("data-stock"), l = 0;
n.forEach(function(e, t) {
e.code == s && (l = t, r = e.market), 0 == e.selected && o++;
}), 1 != n[l].selected && $.ajax({
url: "http://ic.snssdk.com/stock/like/",
dataType: "jsonp",
data: {
code: s,
market: r
},
beforeSend: function() {
return n[l].isclicking || 1 == n[l].selected ? !1 : void (n[l].isclicking = !0);
},
complete: function() {
n[l].isclicking = !1;
},
error: function() {
ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
icon_type: "icon_error"
});
},
success: function(e) {
return 1 != e.code ? (ToutiaoJSBridge.call("toast", {
text: 0 == e.code && e.data.msg ? e.data.msg : "操作失败，请重试",
con_type: "icon_error"
}), !1) : (a.stocks.click_mount++, "single" === t.attr("type") ? t.attr("selected", "") : (t.removeClass("pcard-w1").addClass("pcard-w3").html('<i class="pcard-icon opstock-iconfont icon-done"></i>已添加'), 
o > 3 && (t.css("height", 0), $parent = t.parent(), $parent.on("webkitAnimationEnd", function() {
$parent.remove();
}), $parent.on("animationend", function() {
$parent.remove();
}), $parent.addClass("ant-notification-fade-leave"))), void (n[l].selected = !0));
}
});
}

function wendaCooperateCard() {
var cooperateCardTmpl = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="wenda-cooperate"><div class="authorbar wenda clearfix"><a class="author-avatar-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><div class="author-avatar"><img class="author-avatar-img" src="' + (null == (__t = data.author.avatar) ? "" : __t) + '"></div>', 
data.useServerV && data.author.auth_info && (__p += "" + (null == (__t = buildServerVIcon2(data.author.auth_type, "avatar_icon")) ? "" : __t)), 
__p += '</a><div class="author-bar"><div class="name-link-wrap"><div class="name-link-w"><a class="author-name-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '">' + (null == (__t = data.author.name) ? "" : __t) + '<span class="cooper-tag">问答战略合作伙伴</span></a></div></div><a class="sub-title-w" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><span class="sub-title">' + (null == (__t = data.author.cooperate_text) ? "" : __t) + '</span></a></div></div><a class="cooperate-link" href="' + (null == (__t = data.author.cooperate_link) ? "" : __t) + '"><span class="txt">查看官方网站<em class="iconfont">&#xe644;</em></span></a></div>';
return __p;
};
$.extend(Page.author, {
cooperate_text: wenda_extra.mis_coop_user.profile,
cooperate_link: -1 !== wenda_extra.mis_coop_user.link.indexOf("http") ? "sslocal://webview?url=" + encodeURIComponent(wenda_extra.mis_coop_user.link) + "&title=%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88" : wenda_extra.mis_coop_user.link
});
var cooperateStr = cooperateCardTmpl({
data: Page
});
$("footer").append(cooperateStr).css({
overflow: "initial"
});
}

function wendaContextRender(context) {
!function() {
if ("wenda_context" in context) {
var e = context.wenda_context;
if (window.wendaContext = e, "is_author" in e && (e.is_author ? ($(".follow-button").hide(), 
$(".author-function-buttons").hide(), $(".wenda-info").show()) : "wenda" === Page.article.type && Page.h5_settings.is_liteapp ? ($(".follow-button").hide(), 
$(".author-function-buttons").hide(), $(".wenda-info").hide()) : ($(".author-function-buttons").show(), 
$(".follow-button").show(), $(".wenda-info").hide())), "is_author" in e && e.is_author ? (Page.author.isAuthorSelf = !!e.is_author, 
$(".wd-footer .editor-edit-answer").attr("href", e.edit_answer_schema).show(), $(".wd-footer .dislike-and-report").hide()) : ($(".wd-footer .editor-edit-answer").hide(), 
"detail_related_report_style" in wenda_extra && 0 !== wenda_extra.detail_related_report_style && wenda_extra.wd_version >= 13 ? $(".wd-footer .dislike-and-report").hide() : $(".wd-footer .dislike-and-report").show()), 
"is_author" in e && e.is_author || ("detail_related_report_style" in wenda_extra && (2 === wenda_extra.detail_related_report_style || 3 === wenda_extra.detail_related_report_style) && wenda_extra.wd_version >= 13 ? ($(".report").hide(), 
$(".sep.for-report").hide()) : ($(".report").show(), "detail_related_report_style" in wenda_extra && 1 === wenda_extra.detail_related_report_style && wenda_extra.wd_version >= 13 ? $(".report").addClass("dislike-and-report").text("不喜欢").removeClass("report") : $(".sep.for-report").show())), 
"brow_count" in e && ($(".brow-count").text(e.brow_count), formatCount(".brow-count", e.brow_count, "0")), 
"all_brow_count" in e || "fans_count" in e) {
var t = [];
"all_brow_count" in e && t.push(formatCount(!1, e.all_brow_count, "0") + "阅读"), 
"fans_count" in e && t.push(formatCount(!1, e.fans_count, "0") + "粉丝"), t.length > 0 && setTimeout(function() {
$("#wenda-user-intro").html(t.join(" · "));
}, 50);
}
if ("linkurl" in e && e.linkurl && $("#wd-link-more").attr("href", "sslocal://webview?url=" + encodeURIComponent(e.linkurl) + "&title=%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88").show(), 
"is_digg" in e && "digg_count" in e && (e.is_digg && $("#digg").attr({
"wenda-state": "digged",
aniok: "false"
}), formatCount(".digg-count", e.digg_count, "赞"), formatCount(".digg-count-special", e.digg_count, "0")), 
"is_buryed" in e && "bury_count" in e && (e.is_buryed && $("#bury").attr({
"wenda-state": "buryed",
aniok: "false"
}), formatCount(".bury-count", e.bury_count, "踩"), e.is_buryed && $(".dislike-and-report").css("color", "#999999").text("已反对"), 
wenda_extra.wd_version >= 6)) {
var a = e.is_buryed;
$('[item="dislike-and-report"]').on("click", function() {
var e = this;
ToutiaoJSBridge.call("dislike", {
options: 17
}, function(t) {
0 == t.err_no && (a ? wenda_extra.wd_version >= 8 && ($(e).removeClass("is-buryed"), 
e.innerHTML = "反对", a = !a) : ($(e).addClass("is-buryed"), e.innerHTML = "已反对", 
a = !a));
});
});
}
if ("is_show_bury" in e && e.is_show_bury && $("#bury").show().parent().removeClass("only-one").addClass("only-two"), 
"is_concern_user" in e && change_following_state(!!e.is_concern_user), "ans_count" in e && ($("#total-answer-count").html(e.ans_count + "个回答").css("display", "inline-block"), 
$("#total-answer-count-index").html("全部" + e.ans_count + "个回答")), "nice_ans_count" in e && "wenda_extra" in window && ("function" == typeof window.assignThroughWendaNiceanscount ? window.assignThroughWendaNiceanscount(e.nice_ans_count) : window.wenda_extra.nice_ans_count = e.nice_ans_count), 
"question_schema" in e && e.question_schema && (window.wenda_extra.list_schema = e.question_schema), 
"post_answer_schema" in e && e.post_answer_schema && $(".go-to-answer").attr("href", urlAddQueryParams(e.post_answer_schema, {
source: "big" === $(".go-to-answer").attr("data-type") ? "answer_detail_top_write_answer" : "answer_detail_write_answer"
})), "is_following" in e && Page && Page.author && (Page.author.followState = e.is_following ? "following" : ""), 
"gd_ext_json" in e) {
var n = e.gd_ext_json || {};
if ("string" == typeof e.gd_ext_json) try {
n = JSON.parse(e.gd_ext_json);
} catch (i) {
n = {};
}
window.wenda_extra.gd_ext_json = n, "category_name" in n && "wenda" === Page.article.type && (Page.author.link = Page.author.link + "&category_name=" + n.category_name, 
$(".author-avatar-link").attr("href", Page.author.link), $(".author-name-link").attr("href", Page.author.link), 
$(".sub-title-w").attr("href", Page.author.link));
}
if ((!("show_next" in e) || e.show_next) && ($(".serial").show(), "has_next" in e)) {
var r = $("#next_answer_link");
e.has_next ? (r.attr("href", e.next_answer_schema), r.attr("onclick", null)) : (r.attr("onclick", null), 
r.addClass("disabled").on("click", function() {
ToutiaoJSBridge.call("toast", {
text: "这是最后一个回答",
icon_type: ""
});
}), needCleanDoms.push(r));
}
}
}(), function() {
if ("wenda_recommend" in context && Page.wenda_extra) {
var templateFunction = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<a class="jrwdpd" href="' + (null == (__t = data.open_url) ? "" : __t) + '"><div class="jrwdpd-slogan">' + (null == (__t = data.text) ? "" : __t) + '</div><button class="jrwdpd-button">' + (null == (__t = data.button_text) ? "" : __t) + '</button><div class="jrwdpd-logo"></div><div class="jrwdpd-logo-wrap"></div></a>';
return __p;
}, $template = $(templateFunction({
data: context.wenda_recommend
}));
$("footer").append($template), $template.on("click", function() {
send_umeng_event("wenda_channel_detail", "enter", {
extra: {
qid: Page.wenda_extra.qid,
ansid: Page.wenda_extra.ansid,
enter_from: Page.wenda_extra.enter_from,
parent_enterfrom: Page.wenda_extra.parent_enterfrom || ""
}
});
}), needCleanDoms.push($template);
}
}(), function() {
var e = document.querySelector("#profile"), t = document.querySelector(".wenda-title"), a = 0, n = 0;
t && (a = t.getBoundingClientRect().height), e && (n = e.getBoundingClientRect().height + 20 + a), 
ToutiaoJSBridge.call("onGetHeaderAndProfilePosition", {
header_position: a,
profile_position: n
});
}(), wendaCacheRemove();
}

function processScoreCardByStar(networkCommonParams) {
var scoredArticle, scoreCardTemplateFunction = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="pcard score-star" style="margin-top: 15px;"><div class="p-scorecard pcard-container pcard-vertical-border"><div class="pcard-clearfix score-wrapper"><div class="info-wrapper"><div class="title question pcard-h16 pcard-w1" style="margin-top: 3px;">' + (null == (__t = question) ? "" : __t) + '</div><div class="title thx-letter pcard-h16 pcard-w1" style="margin-top: 2px;">谢谢你为文章打分！</div></div><div class="star-wrap mt11"><span class="star" data-index="0" data-selected="false"></span><span class="star" data-index="1" data-selected="false"></span><span class="star" data-index="2" data-selected="false"></span><span class="star" data-index="3" data-selected="false"></span><span class="star" data-index="4" data-selected="false"></span></div><div class="info pcard-h12 pcard-w1 mt11" style="margin-bottom: 3px;">轻触打分</div></div><div class="pcard-clearfix result-wrapper"><div class="thx-press" style="margin-top: 2px;"><span class="press"></span></div><div class="pcard-h16 pcard-w1 mt8">感谢你的打分，你的打分对我们很重要！</div><a class="rescore-button pcard-h12 pcard-w1">重新打分</a></div></div></div>';
return __p;
};
try {
scoredArticle = localStorage.getItem("article_detail_score");
} catch (e) {}
var group_id = Page.statistics.group_id, score_card_info_string = parseInt(Page.h5_settings.score_card_info_string);
score_card_info_string = score_card_info_string > -1 && 5 > score_card_info_string ? score_card_info_string : 0;
var startTime, lastTimeOutThx, lastTimeOutDone, starQuestions = [ "为文章打分", "这篇文章是否有价值？", "你后悔看过本文吗？", "本文是否浪费了你的时间？", "与其他文章相比，你觉得本文如何？" ], starInfo = [ "轻触打分", "浪费时间", "后悔点进来", "没什么感觉", "比较受益", "非常受益" ], $template = $(scoreCardTemplateFunction({
question: starQuestions[score_card_info_string]
})), $stars = $template.find(".star"), score = 0, has_scored = !1;
$template.on("touchstart", ".star", function(e) {
var t = parseInt(e.target.getAttribute("data-index"));
e.target.getAttribute("data-selected"), $stars.forEach(function(e, a) {
t >= a ? e.setAttribute("data-selected", "true") : e.setAttribute("data-selected", "false");
}), score = t + 1, document.querySelector(".info").innerHTML = starInfo[score], 
lastTimeOutThx && clearTimeout(lastTimeOutThx), lastTimeOutDone && clearTimeout(lastTimeOutDone), 
lastTimeOutThx = setTimeout(function() {
$(".info-wrapper").addClass("move");
}, 500), $(".info-wrapper").addClass("move"), lastTimeOutDone = setTimeout(function() {
var e = {
evaluate_id: JSON.stringify({
gid: group_id,
style: "star",
string_id: score_card_info_string,
interval: Date.now() - startTime
}),
survey_type: "point",
prefer_id: score
};
if ($.extend(!0, e, networkCommonParams), $.ajax({
url: "https://eva.snssdk.com/eva/survey.json",
dataType: "jsonp",
data: e,
error: function() {},
success: function() {}
}), !has_scored) {
scoredArticle = scoredArticle ? scoredArticle + "," + group_id : group_id;
try {
localStorage.setItem("article_detail_score", scoredArticle);
} catch (t) {}
has_scored = !0;
}
$(".p-scorecard").addClass("moveUp"), send_umeng_event("score_card", "click", {
value: group_id,
extra: {
score: score,
interval: Date.now() - startTime
}
});
}, 1500);
}), $template.on("click", ".rescore-button", function() {
$(".info-wrapper").removeClass("move"), $(".p-scorecard").removeClass("moveUp"), 
$stars.forEach(function(e) {
e.setAttribute("data-selected", "false");
}), score = 0, document.querySelector(".info").innerHTML = starInfo[score];
}), $("footer").append($template), send_exposure_event_once($template.get(0), function() {
startTime = Date.now(), send_umeng_event("score_card", "show", {
value: group_id,
extra: {
style: "star"
}
});
}, !0);
}

function processScoreCardByEmoji(networkCommonParams) {
var scoredArticle, scoreCardTemplateFunction = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="pcard score-emoji" style="margin-top: 15px"><div class="p-scorecard pcard-container pcard-vertical-top-border"><div class="pcard-clearfix score-wrapper"><div class="title question pcard-h16 pcard-w1" style="margin-top: 3px;">与其他文章相比，你觉得本文如何？</div><div class="emoji-wrap mt10"><div class="good emoji-button" data-index="0" data-score="5" data-type="good" data-status="init"><span class="pcard-icon good-press button"></span><div class="animation-wrapper" id="good-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[0]) ? "" : __t) + '</div></div><div class="general emoji-button" data-index="1" data-score="3" data-type="general" data-status="init"><span class="pcard-icon general-press button"></span><div class="animation-wrapper" id="general-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[1]) ? "" : __t) + '</div></div><div class="bad emoji-button" data-index="2" data-score="1" data-type="bad" data-status="init"><span class="pcard-icon bad-press button"></span><div class="animation-wrapper" id="bad-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[2]) ? "" : __t) + "</div></div></div></div></div></div>";
return __p;
};
try {
scoredArticle = localStorage.getItem("article_detail_score");
} catch (e) {}
var group_id = Page.statistics.group_id, last_score = -1, score_card_info_string = parseInt(Page.h5_settings.score_card_info_string) || 0;
score_card_info_string = score_card_info_string > -1 && 3 > score_card_info_string ? score_card_info_string : 0;
var startTime, letters = [ [ "非常受益", "一般般", "浪费时间" ], [ "很有帮助", "一般般", "没有帮助" ], [ "很棒的文章", "一般般", "很差的文章" ] ], has_scored = !1, $template = $(scoreCardTemplateFunction({
letters: letters[score_card_info_string]
})), $emojiButtons = $template.find(".emoji-button"), emojiAnimationArray = [ null, null, null ];
$template.on("click", ".emoji-button", function(e) {
var t = $(e.target).closest(".emoji-button"), a = parseInt(t.attr("data-score"));
if (a !== last_score) {
var n = t.attr("data-type"), i = parseInt(t.attr("data-index")), r = {
evaluate_id: JSON.stringify({
gid: group_id,
style: "face",
string_id: score_card_info_string,
interval: Date.now() - startTime
}),
survey_type: "point",
prefer_id: a
};
if ($.extend(!0, r, networkCommonParams), $.ajax({
url: "https://eva.snssdk.com/eva/survey.json",
dataType: "jsonp",
data: r,
error: function() {},
success: function() {}
}), !has_scored) {
scoredArticle = scoredArticle ? scoredArticle + "," + group_id : group_id;
try {
localStorage.setItem("article_detail_score", scoredArticle);
} catch (o) {}
has_scored = !0;
}
last_score = a, $emojiButtons.forEach(function(e, t) {
i === t ? e.setAttribute("data-status", "selected") : e.setAttribute("data-status", "unselected");
}), emojiAnimationArray[i] && emojiAnimationArray[i].destroy();
var s = bodymovin.loadAnimation({
container: document.querySelector("#" + n + "-press-animation"),
path: baseFilePath() + "images/score-" + n + "/data.json",
renderer: "svg",
loop: !1,
autoplay: !0
});
emojiAnimationArray[i] = s, send_umeng_event("score_card", "click", {
value: group_id,
extra: {
score: a,
interval: Date.now() - startTime
}
});
}
}), $("footer").append($template), send_exposure_event_once($template.get(0), function() {
startTime = Date.now(), send_umeng_event("score_card", "show", {
value: group_id,
extra: {
style: "face"
}
});
}, !0);
}

function processScoreCard() {
if (client.isSeniorAndroid) {
var e;
try {
e = localStorage.getItem("article_detail_score");
} catch (t) {}
var a = Page.statistics.group_id;
if (e) {
var n = e.split(",");
if (n.indexOf(a) > -1) return;
}
var i = {};
client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6") ? ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(e) {
i = e.data || e, 1 === Page.h5_settings.score_card_style ? processScoreCardByStar(i) : 2 === Page.h5_settings.score_card_style && processScoreCardByEmoji(i);
}) : 1 === Page.h5_settings.score_card_style ? processScoreCardByStar(i) : 2 === Page.h5_settings.score_card_style && processScoreCardByEmoji(i);
}
}

function followActionHandler() {
var e = $(this), t = e.data("userId"), a = e.data("mediaId"), n = e.hasClass("following"), i = e.attr("data-concerntype") || "", r = Page.article.type, o = "" === i, s = Page.hasExtraSpace && o;
if (!e.hasClass("disabled")) if ($(".subscribe-button").addClass("disabled"), $("header").addClass("canmoving"), 
$(".boot-outer-container").css("display", "none"), "pgc" === r) doFollowMedia(t, a, n, i), 
s && !Page.author.hasRedPack && (n ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError)); else if ("wenda" === r) {
doFollowUser(t, a, n, void 0, followSource.wenda, "answer_detail_top_card");
var l = $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_top_card",
position: "detail",
to_user_id: t,
follow_type: "from_group",
group_id: wenda_extra.ansid,
server_source: 28
});
Page.author.hasRedPack && (l.is_redpacket = 1), sendUmengEventV3(n ? "rt_unfollow" : "rt_follow", l), 
s && (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.3.3")) && (n ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError));
} else "forum" === r && (doFollowUser(t, a, n, void 0, followSource.forum, "detail"), 
s && (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6")) && (n ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError)), 
(client.isAndroid && client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) && sendUmengEventV3(n ? "rt_unfollow" : "rt_follow", {
to_user_id: t,
follow_type: "from_group",
group_id: forum_extra.thread_id,
item_id: forum_extra.thread_id,
category_name: forum_extra.category_name,
source: "weitoutiao_detail",
server_source: followSource.forum,
position: "title_below",
log_pb: forum_extra.log_pb
}, !1));
}

function followBottomAction() {
var e = $(this), t = e.data("userId"), a = e.data("mediaId"), n = e.hasClass("following");
if (!e.hasClass("disabled")) {
if ($(".subscribe-button-bottom").addClass("disabled"), $(".boot-outer-container").css("display", "none"), 
"wenda" === Page.article.type) {
var i = $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_bottom_card",
position: "detail",
to_user_id: t,
follow_type: "from_group",
group_id: wenda_extra.ansid,
server_source: 80
});
Page.author.hasRedPack && (i.is_redpacket = 1), sendUmengEventV3(n ? "rt_unfollow" : "rt_follow", i);
}
doFollowUser(t, a, n, void 0, followSource[Page.article.type] || "", "wenda" === Page.article.type ? "answer_detail_bottom_card" : "detail_bottom");
}
}

function mediasugArrowAction() {
var e = $("header"), t = "close" === e.attr("sugstate");
NativePlayGif.willStart(function() {
e.attr("sugstate", t ? "open" : "close");
}), send_umeng_event("detail", t ? "click_arrow_down" : "click_arrow_up", {
extra: {
source: "article_detail"
}
});
}

function mediasugCardClickHandler(e) {
if (!$(e.target).is(".ms-subs")) {
var t = $(this).attr("it-is-user-id"), a = "", n = "", i = "";
"pgc" === Page.article.type ? (send_umeng_event("detail", "sub_rec_click", {
value: t,
extra: {
source: "article_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_article", n = Page.category_name, i = Page.statistics.group_id) : "forum" === Page.article.type ? (send_umeng_event("follow_card", "click_avatar", {
value: forum_extra.thread_id,
ext_value: t,
extra: {
source: "weitoutiao_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_topic", n = Page.forum_extra.category_name, i = Page.forum_extra.thread_id) : "wenda" === Page.article.type && (send_umeng_event("follow_card", "click_avatar", {
value: wenda_extra.ansid,
ext_value: t,
extra: {
source: "wenda_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_wenda", n = wenda_extra.gd_ext_json ? wenda_extra.gd_ext_json.category_name : "", 
i = wenda_extra.ansid), window.location.href = "sslocal://profile?uid=" + t + ("wenda" === Page.article.type ? "&refer=wenda" : "") + "&group_id=" + i + "&from_page=" + a + "&profile_user_id=" + Page.author.userId + (n ? "&category_name=" + n : "");
}
}

function mediasugFollowAction() {
var e = $(this), t = null != e.attr("isfollowing"), a = e.closest(".ms-item").attr("it-is-user-id"), n = e.closest(".ms-item").attr("it-is-media-id"), i = e.attr("reason"), r = followSource[Page.article.type + "_sug"], o = e.closest(".ms-item").data("index");
if (e.attr("disabled", !0), "wenda" === Page.article.type) sendUmengEventV3(t ? "rt_unfollow" : "rt_follow", $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_follow_card",
position: "detail",
to_user_id: a,
order: o,
profile_user_id: wenda_extra.user ? wenda_extra.user.user_id : "",
follow_type: "from_recommend"
})); else if ("forum" !== Page.article.type || client.isNewsArticleVersionNoLessThan("6.4.2")) {
if (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) {
var s = {
source: "detail_follow_card",
to_user_id: a,
order: o,
profile_user_id: Page.author.userId,
follow_type: "from_recommend",
category_name: "forum" === Page.article.type ? forum_extra.category_name : Page.category_name,
server_source: followSource[Page.article.type + "_sug"],
log_pb: "forum" === Page.article.type ? forum_extra.log_pb : Page.log_pb
};
"" != n && (s.media_id = n), sendUmengEventV3(t ? "rt_unfollow" : "rt_follow", s, !1);
}
} else send_umeng_event(t ? "unfollow" : "follow", "weitoutiao_detail_sug", {
ext_value: a,
value: forum_extra.thread_id,
extra: {
profile_user_id: Page.author.userId,
source: "weitoutiao_detail"
}
});
ToutiaoJSBridge.call("user_follow_action", {
id: a,
action: t ? "unfollow" : "dofollow",
reason: i,
source: r,
order: o,
from: "sug"
}, function(n) {
e.attr("disabled", null), "object" == typeof n && 1 === +n.code && ("pgc" !== Page.article.type || client.isNewsArticleVersionNoLessThan("6.4.2") || send_umeng_event("detail", t ? "sub_rec_unsubscribe" : "sub_rec_subscribe", {
value: a,
extra: {
source: "article_detail",
profile_user_id: Page.author.userId
}
}), e.attr("isfollowing", t ? null : ""), doRecommendUsers(Page.author.userId, function(e) {
if (Array.isArray(e)) for (var n = e.length, i = 0; n > i; i++) e[i].user_id == a && (e[i].is_following = !t);
}, function() {}));
});
}

function domPrepare() {
var e = document.querySelector(".mediasug-outer-container"), t = document.querySelector(".mediasug-inner-container");
if (e && t) {
e.addEventListener("transitionend", function() {
console.info("transitionend"), NativePlayGif.ended();
}, !1);
var a = window.MutationObserver || window.WebKitMutationObserver;
if (a) {
var n = new a(function(e) {
e.forEach(function(e) {
var t = e.attributeName;
if ("sugstate" === t) {
var a = e.target.getAttribute(t);
if ("open" === a) {
console.info("SUG-OEPN"), mediasugScroll.open(), $(document).on("scroll", mediasugScroll.pagescroll), 
ToutiaoJSBridge.on("webviewScrollEvent", function(e) {
mediasugScroll.webviewScroll(e);
});
var n, i;
"pgc" === Page.article.type ? (n = "article_detail", i = Page.statistics.group_id) : "forum" === Page.article.type ? (n = "weitoutiao_detail", 
i = forum_extra.thread_id) : "wenda" === Page.article.type && (n = "wenda_detail", 
i = wenda_extra.ansid), send_umeng_event("follow_card", "show", {
value: i,
extra: {
source: n
}
});
} else "close" === a ? (console.info("SUG-HIDE"), $(document).off("scroll", mediasugScroll.pagescroll), 
mediasugScroll.pushimpr(!0)) : (console.info("SUG-HIDE"), $(document).off("scroll", mediasugScroll.pagescroll), 
mediasugScroll.pushimpr(!0));
}
});
});
n.observe(document.getElementsByTagName("header")[0], {
attributes: !0
});
}
}
}

function recommendUsersError() {
console.info(arguments);
}

function recommendUsersSuccess(list) {
if (!($("header").get(0).getBoundingClientRect().bottom + 232 < 0)) {
list.forEach(function(e) {
if (e.user_auth_info && "string" == typeof e.user_auth_info) try {
e.user_auth_info = JSON.parse(e.user_auth_info);
} catch (t) {
e.user_auth_info = {};
}
}), mediasugScroll.init(list);
var MediasugTemplateFunction = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) {
__p += "";
for (var i = 0; i < data.length; i++) {
var item = data[i];
__p += '<div class="ms-item" it-is-user-id="' + (null == (__t = item.user_id) ? "" : __t) + '" data-index="' + (null == (__t = i + 1) ? "" : __t) + '" it-is-media-id="' + (null == (__t = item.media_id ? item.media_id : "") ? "" : __t) + '"><div class="ms-avatar"><div class="ms-avatar-wrap"><img class="ms-avatar-image" src="' + (null == (__t = item.avatar_url) ? "" : __t) + '"></div>', 
useServerV && item.user_verified && item.user_auth_info && item.user_auth_info.auth_type && (__p += "" + (null == (__t = buildServerVIcon2(item.user_auth_info.auth_type, "avatar_icon")) ? "" : __t)), 
__p += '</div><div class="ms-name-wrap"><div class="ms-name ' + (null == (__t = !useServerV && item.user_verified ? " verified" : "") ? "" : __t) + '">' + (null == (__t = item.name) ? "" : __t) + '</div></div><div class="ms-desc">' + (null == (__t = item.reason_description) ? "" : __t) + '</div><button reason="' + (null == (__t = item.reason) ? "" : __t) + '" class="ms-subs ' + (null == (__t = isRedFocusButton ? "ms-red-btn" : "") ? "" : __t) + '" ' + (null == (__t = item.is_following ? " isfollowing " : "") ? "" : __t) + " " + (null == (__t = item.is_followed ? " isfollowed " : "") ? "" : __t) + ' ><span class="focus-icon">&nbsp;</span></button></div>';
}
__p += "";
}
return __p;
}, MediasugTemplateString = MediasugTemplateFunction({
data: list,
useServerV: Page.useServerV,
isRedFocusButton: Page.isRedFocusButton
});
$("#mediasug-list-html").html(MediasugTemplateString).css("width", 150 * list.length + 10 + 15 + "px"), 
NativePlayGif.willStart(function() {
$("header").attr("sugstate", "open");
}), $("#mediasug-list").on("touchstart touchmove", function() {
sendBytedanceRequest("disable_swipe");
}).on("touchend touchcancel", function() {
sendBytedanceRequest("enable_swipe");
}), $("#mediasug-list").on("scroll", _.throttle(mediasugScroll.handler, 150)), needCleanDoms.push($("#mediasug-list"));
}
}

function doFollowUser(e, t, a, n, i, r) {
subscribeTimeoutTimer = setTimeout(change_following_state, 1e4, a, !0), ToutiaoJSBridge.call("user_follow_action", {
id: e,
action: a ? "unfollow" : "dofollow",
reason: n,
source: i,
from: r
}, function(e) {
clearTimeout(subscribeTimeoutTimer), e && "object" == typeof e && 1 === +e.code ? change_following_state(!!e.status, !0) : change_following_state(a, !0);
});
}

function doFollowMedia(e, t, a, n) {
subscribeTimeoutTimer = setTimeout(change_following_state, 1e4, a, !0), ToutiaoJSBridge.call(a ? "do_media_unlike" : "do_media_like", {
id: t,
uid: e,
concern_type: n,
source: !a && Page.author.hasRedPack ? followSource.pgc + 1e3 : followSource.pgc
}, function(n) {
clearTimeout(subscribeTimeoutTimer), 1 === +n.code ? change_following_state(!a, !0, function(a) {
client.isNewsArticleVersionNoLessThan("6.4.2") ? (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) && sendUmengEventV3(a ? "rt_follow" : "rt_unfollow", {
to_user_id: e,
media_id: t,
follow_type: "from_group",
group_id: Page.statistics.group_id,
item_id: Page.statistics.item_id,
category_name: Page.category_name,
source: "article_detail",
server_source: followSource.pgc,
position: "title_below",
log_pb: Page.log_pb
}, !1) : a ? send_umeng_event("preview", "preview_click_sub") : send_umeng_event("preview", "preview_click_cancel_sub");
}) : client.isAndroid || client.isNewsArticleVersionNoLessThan("5.7.2") ? change_following_state(a, !0) : change_following_state(a, !0);
});
}

function bindStatisticsEvents23() {
$(document.body).on("click", ".subscribe-button", followActionHandler), $(document.body).on("click", ".subscribe-button-bottom", followBottomAction), 
$(document.body).on("click", ".mediasug-arrow-button", mediasugArrowAction), $(document.body).on("click", ".ms-item", mediasugCardClickHandler), 
$(document.body).on("click", ".ms-subs", mediasugFollowAction);
}

function processForumArticle2() {
var e = formatCount(null, forum_extra.read_count, "0");
$("#origin-read-count").html(e);
for (var t = document.querySelectorAll(".emoji"), a = 0, n = t.length, a = 0; n > a; a++) t[a].style.backgroundImage = "url(http://s3.pstatp.com/toutiao/tt_tps/static/images/ttemoji/" + t[a].classList[1] + "@3x.png)";
}

function bindRepostEvent() {
$(".tt-repost-thread").on("click", function(e) {
var t = $(e.target);
0 === t.closest("a").length && (location.href = this.dataset.openUrl);
}), $(".tt-repost-ugcvideo").on("click", function(e) {
var t = $(e.target);
0 === t.closest(".cover").length && 0 === t.closest(".originuser").length && (location.href = this.dataset.openUrl);
}), $(".out-link").on("click", function() {
sendUmengEventV3("external_link_click", {
category_name: forum_extra.category_name,
group_id: Page.forum_extra.thread_id
});
});
}

function processTable() {
client.isAndroid ? $("table").each(function(e, t) {
$(t).addClass("border").wrap('<div class="table-wrap horizontal_scroll_android"/>');
}) : client.isIOS && $("table").each(function(e, t) {
var a = $(t);
if (a.addClass("border").wrap('<div class="table-wrap horizontal_scroll"/>'), a.width() > innerWidth - 30) {
var n = a.parent(), i = $('<div class="swipe_tip">左滑查看更多</div>');
n.append(i), n.on("touchstart", function() {
i.css("opacity", "0");
}).on("scroll touchend", function() {
0 === this.scrollLeft && i.css("opacity", "1");
}), needCleanDoms.push(n);
}
});
}

function appendVideoImg() {
var e = this.parentNode;
e && (e.style.background = "black");
}

function errorVideoImg() {
var e = this.parentNode;
e && e.removeChild(this);
}

function processCustomVideo() {
$(".custom-video").each(function(e, t) {
var a = $(t), n = t.dataset, i = n.width, r = n.height, o = .75, s = 0, l = o, c = "";
i && r && (s = r / i, o >= s ? l = s : c = "height: 100%; width: auto;");
var d = t.clientWidth;
if (a.css("height", d * l + "px"), n.wendaSource && "object" == typeof window.wenda_extra) {
var u = formatDuration(n.duration);
if (a.html('<img src="' + n.poster + '" style="' + c + '" onload="appendVideoImg.call(this)" onerror="errorVideoImg.call(this)" /><i class="custom-video-trigger"></i><i class="custom-video-duration">' + u + "</i>"), 
"pgc" === n.wendaSource) {
var _ = $('<a class="cv-wd-info-wrapper" href="' + n.openUrl + '"><span class="cv-wd-info-name" ' + (Boolean(Number(n.isVerify)) ? "is-verify" : "") + ">" + n.mediaName + '</span><span class="cv-wd-info-pc">' + n.playCount + "次播放</span></a>");
_.on("click", function() {
ToutiaoJSBridge.call("pauseVideo"), send_umeng_event("answer_detail", "click_video_detail", {
value: wenda_extra.ansid,
extra: {
video_id: n.vid,
enter_from: wenda_extra.enter_from || "",
ansid: wenda_extra.ansid,
qid: wenda_extra.qid,
parent_enterfrom: wenda_extra.parent_enterfrom || ""
}
});
}), needCleanDoms.push(_), a.after(_);
}
var p = {
value: wenda_extra.ansid,
extra: {
position: "detail",
video_id: n.vid,
enter_from: wenda_extra.enter_from || "",
ansid: wenda_extra.ansid,
qid: wenda_extra.qid,
parent_enterfrom: wenda_extra.parent_enterfrom || ""
}
};
window.wenda_extra && window.wenda_extra.answer_detail_type ? wendaCacheAdd(function() {
sendUmengWhenTargetShown(t, "video_show", "click_question_and_answer", p, !0);
}) : sendUmengWhenTargetShown(t, "video_show", "click_question_and_answer", p, !0);
} else a.html('<img src="' + n.poster + '" style="' + c + '" onload="appendVideoImg.call(this)" onerror="errorVideoImg.call(this)" /><i class="custom-video-trigger"></i>');
Page.hasExtraSpace = !1;
});
}

function checkDisplayedFactory(e, t) {
return lastBottom = {}, function() {
var a = document.querySelector(e);
if (a) {
var n = a.getBoundingClientRect();
n.bottom < 0 && lastBottom[e] >= 0 ? ToutiaoJSBridge.call(t, {
show: !0
}) : n.bottom >= 0 && lastBottom[e] < 0 && ToutiaoJSBridge.call(t, {
show: !1
}), lastBottom[e] = n.bottom;
}
};
}

function processPageStateChangeEvent(e) {
switch (e.type) {
case "pgc_action":
console.info("pgc_action", e), subscribeTimeoutTimer && clearTimeout(subscribeTimeoutTimer);
var t = $(".subscribe-button"), a = t.data("mediaId");
e.id == a && "status" in e && (change_following_state(!!e.status, !0), e.status && (Page.author.hasRedPack = !1));
break;

case "user_action":
console.info("user_action", e), subscribeTimeoutTimer && clearTimeout(subscribeTimeoutTimer);
var t = $(".subscribe-button"), n = t.data("userId");
if (e.id == n && "status" in e) change_following_state(!!e.status, !0); else {
var i = $('[it-is-user-id="' + e.id + '"]');
i.length > 0 && "status" in e && (i.find(".ms-subs").attr("isfollowing", e.status ? "" : null).attr("disabled", null), 
e.status && mediasugScroll.next(), doRecommendUsers(Page.author.userId, function(t) {
if (Array.isArray(t)) for (var a = t.length, n = 0; a > n; n++) t[n].user_id == e.id && (t[n].is_following = !!e.status);
}, function() {}));
}
break;

case "wenda_digg":
var r = $("#digg").attr("data-answerid");
if (window.wenda_extra && window.wenda_extra.wd_version >= 8 && e.id === window.wenda_extra.ansid) {
var o = +$(".digg-count-special").attr("realnum");
"status" in e && (1 == e.status ? formatCount(".digg-count-special", o + 1, "0") : o > 0 && formatCount(".digg-count-special", o - 1, "0"));
} else if (e.id == r && "digged" !== $("#digg").attr("wenda-state")) {
$("#digg").attr("wenda-state", "digged");
var o = +$("#digg").find(".digg-count").attr("realnum");
formatCount(".digg-count", o + 1, "赞"), formatCount(".digg-count-special", o + 1, "0");
}
break;

case "wenda_bury":
var r = $("#bury").attr("data-answerid");
if (e.id == r && "buryed" !== $("#bury").attr("wenda-state")) {
$("#bury").attr("wenda-state", "buryed");
var s = +$("#bury").find(".bury-count").attr("realnum");
formatCount(".bury-count", s + 1, "踩");
}
break;

case "forum_action":
var l = $(".pcard.fiction").find(".button"), c = l.attr("forum-id");
e.id == c && l.attr("is-concerned", Boolean(e.status)).html(e.status ? "已关注" : "关注");
break;

case "concern_action":
var l = $(".pcard.fiction").find(".button"), d = l.attr("concern-id");
e.id == d && l.attr("is-concerned", Boolean(e.status)).html(e.status ? "已加入" : "加入书架");
break;

case "carousel_image_switch":
"function" == typeof onCarouselImageSwitch && (Page.forum_extra && Page.forum_extra.thread_id == e.id ? onCarouselImageSwitch(e.status) : Page.wenda_extra && Page.wenda_extra.ansid == e.id ? onCarouselImageSwitch(e.status) : Page.statistics.group_id == e.id && onCarouselImageSwitch(e.status));
break;

case "block_action":
if (console.info(e), 1 == e.status) {
var t = $(".subscribe-button"), n = t.data("userId");
if (e.id == n) change_following_state(!1, !0); else {
var i = $('[it-is-user-id="' + e.id + '"]');
i.length > 0 && i.find(".ms-subs").attr("isfollowing", null);
}
}
}
}

function processParagraph() {
var e = /[\u2e80-\u2eff\u3000-\u303f\u3200-\u9fff\uf900-\ufaff\ufe30-\ufe4f]/, t = /[a-z0-9_:\-\/.%]{26,}/gi, a = /huawei/.test(navigator.userAgent.toLowerCase());
a && document.body.classList.add("huawei"), $("article p").each(function(a, n) {
if (!(n.classList.contains("pgc-img-caption") || !n.textContent || $(n).find(".image").length > 0)) if (e.test(n.textContent)) {
if (t.test(n.textContent)) {
var i = n.textContent.match(t);
i.forEach(function(e) {
n.innerHTML = n.innerHTML.replace(e, function(e) {
return '<br class="sysbr">' + e;
});
});
}
} else n.style.textAlign = "left";
});
}

function setContent(e) {
if (startTimestamp = Date.now(), null !== e) {
var t = e.indexOf("<article>"), a = e.indexOf("</article>"), n = e.substring(t + 9, a);
globalContent = n || e;
}
}

function setExtra(e) {
void 0 === e ? globalExtras = window : "object" == typeof e.h5_extra ? globalExtras = e : client.isIOS ? globalExtras.h5_extra = e : client.isAndroid && (globalExtras.h5_extra = $.extend(!0, globalExtras.h5_extra, e)), 
window.Page = buildPage(globalExtras), window.OldPage ? _.isEqual(window.OldPage, window.Page) || (window.OldPage = window.Page, 
buildHeader(window.Page), Page.novel_data && ToutiaoJSBridge.call("is_login", {}, function(e) {
Page.is_login = e && (e.is_login || 1 == e.code), buildArticle(globalContent), processArticle(), 
buildFooter(window.Page), globalContext && contextRenderer(globalContext);
})) : (window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_build_article", +new Date() - startTimestamp), 
window.OldPage = window.Page, TouTiao.setDayMode(Page.pageSettings.is_daymode ? 1 : 0), 
TouTiao.setFontSize(Page.pageSettings.font_size), buildUIStyle(Page.h5_settings), 
buildHeader(window.Page), buildArticle(globalContent), Page.novel_data ? ToutiaoJSBridge.call("is_login", {}, function(e) {
Page.is_login = e && (e.is_login || 1 == e.code), buildFooter(window.Page), functionName();
}) : (buildFooter(window.Page), functionName()));
}

function functionName() {
sendBytedanceRequest("domReady"), window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_process_article", +new Date() - startTimestamp), 
ToutiaoJSBridge.on("page_state_change", processPageStateChangeEvent), processArticle(), 
window.sendTTCustomizeLog && window.sendTTCustomizeLog("end_process_article", +new Date() - startTimestamp), 
null !== globalCachedContext && contextRenderer(globalCachedContext), canSetContext = !0;
}

function insertDiv(e) {
window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_insert_div", +new Date() - startTimestamp), 
canSetContext ? (contextRenderer(e), globalContext = e) : globalCachedContext = e;
}

function onQuit() {
Page && Page.author && Page.author.userId && mediasugScroll.clearData(Page.author.userId), 
Page = {}, OldPage = null, globalContent = void 0, canSetContext = !1, window.imageInited = !1, 
window.imageSizeInitTimer && clearTimeout(window.imageSizeInitTimer), appCloseVideoNoticeWeb(), 
NativePlayGif.clean(), needCleanDoms.forEach(function(e) {
e.off();
}), needCleanDoms = [], imprProcessQueue = [], flushErrors(!0), $("header").replaceWith("<header>"), 
$("article").empty(), $("footer").empty(), $(document).off("scroll"), "onGetSeriesLinkPositionTimer" in window && clearInterval(onGetSeriesLinkPositionTimer);
}

function bindStatisticsEvents() {
document.addEventListener("scroll", function() {
imprProcessQueue.length > 0 && imprProcessQueue.forEach(function(e, t, a) {
e && isElementInViewportY(e[0], e[4]) && (e[5] && 3 === e[5].version ? sendUmengEventV3(e[1], e[3], !!e[5].isDoubleSend) : send_umeng_event(e[1], e[2], e[3]), 
a[t] = void 0);
});
}, !1);
var e = $(document.body);
e.on("click", ".pgc-link", function() {
var e, t = "", a = "";
"forum" === Page.article.type ? (send_umeng_event("talk_detail", "click_ugc_header", Page.forumStatisticsParams), 
t = "detail_topic", a = Page.forum_extra.category_name, e = Page.forum_extra.thread_id) : "pgc" === Page.article.type ? (send_umeng_event("detail", "click_pgc_header", {
value: Page.author.mediaId,
extra: {
item_id: Page.statistics.item_id
}
}), t = "detail_article", a = Page.category_name, e = Page.statistics.group_id) : (t = "detail_answer_wenda", 
a = wenda_extra.gd_ext_json ? wenda_extra.gd_ext_json.category_name : "", e = wenda_extra.ansid);
}), e.on("click", "#prev_serial_link", function() {
send_umeng_event("detail", "click_pre_group", {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id
}
});
}).on("click", "#next_serial_link", function() {
send_umeng_event("detail", "click_next_group", {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id
}
});
}).on("click", "#index_serial_link", function() {
send_umeng_event("detail", "click_catalog", {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id
}
});
}), e.on("click", ".custom-video", function() {
playVideo(this, 0);
}), e.on("click", "#digg", function() {
"digged" === $(this).attr("wenda-state") ? ToutiaoJSBridge.call("toast", {
text: "你已经赞过",
icon_type: "icon_error"
}) : "buryed" === $("#bury").attr("wenda-state") ? ToutiaoJSBridge.call("toast", {
text: "你已经踩过",
icon_type: "icon_error"
}) : ToutiaoJSBridge.call("page_state_change", {
type: "wenda_digg",
id: $(this).attr("data-answerid"),
status: 1
});
}), e.on("click", "#bury", function() {
"buryed" === $(this).attr("wenda-state") ? ToutiaoJSBridge.call("toast", {
text: "你已经踩过",
icon_type: "icon_error"
}) : "digged" === $("#digg").attr("wenda-state") ? ToutiaoJSBridge.call("toast", {
text: "你已经赞过",
icon_type: "icon_error"
}) : ToutiaoJSBridge.call("page_state_change", {
type: "wenda_bury",
id: $(this).attr("data-answerid"),
status: 1
});
});
}

function playVideo(e, t) {
var a = e.getAttribute("data-video-size"), n = e.getBoundingClientRect(), i = [ n.left, e.offsetTop, 640, 435 ];
if (a) {
var r = null;
try {
r = JSON.parse(a), r && r.normal && r.normal.h && r.normal.w && (i[2] = r.normal.w, 
i[3] = r.normal.h);
} catch (o) {}
}
ToutiaoJSBridge.call("playNativeVideo", {
sp: e.getAttribute("data-sp"),
vid: e.getAttribute("data-vid"),
frame: i,
status: t
}, function(e) {
if ($(".custom-video").show(), 1 == e.code) {
var t = document.querySelector('[data-vid="' + e.vid + '"]');
t && (t.style.display = "none", $(t).next(".cv-wd-info-wrapper").hide(), window.wenda_extra && window.wenda_extra.wd_version && (e.height += 15), 
document.body.style.marginTop = e.height + "px");
}
});
}

function __w(e, t, a) {
var n = document.createElement(a);
n.classList.add("image-wrap"), e.insertBefore(n, t), n.appendChild(t);
}

function __adjustOriginImageScale(e, t) {
var a = 200, n = 200, i = window.aW / 2;
if (AIP.isDuoTuThread) return [ "ERROR", "ERROR" ];
var r, o, s = e[0] / e[1];
return r = e[0] ? e[0] > i ? window.aW : e[0] : a, o = s ? parseInt(r / s) : n, 
t && (o = Math.min(o, parseInt(.8 * window.iH))), [ r, o ];
}

function __buildGetImageSource(e, t, a) {
return AIP.url_prefix + "getimage/" + e + "/" + t + "/" + AIP.group_id + "/" + a;
}

function __buildImageSource(e, t) {
return AIP.url_prefix + "image/" + e + "/" + t;
}

function onCarouselImageSwitch(e) {
console.info("onCarouselImageSwitch", e);
var t = AIP.pictures[e], a = AIP.threadGGSwitch ? AIP.threadImageType : "origin";
t.url && t.state !== a && (console.info("onCarouselImageSwitch", e, a), t.url = __buildGetImageSource(a, t.zsp, t.index), 
t.state = a, AIP.renderHolder(t));
}

function tellClientContentSize() {
var e = 0;
setInterval(function() {
var t = document.querySelector("footer").getBoundingClientRect(), a = t.top + t.height;
a !== e && (e = a, ToutiaoJSBridge.call("webviewContentResize", {
height: a
}));
}, 200);
}

function processArticle() {
switch (window.aW = document.body.offsetWidth - 30 || window.innerWidth - 30, window.iH = window.innerHeight, 
AndroidImageProcessor.threadGGSwitch = "forum" === Page.article.type && Page.forum_extra.use_9_layout, 
AndroidImageProcessor.url_prefix = Page.pageSettings.url_prefix, AndroidImageProcessor.group_id = Page.pageSettings.group_id, 
AndroidImageProcessor.imageType = Page.pageSettings.image_type, AndroidImageProcessor.useLazyload = Page.pageSettings.use_lazyload, 
AndroidImageProcessor.samePicturesCheckCache = [], AndroidImageProcessor.start(), 
processParagraph(), Page.article.type) {
case "forum":
bindRepostEvent();
break;

case "pgc":
processTable(), processCustomVideo(), pgcEvent.emit("card-render", document.body);
break;

case "wenda":
processTable(), processCustomVideo();
}
$(document).on("scroll", checkHeaderDisplayed), $(document).on("scroll", checkWendaABHeaderLayout), 
$(document).on("scroll", checkWendanextDisplayed), onGetSeriesLinkPositionTimer = setInterval(function() {
if (!document.querySelector(".serial")) return void clearInterval(onGetSeriesLinkPositionTimer);
var e = document.querySelector(".serial").offsetTop;
e > 0 && (clearInterval(onGetSeriesLinkPositionTimer), ToutiaoJSBridge.call("onGetSeriesLinkPosition", {
value: document.body.scrollHeight - e
}));
}, 500);
}

window.client = {
isAndroid: /android/i.test(navigator.userAgent),
isIOS: /iphone/i.test(navigator.userAgent),
newsArticleVersion: _getNewsArticleVersion()
}, client.osVersion = client.isAndroid ? _getAndroidVersion() : client.isIOS ? _getIOSVersion() : "", 
client.isSeniorAndroid = client.isAndroid ? parseFloat(client.osVersion) >= 4.4 : !0, 
client.isNewsArticleVersionNoLessThan = _isNewsArticleVersionNoLessThan;

var hash = function() {
var e = location.hash.substr(1), t = {};
return e && e.split("&").forEach(function(e) {
e = e.split("=");
var a = e[0], n = e[1];
a && (t[a] = n);
}), function(e, a) {
var n = {};
return void 0 === e && void 0 === a ? location.hash : void 0 === a && "string" == typeof e ? t[e] : ("string" == typeof e && "string" == typeof a ? n[e] = a : void 0 === a && "object" == typeof e && (n = e), 
$.extend(t, n), void (location.hash = hash2string(t)));
};
}(), getMeta = function() {
for (var e = document.getElementsByTagName("meta"), t = {}, a = 0, n = e.length; n > a; a++) {
var i = e[a].name.toLowerCase(), r = e[a].getAttribute("content");
i && r && (t[i] = r);
}
return function(e) {
return t[e];
};
}(), urlAddQueryParams = function(e, t) {
var a, n = [], i = "?";
for (a in t) t.hasOwnProperty(a) && n.push(a + "=" + encodeURIComponent(t[a]));
return -1 !== e.indexOf("?") && (i = "&"), [ e, i, n.join("&") ].join("");
}, event_type = client.isAndroid ? "log_event" : "custom_event", sendBytedanceRequest = function() {
function e() {
o.length > 0 && (n.src = o.shift(), l = Date.now(), t());
}
function t() {
clearTimeout(r), r = setTimeout(e, s);
}
var a = "SEND-BYTE--DANCE-REQUEST", n = document.getElementById(a), i = "bytedance://";
n || (n = document.createElement("iframe"), n.id = a, n.style.display = "none", 
document.body.appendChild(n));
var r, o = [], s = 100, l = Date.now() - s - 1;
return function(e) {
var a = Date.now();
0 === o.length && a - l > s ? (n.src = i + e, l = a) : (o.push(i + e), t());
};
}(), WendaCacheUmeng = [];

!function() {
var e = {};
window.PressState = function(e) {
var t = {
holder: "body",
bindSelector: "",
exceptSelector: "",
pressedClass: "pressed",
triggerLatency: 100,
removeLatency: 100
};
this.settings = $.extend({}, t, e), this._init();
}, PressState.prototype = {
_init: function() {
"" != this.settings.bindSelector && (this._appendClass(), this._bindEvent());
},
_appendClass: function() {
if ("pressed" == this.settings.pressedClass) {
var e = "<style type='text/css'>.pressed{background-color: #e0e0e0 !important;} .night .pressed{background-color: #1b1b1b !important;}</style>";
$("body").append(e);
}
},
_bindEvent: function() {
var t = this.settings.holder, a = "" == this.settings.exceptSelector ? this.settings.bindSelector : [ this.settings.bindSelector, this.settings.exceptSelector ].join(","), n = this.settings.exceptSelector, i = this.settings.pressedClass, r = parseInt(this.settings.triggerLatency), o = parseInt(this.settings.removeLatency);
$(t).on("touchstart", a, function(t) {
if (!$(this).is(n)) {
var a = $(this);
e.mytimer = setTimeout(function() {
a.addClass(i);
}, r), e.tar = t.target;
}
}), $(t).on("touchmove", a, function() {
$(this).is(n) || (clearTimeout(e.mytimer), $(this).removeClass(i), e.tar = null);
}), $(t).on("touchend touchcancel", a, function(t) {
if (!$(this).is(n) && e.tar === t.target) {
clearTimeout(e.mytimer), $(this).hasClass(i) || $(this).addClass(i);
var a = $(this);
setTimeout(function() {
a.removeClass(i);
}, o);
}
});
}
};
}();

var baseFilePath = function() {
function e() {
for (var e = document.querySelectorAll("script"), a = 0, n = e.length; n > a; a++) {
var i = e[a].src, r = i.indexOf("/v55/js/lib.js");
if (r > -1) {
t = i.substr(0, r);
break;
}
if (r = i.indexOf("/v60/js/lib.js"), r > -1) {
t = i.substr(0, r);
break;
}
}
t && (t += "/shared/");
}
var t = "";
return function() {
return t || e(), t;
};
}(), getCommonParams = function() {
function e(e) {
ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(a) {
t = a.data || a, "function" == typeof e && e(t);
});
}
var t;
return e(), function(a) {
t ? "function" == typeof a && a(t) : a && e(a);
};
}(), fnTimeCountDown = function(e, t, a, n) {
var i = {
time_delta: t - new Date().getTime(),
zero: function(e) {
var e = parseInt(e, 10);
return e > 0 ? (9 >= e && (e = "0" + e), String(e)) : "00";
},
dv: function() {
e = e || Date.now();
var t = new Date(e), a = new Date(), r = Math.round((t.getTime() - (a.getTime() + this.time_delta)) / 1e3), o = {
sec: "00",
mini: "00",
hour: "00"
};
return r > 0 ? (o.sec = i.zero(r % 60), o.mini = Math.floor(r / 60) > 0 ? i.zero(Math.floor(r / 60) % 60) : "00", 
o.hour = Math.floor(r / 3600) > 0 ? i.zero(Math.floor(r / 3600) % 24) : "00") : n && n(), 
o;
},
ui: function() {
a.sec && (a.sec.innerHTML = i.dv().sec + "秒"), a.mini && (a.mini.innerHTML = i.dv().mini + "分"), 
a.hour && (a.hour.innerHTML = i.dv().hour + "小时"), setTimeout(i.ui, 1e3);
}
};
i.ui();
}, renderHeader = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) {
if (__p += '<header topbutton-type="' + (null == (__t = data.topbuttonType) ? "" : __t) + '" sugstate="no" ' + (null == (__t = data.hasExtraSpace ? "" : "no-extra-space") ? "" : __t) + ">", 
__p += "", data.h5_settings.pgc_over_head || (__p += '<div class="tt-title">' + (null == (__t = data.article.title) ? "" : __t) + "</div>"), 
__p += "", __p += "", "zhuanma" == data.article.type) __p += '<div class="zhuanma-wrapper"><span class="zm-time">' + (null == (__t = data.article.publishTime) ? "" : __t) + '</span><span class="zm-author">' + (null == (__t = data.author.name) ? "" : __t) + "</span></div>"; else if ("pgc" != data.article.type || !data.novel_data || data.novel_data.can_read) {
if (__p += '<div class="authorbar ' + (null == (__t = data.article.type) ? "" : __t) + '" id="profile">', 
__p += '<a class="author-avatar-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><div class="author-avatar"><img class="author-avatar-img" src="' + (null == (__t = data.author.avatar) ? "" : __t) + '"></div>', 
data.useServerV && data.author.auth_info && (__p += "" + (null == (__t = buildServerVIcon2(data.author.auth_type, "avatar_icon")) ? "" : __t)), 
__p += "</a>", __p += "", "wenda" === data.article.type ? __p += '<div class="wenda-info" style="display: ' + (null == (__t = data.author.isAuthorSelf ? "block" : "none") ? "" : __t) + ';"><span class="read-info brow-count"></span><span class="like-info digg-count-special"></span></div>' : "forum" === data.article.type && (__p += '<div class="wenda-info" style="display: ' + (null == (__t = data.author.isAuthorSelf ? "block" : "none") ? "" : __t) + ';"><span></span></div>'), 
__p += "", __p += '<div class="author-function-buttons" style="display: ' + (null == (__t = data.author.isAuthorSelf || "wenda" === data.article.type && data.h5_settings.is_liteapp || "forum" === data.article.type && "following" === data.author.followState || data.hideFollowButton ? "none" : "block") ? "" : __t) + ';"><div class="mediasug-arrow-button iconfont"></div><button class="subscribe-button follow-button ' + (null == (__t = "followState" in data.author ? data.author.followState : "disabled") ? "" : __t) + " " + (null == (__t = data.isRedFocusButton ? "red-follow-button" : "") ? "" : __t) + '"data-user-id="' + (null == (__t = data.author.userId) ? "" : __t) + '"data-media-id="' + (null == (__t = data.author.mediaId) ? "" : __t) + '"id="subscribe"><i class="iconfont focusicon">&nbsp;</i><i class="redpack"></i></button></div>', 
__p += '<div class="author-bar"><div class="name-link-wrap"><div class="name-link-w ' + (null == (__t = "wenda" === data.article.type && "" === data.author.intro && 0 === data.tags.length ? "no-intro" : "") ? "" : __t) + '">', 
("forum" === data.article.type || "wenda" === data.article.type) && data.author.medals && data.h5_settings.ugc_user_medal) {
__p += '<div class="article-medal">';
for (var medal in data.author.medals) {
var _medal = data.author.medals[medal];
__p += "", data.h5_settings.ugc_user_medal[_medal] && (__p += '<img src="' + (null == (__t = data.h5_settings.ugc_user_medal[_medal]) ? "" : __t) + '">'), 
__p += "";
}
__p += "</div>";
}
if (__p += "", data.useServerV || (__p += "", "" != data.author.verifiedContent && (__p += '<div class="iconfont verified-icon">&#xe600;</div>'), 
__p += ""), __p += '<a class="author-name-link pgc-link" href="' + (null == (__t = data.author.link) ? "" : __t) + '">' + (null == (__t = data.author.name) ? "" : __t) + '</a></div></div><a class="sub-title-w" href="' + (null == (__t = data.author.link) ? "" : __t) + '"><div class="article-tags">', 
data.tags.length > 0) {
__p += "";
for (var tag in data.tags) __p += "", __p += "原创" == data.tags[tag] ? '<div class="article-tag-original"></div>' : '<div class="article-tag">' + (null == (__t = data.tags[tag]) ? "" : __t) + "</div>", 
__p += "";
__p += "";
}
__p += "</div>", __p += "pgc" === data.article.type ? '<span class="sub-title">' + (null == (__t = data.article.publishTime) ? "" : __t) + (null == (__t = data.author.auth_info && data.article.publishTime ? "&nbsp;&middot;&nbsp;" : "") ? "" : __t) + (null == (__t = data.author.auth_info) ? "" : __t) + "</span>" : "forum" === data.article.type ? '<span class="sub-title">' + (null == (__t = data.article.publishTime) ? "" : __t) + (null == (__t = (data.author.intro || data.author.remarkName) && data.article.publishTime ? "&nbsp;&middot;&nbsp;" : "") ? "" : __t) + (null == (__t = data.author.remarkName ? data.author.remarkName : data.author.intro) ? "" : __t) + "</span>" : '<span class="sub-title">' + (null == (__t = data.author.intro) ? "" : __t) + "</span>", 
__p += "</a></div></div>", __p += '<div class="mediasug-outer-container"><div class="mediasug-inner-container"><div class="ms-pointer"></div><div class="ms-title">相关推荐</div><div class="ms-list" id="mediasug-list"><div class="ms-list-scroller" id="mediasug-list-html"></div></div></div></div>';
} else __p += '<div class="empty_authorbar"></div>';
__p += "", __p += "", data.h5_settings.pgc_over_head && (__p += '<div class="tt-title pgc-over-head">' + (null == (__t = data.article.title) ? "" : __t) + "</div>"), 
__p += "</header>";
}
return __p;
}, renderFooter = function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += "<footer>", data.wenda_extra && (__p += "", 
data.wenda_extra.wd_version >= 3 ? (__p += '<div class="wd-footer"><a href="#" class="link-more" id="wd-link-more" style="display:none;">了解更多</a><div class="publish-datetime">' + (null == (__t = data.article.publishTime) ? "" : __t) + "</div>", 
__p += data.wenda_extra.wd_version >= 6 ? '<a class="report" style="display:none" onclick="ToutiaoJSBridge.call(\'report\')">举报</a><span style="display:none" class="sep for-report" style="font-size:12px;">|</span><a class="editor-edit-answer no-icon" style="display:none">编辑</a><div item="dislike-and-report" class="dislike-and-report no-icon" style="display:none;" >反对</div>' : '<a class="editor-edit-answer" style="display:none">编辑</a><div class="dislike-and-report" onclick="ToutiaoJSBridge.call(\'dislike\', {options: 0x11});">不喜欢</div>', 
__p += "</div>") : __p += '<div class="wenda-bottom clearfix"><div class="create-time">' + (null == (__t = data.article.publishTime) ? "" : __t) + '</div></div><div class="bottom-buttons only-one"><div id="digg" data-answerid="' + (null == (__t = data.wenda_extra.ansid) ? "" : __t) + '" class="ib like" wenda-state="" aniok="' + (null == (__t = data.wenda_extra.aniok) ? "" : __t) + '"><span class="ibinner"><i class="iconfont iconb">&nbsp;</i><span class="b digg-count" realnum="0">赞</span></span></div><div id="bury" data-answerid="' + (null == (__t = data.wenda_extra.ansid) ? "" : __t) + '" class="ib unlike" wenda-state="" aniok="' + (null == (__t = data.wenda_extra.aniok) ? "" : __t) + '" style="display: none;"><span class="ibinner"><i class="iconfont iconb">&nbsp;</i><span class="b bury-count" realnum="0">踩</span></span></div></div>', 
__p += ""), __p += "", data.novel_data ? (__p += "", data.novel_data.can_read ? (__p += '<div class="serial">', 
__p += data.novel_data.pre_group_url ? '<a class="prev" id="prev_serial_link" href="' + (null == (__t = data.novel_data.pre_group_url) ? "" : __t) + '">上一章</a>' : '<span class="prev disabled">上一章</span>', 
__p += "", __p += data.novel_data.next_group_url ? '<a class="next" id="next_serial_link" href="' + (null == (__t = data.novel_data.next_group_url) ? "" : __t) + '">下一章</a>' : '<span class="next disabled">下一章</span>', 
__p += '<div class="index-wrap"><a class="index" id="index_serial_link" href="' + (null == (__t = data.novel_data.url) ? "" : __t) + '">目录（共' + (null == (__t = data.novel_data.serial_count) ? "" : __t) + "章）</a></div></div>") : (__p += '<div class="pay">', 
data.pay_status ? (2 == data.pay_status || -1 == data.pay_status && !data.is_login) && (__p += '<div class="split"></div><div class="button"><button class="buy"></button></div>') : __p += '<div class="split"></div><div class="content">当前版本不支持阅读付费章节，请升级到最新版本继续阅读</div><div class="button"><button class="update"></button></div>', 
__p += "</div>"), __p += "") : data.wenda_extra && data.wenda_extra.wd_version >= 1 && data.wenda_extra.wd_version < 3 && (__p += '<div class="serial" style="display: ' + (null == (__t = data.wenda_extra.wd_version >= 2 ? "block" : "none") ? "" : __t) + ';"><a class="prev" id="wenda_index_link"><span id="total-answer-count-index"></span></a><a class="next" id="next_answer_link" onclick="ToutiaoJSBridge.call(\'tellClientRetryPrefetch\');">下一个回答</a></div>'), 
__p += "</footer>";
return __p;
}, globalWendaStates = {}, TouTiao = {
setFontSize: setFontSize,
setDayMode: setDayMode
}, sendWeitoutiaoCardDisplayEvent = function() {
var e = "out", t = !0;
return function(a) {
if (a && a.needRecord && (t = a.needRecord), t) {
var n = $(".pcard.forum").get(0), i = "out", r = n.getBoundingClientRect();
r.bottom <= (window.innerHeight || document.body.clientHeight) && (i = "in"), "in" === i && "out" === e && (console.info("weitoutiao_in"), 
send_umeng_event("widget", "show_wtt", {
value: $("[data-content]").get(0).dataset.id,
extra: {
card_type: "1"
}
}), t = !1), e = i;
}
};
}(), contextRenderer = function(context) {
"object" == typeof context && (wendaContextRender(context), function() {
var cardTemplateFunctions = {
fiction: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<a class="pcard fiction" href="' + (null == (__t = url) ? "" : _.escape(__t)) + '"><div class="pcard-container pcard-vertical-border"><div class="pcard-clearfix"><div class="pcard-pull-left" style="position: relative"><img class="fiction-image" src="' + (null == (__t = poster) ? "" : _.escape(__t)) + '"/><span class="tag ' + (null == (__t = 0 == free_status || 2 == free_status ? "free" : 3 == free_status ? "sell" : "") ? "" : __t) + '"></span></div><div class="fiction-right"><button class="button pcard-button fiction-button pcard-pull-right ' + (null == (__t = isRedButton ? "red-pcard-button" : "") ? "" : __t) + '" action="concern" is-concerned="' + (null == (__t = Boolean(is_concerned)) ? "" : _.escape(__t)) + '" concern-id="' + (null == (__t = concern_id) ? "" : _.escape(__t)) + '" forum-id="' + (null == (__t = forum_id) ? "" : _.escape(__t)) + '">' + (null == (__t = is_concerned ? "已加入" : "加入书架") ? "" : _.escape(__t)) + '</button><div class="pcard-h16 pcard-w1 pcard-o1" style="margin-top: 2px">' + (null == (__t = name) ? "" : _.escape(__t)) + '</div><div class="pcard-h14 pcard-w1" style="margin-top: 4px">' + (null == (__t = 0 == creation_status ? "已完结" : "连载中") ? "" : __t) + " " + (null == (__t = word_number) ? "" : _.escape(__t)) + "</div>", 
0 == free_status || 2 == free_status ? __p += '<div class="pcard-h14 pcard-w1" style="margin-top: 4px">免费书籍，自由畅读</div>' : 1 == free_status ? __p += '<div class="pcard-h14 pcard-w1" style="margin-top: 4px">' + (null == (__t = base_price) ? "" : _.escape(__t)) + "头条币／千字</div>" : 3 == free_status && (__p += '<div class="pcard-h12 pcard-o1" style="margin-top: 6px"><span class="pcard-w9 pcard-w-delete origin-price">' + (null == (__t = base_price) ? "" : _.escape(__t)) + '头条币／千字</span> &nbsp; <span class="pcard-w1 sale-price">' + (null == (__t = discount_price) ? "" : _.escape(__t)) + '头条币／千字</span></div><div class="pcard-h12 pcard-w4 sale" style="margin-top: 4px">限时特价，还剩<span id="day"></span><span id="hour"></span><span id="mini"></span><span id="sec"></span></div>'), 
__p += "</div></div></div></a>";
return __p;
},
auto: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="pcard  auto"><div class="pcard-caption"><span class="pcard-h14 pcard-w1">相关车型</span><span class="pcard-h14 pcard-w3 pcard-vr icon-vr width16"></span><span class="pcard-h14 pcard-w3">数据来源于' + (null == (__t = data.data_source_show) ? "" : __t) + '</span></div><div class="p-autocard pcard-container pcard-vertical-border" data-href="' + (null == (__t = data.open_url) ? "" : __t) + '" data-content="content"><div class="pcard-clearfix"><div class="auto-image pcard-pull-left ' + (null == (__t = "dongchedi" == data.data_source ? "no-bg" : "") ? "" : __t) + '" style="background-image: url(' + (null == (__t = data.cover_url) ? "" : __t) + ');"></div><div class="container-right"><button type="button" class="pcard-button pcard-pull-right ' + (null == (__t = data.isRedButton ? "red-pcard-button" : "") ? "" : __t) + '" data-href="' + (null == (__t = "dongchedi" == data.data_source && data.xunjia_web_url ? data.xunjia_web_url : data.open_url) ? "" : __t) + '" style="margin-top: ' + (null == (__t = "dongchedi" === data.data_source ? "18px" : "") ? "" : __t) + '">' + (null == (__t = "dongchedi" == data.data_source ? "询底价" : "详情") ? "" : __t) + '</button><div class="" style="margin-right: 88px;"><div class="pcard-h16 pcard-w1" style="margin-bottom: 5px; padding-top: ' + (null == (__t = "dongchedi" === data.data_source ? "10px" : "") ? "" : __t) + '">' + (null == (__t = data.car_series) ? "" : __t) + "</div>", 
"rate" in data && (__p += '<div class="pcard-h12 iconfont film-star-score" style="margin-bottom: 5px;">' + (null == (__t = buildScoreByStar(Math.ceil(2 * data.rate))) ? "" : __t) + "&nbsp;" + (null == (__t = data.rate) ? "" : __t) + "</div>"), 
__p += "</div>", __p += "dongchedi" == data.data_source ? '<div class="pcard-w1 pcard-o1"><span class="pcard-w4 pcard-h16">' + (null == (__t = data.show_agent_price ? data.show_agent_price : "暂无报价") ? "" : __t) + '</span><span class="pcard-w4 pcard-h12">' + (null == (__t = data.show_agent_price ? data.show_agent_price_unit : "") ? "" : __t) + '</span>&nbsp;<span class="pcard-w3 pcard-h12 pcard-w-delete">' + (null == (__t = data.show_agent_price ? data.show_origin_price ? data.show_origin_price : "暂无报价" : "") ? "" : __t) + (null == (__t = data.show_agent_price && data.show_origin_price ? data.show_origin_price_unit : "") ? "" : __t) + "</span></div>" : '<div class="pcard-h14 pcard-w1">' + (null == (__t = data.price_prefix) ? "" : __t) + '<span class="pcard-w4">' + (null == (__t = data.price) ? "" : __t) + "</span></div>", 
__p += "</div></div>", Array.isArray(data.jump_url) && data.jump_url.length >= 4 && (__p += '<div class="mt8"><a class="pcard-h14 pcard-w1-a" href="' + (null == (__t = data.jump_url[0]) ? "" : __t) + '" data-label="card_ask">询底价</a><span class="pcard-h14 pcard-w3 pcard-vr icon-vr" style="width: 30px;"></span><a class="pcard-h14 pcard-w1-a" href="' + (null == (__t = data.jump_url[1]) ? "" : __t) + '" data-label="card_second">二手车</a><span class="pcard-h14 pcard-w3 pcard-vr icon-vr" style="width: 30px;"></span><a class="pcard-h14 pcard-w1-a" href="' + (null == (__t = data.jump_url[2]) ? "" : __t) + '" data-label="card_sale">厂商活动</a><span class="pcard-h14 pcard-w3 pcard-vr icon-vr" style="width: 30px;"></span><a class="pcard-h14 pcard-w1-a" href="' + (null == (__t = data.jump_url[3]) ? "" : __t) + '" data-label="card_stages">分期买车</a></div>'), 
__p += "</div></div>";
return __p;
},
stock: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) {
if (__p += '<div class="pcard op-stock">', data.length >= 3) {
__p += '<div class="pcard-container pcard-vertical-border opstock-body">';
for (var i in data) {
var _tempStock = data[i];
__p += '<div class="pcard-h16-large opstock-item"><a href="' + (null == (__t = _tempStock.url) ? "" : __t) + '" data-label = "card_detail"><span class="pcard-w1" style="width:64px;">' + (null == (__t = _tempStock.name) ? "" : __t) + "</span>", 
__p += 2 == _tempStock.rise ? '<span class="opstock-txt-up ml15">' + (null == (__t = _tempStock.price) ? "" : __t) + '</span><span class="opstock-txt-up ml15">' + (null == (__t = _tempStock.rate) ? "" : __t) + "</span>" : 3 == _tempStock.rise ? '<span class="opstock-txt-down ml15">' + (null == (__t = _tempStock.price) ? "" : __t) + '</span><span class="opstock-txt-down ml15">' + (null == (__t = _tempStock.rate) ? "" : __t) + "</span>" : '<span class="opstock-txt-stop ml15">' + (null == (__t = _tempStock.price) ? "" : __t) + '</span><span class="opstock-txt-stop ml15">' + (null == (__t = _tempStock.rate) ? "" : __t) + "</span>", 
__p += "</a>", __p += 0 == _tempStock.selected ? '<a class="button pcard-pull-right pcard-w1 opstock-button" data-stock="' + (null == (__t = _tempStock.code) ? "" : __t) + '" action="addStock"><span><i class="pcard-icon opstock-iconfont icon-plus"></i></span>自选股</a>' : '<a class="pcard-pull-right pcard-w3"><span><i class="pcard-icon opstock-iconfont icon-done"></i></span>已添加</a>', 
__p += "</div>";
}
__p += '</div><a class="pcard-w1 pcard-h14 pcard-footer" href="sslocal://webview?hide_bar=1&bounce_disable=1&url=http%3A%2F%2Fic.snssdk.com%2Fstock%2Fget_quota%2F%23tab%3Dportfolio" data-label="card_selected">进入我的自选股<span><i class="pcard-icon opstock-iconfont icon-rarrow opstock-rarrow"></i></span></a>';
} else __p += '<div class="pcard-caption"><span class="pcard-h14 pcard-w1">相关股票</span></div><div class="pcard-container pcard-border opstock-body-single" ><div class="pcard-clearfix"><div class="pcard-pull-left opstock-block ' + (null == (__t = 2 === data[0].rise ? "opstock-upblock" : 3 === data[0].rise ? "opstock-downblock" : "opstock-stopblock") ? "" : __t) + '" data-label="card_content" data-href="' + (null == (__t = data[0].url) ? "" : __t) + '"><div class="opstock-price">' + (null == (__t = 0 === data[0].rise ? "停牌" : data[0].price) ? "" : __t) + '</div><div class="opstock-change">' + (null == (__t = 0 === data[0].rise ? 0 : data[0].change) ? "" : __t) + "(" + (null == (__t = 0 === data[0].rise ? "0.00%" : data[0].rate) ? "" : __t) + ')</div></div><div class="opstock-right opstock-info"><button class="button pcard-button pcard-pull-right opstock-button-single ml8 mt16 ' + (null == (__t = isRedButton ? "red-pcard-button" : "") ? "" : __t) + '" ' + (null == (__t = data[0].selected ? "selected" : "") ? "" : __t) + ' data-stock="' + (null == (__t = data[0].code) ? "" : __t) + '" action="addStock" type=\'single\'><i class="pcard-icon opstock-iconfont icon-plus"></i></button><div class="pcard-h16 pcard-w1 pcard-o1" style="font-weight: bold; margin-top: 8px;" data-label="card_content" data-href="' + (null == (__t = data[0].url) ? "" : __t) + '">' + (null == (__t = data[0].name) ? "" : _.escape(__t)) + '</div><div class="pcard-h14 pcard-w3" style="margin-top: 4px;" data-label="card_content" data-href="' + (null == (__t = data[0].url) ? "" : __t) + '">', 
("HK" == data[0].market || "US" == data[0].market) && (__p += '<i class="pcard-icon opstock-iconfont ' + (null == (__t = "HK" == data[0].market ? "icon-hk" : "icon-us") ? "" : __t) + '"></i>'), 
__p += "" + (null == (__t = data[0].code) ? "" : _.escape(__t)) + '</div></div></div><a class="pcard-w1 pcard-h14 pcard-footer" href="sslocal://webview?hide_bar=1&bounce_disable=1&url=http%3A%2F%2Fic.snssdk.com%2Fstock%2Fget_quota%2F%23tab%3Dportfolio" data-label="card_selected">进入我的自选股<span><i class="pcard-icon opstock-iconfont icon-rarrow opstock-rarrow"></i></span></a></div>';
__p += "</div>";
}
return __p;
},
weitoutiao: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) {
if (__p += '<div class="pcard forum"><div class="pcard-caption"><span class="pcard-h14 pcard-w1">微头条</span></div><div class="p-autocard pcard-container pcard-vertical-border" data-href="' + (null == (__t = data.open_url) ? "" : __t) + '" data-id="' + (null == (__t = data.id) ? "" : __t) + '" data-content="content"><div class="pcard-clearfix"><div class="header"><div class="authorbar" id="profile">', 
__p += '<a class="author-avatar-link"><div class="author-avatar"><img class="author-avatar-img" src="' + (null == (__t = data.user.avatar) ? "" : __t) + '"></div>', 
data.useServerV && data.user.auth && (__p += "" + (null == (__t = buildServerVIcon2(data.user.auth.auth_type, "avatar_icon")) ? "" : __t)), 
__p += '</a><div class="author-bar"><div class="name-link-wrap"><div class="name-link-w"><a class="author-name-link">' + (null == (__t = data.user.name) ? "" : __t) + '</a></div></div><a class="sub-title-w"><span class="sub-title">' + (null == (__t = data.time_disp) ? "" : __t) + (null == (__t = data.user.auth.auth_info && data.time_disp ? "&nbsp;&middot;&nbsp;" : "") ? "" : __t) + (null == (__t = data.user.auth.auth_info) ? "" : __t) + '</span></a></div></div></div><div class="content">', 
data.text && (__p += '<div class="title-outer"><div class="title-wrap"><div class="title"><span class="title-inner">' + (null == (__t = data.text) ? "" : _.escape(__t)) + "</span></div></div></div>"), 
__p += "", "video" == data.content_type) __p += '<div class="images-wrap video" style="width:' + (null == (__t = data.img_width) ? "" : __t) + "px;height:" + (null == (__t = data.img_height) ? "" : __t) + 'px; margin-bottom: 10px;"><div class="images" style="width:' + (null == (__t = data.img_width) ? "" : __t) + "px;height:" + (null == (__t = data.img_height) ? "" : __t) + "px;background-image: url(" + (null == (__t = data.video.cover_url) ? "" : __t) + ');"></div><i class="custom-video-trigger"></i><i class="custom-video-duration"> ' + (null == (__t = data.video.duration_str) ? "" : __t) + " </i></div>"; else if ("image" == data.content_type) {
__p += '<div style="margin-bottom: 10px;">';
for (var i in data.images) {
var tmp_img = data.images[i];
__p += '<div class="images-wrap ' + (null == (__t = 2 == i && data.more_img ? "more_img" : "") ? "" : __t) + '"><div class="images" style="width:' + (null == (__t = data.img_width) ? "" : __t) + "px;height:" + (null == (__t = data.img_height) ? "" : __t) + "px;background-image: url(" + (null == (__t = tmp_img.url) ? "" : __t) + ');"></div>', 
2 == i && data.more_img && (__p += '<span class="has_more">+' + (null == (__t = data.more_img) ? "" : __t) + "</span>"), 
__p += "</div>";
}
__p += "</div>";
}
__p += '<p class="poi">', data.location && (__p += '<span class="location" style="margin-right: 10px;">' + (null == (__t = data.location) ? "" : __t) + "</span>"), 
__p += "<span>" + (null == (__t = data.read_count_tips) ? "" : __t) + "</span></p></div></div></div></div>";
}
return __p;
},
score_star: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="pcard score-star" style="margin-top: 15px;"><div class="p-scorecard pcard-container pcard-vertical-border"><div class="pcard-clearfix score-wrapper"><div class="info-wrapper"><div class="title question pcard-h16 pcard-w1" style="margin-top: 3px;">' + (null == (__t = question) ? "" : __t) + '</div><div class="title thx-letter pcard-h16 pcard-w1" style="margin-top: 2px;">谢谢你为文章打分！</div></div><div class="star-wrap mt11"><span class="star" data-index="0" data-selected="false"></span><span class="star" data-index="1" data-selected="false"></span><span class="star" data-index="2" data-selected="false"></span><span class="star" data-index="3" data-selected="false"></span><span class="star" data-index="4" data-selected="false"></span></div><div class="info pcard-h12 pcard-w1 mt11" style="margin-bottom: 3px;">轻触打分</div></div><div class="pcard-clearfix result-wrapper"><div class="thx-press" style="margin-top: 2px;"><span class="press"></span></div><div class="pcard-h16 pcard-w1 mt8">感谢你的打分，你的打分对我们很重要！</div><a class="rescore-button pcard-h12 pcard-w1">重新打分</a></div></div></div>';
return __p;
},
score_emoji: function(obj) {
var __t, __p = "";
with (Array.prototype.join, obj || {}) __p += '<div class="pcard score-emoji" style="margin-top: 15px"><div class="p-scorecard pcard-container pcard-vertical-top-border"><div class="pcard-clearfix score-wrapper"><div class="title question pcard-h16 pcard-w1" style="margin-top: 3px;">与其他文章相比，你觉得本文如何？</div><div class="emoji-wrap mt10"><div class="good emoji-button" data-index="0" data-score="5" data-type="good" data-status="init"><span class="pcard-icon good-press button"></span><div class="animation-wrapper" id="good-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[0]) ? "" : __t) + '</div></div><div class="general emoji-button" data-index="1" data-score="3" data-type="general" data-status="init"><span class="pcard-icon general-press button"></span><div class="animation-wrapper" id="general-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[1]) ? "" : __t) + '</div></div><div class="bad emoji-button" data-index="2" data-score="1" data-type="bad" data-status="init"><span class="pcard-icon bad-press button"></span><div class="animation-wrapper" id="bad-press-animation"></div><div class="pcard-h12 title">' + (null == (__t = letters[2]) ? "" : __t) + "</div></div></div></div></div></div>";
return __p;
}
};
if ("wenda" === Page.article.type && window.wenda_extra && window.wenda_extra.mis_coop_user && window.wenda_extra.mis_coop_user.uid === Page.author.userId) return void wendaCooperateCard();
var isShowWendaFooter = 1;
return "cards" in context && Array.isArray(context.cards) ? (context.cards.forEach(function(e) {
var t = e.type, a = {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id,
card_type: e.type,
card_id: e.id
}
};
if (t in cardTemplateFunctions) {
if (e.isRedButton = Page.isRedFocusButton, "auto" === t) {
e.data_source_show = {
dongchedi: "懂车帝",
yiche: "易车"
}[e.data_source], e.min_price && e.min_price > 0 && (e.show_origin_price = parseFloat(e.min_price), 
e.show_origin_price = e.show_origin_price.toFixed(2), e.show_origin_price_unit = "万起"), 
e.pd_eries_agent_min_price && e.pd_eries_agent_min_price > 0 && (e.show_agent_price = parseFloat(e.pd_eries_agent_min_price), 
e.show_agent_price = e.show_agent_price.toFixed(2), e.show_agent_price_unit = "万起"), 
/^http/.test(e.xunjia_web_url) && (e.xunjia_web_url = "sslocal://webview?url=" + encodeURIComponent(e.xunjia_web_url)), 
a.extra.data_source = "wenda_extra" in Page ? e.data_source + "_wenda" : e.data_source;
var n = $(cardTemplateFunctions[t]({
data: e
}));
} else if ("stock" == t) {
var i = [], r = [];
try {
r = JSON.parse(e.keyphrase_stock);
} catch (o) {}
if (r.forEach(function(t) {
if (e.stocks[t]) try {
i.push(JSON.parse(e.stocks[t]));
} catch (a) {}
}), 0 == i.length) return;
send_umeng_event("stock", "article_with_card", a);
var s = [];
if (s = i.filter(function(e) {
return 0 == e.selected;
}), 0 == s.length) return;
i.map(function(e) {
e.url = "sslocal://webview?hide_bar=1&bounce_disable=1&url=" + encodeURIComponent("http://ic.snssdk.com/stock/slice/?code=" + e.market + e.code + "&from=article"), 
1 == e.selected && s.push(e);
});
var n = $(cardTemplateFunctions[t]({
data: s,
isRedButton: e.isRedButton
}));
} else if ("weitoutiao" == t) {
e = e.weitoutiao;
try {
e.user.auth = JSON.parse(e.user.auth);
} catch (o) {}
if ("image" === e.content_type && e.images && Array.isArray(e.images)) {
switch (e.images.length) {
case 1:
e.img_width = innerWidth / 2, e.img_height = Math.min(e.images[0].height / e.images[0].width * e.img_width, e.img_width);
break;

case 2:
e.img_width = e.img_height = (innerWidth - 33) / 2;
break;

case 3:
e.img_width = e.img_height = (innerWidth - 36) / 3;
break;

default:
e.img_width = e.img_height = (innerWidth - 36) / 3, e.more_img = e.images.length - 3, 
e.images = e.images.splice(0, 3);
}
e.img_width = Math.floor(e.img_width), e.img_height = Math.floor(e.img_height);
}
"video" === e.content_type && (e.img_width = innerWidth - 30, e.img_height = 9 * e.img_width / 16, 
e.img_width = Math.floor(e.img_width), e.img_height = Math.floor(e.img_height)), 
e.useServerV = Page.useServerV;
var n = $(cardTemplateFunctions[t]({
data: e
}));
} else if ("fiction" == t) {
if ("pgc" === Page.article.type && Page.novel_data && !Page.novel_data.can_read) return;
var n = $(cardTemplateFunctions[t](e));
if (e.benefit_time && e.time_now && e.benefit_time - e.time_now < 86400) {
var l = {
sec: n.find("#sec").get(0),
mini: n.find("#mini").get(0),
hour: n.find("#hour").get(0)
};
fnTimeCountDown(1e3 * e.benefit_time, 1e3 * e.time_now, l, function() {
n.find(".tag").css("display", "none"), n.find(".sale").css("display", "none"), n.find(".sale-price").css("display", "none"), 
n.find(".origin-price").removeClass("pcard-w-delete pcard-w9").addClass("pcard-w1");
});
} else n.find("#day").text(Math.ceil((e.benefit_time - e.time_now) / 86400) + "天");
} else var n = $(cardTemplateFunctions[t](e));
n.on("click", ".button", function(t) {
t.stopPropagation(), send_umeng_event("detail", "click_card_button", a);
var n = $(this), i = n.attr("action");
"concern" === i ? dealNovelButton(t, e, n, a) : "addStock" == i && dealOptionalStockButton(t, n, e, s, a);
}), "auto" === t ? (n.find("[data-label]").on("click", function(e) {
e.stopPropagation(), send_umeng_event("detail", "click_" + this.dataset.label, a);
}), n.find('[type="button"]').on("click", function(e) {
e.stopPropagation(), location.href = this.dataset.href, send_umeng_event("detail", "click_card_button", a);
}), n.on("click", "[data-content]", function() {
location.href = this.dataset.href, send_umeng_event("detail", "click_card_content", a);
})) : "stock" === t ? (n.find('[data-label="card_selected"]').on("click", function(e) {
e.stopPropagation(), send_umeng_event("stock", "article_into_mystock", a);
}), n.find('[data-label="card_detail"]').on("click", function(e) {
e.stopPropagation(), send_umeng_event("stock", "article_into_stock", a);
}), n.find('[data-label="card_content"]').on("click", function(e) {
e.stopPropagation(), location.href = this.dataset.href, send_umeng_event("stock", "article_into_stock", a);
})) : "weitoutiao" === t ? n.on("click", "[data-content]", function() {
send_umeng_event("widget", "go_detail", {
value: this.dataset.id,
extra: {
enter_from: "widget_wtt",
card_type: 1
}
}), location.href = this.dataset.href;
}) : n.on("click", function() {
send_umeng_event("detail", "click_card_content", a);
}), needCleanDoms.push(n), "wenda" === Page.article.type ? (isShowWendaFooter = 0, 
$("footer").append(n)) : $("footer").prepend(n), "weitoutiao" === t && ($(".content .title").width() < $(".content .title-inner").width() && $(".content .title-wrap").before('<div class="whole-forum"><a class="whole-forum-inner">全文</a></div>'), 
sendWeitoutiaoCardDisplayEvent({
needRecord: !0
}), $(document).on("scroll", sendWeitoutiaoCardDisplayEvent), needCleanDoms.push($(document))), 
sendUmengWhenTargetShown(n.get(0), "detail", "card_show", a, !0);
}
}), void ("wenda" === Page.article.type && isShowWendaFooter && processWendaFooter())) : ("wenda" === Page.article.type && isShowWendaFooter && processWendaFooter(), 
void ("pgc" === Page.article.type && !Page.novel_data && Page.h5_settings.score_card_style && processScoreCard()));
}(), function() {
if ("know_more_url" in context) {
var e = $('<p><a href="sslocal://webview?url=' + encodeURIComponent(context.know_more_url) + '&title=%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88">了解更多</a></p>');
$("article").append(e), e.on("click", function() {
send_umeng_event("detail", "click_landingpage", {
value: Page.author.mediaId,
extra: {
item_id: Page.statistics.item_id
}
}), sendUmengEventV3("detail_click_landingpage", {
enter_from: "click_landingpage",
media_id: +Page.author.mediaId,
item_id: +Page.statistics.item_id
}, !0);
}), needCleanDoms.push(e);
}
}(), function() {
var e = function() {
return "wenda" !== Page.article.type ? !0 : client.isAndroid && _isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && _isNewsArticleVersionNoLessThan("6.4.4") ? !0 : !1;
};
"red_pack" in context && context.red_pack && context.red_pack.token && parseInt(context.red_pack.redpack_id) > 0 && (Page.author.hasRedPack = !Page.author.followState && !Page.author.isAuthorSelf, 
Page.author.isFirstPack = context.red_pack.is_first_pack, e() && Page.author.hasRedPack && $(".author-function-buttons").addClass("redpack-button-just-word follow-button-large"), 
"wenda" === Page.article.type && Page.author.hasRedPack && (sendUmengWhenTargetShown($(".subscribe-button")[0], "red_button", "", $.extend({}, wenda_extra.gd_ext_json || {}, {
user_id: Page.author.userId,
action_type: "show",
source: "answer_detail_top_card",
position: "detail"
}), !0, {
version: 3
}), sendUmengWhenTargetShown($(".subscribe-button-bottom")[0], "red_button", "", $.extend({}, wenda_extra.gd_ext_json || {}, {
user_id: Page.author.userId,
action_type: "show",
source: "answer_detail_bottom_card",
position: "detail"
}), !0, {
version: 3
})));
}(), function() {
"car_image_info" in context && ("IOSImageProcessor" in window ? window.IOSImageProcessor.addAutoScript(context.car_image_info) : "AndroidImageProcessor" in window && window.AndroidImageProcessor.addAutoScript(context.car_image_info));
}(), globalCachedContext = null, canSetContext = !1, window.sendTTCustomizeLog && window.sendTTCustomizeLog("end_context_render", +new Date() - startTimestamp));
}, change_following_state = function() {
function e(e) {
var t = $("header"), n = $(".subscribe-button"), i = $(".subscribe-button-bottom");
a = void 0, Page && Page.author && (Page.author.followState = e ? "following" : ""), 
e ? ($(".author-function-buttons").removeClass("redpack-button redpack-button-just-word"), 
n.addClass("following").removeClass("disabled"), t.attr("fbs", "following"), i.addClass("following").removeClass("disabled")) : (n.removeClass("following disabled"), 
t.attr("fbs", ""), t.attr("sugstate", "no"), i.removeClass("following disabled"));
}
var t, a;
return function(n, i, r) {
"function" == typeof r && r(n), i ? n !== a && (clearTimeout(t), a = n, t = setTimeout(e, 450, n, r)) : e(n, r);
};
}(), followSource = {
pgc: 30,
pgc_sug: 34,
forum: 68,
forum_sug: 69,
wenda: 28,
wenda_sug: 71
}, doRecommendUsers = function() {
function e(e, n, i) {
$.ajax({
dataType: "jsonp",
url: "http://ic.snssdk.com/api/2/relation/follow_recommends/",
data: e,
timeout: 1e4,
beforeSend: function() {
return t ? !1 : void (t = !0);
},
success: function(t, r, o) {
"article" in Page && ("success" === t.message && "object" == typeof t.data && Array.isArray(t.data.recommend_users) && t.data.recommend_users.length >= 3 ? (a[e.to_user_id] = t.data.recommend_users, 
domPrepare(), n(t.data.recommend_users)) : i(t, r, o));
},
error: function(e, t, a) {
i(a, t, e);
},
complete: function() {
t = !1;
}
});
}
var t = !1, a = {}, n = {};
return function(t, i, r, o) {
if ("function" == typeof i && "function" == typeof r) {
if (o && o.deleteCache) return void (a[t] && delete a[t]);
if (a[t]) return void i(a[t]);
var s = {
to_user_id: t,
page: 34
};
(client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6")) && $.isEmptyObject(n) ? getCommonParams(function(t) {
n = t.data || t, $.extend(!0, s, n), e(s, i, r);
}) : ($.extend(!0, s, n), e(s, i, r));
}
};
}(), mediasugScroll = function() {
var e, t, a, n = innerWidth, i = 150, r = 0, o = {}, s = 0, l = !1, c = [], d = "in", u = null, p = 0, f = $("header").height() + 232;
return {
init: function(d) {
l || (l = !0, o = d, s = d.length, n = innerWidth, r = s * i + 24, this.imprcache = {}, 
this.imprlog = [], c = [], "pgc" === Page.article.type ? (e = "article", t = Page.statistics.group_id) : "forum" === Page.article.type ? (e = "weitoutiao", 
t = Page.forumStatisticsParams.value) : (e = Page.article.type, t = Page.wenda_extra.ansid), 
this.sendResult = {
imp_group_list_type: 19,
imp_group_key_name: "u11_recommend_user_" + e + "_detail_" + Page.author.userId,
imp_group_key: Page.author.userId,
imp_group_extra: {
source: e,
profile_user_id: Page.author.userId
},
impressions_in: [],
impressions_out: []
}, a = _.throttle(mediasugScroll.handler, 150), f = $("header").height() + 232);
},
range: function(e) {
var t = Math.floor(e / i);
t = Math.max(t, 0), e += n;
var a = Math.ceil(e / i);
a = Math.min(a, s) - 1;
for (var r = []; a >= t; ) r[r.length] = t++;
return r;
},
pushimpr: function(a) {
if (l) {
if (this.sendResult.impressions_in = [], Object.keys(this.imprcache).length > 0) {
this.sendResult.impressions_out = [];
for (var n in this.imprcache) {
var i = this.imprcache[n];
this.imprlog.push({
uid: n,
time: i,
duration: new Date().getTime() - i
}), console.info("leave", n), this.sendResult.impressions_out.push({
imp_item_type: 51,
imp_item_id: n,
imp_item_extra: {}
});
}
this.imprcache = {}, a && ToutiaoJSBridge.call("impression", this.sendResult);
}
console.info("pushimpr", this.imprlog), this.imprlog.length > 0 && (send_umeng_event("detail", "sub_reco_impression_v2", {
value: Page.author.userId,
extra: {
group_id: t,
impression: client.isIOS ? encodeURIComponent(JSON.stringify(mediasugScroll.imprlog)) : mediasugScroll.imprlog,
need_decode: client.isIOS ? 1 : 0,
source: e
}
}), this.imprlog = []);
}
},
dealimpr: function(e, t) {
var a = this, n = [];
if (e.forEach(function(e) {
var t = o[e].user_id;
if (t in a.imprcache) {
var i = a.imprcache[t];
a.imprlog.push({
uid: t,
time: i,
duration: new Date().getTime() - i
}), delete a.imprcache[t], a.sendResult.impressions_in = a.sendResult.impressions_in.filter(function(e) {
return e.imp_item_id != t;
}), n.push({
imp_item_type: 51,
imp_item_id: t,
imp_item_extra: {}
}), console.info("leave", t);
}
}), t.forEach(function(e) {
var t = o[e].user_id;
a.imprcache[t] = new Date().getTime(), a.sendResult.impressions_in.push({
imp_item_type: 51,
imp_item_id: t,
imp_item_extra: {}
}), console.info("enter", t);
}), e.length > 0 || t.length > 0) {
a.sendResult.impressions_out = n;
var i = {};
$.extend(!0, i, a.sendResult), ToutiaoJSBridge.call("impression", i);
}
},
handler: function() {
if (l) {
for (var e = mediasugScroll.range(this.scrollLeft || 0), t = [], a = {}, n = 0; n < c.length; n++) a[c[n]] = !0;
for (n = 0; n < e.length; n++) e[n] in a ? delete a[e[n]] : t.push(e[n]);
var i = Object.keys(a);
mediasugScroll.dealimpr(i, t), c = e;
}
},
open: function() {
c = [], mediasugScroll.handler();
},
pagescroll: function() {
if (l) {
var e = $("#mediasug-list").get(0), t = "in", a = e.getBoundingClientRect();
(a.bottom <= 0 || a.top > (window.innerHeight || document.body.clientHeight)) && (t = "out"), 
"in" === t && "out" === d ? (console.info("IN"), mediasugScroll.dealimpr([], c)) : "out" === t && "in" === d && (console.info("OUT"), 
mediasugScroll.pushimpr(!0)), d = t;
}
},
clearData: function(e) {
l = !1, doRecommendUsers(e, function() {}, function() {}, {
deleteCache: !0
});
},
horizontalScrollLeft: function(e) {
null === u && (u = e);
var t = e - u, a = Math.ceil(p / i) * i - p;
a = 0 === a ? i : a, $("#mediasug-list").scrollLeft(p + Math.min(t / 2, a)), 2 * i > t && requestAnimationFrame(mediasugScroll.horizontalScrollLeft);
},
next: function() {
var e = window.requestAnimationFrame || window.webkitRequestAnimationFrame;
p = $("#mediasug-list").scrollLeft(), console.info("current ", p), u = null, setTimeout(function() {
e(mediasugScroll.horizontalScrollLeft);
}, 400);
},
webviewScroll: function(e) {
if ("open" === $("header").attr("sugstate") && e.rect && !($("body").height() > innerHeight + 232)) {
var t, a, n, i, r, o, s = $("body").height();
if (r = e.rect.substring(1, e.rect.length - 1).split(","), t = r[0], a = Math.abs(r[1]), 
n = r[2], i = r[3], s === innerHeight) o = a >= f ? "out" : "in"; else {
var l = s - innerHeight;
o = a >= f - l ? "out" : "in";
}
"out" === d && "in" === o ? mediasugScroll.dealimpr([], c) : "in" === d && "out" === o && mediasugScroll.pushimpr(!0), 
d = o;
}
}
};
}(), subscribeTimeoutTimer, checkHeaderDisplayed = checkDisplayedFactory("#profile", "showTitleBarPgcLayout"), checkWendanextDisplayed = checkDisplayedFactory(".serial", "showWendaNextLayout"), checkWendaABHeaderLayout = checkDisplayedFactory(".wenda-title", "showWendaABHeaderLayout"), canSetContext = !1, globalContent, globalCachedContext = null, globalContext, needCleanDoms = [], imprProcessQueue = [];

window.Page = {}, window.OldPage = null, window.globalExtras = {};

var AndroidImageProcessor = {
warpStandNative: function() {
this.pictures.forEach(function(e, t) {
var a = e.holder, n = a.parentNode;
"P" === n.tagName ? "" !== n.textContent ? (console.info("[" + t + "]所在段落有文本，应当分割"), 
__w(n, a, "span")) : n.querySelectorAll(".image").length > 1 ? (console.info("[" + t + "]所在段落有其他图片，应当分割"), 
__w(n, a, "span")) : (console.info("[" + t + "]正确"), n.classList.add("image-wrap")) : (console.info("[" + t + "]直接加包裹"), 
__w(n, a, "p"));
});
},
start: function() {
var e = document.querySelectorAll("a.image");
if (e = Array.prototype.slice.call(e), this.pictures = [], this.allPicturesCount = e.length, 
this.currentViewing = {}, this.loadedOrigins = 0, this.isSeeOriginsButtonShown = !1, 
0 !== this.allPicturesCount) {
if (this.threadGGSwitch && (this.useLazyload = !1, "none" !== this.imageType && (this.imageType = 1 === this.allPicturesCount ? "origin" : "list400")), 
this.isDuoTuThread = this.threadGGSwitch && this.allPicturesCount > 1, this.threadImageType = this.isDuoTuThread ? "list400" : this.threadGGSwitch ? "origin" : this.imageType, 
this.allPicturesCount > 10 && (this.useLazyload = !0), this.pictures = e.map(function(e, t) {
var a, n = e.getAttribute("type") || "", i = +e.getAttribute("width") || 0, r = +e.getAttribute("height") || 0, o = +e.getAttribute("thumb_width") || 0, s = +e.getAttribute("thumb_height") || 0, l = e.getAttribute("zip_src_path") || "";
a = [ "origin", "none" ].indexOf(AIP.imageType) > -1 ? [ i, r ] : [ o, s ];
var c = {
index: t,
holder: e,
state: AIP.imageType,
url: "",
lastUrl: "",
zsp: l,
href: e.getAttribute("href") || "",
link: e.getAttribute("redirect-link") || "",
isGIF: "gif" === n || "2" === n,
isLONG: i > 3 * r || r > 3 * i,
holderSize: a,
bigArea: i * r,
smallArea: o * s,
autoscript: null
};
return c;
}), !this.threadGGSwitch && "origin" !== this.imageType) {
this.isSeeOriginsButtonShown = !0;
var t = document.createElement("div");
t.innerHTML = '<div class="toggle-img" id="toggle-img">显示大图</div>', t.addEventListener("click", function() {
AIP.showAllOriginImages(), sendBytedanceRequest("toggle_image?action=show"), this.style.visibility = "hidden";
}), e[0].parentNode.insertBefore(t, e[0]);
}
this.threadGGSwitch || this.warpStandNative(), this.useLazyload ? (this.renderAllHolders(!0, !0), 
document.removeEventListener("scroll", this._pollImages), document.addEventListener("scroll", this._pollImages, !1), 
this._pollImages()) : this.renderAllHolders(!0, !1);
}
},
showAllOriginImages: function() {
AIP.pictures.forEach(function(e) {
e.state = "origin", e.url && (e.url = __buildGetImageSource("origin", e.zsp, e.index), 
AIP.renderHolder(e));
});
},
_pollImages: function() {
clearTimeout(AIP._pollImagesTimer), AIP._pollImagesTimer = setTimeout(AIP._pollImagesHandler, 100);
},
_pollImagesHandler: function() {
var e = AIP.pictures.every(function(e) {
if ("" !== e.url) return !0;
var t = e.holder.getBoundingClientRect().top;
return console.info("pooling", e.index, t), 0 > t || (t >= 0 && t) <= 2 * window.iH ? (e.url = __buildGetImageSource(e.state, e.zsp, e.index), 
AIP.renderHolder(e), !0) : !1;
});
e && (console.info("所有图片已加载完毕，取消懒加载事件监听"), document.removeEventListener("scroll", AIP._pollImages));
},
renderAllHolders: function(e, t, a) {
console.info("[renderAllHolders]", e, t, a);
var n = this.pictures;
n.forEach(t ? function(t) {
AIP.renderHolder(t, e, a);
} : function(t) {
t.url = __buildGetImageSource(t.state, t.zsp, t.index), AIP.renderHolder(t, e, a);
});
},
renderHolder: function(e, t, a) {
var n = e.holder;
if (t) {
n.setAttribute("index", e.index), n.removeAttribute("href");
var i = document.createDocumentFragment(), r = document.createElement("img");
r.classList.add("opacity-zero"), r.onload = AIP.onLoad, r.onerror = AIP.onError, 
i.appendChild(r);
var o = document.createElement("i");
if (e.isGIF ? (o.setAttribute("class", "image-subscript gif-subscript"), o.textContent = "GIF", 
i.appendChild(o)) : e.isLONG && this.isDuoTuThread ? (o.setAttribute("class", "image-subscript long-subscript"), 
o.textContent = "长图", i.appendChild(o)) : e.autoscript && (o.setAttribute("class", "image-subscript autoscript"), 
o.innerHTML = '<span class="ovf">' + e.autoscript.series_name + "</span><span>" + e.autoscript.price + '</span><span class="sx">&#xe60a;</span><span>查看详情</span>', 
o.dataset.href = e.autoscript.open_url, i.appendChild(o)), "origin" !== e.state) {
var s = document.createElement("i");
s.classList.add("spinner"), i.appendChild(s);
}
n.appendChild(i);
} else r = n.querySelector("img");
if (a) if (e.isGIF) ; else if (e.isLONG && this.isDuoTuThread) ; else if (e.autoscript) {
var o = document.createElement("i");
o.setAttribute("class", "image-subscript autoscript"), o.innerHTML = '<span class="ovf">' + e.autoscript.series_name + "</span><span>" + e.autoscript.price + '</span><span class="sx">&#xe60a;</span><span>查看详情</span>', 
o.dataset.href = e.autoscript.open_url, n.appendChild(o);
}
var l = __adjustOriginImageScale(e.holderSize, "none" === e.state);
console.info("__adjustOriginImageScale", e.holderSize, l[0], l[1]), n.style.width = l[0] + "px", 
n.style.height = l[1] + "px", n.setAttribute("bg", l[0] > 140 && l[1] > 44), AIP.threadGGSwitch && 1 === AIP.allPicturesCount && (n.parentNode.style.paddingTop = 0, 
n.parentNode.style.height = l[1] + "px"), !e.url || e.lastUrl && e.lastUrl === e.url || (console.info("URL_NOT_EQUAL", e.lastUrl, e.url), 
r.src = e.lastUrl = e.url), n.setAttribute("state", e.state);
},
onError: function() {
this.classList.add("opacity-zero"), console.info("[onError]", this);
},
onLoad: function() {
console.info("[onLoad]", this), this.classList.remove("opacity-zero");
var e = this.parentNode, t = e.getAttribute("index"), a = AIP.pictures[t], n = this.naturalWidth * this.naturalHeight, i = Math.abs(a.bigArea - n), r = Math.abs(a.smallArea - n);
if (console.info(n, i, r), a.holderSize = [ this.naturalWidth, this.naturalHeight ], 
AIP.threadGGSwitch ? a.state = AIP.threadImageType : i > r ? a.state = "thumb" : (a.state = "origin", 
AIP.loadedOrigins++), AIP.renderHolder(a), a.holder.classList.remove("animation"), 
AIP.loadedOrigins === AIP.allPicturesCount) {
var o = document.getElementById("toggle-img");
o && (o.style.visibility = "hidden");
}
},
tapEventHandler: function(e) {
e.preventDefault();
var t = this.getAttribute("index"), a = AIP.pictures[t];
if ("origin" === a.state || AIP.isDuoTuThread) {
if (a.link && a.link.indexOf("sslocal") > -1) location.href = a.link; else if (a.href.indexOf("bytedance://large_image") > -1) {
var n = a.holder.getBoundingClientRect(), i = "&left=" + (n.left + window.pageXOffset) + "&top=" + (n.top + window.pageYOffset) + "&width=" + Math.floor(n.width) + "&height=" + Math.floor(n.height);
location.href = a.href + i;
}
} else a.url = __buildGetImageSource("origin", a.zsp, a.index), a.state = "origin", 
a.holder.classList.add("animation"), AIP.renderHolder(a);
},
onNativeImageLoaded: function(e, t, a) {
console.info("[onNativeImageLoaded]", e, t, a);
var n = AIP.pictures[e];
n && t && (n.state = AIP.threadGGSwitch ? AIP.threadImageType : a ? "origin" : "thumb", 
n.url = __buildImageSource(n.state, n.zsp), AIP.renderHolder(n));
},
bindEvents: function() {
console.info("AIP.bindEvents"), $(document.body).on("click", ".image", function(e) {
var t = nz_closest(e.target, ".autoscript");
return t ? (send_umeng_event("detail", "pic_card_click", {
value: +Page.statistics.group_id
}), sendUmengEventV3("clk_event", {
obj_id: "page_detail_pic_tag",
group_id: Page.statistics.group_id
}, !0), location.href = t.dataset.href, !1) : void AIP.tapEventHandler.call(this, e);
});
},
addAutoScript: function(e) {
if (Array.isArray(AIP.pictures)) {
for (var t in e) {
var a = +t;
AIP.pictures[a] && (AIP.pictures[a].autoscript = e[t]);
}
AIP.renderAllHolders(!1, !0, !0), setTimeout(function() {
if (Array.isArray(AIP.pictures)) for (var t in e) {
var a = AIP.pictures[+t];
if (a && a.holder) {
var n = a.holder.querySelector(".autoscript");
n && send_exposure_event_once(n, function() {
Page.statistics && (send_umeng_event("detail", "pic_card_show", {
value: Page.statistics.group_id
}), sendUmengEventV3("show_event", {
obj_id: "page_detail_pic_tag",
group_id: Page.statistics.group_id
}, !0));
}, !0);
}
}
}, 200);
}
}
};

window.AIP = AndroidImageProcessor, window.image_load_cb = AIP.onNativeImageLoaded;

var NativePlayGif = {
clean: function() {},
willStart: function(e) {
"function" == typeof e && e();
},
ended: function() {}
};

!function() {
bindStatisticsEvents(), bindStatisticsEvents23(), tellClientContentSize(), checkHeaderDisplayed(), 
AndroidImageProcessor.bindEvents();
}(), !function(e) {
function t(a) {
if (n[a]) return n[a].exports;
var i = n[a] = {
i: a,
l: !1,
exports: {}
};
return e[a].call(i.exports, i, i.exports, t), i.l = !0, i.exports;
}
var a = window.webpackJsonp;
window.webpackJsonp = function(t, n, r) {
for (var o, s, l = 0, c = []; l < t.length; l++) s = t[l], i[s] && c.push(i[s][0]), 
i[s] = 0;
for (o in n) Object.prototype.hasOwnProperty.call(n, o) && (e[o] = n[o]);
for (a && a(t, n, r); c.length; ) c.shift()();
};
var n = {}, i = {
1: 0
};
t.e = function(e) {
function a() {
s.onerror = s.onload = null, clearTimeout(l);
var t = i[e];
0 !== t && (t && t[1](new Error("Loading chunk " + e + " failed.")), i[e] = void 0);
}
var n = i[e];
if (0 === n) return new Promise(function(e) {
e();
});
if (n) return n[2];
var r = new Promise(function(t, a) {
n = i[e] = [ t, a ];
});
n[2] = r;
var o = document.getElementsByTagName("head")[0], s = document.createElement("script");
s.type = "text/javascript", s.charset = "utf-8", s.async = !0, s.timeout = 12e4, 
t.nc && s.setAttribute("nonce", t.nc), s.src = t.p + "" + ({
0: "component"
}[e] || e) + "." + {
0: "bbd73af8e102627cd57b"
}[e] + ".js";
var l = setTimeout(a, 12e4);
return s.onerror = s.onload = a, o.appendChild(s), r;
}, t.m = e, t.c = n, t.i = function(e) {
return e;
}, t.d = function(e, a, n) {
t.o(e, a) || Object.defineProperty(e, a, {
configurable: !1,
enumerable: !0,
get: n
});
}, t.n = function(e) {
var a = e && e.__esModule ? function() {
return e.default;
} : function() {
return e;
};
return t.d(a, "a", a), a;
}, t.o = function(e, t) {
return Object.prototype.hasOwnProperty.call(e, t);
}, t.p = "https://s2.pstatp.com/pgc/v2/resource/card/", t.oe = function(e) {
throw console.error(e), e;
}, t(t.s = 30);
}([ function(e, t, a) {
"use strict";
Object.defineProperty(t, "__esModule", {
value: !0
}), function(e) {
function n() {
return null;
}
function i(e) {
var t = e.nodeName, a = e.attributes;
e.attributes = {}, t.defaultProps && b(e.attributes, t.defaultProps), a && b(e.attributes, a);
}
function r(e, t) {
var a, n, i;
if (t) {
for (i in t) if (a = W.test(i)) break;
if (a) {
n = e.attributes = {};
for (i in t) t.hasOwnProperty(i) && (n[W.test(i) ? i.replace(/([A-Z0-9])/, "-$1").toLowerCase() : i] = t[i]);
}
}
}
function o(e, t, n) {
var i = t && t._preactCompatRendered && t._preactCompatRendered.base;
i && i.parentNode !== t && (i = null), !i && t && (i = t.firstElementChild);
for (var r = t.childNodes.length; r--; ) t.childNodes[r] !== i && t.removeChild(t.childNodes[r]);
var o = a.i(D.c)(e, t, i);
return t && (t._preactCompatRendered = o && (o._component || {
base: o
})), "function" == typeof n && n(), o && o._component || o;
}
function s(e, t, n, i) {
var r = a.i(D.a)(K, {
context: e.context
}, t), s = o(r, n), l = s._component || s.base;
return i && i.call(l, s), l;
}
function l(e) {
var t = e._preactCompatRendered && e._preactCompatRendered.base;
return !(!t || t.parentNode !== e || (a.i(D.c)(a.i(D.a)(n), e, t), 0));
}
function c(e) {
return f.bind(null, e);
}
function d(e, t) {
for (var a = t || 0; a < e.length; a++) {
var n = e[a];
Array.isArray(n) ? d(n) : n && "object" == typeof n && !g(n) && (n.props && n.type || n.attributes && n.nodeName || n.children) && (e[a] = f(n.type || n.nodeName, n.props || n.attributes, n.children));
}
}
function u(e) {
return "function" == typeof e && !(e.prototype && e.prototype.render);
}
function _(e) {
return S({
displayName: e.displayName || e.name,
render: function() {
return e(this.props, this.context);
}
});
}
function p(e) {
var t = e[z];
return t ? !0 === t ? e : t : (t = _(e), Object.defineProperty(t, z, {
configurable: !0,
value: !0
}), t.displayName = e.displayName, t.propTypes = e.propTypes, t.defaultProps = e.defaultProps, 
Object.defineProperty(e, z, {
configurable: !0,
value: t
}), t);
}
function f() {
for (var e = [], t = arguments.length; t--; ) e[t] = arguments[t];
return d(e, 2), h(D.a.apply(void 0, e));
}
function h(e) {
e.preactCompatNormalized = !0, y(e), u(e.nodeName) && (e.nodeName = p(e.nodeName));
var t = e.attributes.ref, a = t && typeof t;
return !X || "string" !== a && "number" !== a || (e.attributes.ref = v(t, X)), w(e), 
e;
}
function m(e, t) {
for (var n = [], i = arguments.length - 2; i-- > 0; ) n[i] = arguments[i + 2];
if (!g(e)) return e;
var r = e.attributes || e.props, o = a.i(D.a)(e.nodeName || e.type, r, e.children || r && r.children), s = [ o, t ];
return n && n.length ? s.push(n) : t && t.children && s.push(t.children), h(D.d.apply(void 0, s));
}
function g(e) {
return e && (e instanceof G || e.$$typeof === V);
}
function v(e, t) {
return t._refProxies[e] || (t._refProxies[e] = function(a) {
t && t.refs && (t.refs[e] = a, null === a && (delete t._refProxies[e], t = null));
});
}
function w(e) {
var t = e.nodeName, a = e.attributes;
if (a && "string" == typeof t) {
var n = {};
for (var i in a) n[i.toLowerCase()] = i;
if (n.ondoubleclick && (a.ondblclick = a[n.ondoubleclick], delete a[n.ondoubleclick]), 
n.onchange && ("textarea" === t || "input" === t.toLowerCase() && !/^fil|che|rad/i.test(a.type))) {
var r = n.oninput || "oninput";
a[r] || (a[r] = I([ a[r], a[n.onchange] ]), delete a[n.onchange]);
}
}
}
function y(e) {
var t = e.attributes || (e.attributes = {});
nt.enumerable = "className" in t, t.className && (t.class = t.className), Object.defineProperty(t, "className", nt);
}
function b(e) {
for (var t = arguments, a = 1, n = void 0; a < arguments.length; a++) if (n = t[a]) for (var i in n) n.hasOwnProperty(i) && (e[i] = n[i]);
return e;
}
function x(e, t) {
for (var a in e) if (!(a in t)) return !0;
for (var n in t) if (e[n] !== t[n]) return !0;
return !1;
}
function k(e) {
return e && e.base || e;
}
function P() {}
function S(e) {
function t(e, t) {
A(this), B.call(this, e, t, J), N.call(this, e, t);
}
return e = b({
constructor: t
}, e), e.mixins && C(e, T(e.mixins)), e.statics && b(t, e.statics), e.propTypes && (t.propTypes = e.propTypes), 
e.defaultProps && (t.defaultProps = e.defaultProps), e.getDefaultProps && (t.defaultProps = e.getDefaultProps()), 
P.prototype = B.prototype, t.prototype = b(new P(), e), t.displayName = e.displayName || "Component", 
t;
}
function T(e) {
for (var t = {}, a = 0; a < e.length; a++) {
var n = e[a];
for (var i in n) n.hasOwnProperty(i) && "function" == typeof n[i] && (t[i] || (t[i] = [])).push(n[i]);
}
return t;
}
function C(e, t) {
for (var a in t) t.hasOwnProperty(a) && (e[a] = I(t[a].concat(e[a] || Z), "getDefaultProps" === a || "getInitialState" === a || "getChildContext" === a));
}
function A(e) {
for (var t in e) {
var a = e[t];
"function" != typeof a || a.__bound || H.hasOwnProperty(t) || ((e[t] = a.bind(e)).__bound = !0);
}
}
function E(e, t, a) {
return "string" == typeof t && (t = e.constructor.prototype[t]), "function" == typeof t ? t.apply(e, a) : void 0;
}
function I(e, t) {
return function() {
for (var a, n = arguments, i = this, r = 0; r < e.length; r++) {
var o = E(i, e[r], n);
if (t && null != o) {
a || (a = {});
for (var s in o) o.hasOwnProperty(s) && (a[s] = o[s]);
} else void 0 !== o && (a = o);
}
return a;
};
}
function N(e, t) {
$.call(this, e, t), this.componentWillReceiveProps = I([ $, this.componentWillReceiveProps || "componentWillReceiveProps" ]), 
this.render = I([ $, j, this.render || "render", O ]);
}
function $(e) {
if (e) {
var t = e.children;
if (t && Array.isArray(t) && 1 === t.length && ("string" == typeof t[0] || "function" == typeof t[0] || t[0] instanceof G) && (e.children = t[0], 
e.children && "object" == typeof e.children && (e.children.length = 1, e.children[0] = e.children)), 
q) {
var a = "function" == typeof this ? this : this.constructor, n = this.propTypes || a.propTypes, i = this.displayName || a.name;
n && M.a.checkPropTypes(n, e, "prop", i);
}
}
}
function j() {
X = this;
}
function O() {
X === this && (X = null);
}
function B(e, t, a) {
D.e.call(this, e, t), this.state = this.getInitialState ? this.getInitialState() : {}, 
this.refs = {}, this._refProxies = {}, a !== J && N.call(this, e, t);
}
function L(e, t) {
B.call(this, e, t);
}
a.d(t, "version", function() {
return F;
}), a.d(t, "DOM", function() {
return tt;
}), a.d(t, "Children", function() {
return et;
}), a.d(t, "render", function() {
return o;
}), a.d(t, "createClass", function() {
return S;
}), a.d(t, "createFactory", function() {
return c;
}), a.d(t, "createElement", function() {
return f;
}), a.d(t, "cloneElement", function() {
return m;
}), a.d(t, "isValidElement", function() {
return g;
}), a.d(t, "findDOMNode", function() {
return k;
}), a.d(t, "unmountComponentAtNode", function() {
return l;
}), a.d(t, "Component", function() {
return B;
}), a.d(t, "PureComponent", function() {
return L;
}), a.d(t, "unstable_renderSubtreeIntoContainer", function() {
return s;
}), a.d(t, "__spread", function() {
return b;
});
var R = a(26), M = a.n(R), D = a(23);
a.d(t, "PropTypes", function() {
return M.a;
});
var F = "15.1.0", U = "a abbr address area article aside audio b base bdi bdo big blockquote body br button canvas caption cite code col colgroup data datalist dd del details dfn dialog div dl dt em embed fieldset figcaption figure footer form h1 h2 h3 h4 h5 h6 head header hgroup hr html i iframe img input ins kbd keygen label legend li link main map mark menu menuitem meta meter nav noscript object ol optgroup option output p param picture pre progress q rp rt ruby s samp script section select small source span strong style sub summary sup table tbody td textarea tfoot th thead time title tr track u ul var video wbr circle clipPath defs ellipse g image line linearGradient mask path pattern polygon polyline radialGradient rect stop svg text tspan".split(" "), V = "undefined" != typeof Symbol && Symbol.for && Symbol.for("react.element") || 60103, z = "undefined" != typeof Symbol ? Symbol.for("__preactCompatWrapper") : "__preactCompatWrapper", H = {
constructor: 1,
render: 1,
shouldComponentUpdate: 1,
componentWillReceiveProps: 1,
componentWillUpdate: 1,
componentDidUpdate: 1,
componentWillMount: 1,
componentDidMount: 1,
componentWillUnmount: 1,
componentDidUnmount: 1
}, W = /^(?:accent|alignment|arabic|baseline|cap|clip|color|fill|flood|font|glyph|horiz|marker|overline|paint|stop|strikethrough|stroke|text|underline|unicode|units|v|vector|vert|word|writing|x)[A-Z]/, J = {}, q = void 0 === e || !a.i({
NODE_ENV: "production"
}) || !1, G = a.i(D.a)("a", null).constructor;
G.prototype.$$typeof = V, G.prototype.preactCompatUpgraded = !1, G.prototype.preactCompatNormalized = !1, 
Object.defineProperty(G.prototype, "type", {
get: function() {
return this.nodeName;
},
set: function(e) {
this.nodeName = e;
},
configurable: !0
}), Object.defineProperty(G.prototype, "props", {
get: function() {
return this.attributes;
},
set: function(e) {
this.attributes = e;
},
configurable: !0
});
var Q = D.b.event;
D.b.event = function(e) {
return Q && (e = Q(e)), e.persist = Object, e.nativeEvent = e, e;
};
var Y = D.b.vnode;
D.b.vnode = function(e) {
if (!e.preactCompatUpgraded) {
e.preactCompatUpgraded = !0;
var t = e.nodeName, a = e.attributes = b({}, e.attributes);
"function" == typeof t ? (!0 === t[z] || t.prototype && "isReactComponent" in t.prototype) && (e.children && "" === String(e.children) && (e.children = void 0), 
e.children && (a.children = e.children), e.preactCompatNormalized || h(e), i(e)) : (e.children && "" === String(e.children) && (e.children = void 0), 
e.children && (a.children = e.children), a.defaultValue && (a.value || 0 === a.value || (a.value = a.defaultValue), 
delete a.defaultValue), r(e, a));
}
Y && Y(e);
};
var K = function() {};
K.prototype.getChildContext = function() {
return this.props.context;
}, K.prototype.render = function(e) {
return e.children[0];
};
for (var X, Z = [], et = {
map: function(e, t, a) {
return null == e ? null : (e = et.toArray(e), a && a !== e && (t = t.bind(a)), e.map(t));
},
forEach: function(e, t, a) {
return null == e ? null : (e = et.toArray(e), a && a !== e && (t = t.bind(a)), void e.forEach(t));
},
count: function(e) {
return e && e.length || 0;
},
only: function(e) {
if (e = et.toArray(e), 1 !== e.length) throw new Error("Children.only() expects only one child.");
return e[0];
},
toArray: function(e) {
return null == e ? [] : Z.concat(e);
}
}, tt = {}, at = U.length; at--; ) tt[U[at]] = c(U[at]);
var nt = {
configurable: !0,
get: function() {
return this.class;
},
set: function(e) {
this.class = e;
}
};
b(B.prototype = new D.e(), {
constructor: B,
isReactComponent: {},
replaceState: function(e, t) {
var a = this;
this.setState(e, t);
for (var n in a.state) n in e || delete a.state[n];
},
getDOMNode: function() {
return this.base;
},
isMounted: function() {
return !!this.base;
}
}), P.prototype = B.prototype, L.prototype = new P(), L.prototype.isPureReactComponent = !0, 
L.prototype.shouldComponentUpdate = function(e, t) {
return x(this.props, e) || x(this.state, t);
};
var it = {
version: F,
DOM: tt,
PropTypes: M.a,
Children: et,
render: o,
createClass: S,
createFactory: c,
createElement: f,
cloneElement: m,
isValidElement: g,
findDOMNode: k,
unmountComponentAtNode: l,
Component: B,
PureComponent: L,
unstable_renderSubtreeIntoContainer: s,
__spread: b
};
t.default = it;
}.call(t, a(5));
}, function() {}, function(e, t) {
"use strict";
function a(e, t) {
if (t(e), e.firstChild) {
var n = e.firstChild;
if (n) do a(n, t); while (n = n.nextSibling);
}
}
function n(e) {
for (var t = {}, a = 0, n = e.length; n > a; a++) t[e[a].name] = e[a].value;
return t;
}
function i(e) {
for (var t = {}, a = e.attributes, n = e.dataset, i = 0, r = a.length; r > i; i++) "class" !== a[i].name && (t[a[i].name] = a[i].value);
for (var i in n) t[i] = n[i];
return t;
}
function r(e) {
e = e.toLowerCase();
var t = /\b(\w)|\s(\w)/g;
return e.replace(t, function(e) {
return e.toUpperCase();
});
}
function o(e) {
var t = e % 60;
return parseInt(e / 60) + ":" + (10 > t ? "0" + t : t);
}
Object.defineProperty(t, "__esModule", {
value: !0
}), t.default = {
map: a,
attr: n,
buildAttrs: i,
firstUpper: r,
formatTime: o
};
}, function(e) {
var t = {
utf8: {
stringToBytes: function(e) {
return t.bin.stringToBytes(unescape(encodeURIComponent(e)));
},
bytesToString: function(e) {
return decodeURIComponent(escape(t.bin.bytesToString(e)));
}
},
bin: {
stringToBytes: function(e) {
for (var t = [], a = 0; a < e.length; a++) t.push(255 & e.charCodeAt(a));
return t;
},
bytesToString: function(e) {
for (var t = [], a = 0; a < e.length; a++) t.push(String.fromCharCode(e[a]));
return t.join("");
}
}
};
e.exports = t;
}, function(e, t) {
var a, n, i;
!function(r, o) {
n = [ t, e ], a = o, void 0 !== (i = "function" == typeof a ? a.apply(t, n) : a) && (e.exports = i);
}(0, function(e, t) {
"use strict";
function a() {
return "jsonp_" + Date.now() + "_" + Math.ceil(1e5 * Math.random());
}
function n(e) {
try {
delete window[e];
} catch (t) {
window[e] = void 0;
}
}
function i(e) {
var t = document.getElementById(e);
t && document.getElementsByTagName("head")[0].removeChild(t);
}
function r(e) {
var t = arguments.length <= 1 || void 0 === arguments[1] ? {} : arguments[1], r = e, s = t.timeout || o.timeout, l = t.jsonpCallback || o.jsonpCallback, c = void 0;
return new Promise(function(o, d) {
var u = t.jsonpCallbackFunction || a(), _ = l + "_" + u;
window[u] = function(e) {
o({
ok: !0,
json: function() {
return Promise.resolve(e);
}
}), c && clearTimeout(c), i(_), n(u);
}, r += -1 === r.indexOf("?") ? "?" : "&";
var p = document.createElement("script");
p.setAttribute("src", "" + r + l + "=" + u), t.charset && p.setAttribute("charset", t.charset), 
p.id = _, document.getElementsByTagName("head")[0].appendChild(p), c = setTimeout(function() {
d(new Error("JSONP request to " + e + " timed out")), n(u), i(_);
}, s), p.onerror = function() {
d(new Error("JSONP request to " + e + " failed")), n(u), i(_), c && clearTimeout(c);
};
});
}
var o = {
timeout: 5e3,
jsonpCallback: "callback",
jsonpCallbackFunction: null
};
t.exports = r;
});
}, function(e) {
function t() {
throw new Error("setTimeout has not been defined");
}
function a() {
throw new Error("clearTimeout has not been defined");
}
function n(e) {
if (c === setTimeout) return setTimeout(e, 0);
if ((c === t || !c) && setTimeout) return c = setTimeout, setTimeout(e, 0);
try {
return c(e, 0);
} catch (a) {
try {
return c.call(null, e, 0);
} catch (a) {
return c.call(this, e, 0);
}
}
}
function i(e) {
if (d === clearTimeout) return clearTimeout(e);
if ((d === a || !d) && clearTimeout) return d = clearTimeout, clearTimeout(e);
try {
return d(e);
} catch (t) {
try {
return d.call(null, e);
} catch (t) {
return d.call(this, e);
}
}
}
function r() {
f && _ && (f = !1, _.length ? p = _.concat(p) : h = -1, p.length && o());
}
function o() {
if (!f) {
var e = n(r);
f = !0;
for (var t = p.length; t; ) {
for (_ = p, p = []; ++h < t; ) _ && _[h].run();
h = -1, t = p.length;
}
_ = null, f = !1, i(e);
}
}
function s(e, t) {
this.fun = e, this.array = t;
}
function l() {}
var c, d, u = e.exports = {};
!function() {
try {
c = "function" == typeof setTimeout ? setTimeout : t;
} catch (e) {
c = t;
}
try {
d = "function" == typeof clearTimeout ? clearTimeout : a;
} catch (e) {
d = a;
}
}();
var _, p = [], f = !1, h = -1;
u.nextTick = function(e) {
var t = new Array(arguments.length - 1);
if (arguments.length > 1) for (var a = 1; a < arguments.length; a++) t[a - 1] = arguments[a];
p.push(new s(e, t)), 1 !== p.length || f || n(o);
}, s.prototype.run = function() {
this.fun.apply(null, this.array);
}, u.title = "browser", u.browser = !0, u.env = {}, u.argv = [], u.version = "", 
u.versions = {}, u.on = l, u.addListener = l, u.once = l, u.off = l, u.removeListener = l, 
u.removeAllListeners = l, u.emit = l, u.prependListener = l, u.prependOnceListener = l, 
u.listeners = function() {
return [];
}, u.binding = function() {
throw new Error("process.binding is not supported");
}, u.cwd = function() {
return "/";
}, u.chdir = function() {
throw new Error("process.chdir is not supported");
}, u.umask = function() {
return 0;
};
}, function(e) {
var t;
t = function() {
return this;
}();
try {
t = t || Function("return this")() || (0, eval)("this");
} catch (e) {
"object" == typeof window && (t = window);
}
e.exports = t;
}, function(e, t, a) {
"use strict";
function n(e) {
return e && e.__esModule ? e : {
"default": e
};
}
var i = a(16), r = n(i), o = a(24), s = n(o);
!function() {
window.Promise || (window.Promise = s.default), pgcEvent.on("card-render", function() {
var e = {};
document.querySelector("body"), r.default.init({
match: /^(tt-|pre)/i,
text: /^{!--.*--}/,
context: e
}).render(this);
});
}(), window.ttCard = r.default || {};
}, function(e, t, a) {
"use strict";
function n(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function i(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function r(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var o = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), s = a(0), l = function(e) {
return e && e.__esModule ? e : {
"default": e
};
}(s), c = function(e) {
function t(e) {
n(this, t);
var a = i(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e));
return a.state = {
show: !0
}, a.show = function() {
a.setState({
show: !0
});
}, a.cancel = function(e) {
e.preventDefault(), a.props.onCancel(), a.setState({
show: !1
});
}, a;
}
return r(t, e), o(t, [ {
key: "render",
value: function() {
var e = this, t = this.state.show, a = this.props.phone;
return t ? l.default.createElement("div", {
className: "phone-confirm"
}, l.default.createElement("div", {
className: "main"
}, l.default.createElement("div", null, "联系电话"), l.default.createElement("div", null, a)), l.default.createElement("div", {
className: "footer"
}, l.default.createElement("div", {
className: "btn-group"
}, l.default.createElement("a", {
className: "btn",
onClick: function(t) {
return e.cancel(t);
}
}, "取消"), l.default.createElement("a", {
className: "btn",
href: "tel:" + a
}, "呼叫")))) : null;
}
} ]), t;
}(s.Component);
t.default = c;
}, function(e, t, a) {
"use strict";
function n(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function i(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function r(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var o = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), s = a(0), l = function(e) {
return e && e.__esModule ? e : {
"default": e
};
}(s), c = function(e) {
function t(e) {
n(this, t);
var a = i(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e));
return a.play.bind(a), a.pause.bind(a), a;
}
return r(t, e), o(t, [ {
key: "play",
value: function() {
this.audio.play();
}
}, {
key: "pause",
value: function() {
this.audio.pause();
}
}, {
key: "render",
value: function() {
var e = this;
return l.default.createElement("audio", {
autoPlay: this.props.autoPlay,
className: "audio-player " + this.props.className,
controls: this.props.controls,
loop: this.props.loop,
muted: this.props.muted,
onPlay: this.props.onPlay,
preload: this.props.preload,
ref: function(t) {
e.audio = t;
},
src: this.props.src,
style: this.props.style
});
}
}, {
key: "componentDidMount",
value: function() {
var e = this, t = this.audio;
t.addEventListener("error", function(t) {
e.props.onError(t);
}), t.addEventListener("canplay", function(t) {
e.props.onCanPlay(t);
}), t.addEventListener("canplaythrough", function(t) {
e.props.onCanPlayThrough(t);
}), t.addEventListener("play", function(t) {
e.setListenTrack(), e.props.onPlay(t);
}), t.addEventListener("abort", function(t) {
e.clearListenTrack(), e.props.onAbort(t);
}), t.addEventListener("ended", function(t) {
e.clearListenTrack(), e.props.onEnded(t);
}), t.addEventListener("pause", function(t) {
e.clearListenTrack(), e.props.onPause(t);
}), t.addEventListener("seeked", function(t) {
e.clearListenTrack(), e.props.onSeeked(t);
});
}
}, {
key: "setListenTrack",
value: function() {
var e = this;
if (!this.listenTracker) {
var t = this.props.listenInterval;
this.listenTracker = setInterval(function() {
e.props.onListen(e.audio.currentTime);
}, t);
}
}
}, {
key: "clearListenTrack",
value: function() {
this.listenTracker && (clearInterval(this.listenTracker), this.listenTracker = null);
}
} ]), t;
}(s.Component);
c.defaultProps = {
autoPlay: !1,
children: null,
className: "",
controls: !1,
listenInterval: 3e3,
loop: !1,
muted: !1,
onAbort: function() {},
onCanPlay: function() {},
onCanPlayThrough: function() {},
onEnded: function() {},
onError: function() {},
onListen: function() {},
onPause: function() {},
onPlay: function() {},
onSeeked: function() {},
preload: "auto",
src: null
}, t.default = c;
}, function(e, t, a) {
"use strict";
function n(e) {
return e && e.__esModule ? e : {
"default": e
};
}
function i(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function r(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function o(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var s = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), l = a(0), c = n(l), d = a(9), u = n(d), _ = a(4), p = n(_);
a(1);
var f = a(2), h = n(f), m = function(e) {
function t(e) {
i(this, t);
var a = r(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e));
return a.state = {
playing: !1,
progress: 0,
audioSrc: "",
duration: 0
}, a;
}
return o(t, e), s(t, [ {
key: "control",
value: function() {
this.state.playing ? this.refs.player.pause() : this.refs.player.play();
}
}, {
key: "progress",
value: function(e) {
var t = this.props.time;
0 == parseInt(t) && (t = this.state.duration);
var a = Math.ceil(100 * e / t) + "%";
this.setState({
progress: a
});
}
}, {
key: "onPlay",
value: function() {
this.setState({
playing: !0,
duration: this.refs.player.audio.duration
});
for (var e in t.audioList) e !== this.props.id && t.audioList[e].pause();
send_umeng_event && send_umeng_event("sound", "detail_play", {
value: Page.statistics.item_id,
extra: {
sound_id: this.props.id
}
});
}
}, {
key: "onPause",
value: function() {
this.setState({
playing: !1
});
}
}, {
key: "onEnded",
value: function() {
this.setState({
playing: !1,
progress: 0
}), this.refs.player.audio.currentTime = 0;
}
}, {
key: "onError",
value: function() {}
}, {
key: "render",
value: function() {
var e = this, t = this.props, a = t.title, n = t.time, i = t.content, r = (t.id, 
this.state), o = r.playing, s = r.progress, l = r.audioSrc;
return c.default.createElement("div", {
className: o ? "musicplayer playing" : "musicplayer not-playing",
onClick: function() {
return e.control();
}
}, c.default.createElement("div", {
className: "music-state"
}, c.default.createElement("div", {
className: "music-info"
}, c.default.createElement("span", {
className: "music-name"
}, a), c.default.createElement("span", {
className: "music-time"
}, h.default.formatTime(n))), c.default.createElement("div", {
className: "music-musician"
}, i)), c.default.createElement("div", {
className: "progressbar",
style: {
width: s
}
}), c.default.createElement(u.default, {
ref: "player",
src: l,
onError: function() {
return e.onError();
},
onListen: function(t) {
return e.progress(t);
},
onPause: function() {
return e.onPause();
},
onPlay: function(t) {
return e.onPlay(t);
},
onEnded: function(t) {
return e.onEnded(t);
}
}));
}
}, {
key: "getAudioSourceById",
value: function(e) {
var t = this;
p.default("http://i.snssdk.com/audio/urls/1/toutiao/mp4/" + e).then(function(e) {
return e.status >= 400 && ToutiaoJSBridge.call("toast", {
text: "音频获取失败，请重试",
icon_type: "icon_error"
}), e.json();
}).then(function(e) {
return atob(e.data.audio_list.audio_1.main_url.replace(/\n/gi, ""));
}).then(function(e) {
t.setState({
audioSrc: e
});
});
}
}, {
key: "componentDidMount",
value: function() {
this.getAudioSourceById(this.props.id), t.audioList[this.props.id] = this.refs.player;
}
}, {
key: "componentWillUnmount",
value: function() {
t.audioList = null;
}
} ]), t;
}(l.Component);
m.audioList = {}, t.default = m;
}, function(e, t, a) {
"use strict";
function n(e, t) {
var a = {};
for (var n in e) t.indexOf(n) >= 0 || Object.prototype.hasOwnProperty.call(e, n) && (a[n] = e[n]);
return a;
}
function i(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function r(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function o(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var s = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), l = a(0), c = function(e) {
return e && e.__esModule ? e : {
"default": e
};
}(l);
a(1);
var d = function(e) {
function t(e) {
i(this, t);
var a = r(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e));
return a.state = {
status: "idle",
installed: 0,
progress: 0
}, a;
}
return o(t, e), s(t, [ {
key: "hasDownloader",
value: function() {
return client.isNewsArticleVersionNoLessThan("6.1.4");
}
}, {
key: "setInstalledState",
value: function(e) {
this.setState({
installed: e
});
}
}, {
key: "isInstalled",
value: function() {
var e = this;
ToutiaoJSBridge.call("isAppInstalled", {
pkg_name: this.props.pkg_name
}, function(t) {
e.setInstalledState(1 == t.installed ? 1 : 0);
});
}
}, {
key: "renderProgress",
value: function() {
var e = void 0, t = this.state.progress;
return 50 >= t ? (e = "rotate(" + (180 + 3.6 * t) + "deg)", c.default.createElement("div", {
className: "progress-ring"
}, c.default.createElement("i", {
className: "left"
}, c.default.createElement("i", {
style: {
WebkitTransform: e,
transform: e
}
})))) : (e = "rotate(" + (3.6 * t - 360) + "deg)", c.default.createElement("div", {
className: "progress-ring"
}, c.default.createElement("i", {
className: "left"
}, c.default.createElement("i", null)), c.default.createElement("i", {
className: "right"
}, c.default.createElement("i", {
style: {
WebkitTransform: e,
transform: e
}
}))));
}
}, {
key: "renderIcon",
value: function(e) {
return c.default.Children.only("download_active" === e ? c.default.createElement("div", null, this.renderProgress(), "暂停") : "download_paused" === e ? c.default.createElement("div", null, this.renderProgress(), "继续") : "download_finished" === e ? c.default.createElement("div", null, "安装") : c.default.createElement("div", null, c.default.createElement("i", null, ""), "下载"));
}
}, {
key: "renderButton",
value: function(e, t) {
var a = this, n = 1 == e ? "gd-button gd1-btn iconfont" : "gd-button gd2-btn iconfont";
return 1 == this.state.installed ? c.default.createElement("div", {
className: n,
onClick: function(e) {
return a.handleButton(e);
}
}, c.default.createElement("i", null, ""), "打开") : c.default.createElement("div", {
className: n,
onClick: function(e) {
return a.handleButton(e);
}
}, this.renderIcon(t));
}
}, {
key: "render",
value: function() {
var e = this, t = this.props, a = t.logo, n = t.banner, i = t.name, r = t.game_type, o = t.size, s = t.desc, l = t.detail, d = t.download_url_for_ios, u = (t.pkg_name, 
t.download_url_for_android), _ = this.state.status, p = void 0;
if (a && (p = 1), n && (p = 2), client.isIOS && d) l = d, setTimeout(function() {
return e.setInstalledState(0);
}, 0); else {
if (!client.isAndroid || !u) return null;
l = l ? "sslocal://webview?url=" + encodeURIComponent(l) : u;
}
return 1 == p ? c.default.createElement("a", {
className: "game-downloader gd1",
onClick: function() {
return e.log("detail");
},
href: l
}, c.default.createElement("img", {
className: "gd-icon",
src: a
}), " ", this.renderButton(p, _), c.default.createElement("div", {
className: "gd1-cont"
}, c.default.createElement("div", {
className: "gd1-cont-name"
}, i), c.default.createElement("div", {
className: "gd1-cont-text"
}, r, " ", r ? c.default.createElement("span", {
className: "gd1-cont-split"
}) : "", o), c.default.createElement("div", {
className: "gd1-cont-text"
}, s))) : 2 == p ? c.default.createElement("a", {
className: "game-downloader gd2",
onClick: function() {
return e.log("detail");
},
href: l
}, c.default.createElement("img", {
className: "gd2-cover",
src: n
}), c.default.createElement("div", {
className: "gd2-info"
}, this.renderButton(p, _), c.default.createElement("div", {
className: "gd2-cont"
}, c.default.createElement("div", {
className: "gd2-cont-name"
}, i), c.default.createElement("div", {
className: "gd2-cont-text"
}, r, " ", r ? c.default.createElement("span", {
className: "gd2-cont-split"
}) : "", o)))) : null;
}
}, {
key: "subscribe",
value: function() {
t.eventList[this.appad.id] = this.handler.bind(this), ToutiaoJSBridge.call("subscribe_app_ad", {
data: this.state.appad
});
}
}, {
key: "unsubscribe",
value: function() {
delete t.eventList[this.appad.id], ToutiaoJSBridge.call("unsubscribe_app_ad", {
data: this.appad
});
}
}, {
key: "handler",
value: function(e) {
e.current_bytes = e.current_bytes >= 0 ? e.current_bytes : 0;
var t = e.current_bytes / e.total_bytes;
t = isNaN(t) ? 0 : Math.floor(100 * t), "download_failed" === e.status && ToutiaoJSBridge.call("toast", {
text: "应用下载失败"
}), this.setState({
status: e.status,
progress: t
});
}
}, {
key: "log",
value: function(e) {
send_umeng_event(this.appad.tag, e, this.statisticsData);
}
}, {
key: "handleButton",
value: function(e) {
1 == this.state.installed ? (e.stopPropagation(), e.preventDefault(), this.log("click_open"), 
ToutiaoJSBridge.call("openThirdApp", {
pkg_name: this.props.pkg_name
}, function(e) {
0 == e.code && ToutiaoJSBridge.call("toast", {
text: "打开应用失败，请稍后尝试"
});
})) : client.isAndroid && this.hasDownloader() ? (e.stopPropagation(), e.preventDefault(), 
ToutiaoJSBridge.call("download_app_ad", {
data: this.appad
})) : client.isAndroid && (e.stopPropagation(), e.preventDefault(), location.href = this.appad.download_url_for_android, 
this.log("click_download"));
}
}, {
key: "componentDidMount",
value: function() {
var e = n(this.props, []);
e.type = "app", e.source = "pgc", e.tag = "article_card_app_ad", e.item_id = Page.statistics.item_id, 
e.media_id = Page.author.mediaId, e.log_extra = '{"rit":3,"item_id":0,"convert_id":0}', 
client.isIOS && e.download_url_for_ios ? e.detail = e.download_url_for_ios : client.isAndroid && e.download_url_for_android && (e.detail = e.detail ? "sslocal://webview?url=" + encodeURIComponent(e.detail) : e.download_url_for_android, 
e.download_url = e.download_url_for_android), e.download_url = e.download_url_for_android, 
this.appad = e, this.hasDownloader() && this.subscribe(), this.isInstalled(), t.startListen || (ToutiaoJSBridge.on("app_ad_event", function(e) {
e = e || {};
var a = e.appad || {}, n = a.id;
t.eventList[n](e);
}), t.startListen = !0), this.statisticsData = {
value: Page.statistics.item_id,
extra: {
card_type: e.card_type,
app_name: encodeURIComponent(e.name),
pkg_name: e.pkg_name,
app_id: e.app_id,
app_category: encodeURIComponent(e.game_type),
media_id: Page.author.mediaId,
item_id: Page.statistics.item_id
}
}, this.log("show"), ToutiaoJSBridge.call("subscribe_app_ad", {
data: this.appad
});
}
}, {
key: "componentWillUnmount",
value: function() {
ToutiaoJSBridge.call("unsubscribe_app_ad", {
data: this.appad
}), t.eventList = null;
}
} ]), t;
}(l.Component);
d.defaultProps = {
card_type: 0,
card_id: 0,
type: "game",
logo: "http://p3.pstatp.com/large/22d30005ec3a6f01ff6a",
banner: "http://p3.pstatp.com/large/22d30005ec3a6f01ff6a",
name: "游戏",
game_type: "游戏类型",
size: "0",
desc: "游戏描述",
detail: "",
pkg_name: "",
download_url_for_android: "",
download_url_for_ios: ""
}, d.startListen = !1, d.eventList = {}, t.default = d;
}, function(e, t, a) {
"use strict";
function n(e) {
return e && e.__esModule ? e : {
"default": e
};
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var i = a(10), r = n(i), o = a(11), s = n(o), l = a(13), c = n(l), d = a(15), u = n(d), _ = a(14), p = n(_);
t.default = {
Audio: r.default,
Game: s.default,
Novel: c.default,
Temai: u.default,
PhoneGroup: p.default
};
}, function(e, t, a) {
"use strict";
function n(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function i(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function r(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var o = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), s = a(0), l = function(e) {
return e && e.__esModule ? e : {
"default": e
};
}(s);
a(1);
var c = function(e) {
function t() {
return n(this, t), i(this, (t.__proto__ || Object.getPrototypeOf(t)).apply(this, arguments));
}
return r(t, e), o(t, [ {
key: "render",
value: function() {
var e = this.props, t = e.thumb_url, a = e.book_name, n = e.schema_url, i = e.abstract, r = e.author, o = e.category;
return l.default.createElement("div", {
className: "novel-card"
}, l.default.createElement("a", {
href: n,
target: "_blank",
className: "novel-card-link"
}, l.default.createElement("div", {
className: "novel-card-cover"
}, l.default.createElement("img", {
className: "movie-image",
src: t,
alt: a
})), l.default.createElement("div", {
className: "novel-card-content"
}, l.default.createElement("p", {
className: "novel-card-title"
}, a), l.default.createElement("p", {
className: "novel-card-abstract"
}, i), l.default.createElement("div", {
className: "novel-card-detail"
}, l.default.createElement("span", {
className: "novel-card-detail-item novel-card-author"
}, r), l.default.createElement("span", {
className: "novel-card-detail-item novel-card-category"
}, o), l.default.createElement("i", {
className: "novel-card-icon"
}), l.default.createElement("span", {
className: "novel-card-more"
}, "查看更多")))));
}
} ]), t;
}(s.Component);
t.default = c;
}, function(e, t, a) {
"use strict";
function n(e) {
return e && e.__esModule ? e : {
"default": e
};
}
function i(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function r(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function o(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
function s(e) {
return e ? e.replace(/&amp;/g, "&") : "";
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var l = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), c = a(0), d = n(c);
a(1);
var u = a(8), _ = n(u), p = a(4), f = n(p), h = a(22), m = n(h), g = function(e) {
function t(e) {
i(this, t);
var a = r(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e));
return a.state = {
phone: null
}, a.setConfirm = function(e) {
a.confirm = e;
}, a.dial = function(e) {
e.preventDefault(), a.getPhone(), a.confirm && a.confirm.show(), a.log("call", a.state.phone);
}, a.log = function(e, t, a) {
a = a || "click", send_umeng_event("embeded_button_ad", a, {
value: Page.statistics.item_id,
extra: {
action_type: e,
button_value: t,
action_time: new Date().getTime()
}
});
}, a.getPhone = function() {
var e = a.props, t = e.hid, n = e.city, i = a.props["contact-phone"];
if (i) {
var r = i.split(",");
if (r.length <= 1) return void a.setState({
phone: i
});
var o = r[0], s = r[1], l = {
hid: t,
fzz: o,
ext: s,
city: n,
cstr: m.default("" + n + t + "callcenter")
}, c = [];
for (var d in l) c.push(d + "=" + l[d]);
var u = c.join("&");
f.default("http://m.leju.com/?site=api&ctl=callcenter&act=calling&" + u).then(function(e) {
return e.status >= 400 && ToutiaoJSBridge.call("toast", {
text: "电话拨打失败",
icon_type: "icon_error"
}), e.json();
}).then(function(e) {
return 1 == e.status ? e.info.fzz : null;
}).then(function(e) {
a.setState({
phone: e
});
});
}
}, a.cancelPhone = function() {
var e = a.state.phone, t = {
fzz: e,
cstr: m.default(e + "callcenter")
}, n = [];
for (var i in t) n.push(i + "=" + t[i]);
var r = n.join("&");
f.default("http://m.leju.com/?site=api&ctl=callcenter&act=cancel&" + r).then(function(e) {
return e.json();
}).then(function(e) {
return 1 == e.status && this.setState({
phone: null
}), null;
});
}, a;
}
return o(t, e), l(t, [ {
key: "render",
value: function() {
var e = this, t = this.props["contact-phone"], a = this.props["contact-name"], n = this.props["book-url"], i = this.props["book-name"], r = this.props.city, o = this.props.hid, l = this.props.context, c = this.state.phone, u = 0, p = 0, f = 0;
return a && t && (u++, p = 1), n && i && (u++, f = 1), "pc" == l.platform ? null : /iPhone|XiaoMi/.test(window.navigator.userAgent) || /MI/.test(window.navigator.userAgent.split("/")[1]) ? d.default.createElement("div", {
className: "cpg-container",
"button-count": u
}, p ? d.default.createElement("a", {
className: "cpg-button cpg-call",
href: "tel:" + t
}, a) : null, f ? d.default.createElement("a", {
className: "cpg-button cpg-link",
onClick: function() {
return e.log("url", n);
},
href: "sslocal://webview?url=" + encodeURIComponent(s(n))
}, i) : null) : d.default.createElement("div", {
className: "cpg-container",
"button-count": u
}, p ? d.default.createElement("a", {
className: "cpg-button cpg-call",
onClick: this.dial,
href: "tel:" + t
}, a) : null, f ? d.default.createElement("a", {
className: "cpg-button cpg-link",
onClick: function() {
return e.log("url", n);
},
href: "sslocal://webview?url=" + encodeURIComponent(s(n))
}, i) : null, c ? d.default.createElement(_.default, {
phone: c,
onCancel: this.cancelPhone,
city: r,
hid: o,
ref: this.setConfirm
}) : null);
}
}, {
key: "componentDidMount",
value: function() {
var e = this.props["contact-phone"], t = this.props["contact-name"], a = this.props["book-url"], n = this.props["book-name"];
e && t && this.log("call", e, "show"), a && n && this.log("url", a, "show");
}
}, {
key: "componentWillUnmount",
value: function() {
this.state.phone && this.cancelPhone();
}
} ]), t;
}(c.Component);
t.default = g;
}, function(e, t, a) {
"use strict";
function n(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
function i(e, t) {
if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
return !t || "object" != typeof t && "function" != typeof t ? e : t;
}
function r(e, t) {
if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
e.prototype = Object.create(t && t.prototype, {
constructor: {
value: e,
enumerable: !1,
writable: !0,
configurable: !0
}
}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t);
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var o = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), s = a(0), l = function(e) {
return e && e.__esModule ? e : {
"default": e
};
}(s);
a(1);
var c = function(e) {
function t() {
return n(this, t), i(this, (t.__proto__ || Object.getPrototypeOf(t)).apply(this, arguments));
}
return r(t, e), o(t, [ {
key: "render",
value: function() {
var e = this.props, t = e.charge_url, a = (e.commodity_id, e.img_url), n = e.price, i = (e.slave_commodity_id, 
e.source), r = e.title;
return l.default.createElement("div", {
className: "pgc-commodity"
}, l.default.createElement("a", {
className: "pgc-commodity-link",
href: t
}, l.default.createElement("div", {
className: "pgc-commodity-box"
}, l.default.createElement("div", {
className: "pgc-commodity-img-box"
}, l.default.createElement("div", {
className: "pgc-commodity-img-square"
}, l.default.createElement("img", {
src: a,
alt: "特卖"
}))), l.default.createElement("div", {
className: "pgc-commodity-info"
}, l.default.createElement("h3", {
className: "pgc-commodity-title"
}, r), l.default.createElement("div", {
className: "pgc-commodity-bar"
}, l.default.createElement("span", {
className: "pgc-commodity-price"
}, "￥", n), l.default.createElement("span", {
className: "pgc-commodity-from"
}, i), l.default.createElement("span", {
className: "pgc-commodity-buy"
}, "购买"))))));
}
} ]), t;
}(s.Component);
t.default = c;
}, function(e, t, a) {
"use strict";
function n(e) {
return e && e.__esModule ? e : {
"default": e
};
}
function i(e, t) {
if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function");
}
Object.defineProperty(t, "__esModule", {
value: !0
});
var r = Object.assign || function(e) {
for (var t = 1; t < arguments.length; t++) {
var a = arguments[t];
for (var n in a) Object.prototype.hasOwnProperty.call(a, n) && (e[n] = a[n]);
}
return e;
}, o = function() {
function e(e, t) {
for (var a = 0; a < t.length; a++) {
var n = t[a];
n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), 
Object.defineProperty(e, n.key, n);
}
}
return function(t, a, n) {
return a && e(t.prototype, a), n && e(t, n), t;
};
}(), s = a(0), l = n(s), c = a(0), d = n(c), u = a(2), _ = n(u), p = a(12), f = n(p), h = {}, m = function() {
function e() {
i(this, e), this.init({
match: /^(tt-|pre)/i,
selector: ".novel-card, .pgc-commodit, pre[lang]",
context: {
platform: "client"
}
});
}
return o(e, null, [ {
key: "getInstance",
value: function() {
return e.instance || (e.instance = new e()), e.instance;
}
} ]), o(e, [ {
key: "init",
value: function(e) {
return this.config = r({}, this.config, e), this;
}
}, {
key: "registerCard",
value: function(e) {
return h[e.tag] = e.component, this;
}
}, {
key: "getComponentByTag",
value: function(e) {
return e = e.toLowerCase(), h[e];
}
}, {
key: "isCard",
value: function(e) {
return void 0 !== h[e];
}
}, {
key: "checkCardTag",
value: function(e) {
return e && e.nodeName ? this.config.match.test(e.nodeName) : !1;
}
}, {
key: "resolveTagToComponent",
value: function(e) {
if (e) {
var t = e.toLowerCase().split("-");
t.length > 1 && t.shift();
for (var a = "", n = 0, i = t.length; i > n; n++) a += _.default.firstUpper(t[n]);
return a;
}
}
}, {
key: "render",
value: function(e) {
var t = this, n = void 0;
_.default.map(e, function(e) {
if (t.checkCardTag(e)) {
var i = _.default.buildAttrs(e), o = r({}, t.config, i);
if (t.getComponentByTag(e.nodeName)) n = d.default.createElement(t.getComponentByTag(e.nodeName), o), 
l.default.render(n, e); else {
var s = t.resolveTagToComponent(e.nodeName);
a.e(0).then(a.bind(null, 31)).then(function(t) {
var a = t.default;
"pre" == e.nodeName.toLowerCase() && (s = "Code"), n = d.default.createElement(a[s], o, e.textContent), 
l.default.render(n, e);
});
}
}
});
}
}, {
key: "componentWillUnmount",
value: function() {
this.config = null;
}
} ]), e;
}(), g = m.getInstance();
g.registerCard({
tag: "tt-audio",
component: f.default.Audio
}), g.registerCard({
tag: "tt-game",
component: f.default.Game
}), g.registerCard({
tag: "tt-novel",
component: f.default.Novel
}), g.registerCard({
tag: "tt-temai",
component: f.default.Temai
}), g.registerCard({
tag: "tt-phone-group",
component: f.default.PhoneGroup
}), t.default = g;
}, function(e) {
!function() {
var t = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", a = {
rotl: function(e, t) {
return e << t | e >>> 32 - t;
},
rotr: function(e, t) {
return e << 32 - t | e >>> t;
},
endian: function(e) {
if (e.constructor == Number) return 16711935 & a.rotl(e, 8) | 4278255360 & a.rotl(e, 24);
for (var t = 0; t < e.length; t++) e[t] = a.endian(e[t]);
return e;
},
randomBytes: function(e) {
for (var t = []; e > 0; e--) t.push(Math.floor(256 * Math.random()));
return t;
},
bytesToWords: function(e) {
for (var t = [], a = 0, n = 0; a < e.length; a++, n += 8) t[n >>> 5] |= e[a] << 24 - n % 32;
return t;
},
wordsToBytes: function(e) {
for (var t = [], a = 0; a < 32 * e.length; a += 8) t.push(e[a >>> 5] >>> 24 - a % 32 & 255);
return t;
},
bytesToHex: function(e) {
for (var t = [], a = 0; a < e.length; a++) t.push((e[a] >>> 4).toString(16)), t.push((15 & e[a]).toString(16));
return t.join("");
},
hexToBytes: function(e) {
for (var t = [], a = 0; a < e.length; a += 2) t.push(parseInt(e.substr(a, 2), 16));
return t;
},
bytesToBase64: function(e) {
for (var a = [], n = 0; n < e.length; n += 3) for (var i = e[n] << 16 | e[n + 1] << 8 | e[n + 2], r = 0; 4 > r; r++) a.push(8 * n + 6 * r <= 8 * e.length ? t.charAt(i >>> 6 * (3 - r) & 63) : "=");
return a.join("");
},
base64ToBytes: function(e) {
e = e.replace(/[^A-Z0-9+\/]/gi, "");
for (var a = [], n = 0, i = 0; n < e.length; i = ++n % 4) 0 != i && a.push((t.indexOf(e.charAt(n - 1)) & Math.pow(2, -2 * i + 8) - 1) << 2 * i | t.indexOf(e.charAt(n)) >>> 6 - 2 * i);
return a;
}
};
e.exports = a;
}();
}, function(e) {
"use strict";
function t(e) {
return function() {
return e;
};
}
var a = function() {};
a.thatReturns = t, a.thatReturnsFalse = t(!1), a.thatReturnsTrue = t(!0), a.thatReturnsNull = t(null), 
a.thatReturnsThis = function() {
return this;
}, a.thatReturnsArgument = function(e) {
return e;
}, e.exports = a;
}, function(e) {
"use strict";
function t(e, t, n, i, r, o, s, l) {
if (a(t), !e) {
var c;
if (void 0 === t) c = new Error("Minified exception occurred; use the non-minified dev environment for the full error message and additional helpful warnings."); else {
var d = [ n, i, r, o, s, l ], u = 0;
c = new Error(t.replace(/%s/g, function() {
return d[u++];
})), c.name = "Invariant Violation";
}
throw c.framesToPop = 1, c;
}
}
var a = function() {};
e.exports = t;
}, function(e, t, a) {
(function(t) {
var a;
a = "undefined" != typeof window ? window : void 0 !== t ? t : "undefined" != typeof self ? self : {}, 
e.exports = a;
}).call(t, a(6));
}, function(e) {
function t(e) {
return !!e.constructor && "function" == typeof e.constructor.isBuffer && e.constructor.isBuffer(e);
}
function a(e) {
return "function" == typeof e.readFloatLE && "function" == typeof e.slice && t(e.slice(0, 0));
}
e.exports = function(e) {
return null != e && (t(e) || a(e) || !!e._isBuffer);
};
}, function(e, t, a) {
!function() {
var t = a(17), n = a(3).utf8, i = a(21), r = a(3).bin, o = function(e, a) {
e.constructor == String ? e = a && "binary" === a.encoding ? r.stringToBytes(e) : n.stringToBytes(e) : i(e) ? e = Array.prototype.slice.call(e, 0) : Array.isArray(e) || (e = e.toString());
for (var s = t.bytesToWords(e), l = 8 * e.length, c = 1732584193, d = -271733879, u = -1732584194, _ = 271733878, p = 0; p < s.length; p++) s[p] = 16711935 & (s[p] << 8 | s[p] >>> 24) | 4278255360 & (s[p] << 24 | s[p] >>> 8);
s[l >>> 5] |= 128 << l % 32, s[14 + (l + 64 >>> 9 << 4)] = l;
for (var f = o._ff, h = o._gg, m = o._hh, g = o._ii, p = 0; p < s.length; p += 16) {
var v = c, w = d, y = u, b = _;
c = f(c, d, u, _, s[p + 0], 7, -680876936), _ = f(_, c, d, u, s[p + 1], 12, -389564586), 
u = f(u, _, c, d, s[p + 2], 17, 606105819), d = f(d, u, _, c, s[p + 3], 22, -1044525330), 
c = f(c, d, u, _, s[p + 4], 7, -176418897), _ = f(_, c, d, u, s[p + 5], 12, 1200080426), 
u = f(u, _, c, d, s[p + 6], 17, -1473231341), d = f(d, u, _, c, s[p + 7], 22, -45705983), 
c = f(c, d, u, _, s[p + 8], 7, 1770035416), _ = f(_, c, d, u, s[p + 9], 12, -1958414417), 
u = f(u, _, c, d, s[p + 10], 17, -42063), d = f(d, u, _, c, s[p + 11], 22, -1990404162), 
c = f(c, d, u, _, s[p + 12], 7, 1804603682), _ = f(_, c, d, u, s[p + 13], 12, -40341101), 
u = f(u, _, c, d, s[p + 14], 17, -1502002290), d = f(d, u, _, c, s[p + 15], 22, 1236535329), 
c = h(c, d, u, _, s[p + 1], 5, -165796510), _ = h(_, c, d, u, s[p + 6], 9, -1069501632), 
u = h(u, _, c, d, s[p + 11], 14, 643717713), d = h(d, u, _, c, s[p + 0], 20, -373897302), 
c = h(c, d, u, _, s[p + 5], 5, -701558691), _ = h(_, c, d, u, s[p + 10], 9, 38016083), 
u = h(u, _, c, d, s[p + 15], 14, -660478335), d = h(d, u, _, c, s[p + 4], 20, -405537848), 
c = h(c, d, u, _, s[p + 9], 5, 568446438), _ = h(_, c, d, u, s[p + 14], 9, -1019803690), 
u = h(u, _, c, d, s[p + 3], 14, -187363961), d = h(d, u, _, c, s[p + 8], 20, 1163531501), 
c = h(c, d, u, _, s[p + 13], 5, -1444681467), _ = h(_, c, d, u, s[p + 2], 9, -51403784), 
u = h(u, _, c, d, s[p + 7], 14, 1735328473), d = h(d, u, _, c, s[p + 12], 20, -1926607734), 
c = m(c, d, u, _, s[p + 5], 4, -378558), _ = m(_, c, d, u, s[p + 8], 11, -2022574463), 
u = m(u, _, c, d, s[p + 11], 16, 1839030562), d = m(d, u, _, c, s[p + 14], 23, -35309556), 
c = m(c, d, u, _, s[p + 1], 4, -1530992060), _ = m(_, c, d, u, s[p + 4], 11, 1272893353), 
u = m(u, _, c, d, s[p + 7], 16, -155497632), d = m(d, u, _, c, s[p + 10], 23, -1094730640), 
c = m(c, d, u, _, s[p + 13], 4, 681279174), _ = m(_, c, d, u, s[p + 0], 11, -358537222), 
u = m(u, _, c, d, s[p + 3], 16, -722521979), d = m(d, u, _, c, s[p + 6], 23, 76029189), 
c = m(c, d, u, _, s[p + 9], 4, -640364487), _ = m(_, c, d, u, s[p + 12], 11, -421815835), 
u = m(u, _, c, d, s[p + 15], 16, 530742520), d = m(d, u, _, c, s[p + 2], 23, -995338651), 
c = g(c, d, u, _, s[p + 0], 6, -198630844), _ = g(_, c, d, u, s[p + 7], 10, 1126891415), 
u = g(u, _, c, d, s[p + 14], 15, -1416354905), d = g(d, u, _, c, s[p + 5], 21, -57434055), 
c = g(c, d, u, _, s[p + 12], 6, 1700485571), _ = g(_, c, d, u, s[p + 3], 10, -1894986606), 
u = g(u, _, c, d, s[p + 10], 15, -1051523), d = g(d, u, _, c, s[p + 1], 21, -2054922799), 
c = g(c, d, u, _, s[p + 8], 6, 1873313359), _ = g(_, c, d, u, s[p + 15], 10, -30611744), 
u = g(u, _, c, d, s[p + 6], 15, -1560198380), d = g(d, u, _, c, s[p + 13], 21, 1309151649), 
c = g(c, d, u, _, s[p + 4], 6, -145523070), _ = g(_, c, d, u, s[p + 11], 10, -1120210379), 
u = g(u, _, c, d, s[p + 2], 15, 718787259), d = g(d, u, _, c, s[p + 9], 21, -343485551), 
c = c + v >>> 0, d = d + w >>> 0, u = u + y >>> 0, _ = _ + b >>> 0;
}
return t.endian([ c, d, u, _ ]);
};
o._ff = function(e, t, a, n, i, r, o) {
var s = e + (t & a | ~t & n) + (i >>> 0) + o;
return (s << r | s >>> 32 - r) + t;
}, o._gg = function(e, t, a, n, i, r, o) {
var s = e + (t & n | a & ~n) + (i >>> 0) + o;
return (s << r | s >>> 32 - r) + t;
}, o._hh = function(e, t, a, n, i, r, o) {
var s = e + (t ^ a ^ n) + (i >>> 0) + o;
return (s << r | s >>> 32 - r) + t;
}, o._ii = function(e, t, a, n, i, r, o) {
var s = e + (a ^ (t | ~n)) + (i >>> 0) + o;
return (s << r | s >>> 32 - r) + t;
}, o._blocksize = 16, o._digestsize = 16, e.exports = function(e, a) {
if (void 0 === e || null === e) throw new Error("Illegal argument " + e);
var n = t.wordsToBytes(o(e, a));
return a && a.asBytes ? n : a && a.asString ? r.bytesToString(n) : t.bytesToHex(n);
};
}();
}, function(e, t, a) {
"use strict";
function n() {}
function i(e, t) {
var a, i, r, o, s = B;
for (o = arguments.length; o-- > 2; ) O.push(arguments[o]);
for (t && null != t.children && (O.length || O.push(t.children), delete t.children); O.length; ) if ((i = O.pop()) && void 0 !== i.pop) for (o = i.length; o--; ) O.push(i[o]); else "boolean" == typeof i && (i = null), 
(r = "function" != typeof e) && (null == i ? i = "" : "number" == typeof i ? i = String(i) : "string" != typeof i && (r = !1)), 
r && a ? s[s.length - 1] += i : s === B ? s = [ i ] : s.push(i), a = r;
var l = new n();
return l.nodeName = e, l.children = s, l.attributes = null == t ? void 0 : t, l.key = null == t ? void 0 : t.key, 
void 0 !== j.vnode && j.vnode(l), l;
}
function r(e, t) {
for (var a in t) e[a] = t[a];
return e;
}
function o(e, t) {
return i(e.nodeName, r(r({}, e.attributes), t), arguments.length > 2 ? [].slice.call(arguments, 2) : e.children);
}
function s(e) {
!e._dirty && (e._dirty = !0) && 1 == M.push(e) && (j.debounceRendering || L)(l);
}
function l() {
var e, t = M;
for (M = []; e = t.pop(); ) e._dirty && A(e);
}
function c(e, t, a) {
return "string" == typeof t || "number" == typeof t ? void 0 !== e.splitText : "string" == typeof t.nodeName ? !e._componentConstructor && d(e, t.nodeName) : a || e._componentConstructor === t.nodeName;
}
function d(e, t) {
return e.normalizedNodeName === t || e.nodeName.toLowerCase() === t.toLowerCase();
}
function u(e) {
var t = r({}, e.attributes);
t.children = e.children;
var a = e.nodeName.defaultProps;
if (void 0 !== a) for (var n in a) void 0 === t[n] && (t[n] = a[n]);
return t;
}
function _(e, t) {
var a = t ? document.createElementNS("http://www.w3.org/2000/svg", e) : document.createElement(e);
return a.normalizedNodeName = e, a;
}
function p(e) {
var t = e.parentNode;
t && t.removeChild(e);
}
function f(e, t, a, n, i) {
if ("className" === t && (t = "class"), "key" === t) ; else if ("ref" === t) a && a(null), 
n && n(e); else if ("class" !== t || i) if ("style" === t) {
if (n && "string" != typeof n && "string" != typeof a || (e.style.cssText = n || ""), 
n && "object" == typeof n) {
if ("string" != typeof a) for (var r in a) r in n || (e.style[r] = "");
for (var r in n) e.style[r] = "number" == typeof n[r] && !1 === R.test(r) ? n[r] + "px" : n[r];
}
} else if ("dangerouslySetInnerHTML" === t) n && (e.innerHTML = n.__html || ""); else if ("o" == t[0] && "n" == t[1]) {
var o = t !== (t = t.replace(/Capture$/, ""));
t = t.toLowerCase().substring(2), n ? a || e.addEventListener(t, m, o) : e.removeEventListener(t, m, o), 
(e._listeners || (e._listeners = {}))[t] = n;
} else if ("list" !== t && "type" !== t && !i && t in e) h(e, t, null == n ? "" : n), 
null != n && !1 !== n || e.removeAttribute(t); else {
var s = i && t !== (t = t.replace(/^xlink\:?/, ""));
null == n || !1 === n ? s ? e.removeAttributeNS("http://www.w3.org/1999/xlink", t.toLowerCase()) : e.removeAttribute(t) : "function" != typeof n && (s ? e.setAttributeNS("http://www.w3.org/1999/xlink", t.toLowerCase(), n) : e.setAttribute(t, n));
} else e.className = n || "";
}
function h(e, t, a) {
try {
e[t] = a;
} catch (e) {}
}
function m(e) {
return this._listeners[e.type](j.event && j.event(e) || e);
}
function g() {
for (var e; e = D.pop(); ) j.afterMount && j.afterMount(e), e.componentDidMount && e.componentDidMount();
}
function v(e, t, a, n, i, r) {
F++ || (U = null != i && void 0 !== i.ownerSVGElement, V = null != e && !("__preactattr_" in e));
var o = w(e, t, a, n, r);
return i && o.parentNode !== i && i.appendChild(o), --F || (V = !1, r || g()), o;
}
function w(e, t, a, n, i) {
var r = e, o = U;
if (null != t && "boolean" != typeof t || (t = ""), "string" == typeof t || "number" == typeof t) return e && void 0 !== e.splitText && e.parentNode && (!e._component || i) ? e.nodeValue != t && (e.nodeValue = t) : (r = document.createTextNode(t), 
e && (e.parentNode && e.parentNode.replaceChild(r, e), b(e, !0))), r.__preactattr_ = !0, 
r;
var s = t.nodeName;
if ("function" == typeof s) return E(e, t, a, n);
if (U = "svg" === s || "foreignObject" !== s && U, s = String(s), (!e || !d(e, s)) && (r = _(s, U), 
e)) {
for (;e.firstChild; ) r.appendChild(e.firstChild);
e.parentNode && e.parentNode.replaceChild(r, e), b(e, !0);
}
var l = r.firstChild, c = r.__preactattr_, u = t.children;
if (null == c) {
c = r.__preactattr_ = {};
for (var p = r.attributes, f = p.length; f--; ) c[p[f].name] = p[f].value;
}
return !V && u && 1 === u.length && "string" == typeof u[0] && null != l && void 0 !== l.splitText && null == l.nextSibling ? l.nodeValue != u[0] && (l.nodeValue = u[0]) : (u && u.length || null != l) && y(r, u, a, n, V || null != c.dangerouslySetInnerHTML), 
k(r, t.attributes, c), U = o, r;
}
function y(e, t, a, n, i) {
var r, o, s, l, d, u = e.childNodes, _ = [], f = {}, h = 0, m = 0, g = u.length, v = 0, y = t ? t.length : 0;
if (0 !== g) for (var x = 0; g > x; x++) {
var k = u[x], P = k.__preactattr_, S = y && P ? k._component ? k._component.__key : P.key : null;
null != S ? (h++, f[S] = k) : (P || (void 0 !== k.splitText ? !i || k.nodeValue.trim() : i)) && (_[v++] = k);
}
if (0 !== y) for (var x = 0; y > x; x++) {
l = t[x], d = null;
var S = l.key;
if (null != S) h && void 0 !== f[S] && (d = f[S], f[S] = void 0, h--); else if (!d && v > m) for (r = m; v > r; r++) if (void 0 !== _[r] && c(o = _[r], l, i)) {
d = o, _[r] = void 0, r === v - 1 && v--, r === m && m++;
break;
}
d = w(d, l, a, n), s = u[x], d && d !== e && d !== s && (null == s ? e.appendChild(d) : d === s.nextSibling ? p(s) : e.insertBefore(d, s));
}
if (h) for (var x in f) void 0 !== f[x] && b(f[x], !1);
for (;v >= m; ) void 0 !== (d = _[v--]) && b(d, !1);
}
function b(e, t) {
var a = e._component;
a ? I(a) : (null != e.__preactattr_ && e.__preactattr_.ref && e.__preactattr_.ref(null), 
!1 !== t && null != e.__preactattr_ || p(e), x(e));
}
function x(e) {
for (e = e.lastChild; e; ) {
var t = e.previousSibling;
b(e, !0), e = t;
}
}
function k(e, t, a) {
var n;
for (n in a) t && null != t[n] || null == a[n] || f(e, n, a[n], a[n] = void 0, U);
for (n in t) "children" === n || "innerHTML" === n || n in a && t[n] === ("value" === n || "checked" === n ? e[n] : a[n]) || f(e, n, a[n], a[n] = t[n], U);
}
function P(e) {
var t = e.constructor.name;
(z[t] || (z[t] = [])).push(e);
}
function S(e, t, a) {
var n, i = z[e.name];
if (e.prototype && e.prototype.render ? (n = new e(t, a), N.call(n, t, a)) : (n = new N(t, a), 
n.constructor = e, n.render = T), i) for (var r = i.length; r--; ) if (i[r].constructor === e) {
n.nextBase = i[r].nextBase, i.splice(r, 1);
break;
}
return n;
}
function T(e, t, a) {
return this.constructor(e, a);
}
function C(e, t, a, n, i) {
e._disable || (e._disable = !0, (e.__ref = t.ref) && delete t.ref, (e.__key = t.key) && delete t.key, 
!e.base || i ? e.componentWillMount && e.componentWillMount() : e.componentWillReceiveProps && e.componentWillReceiveProps(t, n), 
n && n !== e.context && (e.prevContext || (e.prevContext = e.context), e.context = n), 
e.prevProps || (e.prevProps = e.props), e.props = t, e._disable = !1, 0 !== a && (1 !== a && !1 === j.syncComponentUpdates && e.base ? s(e) : A(e, 1, i)), 
e.__ref && e.__ref(e));
}
function A(e, t, a, n) {
if (!e._disable) {
var i, o, s, l = e.props, c = e.state, d = e.context, _ = e.prevProps || l, p = e.prevState || c, f = e.prevContext || d, h = e.base, m = e.nextBase, w = h || m, y = e._component, x = !1;
if (h && (e.props = _, e.state = p, e.context = f, 2 !== t && e.shouldComponentUpdate && !1 === e.shouldComponentUpdate(l, c, d) ? x = !0 : e.componentWillUpdate && e.componentWillUpdate(l, c, d), 
e.props = l, e.state = c, e.context = d), e.prevProps = e.prevState = e.prevContext = e.nextBase = null, 
e._dirty = !1, !x) {
i = e.render(l, c, d), e.getChildContext && (d = r(r({}, d), e.getChildContext()));
var k, P, T = i && i.nodeName;
if ("function" == typeof T) {
var E = u(i);
o = y, o && o.constructor === T && E.key == o.__key ? C(o, E, 1, d, !1) : (k = o, 
e._component = o = S(T, E, d), o.nextBase = o.nextBase || m, o._parentComponent = e, 
C(o, E, 0, d, !1), A(o, 1, a, !0)), P = o.base;
} else s = w, k = y, k && (s = e._component = null), (w || 1 === t) && (s && (s._component = null), 
P = v(s, i, d, a || !h, w && w.parentNode, !0));
if (w && P !== w && o !== y) {
var N = w.parentNode;
N && P !== N && (N.replaceChild(P, w), k || (w._component = null, b(w, !1)));
}
if (k && I(k), e.base = P, P && !n) {
for (var $ = e, O = e; O = O._parentComponent; ) ($ = O).base = P;
P._component = $, P._componentConstructor = $.constructor;
}
}
if (!h || a ? D.unshift(e) : x || (e.componentDidUpdate && e.componentDidUpdate(_, p, f), 
j.afterUpdate && j.afterUpdate(e)), null != e._renderCallbacks) for (;e._renderCallbacks.length; ) e._renderCallbacks.pop().call(e);
F || n || g();
}
}
function E(e, t, a, n) {
for (var i = e && e._component, r = i, o = e, s = i && e._componentConstructor === t.nodeName, l = s, c = u(t); i && !l && (i = i._parentComponent); ) l = i.constructor === t.nodeName;
return i && l && (!n || i._component) ? (C(i, c, 3, a, n), e = i.base) : (r && !s && (I(r), 
e = o = null), i = S(t.nodeName, c, a), e && !i.nextBase && (i.nextBase = e, o = null), 
C(i, c, 1, a, n), e = i.base, o && e !== o && (o._component = null, b(o, !1))), 
e;
}
function I(e) {
j.beforeUnmount && j.beforeUnmount(e);
var t = e.base;
e._disable = !0, e.componentWillUnmount && e.componentWillUnmount(), e.base = null;
var a = e._component;
a ? I(a) : t && (t.__preactattr_ && t.__preactattr_.ref && t.__preactattr_.ref(null), 
e.nextBase = t, p(t), P(e), x(t)), e.__ref && e.__ref(null);
}
function N(e, t) {
this._dirty = !0, this.context = t, this.props = e, this.state = this.state || {};
}
function $(e, t, a) {
return v(a, e, {}, !1, t, !1);
}
a.d(t, "a", function() {
return i;
}), a.d(t, "d", function() {
return o;
}), a.d(t, "e", function() {
return N;
}), a.d(t, "c", function() {
return $;
}), a.d(t, "b", function() {
return j;
});
var j = {}, O = [], B = [], L = "function" == typeof Promise ? Promise.resolve().then.bind(Promise.resolve()) : setTimeout, R = /acit|ex(?:s|g|n|p|$)|rph|ows|mnc|ntw|ine[ch]|zoo|^ord/i, M = [], D = [], F = 0, U = !1, V = !1, z = {};
r(N.prototype, {
setState: function(e, t) {
var a = this.state;
this.prevState || (this.prevState = r({}, a)), r(a, "function" == typeof e ? e(a, this.props) : e), 
t && (this._renderCallbacks = this._renderCallbacks || []).push(t), s(this);
},
forceUpdate: function(e) {
e && (this._renderCallbacks = this._renderCallbacks || []).push(e), A(this, 2);
},
render: function() {}
});
}, function(e, t, a) {
(function(t) {
!function(a) {
function n() {}
function i(e, t) {
return function() {
e.apply(t, arguments);
};
}
function r(e) {
if ("object" != typeof this) throw new TypeError("Promises must be constructed via new");
if ("function" != typeof e) throw new TypeError("not a function");
this._state = 0, this._handled = !1, this._value = void 0, this._deferreds = [], 
u(e, this);
}
function o(e, t) {
for (;3 === e._state; ) e = e._value;
return 0 === e._state ? void e._deferreds.push(t) : (e._handled = !0, void r._immediateFn(function() {
var e = 1 === n._state ? t.onFulfilled : t.onRejected;
if (null === e) return void (1 === n._state ? s : l)(t.promise, n._value);
var a;
try {
a = e(n._value);
} catch (n) {
return void l(t.promise, n);
}
s(t.promise, a);
}));
}
function s(e, t) {
try {
if (t === e) throw new TypeError("A promise cannot be resolved with itself.");
if (t && ("object" == typeof t || "function" == typeof t)) {
var a = t.then;
if (t instanceof r) return e._state = 3, e._value = t, void c(e);
if ("function" == typeof a) return void u(i(a, t), e);
}
e._state = 1, e._value = t, c(e);
} catch (t) {
l(e, t);
}
}
function l(e, t) {
e._state = 2, e._value = t, c(e);
}
function c(e) {
2 === e._state && 0 === e._deferreds.length && r._immediateFn(function() {
e._handled || r._unhandledRejectionFn(e._value);
});
for (var t = 0, a = e._deferreds.length; a > t; t++) o(e, e._deferreds[t]);
e._deferreds = null;
}
function d(e, t, a) {
this.onFulfilled = "function" == typeof e ? e : null, this.onRejected = "function" == typeof t ? t : null, 
this.promise = a;
}
function u(e, t) {
var a = !1;
try {
e(function(e) {
a || (a = !0, s(t, e));
}, function(e) {
a || (a = !0, l(t, e));
});
} catch (e) {
if (a) return;
a = !0, l(t, e);
}
}
var _ = setTimeout;
r.prototype.catch = function(e) {
return this.then(null, e);
}, r.prototype.then = function(e, t) {
var a = new this.constructor(n);
return o(this, new d(e, t, a)), a;
}, r.all = function(e) {
var t = Array.prototype.slice.call(e);
return new r(function(e, a) {
function n(e, r) {
try {
if (r && ("object" == typeof r || "function" == typeof r)) {
var o = r.then;
if ("function" == typeof o) return void o.call(r, function(t) {
n(e, t);
}, a);
}
t[e] = r, 0 == --i && s(t);
} catch (s) {
a(s);
}
}
if (0 === t.length) return e([]);
for (var i = t.length, r = 0; r < t.length; r++) n(r, t[r]);
});
}, r.resolve = function(e) {
return e && "object" == typeof e && e.constructor === r ? e : new r(function(t) {
t(e);
});
}, r.reject = function(e) {
return new r(function(t, a) {
a(e);
});
}, r.race = function(e) {
return new r(function(t, a) {
for (var n = 0, i = e.length; i > n; n++) e[n].then(t, a);
});
}, r._immediateFn = "function" == typeof t && function(e) {
t(e);
} || function(e) {
_(e, 0);
}, r._unhandledRejectionFn = function(e) {
"undefined" != typeof console && console && console.warn("Possible Unhandled Promise Rejection:", e);
}, r._setImmediateFn = function(e) {
r._immediateFn = e;
}, r._setUnhandledRejectionFn = function(e) {
r._unhandledRejectionFn = e;
}, void 0 !== e && e.exports ? e.exports = r : a.Promise || (a.Promise = r);
}(this);
}).call(t, a(29).setImmediate);
}, function(e, t, a) {
"use strict";
var n = a(18), i = a(19), r = a(27);
e.exports = function() {
function e(e, t, a, n, o, s) {
s !== r && i(!1, "Calling PropTypes validators directly is not supported by the `prop-types` package. Use PropTypes.checkPropTypes() to call them. Read more at http://fb.me/use-check-prop-types");
}
function t() {
return e;
}
e.isRequired = e;
var a = {
array: e,
bool: e,
func: e,
number: e,
object: e,
string: e,
symbol: e,
any: e,
arrayOf: t,
element: e,
instanceOf: t,
node: e,
objectOf: t,
oneOf: t,
oneOfType: t,
shape: t
};
return a.checkPropTypes = n, a.PropTypes = a, a;
};
}, function(e, t, a) {
e.exports = a(25)();
}, function(e) {
"use strict";
e.exports = "SECRET_DO_NOT_PASS_THIS_OR_YOU_WILL_BE_FIRED";
}, function(e, t, a) {
(function(e, t) {
!function(e, a) {
"use strict";
function n(e) {
"function" != typeof e && (e = new Function("" + e));
for (var t = new Array(arguments.length - 1), a = 0; a < t.length; a++) t[a] = arguments[a + 1];
var n = {
callback: e,
args: t
};
return c[l] = n, s(l), l++;
}
function i(e) {
delete c[e];
}
function r(e) {
var t = e.callback, n = e.args;
switch (n.length) {
case 0:
t();
break;

case 1:
t(n[0]);
break;

case 2:
t(n[0], n[1]);
break;

case 3:
t(n[0], n[1], n[2]);
break;

default:
t.apply(a, n);
}
}
function o(e) {
if (d) setTimeout(o, 0, e); else {
var t = c[e];
if (t) {
d = !0;
try {
r(t);
} finally {
i(e), d = !1;
}
}
}
}
if (!e.setImmediate) {
var s, l = 1, c = {}, d = !1, u = e.document, _ = Object.getPrototypeOf && Object.getPrototypeOf(e);
_ = _ && _.setTimeout ? _ : e, "[object process]" === {}.toString.call(e.process) ? function() {
s = function(e) {
t.nextTick(function() {
o(e);
});
};
}() : function() {
if (e.postMessage && !e.importScripts) {
var t = !0, a = e.onmessage;
return e.onmessage = function() {
t = !1;
}, e.postMessage("", "*"), e.onmessage = a, t;
}
}() ? function() {
var t = "setImmediate$" + Math.random() + "$", a = function(a) {
a.source === e && "string" == typeof a.data && 0 === a.data.indexOf(t) && o(+a.data.slice(t.length));
};
e.addEventListener ? e.addEventListener("message", a, !1) : e.attachEvent("onmessage", a), 
s = function(a) {
e.postMessage(t + a, "*");
};
}() : e.MessageChannel ? function() {
var e = new MessageChannel();
e.port1.onmessage = function(e) {
o(e.data);
}, s = function(t) {
e.port2.postMessage(t);
};
}() : u && "onreadystatechange" in u.createElement("script") ? function() {
var e = u.documentElement;
s = function(t) {
var a = u.createElement("script");
a.onreadystatechange = function() {
o(t), a.onreadystatechange = null, e.removeChild(a), a = null;
}, e.appendChild(a);
};
}() : function() {
s = function(e) {
setTimeout(o, 0, e);
};
}(), _.setImmediate = n, _.clearImmediate = i;
}
}("undefined" == typeof self ? void 0 === e ? this : e : self);
}).call(t, a(6), a(5));
}, function(e, t, a) {
function n(e, t) {
this._id = e, this._clearFn = t;
}
var i = Function.prototype.apply;
t.setTimeout = function() {
return new n(i.call(setTimeout, window, arguments), clearTimeout);
}, t.setInterval = function() {
return new n(i.call(setInterval, window, arguments), clearInterval);
}, t.clearTimeout = t.clearInterval = function(e) {
e && e.close();
}, n.prototype.unref = n.prototype.ref = function() {}, n.prototype.close = function() {
this._clearFn.call(window, this._id);
}, t.enroll = function(e, t) {
clearTimeout(e._idleTimeoutId), e._idleTimeout = t;
}, t.unenroll = function(e) {
clearTimeout(e._idleTimeoutId), e._idleTimeout = -1;
}, t._unrefActive = t.active = function(e) {
clearTimeout(e._idleTimeoutId);
var t = e._idleTimeout;
t >= 0 && (e._idleTimeoutId = setTimeout(function() {
e._onTimeout && e._onTimeout();
}, t));
}, a(28);
var r = a(20);
t.setImmediate = r.setImmediate, t.clearImmediate = r.clearImmediate;
}, function(e, t, a) {
e.exports = a(7);
} ]);