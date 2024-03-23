<template>
  <div class="app-container">

    <div class="from-div" style="width: 100%">

      <el-row class="from-border-bottom">
        <el-col :span="4" class="from-col-left">
          制度名称
        </el-col>
        <el-col :span="20" class="from-border-right">
          <el-input v-model="manageSystem.fSystemName" clearable placeholder="请输入内容"></el-input>
        </el-col>
      </el-row>


      <el-row class="from-border-bottom">
        <el-col :span="4" class="from-col-left">
          制度分类
        </el-col>
        <el-col :span="20" class="from-border-right">
          <treeselect style="100%" v-model="manageSystem.fTypeId" :options="typeListTree" :normalizer="normalizer"
            placeholder="选择制度分类" />

          <!-- <el-select
            style="width: 100%"
            v-model="manageSystem.score"
            placeholder="制度分类"
            clearable
            size="small"
          >
            <el-option
              v-for="(item,index) in score"
              :key="index"
              :label="item"
              :value="index"
            />
          </el-select> -->
        </el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="4" class="from-col">
          制度说明
        </el-col>
        <el-col :span="20" style="height: 50px;">
          <el-input type="textarea" maxlength="500" :rows="4" placeholder="请输入制度说明" v-model="manageSystem.fRemark">
          </el-input>
        </el-col>
      </el-row>


      <el-row class="from-border-bottom">
        <el-col :span="4" class="from-borderibht">
          制度内容
        </el-col>
        <el-col :span="20" style="height: 400px;">
          <editor v-model="manageSystem.fSystemContent" :min-height="332" style="height: 80%;"/>
        </el-col>
      </el-row>


      <el-row class="from-border-bottom">
        <el-col :span="4" class="from-col">
          制度附件
        </el-col>
        <el-col :span="20" style="height: 50px;">
          <div style="width: 200px;margin-top: 20px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
              :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove" 
              multiple :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1"
              :on-exceed="handleExceed" :file-list="fileList">
              <el-button v-if="judge == 0" size="small" type="primary">点击上传</el-button>
              <div v-if="judge == 0" slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
        </el-col>
      </el-row>

    </div>

  </div>
</template>

<script>
  import Dict from "../../system/dict";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  import Editor from '@/components/Editor';
  import {
    listType
  } from "@/api/indemnification/type.js";
  import Treeselect from "@riophae/vue-treeselect";
  import "@riophae/vue-treeselect/dist/vue-treeselect.css";


  export default {
    components: {
      Dict,
      Editor,
      Treeselect
    },
    props: ['judge', 'manageSystem'],
    data() {
      return {
        typeListTree: [],
        score: ['制度管理'],
        textarea: '',
        fileList: []
      };
    },
    watch: {
      manageSystem: function() {
        this.getFile();
      }
    },
    created() {
      this.getTreeselect();
      this.getFile();
    },

    mounted() {},

    methods: {
      getFile() {
        console.log('fileList = []');
        this.fileList = [];
        if (this.manageSystem.fInstitutionId) {
          getFileById({
            id: this.manageSystem.fInstitutionId
          }).then(result => {
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              console.log("fileList.url:", this.fileList[0].url);
            }
          })
        }
      },
      /** 查询制度分类下拉树结构 */
      getTreeselect() {
        listType().then(response => {
          const TreeList = {
            fTypeId: 0,
            fTypeName: '顶级制度分类节点',
            children: []
          };
          TreeList.children = this.handleTree(response.rows, "fId", "fParentId");
          this.typeListTree.push(TreeList);
          console.log(typeListTree);
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

      uploadedSuccess(response, file, fileList) {
        this.manageSystem.fInstitutionId = response.data.fId
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.manageSystem.fInstitutionId);
        this.manageSystem.fInstitutionId = '';
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
      }
    }
  };
</script>
<style lang="scss">
  .color409 {
    color: #409eff;
    cursor: pointer;
  }

  .from-col-about {
    text-align: center;
    line-height: 160px;
    border-right: #a4d5ff 1px solid;
    border-left: #a4d5ff 1px solid;
  }

  .from-col-form {
    text-align: center;
    line-height: 250px;
    border-right: #a4d5ff 1px solid;
  }
</style>
