<template>
  <div class="app-container">
    <!-- 顶部 搜索栏 -->
        <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="名称" >
        <el-input
          v-model="queryParams.fPerName"
          placeholder="请输入计划名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" >
        <el-select v-model="queryParams.fStatus" placeholder="状态" clearable
        size="small" style="width: 240px" >
          <el-option v-for="item in approvalStatus" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格 显示 -->
    <el-table  :data="data" border>
      <el-table-column label="序号" align="center" type="index" width="120"/>
      <el-table-column label="项目计划名称" width="300" align="center" prop="fPerName" :show-overflow-tooltip="true"/>
      <el-table-column label="计划时间" align="center" prop="fPreparationTime" width="200"/>
      <el-table-column label="项目概况" align="center" prop="fProContent" show-overflow-tooltip/>
      <el-table-column label="状态" align="center" prop="fStatus" width="200">
        <template scope="scope">
          <span v-if="scope.row.fStatus == 0" >待提交</span>
          <span v-if="scope.row.fStatus == 1" >待审核</span>
          <span v-if="scope.row.fStatus == 2" >待勘察</span>
          <span v-if="scope.row.fStatus == 3" >待招标</span>
          <span v-if="scope.row.fStatus == 4" >待实施</span>
          <span v-if="scope.row.fStatus == 5" >待验收</span>
          <span v-if="scope.row.fStatus == 6" >已验收</span>
          <span v-if="scope.row.fStatus == 7" >待修改</span>
          <span v-if="scope.row.fStatus == 8" >未通过</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 6 || scope.row.fStatus == 8">
            详 情
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 0">
            提 交
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 1">
            审 核
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 2">
            勘 察
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 3">
            招 标
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 4">
            实 施
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 5">
            验 收
          </el-button>

          <el-button size="mini" type="text" @click="open1(scope.row)" v-if="scope.row.fStatus == 7">
            修 改
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

  <el-dialog title="项目申报审批" :visible.sync="editFormVisible" width="1500px" @close="initZi">
    <projectApprove  :rProReport="rProReport"  :fileList="fileList"
    :fileLista="fileList1" :fileListb="fileList2"
    :fileListc="fileList3" :fileListd="fileList4" @shut="close1">
    </projectApprove>
    <!-- <span slot="footer" class="dialog-footer">
          <el-button @click="editFormVisible = false">取 消</el-button>

          <el-button type="primary" @click="addPla" v-if="rProReport.fStatus == 0 ">提 交</el-button>

          <el-button type="primary" @click="modify" v-if="rProReport.fStatus == 7 ">修 改</el-button>

          <el-button type="primary" @click="approve" v-if="rProReport.fStatus == 1 ">提交审批</el-button>

          <el-button type="primary" @click="survey" v-if="rProReport.fStatus == 2 ">提交勘察</el-button>

          <el-button type="primary" @click="bidding" v-if="rProReport.fStatus == 3 ">提交招标</el-button>

          <el-button type="primary" @click="implement" v-if="rProReport.fStatus == 4 ">提交实施</el-button>

          <el-button type="primary" @click="acceptance" v-if="rProReport.fStatus == 5 ">提交验收</el-button>

          <el-button type="primary" @click="editFormVisible = false" v-if="rProReport.fStatus == 8 || rProReport.fStatus == 6">确 定</el-button>


    </span> -->

  </el-dialog>

  <!-- 下一流程 处理人 弹窗 -->
  <el-dialog
    title="选择处理人"
    :visible.sync="nextVisible"
    width="600px"
    >
    <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}</el-radio>
    <span slot="footer" class="dialog-footer">
      <el-button @click="nextVisible = false">取 消</el-button>
      <el-button type="primary" @click="addSubmits">确 定</el-button>
    </span>
  </el-dialog>
  </div>
</template>
<script>
  //获得系统用户
  import {getUserList } from "@/api/security/planning"
  //获得Token
  import {getToken} from "@/utils/auth"
  //获得文件
  import {getFileById} from "@/api/file"
  //项目申报 API
  import {listReport, getReport, addReport, updateReport, delReport} from "@/api/repair/rproreport"
