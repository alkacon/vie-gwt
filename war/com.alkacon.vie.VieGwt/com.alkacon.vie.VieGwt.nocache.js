function com_alkacon_vie_VieGwt(){var O='',vb='" for "gwt:onLoadErrorFn"',tb='" for "gwt:onPropertyErrorFn"',hb='"><\/script>',Y='#',$b='../vieJS/vie-latest-ALL.debug.js',ac='../vieJS/vie-latest-ALL.debug.js"><\/script>',Yb='.cache.html',$='/',Rb='3D6A3A16749C78673D47293C61EFAAF1',Sb='444318F479EAA051DF0E911A19793702',Tb='4AC54EFCA4C953CC69D14F969FA01C12',Ub='5168F9FF32CC4F5395BCD9A705CE2577',Xb=':',nb='::',bc='<script defer="defer">com_alkacon_vie_VieGwt.onInjectionDone(\'com.alkacon.vie.VieGwt\')<\/script>',gb='<script id="',_b='<script language="javascript" src="',qb='=',Z='?',Eb='ActiveXObject',sb='Bad handler "',Fb='ChromeTab.ChromeFrame',Vb='D92F4F41347350296BAC4BA2AF3FC9FB',Zb='DOMContentLoaded',Wb='FC4B74C0CE0CB969C0AC8A3EAF50CBBD',ib='SCRIPT',fb='__gwt_marker_com.alkacon.vie.VieGwt',jb='base',bb='baseUrl',S='begin',R='bootstrap',Db='chromeframe',ab='clear.cache.gif',P='com.alkacon.vie.VieGwt',db='com.alkacon.vie.VieGwt.nocache.js',mb='com.alkacon.vie.VieGwt::',pb='content',X='end',Lb='gecko',Mb='gecko1_8',T='gwt.codesvr=',U='gwt.hosted=',V='gwt.hybrid',ub='gwt:onLoadErrorFn',rb='gwt:onPropertyErrorFn',ob='gwt:property',Pb='hosted.html?com_alkacon_vie_VieGwt',Kb='ie6',Jb='ie8',Ib='ie9',wb='iframe',_='img',xb="javascript:''",Ob='loadExternalRefs',kb='meta',zb='moduleRequested',W='moduleStartup',Hb='msie',lb='name',Bb='opera',yb='position:absolute;width:0;height:0;border:none',Gb='safari',cb='script',Qb='selectingPermutation',Q='startup',eb='undefined',Nb='unknown',Ab='user.agent',Cb='webkit';var l=window,m=document,n=l.__gwtStatsEvent?function(a){return l.__gwtStatsEvent(a)}:null,o=l.__gwtStatsSessionId?l.__gwtStatsSessionId:null,p,q,r,s=O,t={},u=[],v=[],w=[],x=0,y,z;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:S});if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={}}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={}}function A(){var b=false;try{var c=l.location.search;return (c.indexOf(T)!=-1||(c.indexOf(U)!=-1||l.external&&l.external.gwtOnLoad))&&c.indexOf(V)==-1}catch(a){}A=function(){return b};return b}
function B(){if(p&&q){var b=m.getElementById(P);var c=b.contentWindow;if(A()){c.__gwt_getProperty=function(a){return G(a)}}com_alkacon_vie_VieGwt=null;c.gwtOnLoad(y,P,s,x);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:X})}}
function C(){function e(a){var b=a.lastIndexOf(Y);if(b==-1){b=a.length}var c=a.indexOf(Z);if(c==-1){c=a.length}var d=a.lastIndexOf($,Math.min(c,b));return d>=0?a.substring(0,d+1):O}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=m.createElement(_);b.src=a+ab;a=e(b.src)}return a}
function g(){var a=E(bb);if(a!=null){return a}return O}
function h(){var a=m.getElementsByTagName(cb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(db)!=-1){return e(a[b].src)}}return O}
function i(){var a;if(typeof isBodyLoaded==eb||!isBodyLoaded()){var b=fb;var c;m.write(gb+b+hb);c=m.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=ib){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return O}
function j(){var a=m.getElementsByTagName(jb);if(a.length>0){return a[a.length-1].href}return O}
var k=g();if(k==O){k=h()}if(k==O){k=i()}if(k==O){k=j()}if(k==O){k=e(m.location.href)}k=f(k);s=k;return k}
function D(){var b=document.getElementsByTagName(kb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(lb),g;if(f){f=f.replace(mb,O);if(f.indexOf(nb)>=0){continue}if(f==ob){g=e.getAttribute(pb);if(g){var h,i=g.indexOf(qb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=O}t[f]=h}}else if(f==rb){g=e.getAttribute(pb);if(g){try{z=eval(g)}catch(a){alert(sb+g+tb)}}}else if(f==ub){g=e.getAttribute(pb);if(g){try{y=eval(g)}catch(a){alert(sb+g+vb)}}}}}}
function E(a){var b=t[a];return b==null?null:b}
function F(a,b){var c=w;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function G(a){var b=v[a](),c=u[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(z){z(a,d,b)}throw null}
var H;function I(){if(!H){H=true;var a=m.createElement(wb);a.src=xb;a.id=P;a.style.cssText=yb;a.tabIndex=-1;m.body.appendChild(a);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:zb});a.contentWindow.location.replace(s+K)}}
v[Ab]=function(){var c=navigator.userAgent.toLowerCase();var d=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return c.indexOf(Bb)!=-1}())return Bb;if(function(){return c.indexOf(Cb)!=-1||function(){if(c.indexOf(Db)!=-1){return true}if(typeof window[Eb]!=eb){try{var b=new ActiveXObject(Fb);if(b){b.registerBhoIfNeeded();return true}}catch(a){}}return false}()}())return Gb;if(function(){return c.indexOf(Hb)!=-1&&m.documentMode>=9}())return Ib;if(function(){return c.indexOf(Hb)!=-1&&m.documentMode>=8}())return Jb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(c);if(a&&a.length==3)return d(a)>=6000}())return Kb;if(function(){return c.indexOf(Lb)!=-1}())return Mb;return Nb};u[Ab]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};com_alkacon_vie_VieGwt.onScriptLoad=function(){if(H){q=true;B()}};com_alkacon_vie_VieGwt.onInjectionDone=function(){p=true;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:Ob,millis:(new Date).getTime(),type:X});B()};D();C();var J;var K;if(A()){if(l.external&&(l.external.initModule&&l.external.initModule(P))){l.location.reload();return}K=Pb;J=O}n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:Qb});if(!A()){try{F([Ib],Rb);F([Gb],Sb);F([Mb],Tb);F([Bb],Ub);F([Kb],Vb);F([Jb],Wb);J=w[G(Ab)];var L=J.indexOf(Xb);if(L!=-1){x=Number(J.substring(L+1));J=J.substring(0,L)}K=J+Yb}catch(a){return}}var M;function N(){if(!r){r=true;B();if(m.removeEventListener){m.removeEventListener(Zb,N,false)}if(M){clearInterval(M)}}}
if(m.addEventListener){m.addEventListener(Zb,function(){I();N()},false)}var M=setInterval(function(){if(/loaded|complete/.test(m.readyState)){I();N()}},50);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:X});n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:Ob,millis:(new Date).getTime(),type:S});if(!__gwt_scriptsLoaded[$b]){__gwt_scriptsLoaded[$b]=true;document.write(_b+s+ac)}m.write(bc)}
com_alkacon_vie_VieGwt();