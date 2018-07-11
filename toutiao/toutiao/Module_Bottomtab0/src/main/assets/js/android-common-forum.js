function _getNewsArticleVersion() {
var t = /NewsArticle\/([\d\.]*)/i.exec(navigator.userAgent);
return t ? t[1] : "";
}

function _getAndroidVersion() {
var t = /android ([0-9\.]*)/i.exec(navigator.userAgent);
return t ? t[1] : "";
}

function _getIOSVersion() {
var t = /iPhone OS ([0-9_]*)/i.exec(navigator.userAgent);
return t ? t[1].replace(/_/g, ".") : "";
}

function _isNewsArticleVersionNoLessThan(t) {
var e = client.newsArticleVersion;
return e ? (t = t.split(".").slice(0, 3), e = +e.split(".").slice(0, t.length).join(""), 
e >= +t.join("")) : !1;
}

function hash2string(t) {
var e = "#";
for (var a in t) e += a + "=" + t[a] + "&";
return "&" == e.substr(-1) ? e = e.slice(0, -1) : "#" == e.substr(-1) && (e = ""), 
e;
}

function formatCount(t, e, a) {
var i = "";
if ("number" != typeof e || 0 === e) i = a || "赞"; else if (1e4 > e) i = e; else if (1e8 > e) {
var n = (Math.floor(e / 1e3) / 10).toFixed(1);
i = (n.indexOf(".0") > -1 || n >= 10 ? n.slice(0, -2) : n) + "万";
} else {
var n = (Math.floor(e / 1e7) / 10).toFixed(1);
i = (n.indexOf(".0") > -1 || n >= 10 ? n.slice(0, -2) : n) + "亿";
}
return t && $(t).each(function() {
$(this).attr("realnum", e).html(i);
}), i;
}

function commentTimeFormat(t) {
var e, a = new Date(), i = "";
try {
if (e = new Date(1e3 * t), isNaN(e.getTime())) throw new Error("Invalid Date");
} catch (n) {
return "";
}
return i += e.getFullYear() < a.getFullYear() ? e.getFullYear() + "-" : "", i += e.getMonth() >= 9 ? e.getMonth() + 1 : "0" + (e.getMonth() + 1), 
i += "-", i += e.getDate() > 9 ? e.getDate() : "0" + e.getDate(), i += " ", i += e.getHours() > 9 ? e.getHours() : "0" + e.getHours(), 
i += ":", i += e.getMinutes() > 9 ? e.getMinutes() : "0" + e.getMinutes();
}

function formatDuration(t) {
if (isNaN(Number(t))) return "00:00";
var e = [ Math.floor(t / 60), ":", Math.ceil(t % 60) ];
return e[2] <= 9 && e.splice(2, 0, 0), e[0] <= 9 && e.unshift(0), e.join("");
}

function formatTime(t) {
var e = 6e4, a = 60 * e, i = new Date(), n = i.getTime(), r = new Date(i.getFullYear(), i.getMonth(), i.getDate()), o = new Date(+t);
if (isNaN(o.getTime())) return "";
var s = n - t;
if (0 > s) return "";
if (e > s) return "刚刚";
if (a > s) return Math.floor(s / e) + "分钟前";
if (24 * a > s) return Math.floor(s / a) + "小时前";
for (var l = (o.getHours() > 9 ? o.getHours() : "0" + o.getHours()) + ":" + (o.getMinutes() > 9 ? o.getMinutes() : "0" + o.getMinutes()), c = 0; c++ <= 8; ) if (r.setDate(r.getDate() - 1), 
t > r.getTime()) return 1 === c ? "昨天 " + l : 2 === c ? "前天 " + l : c + "天前";
return (o.getFullYear() < i.getFullYear() ? o.getFullYear() + "年" : "") + (o.getMonth() + 1) + "月" + o.getDate() + "日";
}

function send_umeng_event(t, e, a) {
var i = "bytedance://" + event_type + "?category=umeng&tag=" + t + "&label=" + e;
if (a) for (var n in a) {
var r = a[n];
if ("extra" === n && "object" == typeof r) if (client.isAndroid) i += "&extra=" + JSON.stringify(r); else {
var o = "";
for (var s in r) o += "object" == typeof r[s] ? "&" + s + "=" + JSON.stringify(r[s]) : "&" + s + "=" + r[s];
i += o;
} else i += "&" + n + "=" + r;
}
try {
window.webkit.messageHandlers.observe.postMessage(i);
} catch (l) {
console.log(i);
}
}

function sendUmengEventV3(t, e, a) {
if ("string" == typeof t && "" !== t) {
var i = "log_event_v3?event=" + t + "&params=" + JSON.stringify(e || {}) + "&is_double_sending=" + (a ? "1" : "0");
sendBytedanceRequest(i);
}
}

function send_request(t, e) {
var a = "bytedance://" + t;
if (e) {
a += "?";
for (var i in e) a += i + "=" + e[i] + "&";
a = a.slice(0, -1);
}
location.href = a;
}

function send_exposure_event_once(t, e, a) {
function i() {
r && clearTimeout(r), r = setTimeout(function() {
var a = n(t, o);
console.info(a, t), a && (e(), document.removeEventListener("scroll", i, !1));
}, 50);
}
function n(t, e) {
var i = t.getBoundingClientRect(), n = i.top, r = i.height || i.bottom - i.top, o = n;
return a && (o = n + r), e >= o;
}
if (t && "function" == typeof e) {
var r = 0, o = window.innerHeight;
n(t, o) ? e() : document.addEventListener("scroll", i, !1);
}
}

function isElementInViewportY(t, e) {
var a = t.getBoundingClientRect(), i = window.innerHeight || document.body.clientHeight;
return e ? a.height < i ? a.top >= 0 && a.top <= i && a.bottom >= 0 && a.bottom <= i : a.top <= 0 && a.bottom >= i : a.top <= i && a.bottom >= 0;
}

function sendUmengWhenTargetShown(t, e, a, i, n, r) {
t && (isElementInViewportY(t, n) ? r && 3 === r.version ? sendUmengEventV3(e, i, !!r.isDoubleSend) : send_umeng_event(e, a, i) : imprProcessQueue.push(arguments));
}

function wendaCacheAdd(t) {
WendaCacheUmeng.push(t);
}

function wendaCacheRemove() {
var t, e;
for (t = 0, e = WendaCacheUmeng.length; e > t; t++) "function" == typeof WendaCacheUmeng[t] && WendaCacheUmeng[t]();
WendaCacheUmeng = [];
}

function buildServerVIcon(t, e) {
var a = Page.h5_settings.user_verify_info_conf["" + t];
if (!a) return "";
if (a = a[e], !a) return "";
var e = a.icon;
return e = client.isIOS ? a.web_icon_ios : client.isSeniorAndroid ? a.web_icon_android : a.icon_png, 
'<i class="server-v-icon" style="background-image: url(' + e + ');">&nbsp;</i>';
}

function buildServerVIcon2(t, e) {
var a = Page.h5_settings.user_verify_info_conf["" + t];
if (!a) return "";
if (a = a[e], !a) return "";
var e = a.icon;
return e = client.isIOS ? a.web_icon_ios : parseFloat(client.osVersion) > 4.4 ? a.web_icon_android : a.icon_png, 
'<div class="server-v-icon-wrap"><i class="server-v-icon" style="background-image: url(' + e + ');">&nbsp;</i></div>';
}

function trans_v_info(t) {
var e = {};
if (Array.isArray(t.type_config)) for (var a = 0; a < t.type_config.length; a++) {
var i = t.type_config[a];
e[i.type] = i;
}
return e;
}

function nz_closest(t, e) {
for (var a = t.matches || t.webkitMatchesSelector || t.mozMatchesSelector || t.msMatchesSelector; t; ) {
if (a.call(t, e)) return t;
t = t.parentElement;
}
return null;
}

function buildScoreByStar(t) {
var e = "";
t = parseInt(t), 0 > t ? t = 0 : t > 10 && (t = 10);
for (var a = 0; 10 > a; a++) {
var i;
a % 2 === 1 && (i = a > t ? "empty" : a === t ? "half" : "full", e += '<span class="score-star ' + i + '"></span>');
}
return e;
}

