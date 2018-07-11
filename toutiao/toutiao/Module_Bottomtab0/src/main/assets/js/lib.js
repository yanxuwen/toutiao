function SelfEvent(t) {
this.channelId = t, this.eventMap = {};
}

function _flushErrors(t) {
globalErrors.forEach(function(e) {
e.gid || (e.gid = t, window.ToutiaoJSBridge && ToutiaoJSBridge.call("monitor", {
service: MONITOR_SERVICE,
status: 1,
extra: e
}));
});
}

function flushErrors(t) {
clearTimeout(flushErrorsTimer);
var e = window.Page && Page.statistics ? Page.statistics.group_id : "";
t && !e && (e = "gid_still_n/a"), e ? _flushErrors(e) : flushErrorsTimer = setTimeout(flushErrors, 3e3);
}

!function(t, e) {
"function" == typeof define && define.amd ? define(function() {
return e(t);
}) : e(t);
}(this, function(t) {
var e = function() {
function e(t) {
return null == t ? String(t) : $[Y.call(t)] || "object";
}
function i(t) {
return "function" == e(t);
}
function s(t) {
return null != t && t == t.window;
}
function r(t) {
return null != t && t.nodeType == t.DOCUMENT_NODE;
}
function n(t) {
return "object" == e(t);
}
function a(t) {
return n(t) && !s(t) && Object.getPrototypeOf(t) == Object.prototype;
}
function o(t) {
var e = !!t && "length" in t && t.length, i = P.type(t);
return "function" != i && !s(t) && ("array" == i || 0 === e || "number" == typeof e && e > 0 && e - 1 in t);
}
function h(t) {
return T.call(t, function(t) {
return null != t;
});
}
function l(t) {
return t.length > 0 ? P.fn.concat.apply([], t) : t;
}
function p(t) {
return t.replace(/::/g, "/").replace(/([A-Z]+)([A-Z][a-z])/g, "$1_$2").replace(/([a-z\d])([A-Z])/g, "$1_$2").replace(/_/g, "-").toLowerCase();
}
function c(t) {
return t in L ? L[t] : L[t] = new RegExp("(^|\\s)" + t + "(\\s|$)");
}
function f(t, e) {
return "number" != typeof e || j[p(t)] ? e : e + "px";
}
function u(t) {
var e, i;
return N[t] || (e = I.createElement(t), I.body.appendChild(e), i = getComputedStyle(e, "").getPropertyValue("display"), 
e.parentNode.removeChild(e), "none" == i && (i = "block"), N[t] = i), N[t];
}
function d(t) {
return "children" in t ? D.call(t.children) : P.map(t.childNodes, function(t) {
return 1 == t.nodeType ? t : void 0;
});
}
function m(t, e) {
var i, s = t ? t.length : 0;
for (i = 0; s > i; i++) this[i] = t[i];
this.length = s, this.selector = e || "";
}
function g(t, e, i) {
for (S in e) i && (a(e[S]) || te(e[S])) ? (a(e[S]) && !a(t[S]) && (t[S] = {}), te(e[S]) && !te(t[S]) && (t[S] = []), 
g(t[S], e[S], i)) : e[S] !== A && (t[S] = e[S]);
}
function v(t, e) {
return null == e ? P(t) : P(t).filter(e);
}
function y(t, e, s, r) {
return i(e) ? e.call(t, s, r) : e;
}
function b(t, e, i) {
null == i ? t.removeAttribute(e) : t.setAttribute(e, i);
}
function k(t, e) {
var i = t.className || "", s = i && i.baseVal !== A;
return e === A ? s ? i.baseVal : i : void (s ? i.baseVal = e : t.className = e);
}
function E(t) {
try {
return t ? "true" == t || ("false" == t ? !1 : "null" == t ? null : +t + "" == t ? +t : /^[\[\{]/.test(t) ? P.parseJSON(t) : t) : t;
} catch (e) {
return t;
}
}
function w(t, e) {
e(t);
for (var i = 0, s = t.childNodes.length; s > i; i++) w(t.childNodes[i], e);
}
var A, S, P, x, _, M, C = [], F = C.concat, T = C.filter, D = C.slice, I = t.document, N = {}, L = {}, j = {
"column-count": 1,
columns: 1,
"font-weight": 1,
"line-height": 1,
opacity: 1,
"z-index": 1,
zoom: 1
}, O = /^\s*<(\w+|!)[^>]*>/, R = /^<(\w+)\s*\/?>(?:<\/\1>|)$/, V = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi, z = /^(?:body|html)$/i, B = /([A-Z])/g, q = [ "val", "css", "html", "text", "data", "width", "height", "offset" ], U = [ "after", "prepend", "before", "append" ], G = I.createElement("table"), H = I.createElement("tr"), W = {
tr: I.createElement("tbody"),
tbody: G,
thead: G,
tfoot: G,
td: H,
th: H,
"*": I.createElement("div")
}, X = /complete|loaded|interactive/, J = /^[\w-]*$/, $ = {}, Y = $.toString, Z = {}, K = I.createElement("div"), Q = {
tabindex: "tabIndex",
readonly: "readOnly",
"for": "htmlFor",
"class": "className",
maxlength: "maxLength",
cellspacing: "cellSpacing",
cellpadding: "cellPadding",
rowspan: "rowSpan",
colspan: "colSpan",
usemap: "useMap",
frameborder: "frameBorder",
contenteditable: "contentEditable"
}, te = Array.isArray || function(t) {
return t instanceof Array;
};
return Z.matches = function(t, e) {
if (!e || !t || 1 !== t.nodeType) return !1;
var i = t.matches || t.webkitMatchesSelector || t.mozMatchesSelector || t.oMatchesSelector || t.matchesSelector;
if (i) return i.call(t, e);
var s, r = t.parentNode, n = !r;
return n && (r = K).appendChild(t), s = ~Z.qsa(r, e).indexOf(t), n && K.removeChild(t), 
s;
}, _ = function(t) {
return t.replace(/-+(.)?/g, function(t, e) {
return e ? e.toUpperCase() : "";
});
}, M = function(t) {
return T.call(t, function(e, i) {
return t.indexOf(e) == i;
});
}, Z.fragment = function(t, e, i) {
var s, r, n;
return R.test(t) && (s = P(I.createElement(RegExp.$1))), s || (t.replace && (t = t.replace(V, "<$1></$2>")), 
e === A && (e = O.test(t) && RegExp.$1), e in W || (e = "*"), n = W[e], n.innerHTML = "" + t, 
s = P.each(D.call(n.childNodes), function() {
n.removeChild(this);
})), a(i) && (r = P(s), P.each(i, function(t, e) {
q.indexOf(t) > -1 ? r[t](e) : r.attr(t, e);
})), s;
}, Z.Z = function(t, e) {
return new m(t, e);
}, Z.isZ = function(t) {
return t instanceof Z.Z;
}, Z.init = function(t, e) {
var s;
if (!t) return Z.Z();
if ("string" == typeof t) if (t = t.trim(), "<" == t[0] && O.test(t)) s = Z.fragment(t, RegExp.$1, e), 
t = null; else {
if (e !== A) return P(e).find(t);
s = Z.qsa(I, t);
} else {
if (i(t)) return P(I).ready(t);
if (Z.isZ(t)) return t;
if (te(t)) s = h(t); else if (n(t)) s = [ t ], t = null; else if (O.test(t)) s = Z.fragment(t.trim(), RegExp.$1, e), 
t = null; else {
if (e !== A) return P(e).find(t);
s = Z.qsa(I, t);
}
}
return Z.Z(s, t);
}, P = function(t, e) {
return Z.init(t, e);
}, P.extend = function(t) {
var e, i = D.call(arguments, 1);
return "boolean" == typeof t && (e = t, t = i.shift()), i.forEach(function(i) {
g(t, i, e);
}), t;
}, Z.qsa = function(t, e) {
var i, s = "#" == e[0], r = !s && "." == e[0], n = s || r ? e.slice(1) : e, a = J.test(n);
return t.getElementById && a && s ? (i = t.getElementById(n)) ? [ i ] : [] : 1 !== t.nodeType && 9 !== t.nodeType && 11 !== t.nodeType ? [] : D.call(a && !s && t.getElementsByClassName ? r ? t.getElementsByClassName(n) : t.getElementsByTagName(e) : t.querySelectorAll(e));
}, P.contains = I.documentElement.contains ? function(t, e) {
return t !== e && t.contains(e);
} : function(t, e) {
for (;e && (e = e.parentNode); ) if (e === t) return !0;
return !1;
}, P.type = e, P.isFunction = i, P.isWindow = s, P.isArray = te, P.isPlainObject = a, 
P.isEmptyObject = function(t) {
var e;
for (e in t) return !1;
return !0;
}, P.isNumeric = function(t) {
var e = Number(t), i = typeof t;
return null != t && "boolean" != i && ("string" != i || t.length) && !isNaN(e) && isFinite(e) || !1;
}, P.inArray = function(t, e, i) {
return C.indexOf.call(e, t, i);
}, P.camelCase = _, P.trim = function(t) {
return null == t ? "" : String.prototype.trim.call(t);
}, P.uuid = 0, P.support = {}, P.expr = {}, P.noop = function() {}, P.map = function(t, e) {
var i, s, r, n = [];
if (o(t)) for (s = 0; s < t.length; s++) i = e(t[s], s), null != i && n.push(i); else for (r in t) i = e(t[r], r), 
null != i && n.push(i);
return l(n);
}, P.each = function(t, e) {
var i, s;
if (o(t)) {
for (i = 0; i < t.length; i++) if (e.call(t[i], i, t[i]) === !1) return t;
} else for (s in t) if (e.call(t[s], s, t[s]) === !1) return t;
return t;
}, P.grep = function(t, e) {
return T.call(t, e);
}, t.JSON && (P.parseJSON = JSON.parse), P.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function(t, e) {
$["[object " + e + "]"] = e.toLowerCase();
}), P.fn = {
constructor: Z.Z,
length: 0,
forEach: C.forEach,
reduce: C.reduce,
push: C.push,
sort: C.sort,
splice: C.splice,
indexOf: C.indexOf,
concat: function() {
var t, e, i = [];
for (t = 0; t < arguments.length; t++) e = arguments[t], i[t] = Z.isZ(e) ? e.toArray() : e;
return F.apply(Z.isZ(this) ? this.toArray() : this, i);
},
map: function(t) {
return P(P.map(this, function(e, i) {
return t.call(e, i, e);
}));
},
slice: function() {
return P(D.apply(this, arguments));
},
ready: function(t) {
return X.test(I.readyState) && I.body ? t(P) : I.addEventListener("DOMContentLoaded", function() {
t(P);
}, !1), this;
},
get: function(t) {
return t === A ? D.call(this) : this[t >= 0 ? t : t + this.length];
},
toArray: function() {
return this.get();
},
size: function() {
return this.length;
},
remove: function() {
return this.each(function() {
null != this.parentNode && this.parentNode.removeChild(this);
});
},
each: function(t) {
return C.every.call(this, function(e, i) {
return t.call(e, i, e) !== !1;
}), this;
},
filter: function(t) {
return i(t) ? this.not(this.not(t)) : P(T.call(this, function(e) {
return Z.matches(e, t);
}));
},
add: function(t, e) {
return P(M(this.concat(P(t, e))));
},
is: function(t) {
return this.length > 0 && Z.matches(this[0], t);
},
not: function(t) {
var e = [];
if (i(t) && t.call !== A) this.each(function(i) {
t.call(this, i) || e.push(this);
}); else {
var s = "string" == typeof t ? this.filter(t) : o(t) && i(t.item) ? D.call(t) : P(t);
this.forEach(function(t) {
s.indexOf(t) < 0 && e.push(t);
});
}
return P(e);
},
has: function(t) {
return this.filter(function() {
return n(t) ? P.contains(this, t) : P(this).find(t).size();
});
},
eq: function(t) {
return -1 === t ? this.slice(t) : this.slice(t, +t + 1);
},
first: function() {
var t = this[0];
return t && !n(t) ? t : P(t);
},
last: function() {
var t = this[this.length - 1];
return t && !n(t) ? t : P(t);
},
find: function(t) {
var e, i = this;
return e = t ? "object" == typeof t ? P(t).filter(function() {
var t = this;
return C.some.call(i, function(e) {
return P.contains(e, t);
});
}) : 1 == this.length ? P(Z.qsa(this[0], t)) : this.map(function() {
return Z.qsa(this, t);
}) : P();
},
closest: function(t, e) {
var i = [], s = "object" == typeof t && P(t);
return this.each(function(n, a) {
for (;a && !(s ? s.indexOf(a) >= 0 : Z.matches(a, t)); ) a = a !== e && !r(a) && a.parentNode;
a && i.indexOf(a) < 0 && i.push(a);
}), P(i);
},
parents: function(t) {
for (var e = [], i = this; i.length > 0; ) i = P.map(i, function(t) {
return (t = t.parentNode) && !r(t) && e.indexOf(t) < 0 ? (e.push(t), t) : void 0;
});
return v(e, t);
},
parent: function(t) {
return v(M(this.pluck("parentNode")), t);
},
children: function(t) {
return v(this.map(function() {
return d(this);
}), t);
},
contents: function() {
return this.map(function() {
return this.contentDocument || D.call(this.childNodes);
});
},
siblings: function(t) {
return v(this.map(function(t, e) {
return T.call(d(e.parentNode), function(t) {
return t !== e;
});
}), t);
},
empty: function() {
return this.each(function() {
this.innerHTML = "";
});
},
pluck: function(t) {
return P.map(this, function(e) {
return e[t];
});
},
show: function() {
return this.each(function() {
"none" == this.style.display && (this.style.display = ""), "none" == getComputedStyle(this, "").getPropertyValue("display") && (this.style.display = u(this.nodeName));
});
},
replaceWith: function(t) {
return this.before(t).remove();
},
wrap: function(t) {
var e = i(t);
if (this[0] && !e) var s = P(t).get(0), r = s.parentNode || this.length > 1;
return this.each(function(i) {
P(this).wrapAll(e ? t.call(this, i) : r ? s.cloneNode(!0) : s);
});
},
wrapAll: function(t) {
if (this[0]) {
P(this[0]).before(t = P(t));
for (var e; (e = t.children()).length; ) t = e.first();
P(t).append(this);
}
return this;
},
wrapInner: function(t) {
var e = i(t);
return this.each(function(i) {
var s = P(this), r = s.contents(), n = e ? t.call(this, i) : t;
r.length ? r.wrapAll(n) : s.append(n);
});
},
unwrap: function() {
return this.parent().each(function() {
P(this).replaceWith(P(this).children());
}), this;
},
clone: function() {
return this.map(function() {
return this.cloneNode(!0);
});
},
hide: function() {
return this.css("display", "none");
},
toggle: function(t) {
return this.each(function() {
var e = P(this);
(t === A ? "none" == e.css("display") : t) ? e.show() : e.hide();
});
},
prev: function(t) {
return P(this.pluck("previousElementSibling")).filter(t || "*");
},
next: function(t) {
return P(this.pluck("nextElementSibling")).filter(t || "*");
},
html: function(t) {
return 0 in arguments ? this.each(function(e) {
var i = this.innerHTML;
P(this).empty().append(y(this, t, e, i));
}) : 0 in this ? this[0].innerHTML : null;
},
text: function(t) {
return 0 in arguments ? this.each(function(e) {
var i = y(this, t, e, this.textContent);
this.textContent = null == i ? "" : "" + i;
}) : 0 in this ? this.pluck("textContent").join("") : null;
},
attr: function(t, e) {
var i;
return "string" != typeof t || 1 in arguments ? this.each(function(i) {
if (1 === this.nodeType) if (n(t)) for (S in t) b(this, S, t[S]); else b(this, t, y(this, e, i, this.getAttribute(t)));
}) : 0 in this && 1 == this[0].nodeType && null != (i = this[0].getAttribute(t)) ? i : A;
},
removeAttr: function(t) {
return this.each(function() {
1 === this.nodeType && t.split(" ").forEach(function(t) {
b(this, t);
}, this);
});
},
prop: function(t, e) {
return t = Q[t] || t, 1 in arguments ? this.each(function(i) {
this[t] = y(this, e, i, this[t]);
}) : this[0] && this[0][t];
},
removeProp: function(t) {
return t = Q[t] || t, this.each(function() {
delete this[t];
});
},
data: function(t, e) {
var i = "data-" + t.replace(B, "-$1").toLowerCase(), s = 1 in arguments ? this.attr(i, e) : this.attr(i);
return null !== s ? E(s) : A;
},
val: function(t) {
return 0 in arguments ? (null == t && (t = ""), this.each(function(e) {
this.value = y(this, t, e, this.value);
})) : this[0] && (this[0].multiple ? P(this[0]).find("option").filter(function() {
return this.selected;
}).pluck("value") : this[0].value);
},
offset: function(e) {
if (e) return this.each(function(t) {
var i = P(this), s = y(this, e, t, i.offset()), r = i.offsetParent().offset(), n = {
top: s.top - r.top,
left: s.left - r.left
};
"static" == i.css("position") && (n.position = "relative"), i.css(n);
});
if (!this.length) return null;
if (I.documentElement !== this[0] && !P.contains(I.documentElement, this[0])) return {
top: 0,
left: 0
};
var i = this[0].getBoundingClientRect();
return {
left: i.left + t.pageXOffset,
top: i.top + t.pageYOffset,
width: Math.round(i.width),
height: Math.round(i.height)
};
},
css: function(t, i) {
if (arguments.length < 2) {
var s = this[0];
if ("string" == typeof t) {
if (!s) return;
return s.style[_(t)] || getComputedStyle(s, "").getPropertyValue(t);
}
if (te(t)) {
if (!s) return;
var r = {}, n = getComputedStyle(s, "");
return P.each(t, function(t, e) {
r[e] = s.style[_(e)] || n.getPropertyValue(e);
}), r;
}
}
var a = "";
if ("string" == e(t)) i || 0 === i ? a = p(t) + ":" + f(t, i) : this.each(function() {
this.style.removeProperty(p(t));
}); else for (S in t) t[S] || 0 === t[S] ? a += p(S) + ":" + f(S, t[S]) + ";" : this.each(function() {
this.style.removeProperty(p(S));
});
return this.each(function() {
this.style.cssText += ";" + a;
});
},
index: function(t) {
return t ? this.indexOf(P(t)[0]) : this.parent().children().indexOf(this[0]);
},
hasClass: function(t) {
return t ? C.some.call(this, function(t) {
return this.test(k(t));
}, c(t)) : !1;
},
addClass: function(t) {
return t ? this.each(function(e) {
if ("className" in this) {
x = [];
var i = k(this), s = y(this, t, e, i);
s.split(/\s+/g).forEach(function(t) {
P(this).hasClass(t) || x.push(t);
}, this), x.length && k(this, i + (i ? " " : "") + x.join(" "));
}
}) : this;
},
removeClass: function(t) {
return this.each(function(e) {
if ("className" in this) {
if (t === A) return k(this, "");
x = k(this), y(this, t, e, x).split(/\s+/g).forEach(function(t) {
x = x.replace(c(t), " ");
}), k(this, x.trim());
}
});
},
toggleClass: function(t, e) {
return t ? this.each(function(i) {
var s = P(this), r = y(this, t, i, k(this));
r.split(/\s+/g).forEach(function(t) {
(e === A ? !s.hasClass(t) : e) ? s.addClass(t) : s.removeClass(t);
});
}) : this;
},
scrollTop: function(t) {
if (this.length) {
var e = "scrollTop" in this[0];
return t === A ? e ? this[0].scrollTop : this[0].pageYOffset : this.each(e ? function() {
this.scrollTop = t;
} : function() {
this.scrollTo(this.scrollX, t);
});
}
},
scrollLeft: function(t) {
if (this.length) {
var e = "scrollLeft" in this[0];
return t === A ? e ? this[0].scrollLeft : this[0].pageXOffset : this.each(e ? function() {
this.scrollLeft = t;
} : function() {
this.scrollTo(t, this.scrollY);
});
}
},
position: function() {
if (this.length) {
var t = this[0], e = this.offsetParent(), i = this.offset(), s = z.test(e[0].nodeName) ? {
top: 0,
left: 0
} : e.offset();
return i.top -= parseFloat(P(t).css("margin-top")) || 0, i.left -= parseFloat(P(t).css("margin-left")) || 0, 
s.top += parseFloat(P(e[0]).css("border-top-width")) || 0, s.left += parseFloat(P(e[0]).css("border-left-width")) || 0, 
{
top: i.top - s.top,
left: i.left - s.left
};
}
},
offsetParent: function() {
return this.map(function() {
for (var t = this.offsetParent || I.body; t && !z.test(t.nodeName) && "static" == P(t).css("position"); ) t = t.offsetParent;
return t;
});
}
}, P.fn.detach = P.fn.remove, [ "width", "height" ].forEach(function(t) {
var e = t.replace(/./, function(t) {
return t[0].toUpperCase();
});
P.fn[t] = function(i) {
var n, a = this[0];
return i === A ? s(a) ? a["inner" + e] : r(a) ? a.documentElement["scroll" + e] : (n = this.offset()) && n[t] : this.each(function(e) {
a = P(this), a.css(t, y(this, i, e, a[t]()));
});
};
}), U.forEach(function(i, s) {
var r = s % 2;
P.fn[i] = function() {
var i, n, a = P.map(arguments, function(t) {
var s = [];
return i = e(t), "array" == i ? (t.forEach(function(t) {
return t.nodeType !== A ? s.push(t) : P.zepto.isZ(t) ? s = s.concat(t.get()) : void (s = s.concat(Z.fragment(t)));
}), s) : "object" == i || null == t ? t : Z.fragment(t);
}), o = this.length > 1;
return a.length < 1 ? this : this.each(function(e, i) {
n = r ? i : i.parentNode, i = 0 == s ? i.nextSibling : 1 == s ? i.firstChild : 2 == s ? i : null;
var h = P.contains(I.documentElement, n);
a.forEach(function(e) {
if (o) e = e.cloneNode(!0); else if (!n) return P(e).remove();
n.insertBefore(e, i), h && w(e, function(e) {
if (!(null == e.nodeName || "SCRIPT" !== e.nodeName.toUpperCase() || e.type && "text/javascript" !== e.type || e.src)) {
var i = e.ownerDocument ? e.ownerDocument.defaultView : t;
i.eval.call(i, e.innerHTML);
}
});
});
});
}, P.fn[r ? i + "To" : "insert" + (s ? "Before" : "After")] = function(t) {
return P(t)[i](this), this;
};
}), Z.Z.prototype = m.prototype = P.fn, Z.uniq = M, Z.deserializeValue = E, P.zepto = Z, 
P;
}();
return t.Zepto = e, void 0 === t.$ && (t.$ = e), function(e) {
function i(t) {
return t._zid || (t._zid = u++);
}
function s(t, e, s, a) {
if (e = r(e), e.ns) var o = n(e.ns);
return (v[i(t)] || []).filter(function(t) {
return !(!t || e.e && t.e != e.e || e.ns && !o.test(t.ns) || s && i(t.fn) !== i(s) || a && t.sel != a);
});
}
function r(t) {
var e = ("" + t).split(".");
return {
e: e[0],
ns: e.slice(1).sort().join(" ")
};
}
function n(t) {
return new RegExp("(?:^| )" + t.replace(" ", " .* ?") + "(?: |$)");
}
function a(t, e) {
return t.del && !b && t.e in k || !!e;
}
function o(t) {
return E[t] || b && k[t] || t;
}
function h(t, s, n, h, l, c, u) {
var d = i(t), m = v[d] || (v[d] = []);
s.split(/\s/).forEach(function(i) {
if ("ready" == i) return e(document).ready(n);
var s = r(i);
s.fn = n, s.sel = l, s.e in E && (n = function(t) {
var i = t.relatedTarget;
return !i || i !== this && !e.contains(this, i) ? s.fn.apply(this, arguments) : void 0;
}), s.del = c;
var d = c || n;
s.proxy = function(e) {
if (e = p(e), !e.isImmediatePropagationStopped()) {
e.data = h;
var i = d.apply(t, e._args == f ? [ e ] : [ e ].concat(e._args));
return i === !1 && (e.preventDefault(), e.stopPropagation()), i;
}
}, s.i = m.length, m.push(s), "addEventListener" in t && t.addEventListener(o(s.e), s.proxy, a(s, u));
});
}
function l(t, e, r, n, h) {
var l = i(t);
(e || "").split(/\s/).forEach(function(e) {
s(t, e, r, n).forEach(function(e) {
delete v[l][e.i], "removeEventListener" in t && t.removeEventListener(o(e.e), e.proxy, a(e, h));
});
});
}
function p(t, i) {
return (i || !t.isDefaultPrevented) && (i || (i = t), e.each(P, function(e, s) {
var r = i[e];
t[e] = function() {
return this[s] = w, r && r.apply(i, arguments);
}, t[s] = A;
}), t.timeStamp || (t.timeStamp = Date.now()), (i.defaultPrevented !== f ? i.defaultPrevented : "returnValue" in i ? i.returnValue === !1 : i.getPreventDefault && i.getPreventDefault()) && (t.isDefaultPrevented = w)), 
t;
}
function c(t) {
var e, i = {
originalEvent: t
};
for (e in t) S.test(e) || t[e] === f || (i[e] = t[e]);
return p(i, t);
}
var f, u = 1, d = Array.prototype.slice, m = e.isFunction, g = function(t) {
return "string" == typeof t;
}, v = {}, y = {}, b = "onfocusin" in t, k = {
focus: "focusin",
blur: "focusout"
}, E = {
mouseenter: "mouseover",
mouseleave: "mouseout"
};
y.click = y.mousedown = y.mouseup = y.mousemove = "MouseEvents", e.event = {
add: h,
remove: l
}, e.proxy = function(t, s) {
var r = 2 in arguments && d.call(arguments, 2);
if (m(t)) {
var n = function() {
return t.apply(s, r ? r.concat(d.call(arguments)) : arguments);
};
return n._zid = i(t), n;
}
if (g(s)) return r ? (r.unshift(t[s], t), e.proxy.apply(null, r)) : e.proxy(t[s], t);
throw new TypeError("expected function");
}, e.fn.bind = function(t, e, i) {
return this.on(t, e, i);
}, e.fn.unbind = function(t, e) {
return this.off(t, e);
}, e.fn.one = function(t, e, i, s) {
return this.on(t, e, i, s, 1);
};
var w = function() {
return !0;
}, A = function() {
return !1;
}, S = /^([A-Z]|returnValue$|layer[XY]$|webkitMovement[XY]$)/, P = {
preventDefault: "isDefaultPrevented",
stopImmediatePropagation: "isImmediatePropagationStopped",
stopPropagation: "isPropagationStopped"
};
e.fn.delegate = function(t, e, i) {
return this.on(e, t, i);
}, e.fn.undelegate = function(t, e, i) {
return this.off(e, t, i);
}, e.fn.live = function(t, i) {
return e(document.body).delegate(this.selector, t, i), this;
}, e.fn.die = function(t, i) {
return e(document.body).undelegate(this.selector, t, i), this;
}, e.fn.on = function(t, i, s, r, n) {
var a, o, p = this;
return t && !g(t) ? (e.each(t, function(t, e) {
p.on(t, i, s, e, n);
}), p) : (g(i) || m(r) || r === !1 || (r = s, s = i, i = f), (r === f || s === !1) && (r = s, 
s = f), r === !1 && (r = A), p.each(function(p, f) {
n && (a = function(t) {
return l(f, t.type, r), r.apply(this, arguments);
}), i && (o = function(t) {
var s, n = e(t.target).closest(i, f).get(0);
return n && n !== f ? (s = e.extend(c(t), {
currentTarget: n,
liveFired: f
}), (a || r).apply(n, [ s ].concat(d.call(arguments, 1)))) : void 0;
}), h(f, t, r, s, i, o || a);
}));
}, e.fn.off = function(t, i, s) {
var r = this;
return t && !g(t) ? (e.each(t, function(t, e) {
r.off(t, i, e);
}), r) : (g(i) || m(s) || s === !1 || (s = i, i = f), s === !1 && (s = A), r.each(function() {
l(this, t, s, i);
}));
}, e.fn.trigger = function(t, i) {
return t = g(t) || e.isPlainObject(t) ? e.Event(t) : p(t), t._args = i, this.each(function() {
t.type in k && "function" == typeof this[t.type] ? this[t.type]() : "dispatchEvent" in this ? this.dispatchEvent(t) : e(this).triggerHandler(t, i);
});
}, e.fn.triggerHandler = function(t, i) {
var r, n;
return this.each(function(a, o) {
r = c(g(t) ? e.Event(t) : t), r._args = i, r.target = o, e.each(s(o, t.type || t), function(t, e) {
return n = e.proxy(r), r.isImmediatePropagationStopped() ? !1 : void 0;
});
}), n;
}, "focusin focusout focus blur load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select keydown keypress keyup error".split(" ").forEach(function(t) {
e.fn[t] = function(e) {
return 0 in arguments ? this.bind(t, e) : this.trigger(t);
};
}), e.Event = function(t, e) {
g(t) || (e = t, t = e.type);
var i = document.createEvent(y[t] || "Events"), s = !0;
if (e) for (var r in e) "bubbles" == r ? s = !!e[r] : i[r] = e[r];
return i.initEvent(t, s, !0), p(i);
};
}(e), function(e) {
function i(t, i, s) {
var r = e.Event(i);
return e(t).trigger(r, s), !r.isDefaultPrevented();
}
function s(t, e, s, r) {
return t.global ? i(e || k, s, r) : void 0;
}
function r(t) {
t.global && 0 === e.active++ && s(t, null, "ajaxStart");
}
function n(t) {
t.global && !--e.active && s(t, null, "ajaxStop");
}
function a(t, e) {
var i = e.context;
return e.beforeSend.call(i, t, e) === !1 || s(e, i, "ajaxBeforeSend", [ t, e ]) === !1 ? !1 : void s(e, i, "ajaxSend", [ t, e ]);
}
function o(t, e, i, r) {
var n = i.context, a = "success";
i.success.call(n, t, a, e), r && r.resolveWith(n, [ t, a, e ]), s(i, n, "ajaxSuccess", [ e, i, t ]), 
l(a, e, i);
}
function h(t, e, i, r, n) {
var a = r.context;
r.error.call(a, i, e, t), n && n.rejectWith(a, [ i, e, t ]), s(r, a, "ajaxError", [ i, r, t || e ]), 
l(e, i, r);
}
function l(t, e, i) {
var r = i.context;
i.complete.call(r, e, t), s(i, r, "ajaxComplete", [ e, i ]), n(i);
}
function p(t, e, i) {
if (i.dataFilter == c) return t;
var s = i.context;
return i.dataFilter.call(s, t, e);
}
function c() {}
function f(t) {
return t && (t = t.split(";", 2)[0]), t && (t == P ? "html" : t == S ? "json" : w.test(t) ? "script" : A.test(t) && "xml") || "text";
}
function u(t, e) {
return "" == e ? t : (t + "&" + e).replace(/[&?]{1,2}/, "?");
}
function d(t) {
t.processData && t.data && "string" != e.type(t.data) && (t.data = e.param(t.data, t.traditional)), 
!t.data || t.type && "GET" != t.type.toUpperCase() && "jsonp" != t.dataType || (t.url = u(t.url, t.data), 
t.data = void 0);
}
function m(t, i, s, r) {
return e.isFunction(i) && (r = s, s = i, i = void 0), e.isFunction(s) || (r = s, 
s = void 0), {
url: t,
data: i,
success: s,
dataType: r
};
}
function g(t, i, s, r) {
var n, a = e.isArray(i), o = e.isPlainObject(i);
e.each(i, function(i, h) {
n = e.type(h), r && (i = s ? r : r + "[" + (o || "object" == n || "array" == n ? i : "") + "]"), 
!r && a ? t.add(h.name, h.value) : "array" == n || !s && "object" == n ? g(t, h, s, i) : t.add(i, h);
});
}
var v, y, b = +new Date(), k = t.document, E = /<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi, w = /^(?:text|application)\/javascript/i, A = /^(?:text|application)\/xml/i, S = "application/json", P = "text/html", x = /^\s*$/, _ = k.createElement("a");
_.href = t.location.href, e.active = 0, e.ajaxJSONP = function(i, s) {
if (!("type" in i)) return e.ajax(i);
var r, n, l = i.jsonpCallback, p = (e.isFunction(l) ? l() : l) || "Zepto" + b++, c = k.createElement("script"), f = t[p], u = function(t) {
e(c).triggerHandler("error", t || "abort");
}, d = {
abort: u
};
return s && s.promise(d), e(c).on("load error", function(a, l) {
clearTimeout(n), e(c).off().remove(), "error" != a.type && r ? o(r[0], d, i, s) : h(null, l || "error", d, i, s), 
t[p] = f, r && e.isFunction(f) && f(r[0]), f = r = void 0;
}), a(d, i) === !1 ? (u("abort"), d) : (t[p] = function() {
r = arguments;
}, c.src = i.url.replace(/\?(.+)=\?/, "?$1=" + p), k.head.appendChild(c), i.timeout > 0 && (n = setTimeout(function() {
u("timeout");
}, i.timeout)), d);
}, e.ajaxSettings = {
type: "GET",
beforeSend: c,
success: c,
error: c,
complete: c,
context: null,
global: !0,
xhr: function() {
return new t.XMLHttpRequest();
},
accepts: {
script: "text/javascript, application/javascript, application/x-javascript",
json: S,
xml: "application/xml, text/xml",
html: P,
text: "text/plain"
},
crossDomain: !1,
timeout: 0,
processData: !0,
cache: !0,
dataFilter: c
}, e.ajax = function(i) {
var s, n, l = e.extend({}, i || {}), m = e.Deferred && e.Deferred();
for (v in e.ajaxSettings) void 0 === l[v] && (l[v] = e.ajaxSettings[v]);
r(l), l.crossDomain || (s = k.createElement("a"), s.href = l.url, s.href = s.href, 
l.crossDomain = _.protocol + "//" + _.host != s.protocol + "//" + s.host), l.url || (l.url = t.location.toString()), 
(n = l.url.indexOf("#")) > -1 && (l.url = l.url.slice(0, n)), d(l);
var g = l.dataType, b = /\?.+=\?/.test(l.url);
if (b && (g = "jsonp"), l.cache !== !1 && (i && i.cache === !0 || "script" != g && "jsonp" != g) || (l.url = u(l.url, "_=" + Date.now())), 
"jsonp" == g) return b || (l.url = u(l.url, l.jsonp ? l.jsonp + "=?" : l.jsonp === !1 ? "" : "callback=?")), 
e.ajaxJSONP(l, m);
var E, w = l.accepts[g], A = {}, S = function(t, e) {
A[t.toLowerCase()] = [ t, e ];
}, P = /^([\w-]+:)\/\//.test(l.url) ? RegExp.$1 : t.location.protocol, M = l.xhr(), C = M.setRequestHeader;
if (m && m.promise(M), l.crossDomain || S("X-Requested-With", "XMLHttpRequest"), 
S("Accept", w || "*/*"), (w = l.mimeType || w) && (w.indexOf(",") > -1 && (w = w.split(",", 2)[0]), 
M.overrideMimeType && M.overrideMimeType(w)), (l.contentType || l.contentType !== !1 && l.data && "GET" != l.type.toUpperCase()) && S("Content-Type", l.contentType || "application/x-www-form-urlencoded"), 
l.headers) for (y in l.headers) S(y, l.headers[y]);
if (M.setRequestHeader = S, M.onreadystatechange = function() {
if (4 == M.readyState) {
M.onreadystatechange = c, clearTimeout(E);
var t, i = !1;
if (M.status >= 200 && M.status < 300 || 304 == M.status || 0 == M.status && "file:" == P) {
if (g = g || f(l.mimeType || M.getResponseHeader("content-type")), "arraybuffer" == M.responseType || "blob" == M.responseType) t = M.response; else {
t = M.responseText;
try {
t = p(t, g, l), "script" == g ? (1, eval)(t) : "xml" == g ? t = M.responseXML : "json" == g && (t = x.test(t) ? null : e.parseJSON(t));
} catch (s) {
i = s;
}
if (i) return h(i, "parsererror", M, l, m);
}
o(t, M, l, m);
} else h(M.statusText || null, M.status ? "error" : "abort", M, l, m);
}
}, a(M, l) === !1) return M.abort(), h(null, "abort", M, l, m), M;
var F = "async" in l ? l.async : !0;
if (M.open(l.type, l.url, F, l.username, l.password), l.xhrFields) for (y in l.xhrFields) M[y] = l.xhrFields[y];
for (y in A) C.apply(M, A[y]);
return l.timeout > 0 && (E = setTimeout(function() {
M.onreadystatechange = c, M.abort(), h(null, "timeout", M, l, m);
}, l.timeout)), M.send(l.data ? l.data : null), M;
}, e.get = function() {
return e.ajax(m.apply(null, arguments));
}, e.post = function() {
var t = m.apply(null, arguments);
return t.type = "POST", e.ajax(t);
}, e.getJSON = function() {
var t = m.apply(null, arguments);
return t.dataType = "json", e.ajax(t);
}, e.fn.load = function(t, i, s) {
if (!this.length) return this;
var r, n = this, a = t.split(/\s/), o = m(t, i, s), h = o.success;
return a.length > 1 && (o.url = a[0], r = a[1]), o.success = function(t) {
n.html(r ? e("<div>").html(t.replace(E, "")).find(r) : t), h && h.apply(n, arguments);
}, e.ajax(o), this;
};
var M = encodeURIComponent;
e.param = function(t, i) {
var s = [];
return s.add = function(t, i) {
e.isFunction(i) && (i = i()), null == i && (i = ""), this.push(M(t) + "=" + M(i));
}, g(s, t, i), s.join("&").replace(/%20/g, "+");
};
}(e), function(t) {
t.fn.serializeArray = function() {
var e, i, s = [], r = function(t) {
return t.forEach ? t.forEach(r) : void s.push({
name: e,
value: t
});
};
return this[0] && t.each(this[0].elements, function(s, n) {
i = n.type, e = n.name, e && "fieldset" != n.nodeName.toLowerCase() && !n.disabled && "submit" != i && "reset" != i && "button" != i && "file" != i && ("radio" != i && "checkbox" != i || n.checked) && r(t(n).val());
}), s;
}, t.fn.serialize = function() {
var t = [];
return this.serializeArray().forEach(function(e) {
t.push(encodeURIComponent(e.name) + "=" + encodeURIComponent(e.value));
}), t.join("&");
}, t.fn.submit = function(e) {
if (0 in arguments) this.bind("submit", e); else if (this.length) {
var i = t.Event("submit");
this.eq(0).trigger(i), i.isDefaultPrevented() || this.get(0).submit();
}
return this;
};
}(e), function() {
try {
getComputedStyle(void 0);
} catch (e) {
var i = getComputedStyle;
t.getComputedStyle = function(t, e) {
try {
return i(t, e);
} catch (s) {
return null;
}
};
}
}(), e;
}), _ = {}, _.escape = function() {
var t = {
"&": "&amp;",
"<": "&lt;",
">": "&gt;",
'"': "&quot;",
"'": "&#x27;",
"`": "&#x60;"
}, e = function(e) {
return t[e];
}, i = "(?:" + Object.keys(t).join("|") + ")", s = RegExp(i), r = RegExp(i, "g");
return function(t) {
return t = null == t ? "" : "" + t, s.test(t) ? t.replace(r, e) : t;
};
}(), _.isFunction = function(t) {
return "[object Function]" === Object.prototype.toString.call(t);
}, "function" != typeof /./ && "object" != typeof Int8Array && (_.isFunction = function(t) {
return "function" == typeof t || !1;
}), _.has = function(t, e) {
return null != t && Object.prototype.hasOwnProperty.call(t, e);
};

var eq = function(t, e, i, s) {
if (t === e) return 0 !== t || 1 / t === 1 / e;
if (null == t || null == e) return t === e;
var r = toString.call(t);
if (r !== toString.call(e)) return !1;
switch (r) {
case "[object RegExp]":
case "[object String]":
return "" + t == "" + e;

case "[object Number]":
return +t !== +t ? +e !== +e : 0 === +t ? 1 / +t === 1 / e : +t === +e;

case "[object Date]":
case "[object Boolean]":
return +t === +e;
}
var n = "[object Array]" === r;
if (!n) {
if ("object" != typeof t || "object" != typeof e) return !1;
var a = t.constructor, o = e.constructor;
if (a !== o && !(_.isFunction(a) && a instanceof a && _.isFunction(o) && o instanceof o) && "constructor" in t && "constructor" in e) return !1;
}
i = i || [], s = s || [];
for (var h = i.length; h--; ) if (i[h] === t) return s[h] === e;
if (i.push(t), s.push(e), n) {
if (h = t.length, h !== e.length) return !1;
for (;h--; ) if (!eq(t[h], e[h], i, s)) return !1;
} else {
var l, p = Object.keys(t);
if (h = p.length, Object.keys(e).length !== h) return !1;
for (;h--; ) if (l = p[h], !_.has(e, l) || !eq(t[l], e[l], i, s)) return !1;
}
return i.pop(), s.pop(), !0;
};

_.isEqual = function(t, e) {
return eq(t, e);
}, _.now = Date.now || function() {
return new Date().getTime();
}, _.throttle = function(t, e, i) {
var s, r, n, a = null, o = 0;
i || (i = {});
var h = function() {
o = i.leading === !1 ? 0 : _.now(), a = null, n = t.apply(s, r), a || (s = r = null);
};
return function() {
var l = _.now();
o || i.leading !== !1 || (o = l);
var p = e - (l - o);
return s = this, r = arguments, 0 >= p || p > e ? (a && (clearTimeout(a), a = null), 
o = l, n = t.apply(s, r), a || (s = r = null)) : a || i.trailing === !1 || (a = setTimeout(h, p)), 
n;
};
}, !function() {
function t(t) {
if (void 0 === t) return t;
var e, i, s, r, n, a;
for (s = t.length, i = 0, e = ""; s > i; ) {
if (r = 255 & t.charCodeAt(i++), i == s) {
e += d.charAt(r >> 2), e += d.charAt((3 & r) << 4), e += "==";
break;
}
if (n = t.charCodeAt(i++), i == s) {
e += d.charAt(r >> 2), e += d.charAt((3 & r) << 4 | (240 & n) >> 4), e += d.charAt((15 & n) << 2), 
e += "=";
break;
}
a = t.charCodeAt(i++), e += d.charAt(r >> 2), e += d.charAt((3 & r) << 4 | (240 & n) >> 4), 
e += d.charAt((15 & n) << 2 | (192 & a) >> 6), e += d.charAt(63 & a);
}
return e;
}
function e(t) {
for (var e in t) return !1;
return !0;
}
function i(t, i) {
var s = 100;
if ("share" == t) {
if (i && !e(i)) return i;
var r = "", n = "", a = "", o = document.querySelector("title"), h = document.querySelector("meta[name=description]"), l = document.querySelector("link[rel*=apple-touch-icon]"), p = document.querySelector("link[rel*=shortcut]");
if (o && (r = o.innerText), h && (n = h.content), p && (a = p.href), l && (a = l.href), 
!a) for (var c = document.querySelectorAll("body img"), f = 0; f < c.length; f++) {
var u = c[f];
if (u.naturalWidth > s && u.naturalHeight > s) {
a = u.src;
break;
}
}
return {
platform: "weixin_moments",
url: location.href,
title: r,
desc: n,
image: a
};
}
return i;
}
function s() {
f = document.createElement("iframe"), f.id = "__ToutiaoJSBridgeIframe_SetResult", 
f.style.display = "none", document.documentElement.appendChild(f), c = document.createElement("iframe"), 
c.id = "__ToutiaoJSBridgeIframe", c.style.display = "none", document.documentElement.appendChild(c);
}
function r() {
var t = JSON.stringify(m);
return m = [], a("SCENE_FETCHQUEUE", t), t;
}
function n(t) {
var e, i = t.__msg_type, s = t.__params, r = t.__event_id, n = t.__callback_id;
return "callback" == i ? (e = {
__err_code: "cb404"
}, "string" == typeof n && "function" == typeof v[n] && (e = v[n](s), delete v[n])) : "event" == i && (e = {
__err_code: "ev404"
}, "string" == typeof r && "function" == typeof y[r] && (e = y[r](s))), a("SCENE_HANDLEMSGFROMTT", JSON.stringify(e)), 
JSON.stringify(e);
}
function a(e, i) {
f.src = b + "private/setresult/" + e + "&" + t(u.encode(i));
}
function o(t, e, s, r) {
if (r = r || 1, t && "string" == typeof t) {
"object" != typeof e && (e = {}), e = i(t, e);
var n = (g++).toString();
"function" == typeof s && (v[n] = s);
var a = {
JSSDK: r,
func: t,
params: e,
__msg_type: "call",
__callback_id: n
};
m.push(a), c.src = b + "dispatch_message/";
}
}
function h(t, e) {
t && "string" == typeof t && "function" == typeof e && (y[t] = e, o("addEventListener", {
name: t
}, null));
}
function l(t, e) {
"function" == typeof y[t] && y[t](e);
}
function p() {
function t(t, e) {
return "params" == e ? t : t[e];
}
var i = {
pageStateChange: "page_state_change",
isVisible: "is_visible",
isLogin: "is_login",
uploadImage: "upload_image"
}, s = [ "appInfo", "login", "comment", "close", "isVisible", "isLogin", "playVideo" ], r = [ "isAppInstalled", "open", "share", "systemShare", "pay", "pageStateChange", "downloadApp", "openThirdApp", "uploadImage", "addChannel", "gallery", "copyToClipboard", "openCocosPlay" ], n = s.concat(r), a = navigator.userAgent.match(/JSSDK\/([\d.]+)/i), h = a ? a[1] : 1;
a ? n = n.concat([ "config" ]) : toutiao.config = function(e) {
var i = t(e, "success");
return i ? i({
code: 1,
supportList: {
call: s
}
}) : void 0;
}, n.forEach(function(s) {
toutiao[s] = function(r) {
r = r || {};
var n = t(r, "params"), a = t(r, "error"), l = t(r, "success"), p = t(r, "fail");
s = i[s] || s, o(s, n, function(t) {
t = t || {};
var i = t.code;
e(t) ? i = 1 : void 0 == i && (i = 1), -1 == i && a && a(t), 0 == i && p && p(t), 
1 == i && l && l(t);
}, h);
};
});
}
var c, f, u = {
encode: function(t) {
t = t || "", t = t.replace(/\r\n/g, "\n");
for (var e = "", i = 0; i < t.length; i++) {
var s = t.charCodeAt(i);
128 > s ? e += String.fromCharCode(s) : s > 127 && 2048 > s ? (e += String.fromCharCode(s >> 6 | 192), 
e += String.fromCharCode(63 & s | 128)) : (e += String.fromCharCode(s >> 12 | 224), 
e += String.fromCharCode(s >> 6 & 63 | 128), e += String.fromCharCode(63 & s | 128));
}
return e;
},
decode: function(t) {
for (var e = "", i = 0, s = c1 = c2 = 0; i < t.length; ) s = t.charCodeAt(i), 128 > s ? (e += String.fromCharCode(s), 
i++) : s > 191 && 224 > s ? (c2 = t.charCodeAt(i + 1), e += String.fromCharCode((31 & s) << 6 | 63 & c2), 
i += 2) : (c2 = t.charCodeAt(i + 1), c3 = t.charCodeAt(i + 2), e += String.fromCharCode((15 & s) << 12 | (63 & c2) << 6 | 63 & c3), 
i += 3);
return e;
}
}, d = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", m = [], g = 1e3, v = {}, y = {}, b = "bytedance://";
window.ToutiaoJSBridge = {
call: o,
on: h,
_fetchQueue: r,
_handleMessageFromToutiao: n
}, window.toutiao = {
on: h,
trigger: l
}, s(), p();
}(), !function(t) {
"use strict";
function e() {
var e = this;
e.reads = [], e.writes = [], e.raf = h.bind(t), o("initialized", e);
}
function i(t) {
t.scheduled || (t.scheduled = !0, t.raf(s.bind(null, t)), o("flush scheduled"));
}
function s(t) {
o("flush");
var e, s = t.writes, n = t.reads;
try {
o("flushing reads", n.length), r(n), o("flushing writes", s.length), r(s);
} catch (a) {
e = a;
}
if (t.scheduled = !1, (n.length || s.length) && i(t), e) {
if (o("task errored", e.message), !t.catch) throw e;
t.catch(e);
}
}
function r(t) {
o("run tasks");
for (var e; e = t.shift(); ) e();
}
function n(t, e) {
var i = t.indexOf(e);
return !!~i && !!t.splice(i, 1);
}
function a(t, e) {
for (var i in e) e.hasOwnProperty(i) && (t[i] = e[i]);
}
var o = function() {}, h = t.requestAnimationFrame || t.webkitRequestAnimationFrame || t.mozRequestAnimationFrame || t.msRequestAnimationFrame || function(t) {
return setTimeout(t, 16);
};
e.prototype = {
constructor: e,
measure: function(t, e) {
o("measure");
var s = e ? t.bind(e) : t;
return this.reads.push(s), i(this), s;
},
mutate: function(t, e) {
o("mutate");
var s = e ? t.bind(e) : t;
return this.writes.push(s), i(this), s;
},
clear: function(t) {
return o("clear", t), n(this.reads, t) || n(this.writes, t);
},
extend: function(t) {
if (o("extend", t), "object" != typeof t) throw new Error("expected object");
var e = Object.create(this);
return a(e, t), e.fastdom = this, e.initialize && e.initialize(), e;
},
"catch": null
};
var l = t.fastdom = t.fastdom || new e();
"f" == (typeof define)[0] ? define(function() {
return l;
}) : "o" == (typeof module)[0] && (module.exports = l);
}("undefined" != typeof window ? window : this), !function() {
function t() {
var t = "Android";
return p.match(/(Android)\s+([\d.]+)/) && (t = "Android_" + p.match(/(Android)\s+([\d.]+)/)[2]), 
(p.match(/(iPad).*OS\s([\d_]+)/) || p.match(/(iPhone\sOS)\s([\d_]+)/)) && (t = "iOS_" + (p.match(/(iPad).*OS\s([\d_]+)/) ? p.match(/(iPad).*OS\s([\d_]+)/)[2] : p.match(/(iPhone\sOS)\s([\d_]+)/)[2])), 
p.match(/Windows Phone/) && (t = "WP"), t;
}
function e() {
var t = p.match(/NetType\/([^\s]*)/i), e = "WIFI";
return t && (e = t[1]), e;
}
function i() {
var i = {
net_type: e(),
system: t(),
event: "pv"
};
f.push(i);
}
function s() {
f.forEach(function(t) {
t = t || {};
for (var e in c) t[e] = c[e];
var i = [];
for (var s in t) i.push(s + "=" + t[s]);
var r = new Image(), a = h + "?" + i.join("&");
r.src = a;
var o = n, p = o.percent;
if (Math.floor(1e3 * Math.random()) < p) {
var f = l.replace("{PATHNAME}", t.pathname);
f += "?" + i.join("&");
var u = new Image();
u.src = f;
}
}), f = [];
}
function r() {
o || (o = setTimeout(function() {
s(), o = null;
}, 1e3));
}
var n = {
percent: 1,
pathname: "app_article_detail"
}, a = location.protocol;
a = "http:" !== a && "https:" !== a ? "https:" : "";
var o, h = a + "//www.toutiao.com/__utm.gif", l = a + "//m.toutiao.com/log/sentry/v2/api/{PATHNAME}/perf/", p = navigator.userAgent, c = {}, f = [];
c.pathname = n.pathname, c.hostname = location.hostname, c._ta = "TA." + Math.random() + "." + Date.now(), 
window.sendToutiaoGifLog = s, window.sendTTCustomizeLog = function(t, e) {
t = t + "_" + APP_VERSION + "_" + CLIENT_VERSION, f.push({
tt_perf_key: [ t, e ].join("~")
}), r();
}, i();
}(), SelfEvent.prototype.on = function(t, e) {
t && "string" == typeof t && "function" == typeof e && (Array.isArray(this.eventMap[t]) ? -1 === this.eventMap[t].indexOf(e) && this.eventMap[t].push(e) : this.eventMap[t] = [ e ]);
}, SelfEvent.prototype.off = function(t, e) {
if (t && "string" == typeof t) if (e) {
if ("function" == typeof e && Array.isArray(this.eventMap[t])) {
var i = this.eventMap[t].indexOf(e);
i > -1 && this.eventMap[t].splice(i, 1);
}
} else delete this.eventMap[t];
}, SelfEvent.prototype.emit = function(t, e) {
t && "string" == typeof t && e && Array.isArray(this.eventMap[t]) && this.eventMap[t].forEach(function(t) {
t.call(e);
});
};

var pgcEvent = new SelfEvent("pgc");

!function(t) {
if ("object" == typeof exports && "undefined" != typeof module) module.exports = t(); else if ("function" == typeof define && define.amd) define([], t); else {
var e;
e = "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : this, 
e.Raven = t();
}
}(function() {
return function t(e, i, s) {
function r(a, o) {
if (!i[a]) {
if (!e[a]) {
var h = "function" == typeof require && require;
if (!o && h) return h(a, !0);
if (n) return n(a, !0);
var l = new Error("Cannot find module '" + a + "'");
throw l.code = "MODULE_NOT_FOUND", l;
}
var p = i[a] = {
exports: {}
};
e[a][0].call(p.exports, function(t) {
var i = e[a][1][t];
return r(i ? i : t);
}, p, p.exports, t, e, i, s);
}
return i[a].exports;
}
for (var n = "function" == typeof require && require, a = 0; a < s.length; a++) r(s[a]);
return r;
}({
1: [ function(t, e) {
"use strict";
function i(t) {
this.name = "RavenConfigError", this.message = t;
}
i.prototype = new Error(), i.prototype.constructor = i, e.exports = i;
}, {} ],
2: [ function(t, e) {
"use strict";
var i = function(t, e, i) {
var s = t[e], r = t;
if (e in t) {
var n = "warn" === e ? "warning" : e;
t[e] = function() {
var t = [].slice.call(arguments), e = "" + t.join(" "), a = {
level: n,
logger: "console",
extra: {
arguments: t
}
};
i && i(e, a), s && Function.prototype.apply.call(s, r, t);
};
}
};
e.exports = {
wrapMethod: i
};
}, {} ],
3: [ function(t, e) {
(function(i) {
"use strict";
function s() {
return +new Date();
}
function r(t, e) {
return o(e) ? function(i) {
return e(i, t);
} : e;
}
function n() {
this.a = !("object" != typeof JSON || !JSON.stringify), this.b = !a(L), this.c = !a(j), 
this.d = null, this.e = null, this.f = null, this.g = null, this.h = null, this.i = null, 
this.j = {}, this.k = {
logger: "javascript",
ignoreErrors: [],
ignoreUrls: [],
whitelistUrls: [],
includePaths: [],
crossOrigin: "anonymous",
collectWindowErrors: !0,
maxMessageLength: 0,
maxUrlLength: 250,
stackTraceLimit: 50,
autoBreadcrumbs: !0,
instrument: !0,
sampleRate: 1
}, this.l = 0, this.m = !1, this.n = Error.stackTraceLimit, this.o = N.console || {}, 
this.p = {}, this.q = [], this.r = s(), this.s = [], this.t = [], this.u = null, 
this.v = N.location, this.w = this.v && this.v.href, this.x();
for (var t in this.o) this.p[t] = this.o[t];
}
function a(t) {
return void 0 === t;
}
function o(t) {
return "function" == typeof t;
}
function h(t) {
return "[object String]" === O.toString.call(t);
}
function l(t) {
for (var e in t) return !1;
return !0;
}
function p(t, e) {
var i, s;
if (a(t.length)) for (i in t) d(t, i) && e.call(null, i, t[i]); else if (s = t.length) for (i = 0; s > i; i++) e.call(null, i, t[i]);
}
function c(t, e) {
return e ? (p(e, function(e, i) {
t[e] = i;
}), t) : t;
}
function f(t) {
return !!Object.isFrozen && Object.isFrozen(t);
}
function u(t, e) {
return !e || t.length <= e ? t : t.substr(0, e) + "…";
}
function d(t, e) {
return O.hasOwnProperty.call(t, e);
}
function m(t) {
for (var e, i = [], s = 0, r = t.length; r > s; s++) e = t[s], h(e) ? i.push(e.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1")) : e && e.source && i.push(e.source);
return new RegExp(i.join("|"), "i");
}
function g(t) {
var e = [];
return p(t, function(t, i) {
e.push(encodeURIComponent(t) + "=" + encodeURIComponent(i));
}), e.join("&");
}
function v(t) {
var e = t.match(/^(([^:\/?#]+):)?(\/\/([^\/?#]*))?([^?#]*)(\?([^#]*))?(#(.*))?$/);
if (!e) return {};
var i = e[6] || "", s = e[8] || "";
return {
protocol: e[2],
host: e[4],
path: e[5],
relative: e[5] + i + s
};
}
function y() {
var t = N.crypto || N.msCrypto;
if (!a(t) && t.getRandomValues) {
var e = new Uint16Array(8);
t.getRandomValues(e), e[3] = 4095 & e[3] | 16384, e[4] = 16383 & e[4] | 32768;
var i = function(t) {
for (var e = t.toString(16); e.length < 4; ) e = "0" + e;
return e;
};
return i(e[0]) + i(e[1]) + i(e[2]) + i(e[3]) + i(e[4]) + i(e[5]) + i(e[6]) + i(e[7]);
}
return "xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx".replace(/[xy]/g, function(t) {
var e = 16 * Math.random() | 0, i = "x" === t ? e : 3 & e | 8;
return i.toString(16);
});
}
function b(t) {
for (var e, i = 5, s = 80, r = [], n = 0, a = 0, o = " > ", h = o.length; t && n++ < i && (e = k(t), 
!("html" === e || n > 1 && a + r.length * h + e.length >= s)); ) r.push(e), a += e.length, 
t = t.parentNode;
return r.reverse().join(o);
}
function k(t) {
var e, i, s, r, n, a = [];
if (!t || !t.tagName) return "";
if (a.push(t.tagName.toLowerCase()), t.id && a.push("#" + t.id), e = t.className, 
e && h(e)) for (i = e.split(/\s+/), n = 0; n < i.length; n++) a.push("." + i[n]);
var o = [ "type", "name", "title", "alt" ];
for (n = 0; n < o.length; n++) s = o[n], r = t.getAttribute(s), r && a.push("[" + s + '="' + r + '"]');
return a.join("");
}
function E(t, e) {
return !!(!!t ^ !!e);
}
function w(t, e) {
return !E(t, e) && (t = t.values[0], e = e.values[0], t.type === e.type && t.value === e.value && A(t.stacktrace, e.stacktrace));
}
function A(t, e) {
if (E(t, e)) return !1;
var i = t.frames, s = e.frames;
if (i.length !== s.length) return !1;
for (var r, n, a = 0; a < i.length; a++) if (r = i[a], n = s[a], r.filename !== n.filename || r.lineno !== n.lineno || r.colno !== n.colno || r["function"] !== n["function"]) return !1;
return !0;
}
function S(t, e, i, s) {
var r = t[e];
t[e] = i(r), s && s.push([ t, e, r ]);
}
var P = t(6), x = t(7), _ = t(1), M = t(5), C = M.isError, F = M.isObject, T = t(2).wrapMethod, D = "source protocol user pass host port path".split(" "), I = /^(?:(\w+):)?\/\/(?:(\w+)(:\w+)?@)?([\w\.-]+)(?::(\d+))?(\/.*)/, N = "undefined" != typeof window ? window : "undefined" != typeof i ? i : "undefined" != typeof self ? self : {}, L = N.document, j = N.navigator;
n.prototype = {
VERSION: "3.17.0",
debug: !1,
TraceKit: P,
config: function(t, e) {
var i = this;
if (i.g) return this.y("error", "Error: Raven has already been configured"), i;
if (!t) return i;
var s = i.k;
e && p(e, function(t, e) {
"tags" === t || "extra" === t || "user" === t ? i.j[t] = e : s[t] = e;
}), i.setDSN(t), s.ignoreErrors.push(/^Script error\.?$/), s.ignoreErrors.push(/^Javascript error: Script error\.? on line 0$/), 
s.ignoreErrors = m(s.ignoreErrors), s.ignoreUrls = !!s.ignoreUrls.length && m(s.ignoreUrls), 
s.whitelistUrls = !!s.whitelistUrls.length && m(s.whitelistUrls), s.includePaths = m(s.includePaths), 
s.maxBreadcrumbs = Math.max(0, Math.min(s.maxBreadcrumbs || 100, 100));
var r = {
xhr: !0,
console: !0,
dom: !0,
location: !0
}, n = s.autoBreadcrumbs;
"[object Object]" === {}.toString.call(n) ? n = c(r, n) : n !== !1 && (n = r), s.autoBreadcrumbs = n;
var a = {
tryCatch: !0
}, o = s.instrument;
return "[object Object]" === {}.toString.call(o) ? o = c(a, o) : o !== !1 && (o = a), 
s.instrument = o, P.collectWindowErrors = !!s.collectWindowErrors, i;
},
install: function() {
var t = this;
return t.isSetup() && !t.m && (P.report.subscribe(function() {
t.z.apply(t, arguments);
}), t.k.instrument && t.k.instrument.tryCatch && t.A(), t.k.autoBreadcrumbs && t.B(), 
t.C(), t.m = !0), Error.stackTraceLimit = t.k.stackTraceLimit, this;
},
setDSN: function(t) {
var e = this, i = e.D(t), s = i.path.lastIndexOf("/"), r = i.path.substr(1, s);
e.E = t, e.h = i.user, e.F = i.pass && i.pass.substr(1), e.i = i.path.substr(s + 1), 
e.g = e.G(i), e.H = e.g + "/" + r + "api/" + e.i + "/store/", this.x();
},
context: function(t, e, i) {
return o(t) && (i = e || [], e = t, t = void 0), this.wrap(t, e).apply(this, i);
},
wrap: function(t, e, i) {
function s() {
var s = [], n = arguments.length, a = !t || t && t.deep !== !1;
for (i && o(i) && i.apply(this, arguments); n--; ) s[n] = a ? r.wrap(t, arguments[n]) : arguments[n];
try {
return e.apply(this, s);
} catch (h) {
throw r.I(), r.captureException(h, t), h;
}
}
var r = this;
if (a(e) && !o(t)) return t;
if (o(t) && (e = t, t = void 0), !o(e)) return e;
try {
if (e.J) return e;
if (e.K) return e.K;
} catch (n) {
return e;
}
for (var h in e) d(e, h) && (s[h] = e[h]);
return s.prototype = e.prototype, e.K = s, s.J = !0, s.L = e, s;
},
uninstall: function() {
return P.report.uninstall(), this.M(), Error.stackTraceLimit = this.n, this.m = !1, 
this;
},
captureException: function(t, e) {
if (!C(t)) return this.captureMessage(t, c({
trimHeadFrames: 1,
stacktrace: !0
}, e));
this.d = t;
try {
var i = P.computeStackTrace(t);
this.N(i, e);
} catch (s) {
if (t !== s) throw s;
}
return this;
},
captureMessage: function(t, e) {
if (!this.k.ignoreErrors.test || !this.k.ignoreErrors.test(t)) {
e = e || {};
var i = c({
message: t + ""
}, e);
if (this.k.stacktrace || e && e.stacktrace) {
var s;
try {
throw new Error(t);
} catch (r) {
s = r;
}
s.name = null, e = c({
fingerprint: t,
trimHeadFrames: (e.trimHeadFrames || 0) + 1
}, e);
var n = P.computeStackTrace(s), a = this.O(n, e);
i.stacktrace = {
frames: a.reverse()
};
}
return this.P(i), this;
}
},
captureBreadcrumb: function(t) {
var e = c({
timestamp: s() / 1e3
}, t);
if (o(this.k.breadcrumbCallback)) {
var i = this.k.breadcrumbCallback(e);
if (F(i) && !l(i)) e = i; else if (i === !1) return this;
}
return this.t.push(e), this.t.length > this.k.maxBreadcrumbs && this.t.shift(), 
this;
},
addPlugin: function(t) {
var e = [].slice.call(arguments, 1);
return this.q.push([ t, e ]), this.m && this.C(), this;
},
setUserContext: function(t) {
return this.j.user = t, this;
},
setExtraContext: function(t) {
return this.Q("extra", t), this;
},
setTagsContext: function(t) {
return this.Q("tags", t), this;
},
clearContext: function() {
return this.j = {}, this;
},
getContext: function() {
return JSON.parse(x(this.j));
},
setEnvironment: function(t) {
return this.k.environment = t, this;
},
setRelease: function(t) {
return this.k.release = t, this;
},
setDataCallback: function(t) {
var e = this.k.dataCallback;
return this.k.dataCallback = r(e, t), this;
},
setBreadcrumbCallback: function(t) {
var e = this.k.breadcrumbCallback;
return this.k.breadcrumbCallback = r(e, t), this;
},
setShouldSendCallback: function(t) {
var e = this.k.shouldSendCallback;
return this.k.shouldSendCallback = r(e, t), this;
},
setTransport: function(t) {
return this.k.transport = t, this;
},
lastException: function() {
return this.d;
},
lastEventId: function() {
return this.f;
},
isSetup: function() {
return !(!this.a || !this.g && (this.ravenNotConfiguredError || (this.ravenNotConfiguredError = !0, 
this.y("error", "Error: Raven has not been configured.")), 1));
},
afterLoad: function() {
var t = N.RavenConfig;
t && this.config(t.dsn, t.config).install();
},
showReportDialog: function(t) {
if (L) {
t = t || {};
var e = t.eventId || this.lastEventId();
if (!e) throw new _("Missing eventId");
var i = t.dsn || this.E;
if (!i) throw new _("Missing DSN");
var s = encodeURIComponent, r = "";
r += "?eventId=" + s(e), r += "&dsn=" + s(i);
var n = t.user || this.j.user;
n && (n.name && (r += "&name=" + s(n.name)), n.email && (r += "&email=" + s(n.email)));
var a = this.G(this.D(i)), o = L.createElement("script");
o.async = !0, o.src = a + "/api/embed/error-page/" + r, (L.head || L.body).appendChild(o);
}
},
I: function() {
var t = this;
this.l += 1, setTimeout(function() {
t.l -= 1;
});
},
R: function(t, e) {
var i, s;
if (this.b) {
e = e || {}, t = "raven" + t.substr(0, 1).toUpperCase() + t.substr(1), L.createEvent ? (i = L.createEvent("HTMLEvents"), 
i.initEvent(t, !0, !0)) : (i = L.createEventObject(), i.eventType = t);
for (s in e) d(e, s) && (i[s] = e[s]);
if (L.createEvent) L.dispatchEvent(i); else try {
L.fireEvent("on" + i.eventType.toLowerCase(), i);
} catch (r) {}
}
},
S: function(t) {
var e = this;
return function(i) {
if (e.T = null, e.u !== i) {
e.u = i;
var s;
try {
s = b(i.target);
} catch (r) {
s = "<unknown>";
}
e.captureBreadcrumb({
category: "ui." + t,
message: s
});
}
};
},
U: function() {
var t = this, e = 1e3;
return function(i) {
var s;
try {
s = i.target;
} catch (r) {
return;
}
var n = s && s.tagName;
if (n && ("INPUT" === n || "TEXTAREA" === n || s.isContentEditable)) {
var a = t.T;
a || t.S("input")(i), clearTimeout(a), t.T = setTimeout(function() {
t.T = null;
}, e);
}
};
},
V: function(t, e) {
var i = v(this.v.href), s = v(e), r = v(t);
this.w = e, i.protocol === s.protocol && i.host === s.host && (e = s.relative), 
i.protocol === r.protocol && i.host === r.host && (t = r.relative), this.captureBreadcrumb({
category: "navigation",
data: {
to: e,
from: t
}
});
},
A: function() {
function t(t) {
return function() {
for (var e = new Array(arguments.length), s = 0; s < e.length; ++s) e[s] = arguments[s];
var r = e[0];
return o(r) && (e[0] = i.wrap(r)), t.apply ? t.apply(this, e) : t(e[0], e[1]);
};
}
function e(t) {
var e = N[t] && N[t].prototype;
e && e.hasOwnProperty && e.hasOwnProperty("addEventListener") && (S(e, "addEventListener", function(e) {
return function(s, n, a, o) {
try {
n && n.handleEvent && (n.handleEvent = i.wrap(n.handleEvent));
} catch (h) {}
var l, p, c;
return r && r.dom && ("EventTarget" === t || "Node" === t) && (p = i.S("click"), 
c = i.U(), l = function(t) {
if (t) {
var e;
try {
e = t.type;
} catch (i) {
return;
}
return "click" === e ? p(t) : "keypress" === e ? c(t) : void 0;
}
}), e.call(this, s, i.wrap(n, void 0, l), a, o);
};
}, s), S(e, "removeEventListener", function(t) {
return function(e, i, s, r) {
try {
i = i && (i.K ? i.K : i);
} catch (n) {}
return t.call(this, e, i, s, r);
};
}, s));
}
var i = this, s = i.s, r = this.k.autoBreadcrumbs;
S(N, "setTimeout", t, s), S(N, "setInterval", t, s), N.requestAnimationFrame && S(N, "requestAnimationFrame", function(t) {
return function(e) {
return t(i.wrap(e));
};
}, s);
for (var n = [ "EventTarget", "Window", "Node", "ApplicationCache", "AudioTrackList", "ChannelMergerNode", "CryptoOperation", "EventSource", "FileReader", "HTMLUnknownElement", "IDBDatabase", "IDBRequest", "IDBTransaction", "KeyOperation", "MediaController", "MessagePort", "ModalWindow", "Notification", "SVGElementInstance", "Screen", "TextTrack", "TextTrackCue", "TextTrackList", "WebSocket", "WebSocketWorker", "Worker", "XMLHttpRequest", "XMLHttpRequestEventTarget", "XMLHttpRequestUpload" ], a = 0; a < n.length; a++) e(n[a]);
},
B: function() {
function t(t, i) {
t in i && o(i[t]) && S(i, t, function(t) {
return e.wrap(t);
});
}
var e = this, i = this.k.autoBreadcrumbs, s = e.s;
if (i.xhr && "XMLHttpRequest" in N) {
var r = XMLHttpRequest.prototype;
S(r, "open", function(t) {
return function(i, s) {
return h(s) && -1 === s.indexOf(e.h) && (this.W = {
method: i,
url: s,
status_code: null
}), t.apply(this, arguments);
};
}, s), S(r, "send", function(i) {
return function() {
function s() {
if (r.W && (1 === r.readyState || 4 === r.readyState)) {
try {
r.W.status_code = r.status;
} catch (t) {}
e.captureBreadcrumb({
type: "http",
category: "xhr",
data: r.W
});
}
}
for (var r = this, n = [ "onload", "onerror", "onprogress" ], a = 0; a < n.length; a++) t(n[a], r);
return "onreadystatechange" in r && o(r.onreadystatechange) ? S(r, "onreadystatechange", function(t) {
return e.wrap(t, void 0, s);
}) : r.onreadystatechange = s, i.apply(this, arguments);
};
}, s);
}
i.xhr && "fetch" in N && S(N, "fetch", function(t) {
return function() {
for (var i = new Array(arguments.length), s = 0; s < i.length; ++s) i[s] = arguments[s];
var r, n = i[0], a = "GET";
"string" == typeof n ? r = n : (r = n.url, n.method && (a = n.method)), i[1] && i[1].method && (a = i[1].method);
var o = {
method: a,
url: r,
status_code: null
};
return e.captureBreadcrumb({
type: "http",
category: "fetch",
data: o
}), t.apply(this, i).then(function(t) {
return o.status_code = t.status, t;
});
};
}, s), i.dom && this.b && (L.addEventListener ? (L.addEventListener("click", e.S("click"), !1), 
L.addEventListener("keypress", e.U(), !1)) : (L.attachEvent("onclick", e.S("click")), 
L.attachEvent("onkeypress", e.U())));
var n = N.chrome, a = n && n.app && n.app.runtime, l = !a && N.history && history.pushState;
if (i.location && l) {
var c = N.onpopstate;
N.onpopstate = function() {
var t = e.v.href;
return e.V(e.w, t), c ? c.apply(this, arguments) : void 0;
}, S(history, "pushState", function(t) {
return function() {
var i = arguments.length > 2 ? arguments[2] : void 0;
return i && e.V(e.w, i + ""), t.apply(this, arguments);
};
}, s);
}
if (i.console && "console" in N && console.log) {
var f = function(t, i) {
e.captureBreadcrumb({
message: t,
level: i.level,
category: "console"
});
};
p([ "debug", "info", "warn", "error", "log" ], function(t, e) {
T(console, e, f);
});
}
},
M: function() {
for (var t; this.s.length; ) {
t = this.s.shift();
var e = t[0], i = t[1], s = t[2];
e[i] = s;
}
},
C: function() {
var t = this;
p(this.q, function(e, i) {
var s = i[0], r = i[1];
s.apply(t, [ t ].concat(r));
});
},
D: function(t) {
var e = I.exec(t), i = {}, s = 7;
try {
for (;s--; ) i[D[s]] = e[s] || "";
} catch (r) {
throw new _("Invalid DSN: " + t);
}
if (i.pass && !this.k.allowSecretKey) throw new _("Do not specify your secret key in the DSN. See: http://bit.ly/raven-secret-key");
return i;
},
G: function(t) {
var e = "//" + t.host + (t.port ? ":" + t.port : "");
return t.protocol && (e = t.protocol + ":" + e), e;
},
z: function() {
this.l || this.N.apply(this, arguments);
},
N: function(t, e) {
var i = this.O(t, e);
this.R("handle", {
stackInfo: t,
options: e
}), this.X(t.name, t.message, t.url, t.lineno, i, e);
},
O: function(t, e) {
var i = this, s = [];
if (t.stack && t.stack.length && (p(t.stack, function(t, e) {
var r = i.Y(e);
r && s.push(r);
}), e && e.trimHeadFrames)) for (var r = 0; r < e.trimHeadFrames && r < s.length; r++) s[r].in_app = !1;
return s = s.slice(0, this.k.stackTraceLimit);
},
Y: function(t) {
if (t.url) {
var e = {
filename: t.url,
lineno: t.line,
colno: t.column,
"function": t.func || "?"
};
return e.in_app = !(this.k.includePaths.test && !this.k.includePaths.test(e.filename) || /(Raven|TraceKit)\./.test(e["function"]) || /raven\.(min\.)?js$/.test(e.filename)), 
e;
}
},
X: function(t, e, i, s, r, n) {
var a;
if (!(this.k.ignoreErrors.test && this.k.ignoreErrors.test(e) || (e += "", r && r.length ? (i = r[0].filename || i, 
r.reverse(), a = {
frames: r
}) : i && (a = {
frames: [ {
filename: i,
lineno: s,
in_app: !0
} ]
}), this.k.ignoreUrls.test && this.k.ignoreUrls.test(i) || this.k.whitelistUrls.test && !this.k.whitelistUrls.test(i)))) {
var o = c({
exception: {
values: [ {
type: t,
value: e,
stacktrace: a
} ]
},
culprit: i
}, n);
this.P(o);
}
},
Z: function(t) {
var e = this.k.maxMessageLength;
if (t.message && (t.message = u(t.message, e)), t.exception) {
var i = t.exception.values[0];
i.value = u(i.value, e);
}
var s = t.request;
return s && (s.url && (s.url = u(s.url, this.k.maxUrlLength)), s.Referer && (s.Referer = u(s.Referer, this.k.maxUrlLength))), 
t.breadcrumbs && t.breadcrumbs.values && this.$(t.breadcrumbs), t;
},
$: function(t) {
for (var e, i, s, r = [ "to", "from", "url" ], n = 0; n < t.values.length; ++n) if (i = t.values[n], 
i.hasOwnProperty("data") && F(i.data) && !f(i.data)) {
s = c({}, i.data);
for (var a = 0; a < r.length; ++a) e = r[a], s.hasOwnProperty(e) && (s[e] = u(s[e], this.k.maxUrlLength));
t.values[n].data = s;
}
},
_: function() {
if (this.c || this.b) {
var t = {};
return this.c && j.userAgent && (t.headers = {
"User-Agent": navigator.userAgent
}), this.b && (L.location && L.location.href && (t.url = L.location.href), L.referrer && (t.headers || (t.headers = {}), 
t.headers.Referer = L.referrer)), t;
}
},
x: function() {
this.aa = 0, this.ba = null;
},
ca: function() {
return this.aa && s() - this.ba < this.aa;
},
da: function(t) {
var e = this.e;
return !(!e || t.message !== e.message || t.culprit !== e.culprit) && (t.stacktrace || e.stacktrace ? A(t.stacktrace, e.stacktrace) : !t.exception && !e.exception || w(t.exception, e.exception));
},
ea: function(t) {
if (!this.ca()) {
var e = t.status;
if (400 === e || 401 === e || 429 === e) {
var i;
try {
i = t.getResponseHeader("Retry-After"), i = 1e3 * parseInt(i, 10);
} catch (r) {}
this.aa = i ? i : 2 * this.aa || 1e3, this.ba = s();
}
}
},
P: function(t) {
var e = this.k, i = {
project: this.i,
logger: e.logger,
platform: "javascript"
}, r = this._();
return r && (i.request = r), t.trimHeadFrames && delete t.trimHeadFrames, t = c(i, t), 
t.tags = c(c({}, this.j.tags), t.tags), t.extra = c(c({}, this.j.extra), t.extra), 
t.extra["session:duration"] = s() - this.r, this.t && this.t.length > 0 && (t.breadcrumbs = {
values: [].slice.call(this.t, 0)
}), l(t.tags) && delete t.tags, this.j.user && (t.user = this.j.user), e.environment && (t.environment = e.environment), 
e.release && (t.release = e.release), e.serverName && (t.server_name = e.serverName), 
o(e.dataCallback) && (t = e.dataCallback(t) || t), !t || l(t) || o(e.shouldSendCallback) && !e.shouldSendCallback(t) ? void 0 : this.ca() ? void this.y("warn", "Raven dropped error due to backoff: ", t) : void ("number" == typeof e.sampleRate ? Math.random() < e.sampleRate && this.fa(t) : this.fa(t));
},
ga: function() {
return y();
},
fa: function(t, e) {
var i = this, s = this.k;
if (this.isSetup()) {
if (this.f = t.event_id || (t.event_id = this.ga()), t = this.Z(t), !this.k.allowDuplicates && this.da(t)) return void this.y("warn", "Raven dropped repeat event: ", t);
this.e = t, this.y("debug", "Raven about to send:", t);
var r = {
sentry_version: "7",
sentry_client: "raven-js/" + this.VERSION,
sentry_key: this.h
};
this.F && (r.sentry_secret = this.F);
var n = t.exception && t.exception.values[0];
this.captureBreadcrumb({
category: "sentry",
message: n ? (n.type ? n.type + ": " : "") + n.value : t.message,
event_id: t.event_id,
level: t.level || "error"
});
var a = this.H;
(s.transport || this.ha).call(this, {
url: a,
auth: r,
data: t,
options: s,
onSuccess: function() {
i.x(), i.R("success", {
data: t,
src: a
}), e && e();
},
onError: function(s) {
i.y("error", "Raven transport failed to send: ", s), s.request && i.ea(s.request), 
i.R("failure", {
data: t,
src: a
}), s = s || new Error("Raven send failed (no additional details provided)"), e && e(s);
}
});
}
},
ha: function(t) {
var e = new XMLHttpRequest(), i = "withCredentials" in e || "undefined" != typeof XDomainRequest;
if (i) {
var s = t.url;
"withCredentials" in e ? e.onreadystatechange = function() {
if (4 === e.readyState) if (200 === e.status) t.onSuccess && t.onSuccess(); else if (t.onError) {
var i = new Error("Sentry error code: " + e.status);
i.request = e, t.onError(i);
}
} : (e = new XDomainRequest(), s = s.replace(/^https?:/, ""), t.onSuccess && (e.onload = t.onSuccess), 
t.onError && (e.onerror = function() {
var i = new Error("Sentry error code: XDomainRequest");
i.request = e, t.onError(i);
})), e.open("POST", s + "?" + g(t.auth)), e.send(x(t.data));
}
},
y: function(t) {
this.p[t] && this.debug && Function.prototype.apply.call(this.p[t], this.o, [].slice.call(arguments, 1));
},
Q: function(t, e) {
a(e) ? delete this.j[t] : this.j[t] = c(this.j[t] || {}, e);
}
};
var O = Object.prototype;
n.prototype.setUser = n.prototype.setUserContext, n.prototype.setReleaseContext = n.prototype.setRelease, 
e.exports = n;
}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {});
}, {
1: 1,
2: 2,
5: 5,
6: 6,
7: 7
} ],
4: [ function(t, e) {
(function(i) {
"use strict";
var s = t(3), r = "undefined" != typeof window ? window : "undefined" != typeof i ? i : "undefined" != typeof self ? self : {}, n = r.Raven, a = new s();
a.noConflict = function() {
return r.Raven = n, a;
}, a.afterLoad(), e.exports = a;
}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {});
}, {
3: 3
} ],
5: [ function(t, e) {
"use strict";
function i(t) {
return "object" == typeof t && null !== t;
}
function s(t) {
switch ({}.toString.call(t)) {
case "[object Error]":
return !0;

case "[object Exception]":
return !0;

case "[object DOMException]":
return !0;

default:
return t instanceof Error;
}
}
function r(t) {
function e(e, i) {
var s = t(e) || e;
return i ? i(s) || s : s;
}
return e;
}
e.exports = {
isObject: i,
isError: s,
wrappedCallback: r
};
}, {} ],
6: [ function(t, e) {
(function(i) {
"use strict";
function s() {
return "undefined" == typeof document || "undefined" == typeof document.location ? "" : document.location.href;
}
var r = t(5), n = {
collectWindowErrors: !0,
debug: !1
}, a = "undefined" != typeof window ? window : "undefined" != typeof i ? i : "undefined" != typeof self ? self : {}, o = [].slice, h = "?", l = /^(?:[Uu]ncaught (?:exception: )?)?(?:((?:Eval|Internal|Range|Reference|Syntax|Type|URI|)Error): )?(.*)$/;
n.report = function() {
function t(t) {
f(), y.push(t);
}
function e(t) {
for (var e = y.length - 1; e >= 0; --e) y[e] === t && y.splice(e, 1);
}
function i() {
u(), y = [];
}
function p(t, e) {
var i = null;
if (!e || n.collectWindowErrors) {
for (var s in y) if (y.hasOwnProperty(s)) try {
y[s].apply(null, [ t ].concat(o.call(arguments, 2)));
} catch (r) {
i = r;
}
if (i) throw i;
}
}
function c(t, e, i, a, o) {
var c = null;
if (E) n.computeStackTrace.augmentStackTraceWithInitialElement(E, e, i, t), d(); else if (o && r.isError(o)) c = n.computeStackTrace(o), 
p(c, !0); else {
var f, u = {
url: e,
line: i,
column: a
}, m = void 0, v = t;
if ("[object String]" === {}.toString.call(t)) {
var f = t.match(l);
f && (m = f[1], v = f[2]);
}
u.func = h, c = {
name: m,
message: v,
url: s(),
stack: [ u ]
}, p(c, !0);
}
return !!g && g.apply(this, arguments);
}
function f() {
v || (g = a.onerror, a.onerror = c, v = !0);
}
function u() {
v && (a.onerror = g, v = !1, g = void 0);
}
function d() {
var t = E, e = b;
b = null, E = null, k = null, p.apply(null, [ t, !1 ].concat(e));
}
function m(t, e) {
var i = o.call(arguments, 1);
if (E) {
if (k === t) return;
d();
}
var s = n.computeStackTrace(t);
if (E = s, k = t, b = i, setTimeout(function() {
k === t && d();
}, s.incomplete ? 2e3 : 0), e !== !1) throw t;
}
var g, v, y = [], b = null, k = null, E = null;
return m.subscribe = t, m.unsubscribe = e, m.uninstall = i, m;
}(), n.computeStackTrace = function() {
function t(t) {
if ("undefined" != typeof t.stack && t.stack) {
for (var e, i, r, n = /^\s*at (.*?) ?\(((?:file|https?|blob|chrome-extension|native|eval|webpack|<anonymous>|\/).*?)(?::(\d+))?(?::(\d+))?\)?\s*$/i, a = /^\s*(.*?)(?:\((.*?)\))?(?:^|@)((?:file|https?|blob|chrome|webpack|resource|\[native).*?|[^@]*bundle)(?::(\d+))?(?::(\d+))?\s*$/i, o = /^\s*at (?:((?:\[object object\])?.+) )?\(?((?:file|ms-appx|https?|webpack|blob):.*?):(\d+)(?::(\d+))?\)?\s*$/i, l = /(\S+) line (\d+)(?: > eval line \d+)* > eval/i, p = /\((\S*)(?::(\d+))(?::(\d+))\)/, c = t.stack.split("\n"), f = [], u = (/^(.*) is undefined$/.exec(t.message), 
0), d = c.length; d > u; ++u) {
if (i = n.exec(c[u])) {
var m = i[2] && 0 === i[2].indexOf("native"), g = i[2] && 0 === i[2].indexOf("eval");
g && (e = p.exec(i[2])) && (i[2] = e[1], i[3] = e[2], i[4] = e[3]), r = {
url: m ? null : i[2],
func: i[1] || h,
args: m ? [ i[2] ] : [],
line: i[3] ? +i[3] : null,
column: i[4] ? +i[4] : null
};
} else if (i = o.exec(c[u])) r = {
url: i[2],
func: i[1] || h,
args: [],
line: +i[3],
column: i[4] ? +i[4] : null
}; else {
if (!(i = a.exec(c[u]))) continue;
var g = i[3] && i[3].indexOf(" > eval") > -1;
g && (e = l.exec(i[3])) ? (i[3] = e[1], i[4] = e[2], i[5] = null) : 0 !== u || i[5] || "undefined" == typeof t.columnNumber || (f[0].column = t.columnNumber + 1), 
r = {
url: i[3],
func: i[1] || h,
args: i[2] ? i[2].split(",") : [],
line: i[4] ? +i[4] : null,
column: i[5] ? +i[5] : null
};
}
!r.func && r.line && (r.func = h), f.push(r);
}
return f.length ? {
name: t.name,
message: t.message,
url: s(),
stack: f
} : null;
}
}
function e(t, e, i) {
var s = {
url: e,
line: i
};
if (s.url && s.line) {
if (t.incomplete = !1, s.func || (s.func = h), t.stack.length > 0 && t.stack[0].url === s.url) {
if (t.stack[0].line === s.line) return !1;
if (!t.stack[0].line && t.stack[0].func === s.func) return t.stack[0].line = s.line, 
!1;
}
return t.stack.unshift(s), t.partial = !0, !0;
}
return t.incomplete = !0, !1;
}
function i(t, a) {
for (var o, l, p = /function\s+([_$a-zA-Z\xA0-\uFFFF][_$a-zA-Z0-9\xA0-\uFFFF]*)?\s*\(/i, c = [], f = {}, u = !1, d = i.caller; d && !u; d = d.caller) if (d !== r && d !== n.report) {
if (l = {
url: null,
func: h,
line: null,
column: null
}, d.name ? l.func = d.name : (o = p.exec(d.toString())) && (l.func = o[1]), "undefined" == typeof l.func) try {
l.func = o.input.substring(0, o.input.indexOf("{"));
} catch (m) {}
f["" + d] ? u = !0 : f["" + d] = !0, c.push(l);
}
a && c.splice(0, a);
var g = {
name: t.name,
message: t.message,
url: s(),
stack: c
};
return e(g, t.sourceURL || t.fileName, t.line || t.lineNumber, t.message || t.description), 
g;
}
function r(e, r) {
var a = null;
r = null == r ? 0 : +r;
try {
if (a = t(e)) return a;
} catch (o) {
if (n.debug) throw o;
}
try {
if (a = i(e, r + 1)) return a;
} catch (o) {
if (n.debug) throw o;
}
return {
name: e.name,
message: e.message,
url: s()
};
}
return r.augmentStackTraceWithInitialElement = e, r.computeStackTraceFromStackProp = t, 
r;
}(), e.exports = n;
}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {});
}, {
5: 5
} ],
7: [ function(t, e, i) {
"use strict";
function s(t, e) {
for (var i = 0; i < t.length; ++i) if (t[i] === e) return i;
return -1;
}
function r(t, e, i, s) {
return JSON.stringify(t, n(e, s), i);
}
function n(t, e) {
var i = [], r = [];
return null == e && (e = function(t, e) {
return i[0] === e ? "[Circular ~]" : "[Circular ~." + r.slice(0, s(i, e)).join(".") + "]";
}), function(n, a) {
if (i.length > 0) {
var o = s(i, this);
~o ? i.splice(o + 1) : i.push(this), ~o ? r.splice(o, 1 / 0, n) : r.push(n), ~s(i, a) && (a = e.call(this, n, a));
} else i.push(a);
return null == t ? a : t.call(this, n, a);
};
}
i = e.exports = r, i.getSerialize = n;
}, {} ]
}, {}, [ 4 ])(4);
}), JSVERSION = 292;

var globalErrors = [], startTimestamp = Date.now(), flushErrorsTimer;

window.onerror = function(t, e, i, s, r) {
"string" != typeof t && (t = "");
var n = {
version: JSVERSION,
message: t,
col: s,
url: e,
line: i,
timestamp: Date.now() - startTimestamp
};
n.stack = r && r.stack ? (r.stack || r.stacktrace).toString() : "", "ReferenceError: Can't find variable: getElementPosition" !== t && (t.indexOf("h.el.trigger") > -1 || (globalErrors.push(n), 
flushErrors()));
}, ToutiaoJSBridge && ToutiaoJSBridge.call("TTNetwork.commonParams", {}, function(t) {
var e = t.data || t;
e && e.device_id && window.Raven && Raven.config("http://key@m.toutiao.com/log/sentry/v2/183", {
tags: {
ac: e.ac,
aid: e.aid,
channel: e.channel,
device_brand: e.device_brand,
device_id: e.device_id,
device_platform: e.device_platform,
device_type: e.device_type,
os_version: e.os_version,
resolution: e.resolution,
uuid: e.uuid,
version_name: e.version_name || e.version_code,
js_version: JSVERSION,
gid: "",
service: MONITOR_SERVICE
},
ignoreErrors: [ "ReferenceError: Can't find variable: getElementPosition" ],
dataCallback: function(t) {
var e = [ "lib.js", "iphone.js", "ios-common.js", "android.js", "android-common.js" ], i = [ "js" ], s = [ "v55", "v60", "shared" ], r = "http://s3.pstatp.com/toutiao/app_web_article_online_updates/";
return t && t.exception && Array.isArray(t.exception.values) && t.exception.values.forEach(function(t) {
t && t.stacktrace && Array.isArray(t.stacktrace.frames) && t.stacktrace.frames.forEach(function(t) {
var n = t.filename, a = n.split("/"), o = a.length;
e.indexOf(a[o - 1]) >= 0 && i.indexOf(a[o - 2]) >= 0 && s.indexOf(a[o - 3]) >= 0 && (t.filename = r + JSVERSION + (client.isAndroid ? "/android" : "/iphone") + "/" + a[o - 3] + "/" + a[o - 2] + "/" + a[o - 1]);
});
}), t.tags.gid = window.Page && Page.statistics ? Page.statistics.group_id : "", 
t;
}
}).install();
});

var window = "undefined" == typeof window ? {} : window;

!function(t, e) {
"function" == typeof define && define.amd ? define(e) : "object" == typeof module && module.exports ? module.exports = e() : t.bodymovin = e();
}(window, function() {
function t() {
return {};
}
function e(t) {
ke = t ? Math.round : function(t) {
return t;
};
}
function i(t) {
return Math.round(1e4 * t) / 1e4;
}
function s(t) {
t.style.userSelect = "none", t.style.MozUserSelect = "none", t.style.webkitUserSelect = "none", 
t.style.oUserSelect = "none";
}
function r(t, e, i, s) {
this.type = t, this.currentTime = e, this.totalTime = i, this.direction = 0 > s ? -1 : 1;
}
function n(t, e) {
this.type = t, this.direction = 0 > e ? -1 : 1;
}
function a(t, e, i, s) {
this.type = t, this.currentLoop = e, this.totalLoops = i, this.direction = 0 > s ? -1 : 1;
}
function o(t, e, i) {
this.type = t, this.firstFrame = e, this.totalFrames = i;
}
function h(t, e) {
this.type = t, this.target = e;
}
function l(t, e) {
return this._cbs[t] || (this._cbs[t] = []), this._cbs[t].push(e), function() {
this.removeEventListener(t, e);
}.bind(this);
}
function p(t, e) {
if (e) {
if (this._cbs[t]) {
for (var i = 0, s = this._cbs[t].length; s > i; ) this._cbs[t][i] === e && (this._cbs[t].splice(i, 1), 
i -= 1, s -= 1), i += 1;
this._cbs[t].length || (this._cbs[t] = null);
}
} else this._cbs[t] = null;
}
function c(t, e) {
if (this._cbs[t]) for (var i = this._cbs[t].length, s = 0; i > s; s++) this._cbs[t][s](e);
}
function f(t, e) {
void 0 === e && (e = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
var i, s = "";
for (i = t; i > 0; --i) s += e[Math.round(Math.random() * (e.length - 1))];
return s;
}
function u(t, e, i) {
var s, r, n, a, o, h, l, p;
switch (1 === arguments.length && (e = t.s, i = t.v, t = t.h), a = Math.floor(6 * t), 
o = 6 * t - a, h = i * (1 - e), l = i * (1 - o * e), p = i * (1 - (1 - o) * e), 
a % 6) {
case 0:
s = i, r = p, n = h;
break;

case 1:
s = l, r = i, n = h;
break;

case 2:
s = h, r = i, n = p;
break;

case 3:
s = h, r = l, n = i;
break;

case 4:
s = p, r = h, n = i;
break;

case 5:
s = i, r = h, n = l;
}
return [ s, r, n ];
}
function d(t, e, i) {
1 === arguments.length && (e = t.g, i = t.b, t = t.r);
var s, r = Math.max(t, e, i), n = Math.min(t, e, i), a = r - n, o = 0 === r ? 0 : a / r, h = r / 255;
switch (r) {
case n:
s = 0;
break;

case t:
s = e - i + a * (i > e ? 6 : 0), s /= 6 * a;
break;

case e:
s = i - t + 2 * a, s /= 6 * a;
break;

case i:
s = t - e + 4 * a, s /= 6 * a;
}
return [ s, o, h ];
}
function m(t, e) {
var i = d(255 * t[0], 255 * t[1], 255 * t[2]);
return i[1] += e, i[1] > 1 ? i[1] = 1 : i[1] <= 0 && (i[1] = 0), u(i[0], i[1], i[2]);
}
function g(t, e) {
var i = d(255 * t[0], 255 * t[1], 255 * t[2]);
return i[2] += e, i[2] > 1 ? i[2] = 1 : i[2] < 0 && (i[2] = 0), u(i[0], i[1], i[2]);
}
function v(t, e) {
var i = d(255 * t[0], 255 * t[1], 255 * t[2]);
return i[0] += e / 360, i[0] > 1 ? i[0] -= 1 : i[0] < 0 && (i[0] += 1), u(i[0], i[1], i[2]);
}
function y(t) {
var e, i, s = [], r = [], n = [], a = {}, o = 0;
t.c && (s[0] = t.o[0], r[0] = t.i[0], n[0] = t.v[0], o = 1), i = t.i.length;
var h = i - 1;
for (e = o; i > e; e += 1) s.push(t.o[h]), r.push(t.i[h]), n.push(t.v[h]), h -= 1;
return a.i = s, a.o = r, a.v = n, a;
}
function b() {}
function k(t, e, i) {
if (!e) {
var s = Object.create(t.prototype, i), r = {};
return s && "[object Function]" === r.toString.call(s.init) && s.init(), s;
}
e.prototype = Object.create(t.prototype), e.prototype.constructor = e, e.prototype._parent = t.prototype;
}
function E(t, e) {
for (var i in t.prototype) t.prototype.hasOwnProperty(i) && (e.prototype[i] = t.prototype[i]);
}
function w() {
function t(t, e, i, s, r, n) {
var a = t * s + e * r + i * n - r * s - n * t - i * e;
return a > -1e-4 && 1e-4 > a;
}
function e(e, i, s, r, n, a, o, h, l) {
if (0 === s && 0 === a && 0 === l) return t(e, i, r, n, o, h);
var p, c = Math.sqrt(Math.pow(r - e, 2) + Math.pow(n - i, 2) + Math.pow(a - s, 2)), f = Math.sqrt(Math.pow(o - e, 2) + Math.pow(h - i, 2) + Math.pow(l - s, 2)), u = Math.sqrt(Math.pow(o - r, 2) + Math.pow(h - n, 2) + Math.pow(l - a, 2));
return p = c > f ? c > u ? c - f - u : u - f - c : u > f ? u - f - c : f - c - u, 
p > -1e-4 && 1e-4 > p;
}
function i(t) {
this.segmentLength = 0, this.points = new Array(t);
}
function s(t, e) {
this.partialLength = t, this.point = e;
}
function r(t, e) {
var i = e.segments, s = i.length, r = _e((s - 1) * t), n = t * e.addedLength, a = 0;
if (n == i[r].l) return i[r].p;
for (var o = i[r].l > n ? -1 : 1, h = !0; h; ) i[r].l <= n && i[r + 1].l > n ? (a = (n - i[r].l) / (i[r + 1].l - i[r].l), 
h = !1) : r += o, (0 > r || r >= s - 1) && (h = !1);
return i[r].p + (i[r + 1].p - i[r].p) * a;
}
function n() {
this.pt1 = new Array(2), this.pt2 = new Array(2), this.pt3 = new Array(2), this.pt4 = new Array(2);
}
function a(t, e, i, s, a, o, h) {
var l = new n();
a = 0 > a ? 0 : a > 1 ? 1 : a;
var p = r(a, h);
o = o > 1 ? 1 : o;
var c, f = r(o, h), u = t.length, d = 1 - p, m = 1 - f;
for (c = 0; u > c; c += 1) l.pt1[c] = Math.round(1e3 * (d * d * d * t[c] + (p * d * d + d * p * d + d * d * p) * i[c] + (p * p * d + d * p * p + p * d * p) * s[c] + p * p * p * e[c])) / 1e3, 
l.pt3[c] = Math.round(1e3 * (d * d * m * t[c] + (p * d * m + d * p * m + d * d * f) * i[c] + (p * p * m + d * p * f + p * d * f) * s[c] + p * p * f * e[c])) / 1e3, 
l.pt4[c] = Math.round(1e3 * (d * m * m * t[c] + (p * m * m + d * f * m + d * m * f) * i[c] + (p * f * m + d * f * f + p * m * f) * s[c] + p * f * f * e[c])) / 1e3, 
l.pt2[c] = Math.round(1e3 * (m * m * m * t[c] + (f * m * m + m * f * m + m * m * f) * i[c] + (f * f * m + m * f * f + f * m * f) * s[c] + f * f * f * e[c])) / 1e3;
return l;
}
var o = function() {
function t(t, e) {
this.l = t, this.p = e;
}
return function(e, i, s, r) {
var n, a, o, h, l, p, c = Fe, f = 0, u = [], d = [], m = {
addedLength: 0,
segments: []
};
for (o = s.length, n = 0; c > n; n += 1) {
for (l = n / (c - 1), p = 0, a = 0; o > a; a += 1) h = Pe(1 - l, 3) * e[a] + 3 * Pe(1 - l, 2) * l * s[a] + 3 * (1 - l) * Pe(l, 2) * r[a] + Pe(l, 3) * i[a], 
u[a] = h, null !== d[a] && (p += Pe(u[a] - d[a], 2)), d[a] = u[a];
p && (p = xe(p), f += p), m.segments.push(new t(f, l));
}
return m.addedLength = f, m;
};
}(), h = function() {
var e = {};
return function(r) {
var n = r.s, a = r.e, o = r.to, h = r.ti, l = (n.join("_") + "_" + a.join("_") + "_" + o.join("_") + "_" + h.join("_")).replace(/\./g, "p");
if (e[l]) return void (r.bezierData = e[l]);
var p, c, f, u, d, m, g, v = Fe, y = 0, b = null;
2 === n.length && (n[0] != a[0] || n[1] != a[1]) && t(n[0], n[1], a[0], a[1], n[0] + o[0], n[1] + o[1]) && t(n[0], n[1], a[0], a[1], a[0] + h[0], a[1] + h[1]) && (v = 2);
var k = new i(v);
for (f = o.length, p = 0; v > p; p += 1) {
for (g = new Array(f), d = p / (v - 1), m = 0, c = 0; f > c; c += 1) u = Pe(1 - d, 3) * n[c] + 3 * Pe(1 - d, 2) * d * (n[c] + o[c]) + 3 * (1 - d) * Pe(d, 2) * (a[c] + h[c]) + Pe(d, 3) * a[c], 
g[c] = u, null !== b && (m += Pe(g[c] - b[c], 2));
m = xe(m), y += m, k.points[p] = new s(m, g), b = g;
}
k.segmentLength = y, r.bezierData = k, e[l] = k;
};
}();
return {
getBezierLength: o,
getNewSegment: a,
buildBezierData: h,
pointOnLine2D: t,
pointOnLine3D: e
};
}
function A() {
function t(r, n, o) {
var h, l, p, c, f, u, d, m, g = r.length;
for (c = 0; g > c; c += 1) if (h = r[c], "ks" in h && !h.completed) {
if (h.completed = !0, h.tt && (r[c - 1].td = h.tt), l = [], p = -1, h.hasMask) {
var v = h.masksProperties;
for (u = v.length, f = 0; u > f; f += 1) if (v[f].pt.k.i) s(v[f].pt.k); else for (m = v[f].pt.k.length, 
d = 0; m > d; d += 1) v[f].pt.k[d].s && s(v[f].pt.k[d].s[0]), v[f].pt.k[d].e && s(v[f].pt.k[d].e[0]);
}
0 === h.ty ? (h.layers = e(h.refId, n), t(h.layers, n, o)) : 4 === h.ty ? i(h.shapes) : 5 == h.ty && a(h, o);
}
}
function e(t, e) {
for (var i = 0, s = e.length; s > i; ) {
if (e[i].id === t) return e[i].layers.__used ? JSON.parse(JSON.stringify(e[i].layers)) : (e[i].layers.__used = !0, 
e[i].layers);
i += 1;
}
}
function i(t) {
var e, r, n, a = t.length, o = !1;
for (e = a - 1; e >= 0; e -= 1) if ("sh" == t[e].ty) {
if (t[e].ks.k.i) s(t[e].ks.k); else for (n = t[e].ks.k.length, r = 0; n > r; r += 1) t[e].ks.k[r].s && s(t[e].ks.k[r].s[0]), 
t[e].ks.k[r].e && s(t[e].ks.k[r].e[0]);
o = !0;
} else "gr" == t[e].ty && i(t[e].it);
}
function s(t) {
var e, i = t.i.length;
for (e = 0; i > e; e += 1) t.i[e][0] += t.v[e][0], t.i[e][1] += t.v[e][1], t.o[e][0] += t.v[e][0], 
t.o[e][1] += t.v[e][1];
}
function r(t, e) {
var i = e ? e.split(".") : [ 100, 100, 100 ];
return t[0] > i[0] ? !0 : i[0] > t[0] ? !1 : t[1] > i[1] ? !0 : i[1] > t[1] ? !1 : t[2] > i[2] ? !0 : i[2] > t[2] ? !1 : void 0;
}
function n(e, i) {
e.__complete || (l(e), o(e), h(e), p(e), t(e.layers, e.assets, i), e.__complete = !0);
}
function a(t, e) {
var i, s, r = t.t.d.k, n = r.length;
for (s = 0; n > s; s += 1) {
var a = t.t.d.k[s].s;
i = [];
var o, h, l, p, c, f, u, d = 0, m = t.t.m.g, g = 0, v = 0, y = 0, b = [], k = 0, E = 0, w = e.getFontByName(a.f), A = 0, S = w.fStyle.split(" "), P = "normal", x = "normal";
for (h = S.length, o = 0; h > o; o += 1) "italic" === S[o].toLowerCase() ? x = "italic" : "bold" === S[o].toLowerCase() ? P = "700" : "black" === S[o].toLowerCase() ? P = "900" : "medium" === S[o].toLowerCase() ? P = "500" : "regular" === S[o].toLowerCase() || "normal" === S[o].toLowerCase() ? P = "400" : ("light" === S[o].toLowerCase() || "thin" === S[o].toLowerCase()) && (P = "200");
if (a.fWeight = P, a.fStyle = x, h = a.t.length, a.sz) {
var _ = a.sz[0], M = -1;
for (o = 0; h > o; o += 1) l = !1, " " === a.t.charAt(o) ? M = o : 13 === a.t.charCodeAt(o) && (k = 0, 
l = !0), e.chars ? (u = e.getCharData(a.t.charAt(o), w.fStyle, w.fFamily), A = l ? 0 : u.w * a.s / 100) : A = e.measureText(a.t.charAt(o), a.f, a.s), 
k + A > _ ? (-1 === M ? (a.t = a.t.substr(0, o) + "\r" + a.t.substr(o), h += 1) : (o = M, 
a.t = a.t.substr(0, o) + "\r" + a.t.substr(o + 1)), M = -1, k = 0) : k += A;
h = a.t.length;
}
var C = a.tr / 1e3 * a.s;
for (k = -C, A = 0, o = 0; h > o; o += 1) if (l = !1, " " === a.t.charAt(o) ? p = " " : 13 === a.t.charCodeAt(o) ? (b.push(k), 
E = k > E ? k : E, k = -2 * C, p = "", l = !0, y += 1) : p = a.t.charAt(o), e.chars ? (u = e.getCharData(a.t.charAt(o), w.fStyle, e.getFontByName(a.f).fFamily), 
A = l ? 0 : u.w * a.s / 100) : A = e.measureText(p, a.f, a.s), k += A + C, i.push({
l: A,
an: A,
add: g,
n: l,
anIndexes: [],
val: p,
line: y
}), 2 == m) {
if (g += A, "" == p || " " == p || o == h - 1) {
for (("" == p || " " == p) && (g -= A); o >= v; ) i[v].an = g, i[v].ind = d, i[v].extra = A, 
v += 1;
d += 1, g = 0;
}
} else if (3 == m) {
if (g += A, "" == p || o == h - 1) {
for ("" == p && (g -= A); o >= v; ) i[v].an = g, i[v].ind = d, i[v].extra = A, v += 1;
g = 0, d += 1;
}
} else i[d].ind = d, i[d].extra = 0, d += 1;
if (a.l = i, E = k > E ? k : E, b.push(k), a.sz) a.boxWidth = a.sz[0], a.justifyOffset = 0; else switch (a.boxWidth = E, 
a.j) {
case 1:
a.justifyOffset = -a.boxWidth;
break;

case 2:
a.justifyOffset = -a.boxWidth / 2;
break;

default:
a.justifyOffset = 0;
}
a.lineWidths = b;
var F = t.t.a;
f = F.length;
var T, D, I = [];
for (c = 0; f > c; c += 1) {
for (F[c].a.sc && (a.strokeColorAnim = !0), F[c].a.sw && (a.strokeWidthAnim = !0), 
(F[c].a.fc || F[c].a.fh || F[c].a.fs || F[c].a.fb) && (a.fillColorAnim = !0), D = 0, 
T = F[c].s.b, o = 0; h > o; o += 1) i[o].anIndexes[c] = D, (1 == T && "" != i[o].val || 2 == T && "" != i[o].val && " " != i[o].val || 3 == T && (i[o].n || " " == i[o].val || o == h - 1) || 4 == T && (i[o].n || o == h - 1)) && (1 === F[c].s.rn && I.push(D), 
D += 1);
t.t.a[c].s.totalChars = D;
var N, L = -1;
if (1 === F[c].s.rn) for (o = 0; h > o; o += 1) L != i[o].anIndexes[c] && (L = i[o].anIndexes[c], 
N = I.splice(Math.floor(Math.random() * I.length), 1)[0]), i[o].anIndexes[c] = N;
}
0 !== f || "m" in t.t.p || (t.singleShape = !0), a.yOffset = a.lh || 1.2 * a.s, 
a.ls = a.ls || 0, a.ascent = w.ascent * a.s / 100;
}
}
var o = function() {
function t(t) {
var e = t.t.d;
t.t.d = {
k: [ {
s: e,
t: 0
} ]
};
}
function e(e) {
var i, s = e.length;
for (i = 0; s > i; i += 1) 5 === e[i].ty && t(e[i]);
}
var i = [ 4, 4, 14 ];
return function(t) {
if (r(i, t.v) && (e(t.layers), t.assets)) {
var s, n = t.assets.length;
for (s = 0; n > s; s += 1) t.assets[s].layers && e(t.assets[s].layers);
}
};
}(), h = function() {
var t = [ 4, 7, 99 ];
return function(e) {
if (e.chars && !r(t, e.v)) {
var i, n, a, o, h, l = e.chars.length;
for (i = 0; l > i; i += 1) if (e.chars[i].data && e.chars[i].data.shapes) for (h = e.chars[i].data.shapes[0].it, 
a = h.length, n = 0; a > n; n += 1) o = h[n].ks.k, s(h[n].ks.k);
}
};
}(), l = function() {
function t(e) {
var i, s, r, n = e.length;
for (i = 0; n > i; i += 1) if ("gr" === e[i].ty) t(e[i].it); else if ("fl" === e[i].ty || "st" === e[i].ty) if (e[i].c.k && e[i].c.k[0].i) for (r = e[i].c.k.length, 
s = 0; r > s; s += 1) e[i].c.k[s].s && (e[i].c.k[s].s[0] /= 255, e[i].c.k[s].s[1] /= 255, 
e[i].c.k[s].s[2] /= 255, e[i].c.k[s].s[3] /= 255), e[i].c.k[s].e && (e[i].c.k[s].e[0] /= 255, 
e[i].c.k[s].e[1] /= 255, e[i].c.k[s].e[2] /= 255, e[i].c.k[s].e[3] /= 255); else e[i].c.k[0] /= 255, 
e[i].c.k[1] /= 255, e[i].c.k[2] /= 255, e[i].c.k[3] /= 255;
}
function e(e) {
var i, s = e.length;
for (i = 0; s > i; i += 1) 4 === e[i].ty && t(e[i].shapes);
}
var i = [ 4, 1, 9 ];
return function(t) {
if (r(i, t.v) && (e(t.layers), t.assets)) {
var s, n = t.assets.length;
for (s = 0; n > s; s += 1) t.assets[s].layers && e(t.assets[s].layers);
}
};
}(), p = function() {
function t(e) {
var i, s, r, n = e.length, a = !1;
for (i = n - 1; i >= 0; i -= 1) if ("sh" == e[i].ty) {
if (e[i].ks.k.i) e[i].ks.k.c = e[i].closed; else for (r = e[i].ks.k.length, s = 0; r > s; s += 1) e[i].ks.k[s].s && (e[i].ks.k[s].s[0].c = e[i].closed), 
e[i].ks.k[s].e && (e[i].ks.k[s].e[0].c = e[i].closed);
a = !0;
} else "gr" == e[i].ty && t(e[i].it);
}
function e(e) {
var i, s, r, n, a, o, h = e.length;
for (s = 0; h > s; s += 1) {
if (i = e[s], i.hasMask) {
var l = i.masksProperties;
for (n = l.length, r = 0; n > r; r += 1) if (l[r].pt.k.i) l[r].pt.k.c = l[r].cl; else for (o = l[r].pt.k.length, 
a = 0; o > a; a += 1) l[r].pt.k[a].s && (l[r].pt.k[a].s[0].c = l[r].cl), l[r].pt.k[a].e && (l[r].pt.k[a].e[0].c = l[r].cl);
}
4 === i.ty && t(i.shapes);
}
}
var i = [ 4, 4, 18 ];
return function(t) {
if (r(i, t.v) && (e(t.layers), t.assets)) {
var s, n = t.assets.length;
for (s = 0; n > s; s += 1) t.assets[s].layers && e(t.assets[s].layers);
}
};
}(), c = {};
return c.completeData = n, c;
}
function S() {
this.c = !1, this._length = 0, this._maxLength = 8, this.v = Array.apply(null, {
length: this._maxLength
}), this.o = Array.apply(null, {
length: this._maxLength
}), this.i = Array.apply(null, {
length: this._maxLength
});
}
function P() {}
function x() {}
function _() {}
function M() {}
function C() {
this._length = 0, this._maxLength = 4, this.shapes = Array.apply(null, {
length: this._maxLength
});
}
function F(t, e, i) {
this.mdf = !1, this._firstFrame = !0, this._hasMaskedPath = !1, this._frameId = -1, 
this._dynamicProperties = [], this._textData = t, this._renderType = e, this._elem = i, 
this._animatorsData = Array.apply(null, {
length: this._textData.a.length
}), this._pathData = {}, this._moreOptions = {
alignment: {}
}, this.renderedLetters = [], this.lettersChangedFlag = !1;
}
function T(t, e, i, s, r, n) {
this.o = t, this.sw = e, this.sc = i, this.fc = s, this.m = r, this.p = n, this.mdf = {
o: !0,
sw: !!e,
sc: !!i,
fc: !!s,
m: !0,
p: !0
};
}
function D() {}
function I(t, e) {
this.animationItem = t, this.layers = null, this.renderedFrame = -1, this.globalData = {
frameNum: -1
}, this.renderConfig = {
preserveAspectRatio: e && e.preserveAspectRatio || "xMidYMid meet",
progressiveLoad: e && e.progressiveLoad || !1,
hideOnTransparent: e && e.hideOnTransparent === !1 ? !1 : !0,
viewBoxOnly: e && e.viewBoxOnly || !1
}, this.globalData.renderConfig = this.renderConfig, this.elements = [], this.pendingElements = [], 
this.destroyed = !1;
}
function N(t, e, i) {
this.dynamicProperties = [], this.data = t, this.element = e, this.globalData = i, 
this.paths = [], this.storedData = [], this.masksProperties = this.data.masksProperties, 
this.viewData = new Array(this.masksProperties.length), this.maskElement = null, 
this.firstFrame = !0;
var s, r, n, a, o, h, l, p, c = this.globalData.defs, u = this.masksProperties.length, d = this.masksProperties, m = 0, g = [], v = f(10), y = "clipPath", b = "clip-path";
for (s = 0; u > s; s++) if (("a" !== d[s].mode && "n" !== d[s].mode || d[s].inv || 100 !== d[s].o.k) && (y = "mask", 
b = "mask"), "s" != d[s].mode && "i" != d[s].mode || 0 != m ? o = null : (o = document.createElementNS(Ee, "rect"), 
o.setAttribute("fill", "#ffffff"), o.setAttribute("width", this.element.comp.data.w), 
o.setAttribute("height", this.element.comp.data.h), g.push(o)), r = document.createElementNS(Ee, "path"), 
"n" != d[s].mode) {
if (m += 1, "s" == d[s].mode ? r.setAttribute("fill", "#000000") : r.setAttribute("fill", "#ffffff"), 
r.setAttribute("clip-rule", "nonzero"), 0 !== d[s].x.k) {
y = "mask", b = "mask", p = Re.getProp(this.element, d[s].x, 0, null, this.dynamicProperties);
var k = "fi_" + f(10);
h = document.createElementNS(Ee, "filter"), h.setAttribute("id", k), l = document.createElementNS(Ee, "feMorphology"), 
l.setAttribute("operator", "dilate"), l.setAttribute("in", "SourceGraphic"), l.setAttribute("radius", "0"), 
h.appendChild(l), c.appendChild(h), "s" == d[s].mode ? r.setAttribute("stroke", "#000000") : r.setAttribute("stroke", "#ffffff");
} else l = null, p = null;
if (this.storedData[s] = {
elem: r,
x: p,
expan: l,
lastPath: "",
lastOperator: "",
filterId: k,
lastRadius: 0
}, "i" == d[s].mode) {
a = g.length;
var E = document.createElementNS(Ee, "g");
for (n = 0; a > n; n += 1) E.appendChild(g[n]);
var w = document.createElementNS(Ee, "mask");
w.setAttribute("mask-type", "alpha"), w.setAttribute("id", v + "_" + m), w.appendChild(r), 
c.appendChild(w), E.setAttribute("mask", "url(" + we + "#" + v + "_" + m + ")"), 
g.length = 0, g.push(E);
} else g.push(r);
d[s].inv && !this.solidPath && (this.solidPath = this.createLayerSolidPath()), this.viewData[s] = {
elem: r,
lastPath: "",
op: Re.getProp(this.element, d[s].o, 0, .01, this.dynamicProperties),
prop: Ve.getShapeProp(this.element, d[s], 3, this.dynamicProperties, null)
}, o && (this.viewData[s].invRect = o), this.viewData[s].prop.k || this.drawPath(d[s], this.viewData[s].prop.v, this.viewData[s]);
} else this.viewData[s] = {
op: Re.getProp(this.element, d[s].o, 0, .01, this.dynamicProperties),
prop: Ve.getShapeProp(this.element, d[s], 3, this.dynamicProperties, null),
elem: r
}, c.appendChild(r);
for (this.maskElement = document.createElementNS(Ee, y), u = g.length, s = 0; u > s; s += 1) this.maskElement.appendChild(g[s]);
this.maskElement.setAttribute("id", v), m > 0 && this.element.maskedElement.setAttribute(b, "url(" + we + "#" + v + ")"), 
c.appendChild(this.maskElement);
}
function L() {}
function j(t, e, i, s, r) {
this.globalData = i, this.comp = s, this.data = t, this.matteElement = null, this.transformedElement = null, 
this.isTransparent = !1, this.parentContainer = e, this.layerId = r ? r.layerId : "ly_" + f(10), 
this.placeholder = r, this._sizeChanged = !1, this.init();
}
function O(t, e, i, s, r) {
this.shapes = [], this.shapesData = t.shapes, this.stylesList = [], this.itemsData = [], 
this.prevViewData = [], this.shapeModifiers = [], this.processedElements = [], this._parent.constructor.call(this, t, e, i, s, r);
}
function R() {}
function V(t, e, i, s, r) {
this.textSpans = [], this.renderType = "svg", this._parent.constructor.call(this, t, e, i, s, r);
}
function z(t, e) {
this.filterManager = e;
var i = document.createElementNS(Ee, "feColorMatrix");
if (i.setAttribute("type", "matrix"), i.setAttribute("color-interpolation-filters", "linearRGB"), 
i.setAttribute("values", "0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0"), 
i.setAttribute("result", "f1"), t.appendChild(i), i = document.createElementNS(Ee, "feColorMatrix"), 
i.setAttribute("type", "matrix"), i.setAttribute("color-interpolation-filters", "sRGB"), 
i.setAttribute("values", "1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0"), i.setAttribute("result", "f2"), 
t.appendChild(i), this.matrixFilter = i, 100 !== e.effectElements[2].p.v || e.effectElements[2].p.k) {
var s = document.createElementNS(Ee, "feMerge");
t.appendChild(s);
var r;
r = document.createElementNS(Ee, "feMergeNode"), r.setAttribute("in", "SourceGraphic"), 
s.appendChild(r), r = document.createElementNS(Ee, "feMergeNode"), r.setAttribute("in", "f2"), 
s.appendChild(r);
}
}
function B(t, e) {
this.filterManager = e;
var i = document.createElementNS(Ee, "feColorMatrix");
i.setAttribute("type", "matrix"), i.setAttribute("color-interpolation-filters", "sRGB"), 
i.setAttribute("values", "1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0"), t.appendChild(i), 
this.matrixFilter = i;
}
function q(t, e) {
this.initialized = !1, this.filterManager = e, this.elem = t, this.paths = [];
}
function U(t, e) {
this.filterManager = e;
var i = document.createElementNS(Ee, "feColorMatrix");
i.setAttribute("type", "matrix"), i.setAttribute("color-interpolation-filters", "linearRGB"), 
i.setAttribute("values", "0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0"), 
i.setAttribute("result", "f1"), t.appendChild(i);
var s = document.createElementNS(Ee, "feComponentTransfer");
s.setAttribute("color-interpolation-filters", "sRGB"), t.appendChild(s), this.matrixFilter = s;
var r = document.createElementNS(Ee, "feFuncR");
r.setAttribute("type", "table"), s.appendChild(r), this.feFuncR = r;
var n = document.createElementNS(Ee, "feFuncG");
n.setAttribute("type", "table"), s.appendChild(n), this.feFuncG = n;
var a = document.createElementNS(Ee, "feFuncB");
a.setAttribute("type", "table"), s.appendChild(a), this.feFuncB = a;
}
function G(t, e) {
this.filterManager = e;
var i = this.filterManager.effectElements, s = document.createElementNS(Ee, "feComponentTransfer");
(i[9].p.k || 0 !== i[9].p.v || i[10].p.k || 1 !== i[10].p.v || i[11].p.k || 1 !== i[11].p.v || i[12].p.k || 0 !== i[12].p.v || i[13].p.k || 1 !== i[13].p.v) && (this.feFuncR = this.createFeFunc("feFuncR", s)), 
(i[16].p.k || 0 !== i[16].p.v || i[17].p.k || 1 !== i[17].p.v || i[18].p.k || 1 !== i[18].p.v || i[19].p.k || 0 !== i[19].p.v || i[20].p.k || 1 !== i[20].p.v) && (this.feFuncG = this.createFeFunc("feFuncG", s)), 
(i[23].p.k || 0 !== i[23].p.v || i[24].p.k || 1 !== i[24].p.v || i[25].p.k || 1 !== i[25].p.v || i[26].p.k || 0 !== i[26].p.v || i[27].p.k || 1 !== i[27].p.v) && (this.feFuncB = this.createFeFunc("feFuncB", s)), 
(i[30].p.k || 0 !== i[30].p.v || i[31].p.k || 1 !== i[31].p.v || i[32].p.k || 1 !== i[32].p.v || i[33].p.k || 0 !== i[33].p.v || i[34].p.k || 1 !== i[34].p.v) && (this.feFuncA = this.createFeFunc("feFuncA", s)), 
(this.feFuncR || this.feFuncG || this.feFuncB || this.feFuncA) && (s.setAttribute("color-interpolation-filters", "sRGB"), 
t.appendChild(s), s = document.createElementNS(Ee, "feComponentTransfer")), (i[2].p.k || 0 !== i[2].p.v || i[3].p.k || 1 !== i[3].p.v || i[4].p.k || 1 !== i[4].p.v || i[5].p.k || 0 !== i[5].p.v || i[6].p.k || 1 !== i[6].p.v) && (s.setAttribute("color-interpolation-filters", "sRGB"), 
t.appendChild(s), this.feFuncRComposed = this.createFeFunc("feFuncR", s), this.feFuncGComposed = this.createFeFunc("feFuncG", s), 
this.feFuncBComposed = this.createFeFunc("feFuncB", s));
}
function H(t, e) {
t.setAttribute("x", "-100%"), t.setAttribute("y", "-100%"), t.setAttribute("width", "400%"), 
t.setAttribute("height", "400%"), this.filterManager = e;
var i = document.createElementNS(Ee, "feGaussianBlur");
i.setAttribute("in", "SourceAlpha"), i.setAttribute("result", "drop_shadow_1"), 
i.setAttribute("stdDeviation", "0"), this.feGaussianBlur = i, t.appendChild(i);
var s = document.createElementNS(Ee, "feOffset");
s.setAttribute("dx", "25"), s.setAttribute("dy", "0"), s.setAttribute("in", "drop_shadow_1"), 
s.setAttribute("result", "drop_shadow_2"), this.feOffset = s, t.appendChild(s);
var r = document.createElementNS(Ee, "feFlood");
r.setAttribute("flood-color", "#00ff00"), r.setAttribute("flood-opacity", "1"), 
r.setAttribute("result", "drop_shadow_3"), this.feFlood = r, t.appendChild(r);
var n = document.createElementNS(Ee, "feComposite");
n.setAttribute("in", "drop_shadow_3"), n.setAttribute("in2", "drop_shadow_2"), n.setAttribute("operator", "in"), 
n.setAttribute("result", "drop_shadow_4"), t.appendChild(n);
var a = document.createElementNS(Ee, "feMerge");
t.appendChild(a);
var o;
o = document.createElementNS(Ee, "feMergeNode"), a.appendChild(o), o = document.createElementNS(Ee, "feMergeNode"), 
o.setAttribute("in", "SourceGraphic"), this.feMergeNode = o, this.feMerge = a, this.originalNodeAdded = !1, 
a.appendChild(o);
}
function W(t, e, i) {
this.initialized = !1, this.filterManager = e, this.filterElem = t, this.elem = i, 
i.matteElement = document.createElementNS(Ee, "g"), i.matteElement.appendChild(i.layerElement), 
i.matteElement.appendChild(i.transformedElement), i.baseElement = i.matteElement;
}
function X(t) {
var e, i = t.data.ef.length, s = f(10), r = Ue.createFilter(s), n = 0;
this.filters = [];
var a;
for (e = 0; i > e; e += 1) 20 === t.data.ef[e].ty ? (n += 1, a = new z(r, t.effects.effectElements[e]), 
this.filters.push(a)) : 21 === t.data.ef[e].ty ? (n += 1, a = new B(r, t.effects.effectElements[e]), 
this.filters.push(a)) : 22 === t.data.ef[e].ty ? (a = new q(t, t.effects.effectElements[e]), 
this.filters.push(a)) : 23 === t.data.ef[e].ty ? (n += 1, a = new U(r, t.effects.effectElements[e]), 
this.filters.push(a)) : 24 === t.data.ef[e].ty ? (n += 1, a = new G(r, t.effects.effectElements[e]), 
this.filters.push(a)) : 25 === t.data.ef[e].ty ? (n += 1, a = new H(r, t.effects.effectElements[e]), 
this.filters.push(a)) : 28 === t.data.ef[e].ty && (a = new W(r, t.effects.effectElements[e], t), 
this.filters.push(a));
n && (t.globalData.defs.appendChild(r), t.layerElement.setAttribute("filter", "url(" + we + "#" + s + ")"));
}
function J(t, e, i, s, r) {
this._parent.constructor.call(this, t, e, i, s, r), this.layers = t.layers, this.supports3d = !0, 
this.completeLayers = !1, this.pendingElements = [], this.elements = this.layers ? Array.apply(null, {
length: this.layers.length
}) : [], this.data.tm && (this.tm = Re.getProp(this, this.data.tm, 0, i.frameRate, this.dynamicProperties)), 
this.data.xt ? (this.layerElement = document.createElementNS(Ee, "g"), this.buildAllItems()) : i.progressiveLoad || this.buildAllItems();
}
function $(t, e, i, s, r) {
this.assetData = i.getAssetData(t.refId), this._parent.constructor.call(this, t, e, i, s, r);
}
function Y(t, e, i, s, r) {
this._parent.constructor.call(this, t, e, i, s, r);
}
function Z(t) {
we = t;
}
function K(t) {
Je.play(t);
}
function Q(t) {
Je.pause(t);
}
function te(t) {
Je.togglePause(t);
}
function ee(t, e) {
Je.setSpeed(t, e);
}
function ie(t, e) {
Je.setDirection(t, e);
}
function se(t) {
Je.stop(t);
}
function re(t) {
Je.moveFrame(t);
}
function ne() {
Ze === !0 ? Je.searchAnimations(Ke, Ze, Qe) : Je.searchAnimations();
}
function ae(t) {
return Je.registerAnimation(t);
}
function oe() {
Je.resize();
}
function he() {
Je.start();
}
function le(t, e, i) {
Je.goToAndStop(t, e, i);
}
function pe(t) {
Ae = t;
}
function ce(t) {
return Ze === !0 && (t.animationData = JSON.parse(Ke)), Je.loadAnimation(t);
}
function fe(t) {
return Je.destroy(t);
}
function ue(t) {
if ("string" == typeof t) switch (t) {
case "high":
Fe = 200;
break;

case "medium":
Fe = 50;
break;

case "low":
Fe = 10;
} else !isNaN(t) && t > 1 && (Fe = t);
e(Fe >= 50 ? !1 : !0);
}
function de() {
return "undefined" != typeof navigator;
}
function me(t, e) {
"expressions" === t && (be = e);
}
function ge(t) {
switch (t) {
case "propertyFactory":
return Re;

case "shapePropertyFactory":
return Ve;

case "matrix":
return b;
}
}
function ve() {
"complete" === document.readyState && (clearInterval(ri), ne());
}
function ye(t) {
for (var e = si.split("&"), i = 0; i < e.length; i++) {
var s = e[i].split("=");
if (decodeURIComponent(s[0]) == t) return decodeURIComponent(s[1]);
}
}
var be, ke, Ee = "http://www.w3.org/2000/svg", we = "", Ae = !0, Se = /^((?!chrome|android).)*safari/i.test(navigator.userAgent), Pe = (Math.round, 
Math.pow), xe = Math.sqrt, _e = (Math.abs, Math.floor), Me = (Math.max, Math.min), Ce = {};
!function() {
var t, e = Object.getOwnPropertyNames(Math), i = e.length;
for (t = 0; i > t; t += 1) Ce[e[t]] = Math[e[t]];
}(), Ce.random = Math.random, Ce.abs = function(t) {
var e = typeof t;
if ("object" === e && t.length) {
var i, s = Array.apply(null, {
length: t.length
}), r = t.length;
for (i = 0; r > i; i += 1) s[i] = Math.abs(t[i]);
return s;
}
return Math.abs(t);
};
var Fe = 150, Te = Math.PI / 180, De = .5519;
e(!1);
var Ie = function() {
var t, e, i = [];
for (t = 0; 256 > t; t += 1) e = t.toString(16), i[t] = 1 == e.length ? "0" + e : e;
return function(t, e, s) {
return 0 > t && (t = 0), 0 > e && (e = 0), 0 > s && (s = 0), "#" + i[t] + i[e] + i[s];
};
}(), b = (function() {
var t = [];
return function(e, i) {
return void 0 !== i && (e[3] = i), t[e[0]] || (t[e[0]] = {}), t[e[0]][e[1]] || (t[e[0]][e[1]] = {}), 
t[e[0]][e[1]][e[2]] || (t[e[0]][e[1]][e[2]] = {}), t[e[0]][e[1]][e[2]][e[3]] || (t[e[0]][e[1]][e[2]][e[3]] = "rgba(" + e.join(",") + ")"), 
t[e[0]][e[1]][e[2]][e[3]];
};
}(), function() {
function t() {
return this.props[0] = 1, this.props[1] = 0, this.props[2] = 0, this.props[3] = 0, 
this.props[4] = 0, this.props[5] = 1, this.props[6] = 0, this.props[7] = 0, this.props[8] = 0, 
this.props[9] = 0, this.props[10] = 1, this.props[11] = 0, this.props[12] = 0, this.props[13] = 0, 
this.props[14] = 0, this.props[15] = 1, this;
}
function e(t) {
if (0 === t) return this;
var e = Math.cos(t), i = Math.sin(t);
return this._t(e, -i, 0, 0, i, e, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
}
function s(t) {
if (0 === t) return this;
var e = Math.cos(t), i = Math.sin(t);
return this._t(1, 0, 0, 0, 0, e, -i, 0, 0, i, e, 0, 0, 0, 0, 1);
}
function r(t) {
if (0 === t) return this;
var e = Math.cos(t), i = Math.sin(t);
return this._t(e, 0, i, 0, 0, 1, 0, 0, -i, 0, e, 0, 0, 0, 0, 1);
}
function n(t) {
if (0 === t) return this;
var e = Math.cos(t), i = Math.sin(t);
return this._t(e, -i, 0, 0, i, e, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
}
function a(t, e) {
return this._t(1, e, t, 1, 0, 0);
}
function o(t, e) {
return this.shear(Math.tan(t), Math.tan(e));
}
function h(t, e) {
var i = Math.cos(e), s = Math.sin(e);
return this._t(i, s, 0, 0, -s, i, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)._t(1, 0, 0, 0, Math.tan(t), 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)._t(i, -s, 0, 0, s, i, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
}
function l(t, e, i) {
return i = isNaN(i) ? 1 : i, 1 == t && 1 == e && 1 == i ? this : this._t(t, 0, 0, 0, 0, e, 0, 0, 0, 0, i, 0, 0, 0, 0, 1);
}
function p(t, e, i, s, r, n, a, o, h, l, p, c, f, u, d, m) {
return this.props[0] = t, this.props[1] = e, this.props[2] = i, this.props[3] = s, 
this.props[4] = r, this.props[5] = n, this.props[6] = a, this.props[7] = o, this.props[8] = h, 
this.props[9] = l, this.props[10] = p, this.props[11] = c, this.props[12] = f, this.props[13] = u, 
this.props[14] = d, this.props[15] = m, this;
}
function c(t, e, i) {
return i = i || 0, 0 !== t || 0 !== e || 0 !== i ? this._t(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, t, e, i, 1) : this;
}
function f(t, e, i, s, r, n, a, o, h, l, p, c, f, u, d, m) {
if (1 === t && 0 === e && 0 === i && 0 === s && 0 === r && 1 === n && 0 === a && 0 === o && 0 === h && 0 === l && 1 === p && 0 === c) return (0 !== f || 0 !== u || 0 !== d) && (this.props[12] = this.props[12] * t + this.props[13] * r + this.props[14] * h + this.props[15] * f, 
this.props[13] = this.props[12] * e + this.props[13] * n + this.props[14] * l + this.props[15] * u, 
this.props[14] = this.props[12] * i + this.props[13] * a + this.props[14] * p + this.props[15] * d, 
this.props[15] = this.props[12] * s + this.props[13] * o + this.props[14] * c + this.props[15] * m), 
this._identityCalculated = !1, this;
var g = this.props[0], v = this.props[1], y = this.props[2], b = this.props[3], k = this.props[4], E = this.props[5], w = this.props[6], A = this.props[7], S = this.props[8], P = this.props[9], x = this.props[10], _ = this.props[11], M = this.props[12], C = this.props[13], F = this.props[14], T = this.props[15];
return this.props[0] = g * t + v * r + y * h + b * f, this.props[1] = g * e + v * n + y * l + b * u, 
this.props[2] = g * i + v * a + y * p + b * d, this.props[3] = g * s + v * o + y * c + b * m, 
this.props[4] = k * t + E * r + w * h + A * f, this.props[5] = k * e + E * n + w * l + A * u, 
this.props[6] = k * i + E * a + w * p + A * d, this.props[7] = k * s + E * o + w * c + A * m, 
this.props[8] = S * t + P * r + x * h + _ * f, this.props[9] = S * e + P * n + x * l + _ * u, 
this.props[10] = S * i + P * a + x * p + _ * d, this.props[11] = S * s + P * o + x * c + _ * m, 
this.props[12] = M * t + C * r + F * h + T * f, this.props[13] = M * e + C * n + F * l + T * u, 
this.props[14] = M * i + C * a + F * p + T * d, this.props[15] = M * s + C * o + F * c + T * m, 
this._identityCalculated = !1, this;
}
function u() {
return this._identityCalculated || (this._identity = !(1 !== this.props[0] || 0 !== this.props[1] || 0 !== this.props[2] || 0 !== this.props[3] || 0 !== this.props[4] || 1 !== this.props[5] || 0 !== this.props[6] || 0 !== this.props[7] || 0 !== this.props[8] || 0 !== this.props[9] || 1 !== this.props[10] || 0 !== this.props[11] || 0 !== this.props[12] || 0 !== this.props[13] || 0 !== this.props[14] || 1 !== this.props[15]), 
this._identityCalculated = !0), this._identity;
}
function d(t) {
var e;
for (e = 0; 16 > e; e += 1) t.props[e] = this.props[e];
}
function m(t) {
var e;
for (e = 0; 16 > e; e += 1) this.props[e] = t[e];
}
function g(t, e, i) {
return {
x: t * this.props[0] + e * this.props[4] + i * this.props[8] + this.props[12],
y: t * this.props[1] + e * this.props[5] + i * this.props[9] + this.props[13],
z: t * this.props[2] + e * this.props[6] + i * this.props[10] + this.props[14]
};
}
function v(t, e, i) {
return t * this.props[0] + e * this.props[4] + i * this.props[8] + this.props[12];
}
function y(t, e, i) {
return t * this.props[1] + e * this.props[5] + i * this.props[9] + this.props[13];
}
function b(t, e, i) {
return t * this.props[2] + e * this.props[6] + i * this.props[10] + this.props[14];
}
function k(t) {
var e = this.props[0] * this.props[5] - this.props[1] * this.props[4], i = this.props[5] / e, s = -this.props[1] / e, r = -this.props[4] / e, n = this.props[0] / e, a = (this.props[4] * this.props[13] - this.props[5] * this.props[12]) / e, o = -(this.props[0] * this.props[13] - this.props[1] * this.props[12]) / e;
return [ t[0] * i + t[1] * r + a, t[0] * s + t[1] * n + o, 0 ];
}
function E(t) {
var e, i = t.length, s = [];
for (e = 0; i > e; e += 1) s[e] = k(t[e]);
return s;
}
function w(t, e, i, s) {
if (s && 2 === s) {
var r = He.newPoint();
return r[0] = t * this.props[0] + e * this.props[4] + i * this.props[8] + this.props[12], 
r[1] = t * this.props[1] + e * this.props[5] + i * this.props[9] + this.props[13], 
r;
}
return [ t * this.props[0] + e * this.props[4] + i * this.props[8] + this.props[12], t * this.props[1] + e * this.props[5] + i * this.props[9] + this.props[13], t * this.props[2] + e * this.props[6] + i * this.props[10] + this.props[14] ];
}
function A(t, e) {
return this.isIdentity() ? t + "," + e : ke(t * this.props[0] + e * this.props[4] + this.props[12]) + "," + ke(t * this.props[1] + e * this.props[5] + this.props[13]);
}
function S() {
return [ this.props[0], this.props[1], this.props[2], this.props[3], this.props[4], this.props[5], this.props[6], this.props[7], this.props[8], this.props[9], this.props[10], this.props[11], this.props[12], this.props[13], this.props[14], this.props[15] ];
}
function P() {
return Se ? "matrix3d(" + i(this.props[0]) + "," + i(this.props[1]) + "," + i(this.props[2]) + "," + i(this.props[3]) + "," + i(this.props[4]) + "," + i(this.props[5]) + "," + i(this.props[6]) + "," + i(this.props[7]) + "," + i(this.props[8]) + "," + i(this.props[9]) + "," + i(this.props[10]) + "," + i(this.props[11]) + "," + i(this.props[12]) + "," + i(this.props[13]) + "," + i(this.props[14]) + "," + i(this.props[15]) + ")" : (this.cssParts[1] = this.props.join(","), 
this.cssParts.join(""));
}
function x() {
return "matrix(" + this.props[0] + "," + this.props[1] + "," + this.props[4] + "," + this.props[5] + "," + this.props[12] + "," + this.props[13] + ")";
}
function _() {
return "" + this.toArray();
}
return function() {
this.reset = t, this.rotate = e, this.rotateX = s, this.rotateY = r, this.rotateZ = n, 
this.skew = o, this.skewFromAxis = h, this.shear = a, this.scale = l, this.setTransform = p, 
this.translate = c, this.transform = f, this.applyToPoint = g, this.applyToX = v, 
this.applyToY = y, this.applyToZ = b, this.applyToPointArray = w, this.applyToPointStringified = A, 
this.toArray = S, this.toCSS = P, this.to2dCSS = x, this.toString = _, this.clone = d, 
this.cloneFromProps = m, this.inversePoints = E, this.inversePoint = k, this._t = this.transform, 
this.isIdentity = u, this._identity = !0, this._identityCalculated = !1, this.props = [ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 ], 
this.cssParts = [ "matrix3d(", "", ")" ];
};
}());
!function(t, e) {
function i(i, l, p) {
var u = [];
l = 1 == l ? {
entropy: !0
} : l || {};
var y = a(n(l.entropy ? [ i, h(t) ] : null == i ? o() : i, 3), u), b = new s(u), k = function() {
for (var t = b.g(f), e = m, i = 0; g > t; ) t = (t + i) * c, e *= c, i = b.g(1);
for (;t >= v; ) t /= 2, e /= 2, i >>>= 1;
return (t + i) / e;
};
return k.int32 = function() {
return 0 | b.g(4);
}, k.quick = function() {
return b.g(4) / 4294967296;
}, k["double"] = k, a(h(b.S), t), (l.pass || p || function(t, i, s, n) {
return n && (n.S && r(n, b), t.state = function() {
return r(b, {});
}), s ? (e[d] = t, i) : t;
})(k, y, "global" in l ? l.global : this == e, l.state);
}
function s(t) {
var e, i = t.length, s = this, r = 0, n = s.i = s.j = 0, a = s.S = [];
for (i || (t = [ i++ ]); c > r; ) a[r] = r++;
for (r = 0; c > r; r++) a[r] = a[n = y & n + t[r % i] + (e = a[r])], a[n] = e;
(s.g = function(t) {
for (var e, i = 0, r = s.i, n = s.j, a = s.S; t--; ) e = a[r = y & r + 1], i = i * c + a[y & (a[r] = a[n = y & n + e]) + (a[n] = e)];
return s.i = r, s.j = n, i;
})(c);
}
function r(t, e) {
return e.i = t.i, e.j = t.j, e.S = t.S.slice(), e;
}
function n(t, e) {
var i, s = [], r = typeof t;
if (e && "object" == r) for (i in t) try {
s.push(n(t[i], e - 1));
} catch (a) {}
return s.length ? s : "string" == r ? t : t + "\x00";
}
function a(t, e) {
for (var i, s = t + "", r = 0; r < s.length; ) e[y & r] = y & (i ^= 19 * e[y & r]) + s.charCodeAt(r++);
return h(e);
}
function o() {
try {
if (l) return h(l.randomBytes(c));
var e = new Uint8Array(c);
return (p.crypto || p.msCrypto).getRandomValues(e), h(e);
} catch (i) {
var s = p.navigator, r = s && s.plugins;
return [ +new Date(), p, r, p.screen, h(t) ];
}
}
function h(t) {
return String.fromCharCode.apply(0, t);
}
var l, p = this, c = 256, f = 6, u = 52, d = "random", m = e.pow(c, f), g = e.pow(2, u), v = 2 * g, y = c - 1;
e["seed" + d] = i, a(e.random(), t);
}([], Ce);
var Ne = function() {
function t(t, e, i, s, r) {
var n = r || ("bez_" + t + "_" + e + "_" + i + "_" + s).replace(/\./g, "p");
if (p[n]) return p[n];
var a = new h([ t, e, i, s ]);
return p[n] = a, a;
}
function e(t, e) {
return 1 - 3 * e + 3 * t;
}
function i(t, e) {
return 3 * e - 6 * t;
}
function s(t) {
return 3 * t;
}
function r(t, r, n) {
return ((e(r, n) * t + i(r, n)) * t + s(r)) * t;
}
function n(t, r, n) {
return 3 * e(r, n) * t * t + 2 * i(r, n) * t + s(r);
}
function a(t, e, i, s, n) {
var a, o, h = 0;
do o = e + (i - e) / 2, a = r(o, s, n) - t, a > 0 ? i = o : e = o; while (Math.abs(a) > u && ++h < d);
return o;
}
function o(t, e, i, s) {
for (var a = 0; c > a; ++a) {
var o = n(e, i, s);
if (0 === o) return e;
var h = r(e, i, s) - t;
e -= h / o;
}
return e;
}
function h(t) {
this._p = t, this._mSampleValues = v ? new Float32Array(m) : new Array(m), this._precomputed = !1, 
this.get = this.get.bind(this);
}
var l = {};
l.getBezierEasing = t;
var p = {}, c = 4, f = .001, u = 1e-7, d = 10, m = 11, g = 1 / (m - 1), v = "function" == typeof Float32Array;
return h.prototype = {
get: function(t) {
var e = this._p[0], i = this._p[1], s = this._p[2], n = this._p[3];
return this._precomputed || this._precompute(), e === i && s === n ? t : 0 === t ? 0 : 1 === t ? 1 : r(this._getTForX(t), i, n);
},
_precompute: function() {
var t = this._p[0], e = this._p[1], i = this._p[2], s = this._p[3];
this._precomputed = !0, (t !== e || i !== s) && this._calcSampleValues();
},
_calcSampleValues: function() {
for (var t = this._p[0], e = this._p[2], i = 0; m > i; ++i) this._mSampleValues[i] = r(i * g, t, e);
},
_getTForX: function(t) {
for (var e = this._p[0], i = this._p[2], s = this._mSampleValues, r = 0, h = 1, l = m - 1; h !== l && s[h] <= t; ++h) r += g;
--h;
var p = (t - s[h]) / (s[h + 1] - s[h]), c = r + p * g, u = n(c, e, i);
return u >= f ? o(t, c, e, i) : 0 === u ? c : a(t, r, r + g, e, i);
}
}, l;
}();
!function() {
for (var t = 0, e = [ "ms", "moz", "webkit", "o" ], i = 0; i < e.length && !window.requestAnimationFrame; ++i) window.requestAnimationFrame = window[e[i] + "RequestAnimationFrame"], 
window.cancelAnimationFrame = window[e[i] + "CancelAnimationFrame"] || window[e[i] + "CancelRequestAnimationFrame"];
window.requestAnimationFrame || (window.requestAnimationFrame = function(e) {
var i = new Date().getTime(), s = Math.max(0, 16 - (i - t)), r = window.setTimeout(function() {
e(i + s);
}, s);
return t = i + s, r;
}), window.cancelAnimationFrame || (window.cancelAnimationFrame = function(t) {
clearTimeout(t);
});
}();
var Le = w(), je = A(), Oe = function() {
function t(t, e) {
var i = document.createElement("span");
i.style.fontFamily = e;
var s = document.createElement("span");
s.innerHTML = "giItT1WQy@!-/#", i.style.position = "absolute", i.style.left = "-10000px", 
i.style.top = "-10000px", i.style.fontSize = "300px", i.style.fontVariant = "normal", 
i.style.fontStyle = "normal", i.style.fontWeight = "normal", i.style.letterSpacing = "0", 
i.appendChild(s), document.body.appendChild(i);
var r = s.offsetWidth;
return s.style.fontFamily = t + ", " + e, {
node: s,
w: r,
parent: i
};
}
function e() {
var t, i, s, r = this.fonts.length, n = r;
for (t = 0; r > t; t += 1) if (this.fonts[t].loaded) n -= 1; else if ("t" === this.fonts[t].fOrigin || 2 === this.fonts[t].origin) {
if (window.Typekit && window.Typekit.load && 0 === this.typekitLoaded) {
this.typekitLoaded = 1;
try {
window.Typekit.load({
async: !0,
active: function() {
this.typekitLoaded = 2;
}.bind(this)
});
} catch (a) {}
}
2 === this.typekitLoaded && (this.fonts[t].loaded = !0);
} else "n" === this.fonts[t].fOrigin || 0 === this.fonts[t].origin ? this.fonts[t].loaded = !0 : (i = this.fonts[t].monoCase.node, 
s = this.fonts[t].monoCase.w, i.offsetWidth !== s ? (n -= 1, this.fonts[t].loaded = !0) : (i = this.fonts[t].sansCase.node, 
s = this.fonts[t].sansCase.w, i.offsetWidth !== s && (n -= 1, this.fonts[t].loaded = !0)), 
this.fonts[t].loaded && (this.fonts[t].sansCase.parent.parentNode.removeChild(this.fonts[t].sansCase.parent), 
this.fonts[t].monoCase.parent.parentNode.removeChild(this.fonts[t].monoCase.parent)));
0 !== n && Date.now() - this.initTime < h ? setTimeout(e.bind(this), 20) : setTimeout(function() {
this.loaded = !0;
}.bind(this), 0);
}
function i(t, e) {
var i = document.createElementNS(Ee, "text");
i.style.fontSize = "100px", i.style.fontFamily = e.fFamily, i.textContent = "1", 
e.fClass ? (i.style.fontFamily = "inherit", i.className = e.fClass) : i.style.fontFamily = e.fFamily, 
t.appendChild(i);
var s = document.createElement("canvas").getContext("2d");
return s.font = "100px " + e.fFamily, s;
}
function s(s, r) {
if (!s) return void (this.loaded = !0);
if (this.chars) return this.loaded = !0, void (this.fonts = s.list);
var n, a = s.list, o = a.length;
for (n = 0; o > n; n += 1) {
if (a[n].loaded = !1, a[n].monoCase = t(a[n].fFamily, "monospace"), a[n].sansCase = t(a[n].fFamily, "sans-serif"), 
a[n].fPath) {
if ("p" === a[n].fOrigin || 3 === a[n].origin) {
var h = document.createElement("style");
h.type = "text/css", h.innerHTML = "@font-face {font-family: " + a[n].fFamily + "; font-style: normal; src: url('" + a[n].fPath + "');}", 
r.appendChild(h);
} else if ("g" === a[n].fOrigin || 1 === a[n].origin) {
var l = document.createElement("link");
l.type = "text/css", l.rel = "stylesheet", l.href = a[n].fPath, r.appendChild(l);
} else if ("t" === a[n].fOrigin || 2 === a[n].origin) {
var p = document.createElement("script");
p.setAttribute("src", a[n].fPath), r.appendChild(p);
}
} else a[n].loaded = !0;
a[n].helper = i(r, a[n]), this.fonts.push(a[n]);
}
e.bind(this)();
}
function r(t) {
if (t) {
this.chars || (this.chars = []);
var e, i, s, r = t.length, n = this.chars.length;
for (e = 0; r > e; e += 1) {
for (i = 0, s = !1; n > i; ) this.chars[i].style === t[e].style && this.chars[i].fFamily === t[e].fFamily && this.chars[i].ch === t[e].ch && (s = !0), 
i += 1;
s || (this.chars.push(t[e]), n += 1);
}
}
}
function n(t, e, i) {
for (var s = 0, r = this.chars.length; r > s; ) {
if (this.chars[s].ch === t && this.chars[s].style === e && this.chars[s].fFamily === i) return this.chars[s];
s += 1;
}
}
function a(t, e, i) {
var s = this.getFontByName(e), r = s.helper;
return r.measureText(t).width * i / 100;
}
function o(t) {
for (var e = 0, i = this.fonts.length; i > e; ) {
if (this.fonts[e].fName === t) return this.fonts[e];
e += 1;
}
return "sans-serif";
}
var h = 5e3, l = function() {
this.fonts = [], this.chars = null, this.typekitLoaded = 0, this.loaded = !1, this.initTime = Date.now();
};
return l.prototype.addChars = r, l.prototype.addFonts = s, l.prototype.getCharData = n, 
l.prototype.getFontByName = o, l.prototype.measureText = a, l;
}(), Re = function() {
function t() {
if (this.elem.globalData.frameId !== this.frameId) {
this.mdf = !1;
var t = this.comp.renderedFrame - this.offsetTime;
if (!(t === this.lastFrame || this.lastFrame !== l && (this.lastFrame >= this.keyframes[this.keyframes.length - 1].t - this.offsetTime && t >= this.keyframes[this.keyframes.length - 1].t - this.offsetTime || this.lastFrame < this.keyframes[0].t - this.offsetTime && t < this.keyframes[0].t - this.offsetTime))) {
for (var e, i, s = this.lastFrame < t ? this._lastIndex : 0, r = this.keyframes.length - 1, n = !0; n; ) {
if (e = this.keyframes[s], i = this.keyframes[s + 1], s == r - 1 && t >= i.t - this.offsetTime) {
e.h && (e = i);
break;
}
if (i.t - this.offsetTime > t) break;
r - 1 > s ? s += 1 : n = !1;
}
this._lastIndex = s;
var a, o, h, p, c, f;
if (e.to) {
e.bezierData || Le.buildBezierData(e);
var u = e.bezierData;
if (t >= i.t - this.offsetTime || t < e.t - this.offsetTime) {
var d = t >= i.t - this.offsetTime ? u.points.length - 1 : 0;
for (o = u.points[d].point.length, a = 0; o > a; a += 1) this.pv[a] = u.points[d].point[a], 
this.v[a] = this.mult ? this.pv[a] * this.mult : this.pv[a], this.lastPValue[a] !== this.pv[a] && (this.mdf = !0, 
this.lastPValue[a] = this.pv[a]);
this._lastBezierData = null;
} else {
e.__fnct ? f = e.__fnct : (f = Ne.getBezierEasing(e.o.x, e.o.y, e.i.x, e.i.y, e.n).get, 
e.__fnct = f), h = f((t - (e.t - this.offsetTime)) / (i.t - this.offsetTime - (e.t - this.offsetTime)));
var m, g = u.segmentLength * h, v = this.lastFrame < t && this._lastBezierData === u ? this._lastAddedLength : 0;
for (c = this.lastFrame < t && this._lastBezierData === u ? this._lastPoint : 0, 
n = !0, p = u.points.length; n; ) {
if (v += u.points[c].partialLength, 0 === g || 0 === h || c == u.points.length - 1) {
for (o = u.points[c].point.length, a = 0; o > a; a += 1) this.pv[a] = u.points[c].point[a], 
this.v[a] = this.mult ? this.pv[a] * this.mult : this.pv[a], this.lastPValue[a] !== this.pv[a] && (this.mdf = !0, 
this.lastPValue[a] = this.pv[a]);
break;
}
if (g >= v && g < v + u.points[c + 1].partialLength) {
for (m = (g - v) / u.points[c + 1].partialLength, o = u.points[c].point.length, 
a = 0; o > a; a += 1) this.pv[a] = u.points[c].point[a] + (u.points[c + 1].point[a] - u.points[c].point[a]) * m, 
this.v[a] = this.mult ? this.pv[a] * this.mult : this.pv[a], this.lastPValue[a] !== this.pv[a] && (this.mdf = !0, 
this.lastPValue[a] = this.pv[a]);
break;
}
p - 1 > c ? c += 1 : n = !1;
}
this._lastPoint = c, this._lastAddedLength = v - u.points[c].partialLength, this._lastBezierData = u;
}
} else {
var y, b, k, E, w;
for (r = e.s.length, s = 0; r > s; s += 1) {
if (1 !== e.h && (t >= i.t - this.offsetTime ? h = 1 : t < e.t - this.offsetTime ? h = 0 : (e.o.x instanceof Array ? (e.__fnct || (e.__fnct = []), 
e.__fnct[s] ? f = e.__fnct[s] : (y = e.o.x[s] || e.o.x[0], b = e.o.y[s] || e.o.y[0], 
k = e.i.x[s] || e.i.x[0], E = e.i.y[s] || e.i.y[0], f = Ne.getBezierEasing(y, b, k, E).get, 
e.__fnct[s] = f)) : e.__fnct ? f = e.__fnct : (y = e.o.x, b = e.o.y, k = e.i.x, 
E = e.i.y, f = Ne.getBezierEasing(y, b, k, E).get, e.__fnct = f), h = f((t - (e.t - this.offsetTime)) / (i.t - this.offsetTime - (e.t - this.offsetTime))))), 
this.sh && 1 !== e.h) {
var A = e.s[s], S = e.e[s];
-180 > A - S ? A += 360 : A - S > 180 && (A -= 360), w = A + (S - A) * h;
} else w = 1 === e.h ? e.s[s] : e.s[s] + (e.e[s] - e.s[s]) * h;
1 === r ? (this.v = this.mult ? w * this.mult : w, this.pv = w, this.lastPValue != this.pv && (this.mdf = !0, 
this.lastPValue = this.pv)) : (this.v[s] = this.mult ? w * this.mult : w, this.pv[s] = w, 
this.lastPValue[s] !== this.pv[s] && (this.mdf = !0, this.lastPValue[s] = this.pv[s]));
}
}
}
this.lastFrame = t, this.frameId = this.elem.globalData.frameId;
}
}
function e() {}
function i(t, i, s) {
this.mult = s, this.v = s ? i.k * s : i.k, this.pv = i.k, this.mdf = !1, this.comp = t.comp, 
this.k = !1, this.kf = !1, this.vel = 0, this.getValue = e;
}
function s(t, i, s) {
this.mult = s, this.data = i, this.mdf = !1, this.comp = t.comp, this.k = !1, this.kf = !1, 
this.frameId = -1, this.v = Array.apply(null, {
length: i.k.length
}), this.pv = Array.apply(null, {
length: i.k.length
}), this.lastValue = Array.apply(null, {
length: i.k.length
});
var r = Array.apply(null, {
length: i.k.length
});
this.vel = r.map(function() {
return 0;
});
var n, a = i.k.length;
for (n = 0; a > n; n += 1) this.v[n] = s ? i.k[n] * s : i.k[n], this.pv[n] = i.k[n];
this.getValue = e;
}
function r(e, i, s) {
this.keyframes = i.k, this.offsetTime = e.data.st, this.lastValue = -99999, this.lastPValue = -99999, 
this.frameId = -1, this._lastIndex = 0, this.k = !0, this.kf = !0, this.data = i, 
this.mult = s, this.elem = e, this.comp = e.comp, this.lastFrame = l, this.v = s ? i.k[0].s[0] * s : i.k[0].s[0], 
this.pv = i.k[0].s[0], this.getValue = t;
}
function n(e, i, s) {
var r, n, a, o, h, p = i.k.length;
for (r = 0; p - 1 > r; r += 1) i.k[r].to && i.k[r].s && i.k[r].e && (n = i.k[r].s, 
a = i.k[r].e, o = i.k[r].to, h = i.k[r].ti, (2 === n.length && (n[0] !== a[0] || n[1] !== a[1]) && Le.pointOnLine2D(n[0], n[1], a[0], a[1], n[0] + o[0], n[1] + o[1]) && Le.pointOnLine2D(n[0], n[1], a[0], a[1], a[0] + h[0], a[1] + h[1]) || 3 === n.length && (n[0] !== a[0] || n[1] !== a[1] || n[2] !== a[2]) && Le.pointOnLine3D(n[0], n[1], n[2], a[0], a[1], a[2], n[0] + o[0], n[1] + o[1], n[2] + o[2]) && Le.pointOnLine3D(n[0], n[1], n[2], a[0], a[1], a[2], a[0] + h[0], a[1] + h[1], a[2] + h[2])) && (i.k[r].to = null, 
i.k[r].ti = null));
this.keyframes = i.k, this.offsetTime = e.data.st, this.k = !0, this.kf = !0, this.mult = s, 
this.elem = e, this.comp = e.comp, this.getValue = t, this.frameId = -1, this._lastIndex = 0, 
this.v = Array.apply(null, {
length: i.k[0].s.length
}), this.pv = Array.apply(null, {
length: i.k[0].s.length
}), this.lastValue = Array.apply(null, {
length: i.k[0].s.length
}), this.lastPValue = Array.apply(null, {
length: i.k[0].s.length
}), this.lastFrame = l;
}
function a(t, e, a, o, h) {
var l;
if (2 === a) l = new p(t, e, h); else if (0 === e.a) l = 0 === a ? new i(t, e, o) : new s(t, e, o); else if (1 === e.a) l = 0 === a ? new r(t, e, o) : new n(t, e, o); else if (e.k.length) if ("number" == typeof e.k[0]) l = new s(t, e, o); else switch (a) {
case 0:
l = new r(t, e, o);
break;

case 1:
l = new n(t, e, o);
} else l = new i(t, e, o);
return l.k && h.push(l), l;
}
function o(t, e, i, s) {
return new f(t, e, i, s);
}
function h(t, e, i) {
return new u(t, e, i);
}
var l = -999999, p = function() {
function t() {
return this.p ? ExpressionValue(this.p) : [ this.px.v, this.py.v, this.pz ? this.pz.v : 0 ];
}
function e() {
return ExpressionValue(this.px);
}
function i() {
return ExpressionValue(this.py);
}
function s() {
return ExpressionValue(this.a);
}
function r() {
return ExpressionValue(this.or);
}
function n() {
return this.r ? ExpressionValue(this.r, 1 / Te) : ExpressionValue(this.rz, 1 / Te);
}
function a() {
return ExpressionValue(this.s, 100);
}
function o() {
return ExpressionValue(this.o, 100);
}
function h() {
return ExpressionValue(this.sk);
}
function l() {
return ExpressionValue(this.sa);
}
function p(t) {
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(), this.dynamicProperties[e].mdf && (this.mdf = !0);
this.a && t.translate(-this.a.v[0], -this.a.v[1], this.a.v[2]), this.s && t.scale(this.s.v[0], this.s.v[1], this.s.v[2]), 
this.r ? t.rotate(-this.r.v) : t.rotateZ(-this.rz.v).rotateY(this.ry.v).rotateX(this.rx.v).rotateZ(-this.or.v[2]).rotateY(this.or.v[1]).rotateX(this.or.v[0]), 
this.data.p.s ? this.data.p.z ? t.translate(this.px.v, this.py.v, -this.pz.v) : t.translate(this.px.v, this.py.v, 0) : t.translate(this.p.v[0], this.p.v[1], -this.p.v[2]);
}
function c() {
if (this.elem.globalData.frameId !== this.frameId) {
this.mdf = !1;
var t, e = this.dynamicProperties.length;
for (t = 0; e > t; t += 1) this.dynamicProperties[t].getValue(), this.dynamicProperties[t].mdf && (this.mdf = !0);
if (this.mdf) {
if (this.v.reset(), this.a && this.v.translate(-this.a.v[0], -this.a.v[1], this.a.v[2]), 
this.s && this.v.scale(this.s.v[0], this.s.v[1], this.s.v[2]), this.sk && this.v.skewFromAxis(-this.sk.v, this.sa.v), 
this.r ? this.v.rotate(-this.r.v) : this.v.rotateZ(-this.rz.v).rotateY(this.ry.v).rotateX(this.rx.v).rotateZ(-this.or.v[2]).rotateY(this.or.v[1]).rotateX(this.or.v[0]), 
this.autoOriented && this.p.keyframes && this.p.getValueAtTime) {
var i, s;
this.p.lastFrame + this.p.offsetTime <= this.p.keyframes[0].t ? (i = this.p.getValueAtTime((this.p.keyframes[0].t + .01) / this.elem.globalData.frameRate, 0), 
s = this.p.getValueAtTime(this.p.keyframes[0].t / this.elem.globalData.frameRate, 0)) : this.p.lastFrame + this.p.offsetTime >= this.p.keyframes[this.p.keyframes.length - 1].t ? (i = this.p.getValueAtTime(this.p.keyframes[this.p.keyframes.length - 1].t / this.elem.globalData.frameRate, 0), 
s = this.p.getValueAtTime((this.p.keyframes[this.p.keyframes.length - 1].t - .01) / this.elem.globalData.frameRate, 0)) : (i = this.p.pv, 
s = this.p.getValueAtTime((this.p.lastFrame + this.p.offsetTime - .01) / this.elem.globalData.frameRate, this.p.offsetTime)), 
this.v.rotate(-Math.atan2(i[1] - s[1], i[0] - s[0]));
}
this.data.p.s ? this.data.p.z ? this.v.translate(this.px.v, this.py.v, -this.pz.v) : this.v.translate(this.px.v, this.py.v, 0) : this.v.translate(this.p.v[0], this.p.v[1], -this.p.v[2]);
}
this.frameId = this.elem.globalData.frameId;
}
}
function f() {
this.inverted = !0, this.iv = new b(), this.k || (this.data.p.s ? this.iv.translate(this.px.v, this.py.v, -this.pz.v) : this.iv.translate(this.p.v[0], this.p.v[1], -this.p.v[2]), 
this.r ? this.iv.rotate(-this.r.v) : this.iv.rotateX(-this.rx.v).rotateY(-this.ry.v).rotateZ(this.rz.v), 
this.s && this.iv.scale(this.s.v[0], this.s.v[1], 1), this.a && this.iv.translate(-this.a.v[0], -this.a.v[1], this.a.v[2]));
}
function u() {}
return function(d, m, g) {
this.elem = d, this.frameId = -1, this.type = "transform", this.dynamicProperties = [], 
this.mdf = !1, this.data = m, this.getValue = c, this.applyToMatrix = p, this.setInverted = f, 
this.autoOrient = u, this.v = new b(), m.p.s ? (this.px = Re.getProp(d, m.p.x, 0, 0, this.dynamicProperties), 
this.py = Re.getProp(d, m.p.y, 0, 0, this.dynamicProperties), m.p.z && (this.pz = Re.getProp(d, m.p.z, 0, 0, this.dynamicProperties))) : this.p = Re.getProp(d, m.p, 1, 0, this.dynamicProperties), 
m.r ? this.r = Re.getProp(d, m.r, 0, Te, this.dynamicProperties) : m.rx && (this.rx = Re.getProp(d, m.rx, 0, Te, this.dynamicProperties), 
this.ry = Re.getProp(d, m.ry, 0, Te, this.dynamicProperties), this.rz = Re.getProp(d, m.rz, 0, Te, this.dynamicProperties), 
this.or = Re.getProp(d, m.or, 1, Te, this.dynamicProperties)), m.sk && (this.sk = Re.getProp(d, m.sk, 0, Te, this.dynamicProperties), 
this.sa = Re.getProp(d, m.sa, 0, Te, this.dynamicProperties)), m.a && (this.a = Re.getProp(d, m.a, 1, 0, this.dynamicProperties)), 
m.s && (this.s = Re.getProp(d, m.s, 1, .01, this.dynamicProperties)), this.o = m.o ? Re.getProp(d, m.o, 0, .01, g) : {
mdf: !1,
v: 1
}, this.dynamicProperties.length ? g.push(this) : (this.a && this.v.translate(-this.a.v[0], -this.a.v[1], this.a.v[2]), 
this.s && this.v.scale(this.s.v[0], this.s.v[1], this.s.v[2]), this.sk && this.v.skewFromAxis(-this.sk.v, this.sa.v), 
this.r ? this.v.rotate(-this.r.v) : this.v.rotateZ(-this.rz.v).rotateY(this.ry.v).rotateX(this.rx.v).rotateZ(-this.or.v[2]).rotateY(this.or.v[1]).rotateX(this.or.v[0]), 
this.data.p.s ? m.p.z ? this.v.translate(this.px.v, this.py.v, -this.pz.v) : this.v.translate(this.px.v, this.py.v, 0) : this.v.translate(this.p.v[0], this.p.v[1], -this.p.v[2])), 
Object.defineProperty(this, "position", {
get: t
}), Object.defineProperty(this, "xPosition", {
get: e
}), Object.defineProperty(this, "yPosition", {
get: i
}), Object.defineProperty(this, "orientation", {
get: r
}), Object.defineProperty(this, "anchorPoint", {
get: s
}), Object.defineProperty(this, "rotation", {
get: n
}), Object.defineProperty(this, "scale", {
get: a
}), Object.defineProperty(this, "opacity", {
get: o
}), Object.defineProperty(this, "skew", {
get: h
}), Object.defineProperty(this, "skewAxis", {
get: l
});
};
}(), c = function() {
function t(t) {
if (this.prop.getValue(), this.cmdf = !1, this.omdf = !1, this.prop.mdf || t) {
var e, i, s, r = 4 * this.data.p;
for (e = 0; r > e; e += 1) i = e % 4 === 0 ? 100 : 255, s = Math.round(this.prop.v[e] * i), 
this.c[e] !== s && (this.c[e] = s, this.cmdf = !0);
if (this.o.length) for (r = this.prop.v.length, e = 4 * this.data.p; r > e; e += 1) i = e % 2 === 0 ? 100 : 1, 
s = e % 2 === 0 ? Math.round(100 * this.prop.v[e]) : this.prop.v[e], this.o[e - 4 * this.data.p] !== s && (this.o[e - 4 * this.data.p] = s, 
this.omdf = !0);
}
}
function e(e, i, s) {
this.prop = a(e, i.k, 1, null, []), this.data = i, this.k = this.prop.k, this.c = Array.apply(null, {
length: 4 * i.p
});
var r = i.k.k[0].s ? i.k.k[0].s.length - 4 * i.p : i.k.k.length - 4 * i.p;
this.o = Array.apply(null, {
length: r
}), this.cmdf = !1, this.omdf = !1, this.getValue = t, this.prop.k && s.push(this), 
this.getValue(!0);
}
return function(t, i, s) {
return new e(t, i, s);
};
}(), f = function() {
function t(t) {
var e = 0, i = this.dataProps.length;
if (this.elem.globalData.frameId !== this.frameId || t) {
for (this.mdf = !1, this.frameId = this.elem.globalData.frameId; i > e; ) {
if (this.dataProps[e].p.mdf) {
this.mdf = !0;
break;
}
e += 1;
}
if (this.mdf || t) for ("svg" === this.renderer && (this.dasharray = ""), e = 0; i > e; e += 1) "o" != this.dataProps[e].n ? "svg" === this.renderer ? this.dasharray += " " + this.dataProps[e].p.v : this.dasharray[e] = this.dataProps[e].p.v : this.dashoffset = this.dataProps[e].p.v;
}
}
return function(e, i, s, r) {
this.elem = e, this.frameId = -1, this.dataProps = new Array(i.length), this.renderer = s, 
this.mdf = !1, this.k = !1, this.dasharray = "svg" === this.renderer ? "" : new Array(i.length - 1), 
this.dashoffset = 0;
var n, a, o = i.length;
for (n = 0; o > n; n += 1) a = Re.getProp(e, i[n].v, 0, 0, r), this.k = a.k ? !0 : this.k, 
this.dataProps[n] = {
n: i[n].n,
p: a
};
this.getValue = t, this.k ? r.push(this) : this.getValue(!0);
};
}(), u = function() {
function t(t) {
if (this.mdf = t || !1, this.dynamicProperties.length) {
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(), this.dynamicProperties[e].mdf && (this.mdf = !0);
}
var s = this.elem.currentTextDocumentData.l.length;
t && 2 === this.data.r && (this.e.v = s);
var r = 2 === this.data.r ? 1 : 100 / s, n = this.o.v / r, a = this.s.v / r + n, o = this.e.v / r + n;
if (a > o) {
var h = a;
a = o, o = h;
}
this.finalS = a, this.finalE = o;
}
function e(t) {
var e = Ne.getBezierEasing(this.ne.v / 100, 0, 1 - this.xe.v / 100, 1).get, n = 0, a = this.finalS, o = this.finalE, h = this.data.sh;
if (2 == h) n = o === a ? t >= o ? 1 : 0 : i(0, s(.5 / (o - a) + (t - a) / (o - a), 1)), 
n = e(n); else if (3 == h) n = o === a ? t >= o ? 0 : 1 : 1 - i(0, s(.5 / (o - a) + (t - a) / (o - a), 1)), 
n = e(n); else if (4 == h) o === a ? n = 0 : (n = i(0, s(.5 / (o - a) + (t - a) / (o - a), 1)), 
.5 > n ? n *= 2 : n = 1 - 2 * (n - .5)), n = e(n); else if (5 == h) {
if (o === a) n = 0; else {
var l = o - a;
t = s(i(0, t + .5 - a), o - a);
var p = -l / 2 + t, c = l / 2;
n = Math.sqrt(1 - p * p / (c * c));
}
n = e(n);
} else 6 == h ? (o === a ? n = 0 : (t = s(i(0, t + .5 - a), o - a), n = (1 + Math.cos(Math.PI + 2 * Math.PI * t / (o - a))) / 2), 
n = e(n)) : (t >= r(a) && (n = 0 > t - a ? 1 - (a - t) : i(0, s(o - t, 1))), n = e(n));
return n * this.a.v;
}
var i = Math.max, s = Math.min, r = Math.floor;
return function(i, s, r) {
this.mdf = !1, this.k = !1, this.data = s, this.dynamicProperties = [], this.getValue = t, 
this.getMult = e, this.elem = i, this.comp = i.comp, this.finalS = 0, this.finalE = 0, 
this.s = Re.getProp(i, s.s || {
k: 0
}, 0, 0, this.dynamicProperties), this.e = "e" in s ? Re.getProp(i, s.e, 0, 0, this.dynamicProperties) : {
v: 100
}, this.o = Re.getProp(i, s.o || {
k: 0
}, 0, 0, this.dynamicProperties), this.xe = Re.getProp(i, s.xe || {
k: 0
}, 0, 0, this.dynamicProperties), this.ne = Re.getProp(i, s.ne || {
k: 0
}, 0, 0, this.dynamicProperties), this.a = Re.getProp(i, s.a, 0, .01, this.dynamicProperties), 
this.dynamicProperties.length ? r.push(this) : this.getValue();
};
}(), d = {};
return d.getProp = a, d.getDashProp = o, d.getTextSelectorProp = h, d.getGradientProp = c, 
d;
}();
S.prototype.setPathData = function(t, e) {
for (this.c = t; e > this._maxLength; ) this.doubleArrayLength();
for (var i = 0; e > i; ) this.v[i] = He.newPoint(), this.o[i] = He.newPoint(), this.i[i] = He.newPoint(), 
i += 1;
this._length = e;
}, S.prototype.doubleArrayLength = function() {
this.v = this.v.concat(Array.apply(null, {
length: this._maxLength
})), this.i = this.i.concat(Array.apply(null, {
length: this._maxLength
})), this.o = this.o.concat(Array.apply(null, {
length: this._maxLength
})), this._maxLength *= 2;
}, S.prototype.setXYAt = function(t, e, i, s, r) {
var n;
switch (this._length = Math.max(this._length, s + 1), this._length >= this._maxLength && this.doubleArrayLength(), 
i) {
case "v":
n = this.v;
break;

case "i":
n = this.i;
break;

case "o":
n = this.o;
}
(!n[s] || n[s] && !r) && (n[s] = He.newPoint()), n[s][0] = t, n[s][1] = e;
}, S.prototype.setTripleAt = function(t, e, i, s, r, n, a, o) {
this.setXYAt(t, e, "v", a, o), this.setXYAt(i, s, "o", a, o), this.setXYAt(r, n, "i", a, o);
};
var Ve = function() {
function t() {
if (this.elem.globalData.frameId !== this.frameId) {
this.mdf = !1;
var t = this.comp.renderedFrame - this.offsetTime;
if (this.lastFrame === a || !(this.lastFrame < this.keyframes[0].t - this.offsetTime && t < this.keyframes[0].t - this.offsetTime || this.lastFrame > this.keyframes[this.keyframes.length - 1].t - this.offsetTime && t > this.keyframes[this.keyframes.length - 1].t - this.offsetTime)) {
var e, i, s;
if (t < this.keyframes[0].t - this.offsetTime) e = this.keyframes[0].s[0], s = !0, 
this._lastIndex = 0; else if (t >= this.keyframes[this.keyframes.length - 1].t - this.offsetTime) e = 1 === this.keyframes[this.keyframes.length - 2].h ? this.keyframes[this.keyframes.length - 1].s[0] : this.keyframes[this.keyframes.length - 2].e[0], 
s = !0; else {
for (var r, n, o, h, l, p, c = this.lastFrame < a ? this._lastIndex : 0, f = this.keyframes.length - 1, u = !0; u && (r = this.keyframes[c], 
n = this.keyframes[c + 1], !(n.t - this.offsetTime > t)); ) f - 1 > c ? c += 1 : u = !1;
s = 1 === r.h, this._lastIndex = c;
var d;
if (!s) {
if (t >= n.t - this.offsetTime) d = 1; else if (t < r.t - this.offsetTime) d = 0; else {
var m;
r.__fnct ? m = r.__fnct : (m = Ne.getBezierEasing(r.o.x, r.o.y, r.i.x, r.i.y).get, 
r.__fnct = m), d = m((t - (r.t - this.offsetTime)) / (n.t - this.offsetTime - (r.t - this.offsetTime)));
}
i = r.e[0];
}
e = r.s[0];
}
h = this.v._length, p = e.i[0].length;
var g, v = !1;
for (o = 0; h > o; o += 1) for (l = 0; p > l; l += 1) s ? (g = e.i[o][l], this.v.i[o][l] !== g && (this.v.i[o][l] = g, 
this.pv.i[o][l] = g, v = !0), g = e.o[o][l], this.v.o[o][l] !== g && (this.v.o[o][l] = g, 
this.pv.o[o][l] = g, v = !0), g = e.v[o][l], this.v.v[o][l] !== g && (this.v.v[o][l] = g, 
this.pv.v[o][l] = g, v = !0)) : (g = e.i[o][l] + (i.i[o][l] - e.i[o][l]) * d, this.v.i[o][l] !== g && (this.v.i[o][l] = g, 
this.pv.i[o][l] = g, v = !0), g = e.o[o][l] + (i.o[o][l] - e.o[o][l]) * d, this.v.o[o][l] !== g && (this.v.o[o][l] = g, 
this.pv.o[o][l] = g, v = !0), g = e.v[o][l] + (i.v[o][l] - e.v[o][l]) * d, this.v.v[o][l] !== g && (this.v.v[o][l] = g, 
this.pv.v[o][l] = g, v = !0));
this.mdf = v, this.v.c = e.c, this.paths = this.localShapeCollection;
}
this.lastFrame = t, this.frameId = this.elem.globalData.frameId;
}
}
function e() {
return this.v;
}
function i() {
this.paths = this.localShapeCollection, this.k || (this.mdf = !1);
}
function s(t, s, r) {
this.comp = t.comp, this.k = !1, this.mdf = !1, this.v = We.newShape();
var n = 3 === r ? s.pt.k : s.ks.k;
this.v.v = n.v, this.v.i = n.i, this.v.o = n.o, this.v.c = n.c, this.v._length = this.v.v.length, 
this.getValue = e, this.pv = We.clone(this.v), this.localShapeCollection = Xe.newShapeCollection(), 
this.paths = this.localShapeCollection, this.paths.addShape(this.v), this.reset = i;
}
function r(e, s, r) {
this.comp = e.comp, this.elem = e, this.offsetTime = e.data.st, this._lastIndex = 0, 
this.getValue = t, this.keyframes = 3 === r ? s.pt.k : s.ks.k, this.k = !0, this.kf = !0;
var n = this.keyframes[0].s[0].i.length;
this.keyframes[0].s[0].i[0].length, this.v = We.newShape(), this.v.setPathData(this.keyframes[0].s[0].c, n), 
this.pv = We.clone(this.v), this.localShapeCollection = Xe.newShapeCollection(), 
this.paths = this.localShapeCollection, this.paths.addShape(this.v), this.lastFrame = a, 
this.reset = i;
}
function n(t, e, i, n) {
var a;
if (3 === i || 4 === i) {
var p = 3 === i ? e.pt : e.ks, c = p.k;
a = 1 === p.a || c.length ? new r(t, e, i) : new s(t, e, i);
} else 5 === i ? a = new l(t, e) : 6 === i ? a = new o(t, e) : 7 === i && (a = new h(t, e));
return a.k && n.push(a), a;
}
var a = -999999, o = function() {
function t() {
var t = this.p.v[0], e = this.p.v[1], i = this.s.v[0] / 2, r = this.s.v[1] / 2;
3 !== this.d ? (this.v.v[0][0] = t, this.v.v[0][1] = e - r, this.v.v[1][0] = t + i, 
this.v.v[1][1] = e, this.v.v[2][0] = t, this.v.v[2][1] = e + r, this.v.v[3][0] = t - i, 
this.v.v[3][1] = e, this.v.i[0][0] = t - i * s, this.v.i[0][1] = e - r, this.v.i[1][0] = t + i, 
this.v.i[1][1] = e - r * s, this.v.i[2][0] = t + i * s, this.v.i[2][1] = e + r, 
this.v.i[3][0] = t - i, this.v.i[3][1] = e + r * s, this.v.o[0][0] = t + i * s, 
this.v.o[0][1] = e - r, this.v.o[1][0] = t + i, this.v.o[1][1] = e + r * s, this.v.o[2][0] = t - i * s, 
this.v.o[2][1] = e + r, this.v.o[3][0] = t - i, this.v.o[3][1] = e - r * s) : (this.v.v[0][0] = t, 
this.v.v[0][1] = e - r, this.v.v[1][0] = t - i, this.v.v[1][1] = e, this.v.v[2][0] = t, 
this.v.v[2][1] = e + r, this.v.v[3][0] = t + i, this.v.v[3][1] = e, this.v.i[0][0] = t + i * s, 
this.v.i[0][1] = e - r, this.v.i[1][0] = t - i, this.v.i[1][1] = e - r * s, this.v.i[2][0] = t - i * s, 
this.v.i[2][1] = e + r, this.v.i[3][0] = t + i, this.v.i[3][1] = e + r * s, this.v.o[0][0] = t - i * s, 
this.v.o[0][1] = e - r, this.v.o[1][0] = t - i, this.v.o[1][1] = e + r * s, this.v.o[2][0] = t + i * s, 
this.v.o[2][1] = e + r, this.v.o[3][0] = t + i, this.v.o[3][1] = e - r * s);
}
function e(t) {
var e, i = this.dynamicProperties.length;
if (this.elem.globalData.frameId !== this.frameId) {
for (this.mdf = !1, this.frameId = this.elem.globalData.frameId, e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(t), 
this.dynamicProperties[e].mdf && (this.mdf = !0);
this.mdf && this.convertEllToPath();
}
}
var s = De;
return function(s, r) {
this.v = We.newShape(), this.v.setPathData(!0, 4), this.localShapeCollection = Xe.newShapeCollection(), 
this.paths = this.localShapeCollection, this.localShapeCollection.addShape(this.v), 
this.d = r.d, this.dynamicProperties = [], this.elem = s, this.comp = s.comp, this.frameId = -1, 
this.mdf = !1, this.getValue = e, this.convertEllToPath = t, this.reset = i, this.p = Re.getProp(s, r.p, 1, 0, this.dynamicProperties), 
this.s = Re.getProp(s, r.s, 1, 0, this.dynamicProperties), this.dynamicProperties.length ? this.k = !0 : this.convertEllToPath();
};
}(), h = function() {
function t() {
var t, e = Math.floor(this.pt.v), i = 2 * Math.PI / e, s = this.or.v, r = this.os.v, n = 2 * Math.PI * s / (4 * e), a = -Math.PI / 2, o = 3 === this.data.d ? -1 : 1;
for (a += this.r.v, this.v._length = 0, t = 0; e > t; t += 1) {
var h = s * Math.cos(a), l = s * Math.sin(a), p = 0 === h && 0 === l ? 0 : l / Math.sqrt(h * h + l * l), c = 0 === h && 0 === l ? 0 : -h / Math.sqrt(h * h + l * l);
h += +this.p.v[0], l += +this.p.v[1], this.v.setTripleAt(h, l, h - p * n * r * o, l - c * n * r * o, h + p * n * r * o, l + c * n * r * o, t, !0), 
a += i * o;
}
this.paths.length = 0, this.paths[0] = this.v;
}
function e() {
var t, e, i, s, r = 2 * Math.floor(this.pt.v), n = 2 * Math.PI / r, a = !0, o = this.or.v, h = this.ir.v, l = this.os.v, p = this.is.v, c = 2 * Math.PI * o / (2 * r), f = 2 * Math.PI * h / (2 * r), u = -Math.PI / 2;
u += this.r.v;
var d = 3 === this.data.d ? -1 : 1;
for (this.v._length = 0, t = 0; r > t; t += 1) {
e = a ? o : h, i = a ? l : p, s = a ? c : f;
var m = e * Math.cos(u), g = e * Math.sin(u), v = 0 === m && 0 === g ? 0 : g / Math.sqrt(m * m + g * g), y = 0 === m && 0 === g ? 0 : -m / Math.sqrt(m * m + g * g);
m += +this.p.v[0], g += +this.p.v[1], this.v.setTripleAt(m, g, m - v * s * i * d, g - y * s * i * d, m + v * s * i * d, g + y * s * i * d, t, !0), 
a = !a, u += n * d;
}
}
function s() {
if (this.elem.globalData.frameId !== this.frameId) {
this.mdf = !1, this.frameId = this.elem.globalData.frameId;
var t, e = this.dynamicProperties.length;
for (t = 0; e > t; t += 1) this.dynamicProperties[t].getValue(), this.dynamicProperties[t].mdf && (this.mdf = !0);
this.mdf && this.convertToPath();
}
}
return function(r, n) {
this.v = We.newShape(), this.v.setPathData(!0, 0), this.elem = r, this.comp = r.comp, 
this.data = n, this.frameId = -1, this.d = n.d, this.dynamicProperties = [], this.mdf = !1, 
this.getValue = s, this.reset = i, 1 === n.sy ? (this.ir = Re.getProp(r, n.ir, 0, 0, this.dynamicProperties), 
this.is = Re.getProp(r, n.is, 0, .01, this.dynamicProperties), this.convertToPath = e) : this.convertToPath = t, 
this.pt = Re.getProp(r, n.pt, 0, 0, this.dynamicProperties), this.p = Re.getProp(r, n.p, 1, 0, this.dynamicProperties), 
this.r = Re.getProp(r, n.r, 0, Te, this.dynamicProperties), this.or = Re.getProp(r, n.or, 0, 0, this.dynamicProperties), 
this.os = Re.getProp(r, n.os, 0, .01, this.dynamicProperties), this.localShapeCollection = Xe.newShapeCollection(), 
this.localShapeCollection.addShape(this.v), this.paths = this.localShapeCollection, 
this.dynamicProperties.length ? this.k = !0 : this.convertToPath();
};
}(), l = function() {
function t(t) {
if (this.elem.globalData.frameId !== this.frameId) {
this.mdf = !1, this.frameId = this.elem.globalData.frameId;
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(t), this.dynamicProperties[e].mdf && (this.mdf = !0);
this.mdf && this.convertRectToPath();
}
}
function e() {
var t = this.p.v[0], e = this.p.v[1], i = this.s.v[0] / 2, s = this.s.v[1] / 2, r = Me(i, s, this.r.v), n = r * (1 - De);
this.v._length = 0, 2 === this.d || 1 === this.d ? (this.v.setTripleAt(t + i, e - s + r, t + i, e - s + r, t + i, e - s + n, 0, !0), 
this.v.setTripleAt(t + i, e + s - r, t + i, e + s - n, t + i, e + s - r, 1, !0), 
0 !== r ? (this.v.setTripleAt(t + i - r, e + s, t + i - r, e + s, t + i - n, e + s, 2, !0), 
this.v.setTripleAt(t - i + r, e + s, t - i + n, e + s, t - i + r, e + s, 3, !0), 
this.v.setTripleAt(t - i, e + s - r, t - i, e + s - r, t - i, e + s - n, 4, !0), 
this.v.setTripleAt(t - i, e - s + r, t - i, e - s + n, t - i, e - s + r, 5, !0), 
this.v.setTripleAt(t - i + r, e - s, t - i + r, e - s, t - i + n, e - s, 6, !0), 
this.v.setTripleAt(t + i - r, e - s, t + i - n, e - s, t + i - r, e - s, 7, !0)) : (this.v.setTripleAt(t - i, e + s, t - i + n, e + s, t - i, e + s, 2), 
this.v.setTripleAt(t - i, e - s, t - i, e - s + n, t - i, e - s, 3))) : (this.v.setTripleAt(t + i, e - s + r, t + i, e - s + n, t + i, e - s + r, 0, !0), 
0 !== r ? (this.v.setTripleAt(t + i - r, e - s, t + i - r, e - s, t + i - n, e - s, 1, !0), 
this.v.setTripleAt(t - i + r, e - s, t - i + n, e - s, t - i + r, e - s, 2, !0), 
this.v.setTripleAt(t - i, e - s + r, t - i, e - s + r, t - i, e - s + n, 3, !0), 
this.v.setTripleAt(t - i, e + s - r, t - i, e + s - n, t - i, e + s - r, 4, !0), 
this.v.setTripleAt(t - i + r, e + s, t - i + r, e + s, t - i + n, e + s, 5, !0), 
this.v.setTripleAt(t + i - r, e + s, t + i - n, e + s, t + i - r, e + s, 6, !0), 
this.v.setTripleAt(t + i, e + s - r, t + i, e + s - r, t + i, e + s - n, 7, !0)) : (this.v.setTripleAt(t - i, e - s, t - i + n, e - s, t - i, e - s, 1, !0), 
this.v.setTripleAt(t - i, e + s, t - i, e + s - n, t - i, e + s, 2, !0), this.v.setTripleAt(t + i, e + s, t + i - n, e + s, t + i, e + s, 3, !0)));
}
return function(s, r) {
this.v = We.newShape(), this.v.c = !0, this.localShapeCollection = Xe.newShapeCollection(), 
this.localShapeCollection.addShape(this.v), this.paths = this.localShapeCollection, 
this.elem = s, this.comp = s.comp, this.frameId = -1, this.d = r.d, this.dynamicProperties = [], 
this.mdf = !1, this.getValue = t, this.convertRectToPath = e, this.reset = i, this.p = Re.getProp(s, r.p, 1, 0, this.dynamicProperties), 
this.s = Re.getProp(s, r.s, 1, 0, this.dynamicProperties), this.r = Re.getProp(s, r.r, 0, 0, this.dynamicProperties), 
this.dynamicProperties.length ? this.k = !0 : this.convertRectToPath();
};
}(), p = {};
return p.getShapeProp = n, p;
}(), ze = function() {
function t(t, e) {
s[t] || (s[t] = e);
}
function e(t, e, i, r) {
return new s[t](e, i, r);
}
var i = {}, s = {};
return i.registerModifier = t, i.getModifier = e, i;
}();
P.prototype.initModifierProperties = function() {}, P.prototype.addShapeToModifier = function() {}, 
P.prototype.addShape = function(t) {
this.closed || (this.shapes.push({
shape: t.sh,
data: t,
localShapeCollection: Xe.newShapeCollection()
}), this.addShapeToModifier(t.sh));
}, P.prototype.init = function(t, e, i) {
this.elem = t, this.frameId = -1, this.shapes = [], this.dynamicProperties = [], 
this.mdf = !1, this.closed = !1, this.k = !1, this.comp = t.comp, this.initModifierProperties(t, e), 
this.dynamicProperties.length ? (this.k = !0, i.push(this)) : this.getValue(!0);
}, E(P, x), x.prototype.processKeys = function(t) {
if (this.elem.globalData.frameId !== this.frameId || t) {
this.mdf = t ? !0 : !1, this.frameId = this.elem.globalData.frameId;
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(), this.dynamicProperties[e].mdf && (this.mdf = !0);
if (this.mdf || t) {
var s = this.o.v % 360 / 360;
0 > s && (s += 1);
var r = this.s.v + s, n = this.e.v + s;
if (r > n) {
var a = r;
r = n, n = a;
}
this.sValue = r, this.eValue = n, this.oValue = s;
}
}
}, x.prototype.initModifierProperties = function(t, e) {
this.sValue = 0, this.eValue = 0, this.oValue = 0, this.getValue = this.processKeys, 
this.s = Re.getProp(t, e.s, 0, .01, this.dynamicProperties), this.e = Re.getProp(t, e.e, 0, .01, this.dynamicProperties), 
this.o = Re.getProp(t, e.o, 0, 0, this.dynamicProperties), this.m = e.m, this.dynamicProperties.length || this.getValue(!0);
}, x.prototype.getSegmentsLength = function(t) {
var e, i = t.c, s = t.v, r = t.o, n = t.i, a = t._length, o = [], h = 0;
for (e = 0; a - 1 > e; e += 1) o[e] = Le.getBezierLength(s[e], s[e + 1], r[e], n[e + 1]), 
h += o[e].addedLength;
return i && (o[e] = Le.getBezierLength(s[e], s[0], r[e], n[0]), h += o[e].addedLength), 
{
lengths: o,
totalLength: h
};
}, x.prototype.calculateShapeEdges = function(t, e, i, s, r) {
var n = [];
1 >= e ? n.push({
s: t,
e: e
}) : t >= 1 ? n.push({
s: t - 1,
e: e - 1
}) : (n.push({
s: t,
e: 1
}), n.push({
s: 0,
e: e - 1
}));
var a, o, h = [], l = n.length;
for (a = 0; l > a; a += 1) if (o = n[a], o.e * r < s || o.s * r > s + i) ; else {
var p, c;
p = o.s * r <= s ? 0 : (o.s * r - s) / i, c = o.e * r >= s + i ? 1 : (o.e * r - s) / i, 
h.push([ p, c ]);
}
return h.length || h.push([ 0, 0 ]), h;
}, x.prototype.processShapes = function(t) {
var e, i, s, r, n, a, o, h = this.shapes.length, l = this.sValue, p = this.eValue, c = 0;
if (p === l) for (i = 0; h > i; i += 1) this.shapes[i].localShapeCollection.releaseShapes(), 
this.shapes[i].shape.mdf = !0, this.shapes[i].shape.paths = this.shapes[i].localShapeCollection; else if (1 === p && 0 === l || 0 === p && 1 === l) {
if (this.mdf) for (i = 0; h > i; i += 1) this.shapes[i].shape.mdf = !0;
} else {
var f, u, d = [];
for (i = 0; h > i; i += 1) if (f = this.shapes[i], f.shape.mdf || this.mdf || t || 2 === this.m) {
if (e = f.shape.paths, r = e._length, o = 0, !f.shape.mdf && f.pathsData) o = f.totalShapeLength; else {
for (n = [], s = 0; r > s; s += 1) a = this.getSegmentsLength(e.shapes[s]), n.push(a), 
o += a.totalLength;
f.totalShapeLength = o, f.pathsData = n;
}
c += o, f.shape.mdf = !0;
} else f.shape.paths = f.localShapeCollection;
var s, r, m = l, g = p, v = 0;
for (i = h - 1; i >= 0; i -= 1) if (f = this.shapes[i], f.shape.mdf) {
if (u = f.localShapeCollection, u.releaseShapes(), 2 === this.m && h > 1) {
var y = this.calculateShapeEdges(l, p, f.totalShapeLength, v, c);
v += f.totalShapeLength;
} else y = [ [ m, g ] ];
for (r = y.length, s = 0; r > s; s += 1) {
m = y[s][0], g = y[s][1], d.length = 0, 1 >= g ? d.push({
s: f.totalShapeLength * m,
e: f.totalShapeLength * g
}) : m >= 1 ? d.push({
s: f.totalShapeLength * (m - 1),
e: f.totalShapeLength * (g - 1)
}) : (d.push({
s: f.totalShapeLength * m,
e: f.totalShapeLength
}), d.push({
s: 0,
e: f.totalShapeLength * (g - 1)
}));
var b = this.addShapes(f, d[0]);
if (d[0].s !== d[0].e) {
if (d.length > 1) if (f.shape.v.c) {
var k = b.pop();
this.addPaths(b, u), b = this.addShapes(f, d[1], k);
} else this.addPaths(b, u), b = this.addShapes(f, d[1]);
this.addPaths(b, u);
}
}
f.shape.paths = u;
}
}
this.dynamicProperties.length || (this.mdf = !1);
}, x.prototype.addPaths = function(t, e) {
var i, s = t.length;
for (i = 0; s > i; i += 1) e.addShape(t[i]);
}, x.prototype.addSegment = function(t, e, i, s, r, n, a) {
r.setXYAt(e[0], e[1], "o", n), r.setXYAt(i[0], i[1], "i", n + 1), a && r.setXYAt(t[0], t[1], "v", n), 
r.setXYAt(s[0], s[1], "v", n + 1);
}, x.prototype.addShapes = function(t, e, i) {
var s, r, n, a, o, h, l, p, c = t.pathsData, f = t.shape.paths.shapes, u = t.shape.paths._length, d = 0, m = [], g = !0;
for (i ? (o = i._length, p = i._length) : (i = We.newShape(), o = 0, p = 0), m.push(i), 
s = 0; u > s; s += 1) {
for (h = c[s].lengths, i.c = f[s].c, n = f[s].c ? h.length : h.length + 1, r = 1; n > r; r += 1) if (a = h[r - 1], 
d + a.addedLength < e.s) d += a.addedLength, i.c = !1; else {
if (d > e.e) {
i.c = !1;
break;
}
e.s <= d && e.e >= d + a.addedLength ? (this.addSegment(f[s].v[r - 1], f[s].o[r - 1], f[s].i[r], f[s].v[r], i, o, g), 
g = !1) : (l = Le.getNewSegment(f[s].v[r - 1], f[s].v[r], f[s].o[r - 1], f[s].i[r], (e.s - d) / a.addedLength, (e.e - d) / a.addedLength, h[r - 1]), 
this.addSegment(l.pt1, l.pt3, l.pt4, l.pt2, i, o, g), g = !1, i.c = !1), d += a.addedLength, 
o += 1;
}
if (f[s].c) {
if (a = h[r - 1], d <= e.e) {
var v = h[r - 1].addedLength;
e.s <= d && e.e >= d + v ? (this.addSegment(f[s].v[r - 1], f[s].o[r - 1], f[s].i[0], f[s].v[0], i, o, g), 
g = !1) : (l = Le.getNewSegment(f[s].v[r - 1], f[s].v[0], f[s].o[r - 1], f[s].i[0], (e.s - d) / v, (e.e - d) / v, h[r - 1]), 
this.addSegment(l.pt1, l.pt3, l.pt4, l.pt2, i, o, g), g = !1, i.c = !1);
} else i.c = !1;
d += a.addedLength, o += 1;
}
if (i._length && (i.setXYAt(i.v[p][0], i.v[p][1], "i", p), i.setXYAt(i.v[i._length - 1][0], i.v[i._length - 1][1], "o", i._length - 1)), 
d > e.e) break;
u - 1 > s && (i = We.newShape(), g = !0, m.push(i), o = 0);
}
return m;
}, ze.registerModifier("tm", x), E(P, _), _.prototype.processKeys = function(t) {
if (this.elem.globalData.frameId !== this.frameId || t) {
this.mdf = t ? !0 : !1, this.frameId = this.elem.globalData.frameId;
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(), this.dynamicProperties[e].mdf && (this.mdf = !0);
}
}, _.prototype.initModifierProperties = function(t, e) {
this.getValue = this.processKeys, this.rd = Re.getProp(t, e.r, 0, null, this.dynamicProperties), 
this.dynamicProperties.length || this.getValue(!0);
}, _.prototype.processPath = function(t, e) {
var i = We.newShape();
i.c = t.c;
var s, r, n, a, o, h, l, p, c, f, u, d, m, g = t._length, v = 0;
for (s = 0; g > s; s += 1) r = t.v[s], a = t.o[s], n = t.i[s], r[0] === a[0] && r[1] === a[1] && r[0] === n[0] && r[1] === n[1] ? 0 !== s && s !== g - 1 || t.c ? (o = 0 === s ? t.v[g - 1] : t.v[s - 1], 
h = Math.sqrt(Math.pow(r[0] - o[0], 2) + Math.pow(r[1] - o[1], 2)), l = h ? Math.min(h / 2, e) / h : 0, 
p = d = r[0] + (o[0] - r[0]) * l, c = m = r[1] - (r[1] - o[1]) * l, f = p - (p - r[0]) * De, 
u = c - (c - r[1]) * De, i.setTripleAt(p, c, f, u, d, m, v), v += 1, o = s === g - 1 ? t.v[0] : t.v[s + 1], 
h = Math.sqrt(Math.pow(r[0] - o[0], 2) + Math.pow(r[1] - o[1], 2)), l = h ? Math.min(h / 2, e) / h : 0, 
p = f = r[0] + (o[0] - r[0]) * l, c = u = r[1] + (o[1] - r[1]) * l, d = p - (p - r[0]) * De, 
m = c - (c - r[1]) * De, i.setTripleAt(p, c, f, u, d, m, v), v += 1) : (i.setTripleAt(r[0], r[1], a[0], a[1], n[0], n[1], v), 
v += 1) : (i.setTripleAt(t.v[s][0], t.v[s][1], t.o[s][0], t.o[s][1], t.i[s][0], t.i[s][1], v), 
v += 1);
return i;
}, _.prototype.processShapes = function(t) {
var e, i, s, r, n = this.shapes.length, a = this.rd.v;
if (0 !== a) {
var o, h, l;
for (i = 0; n > i; i += 1) {
if (o = this.shapes[i], h = o.shape.paths, l = o.localShapeCollection, o.shape.mdf || this.mdf || t) for (l.releaseShapes(), 
o.shape.mdf = !0, e = o.shape.paths.shapes, r = o.shape.paths._length, s = 0; r > s; s += 1) l.addShape(this.processPath(e[s], a));
o.shape.paths = o.localShapeCollection;
}
}
this.dynamicProperties.length || (this.mdf = !1);
}, ze.registerModifier("rd", _), M.prototype.processKeys = function(t) {
if (this.elem.globalData.frameId !== this.frameId || t) {
this.mdf = t ? !0 : !1;
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) this.dynamicProperties[e].getValue(), this.dynamicProperties[e].mdf && (this.mdf = !0);
}
}, M.prototype.initModifierProperties = function(t, e) {
this.getValue = this.processKeys, this.c = Re.getProp(t, e.c, 0, null, this.dynamicProperties), 
this.o = Re.getProp(t, e.o, 0, null, this.dynamicProperties), this.tr = Re.getProp(t, e.tr, 2, null, this.dynamicProperties), 
this.data = e, this.dynamicProperties.length || this.getValue(!0), this.pMatrix = new b(), 
this.rMatrix = new b(), this.sMatrix = new b(), this.tMatrix = new b(), this.matrix = new b();
}, M.prototype.applyTransforms = function(t, e, i, s, r, n) {
var a = n ? -1 : 1, o = s.s.v[0] + (1 - s.s.v[0]) * (1 - r), h = s.s.v[1] + (1 - s.s.v[1]) * (1 - r);
t.translate(s.p.v[0] * a * r, s.p.v[1] * a * r, s.p.v[2]), e.translate(-s.a.v[0], -s.a.v[1], s.a.v[2]), 
e.rotate(-s.r.v * a * r), e.translate(s.a.v[0], s.a.v[1], s.a.v[2]), i.translate(-s.a.v[0], -s.a.v[1], s.a.v[2]), 
i.scale(n ? 1 / o : o, n ? 1 / h : h), i.translate(s.a.v[0], s.a.v[1], s.a.v[2]);
}, M.prototype.init = function(t, e, i, s, r) {
this.elem = t, this.arr = e, this.pos = i, this.elemsData = s, this._currentCopies = 0, 
this._elements = [], this._groups = [], this.dynamicProperties = [], this.frameId = -1, 
this.initModifierProperties(t, e[i]);
for (var n = 0; i > 0; ) i -= 1, this._elements.unshift(e[i]), n += 1;
this.dynamicProperties.length ? (this.k = !0, r.push(this)) : this.getValue(!0);
}, M.prototype.resetElements = function(t) {
var e, i = t.length;
for (e = 0; i > e; e += 1) t[e]._processed = !1, "gr" === t[e].ty && this.resetElements(t[e].it);
}, M.prototype.cloneElements = function(t) {
var e = (t.length, JSON.parse(JSON.stringify(t)));
return this.resetElements(e), e;
}, M.prototype.changeGroupRender = function(t, e) {
var i, s = t.length;
for (i = 0; s > i; i += 1) t[i]._render = e, "gr" === t[i].ty && this.changeGroupRender(t[i].it, e);
}, M.prototype.processShapes = function(t) {
if (this.elem.globalData.frameId !== this.frameId && (this.frameId = this.elem.globalData.frameId, 
this.dynamicProperties.length || t || (this.mdf = !1), this.mdf)) {
var e = Math.ceil(this.c.v);
if (this._groups.length < e) {
for (;this._groups.length < e; ) {
var i = {
it: this.cloneElements(this._elements),
ty: "gr"
};
i.it.push({
a: {
a: 0,
ix: 1,
k: [ 0, 0 ]
},
nm: "Transform",
o: {
a: 0,
ix: 7,
k: 100
},
p: {
a: 0,
ix: 2,
k: [ 0, 0 ]
},
r: {
a: 0,
ix: 6,
k: 0
},
s: {
a: 0,
ix: 3,
k: [ 100, 100 ]
},
sa: {
a: 0,
ix: 5,
k: 0
},
sk: {
a: 0,
ix: 4,
k: 0
},
ty: "tr"
}), this.arr.splice(0, 0, i), this._groups.splice(0, 0, i), this._currentCopies += 1;
}
this.elem.reloadShapes();
}
var s, r, n = 0;
for (s = 0; s <= this._groups.length - 1; s += 1) r = e > n, this._groups[s]._render = r, 
this.changeGroupRender(this._groups[s].it, r), n += 1;
this._currentCopies = e, this.elem.firstFrame = !0;
var a = this.o.v, o = a % 1, h = a > 0 ? Math.floor(a) : Math.ceil(a), l = (this.tr.v.props, 
this.pMatrix.props), p = this.rMatrix.props, c = this.sMatrix.props;
this.pMatrix.reset(), this.rMatrix.reset(), this.sMatrix.reset(), this.tMatrix.reset(), 
this.matrix.reset();
var f = 0;
if (a > 0) {
for (;h > f; ) this.applyTransforms(this.pMatrix, this.rMatrix, this.sMatrix, this.tr, 1, !1), 
f += 1;
o && (this.applyTransforms(this.pMatrix, this.rMatrix, this.sMatrix, this.tr, o, !1), 
f += o);
} else if (0 > a) {
for (;f > h; ) this.applyTransforms(this.pMatrix, this.rMatrix, this.sMatrix, this.tr, 1, !0), 
f -= 1;
o && (this.applyTransforms(this.pMatrix, this.rMatrix, this.sMatrix, this.tr, -o, !0), 
f -= o);
}
s = 1 === this.data.m ? 0 : this._currentCopies - 1;
var u = 1 === this.data.m ? 1 : -1;
for (n = this._currentCopies; n; ) {
if (0 !== f) {
(0 !== s && 1 === u || s !== this._currentCopies - 1 && -1 === u) && this.applyTransforms(this.pMatrix, this.rMatrix, this.sMatrix, this.tr, 1, !1), 
this.matrix.transform(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9], p[10], p[11], p[12], p[13], p[14], p[15]), 
this.matrix.transform(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11], c[12], c[13], c[14], c[15]), 
this.matrix.transform(l[0], l[1], l[2], l[3], l[4], l[5], l[6], l[7], l[8], l[9], l[10], l[11], l[12], l[13], l[14], l[15]);
var d, m = this.elemsData[s].it, g = m[m.length - 1].transform.mProps.v.props, v = g.length;
for (d = 0; v > d; d += 1) g[d] = this.matrix.props[d];
this.matrix.reset();
} else {
this.matrix.reset();
var d, m = this.elemsData[s].it, g = m[m.length - 1].transform.mProps.v.props, v = g.length;
for (d = 0; v > d; d += 1) g[d] = this.matrix.props[d];
}
f += 1, n -= 1, s += u;
}
}
}, M.prototype.addShape = function() {}, ze.registerModifier("rp", M), C.prototype.addShape = function(t) {
this._length === this._maxLength && (this.shapes = this.shapes.concat(Array.apply(null, {
length: this._maxLength
})), this._maxLength *= 2), this.shapes[this._length] = t, this._length += 1;
}, C.prototype.releaseShapes = function() {
var t;
for (t = 0; t < this._length; t += 1) We.release(this.shapes[t]);
this._length = 0;
};
var Be = function() {
function t() {
this.loadedAssets += 1, this.loadedAssets === this.totalImages;
}
function e(t) {
var e = "";
if (this.assetsPath) {
var i = t.p;
-1 !== i.indexOf("images/") && (i = i.split("/")[1]), e = this.assetsPath + i;
} else e = this.path, e += t.u ? t.u : "", e += t.p;
return e;
}
function i(e) {
var i = document.createElement("img");
i.addEventListener("load", t.bind(this), !1), i.addEventListener("error", t.bind(this), !1), 
i.src = e;
}
function s(t) {
this.totalAssets = t.length;
var s;
for (s = 0; s < this.totalAssets; s += 1) t[s].layers || (i.bind(this)(e.bind(this)(t[s])), 
this.totalImages += 1);
}
function r(t) {
this.path = t || "";
}
function n(t) {
this.assetsPath = t || "";
}
return function() {
this.loadAssets = s, this.setAssetsPath = n, this.setPath = r, this.assetsPath = "", 
this.path = "", this.totalAssets = 0, this.totalImages = 0, this.loadedAssets = 0;
};
}(), qe = function() {
var t = {
maskType: !0
};
return (/MSIE 10/i.test(navigator.userAgent) || /MSIE 9/i.test(navigator.userAgent) || /rv:11.0/i.test(navigator.userAgent) || /Edge\/\d./i.test(navigator.userAgent)) && (t.maskType = !1), 
t;
}(), Ue = function() {
function t(t) {
var e = document.createElementNS(Ee, "filter");
return e.setAttribute("id", t), e.setAttribute("filterUnits", "objectBoundingBox"), 
e.setAttribute("x", "0%"), e.setAttribute("y", "0%"), e.setAttribute("width", "100%"), 
e.setAttribute("height", "100%"), e;
}
function e() {
var t = document.createElementNS(Ee, "feColorMatrix");
return t.setAttribute("type", "matrix"), t.setAttribute("color-interpolation-filters", "sRGB"), 
t.setAttribute("values", "0 0 0 1 0  0 0 0 1 0  0 0 0 1 0  0 0 0 1 1"), t;
}
var i = {};
return i.createFilter = t, i.createAlphaToLuminanceFilter = e, i;
}();
F.prototype.searchProperties = function(t) {
var e, i, s, r = this._textData.a.length;
for (e = 0; r > e; e += 1) s = this._textData.a[e], i = {
a: {},
s: {}
}, "r" in s.a && (i.a.r = Re.getProp(this._elem, s.a.r, 0, Te, this._dynamicProperties)), 
"rx" in s.a && (i.a.rx = Re.getProp(this._elem, s.a.rx, 0, Te, this._dynamicProperties)), 
"ry" in s.a && (i.a.ry = Re.getProp(this._elem, s.a.ry, 0, Te, this._dynamicProperties)), 
"sk" in s.a && (i.a.sk = Re.getProp(this._elem, s.a.sk, 0, Te, this._dynamicProperties)), 
"sa" in s.a && (i.a.sa = Re.getProp(this._elem, s.a.sa, 0, Te, this._dynamicProperties)), 
"s" in s.a && (i.a.s = Re.getProp(this._elem, s.a.s, 1, .01, this._dynamicProperties)), 
"a" in s.a && (i.a.a = Re.getProp(this._elem, s.a.a, 1, 0, this._dynamicProperties)), 
"o" in s.a && (i.a.o = Re.getProp(this._elem, s.a.o, 0, .01, this._dynamicProperties)), 
"p" in s.a && (i.a.p = Re.getProp(this._elem, s.a.p, 1, 0, this._dynamicProperties)), 
"sw" in s.a && (i.a.sw = Re.getProp(this._elem, s.a.sw, 0, 0, this._dynamicProperties)), 
"sc" in s.a && (i.a.sc = Re.getProp(this._elem, s.a.sc, 1, 0, this._dynamicProperties)), 
"fc" in s.a && (i.a.fc = Re.getProp(this._elem, s.a.fc, 1, 0, this._dynamicProperties)), 
"fh" in s.a && (i.a.fh = Re.getProp(this._elem, s.a.fh, 0, 0, this._dynamicProperties)), 
"fs" in s.a && (i.a.fs = Re.getProp(this._elem, s.a.fs, 0, .01, this._dynamicProperties)), 
"fb" in s.a && (i.a.fb = Re.getProp(this._elem, s.a.fb, 0, .01, this._dynamicProperties)), 
"t" in s.a && (i.a.t = Re.getProp(this._elem, s.a.t, 0, 0, this._dynamicProperties)), 
i.s = Re.getTextSelectorProp(this._elem, s.s, this._dynamicProperties), i.s.t = s.s.t, 
this._animatorsData[e] = i;
this._textData.p && "m" in this._textData.p ? (this._pathData = {
f: Re.getProp(this._elem, this._textData.p.f, 0, 0, this._dynamicProperties),
l: Re.getProp(this._elem, this._textData.p.l, 0, 0, this._dynamicProperties),
r: this._textData.p.r,
m: this._elem.maskManager.getMaskProperty(this._textData.p.m)
}, this._hasMaskedPath = !0) : this._hasMaskedPath = !1, this._moreOptions.alignment = Re.getProp(this._elem, this._textData.m.a, 1, 0, this._dynamicProperties), 
this._dynamicProperties.length && t.push(this);
}, F.prototype.getMeasures = function(t, e) {
if (this.lettersChangedFlag = e, this.mdf || this._firstFrame || e || this._hasMaskedPath && this._pathData.m.mdf) {
this._firstFrame = !1;
var i, s, r, n, a = this._moreOptions.alignment.v, o = this._animatorsData, h = this._textData, l = this.mHelper, p = this._renderType, c = this.renderedLetters.length, f = (this.data, 
t.l);
if (this._hasMaskedPath) {
var u = this._pathData.m;
if (!this._pathData.n || this._pathData.mdf) {
var d = u.v;
this._pathData.r && (d = y(d));
var b = {
tLength: 0,
segments: []
};
n = d._length - 1;
var k, E = 0;
for (r = 0; n > r; r += 1) k = {
s: d.v[r],
e: d.v[r + 1],
to: [ d.o[r][0] - d.v[r][0], d.o[r][1] - d.v[r][1] ],
ti: [ d.i[r + 1][0] - d.v[r + 1][0], d.i[r + 1][1] - d.v[r + 1][1] ]
}, Le.buildBezierData(k), b.tLength += k.bezierData.segmentLength, b.segments.push(k), 
E += k.bezierData.segmentLength;
r = n, u.v.c && (k = {
s: d.v[r],
e: d.v[0],
to: [ d.o[r][0] - d.v[r][0], d.o[r][1] - d.v[r][1] ],
ti: [ d.i[0][0] - d.v[0][0], d.i[0][1] - d.v[0][1] ]
}, Le.buildBezierData(k), b.tLength += k.bezierData.segmentLength, b.segments.push(k), 
E += k.bezierData.segmentLength), this._pathData.pi = b;
}
var w, A, S, b = this._pathData.pi, P = this._pathData.f.v, x = 0, _ = 1, M = 0, C = !0, F = b.segments;
if (0 > P && u.v.c) for (b.tLength < Math.abs(P) && (P = -Math.abs(P) % b.tLength), 
x = F.length - 1, S = F[x].bezierData.points, _ = S.length - 1; 0 > P; ) P += S[_].partialLength, 
_ -= 1, 0 > _ && (x -= 1, S = F[x].bezierData.points, _ = S.length - 1);
S = F[x].bezierData.points, A = S[_ - 1], w = S[_];
var D, I, N = w.partialLength;
}
n = f.length, i = 0, s = 0;
var L, j, O, R, V, z = 1.2 * t.s * .714, B = !0, q = Array.apply(null, {
length: n
});
if (R = o.length, e) for (O = 0; R > O; O += 1) j = o[O].s, j.getValue(!0);
var U, G, H, W, X, J, $, Y, Z, K, Q, te, ee, ie = -1, se = P, re = x, ne = _, ae = -1, oe = 0, he = "", le = this.defaultPropsArray;
for (r = 0; n > r; r += 1) if (l.reset(), X = 1, f[r].n) i = 0, s += t.yOffset, 
s += B ? 1 : 0, P = se, B = !1, oe = 0, this._hasMaskedPath && (x = re, _ = ne, 
S = F[x].bezierData.points, A = S[_ - 1], w = S[_], N = w.partialLength, M = 0), 
q[r] = this.emptyProp; else {
if (this._hasMaskedPath) {
if (ae !== f[r].line) {
switch (t.j) {
case 1:
P += E - t.lineWidths[f[r].line];
break;

case 2:
P += (E - t.lineWidths[f[r].line]) / 2;
}
ae = f[r].line;
}
ie !== f[r].ind && (f[ie] && (P += f[ie].extra), P += f[r].an / 2, ie = f[r].ind), 
P += a[0] * f[r].an / 200;
var pe = 0;
for (O = 0; R > O; O += 1) L = o[O].a, "p" in L && (j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
pe += U.length ? L.p.v[0] * U[0] : L.p.v[0] * U), "a" in L && (j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
pe += U.length ? L.a.v[0] * U[0] : L.a.v[0] * U);
for (C = !0; C; ) M + N >= P + pe || !S ? (D = (P + pe - M) / w.partialLength, H = A.point[0] + (w.point[0] - A.point[0]) * D, 
W = A.point[1] + (w.point[1] - A.point[1]) * D, l.translate(-a[0] * f[r].an / 200, -(a[1] * z / 100)), 
C = !1) : S && (M += w.partialLength, _ += 1, _ >= S.length && (_ = 0, x += 1, F[x] ? S = F[x].bezierData.points : u.v.c ? (_ = 0, 
x = 0, S = F[x].bezierData.points) : (M -= w.partialLength, S = null)), S && (A = w, 
w = S[_], N = w.partialLength));
G = f[r].an / 2 - f[r].add, l.translate(-G, 0, 0);
} else G = f[r].an / 2 - f[r].add, l.translate(-G, 0, 0), l.translate(-a[0] * f[r].an / 200, -a[1] * z / 100, 0);
for (oe += f[r].l / 2, O = 0; R > O; O += 1) L = o[O].a, "t" in L && (j = o[O].s, 
U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), this._hasMaskedPath ? P += U.length ? L.t * U[0] : L.t * U : i += U.length ? L.t.v * U[0] : L.t.v * U);
for (oe += f[r].l / 2, t.strokeWidthAnim && ($ = t.sw || 0), t.strokeColorAnim && (J = t.sc ? [ t.sc[0], t.sc[1], t.sc[2] ] : [ 0, 0, 0 ]), 
t.fillColorAnim && t.fc && (Y = [ t.fc[0], t.fc[1], t.fc[2] ]), O = 0; R > O; O += 1) L = o[O].a, 
"a" in L && (j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
U.length ? l.translate(-L.a.v[0] * U[0], -L.a.v[1] * U[1], L.a.v[2] * U[2]) : l.translate(-L.a.v[0] * U, -L.a.v[1] * U, L.a.v[2] * U));
for (O = 0; R > O; O += 1) L = o[O].a, "s" in L && (j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
U.length ? l.scale(1 + (L.s.v[0] - 1) * U[0], 1 + (L.s.v[1] - 1) * U[1], 1) : l.scale(1 + (L.s.v[0] - 1) * U, 1 + (L.s.v[1] - 1) * U, 1));
for (O = 0; R > O; O += 1) {
if (L = o[O].a, j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
"sk" in L && (U.length ? l.skewFromAxis(-L.sk.v * U[0], L.sa.v * U[1]) : l.skewFromAxis(-L.sk.v * U, L.sa.v * U)), 
"r" in L && l.rotateZ(U.length ? -L.r.v * U[2] : -L.r.v * U), "ry" in L && l.rotateY(U.length ? L.ry.v * U[1] : L.ry.v * U), 
"rx" in L && l.rotateX(U.length ? L.rx.v * U[0] : L.rx.v * U), "o" in L && (X += U.length ? (L.o.v * U[0] - X) * U[0] : (L.o.v * U - X) * U), 
t.strokeWidthAnim && "sw" in L && ($ += U.length ? L.sw.v * U[0] : L.sw.v * U), 
t.strokeColorAnim && "sc" in L) for (Z = 0; 3 > Z; Z += 1) J[Z] = Math.round(U.length ? 255 * (J[Z] + (L.sc.v[Z] - J[Z]) * U[0]) : 255 * (J[Z] + (L.sc.v[Z] - J[Z]) * U));
if (t.fillColorAnim && t.fc) {
if ("fc" in L) for (Z = 0; 3 > Z; Z += 1) Y[Z] = U.length ? Y[Z] + (L.fc.v[Z] - Y[Z]) * U[0] : Y[Z] + (L.fc.v[Z] - Y[Z]) * U;
"fh" in L && (Y = U.length ? v(Y, L.fh.v * U[0]) : v(Y, L.fh.v * U)), "fs" in L && (Y = U.length ? m(Y, L.fs.v * U[0]) : m(Y, L.fs.v * U)), 
"fb" in L && (Y = U.length ? g(Y, L.fb.v * U[0]) : g(Y, L.fb.v * U));
}
}
for (O = 0; R > O; O += 1) L = o[O].a, "p" in L && (j = o[O].s, U = j.getMult(f[r].anIndexes[O], h.a[O].s.totalChars), 
this._hasMaskedPath ? U.length ? l.translate(0, L.p.v[1] * U[0], -L.p.v[2] * U[1]) : l.translate(0, L.p.v[1] * U, -L.p.v[2] * U) : U.length ? l.translate(L.p.v[0] * U[0], L.p.v[1] * U[1], -L.p.v[2] * U[2]) : l.translate(L.p.v[0] * U, L.p.v[1] * U, -L.p.v[2] * U));
if (t.strokeWidthAnim && (K = 0 > $ ? 0 : $), t.strokeColorAnim && (Q = "rgb(" + Math.round(255 * J[0]) + "," + Math.round(255 * J[1]) + "," + Math.round(255 * J[2]) + ")"), 
t.fillColorAnim && t.fc && (te = "rgb(" + Math.round(255 * Y[0]) + "," + Math.round(255 * Y[1]) + "," + Math.round(255 * Y[2]) + ")"), 
this._hasMaskedPath) {
if (l.translate(0, -t.ls), l.translate(0, a[1] * z / 100 + s, 0), h.p.p) {
I = (w.point[1] - A.point[1]) / (w.point[0] - A.point[0]);
var ce = 180 * Math.atan(I) / Math.PI;
w.point[0] < A.point[0] && (ce += 180), l.rotate(-ce * Math.PI / 180);
}
l.translate(H, W, 0), P -= a[0] * f[r].an / 200, f[r + 1] && ie !== f[r + 1].ind && (P += f[r].an / 2, 
P += t.tr / 1e3 * t.s);
} else {
switch (l.translate(i, s, 0), t.ps && l.translate(t.ps[0], t.ps[1] + t.ascent, 0), 
t.j) {
case 1:
l.translate(t.justifyOffset + (t.boxWidth - t.lineWidths[f[r].line]), 0, 0);
break;

case 2:
l.translate(t.justifyOffset + (t.boxWidth - t.lineWidths[f[r].line]) / 2, 0, 0);
}
l.translate(0, -t.ls), l.translate(G, 0, 0), l.translate(a[0] * f[r].an / 200, a[1] * z / 100, 0), 
i += f[r].l + t.tr / 1e3 * t.s;
}
"html" === p ? he = l.toCSS() : "svg" === p ? he = l.to2dCSS() : le = [ l.props[0], l.props[1], l.props[2], l.props[3], l.props[4], l.props[5], l.props[6], l.props[7], l.props[8], l.props[9], l.props[10], l.props[11], l.props[12], l.props[13], l.props[14], l.props[15] ], 
ee = X, r >= c ? (V = new T(ee, K, Q, te, he, le), this.renderedLetters.push(V), 
c += 1, this.lettersChangedFlag = !0) : (V = this.renderedLetters[r], this.lettersChangedFlag = V.update(ee, K, Q, te, he, le) || this.lettersChangedFlag);
}
}
}, F.prototype.getValue = function() {
if (this._elem.globalData.frameId !== this._frameId) {
this._frameId = this._elem.globalData.frameId;
var t, e = this._dynamicProperties.length;
for (this.mdf = !1, t = 0; e > t; t += 1) this._dynamicProperties[t].getValue(), 
this.mdf = this._dynamicProperties[t].mdf || this.mdf;
}
}, F.prototype.mHelper = new b(), F.prototype.defaultPropsArray = [], T.prototype.update = function(t, e, i, s, r, n) {
this.mdf.o = !1, this.mdf.sw = !1, this.mdf.sc = !1, this.mdf.fc = !1, this.mdf.m = !1, 
this.mdf.p = !1;
var a = !1;
return this.o !== t && (this.o = t, this.mdf.o = !0, a = !0), this.sw !== e && (this.sw = e, 
this.mdf.sw = !0, a = !0), this.sc !== i && (this.sc = i, this.mdf.sc = !0, a = !0), 
this.fc !== s && (this.fc = s, this.mdf.fc = !0, a = !0), this.m !== r && (this.m = r, 
this.mdf.m = !0, a = !0), !n.length || this.p[0] === n[0] && this.p[1] === n[1] && this.p[4] === n[4] && this.p[5] === n[5] && this.p[12] === n[12] && this.p[13] === n[13] || (this.p = n, 
this.mdf.p = !0, a = !0), a;
};
var Ge = function() {
function t(t) {
return t.concat(Array.apply(null, {
length: t.length
}));
}
return {
"double": t
};
}(), He = function() {
function t() {
var t;
return s ? (s -= 1, t = n[s]) : t = [ .1, .1 ], t;
}
function e(t) {
s === r && (n = Ge["double"](n), r = 2 * r), n[s] = t, s += 1;
}
var i = {
newPoint: t,
release: e
}, s = 0, r = 8, n = Array.apply(null, {
length: r
});
return i;
}(), We = function() {
function t() {
var t;
return n ? (n -= 1, t = o[n]) : t = new S(), t;
}
function e(t) {
n === a && (o = Ge["double"](o), a = 2 * a);
var e, i = t._length;
for (e = 0; i > e; e += 1) He.release(t.v[e]), He.release(t.i[e]), He.release(t.o[e]), 
t.v[e] = null, t.i[e] = null, t.o[e] = null;
t._length = 0, t.c = !1, o[n] = t, n += 1;
}
function i(t, i) {
for (;i--; ) e(t[i]);
}
function s(e, i) {
var s, r = e._length, n = t();
n._length = e._length, n.c = e.c;
var a;
for (s = 0; r > s; s += 1) i ? (a = i.applyToPointArray(e.v[s][0], e.v[s][1], 0, 2), 
n.setXYAt(a[0], a[1], "v", s), He.release(a), a = i.applyToPointArray(e.o[s][0], e.o[s][1], 0, 2), 
n.setXYAt(a[0], a[1], "o", s), He.release(a), a = i.applyToPointArray(e.i[s][0], e.i[s][1], 0, 2), 
n.setXYAt(a[0], a[1], "i", s), He.release(a)) : n.setTripleAt(e.v[s][0], e.v[s][1], e.o[s][0], e.o[s][1], e.i[s][0], e.i[s][1], s);
return n;
}
var r = {
clone: s,
newShape: t,
release: e,
releaseArray: i
}, n = 0, a = 4, o = Array.apply(null, {
length: a
});
return r;
}(), Xe = function() {
function t() {
var t;
return r ? (r -= 1, t = a[r]) : t = new C(), t;
}
function e(t) {
var e, i = t._length;
for (e = 0; i > e; e += 1) We.release(t.shapes[e]);
t._length = 0, r === n && (a = Ge["double"](a), n = 2 * n), a[r] = t, r += 1;
}
function i(t) {
e(t), r === n && (a = Ge["double"](a), n = 2 * n), a[r] = t, r += 1;
}
var s = {
newShapeCollection: t,
release: e,
clone: i
}, r = 0, n = 4, a = Array.apply(null, {
length: n
});
return s;
}();
D.prototype.checkLayers = function(t) {
var e, i, s = this.layers.length;
for (this.completeLayers = !0, e = s - 1; e >= 0; e--) this.elements[e] || (i = this.layers[e], 
i.ip - i.st <= t - this.layers[e].st && i.op - i.st > t - this.layers[e].st && this.buildItem(e)), 
this.completeLayers = this.elements[e] ? this.completeLayers : !1;
this.checkPendingElements();
}, D.prototype.createItem = function(t) {
switch (t.ty) {
case 2:
return this.createImage(t);

case 0:
return this.createComp(t);

case 1:
return this.createSolid(t);

case 4:
return this.createShape(t);

case 5:
return this.createText(t);

case 13:
return this.createCamera(t);

case 99:
return null;
}
return this.createBase(t);
}, D.prototype.createCamera = function() {
throw new Error("You're using a 3d camera. Try the html renderer.");
}, D.prototype.buildAllItems = function() {
var t, e = this.layers.length;
for (t = 0; e > t; t += 1) this.buildItem(t);
this.checkPendingElements();
}, D.prototype.includeLayers = function(t) {
this.completeLayers = !1;
var e, i, s = t.length, r = this.layers.length;
for (e = 0; s > e; e += 1) for (i = 0; r > i; ) {
if (this.layers[i].id == t[e].id) {
this.layers[i] = t[e];
break;
}
i += 1;
}
}, D.prototype.setProjectInterface = function(t) {
this.globalData.projectInterface = t;
}, D.prototype.initItems = function() {
this.globalData.progressiveLoad || this.buildAllItems();
}, D.prototype.buildElementParenting = function(t, e, i) {
i = i || [];
for (var s = this.elements, r = this.layers, n = 0, a = r.length; a > n; ) r[n].ind == e && (s[n] && s[n] !== !0 ? void 0 !== r[n].parent ? (i.push(s[n]), 
s[n]._isParent = !0, this.buildElementParenting(t, r[n].parent, i)) : (i.push(s[n]), 
s[n]._isParent = !0, t.setHierarchy(i)) : (this.buildItem(n), this.addPendingElement(t))), 
n += 1;
}, D.prototype.addPendingElement = function(t) {
this.pendingElements.push(t);
}, E(D, I), I.prototype.createBase = function(t) {
return new j(t, this.layerElement, this.globalData, this);
}, I.prototype.createShape = function(t) {
return new O(t, this.layerElement, this.globalData, this);
}, I.prototype.createText = function(t) {
return new V(t, this.layerElement, this.globalData, this);
}, I.prototype.createImage = function(t) {
return new $(t, this.layerElement, this.globalData, this);
}, I.prototype.createComp = function(t) {
return new J(t, this.layerElement, this.globalData, this);
}, I.prototype.createSolid = function(t) {
return new Y(t, this.layerElement, this.globalData, this);
}, I.prototype.configAnimation = function(t) {
this.layerElement = document.createElementNS(Ee, "svg"), this.layerElement.setAttribute("xmlns", "http://www.w3.org/2000/svg"), 
this.layerElement.setAttribute("viewBox", "0 0 " + t.w + " " + t.h), this.renderConfig.viewBoxOnly || (this.layerElement.setAttribute("width", t.w), 
this.layerElement.setAttribute("height", t.h), this.layerElement.style.width = "100%", 
this.layerElement.style.height = "100%"), this.layerElement.setAttribute("preserveAspectRatio", this.renderConfig.preserveAspectRatio), 
this.animationItem.wrapper.appendChild(this.layerElement);
var e = document.createElementNS(Ee, "defs");
this.globalData.defs = e, this.layerElement.appendChild(e), this.globalData.getAssetData = this.animationItem.getAssetData.bind(this.animationItem), 
this.globalData.getAssetsPath = this.animationItem.getAssetsPath.bind(this.animationItem), 
this.globalData.progressiveLoad = this.renderConfig.progressiveLoad, this.globalData.frameId = 0, 
this.globalData.nm = t.nm, this.globalData.compSize = {
w: t.w,
h: t.h
}, this.data = t, this.globalData.frameRate = t.fr;
var i = document.createElementNS(Ee, "clipPath"), s = document.createElementNS(Ee, "rect");
s.setAttribute("width", t.w), s.setAttribute("height", t.h), s.setAttribute("x", 0), 
s.setAttribute("y", 0);
var r = "animationMask_" + f(10);
i.setAttribute("id", r), i.appendChild(s);
var n = document.createElementNS(Ee, "g");
n.setAttribute("clip-path", "url(" + we + "#" + r + ")"), this.layerElement.appendChild(n), 
e.appendChild(i), this.layerElement = n, this.layers = t.layers, this.globalData.fontManager = new Oe(), 
this.globalData.fontManager.addChars(t.chars), this.globalData.fontManager.addFonts(t.fonts, e), 
this.elements = Array.apply(null, {
length: t.layers.length
});
}, I.prototype.destroy = function() {
this.animationItem.wrapper.innerHTML = "", this.layerElement = null, this.globalData.defs = null;
var t, e = this.layers ? this.layers.length : 0;
for (t = 0; e > t; t++) this.elements[t] && this.elements[t].destroy();
this.elements.length = 0, this.destroyed = !0, this.animationItem = null;
}, I.prototype.updateContainerSize = function() {}, I.prototype.buildItem = function(t) {
var e = this.elements;
if (!e[t] && 99 != this.layers[t].ty) {
e[t] = !0;
var i = this.createItem(this.layers[t]);
e[t] = i, be && (0 === this.layers[t].ty && this.globalData.projectInterface.registerComposition(i), 
i.initExpressions()), this.appendElementInPos(i, t), this.layers[t].tt && (this.elements[t - 1] && this.elements[t - 1] !== !0 ? i.setMatte(e[t - 1].layerId) : (this.buildItem(t - 1), 
this.addPendingElement(i)));
}
}, I.prototype.checkPendingElements = function() {
for (;this.pendingElements.length; ) {
var t = this.pendingElements.pop();
if (t.checkParenting(), t.data.tt) for (var e = 0, i = this.elements.length; i > e; ) {
if (this.elements[e] === t) {
t.setMatte(this.elements[e - 1].layerId);
break;
}
e += 1;
}
}
}, I.prototype.renderFrame = function(t) {
if (this.renderedFrame != t && !this.destroyed) {
null === t ? t = this.renderedFrame : this.renderedFrame = t, this.globalData.frameNum = t, 
this.globalData.frameId += 1, this.globalData.projectInterface.currentFrame = t;
var e, i = this.layers.length;
for (this.completeLayers || this.checkLayers(t), e = i - 1; e >= 0; e--) (this.completeLayers || this.elements[e]) && this.elements[e].prepareFrame(t - this.layers[e].st);
for (e = i - 1; e >= 0; e--) (this.completeLayers || this.elements[e]) && this.elements[e].renderFrame();
}
}, I.prototype.appendElementInPos = function(t, e) {
var i = t.getBaseElement();
if (i) {
for (var s, r = 0; e > r; ) this.elements[r] && this.elements[r] !== !0 && this.elements[r].getBaseElement() && (s = this.elements[r].getBaseElement()), 
r += 1;
s ? this.layerElement.insertBefore(i, s) : this.layerElement.appendChild(i);
}
}, I.prototype.hide = function() {
this.layerElement.style.display = "none";
}, I.prototype.show = function() {
this.layerElement.style.display = "block";
}, I.prototype.searchExtraCompositions = function(t) {
var e, i = t.length, s = document.createElementNS(Ee, "g");
for (e = 0; i > e; e += 1) if (t[e].xt) {
var r = this.createComp(t[e], s, this.globalData.comp, null);
r.initExpressions(), this.globalData.projectInterface.registerComposition(r);
}
}, N.prototype.getMaskProperty = function(t) {
return this.viewData[t].prop;
}, N.prototype.prepareFrame = function() {
var t, e = this.dynamicProperties.length;
for (t = 0; e > t; t += 1) this.dynamicProperties[t].getValue();
}, N.prototype.renderFrame = function(t) {
var e, i = this.masksProperties.length;
for (e = 0; i > e; e++) if ((this.viewData[e].prop.mdf || this.firstFrame) && this.drawPath(this.masksProperties[e], this.viewData[e].prop.v, this.viewData[e]), 
(this.viewData[e].op.mdf || this.firstFrame) && this.viewData[e].elem.setAttribute("fill-opacity", this.viewData[e].op.v), 
"n" !== this.masksProperties[e].mode && (this.viewData[e].invRect && (this.element.finalTransform.mProp.mdf || this.firstFrame) && (this.viewData[e].invRect.setAttribute("x", -t.props[12]), 
this.viewData[e].invRect.setAttribute("y", -t.props[13])), this.storedData[e].x && (this.storedData[e].x.mdf || this.firstFrame))) {
var s = this.storedData[e].expan;
this.storedData[e].x.v < 0 ? ("erode" !== this.storedData[e].lastOperator && (this.storedData[e].lastOperator = "erode", 
this.storedData[e].elem.setAttribute("filter", "url(" + we + "#" + this.storedData[e].filterId + ")")), 
s.setAttribute("radius", -this.storedData[e].x.v)) : ("dilate" !== this.storedData[e].lastOperator && (this.storedData[e].lastOperator = "dilate", 
this.storedData[e].elem.setAttribute("filter", null)), this.storedData[e].elem.setAttribute("stroke-width", 2 * this.storedData[e].x.v));
}
this.firstFrame = !1;
}, N.prototype.getMaskelement = function() {
return this.maskElement;
}, N.prototype.createLayerSolidPath = function() {
var t = "M0,0 ";
return t += " h" + this.globalData.compSize.w, t += " v" + this.globalData.compSize.h, 
t += " h-" + this.globalData.compSize.w, t += " v-" + this.globalData.compSize.h + " ";
}, N.prototype.drawPath = function(t, e, i) {
var s, r, n = " M" + e.v[0][0] + "," + e.v[0][1];
for (r = e._length, s = 1; r > s; s += 1) n += " C" + ke(e.o[s - 1][0]) + "," + ke(e.o[s - 1][1]) + " " + ke(e.i[s][0]) + "," + ke(e.i[s][1]) + " " + ke(e.v[s][0]) + "," + ke(e.v[s][1]);
e.c && r > 1 && (n += " C" + ke(e.o[s - 1][0]) + "," + ke(e.o[s - 1][1]) + " " + ke(e.i[0][0]) + "," + ke(e.i[0][1]) + " " + ke(e.v[0][0]) + "," + ke(e.v[0][1])), 
i.lastPath !== n && (i.elem && (e.c ? t.inv ? i.elem.setAttribute("d", this.solidPath + n) : i.elem.setAttribute("d", n) : i.elem.setAttribute("d", "")), 
i.lastPath = n);
}, N.prototype.getMask = function(t) {
for (var e = 0, i = this.masksProperties.length; i > e; ) {
if (this.masksProperties[e].nm === t) return {
maskPath: this.viewData[e].prop.pv
};
e += 1;
}
}, N.prototype.destroy = function() {
this.element = null, this.globalData = null, this.maskElement = null, this.data = null, 
this.paths = null, this.masksProperties = null;
}, L.prototype.checkMasks = function() {
if (!this.data.hasMask) return !1;
for (var t = 0, e = this.data.masksProperties.length; e > t; ) {
if ("n" !== this.data.masksProperties[t].mode && this.data.masksProperties[t].cl !== !1) return !0;
t += 1;
}
return !1;
}, L.prototype.checkParenting = function() {
void 0 !== this.data.parent && this.comp.buildElementParenting(this, this.data.parent);
}, L.prototype.prepareFrame = function(t) {
this.data.ip - this.data.st <= t && this.data.op - this.data.st > t ? this.isVisible !== !0 && (this.elemMdf = !0, 
this.globalData.mdf = !0, this.isVisible = !0, this.firstFrame = !0, this.data.hasMask && (this.maskManager.firstFrame = !0)) : this.isVisible !== !1 && (this.elemMdf = !0, 
this.globalData.mdf = !0, this.isVisible = !1);
var e, i = this.dynamicProperties.length;
for (e = 0; i > e; e += 1) (this.isVisible || this._isParent && "transform" === this.dynamicProperties[e].type) && (this.dynamicProperties[e].getValue(), 
this.dynamicProperties[e].mdf && (this.elemMdf = !0, this.globalData.mdf = !0));
return this.data.hasMask && this.isVisible && this.maskManager.prepareFrame(t * this.data.sr), 
this.currentFrameNum = t * this.data.sr, this.isVisible;
}, L.prototype.globalToLocal = function(t) {
var e = [];
e.push(this.finalTransform);
for (var i = !0, s = this.comp; i; ) s.finalTransform ? (s.data.hasMask && e.splice(0, 0, s.finalTransform), 
s = s.comp) : i = !1;
var r, n, a = e.length;
for (r = 0; a > r; r += 1) n = e[r].mat.applyToPointArray(0, 0, 0), t = [ t[0] - n[0], t[1] - n[1], 0 ];
return t;
}, L.prototype.initExpressions = function() {
this.layerInterface = LayerExpressionInterface(this), this.data.hasMask && this.layerInterface.registerMaskInterface(this.maskManager);
var t = EffectsExpressionInterface.createEffectsInterface(this, this.layerInterface);
this.layerInterface.registerEffectsInterface(t), 0 === this.data.ty || this.data.xt ? this.compInterface = CompExpressionInterface(this) : 4 === this.data.ty ? this.layerInterface.shapeInterface = ShapeExpressionInterface.createShapeInterface(this.shapesData, this.itemsData, this.layerInterface) : 5 === this.data.ty && (this.layerInterface.textInterface = TextExpressionInterface(this));
}, L.prototype.setBlendMode = function() {
var t = "";
switch (this.data.bm) {
case 1:
t = "multiply";
break;

case 2:
t = "screen";
break;

case 3:
t = "overlay";
break;

case 4:
t = "darken";
break;

case 5:
t = "lighten";
break;

case 6:
t = "color-dodge";
break;

case 7:
t = "color-burn";
break;

case 8:
t = "hard-light";
break;

case 9:
t = "soft-light";
break;

case 10:
t = "difference";
break;

case 11:
t = "exclusion";
break;

case 12:
t = "hue";
break;

case 13:
t = "saturation";
break;

case 14:
t = "color";
break;

case 15:
t = "luminosity";
}
var e = this.baseElement || this.layerElement;
e.style["mix-blend-mode"] = t;
}, L.prototype.init = function() {
this.data.sr || (this.data.sr = 1), this.dynamicProperties = this.dynamicProperties || [], 
this.data.ef && (this.effects = new EffectsManager(this.data, this, this.dynamicProperties)), 
this.hidden = !1, this.firstFrame = !0, this.isVisible = !1, this._isParent = !1, 
this.currentFrameNum = -99999, this.lastNum = -99999, this.data.ks && (this.finalTransform = {
mProp: Re.getProp(this, this.data.ks, 2, null, this.dynamicProperties),
matMdf: !1,
opMdf: !1,
mat: new b(),
opacity: 1
}, this.data.ao && (this.finalTransform.mProp.autoOriented = !0), this.finalTransform.op = this.finalTransform.mProp.o, 
this.transform = this.finalTransform.mProp, 11 !== this.data.ty && this.createElements(), 
this.data.hasMask && this.addMasks(this.data)), this.elemMdf = !1;
}, L.prototype.getType = function() {
return this.type;
}, L.prototype.resetHierarchy = function() {
this.hierarchy ? this.hierarchy.length = 0 : this.hierarchy = [];
}, L.prototype.getHierarchy = function() {
return this.hierarchy || (this.hierarchy = []), this.hierarchy;
}, L.prototype.setHierarchy = function(t) {
this.hierarchy = t;
}, L.prototype.getLayerSize = function() {
return 5 === this.data.ty ? {
w: this.data.textData.width,
h: this.data.textData.height
} : {
w: this.data.width,
h: this.data.height
};
}, L.prototype.hide = function() {}, L.prototype.sourceRectAtTime = function() {
return {
top: 0,
left: 0,
width: 100,
height: 100
};
}, L.prototype.mHelper = new b(), k(L, j), j.prototype.createElements = function() {
this.layerElement = document.createElementNS(Ee, "g"), this.transformedElement = this.layerElement, 
this.data.hasMask && (this.maskedElement = this.layerElement);
var t = null;
if (this.data.td) {
if (3 == this.data.td || 1 == this.data.td) {
var e = document.createElementNS(Ee, "mask");
if (e.setAttribute("id", this.layerId), e.setAttribute("mask-type", 3 == this.data.td ? "luminance" : "alpha"), 
e.appendChild(this.layerElement), t = e, this.globalData.defs.appendChild(e), !qe.maskType && 1 == this.data.td) {
e.setAttribute("mask-type", "luminance");
var i = f(10), s = Ue.createFilter(i);
this.globalData.defs.appendChild(s), s.appendChild(Ue.createAlphaToLuminanceFilter());
var r = document.createElementNS(Ee, "g");
r.appendChild(this.layerElement), t = r, e.appendChild(r), r.setAttribute("filter", "url(" + we + "#" + i + ")");
}
} else if (2 == this.data.td) {
var n = document.createElementNS(Ee, "mask");
n.setAttribute("id", this.layerId), n.setAttribute("mask-type", "alpha");
var a = document.createElementNS(Ee, "g");
n.appendChild(a);
var i = f(10), s = Ue.createFilter(i), o = document.createElementNS(Ee, "feColorMatrix");
o.setAttribute("type", "matrix"), o.setAttribute("color-interpolation-filters", "sRGB"), 
o.setAttribute("values", "1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 -1 1"), s.appendChild(o), 
this.globalData.defs.appendChild(s);
var h = document.createElementNS(Ee, "rect");
if (h.setAttribute("width", this.comp.data.w), h.setAttribute("height", this.comp.data.h), 
h.setAttribute("x", "0"), h.setAttribute("y", "0"), h.setAttribute("fill", "#ffffff"), 
h.setAttribute("opacity", "0"), a.setAttribute("filter", "url(" + we + "#" + i + ")"), 
a.appendChild(h), a.appendChild(this.layerElement), t = a, !qe.maskType) {
n.setAttribute("mask-type", "luminance"), s.appendChild(Ue.createAlphaToLuminanceFilter());
var r = document.createElementNS(Ee, "g");
a.appendChild(h), r.appendChild(this.layerElement), t = r, a.appendChild(r);
}
this.globalData.defs.appendChild(n);
}
} else (this.data.hasMask || this.data.tt) && this.data.tt ? (this.matteElement = document.createElementNS(Ee, "g"), 
this.matteElement.appendChild(this.layerElement), t = this.matteElement, this.baseElement = this.matteElement) : this.baseElement = this.layerElement;
if (!this.data.ln && !this.data.cl || 4 !== this.data.ty && 0 !== this.data.ty || (this.data.ln && this.layerElement.setAttribute("id", this.data.ln), 
this.data.cl && this.layerElement.setAttribute("class", this.data.cl)), 0 === this.data.ty) {
var l = document.createElementNS(Ee, "clipPath"), p = document.createElementNS(Ee, "path");
p.setAttribute("d", "M0,0 L" + this.data.w + ",0 L" + this.data.w + "," + this.data.h + " L0," + this.data.h + "z");
var c = "cp_" + f(8);
if (l.setAttribute("id", c), l.appendChild(p), this.globalData.defs.appendChild(l), 
this.checkMasks()) {
var u = document.createElementNS(Ee, "g");
u.setAttribute("clip-path", "url(" + we + "#" + c + ")"), u.appendChild(this.layerElement), 
this.transformedElement = u, t ? t.appendChild(this.transformedElement) : this.baseElement = this.transformedElement;
} else this.layerElement.setAttribute("clip-path", "url(" + we + "#" + c + ")");
}
0 !== this.data.bm && this.setBlendMode(), this.layerElement !== this.parentContainer && (this.placeholder = null), 
this.data.ef && (this.effectsManager = new X(this)), this.checkParenting();
}, j.prototype.setBlendMode = L.prototype.setBlendMode, j.prototype.renderFrame = function() {
if (3 === this.data.ty || this.data.hd || !this.isVisible) return !1;
this.lastNum = this.currentFrameNum, this.finalTransform.opMdf = this.firstFrame || this.finalTransform.op.mdf, 
this.finalTransform.matMdf = this.firstFrame || this.finalTransform.mProp.mdf, this.finalTransform.opacity = this.finalTransform.op.v;
var t, e = this.finalTransform.mat;
if (this.hierarchy) {
var i = 0, s = this.hierarchy.length;
if (!this.finalTransform.matMdf) for (;s > i; ) {
if (this.hierarchy[i].finalTransform.mProp.mdf) {
this.finalTransform.matMdf = !0;
break;
}
i += 1;
}
if (this.finalTransform.matMdf) for (t = this.finalTransform.mProp.v.props, e.cloneFromProps(t), 
i = 0; s > i; i += 1) t = this.hierarchy[i].finalTransform.mProp.v.props, e.transform(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11], t[12], t[13], t[14], t[15]);
} else this.isVisible && (e = this.finalTransform.mProp.v);
return this.finalTransform.matMdf && this.layerElement && this.transformedElement.setAttribute("transform", e.to2dCSS()), 
this.finalTransform.opMdf && this.layerElement && (this.finalTransform.op.v <= 0 ? !this.isTransparent && this.globalData.renderConfig.hideOnTransparent && (this.isTransparent = !0, 
this.hide()) : this.hidden && this.isTransparent && (this.isTransparent = !1, this.show()), 
this.transformedElement.setAttribute("opacity", this.finalTransform.op.v)), this.data.hasMask && this.maskManager.renderFrame(e), 
this.effectsManager && this.effectsManager.renderFrame(this.firstFrame), this.isVisible;
}, j.prototype.destroy = function() {
this.layerElement = null, this.parentContainer = null, this.matteElement && (this.matteElement = null), 
this.maskManager && this.maskManager.destroy();
}, j.prototype.getBaseElement = function() {
return this.baseElement;
}, j.prototype.addMasks = function(t) {
this.maskManager = new N(t, this, this.globalData);
}, j.prototype.setMatte = function(t) {
this.matteElement && this.matteElement.setAttribute("mask", "url(" + we + "#" + t + ")");
}, j.prototype.hide = function() {
this.hidden || (this.layerElement.style.display = "none", this.hidden = !0);
}, j.prototype.show = function() {
this.isVisible && !this.isTransparent && (this.hidden = !1, this.layerElement.style.display = "block");
}, k(j, O), O.prototype.identityMatrix = new b(), O.prototype.lcEnum = {
1: "butt",
2: "round",
3: "square"
}, O.prototype.ljEnum = {
1: "miter",
2: "round",
3: "butt"
}, O.prototype.searchProcessedElement = function(t) {
for (var e = this.processedElements.length; e; ) if (e -= 1, this.processedElements[e].elem === t) return this.processedElements[e].pos;
return 0;
}, O.prototype.addProcessedElement = function(t, e) {
for (var i = this.processedElements.length; i; ) if (i -= 1, this.processedElements[i].elem === t) {
this.processedElements[i].pos = e;
break;
}
0 === i && this.processedElements.push({
elem: t,
pos: e
});
}, O.prototype.buildExpressionInterface = function() {}, O.prototype.createElements = function() {
this._parent.createElements.call(this), this.searchShapes(this.shapesData, this.itemsData, this.prevViewData, this.layerElement, this.dynamicProperties, 0, [], !0), 
(!this.data.hd || this.data.td) && s(this.layerElement);
}, O.prototype.setGradientData = function(t, e, i) {
var s, r = "gr_" + f(10);
s = 1 === e.t ? document.createElementNS(Ee, "linearGradient") : document.createElementNS(Ee, "radialGradient"), 
s.setAttribute("id", r), s.setAttribute("spreadMethod", "pad"), s.setAttribute("gradientUnits", "userSpaceOnUse");
var n, a, o, h = [];
for (o = 4 * e.g.p, a = 0; o > a; a += 4) n = document.createElementNS(Ee, "stop"), 
s.appendChild(n), h.push(n);
t.setAttribute("gf" === e.ty ? "fill" : "stroke", "url(#" + r + ")"), this.globalData.defs.appendChild(s), 
i.gf = s, i.cst = h;
}, O.prototype.setGradientOpacity = function(t, e, i) {
if (t.g.k.k[0].s && t.g.k.k[0].s.length > 4 * t.g.p || t.g.k.k.length > 4 * t.g.p) {
var s, r, n, a, o = document.createElementNS(Ee, "mask"), h = document.createElementNS(Ee, "path");
o.appendChild(h);
var l = "op_" + f(10), p = "mk_" + f(10);
o.setAttribute("id", p), s = 1 === t.t ? document.createElementNS(Ee, "linearGradient") : document.createElementNS(Ee, "radialGradient"), 
s.setAttribute("id", l), s.setAttribute("spreadMethod", "pad"), s.setAttribute("gradientUnits", "userSpaceOnUse"), 
a = t.g.k.k[0].s ? t.g.k.k[0].s.length : t.g.k.k.length;
var c = [];
for (n = 4 * t.g.p; a > n; n += 2) r = document.createElementNS(Ee, "stop"), r.setAttribute("stop-color", "rgb(255,255,255)"), 
s.appendChild(r), c.push(r);
return h.setAttribute("gf" === t.ty ? "fill" : "stroke", "url(#" + l + ")"), this.globalData.defs.appendChild(s), 
this.globalData.defs.appendChild(o), e.of = s, e.ost = c, i.msElem = h, p;
}
}, O.prototype.createStyleElement = function(t, e, i) {
var s = {}, r = {
data: t,
type: t.ty,
d: "",
ld: "",
lvl: e,
mdf: !1,
closed: !1
}, n = document.createElementNS(Ee, "path");
if (s.o = Re.getProp(this, t.o, 0, .01, i), ("st" == t.ty || "gs" == t.ty) && (n.setAttribute("stroke-linecap", this.lcEnum[t.lc] || "round"), 
n.setAttribute("stroke-linejoin", this.ljEnum[t.lj] || "round"), n.setAttribute("fill-opacity", "0"), 
1 == t.lj && n.setAttribute("stroke-miterlimit", t.ml), s.w = Re.getProp(this, t.w, 0, null, i), 
t.d)) {
var a = Re.getDashProp(this, t.d, "svg", i);
a.k || (n.setAttribute("stroke-dasharray", a.dasharray), n.setAttribute("stroke-dashoffset", a.dashoffset)), 
s.d = a;
}
if ("fl" == t.ty || "st" == t.ty) s.c = Re.getProp(this, t.c, 1, 255, i); else {
s.g = Re.getGradientProp(this, t.g, i), 2 == t.t && (s.h = Re.getProp(this, t.h, 1, .01, i), 
s.a = Re.getProp(this, t.a, 1, Te, i)), s.s = Re.getProp(this, t.s, 1, null, i), 
s.e = Re.getProp(this, t.e, 1, null, i), this.setGradientData(n, t, s, r);
var o = this.setGradientOpacity(t, s, r);
o && n.setAttribute("mask", "url(#" + o + ")");
}
return s.elem = n, 2 === t.r && n.setAttribute("fill-rule", "evenodd"), t.ln && n.setAttribute("id", t.ln), 
t.cl && n.setAttribute("class", t.cl), r.pElem = n, this.stylesList.push(r), s.style = r, 
s;
}, O.prototype.createGroupElement = function(t) {
var e = {
it: [],
prevViewData: []
}, i = document.createElementNS(Ee, "g");
return e.gr = i, t.ln && e.gr.setAttribute("id", t.ln), e;
}, O.prototype.createTransformElement = function(t, e) {
var i = {
transform: {
op: Re.getProp(this, t.o, 0, .01, e),
mProps: Re.getProp(this, t, 2, null, e)
},
elements: []
};
return i;
}, O.prototype.createShapeElement = function(t, e, i, s) {
var r = {
elements: [],
caches: [],
styles: [],
transformers: e,
lStr: ""
}, n = 4;
return "rc" == t.ty ? n = 5 : "el" == t.ty ? n = 6 : "sr" == t.ty && (n = 7), r.sh = Ve.getShapeProp(this, t, n, s), 
r.lvl = i, this.shapes.push(r.sh), this.addShapeToModifiers(r), r;
}, O.prototype.setElementStyles = function() {
var t, e = this.stylesList.length, i = [];
for (t = 0; e > t; t += 1) this.stylesList[t].closed || i.push(this.stylesList[t]);
return i;
}, O.prototype.reloadShapes = function() {
this.firstFrame = !0;
var t, e = this.itemsData.length;
for (t = 0; e > t; t += 1) this.prevViewData[t] = this.itemsData[t];
this.searchShapes(this.shapesData, this.itemsData, this.prevViewData, this.layerElement, this.dynamicProperties, 0, [], !0);
var t, e = this.dynamicProperties.length;
for (t = 0; e > t; t += 1) this.dynamicProperties[t].getValue();
this.renderModifiers();
}, O.prototype.searchShapes = function(t, e, i, s, r, n, a, o) {
var h, l, p, c, f, u, d = [].concat(a), m = t.length - 1, g = [], v = [];
for (h = m; h >= 0; h -= 1) {
if (u = this.searchProcessedElement(t[h]), u ? e[h] = i[u - 1] : t[h]._render = o, 
"fl" == t[h].ty || "st" == t[h].ty || "gf" == t[h].ty || "gs" == t[h].ty) u ? e[h].style.closed = !1 : e[h] = this.createStyleElement(t[h], n, r), 
t[h]._render && s.appendChild(e[h].elem), g.push(e[h].style); else if ("gr" == t[h].ty) {
if (u) for (p = e[h].it.length, l = 0; p > l; l += 1) e[h].prevViewData[l] = e[h].it[l]; else e[h] = this.createGroupElement(t[h]);
this.searchShapes(t[h].it, e[h].it, e[h].prevViewData, e[h].gr, r, n + 1, d, o), 
t[h]._render && s.appendChild(e[h].gr);
} else "tr" == t[h].ty ? (u || (e[h] = this.createTransformElement(t[h], r)), c = e[h].transform, 
d.push(c)) : "sh" == t[h].ty || "rc" == t[h].ty || "el" == t[h].ty || "sr" == t[h].ty ? (u || (e[h] = this.createShapeElement(t[h], d, n, r)), 
e[h].elements = this.setElementStyles()) : "tm" == t[h].ty || "rd" == t[h].ty || "ms" == t[h].ty ? (u ? (f = e[h], 
f.closed = !1) : (f = ze.getModifier(t[h].ty), f.init(this, t[h], r), e[h] = f, 
this.shapeModifiers.push(f)), v.push(f)) : "rp" == t[h].ty && (u ? (f = e[h], f.closed = !0) : (f = ze.getModifier(t[h].ty), 
e[h] = f, f.init(this, t, h, e, r), this.shapeModifiers.push(f), o = !1), v.push(f));
this.addProcessedElement(t[h], h + 1);
}
for (m = g.length, h = 0; m > h; h += 1) g[h].closed = !0;
for (m = v.length, h = 0; m > h; h += 1) v[h].closed = !0;
}, O.prototype.addShapeToModifiers = function(t) {
var e, i = this.shapeModifiers.length;
for (e = 0; i > e; e += 1) this.shapeModifiers[e].addShape(t);
}, O.prototype.renderModifiers = function() {
if (this.shapeModifiers.length) {
var t, e = this.shapes.length;
for (t = 0; e > t; t += 1) this.shapes[t].reset();
for (e = this.shapeModifiers.length, t = e - 1; t >= 0; t -= 1) this.shapeModifiers[t].processShapes(this.firstFrame);
}
}, O.prototype.renderFrame = function(t) {
var e = this._parent.renderFrame.call(this, t);
if (e === !1) return void this.hide();
this.hidden && (this.layerElement.style.display = "block", this.hidden = !1), this.renderModifiers();
var i, s = this.stylesList.length;
for (i = 0; s > i; i += 1) this.stylesList[i].d = "", this.stylesList[i].mdf = !1;
for (this.renderShape(this.shapesData, this.itemsData, null), i = 0; s > i; i += 1) "0" === this.stylesList[i].ld && (this.stylesList[i].ld = "1", 
this.stylesList[i].pElem.style.display = "block"), (this.stylesList[i].mdf || this.firstFrame) && (this.stylesList[i].pElem.setAttribute("d", this.stylesList[i].d), 
this.stylesList[i].msElem && this.stylesList[i].msElem.setAttribute("d", this.stylesList[i].d));
this.firstFrame && (this.firstFrame = !1);
}, O.prototype.hide = function() {
if (!this.hidden) {
this.layerElement.style.display = "none";
var t, e = this.stylesList.length;
for (t = e - 1; t >= 0; t -= 1) "0" !== this.stylesList[t].ld && (this.stylesList[t].ld = "0", 
this.stylesList[t].pElem.style.display = "none", this.stylesList[t].pElem.parentNode && (this.stylesList[t].parent = this.stylesList[t].pElem.parentNode));
this.hidden = !0;
}
}, O.prototype.renderShape = function(t, e, i) {
var s, r, n = t.length - 1;
for (s = n; s >= 0; s -= 1) r = t[s].ty, "tr" == r ? ((this.firstFrame || e[s].transform.op.mdf && i) && i.setAttribute("opacity", e[s].transform.op.v), 
(this.firstFrame || e[s].transform.mProps.mdf && i) && i.setAttribute("transform", e[s].transform.mProps.v.to2dCSS())) : "sh" == r || "el" == r || "rc" == r || "sr" == r ? this.renderPath(t[s], e[s]) : "fl" == r ? this.renderFill(t[s], e[s]) : "gf" == r ? this.renderGradient(t[s], e[s]) : "gs" == r ? (this.renderGradient(t[s], e[s]), 
this.renderStroke(t[s], e[s])) : "st" == r ? this.renderStroke(t[s], e[s]) : "gr" == r && this.renderShape(t[s].it, e[s].it, e[s].gr);
}, O.prototype.buildShapeString = function(t, e, i, s) {
var r, n = "";
for (r = 1; e > r; r += 1) 1 === r && (n += " M" + s.applyToPointStringified(t.v[0][0], t.v[0][1])), 
n += " C" + s.applyToPointStringified(t.o[r - 1][0], t.o[r - 1][1]) + " " + s.applyToPointStringified(t.i[r][0], t.i[r][1]) + " " + s.applyToPointStringified(t.v[r][0], t.v[r][1]);
return 1 === e && (n += " M" + s.applyToPointStringified(t.v[0][0], t.v[0][1])), 
i && e && (n += " C" + s.applyToPointStringified(t.o[r - 1][0], t.o[r - 1][1]) + " " + s.applyToPointStringified(t.i[0][0], t.i[0][1]) + " " + s.applyToPointStringified(t.v[0][0], t.v[0][1]), 
n += "z"), n;
}, O.prototype.renderPath = function(t, e) {
var i, s, r, n, a, o, h = e.elements.length, l = e.lvl;
if (t._render) for (o = 0; h > o; o += 1) if (e.elements[o].data._render) {
n = e.sh.mdf || this.firstFrame, r = "M0 0";
var p = e.sh.paths;
if (s = p._length, e.elements[o].lvl < l) {
for (var c, f = this.mHelper.reset(), u = l - e.elements[o].lvl, d = e.transformers.length - 1; u > 0; ) n = e.transformers[d].mProps.mdf || n, 
c = e.transformers[d].mProps.v.props, f.transform(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11], c[12], c[13], c[14], c[15]), 
u--, d--;
if (n) {
for (i = 0; s > i; i += 1) a = p.shapes[i], a && a._length && (r += this.buildShapeString(a, a._length, a.c, f));
e.caches[o] = r;
} else r = e.caches[o];
} else if (n) {
for (i = 0; s > i; i += 1) a = p.shapes[i], a && a._length && (r += this.buildShapeString(a, a._length, a.c, this.identityMatrix));
e.caches[o] = r;
} else r = e.caches[o];
e.elements[o].d += r, e.elements[o].mdf = n || e.elements[o].mdf;
} else e.elements[o].mdf = !0;
}, O.prototype.renderFill = function(t, e) {
var i = e.style;
(e.c.mdf || this.firstFrame) && i.pElem.setAttribute("fill", "rgb(" + _e(e.c.v[0]) + "," + _e(e.c.v[1]) + "," + _e(e.c.v[2]) + ")"), 
(e.o.mdf || this.firstFrame) && i.pElem.setAttribute("fill-opacity", e.o.v);
}, O.prototype.renderGradient = function(t, e) {
var i = e.gf, s = e.of, r = e.s.v, n = e.e.v;
if (e.o.mdf || this.firstFrame) {
var a = "gf" === t.ty ? "fill-opacity" : "stroke-opacity";
e.elem.setAttribute(a, e.o.v);
}
if (e.s.mdf || this.firstFrame) {
var o = 1 === t.t ? "x1" : "cx", h = "x1" === o ? "y1" : "cy";
i.setAttribute(o, r[0]), i.setAttribute(h, r[1]), s && (s.setAttribute(o, r[0]), 
s.setAttribute(h, r[1]));
}
var l, p, c, f;
if (e.g.cmdf || this.firstFrame) {
l = e.cst;
var u = e.g.c;
for (c = l.length, p = 0; c > p; p += 1) f = l[p], f.setAttribute("offset", u[4 * p] + "%"), 
f.setAttribute("stop-color", "rgb(" + u[4 * p + 1] + "," + u[4 * p + 2] + "," + u[4 * p + 3] + ")");
}
if (s && (e.g.omdf || this.firstFrame)) {
l = e.ost;
var d = e.g.o;
for (c = l.length, p = 0; c > p; p += 1) f = l[p], f.setAttribute("offset", d[2 * p] + "%"), 
f.setAttribute("stop-opacity", d[2 * p + 1]);
}
if (1 === t.t) (e.e.mdf || this.firstFrame) && (i.setAttribute("x2", n[0]), i.setAttribute("y2", n[1]), 
s && (s.setAttribute("x2", n[0]), s.setAttribute("y2", n[1]))); else {
var m;
if ((e.s.mdf || e.e.mdf || this.firstFrame) && (m = Math.sqrt(Math.pow(r[0] - n[0], 2) + Math.pow(r[1] - n[1], 2)), 
i.setAttribute("r", m), s && s.setAttribute("r", m)), e.e.mdf || e.h.mdf || e.a.mdf || this.firstFrame) {
m || (m = Math.sqrt(Math.pow(r[0] - n[0], 2) + Math.pow(r[1] - n[1], 2)));
var g = Math.atan2(n[1] - r[1], n[0] - r[0]), v = e.h.v >= 1 ? .99 : e.h.v <= -1 ? -.99 : e.h.v, y = m * v, b = Math.cos(g + e.a.v) * y + r[0], k = Math.sin(g + e.a.v) * y + r[1];
i.setAttribute("fx", b), i.setAttribute("fy", k), s && (s.setAttribute("fx", b), 
s.setAttribute("fy", k));
}
}
}, O.prototype.renderStroke = function(t, e) {
var i = e.style, s = e.d;
s && s.k && (s.mdf || this.firstFrame) && (i.pElem.setAttribute("stroke-dasharray", s.dasharray), 
i.pElem.setAttribute("stroke-dashoffset", s.dashoffset)), e.c && (e.c.mdf || this.firstFrame) && i.pElem.setAttribute("stroke", "rgb(" + _e(e.c.v[0]) + "," + _e(e.c.v[1]) + "," + _e(e.c.v[2]) + ")"), 
(e.o.mdf || this.firstFrame) && i.pElem.setAttribute("stroke-opacity", e.o.v), (e.w.mdf || this.firstFrame) && (i.pElem.setAttribute("stroke-width", e.w.v), 
i.msElem && i.msElem.setAttribute("stroke-width", e.w.v));
}, O.prototype.destroy = function() {
this._parent.destroy.call(this._parent), this.shapeData = null, this.itemsData = null, 
this.parentContainer = null, this.placeholder = null;
}, R.prototype.init = function() {
this._frameId = -1, this.lettersChangedFlag = !0, this.currentTextDocumentData = this.data.t.d.k[0].s, 
this.dynamicProperties = this.dynamicProperties || [], this.textAnimator = new F(this.data.t, this.renderType, this), 
this._parent.init.call(this), this.textAnimator.searchProperties(this.dynamicProperties), 
this.buildNewText();
}, R.prototype.prepareFrame = function(t) {
if (this._frameId !== this.globalData.frameId) {
this._frameId = this.globalData.frameId;
for (var e = this.data.t.d.k, i = 0, s = e.length; s > i && (textDocumentData = e[i].s, 
i += 1, !(i === s || e[i].t > t)); ) ;
this.lettersChangedFlag = !1, textDocumentData !== this.currentTextDocumentData && (this.currentTextDocumentData = textDocumentData, 
this.lettersChangedFlag = !0, this.buildNewText()), this._parent.prepareFrame.call(this, t);
}
}, R.prototype.createPathShape = function(t, e) {
var i, s, r = e.length, n = "";
for (i = 0; r > i; i += 1) s = e[i].ks.k, n += this.buildShapeString(s, s.i.length, !0, t);
return n;
}, R.prototype.buildShapeString = O.prototype.buildShapeString, R.prototype.emptyProp = new T(), 
k(j, V), V.prototype.init = R.prototype.init, V.prototype.createPathShape = R.prototype.createPathShape, 
V.prototype.prepareFrame = R.prototype.prepareFrame, V.prototype.buildShapeString = R.prototype.buildShapeString, 
V.prototype.createElements = function() {
this._parent.createElements.call(this), this.data.ln && this.layerElement.setAttribute("id", this.data.ln), 
this.data.cl && this.layerElement.setAttribute("class", this.data.cl);
}, V.prototype.buildNewText = function() {
var t, e, i = this.currentTextDocumentData;
this.renderedLetters = Array.apply(null, {
length: this.currentTextDocumentData.l ? this.currentTextDocumentData.l.length : 0
}), i.fc ? this.layerElement.setAttribute("fill", "rgb(" + Math.round(255 * i.fc[0]) + "," + Math.round(255 * i.fc[1]) + "," + Math.round(255 * i.fc[2]) + ")") : this.layerElement.setAttribute("fill", "rgba(0,0,0,0)"), 
i.sc && (this.layerElement.setAttribute("stroke", "rgb(" + Math.round(255 * i.sc[0]) + "," + Math.round(255 * i.sc[1]) + "," + Math.round(255 * i.sc[2]) + ")"), 
this.layerElement.setAttribute("stroke-width", i.sw)), this.layerElement.setAttribute("font-size", i.s);
var s = this.globalData.fontManager.getFontByName(i.f);
if (s.fClass) this.layerElement.setAttribute("class", s.fClass); else {
this.layerElement.setAttribute("font-family", s.fFamily);
var r = i.fWeight, n = i.fStyle;
this.layerElement.setAttribute("font-style", n), this.layerElement.setAttribute("font-weight", r);
}
var a = i.l || [];
if (e = a.length) {
var o, h, l = this.mHelper, p = "", c = this.data.singleShape;
if (c) var f = 0, u = 0, d = i.lineWidths, m = i.boxWidth, g = !0, v = i.tr / 1e3 * i.s;
var y = 0;
for (t = 0; e > t; t += 1) {
if (this.globalData.fontManager.chars ? c && 0 !== t || (o = this.textSpans[y] ? this.textSpans[y] : document.createElementNS(Ee, "path")) : o = this.textSpans[y] ? this.textSpans[y] : document.createElementNS(Ee, "text"), 
o.style.display = "inherit", o.setAttribute("stroke-linecap", "butt"), o.setAttribute("stroke-linejoin", "round"), 
o.setAttribute("stroke-miterlimit", "4"), c && a[t].n && (f = -v, u += i.yOffset, 
u += g ? 1 : 0, g = !1), l.reset(), this.globalData.fontManager.chars && l.scale(i.s / 100, i.s / 100), 
c) {
switch (i.ps && l.translate(i.ps[0], i.ps[1] + i.ascent, 0), l.translate(0, -i.ls, 0), 
i.j) {
case 1:
l.translate(i.justifyOffset + (m - d[a[t].line]), 0, 0);
break;

case 2:
l.translate(i.justifyOffset + (m - d[a[t].line]) / 2, 0, 0);
}
l.translate(f, u, 0);
}
if (this.globalData.fontManager.chars) {
var b, k = this.globalData.fontManager.getCharData(i.t.charAt(t), s.fStyle, this.globalData.fontManager.getFontByName(i.f).fFamily);
b = k ? k.data : null, b && b.shapes && (h = b.shapes[0].it, c || (p = ""), p += this.createPathShape(l, h), 
c || o.setAttribute("d", p)), c || this.layerElement.appendChild(o);
} else o.textContent = a[t].val, o.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:space", "preserve"), 
this.layerElement.appendChild(o), c && o.setAttribute("transform", l.to2dCSS());
c && (f += a[t].l || 0, f += v), this.textSpans[y] = o, y += 1;
}
if (!c) for (;y < this.textSpans.length; ) this.textSpans[y].style.display = "none", 
y += 1;
c && this.globalData.fontManager.chars && (o.setAttribute("d", p), this.layerElement.appendChild(o)), 
this._sizeChanged = !0;
}
}, V.prototype.sourceRectAtTime = function() {
if (this.prepareFrame(this.comp.renderedFrame - this.data.st), this.renderLetters(), 
this._sizeChanged) {
this._sizeChanged = !1;
var t = this.layerElement.getBBox();
this.bbox = {
top: t.y,
left: t.x,
width: t.width,
height: t.height
};
}
return this.bbox;
}, V.prototype.renderLetters = function() {
if (!this.data.singleShape && (this.textAnimator.getMeasures(this.currentTextDocumentData, this.lettersChangedFlag), 
this.lettersChangedFlag || this.textAnimator.lettersChangedFlag)) {
this._sizeChanged = !0;
var t, e, i = 0, s = this.textAnimator.renderedLetters, r = this.currentTextDocumentData.l;
e = r.length;
var n;
for (t = 0; e > t; t += 1) r[t].n || (n = s[i], i += 1, n.mdf.m && this.textSpans[t].setAttribute("transform", n.m), 
n.mdf.o && this.textSpans[t].setAttribute("opacity", n.o), n.mdf.sw && this.textSpans[t].setAttribute("stroke-width", n.sw), 
n.mdf.sc && this.textSpans[t].setAttribute("stroke", n.sc), n.mdf.fc && this.textSpans[t].setAttribute("fill", n.fc));
}
}, V.prototype.renderFrame = function(t) {
var e = this._parent.renderFrame.call(this, t);
return e === !1 ? void this.hide() : (this.hidden && this.show(), this.firstFrame && (this.firstFrame = !1), 
void this.renderLetters());
}, V.prototype.destroy = function() {
this._parent.destroy.call(this._parent);
}, z.prototype.renderFrame = function(t) {
if (t || this.filterManager.mdf) {
var e = this.filterManager.effectElements[0].p.v, i = this.filterManager.effectElements[1].p.v, s = this.filterManager.effectElements[2].p.v / 100;
this.matrixFilter.setAttribute("values", i[0] - e[0] + " 0 0 0 " + e[0] + " " + (i[1] - e[1]) + " 0 0 0 " + e[1] + " " + (i[2] - e[2]) + " 0 0 0 " + e[2] + " 0 0 0 " + s + " 0");
}
}, B.prototype.renderFrame = function(t) {
if (t || this.filterManager.mdf) {
var e = this.filterManager.effectElements[2].p.v, i = this.filterManager.effectElements[6].p.v;
this.matrixFilter.setAttribute("values", "0 0 0 0 " + e[0] + " 0 0 0 0 " + e[1] + " 0 0 0 0 " + e[2] + " 0 0 0 " + i + " 0");
}
}, q.prototype.initialize = function() {
var t, e, i, s, r = this.elem.layerElement.children || this.elem.layerElement.childNodes;
for (1 === this.filterManager.effectElements[1].p.v ? (s = this.elem.maskManager.masksProperties.length, 
i = 0) : (i = this.filterManager.effectElements[0].p.v - 1, s = i + 1), e = document.createElementNS(Ee, "g"), 
e.setAttribute("fill", "none"), e.setAttribute("stroke-linecap", "round"), e.setAttribute("stroke-dashoffset", 1), 
i; s > i; i += 1) t = document.createElementNS(Ee, "path"), e.appendChild(t), this.paths.push({
p: t,
m: i
});
if (3 === this.filterManager.effectElements[10].p.v) {
var n = document.createElementNS(Ee, "mask"), a = "stms_" + f(10);
n.setAttribute("id", a), n.setAttribute("mask-type", "alpha"), n.appendChild(e), 
this.elem.globalData.defs.appendChild(n);
var o = document.createElementNS(Ee, "g");
o.setAttribute("mask", "url(" + we + "#" + a + ")"), r[0] && o.appendChild(r[0]), 
this.elem.layerElement.appendChild(o), this.masker = n, e.setAttribute("stroke", "#fff");
} else if (1 === this.filterManager.effectElements[10].p.v || 2 === this.filterManager.effectElements[10].p.v) {
if (2 === this.filterManager.effectElements[10].p.v) for (var r = this.elem.layerElement.children || this.elem.layerElement.childNodes; r.length; ) this.elem.layerElement.removeChild(r[0]);
this.elem.layerElement.appendChild(e), this.elem.layerElement.removeAttribute("mask"), 
e.setAttribute("stroke", "#fff");
}
this.initialized = !0, this.pathMasker = e;
}, q.prototype.renderFrame = function(t) {
this.initialized || this.initialize();
var e, i, s, r = this.paths.length;
for (e = 0; r > e; e += 1) if (i = this.elem.maskManager.viewData[this.paths[e].m], 
s = this.paths[e].p, (t || this.filterManager.mdf || i.prop.mdf) && s.setAttribute("d", i.lastPath), 
t || this.filterManager.effectElements[9].p.mdf || this.filterManager.effectElements[4].p.mdf || this.filterManager.effectElements[7].p.mdf || this.filterManager.effectElements[8].p.mdf || i.prop.mdf) {
var n;
if (0 !== this.filterManager.effectElements[7].p.v || 100 !== this.filterManager.effectElements[8].p.v) {
var a = Math.min(this.filterManager.effectElements[7].p.v, this.filterManager.effectElements[8].p.v) / 100, o = Math.max(this.filterManager.effectElements[7].p.v, this.filterManager.effectElements[8].p.v) / 100, h = s.getTotalLength();
n = "0 0 0 " + h * a + " ";
var l, p = h * (o - a), c = 1 + 2 * this.filterManager.effectElements[4].p.v * this.filterManager.effectElements[9].p.v / 100, f = Math.floor(p / c);
for (l = 0; f > l; l += 1) n += "1 " + 2 * this.filterManager.effectElements[4].p.v * this.filterManager.effectElements[9].p.v / 100 + " ";
n += "0 " + 10 * h + " 0 0";
} else n = "1 " + 2 * this.filterManager.effectElements[4].p.v * this.filterManager.effectElements[9].p.v / 100;
s.setAttribute("stroke-dasharray", n);
}
if ((t || this.filterManager.effectElements[4].p.mdf) && this.pathMasker.setAttribute("stroke-width", 2 * this.filterManager.effectElements[4].p.v), 
(t || this.filterManager.effectElements[6].p.mdf) && this.pathMasker.setAttribute("opacity", this.filterManager.effectElements[6].p.v), 
(1 === this.filterManager.effectElements[10].p.v || 2 === this.filterManager.effectElements[10].p.v) && (t || this.filterManager.effectElements[3].p.mdf)) {
var u = this.filterManager.effectElements[3].p.v;
this.pathMasker.setAttribute("stroke", "rgb(" + _e(255 * u[0]) + "," + _e(255 * u[1]) + "," + _e(255 * u[2]) + ")");
}
}, U.prototype.renderFrame = function(t) {
if (t || this.filterManager.mdf) {
var e = this.filterManager.effectElements[0].p.v, i = this.filterManager.effectElements[1].p.v, s = this.filterManager.effectElements[2].p.v, r = s[0] + " " + i[0] + " " + e[0], n = s[1] + " " + i[1] + " " + e[1], a = s[2] + " " + i[2] + " " + e[2];
this.feFuncR.setAttribute("tableValues", r), this.feFuncG.setAttribute("tableValues", n), 
this.feFuncB.setAttribute("tableValues", a);
}
}, G.prototype.createFeFunc = function(t, e) {
var i = document.createElementNS(Ee, t);
return i.setAttribute("type", "table"), e.appendChild(i), i;
}, G.prototype.getTableValue = function(t, e, i, s, r) {
for (var n, a, o = 0, h = 256, l = Math.min(t, e), p = Math.max(t, e), c = Array.call(null, {
length: h
}), f = 0, u = r - s, d = e - t; 256 >= o; ) n = o / 256, a = l >= n ? 0 > d ? r : s : n >= p ? 0 > d ? s : r : s + u * Math.pow((n - t) / d, 1 / i), 
c[f++] = a, o += 256 / (h - 1);
return c.join(" ");
}, G.prototype.renderFrame = function(t) {
if (t || this.filterManager.mdf) {
var e, i = this.filterManager.effectElements;
this.feFuncRComposed && (t || i[2].p.mdf || i[3].p.mdf || i[4].p.mdf || i[5].p.mdf || i[6].p.mdf) && (e = this.getTableValue(i[2].p.v, i[3].p.v, i[4].p.v, i[5].p.v, i[6].p.v), 
this.feFuncRComposed.setAttribute("tableValues", e), this.feFuncGComposed.setAttribute("tableValues", e), 
this.feFuncBComposed.setAttribute("tableValues", e)), this.feFuncR && (t || i[9].p.mdf || i[10].p.mdf || i[11].p.mdf || i[12].p.mdf || i[13].p.mdf) && (e = this.getTableValue(i[9].p.v, i[10].p.v, i[11].p.v, i[12].p.v, i[13].p.v), 
this.feFuncR.setAttribute("tableValues", e)), this.feFuncG && (t || i[16].p.mdf || i[17].p.mdf || i[18].p.mdf || i[19].p.mdf || i[20].p.mdf) && (e = this.getTableValue(i[16].p.v, i[17].p.v, i[18].p.v, i[19].p.v, i[20].p.v), 
this.feFuncG.setAttribute("tableValues", e)), this.feFuncB && (t || i[23].p.mdf || i[24].p.mdf || i[25].p.mdf || i[26].p.mdf || i[27].p.mdf) && (e = this.getTableValue(i[23].p.v, i[24].p.v, i[25].p.v, i[26].p.v, i[27].p.v), 
this.feFuncB.setAttribute("tableValues", e)), this.feFuncA && (t || i[30].p.mdf || i[31].p.mdf || i[32].p.mdf || i[33].p.mdf || i[34].p.mdf) && (e = this.getTableValue(i[30].p.v, i[31].p.v, i[32].p.v, i[33].p.v, i[34].p.v), 
this.feFuncA.setAttribute("tableValues", e));
}
}, H.prototype.renderFrame = function(t) {
if (t || this.filterManager.mdf) {
if ((t || this.filterManager.effectElements[4].p.mdf) && this.feGaussianBlur.setAttribute("stdDeviation", this.filterManager.effectElements[4].p.v / 4), 
t || this.filterManager.effectElements[0].p.mdf) {
var e = this.filterManager.effectElements[0].p.v;
this.feFlood.setAttribute("flood-color", Ie(Math.round(255 * e[0]), Math.round(255 * e[1]), Math.round(255 * e[2])));
}
if ((t || this.filterManager.effectElements[1].p.mdf) && this.feFlood.setAttribute("flood-opacity", this.filterManager.effectElements[1].p.v / 255), 
t || this.filterManager.effectElements[2].p.mdf || this.filterManager.effectElements[3].p.mdf) {
var i = this.filterManager.effectElements[3].p.v, s = (this.filterManager.effectElements[2].p.v - 90) * Te, r = i * Math.cos(s), n = i * Math.sin(s);
this.feOffset.setAttribute("dx", r), this.feOffset.setAttribute("dy", n);
}
}
}, W.prototype.setElementAsMask = function(t, e) {
var i = document.createElementNS(Ee, "mask");
i.setAttribute("id", e.layerId), i.setAttribute("mask-type", "alpha"), i.appendChild(e.layerElement), 
t.setMatte(e.layerId), e.data.hd = !1;
var s = t.globalData.defs;
s.appendChild(i);
}, W.prototype.initialize = function() {
for (var t = this.filterManager.effectElements[0].p.v, e = 0, i = this.elem.comp.elements.length; i > e; ) this.elem.comp.elements[e].data.ind === t && this.setElementAsMask(this.elem, this.elem.comp.elements[e]), 
e += 1;
this.initialized = !0;
}, W.prototype.renderFrame = function() {
this.initialized || this.initialize();
}, X.prototype.renderFrame = function(t) {
var e, i = this.filters.length;
for (e = 0; i > e; e += 1) this.filters[e].renderFrame(t);
}, k(j, J), J.prototype.hide = function() {
if (!this.hidden) {
this._parent.hide.call(this);
var t, e = this.elements.length;
for (t = 0; e > t; t += 1) this.elements[t] && this.elements[t].hide();
}
}, J.prototype.prepareFrame = function(t) {
if (this._parent.prepareFrame.call(this, t), this.isVisible !== !1 || this.data.xt) {
if (this.tm) {
var e = this.tm.v;
e === this.data.op && (e = this.data.op - 1), this.renderedFrame = e;
} else this.renderedFrame = t / this.data.sr;
var i, s = this.elements.length;
for (this.completeLayers || this.checkLayers(this.renderedFrame), i = 0; s > i; i += 1) (this.completeLayers || this.elements[i]) && this.elements[i].prepareFrame(this.renderedFrame - this.layers[i].st);
}
}, J.prototype.renderFrame = function(t) {
var e, i = this._parent.renderFrame.call(this, t), s = this.layers.length;
if (i === !1) return void this.hide();
for (this.hidden && this.show(), e = 0; s > e; e += 1) (this.completeLayers || this.elements[e]) && this.elements[e].renderFrame();
this.firstFrame && (this.firstFrame = !1);
}, J.prototype.setElements = function(t) {
this.elements = t;
}, J.prototype.getElements = function() {
return this.elements;
}, J.prototype.destroy = function() {
this._parent.destroy.call(this._parent);
var t, e = this.layers.length;
for (t = 0; e > t; t += 1) this.elements[t] && this.elements[t].destroy();
}, J.prototype.checkLayers = I.prototype.checkLayers, J.prototype.buildItem = I.prototype.buildItem, 
J.prototype.buildAllItems = I.prototype.buildAllItems, J.prototype.buildElementParenting = I.prototype.buildElementParenting, 
J.prototype.createItem = I.prototype.createItem, J.prototype.createImage = I.prototype.createImage, 
J.prototype.createComp = I.prototype.createComp, J.prototype.createSolid = I.prototype.createSolid, 
J.prototype.createShape = I.prototype.createShape, J.prototype.createText = I.prototype.createText, 
J.prototype.createBase = I.prototype.createBase, J.prototype.appendElementInPos = I.prototype.appendElementInPos, 
J.prototype.checkPendingElements = I.prototype.checkPendingElements, J.prototype.addPendingElement = I.prototype.addPendingElement, 
k(j, $), $.prototype.createElements = function() {
var t = this.globalData.getAssetsPath(this.assetData);
this._parent.createElements.call(this), this.innerElem = document.createElementNS(Ee, "image"), 
this.innerElem.setAttribute("width", this.assetData.w + "px"), this.innerElem.setAttribute("height", this.assetData.h + "px"), 
this.innerElem.setAttribute("preserveAspectRatio", "xMidYMid slice"), this.innerElem.setAttributeNS("http://www.w3.org/1999/xlink", "href", t), 
this.maskedElement = this.innerElem, this.layerElement.appendChild(this.innerElem), 
this.data.ln && this.layerElement.setAttribute("id", this.data.ln), this.data.cl && this.layerElement.setAttribute("class", this.data.cl);
}, $.prototype.renderFrame = function(t) {
var e = this._parent.renderFrame.call(this, t);
return e === !1 ? void this.hide() : (this.hidden && this.show(), void (this.firstFrame && (this.firstFrame = !1)));
}, $.prototype.destroy = function() {
this._parent.destroy.call(this._parent), this.innerElem = null;
}, k(j, Y), Y.prototype.createElements = function() {
this._parent.createElements.call(this);
var t = document.createElementNS(Ee, "rect");
t.setAttribute("width", this.data.sw), t.setAttribute("height", this.data.sh), t.setAttribute("fill", this.data.sc), 
this.layerElement.appendChild(t), this.innerElem = t, this.data.ln && this.layerElement.setAttribute("id", this.data.ln), 
this.data.cl && this.layerElement.setAttribute("class", this.data.cl);
}, Y.prototype.renderFrame = $.prototype.renderFrame, Y.prototype.destroy = $.prototype.destroy;
var Je = function() {
function t(t) {
for (var e = 0, i = t.target; S > e; ) w[e].animation === i && (w.splice(e, 1), 
e -= 1, S -= 1, i.isPaused || s()), e += 1;
}
function e(t, e) {
if (!t) return null;
for (var i = 0; S > i; ) {
if (w[i].elem == t && null !== w[i].elem) return w[i].animation;
i += 1;
}
var s = new $e();
return r(s, t), s.setData(t, e), s;
}
function i() {
x += 1, k();
}
function s() {
x -= 1, 0 === x && (P = !0);
}
function r(e, r) {
e.addEventListener("destroy", t), e.addEventListener("_active", i), e.addEventListener("_idle", s), 
w.push({
elem: r,
animation: e
}), S += 1;
}
function n(t) {
var e = new $e();
return r(e, null), e.setParams(t), e;
}
function a(t, e) {
var i;
for (i = 0; S > i; i += 1) w[i].animation.setSpeed(t, e);
}
function o(t, e) {
var i;
for (i = 0; S > i; i += 1) w[i].animation.setDirection(t, e);
}
function h(t) {
var e;
for (e = 0; S > e; e += 1) w[e].animation.play(t);
}
function l(t, e) {
A = Date.now();
var i;
for (i = 0; S > i; i += 1) w[i].animation.moveFrame(t, e);
}
function p(t) {
var e, i = t - A;
for (e = 0; S > e; e += 1) w[e].animation.advanceTime(i);
A = t, P || requestAnimationFrame(p);
}
function c(t) {
A = t, requestAnimationFrame(p);
}
function f(t) {
var e;
for (e = 0; S > e; e += 1) w[e].animation.pause(t);
}
function u(t, e, i) {
var s;
for (s = 0; S > s; s += 1) w[s].animation.goToAndStop(t, e, i);
}
function d(t) {
var e;
for (e = 0; S > e; e += 1) w[e].animation.stop(t);
}
function m(t) {
var e;
for (e = 0; S > e; e += 1) w[e].animation.togglePause(t);
}
function g(t) {
var e;
for (e = S - 1; e >= 0; e -= 1) w[e].animation.destroy(t);
}
function v(t, i, s) {
var r, n = document.getElementsByClassName("bodymovin"), a = n.length;
for (r = 0; a > r; r += 1) s && n[r].setAttribute("data-bm-type", s), e(n[r], t);
if (i && 0 === a) {
s || (s = "svg");
var o = document.getElementsByTagName("body")[0];
o.innerHTML = "";
var h = document.createElement("div");
h.style.width = "100%", h.style.height = "100%", h.setAttribute("data-bm-type", s), 
o.appendChild(h), e(h, t);
}
}
function y() {
var t;
for (t = 0; S > t; t += 1) w[t].animation.resize();
}
function b() {
requestAnimationFrame(c);
}
function k() {
P && (P = !1, requestAnimationFrame(c));
}
var E = {}, w = [], A = 0, S = 0, P = !0, x = 0;
return setTimeout(b, 0), E.registerAnimation = e, E.loadAnimation = n, E.setSpeed = a, 
E.setDirection = o, E.play = h, E.moveFrame = l, E.pause = f, E.stop = d, E.togglePause = m, 
E.searchAnimations = v, E.resize = y, E.start = b, E.goToAndStop = u, E.destroy = g, 
E;
}(), $e = function() {
this._cbs = [], this.name = "", this.path = "", this.isLoaded = !1, this.currentFrame = 0, 
this.currentRawFrame = 0, this.totalFrames = 0, this.frameRate = 0, this.frameMult = 0, 
this.playSpeed = 1, this.playDirection = 1, this.pendingElements = 0, this.playCount = 0, 
this.prerenderFramesFlag = !0, this.animationData = {}, this.layers = [], this.assets = [], 
this.isPaused = !0, this.autoplay = !1, this.loop = !0, this.renderer = null, this.animationID = f(10), 
this.scaleMode = "fit", this.assetsPath = "", this.timeCompleted = 0, this.segmentPos = 0, 
this.subframeEnabled = Ae, this.segments = [], this.pendingSegment = !1, this._idle = !0, 
this.projectInterface = t();
};
$e.prototype.setParams = function(t) {
var e = this;
t.context && (this.context = t.context), (t.wrapper || t.container) && (this.wrapper = t.wrapper || t.container);
var i = t.animType ? t.animType : t.renderer ? t.renderer : "svg";
switch (i) {
case "canvas":
this.renderer = new CanvasRenderer(this, t.rendererSettings);
break;

case "svg":
this.renderer = new I(this, t.rendererSettings);
break;

case "hybrid":
case "html":
default:
this.renderer = new HybridRenderer(this, t.rendererSettings);
}
if (this.renderer.setProjectInterface(this.projectInterface), this.animType = i, 
"" === t.loop || null === t.loop || (this.loop = t.loop === !1 ? !1 : t.loop === !0 ? !0 : parseInt(t.loop)), 
this.autoplay = "autoplay" in t ? t.autoplay : !0, this.name = t.name ? t.name : "", 
this.prerenderFramesFlag = "prerender" in t ? t.prerender : !0, this.autoloadSegments = t.hasOwnProperty("autoloadSegments") ? t.autoloadSegments : !0, 
t.animationData) e.configAnimation(t.animationData); else if (t.path) {
"json" != t.path.substr(-4) && ("/" != t.path.substr(-1, 1) && (t.path += "/"), 
t.path += "data.json");
var s = document.createElement("script");
s.src = t.path, s.style.display = "none", s.onload = function() {
try {
e.configAnimation(lottieAnimationData), s.parentNode.removeChild(s);
} catch (t) {}
}, document.querySelector("body").appendChild(s);
}
}, $e.prototype.setData = function(t, e) {
var i = {
wrapper: t,
animationData: e ? "object" == typeof e ? e : JSON.parse(e) : null
}, s = t.attributes;
i.path = s.getNamedItem("data-animation-path") ? s.getNamedItem("data-animation-path").value : s.getNamedItem("data-bm-path") ? s.getNamedItem("data-bm-path").value : s.getNamedItem("bm-path") ? s.getNamedItem("bm-path").value : "", 
i.animType = s.getNamedItem("data-anim-type") ? s.getNamedItem("data-anim-type").value : s.getNamedItem("data-bm-type") ? s.getNamedItem("data-bm-type").value : s.getNamedItem("bm-type") ? s.getNamedItem("bm-type").value : s.getNamedItem("data-bm-renderer") ? s.getNamedItem("data-bm-renderer").value : s.getNamedItem("bm-renderer") ? s.getNamedItem("bm-renderer").value : "canvas";
var r = s.getNamedItem("data-anim-loop") ? s.getNamedItem("data-anim-loop").value : s.getNamedItem("data-bm-loop") ? s.getNamedItem("data-bm-loop").value : s.getNamedItem("bm-loop") ? s.getNamedItem("bm-loop").value : "";
"" === r || (i.loop = "false" === r ? !1 : "true" === r ? !0 : parseInt(r));
var n = s.getNamedItem("data-anim-autoplay") ? s.getNamedItem("data-anim-autoplay").value : s.getNamedItem("data-bm-autoplay") ? s.getNamedItem("data-bm-autoplay").value : s.getNamedItem("bm-autoplay") ? s.getNamedItem("bm-autoplay").value : !0;
i.autoplay = "false" !== n, i.name = s.getNamedItem("data-name") ? s.getNamedItem("data-name").value : s.getNamedItem("data-bm-name") ? s.getNamedItem("data-bm-name").value : s.getNamedItem("bm-name") ? s.getNamedItem("bm-name").value : "";
var a = s.getNamedItem("data-anim-prerender") ? s.getNamedItem("data-anim-prerender").value : s.getNamedItem("data-bm-prerender") ? s.getNamedItem("data-bm-prerender").value : s.getNamedItem("bm-prerender") ? s.getNamedItem("bm-prerender").value : "";
"false" === a && (i.prerender = !1), this.setParams(i);
}, $e.prototype.includeLayers = function(t) {
t.op > this.animationData.op && (this.animationData.op = t.op, this.totalFrames = Math.floor(t.op - this.animationData.ip), 
this.animationData.tf = this.totalFrames);
var e, i, s = this.animationData.layers, r = s.length, n = t.layers, a = n.length;
for (i = 0; a > i; i += 1) for (e = 0; r > e; ) {
if (s[e].id == n[i].id) {
s[e] = n[i];
break;
}
e += 1;
}
if ((t.chars || t.fonts) && (this.renderer.globalData.fontManager.addChars(t.chars), 
this.renderer.globalData.fontManager.addFonts(t.fonts, this.renderer.globalData.defs)), 
t.assets) for (r = t.assets.length, e = 0; r > e; e += 1) this.animationData.assets.push(t.assets[e]);
this.animationData.__complete = !1, je.completeData(this.animationData, this.renderer.globalData.fontManager), 
this.renderer.includeLayers(t.layers), be && be.initExpressions(this), this.renderer.renderFrame(null), 
this.loadNextSegment();
}, $e.prototype.loadNextSegment = function() {
var t = this.animationData.segments;
if (!t || 0 === t.length || !this.autoloadSegments) return this.trigger("data_ready"), 
void (this.timeCompleted = this.animationData.tf);
var e = t.shift();
this.timeCompleted = e.time * this.frameRate;
var i = new XMLHttpRequest(), s = this, r = this.path + this.fileName + "_" + this.segmentPos + ".json";
this.segmentPos += 1, i.open("GET", r, !0), i.send(), i.onreadystatechange = function() {
if (4 == i.readyState) if (200 == i.status) s.includeLayers(JSON.parse(i.responseText)); else try {
var t = JSON.parse(i.responseText);
s.includeLayers(t);
} catch (e) {}
};
}, $e.prototype.loadSegments = function() {
var t = this.animationData.segments;
t || (this.timeCompleted = this.animationData.tf), this.loadNextSegment();
}, $e.prototype.configAnimation = function(t) {
this.renderer && this.renderer.destroyed || (this.animationData = t, this.totalFrames = Math.floor(this.animationData.op - this.animationData.ip), 
this.animationData.tf = this.totalFrames, this.renderer.configAnimation(t), t.assets || (t.assets = []), 
t.comps && (t.assets = t.assets.concat(t.comps), t.comps = null), this.renderer.searchExtraCompositions(t.assets), 
this.layers = this.animationData.layers, this.assets = this.animationData.assets, 
this.frameRate = this.animationData.fr, this.firstFrame = Math.round(this.animationData.ip), 
this.frameMult = this.animationData.fr / 1e3, this.trigger("config_ready"), this.imagePreloader = new Be(), 
this.imagePreloader.setAssetsPath(this.assetsPath), this.imagePreloader.setPath(this.path), 
this.imagePreloader.loadAssets(t.assets), this.loadSegments(), this.updaFrameModifier(), 
this.renderer.globalData.fontManager ? this.waitForFontsLoaded() : (je.completeData(this.animationData, this.renderer.globalData.fontManager), 
this.checkLoaded()));
}, $e.prototype.waitForFontsLoaded = function() {
function t() {
this.renderer.globalData.fontManager.loaded ? (je.completeData(this.animationData, this.renderer.globalData.fontManager), 
this.checkLoaded()) : setTimeout(t.bind(this), 20);
}
return function() {
t.bind(this)();
};
}(), $e.prototype.addPendingElement = function() {
this.pendingElements += 1;
}, $e.prototype.elementLoaded = function() {
this.pendingElements--, this.checkLoaded();
}, $e.prototype.checkLoaded = function() {
0 === this.pendingElements && (be && be.initExpressions(this), this.renderer.initItems(), 
setTimeout(function() {
this.trigger("DOMLoaded");
}.bind(this), 0), this.isLoaded = !0, this.gotoFrame(), this.autoplay && this.play());
}, $e.prototype.resize = function() {
this.renderer.updateContainerSize();
}, $e.prototype.setSubframe = function(t) {
this.subframeEnabled = t ? !0 : !1;
}, $e.prototype.gotoFrame = function() {
this.currentFrame = this.subframeEnabled ? this.currentRawFrame : Math.floor(this.currentRawFrame), 
this.timeCompleted !== this.totalFrames && this.currentFrame > this.timeCompleted && (this.currentFrame = this.timeCompleted), 
this.trigger("enterFrame"), this.renderFrame();
}, $e.prototype.renderFrame = function() {
this.isLoaded !== !1 && this.renderer.renderFrame(this.currentFrame + this.firstFrame);
}, $e.prototype.play = function(t) {
t && this.name != t || this.isPaused === !0 && (this.isPaused = !1, this._idle && (this._idle = !1, 
this.trigger("_active")));
}, $e.prototype.pause = function(t) {
t && this.name != t || this.isPaused === !1 && (this.isPaused = !0, this.pendingSegment || (this._idle = !0, 
this.trigger("_idle")));
}, $e.prototype.togglePause = function(t) {
t && this.name != t || (this.isPaused === !0 ? this.play() : this.pause());
}, $e.prototype.stop = function(t) {
t && this.name != t || (this.pause(), this.currentFrame = this.currentRawFrame = 0, 
this.playCount = 0, this.gotoFrame());
}, $e.prototype.goToAndStop = function(t, e, i) {
i && this.name != i || (this.setCurrentRawFrameValue(e ? t : t * this.frameModifier), 
this.pause());
}, $e.prototype.goToAndPlay = function(t, e, i) {
this.goToAndStop(t, e, i), this.play();
}, $e.prototype.advanceTime = function(t) {
return this.pendingSegment ? (this.pendingSegment = !1, this.adjustSegment(this.segments.shift()), 
void (this.isPaused && this.play())) : void (this.isPaused !== !0 && this.isLoaded !== !1 && this.setCurrentRawFrameValue(this.currentRawFrame + t * this.frameModifier));
}, $e.prototype.updateAnimation = function(t) {
this.setCurrentRawFrameValue(this.totalFrames * t);
}, $e.prototype.moveFrame = function(t, e) {
e && this.name != e || this.setCurrentRawFrameValue(this.currentRawFrame + t);
}, $e.prototype.adjustSegment = function(t) {
this.playCount = 0, t[1] < t[0] ? (this.frameModifier > 0 && (this.playSpeed < 0 ? this.setSpeed(-this.playSpeed) : this.setDirection(-1)), 
this.totalFrames = t[0] - t[1], this.firstFrame = t[1], this.setCurrentRawFrameValue(this.totalFrames - .01)) : t[1] > t[0] && (this.frameModifier < 0 && (this.playSpeed < 0 ? this.setSpeed(-this.playSpeed) : this.setDirection(1)), 
this.totalFrames = t[1] - t[0], this.firstFrame = t[0], this.setCurrentRawFrameValue(0)), 
this.trigger("segmentStart");
}, $e.prototype.setSegment = function(t, e) {
var i = -1;
this.isPaused && (this.currentRawFrame + this.firstFrame < t ? i = t : this.currentRawFrame + this.firstFrame > e && (i = e - t - .01)), 
this.firstFrame = t, this.totalFrames = e - t, -1 !== i && this.goToAndStop(i, !0);
}, $e.prototype.playSegments = function(t, e) {
if ("object" == typeof t[0]) {
var i, s = t.length;
for (i = 0; s > i; i += 1) this.segments.push(t[i]);
} else this.segments.push(t);
e && this.adjustSegment(this.segments.shift()), this.isPaused && this.play();
}, $e.prototype.resetSegments = function(t) {
this.segments.length = 0, this.segments.push([ this.animationData.ip * this.frameRate, Math.floor(this.animationData.op - this.animationData.ip + this.animationData.ip * this.frameRate) ]), 
t && this.adjustSegment(this.segments.shift());
}, $e.prototype.checkSegments = function() {
this.segments.length && (this.pendingSegment = !0);
}, $e.prototype.remove = function(t) {
t && this.name != t || this.renderer.destroy();
}, $e.prototype.destroy = function(t) {
t && this.name != t || this.renderer && this.renderer.destroyed || (this.renderer.destroy(), 
this.trigger("destroy"), this._cbs = null, this.onEnterFrame = this.onLoopComplete = this.onComplete = this.onSegmentStart = this.onDestroy = null);
}, $e.prototype.setCurrentRawFrameValue = function(t) {
if (this.currentRawFrame = t, this.currentRawFrame >= this.totalFrames) {
if (this.checkSegments(), this.loop === !1) return this.currentRawFrame = this.totalFrames - .01, 
this.gotoFrame(), this.pause(), void this.trigger("complete");
if (this.trigger("loopComplete"), this.playCount += 1, this.loop !== !0 && this.playCount == this.loop || this.pendingSegment) return this.currentRawFrame = this.totalFrames - .01, 
this.gotoFrame(), this.pause(), void this.trigger("complete");
this.currentRawFrame = this.currentRawFrame % this.totalFrames;
} else if (this.currentRawFrame < 0) return this.checkSegments(), this.playCount -= 1, 
this.playCount < 0 && (this.playCount = 0), this.loop === !1 || this.pendingSegment ? (this.currentRawFrame = 0, 
this.gotoFrame(), this.pause(), void this.trigger("complete")) : (this.trigger("loopComplete"), 
this.currentRawFrame = (this.totalFrames + this.currentRawFrame) % this.totalFrames, 
void this.gotoFrame());
this.gotoFrame();
}, $e.prototype.setSpeed = function(t) {
this.playSpeed = t, this.updaFrameModifier();
}, $e.prototype.setDirection = function(t) {
this.playDirection = 0 > t ? -1 : 1, this.updaFrameModifier();
}, $e.prototype.updaFrameModifier = function() {
this.frameModifier = this.frameMult * this.playSpeed * this.playDirection;
}, $e.prototype.getPath = function() {
return this.path;
}, $e.prototype.getAssetsPath = function(t) {
var e = "";
if (this.assetsPath) {
var i = t.p;
-1 !== i.indexOf("images/") && (i = i.split("/")[1]), e = this.assetsPath + i;
} else e = this.path, e += t.u ? t.u : "", e += t.p;
return e;
}, $e.prototype.getAssetData = function(t) {
for (var e = 0, i = this.assets.length; i > e; ) {
if (t == this.assets[e].id) return this.assets[e];
e += 1;
}
}, $e.prototype.hide = function() {
this.renderer.hide();
}, $e.prototype.show = function() {
this.renderer.show();
}, $e.prototype.getAssets = function() {
return this.assets;
}, $e.prototype.trigger = function(t) {
if (this._cbs && this._cbs[t]) switch (t) {
case "enterFrame":
this.triggerEvent(t, new r(t, this.currentFrame, this.totalFrames, this.frameMult));
break;

case "loopComplete":
this.triggerEvent(t, new a(t, this.loop, this.playCount, this.frameMult));
break;

case "complete":
this.triggerEvent(t, new n(t, this.frameMult));
break;

case "segmentStart":
this.triggerEvent(t, new o(t, this.firstFrame, this.totalFrames));
break;

case "destroy":
this.triggerEvent(t, new h(t, this));
break;

default:
this.triggerEvent(t);
}
"enterFrame" === t && this.onEnterFrame && this.onEnterFrame.call(this, new r(t, this.currentFrame, this.totalFrames, this.frameMult)), 
"loopComplete" === t && this.onLoopComplete && this.onLoopComplete.call(this, new a(t, this.loop, this.playCount, this.frameMult)), 
"complete" === t && this.onComplete && this.onComplete.call(this, new n(t, this.frameMult)), 
"segmentStart" === t && this.onSegmentStart && this.onSegmentStart.call(this, new o(t, this.firstFrame, this.totalFrames)), 
"destroy" === t && this.onDestroy && this.onDestroy.call(this, new h(t, this));
}, $e.prototype.addEventListener = l, $e.prototype.removeEventListener = p, $e.prototype.triggerEvent = c;
var Ye = {};
Ye.play = K, Ye.pause = Q, Ye.setLocationHref = Z, Ye.togglePause = te, Ye.setSpeed = ee, 
Ye.setDirection = ie, Ye.stop = se, Ye.moveFrame = re, Ye.searchAnimations = ne, 
Ye.registerAnimation = ae, Ye.loadAnimation = ce, Ye.setSubframeRendering = pe, 
Ye.resize = oe, Ye.start = he, Ye.goToAndStop = le, Ye.destroy = fe, Ye.setQuality = ue, 
Ye.inBrowser = de, Ye.installPlugin = me, Ye.__getFactory = ge, Ye.version = "4.11.1";
var Ze = "__[STANDALONE]__", Ke = "__[ANIMATIONDATA]__", Qe = "";
if (Ze) {
var ti = document.getElementsByTagName("script"), ei = ti.length - 1, ii = ti[ei] || {
src: ""
}, si = ii.src.replace(/^[^\?]+\??/, "");
Qe = ye("renderer");
}
var ri = setInterval(ve, 100);
return Ye;
});