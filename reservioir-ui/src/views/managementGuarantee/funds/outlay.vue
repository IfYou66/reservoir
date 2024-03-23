<template>
  <div class="app-container">

    <el-row class="from-top" style="width:100%;">
      <!-- <el-col :span="24">
        <el-steps :active="1" simple>
          <el-step title="编制" icon="el-icon-edit"></el-step>
          <el-step title="审核" icon="el-icon-upload"></el-step>
          <el-step title="批准" icon="el-icon-picture"></el-step>
          <el-step title="完成" icon="el-icon-picture"></el-step>
        </el-steps>
      </el-col> -->
      <!-- <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;justify-content:center;width: 80% ;">
          <div style="position: relative;">
            <img src="../../../assets/images/01s.png"/>
            <div  style="position: absolute;top: 27px;left: 23px;width: 50%;color: #FFFFFF;">编制</div>
          </div>
          <div  style="position: relative;width: 20%;" >
            <img :src="require(active>1? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
            <img v-if="active==1" :src="require(active==1? '../../../assets/images/07.gif':'../../../assets/images/06.gif')" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
            </div>
          <div  style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
            <div  :style="active>1? 'position: absolute;top:27px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 27px;left: 23px;width: 50%;color: #999999;'">审核</div>
            </div>
          <div  style="position: relative;width: 20%;">
            <img :src="require(active>2? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
            <img v-if="active==2 || active==1" :src="require(active==2? '../../../assets/images/07.gif':'../../../assets/images/06.gif')" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
            </div>
          <div   style="position: relative;">
            <img :src="require(active>2? '../../../assets/images/01s.png':'../../../assets/images/01.png')"/>
            <div  :style="active>1? 'position: absolute;top:27px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 27px;left: 23px;width: 50%;color: #999999;'">批准</div>
            </div>
            <div  style="position: relative;width: 20%;">
              <img :src="require(active==4? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
              <img v-if="active!=4" :src="require(active==3? '../../../assets/images/07.gif':'../../../assets/images/06.gif')" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
              </div>
            <div   style="position: relative;">
              <img :src="require(active==4? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
              <div  :style="active>1? 'position: absolute;top: 27px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 27px;left: 23px;width: 50%;color: #999999;'">完成</div>
              </div>
        </div>
      </el-col> -->
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img src="../../../assets/images/jin.png"/>
            <div  style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.编制</div>
          </div>
          <div  style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">2.审核</div>
            </div>
          <div   style="position: relative;">
            <img :src="require(active>2? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>2? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">3.批准</div>
            </div>
            <div   style="position: relative;">
              <img :src="require(active==4? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
              <div  :style="active==4? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">4.完成</div>
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
          <el-button v-if="active == 1 && formData.fId == null || formData.fId == '' " type="primary" size="small" style="margin-right: 5px" @click="submit(0)">暂存
          </el-button>
          <el-button v-if="active == 1" type="primary" size="small" style="margin-right: 20px" @click="submit(1)">提交
          </el-button>
          <el-button v-if="active == 2" type="primary" size="small" style="margin-right: 20px" @click="check">审核</el-button>
          <el-button v-if="active == 3" type="primary" size="small" style="margin-right: 20px" @click="approve">审批</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24"
                class="from-div-title"
        >
          经费支出详情表
        </el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left">
          经费申请名称
        </el-col>
        <el-col :span="13" class="from-border-right">
          <el-input v-model="formData.fApplyName" clearable placeholder="请输入内容" v-bind:disabled="active != 1? true : false"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left">
          类别
        </el-col>
        <el-col :span="5" class="from-col-left">
          <el-select
            v-model="formData.fApplyType"
            placeholder="类别"
            clearable
            size="small"
            v-bind:disabled="active != 1? true : false"
          >
            <el-option
              v-for="(item,index) in dict.fundType"
              :key="item.dictValue"
              :label="item.dictLabel"
              :value="item.dictValue"
            />
          </el-select>
        </el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left">
          申请金额(元)
        </el-col>
        <el-col :span="3" class="from-border-right">
          <el-input v-model="formData.fApplyMoney" clearable placeholder="请输入内容" v-bind:disabled="active != 1? true : false"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left">
          批准金额(元)
        </el-col>
        <el-col :span="3" class="from-border-right">
          <el-input v-model="formData.fApprovalMoney" clearable placeholder="请输入内容" v-bind:disabled="active != 1? true : false"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left">
          支出金额(元)
        </el-col>
        <el-col :span="3" class="from-border-right">
          <el-input v-model="formData.fExpendMoney" clearable placeholder="请输入内容" v-bind:disabled="active != 1? true : false"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left">
          结余金额(元)
        </el-col>
        <el-col :span="3" class="from-border-right">
          <el-input v-model="formData.fSurplusMoney" clearable placeholder="请输入内容" v-bind:disabled="active != 1? true : false"></el-input>
        </el-col>
      </el-row>

      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:188px;">
          用途
        </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            用途说明：
          </div>
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="5" v-model="formData.fPurpose" placeholder="请输入内容" v-bind:disabled="active != 1? true : false"/>
        </el-col>
      </el-row>

      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" >
          经费清单
        </el-col>
        <el-col :span="21" style="height: 400px;">
           <div style="font-size: 16px;font-weight: 700;padding: 10px;">
             经费清单：
           </div>
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="8" placeholder="请输入内容" v-model="formData.fFundListing" v-bind:disabled="active != 1? true : false">
          </el-input>
          <div style="display:flex;justify-content:space-between;margin-top: 70px;">
           <div  style="width: 200px;margin-left: 20px;">
             <el-upload style="margin-left: 15px;" class="upload-demo"
                        :headers="GLOBAL.headers()"
                        :action="GLOBAL.httpUrl"
                        :on-preview="handlePreview" :on-remove="handleRemove"  multiple
                        :on-success="uploadedSuccess"
                        :show-file-list="true"
                        :auto-upload="true"
                        :limit="1"
                        :disabled="active != 1"
                        :on-exceed="handleExceed" :file-list="fileList">
               <el-button size="small" type="primary" :disabled="active != 1">经费清单</el-button>
			   <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
             </el-upload>
          </div>
          <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
            <div style="text-align: left">
             <div style="margin-left:-1px;display:inline;">编制人：<el-input v-model="formData.fPreparedBy"  placeholder="请输入编制人名称" style="width:220px;border: 1px solid #DCDFE6;" v-bind:disabled="active != 1? true : false"></el-input></div>
            <div >
              <div class="block" style="transform:translateY(10%);">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker style="border: 1px solid #DCDFE6;"
                  type="date"
                  v-model="formData.fPreparationTime"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-bind:disabled="active != 1? true : false"
                  >
                </el-date-picker>
              </div>
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
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="3" v-model="formData.fReviewComments" placeholder="请输入内容" v-bind:disabled="active != 2? true : false">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
               <div style="font-size: 16px;font-weight: 700;display:inline;">
                审核结果：
              </div>
              <el-select v-model="formData.fReviewResult" clearable placeholder="请选择"
                         v-bind:disabled="active != 2? true : false">
                <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel"
                           :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审核人：<el-input v-model="formData.fReviewPeople"  placeholder="请输入内容" style="width:180px;" v-bind:disabled="active != 2? true : false"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="formData.fReviewDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-bind:disabled="active != 2? true : false"
                >
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          经费审批
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审批意见：
          </div>
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="3" v-model="formData.fAuditComments" placeholder="请输入内容" v-bind:disabled="active != 3? true : false">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
               <div style="font-size: 16px;font-weight: 700;display:inline;">
                审批结果：
              </div>
              <el-select v-model="formData.fAuditResult" clearable placeholder="请选择"
                         v-bind:disabled="active != 3? true : false">
                <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel"
                           :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审批人：<el-input v-model="formData.fAuditPeople"  placeholder="请输入内容" style="width:180px;" v-bind:disabled="active != 3? true : false"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="formData.fAuditDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-bind:disabled="active != 3? true : false"
                >
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
<!--      <el-radio v-model="formData.fActPersion" :label="item.userId" v-for="(item,index) in userList" :key="index">-->
<!--        {{ item.nickName }}-->
<!--      </el-radio>-->
<!--      <span slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="addAndUpdate">确 定</el-button>-->
<!--      </span>-->
<!--    </el-dialog>-->


  </div>
