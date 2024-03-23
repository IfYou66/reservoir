<template>
  <div class="app-container">
    <el-row class="from-top">
      <!-- <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img src="../../../assets/images/01s.png"/>
            <div  style="position: absolute;top: 17px;left: 23px;width: 50%;color: #FFFFFF;">计划编制</div>
          </div>
          <div  style="position: relative; width: 30%;">
            <img :src="require(active>1? '../../../assets/images/04.png':'../../../assets/images/05.png')"  style="width: 100%;"/>
            <img v-if="active==1" :src="require(active==1? '../../../assets/images/07.gif':'../../../assets/images/06.gif')" style="position: absolute;top: 0px;left: 150px;height: 80%;width: 10%;"/>
            </div>
          <div  style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
            <div  :style="active>1? 'position: absolute;top: 17px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 17px;left: 23px;width: 50%;color: #999999;'">计划审核</div>
            </div>
          <div  style="position: relative; width: 30%;">
            <img :src="require(active==3? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;" />
            <img v-if="active==2 || active==1" :src="require(active==2? '../../../assets/images/07.gif':'../../../assets/images/06.gif')" style="position: absolute;top: 0px;left: 150px;height: 80%;width: 10%;"/>
            </div>
          <div   style="position: relative;">
            <img :src="require(active==3? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
            <div  :style="active>1? 'position: absolute;top: 17px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 17px;left: 23px;width: 50%;color: #999999;'">计划批准</div>
            </div>
        </div>
      </el-col> -->
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img src="../../../assets/images/jin.png"/>
            <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.计划编制</div>
          </div>
          <div style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')"/>
            <div
              :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              2.计划审核
            </div>
          </div>
          <div style="position: relative;">
            <img :src="require(active>2? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')"/>
            <div
              :style="active>2? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              3.计划批准
            </div>
          </div>
          <div style="position: relative;">
            <img :src="require(active>3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')"/>
            <div
              :style="active>3? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              4.完成
            </div>
          </div>
        </div>
      </el-col>


    </el-row>
    <div class="from-div">
      <el-row>
        <el-col :span="24"
                class="from-div-title"
                style="background-color: rgba(215, 215, 215, 1); text-align: right;"
        >
          <div style="margin-right: 10px">
            <el-button type="primary" size="small" @click.native="addSubmitshow('1',0)"
                       v-if="active==1 && addFrom.fId == null || addFrom.fId == '' ">暂存
            </el-button>
            <el-button type="primary" size="small" @click.native="addSubmitshow('1',1)" v-if="active==1">提交</el-button>
            <el-button type="primary" size="small" @click.native="addSubmitshow('2')"
                       v-if="active==2 && addFrom.landingPersonId != addFrom.fStartPersion">审核
            </el-button>
            <el-button type="primary" size="small" @click.native="addSubmits()"
                       v-if="active==3 && addFrom.landingPersonId != addFrom.fStartPersion">批准
            </el-button>
          </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="24"
                class="from-div-title"
        >
          安全检查计划编制审批表
        </el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left">
          计划名称
        </el-col>
        <el-col :span="8" class="from-border-right">
          <el-input v-model="addFrom.fPlanName" placeholder="请输入内容" :disabled="active != 1"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left">
          计划类型
        </el-col>
        <el-col :span="3" style="line-height: 40px;border-right: #a4d5ff 1px solid;">
          <div>
            <el-select v-model="addFrom.fPlanType" placeholder="请选择" :disabled="active != 1">
              <el-option v-for="dict in dict.plantTypeList" 
              	 :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue" >
              </el-option>
            </el-select>
          </div>
        </el-col>

        <el-col :span="3" class="from-col-left">
          预算（元）
        </el-col>
        <el-col :span="4" class="from-border-right">
          <el-input v-model="addFrom.fBudget" placeholder="预算（元）" :disabled="active != 1"></el-input>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht">
          计划内容
        </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            计划概述：
          </div>
          <el-input type="textarea" maxlength="500" show-word-limit  :rows="8" placeholder="请输入内容" v-model="addFrom.fPlanContent"
                    :disabled="active != 1">
          </el-input>
          <div style="display:flex;justify-content:space-between;margin-top: 70px;">
            <div style="width: 200px;margin-left: 20px;">
              <el-upload class="upload-demo" style="font-size:100" :action="GLOBAL.httpUrl" multiple
              :before-upload = "beforeAvatarUpload"
                         :on-success="successResave" ref="upload" :headers="GLOBAL.headers()" :limit="1"
                         :show-file-list="true" :auto-upload="true" :disabled="active != 1" :on-remove="remove"
                         :file-list="addFrom.fileList" :on-preview="handlePreview">
                <el-button :disabled="active != 1" type="primary">计划内容</el-button>
				<div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
              <div style="text-align: left">
               <div style="display:inline;">编制人：<el-input v-model="addFrom.fEditPersion"  placeholder="请输入编制人名称" style="width:220px;border: 1px solid #DCDFE6;" :disabled="active != 1"></el-input></div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                  <el-date-picker
                    type="date" style="border: 1px solid #DCDFE6;"
                    v-model="addFrom.fEditTime"
                    placeholder="选择日期"
                    format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd"
                    :disabled="active != 1">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          计划审核
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审核意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="addFrom.fAuditContent"
                    :disabled="active != 2">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审核结果：
              </div>
              <el-select v-model="addFrom.fAuditResult" clearable placeholder="请选择" :disabled="active != 2">
                <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div>
              <span>审核人：<el-input v-model="addFrom.fAuditPersion" placeholder="请输入审核人名称" style="width:180px;"
                                  :disabled="active != 2"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker style="border: 1px solid #DCDFE6;"
                                value-format="yyyy-MM-dd"
                                v-model="addFrom.fAuditTime"
                                :disabled="active != 2"
                                type="date"
                                placeholder="选择日期时间">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          计划批准
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审批意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="addFrom.fApproveContent"
                    :disabled="active != 3">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审批结果：
              </div>
              <el-select v-model="addFrom.fApproveResult" clearable placeholder="请选择" :disabled="active != 3">
                <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div>
              <span>审批人：<el-input v-model="addFrom.fApprovePersion" :disabled="active != 3" placeholder="请输入审批人名称"
                                  style="width:180px;"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>

                <el-date-picker style="border: 1px solid #DCDFE6;"
                                value-format="yyyy-MM-dd"
                                v-model="addFrom.fApproveTime"
                                :disabled="active != 3"
                                type="date"
                                placeholder="选择日期时间">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <!--    <el-dialog-->
    <!--      title="选择处理人"-->
    <!--      :visible.sync="dialogVisible"-->
    <!--      :modal="false"-->
    <!--      width="30%">-->
    <!--       <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}</el-radio>-->
    <!--        &lt;!&ndash; <el-radio v-model="radio" label="2">备选项</el-radio> &ndash;&gt;-->
    <!--      <span slot="footer" class="dialog-footer">-->
    <!--        <el-button @click="dialogVisible = false">取 消</el-button>-->
    <!--        <el-button type="primary" @click="addSubmits">确 定</el-button>-->
    <!--      </span>-->
    <!--    </el-dialog>-->
  </div>
