(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-54a12b89"],{"358e":function(t,e,n){t.exports=n.p+"static/fonts/name.1185c12c.ttf"},"55eb":function(t,e,n){"use strict";n("6351")},6351:function(t,e,n){},"71e4":function(t,e,n){t.exports=n.p+"static/img/manage.787c3185.png"},"7bae":function(t,e,n){"use strict";n.r(e);var o=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},i=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("div",{attrs:{id:"container"}})])}],a=n("b85c"),r=(n("ace4"),n("d3b7"),n("cfc3"),n("9a8c"),n("a975"),n("735e"),n("c1ac"),n("d139"),n("3a7b"),n("d5d6"),n("82f8"),n("e91f"),n("60bd"),n("5f96"),n("3280"),n("3fcc"),n("ca91"),n("25a1"),n("cd26"),n("3c5d"),n("2954"),n("649e"),n("219c"),n("170b"),n("b39a"),n("72f7"),n("b680"),n("ac1f"),n("5319"),n("5a89")),s=n("4721"),l=n("a201"),c=n("02ba"),d=n("f1ce"),u=n("34ad"),f=n("2c0a"),m={name:"first",methods:{},mounted:function(){var t,e,o,i,m=2,v=4,h=new r["h"];function p(t){return Math.pow(2,Math.ceil(Math.log(t)/Math.log(2)))}Math.lerp=function(t,e,n){return n=Math.max(Math.min(n,1),0),t+(e-t)*n};var y,x,g,w,b=["files/glbs/Parrot.glb","files/glbs/Flamingo.glb"],A=Math.floor(Math.random()*b.length);(new u["a"]).load(b[A],(function(n){var o=n.animations;e=Math.round(60*o[0].duration);var i=n.scene.children[0].geometry,a=i.morphAttributes.position,s=p(e),l=p(i.getAttribute("position").count);i.getAttribute("position").count;for(var c=new Float32Array(3*l*s),d=0;d<l;d++)for(var u=0;u<s;u++){var f=u*l*3,y=Math.floor(u/e*a.length),x=(Math.floor(u/e*a.length)+1)%a.length,g=u/e*a.length%1;if(u<e){var w=void 0,b=void 0;w=a[y].array[3*d],b=a[x].array[3*d],void 0!==w&&void 0!==b&&(c[f+3*d]=Math.lerp(w,b,g)),w=a[y].array[3*d+1],b=a[x].array[3*d+1],void 0!==w&&void 0!==b&&(c[f+3*d+1]=Math.lerp(w,b,g)),w=a[y].array[3*d+2],b=a[x].array[3*d+2],void 0!==w&&void 0!==b&&(c[f+3*d+2]=Math.lerp(w,b,g))}}t=new r["l"](c,l,s,r["kb"],r["q"]),t.needsUpdate=!0;for(var A=[],z=[],P=[],D=[],S=[],M=3*i.getAttribute("position").count*v,R=0;R<M;R++){var I=R%(3*i.getAttribute("position").count);A.push(i.getAttribute("position").array[I]),z.push(i.getAttribute("color").array[I])}for(var T=Math.random(),E=0;E<i.getAttribute("position").count*v;E++){var j=E%i.getAttribute("position").count,F=Math.floor(E/i.getAttribute("position").count);0===j&&(T=Math.random());var U=~~F,V=U%m/m,C=~~(U/m)/m;P.push(V,C,j/l,e/s),D.push(F,T,Math.random(),Math.random())}for(var q=0;q<i.index.array.length*v;q++){var B=Math.floor(q/i.index.array.length)*i.getAttribute("position").count;S.push(i.index.array[q%i.index.array.length]+B)}h.setAttribute("position",new r["g"](new Float32Array(A),3)),h.setAttribute("birdColor",new r["g"](new Float32Array(z),3)),h.setAttribute("color",new r["g"](new Float32Array(z),3)),h.setAttribute("reference",new r["g"](new Float32Array(P),4)),h.setAttribute("seeds",new r["g"](new Float32Array(D),4)),h.setIndex(S),et(),ct()}));var z,P,D,S,M,R,I,T,E,j,F,U,V,C=0,q=0,B=window.innerWidth/2,N=window.innerHeight/2,O=800,k=O/2,H=performance.now(),Q=(function(){E=[{name:"mesh0",pos:{x:-60,y:0,z:60},url:"#",img:n("8829"),rot:{x:.1,y:.2,z:.5}},{name:"mesh2",pos:{x:-10,y:0,z:10},url:"/reservoir",img:n("71e4"),rot:{x:.3,y:.2,z:.3}},{name:"mesh4",pos:{x:60,y:0,z:40},url:"#",img:n("b6d4"),rot:{x:.5,y:.2,z:.1}}]}(),"滕州市数字水库管理平台"),W=20,L=70,Z=30,_=4,K=2,J=1.5,Y=null,G=!0,X=!1,$=null;function tt(){function t(t){var e=o();if(e){document.body.style.cursor="pointer";var n=E[e.object.index];$=e.object.index,n.rot.x=0,n.rot.z=0,n.rot.y=0,n.pos.y=5,X=!0,ft()}else X&&(X=!1,E[$].rot.x=.1*($+1),E[$].rot.y=.2,E[$].rot.z=.1*(E.length-$-1),E[$].pos.y=0,ft()),document.body.style.cursor="default"}function e(t){var e=o();e&&(window.location.href=n(e.object.position.x).url)}function n(t){var e,n=Object(a["a"])(E);try{for(n.s();!(e=n.n()).done;){var o=e.value;if(t===o.pos.x)return o}}catch(i){n.e(i)}finally{n.f()}}function o(){var t=new r["lb"],e=new r["Db"];e.x=event.clientX/window.innerWidth*2-1,e.y=-event.clientY/window.innerHeight*2+1,t.setFromCamera(e,x);var n=t.intersectObjects(g.children,!0);if(n.length>2){var o,i=Object(a["a"])(n);try{for(i.s();!(o=i.n()).done;){var s=o.value;if(s.object instanceof r["N"]&&s.object.index>=0)return s}}catch(l){i.e(l)}finally{i.f()}}}document.addEventListener("click",e,!1),document.addEventListener("mousemove",t,!1)}function et(){y=document.getElementById("container"),w=new r["Ib"],w.setPixelRatio(window.devicePixelRatio),w.setSize(window.innerWidth,window.innerHeight),w.toneMapping=r["a"],y.appendChild(w.domElement),g=new r["nb"],x=new r["ab"](70,window.innerWidth/window.innerHeight,1,2e4),x.position.set(30,30,100),T=new r["Eb"];var t=new r["cb"](1e4,1e4);I=new l["a"](t,{textureWidth:512,textureHeight:512,waterNormals:(new r["yb"]).load(n("f28c"),(function(t){t.wrapS=t.wrapT=r["mb"]})),sunDirection:new r["Eb"],sunColor:16777215,waterColor:7695,distortionScale:10,fog:void 0!==g.fog}),I.rotation.x=-Math.PI/2,g.add(I);var e=new c["a"];e.scale.setScalar(1e4),g.add(e);var o=e.material.uniforms;o["turbidity"].value=10,o["rayleigh"].value=9,o["mieCoefficient"].value=.005,o["mieDirectionalG"].value=.8;for(var i={elevation:2*(40*(12-Math.abs((new Date).getHours()+(new Date).getMinutes()/60-12))/12-20),azimuth:10*(12-(new Date).getHours()-(new Date).getMinutes()/60)-170},a=new r["Z"](w),u=(function(){var t=r["L"].degToRad(90-i.elevation),n=r["L"].degToRad(i.azimuth);T.setFromSphericalCoords(1,t,n),e.material.uniforms["sunPosition"].value.copy(T),I.material.uniforms["sunDirection"].value.copy(T).normalize(),g.environment=a.fromScene(e).texture}(),new r["f"](20,20,20)),f=0;f<E.length;f++){var m=(new r["yb"]).load(E[f].img),v=new r["R"]({map:m}),h=new r["N"](u,v);h.index=f,g.add(h),E[f].obj=h}var p=new r["f"](30,30,30),b=(new r["yb"]).load(n("b3d6")),A=new r["R"]({map:b}),z=new r["N"](p,A);z.position.x=-800,z.position.y=88,z.position.z=-500,z.rotation.y=7.24,z.rotation.x=9.5,z.rotation.z=9.4,g.add(z),R=new s["a"](x,w.domElement),R.maxPolarAngle=.495*Math.PI,R.target.set(0,10,0),R.minDistance=50,R.maxDistance=4800,R.update();var P=new r["m"](16777215,.125);P.position.set(0,0,1).normalize(),g.add(P);var D=new r["db"](16777215,1.5);D.position.set(0,200,90),D.color.setHSL(.1,1,.3),g.add(D),V=new r["P"]({color:16777215,flatShading:!0}),j=new r["t"],j.position.y=100,g.add(j);var S=new d["a"];S.load(n("358e"),(function(t){Y=new r["r"](t),st()})),x.updateMatrixWorld(),nt(),ot(),y.style.touchAction="none",y.addEventListener("pointermove",rt),window.addEventListener("resize",lt)}function nt(){z=new f["a"](m,m,w);var t=z.createTexture(),e=z.createTexture();it(t),at(e),P=z.addVariable("textureVelocity","uniform float time;\n\t\t\tuniform float testing;\n\t\t\tuniform float delta; // about 0.016\n\t\t\tuniform float separationDistance; // 20\n\t\t\tuniform float alignmentDistance; // 40\n\t\t\tuniform float cohesionDistance; //\n\t\t\tuniform float freedomFactor;\n\t\t\tuniform vec3 predator;\n\n\t\t\tconst float width = resolution.x;\n\t\t\tconst float height = resolution.y;\n\n\t\t\tconst float PI = 3.141592653589793;\n\t\t\tconst float PI_2 = PI * 2.0;\n\t\t\t// const float VISION = PI * 0.55;\n\n\t\t\tfloat zoneRadius = 40.0;\n\t\t\tfloat zoneRadiusSquared = 1600.0;\n\n\t\t\tfloat separationThresh = 0.45;\n\t\t\tfloat alignmentThresh = 0.65;\n\n\t\t\tconst float UPPER_BOUNDS = BOUNDS;\n\t\t\tconst float LOWER_BOUNDS = -UPPER_BOUNDS;\n\n\t\t\tconst float SPEED_LIMIT = 9.0;\n\n\t\t\tfloat rand( vec2 co ){\n\t\t\t\treturn fract( sin( dot( co.xy, vec2(12.9898,78.233) ) ) * 43758.5453 );\n\t\t\t}\n\n\t\t\tvoid main() {\n\n\t\t\t\tzoneRadius = separationDistance + alignmentDistance + cohesionDistance;\n\t\t\t\tseparationThresh = separationDistance / zoneRadius;\n\t\t\t\talignmentThresh = ( separationDistance + alignmentDistance ) / zoneRadius;\n\t\t\t\tzoneRadiusSquared = zoneRadius * zoneRadius;\n\n\n\t\t\t\tvec2 uv = gl_FragCoord.xy / resolution.xy;\n\t\t\t\tvec3 birdPosition, birdVelocity;\n\n\t\t\t\tvec3 selfPosition = texture2D( texturePosition, uv ).xyz;\n\t\t\t\tvec3 selfVelocity = texture2D( textureVelocity, uv ).xyz;\n\n\t\t\t\tfloat dist;\n\t\t\t\tvec3 dir; // direction\n\t\t\t\tfloat distSquared;\n\n\t\t\t\tfloat separationSquared = separationDistance * separationDistance;\n\t\t\t\tfloat cohesionSquared = cohesionDistance * cohesionDistance;\n\n\t\t\t\tfloat f;\n\t\t\t\tfloat percent;\n\n\t\t\t\tvec3 velocity = selfVelocity;\n\n\t\t\t\tfloat limit = SPEED_LIMIT;\n\n\t\t\t\tdir = predator * UPPER_BOUNDS - selfPosition;\n\t\t\t\tdir.z = 0.;\n\t\t\t\t// dir.z *= 0.6;\n\t\t\t\tdist = length( dir );\n\t\t\t\tdistSquared = dist * dist;\n\n\t\t\t\tfloat preyRadius = 150.0;\n\t\t\t\tfloat preyRadiusSq = preyRadius * preyRadius;\n\n\n\t\t\t\t// move birds away from predator\n\t\t\t\tif ( dist < preyRadius ) {\n\n\t\t\t\t\tf = ( distSquared / preyRadiusSq - 1.0 ) * delta * 100.;\n\t\t\t\t\tvelocity += normalize( dir ) * f;\n\t\t\t\t\tlimit += 5.0;\n\t\t\t\t}\n\n\n\t\t\t\t// if (testing == 0.0) {}\n\t\t\t\t// if ( rand( uv + time ) < freedomFactor ) {}\n\n\n\t\t\t\t// Attract flocks to the center\n\t\t\t\tvec3 central = vec3( 0., 0., 0. );\n\t\t\t\tdir = selfPosition - central;\n\t\t\t\tdist = length( dir );\n\n\t\t\t\tdir.y *= 2.5;\n\t\t\t\tvelocity -= normalize( dir ) * delta * 5.;\n\n\t\t\t\tfor ( float y = 0.0; y < height; y++ ) {\n\t\t\t\t\tfor ( float x = 0.0; x < width; x++ ) {\n\n\t\t\t\t\t\tvec2 ref = vec2( x + 0.5, y + 0.5 ) / resolution.xy;\n\t\t\t\t\t\tbirdPosition = texture2D( texturePosition, ref ).xyz;\n\n\t\t\t\t\t\tdir = birdPosition - selfPosition;\n\t\t\t\t\t\tdist = length( dir );\n\n\t\t\t\t\t\tif ( dist < 0.0001 ) continue;\n\n\t\t\t\t\t\tdistSquared = dist * dist;\n\n\t\t\t\t\t\tif ( distSquared > zoneRadiusSquared ) continue;\n\n\t\t\t\t\t\tpercent = distSquared / zoneRadiusSquared;\n\n\t\t\t\t\t\tif ( percent < separationThresh ) { // low\n\n\t\t\t\t\t\t\t// Separation - Move apart for comfort\n\t\t\t\t\t\t\tf = ( separationThresh / percent - 1.0 ) * delta;\n\t\t\t\t\t\t\tvelocity -= normalize( dir ) * f;\n\n\t\t\t\t\t\t} else if ( percent < alignmentThresh ) { // high\n\n\t\t\t\t\t\t\t// Alignment - fly the same direction\n\t\t\t\t\t\t\tfloat threshDelta = alignmentThresh - separationThresh;\n\t\t\t\t\t\t\tfloat adjustedPercent = ( percent - separationThresh ) / threshDelta;\n\n\t\t\t\t\t\t\tbirdVelocity = texture2D( textureVelocity, ref ).xyz;\n\n\t\t\t\t\t\t\tf = ( 0.5 - cos( adjustedPercent * PI_2 ) * 0.5 + 0.5 ) * delta;\n\t\t\t\t\t\t\tvelocity += normalize( birdVelocity ) * f;\n\n\t\t\t\t\t\t} else {\n\n\t\t\t\t\t\t\t// Attraction / Cohesion - move closer\n\t\t\t\t\t\t\tfloat threshDelta = 1.0 - alignmentThresh;\n\t\t\t\t\t\t\tfloat adjustedPercent;\n\t\t\t\t\t\t\tif( threshDelta == 0. ) adjustedPercent = 1.;\n\t\t\t\t\t\t\telse adjustedPercent = ( percent - alignmentThresh ) / threshDelta;\n\n\t\t\t\t\t\t\tf = ( 0.5 - ( cos( adjustedPercent * PI_2 ) * -0.5 + 0.5 ) ) * delta;\n\n\t\t\t\t\t\t\tvelocity += normalize( dir ) * f;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t// this make tends to fly around than down or up\n\t\t\t\t// if (velocity.y > 0.) velocity.y *= (1. - 0.2 * delta);\n\n\t\t\t\t// Speed Limits\n\t\t\t\tif ( length( velocity ) > limit ) {\n\t\t\t\t\tvelocity = normalize( velocity ) * limit;\n\t\t\t\t}\n\n\t\t\t\tgl_FragColor = vec4( velocity, 1.0 );\n\n\t\t\t}\n",e),D=z.addVariable("texturePosition","uniform float time;\n\t\t\tuniform float delta;\n\n\t\t\tvoid main()\t{\n\n\t\t\t\tvec2 uv = gl_FragCoord.xy / resolution.xy;\n\t\t\t\tvec4 tmpPos = texture2D( texturePosition, uv );\n\t\t\t\tvec3 position = tmpPos.xyz;\n\t\t\t\tvec3 velocity = texture2D( textureVelocity, uv ).xyz;\n\n\t\t\t\tfloat phase = tmpPos.w;\n\n\t\t\t\tphase = mod( ( phase + delta +\n\t\t\t\t\tlength( velocity.xz ) * delta * 3. +\n\t\t\t\t\tmax( velocity.y, 0.0 ) * delta * 6. ), 62.83 );\n\n\t\t\t\tgl_FragColor = vec4( position + velocity * delta * 15. , phase );\n\n\t\t\t}",t),z.setVariableDependencies(P,[D,P]),z.setVariableDependencies(D,[D,P]),S=D.material.uniforms,M=P.material.uniforms,S["time"]={value:0},S["delta"]={value:0},M["time"]={value:1},M["delta"]={value:0},M["testing"]={value:1},M["separationDistance"]={value:1},M["alignmentDistance"]={value:1},M["cohesionDistance"]={value:1},M["freedomFactor"]={value:1},M["predator"]={value:new r["Eb"]},P.material.defines.BOUNDS=O.toFixed(2),P.wrapS=r["mb"],P.wrapT=r["mb"],D.wrapS=r["mb"],D.wrapT=r["mb"];var n=z.init();null!==n&&console.error(n)}function ot(){var e=h,n=new r["R"]({vertexColors:!0,flatShading:!0,roughness:1,metalness:0});n.onBeforeCompile=function(e){e.uniforms.texturePosition={value:null},e.uniforms.textureVelocity={value:null},e.uniforms.textureAnimation={value:t},e.uniforms.time={value:1},e.uniforms.size={value:.3},e.uniforms.delta={value:0};var n="#define STANDARD",o="\n\t\t\t\t\t\tattribute vec4 reference;\n\t\t\t\t\t\tattribute vec4 seeds;\n\t\t\t\t\t\tattribute vec3 birdColor;\n\t\t\t\t\t\tuniform sampler2D texturePosition;\n\t\t\t\t\t\tuniform sampler2D textureVelocity;\n\t\t\t\t\t\tuniform sampler2D textureAnimation;\n\t\t\t\t\t\tuniform float size;\n\t\t\t\t\t\tuniform float time;\n\t\t\t\t\t";e.vertexShader=e.vertexShader.replace(n,n+o),n="#include <begin_vertex>",o="\n\t\t\t\t\t\tvec4 tmpPos = texture2D( texturePosition, reference.xy );\n\n\t\t\t\t\t\tvec3 pos = tmpPos.xyz;\n\t\t\t\t\t\tvec3 velocity = normalize(texture2D( textureVelocity, reference.xy ).xyz);\n\t\t\t\t\t\tvec3 aniPos = texture2D( textureAnimation, vec2( reference.z, mod( time + ( seeds.x ) * ( ( 0.0004 + seeds.y / 10000.0) + normalize( velocity ) / 20000.0 ), reference.w ) ) ).xyz;\n\t\t\t\t\t\tvec3 newPosition = position;\n\n\t\t\t\t\t\tnewPosition = mat3( modelMatrix ) * ( newPosition + aniPos );\n\t\t\t\t\t\tnewPosition *= size + seeds.y * size * 0.2;\n\n\t\t\t\t\t\tvelocity.z *= -1.;\n\t\t\t\t\t\tfloat xz = length( velocity.xz );\n\t\t\t\t\t\tfloat xyz = 1.;\n\t\t\t\t\t\tfloat x = sqrt( 1. - velocity.y * velocity.y );\n\n\t\t\t\t\t\tfloat cosry = velocity.x / xz;\n\t\t\t\t\t\tfloat sinry = velocity.z / xz;\n\n\t\t\t\t\t\tfloat cosrz = x / xyz;\n\t\t\t\t\t\tfloat sinrz = velocity.y / xyz;\n\n\t\t\t\t\t\tmat3 maty =  mat3( cosry, 0, -sinry, 0    , 1, 0     , sinry, 0, cosry );\n\t\t\t\t\t\tmat3 matz =  mat3( cosrz , sinrz, 0, -sinrz, cosrz, 0, 0     , 0    , 1 );\n\n\t\t\t\t\t\tnewPosition =  maty * matz * newPosition;\n\t\t\t\t\t\tnewPosition += pos;\n\n\t\t\t\t\t\tvec3 transformed = vec3( newPosition );\n\t\t\t\t\t",e.vertexShader=e.vertexShader.replace(n,o),i=e},o=new r["N"](e,n),o.rotation.y=Math.PI/2,o.position.x=1300,o.position.z=-2400,o.position.y=300,o.castShadow=!0,o.receiveShadow=!0,g.add(o)}function it(t){for(var e=t.image.data,n=0,o=e.length;n<o;n+=4){var i=Math.random()*O-k,a=Math.random()*O-k,r=Math.random()*O-k;e[n+0]=i,e[n+1]=a,e[n+2]=r,e[n+3]=1}}function at(t){for(var e=t.image.data,n=0,o=e.length;n<o;n+=4){var i=Math.random()-.5,a=Math.random()-.5,r=Math.random()-.5;e[n+0]=10*i,e[n+1]=10*a,e[n+2]=10*r,e[n+3]=1}}function rt(t){!1!==t.isPrimary&&(C=t.clientX-B,q=t.clientY-N)}function st(){U=new r["wb"](Q,{font:Y,size:L,height:W,curveSegments:_,bevelThickness:K,bevelSize:J,bevelEnabled:!0}),U.computeBoundingBox(),U.computeVertexNormals();var t=-.5*(U.boundingBox.max.x-U.boundingBox.min.x);G&&(F=new r["N"](U,V),F.position.x=t,F.position.y=-Z,F.position.z=W,F.rotation.x=Math.PI,F.rotation.y=2*Math.PI,j.add(F))}function lt(){x.aspect=window.innerWidth/window.innerHeight,x.updateProjectionMatrix(),w.setSize(window.innerWidth,window.innerHeight)}function ct(){requestAnimationFrame(ct),j.position.x=-227,j.position.y=18,j.position.z=-600,j.rotation.y=6,j.rotation.x=600.02,j.rotation.z=219.9,ft()}tt();var dt=2700,ut=8;function ft(){var t,e=performance.now(),n=5e-4*e,o=Object(a["a"])(E);try{for(o.s();!(t=o.n()).done;){var s=t.value;mt(n,s)}}catch(c){o.e(c)}finally{o.f()}I.material.uniforms["time"].value+=1/60,ut<33.7&&(ut+=.1,dt-=10,x.position.x=dt*Math.sin(r["L"].degToRad(ut))-45,x.position.y=dt/3*Math.sin(r["L"].degToRad(ut)),x.position.z=dt*Math.cos(r["L"].degToRad(ut)));var l=(e-H)/1e3;l>1&&(l=1),H=e,S["time"].value=e,S["delta"].value=l,M["time"].value=e,M["delta"].value=l,i&&(i.uniforms["time"].value=e/1e3),i&&(i.uniforms["delta"].value=l),M["predator"].value.set(.5*C/B,-.5*q/N,0),C=1e4,q=1e4,z.compute(),i&&(i.uniforms["texturePosition"].value=z.getCurrentRenderTarget(D).texture),i&&(i.uniforms["textureVelocity"].value=z.getCurrentRenderTarget(P).texture),w.render(g,x)}function mt(t,e){e.obj.position.y=5*Math.sin(t+e.pos.x)+e.pos.y,e.obj.position.x=e.pos.x,e.obj.position.z=e.pos.z,e.obj.rotation.x=e.rot.x*t,e.obj.rotation.z=e.rot.z*t}}},v=m,h=(n("55eb"),n("2877")),p=Object(h["a"])(v,o,i,!1,null,"73d654bf",null);e["default"]=p.exports},8829:function(t,e,n){t.exports=n.p+"static/img/monitor.6dc778d9.png"},b3d6:function(t,e){t.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAJnSURBVFhHzZZNSh1BFIXfErIEl5AlZAkuwSXEaQaZZBpw5DSZZerQYcg0E0kICIoIQUGQGCQgBAKVfGVOc97h1uO1PNADx9d9u+rWuX/dLtoj4+kL+Hn3px18vf1/d4/zH7+73fFi/6xtvztvrw+vOlkD9j5dT9cVJgFsWux+mcjGj6e/2vO3J/0e5xyKs2evvrWtN8eTMGy+F7JXdtbjP0WDoYCKOMIxv7IhDJuvgxy28+H7ko0zErMFHF3ctfefb5bsZMvvtc5tiKkwFMCGVRFQAmzUPgVgU+l0X6UfDAWQ1kwta2R/eXDZIyUbKZSyQK71DEGzemAkQJE/hOylNI7ZAhTZQ0nmHLN7AFH8itTX1xClPxcRTq8khgIqsiaRGanWkHb6hYASswRsgtmMQwGkK8drU/RMzGpC6i3mNJBiPRvZISVbKwOjKQA48BcN9A9W+iLijb2IQE5H3sMUqJdWYiiAdKUT1mRfkFLgNqjOTzulw4cyMhRQMQXhbHJkdghGPpf29b//UKVxHaqp0g6yUSFZ8dfxJMC7l0Uge0BMsVWk+ckW87+rUgDXIAUQLTbgIqrsef3xR9QrX8W+WR+M0RQAHPqzEb3eFbqArKHSVAng4Ln9QjYIqvrntAvIg4S0V2MFczpGNugNCLoAbyKiE1JA1dUqV9pBlalSgH9SORSnNE4eiFDZyAZRYqsOEvyZpsvRBWiBut8nwslhjJdmf7QOOiTCsyssaDhtInqBa68519lEiKlqTZYSrK2mYaEXhqJ3UAoORnnWzuEl5PBVaxPTGFYjsi7YS3k8g+uiC3g8tPYXKuQ5cGlUAA0AAAAASUVORK5CYII="},b6d4:function(t,e,n){t.exports=n.p+"static/img/apprise.66c762f1.png"},f28c:function(t,e,n){t.exports=n.p+"static/img/waternormals.4418dde3.jpg"}}]);