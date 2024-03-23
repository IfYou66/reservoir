<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="调度名称" prop="fPlanName">
        <el-input v-model="queryParams.fDispatchName" placeholder="请输入计划名称" clearable size="small" style="width: 240px"
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="状态" prop="fActStatus">
        <el-select v-model="queryParams.fActStatus" placeholder="状态" clearable size="small" style="width: 240px">
          <el-option v-for="item in controlStatus" :key="item.dictValue" :label="item.dictLabel"
            :value="item.dictValue" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-table v-loading="loading" :data="controlList">
      <el-table-column width="55" align="center" />
      <el-table-column label="序号" align="center" type="index" width="200" />
      <el-table-column label="调度名称" align="center" prop="fDispatchName" width="300" />
      <!-- <el-table-column label="预算" align="center" prop="fBudget" :show-overflow-tooltip="true" width="300" /> -->
      <el-table-column label="调度时间" align="center" prop="fEditTime" :show-overflow-tooltip="true" width="300" />
      <el-table-column label="状态" align="center" prop="fActStatus" width="300">
        <template slot-scope="scope">
          <span v-if="scope.row.fActStatus === 0">待提交</span>
          <span v-if="scope.row.fActStatus === 1">待审核</span>
          <span v-if="scope.row.fActStatus === 2">待批准</span>
          <span v-if="scope.row.fActStatus === 3">已批准</span>
          <span v-if="scope.row.fActStatus === 4">已驳回</span>
          <span v-if="scope.row.fActStatus === 5">不通过</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="open1(scope.row)">
            <span v-if="scope.row.fActStatus == 0">提交</span>
            <span v-else-if="scope.row.fActStatus == 1">审核</span>
            <span v-else-if="scope.row.fActStatus == 2">审批</span>
            <span v-else-if="scope.row.fActStatus == 4">修改</span>
          </el-button>
          <el-button v-if="scope.row.fActStatus > 1" size="mini" type="text" @click="open2(scope.row)">
            详情
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <el-dialog title="提示" :visible.sync="editFormVisible1" width="1500px">
      <mainDetails :rControl='rControl' :audit='audit'></mainDetails>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editFormVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="submitForm">提 交</el-button>
      </span>
    </el-dialog>

    <el-dialog title="提示" :visible.sync="editFormVisible2" width="1500px">
      <div class="from-div">
        <el-row class="from-top">
          <el-col :span="24">
            <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
              <div style="position: relative;">
                <img src="../../../assets/images/jin.png" />
                <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.编制</div>
              </div>
              <div style="position: relative;">
                <img :src="require(this.rControl.fActStatus>=1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
                <div :style="this.rControl.fActStatus>=1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
                  2.审核</div>
              </div>
              <div style="position: relative;">
                <img :src="require(this.rControl.fActStatus>=2? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
                <div :style="this.rControl.fActStatus>=2? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
                  3.审批</div>
              </div>
              <div style="position: relative;">
                <img :src="require(this.rControl.fActStatus==3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
                <div :style="this.rControl.fActStatus==3? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
                  4.完成</div>
              </div>
            </div>
          </el-col>

        </el-row>
        <el-row>
          <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
            <div style="margin-right: 10px">
              <el-button type="primary" size="small" @click="editFormVisible2 = false">取消</el-button>
              <el-button type="primary" size="small" @click="tijiao">提交</el-button>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24" class="from-div-title">年度调度编制表</el-col>
        </el-row>
        <el-row class="from-border-bottom">
          <el-col :span="3" class="from-col-left">
            调度名称
          </el-col>
          <el-col :span="8" class="from-border-right">
            <el-input v-model="rControl.fDispatchName" placeholder="请输入内容" :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true"></el-input>
          </el-col>
          <el-col :span="3" class="from-col-left">
            调度类型
          </el-col>
          <el-col :span="3" style="line-height: 40px;border-right: #a4d5ff 1px solid;">
            <div>
              <el-select v-model="rControl.fDispatchType" placeholder="请选择" :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true">
                <el-option v-for="item in audit.planType" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
          </el-col>
          <el-col :span="3" class="from-col-left">
            预算（元）
          </el-col>
          <el-col :span="4" class="from-border-right">
            <el-input v-model="rControl.fBudget" placeholder="预算（元）" :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true"></el-input>
          </el-col>
        </el-row>

        <el-row class="from-border-bottom">
          <el-col :span="3" class="from-borderibht">
            调度内容
          </el-col>
          <el-col :span="21" style="height: 400px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              调度概述：
            </div>
            <el-input  maxlength="500" show-word-limit  :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true" type="textarea" :rows="8" placeholder="请输入内容"
              v-model="rControl.fDispatchContent">
            </el-input>
            <div style="display:flex;justify-content:space-between;margin-top: 100px;">
              <div style="width: 200px;margin-top: -60px;margin-left: 20px;">
                <el-upload  style="margin-left: 15px;margin-top: 15px"
                  class="upload-demo" :headers="GLOBAL.headers()" :action="GLOBAL.httpUrl" :on-preview="handlePreview"
                  :on-remove="handleRemove"  multiple :on-success="uploadedSuccess"
                  :show-file-list="true" :auto-upload="true" :limit="1" :on-exceed="handleExceed" :file-list="fileList"  :before-upload = "beforeAvatarUpload" >
                  <el-button size="small" type="primary" :disabled="rControl.fActStatus == 0 || rControl.fActStatus == 4 ? false : true">上传附件</el-button>
                  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
                </el-upload>
              </div>
              <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
                <div>
                  <span>编制人：<el-input :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true"
                      v-model="rControl.fEditPersion" placeholder="请输入内容"
                      style="width:220px;border: 1px solid #DCDFE6;">
                    </el-input></span>
                  <div class="block" style="transform:translateY(10%)">
                    <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                    <el-date-picker :disabled="rControl.fActStatus == 0 ||rControl.fActStatus == 4 ? false : true" type="date"
                      style="border: 1px solid #DCDFE6;" v-model="rControl.fEditTime" placeholder="选择日期"
                      format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" >
                    </el-date-picker>
                  </div>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>

        <el-row class="from-border-bottom">
          <el-col :span="3" class="from-col">
            调度审核
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审核意见：
            </div>
            <el-input  maxlength="500" show-word-limit  :disabled="rControl.fActStatus == 1 ? false : true" type="textarea" :rows="3" placeholder="请输入内容"
              v-model="rControl.fAuditContent">
            </el-input>
            <div class="from-select">
              <div style="margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 700;display:inline;">
                  审核结果：
                </div>
                <el-select :disabled="rControl.fActStatus == 1 ? false : true" v-model="rControl.fAuditResult"
                  clearable placeholder="请选择">
                  <el-option v-for="item in fReviewResultList" :key="item.value" :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </div>
              <div>
                <span>审核人：<el-input :disabled="rControl.fActStatus == 1 ? false : true"
                    v-model="rControl.fAuditPersion" placeholder="请输入内容" style="width:180px;">
                  </el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="rControl.fActStatus == 1 ? false : true" type="date"
                    v-model="rControl.fAuditTime" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd HH:mm:ss">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>

        <el-row class="from-border-bottom">
          <el-col :span="3" class="from-col">
            调度批准
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审批意见：
            </div>
            <el-input  maxlength="500" show-word-limit  type="textarea" :disabled="rControl.fActStatus == 2 ? false : true" :rows="3" v-model="rControl.fApproveContent" placeholder="请输入内容">
            </el-input>
            <div class="from-select">
              <div style="margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 700;display:inline;">
                  审批结果：
                </div>
                <el-select :disabled="rControl.fActStatus == 2 ? false : true" v-model="rControl.fApproveResult" clearable placeholder="请选择">
                  <el-option  v-for="item in fReviewResultList" :key="item.value" :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </div>
              <div>
              <span>审批人：<el-input :disabled="rControl.fActStatus == 2 ? false : true" v-model="rControl.fApprovePersion" placeholder="请输入内容" style="width:180px;">
                </el-input>
              </span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="rControl.fActStatus == 2 ? false : true" type="date"
                                  v-model="rControl.fApproveTime" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                                  value-format="yyyy-MM-dd HH:mm:ss">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
      <!-- <span slot="footer" class="dialog-footer">
        <el-button @click="editFormVisible2 = false">取 消</el-button>
        <el-button type="primary" @click="submitForm2">提 交</el-button>
      </span> -->
    </el-dialog>
  </div>
