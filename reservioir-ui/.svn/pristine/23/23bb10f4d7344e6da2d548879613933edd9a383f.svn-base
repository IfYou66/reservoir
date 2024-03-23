<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="年度调度名称" prop="fDispatchName">
        <el-input
          v-model="queryParams.fDispatchName"
          placeholder="请输入年度调度名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年度调度类型" prop="fDispatchType">
        <el-select v-model="queryParams.fDispatchType" placeholder="请选择年度调度类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['run:scheduling:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['run:scheduling:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['run:scheduling:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['run:scheduling:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schedulingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="fId" />
      <el-table-column label="年度调度名称" align="center" prop="fDispatchName" />
      <el-table-column label="年度调度类型" align="center" prop="fDispatchType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['run:scheduling:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['run:scheduling:remove']"
          >删除</el-button>
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

    <!-- 添加或修改年度调度总结 对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="年度调度名称" prop="fDispatchName">
          <el-input v-model="form.fDispatchName" placeholder="请输入年度调度名称" />
        </el-form-item>
        <el-form-item label="年度调度类型" prop="fDispatchType">
          <el-select v-model="form.fDispatchType" placeholder="请选择年度调度类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="预算（元）" prop="fBudget">
          <el-input v-model="form.fBudget" placeholder="请输入预算" />
        </el-form-item>
        <el-form-item label="年度调度概述">
          <editor v-model="form.fDispatchContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="年度调度附件" prop="fDispatchId">
          <el-input v-model="form.fDispatchId" placeholder="请输入年度调度附件" />
        </el-form-item>
        <el-form-item label="编制人" prop="fEditPersion">
          <el-input v-model="form.fEditPersion" placeholder="请输入编制人" />
        </el-form-item>
        <el-form-item label="编制时间" prop="fEditTime">
          <el-date-picker clearable size="small"
            v-model="form.fEditTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择编制时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核意见">
          <editor v-model="form.fAuditContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="审核结果 0:不同意1：同意" prop="fAuditResult">
          <el-input v-model="form.fAuditResult" placeholder="请输入审核结果 0:不同意1：同意" />
        </el-form-item>
        <el-form-item label="审核人" prop="fAuditPersion">
          <el-input v-model="form.fAuditPersion" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核时间" prop="fAuditTime">
          <el-date-picker clearable size="small"
            v-model="form.fAuditTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批意见">
          <editor v-model="form.fApproveContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="审批结果" prop="fApproveResult">
          <el-input v-model="form.fApproveResult" placeholder="请输入审批结果" />
        </el-form-item>
        <el-form-item label="审批人" prop="fApprovePersion">
          <el-input v-model="form.fApprovePersion" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="审批时间" prop="fApproveTime">
          <el-date-picker clearable size="small"
            v-model="form.fApproveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择审批时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态 0:失效1：有效">
          <el-radio-group v-model="form.fStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="流程发起人" prop="fStartPersion">
          <el-input v-model="form.fStartPersion" placeholder="请输入流程发起人" />
        </el-form-item>
        <el-form-item label="创建时间" prop="fCreateTime">
          <el-date-picker clearable size="small"
            v-model="form.fCreateTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="流程实例id" prop="fActId">
          <el-input v-model="form.fActId" placeholder="请输入流程实例id" />
        </el-form-item>
        <el-form-item label="流程下一节点审核人" prop="fActPersion">
          <el-input v-model="form.fActPersion" placeholder="请输入流程下一节点审核人" />
        </el-form-item>
        <el-form-item label="流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回">
          <el-radio-group v-model="form.fActStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="流程节点" prop="fActNode">
          <el-input v-model="form.fActNode" placeholder="请输入流程节点" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listScheduling, getScheduling, delScheduling, addScheduling, updateScheduling } from "@/api/run/scheduling";

export default {
  name: "Scheduling",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 年度调度总结 表格数据
      schedulingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fDispatchName: null,
        fDispatchType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询年度调度总结 列表 */
    getList() {
      this.loading = true;
      listScheduling(this.queryParams).then(response => {
        this.schedulingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        fId: null,
        fDispatchName: null,
        fDispatchType: null,
        fBudget: null,
        fDispatchContent: null,
        fDispatchId: null,
        fEditPersion: null,
        fEditTime: null,
        fAuditContent: null,
        fAuditResult: null,
        fAuditPersion: null,
        fAuditTime: null,
        fApproveContent: null,
        fApproveResult: null,
        fApprovePersion: null,
        fApproveTime: null,
        fStatus: 0,
        fStartPersion: null,
        fCreateTime: null,
        fActId: null,
        fActPersion: null,
        fActStatus: 0,
        fActNode: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.fId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加年度调度总结 ";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const fId = row.fId || this.ids
      getScheduling(fId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改年度调度总结 ";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.fId != null) {
            updateScheduling(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScheduling(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const fIds = row.fId || this.ids;
      this.$confirm('是否确认删除年度调度总结 编号为"' + fIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delScheduling(fIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('run/scheduling/export', {
        ...this.queryParams
      }, `run_scheduling.xlsx`)
    }
  }
};
</script>