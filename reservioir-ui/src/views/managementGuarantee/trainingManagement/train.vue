<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="名称" prop="roleName">
        <el-input
          v-model="queryParams.fPlanName"
          placeholder="请输入计划名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.fActStatus"
          placeholder="状态"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="(item,index) in dict.trainingStatus"
            :key="item.dictValue"
            :label="item.dictLabel"
            :value="item.dictValue"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="getList">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-table v-loading="loading" :data="tableData" border>
<!--      <el-table-column label="序号" align="center" prop="id" width="120"/>-->
      <el-table-column label="计划名称" align="center" prop="fPlanName" :show-overflow-tooltip="true" width="260"/>
      <el-table-column label="培训时间" align="center" prop="fTraTime" :show-overflow-tooltip="true" width="150"/>
      <el-table-column label="评价方式" align="center" prop="fEvaWay" width="380">
        <template slot-scope="scope">
           <span v-for="(item,index) in dict.assessMode" v-if="item.dictValue == scope.row.fEvaWay">
                  {{item.dictLabel}}
                </span>
        </template>
      </el-table-column>
      <el-table-column label="费用" align="center" prop="fBudget">
        <template slot-scope="scope">
            <span
              @click="handleQuery"
            >{{ scope.row.fBudget }}元</span>
        </template>
      </el-table-column>

      <el-table-column label="状态" align="center" prop="fActNode" width="180">
        <template slot-scope="scope">
          <span v-for="(item,index) in dict.trainingStatus" v-if="scope.row.fActStatus == item.dictValue">{{ item.dictLabel }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <span v-if="row.fActStatus == '1'">
            <el-button
              size="mini"
              type="text"
              @click="check(row)"
            >提交
            </el-button>
          </span>

          <span v-if="row.fActStatus == '2'">
            <el-button
              size="mini"
              type="text"
              @click="check(row)"

            >审核
            </el-button>
          </span>

          <span v-if="row.fActStatus == '3'">
            <el-button
              size="mini"
              type="text"
              @click="check(row)"
            >审批
            </el-button>
          </span>

          <span v-if="row.fActStatus == '4'">
            <el-button
              size="mini"
              type="text"
              @click="check(row)"
            >实施
            </el-button>
          </span>
          <span v-if="row.fActStatus == '5'">
            <el-button
              size="mini"
              type="text"
              @click="scoring(row)"
            >打分
            </el-button>
          </span>
          <span v-if="row.fActStatus == '6'">
            <el-button
              size="mini"
              type="text"
              @click="scoring(row)"
              style="margin-left: 5px"
            >详情
            </el-button>
          </span>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
    />

    <el-dialog
      title="培训审核"
      :visible.sync="dialogVisible"
      width="1500px">
      <Organization ref="plait" @shut="closeReview" @search="getList"></Organization>
    </el-dialog>

  </div>
</template>

<script>

import Organization from '../trainingManagement/organization.vue'

import {
  listTraining,
  queryDataDictionary,
  dataQuery
} from "@/api/indemnification/training";

import {
  listJoinTraining
} from "@/api/indemnification/joinTraining";

import {getFileById} from "@/api/file";

export default {
  components: {
    Organization
  },
  data() {
    return {

      dict:{
        trainingStatus: [],
        assessMode:[]
      },

      tableData:[],

      dialogVisible: false,
      // 遮罩层
      loading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fPlanName: undefined,
        fActStatus: undefined,
        fPlanType: undefined
      },
      fileList:[],

      formData: {

        /** id */
        fId: null,

        /** 计划名称 */
        fPlanName: null,

        /** 评价方式 */
        fEvaWay: null,

        /** 预算 */
        fBudget: null,

        /** 培训开始时间 */
        fStartTime: null,

        /** 培训结束时间 */
        fEndTime: null,

        /** 培训概述 */
        fTraContent: null,

        /** 附件id */
        fTraId: null,

        /** 编制人 */
        fPreparedBy: null,

        /** 编制时间 */
        fPreparationTime: null,

        /** 培训人 */
        fTraPersion: null,

        /** 培训时间 */
        fTraTime: null,

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

        /** 实施内容 */
        fImpContent: null,

        /** 实施总结附件id */
        fImpId: '',

        /** 实施人 */
        fImpPersion: null,

        /** 实施时间 */
        fImpTime: null,

        /** 培训照片id */
        fPhoto: null,

        /** 状态 0:无效1：有效 */
        fStatus: null,

        /** 流程实例id */
        fActId: null,

        /** 流程下一环节审核人 */
        fActPersion: null,

        /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
        fActStatus: null,

        /** 流程节点 */
        fActNode: null,

        /** 培训人员集合 */
        joinTrainingList:[],

      },

      file:{},

      files:{},

    };
  },

  mounted(){
    this.getList()
    this.queryDataDictionary()
    this.dataQuery()
  },

  methods: {

    getList() {
      this.loading = true;
      listTraining(this.queryParams).then(response => {
        this.tableData = response.rows;
        this.total = response.total;
        this.loading = false
      });
    },

    queryDataDictionary() {
      queryDataDictionary().then(res => {
        this.dict.assessMode = res.data.assessMode
        // this.dict.result = res.data.result
        // this.dict.gender = res.data.gender
        // this.dict.politicalStatus = res.data.politicalStatus
        // this.dict.education = res.data.education
      });
    },

    check(row) {

      this.dialogVisible = true
      this.formData = row
      var data = {
        fTrainingId: row.fId
      }
      listJoinTraining(data).then(res => {
        if (res.code == 200) {
          this.formData.joinTrainingList = res.rows
        }
      });

      if (row.fTraId) {
        getFileById({id: row.fTraId}).then(result => {
          if (result) {
           // this.file = result.data
            // 调用子组件的方法
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              console.log("fileList.url:", this.fileList[0].url);
            }
            this.$nextTick(() => {
              this.$refs.plait.init(this.formData,this.fileList)
            });
          }
        })
      };
    },

    scoring(row) {
      this.dialogVisible = true
      this.formData = row
      var data = {
        fTrainingId: row.fId
      }
      listJoinTraining(data).then(res => {
        if (res.code == 200) {
          this.formData.joinTrainingList = res.rows
        }
      });
      if (row.fTraId) {
        getFileById({id: row.fTraId}).then(result => {
          if (result) {
            this.file = result.data
          }
        })
      };
      if (row.fImpId) {
        getFileById({id: row.fImpId}).then(result => {
          if (result) {
            this.files = result.data
          }
        })
      };
      // 调用子组件的方法
      this.$nextTick(() => {
        this.$refs.plait.init(this.formData,this.file,this.files)
      });
    },

    closeReview(data) {
      this.dialogVisible = data
    },

    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {
        });
    },

    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      // this.dateRange = [];
      this.queryParams.fPlanName=null
      this.queryParams.fActStatus=null
      this.handleQuery();
    },

    dataQuery() {
      var query = { dictType: 'trainingStatus'};
      dataQuery(query).then(res => {
        if (res.code == 200) {
          this.dict.trainingStatus = res.data
        }
      });
    }

  }
};
</script>
<style lang="scss">
.color409 {
  color: #409eff;
  cursor: pointer;
}
</style>