import projectApprove from './projectApprove.vue';
export default {
  components: {projectApprove},
  name: "RightToolbar",
  data() {
    return {
      nextVisible:false,
      list:[],
      total:0,
      radio:'',

      fileList: [],
      fileList1: [],
      fileList2: [],
      fileList3: [],
      fileList4: [],
      options: [{
          value: '选项1',
          label: '计划一'
        }, {
          value: '选项2',
          label: '计划二'
        }, {
          value: '选项3',
          label: '计划三'
        }],
        audit: [{
          value: '选项1',
          label: '通过'
        }, {
          value: '选项2',
          label: '未通过'
        }],
        options1: [{
          value: '选项1',
          label: '汛前检查'
        }, {
          value: '选项2',
          label: '年度检查'
        }, {
          value: '选项3',
          label: '特别检查'
        }],
      // 显隐数据
      // 弹出层标题
      title: "显示/隐藏",
      // 是否显示弹出层
      editFormVisible: false,
      editFormVisible1: false,
      data: [],
         // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fPerName: '',
        fStatus: '',
      },
      approvalStatus: [
        { value: 0, label: '待提交' },
        { value: 1, label: '待审核' },
        { value: 2, label: '待勘察' },
        { value: 3, label: '待招标' },
        { value: 4, label: '待实施' },
        { value: 5, label: '待验收' },
        { value: 6, label: '已验收' },
        { value: 7, label: '待修改' },
        { value: 8, label: '未通过' },
      ],
    //对象 项目申报
    rProReport:{
          //id
          fId:'',
          //项目名称
          fPerName:'',
          //预算
          fBudget:'',

          //项目概况
          fProContent:'',
          //项目概况附件id
          fProId:'',
          //编制人
          fPreparedBy:'',
          //编制时间
          fPreparationTime:'',

          //审批意见
          fAuditComments:'',
          //审批结果
          fAuditResult:'',
          //审批人
          fAuditPeople:'',
          //审批时间
          fAuditDate:'',

          //勘察设计内容
          fDesignContent:'',
          //勘察设计附件id
          fDesignId:'',
          //勘察设计单位
          fDesignUnit:'',
          //勘察设计时间
          fDesignTime:'',

          //招投标概况内容
          fTenderContent:'',
          //招投标附件id
          fTenderId:'',
          //投标人
          fTenderPersion:'',
          //投标时间
          fTenderTime:'',

          //项目实施概况内容
          fProimplContent:'',
          //项目实施内容附件id
          fProimplId:'',
          //项目实施人
          fProimplPersion:'',
          //项目实施时间
          fProimplTime:'',

          //评价验收意见
          fAcceptanceContent:'',
          //验收专家名单
          fAcceptanceList:'',
          //评价验收附件id
          fAcceptanceId:'',
          //专家验收组长
          fAcceptancePersion:'',
          //验收时间
          fAcceptanceTime:'',

          //状态
          fStatus:'',
          //创建人
          fCreatePeople:'',
          //创建时间
          fCreateTime:'',
          //流程实例id
          fActId:'',
          //流程下一节点审核人
          fActPersion:'',
          //流程状态
          fActStatus:'',
          //流程节点
          fActNode:'',
    },
    //对象 项目申报 初始化
    rProReportInit:{
          //id
          fId:'',
          //项目名称
          fPerName:'',
          //预算
          fBudget:'',

          //项目概况
          fProContent:'',
          //项目概况附件id
          fProId:'',
          //编制人
          fPreparedBy:'',
          //编制时间
          fPreparationTime:'',

          //审批意见
          fAuditComments:'',
          //审批结果
          fAuditResult:'',
          //审批人
          fAuditPeople:'',
          //审批时间
          fAuditDate:'',

          //勘察设计内容
          fDesignContent:'',
          //勘察设计附件id
          fDesignId:'',
          //勘察设计单位
          fDesignUnit:'',
          //勘察设计时间
          fDesignTime:'',

          //招投标概况内容
          fTenderContent:'',
          //招投标附件id
          fTenderId:'',
          //投标人
          fTenderPersion:'',
          //投标时间
          fTenderTime:'',

          //项目实施概况内容
          fProimplContent:'',
          //项目实施内容附件id
          fProimplId:'',
          //项目实施人
          fProimplPersion:'',
          //项目实施时间
          fProimplTime:'',

          //评价验收意见
          fAcceptanceContent:'',
          //验收专家名单
          fAcceptanceList:'',
          //评价验收附件id
          fAcceptanceId:'',
          //专家验收组长
          fAcceptancePersion:'',
          //验收时间
          fAcceptanceTime:'',

          //状态
          fStatus:'',
          //创建人
          fCreatePeople:'',
          //创建时间
          fCreateTime:'',
          //流程实例id
          fActId:'',
          //流程下一节点审核人
          fActPersion:'',
          //流程状态
          fActStatus:'',
          //流程节点
          fActNode:'',
    },
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
    // 显隐列初始默认隐藏列
    for (let item in this.columns) {
      if (this.columns[item].visible === false) {
        this.value.push(parseInt(item));
      }
    }
    this.personnel()
    this.getList()
  },
  methods: {
    //点击 <下一个处理人> 弹窗 => <确定> 按钮
    addSubmits() {
      if(this.radio == null || this.radio == '') {
        this.$message({
          showClose: true,
          message: '请选择处理人',
          type: 'error'
        });
        return false
      }
      //提交 保存
      if(this.rProReport.fStatus == 0 || this.rProReport.fStatus == 7) {
        this.rProReport.fStatus = 1
        this.rProReport.fActPersion = this.radio
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
      //提交 审核
      else if(this.rProReport.fStatus == 1) {
        this.rProReport.fStatus = 2
        this.rProReport.fActPersion = this.radio
        console.log('处理人  ',this.radio)
        console.log('处理人  ',this.rProReport.fActPersion)
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
      //提交 勘察
      else if(this.rProReport.fStatus == 2) {
        this.rProReport.fStatus = 3
        this.rProReport.fActPersion = this.radio
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
      //提交 招投标
      else if(this.rProReport.fStatus == 3) {
        this.rProReport.fStatus = 4
        this.rProReport.fActPersion = this.radio
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
      //提交 实施
      else if(this.rProReport.fStatus == 4) {
        this.rProReport.fStatus = 5
        this.rProReport.fActPersion = this.radio
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
    },
    //获取处理人集合
    personnel(){
      console.log('获取处理人集合')
      getUserList().then(response => {
         console.log('获取处理人集合执行成功',response)
        this.list = response.data
      })
    },

    //获得 数据 列表
    getList() {
      listReport(this.queryParams).then(res => {
        if(res.code == 200) {
          console.log('获得 数据 列表', res.rows)
          this.total = res.total
          this.data = res.rows
        }
      })
    },
    open(){
      this.editFormVisible = true;
    },
    open1(val){
      if(val.fProId) {
        getFileById({id:val.fProId}).then(result =>{
          if (result) {
            this.fileList = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }
      if(val.fDesignId) {
        getFileById({id:val.fDesignId}).then(result =>{
          if (result) {
            this.fileList1 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList1.url:",this.fileList[0].url);
            console.log("fileList1.name:",this.fileList[0].name);
          }
        })
      }
      if(val.fTenderId) {
        getFileById({id:val.fTenderId}).then(result =>{
          if (result) {
            this.fileList2 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList2.url:",this.fileList[0].url);
            console.log("fileList2.name:",this.fileList[0].name);
          }
        })
      }
      if(val.fProimplId) {
        getFileById({id:val.fProimplId}).then(result =>{
          if (result) {
            this.fileList3 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList3.url:",this.fileList[0].url);
            console.log("fileList3.name:",this.fileList[0].name);
          }
        })
      }
      if(val.fAcceptanceId) {
        getFileById({id:val.fAcceptanceId}).then(result =>{
          if (result) {
            this.fileList4 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList4.url:",this.fileList[0].url);
            console.log("fileList4.name:",this.fileList[0].name);
          }
        })
      }
      this.rProReport = val
      this.editFormVisible = true;
    },
    /** 搜索按钮操作 */
    handleQuery() {

      this.queryParams.pageNum = 1;
      this.getList();
    },
    initZi() {
      this.handleQuery()
      this.fileList = []
      this.fileList1 = []
      this.fileList2 = []
      this.fileList3 = []
      this.fileList4 = []
    },

    /** 重置按钮操作 */
    resetQuery() {
      //this.dateRange = [];
      this.queryParams.fStatus = ''
      this.queryParams.fPerName = ''
      this.handleQuery();
    },
    addPla() {
      console.log('提 交')
      //是否填写 项目名称
      if(this.rProReport.fPerName == null || this.rProReport.fPerName == '') {
        this.$message({
          showClose: true,
          message: '请填写项目名称',
          type: 'error'
        });
        return false
      }
      //是否填写 预算
      if(this.rProReport.fBudget == null || this.rProReport.fBudget == '') {
        this.$message({
          showClose: true,
          message: '请选择计划预算',
          type: 'error'
        });
        return false
      }
      //是否填写 项目概况
      if(this.rProReport.fProContent == null || this.rProReport.fProContent == '') {
        this.$message({
          showClose: true,
          message: '请填写项目概况',
          type: 'error'
        });
        return false
      }
      //是否填写 编制人
      if(this.rProReport.fPreparedBy == null || this.rProReport.fPreparedBy == '') {
        this.$message({
          showClose: true,
          message: '请填写编制人',
          type: 'error'
        });
        return false
      }
      //是否填写 编制时间
      if(this.rProReport.fPreparationTime == null || this.rProReport.fPreparationTime == '') {
        this.$message({
          showClose: true,
          message: '请选择编制时间',
          type: 'error'
        });
        return false
      }
        this.rProReport.fStatus = 1
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
    },
    modify() {
      console.log('修 改')
      //是否填写 项目名称
      if(this.rProReport.fPerName == null || this.rProReport.fPerName == '') {
        this.$message({
          showClose: true,
          message: '请填写项目名称',
          type: 'error'
        });
        return false
      }
      //是否填写 预算
      if(this.rProReport.fBudget == null || this.rProReport.fBudget == '') {
        this.$message({
          showClose: true,
          message: '请选择计划预算',
          type: 'error'
        });
        return false
      }
      //是否填写 项目概况
      if(this.rProReport.fProContent == null || this.rProReport.fProContent == '') {
        this.$message({
          showClose: true,
          message: '请填写项目概况',
          type: 'error'
        });
        return false
      }
      //是否填写 编制人
      if(this.rProReport.fPreparedBy == null || this.rProReport.fPreparedBy == '') {
        this.$message({
          showClose: true,
          message: '请填写编制人',
          type: 'error'
        });
        return false
      }
      //是否填写 编制时间
      if(this.rProReport.fPreparationTime == null || this.rProReport.fPreparationTime == '') {
        this.$message({
          showClose: true,
          message: '请选择编制时间',
          type: 'error'
        });
        return false
      }
      this.rProReport.fStatus = 1
      updateReport(this.rProReport).then(res => {
        if(res.code == 200) {
          this.msgSuccess("提交成功")
          this.editFormVisible = false
          this.nextVisible = false
          this.fileList = []
          this.fileList1 = []
          this.fileList2 = []
          this.fileList3 = []
          this.fileList4 = []
          this.radio = ''
        }
      })
    },
    approve() {
      console.log('提交审批')

      //是否填写 审核意见
      if(this.rProReport.fAuditComments == null || this.rProReport.fAuditComments == '') {
        this.$message({
          showClose: true,
          message: '请填写审批意见',
          type: 'error'
        });
        return false
      }
      //是否填写 审核结果
      if(this.rProReport.fAuditResult == null || this.rProReport.fAuditResult == '') {
        this.$message({
          showClose: true,
          message: '请选择审批结果',
          type: 'error'
        });
        return false
      }
      //是否填写 审核人
      if(this.rProReport.fAuditPeople == null || this.rProReport.fAuditPeople == '') {
        this.$message({
          showClose: true,
          message: '请填写审批人',
          type: 'error'
        });
        return false
      }
      //是否填写 审批时间
      if(this.rProReport.fAuditDate == null || this.rProReport.fAuditDate == '') {
        this.$message({
          showClose: true,
          message: '请选择审批时间',
          type: 'error'
        });
        return false
      }
      //审核结果 => 通过
      if(this.rProReport.fAuditResult == 1) {
        this.rProReport.fStatus = 2
        console.log('处理人  ',this.radio)
        console.log('处理人  ',this.rProReport.fActPersion)
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      }
      //审核结果 => 不通过
      else if(this.rProReport.fAuditResult == 2) {
        this.rProReport.fStatus = 8
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
          }
        })
      }
      //审核结果 => 驳回
      else if(this.rProReport.fAuditResult == 3) {
        this.rProReport.fStatus = 7
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
          }
        })
      }

    },
    survey() {
      console.log('提交勘察')
      //是否填写 勘察设计内容
      if(this.rProReport.fDesignContent == null || this.rProReport.fDesignContent == '') {
        this.$message({
          showClose: true,
          message: '请填写勘察设计内容',
          type: 'error'
        });
        return false
      }
      //是否填写 勘察设计单位
      if(this.rProReport.fDesignUnit == null || this.rProReport.fDesignUnit == '') {
        this.$message({
          showClose: true,
          message: '请填写勘察设计单位',
          type: 'error'
        });
        return false
      }
      //是否填写 勘察设计时间
      if(this.rProReport.fDesignTime == null || this.rProReport.fDesignTime == '') {
        this.$message({
          showClose: true,
          message: '请选择勘察设计时间',
          type: 'error'
        });
        return false
      }
        this.rProReport.fStatus = 3
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
    },
    bidding() {
      console.log('提交招标')
      //是否填写 招投标概况内容
      if(this.rProReport.fTenderContent == null || this.rProReport.fTenderContent == '') {
        this.$message({
          showClose: true,
          message: '请填写招投标概况内容',
          type: 'error'
        });
        return false
      }
      //是否填写 投标人
      if(this.rProReport.fTenderPersion == null || this.rProReport.fTenderPersion == '') {
        this.$message({
          showClose: true,
          message: '请填写投标人',
          type: 'error'
        });
        return false
      }
      //是否填写 投标时间
      if(this.rProReport.fTenderTime == null || this.rProReport.fTenderTime == '') {
        this.$message({
          showClose: true,
          message: '请选择投标时间',
          type: 'error'
        });
        return false
      }
      console.log("========= 提交招标 =========",this.rProReport)
      this.rProReport.fStatus = 4
      updateReport(this.rProReport).then(res => {
        if(res.code == 200) {
          this.msgSuccess("提交成功")
          this.editFormVisible = false
          this.nextVisible = false
          this.fileList = []
          this.fileList1 = []
          this.fileList2 = []
          this.fileList3 = []
          this.fileList4 = []
          this.radio = ''
        }
      })
    },
    implement() {
      console.log('提交实施')
      //是否填写 项目实施概况内容
      if(this.rProReport.fProimplContent == null || this.rProReport.fProimplContent == '') {
        this.$message({
          showClose: true,
          message: '请填写项目实施概况内容',
          type: 'error'
        });
        return false
      }
      //是否填写 项目实施人
      if(this.rProReport.fProimplPersion == null || this.rProReport.fProimplPersion == '') {
        this.$message({
          showClose: true,
          message: '请填写项目实施人',
          type: 'error'
        });
        return false
      }
      //是否填写 项目实施时间
      if(this.rProReport.fProimplTime == null || this.rProReport.fProimplTime == '') {
        this.$message({
          showClose: true,
          message: '请选择项目实施时间',
          type: 'error'
        });
        return false
      }
        this.rProReport.fStatus = 5
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.editFormVisible = false
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
    },
    acceptance() {
      console.log('提交验收')
      //是否填写 评价验收意见
      if(this.rProReport.fAcceptanceContent == null || this.rProReport.fAcceptanceContent == '') {
        this.$message({
          showClose: true,
          message: '请填写评价验收意见',
          type: 'error'
        });
        return false
      }
      //是否填写 验收专家名单
      if(this.rProReport.fAcceptanceList == null || this.rProReport.fAcceptanceList == '') {
        this.$message({
          showClose: true,
          message: '请填写验收专家名单',
          type: 'error'
        });
        return false
      }
      //是否填写 专家验收组长
      if(this.rProReport.fAcceptancePersion == null || this.rProReport.fAcceptancePersion == '') {
        this.$message({
          showClose: true,
          message: '请填写专家验收组长',
          type: 'error'
        });
        return false
      }
      //是否填写 验收时间
      if(this.rProReport.fAcceptanceTime == null || this.rProReport.fAcceptanceTime == '') {
        this.$message({
          showClose: true,
          message: '请选择验收时间',
          type: 'error'
        });
        return false
      }
      this.rProReport.fStatus = 6
      updateReport(this.rProReport).then(res => {
        if(res.code == 200) {
          this.msgSuccess("提交成功")
          this.editFormVisible = false
          this.fileList = []
          this.fileList1 = []
          this.fileList2 = []
          this.fileList3 = []
          this.fileList4 = []
        }
      })

    },
    // 关闭弹窗——实施
    close1(data) {
        this.editFormVisible = false
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
.el-steps--simple{
  padding: 0;
}
</style>
