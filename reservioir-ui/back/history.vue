<template>
  <div class="main-body">
    <div class="el-card__body" style="margin-top: 10px">
      <el-row>
        <el-col :span="12">
          <label class="el-form-item__label">日期选择:</label>
          <el-date-picker
            v-model="value"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-col>
        <el-col :span="12">
          <el-button type="primary">往前</el-button>
          <el-button type="primary">数据查询</el-button>
          <el-button type="primary">往后</el-button>
          <el-button type="primary">导出</el-button>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <label class="el-form-item__label">类别选择:</label>
          <el-select v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>

        <el-col :span="12">
          <label class="el-form-item__label">参数选择:</label>
          <el-select v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>
      </el-row>
    </div>
    <div id="div-line">

    </div>
  </div>
</template>

<script>

  const operator = require('@/api/data/operator');
  const common = require('@/api/data/common');
  const reservoir = require('@/api/data/'+common.CURRENT_RESERVOIR+'/reservoir');
  const datetime = require('@/api/data/datetime');

  export default {
    data() {
      return {
        options: [{
          value: '选项1',
          label: '关键参数'
        }, {
          value: '选项2',
          label: '气象参数'
        }, {
          value: '选项3',
          label: '水质参数'
        }],
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
        value: '',
        tiem: ['01.02', '01.03', '01.04', '01.05', '01.06', '01.07', '01.08'],

      };
    },
    mounted() {
      this.drawLine();
    },
    methods: {
      drawLine() {
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('div-line'))
        // 绘制图表
        myChart.setOption({
          title: {
            text: '水位(m)',
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: this.tiem,

            axisTick: {
              alignWithLabel: true
            }
          }],
          yAxis: [{
            type: 'value'
          }],
          itemStyle: {
            color: '#06bd73'
          },
          series: [{
            name: '直接访问',
            type: 'line',
            barWidth: '60%',
            data: [10, 52, 200, 334, 390, 330, 220]
          }]
        });
      },
    }

  };


</script>

<style scoped>
  html, body {
    height: 95%;
    padding: 0;
    margin: 0;
  }

  .main-body {
    height: 100%;
  }

  .layui-form-label {
    font-size: 18px;
    font-family: 华文楷体, serif;
    width: 120px !important;
  }

  .layui-input-block {
    margin-left: 140px !important;
  }

  #div-img > img {
    width: 600px;
  }

  #div-line {
    display: block;
    min-height: 300px;
    height: 70%;
  }

  .layui-form-radio div {
    font-size: 16px;
  }

  form {
    margin-top: 2%;
  }
</style>
