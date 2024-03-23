<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch">
            <el-form-item label="名称" prop="fTypeName">
                <el-input v-model="queryParams.fTypeName" placeholder="请输入名称" clearable size="small"
                    @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
                <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd"  v-hasPermi="['classifyManage:type:add']">添加</el-button>
            </el-form-item>
        </el-form>
        <!--        <el-table
          v-loading="loading"
          :data="typeList"
          row-key="fId"
          :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
          style="width: 100%;margin-bottom: 20px;"
          border
        > -->
        <el-table v-loading="loading" :data="typeList" row-key="fId" :default-expand-all="false" :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
            style="width: 100%;margin-bottom: 20px;" border>
            <el-table-column label="名称" align="center" prop="fTypeName" />
            <el-table-column label="编号" align="center" prop="fCode" />
            <el-table-column label="描述" align="center" prop="fRemark" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['classifyManage:type:edit']" v-if="scope.row.fOperationStatus  !=1 ">修改</el-button>
                    <el-button size="mini" type="text" icon="el-icon-plus" @click="handleAdd(scope.row)" v-hasPermi="['classifyManage:type:add']">新增</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['classifyManage:type:remove']" v-if="scope.row.fOperationStatus !=1 ">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" label-width="120px">
                <el-form-item label="父级制度" prop="fParentId">
                    <treeselect style="width: 300px" v-model="form.fParentId" :options="typeListTree" :normalizer="normalizer"
                        placeholder="选择父级制度" />
                </el-form-item>
                <el-form-item label="制度名称">
                    <el-input v-model="form.fTypeName" style="width: 300px"></el-input>
                </el-form-item>
                <el-form-item label="制度编号">
                    <el-input v-model="form.fCode" style="width: 300px"></el-input>
                </el-form-item>
                <el-form-item label="制度描述">
                    <el-input type="textarea"  maxlength="500" show-word-limit  :rows="5" v-model="form.fRemark" style="width: 300px"></el-input>
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
    import {
        listType,
        getType,
        delType,
        addType,
        updateType,
        exportType,
        treeselect
    } from "@/api/indemnification/type.js";
    import Treeselect from "@riophae/vue-treeselect";
    import "@riophae/vue-treeselect/dist/vue-treeselect.css";

    export default {
        name: "Type",
        components: {
            Treeselect
        },
        data() {
            return {
                // 遮罩层
                loading: true,
                // 显示搜索条件
                showSearch: true,
                // 制度分类表格数据
                typeList: [],
                typeList2: [],
                typeListTree: [],
                // 弹出层标题
                title: "",
                // 是否显示弹出层
                open: false,
                // 查询参数
                queryParams: {
                    fTypeName: null,
                    fParentId: null,
                    fCode: null,
                    fRemark: null,
                    fStatus: null,
                    fCreateTime: null
                },
                // 表单参数
                form: {},
                // 表单校验
                rules: {}
            };
        },
        created() {
            this.getList();
        },
        methods: {
            /** 查询制度分类列表 */
            getList() {
                this.loading = true;
                listType(this.queryParams).then(response => {
                    this.typeList = this.handleTree(response.rows, "fId", "fParentId");
                    this.typeList2 = response.rows;
                    this.loading = false;
                });
            },
            /** 转换制度分类数据结构 */
            normalizer(node) {
                if (node.children && !node.children.length) {
                    delete node.children;
                }
                return {
                    id: node.fId,
                    label: node.fTypeName,
                    children: node.children
                };
            },
            /** 查询制度分类下拉树结构 */
            getTreeselect() {
                listType().then(response => {
                    this.typeListTree = this.handleTree(response.rows, "fId", "fParentId");
                    const data = {
                        fId: 0,
                        fTypeName: '顶级节点',
                        children: []
                    };
                    data.children = response.data;
                    this.typeListTree.push(data);
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
                    fTypeName: null,
                    fParentId: null,
                    fCode: null,
                    fRemark: null,
                    fStatus: 0,
                    fCreateTime: null
                };
                this.resetForm("form");
            },
            /** 搜索按钮操作 */
            handleQuery() {
                this.getList();
            },
            /** 重置按钮操作 */
            resetQuery() {
                this.resetForm("queryForm");
                this.handleQuery();
            },
            /** 新增按钮操作 */
            handleAdd(row) {
                this.reset();
                this.getTreeselect();
                if (row != null && row.fId) {
                    this.form.fParentId = row.fId;
                } else {
                    this.form.fParentId = 0;
                }
                this.open = true;
                this.title = "添加";
            },
            /** 修改按钮操作 */
            handleUpdate(row) {
                this.reset();
                this.getTreeselect();
                if (row != null) {
                    this.form.fParentId = row.fId;
                }
                getType(row.fId).then(response => {
                    this.form = response.data;
                    this.open = true;
                    this.title = "修改";
                });
            },
            /** 提交按钮 */
            submitForm() {
                this.$refs["form"].validate(valid => {
                    if (valid) {
                        if (this.form.fId != null) {
                            updateType(this.form).then(response => {
                                this.msgSuccess("修改成功");
                                this.open = false;
                                this.getList();
                            });
                        } else {
                            addType(this.form).then(response => {
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
                this.$confirm('是否确认删除名称为"' + row.fTypeName + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return delType(row.fId);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("删除成功");
                }).catch(() => {});
            }
        }
    };
</script>
