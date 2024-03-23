<template>
  <div>

    <div class="front">
      <div class="system">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane v-for="(item,index) in response" :label="item.fTypeName" :name="item.fCode">
            <div >
              <div style="width: 100%;height: 100%;" v-if="list!=null">
                <img  src="../../../assets/background1.png" class="imgSrc"  />
                <div class="background-text" style="margin-top: -150px;" >
                  <div style="text-align: center;font-size: 26px;font-weight: 600;">
                    <!-- 档案管理制度 -->
                    {{list.fSystemName}}
                  </div>

                  <div class="ql-container ql-snow" style="border: 0px;">
										     <div class="ql-editor" v-html="list.fSystemContent"  style="width: 70%;margin: 0 auto;margin-top: 30px;"></div>
									</div>
                  <div  v-if="fileList.length>0"  style="width: 70%;margin: 0 auto;margin-top: 30px;text-align: left;padding: 12px 15px;">
                    <div>
                      附件：
                    </div>
                    <el-upload style="width:400px"  class="upload-demo" :headers="GLOBAL.headers()" :action="GLOBAL.httpUrl" :on-preview="handlePreview"
                        :show-file-list="true" disabled :file-list="fileList">
                    </el-upload>
                  </div>

                </div>
                <img  src="../../../assets/background2.png" class="imgSrc"  style="margin-top: -30px;" />
              </div>
            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>

</template>

<script>
  import {
    getManagementInfoByCode
  } from "@/api/indemnification/manageSystem";
  import {
    getFileById
  } from "@/api/file";
  import {
        listType
    } from "@/api/indemnification/type.js";

  export default {
    components: {},
    data() {
      return {
        activeName: '',
        list:null,
        height:0,
        response:'',
        fileList:[],

      };
    },
    mounted() {

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
    	/** 查询制度分类列表 */
      getTypeList() {
        let queryParams = {
        	fParentCode:'TWO-ONE-TABLE'
        };
        listType(queryParams).then(response => {
          if(response.rows.length>0){
            console.log(response.rows);
            this.response = response.rows
            this.activeName=this.response[0].fCode
            this.getManagementInfoByCode();
            }
      });
      },

      handleClick(tab, event) {
        console.log(tab.name);
          getManagementInfoByCode(tab.name).then(result => {
            if (result.data) {
              this.list = result.data
              if(this.list.fInstitutionId != ''){
                this.getFile(this.list.fInstitutionId)
              }
            }else{
              this.list=null
            }
          })
      },
      getManagementInfoByCode() {
        getManagementInfoByCode(this.response[0].fCode).then(result => {
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
    	this.getTypeList();
    },
  }
</script>

<style>
 .system .el-tabs__item {
   padding: 0 20px;
   height: 40px;
   -webkit-box-sizing: border-box;
   box-sizing: border-box;
   line-height: 40px;
   display: initial !important;
   list-style: none;
   width: 0px !important;
  padding-left: 20px !important;
   padding-right: 20px !important;
   text-align: center;
   font-size: 18px;
   font-weight: 500;
   color: #303133;
   position: relative;
 }
 .el-tabs__item.is-active {
     color: #1890ff !important;
 }
 .el-upload-list__item.is-success .el-upload-list__item-status-label {
     display: none !important;
 }
 .el-upload-list__item .el-icon-close-tip {
     display: none !important;
 }



  /*
.layout {
  display: flex;
  flex-wrap: wrap;
}


.el-card__header {
  background-color: yellowgreen;
}

.color409 {
  color: #409eff;
  cursor: pointer;
}

.title {
  width: 10%;
  text-align: center;
  margin-top: 15px;
}

/deep/ .el-tree-node__label {
  font-size: 18px;
}

.el-row {
  margin-bottom: 20px;

}

.el-col {
  border-radius: 4px;
}

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 480px;
} */


  .background {
    width: 100%;
    /* height: 125%; */
    /**宽高100%是为了图片铺满屏幕 */
    z-index: 1;
    position: absolute;
    padding-left: 200px;
    padding-right: 200px;
  }

  .background-text {
    width: 100%;
    background-color: #BBE1F8;
    /* height: 100%; */
    /**宽高100%是为了图片铺满屏幕 */
/*    z-index: 2;
    position: absolute; */

  }

  .imgSrc {
    height: 100%;
    width: 100%;
  }

  .front {
    width: 100%;
    height: 100%;
    /*  z-index: 1;
  position: absolute; */
    text-align: center;
  }
</style>
