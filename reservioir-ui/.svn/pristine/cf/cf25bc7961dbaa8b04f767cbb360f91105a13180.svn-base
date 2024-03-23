<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="名称" prop="roleName">
        <el-input
          v-model="queryParams.roleName"
          placeholder="请输入计划名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="状态"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="(item,index) in approvalStatus"
            :key="index"
            :label="item"
            :value="index"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-table v-loading="loading" :data="data">
      <el-table-column width="55" align="center"/>
      <el-table-column label="序号" align="center" prop="id" width="120"/>
      <el-table-column label="项目计划名称" align="center" prop="planName" :show-overflow-tooltip="true" width="260">
        <template slot-scope="scope">
            <span
              @click="handleQuery"
              class="color409"
            >{{ scope.row.planName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计划时间" align="center" prop="planningTime" :show-overflow-tooltip="true" width="150"/>
      <el-table-column label="项目概括" align="center" prop="progressStatus" width="380"/>

      <el-table-column label="状态" align="center" prop="status" width="180">

      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <div v-if="scope.row.status == '待审核'">
            <el-button
              size="mini"
              type="text"
              @click="handleUpdate(scope.row)"
            >审批
            </el-button>
          </div>

          <div v-if="scope.row.status == '待勘察设计'">
            <el-button
              size="mini"
              type="text"
              @click="handleUpdate(scope.row)"
            >勘察设计
            </el-button>
          </div>

          <div v-if="scope.row.status == '待招投标'">
            <el-button
              size="mini"
              type="text"
              @click="handleUpdate(scope.row)"
            >招投标
            </el-button>
          </div>
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


  </div>
</template>

<script>
import {listRole} from "@/api/system/role";
import ScrollPane from "../../../layout/components/TagsView/ScrollPane";

export default {
  components: {ScrollPane},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据
      data: [{
        id: '1',
        planName: '2021年度项目计划一',
        planningTime: '2021-07-05 16:00:00',
        progressStatus: '项目基本说明',
        status: '待审核'
      },
        {
          id: '2',
          planName: '2021年度项目计划二',
          planningTime: '2021-07-05 16:00:00',
          progressStatus: '项目基本说明',
          status: '待勘察设计'
        },
        {
          id: '3',
          planName: '2021年度项目计划三',
          planningTime: '2021-07-05 16:00:00',
          progressStatus: '项目基本说明',
          status: '待招投标'
        }],

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        planName: undefined,
        status: undefined
      },

      approvalStatus: ['计划编制', '计划审批', '勘察设计', '招投标', '项目实施', '评级验收']

    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询角色列表 */
    getList() {
      this.loading = true;
      listRole(this.addDateRange(this.queryParams, this.dateRange)).then(
        response => {
          this.roleList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },

    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
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
