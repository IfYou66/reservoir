<template>
  <div class="app-container">
    <div class="layui-fluid">
      <div class="layui-row">
        <div>
          <div id='main' class="layui-card" style="/*min-width: 1400px;*/">
            <div style="width: 100%; margin: 0 auto">
              <el-row>
                <el-col :span="10">
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
                <el-col :span="6">
                  <label class="el-form-item__label">断面选择:</label>
                  <el-select v-model="value" placeholder="请选择">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-col>
                <el-col :span="8">
                  <el-button type="primary">往前</el-button>
                  <el-button type="primary">数据查询</el-button>
                  <el-button type="primary">往后</el-button>
                  <el-button type="primary">导出</el-button>
                </el-col>
              </el-row>


            </div>

            <div class="layui-card-body" style="width:100%;height: 380px;">
              <div id="seepageChart" style="width:105%;height: 100%;/*min-width: 1400px;*/"></div>

            </div>
            <div class="layui-card-body" style="width:90%;height: 300px; margin: -10px 5%;">
              <div style="width:100%;height: 100%;/*min-width: 1400px;*/">

                <el-table
                  :data="tableData"
                  border
                  style="width: 100%">
                  <el-table-column
                    prop="tube"
                    label="测压管"
                    width="180">
                  </el-table-column>
                  <el-table-column
                    prop="waterLevel"
                    label="水库水位"
                    width="180">
                  </el-table-column>
                  <el-table-column
                    prop="seepageLevel"
                    label="渗压水位">
                  </el-table-column>
                  <el-table-column
                    prop="upHeight"
                    label="管口高程">
                  </el-table-column>
                  <el-table-column
                    prop="downHeight"
                    label="管底高程">
                  </el-table-column>
                </el-table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
  const common = require('@/api/data/common');
  const reservoir = require('@/api/data/heihushan/reservoir');
  export default {
    name: "vd",
    data() {

      return {
        points: reservoir.getVideo(),
        activeIndex: '1',
        activeIndex2: '1',
        order: '1',
        tableData: [{
          tube: 'T1',
          waterLevel: 153,
          seepageLevel: 213,
          upHeight: 176.54,
          downHeight: 165.23,
        },{
          tube: 'T2',
          waterLevel: 153,
          seepageLevel: 213,
          upHeight: 176.54,
          downHeight: 165.23,
        },{
          tube: 'T3',
          waterLevel: 153,
          seepageLevel: 213,
          upHeight: 176.54,
          downHeight: 165.23,
        },{
          tube: 'T4',
          waterLevel: 153,
          seepageLevel: 213,
          upHeight: 176.54,
          downHeight: 165.23,
        }]
      };
    },
    mounted() {
      this.displayWaterLevelLine(0);
    },

    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      //显示水位线
      displayWaterLevelLine(index) {
        chartWaterLevel = this.$echarts.init(document.getElementById('seepageChart'));
        chartWaterLevel.setOption(seepage[index].createDam(1), true);

        if (setEvent === 0) {
          setEvent++;
          chartWaterLevel.on('click', function (params) {
            show(params);
          }, false);
        } else {
          chartWaterLevel.off("click");
          chartWaterLevel.on('click', function (params) {
            show(params);
          }, false);
        }
      }

    }
  }

  let seepage = reservoir.getDam().getSeepageSafe();
  let setEvent = 0;
  let chartWaterLevel, dateSelect, lineChart, lineOption, data;


</script>

<style scoped>

</style>