</template>
<script>
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
    getUserList,
  } from "@/api/security/planning";

  import {
    planDataQuery
  } from "@/api/emergency/emergency";
 /* import {
    listControl,
    getControl,
    delControl,
    addControl,
    updateControl,
    startWorkFlow,
    taskReview,
    getDictByType
  } from "@/api/reservoir/control";*/
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  import {listControl,updateControl} from "@/api/reservoir/annualEstablishment"
  import mainDetails from './annualEstablishment.vue';
  export default {
    components: {
      mainDetails
    },
    name: "RightToolbar",
    data() {
      return {
        controlStatus:[],
        //审核结果 列表
        fReviewResultList: [{
          value: 1,
          label: '通过'
        },
          {
            value: 2,
            label: '不通过'
          },
          {
            value: 3,
            label: '驳回'
          },
        ],
        fPlanName: '',
        rControlImpl: {},
        userList: [],
        nextVisible: false,
        nextVisible2: false,
        audit: [],
        rControl: {},
        // 总条数
        total: 0,
        fileList: [],
        options: [],
        options1: [],
        // 是否显示弹出层
        editFormVisible1: false,
        editFormVisible2: false,
        controlList: [],

        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          fDispatchName: undefined,
          fActStatus: undefined
        },

        queryParams2: {
          fPreparedId: ''
        }
      };
    },
    props: {
      showSearch: {
        type: Boolean,
        default: true,
      },
      columns: {
        type: Array,
      },
    },
    created() {
      this.getList();
      this.dataQuery();
      this.Personnel();
      this.getDitc();

    },
    methods: {
      beforeAvatarUpload(file){
      const isLt100M = file.size / 1024 / 1024 < 100;
         if (!isLt100M) {
                this.$message.error('上传文件大小不能超过 100MB!');
                return false
            }
      },

      dataQuery() {
        var query = { dictType: 'Annual_Dispatching_Status' }
        planDataQuery(query).then(res => {
          if (res.code == 200) {
            this.controlStatus = res.data
          }
        });
      },


      getFile() {
        console.log('fileList = []');
        this.fileList = [];
        if (this.rControl.fImplId) {
          getFileById({
            id: this.rControl.fImplId
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
        this.rControl.fImplId = response.data.fId;
        this.getFile();
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.rControl.fImplId);
        this.rControl.fImplId = '';
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


      open2(row) {
        this.getFile();
        this.editFormVisible2 = true;
        this.fPlanName = row.fPlanName;
        this.queryParams2.fPreparedId = row.fId;
        this.rControl = row;
        console.log(this.queryParams2);
        listControlImpl(this.queryParams2).then(response => {
          if (response.rows && response.rows[0]) {
            this.rControl = response.rows[0]
          }
        });
      },
      //暂存  提交
      tijiao() {
        //判断是否为 <暂存> 状态
        if (this.rControl.fActStatus == 0 || this.rControl.fActStatus == 4) {
          //是否填写 预案名称
          if (this.rControl.fDispatchName == null || this.rControl.fDispatchName == '') {
            this.$message({
              showClose: true,
              message: '请填写调度名称',
              type: 'error'
            });
            return false
          }
          //是否填写 预案编号
          if (this.rControl.fDispatchType == null || this.rControl.fDispatchType == '') {
            this.$message({
              showClose: true,
              message: '请选择调度类型',
              type: 'error'
            });
            return false
          }
          //是否填写 发布开始时间
          if (this.rControl.fBudget == null || this.rControl.fBudget == '') {
            this.$message({
              showClose: true,
              message: '请填写预算',
              type: 'error'
            });
            return false
          }
          //是否填写 发布结束时间
          if (this.rControl.fDispatchContent == null || this.rControl.fDispatchContent == '') {
            this.$message({
              showClose: true,
              message: '请填写计划概述',
              type: 'error'
            });
            return false
          }
          //是否填写 预案概述
          if (this.rControl.fEditPersion == null || this.rControl.fEditPersion == '') {
            this.$message({
              showClose: true,
              message: '请填写编制人',
              type: 'error'
            });
            return false
          }
          //是否填写 编制时间
          if (this.rControl.fEditTime == null || this.rControl.fEditTime == '') {
            this.$message({
              showClose: true,
              message: '请选择编制时间',
              type: 'error'
            });
            return false
          }
          //打开处理人 弹窗
          this.addSubmits();
        }
        //判断是否为 <待审核> 状态
        else if (this.rControl.fActStatus == 1) {
          //是否填写 审核意见
          if (this.rControl.fAuditContent == null || this.rControl.fAuditContent == '') {
            this.$message({
              showClose: true,
              message: '请填写审核意见',
              type: 'error'
            });
            return false
          }
          //是否填写 审核结果
          if (this.rControl.fAuditResult == null || this.rControl.fAuditResult == '') {
            this.$message({
              showClose: true,
              message: '请选择审核结果',
              type: 'error'
            });
            return false
          }
          //是否填写 审核人
          if (this.rControl.fAuditPersion == null || this.rControl.fAuditPersion == '') {
            this.$message({
              showClose: true,
              message: '请填写审核人',
              type: 'error'
            });
            return false
          }
          //是否填写 审核时间
          if (this.rControl.fAuditTime == null || this.rControl.fAuditTime == '') {
            this.$message({
              showClose: true,
              message: '请选择审核时间',
              type: 'error'
            });
            return false
          }
          //审核结果  为 通过
          if (this.rControl.fAuditResult == 1) {
            //打开处理人 弹窗
            this.addSubmits();
          }
          //审核结果 为 不通过
          else if (this.rControl.fAuditResult == 2) {
            //将状态 变为 不同意删除
            this.rControl.fActStatus = 5
            updateControl(this.rControl).then(res => {
              if (res.code == 200) {
                this.msgSuccess("审核提交成功")
                this.editFormVisible2 = false
                this.nextVisible = false
                this.getList()
              }
            })
          }
          //审核结果 为 驳回
          else if (this.rControl.fAuditResult == 3) {
            //将状态 变为 不同意删除
            this.rControl.fActStatus = 4
            updateControl(this.rControl).then(res => {
              if (res.code == 200) {
                this.msgSuccess("审核提交成功")
                this.editFormVisible2 = false
                this.nextVisible = false
                this.getList()
              }
            })
          }

        }
        //判断是否为 <待批准> 状态
        else if (this.rControl.fActStatus == 2) {
          //是否填写 审批意见
          if (this.rControl.fApproveContent == null || this.rControl.fApproveContent == '') {
            this.$message({
              showClose: true,
              message: '请填写审批意见',
              type: 'error'
            });
            return false
          }
          //是否填写 审批结果
          if (this.rControl.fApproveResult == null || this.rControl.fApproveResult == '') {
            this.$message({
              showClose: true,
              message: '请选择审批结果',
              type: 'error'
            });
            return false
          }
          //是否填写 审批人
          if (this.rControl.fApprovePersion == null || this.rControl.fApprovePersion == '') {
            this.$message({
              showClose: true,
              message: '请填写审批人',
              type: 'error'
            });
            return false
          }
          //是否填写 审批时间
          if (this.rControl.fApproveTime == null || this.rControl.fApproveTime == '') {
            this.$message({
              showClose: true,
              message: '请选择审批时间',
              type: 'error'
            });
            return false
          }
          //审批结果  为 通过
          if (this.rControl.fApproveResult == 1) {
            //打开处理人 弹窗
            this.addSubmits();
          }
          //审批结果 为 不通过
          else if (this.rControl.fApproveResult == 2) {
            //将状态 变为 不同意删除
            this.rControl.fActStatus = 5
            updateControl(this.rControl).then(res => {
              if (res.code == 200) {
                this.msgSuccess("审批提交成功")
                this.editFormVisible2 = false
                this.nextVisible = false
                this.getList()
              }
            })
          }
          //审核结果 为 驳回
          else if (this.rControl.fApproveResult == 3) {
            //将状态 变为 不同意删除
            this.rControl.fActStatus = 4
            updateControl(this.rControl).then(res => {
              if (res.code == 200) {
                this.msgSuccess("审批提交成功")
                this.editFormVisible2 = false
                this.nextVisible = false
                this.getList()
              }
            })
          }

        }
      },
      addSubmits() {
        //  表单 提交
        if (this.rControl.fActStatus == 0 || this.rControl.fActStatus == 4) {
          //将状态 变为 待审核
          this.rControl.fActStatus = 1
          //存放 处理人
          this.rControl.fActPersion = this.radio
          updateControl(this.rControl).then(res => {
            if (res.code == 200) {
              this.msgSuccess("提交成功")
              this.editFormVisible2 = false
              this.nextVisible = false
              this.getList()
            }
          })
        }//  审核 通过
        else if (this.rControl.fActStatus == 1) {
          //将状态 变为 审核通过待批准
          this.rControl.fActStatus = 2
          //存放 处理人
          this.rControl.fActPersion = this.radio
          updateControl(this.rControl).then(res => {
            if (res.code == 200) {
              this.msgSuccess("提交成功")
              this.editFormVisible2 = false
              this.nextVisible = false
              this.getList()
            }
          })
        } //  批准 通过
        else if (this.rControl.fActStatus == 2) {
          //将状态 变为 已批准
          this.rControl.fActStatus = 3
          //存放 处理人
          this.rControl.fActPersion = this.radio
          updateControl(this.rControl).then(res => {
            if (res.code == 200) {
              this.msgSuccess("提交成功")
              this.editFormVisible2 = false
              this.nextVisible = false
              this.getList()
            }
          })
        }
      },

      nextL2() {
        if (this.rControl.fActStatus == 5) {
          startWorkFlowControlImpl(this.rControl).then(response => {
            this.msgSuccess("提交成功");
            this.nextVisible2 = false;
            this.editFormVisible2 = false;
            this.getList();
          });
        } else if (this.rControl.fActStatus == 6) {
          taskReviewControlImpl(this.rControl).then(response => {
            this.msgSuccess("审核成功");
            this.nextVisible2 = false;
            this.editFormVisible2 = false;
            this.getList();
          });
        }
      },

      Personnel() {
        getUserList().then(response => {
          this.userList = response.data
        })
      },

      submitForm2() {
        this.nextL();
      },

      submitForm() {
        this.nextL();
      },

      getDitc() {
        getDictByType().then(response => {
          this.audit = response.data
        })
        // listControl(this.queryParams2).then(response => {
        //   if (response.rows) {
        //     this.audit.list = response.rows;
        //   }
        // });
      },

      /** 查询控制运行计划 列表 */
      getList() {
        this.loading = true;
        listControl(this.queryParams).then(response => {
          this.controlList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      open1(rows) {
        this.rControl = rows;
        if (this.rControl.fPlanType) {
          this.rControl.fPlanType = this.rControl.fPlanType.toString();
          if (this.rControl.fReviewResult) {
            this.rControl.fReviewResult = this.rControl.fReviewResult.toString();
            if (this.rControl.fAuditResult) {
              this.rControl.fAuditResult = this.rControl.fAuditResult.toString();
            }
          }
        }


          this.fileList = [];
          if (this.rControl.fDispatchId) {
            getFileById({
              id: this.rControl.fDispatchId
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

        this.editFormVisible2 = true;
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },

      /** 重置按钮操作 */
      resetQuery() {
        this.queryParams = {};
        this.handleQuery();
      }
    },
  };
</script>
<style lang="scss" scoped>
  ::v-deep .el-transfer__button {
    border-radius: 50%;
    padding: 12px;
    display: block;
    margin-left: 0px;
  }

  ::v-deep .el-transfer__button:first-child {
    margin-bottom: 10px;
  }
</style>
