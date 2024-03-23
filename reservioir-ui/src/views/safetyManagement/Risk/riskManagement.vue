<template>
  <div class="app-container">

    <!-- 查询 查询条件 -->
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="名称" prop="fRiskName">
        <el-input
          v-model="queryParams.fRiskName"
          placeholder="请输入名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" prop="fActStatus">
        <el-select
          v-model="queryParams.fActStatus"
          placeholder="状态"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="item in approvalStatus"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 列表 数据 -->
    <el-table v-loading="loading" :data="data" border>

      <el-table-column label="序号" align="center" prop="id" width="120">
        <template scope="scope">
          <span>{{  (scope.$index + 1)}} </span>
        </template>
      </el-table-column>
      <el-table-column label="险情名称" align="center" prop="fRiskName" :show-overflow-tooltip="true">
        <template slot-scope="scope">
            <span @click="handleUpdate" class="color409"
            >{{ scope.row.fRiskName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上报人" align="center" prop="fRecordPeople" :show-overflow-tooltip="true" />
      <el-table-column label="发现时间" align="center" prop="fRiskFindDate" :show-overflow-tooltip="true" />
      <el-table-column label="险情录入" align="center" prop="fRiskSummary" />
      <el-table-column label="应急响应情况" align="center" prop="fResponseSituation" />

      <el-table-column label="状态" align="center" prop="fActStatus" >
        <template scope="scope">
          <span v-if="scope.row.fActStatus === 0" >待提交</span>
          <span v-if="scope.row.fActStatus === 1" >待响应</span>
          <span v-if="scope.row.fActStatus === 2" >待排除</span>
          <span v-if="scope.row.fActStatus === 3" >待检查</span>
          <span v-if="scope.row.fActStatus === 4" >已检查</span>
          <span v-if="scope.row.fActStatus === 5" >待修改</span>
          <span v-if="scope.row.fActStatus === 6" >未通过</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">

           <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 0 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)" >
              提交
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 1 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)" >
              响应
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 2 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)" >
              处置
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 3 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)" >
              检查
            </el-button>
          </div>
          <div style="overflow: auto;display: inline;margin-left:20px;" v-if="scope.row.fActStatus == 5 ">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)" >
              修改
            </el-button>
          </div>

          <div style="overflow: auto;display: inline;margin-left:20px;" >
            <el-button size="mini" type="text" @click="handleUpdate2(scope.row)" >
              详情
            </el-button>
          </div>

        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 组件 -->
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!-- 弹窗 操作 -->
    <el-dialog title="提示" :visible.sync="dialogVisible" width="1500px" @close="initZi">

      <HandlingCopy :MRiskManagement="MRiskManagement" @addPlafalse="addPlafalse" @addPla="addPla" :fileList="fileList" :fileList1="fileList1" :fileList2="fileList2"></HandlingCopy>
<!--      <span slot="footer" class="dialog-footer">
        <el-button @click="addPlafalse">取 消</el-button>

        <el-button type="primary" @click="addPla"
        v-if="MRiskManagement.fActStatus == 0 ">提 交</el-button>

        <el-button type="primary" @click="addPla"
        v-if="MRiskManagement.fActStatus == 5 ">修 改</el-button>

        <el-button type="primary" @click="addPla"
        v-if="MRiskManagement.fActStatus == 1 ">提 交</el-button>

        <el-button type="primary" @click="addPla"
        v-if="MRiskManagement.fActStatus == 2 ">提 交</el-button>

        <el-button type="primary" @click="addPla2"
        v-if="MRiskManagement.fActStatus == 3 ">提 交</el-button>

        <el-button type="primary" @click="dialogVisible = false"
        v-if="MRiskManagement.fActStatus == 4 ">确 定</el-button>

      </span>-->
    </el-dialog>

    <!-- 弹窗 操作 -->
    <el-dialog title="提示" :visible.sync="dialogVisible2" width="1500px" @close="initZi">

      <HandlingCopy2 :MRiskManagement="MRiskManagement" :fileList="fileList" :fileList1="fileList1" :fileList2="fileList2"></HandlingCopy2>
    </el-dialog>

    <!-- 下一流程 处理人 弹窗 -->
    <el-dialog
      title="选择处理人"
      :visible.sync="nextVisible"
      width="700px">
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
  import HandlingCopy from './handlingCopy.vue'
  import HandlingCopy2 from './handlingCopy2.vue'
  //引入 险情管理 接口js
  import {listManagement, getManagement, addManagement, updateManagement, delManagement} from '@/api/risk/risk'
  import {getFileById} from "@/api/file"

