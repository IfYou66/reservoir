<template>
  <div class="app-container">
    <el-row class="from-top">
      <el-col :span="24">
        <el-col :span="24">
          <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
            <div style="position: relative;">
              <img src="../../../assets/images/jin.png" />
              <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.实施</div>
            </div>
            <div style="position: relative;">
              <img :src="require(active>1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
              <div
                :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
                2.审核</div>
            </div>
            <div style="position: relative;">
              <img :src="require(active==3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
              <div
                :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
                3.完成</div>
            </div>
          </div>
        </el-col>
      </el-col>
    </el-row>
    <div class="from-div">

      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div>
            <el-button type="primary" size="small" @click="handleAdd">暂存</el-button>
            <el-button type="primary" style="margin-right: 10px;" size="small" @click="submitForm">提交</el-button>
          </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="24" class="from-div-title">控制运行实施表</el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left">
          计划名称
        </el-col>
        <el-col :span="8" style="line-height: 40px;">
          <div>
            <el-select v-model="rControlImpl.fPreparedId" placeholder="请选择">
              <el-option v-for="item in controlList" :key="item.fId" :label="item.fPlanName" :value="item.fId">
              </el-option>
            </el-select>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht">
          实施内容
        </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            实施内容：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="8" placeholder="请输入内容" v-model="rControlImpl.fImplContent">
          </el-input>
          <div style="display:flex;justify-content:space-between;margin-top: 100px;">
            <div style="width: 200px;margin-top: -60px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                 multiple :on-success="uploadedSuccess" :show-file-list="true"
                :auto-upload="true" :limit="1" :on-exceed="handleExceed" :file-list="fileList">
                <el-button size="small" type="primary">上传附件</el-button>
                <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>
            <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
              <div>
                <span>实施人：<el-input v-model="rControlImpl.fImplPeople" placeholder="请输入内容"
                    style="width:220px;border: 1px solid #DCDFE6;">
                  </el-input></span>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" style="border: 1px solid #DCDFE6;" v-model="rControlImpl.fImplTime"
                    placeholder="选择日期" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          实施审核
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审核意见：
          </div>
          <el-input  maxlength="500" show-word-limit  disabled type="textarea" :rows="3" placeholder="请输入内容" v-model="rControlImpl.fReviewComments">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审核结果：
              </div>
              <el-select disabled v-model="rControlImpl.fReviewResult" clearable placeholder="请选择">
                <el-option disabled v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
              <span>审核人：<el-input disabled v-model="rControlImpl.fReviewPeople" placeholder="请输入内容"
                  style="width:180px;">
                </el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker disabled type="dates" v-model="rControlImpl.fReviewDate" placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
  import {
    listControl,
    getControl,
    delControl,
    addControl,
    updateControl,
    getDictByType
  } from "@/api/reservoir/control";
  import {
    getUserList,
  } from "@/api/security/planning";
  import {
    listControlImpl,
    getControlImpl,
    delControlImpl,
    addControlImpl,
    updateControlImpl,
    startWorkFlowControlImpl,
    taskReviewControlImpl
  } from "@/api/reservoir/controlImpl";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  export default {

    data() {
      return {
        controlList: [],
        // 查询参数
        queryParams: {
          fActStatus: 4
        },
        userList: [],
        nextVisible: false,
        rControlImpl: {},
        active: 1,
        fileList: [],
        audit: [],
      };
    },
    created() {
      this.getLately();
      this.getList();
      this.Personnel();
    },
    methods: {
      beforeAvatarUpload(file){
      const isLt100M = file.size / 1024 / 1024 < 100;
         if (!isLt100M) {
                this.$message.error('上传文件大小不能超过 100MB!');
                return false
            }
      },


      getFile() {
        console.log('fileList = []');
        this.fileList = [];
        if (this.rControlImpl.fImplId) {
          getFileById({
            id: this.rControlImpl.fImplId
          }).then(result => {
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              console.log("fileList.url:", this.fileList[0].url);
            }
          })
        }
      },
      uploadedSuccess(response, file, fileList) {
        this.rControlImpl.fImplId = response.data.fId;
        this.getFile();
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.rControlImpl.fImplId);
        this.rControlImpl.fImplId = '';
        this.getFile();
      },
      handlePreview(file) {
		  // window.location.href = this.fileList[0].url;
		  window.open(this.fileList[0].url);
	  },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },

      getList() {
        listControl(this.queryParams).then(response => {
          this.controlList = response.rows;
        });
      },

      openStartWorkFlow() {
        // if (this.rControlImpl.fPreparedId == null) {
        //   this.$message.error("请填写计划名称")
        //   return false
        // } else if (this.rControlImpl.fImplContent == null) {
        //   this.$message.error("实施内容")
        //   return false
        // } else if (this.rControlImpl.fPreparedBy == null) {
        //   this.$message.error("请填写实施人")
        //   return false
        // } else if (this.rControlImpl.fPreparationTime == null) {
        //   this.$message.error("请填写实施时间")
        //   return false
        // } else {
        startWorkFlowControlImpl(this.rControlImpl).then(response => {
          this.msgSuccess("提交成功");
          this.nextVisible = false;
          this.getLatelyControl();
        });
        // }
      },

      getDitc() {
        getDictByType().then(response => {
          this.audit = response.data
        })
      },


      Personnel() {
        getUserList().then(response => {
          this.userList = response.data
        })
      },

      submitForm() {
        this.openStartWorkFlow();
      },

      getLately() {
        this.rControlImpl = {};
      },

      handleAdd() {
        addControlImpl(this.rControlImpl).then(response => {
          this.msgSuccess("暂存成功");
          this.open = false;
          this.getLately();
        });
      },
    }
  };
</script>
<style lang="scss">
  .color409 {
    color: #409eff;
    cursor: pointer;
  }
</style>
