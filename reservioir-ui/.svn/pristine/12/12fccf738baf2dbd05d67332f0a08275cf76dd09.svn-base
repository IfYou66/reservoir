<template>
  <div class="app-container">
    <el-row :gutter="20">

      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="typeName"
            placeholder="请输入制度分类名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="typeList"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            :default-expand-all="false"
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>

      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true">
          <el-form-item label="名称" prop="fSystemName">
            <el-input
              v-model="queryParams.fSystemName"
              placeholder="请输入制度名称"
              clearable
              size="small"
              style="width: 240px"
            />
          </el-form-item>

          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="reset">重置</el-button>
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="add">新增</el-button>
          </el-form-item>
        </el-form>


        <el-table :data="manageSystemList" border>
          <el-table-column label="序号" align="center" type="index" width="150"/>
          <el-table-column label="制度名称" align="center" prop="fSystemName">
            <template slot-scope="scope">
            <span
              @click="seeDetails(scope.row)"
              class="color409"
            >{{ scope.row.fSystemName }}</span>
            </template>
          </el-table-column>
          <!-- <el-table-column label="分类" align="center" prop="fTypeId"/> -->
          <el-table-column label="分类" align="center" prop="fTypeId">
            <template slot-scope="scope">
           <span v-for="(item,index) in typeList2" :key="index" v-if="item.fId == scope.row.fTypeId">
             {{ item.fTypeName }}
           </span>
            </template>
          </el-table-column>
          <el-table-column label="说明" align="center" prop="fRemark" :show-overflow-tooltip="true"/>
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
            <el-button size="mini" type="text" @click="edit(scope.row)">编辑</el-button>
            <el-button size="mini" type="text" @click="handleDelete(scope.row)">删除</el-button>
            <el-button size="mini" type="text" @click="seeDetails(scope.row)">详情</el-button>
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
      </el-col>
    </el-row>

    <el-dialog
      :title="this.title"
      :visible.sync="dialogVisible"
      width="1500px"
    >
      <AddAndModify ref="AddAndModifyData" :judge="this.judge" v-bind:manageSystem="manageSystem"></AddAndModify>
      <span slot="footer" class="dialog-footer" v-if="judge == 0">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submitForm">确 定</el-button>
  </span>
    </el-dialog>


  </div>
</template>

<script>
import { treeselect, listType } from "@/api/indemnification/type.js";
import AddAndModify from '../institution/addAndModify.vue'

import { listManageSystem, getManageSystem, delManageSystem, addManageSystem, updateManageSystem } from "@/api/indemnification/manageSystem";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {

  components: {Treeselect, AddAndModify},
  data() {
    return {
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      // 总条数
      total: 0,
      // 制度分类表格数据
      typeList: [],
      typeList2: [],
      typeName: '',

      judge: '',

      title: '',

      dialogVisible: true,

      // 遮罩层
      loading: true,
      manageSystemList: [],
      manageSystem: {
        fSystemName: null,
        fTypeId: null,
        fSystemContent: null,
        fRemark: null,
        fInstitutionId: null,
        fStatus: null,
        fCreateTime: null,
        fUpdateTime: null
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fSystemName: null,
        fTypeId: null,
        fSystemContent: null,
        fRemark: null,
        fInstitutionId: null,
        fStatus: null,
        fCreateTime: null,
        fUpdateTime: null
      },
    };
  },
  watch: {
    // 根据名称筛选部门树
    typeName(val) {
      this.$refs.tree.filter(val);
    }
  },

  created() {
      this.getTypeList();
      this.getList();
  },

  methods: {
    getTypeList() {
        this.loading = true;
        treeselect(this.queryParams).then(response => {
            this.typeList = response.data;
        });
    },

    seeDetails(row) {
      this.manageSystem = this.deepClone(row);
      this.title = '制度管理详情';
      this.dialogVisible = true;
      this.judge = 1;
    },

    add() {
      this.manageSystem = {};
      this.title = '新增制度管理';
      this.dialogVisible = true;
      this.judge = 0;
    },

    edit(row) {
      this.manageSystem = this.deepClone(row);
      this.title = '编辑制度管理';
      this.dialogVisible = true;
      this.judge = 0;
    },

    /** 查询制度管理 列表 */
    getList() {
      this.loading = true;
      listManageSystem(this.queryParams).then(response => {
        this.manageSystemList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      listType().then(response => {
        this.typeList2 = response.rows;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.fTypeId = data.id;
      this.getList();
    },
    // 表单重置
    reset() {
      this.queryParams = {
        pageNum: 1,
        pageSize: 10,
        fTypeId: undefined,
        fSystemName: undefined
      };
      this.getList();
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.userId);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    /** 提交按钮 */
    submitForm() {
      if(this.title == '新增制度管理'){
          addManageSystem(this.manageSystem).then(response => {
            this.msgSuccess("新增成功");
            this.dialogVisible = false;
            this.getList();
          });
      }else if(this.title == '编辑制度管理'){
        updateManageSystem(this.manageSystem).then(response => {
          this.msgSuccess("修改成功");
          this.dialogVisible = false;
          this.getList();
        });
      }
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const fIds = row.fId || this.ids;
      this.$confirm('是否确认删除名称为"' + row.fSystemName + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delManageSystem(fIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },  judgeType(obj) {
  // tostring会返回对应不同的标签的构造函数
    const toString = Object.prototype.toString;
    const map = {
      '[object Boolean]': 'boolean',
      '[object Number]': 'number',
      '[object String]': 'string',
      '[object Function]': 'function',
      '[object Array]': 'array',
      '[object Date]': 'date',
      '[object RegExp]': 'regExp',
      '[object Undefined]': 'undefined',
      '[object Null]': 'null',
      '[object Object]': 'object',
    };
    if (obj instanceof Element) {
      return 'element';
    }
    return map[toString.call(obj)];
  },
  deepClone(data) {
    const type = this.judgeType(data);
    let obj;
    if (type === 'array'){
      obj = [];
    } else if (type === 'object') {
      obj = {};
    } else {
  // 不再具有下一层次
      return data;
    }
    if (type === 'array'){
      for (let i = 0, len = data.length; i < len; i++) {
        obj.push(this.deepClone(data[i]));
      }
    } else if (type === 'object') {
      // 对原型上的方法也拷贝了....
      for (const key in data) {
        obj[key] = this.deepClone(data[key]);
      }
    }
    return obj;
  },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/user/export', {
        ...this.queryParams
      }, `user_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/user/importTemplate', {
        ...this.queryParams
      }, `user_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", {dangerouslyUseHTMLString: true});
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
