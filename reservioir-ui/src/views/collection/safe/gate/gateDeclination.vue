<template>
  <div class="app-container">
    <record :sensor="sensor" :dialogVisible="dialogVisible" @changeShow="showHistory"></record>
    <dv-border-box9 style="padding: 10px; height: 80vh">
      <el-row>
        <el-col :span="6">
          <dv-decoration3 style="width: 320px;height: 30px"></dv-decoration3>
        </el-col>
        <el-col :span="10">
          <label class="w-label">参数选择：</label>
          <el-radio-group v-model="paraIndex">
            <el-radio :label="i" v-bind:key="item" v-for="(item,i) in paras" @change="select(paraIndex)">{{item}}
            </el-radio>
          </el-radio-group>
        </el-col>
        <el-col :span="8">
          <div id="lb-time" class="layui-inline">
            <label class="w-label" for="newest-time">最新监测时间：<span
              id="newest-time">{{newestTime}}</span></label>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <div id="div-main">
          <div id="div-img" style="width:100%;height:500px;margin-left: 10%;margin-top: 50px;"></div>
        </div>
      </el-row>
    </dv-border-box9>
  </div>
</template>

<script>

  import record from '@/views/collection/common/record'
  import zrender from 'zrender'
  import ImageShape from 'zrender/src/graphic/Image';
  import PolygonShape from 'zrender/src/graphic/shape/Polygon';
  import Text from 'zrender/src/graphic/Text';
  import Circle from 'zrender/src/graphic/shape/Circle';
  import LinearGradient from 'zrender/src/graphic/LinearGradient';
  import ShapeLine from "zrender/src/graphic/shape/Polyline";

  export default {
    name: "realtime",
    components: {record},
    data() {
      let paras = this.operator.getAttrArray(this.common.getData('gateDeclination'), 'name');
      return {
        transform: this.reservoir.getGate().getDeclinationSafe(),
        paras: paras,
        paraIndex: 1,
        sensor: null,
        dialogVisible: false,
        newestTime: '2016-08-01 10:00:00',

        zr: null,
        images: [],
        shapeGs: [],
        shapes: [],
      }
    },
    methods: {
      select(paraIndex) {
        this.paraIndex = paraIndex;
        this.updateSensors();
      },
      showRecord(sen) {
        this.sensor = sen;
        this.dialogVisible = true;
      },
      // 监听 子组件弹窗关闭后触发，有子组件调用
      showHistory(data) {
        this.dialogVisible = data !== 'false';
      },
      /**
       * 创建多边形
       * @param points 多个点
       * @param order
       * @returns {PolygonShape}
       */
      createShapePolygon(sensor) {
        let that = this;
        return new PolygonShape({
          style: {
            fill: 'rgba(20, 200, 200, 0.6)',
            lineWidth: 2
          },
          draggable: false,
          shape: {
            points: this.operator.createBackgroundRect(sensor.pos[0], sensor.pos[1], 100, 50),
          },
          states: {
            normal: {
              transition: '* 500 0 Linear'
            },
            hover: {
              shape: {
                points: [[0, 0], [1000, 0], [1000, 600], [0, 600]]
              }
            }
          },
          // 图形元素上绑定事件
          onclick: function () {
            that.lineShow(sensor);
          }
        });
      },
      /**
       * 创建一个圆形
       * @param color 颜色
       * @param radius 半径
       * @param order 次序
       * @returns {Circle}
       */
      createCircleShape(color, radius, order) {
        let position = this.findSensor(order).pos;
        let x = position[0] + 10;
        let y = position[1] + 30;

        let gradient = new LinearGradient();
        gradient.addColorStop(0, color);
        gradient.addColorStop(1, color);
        let shape = new Circle({
          position: [x, y],
          scale: [1, 1],
          shape: {
            cx: 0,
            cy: 0,
            r: 7
          },
          style: {
            fill: gradient,
            lineWidth: 5
          }
        });

        shape.animateShape(true).when(1000, {r: radius}).start();
        return shape;
      },
      /**
       * 创建图像文本内容
       * @param text 文本内容
       * @param order 次序
       * @returns {zrender/graphic/Text|Text|Text}
       */
      createShapeText(text, order) {
        let that = this;
        let position = this.findSensor(order).pos;
        let x = position[0] + 25;
        let y = position[1] + 5;

        return new Text({
          style: {
            text: text,
            x: x,
            y: y,
            textFont: 'bold 16px Arial',
            color: '#fff000',
            strokeColor: '#0ff000'
          },
          draggable: false,
          onclick: function () {
            that.lineShow(that.findSensor(order));
          }
        });
      },

      /**
       * 创建图片形状
       * @param imageName 图片名称
       * @param posX 横坐标
       * @param posY 纵坐标
       * @param width 宽度
       * @param height 高度
       * @param text 文本
       * @param order 次序
       * @returns {ImageShape}
       */
      createImageShape(imageName, posX, posY, width, height, text, order) {
        let that = this;
        let position = this.findSensor(order).pos;
        let x = position[0];
        let y = position[1] + 20;
        return new ImageShape({
          position: [x, y],
          scale: [1, 1],
          style: {
            x: 0,
            y: 0,
            image: require(`@/assets/images/common/` + imageName),
            width: 20,
            height: 20,
            sx: posX,
            sy: posY,
            sWidth: width,
            sHeight: height,
            text: text,
            hoverable: true,
            textAlign: 'start',
            textPosition: 'right',
            textFont: 'bold 16px Arial'
          },
          draggable: false,
          // 图形元素上绑定事件
          onclick: function () {
            that.lineShow(that.findSensor(order));
          }
        });
      },

      /**
       * 创建形状线条
       * @param order 次序
       * @returns {ShapeLine}
       */
      createShapeLine(order) {
        let that = this;
        return new ShapeLine({
          position: this.findSensor(order).pos,
          style: {
            stroke: "rgba(0, 0, 200, 0.8)",
            lineWidth: 2
          },
          shape: {
            points: [[10, 0], [10, 20], [10, 10], [0, 10], [20, 10]]
          },
          // 图形元素上绑定事件
          onclick: function () {
            that.lineShow(that.findSensor(order));
          }
        });
      },
      /**
       * 显示历史数据
       * */
      lineShow(sensor) {
        if (sensor && !sensor.invalid) {
          if (sensor.name === '沉降' && sensor.type === 0) {   //处理沉降中的基准点，让它不显示曲线
            sensor.url = '';
          }
          this.showRecord(sensor);
        }
      },
      setData(sensor) {
        let posX = 0;
        let posY = 0;
        let img;
        let txtTem;
        let shapeInfo;
        let sensors = this.common.getData('gateDeclination');
        if (sensor.name === '电压') {                                 //电压没有正负，单独处理
          for (let i = 0; i < sensors.length; i++) {
            if (sensor.id === sensors[i].id) {
              img = 'horizontal.png';
              this.zr.remove(this.shapeGs[i]);
              this.zr.add(this.shapes[i]);
              this.zr.remove(this.images[i]);
              txtTem = sensor.name + ":" + (value).toFixed(1) + sensor.unit;
              this.images[i] = this.createImageShape(img, posX,
                posY, 100, 100, txtTem, i);
              this.zr.add(this.images[i]);
            }
          }
        } else if (sensor.name === '液面') {                          //液面距离
          shapeInfo = this.setValue(150, 0, 320, 260, sensor);
          this.switchImage(shapeInfo, sensor);
        } else {                                                      //沉降位移的处理
          shapeInfo = this.setValue(310, 135, 140, 270, sensor);
          this.switchImage(shapeInfo, sensor);
        }
      },
      /**
       * 成功获取数据后的处理函数
       */
      updateSensors() {
        let sens = this.common.getData('gateDeclination');
        let newestTime = sens[0].time;
        for (let i = 0; i < sens.length; i++) {
          if (sens[i].time > newestTime) {
            newestTime = sens[i].time;
          }
          let sensorID = sens[i].id;
          let sensor = this.operator.findArrayItemByAttrValue(sens, 'id', sensorID);

          if (sensor && this.paras[this.paraIndex] === sensor.name) {
            this.setData(sensor);
          }
        }
        this.newestTime = new Date(newestTime).format("yyyy-MM-dd hh:mm:ss");
      },
      /**
       * 设置数据
       * @param posX1
       * @param posY1
       * @param posX2
       * @param posY2
       * @param sensor 传感器数据
       * */
      setValue(posX1, posY1, posX2, posY2, sensor) {
        let posX, posY, img, txtTem;
        if (sensor.value > 0) {
          posX = posX1;
          posY = posY1;
          img = 'orientation.png';
          this.zr.remove(this.shapeGs[sensor.type]);
          this.zr.add(this.shapes[sensor.type]);
        } else if (sensor.value < 0) {
          posX = posX2;
          posY = posY2;
          img = 'orientation.png';
          this.zr.remove(this.shapes[sensor.type]);
          this.zr.add(this.shapeGs[sensor.type]);
        } else {
          img = 'horizontal.png';
        }
        txtTem = this.operator.getPointText(sensor);
        return {'posX': posX, 'posY': posY, 'img': img, 'txtTem': txtTem};
      },
      /**
       * 查找传感器数据
       *
       * */
      findSensor(order) {
        let sensors = this.common.getData('gateDeclination');
        let name = this.paras[this.paraIndex];
        return this.operator.getSensor(this.operator.getSensors(sensors, 'type', order), 'name', name, true);
      },
      /**
       * 切换图片
       * @param shapeInfo 图像参数
       * @param sensor 传感器数据
       * */
      switchImage(shapeInfo, sensor) {
        this.zr.remove(this.images[sensor.type]);
        this.images[sensor.type] = this.createImageShape(shapeInfo.img, shapeInfo.posX,
          shapeInfo.posY, 100, 100, shapeInfo.txtTem, sensor.type);
        this.zr.add(this.images[sensor.type]);
      },
    },
    mounted() {
      this.zr = zrender.init(document.getElementById("div-img"));
      let image = new ImageShape({
        scale: [1.1, 1],
        style: {
          x: -80,
          y: 0,
          image: require(`../../../../assets/images/${this.common.CURRENT_RESERVOIR}/gateDisplacement.jpg`),
          width: 1000,
          height: 600
        },
        draggable: false
      });
      this.zr.add(image);

      let sens = this.operator.getSensors(this.common.getData('gateDeclination'), 'name', 'x倾斜');
      for (let i = 0; i < sens.length; i++) {
        this.zr.add(this.createShapePolygon(sens[i]));
        this.shapes.push(this.createCircleShape('#0000ff', sens[i].size, i));
        this.shapeGs.push(this.createCircleShape('#0ff000', sens[i].size, i));

        this.zr.add(this.createShapeText(sens[i].title, i));
        image = this.createImageShape(sens[i].image, '', '', 100, 100, sens[i].text, i);
        this.images.push(image);
        this.zr.add(image);
        this.zr.add(this.createShapeLine(i));
      }

      this.updateSensors();
      let that = this;
      setInterval(function () {
        that.updateSensors();
      }, this.common.TIME_SPAN);
    }
  }


</script>

<style scoped>
  .app-container {
    margin: 0;
    background: url("../../../../assets/images/bg.png") repeat-y;
    color: #dfe6ec;
    height: 100vh;
  }

  ::v-deep .w-label {
    font-size: 24px;
    font-family: 楷体, serif;
    color: #eceebc;
  }

  ::v-deep .el-radio__label {
    font-size: 24px;
    font-family: 楷体, serif;
    color: #eceebc;
  }

  ::v-deep .el-radio__input {
    vertical-align: baseline;
  }
</style>
