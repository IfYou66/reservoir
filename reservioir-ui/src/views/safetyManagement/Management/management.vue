<template>
  <div class="app-container">

    <!-- 查询 条件查询 -->
    <el-form :model="queryParams" ref="queryParam" v-show="showSearch" :inline="true">
 			<!-- 查询 <预案分类> 选择 -->
      <el-form-item label="预案分类" prop="fActStatus">
        <el-select v-model="queryParams.fPlanType" placeholder="预案分类" clearable size="small" style="width: 240px">
          <el-option v-for="(item,index) in approvalPlanType" :key="index" :label="item.dictLabel" :value="item.dictValue" />
        </el-select>
      </el-form-item>
      <!-- 查询 <名称> 模糊查询 -->
      <el-form-item label="名称" prop="fPlanName">
        <el-input v-model="queryParams.fPlanName" placeholder="请输入计划名称" clearable size="small" style="width: 240px"
                  @keyup.enter.native="handleQuery" />
      </el-form-item>

      <!-- 查询 <状态> 选择 -->
      <el-form-item label="状态" prop="fActStatus">
        <el-select v-model="queryParams.fActStatus" placeholder="状态" clearable size="small" style="width: 240px">
          <el-option v-for="(item,index) in approvalStatus" :key="index" :label="item.dictLabel" :value="item.dictValue" />
        </el-select>
      </el-form-item>



      <!-- 查询 <搜索> <重置> 按钮 -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>

    </el-form>

    <!-- 列表数据 显示 -->
    <el-table v-loading="loading" :data="data" border>

      <el-table-column label="序号" align="center" prop="id" width="120">
        <template scope="scope">
          <span>{{ (scope.$index + 1)}} </span>
        </template>
      </el-table-column>
      <el-table-column label="预案名称" align="center" prop="fPlanName" :show-overflow-tooltip="true" />
      <el-table-column label="编号" align="center" prop="fPlanNumber" :show-overflow-tooltip="true" />
      <el-table-column label="执行时间" align="center" prop="fPublishStartDate" :show-overflow-tooltip="true" />
      <el-table-column label="预案说明" align="center" prop="fPlanSummary" />

      <el-table-column label="状态" align="center">
        <template scope="scope">
          <span v-if="scope.row.fActStatus === 0">待提交</span>
          <span v-if="scope.row.fActStatus === 1">待审核</span>
          <span v-if="scope.row.fActStatus === 2">待批准</span>
          <span v-if="scope.row.fActStatus === 3">待发布</span>
          <span v-if="scope.row.fActStatus === 4">待演练</span>
          <span v-if="scope.row.fActStatus === 5">待执行</span>
          <span v-if="scope.row.fActStatus === 6">已执行</span>
          <span v-if="scope.row.fActStatus === 7">已驳回</span>
          <span v-if="scope.row.fActStatus === 8">不通过</span>
        </template>
      </el-table-column>
      <el-table-column label="分类" align="center">
        <template scope="scope">
<!--          <span v-if="scope.row.fPlanType === 0">水库大坝管理运行预案</span>
          <span v-if="scope.row.fPlanType === 1">水库防汛抢险应急预案</span>
          <span v-if="scope.row.fPlanType === 2">水库防御洪水预案</span> -->

          <span v-if="scope.row.fPlanType == item.dictValue"   v-for="(item,index) in approvalPlanType" :key="index">{{item.dictLabel}}</span>

          <!-- <el-select v-model="queryParams.fPlanType" placeholder="预案分类" clearable size="small" style="width: 240px">
            <el-option v-for="(item,index) in approvalPlanType" :key="index" :label="item.dictLabel" :value="item.dictValue" />
          </el-select> -->
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 0 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              提交
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 1 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              审核
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 2 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              批准
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 3 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              发布
            </el-button>
          </div>
          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 4 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              演练
            </el-button>
          </div>
          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 5 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              执行
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 7 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">
              修改
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;">
            <el-button size="mini" type="text" @click="handleLook(scope.row)">
              详情
            </el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-col :span="24" :xs="24">
      <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                  @pagination="getList" />
    </el-col>

    <el-dialog title="提示" :visible.sync="dialogVisible" width="1500px" @close="initZi">
      <EstablishmentCopy @show="show" :emergencyPass='emergency' :status="status" :fileList="fileList" :fileList2="fileList2" :fileList3="fileList3" :fileList4="fileList4"></EstablishmentCopy>
    </el-dialog>

    <el-dialog title="提示" :visible.sync="dialogVisible1" width="1500px" @close="initZi">
      <EstablishmentCopy2 :emergencyPass='emergency' :status="status" :fileList="fileList" :fileList2="fileList2" :fileList3="fileList3" :fileList4="fileList4"></EstablishmentCopy2>
    </el-dialog>

    <!-- 下一流程 处理人 弹窗 -->
    <el-dialog title="选择处理人" :visible.sync="nextVisible" width="700px">
      <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}
      </el-radio>
      <span slot="footer" class="dialog-footer">
        <el-button @click="nextVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSubmits">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import EstablishmentCopy from './establishmentCopy.vue'
