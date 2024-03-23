<template>
  <div class="app-container" >
       <el-row class="from-top">
      <!-- 顶部 箭头 -->
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img style="width: 100%;height: 45px;"
            :src="require(rProReport.fStatus != 8? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')"/>
            <div  style="position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;">1.项目编制</div>
          </div>

          <div  style="position: relative;">
            <img  style="width: 100%;height: 45px;"
            :src="require( (rProReport.fStatus >= 1 && rProReport.fStatus <= 6)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 1 && rProReport.fStatus <= 6)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">2.项目审批</div>
          </div>

          <div   style="position: relative;">
            <img  style="width: 100%;height: 45px;" :src="require((rProReport.fStatus >= 2 && rProReport.fStatus <= 6)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 2 && rProReport.fStatus <= 6)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">3.勘察设计</div>
          </div>

          <div   style="position: relative;">
            <img  style="width: 100%;height: 45px;" :src="require((rProReport.fStatus >= 3 && rProReport.fStatus <= 6)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 3 && rProReport.fStatus <= 6)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">4.招投标</div>
          </div>

          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require((rProReport.fStatus >= 4 && rProReport.fStatus <= 6)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 4 && rProReport.fStatus <= 6)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">5.项目实施</div>
          </div>

          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require((rProReport.fStatus >= 5 && rProReport.fStatus <= 6)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 5 && rProReport.fStatus <= 6)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">6.项目验收</div>
          </div>
          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require((rProReport.fStatus >= 6 && rProReport.fStatus <= 7)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rProReport.fStatus >= 6 && rProReport.fStatus <= 7)? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">7.完成</div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 表主体 -->
    <div  class="from-div" style="width: 100%;">

      <!-- 顶部 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div>
          <el-button type="primary" @click="addPla" v-if="rProReport.fStatus == 0 ">提 交</el-button>

          <el-button type="primary" @click="modify" v-if="rProReport.fStatus == 7 ">修 改</el-button>

          <el-button type="primary" @click="approve" v-if="rProReport.fStatus == 1 ">提交审批</el-button>

          <el-button type="primary" @click="survey" v-if="rProReport.fStatus == 2 ">提交勘察</el-button>

          <el-button type="primary" @click="bidding" v-if="rProReport.fStatus == 3 ">提交招标</el-button>

          <el-button type="primary" @click="implement" v-if="rProReport.fStatus == 4 ">提交实施</el-button>

          <el-button type="primary" @click="acceptance" v-if="rProReport.fStatus == 5 ">提交验收</el-button>

          <el-button type="primary" @click="close" v-if="rProReport.fStatus == 8 || rProReport.fStatus == 6">确 定</el-button>
        </div>
        </el-col>
      </el-row>

      <!-- 顶部 表名 -->
      <el-row>
        <el-col :span="24" class="from-div-title">维修养护项目申报</el-col>
      </el-row>

      <!-- 第一行 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3" class="from-col-left" >
          项目名称
        </el-col>
        <el-col :span="10" class="from-border-right" >
          <el-input :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true" v-model="rProReport.fPerName" placeholder="请输入内容"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left" >
          预算（元）
        </el-col>
        <el-col :span="8" class="from-border-right" >
          <el-input :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true" v-model="rProReport.fBudget" placeholder="预算"></el-input>
        </el-col>
      </el-row>

      <!-- 第二行 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" >
          项目概况
        </el-col>
        <el-col :span="21" style="height: 400px;">
           <div style="font-size: 16px;font-weight: 700;padding: 10px;">
             项目概况:
           </div>
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="8"  :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true"  placeholder="请输入内容" v-model="rProReport.fProContent">
          </el-input>
          <div style="display:flex;justify-content:space-between;margin-top: 100px;">
           <div  style="width: 200px;margin-left: 20px;margin-top: -30px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="upload.headers"
                :action="upload.url"
                :on-preview="handlePreview"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileList">
              <el-button size="small" type="primary" :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true">点击上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
          <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
            <div style="text-align: left">
             <div style="display:inline;">编制人：<el-input :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true" v-model="rProReport.fPreparedBy"  placeholder="请输入内容" style="width:220px;border: 1px solid #DCDFE6;"></el-input></div>
              <div class="block" style="transform:translateY(10%);">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date" style="border: 1px solid #DCDFE6;"
                  v-model="rProReport.fPreparationTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 0 || rProReport.fStatus == 7)?false:true">
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>

        </el-col>
      </el-row>




      <!-- 第三行 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          项目审批
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审批意见：
          </div>
          <el-input :disabled="(rProReport.fStatus == 1 )?false:true" type="textarea"  maxlength="500" show-word-limit  :rows="3" v-model="rProReport.fAuditComments"   placeholder="请输入内容">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审批结果：
              </div>
              <el-select
              :disabled="(rProReport.fStatus == 1 )?false:true"
              v-model="rProReport.fAuditResult"
              clearable placeholder="请选择">
                <el-option v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审批人：
                <el-input v-model="rProReport.fAuditPeople"
                :disabled="(rProReport.fStatus == 1 )?false:true"
                placeholder="请输入内容"
                style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rProReport.fAuditDate"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 1 )?false:true"  >
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3"  style=" text-align: center;line-height: 280px;border-right: #a4d5ff 1px solid;">
          勘察设计
        </el-col>
        <el-col :span="21" style="height: 80px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            设计说明：
          </div>
          <el-input
          :disabled="(rProReport.fStatus == 2 )?false:true"
          type="textarea" :rows="5" v-model="rProReport.fDesignContent"  maxlength="500" show-word-limit    placeholder="请输入内容">
          </el-input>
          <div class="from-select">
           <div  style="width: 200px;margin-left: 20px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="GLOBAL.headers()"
                :action="GLOBAL.httpUrl"
                :on-preview="handlePreviewa"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess1"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileLista">
              <el-button size="small" type="primary" :disabled="(rProReport.fStatus == 2 )?false:true"  >设计资料上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
          <div style="font-size: 20px;width:400px;margin-right: -10px">
            <div>
              <span style="margin-left:30px;">勘察设计单位：
                <el-input :disabled="(rProReport.fStatus == 2 )?false:true"   v-model="rProReport.fDesignUnit"  placeholder="请输入内容" style="width:220px;"></el-input></span>
              <div class="block" style="margin-left: 65px;transform:translateY(10%);">
                <span class="demonstration" style="margin-left:25px;" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rProReport.fDesignTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 2 )?false:true" >
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3"  style=" text-align: center;
    line-height: 230px;
    border-right: #a4d5ff 1px solid;">
          招投标
        </el-col>
        <el-col :span="21" style="height: 80px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            招投标概况：
          </div>
          <el-input  maxlength="500" show-word-limit  :disabled="(rProReport.fStatus == 3 )?false:true"  type="textarea" :rows="3" v-model="rProReport.fTenderContent"   placeholder="请输入内容">
          </el-input>
          <div class="from-select">
           <div  style="width: 200px;margin-left: 20px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="GLOBAL.headers()"
                :action="GLOBAL.httpUrl"
                :on-preview="handlePreviewb"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess2"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileListb">
              <el-button size="small" type="primary" :disabled="(rProReport.fStatus == 3 )?false:true" >招投标资料上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
          <div style=";font-size: 20px;width:300px;">
            <div>
              <span >投标人：<el-input :disabled="(rProReport.fStatus == 3 )?false:true"  v-model="rProReport.fTenderPersion"  placeholder="请输入内容" style="width:220px;"></el-input></span>
              <div class="block" style="transform:translateY(10%);">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rProReport.fTenderTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 3 )?false:true" >
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>
        </el-col>
      </el-row>

      <!-- 第六行 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3"  style=" text-align: center;
    line-height: 230px;
    border-right: #a4d5ff 1px solid;">
          项目实施
        </el-col>
        <el-col :span="21" style="height: 80px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            项目实施概况：
          </div>
          <el-input type="textarea" :rows="3"
		   maxlength="500" show-word-limit
          v-model="rProReport.fProimplContent"
          placeholder="请输入内容"
          :disabled="(rProReport.fStatus == 4 )?false:true" >
          </el-input>
          <div class="from-select">
           <div  style="width: 200px;margin-left: 20px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="GLOBAL.headers()"
                :action="GLOBAL.httpUrl"
                :on-preview="handlePreviewc"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess3"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileListc">
              <el-button size="small" type="primary" :disabled="(rProReport.fStatus == 4 )?false:true">实施资料上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
           <div style=";font-size: 20px;width:300px;">
            <div>
              <span >实施人：<el-input :disabled="(rProReport.fStatus == 4 )?false:true" v-model="rProReport.fProimplPersion"  placeholder="请输入内容" style="width:220px;"></el-input></span>
              <div class="block" style="transform:translateY(10%);">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rProReport.fProimplTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 4 )?false:true">
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>
        </el-col>
      </el-row>

      <!-- 第七行 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3"  style=" text-align: center;
    line-height: 430px;
    border-right: #a4d5ff 1px solid;">
          评价验收
        </el-col>
        <el-col :span="21" style="height: 100px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            评价验收意见：
          </div>
          <el-input type="textarea" :rows="7" v-model="rProReport.fAcceptanceContent"
		   maxlength="500" show-word-limit
          :disabled="(rProReport.fStatus == 5 )?false:true" show-word-limit
          placeholder="请输入内容">
          </el-input>
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            验收专家名单：
          </div>
          <el-input type="textarea" :rows="3"
          v-model="rProReport.fAcceptanceList"
		   maxlength="500" show-word-limit
          placeholder="请输入内容"
          :disabled="(rProReport.fStatus == 5 )?false:true">
          </el-input>
          <div class="from-select">
           <div  style="width: 200px;margin-left: 20px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="GLOBAL.headers()"
                :action="GLOBAL.httpUrl"
                :on-preview="handlePreviewd"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess4"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileListd">
              <el-button size="small" type="primary" :disabled="(rProReport.fStatus == 5 )?false:true">验收资料上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>
          <div style="font-size: 20px;width:400px;margin-right: -10px">
            <div>
              <span style="margin-left:30px;">专家验收组长：
                <el-input v-model="rProReport.fAcceptancePersion"
                placeholder="请输入内容"
                :disabled="(rProReport.fStatus == 5 )?false:true"
                style="width:220px;"></el-input></span>
              <div class="block" style="margin-left: 65px;transform:translateY(10%);">
                <span class="demonstration" style="margin-left:25px;" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rProReport.fAcceptanceTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="(rProReport.fStatus == 5 )?false:true">
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>
        </el-col>
      </el-row>

    </div>

  <!-- 下一流程 处理人 弹窗 -->
  <!-- <el-dialog
    title="选择处理人"
    :visible.sync="nextVisible"
    width="30%"
    :before-close="handleClose">
    <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}</el-radio>
    <span slot="footer" class="dialog-footer">
      <el-button @click="nextVisible = false">取 消</el-button>
      <el-button type="primary" @click="addSubmits">确 定</el-button>
    </span>
  </el-dialog> -->
  </div>
