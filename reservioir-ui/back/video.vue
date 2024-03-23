<template>
  <div class="app-container">
    <el-tabs>
      <el-tab-pane :label="point.name" :name="point.name" v-for="(point,i) in points">
        <div style="float:left;width: 10%;">
          <div v-for="(item,i) in point.points" >
            <el-radio v-model="order" :label="item.id" border>{{item.name}}</el-radio>
          </div>
        </div>
        <div style="float:left;width:89%;">
          <img src="../../../../assets/images/heihushan/video.png" alt="">
        </div>

      </el-tab-pane>

    </el-tabs>
    <!--    <el-tabs>-->
    <!--    <el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>-->
    <!--    <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>-->
    <!--    <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>-->
    <!--    <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>-->
    <!--  </el-tabs>-->
  </div>

</template>

<script>
  // const common = require('@/api/data/common');
  const reservoir = require('@/api/data/heihushan/reservoir');
  export default {
    name: "vd",
    data() {
      return {
        points: reservoir.getVideo(),
        activeIndex: '1',
        activeIndex2: '1',
        order: '1'
      };

      // let video = reservoir.getVideo();
      // let videoID = "";
      // let urlServer = 'http://58.58.27.77:8084/Handler.ashx';
      // let player = null;
      // let tabIndex = 0;
      // $.support.ajax = true;
      // iniUI();
      //
      // //初始化界面
      // function iniUI() {
      //   for (let i = 0; i < video.length; i++) {
      //     $('#data-title').append('<li class="layui-this">' + video[i].name + '</li>');
      //     $('#data-content').append(
      //       '<div class="layui-tab-item" id="title-' + i + '">\n' +
      //       '                        <form class="layui-form" action="">\n' +
      //       '                            <div class="layui-form-item left-content" id="left-list-' + i + '">\n' +
      //       '\n' +
      //       '                            </div>\n' +
      //       '                        </form>\n' +
      //       '                        <div class="right-content">\n' +
      //       '                            <div class="right-content-inner" onclick="setControls()" id="view-part-' + i + '">\n' +
      //       '                            </div>\n' +
      //       '                        </div>\n' +
      //       '                    </div>'
      //     );
      //   }
      //
      //   //默认显示第一个
      //   $('.layui-tab-title li').eq(0).addClass('layui-this').siblings().removeClass('layui-this');
      //   $('.layui-tab-item').eq(0).addClass('layui-show').siblings().removeClass('layui-show');
      //   $('#title-0').addClass('layui-show');
      //   addList(0);
      //   doPointView(video[0].videoId);
      // }
      //
      // window.setControls = function () {
      //   let getDisplay = document.getElementById('controls').style.display;
      //   if (getDisplay === 'none') {
      //     document.getElementById('controls').style.display = 'block';
      //   } else {
      //     document.getElementById('controls').style.display = 'none';
      //   }
      // };
      //
      // window.startControl = function (direction) {
      //   let name = "startControl";
      //   if (videoID.length > 0) {
      //     let data1 = {name: name, value: videoID, direction: direction};
      //     sendAjax(urlServer, data1);
      //   }
      // };
      //
      // window.stopControl = function () {
      //   let name = "stopControl";
      //   if (videoID.length > 0) {
      //     let data1 = {name: name, value: videoID};
      //     sendAjax(urlServer, data1);
      //   }
      // }
      //
      // //初始化界面
      // function addList(order) {
      //   let pointList = video[order].points;
      //   for (let j = 0; j < pointList.length; j++) {
      //     if (j === 0) {
      //       $('#left-list-' + order).append('<div class="layui-input-block">\n' +
      //         '                                    <input type="radio" name="point" lay-filter="point" checked value="' +
      //         pointList[j].id + '" title="' + pointList[j].name + '"\n' +
      //         '                                           >\n' +
      //         '                                </div>');
      //     } else {
      //       $('#left-list-' + order).append('<div class="layui-input-block">\n' +
      //         '                                    <input type="radio" name="point" lay-filter="point" value="' +
      //         pointList[j].id + '" title="' + pointList[j].name + '"\n' +
      //         '                                           >\n' +
      //         '                                </div>');
      //     }
      //   }
      //   form.render();
      // }
      //
      // form.on("radio(point)", function (data) {
      //   $("input[name='point']:checked").css('color', 'red');
      //   doPreset(data.value);
      // });
      //
      //
      // $('.layui-tab-title').on('click', function (data) {
      //   let item = getItemByName(data.target.innerHTML);
      //   if ($('#left-list-' + item.id).html().trim() === '') {
      //     addList(item.id);
      //   }
      //   tabIndex = item.id;
      //   doPointView(item.videoId);
      // });
      //
      //
      // function doPointView(idTem) {
      //   let name = "getPointView";
      //   videoID = idTem;
      //   if (videoID.length > 0) {
      //     let data = {name: name, value: videoID};
      //     sendAjax(urlServer, data);
      //   }
      // }
      //
      // window.doPreset = function (index) {
      //   let set = $("input[name='radio2']:checked").val();
      //   if (set > 0) {
      //     clearPreset(index);
      //   } else {
      //     movePreset(index);
      //   }
      // };
      //
      // function movePreset(index) {
      //   let name = "movePreset";
      //   if (videoID.length > 0) {
      //     let data1 = {name: name, value: videoID, index: index};
      //     sendAjax(urlServer, data1);
      //   }
      // }
      //
      // function clearPreset(index) {
      //   let name = "clearPreset";
      //   if (videoID.length > 0) {
      //     let data1 = {name: name, value: videoID, index: index};
      //     sendAjax(urlServer, data1);
      //   }
      // }
      //
      // function sendAjax(url, data) {
      //   $.ajax({
      //     type: "POST",
      //     url: url,
      //     data: data,
      //     success: function (msg) {
      //       dataResponse(msg);
      //     }
      //   });
      // }
      //
      // //回调函数
      // function dataResponse(text) {
      //   let index1 = text.indexOf("$");
      //   let name = text.substring(0, index1);
      //   let value = "";
      //   if (text.length > index1)
      //     value = text.substring(index1 + 1, text.length);
      //   if (value.length > 1) {
      //     let obj = $.parseJSON(value);
      //     if (obj != null) {
      //       if (name === "getPointView") {
      //         for (let i = 0; i < obj.length; i++) {
      //           setVideo(obj[i].HLS);
      //           break;
      //         }
      //       }
      //     }
      //   }
      // }
      //
      // function getItemByName(name) {
      //   for (let i = 0; i < video.length; i++) {
      //     if (name === video[i].name) {
      //       return video[i];
      //     }
      //   }
      // }
      //
      // function setVideo(hls) {
      //   $("#player").remove();
      //   $("#view-part-" + tabIndex).append('<video class="player" id="player" muted="muted"  poster="" playsInline webkit-playsinline autoplay> <source id="hls" src="' + hls + '" type="application/x-mpegURL" /> </video>');
      //   player = iniPlayer(hls);
      // }
      //
      // function iniPlayer(hls) {
      //   player = new EZUIPlayer("player");
      //   player.on('error', function () {
      //   });
      //   player.on('play', function () {
      //   });
      //   player.on('pause', function () {
      //   });
      //   player.on('waiting', function () {
      //   });
      // }
    },

    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }

  }
</script>

<style scoped>
  ::v-deep .el-tabs__nav-scroll > div > div {
    background-color: #9fecff;
    width: 170px !important;
  }
</style>
