<template>
  <div class="app-container">
    <record :sensor="sensor" :dialogVisible="dialogVisible" @changeShow="showHistory"></record>
    <dv-border-box9 style="padding: 10px; height: 80vh">
      <el-row>
        <el-col :span="6">
          <dv-decoration3 style="width: 320px;height: 30px"></dv-decoration3>
        </el-col>
        <el-col :span="8">
          <label class="w-label">断面选择：</label>
          <el-radio-group v-model="paraIndex">
            <el-radio :label="i" v-bind:key="item" v-for="(item,i) in paras" @change="select(paraIndex)">{{item}}
            </el-radio>
          </el-radio-group>
        </el-col>
        <el-col :span="10">
          <div id="lb-time" class="layui-inline">
            <label class="w-label" for="newest-time">最新监测时间：<span
              id="newest-time">{{newestTime}}</span></label>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <div id="div-main">
          <div id="div-img" style="width:100%;height:500px;margin-top: 50px;"></div>
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
      let sensors = this.common.getData('gateSeepage');
      let paras = this.operator.getAttrArray(sensors, 'section');
      return {
        seepage: this.reservoir.getGate().getSeepageSafe(),
        sensors: sensors,
        paras: paras,
        paraIndex: 1,
        sensor: null,
        dialogVisible: false,
        newestTime: '2016-08-01 10:00:00',
        setEvent: 0,
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
       * 显示历史数据
       * */
      lineShow(order) {
        let sensor = this.findSensor(order);
        if (sensor && !sensor.invalid) {
          if (sensor.name === '沉降' && sensor.type === 0) {   //处理沉降中的基准点，让它不显示曲线
            sensor.url = '';
          }
          this.showRecord(sensor);
        }
      },

      /**
       * 查找传感器数据
       *
       * */
      findSensor(order) {
        let name = this.paras[this.paraIndex];
        return this.operator.getSensor(this.operator.getSensors(this.sensors, 'type', order), 'name', name, true);
      },
      /**
       * 成功获取数据后的处理函数
       */
      updateSensors() {
        let chartWaterLevel = this.$echarts.init(document.getElementById('div-img'));
        chartWaterLevel.setOption(this.seepage.createGateOption(this.paraIndex), true);

        if (this.setEvent === 0) {
          this.setEvent++;
          chartWaterLevel.on('click', function (params) {
            show(params);
          }, false);
        } else {
          chartWaterLevel.off("click");
          chartWaterLevel.on('click', function (params) {
            show(params);
          }, false);
        }

        //刷新时间
        let newestTime = this.sensors[0].time;
        for (let i = 0; i < this.sensors.length; i++) {
          if (this.sensors[i].time > newestTime) {
            newestTime = this.sensors[i].time;
          }
        }
        this.newestTime = (new Date(newestTime)).format("yyyy-MM-dd hh:mm:ss");
      },
      show(params) {
        if (params.componentType === 'markPoint') {
          let sensors = this.operator.getSensors(this.common.loadSensors(), 'name', '水位').concat(this.operator.getSensors(this.sensors, 'type', this.paras[this.paraIndex]));
          let sensor = this.operator.findArrayItemByAttrValue(sensors, 'index', params.seriesIndex);
          if (sensor) {
            this.showRecord(sensor);
          }
        }
      },
    },
    mounted() {

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
