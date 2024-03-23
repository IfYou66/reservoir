<template>
  <el-dialog width="1000px" title="历史数据" :visible.sync="showDialog" @close="handleClose" @opened="handleOpen">
    <el-container>
      <el-header>
        <div>
          <el-row :gutter="20">
            <el-col :span="16">
              <span style="color: #9fecff">选择日期：</span>
              <el-button type="primary" icon="el-icon-caret-left" style="width: 20px" @click="getPre"></el-button>
              <el-date-picker
                v-model="dateRange"
                type="daterange"
                align="right"
                unlink-panels
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd"
                :picker-options="pickerOptions">
              </el-date-picker>
              <el-button type="primary" icon="el-icon-caret-right" style="width: 20px" @click="getNext"></el-button>
            </el-col>
            <el-col :span="4">
              <el-button type="warning" round @click="queryData">数据查询</el-button>
            </el-col>
            <el-col :span="4">
              <el-button type="primary" round @click="exportData">数据导出</el-button>
            </el-col>
          </el-row>
        </div>
      </el-header>
      <div id="div-line"></div>

      <el-footer style="text-align: center">
        <el-button @click="showDialog = false" style="width:150px; background-color: #c0d9d4"
                   icon="el-icon-switch-button">关闭弹窗
        </el-button>
      </el-footer>
    </el-container>
  </el-dialog>
</template>