</template>

<script>

import { getToken } from "@/utils/auth";
import {
  getUserList
} from "@/api/security/planning";
import { inquiry } from "@/api/fundManage/apply"
import { addExpend, updateExpend } from "@/api/fundManage/expend"

import {
  dataQuery
} from "@/api/indemnification/training";

export default {
  components: { },
  data() {
    return {

      dict: {
        fundType: [],
        result: [],
      },

      // 文件上传
      upload: {
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/file/upload"
      },

      userList: [],

      // dialogVisible: false,

      active:1,

      info: {
        stockDate:this.getNowTime(),  //日期
      },

      formData: {

        /** 经费支出表ID */
        fId: null,

        /** 经费申请名称 */
        fApplyName: null,

        /** 申请类别 */
        fApplyType: null,

        /** 申请金额 */
        fApplyMoney: null,

        /** 批准金额 */
        fApprovalMoney: null,

        /** 支出金额 */
        fExpendMoney: null,

        /** 结余金额 */
        fSurplusMoney: null,

        /** 用途 */
        fPurpose: null,

        /** 经费清单 */
        fFundListing: null,

        /** 编制人 */
        fPreparedBy: null,

        /** 编制时间 */
        fPreparationTime: null,

        /** 经费清单附件ID */
        fExpendFileId: null,

        /** 审核意见 */
        fReviewComments: null,

        /** 审核结果 */
        fReviewResult: null,

        /** 审核人 */
        fReviewPeople: null,

        /** 审核时间 */
        fReviewDate: null,

        /** 审批意见 */
        fAuditComments: null,

        /** 审批结果 */
        fAuditResult: null,

        /** 审批人 */
        fAuditPeople: null,

        /** 审批时间 */
        fAuditDate: null,

        /** 创建人 */
        fCreatePeople: null,

        /** 创建时间 */
        fCreateTime: null,

        /** 流程实例ID */
        fActId: null,

        // /** 下一节点审核人 */
        // fActPersion: null,

        /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
        ActStatus: null,

        /** 流程节点 */
        fActNode: null,

        /**
         * 暂存或提交 1提交 0暂存
         */
        holdOrSubmit: null,

        /**
         * 当前登陆人
         */
        landingPersonId: null

      },

      fileList: [],

    };
  },
  created() {
    this.Personnel()
    this.inquiry()
    this.dataQuery()
  },
  methods: {

    init(data,file) {
      this.active = data.fActStatus
      this.formData = data
      if (file) {
        this.fileList = [{name: file.fOldFileName, url: file.fFilePath}]
      }
      if (data.fReviewResult) {
        this.formData.fReviewResult = this.formData.fReviewResult.toString();
      }
      if (data.fAuditResult) {
        this.formData.fAuditResult = this.formData.fAuditResult.toString();
      }
    },

    inquiry() {
      inquiry().then(res => {
        if (res.code == 200) {
          this.dict.result = res.data.result
        }
      });
    },

    dataQuery() {
      var query = { dictType: 'fundType' }
      dataQuery(query).then(res => {
        if (res.code == 200) {
          this.dict.fundType = res.data
        }
      });
    },

    Personnel() {
      getUserList().then(response => {
        this.userList = response.data
      })
    },


    submit(type) {
      if (this.active == 1) {
        if (this.formData.fApplyName == null) {
          this.$message.error("请填写申请名称")
          return false
        } else if (this.formData.fApplyType == null) {
          this.$message.error("请选择申请类别")
          return false
        } else if (this.formData.fApplyMoney == null) {
          this.$message.error("请填写申请金额")
          return false
        } else if (this.formData.fApprovalMoney == null) {
          this.$message.error("请填批准金额")
          return false
        } else if (this.formData.fExpendMoney == null) {
          this.$message.error("请填写支出金额")
          return false
        } else if (this.formData.fSurplusMoney == null) {
          this.$message.error("请填写结余金额")
          return false
        } else if (this.formData.fPurpose == null) {
          this.$message.error("请填写用途")
          return false
        }else if (this.formData.fFundListing == null) {
          this.$message.error("请填写经费清单")
          return false
        }else if (this.formData.fExpendFileId == null) {
          this.$message.error("请上传经费清单")
          return false
        }else if (this.formData.fPreparedBy == null) {
          this.$message.error("请填写编制人")
          return false
        }else if (this.formData.fPreparationTime == null) {
          this.$message.error("请填写编制时间")
          return false
        }
        this.formData.holdOrSubmit = type
        // if (type == 1) {
        //   this.dialogVisible = true;
        // } else {
        this.addAndUpdate()
        // }
      }
    },

    check() {
      if (this.active == 2) {
        if (this.formData.fReviewComments == null) {
          this.$message.error("请填写审核意见")
          return false
        } else if (this.formData.fReviewResult == null) {
          this.$message.error("请选择审核结果")
          return false
        } else if (this.formData.fReviewPeople == null) {
          this.$message.error("请填写审核人")
          return false
        } else if (this.formData.fReviewDate == null) {
          this.$message.error("请选择审核时间")
          return false
        }
        // this.dialogVisible = true
        this.addAndUpdate()
      }
    },

    approve() {
      if (this.active == 3) {
        if (this.formData.fAuditComments == null) {
          this.$message.error("请填写审批意见")
          return false
        } else if (this.formData.fAuditResult == null) {
          this.$message.error("请选择审批结果")
          return false
        } else if (this.formData.fAuditPeople == null) {
          this.$message.error("请填写审批人")
          return false
        } else if (this.formData.fAuditDate == null) {
          this.$message.error("请选择审批时间")
          return false
        }
        this.addAndUpdate()
      }
    },


    addAndUpdate() {
      // if (this.formData.holdOrSubmit == 1) {
      //   if (this.formData.fActPersion == null) {
      //     this.$message.error("请选择流程下一环节审核人")
      //     return false
      //   }
      // }
      if (this.formData.fId != null && this.formData.fId != '') {
        updateExpend(this.formData).then(res => {
          if (res.code == 200) {
            if (this.formData.holdOrSubmit == 1) {
              this.$message.success("经费支出提交成功");
            } else {
              this.msgSuccess("经费支出暂存成功")
            }
            this.dialogVisible = false;
            // 调用父组件方法关闭弹窗
            this.$emit("shut", false)
            // 调用父组件方法查询列表
            this.$emit("search")
          } else {
            if (this.formData.holdOrSubmit == 1) {
              this.$message.error("经费支出提交失败");
            } else {
              this.msgError("经费支出暂存失败")
            }
          }
        });
      } else {
        addExpend(this.formData).then(res => {
          if (res.code == 200) {
            this.$message.success("经费支出成功");
            this.clearForm()
            this.dialogVisible = false
          } else {
            this.$message.error("经费支出失败");
          }
        });
      }
    },

    uploadedSuccess(response, file, fileList) {
      this.formData.fExpendFileId = response.data.fId
      this.fileList = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    handleRemove(file, fileList) {
      this.GLOBAL.commonFun(this.formData.fExpendFileId)
    },
    handlePreview(file) {
      // window.location.href = file.url;
	  window.open(this.fileList[0].url);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    getNowTime() {
	       var now = new Date();
	       var year = now.getFullYear(); //得到年份
	       var month = now.getMonth(); //得到月份
	       var date = now.getDate(); //得到日期
	       var hour =" 00:00:00"; //默认时分秒 如果传给后台的格式为年月日时分秒，就需要加这个，如若不需要，此行可忽略
	       month = month + 1;
	       month = month.toString().padStart(2, "0");
	       date = date.toString().padStart(2, "0");
	       var defaultDate = `${year}-${month}-${date}${hour}`;
	       console.log(defaultDate)
	       return defaultDate;
	       this.$set(this.info, "stockDate", defaultDate);
	    },

    clearForm() {
      this.formData = {

        /** 经费支出表ID */
        fId: null,

          /** 经费申请名称 */
          fApplyName: null,

          /** 申请类别 */
          fApplyType: null,

          /** 申请金额 */
          fApplyMoney: null,

          /** 批准金额 */
          fApprovalMoney: null,

          /** 支出金额 */
          fExpendMoney: null,

          /** 结余金额 */
          fSurplusMoney: null,

          /** 用途 */
          fPurpose: null,

          /** 经费清单 */
          fFundListing: null,

          /** 编制人 */
          fPreparedBy: null,

          /** 编制时间 */
          fPreparationTime: null,

          /** 经费清单附件ID */
          fExpendFileId: null,

          /** 审核意见 */
          fReviewComments: null,

          /** 审核结果 */
          fReviewResult: null,

          /** 审核人 */
          fReviewPeople: null,

          /** 审核时间 */
          fReviewDate: null,

          /** 审批意见 */
          fAuditComments: null,

          /** 审批结果 */
          fAuditResult: null,

          /** 审批人 */
          fAuditPeople: null,

          /** 审批时间 */
          fAuditDate: null,

          /** 创建人 */
          fCreatePeople: null,

          /** 创建时间 */
          fCreateTime: null,

          /** 流程实例ID */
          fActId: null,

          // /** 下一节点审核人 */
          // fActPersion: null,

          /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
          ActStatus: null,

          /** 流程节点 */
          fActNode: null,

          /**
           * 暂存或提交 1提交 0暂存
           */
          holdOrSubmit: null,

          /**
           * 当前登陆人
           */
          landingPersonId: null

      },
        this.fileList = []
    }

  }
};
</script>
<style lang="scss">

.color409 {
  color: #409eff;
  cursor: pointer;
}

.from-col-about {
  text-align: center;
  line-height: 160px;
  border-right: #a4d5ff 1px solid;
  border-left: #a4d5ff 1px solid;
}

.from-col-form {
  text-align: center;
  line-height: 280px;
  border-right: #a4d5ff 1px solid;
}

</style>
