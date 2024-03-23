<template>
  <div>
    <h1 class="title">{{list.fSystemName}}</h1>

    <div class="ql-container ql-snow" style="border: 0px;">
         <div class="ql-editor" v-html="list.fSystemContent"  style="width: 70%;margin: 0 auto;margin-top: 30px;"></div>
    </div>
    <div  v-if="fileList.length>0"  style="width: 70%;margin: 0 auto;margin-top: 30px;text-align: left;padding: 12px 15px;">
      <div>
        附件：
      </div>
      <el-upload style="width: 600px;"  class="upload-demo" :headers="GLOBAL.headers()" :action="GLOBAL.httpUrl" :on-preview="handlePreview"
          :show-file-list="true" disabled :file-list="fileList">
      </el-upload>
    </div>

  </div>

</template>

<script>
  import { getManagementInfoByCode } from "@/api/indemnification/manageSystem";
  import {
    getFileById
  } from "@/api/file";

export default {
  components: {},
  data() {
    return {
      activeName: '',
      list:'',
      response:'',
      fileList:[],

    };
  },
  methods: {
    getFile(val) {
      console.log('fileList = []');
      this.fileList = [];
      if (val) {
        getFileById({
          id: val
        }).then(result => {
          if (result) {
            this.fileList = [{
              name: result.data.fOldFileName,
              url: result.data.fFilePath
            }];
            console.log("fileList.url:", this.fileList);
          }
        })
      }
    },
      handlePreview(file) {
      window.open(this.fileList[0].url);
    },

    getManagementInfoByCode(){
      // var params = {
      //   code: 'O-CENTER'
      // }
      getManagementInfoByCode('O-CENTER').then(result => {
        if (result.data) {
          this.list = result.data
          if(this.list.fInstitutionId != ''){
            this.getFile(this.list.fInstitutionId)
          }
        }else{
              this.list=null
            }
      })
    }

  },
  created() {
    this.getManagementInfoByCode()
  },
}
</script>

<style scoped>

.layout {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.title {
  margin-top: 50px;
  font-size: 40px;
  display: flex;
  justify-content: center;
}

.mainBody {
  width: 98%;
  text-indent: 35px;
  font-size: 25px;
}

#img {
  width: 95%;
}
  .el-upload-list__item.is-success .el-upload-list__item-status-label {
      display: none !important;
  }
  .el-upload-list__item .el-icon-close-tip {
      display: none !important;
  }
</style>