export default {
  components: {HandlingCopy, HandlingCopy2},
  data() {
    return {
      fileList: [],
      fileList1: [],
      fileList2: [],
      //对象
      MRiskManagement:{
          //险情管理ID
          fId:'',
          //险情名称
          fRiskName:'',
          //险情类别
          fRiskType:'',
          //险情编号
          fRiskNumber:'',
          //险情发现时间
          fRiskFindDate:'',

          //险情概述
          fRiskSummary:'',
          //记录人
          fRecordPeople:'',
          //记录时间
          fRecordDate:'',
          //险情信息附件ID
          fRiskInfoFileId:'',

          //响应情况
          fResponseSituation:'',
          //响应人
          fResponsePeople:'',
          //响应时间
          fResponseDate:'',
          //响应信息附件ID
          fResponseInfoFileId:'',

          //处置结果
          fDisposalResults:'',
          //处置人
          fDisposalPeople:'',
          //处置时间
          fDisposalDate:'',
          //处置信息附件ID
          fDisposalInfoFileId:'',

          //检查意见
          fInspectionOpinions:'',
          //检查结果
          fInspectionResults:'',
          //检查人
          fInspectionPeople:'',
          //检查时间
          fInspectionDate:'',

          //流程实例ID
          fActId:'',
          //下一节点审核人
          fActPersion:'',
          //流程状态
          fActStatus:'',
          //流程节点
          fActNode:'',
          //创建人
          fCreateBy:'',
          //创建时间
          fCreateTime:'',
      },
      //对象
      MRiskManagementInit:{
          //险情管理ID
          fId:'',
          //险情名称
          fRiskName:'',
          //险情类别
          fRiskType:'',
          //险情编号
          fRiskNumber:'',
          //险情发现时间
          fRiskFindDate:'',

          //险情概述
          fRiskSummary:'',
          //记录人
          fRecordPeople:'',
          //记录时间
          fRecordDate:'',
          //险情信息附件ID
          fRiskInfoFileId:'',

          //响应情况
          fResponseSituation:'',
          //响应人
          fResponsePeople:'',
          //响应时间
          fResponseDate:'',
          //响应信息附件ID
          fResponseInfoFileId:'',

          //处置结果
          fDisposalResults:'',
          //处置人
          fDisposalPeople:'',
          //处置时间
          fDisposalDate:'',
          //处置信息附件ID
          fDisposalInfoFileId:'',

          //检查意见
          fInspectionOpinions:'',
          //检查结果
          fInspectionResults:'',
          //检查人
          fInspectionPeople:'',
          //检查时间
          fInspectionDate:'',

          //流程实例ID
          fActId:'',
          //下一节点审核人
          fActPersion:'',
          //流程状态
          fActStatus:'',
          //流程节点
          fActNode:'',
          //创建人
          fCreateBy:'',
          //创建时间
          fCreateTime:'',
      },
      dialogVisible:false,
      dialogVisible2:false,
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
        fRiskName: '',
        fActStatus: ''
      },
      approvalStatus: [
        {value:0,label:'待提交'},
        {value:1,label:'待响应'},
        {value:2,label:'待排除'},
        {value:3,label:'待检查'},
        {value:4,label:'已检查'},
        {value:5,label:'待修改'},
        {value:6,label:'未通过'},

      ],
      //下一处理人 弹窗
      nextVisible:false,
      //处理人
      radio:'',
      //处理人 集合
      list:[],
    };
  },
  created() {
    this.getList()
    this.personnel()
  },
  methods: {
    addPlafalse(){
      this.dialogVisible = false
    },
    isToString(val){
      if(val.fRiskType){
        val.fRiskType = val.fRiskType.toString()
      }
      if(val.fInspectionResults){
        val.fInspectionResults = val.fInspectionResults.toString()
      }
    },
    handleUpdate(val){
      this.MRiskManagement = val
      this.isToString(this.MRiskManagement)
      this.dialogVisible = true
      console.log(val)
      if (val.fRiskInfoFileId) {
        getFileById({id:val.fRiskInfoFileId}).then(result =>{
          if (result) {
            this.fileList = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }
      if (val.fResponseInfoFileId) {
        getFileById({id:val.fResponseInfoFileId}).then(result =>{
          if (result) {
            this.fileList1 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }
      if (val.fDisposalInfoFileId) {
        getFileById({id:val.fDisposalInfoFileId}).then(result =>{
          if (result) {
            this.fileList2 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }

    },
    handleUpdate2(val){
      this.MRiskManagement = val
      this.dialogVisible2 = true
      this.isToString(this.MRiskManagement)
      console.log(val)
      if (val.fRiskInfoFileId) {
        getFileById({id:val.fRiskInfoFileId}).then(result =>{
          if (result) {
            this.fileList = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }
      if (val.fResponseInfoFileId) {
        getFileById({id:val.fResponseInfoFileId}).then(result =>{
          if (result) {
            this.fileList1 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }
      if (val.fDisposalInfoFileId) {
        getFileById({id:val.fDisposalInfoFileId}).then(result =>{
          if (result) {
            this.fileList2 = [{name:result.data.fOldFileName,url:result.data.fFilePath}];
            console.log("fileList.url:",this.fileList[0].url);
            console.log("fileList.name:",this.fileList[0].name);
          }
        })
      }

    },

    //处理人 确定按钮
    addSubmits() {
      //提交 保存
      if(this.MRiskManagement.fActStatus == 0) {
        this.MRiskManagement.fActStatus = 1
        this.MRiskManagement.fActPersion = this.radio
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
          }
        })
      }
      //提交 修改
      else if(this.MRiskManagement.fActStatus == 5) {
        this.MRiskManagement.fActStatus = 1
        this.MRiskManagement.fActPersion = this.radio
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("修改提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
          }
        })
      }
      //提交 响应
      else if(this.MRiskManagement.fActStatus == 1) {
        this.MRiskManagement.fActStatus = 2
        this.MRiskManagement.fActPersion = this.radio
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("响应提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
          }
        })
      }
      //提交 处置
      else if(this.MRiskManagement.fActStatus == 2) {
        this.MRiskManagement.fActStatus = 3
        this.MRiskManagement.fActPersion = this.radio
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("排除提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
          }
        })
      }
      //提交 处置
      else if(this.MRiskManagement.fActStatus == 3) {
        this.MRiskManagement.fActStatus = 4
        this.MRiskManagement.fActPersion = this.radio
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("检查提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
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

    //提交 保存的险情
    addPla() {
      // this.msgSuccess("检查提交成功")
      this.addSubmits();
    },
    addPla2() {
      //提交 检查 通过
      if(this.MRiskManagement.fInspectionResults == 1) {
        this.MRiskManagement.fActStatus = 4
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("检查提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.dialogVisible = false
            this.getList()
          }
        })
      }
      //提交 检查 通过
      else if(this.MRiskManagement.fInspectionResults == 2) {
        this.MRiskManagement.fActStatus = 6
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("检查提交成功")
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.dialogVisible = false
              this.getList()
          }
        })
      }
      //提交 检查 驳回
      else if(this.MRiskManagement.fInspectionResults == 3) {
        this.MRiskManagement.fActStatus = 5
        updateManagement(this.MRiskManagement).then(res => {
          if(res.code == 200) {
            this.msgSuccess("检查提交成功")
            this.MRiskManagement = this.MRiskManagementInit
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.nextVisible = false
            this.dialogVisible = false
            this.getList()
          }
        })
      }


    },
    //查询 列表数据
    getList() {
      listManagement(this.queryParams).then(res => {
        console.log('查询条件 this.queryParams', this.queryParams)
        if(res.code == 200) {
          this.data = res.rows
          this.total = res.total
          console.log('查询 列表数据',res)
        }
      })
    },

    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },

    /** 重置按钮操作 */
    resetQuery() {
      this.queryParams.pageNum = 1
      this.queryParams.pageSize = 10
      this.queryParams.fRiskName = ''
      this.queryParams.fActStatus = ''
      this.getList();
    },
    //弹窗初始化
    initZi() {
      this.getList()
      this.fileList = []
      this.fileList1 = []
      this.fileList2 = []
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