function buildPage(t) {
function e() {
var e = t.h5_extra, a = {
font_size: e.font_size || "m",
image_type: e.image_type || "thumb",
is_daymode: !!e.is_daymode,
use_lazyload: !!e.use_lazyload,
url_prefix: e.url_prefix || "content://com.ss.android.article.base.ImageProvider/",
group_id: e.str_group_id || e.group_id || ""
};
return a;
}
function a() {
var t = {
font_size: getMeta("font_size") || "m",
image_type: getMeta("load_image") || "thumb",
is_daymode: getMeta("night_mode") ? !1 : !0,
use_lazyload: "undefined" == typeof window.close_lazyload ? !0 : !1,
url_prefix: "undefined" == typeof window.url_prefix ? "content://com.ss.android.article.base.ImageProvider/" : window.url_prefix,
group_id: getMeta("group_id") || ""
};
return t;
}
function i() {
var t = {
font_size: hash("tt_font") || "m",
image_type: hash("tt_image") || "thumb",
is_daymode: "1" == hash("tt_daymode"),
use_lazyload: !!parseInt(getMeta("lazy_load")),
url_prefix: "",
group_id: ""
};
return t;
}
var n = {
v55: {
android: a,
ios: i
},
v60: {
ios: e,
android: e
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
var e = "zhuanma";
if ("object" == typeof t.wenda_extra) e = "wenda"; else if ("object" == typeof t.forum_extra) e = "forum"; else if ("object" == typeof t.h5_extra) {
var a = t.h5_extra.media;
"object" == typeof a && null !== a && 0 != a.id && (e = "pgc");
}
return e;
},
wenda: function() {
var e = t.wenda_extra, a = e.user || {};
t.wenda_extra.title = _.escape(t.wenda_extra.title), r.article = {
title: e.title,
publishTime: e.show_time
}, r.author = {
userId: a.user_id,
name: a.user_name,
link: r.h5_settings.is_liteapp ? "javascript:;" : a.schema + "&group_id=" + e.ansid + "&from_page=detail_answer_wenda",
intro: a.user_intro,
avatar: a.user_profile_image_url,
isAuthorSelf: !1,
verifiedContent: a.is_verify ? "PLACE_HOLDER" : "",
medals: a.medals
};
var i = {
auth_type: "",
auth_info: ""
};
try {
i = JSON.parse(a.user_auth_info);
} catch (n) {}
r.author.auth_type = a.user_auth_info ? i.auth_type || 0 : "", r.author.auth_info = i.auth_info, 
"is_following" in e && (r.author.followState = e.is_following ? "following" : ""), 
r.wenda_extra = e, r.wenda_extra.aniok = client.isSeniorAndroid, r.statistics.group_id = e.ansid;
},
forum: function() {
var e = window.forum_extra, a = t.h5_extra, i = {};
if (r.article = {
title: e.thread_title || "",
publishTime: formatTime(1e3 * e.publish_timestamp)
}, a.user_info) {
if ("string" == typeof a.user_info) try {
i = JSON.parse(a.user_info);
} catch (n) {
i = {};
} else i = a.user_info;
r.author = {
userId: i.user_id,
name: i.screen_name,
link: i.schema + "&group_id=" + e.thread_id + "&from_page=detail_topic" + (a.category_name ? "&from_page=" + a.category_name : ""),
avatar: i.avatar_url,
isAuthorSelf: !!a.is_author,
verifiedContent: i.verified_content,
medals: i.medals,
remarkName: i.remark_name,
followState: i.is_following ? "following" : ""
};
var o = {
auth_type: "",
auth_info: ""
};
try {
o = JSON.parse(i.user_auth_info);
} catch (s) {}
r.author.auth_type = i.user_auth_info ? o.auth_type || "0" : "", r.author.auth_info = o.auth_info, 
r.tags = [];
var l = [];
"object" == typeof i.media && i.media.name && l.push(i.media.name), i.verified_content && l.push(i.verified_content), 
r.author.intro = l.join("，");
}
r.use_9_layout = a.use_9_layout, r.show_origin = 0 == a.show_origin ? 0 : 1, a.show_tips && (r.show_tips = a.show_tips), 
r.forum_extra = e, a.category_name && (r.category_name = a.category_name), a.log_pb && (r.log_pb = a.log_pb), 
r.forumStatisticsParams = {
value: a.thread_id,
ext_value: a.forum_id,
extra: {
enter_from: a.enter_from,
concern_id: a.concern_id,
refer: a.refer,
group_type: a.group_type,
category_id: a.category_id
}
};
},
pgc: function() {
var e = t.h5_extra, a = e.media || {};
r.article = {
title: e.title,
publishTime: e.publish_stamp ? formatTime(1e3 * e.publish_stamp) : e.publish_time
}, r.author = {
userId: e.media_user_id,
mediaId: a.id,
name: a.name,
link: "sslocal://profile?refer=all&source=article_top_author&uid=" + e.media_user_id + "&group_id=" + r.statistics.group_id + "&from_page=detail_article" + (e.category_name ? "&category_name=" + e.category_name : ""),
intro: a.description,
avatar: a.avatar_url,
isAuthorSelf: !!e.is_author
}, (r.h5_settings.is_liteapp || !e.media_user_id) && (r.author.link = "bytedance://media_account?refer=all&media_id=" + a.id + "&loc=0&entry_id=" + a.id);
var i = {
auth_type: "",
auth_info: ""
};
try {
i = JSON.parse(a.user_auth_info);
} catch (n) {}
r.author.auth_type = a.user_auth_info ? i.auth_type || 0 : "", r.author.auth_info = i.auth_info, 
r.author.verifiedContent = a.user_verified && r.author.auth_info || "", "is_subscribed" in e && (r.author.followState = e.is_subscribed ? "following" : ""), 
e.is_original && r.tags.push("原创"), e.category_name && (r.category_name = e.category_name), 
e.log_pb && (r.log_pb = e.log_pb);
},
zhuanma: function() {
var e = t.h5_extra;
r.article = {
title: e.title,
publishTime: e.publish_time || "0000-00-00 00:00"
}, r.author.name = e.source;
},
common: function() {
var e = t.h5_extra;
if ("custom_style" in t && (r.customStyle = t.custom_style), "novel_data" in e) if ("object" == typeof e.novel_data) r.novel_data = e.novel_data; else if ("string" == typeof e.novel_data) try {
r.novel_data = JSON.parse(e.novel_data);
} catch (a) {}
var i = e.ab_client || [];
r.topbuttonType = "pgc" !== r.article.type || i.indexOf("f7") > -1 ? "concern" : "digg";
try {
r.h5_settings = "object" == typeof e.h5_settings ? e.h5_settings : JSON.parse(e.h5_settings);
} catch (a) {
r.h5_settings = {};
}
r.h5_settings.pgc_over_head = !!r.h5_settings.pgc_over_head && "pgc" === r.article.type, 
r.h5_settings.is_liteapp = !!e.is_lite;
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
r.hasExtraSpace = !r.h5_settings.is_liteapp && client.isSeniorAndroid, r.hideFollowButton = !!e.hideFollowButton, 
r.statistics = {
group_id: e.str_group_id || e.group_id || "",
item_id: e.str_item_id || e.item_id || ""
};
}
};
"object" != typeof t && (t = window);
var s = o.getArticleType();
return r.article.type = s, o.common(), window.OldPage && (r.hasExtraSpace = OldPage.hasExtraSpace), 
o[s](), r.pageSettings = n[APP_VERSION][CLIENT_VERSION](), r.article.type = s, r;
}

function buildHeader(t) {
if (t.author && t.author.userId) {
var e = renderHeader({
data: t
}), a = $("header");
a.length <= 0 ? $(document.body).prepend(e) : a.replaceWith(e);
}
}

function buildArticle(t) {
document.body.classList.add(Page.article.type), document.body.classList.add(CLIENT_VERSION), 
document.body.classList.add(APP_VERSION), "string" == typeof t && $("article").html(t), 
"wenda" === Page.article.type && processWendaArticle(), "forum" === Page.article.type && processForumArticle2();
}

function buildFooter(t) {
var e = renderFooter({
data: t
}), a = $("footer");
a.length > 0 ? a.replaceWith(e) : $(document.body).append(e);
}

function processWendaArticle() {
var t, e = Page.wenda_extra, a = e.show_post_answer_strategy || {}, i = e.wd_version || 0, n = Page.h5_settings.is_liteapp, r = "show_top" in a && !n, o = "show_default" in a && !n;
if (window.wendaStatisticsParams = {
value: e.qid,
ext_value: e.nice_ans_count,
extra: {
enter_from: e.enter_from,
ansid: e.ansid,
parent_enterfrom: e.parent_enterfrom || ""
}
}, window.assignThroughWendaNiceanscount = function(t) {
wendaStatisticsParams.ext_value = t;
}, 1 > i || i >= 3 && 1 == e.showMode) $("header").find(".tt-title").remove(); else {
t = $(r ? '<div class="wt">' + e.title + '</div><div class="ft"><span class="see-all-answers" id="total-answer-count"></span><span class="hide-placeholder">&nbsp;</span></div><a class="big-answer-buttoon go-to-answer" data-type="big" href="' + urlAddQueryParams(a.show_top.schema, {
source: "answer_detail_top_write_answer"
}) + '">' + a.show_top.text + '</a><div class="big-answer-buttoon-gap"></div>' : o ? '<div class="wt">' + e.title + '</div><div class="ft"><a class="go-to-answer go-to-answer-small" data-type="small" href="' + urlAddQueryParams(a.show_default.schema, {
source: "answer_detail_write_answer"
}) + '">回答</a><span class="see-all-answers" id="total-answer-count"></span></div>' : '<div class="wt">' + e.title + '</div><div class="ft"><span class="see-all-answers" id="total-answer-count"></span><span class="hide-placeholder">&nbsp;</span></div>');
var s = r ? "bigans" : o ? "smlans" : "noans";
$("header").find(".tt-title").removeClass("tt-title").addClass("wenda-title " + s + " title-type" + (e.answer_detail_type || 0)).html(t).on("click", function() {
return "wenda_title_handle" in e && e.wenda_title_handle ? void (ToutiaoJSBridge && ToutiaoJSBridge.call("clickWendaDetailHeader")) : void ("need_return" in e ? e.need_return ? ToutiaoJSBridge && ToutiaoJSBridge.call("close") : e.list_schema && (window.location.href = e.list_schema) : [ "click_answer", "click_answer_fold" ].indexOf(e.enter_from) > -1 ? ToutiaoJSBridge && ToutiaoJSBridge.call("close") : e.list_schema && (window.location.href = e.list_schema));
}), new PressState({
bindSelector: ".wenda-title,.big-answer-buttoon",
exceptSelector: ".go-to-answer-small,.see-all-answers",
pressedClass: "pressing",
removeLatency: 500
}), r ? (send_umeng_event("answer_detail", "top_write_answer_show", wendaStatisticsParams), 
$(".go-to-answer").on("click", function(t) {
t.stopPropagation(), send_umeng_event("answer_detail", "top_write_answer", wendaStatisticsParams);
})) : o && (window.wenda_extra && window.wenda_extra.answer_detail_type ? wendaCacheAdd(function() {
send_umeng_event("answer_detail", "wirte_answer_show", wendaStatisticsParams);
}) : send_umeng_event("answer_detail", "wirte_answer_show", wendaStatisticsParams), 
$(".go-to-answer").on("click", function(t) {
t.stopPropagation(), send_umeng_event("answer_detail", "wirte_answer", wendaStatisticsParams);
}));
}
$("#wenda_index_link").on("click", function() {
[ "click_answer", "click_answer_fold" ].indexOf(e.enter_from) > -1 ? ToutiaoJSBridge.call("close") : location.href = e.list_schema;
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

function update_forum_tags(t) {
"string" == typeof t && (t = t.split(","));
var e = $('<div class="article-tags">');
t.forEach(function(t) {
"" !== t && e.append($('<div class="article-tag">').html(t));
}), t.length >= 1 ? $(".name-link-w").removeClass("no-intro") : "" === $(".sub-title").text() && $(".name-link-w").addClass("no-intro"), 
$(".article-tags").replaceWith(e);
}

function on_page_disappear() {
"object" == typeof window.mediasugScroll && null !== window.mediasugScroll && "function" == typeof window.mediasugScroll.pushimpr && window.mediasugScroll.pushimpr(!1);
}

function set_info(t) {
if ("string" == typeof t) t = JSON.parse(t); else if ("object" != typeof t) return;
$.extend(window.globalWendaStates, t), "is_concern_user" in t && change_following_state(!!t.is_concern_user), 
"brow_count" in t && ($(".brow-count").text(t.brow_count), formatCount(".brow-count", t.brow_count, "0")), 
"is_digg" in t && "digg_count" in t && (t.is_digg && $("#digg").attr({
"wenda-state": "digged",
aniok: "false"
}), formatCount(".digg-count", t.digg_count, "赞"), formatCount(".digg-count-special", t.digg_count, "0")), 
"is_buryed" in t && "bury_count" in t && (t.is_buryed && $("#bury").attr({
"wenda-state": "buryed",
aniok: "false"
}), formatCount(".bury-count", t.bury_count, "踩")), "is_show_bury" in t && t.is_show_bury && $("#bury").show().parent().removeClass("only-one").addClass("only-two");
}

function getElementPosition(t) {
var e = /^.image:nth-child\((\d+)\)$/, a = t.match(e);
a && (t = ".image-container:nth-child(" + a[1] + ")>.image");
var i = "{{0,0},{0,0}}", n = document.querySelector(t);
if (n) {
var r = n.getBoundingClientRect();
i = "{{" + (r.left + window.pageXOffset) + "," + (r.top + window.pageYOffset) + "},{" + r.width + "," + r.height + "}}";
}
return i;
}

function setFontSize(t) {
var e = t.split("_")[0], a = (t.split("_")[1], [ "s", "m", "l", "xl" ]), i = $.map(a, function(t) {
return "font_" + t;
}).join(" ");
a.indexOf(e) > -1 && $("body").removeClass(i).addClass("font_" + e);
}

function setDayMode(t) {
var e = [ 0, 1, "0", "1" ];
e.indexOf(t) > -1 && (t = parseInt(t), $(document.body)[t ? "removeClass" : "addClass"]("night"));
}

function appCloseVideoNoticeWeb(t) {
var e = $('[data-vid="' + t + '"]');
e.each(function() {
$(this).css("display", "block"), $(this).next(".cv-wd-info-wrapper").show();
}), $("body").css("margin-top", "0px");
}

function getVideoFrame(t) {
var e = document.querySelector('[data-vid="' + t + '"]'), a = "{{0,0},{0,0}}";
if (e) {
var i = e.getBoundingClientRect();
a = "{{" + i.left + "," + e.offsetTop + "},{" + i.width + "," + i.height + "}}";
}
return a;
}

function processMenuItemPressEvent() {
ToutiaoJSBridge.call("typos", {
strings: getThreeStrings()
});
}

function getThreeStrings() {
var t = "", e = "", a = "", i = document.getSelection();
if ("Range" !== i.type) return [ t, e, a ];
var n = i.getRangeAt(0);
if (!n) return [ t, e, a ];
try {
t = n.startContainer.textContent.substring(0, n.startOffset).substr(-20), e = n.toString(), 
a = n.endContainer.textContent.substring(n.endOffset).substring(0, 20);
} catch (r) {}
return n.detach(), n = null, [ t, e, a ];
}

function subscribe_switch(t) {
"pgc" == Page.article.type && change_following_state(!!t);
}

function dealNovelButton(t, e, a, i) {
t.preventDefault(), send_umeng_event("detail", e.is_concerned ? "click_fictioncard_discare" : "click_fictioncard_care", i), 
$.ajax({
url: "http://ic.snssdk.com/concern/v1/commit/" + (e.is_concerned ? "discare/" : "care/"),
dataType: "jsonp",
data: {
concern_id: e.concern_id
},
beforeSend: function() {
return e.isclicking ? !1 : void (e.isclicking = !0);
},
complete: function() {
e.isclicking = !1;
},
error: function() {
ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
icon_type: "icon_error"
});
},
success: function(t) {
return 0 != t.err_no ? (ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
con_type: "icon_error"
}), !1) : (e.is_concerned = !e.is_concerned, a.attr("is-concerned", Boolean(e.is_concerned)).html(e.is_concerned ? "已加入" : "加入书架"), 
ToutiaoJSBridge.call("page_state_change", {
type: "concern_action",
id: e.concern_id,
status: e.is_concerned ? 1 : 0
}), ToutiaoJSBridge.call("page_state_change", {
type: "forum_action",
id: e.forum_id,
status: e.is_concerned ? 1 : 0
}), send_umeng_event(e.is_concerned ? "concern_novel" : "unconcern_novel", "detail", {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id,
novel_id: e.id
}
}), void sendUmengEventV3(e.is_concerned ? "concern_novel_detail" : "unconcern_novel_detail", {
item_id: +Page.statistics.item_id,
group_id: +Page.statistics.group_id,
novel_id: e.id
}, !0));
}
});
}

