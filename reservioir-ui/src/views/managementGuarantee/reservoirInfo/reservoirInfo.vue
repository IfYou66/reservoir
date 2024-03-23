<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="水库名称" prop="fName">
        <el-input
          v-model="queryParams.fName"
          placeholder="请输入水库名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['reservoirInfo:reservoirInfo:add']"
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
          v-hasPermi="['reservoirInfo:reservoirInfo:edit']"
        >修改</el-button>
      </el-col>

      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reservoirInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="水库名称" align="center" prop="fName" />
      <el-table-column label="权限字符" align="center" prop="fReservoirKey" />
      <el-table-column label="超级管理员用户名" align="center" prop="fAdminUserName" />
      <el-table-column label="说明" align="center" prop="fRemark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['reservoirInfo:reservoirInfo:edit']"
          >修改</el-button>
          <!--<el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['reservoirInfo:reservoirInfo:remove']"
          >删除</el-button>-->
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

    <!-- 添加或修改水库信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="水库名称" prop="fName">
          <el-input v-model="form.fName" placeholder="请输入水库名称" />
        </el-form-item>
        <el-form-item label="权限字符" prop="fReservoirKey" v-if="this.form.id == null">
          <el-input v-model="form.fReservoirKey" placeholder="请输入权限字符" />
        </el-form-item>
        <el-form-item label="上传图片" prop="" :required="true">
          <el-upload
            class="avatar-uploader"
            :headers="GLOBAL.headers()"
            :action="GLOBAL.httpUrl"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-if="!imageUrl" class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="说明" prop="fRemark">
          <el-input v-model="form.fRemark" type="textarea" placeholder="请输入内容"  rows="8"/>
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

import { listReservoirInfo, getReservoirInfo, delReservoirInfo, addReservoirInfo, updateReservoirInfo } from "@/api/indemnification/reservoirInfo";

  import {
    getFileById
  } from "@/api/file";
export default {
  name: "reservoirInfo",
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
      // reservoirInfo表格数据
      reservoirInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        fName: null,
      },
      imageUrl:'',
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        fName: [
          { required: true, message: "水库名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getFile() {
      if (this.form.fTopLogoImg) {
        getFileById({
          id: this.form.fTopLogoImg
        }).then(result => {
          if (result) {
            this.imageUrl = result.data.fFilePath
            console.log("fileList.url:", result.data.fFilePath);
          }
        })
      }
    },
    // 检查记录列表图片
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      console.log('5665',this.imageUrl)
      this.form.fTopLogoImg = res.data.fId
      // this.checkForm.imageUrl = this.imageUrl
    },
    beforeAvatarUpload(file){
      const isLt100M = file.size / 1024 / 1024 < 100;
       if (!isLt100M) {
          this.$message.error('上传文件大小不能超过 100MB!');
          return false
        }
     },
    /** 查询水库信息列表 */
    getList() {
      this.loading = true;
      listReservoirInfo(this.queryParams).then(response => {
        this.reservoirInfoList = response.rows;
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
        id: null,
        fName: null,
        fRemark: null,
        createId: null,
        createTime: null,
        updatedId: null,
        updatedTime: null,
        fAdminUserId:null,
        fAdminUserName:null,
        fReservoirKey:null,
        fTopLogoImg:null
      };
      this.imageUrl = null;
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加水库信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getReservoirInfo(id).then(response => {
        this.form = response.data;
        this.getFile()
        this.open = true;
        this.title = "修改水库信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if(!this.form.fTopLogoImg){
            this.msgSuccess({
              offset: '300',
              message: "请上传图片",
              type: "error"
            });
            return false
          }
          if (this.form.id != null) {
            updateReservoirInfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReservoirInfo(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除水库信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delReservoirInfo(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('reservoirInfo/reservoirInfo/export', {
        ...this.queryParams
      }, `reservoirInfo_水库信息.xlsx`)
    }
  }
};
</script>
<style lang="scss">

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 118px;
  height: 118px;
  line-height: 118px;
  text-align: center;
}

.avatar {
  width: 118px;
  height: 118px;
  display: block;
}
  .el-image-viewer__wrapper {
    z-index: 99999999 !important;
  }

</style>