</template>
<script>
  //获得系统用户
  import {getUserList } from "@/api/security/planning"
  //获得Token
  import {getToken} from "@/utils/auth"
  //获得文件
  import {getFileById} from "@/api/file"
  //项目申报 API
  import {listReport, getReport, addReport, updateReport, delReport} from "@/api/repair/rproreport"
  export default {
    props: ['rProReport','fileList','fileLista','fileListb','fileListc','fileListd',],
    data() {
      return {
        // 文件上传
        upload: {
          // 设置上传的请求头部
          headers: {Authorization: "Bearer " + getToken()},
          // 上传的地址
          url: "http://localhost/dev-api/file/upload"
        },

        //下一处理人 弹窗
        nextVisible:false,
        //处理人
        radio:'',

        active:1,
        info: {
          stockDate:this.getNowTime(),  //日期
        },
        //处理人 集合
        list:[],
        audit: [
          { value: 1, label: '通过' },
          { value: 2, label: '未通过'},
          { value: 3, label: '驳回'},
        ],
        options: [
          { value: 1, label: '汛前检查' },
          { value: 2, label: '年度检查' },
          { value: 3, label: '特别检查' }
        ],


      }
    },
    created() {
      this.personnel()
    },
    methods: {
      beforeAvatarUpload(file){
      const isLt100M = file.size / 1024 / 1024 < 100;
         if (!isLt100M) {
                this.$message.error('上传文件大小不能超过 100MB!');
                return false
            }
      },
      handlePreview(file) {
		   // window.location.href =  this.fileList[0].url
		   window.open(this.fileList[0].url);
      },
      handlePreviewa(file) {
       // window.location.href =  this.fileLista[0].url
	   window.open(this.fileLista[0].url);
      },
      handlePreviewb(file) {
       // window.location.href =  this.fileListb[0].url
	   window.open(this.fileListb[0].url);
      },
      handlePreviewc(file) {
       // window.location.href =  this.fileListc[0].url
	   window.open(this.fileListc[0].url);
      },
      handlePreviewd(file) {
       // window.location.href =  this.fileListd[0].url
	   window.open(this.fileListd[0].url);
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      //删除文件的
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      //上传数量 限制
      handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      //上传成功
      uploadedSuccess(response, file, fileList) {
        console.log('上传成功',response)
        this.rProReport.fProId = response.data.fId
        this.fileList = [{
          name:response.data.fOldFileName,
          url:response.data.fFilePath
        }]
      },
      //上传成功
      uploadedSuccess1(response, file, fileList) {
        console.log('上传成功',response)
        this.rProReport.fDesignId = response.data.fId
        this.fileLista = [{
          name:response.data.fOldFileName,
          url:response.data.fFilePath
        }]
      },
      //上传成功
      uploadedSuccess2(response, file, fileList) {
        console.log('上传成功',response)
        this.rProReport.fTenderId = response.data.fId
        this.fileListb = [{
          name:response.data.fOldFileName,
          url:response.data.fFilePath
        }]
      },
      //上传成功
      uploadedSuccess3(response, file, fileList) {
        console.log('上传成功',response)
        this.rProReport.fProimplId = response.data.fId
        this.fileListc = [{
          name:response.data.fOldFileName,
          url:response.data.fFilePath
        }]
      },
      //上传成功
      uploadedSuccess4(response, file, fileList) {
        console.log('上传成功',response)
        this.rProReport.fAcceptanceId = response.data.fId
        this.fileListd = [{
          name:response.data.fOldFileName,
          url:response.data.fFilePath
        }]
      },
      //处理默认选中当前日期
	    getNowTime() {
	       var now = new Date();
	       var year = now.getFullYear(); //得到年份
	       var month = now.getMonth(); //得到月份
	       var date = now.getDate(); //得到日期
	       var hour =" 00:00:00"; //默认时分秒 如果传给后台的格式为年月日时分秒，就需要加这个，如若不需要，此行可忽略
	       month = month + 1;
	       month = month.toString().padStart(2, "0");
	       date = date.toString().padStart(2, "0");
	       var defaultDate = `${year}-${month}-${date}${hour}`;
	       console.log(defaultDate)
	       return defaultDate;
	       this.$set(this.info, "stockDate", defaultDate);
	    },
      //获取处理人集合
      personnel(){
        console.log('获取处理人集合')
        getUserList().then(response => {
           console.log('获取处理人集合执行成功',response)
          this.list = response.data
        })
      },
      //提交 保存
      save() {
        this.rProReport.fStatus = 0
        addReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.rProReport.fStatus = ''
            this.rProReport = this.rProReportInit
            this.fileList = []
          }
        })
      },
      //提交 打开 <下一个处理人> 弹窗
      submit() {
        //是否填写 项目名称
        if(this.rProReport.fPerName == null || this.rProReport.fPerName == '') {
          this.$message({
            showClose: true,
            message: '请填写项目名称',
            type: 'error'
          });
          return false
        }
        //是否填写 预算
        if(this.rProReport.fBudget == null || this.rProReport.fBudget == '') {
          this.$message({
            showClose: true,
            message: '请选择计划预算',
            type: 'error'
          });
          return false
        }
        //是否填写 项目概况
        if(this.rProReport.fProContent == null || this.rProReport.fProContent == '') {
          this.$message({
            showClose: true,
            message: '请填写项目概况',
            type: 'error'
          });
          return false
        }
        //是否填写 编制人
        if(this.rProReport.fPreparedBy == null || this.rProReport.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        //是否填写 编制时间
        if(this.rProReport.fPreparationTime == null || this.rProReport.fPreparationTime == '') {
          this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
          return false
        }
        this.nextVisible = true
      },
      //点击 <下一个处理人> 弹窗 => <确定> 按钮
      // addSubmits() {
      //   this.rProReport.fStatus = 1
      //   addReport(this.rProReport).then(res => {
      //     if(res.code == 200) {
      //       this.msgSuccess("提交成功")
      //       this.nextVisible = false
      //       this.rProReport.fStatus = ''
      //       this.rProReport = this.rProReportInit
      //       this.fileList = []
      //     }
      //   })
      // },
      addPla() {
        console.log('提 交')
        //是否填写 项目名称
        if(this.rProReport.fPerName == null || this.rProReport.fPerName == '') {
          this.$message({
            showClose: true,
            message: '请填写项目名称',
            type: 'error'
          });
          return false
        }
        //是否填写 预算
        if(this.rProReport.fBudget == null || this.rProReport.fBudget == '') {
          this.$message({
            showClose: true,
            message: '请选择计划预算',
            type: 'error'
          });
          return false
        }
        //是否填写 项目概况
        if(this.rProReport.fProContent == null || this.rProReport.fProContent == '') {
          this.$message({
            showClose: true,
            message: '请填写项目概况',
            type: 'error'
          });
          return false
        }
        //是否填写 编制人
        if(this.rProReport.fPreparedBy == null || this.rProReport.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        //是否填写 编制时间
        if(this.rProReport.fPreparationTime == null || this.rProReport.fPreparationTime == '') {
          this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
          return false
        }
          this.rProReport.fStatus = 1
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.nextVisible = false
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
              this.radio = ''
            }
          })
      },
      modify() {
        console.log('修 改')
        //是否填写 项目名称
        if(this.rProReport.fPerName == null || this.rProReport.fPerName == '') {
          this.$message({
            showClose: true,
            message: '请填写项目名称',
            type: 'error'
          });
          return false
        }
        //是否填写 预算
        if(this.rProReport.fBudget == null || this.rProReport.fBudget == '') {
          this.$message({
            showClose: true,
            message: '请选择计划预算',
            type: 'error'
          });
          return false
        }
        //是否填写 项目概况
        if(this.rProReport.fProContent == null || this.rProReport.fProContent == '') {
          this.$message({
            showClose: true,
            message: '请填写项目概况',
            type: 'error'
          });
          return false
        }
        //是否填写 编制人
        if(this.rProReport.fPreparedBy == null || this.rProReport.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        //是否填写 编制时间
        if(this.rProReport.fPreparationTime == null || this.rProReport.fPreparationTime == '') {
          this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
          return false
        }
        this.rProReport.fStatus = 1
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.$emit("shut", false)
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      },
      approve() {
        console.log('提交审批')

        //是否填写 审核意见
        if(this.rProReport.fAuditComments == null || this.rProReport.fAuditComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审批意见',
            type: 'error'
          });
          return false
        }
        //是否填写 审核结果
        if(this.rProReport.fAuditResult == null || this.rProReport.fAuditResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审批结果',
            type: 'error'
          });
          return false
        }
        //是否填写 审核人
        if(this.rProReport.fAuditPeople == null || this.rProReport.fAuditPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审批人',
            type: 'error'
          });
          return false
        }
        //是否填写 审批时间
        if(this.rProReport.fAuditDate == null || this.rProReport.fAuditDate == '') {
          this.$message({
            showClose: true,
            message: '请选择审批时间',
            type: 'error'
          });
          return false
        }
        //审核结果 => 通过
        if(this.rProReport.fAuditResult == 1) {
          this.rProReport.fStatus = 2
          console.log('处理人  ',this.radio)
          console.log('处理人  ',this.rProReport.fActPersion)
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.nextVisible = false
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
              this.radio = ''
            }
          })
        }
        //审核结果 => 不通过
        else if(this.rProReport.fAuditResult == 2) {
          this.rProReport.fStatus = 8
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
            }
          })
        }
        //审核结果 => 驳回
        else if(this.rProReport.fAuditResult == 3) {
          this.rProReport.fStatus = 7
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
            }
          })
        }

      },
      survey() {
        console.log('提交勘察')
        //是否填写 勘察设计内容
        if(this.rProReport.fDesignContent == null || this.rProReport.fDesignContent == '') {
          this.$message({
            showClose: true,
            message: '请填写勘察设计内容',
            type: 'error'
          });
          return false
        }
        //是否填写 勘察设计单位
        if(this.rProReport.fDesignUnit == null || this.rProReport.fDesignUnit == '') {
          this.$message({
            showClose: true,
            message: '请填写勘察设计单位',
            type: 'error'
          });
          return false
        }
        //是否填写 勘察设计时间
        if(this.rProReport.fDesignTime == null || this.rProReport.fDesignTime == '') {
          this.$message({
            showClose: true,
            message: '请选择勘察设计时间',
            type: 'error'
          });
          return false
        }
          this.rProReport.fStatus = 3
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.nextVisible = false
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
              this.radio = ''
            }
          })
      },
      bidding() {
        console.log('提交招标')
        //是否填写 招投标概况内容
        if(this.rProReport.fTenderContent == null || this.rProReport.fTenderContent == '') {
          this.$message({
            showClose: true,
            message: '请填写招投标概况内容',
            type: 'error'
          });
          return false
        }
        //是否填写 投标人
        if(this.rProReport.fTenderPersion == null || this.rProReport.fTenderPersion == '') {
          this.$message({
            showClose: true,
            message: '请填写投标人',
            type: 'error'
          });
          return false
        }
        //是否填写 投标时间
        if(this.rProReport.fTenderTime == null || this.rProReport.fTenderTime == '') {
          this.$message({
            showClose: true,
            message: '请选择投标时间',
            type: 'error'
          });
          return false
        }
        console.log("========= 提交招标 =========",this.rProReport)
        this.rProReport.fStatus = 4
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.$emit("shut", false)
            this.nextVisible = false
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
            this.radio = ''
          }
        })
      },
      implement() {
        console.log('提交实施')
        //是否填写 项目实施概况内容
        if(this.rProReport.fProimplContent == null || this.rProReport.fProimplContent == '') {
          this.$message({
            showClose: true,
            message: '请填写项目实施概况内容',
            type: 'error'
          });
          return false
        }
        //是否填写 项目实施人
        if(this.rProReport.fProimplPersion == null || this.rProReport.fProimplPersion == '') {
          this.$message({
            showClose: true,
            message: '请填写项目实施人',
            type: 'error'
          });
          return false
        }
        //是否填写 项目实施时间
        if(this.rProReport.fProimplTime == null || this.rProReport.fProimplTime == '') {
          this.$message({
            showClose: true,
            message: '请选择项目实施时间',
            type: 'error'
          });
          return false
        }
          this.rProReport.fStatus = 5
          updateReport(this.rProReport).then(res => {
            if(res.code == 200) {
              this.msgSuccess("提交成功")
              this.$emit("shut", false)
              this.nextVisible = false
              this.fileList = []
              this.fileList1 = []
              this.fileList2 = []
              this.fileList3 = []
              this.fileList4 = []
              this.radio = ''
            }
          })
      },
      acceptance() {
        console.log('提交验收')
        //是否填写 评价验收意见
        if(this.rProReport.fAcceptanceContent == null || this.rProReport.fAcceptanceContent == '') {
          this.$message({
            showClose: true,
            message: '请填写评价验收意见',
            type: 'error'
          });
          return false
        }
        //是否填写 验收专家名单
        if(this.rProReport.fAcceptanceList == null || this.rProReport.fAcceptanceList == '') {
          this.$message({
            showClose: true,
            message: '请填写验收专家名单',
            type: 'error'
          });
          return false
        }
        //是否填写 专家验收组长
        if(this.rProReport.fAcceptancePersion == null || this.rProReport.fAcceptancePersion == '') {
          this.$message({
            showClose: true,
            message: '请填写专家验收组长',
            type: 'error'
          });
          return false
        }
        //是否填写 验收时间
        if(this.rProReport.fAcceptanceTime == null || this.rProReport.fAcceptanceTime == '') {
          this.$message({
            showClose: true,
            message: '请选择验收时间',
            type: 'error'
          });
          return false
        }
        this.rProReport.fStatus = 6
        updateReport(this.rProReport).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.$emit("shut", false)
            this.fileList = []
            this.fileList1 = []
            this.fileList2 = []
            this.fileList3 = []
            this.fileList4 = []
          }
        })

      },

      close() {
          this.$emit("shut", false)
      }

    }
  };
</script>
<style lang="scss" >
  .color409 {
    color: #409eff;
    cursor: pointer;
  }




</style>