import EstablishmentCopy2 from './establishmentCopy2.vue'
import {
  getUserList
} from "@/api/security/planning"
import {
  listPlanning,
  getPlanning,
  delPlanning,
  addPlanning,
  updatePlanning,
  planDataQuery
} from "@/api/emergency/emergency";
//文件上传
import {
  getFileById
} from "@/api/file";
//获得 Token
import {
  getToken
} from "@/utils/auth";
export default {
  components: {
    EstablishmentCopy,
    EstablishmentCopy2
  },
  data() {
    return {
      //调用子组件 用1 不用 0
      status: 0,
      //预案编制对象
      emergency: {

        //预案编制ID
        fId: '',
        //预案分类
        fPlanType:'',
        //预案名称
        fPlanName: '',
        //预案编号
        fPlanNumber: '',
        //发布开始时间
        fPublishStartDate: '',
        //发布结束时间
        fPublishEndDate: '',
        //预案概述
        fPlanSummary: '',
        //编制时间
        fPreparationTime: '',
        //编制人
        fPreparedBy: '',

        //预案文件ID
        fPlanFileId: '',

        //审核意见
        fReviewComments: '',
        //审核结果
        fReviewResult: '',
        //审核人
        fReviewPeople: '',
        //审核时间
        fReviewDate: '',

        //审批意见
        fAuditComments: '',
        //审批结果
        fAuditResult: '',
        //审批人
        fAuditPeople: '',
        //审批时间
        fAuditDate: '',

        //发布内容
        fPublishContent: '',
        //发布人
        fPublishPeople: '',
        //发布确认时间
        fPublishConfirmDate: '',


        //演练概述
        fDrillOutline:'',
        //演练文件ID
        fDrillFileId:'',
        //演练记录人
        fDrillPeople:'',
        //演练时间
        fDrillDate:'',

        //执行启动记录
        fExecutiveStartRecord:'',
        //执行过程
        fExecutiveProcessRecord:'',
        //执行终止记录
        fExecutiveEndRecord:'',
        //执行文件ID
        fExecutiveFileId:'',
        //执行记录人
        fExecutivePeople:'',
        //执行时间
        fExecutiveDate:'',


        //流程实例ID
        fActId: '',
        //下一节点审核人
        fActPersion: '',
        //流程状态 0：暂存 1：已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除
        fActStatus: '',
        //流程节点
        fActNode: '',

        //创建人
        fCreateBy: '',
        //创建时间
        fCreateTime: '',

      },
      //预案编制对象
      emergencyInit: {

        //预案编制ID
        fId: '',
        //预案分类
        fPlanType:'',
        //预案名称
        fPlanName: '',
        //预案编号
        fPlanNumber: '',
        //发布开始时间
        fPublishStartDate: '',
        //发布结束时间
        fPublishEndDate: '',
        //预案概述
        fPlanSummary: '',
        //编制时间
        fPreparationTime: '',
        //编制人
        fPreparedBy: '',

        //预案文件ID
        fPlanFileId: '',

        //审核意见
        fReviewComments: '',
        //审核结果
        fReviewResult: '',
        //审核人
        fReviewPeople: '',
        //审核时间
        fReviewDate: '',

        //审批意见
        fAuditComments: '',
        //审批结果
        fAuditResult: '',
        //审批人
        fAuditPeople: '',
        //审批时间
        fAuditDate: '',

        //发布内容
        fPublishContent: '',
        //发布人
        fPublishPeople: '',
        //发布确认时间
        fPublishConfirmDate: '',


        //演练概述
        fDrillOutline:'',
        //演练文件ID
        fDrillFileId:'',
        //演练记录人
        fDrillPeople:'',
        //演练时间
        fDrillDate:'',

        //执行启动记录
        fExecutiveStartRecord:'',
        //执行过程
        fExecutiveProcessRecord:'',
        //执行终止记录
        fExecutiveEndRecord:'',
        //执行文件ID
        fExecutiveFileId:'',
        //执行记录人
        fExecutivePeople:'',
        //执行时间
        fExecutiveDate:'',



        //流程实例ID
        fActId: '',
        //下一节点审核人
        fActPersion: '',
        //流程状态 0：暂存 1：已提交启动 2：批准中 3：发布 4：发布完成 7：驳回 8：不同意删除
        fActStatus: '',
        //流程节点
        fActNode: '',

        //创建人
        fCreateBy: '',
        //创建时间
        fCreateTime: '',

      },
      //处理人 集合
      list: '',
      nextVisible: false,
      dialogVisible: false,
      // 遮罩层
      loading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据
      data: [],

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        planName: undefined,
        status: undefined,
        planType:undefined
      },


      approvalStatus: [],
      approvalPlanType:[],

      //当前页码
      pageNum: 1,
      //当前页大小
      pageSize: 10,
      radio: '',
      //文件集合
      fileList: [],
      fileList2: [],
      fileList3: [],
      fileList4: [],

      //详情弹窗
      dialogVisible1: false,
    };
  },
  created() {
    this.getList()
    this.personnel()
    this.dataQuery()
    this.dataQuerys()
  },
  methods: {
    show(){
      this.tijiao();
    },
    dataQuery() {
      var query = { dictType: 'Plan_Classification' }
      planDataQuery(query).then(res => {
        if (res.code == 200) {
          this.approvalPlanType = res.data
        }
      });
    },
    dataQuerys() {
      var query = { dictType: 'Plan_Status' }
      planDataQuery(query).then(res => {
        if (res.code == 200) {
          this.approvalStatus = res.data
        }
      });
    },
    //获取处理人集合
    personnel() {
      console.log('获取处理人集合')
      getUserList().then(response => {
        console.log('获取处理人集合执行成功', response)
        this.list = response.data
      })
    },
    //获取 <列表数据>
    getList() {
      listPlanning(this.queryParams).then(res => {
        if (res.code == 200) {
          console.log("查询列表成功", res)
          this.data = res.rows
          this.total = res.total
        }
      })

    },
    initZi() {
      console.log("关闭了")
      this.getList()
      this.fileList = []
      this.fileList2 = []
      this.fileList3 = []
      this.fileList4 = []
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.pageNum = 1;
      this.getList();
    },

    /** 重置按钮操作 */
    resetQuery() {
      this.queryParams.fActStatus = ''
      this.queryParams.fPlanName = ''
      //this.resetForm("queryForm");
      this.handleQuery();
    },
    //操作按钮
    handleUpdate(val) {
      console.log(this.emergency.fActStatus)
      if (val.fPlanFileId) {
        getFileById({
          id: val.fPlanFileId
        }).then(result => {
          if (result) {
            this.fileList = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fAuditFileId) {
        getFileById({
          id: val.fAuditFileId
        }).then(result => {
          if (result) {
            this.fileList2 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fDrillFileId) {
        getFileById({
          id: val.fDrillFileId
        }).then(result => {
          if (result) {
            this.fileList3 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fExecutiveFileId) {
        getFileById({
          id: val.fExecutiveFileId
        }).then(result => {
          if (result) {
            this.fileList4 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      this.emergency = val
      this.status = 1
      this.dialogVisible = true
    },
    //详情
    handleLook(val) {
      if (val.fPlanFileId) {
        getFileById({
          id: val.fPlanFileId
        }).then(result => {
          if (result) {
            this.fileList = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fAuditFileId) {
        getFileById({
          id: val.fAuditFileId
        }).then(result => {
          if (result) {
            this.fileList2 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fDrillFileId) {
        getFileById({
          id: val.fDrillFileId
        }).then(result => {
          if (result) {
            this.fileList3 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      if (val.fExecutiveFileId) {
        getFileById({
          id: val.fExecutiveFileId
        }).then(result => {
          if (result) {
            this.fileList4 = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
          }
        })
      }
      this.emergency = val
      this.emergency.fActStatus = 10
      this.status = 1
      this.dialogVisible1 = true
    },
    //暂存  提交
    tijiao() {
      console.log(this.emergency.fActStatus)
      //判断是否为 <暂存> 状态
      if (this.emergency.fActStatus == 0 || this.emergency.fActStatus == 7) {
        //是否填写 预案名称
        if (this.emergency.fPlanName == null || this.emergency.fPlanName == '') {
          this.$message({
            showClose: true,
            message: '请填写预案名称',
            type: 'error'
          });
          return false
        }
        //是否填写 预案编号
        if (this.emergency.fPlanNumber == null || this.emergency.fPlanNumber == '') {
          this.$message({
            showClose: true,
            message: '请填写预案编号',
            type: 'error'
          });
          return false
        }
        //是否填写 发布开始时间
        if (this.emergency.fPublishStartDate == null || this.emergency.fPublishStartDate == '') {
          this.$message({
            showClose: true,
            message: '请选择发布开始时间',
            type: 'error'
          });
          return false
        }
        //是否填写 发布结束时间
        if (this.emergency.fPublishEndDate == null || this.emergency.fPublishEndDate == '') {
          this.$message({
            showClose: true,
            message: '请选择发布结束时间',
            type: 'error'
          });
          return false
        }
        //是否填写 预案概述
        if (this.emergency.fPlanSummary == null || this.emergency.fPlanSummary == '') {
          this.$message({
            showClose: true,
            message: '请填写预案概述',
            type: 'error'
          });
          return false
        }
        //是否填写 编制时间
        if (this.emergency.fPreparationTime == null || this.emergency.fPreparationTime == '') {
          this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
          return false
        }
        //是否填写 编制人
        if (this.emergency.fPreparedBy == null || this.emergency.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        //打开处理人 弹窗
        this.addSubmits();
      }
      //判断是否为 <待审核> 状态
      else if (this.emergency.fActStatus == 1) {
        //是否填写 审核意见
        if (this.emergency.fReviewComments == null || this.emergency.fReviewComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审核意见',
            type: 'error'
          });
          return false
        }
        //是否填写 审核结果
        if (this.emergency.fReviewResult == null || this.emergency.fReviewResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审核结果',
            type: 'error'
          });
          return false
        }
        //是否填写 审核人
        if (this.emergency.fReviewPeople == null || this.emergency.fReviewPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审核人',
            type: 'error'
          });
          return false
        }
        //是否填写 审核时间
        if (this.emergency.fReviewDate == null || this.emergency.fReviewDate == '') {
          this.$message({
            showClose: true,
            message: '请选择审核时间',
            type: 'error'
          });
          return false
        }
        //审核结果  为 通过
        if (this.emergency.fReviewResult == 1) {
          //打开处理人 弹窗
          this.addSubmits();
        }
        //审核结果 为 不通过
        else if (this.emergency.fReviewResult == 2) {
          //将状态 变为 不同意删除
          this.emergency.fActStatus = 8
          updatePlanning(this.emergency).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审核提交成功")
              this.dialogVisible = false
              this.nextVisible = false
              this.getList()
            }
          })
        }
        //审核结果 为 驳回
        else if (this.emergency.fReviewResult == 3) {
          //将状态 变为 不同意删除
          this.emergency.fActStatus = 7
          updatePlanning(this.emergency).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审核提交成功")
              this.dialogVisible = false
              this.nextVisible = false
              this.getList()
            }
          })
        }

      }
      //判断是否为 <待批准> 状态
      else if (this.emergency.fActStatus == 2) {
        //是否填写 审批意见
        if (this.emergency.fAuditComments == null || this.emergency.fAuditComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审批意见',
            type: 'error'
          });
          return false
        }
        //是否填写 审批结果
        if (this.emergency.fAuditResult == null || this.emergency.fAuditResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审批结果',
            type: 'error'
          });
          return false
        }
        //是否填写 审批人
        if (this.emergency.fAuditPeople == null || this.emergency.fAuditPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审批人',
            type: 'error'
          });
          return false
        }
        //是否填写 审批时间
        if (this.emergency.fAuditDate == null || this.emergency.fAuditDate == '') {
          this.$message({
            showClose: true,
            message: '请选择审批时间',
            type: 'error'
          });
          return false
        }
        //审批结果  为 通过
        if (this.emergency.fAuditResult == 1) {
          //打开处理人 弹窗
          this.addSubmits();
        }
        //审批结果 为 不通过
        else if (this.emergency.fAuditResult == 2) {
          //将状态 变为 不同意删除
          this.emergency.fActStatus = 8
          updatePlanning(this.emergency).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审批提交成功")
              this.dialogVisible = false
              this.nextVisible = false
              this.getList()
            }
          })
        }
        //审核结果 为 驳回
        else if (this.emergency.fAuditResult == 3) {
          //将状态 变为 不同意删除
          this.emergency.fActStatus = 7
          updatePlanning(this.emergency).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审批提交成功")
              this.dialogVisible = false
              this.nextVisible = false
              this.getList()
            }
          })
        }

      }
      //判断是否为 <待发布> 状态
      else if (this.emergency.fActStatus == 3) {
        //是否填写 发布内容
        if (this.emergency.fPublishContent == null || this.emergency.fPublishContent == '') {
          this.$message({
            showClose: true,
            message: '请填写预案发布内容',
            type: 'error'
          });
          return false
        }
        //是否填写 发布人
        if (this.emergency.fPublishPeople == null || this.emergency.fPublishPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写发布人',
            type: 'error'
          });
          return false
        }
        //是否填写 发布确认时间
        if (this.emergency.fPublishConfirmDate == null || this.emergency.fPublishConfirmDate == '') {
          this.$message({
            showClose: true,
            message: '请选择预案发布时间',
            type: 'error'
          });
          return false
        }
        //将状态 变为 发布完成
        this.emergency.fActStatus = 4
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("预案发布成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //判断是否为 <待演练> 状态
      else if (this.emergency.fActStatus == 4) {
        //是否填写 发布内容
        if (this.emergency.fDrillOutline == null || this.emergency.fDrillOutline == '') {
          this.$message({
            showClose: true,
            message: '请填写演练概述内容',
            type: 'error'
          });
          return false
        }
        //是否填写 发布人
        if (this.emergency.fDrillPeople == null || this.emergency.fDrillPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写演练记录人',
            type: 'error'
          });
          return false
        }
        //是否填写 发布确认时间
        if (this.emergency.fDrillDate == null || this.emergency.fDrillDate == '') {
          this.$message({
            showClose: true,
            message: '请选择演练时间',
            type: 'error'
          });
          return false
        }
        //将状态 变为 演练完成
        this.emergency.fActStatus = 5
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("演练成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //判断是否为 <待执行> 状态
      else if (this.emergency.fActStatus == 5) {
        //是否填写 发布内容
        if (this.emergency.fExecutiveStartRecord == null || this.emergency.fExecutiveStartRecord == '') {
          this.$message({
            showClose: true,
            message: '请填写执行启动内容',
            type: 'error'
          });
          return false
        }
        //是否填写 发布人
        if (this.emergency.fExecutiveProcessRecord == null || this.emergency.fExecutiveProcessRecord == '') {
          this.$message({
            showClose: true,
            message: '请填写执行过程',
            type: 'error'
          });
          return false
        }
        //是否填写 发布确认时间
        if (this.emergency.fExecutiveEndRecord == null || this.emergency.fExecutiveEndRecord == '') {
          this.$message({
            showClose: true,
            message: '填写执行终止记录',
            type: 'error'
          });
          return false
        }
        //是否填写 发布确认时间
        if (this.emergency.fExecutivePeople == null || this.emergency.fExecutivePeople == '') {
          this.$message({
            showClose: true,
            message: '填写执行记录人',
            type: 'error'
          });
          return false
        }
        //是否填写 发布确认时间
        if (this.emergency.fExecutiveDate == null || this.emergency.fExecutiveDate == '') {
          this.$message({
            showClose: true,
            message: '请选择执行时间',
            type: 'error'
          });
          return false
        }
        //将状态 变为 已执行
        this.emergency.fActStatus = 6
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("执行成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
    },
    addSubmits() {
      //  表单 提交
      if (this.emergency.fActStatus == 0) {
        //将状态 变为 待审核
        this.emergency.fActStatus = 1
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  审核 通过
      else if (this.emergency.fActStatus == 1) {
        //将状态 变为 审核通过待批准
        this.emergency.fActStatus = 2
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  批准 通过
      else if (this.emergency.fActStatus == 2) {
        //将状态 变为 待发布
        this.emergency.fActStatus = 3
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  发布 通过
      else if (this.emergency.fActStatus == 3) {
        //将状态 变为 待演练
        this.emergency.fActStatus = 4
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  演练 通过
      else if (this.emergency.fActStatus == 4) {
        //将状态 变为 待执行
        this.emergency.fActStatus = 5
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  执行 通过
      else if (this.emergency.fActStatus == 5) {
        //将状态 变为 已执行
        this.emergency.fActStatus = 6
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }
      //  表单 提交
      if (this.emergency.fActStatus == 7) {
        //将状态 变为 待审核
        this.emergency.fActStatus = 1
        //存放 处理人
        this.emergency.fActPersion = this.radio
        updatePlanning(this.emergency).then(res => {
          if (res.code == 200) {
            this.msgSuccess("提交成功")
            this.dialogVisible = false
            this.nextVisible = false
            this.getList()
          }
        })
      }

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
