<template>
  <div class='app-container'>
    <div id='first'>
      <canvas id="digitalRain" style="height: 100%;width:100%;">
      </canvas>

      <div id="mainMap"
           style="position: absolute; z-index: 10; left:10%; top:10%; height:50%;width: 50%;padding:10px;background:#0c0d0f00">
      </div>

      <div id="imgDiv"
           style="position: absolute; z-index: 10; left:30%; top:500px; width: 600px;padding:10px;background:#ffffff00">
        <img :src="require(`@/assets/images/title.jpg`)" alt="" style="width: 120%;height: 120%;">
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: "first",
    methods: {
      jump() {

        const TIME_COUNT = 20;
        if (!this.timer) {
          this.count = TIME_COUNT;
          this.show = false;
          this.timer = setInterval(() => {
            if (this.count > 0 && this.count <= TIME_COUNT) {
              this.count--;
            } else {
              this.show = true;
              clearInterval(this.timer);
              this.timer = null;
              //跳转的页面写在此处
              this.stopMusic();
              this.$router.push({path: this.redirect || "/login"})
            }
          }, 1000)
        }
      },

      jumpNow() {
        this.$router.push({path: this.redirect || "/login"});
        clearInterval(this.timer);
        this.timer = null;
      },

      getEcharts() {
        // 基于准备好的dom，初始化echarts实例
        const json = require('@/api/flash/tz.json')
        const reservoirs = require('@/api/flash/reservoirs.json')
        this.$echarts.registerMap('滕州', json);
        var chart = this.$echarts.init(document.getElementById('mainMap'));

        var series = [];//地图展现数据
        //24个省市经度纬度
        var geoCoordMap = function () {
          let list = reservoirs.list;
          let obj = {};
          for (let i = 0; i < list.length; i++) {
            obj[list[i].label] = [list[i].lon, list[i].lat, list[i].type];
          }
          return obj;
        }();

        var fromdata = '滕州市';//默认飞线原点
        //初始化飞线数据
        var XAData = function () {
          let list = reservoirs.list;
          let obj = [];
          for (let i = 0; i < list.length; i++) {
            let item = [{name: list[i].label}, {name: '滕州市', value: 95}];
            obj.push(item);
          }
          return obj;
        }();

        var convertData1 = function (data) {
          let res = [];
          for (let i = 0; i < data.length; i++) {
            let dataItem = data[i];
            let fromCoord = geoCoordMap[dataItem[0].name];
            let toCoord = geoCoordMap[dataItem[1].name];
            if (fromCoord && toCoord) {
              res.push({
                fromName: dataItem[0].name, toName: dataItem[1].name, coords: [fromCoord, toCoord]
              });
            }
          }
          return res;
        };

        [[fromdata, XAData]].forEach(function (item, i) {
          series.push(
            {
              type: 'effectScatter',
              coordinateSystem: 'geo',
              zlevel: 15,
              symbolSize: 8,
              rippleEffect: {
                period: 8, brushType: 'stroke', scale: 4
              },
              itemStyle: {
                color: '#ff9815',
                opacity: 1
              },
              data:
                function () {
                  let list = reservoirs.list;
                  let obj = [];
                  for (let i = 0; i < list.length; i++) {
                    if (list[i].type === 1) {
                      let item = [list[i].lon, list[i].lat, list[i].label];
                      obj.push(item);
                    }
                  }
                  return obj;
                }(),
            },
            {
              type: 'effectScatter',
              coordinateSystem: 'geo',
              zlevel: 15,
              symbolSize: 4,
              rippleEffect: {
                period: 8, brushType: 'stroke', scale: 4
              },
              itemStyle: {
                color: '#ff524d',
                opacity: 1
              },
              data:
                function () {
                  let list = reservoirs.list;
                  let obj = [];
                  for (let i = 0; i < list.length; i++) {
                    if (list[i].type === 2) {
                      let item = [list[i].lon, list[i].lat, list[i].label];
                      obj.push(item);
                    }
                  }
                  return obj;
                }(),
            },
            {
              type: 'effectScatter',
              coordinateSystem: 'geo',
              zlevel: 15,
              symbolSize: 4,
              rippleEffect: {
                period: 8, brushType: 'stroke', scale: 4
              },
              itemStyle: {
                color: '#1bff28',
                opacity: 1
              },
              data:
                function () {
                  let list = reservoirs.list;
                  let obj = [];
                  for (let i = 0; i < list.length; i++) {
                    if (list[i].type === 3) {
                      let item = [list[i].lon, list[i].lat, list[i].label];
                      obj.push(item);
                    }
                  }
                  return obj;
                }(),
            },
            {
              type: 'effectScatter',
              coordinateSystem: 'geo',
              zlevel: 15,
              symbolSize: 12,
              rippleEffect: {
                period: 6, brushType: 'stroke', scale: 8
              },
              itemStyle: {
                color: '#FF5722',
                opacity: 1
              },
              data: item[1].map(function (dataItem) {
                return {
                  name: dataItem[1].name,
                  value: geoCoordMap[dataItem[1].name].concat([dataItem[1].name]),
                  tooltip: {
                    formatter: dataItem[1].name
                  }
                };
              }),
            },
            {
              type: 'lines',
              coordinateSystem: 'geo',
              zlevel: 15,

              effect: {
                show: true, period: 5, trailLength: 0, symbol: 'arrow', color: '#01AAED', symbolSize: 8,
              },
              lineStyle: {
                normal: {width: 1.2, opacity: 0.6, curveness: 0.2, color: '#FFB800'}
              },
              data: convertData1(item[1])
            }
          )
        });

        let option = {

          color: ['#fc5353', '#f4fc6c', '#e68b55', '#9a68ff', '#ff60c5'],

          tooltip: {
            backgroundColor: "rgba(255,255,255,0.8)", //设置背景图片 rgba格式
            color: "black",
            borderWidth: "1",
            borderColor: "gray",
            textStyle: {
              color: "#059bbd"
            },
            trigger: 'item',
            formatter: function (params) {
              if (params.value) {
                return params.data[2];
              } else {
                return params.label;
              }
            }
          },
          legend: {
            orient: 'horizontal',
            left: '27%',
            top: '5%',
            data: ['高线'],
            textStyle: {
              color: '#ffffff'
            },
            icon: 'circle'
          },
          geo: {
            map: '滕州',
            zlevel: 10,
            layoutCenter: ['48%', '50%'],
            roam: true,
            show: true,
            layoutSize: "80%",
            zoom: 1.08,
            label: {
              normal: {
                show: true,//地图上的省份名称是否显示
                textStyle: {
                  fontSize: 12,
                  color: '#43D0D6'
                }
              },
              emphasis: {
                show: true
              }
            },
            itemStyle: {
              normal: {
                color: '#062031',
                borderWidth: 1.1,
                borderColor: '#43D0D6'
              },
              emphasis: {
                areaColor: '#43D0D6'
              }
            }
          },
          series: series
        };
        chart.setOption(option);
        chart.on('click', function (params) {

        });
      },


      playMusic() {
        // 为了防止第二次创建
        let playState = true

        function testAutoPlay() {
          // 返回一个promise以告诉调用者检测结果
          return new Promise(resolve => {
            if (playState) {
              let audio;
              let audios = document.getElementsByTagName('audio');
              if (audios.length > 0) {
                audio = audios[0];
              } else {
                audio = document.createElement('audio');
              }
              audio.src = "flash.mp3";
              //循环播放，如果不需要可注释
              audio.loop = "loop"
              document.body.appendChild(audio);
              let autoplay = true;
              // play返回的是一个promise
              audio.play().then(() => {
                // 支持自动播放
                autoplay = true;
                console.log("正常播放")
              }).catch(err => {
                // 不支持自动播放
                console.log("不支持播放")
                autoplay = false;
              }).finally((e) => {
                resolve(autoplay);
              });
              playState = false
            } else {
              resolve(false)
            }

          });
        }

        let audioInfo = {
          autoplay: false,
          testAutoPlay() {
            return testAutoPlay()
          },
          // 监听页面的点击事件，一旦点过了就能autoplay了
          setAutoPlayWhenClick() {
            function setAutoPlay() {
              // 设置自动播放为true
              audioInfo.autoplay = true;
              document.removeEventListener('click', setAutoPlay);
              document.removeEventListener('touchend', setAutoPlay);
            }

            document.addEventListener('click', setAutoPlay);
            document.addEventListener('touchend', setAutoPlay);
          },
          init() {
            // 检测是否能自动播放
            audioInfo.testAutoPlay().then(autoplay => {
              if (!audioInfo.autoplay) {
                audioInfo.autoplay = autoplay;
              }
            });
            // 用户点击交互之后，设置成能自动播放
            audioInfo.setAutoPlayWhenClick();
          }
        };
        // PC端
        document.addEventListener('click', () => {
          audioInfo.init();
        });
      },

      stopMusic() {
        let audios = document.getElementsByTagName('audio');
        if (audios.length > 0) {
          audios[0].src = '';
          audios[0].pause();
        }
      }
    },
    mounted() {
      this.getEcharts();
      this.jump();

      this.playMusic();

      let that = this;
      document.addEventListener('dblclick', function () {
        that.$router.push({path: that.redirect || "/login"});
        that.stopMusic();
      });

      let drCav = document.getElementById("digitalRain");

      /*将画布大小设置为窗口文档显示区大小*/
      let width = window.innerWidth;
      let height = window.innerHeight;
      drCav.width = width;
      drCav.height = height;

      let fontsize = 16;                          //数字字体大小
      let columns = Math.ceil(width / fontsize);  //列数（向上取整）
      let dropLine = [];
      for (let i = 0; i < columns; i++) {
        dropLine[i] = 0;
      }

      /*Run*/
      if (drCav.getContext) {
        let ctx = drCav.getContext("2d");
        let timer = setInterval(function () {
          ctx.fillStyle = "rgba(0,0,0,0.07)";   //设置透明度，逐渐覆盖之前的数字
          ctx.fillRect(0, 0, width, height);       //填充画布

          ctx.fillStyle = "#06643b";
          ctx.font = fontsize + "px Simsun";
          for (let i = 0; i < columns; i++) {
            let figure = Math.floor(Math.random() * 10);  //生成0~9的伪随机数

            /*绘制数字(核心部分)*/
            ctx.fillText(figure, i * fontsize, dropLine[i] * fontsize);
            if (dropLine[i] * fontsize > height || Math.random() > 0.98) {
              dropLine[i] = 0;
            }
            dropLine[i]++;
          }
          width++;
        }, 60);
      }

    }
  }
</script>

<style scoped>
  .app-container {
    margin: 2px 0px;

    padding: 0px;
    background: #000000
  }

  @-webkit-keyframes scaleDraw {
    0% {
      -webkit-transform: scale(1);
    }
    25% {
      -webkit-transform: scale(1.5);
    }
    50% {
      -webkit-transform: scale(1.8);
    }
    75% {
      -webkit-transform: scale(2.2);
    }
  }

  #mainMap, #imgDiv {
    -webkit-animation-name: scaleDraw;
    -webkit-animation-timing-function: ease-in-out;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-duration: 40s;
    -webkit-animation-direction: alternate;
  }

  body {
    padding: 0;
  }

  img {
    margin: 0;
  }

  #first {
    display: block;
  }

  iframe {
    display: none;
  }
</style>
