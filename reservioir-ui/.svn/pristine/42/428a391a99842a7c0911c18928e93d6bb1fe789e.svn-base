<template>
  <dv-border-box-11 :title="title" style="width: 500px;height: 180px;padding: 60px;">
    <el-row>
      <label>计算结果:</label>
      <dv-digital-flop :config="config" v-if='config' style="width:200px;height:30px;display: inline-block"/>
    </el-row>
    <el-row>
      <label>安全范围:</label>
      <label class="value" id="stableUpPara">{{scope}}</label>
    </el-row>
    <el-row>
      <label>状态:</label>
      <label class="value" id="safeStableUpPara">{{state?'安全':'危险'}}</label>
    </el-row>
  </dv-border-box-11>
</template>

<script>
  export default {
    name: "result",
    data() {
      return {
      };
    },
    props: {
      title: String,
      scope: String,
      state: Boolean,
      config: Object,
    },

    methods: {},
    mounted() {

    },


  }
</script>

<style scoped>
  label {
    display: inline-block;
    width: 120px;
    line-height: 30px;
    vertical-align: bottom;
    color: #1bcca9;
    font-size: 16pt;
    font-family: 华文楷体, serif;
  }

  .value {
    margin-left: 20%;
    display: inline-block;
    width: 120px;
    line-height: 30px;
  }

</style>