<script>
  let excel = require('@/api/collection/excel');
  export default {
    name: "record",
    data() {
      return {
        pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        dateRange: [new Date().format("yyyy-MM-dd"), new Date().format("yyyy-MM-dd")],
        loading: '',
        data: '',
        showDialog: false,
        lineChart: null,
        lineOption: null
      };
    },
    props: {
      sensor: {
        type: Object,
        default: () => ({})
      },
      dialogVisible: {type: Boolean, default: false}
    },
    watch: {
      // 监听 addOrUpdateVisible 改变
      dialogVisible(oldVal, newVal) {
        this.showDialog = this.dialogVisible
      },
    },
    methods: {
      // 弹出框关闭后触发
      handleClose() {
        // 子组件调用父组件方法，并传递参数
        this.$emit('changeShow', 'false')
      },
      handleOpen() {
        // 子组件调用父组件方法，并传递参数
        this.refreshData();
      },
      getPre() {
        let start = new Date(this.dateRange[0]);
        let end = new Date(this.dateRange[1]);
        let span = end.getTime() - start.getTime() + 24 * 3600 * 1000;
        start.setTime(start.getTime() - span);
        end.setTime(end.getTime() - span);
        this.dateRange[0] = start.format('yyyy-MM-dd');
        this.dateRange[1] = end.format('yyyy-MM-dd');
        this.$set(this, "dateRange", [start.format('yyyy-MM-dd'), end.format('yyyy-MM-dd')]);
        this.refreshData();
      },
      getNext() {
        let start = new Date(this.dateRange[0]);
        let end = new Date(this.dateRange[1]);
        let span = end.getTime() - start.getTime() + 24 * 3600 * 1000;
        start.setTime(start.getTime() + span);
        end.setTime(end.getTime() + span);
        this.dateRange[0] = start.format('yyyy-MM-dd');
        this.dateRange[1] = end.format('yyyy-MM-dd');
        this.$set(this, "dateRange", [start.format('yyyy-MM-dd'), end.format('yyyy-MM-dd')]);
        this.refreshData();
      },
      refreshData() {
        this.initChart();
        this.loading = this.openLoading();
        //开始获取数据
        if (this.sensor.id) {
          this.request.sendRecordRequest(this.sensor.url, this.common.SENSOR_RECORD_COMMOND,
            this.sensor.id, this.dateRange[0], this.dateRange[1], this.handle);
        } else {
          this.data = [];
          this.addSeries(10, -10);
          this.loading.close();
          this.$message.warning('没有数据');
        }
      },

      queryData() {
        this.refreshData();
      },

      initChart() {
        this.lineChart = this.$echarts.init(document.getElementById('div-line'));
        this.lineOption = {
          title: {
            text: this.sensor.name + '(' + this.sensor.unit + ')',
            textStyle: {
              color: '#eddee3',
              fontStyle: '',
            },
          },

          dataZoom: [{
            show: true,
            realtime: true,
            start: 0.01,
            end: 100
          }],

          grid: {
            left: '5%',
            right: '4%',
            bottom: '13%',
            show: false,
            containLabel: true
          },
          xAxis: {
            type: 'time',
            axisLine: {
              show: true,
              onZero: false,
              color: '#e4f3cd',
            },
            axisTick: {
              show: false
            },
            axisLabel: {
              show: true,
              textStyle: {
                color: '#e4f3cd'
              }
            },
            z: 10
          },
          yAxis: {
            axisLine: {
              show: true,
              lineStyle: {
                color: '#8edfb9',
              }
            },
            axisTick: {
              show: true
            },
            axisLabel: {
              show: true,
              textStyle: {
                color: '#e8e8e8'
              }
            },
          },

          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              label: {
                backgroundColor: '#6a7985'
              }
            }
          },
          series: []
        };
        this.lineChart.setOption(this.lineOption);
      },

      exportData() {
        let title;
        let lineName = this.sensor.name + '(' + this.sensor.unit + ')';
        title = ['时间', lineName];
        if (this.data[0] && typeof this.data[0][0] !== 'string') {
          for (let i = 0; i < this.data.length; i++) {
            this.data[i][0] = this.data[i][0].format('yyyy-MM-dd hh:mm:ss');
          }
        }
        excel.convert(this.data, lineName, title);
      },


      addSeries(max, min) {
        let series = {
          name: this.sensor.name + '(' + this.sensor.unit + ')',
          type: 'line',
          symbolSize: 2,
          symbol: 'dot',
          smooth: true,
          textStyle: {
            fontSize: 15,
            color: '#fff'
          },
          lineStyle: {
            width: 3,
            shadowColor: 'rgba(255,240,205,0.76)',
            shadowBlur: 10,
            shadowOffsetY: 8
          },
          itemStyle: {
            normal: {
              label: {
                show: false,//显示圆点顶部的数字
                position: 'top',
                formatter: function (params) {
                  return params.value;
                },
                rich: {
                  color1: {
                    color: '#f7ba0e'
                  },
                  color2: {
                    color: '#42a1fe'
                  }
                },
                textStyle: {
                  color: '#496c71'
                },
              },
              color: "#488f10",
              width: 8,
              lineStyle: {
                width: 2,
                color: '#b3d9c0'
              }
            },
          },
          data: this.data
        };
        this.lineOption.xAxis.min = new Date((this.dateRange[0]).replace(/-/g, '/')).getTime() - 1000 * 60;
        this.lineOption.xAxis.max = new Date((this.dateRange[1]).replace(/-/g, '/')).getTime() + 1000 * 60 * 60 * 24;
        this.lineOption.yAxis.min = (min === this.common.BOUNDARY) ? 4 : Math.round(min - (max - min) * 0.2 - 10);
        this.lineOption.yAxis.max = (max === -this.common.BOUNDARY) ? -4 : Math.round(max + (max - min) * 0.2 + 10);
        this.lineOption.series = [];
        this.lineOption.series.push(series);
        this.lineChart.setOption(this.lineOption, true);
      },



      /**
       * 成功获取数据后的处理函数
       * @param result 从服务器获取的数据
       */
      handle(result) {
        if (!result) {
          this.loading.close();
          this.$message.info('没有数据');
          this.data = [];
          this.addSeries(1, -1);
          return;
        }
        let resultArr = [];
        let max = -this.common.BOUNDARY;
        let min = this.common.BOUNDARY;
        for (let i = 0; i < result.length; i++) {
          let value = parseFloat(result[i].DataValue);
          let flag = false;
          if (this.sensor.name === '库容') {
            value = this.reservoir.getRelations().getCapacityRelationShip('capacity',
              this.common.correct(parseFloat(value), this.sensor.bias));
          } else if (this.sensor.name === '水面面积') {
            value = this.reservoir.getRelations().getArea('area', this.common.correct(parseFloat(value), this.sensor.bias));
          } else if (this.sensor.name === '可用水量') {
            let capacity = this.reservoir.getRelations().getCapacityRelationShip('capacity',
              this.common.correct(parseFloat(value), this.sensor.bias));
            value = capacity - this.base.getBaseInfo().deadCapacity
          } else if (this.sensor.name.indexOf('振动') > 0) {
            value = parseFloat(result[i].DataValue);
          } else {
            value = this.common.correct(parseFloat(result[i].DataValue), this.sensor.bias);
            if (value < this.sensor.high && value > this.sensor.low) {
              resultArr.push([new Date(result[i].RevTime), this.operator.fix(value)]);
              if (min > value) min = value;
              if (max < value) max = value;
            }
            continue;
          }

          resultArr.push([new Date(result[i].RevTime), this.operator.fix(value)]);
          if (min > value) min = value;
          if (max < value) max = value;
        }
        //去重
        //this.data = this.common.removeRepeat(resultArr, 'RevTime');
        this.data = resultArr;
        this.addSeries(max, min);
        this.loading.close();
      },
    },
    mounted() {

    },


  }
</script>

<style scoped>
  body, html, .main-body {
    height: 90%;
  }

  button {
    margin: 0 10px;
  }

  ::v-deep .el-dialog {
    width: 1100px;
  }

  ::v-deep .el-dialog__body {
    background-color: #082752;
  }

  .el-range-editor--medium .el-range-input {
    font-size: 14px;
    background-color: #f4ffff;
  }


  #div-img > img {
    width: 600px;
  }

  #div-line {
    display: block;
    height: 300px;
    width: 900px;
    margin: 10px auto;
  }

  ::v-deep .el-dialog__header {
    background-color: #86987526;
    font-size: 16pt;
  }

</style>
