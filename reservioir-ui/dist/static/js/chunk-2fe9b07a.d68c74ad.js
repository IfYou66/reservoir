(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2fe9b07a"],{"1e4b":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container home"},[n("div",{staticClass:"layui-fluid"},[n("div",{staticClass:"layui-card"},[n("div",{staticClass:"layui-card-body",staticStyle:{width:"100%",height:"100%"}},[n("iframe",{ref:"mainIframe",attrs:{id:"mainIframe",name:"mainIframe",allowfullscreen:"true",frameborder:"0",marginheight:"0",marginwidth:"0",src:"http://58.58.27.77:6400/",width:"80%",height:"80%"}})])])])])},a=[],m=(n("a9e3"),{name:"index",data:function(){return{version:"2.5.0",base:n("9feb")("./"+this.common.CURRENT_RESERVOIR+"/base"),image:this.common.CURRENT_RESERVOIR}},mounted:function(){setTimeout((function(){if(document.getElementById("mainIframe")){var e=document.getElementById("mainIframe"),t=document.documentElement.clientWidth,n=document.documentElement.clientHeight;e.style.width=Number(t-200)+"px",e.style.height=Number(n-200)+"px"}}),200),this.$nextTick((function(){window.addEventListener("resize",(function(){var e=document.getElementById("mainIframe"),t=document.documentElement.clientWidth,n=document.documentElement.clientHeight;e.style.width=Number(t-200)+"px",e.style.height=Number(n-200)+"px"}))}))},methods:{goTarget:function(e){window.open(e,"_blank")},addInfo:function(){var e=document.getElementById("main");e.innerHTML=this.base.getBaseInfo().info}}}),c=m,o=(n("708a"),n("2877")),d=Object(o["a"])(c,i,a,!1,null,"ff7ab158",null);t["default"]=d.exports},"708a":function(e,t,n){"use strict";n("c466")},c466:function(e,t,n){}}]);