function dealOptionalStockButton(t, e, a, i, n) {
t.stopPropagation(), send_umeng_event("stock", "article_add_stock", n);
var r, o = 0, s = e.attr("data-stock"), l = 0;
i.forEach(function(t, e) {
t.code == s && (l = e, r = t.market), 0 == t.selected && o++;
}), 1 != i[l].selected && $.ajax({
url: "http://ic.snssdk.com/stock/like/",
dataType: "jsonp",
data: {
code: s,
market: r
},
beforeSend: function() {
return i[l].isclicking || 1 == i[l].selected ? !1 : void (i[l].isclicking = !0);
},
complete: function() {
i[l].isclicking = !1;
},
error: function() {
ToutiaoJSBridge.call("toast", {
text: "操作失败，请重试",
icon_type: "icon_error"
});
},
success: function(t) {
return 1 != t.code ? (ToutiaoJSBridge.call("toast", {
text: 0 == t.code && t.data.msg ? t.data.msg : "操作失败，请重试",
con_type: "icon_error"
}), !1) : (a.stocks.click_mount++, "single" === e.attr("type") ? e.attr("selected", "") : (e.removeClass("pcard-w1").addClass("pcard-w3").html('<i class="pcard-icon opstock-iconfont icon-done"></i>已添加'), 
o > 3 && (e.css("height", 0), $parent = e.parent(), $parent.on("webkitAnimationEnd", function() {
$parent.remove();
}), $parent.on("animationend", function() {
$parent.remove();
}), $parent.addClass("ant-notification-fade-leave"))), void (i[l].selected = !0));
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
var t = context.wenda_context;
if (window.wendaContext = t, "is_author" in t && (t.is_author ? ($(".follow-button").hide(), 
$(".author-function-buttons").hide(), $(".wenda-info").show()) : "wenda" === Page.article.type && Page.h5_settings.is_liteapp ? ($(".follow-button").hide(), 
$(".author-function-buttons").hide(), $(".wenda-info").hide()) : ($(".author-function-buttons").show(), 
$(".follow-button").show(), $(".wenda-info").hide())), "is_author" in t && t.is_author ? (Page.author.isAuthorSelf = !!t.is_author, 
$(".wd-footer .editor-edit-answer").attr("href", t.edit_answer_schema).show(), $(".wd-footer .dislike-and-report").hide()) : ($(".wd-footer .editor-edit-answer").hide(), 
"detail_related_report_style" in wenda_extra && 0 !== wenda_extra.detail_related_report_style && wenda_extra.wd_version >= 13 ? $(".wd-footer .dislike-and-report").hide() : $(".wd-footer .dislike-and-report").show()), 
"is_author" in t && t.is_author || ("detail_related_report_style" in wenda_extra && (2 === wenda_extra.detail_related_report_style || 3 === wenda_extra.detail_related_report_style) && wenda_extra.wd_version >= 13 ? ($(".report").hide(), 
$(".sep.for-report").hide()) : ($(".report").show(), "detail_related_report_style" in wenda_extra && 1 === wenda_extra.detail_related_report_style && wenda_extra.wd_version >= 13 ? $(".report").addClass("dislike-and-report").text("不喜欢").removeClass("report") : $(".sep.for-report").show())), 
"brow_count" in t && ($(".brow-count").text(t.brow_count), formatCount(".brow-count", t.brow_count, "0")), 
"all_brow_count" in t || "fans_count" in t) {
var e = [];
"all_brow_count" in t && e.push(formatCount(!1, t.all_brow_count, "0") + "阅读"), 
"fans_count" in t && e.push(formatCount(!1, t.fans_count, "0") + "粉丝"), e.length > 0 && setTimeout(function() {
$("#wenda-user-intro").html(e.join(" · "));
}, 50);
}
if ("linkurl" in t && t.linkurl && $("#wd-link-more").attr("href", "sslocal://webview?url=" + encodeURIComponent(t.linkurl) + "&title=%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88").show(), 
"is_digg" in t && "digg_count" in t && (t.is_digg && $("#digg").attr({
"wenda-state": "digged",
aniok: "false"
}), formatCount(".digg-count", t.digg_count, "赞"), formatCount(".digg-count-special", t.digg_count, "0")), 
"is_buryed" in t && "bury_count" in t && (t.is_buryed && $("#bury").attr({
"wenda-state": "buryed",
aniok: "false"
}), formatCount(".bury-count", t.bury_count, "踩"), t.is_buryed && $(".dislike-and-report").css("color", "#999999").text("已反对"), 
wenda_extra.wd_version >= 6)) {
var a = t.is_buryed;
$('[item="dislike-and-report"]').on("click", function() {
var t = this;
ToutiaoJSBridge.call("dislike", {
options: 17
}, function(e) {
0 == e.err_no && (a ? wenda_extra.wd_version >= 8 && ($(t).removeClass("is-buryed"), 
t.innerHTML = "反对", a = !a) : ($(t).addClass("is-buryed"), t.innerHTML = "已反对", 
a = !a));
});
});
}
if ("is_show_bury" in t && t.is_show_bury && $("#bury").show().parent().removeClass("only-one").addClass("only-two"), 
"is_concern_user" in t && change_following_state(!!t.is_concern_user), "ans_count" in t && ($("#total-answer-count").html(t.ans_count + "个回答").css("display", "inline-block"), 
$("#total-answer-count-index").html("全部" + t.ans_count + "个回答")), "nice_ans_count" in t && "wenda_extra" in window && ("function" == typeof window.assignThroughWendaNiceanscount ? window.assignThroughWendaNiceanscount(t.nice_ans_count) : window.wenda_extra.nice_ans_count = t.nice_ans_count), 
"question_schema" in t && t.question_schema && (window.wenda_extra.list_schema = t.question_schema), 
"post_answer_schema" in t && t.post_answer_schema && $(".go-to-answer").attr("href", urlAddQueryParams(t.post_answer_schema, {
source: "big" === $(".go-to-answer").attr("data-type") ? "answer_detail_top_write_answer" : "answer_detail_write_answer"
})), "is_following" in t && Page && Page.author && (Page.author.followState = t.is_following ? "following" : ""), 
"gd_ext_json" in t) {
var i = t.gd_ext_json || {};
if ("string" == typeof t.gd_ext_json) try {
i = JSON.parse(t.gd_ext_json);
} catch (n) {
i = {};
}
window.wenda_extra.gd_ext_json = i, "category_name" in i && "wenda" === Page.article.type && (Page.author.link = Page.author.link + "&category_name=" + i.category_name, 
$(".author-avatar-link").attr("href", Page.author.link), $(".author-name-link").attr("href", Page.author.link), 
$(".sub-title-w").attr("href", Page.author.link));
}
if ((!("show_next" in t) || t.show_next) && ($(".serial").show(), "has_next" in t)) {
var r = $("#next_answer_link");
t.has_next ? (r.attr("href", t.next_answer_schema), r.attr("onclick", null)) : (r.attr("onclick", null), 
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
var t = document.querySelector("#profile"), e = document.querySelector(".wenda-title"), a = 0, i = 0;
e && (a = e.getBoundingClientRect().height), t && (i = t.getBoundingClientRect().height + 20 + a), 
ToutiaoJSBridge.call("onGetHeaderAndProfilePosition", {
header_position: a,
profile_position: i
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
$template.on("touchstart", ".star", function(t) {
var e = parseInt(t.target.getAttribute("data-index"));
t.target.getAttribute("data-selected"), $stars.forEach(function(t, a) {
e >= a ? t.setAttribute("data-selected", "true") : t.setAttribute("data-selected", "false");
}), score = e + 1, document.querySelector(".info").innerHTML = starInfo[score], 
lastTimeOutThx && clearTimeout(lastTimeOutThx), lastTimeOutDone && clearTimeout(lastTimeOutDone), 
lastTimeOutThx = setTimeout(function() {
$(".info-wrapper").addClass("move");
}, 500), $(".info-wrapper").addClass("move"), lastTimeOutDone = setTimeout(function() {
var t = {
evaluate_id: JSON.stringify({
gid: group_id,
style: "star",
string_id: score_card_info_string,
interval: Date.now() - startTime
}),
survey_type: "point",
prefer_id: score
};
if ($.extend(!0, t, networkCommonParams), $.ajax({
url: "https://eva.snssdk.com/eva/survey.json",
dataType: "jsonp",
data: t,
error: function() {},
success: function() {}
}), !has_scored) {
scoredArticle = scoredArticle ? scoredArticle + "," + group_id : group_id;
try {
localStorage.setItem("article_detail_score", scoredArticle);
} catch (e) {}
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
$stars.forEach(function(t) {
t.setAttribute("data-selected", "false");
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
$template.on("click", ".emoji-button", function(t) {
var e = $(t.target).closest(".emoji-button"), a = parseInt(e.attr("data-score"));
if (a !== last_score) {
var i = e.attr("data-type"), n = parseInt(e.attr("data-index")), r = {
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
last_score = a, $emojiButtons.forEach(function(t, e) {
n === e ? t.setAttribute("data-status", "selected") : t.setAttribute("data-status", "unselected");
}), emojiAnimationArray[n] && emojiAnimationArray[n].destroy();
var s = bodymovin.loadAnimation({
container: document.querySelector("#" + i + "-press-animation"),
path: baseFilePath() + "images/score-" + i + "/data.json",
renderer: "svg",
loop: !1,
autoplay: !0
});
emojiAnimationArray[n] = s, send_umeng_event("score_card", "click", {
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
var t;
try {
t = localStorage.getItem("article_detail_score");
} catch (e) {}
var a = Page.statistics.group_id;
if (t) {
var i = t.split(",");
if (i.indexOf(a) > -1) return;
}
var n = {};
client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6") ? ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(t) {
n = t.data || t, 1 === Page.h5_settings.score_card_style ? processScoreCardByStar(n) : 2 === Page.h5_settings.score_card_style && processScoreCardByEmoji(n);
}) : 1 === Page.h5_settings.score_card_style ? processScoreCardByStar(n) : 2 === Page.h5_settings.score_card_style && processScoreCardByEmoji(n);
}
}

function followActionHandler() {
var t = $(this), e = t.data("userId"), a = t.data("mediaId"), i = t.hasClass("following"), n = t.attr("data-concerntype") || "", r = Page.article.type, o = "" === n, s = Page.hasExtraSpace && o;
if (!t.hasClass("disabled")) if ($(".subscribe-button").addClass("disabled"), $("header").addClass("canmoving"), 
$(".boot-outer-container").css("display", "none"), "pgc" === r) doFollowMedia(e, a, i, n), 
s && !Page.author.hasRedPack && (i ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError)); else if ("wenda" === r) {
doFollowUser(e, a, i, void 0, followSource.wenda, "answer_detail_top_card");
var l = $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_top_card",
position: "detail",
to_user_id: e,
follow_type: "from_group",
group_id: wenda_extra.ansid,
server_source: 28
});
Page.author.hasRedPack && (l.is_redpacket = 1), sendUmengEventV3(i ? "rt_unfollow" : "rt_follow", l), 
s && (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.3.3")) && (i ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError));
} else "forum" === r && (doFollowUser(e, a, i, void 0, followSource.forum, "detail"), 
s && (client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6")) && (i ? "open" === $("header").attr("sugstate") ? NativePlayGif.willStart(function() {
$("header").attr("sugstate", "no");
}) : $("header").attr("sugstate", "no") : doRecommendUsers(Page.author.userId, recommendUsersSuccess, recommendUsersError)), 
(client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) && sendUmengEventV3(i ? "rt_unfollow" : "rt_follow", {
to_user_id: e,
follow_type: "from_group",
group_id: forum_extra.thread_id,
item_id: forum_extra.thread_id,
category_name: Page.category_name,
source: "weitoutiao_detail",
server_source: followSource.forum,
position: "title_below",
log_pb: Page.log_pb
}, !1));
}

function followBottomAction() {
var t = $(this), e = t.data("userId"), a = t.data("mediaId"), i = t.hasClass("following");
if (!t.hasClass("disabled")) {
if ($(".subscribe-button-bottom").addClass("disabled"), $(".boot-outer-container").css("display", "none"), 
"wenda" === Page.article.type) {
var n = $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_bottom_card",
position: "detail",
to_user_id: e,
follow_type: "from_group",
group_id: wenda_extra.ansid,
server_source: 80
});
Page.author.hasRedPack && (n.is_redpacket = 1), sendUmengEventV3(i ? "rt_unfollow" : "rt_follow", n);
}
doFollowUser(e, a, i, void 0, followSource[Page.article.type] || "", "wenda" === Page.article.type ? "answer_detail_bottom_card" : "detail_bottom");
}
}

function mediasugArrowAction() {
var t = $("header"), e = "close" === t.attr("sugstate");
NativePlayGif.willStart(function() {
t.attr("sugstate", e ? "open" : "close");
}), send_umeng_event("detail", e ? "click_arrow_down" : "click_arrow_up", {
extra: {
source: "article_detail"
}
});
}

function mediasugCardClickHandler(t) {
if (!$(t.target).is(".ms-subs")) {
var e = $(this).attr("it-is-user-id"), a = "", i = "", n = "";
"pgc" === Page.article.type ? (send_umeng_event("detail", "sub_rec_click", {
value: e,
extra: {
source: "article_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_article", i = Page.category_name, n = Page.statistics.group_id) : "forum" === Page.article.type ? (send_umeng_event("follow_card", "click_avatar", {
value: forum_extra.thread_id,
ext_value: e,
extra: {
source: "weitoutiao_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_topic", i = Page.category_name, n = Page.forum_extra.thread_id) : "wenda" === Page.article.type && (send_umeng_event("follow_card", "click_avatar", {
value: wenda_extra.ansid,
ext_value: e,
extra: {
source: "wenda_detail",
profile_user_id: Page.author.userId
}
}), a = "detail_follow_card_wenda", i = wenda_extra.gd_ext_json ? wenda_extra.gd_ext_json.category_name : "", 
n = wenda_extra.ansid), window.location.href = "sslocal://profile?uid=" + e + ("wenda" === Page.article.type ? "&refer=wenda" : "") + "&group_id=" + n + "&from_page=" + a + "&profile_user_id=" + Page.author.userId + (i ? "&category_name=" + i : "");
}
}

function mediasugFollowAction() {
var t = $(this), e = null != t.attr("isfollowing"), a = t.closest(".ms-item").attr("it-is-user-id"), i = t.attr("reason"), n = followSource[Page.article.type + "_sug"], r = t.closest(".ms-item").data("index");
if (t.attr("disabled", !0), "wenda" === Page.article.type) sendUmengEventV3(e ? "rt_unfollow" : "rt_follow", $.extend({}, wenda_extra.gd_ext_json || {}, {
source: "answer_detail_follow_card",
position: "detail",
to_user_id: a,
order: r,
profile_user_id: wenda_extra.user ? wenda_extra.user.user_id : "",
follow_type: "from_recommend"
})); else if ("forum" !== Page.article.type || client.isNewsArticleVersionNoLessThan("6.4.2")) {
if (client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) {
var o = {
source: "detail_follow_card",
to_user_id: a,
order: r,
profile_user_id: Page.author.userId,
follow_type: "from_recommend",
category_name: Page.category_name,
server_source: followSource[Page.article.type + "_sug"],
log_pb: Page.log_pb
};
Page.author.mediaId && (o.media_id = Page.author.mediaId), sendUmengEventV3(e ? "rt_unfollow" : "rt_follow", o, !1);
}
} else send_umeng_event(e ? "unfollow" : "follow", "weitoutiao_detail_sug", {
ext_value: a,
value: forum_extra.thread_id,
extra: {
profile_user_id: Page.author.userId,
source: "weitoutiao_detail"
}
});
ToutiaoJSBridge.call("user_follow_action", {
id: a,
action: e ? "unfollow" : "dofollow",
reason: i,
source: n,
order: r,
from: "sug"
}, function(i) {
t.attr("disabled", null), "object" == typeof i && 1 === +i.code && ("pgc" !== Page.article.type || client.isNewsArticleVersionNoLessThan("6.4.2") || send_umeng_event("detail", e ? "sub_rec_unsubscribe" : "sub_rec_subscribe", {
value: a,
extra: {
source: "article_detail",
profile_user_id: Page.author.userId
}
}), t.attr("isfollowing", e ? null : ""), doRecommendUsers(Page.author.userId, function(t) {
if (Array.isArray(t)) for (var i = t.length, n = 0; i > n; n++) t[n].user_id == a && (t[n].is_following = !e);
}, function() {}));
});
}

function domPrepare() {
var t = document.querySelector(".mediasug-outer-container"), e = document.querySelector(".mediasug-inner-container");
if (t && e) {
t.addEventListener("transitionend", function() {
console.info("transitionend"), NativePlayGif.ended();
}, !1);
var a = window.MutationObserver || window.WebKitMutationObserver;
if (a) {
var i = new a(function(t) {
t.forEach(function(t) {
var e = t.attributeName;
if ("sugstate" === e) {
var a = t.target.getAttribute(e);
if ("open" === a) {
console.info("SUG-OEPN"), mediasugScroll.open(), $(document).on("scroll", mediasugScroll.pagescroll), 
ToutiaoJSBridge.on("webviewScrollEvent", function(t) {
mediasugScroll.webviewScroll(t);
});
var i, n;
"pgc" === Page.article.type ? (i = "article_detail", n = Page.statistics.group_id) : "forum" === Page.article.type ? (i = "weitoutiao_detail", 
n = forum_extra.thread_id) : "wenda" === Page.article.type && (i = "wenda_detail", 
n = wenda_extra.ansid), send_umeng_event("follow_card", "show", {
value: n,
extra: {
source: i
}
});
} else "close" === a ? (console.info("SUG-HIDE"), $(document).off("scroll", mediasugScroll.pagescroll), 
mediasugScroll.pushimpr(!0)) : (console.info("SUG-HIDE"), $(document).off("scroll", mediasugScroll.pagescroll), 
mediasugScroll.pushimpr(!0));
}
});
});
i.observe(document.getElementsByTagName("header")[0], {
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
list.forEach(function(t) {
if (t.user_auth_info && "string" == typeof t.user_auth_info) try {
t.user_auth_info = JSON.parse(t.user_auth_info);
} catch (e) {
t.user_auth_info = {};
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

function doFollowUser(t, e, a, i, n, r) {
subscribeTimeoutTimer = setTimeout(change_following_state, 1e4, a, !0), ToutiaoJSBridge.call("user_follow_action", {
id: t,
action: a ? "unfollow" : "dofollow",
reason: i,
source: n,
from: r
}, function(t) {
clearTimeout(subscribeTimeoutTimer), t && "object" == typeof t && 1 === +t.code ? change_following_state(!!t.status, !0) : change_following_state(a, !0);
});
}

function doFollowMedia(t, e, a, i) {
subscribeTimeoutTimer = setTimeout(change_following_state, 1e4, a, !0), ToutiaoJSBridge.call(a ? "do_media_unlike" : "do_media_like", {
id: e,
uid: t,
concern_type: i,
source: !a && Page.author.hasRedPack ? followSource.pgc + 1e3 : followSource.pgc
}, function(i) {
clearTimeout(subscribeTimeoutTimer), 1 === +i.code ? change_following_state(!a, !0, function(a) {
client.isNewsArticleVersionNoLessThan("6.4.2") ? (client.isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.4.5")) && sendUmengEventV3(a ? "rt_follow" : "rt_unfollow", {
to_user_id: t,
media_id: e,
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
if (Page.show_origin || $(".tt-repost-thread").each(function(t, e) {
$(e).html(Page.show_tips || "原内容已经删除").removeClass("tt-repost-thread").addClass("tt-repost-delete");
}), h5_extra.read_count && h5_extra.read_count >= 0) {
var t = formatCount(null, h5_extra.read_count, "0");
$("#origin-read-count").html(t);
}
for (var e = document.querySelectorAll(".emoji"), a = 0, i = e.length, a = 0; i > a; a++) e[a].style.backgroundImage = "url(http://s3.pstatp.com/toutiao/tt_tps/static/images/ttemoji/" + e[a].classList[1] + "@3x.png)";
}

function bindRepostEvent() {
$(".tt-repost-thread").on("click", function(t) {
var e = $(t.target);
0 === e.closest("a").length && (location.href = this.dataset.openUrl);
}), $(".tt-repost-ugcvideo").on("click", function(t) {
var e = $(t.target);
0 === e.closest(".cover").length && 0 === e.closest(".originuser").length && (location.href = this.dataset.openUrl);
}), $(".out-link").on("click", function() {
sendUmengEventV3("external_link_click", {
category_name: Page.category_name,
group_id: Page.forum_extra.thread_id
});
});
}

function processTable() {
client.isAndroid ? $("table").each(function(t, e) {
$(e).addClass("border").wrap('<div class="table-wrap horizontal_scroll_android"/>');
}) : client.isIOS && $("table").each(function(t, e) {
var a = $(e);
if (a.addClass("border").wrap('<div class="table-wrap horizontal_scroll"/>'), a.width() > innerWidth - 30) {
var i = a.parent(), n = $('<div class="swipe_tip">左滑查看更多</div>');
i.append(n), i.on("touchstart", function() {
n.css("opacity", "0");
}).on("scroll touchend", function() {
0 === this.scrollLeft && n.css("opacity", "1");
}), needCleanDoms.push(i);
}
});
}

function appendVideoImg() {
var t = this.parentNode;
t && (t.style.background = "black");
}

function errorVideoImg() {
var t = this.parentNode;
t && t.removeChild(this);
}

function processCustomVideo() {
$(".custom-video").each(function(t, e) {
var a = $(e), i = e.dataset, n = i.width, r = i.height, o = .75, s = 0, l = o, c = "";
n && r && (s = r / n, o >= s ? l = s : c = "height: 100%; width: auto;");
var d = e.clientWidth;
if (a.css("height", d * l + "px"), i.wendaSource && "object" == typeof window.wenda_extra) {
var _ = formatDuration(i.duration);
if (a.html('<img src="' + i.poster + '" style="' + c + '" onload="appendVideoImg.call(this)" onerror="errorVideoImg.call(this)" /><i class="custom-video-trigger"></i><i class="custom-video-duration">' + _ + "</i>"), 
"pgc" === i.wendaSource) {
var u = $('<a class="cv-wd-info-wrapper" href="' + i.openUrl + '"><span class="cv-wd-info-name" ' + (Boolean(Number(i.isVerify)) ? "is-verify" : "") + ">" + i.mediaName + '</span><span class="cv-wd-info-pc">' + i.playCount + "次播放</span></a>");
u.on("click", function() {
ToutiaoJSBridge.call("pauseVideo"), send_umeng_event("answer_detail", "click_video_detail", {
value: wenda_extra.ansid,
extra: {
video_id: i.vid,
enter_from: wenda_extra.enter_from || "",
ansid: wenda_extra.ansid,
qid: wenda_extra.qid,
parent_enterfrom: wenda_extra.parent_enterfrom || ""
}
});
}), needCleanDoms.push(u), a.after(u);
}
var p = {
value: wenda_extra.ansid,
extra: {
position: "detail",
video_id: i.vid,
enter_from: wenda_extra.enter_from || "",
ansid: wenda_extra.ansid,
qid: wenda_extra.qid,
parent_enterfrom: wenda_extra.parent_enterfrom || ""
}
};
window.wenda_extra && window.wenda_extra.answer_detail_type ? wendaCacheAdd(function() {
sendUmengWhenTargetShown(e, "video_show", "click_question_and_answer", p, !0);
}) : sendUmengWhenTargetShown(e, "video_show", "click_question_and_answer", p, !0);
} else a.html('<img src="' + i.poster + '" style="' + c + '" onload="appendVideoImg.call(this)" onerror="errorVideoImg.call(this)" /><i class="custom-video-trigger"></i>');
Page.hasExtraSpace = !1;
});
}

function checkDisplayedFactory(t, e) {
return lastBottom = {}, function() {
var a = document.querySelector(t);
if (a) {
var i = a.getBoundingClientRect();
i.bottom < 0 && lastBottom[t] >= 0 ? ToutiaoJSBridge.call(e, {
show: !0
}) : i.bottom >= 0 && lastBottom[t] < 0 && ToutiaoJSBridge.call(e, {
show: !1
}), lastBottom[t] = i.bottom;
}
};
}

function processPageStateChangeEvent(t) {
switch (t.type) {
case "pgc_action":
console.info("pgc_action", t), subscribeTimeoutTimer && clearTimeout(subscribeTimeoutTimer);
var e = $(".subscribe-button"), a = e.data("mediaId");
t.id == a && "status" in t && (change_following_state(!!t.status, !0), t.status && (Page.author.hasRedPack = !1));
break;

case "user_action":
console.info("user_action", t), subscribeTimeoutTimer && clearTimeout(subscribeTimeoutTimer);
var e = $(".subscribe-button"), i = e.data("userId");
if (t.id == i && "status" in t) change_following_state(!!t.status, !0); else {
var n = $('[it-is-user-id="' + t.id + '"]');
n.length > 0 && "status" in t && (n.find(".ms-subs").attr("isfollowing", t.status ? "" : null).attr("disabled", null), 
t.status && mediasugScroll.next(), doRecommendUsers(Page.author.userId, function(e) {
if (Array.isArray(e)) for (var a = e.length, i = 0; a > i; i++) e[i].user_id == t.id && (e[i].is_following = !!t.status);
}, function() {}));
}
break;

case "wenda_digg":
var r = $("#digg").attr("data-answerid");
if (window.wenda_extra && window.wenda_extra.wd_version >= 8 && t.id === window.wenda_extra.ansid) {
var o = +$(".digg-count-special").attr("realnum");
"status" in t && (1 == t.status ? formatCount(".digg-count-special", o + 1, "0") : o > 0 && formatCount(".digg-count-special", o - 1, "0"));
} else if (t.id == r && "digged" !== $("#digg").attr("wenda-state")) {
$("#digg").attr("wenda-state", "digged");
var o = +$("#digg").find(".digg-count").attr("realnum");
formatCount(".digg-count", o + 1, "赞"), formatCount(".digg-count-special", o + 1, "0");
}
break;

case "wenda_bury":
var r = $("#bury").attr("data-answerid");
if (t.id == r && "buryed" !== $("#bury").attr("wenda-state")) {
$("#bury").attr("wenda-state", "buryed");
var s = +$("#bury").find(".bury-count").attr("realnum");
formatCount(".bury-count", s + 1, "踩");
}
break;

case "forum_action":
var l = $(".pcard.fiction").find(".button"), c = l.attr("forum-id");
t.id == c && l.attr("is-concerned", Boolean(t.status)).html(t.status ? "已关注" : "关注");
break;

case "concern_action":
var l = $(".pcard.fiction").find(".button"), d = l.attr("concern-id");
t.id == d && l.attr("is-concerned", Boolean(t.status)).html(t.status ? "已加入" : "加入书架");
break;

case "carousel_image_switch":
"function" == typeof onCarouselImageSwitch && (Page.forum_extra && Page.forum_extra.thread_id == t.id ? onCarouselImageSwitch(t.status) : Page.wenda_extra && Page.wenda_extra.ansid == t.id ? onCarouselImageSwitch(t.status) : Page.statistics.group_id == t.id && onCarouselImageSwitch(t.status));
break;

case "block_action":
if (console.info(t), 1 == t.status) {
var e = $(".subscribe-button"), i = e.data("userId");
if (t.id == i) change_following_state(!1, !0); else {
var n = $('[it-is-user-id="' + t.id + '"]');
n.length > 0 && n.find(".ms-subs").attr("isfollowing", null);
}
}
}
}

function processParagraph() {
var t = /[\u2e80-\u2eff\u3000-\u303f\u3200-\u9fff\uf900-\ufaff\ufe30-\ufe4f]/, e = /[a-z0-9_:\-\/.%]{26,}/gi, a = /huawei/.test(navigator.userAgent.toLowerCase());
a && document.body.classList.add("huawei"), $("article p").each(function(a, i) {
if (!(i.classList.contains("pgc-img-caption") || !i.textContent || $(i).find(".image").length > 0)) if (t.test(i.textContent)) {
if (e.test(i.textContent)) {
var n = i.textContent.match(e);
n.forEach(function(t) {
i.innerHTML = i.innerHTML.replace(t, function(t) {
return '<br class="sysbr">' + t;
});
});
}
} else i.style.textAlign = "left";
});
}

function setContent(t) {
if (startTimestamp = Date.now(), null !== t) {
var e = t.indexOf("<article>"), a = t.indexOf("</article>"), i = t.substring(e + 9, a);
globalContent = i || t;
}
}

function setExtra(t) {
void 0 === t ? globalExtras = window : "object" == typeof t.h5_extra ? globalExtras = t : client.isIOS ? globalExtras.h5_extra = t : client.isAndroid && (globalExtras.h5_extra = $.extend(!0, globalExtras.h5_extra, t)), 
window.Page = buildPage(globalExtras), window.OldPage ? _.isEqual(window.OldPage, window.Page) || (window.OldPage = window.Page, 
buildHeader(window.Page), "forum" == Page.article.type && buildArticle(globalContent)) : (window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_build_article", +new Date() - startTimestamp), 
window.OldPage = window.Page, TouTiao.setDayMode(Page.pageSettings.is_daymode ? 1 : 0), 
TouTiao.setFontSize(Page.pageSettings.font_size), buildUIStyle(Page.h5_settings), 
buildHeader(window.Page), buildArticle(globalContent), buildFooter(window.Page), 
functionName());
}

function functionName() {
sendBytedanceRequest("domReady"), window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_process_article", +new Date() - startTimestamp), 
ToutiaoJSBridge.on("page_state_change", processPageStateChangeEvent), processArticle(), 
window.sendTTCustomizeLog && window.sendTTCustomizeLog("end_process_article", +new Date() - startTimestamp), 
null !== globalCachedContext && contextRenderer(globalCachedContext), canSetContext = !0;
}

function insertDiv(t) {
window.sendTTCustomizeLog && window.sendTTCustomizeLog("start_insert_div", +new Date() - startTimestamp), 
canSetContext ? contextRenderer(t) : globalCachedContext = t;
}

function onQuit() {
Page && Page.author && Page.author.userId && mediasugScroll.clearData(Page.author.userId), 
Page = {}, OldPage = null, globalContent = void 0, canSetContext = !1, window.imageInited = !1, 
window.imageSizeInitTimer && clearTimeout(window.imageSizeInitTimer), appCloseVideoNoticeWeb(), 
NativePlayGif.clean(), needCleanDoms.forEach(function(t) {
t.off();
}), needCleanDoms = [], imprProcessQueue = [], flushErrors(!0), $("header").replaceWith("<header>"), 
$("article").empty(), $("footer").empty(), $(document).off("scroll"), "onGetSeriesLinkPositionTimer" in window && clearInterval(onGetSeriesLinkPositionTimer);
}

function bindStatisticsEvents() {
document.addEventListener("scroll", function() {
imprProcessQueue.length > 0 && imprProcessQueue.forEach(function(t, e, a) {
t && isElementInViewportY(t[0], t[4]) && (t[5] && 3 === t[5].version ? sendUmengEventV3(t[1], t[3], !!t[5].isDoubleSend) : send_umeng_event(t[1], t[2], t[3]), 
a[e] = void 0);
});
}, !1);
var t = $(document.body);
t.on("click", ".pgc-link", function() {
var t, e = "", a = "";
"forum" === Page.article.type ? (send_umeng_event("talk_detail", "click_ugc_header", Page.forumStatisticsParams), 
e = "detail_topic", a = Page.forum_extra.category_name, t = Page.forum_extra.thread_id) : "pgc" === Page.article.type ? (send_umeng_event("detail", "click_pgc_header", {
value: Page.author.mediaId,
extra: {
item_id: Page.statistics.item_id
}
}), e = "detail_article", a = Page.category_name, t = Page.statistics.group_id) : (e = "detail_answer_wenda", 
a = wenda_extra.gd_ext_json ? wenda_extra.gd_ext_json.category_name : "", t = wenda_extra.ansid);
}), t.on("click", "#prev_serial_link", function() {
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
}), t.on("click", ".custom-video", function() {
playVideo(this, 0);
}), t.on("click", "#digg", function() {
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
}), t.on("click", "#bury", function() {
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

function playVideo(t, e) {
var a = t.getAttribute("data-video-size"), i = t.getBoundingClientRect(), n = [ i.left, t.offsetTop, 640, 435 ];
if (a) {
var r = null;
try {
r = JSON.parse(a), r && r.normal && r.normal.h && r.normal.w && (n[2] = r.normal.w, 
n[3] = r.normal.h);
} catch (o) {}
}
ToutiaoJSBridge.call("playNativeVideo", {
sp: t.getAttribute("data-sp"),
vid: t.getAttribute("data-vid"),
frame: n,
status: e
}, function(t) {
if ($(".custom-video").show(), 1 == t.code) {
var e = document.querySelector('[data-vid="' + t.vid + '"]');
e && (e.style.display = "none", $(e).next(".cv-wd-info-wrapper").hide(), window.wenda_extra && window.wenda_extra.wd_version && (t.height += 15), 
document.body.style.marginTop = t.height + "px");
}
});
}

function __w(t, e, a) {
var i = document.createElement(a);
i.classList.add("image-wrap"), t.insertBefore(i, e), i.appendChild(e);
}

function __adjustOriginImageScale(t, e) {
var a = 200, i = 200, n = window.aW / 2;
if (AIP.isDuoTuThread) return [ "ERROR", "ERROR" ];
var r, o, s = t[0] / t[1];
return r = t[0] ? t[0] > n ? window.aW : t[0] : a, o = s ? parseInt(r / s) : i, 
e && (o = Math.min(o, parseInt(.8 * window.iH))), [ r, o ];
}

function __buildGetImageSource(t, e, a) {
return AIP.url_prefix + "getimage/" + t + "/" + e + "/" + AIP.group_id + "/" + a;
}

function __buildImageSource(t, e) {
return AIP.url_prefix + "image/" + t + "/" + e;
}

function onCarouselImageSwitch(t) {
console.info("onCarouselImageSwitch", t);
var e = AIP.pictures[t], a = AIP.threadGGSwitch ? AIP.threadImageType : "origin";
e.url && e.state !== a && (console.info("onCarouselImageSwitch", t, a), e.url = __buildGetImageSource(a, e.zsp, e.index), 
e.state = a, AIP.renderHolder(e));
}

function tellClientContentSize() {
var t = 0;
setInterval(function() {
var e = document.querySelector("footer").getBoundingClientRect(), a = e.top + e.height;
a !== t && (t = a, console.info("tellClientContentSize", a), ToutiaoJSBridge.call("webviewContentResize", {
height: a
}));
}, 200);
}

function processArticle() {
switch (window.aW = document.body.offsetWidth - 30 || window.innerWidth - 30, window.iH = window.innerHeight, 
AndroidImageProcessor.threadGGSwitch = "forum" === Page.article.type && Page.use_9_layout, 
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
var t = document.querySelector(".serial").offsetTop;
t > 0 && (clearInterval(onGetSeriesLinkPositionTimer), ToutiaoJSBridge.call("onGetSeriesLinkPosition", {
value: document.body.scrollHeight - t
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
var t = location.hash.substr(1), e = {};
return t && t.split("&").forEach(function(t) {
t = t.split("=");
var a = t[0], i = t[1];
a && (e[a] = i);
}), function(t, a) {
var i = {};
return void 0 === t && void 0 === a ? location.hash : void 0 === a && "string" == typeof t ? e[t] : ("string" == typeof t && "string" == typeof a ? i[t] = a : void 0 === a && "object" == typeof t && (i = t), 
$.extend(e, i), void (location.hash = hash2string(e)));
};
}(), getMeta = function() {
for (var t = document.getElementsByTagName("meta"), e = {}, a = 0, i = t.length; i > a; a++) {
var n = t[a].name.toLowerCase(), r = t[a].getAttribute("content");
n && r && (e[n] = r);
}
return function(t) {
return e[t];
};
}(), urlAddQueryParams = function(t, e) {
var a, i = [], n = "?";
for (a in e) e.hasOwnProperty(a) && i.push(a + "=" + encodeURIComponent(e[a]));
return -1 !== t.indexOf("?") && (n = "&"), [ t, n, i.join("&") ].join("");
}, event_type = client.isAndroid ? "log_event" : "custom_event", sendBytedanceRequest = function() {
function t() {
o.length > 0 && (i.src = o.shift(), l = Date.now(), e());
}
function e() {
clearTimeout(r), r = setTimeout(t, s);
}
var a = "SEND-BYTE--DANCE-REQUEST", i = document.getElementById(a), n = "bytedance://";
i || (i = document.createElement("iframe"), i.id = a, i.style.display = "none", 
document.body.appendChild(i));
var r, o = [], s = 100, l = Date.now() - s - 1;
return function(t) {
var a = Date.now();
0 === o.length && a - l > s ? (i.src = n + t, l = a) : (o.push(n + t), e());
};
}(), WendaCacheUmeng = [];

!function() {
var t = {};
window.PressState = function(t) {
var e = {
holder: "body",
bindSelector: "",
exceptSelector: "",
pressedClass: "pressed",
triggerLatency: 100,
removeLatency: 100
};
this.settings = $.extend({}, e, t), this._init();
}, PressState.prototype = {
_init: function() {
"" != this.settings.bindSelector && (this._appendClass(), this._bindEvent());
},
_appendClass: function() {
if ("pressed" == this.settings.pressedClass) {
var t = "<style type='text/css'>.pressed{background-color: #e0e0e0 !important;} .night .pressed{background-color: #1b1b1b !important;}</style>";
$("body").append(t);
}
},
_bindEvent: function() {
var e = this.settings.holder, a = "" == this.settings.exceptSelector ? this.settings.bindSelector : [ this.settings.bindSelector, this.settings.exceptSelector ].join(","), i = this.settings.exceptSelector, n = this.settings.pressedClass, r = parseInt(this.settings.triggerLatency), o = parseInt(this.settings.removeLatency);
$(e).on("touchstart", a, function(e) {
if (!$(this).is(i)) {
var a = $(this);
t.mytimer = setTimeout(function() {
a.addClass(n);
}, r), t.tar = e.target;
}
}), $(e).on("touchmove", a, function() {
$(this).is(i) || (clearTimeout(t.mytimer), $(this).removeClass(n), t.tar = null);
}), $(e).on("touchend touchcancel", a, function(e) {
if (!$(this).is(i) && t.tar === e.target) {
clearTimeout(t.mytimer), $(this).hasClass(n) || $(this).addClass(n);
var a = $(this);
setTimeout(function() {
a.removeClass(n);
}, o);
}
});
}
};
}();

var baseFilePath = function() {
function t() {
for (var t = document.querySelectorAll("script"), a = 0, i = t.length; i > a; a++) {
var n = t[a].src, r = n.indexOf("/v55/js/lib.js");
if (r > -1) {
e = n.substr(0, r);
break;
}
if (r = n.indexOf("/v60/js/lib.js"), r > -1) {
e = n.substr(0, r);
break;
}
}
e && (e += "/shared/");
}
var e = "";
return function() {
return e || t(), e;
};
}(), getCommonParams = function() {
function t(t) {
ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(a) {
e = a.data || a, "function" == typeof t && t(e);
});
}
var e;
return t(), function(a) {
e ? "function" == typeof a && a(e) : a && t(a);
};
}(), fnTimeCountDown = function(t, e, a, i) {
var n = {
time_delta: e - new Date().getTime(),
zero: function(t) {
var t = parseInt(t, 10);
return t > 0 ? (9 >= t && (t = "0" + t), String(t)) : "00";
},
dv: function() {
t = t || Date.now();
var e = new Date(t), a = new Date(), r = Math.round((e.getTime() - (a.getTime() + this.time_delta)) / 1e3), o = {
sec: "00",
mini: "00",
hour: "00"
};
return r > 0 ? (o.sec = n.zero(r % 60), o.mini = Math.floor(r / 60) > 0 ? n.zero(Math.floor(r / 60) % 60) : "00", 
o.hour = Math.floor(r / 3600) > 0 ? n.zero(Math.floor(r / 3600) % 24) : "00") : i && i(), 
o;
},
ui: function() {
a.sec && (a.sec.innerHTML = n.dv().sec + "秒"), a.mini && (a.mini.innerHTML = n.dv().mini + "分"), 
a.hour && (a.hour.innerHTML = n.dv().hour + "小时"), setTimeout(n.ui, 1e3);
}
};
n.ui();
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
var t = "out", e = !0;
return function(a) {
if (a && a.needRecord && (e = a.needRecord), e) {
var i = $(".pcard.forum").get(0), n = "out", r = i.getBoundingClientRect();
r.bottom <= (window.innerHeight || document.body.clientHeight) && (n = "in"), "in" === n && "out" === t && (console.info("weitoutiao_in"), 
send_umeng_event("widget", "show_wtt", {
value: $("[data-content]").get(0).dataset.id,
extra: {
card_type: "1"
}
}), e = !1), t = n;
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
return "cards" in context && Array.isArray(context.cards) ? (context.cards.forEach(function(t) {
var e = t.type, a = {
value: Page.statistics.group_id,
extra: {
item_id: Page.statistics.item_id,
card_type: t.type,
card_id: t.id
}
};
if (e in cardTemplateFunctions) {
if (t.isRedButton = Page.isRedFocusButton, "auto" === e) {
t.data_source_show = {
dongchedi: "懂车帝",
yiche: "易车"
}[t.data_source], t.min_price && t.min_price > 0 && (t.show_origin_price = parseFloat(t.min_price), 
t.show_origin_price = t.show_origin_price.toFixed(2), t.show_origin_price_unit = "万起"), 
t.pd_eries_agent_min_price && t.pd_eries_agent_min_price > 0 && (t.show_agent_price = parseFloat(t.pd_eries_agent_min_price), 
t.show_agent_price = t.show_agent_price.toFixed(2), t.show_agent_price_unit = "万起"), 
/^http/.test(t.xunjia_web_url) && (t.xunjia_web_url = "sslocal://webview?url=" + encodeURIComponent(t.xunjia_web_url)), 
a.extra.data_source = "wenda_extra" in Page ? t.data_source + "_wenda" : t.data_source;
var i = $(cardTemplateFunctions[e]({
data: t
}));
} else if ("stock" == e) {
var n = [], r = [];
try {
r = JSON.parse(t.keyphrase_stock);
} catch (o) {}
if (r.forEach(function(e) {
if (t.stocks[e]) try {
n.push(JSON.parse(t.stocks[e]));
} catch (a) {}
}), 0 == n.length) return;
send_umeng_event("stock", "article_with_card", a);
var s = [];
if (s = n.filter(function(t) {
return 0 == t.selected;
}), 0 == s.length) return;
n.map(function(t) {
t.url = "sslocal://webview?hide_bar=1&bounce_disable=1&url=" + encodeURIComponent("http://ic.snssdk.com/stock/slice/?code=" + t.market + t.code + "&from=article"), 
1 == t.selected && s.push(t);
});
var i = $(cardTemplateFunctions[e]({
data: s,
isRedButton: t.isRedButton
}));
} else if ("weitoutiao" == e) {
t = t.weitoutiao;
try {
t.user.auth = JSON.parse(t.user.auth);
} catch (o) {}
if ("image" === t.content_type && t.images && Array.isArray(t.images)) {
switch (t.images.length) {
case 1:
t.img_width = innerWidth / 2, t.img_height = Math.min(t.images[0].height / t.images[0].width * t.img_width, t.img_width);
break;

case 2:
t.img_width = t.img_height = (innerWidth - 33) / 2;
break;

case 3:
t.img_width = t.img_height = (innerWidth - 36) / 3;
break;

default:
t.img_width = t.img_height = (innerWidth - 36) / 3, t.more_img = t.images.length - 3, 
t.images = t.images.splice(0, 3);
}
t.img_width = Math.floor(t.img_width), t.img_height = Math.floor(t.img_height);
}
"video" === t.content_type && (t.img_width = innerWidth - 30, t.img_height = 9 * t.img_width / 16, 
t.img_width = Math.floor(t.img_width), t.img_height = Math.floor(t.img_height)), 
t.useServerV = Page.useServerV;
var i = $(cardTemplateFunctions[e]({
data: t
}));
} else if ("fiction" == e) {
if ("pgc" === Page.article.type && Page.novel_data && !Page.novel_data.can_read) return;
var i = $(cardTemplateFunctions[e](t));
if (t.benefit_time && t.time_now && t.benefit_time - t.time_now < 86400) {
var l = {
sec: i.find("#sec").get(0),
mini: i.find("#mini").get(0),
hour: i.find("#hour").get(0)
};
fnTimeCountDown(1e3 * t.benefit_time, 1e3 * t.time_now, l, function() {
i.find(".tag").css("display", "none"), i.find(".sale").css("display", "none"), i.find(".sale-price").css("display", "none"), 
i.find(".origin-price").removeClass("pcard-w-delete pcard-w9").addClass("pcard-w1");
});
} else i.find("#day").text(Math.ceil((t.benefit_time - t.time_now) / 86400) + "天");
} else var i = $(cardTemplateFunctions[e](t));
i.on("click", ".button", function(e) {
e.stopPropagation(), send_umeng_event("detail", "click_card_button", a);
var i = $(this), n = i.attr("action");
"concern" === n ? dealNovelButton(e, t, i, a) : "addStock" == n && dealOptionalStockButton(e, i, t, s, a);
}), "auto" === e ? (i.find("[data-label]").on("click", function(t) {
t.stopPropagation(), send_umeng_event("detail", "click_" + this.dataset.label, a);
}), i.find('[type="button"]').on("click", function(t) {
t.stopPropagation(), location.href = this.dataset.href, send_umeng_event("detail", "click_card_button", a);
}), i.on("click", "[data-content]", function() {
location.href = this.dataset.href, send_umeng_event("detail", "click_card_content", a);
})) : "stock" === e ? (i.find('[data-label="card_selected"]').on("click", function(t) {
t.stopPropagation(), send_umeng_event("stock", "article_into_mystock", a);
}), i.find('[data-label="card_detail"]').on("click", function(t) {
t.stopPropagation(), send_umeng_event("stock", "article_into_stock", a);
}), i.find('[data-label="card_content"]').on("click", function(t) {
t.stopPropagation(), location.href = this.dataset.href, send_umeng_event("stock", "article_into_stock", a);
})) : "weitoutiao" === e ? i.on("click", "[data-content]", function() {
send_umeng_event("widget", "go_detail", {
value: this.dataset.id,
extra: {
enter_from: "widget_wtt",
card_type: 1
}
}), location.href = this.dataset.href;
}) : i.on("click", function() {
send_umeng_event("detail", "click_card_content", a);
}), needCleanDoms.push(i), "wenda" === Page.article.type ? (isShowWendaFooter = 0, 
$("footer").append(i)) : $("footer").prepend(i), "weitoutiao" === e && ($(".content .title").width() < $(".content .title-inner").width() && $(".content .title-wrap").before('<div class="whole-forum"><a class="whole-forum-inner">全文</a></div>'), 
sendWeitoutiaoCardDisplayEvent({
needRecord: !0
}), $(document).on("scroll", sendWeitoutiaoCardDisplayEvent), needCleanDoms.push($(document))), 
sendUmengWhenTargetShown(i.get(0), "detail", "card_show", a, !0);
}
}), void ("wenda" === Page.article.type && isShowWendaFooter && processWendaFooter())) : ("wenda" === Page.article.type && isShowWendaFooter && processWendaFooter(), 
void ("pgc" === Page.article.type && !Page.novel_data && Page.h5_settings.score_card_style && processScoreCard()));
}(), function() {
if ("know_more_url" in context) {
var t = $('<p><a href="sslocal://webview?url=' + encodeURIComponent(context.know_more_url) + '&title=%E7%BD%91%E9%A1%B5%E6%B5%8F%E8%A7%88">了解更多</a></p>');
$("article").append(t), t.on("click", function() {
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
}), needCleanDoms.push(t);
}
}(), function() {
var t = function() {
return "wenda" !== Page.article.type ? !0 : client.isAndroid && _isNewsArticleVersionNoLessThan("6.4.4") || client.isIOS && _isNewsArticleVersionNoLessThan("6.4.4") ? !0 : !1;
};
"red_pack" in context && context.red_pack && context.red_pack.token && parseInt(context.red_pack.redpack_id) > 0 && (Page.author.hasRedPack = !Page.author.followState && !Page.author.isAuthorSelf, 
Page.author.isFirstPack = context.red_pack.is_first_pack, t() && Page.author.hasRedPack && $(".author-function-buttons").addClass("redpack-button-just-word follow-button-large"), 
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
function t(t) {
var e = $("header"), i = $(".subscribe-button"), n = $(".subscribe-button-bottom");
a = void 0, Page && Page.author && (Page.author.followState = t ? "following" : ""), 
t ? ($(".author-function-buttons").removeClass("redpack-button redpack-button-just-word"), 
i.addClass("following").removeClass("disabled"), e.attr("fbs", "following"), n.addClass("following").removeClass("disabled")) : (i.removeClass("following disabled"), 
e.attr("fbs", ""), e.attr("sugstate", "no"), n.removeClass("following disabled"));
}
var e, a;
return function(i, n, r) {
"function" == typeof r && r(i), n ? i !== a && (clearTimeout(e), a = i, e = setTimeout(t, 450, i, r)) : t(i, r);
};
}(), followSource = {
pgc: 30,
pgc_sug: 34,
forum: 68,
forum_sug: 69,
wenda: 28,
wenda_sug: 71
}, doRecommendUsers = function() {
function t(t, i, n) {
$.ajax({
dataType: "jsonp",
url: "http://ic.snssdk.com/api/2/relation/follow_recommends/",
data: t,
timeout: 1e4,
beforeSend: function() {
return e ? !1 : void (e = !0);
},
success: function(e, r, o) {
"article" in Page && ("success" === e.message && "object" == typeof e.data && Array.isArray(e.data.recommend_users) && e.data.recommend_users.length >= 3 ? (a[t.to_user_id] = e.data.recommend_users, 
domPrepare(), i(e.data.recommend_users)) : n(e, r, o));
},
error: function(t, e, a) {
n(a, e, t);
},
complete: function() {
e = !1;
}
});
}
var e = !1, a = {}, i = {};
return function(e, n, r, o) {
if ("function" == typeof n && "function" == typeof r) {
if (o && o.deleteCache) return void (a[e] && delete a[e]);
if (a[e]) return void n(a[e]);
var s = {
to_user_id: e,
page: 34
};
(client.isAndroid && client.isNewsArticleVersionNoLessThan("6.2.5") || client.isIOS && client.isNewsArticleVersionNoLessThan("6.2.6")) && $.isEmptyObject(i) ? ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(e) {
i = e.data || e, $.extend(!0, s, i), t(s, n, r);
}) : ($.extend(!0, s, i), t(s, n, r));
}
};
}(), mediasugScroll = function() {
var t, e, a, i = innerWidth, n = 150, r = 0, o = {}, s = 0, l = !1, c = [], d = "in", u = null, p = 0, h = $("header").height() + 232;
return {
init: function(d) {
l || (l = !0, o = d, s = d.length, i = innerWidth, r = s * n + 24, this.imprcache = {}, 
this.imprlog = [], c = [], "pgc" === Page.article.type ? (t = "article", e = Page.statistics.group_id) : "forum" === Page.article.type ? (t = "weitoutiao", 
e = Page.forumStatisticsParams.value) : (t = Page.article.type, e = Page.wenda_extra.ansid), 
this.sendResult = {
imp_group_list_type: 19,
imp_group_key_name: "u11_recommend_user_" + t + "_detail_" + Page.author.userId,
imp_group_key: Page.author.userId,
imp_group_extra: {
source: t,
profile_user_id: Page.author.userId
},
impressions_in: [],
impressions_out: []
}, a = _.throttle(mediasugScroll.handler, 150), h = $("header").height() + 232);
},
range: function(t) {
var e = Math.floor(t / n);
e = Math.max(e, 0), t += i;
var a = Math.ceil(t / n);
a = Math.min(a, s) - 1;
for (var r = []; a >= e; ) r[r.length] = e++;
return r;
},
pushimpr: function(a) {
if (l) {
if (this.sendResult.impressions_in = [], Object.keys(this.imprcache).length > 0) {
this.sendResult.impressions_out = [];
for (var i in this.imprcache) {
var n = this.imprcache[i];
this.imprlog.push({
uid: i,
time: n,
duration: new Date().getTime() - n
}), console.info("leave", i), this.sendResult.impressions_out.push({
imp_item_type: 51,
imp_item_id: i,
imp_item_extra: {}
});
}
this.imprcache = {}, a && ToutiaoJSBridge.call("impression", this.sendResult);
}
console.info("pushimpr", this.imprlog), this.imprlog.length > 0 && (send_umeng_event("detail", "sub_reco_impression_v2", {
value: Page.author.userId,
extra: {
group_id: e,
impression: client.isIOS ? encodeURIComponent(JSON.stringify(mediasugScroll.imprlog)) : mediasugScroll.imprlog,
need_decode: client.isIOS ? 1 : 0,
source: t
}
}), this.imprlog = []);
}
},
dealimpr: function(t, e) {
var a = this, i = [];
if (t.forEach(function(t) {
var e = o[t].user_id;
if (e in a.imprcache) {
var n = a.imprcache[e];
a.imprlog.push({
uid: e,
time: n,
duration: new Date().getTime() - n
}), delete a.imprcache[e], a.sendResult.impressions_in = a.sendResult.impressions_in.filter(function(t) {
return t.imp_item_id != e;
}), i.push({
imp_item_type: 51,
imp_item_id: e,
imp_item_extra: {}
}), console.info("leave", e);
}
}), e.forEach(function(t) {
var e = o[t].user_id;
a.imprcache[e] = new Date().getTime(), a.sendResult.impressions_in.push({
imp_item_type: 51,
imp_item_id: e,
imp_item_extra: {}
}), console.info("enter", e);
}), t.length > 0 || e.length > 0) {
a.sendResult.impressions_out = i;
var n = {};
$.extend(!0, n, a.sendResult), ToutiaoJSBridge.call("impression", n);
}
},
handler: function() {
if (l) {
for (var t = mediasugScroll.range(this.scrollLeft || 0), e = [], a = {}, i = 0; i < c.length; i++) a[c[i]] = !0;
for (i = 0; i < t.length; i++) t[i] in a ? delete a[t[i]] : e.push(t[i]);
var n = Object.keys(a);
mediasugScroll.dealimpr(n, e), c = t;
}
},
open: function() {
c = [], mediasugScroll.handler();
},
pagescroll: function() {
if (l) {
var t = $("#mediasug-list").get(0), e = "in", a = t.getBoundingClientRect();
(a.bottom <= 0 || a.top > (window.innerHeight || document.body.clientHeight)) && (e = "out"), 
"in" === e && "out" === d ? (console.info("IN"), mediasugScroll.dealimpr([], c)) : "out" === e && "in" === d && (console.info("OUT"), 
mediasugScroll.pushimpr(!0)), d = e;
}
},
clearData: function(t) {
l = !1, doRecommendUsers(t, function() {}, function() {}, {
deleteCache: !0
});
},
horizontalScrollLeft: function(t) {
null === u && (u = t);
var e = t - u, a = Math.ceil(p / n) * n - p;
a = 0 === a ? n : a, $("#mediasug-list").scrollLeft(p + Math.min(e / 2, a)), 2 * n > e && requestAnimationFrame(mediasugScroll.horizontalScrollLeft);
},
next: function() {
var t = window.requestAnimationFrame || window.webkitRequestAnimationFrame;
p = $("#mediasug-list").scrollLeft(), console.info("current ", p), u = null, setTimeout(function() {
t(mediasugScroll.horizontalScrollLeft);
}, 400);
},
webviewScroll: function(t) {
if ("open" === $("header").attr("sugstate") && t.rect && !($("body").height() > innerHeight + 232)) {
var e, a, i, n, r, o, s = $("body").height();
if (r = t.rect.substring(1, t.rect.length - 1).split(","), e = r[0], a = Math.abs(r[1]), 
i = r[2], n = r[3], s === innerHeight) o = a >= h ? "out" : "in"; else {
var l = s - innerHeight;
o = a >= h - l ? "out" : "in";
}
"out" === d && "in" === o ? mediasugScroll.dealimpr([], c) : "in" === d && "out" === o && mediasugScroll.pushimpr(!0), 
d = o;
}
}
};
}(), subscribeTimeoutTimer, checkHeaderDisplayed = checkDisplayedFactory("#profile", "showTitleBarPgcLayout"), checkWendanextDisplayed = checkDisplayedFactory(".serial", "showWendaNextLayout"), checkWendaABHeaderLayout = checkDisplayedFactory(".wenda-title", "showWendaABHeaderLayout"), canSetContext = !1, globalContent, globalCachedContext = null, needCleanDoms = [], imprProcessQueue = [];

window.Page = {}, window.OldPage = null, window.globalExtras = {};

var AndroidImageProcessor = {
warpStandNative: function() {
this.pictures.forEach(function(t, e) {
var a = t.holder, i = a.parentNode;
"P" === i.tagName ? "" !== i.textContent ? (console.info("[" + e + "]所在段落有文本，应当分割"), 
__w(i, a, "span")) : i.querySelectorAll(".image").length > 1 ? (console.info("[" + e + "]所在段落有其他图片，应当分割"), 
__w(i, a, "span")) : (console.info("[" + e + "]正确"), i.classList.add("image-wrap")) : (console.info("[" + e + "]直接加包裹"), 
__w(i, a, "p"));
});
},
start: function() {
var t = document.querySelectorAll("a.image");
if (t = Array.prototype.slice.call(t), this.pictures = [], this.allPicturesCount = t.length, 
this.currentViewing = {}, this.loadedOrigins = 0, this.isSeeOriginsButtonShown = !1, 
0 !== this.allPicturesCount) {
if (this.threadGGSwitch && (this.useLazyload = !1, "none" !== this.imageType && (this.imageType = 1 === this.allPicturesCount ? "origin" : "list400")), 
this.isDuoTuThread = this.threadGGSwitch && this.allPicturesCount > 1, this.threadImageType = this.isDuoTuThread ? "list400" : this.threadGGSwitch ? "origin" : this.imageType, 
this.allPicturesCount > 10 && (this.useLazyload = !0), this.pictures = t.map(function(t, e) {
var a, i = t.getAttribute("type") || "", n = +t.getAttribute("width") || 0, r = +t.getAttribute("height") || 0, o = +t.getAttribute("thumb_width") || 0, s = +t.getAttribute("thumb_height") || 0, l = t.getAttribute("zip_src_path") || "";
a = [ "origin", "none" ].indexOf(AIP.imageType) > -1 ? [ n, r ] : [ o, s ];
var c = {
index: e,
holder: t,
state: AIP.imageType,
url: "",
lastUrl: "",
zsp: l,
href: t.getAttribute("href") || "",
link: t.getAttribute("redirect-link") || "",
isGIF: "gif" === i || "2" === i,
isLONG: n > 3 * r || r > 3 * n,
holderSize: a,
bigArea: n * r,
smallArea: o * s,
autoscript: null
};
return c;
}), !this.threadGGSwitch && "origin" !== this.imageType) {
this.isSeeOriginsButtonShown = !0;
var e = document.createElement("div");
e.innerHTML = '<div class="toggle-img" id="toggle-img">显示大图</div>', e.addEventListener("click", function() {
AIP.showAllOriginImages(), sendBytedanceRequest("toggle_image?action=show"), this.style.visibility = "hidden";
}), t[0].parentNode.insertBefore(e, t[0]);
}
this.threadGGSwitch || this.warpStandNative(), this.useLazyload ? (this.renderAllHolders(!0, !0), 
document.removeEventListener("scroll", this._pollImages), document.addEventListener("scroll", this._pollImages, !1), 
this._pollImages()) : this.renderAllHolders(!0, !1);
}
},
showAllOriginImages: function() {
AIP.pictures.forEach(function(t) {
t.state = "origin", t.url && (t.url = __buildGetImageSource("origin", t.zsp, t.index), 
AIP.renderHolder(t));
});
},
_pollImages: function() {
clearTimeout(AIP._pollImagesTimer), AIP._pollImagesTimer = setTimeout(AIP._pollImagesHandler, 100);
},
_pollImagesHandler: function() {
var t = AIP.pictures.every(function(t) {
if ("" !== t.url) return !0;
var e = t.holder.getBoundingClientRect().top;
return console.info("pooling", t.index, e), 0 > e || (e >= 0 && e) <= 2 * window.iH ? (t.url = __buildGetImageSource(t.state, t.zsp, t.index), 
AIP.renderHolder(t), !0) : !1;
});
t && (console.info("所有图片已加载完毕，取消懒加载事件监听"), document.removeEventListener("scroll", AIP._pollImages));
},
renderAllHolders: function(t, e, a) {
console.info("[renderAllHolders]", t, e, a);
var i = this.pictures;
i.forEach(e ? function(e) {
AIP.renderHolder(e, t, a);
} : function(e) {
e.url = __buildGetImageSource(e.state, e.zsp, e.index), AIP.renderHolder(e, t, a);
});
},
renderHolder: function(t, e, a) {
var i = t.holder;
if (e) {
i.setAttribute("index", t.index), i.removeAttribute("href");
var n = document.createDocumentFragment(), r = document.createElement("img");
r.classList.add("opacity-zero"), r.onload = AIP.onLoad, r.onerror = AIP.onError, 
n.appendChild(r);
var o = document.createElement("i");
if (t.isGIF ? (o.setAttribute("class", "image-subscript gif-subscript"), o.textContent = "GIF", 
n.appendChild(o)) : t.isLONG && this.isDuoTuThread ? (o.setAttribute("class", "image-subscript long-subscript"), 
o.textContent = "长图", n.appendChild(o)) : t.autoscript && (o.setAttribute("class", "image-subscript autoscript"), 
o.innerHTML = '<span class="ovf">' + t.autoscript.series_name + "</span><span>" + t.autoscript.price + '</span><span class="sx">&#xe60a;</span><span>查看详情</span>', 
o.dataset.href = t.autoscript.open_url, n.appendChild(o)), "origin" !== t.state) {
var s = document.createElement("i");
s.classList.add("spinner"), n.appendChild(s);
}
i.appendChild(n);
} else r = i.querySelector("img");
if (a) if (t.isGIF) ; else if (t.isLONG && this.isDuoTuThread) ; else if (t.autoscript) {
var o = document.createElement("i");
o.setAttribute("class", "image-subscript autoscript"), o.innerHTML = '<span class="ovf">' + t.autoscript.series_name + "</span><span>" + t.autoscript.price + '</span><span class="sx">&#xe60a;</span><span>查看详情</span>', 
o.dataset.href = t.autoscript.open_url, i.appendChild(o);
}
var l = __adjustOriginImageScale(t.holderSize, "none" === t.state);
console.info("__adjustOriginImageScale", t.holderSize, l[0], l[1]), i.style.width = l[0] + "px", 
i.style.height = l[1] + "px", i.setAttribute("bg", l[0] > 140 && l[1] > 44), AIP.threadGGSwitch && 1 === AIP.allPicturesCount && (i.parentNode.style.paddingTop = 0, 
i.parentNode.style.height = l[1] + "px"), !t.url || t.lastUrl && t.lastUrl === t.url || (console.info("URL_NOT_EQUAL", t.lastUrl, t.url), 
r.src = t.lastUrl = t.url), i.setAttribute("state", t.state);
},
onError: function() {
this.classList.add("opacity-zero"), console.info("[onError]", this);
},
onLoad: function() {
console.info("[onLoad]", this), this.classList.remove("opacity-zero");
var t = this.parentNode, e = t.getAttribute("index"), a = AIP.pictures[e], i = this.naturalWidth * this.naturalHeight, n = Math.abs(a.bigArea - i), r = Math.abs(a.smallArea - i);
if (console.info(i, n, r), a.holderSize = [ this.naturalWidth, this.naturalHeight ], 
AIP.threadGGSwitch ? a.state = AIP.threadImageType : n > r ? a.state = "thumb" : (a.state = "origin", 
AIP.loadedOrigins++), AIP.renderHolder(a), a.holder.classList.remove("animation"), 
AIP.loadedOrigins === AIP.allPicturesCount) {
var o = document.getElementById("toggle-img");
o && (o.style.visibility = "hidden");
}
},
tapEventHandler: function(t) {
t.preventDefault();
var e = this.getAttribute("index"), a = AIP.pictures[e];
if ("origin" === a.state || AIP.isDuoTuThread) {
if (a.link && a.link.indexOf("sslocal") > -1) location.href = a.link; else if (a.href.indexOf("bytedance://large_image") > -1) {
var i = a.holder.getBoundingClientRect(), n = "&left=" + (i.left + window.pageXOffset) + "&top=" + (i.top + window.pageYOffset) + "&width=" + Math.floor(i.width) + "&height=" + Math.floor(i.height);
location.href = a.href + n;
}
} else a.url = __buildGetImageSource("origin", a.zsp, a.index), a.state = "origin", 
a.holder.classList.add("animation"), AIP.renderHolder(a);
},
onNativeImageLoaded: function(t, e, a) {
console.info("[onNativeImageLoaded]", t, e, a);
var i = AIP.pictures[t];
i && e && (i.state = AIP.threadGGSwitch ? AIP.threadImageType : a ? "origin" : "thumb", 
i.url = __buildImageSource(i.state, i.zsp), AIP.renderHolder(i));
},
bindEvents: function() {
console.info("AIP.bindEvents"), $(document.body).on("click", ".image", function(t) {
var e = nz_closest(t.target, ".autoscript");
return e ? (send_umeng_event("detail", "pic_card_click", {
value: +Page.statistics.group_id
}), sendUmengEventV3("clk_event", {
obj_id: "page_detail_pic_tag",
group_id: Page.statistics.group_id
}, !0), location.href = e.dataset.href, !1) : void AIP.tapEventHandler.call(this, t);
});
},
addAutoScript: function(t) {
if (Array.isArray(AIP.pictures)) {
for (var e in t) {
var a = +e;
AIP.pictures[a] && (AIP.pictures[a].autoscript = t[e]);
}
AIP.renderAllHolders(!1, !0, !0), setTimeout(function() {
if (Array.isArray(AIP.pictures)) for (var e in t) {
var a = AIP.pictures[+e];
if (a && a.holder) {
var i = a.holder.querySelector(".autoscript");
i && send_exposure_event_once(i, function() {
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
willStart: function(t) {
"function" == typeof t && t();
},
ended: function() {}
};

!function() {
bindStatisticsEvents(), bindStatisticsEvents23(), tellClientContentSize(), checkHeaderDisplayed(), 
AndroidImageProcessor.bindEvents();
}();