(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4c7a4ed0"],{1157:function(e,t,i){e.exports=i.p+"static/img/head.fda3837f.png"},9675:function(e,t,i){e.exports=i.p+"static/img/title.fd301eec.jpg"},a00f:function(e,t,i){"use strict";i("d1b5")},d1b5:function(e,t,i){},d2fe:function(e,t,i){"use strict";i.r(t);var r=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-row",{staticClass:"top-div"},[r("img",{attrs:{src:i("9675"),alt:""}}),r("div",{attrs:{id:"menu"}},[r("div",{staticStyle:{"margin-top":"20px","margin-right":"40px"}},[r("img",{staticStyle:{width:"40px",height:"40px"},attrs:{src:i("1157"),alt:""}}),r("div",{staticStyle:{"margin-left":"-10px",color:"#385292"}},[e._v("退出登陆")])])])]),r("el-col",{attrs:{span:3,id:"left"}},[r("el-row",[r("el-col",{attrs:{id:"imgDiv",span:24}})],1),r("el-row"),r("el-row",[r("el-tree",{attrs:{data:e.reservoirs,"node-key":"id","default-expand-all":""},on:{"node-click":e.handleNodeClick},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.node;t.data;return r("span",{staticClass:"custom-tree-node"},[r("span",[r("i",{staticClass:"el-icon-s-flag"}),e._v(e._s(i.label)+" ")])])}}])})],1)],1),r("el-col",{attrs:{span:21}},[r("div",{staticClass:"divTdtMap",attrs:{id:"mapDiv"}})])],1)},a=[],n=i("b85c"),s=(i("d81d"),i("a4d3"),i("e01a"),{name:"reservoir",data:function(){return{tdtMapDivID:"tdtMapDivID_"+this._uid,tdtMap:{},activeIndex:"1",markers:[],reservoirs:[{label:"马河水库",lan:117.214965,sat:35.221793,icon:"el-icon-info",description:"马河水库地处滕州市城区东北15千米处，龙山和谷山之间，位于东郭镇马河村西北400米，龙阳镇何岭村东北500米处。水库是一座以防洪、灌溉为主，结合发电、工业供水、养殖等综合利用的大型水库。",url:"/"},{label:"户主水库",lan:117.27445,sat:35.230406,icon:"el-icon-success",description:"户主水库，滕州市户主水库位于滕州市城区东北17公里，东郭镇境内，属淮河流域，南四湖水系，城河支流乡河上游。流域面积44平方公里，干流平均坡降0.00576米/米，坝址以上干流长9公里，流域呈扇形，平均宽4.63公里。2005年6月，被国家防总确定为全国防洪重点中型水库。",url:"/#"},{label:"户主东水库",lan:117.29441,sat:35.227917,description:"户主东水库，滕州市户主水库位于滕州市城区东北17公里，东郭镇境内，属淮河流域，南四湖水系，城河支流乡河上游。流域面积44平方公里，干流平均坡降0.00576米/米，坝址以上干流长9公里，流域呈扇形，平均宽4.63公里。2005年6月，被国家防总确定为全国防洪重点中型水库。",url:"/#"},{label:"虎山水库",lan:117.293163,sat:35.039168,description:"虎山水库地处滕州市城区东北15千米处，龙山和谷山之间，位于东郭镇马河村西北400米，龙阳镇何岭村东北500米处。水库是一座以防洪、灌溉为主，结合发电、工业供水、养殖等综合利用的大型水库。",url:"/#"}],defaultProps:{children:"children",label:"label"},map:void 0}},created:function(){},mounted:function(){this.initTdtMap(),window.enterRes=this.enterRes},watch:{},methods:{initTdtMap:function(){var e="http://t0.tianditu.gov.cn/img_w/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX={z}&TILEROW={y}&TILECOL={x}&tk=dd2abf5a55ddf44b3c81d9101e2d419b",t=new T.TileLayer(e,{minZoom:1,maxZoom:18}),i={layers:[t]};this.map=new T.Map("mapDiv",i),this.map.enableScrollWheelZoom(),this.createMarkers(),this.markers.length>0&&this.locateMarker(this.markers[0].or.lng,this.markers[0].or.lat)},createMarkers:function(){for(var e=this,t=function(t){var i=new T.LngLat(e.reservoirs[t].lan,e.reservoirs[t].sat),r=new T.Marker(i);e.map.addOverLay(r);var a=new T.InfoWindow,n="<div style='margin:5px;'><div style='margin: 30px 10px 0 10px; padding-bottom: 20px'><h2 style='text-align: center'>"+e.reservoirs[t].label+"</h2><div id='imgRes' style='float:left;margin:0px 10px' width='40' height='40' title='马河水库'></div><div style='margin:10px 0px 10px 120px;font-size: larger'>"+e.reservoirs[t].description+"</div><input style='margin: 0 auto;  width: 180px;height: 30px; text-align: center; background: #5596de;color: #FFF;border: none;display: block;cursor: pointer;' type='button' value='进入系统'  onclick='enterRes()'></div></div>";a.setContent(n),r.addEventListener("click",(function(){r.openInfoWindow(a)})),r.win=a,e.markers.push(r)},i=0;i<this.reservoirs.length;i++)t(i);this.markers[0].openInfoWindow(this.markers[0].win.ET)},findMarker:function(e,t){var i,r=Object(n["a"])(this.markers);try{for(r.s();!(i=r.n()).done;){var a=i.value;if(Math.abs(a.or.lng-e)<.001&&Math.abs(a.or.lat-t)<.001)return a}}catch(s){r.e(s)}finally{r.f()}},handleNodeClick:function(e){this.isReservoir(e)&&this.locateMarker(e.lan,e.sat)},locateMarker:function(e,t){var i=new T.LngLat(e,t+.005);this.map.centerAndZoom(i,15);var r=this.findMarker(e,t);r.openInfoWindow(r.win.ET)},enterRes:function(){this.$router.push({path:this.redirect||"/"})},isReservoir:function(e){return-1!==e.label.indexOf("水库")},findItem:function(e){if(this.isReservoir(e))for(var t=0;t<this.reservoirs.length;t++)for(var i=this.reservoirs[t].children,r=0;r<i.length;r++){var a=i[r].children;if(a)for(var n=0;n<a.length;n++){var s=a[n];if(s.label===e.label)return s}else if(i[r].label===e.label)return i[r]}}}}),l=s,o=(i("a00f"),i("2877")),d=Object(o["a"])(l,r,a,!1,null,null,null);t["default"]=d.exports}}]);