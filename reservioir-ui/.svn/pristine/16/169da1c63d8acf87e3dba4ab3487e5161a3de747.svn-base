<template>
  <div style="margin: 20px;">
    <div style="width:100%;text-align: center;">
      <img src="../../../assets/images/runPlan/xingli.jpg"  alt="上海鲜花港 - 郁金香"  style="width:90%;margin: 0 auto;height:650px;" align="middle"/>
        <div style="width:30%;margin-left:5%">
          <el-table  :data="data">
            <el-table-column label="附件名称" align="center"  prop="p1" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
              >{{ scope.row.p2 }}
              </el-button>
            </template>
            </el-table-column>
          </el-table>
         </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        activeName: 'first',
        data: [{
          id: '1',
          p1: '兴利调度预案',
          p2: '下载',
        },]
      };
    },

    mounted() {
      this.drawLine();
      this.drawLine1();
    },
    methods: {
    },
  };
</script>
<style lang="scss" scoped>

  .qwe {
    width: 300px;
    float: right;
  }

</style>
