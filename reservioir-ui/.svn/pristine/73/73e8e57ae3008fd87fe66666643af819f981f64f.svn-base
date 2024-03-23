<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="计划名称" prop="fPlanName">
        <el-input v-model="queryParams.fPlanName" placeholder="请输入计划名称" clearable size="small" style="width: 240px"
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="状态" prop="fActStatus">
        <el-select v-model="queryParams.fActStatus" placeholder="状态" clearable size="small" style="width: 240px">
          <el-option v-for="item in audit.controlStatus" :key="item.dictValue" :label="item.dictLabel"
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
      <el-table-column label="计划名称" align="center" prop="fPlanName" width="300" />
      <el-table-column label="计划时间" align="center" prop="fPreparationTime" :show-overflow-tooltip="true" width="300" />
      <el-table-column label="状态" align="center" prop="fActStatus" width="300">
        <template slot-scope="scope">
          <span v-for="(item,index) in audit.controlStatus" :key="index" v-if="item.dictValue == scope.row.fActStatus">
            {{ item.dictLabel }}
          </span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="open1(scope.row)">
            <span v-if="scope.row.fActStatus == 0">查看</span>
            <span v-else-if="scope.row.fActStatus == 1">提交</span>
            <span v-else-if="scope.row.fActStatus == 2">审核</span>
            <span v-else-if="scope.row.fActStatus == 3">审批</span>
            <span v-else-if="scope.row.fActStatus > 3">计划详情</span>
          </el-button>
          <el-button v-if="scope.row.fActStatus > 4" size="mini" type="text" @click="open2(scope.row)">
            <span v-if="scope.row.fActStatus == 0">查看</span>
            <span v-else-if="scope.row.fActStatus == 5">实施提交</span>
            <span v-else-if="scope.row.fActStatus == 6">实施审核</span>
            <span v-else-if="scope.row.fActStatus == 7">实施详情</span>
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <el-dialog title="计划详情" :visible.sync="editFormVisible1" width="1500px">
      <mainPlan :rControl='rControl' :audit='audit' @submitForm="submitForm" @submitFormfalse="submitFormfalse"></mainPlan>
      <!-- <span slot="footer" class="dialog-footer">
        <el-button @click="editFormVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="submitForm">提 交</el-button>
      </span> -->
    </el-dialog>

    <el-dialog title="实施详情" :visible.sync="editFormVisible2" width="1500px">
      <div class="from-div">
        <el-row>
          <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
            <div style="margin-right: 10px">
              <el-button type="primary" size="small" @click="editFormVisible2 = false">取消</el-button>
              <el-button type="primary" size="small" @click="submitForm2">提交</el-button>
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
            <span>
              <el-input :disabled="rControl.fActStatus == 5 ? false : true" v-model="fPlanName" placeholder=""
                style="width:220px;solid #DCDFE6;">
              </el-input>
            </span>
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
            <el-input  maxlength="500" show-word-limit  :disabled="rControl.fActStatus == 5 ? false : true" type="textarea" :rows="8" placeholder="请输入内容"
              v-model="rControlImpl.fImplContent">
            </el-input>
            <div style="display:flex;justify-content:space-between;margin-top: 100px;">
              <div style="width: 200px;margin-top: -60px;margin-left: 20px;">
                <el-upload v-if="rControl.fActStatus == 5 || fileList" style="margin-left: 15px;margin-top: 15px"
                     :before-upload = "beforeAvatarUpload"
                  class="upload-demo" :headers="GLOBAL.headers()" :action="GLOBAL.httpUrl" :on-preview="handlePreview"
                  :on-remove="handleRemove"  multiple :on-success="uploadedSuccess"
                  :show-file-list="true" :auto-upload="true" :limit="1" :on-exceed="handleExceed" :file-list="fileList">
                  <el-button size="small" type="primary">上传附件</el-button>
                  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
                </el-upload>
              </div>
              <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
                <div>
                  <span>实施人：<el-input :disabled="rControl.fActStatus == 5 ? false : true"
                      v-model="rControlImpl.fImplPeople" placeholder="请输入内容"
                      style="width:220px;border: 1px solid #DCDFE6;">
                    </el-input></span>
                  <div class="block" style="transform:translateY(10%)">
                    <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                    <el-date-picker :disabled="rControl.fActStatus == 5 ? false : true" type="date"
                      style="border: 1px solid #DCDFE6;" v-model="rControlImpl.fImplTime" placeholder="选择日期"
                      format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
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
            <el-input  maxlength="500" show-word-limit  :disabled="rControl.fActStatus == 6 ? false : true" type="textarea" :rows="3" placeholder="请输入内容"
              v-model="rControlImpl.fReviewComments">
            </el-input>
            <div class="from-select">
              <div style="margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 700;display:inline;">
                  审核结果：
                </div>
                <el-select :disabled="rControl.fActStatus == 6 ? false : true" v-model="rControlImpl.fReviewResult"
                  clearable placeholder="请选择">
                  <el-option v-for="item in audit.sysResult" :key="item.dictValue" :label="item.dictLabel"
                    :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div>
                <span>审核人：<el-input :disabled="rControl.fActStatus == 6 ? false : true"
                    v-model="rControlImpl.fReviewPeople" placeholder="请输入内容" style="width:180px;">
                  </el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="rControl.fActStatus == 6 ? false : true" type="date"
                    v-model="rControlImpl.fReviewDate" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
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
    listControl,
    getControl,
    delControl,
    addControl,
    updateControl,
    startWorkFlow,
    taskReview,
    getDictByType
  } from "@/api/reservoir/control";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  import mainDetails from './mainDetails.vue';
  import mainPlan from './mainPlan.vue';
  export default {
    components: {
      mainDetails,
      mainPlan
    },
    name: "RightToolbar",
    data() {
      return {
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
          fPlanName: undefined,
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
      this.Personnel();
      this.getDitc();
      this.getList();
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
        this.fileList = [];
        if (this.rControlImpl.fImplId) {
          getFileById({
            id: this.rControlImpl.fImplId
          }).then(result => {
            console.log(result)
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              console.log("fileList.url:", this.fileList[0]);
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


      open2(row) {
        this.editFormVisible2 = true;
        this.fPlanName = row.fPlanName;
        this.queryParams2.fPreparedId = row.fId;
        this.rControl = row;
        listControlImpl(this.queryParams2).then(response => {
          if (response.rows && response.rows[0]) {
            this.rControlImpl = response.rows[0]
          }
          this.getFile();
        });
      },

      nextL() {
        if (this.rControl.fActStatus == 1) {
          startWorkFlow(this.rControl).then(response => {
            this.msgSuccess("提交成功");
            this.nextVisible = false;
            this.editFormVisible1 = false;
            this.getList();
          });
        } else if (this.rControl.fActStatus == 2 || this.rControl.fActStatus == 3) {
          taskReview(this.rControl).then(response => {
            if (this.rControl.fActStatus == 2) {
              this.msgSuccess("审核成功");
            } else {
              this.msgSuccess("审批成功");
            }
            this.nextVisible = false;
            this.editFormVisible1 = false;
            this.getList();
          });
        }
      },

      nextL2() {
        if (this.rControl.fActStatus == 5) {
          startWorkFlowControlImpl(this.rControlImpl).then(response => {
            this.msgSuccess("提交成功");
            this.nextVisible2 = false;
            this.editFormVisible2 = false;
            this.getList();
          });
        } else if (this.rControl.fActStatus == 6) {
          taskReviewControlImpl(this.rControlImpl).then(response => {
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
        this.nextL2();
      },
      submitFormfalse(){
        this.editFormVisible1 = false
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
        this.editFormVisible1 = true;
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