</template>
<script>
// import {getToken} from "@/utils/auth";
import {
  getUserList,
  startWorkFlow,
  getReviewTask,
  submit,
  taskReview,
  taskApprove
} from "@/api/security/planning";
import {
  queryDataDictionary
} from "@/api/indemnification/training";

export default {

  props: ['fActId', 'fId', 'time'],

  data() {
    return {

      dict: {
        result: [],
        plantTypeList:[] 
      },

      addFrom: {
        fId: null,
        fPlanName: null,
        fPlanType: null,
        fBudget: null,
        fPlanContent: null,
        fEditPersion: null,
        fEditTime: null,
        fPlanId: null,
        fAuditContent: null,
        fAuditResult: null,
        fAuditPersion: null,
        fAuditTime: null,
        fApproveContent: null,
        fApproveResult: null,
        fApprovePersion: null,
        fApproveTime: null,
        // 流程发起人
        fStartPersion: null,
      },
      list: [],

      // dialogVisible:false,
      // radio:'',
      // headers: {Authorization: "Bearer " + getToken()},

      active: 1,

      fileList: [],

      holdOrSubmit: '',

    };
  },
  watch: {
    fActId(val, newval) {
      this.getReviewTask()
    },
    time(val, newval) {
      this.getReviewTask()
    },
    fId(val, newval) {
      this.getReviewTask()
    }
  },
  created() {
    if (this.fId) {
      this.getReviewTask()
    }
    //计划类型
 		this.getDicts("plan_type").then(response => {
      this.dict.plantTypeList = response.data;
    });
    this.queryDataDictionary()
    this.Personnel()
  },


  methods: {
    beforeAvatarUpload(file){
    const isLt100M = file.size / 1024 / 1024 < 100;
       if (!isLt100M) {
              this.$message.error('上传文件大小不能超过 100MB!');
              return false
          }
    },
	  handlePreview(file) {
      if(!file.url){
	  	// window.location.href = file.response.data.fFilePath;
		window.open(file.response.data.fFilePath);
      } else {
        window.open(file.url); 
      }
	  },

    Personnel() {
      getUserList().then(response => {
        this.list = response.data
      })
    },
    successResave(response, file, fileList) {
      this.addFrom.fPlanId = response.data.fId
    },
    remove(file, fileList) {
      this.GLOBAL.commonFun(this.addFrom.fPlanId)
    },
    clearOut() {
      this.active = 1
      this.addFrom = {
        fPlanName: null,
        fPlanType: null,
        fBudget: null,
        fPlanContent: null,
        fEditPersion: null,
        fEditTime: null,
        fPlanId: null,
        fAuditContent: null,
        fAuditResult: null,
        fAuditPersion: null,
        fAuditTime: null,
        fApproveContent: null,
        fApproveResult: null,
        fApprovePersion: null,
        fApproveTime: null,
      },
        this.addFrom.fileList = []
    },


    addSubmitshow(val, type) {
      if (val == '1') {
        if (this.addFrom.fPlanName == null) {
          this.$message({
            showClose: true,
            message: '请填写计划名称',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fPlanType == null) {
          this.$message({
            showClose: true,
            message: '请填写计划类型',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fBudget == null) {
          this.$message({
            showClose: true,
            message: '请填写计划预算',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fPlanContent == null) {
          this.$message({
            showClose: true,
            message: '请填写计划概述',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fEditPersion == null) {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fEditTime == null) {
          this.$message({
            showClose: true,
            message: '请填写时间',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fPlanId == null) {
          this.$message({
            showClose: true,
            message: '请上传文件',
            type: 'error'
          });
          return false
        }
        if (this.active > 1) {
          this.$message({
            showClose: true,
            message: '此状态无法提交',
            type: 'error'
          });
          return false
        }
        this.holdOrSubmit = type
        // if (type == 1) {
        //   this.dialogVisible = true;
        // } else {
        this.addSubmits()
        // }
      }
      if (val == '2') {
        if (this.addFrom.fAuditContent == null) {
          this.$message({
            showClose: true,
            message: '请填写审核意见',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fAuditResult == null) {
          this.$message({
            showClose: true,
            message: '请填写审核结果',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fAuditPersion == null) {
          this.$message({
            showClose: true,
            message: '请填写审核人',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fAuditTime == null) {
          this.$message({
            showClose: true,
            message: '请填写时间',
            type: 'error'
          });
          return false
        }
        if (this.active > 2) {
          this.$message({
            showClose: true,
            message: '此状态无法提交',
            type: 'error'
          });
          return false
        }
        // this.dialogVisible = true
        this.addSubmits()
      }

    },

    addSubmits() {
      // if(this.active!=3){
      //   if (this.holdOrSubmit == 1) {
      //     if (this.radio == '') {
      //       this.$message({
      //         showClose: true,
      //         message: '请选择审批人',
      //         type: 'error'
      //       });
      //       return false
      //     }
      //   }
      // }

      if (this.active == 3) {
        if (this.addFrom.fApproveContent == null) {
          this.$message({
            showClose: true,
            message: '请填写批准意见',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fApproveResult == null) {
          this.$message({
            showClose: true,
            message: '请填写批准结果',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fApprovePersion == null) {
          this.$message({
            showClose: true,
            message: '请填写批准人',
            type: 'error'
          });
          return false
        }
        if (this.addFrom.fApproveTime == null) {
          this.$message({
            showClose: true,
            message: '请填写批准时间',
            type: 'error'
          });
          return false
        }
      }

      console.log('549+64', this.active)
      if (this.active == 1) {
        console.log('222222+64')
        var params = {
          fId: this.addFrom.fId,
          // fActPersion:this.radio,
          fPlanName: this.addFrom.fPlanName,
          fPlanType: this.addFrom.fPlanType,
          fBudget: this.addFrom.fBudget,
          fPlanContent: this.addFrom.fPlanContent,
          fEditPersion: this.addFrom.fEditPersion,
          fEditTime: this.addFrom.fEditTime,
          fPlanId: this.addFrom.fPlanId,
          // 提交或暂存
          holdOrSubmit: this.holdOrSubmit,
        }
        if (this.addFrom.fId) {
          // 提交接口
          submit(params).then(res => {
            if (res.code == 200) {
              this.clearOut()
              // this.dialogVisible = false
              this.msgSuccess("提交成功");
              // 调用父组件方法关闭弹窗
              this.$emit("shut", false);
              // 调用父组件方法查询列表
              this.$emit("search")
            }
          });
        } else {
          // 保存接口
          startWorkFlow(params).then(response => {
            if (response.code == 200) {
              this.clearOut()
              // this.dialogVisible = false
              if (this.holdOrSubmit == 1) {
                this.msgSuccess("提交成功");
              } else {
                this.msgSuccess("暂存成功");
              }
              // 调用父组件方法关闭弹窗
              this.$emit("shut", false);
              // 调用父组件方法查询列表
              this.$emit("search")
              // this.getReviewTask()
            }

          })
        }
      }
      if (this.active == 2) {
        var params = {
          fId: this.addFrom.fId,
          // fActPersion:this.radio,
          fActId: this.addFrom.fActId,
          fAuditContent: this.addFrom.fAuditContent,
          fAuditResult: this.addFrom.fAuditResult,
          fAuditPersion: this.addFrom.fAuditPersion,
          fAuditTime: this.addFrom.fAuditTime,
          auditStatus: this.addFrom.fAuditResult,
        }
        taskReview(params).then(response => {
          if (response.code == 200) {
            this.clearOut()
            // this.dialogVisible = false
            this.msgSuccess("审核成功");
            // 调用父组件方法关闭弹窗
            this.$emit("shut", false)
            // 调用父组件方法查询列表
            this.$emit("search")
            // this.getReviewTask()
          }
        })

      }

      if (this.active == 3) {
        var params = {
          fId: this.addFrom.fId,
          // fActPersion:this.radio,
          fActId: this.addFrom.fActId,
          fApproveContent: this.addFrom.fApproveContent,
          fApproveResult: this.addFrom.fApproveResult,
          fApprovePersion: this.addFrom.fApprovePersion,
          fApproveTime: this.addFrom.fApproveTime,
          auditStatus: this.addFrom.fApproveResult,
        }
        taskApprove(params).then(response => {
          if (response.code == 200) {
            this.clearOut()
            // this.dialogVisible = false
            this.msgSuccess("批准成功");
            // 调用父组件方法关闭弹窗
            this.$emit("shut", false)
            // 调用父组件方法查询列表
            this.$emit("search")
            // this.getReviewTask()
          }
        })

      }

    },
    getReviewTask() {
      var params = {
        fActId: this.fActId,
        fId: this.fId
      }
      getReviewTask(params).then(response => {
        if (response.data) {
          this.active = response.data.fActStatus
          this.addFrom = response.data
          if (this.addFrom.fPlanType != null) {
            this.addFrom.fPlanType = this.addFrom.fPlanType.toString()
          }
          if (this.addFrom.fAuditResult != null) {
            this.addFrom.fAuditResult = this.addFrom.fAuditResult.toString()
          }
          if (this.addFrom.fApproveResult != null) {
            this.addFrom.fApproveResult = this.addFrom.fApproveResult.toString()
          }
          this.addFrom.fileList = [{
            name: null,
            url: null
          }];
          if (this.addFrom.sysFile) {
            this.addFrom.fileList[0].name = this.addFrom.sysFile.fOldFileName
            this.addFrom.fileList[0].url = this.addFrom.sysFile.fFilePath
          }
        }
      })
    },

    queryDataDictionary() {
      queryDataDictionary().then(res => {
        this.dict.result = res.data.result
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

.el-upload-list__item-name {
  font-size: 20px;
}


</style>
