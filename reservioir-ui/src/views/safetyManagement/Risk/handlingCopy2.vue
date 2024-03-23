<template>
  <div class="app-container">
    <!-- 头部箭头 -->
    <el-row class="from-top">
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img src="../../../assets/images/jin.png" />
            <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.险情发生</div>
          </div>
          <div style="position: relative;">
            <img
              :src="require((MRiskManagement.fActStatus >= 1 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              :style="(MRiskManagement.fActStatus >= 1 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              2.应急响应</div>
          </div>
          <div style="position: relative;">
            <img
              :src="require((MRiskManagement.fActStatus >= 2 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              :style="(MRiskManagement.fActStatus >= 2 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              3.险情排除</div>
          </div>
          <div style="position: relative;">
            <img
              :src="require((MRiskManagement.fActStatus >= 4 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              :style="(MRiskManagement.fActStatus >= 4 && MRiskManagement.fActStatus <= 4) || MRiskManagement.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              4.处置检查完成</div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 表主体 -->
    <div class="from-div">
      <!-- 头部按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
          </div>
        </el-col>
      </el-row>

      <!-- 表名 -->
      <el-row>
        <el-col :span="24" class="from-div-title">
          水库大坝险情处置一览表
        </el-col>
      </el-row>

      <!-- 险情 第一行 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left"> 险情名称 </el-col>
        <el-col :span="4" class="from-border-right">
          <el-input v-model="MRiskManagement.fRiskName" placeholder="请输入内容" :disabled="true"></el-input>
        </el-col>

        <el-col :span="2" class="from-col-left"> 险情类别 </el-col>
        <el-col :span="3" style="line-height: 40px;border-right: #a4d5ff 1px solid;">
          <div>
            <el-select v-model="MRiskManagement.fRiskType" placeholder="请选择" :disabled="true">
              <el-option v-for="item in audit" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
              </el-option>
            </el-select>
          </div>
        </el-col>

        <el-col :span="2" class="from-col-left"> 险情编号 </el-col>
        <el-col :span="2" class="from-border-right">
          <el-input v-model="MRiskManagement.fRiskNumber" placeholder="请输入内容" :disabled="true"></el-input>
        </el-col>

        <el-col :span="3" class="from-col-left"> 险情发现时间 </el-col>
        <el-col :span="4" style="text-align: center ;line-height: 40px;">
          <el-date-picker v-model="MRiskManagement.fRiskFindDate" type="date" placeholder="开始时间" format="yyyy-MM-dd"
            :disabled="true">
          </el-date-picker>
        </el-col>

      </el-row>

      <!-- 险情 第二行 概述 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" style="line-height: 250px;"> 险情概述 </el-col>
        <el-col :span="21">

          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 险情概述： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="5" placeholder="请输入内容" v-model="MRiskManagement.fRiskSummary"
            :disabled="true">
          </el-input>

          <div style="display:flex;justify-content:space-between;">

            <div style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: 0px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                multiple :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1"
                :on-exceed="handleExceed" :file-list="fileList">
                <el-button size="small" type="primary" :disabled=" true">点击上传</el-button>
				<div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;margin-right: -15px">记录人：
                  <el-input v-model="MRiskManagement.fRecordPeople" placeholder="请输入内容" :disabled="true"
                    style="width:220px;border: 1px solid #DCDFE6;margin-left: -6px"></el-input>
                </div>

                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" style="border: 1px solid #DCDFE6;" v-model="MRiskManagement.fRecordDate"
                    placeholder="选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd" :disabled="true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>

        </el-col>
      </el-row>

      <!-- 险情 第三行 响应 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" style="line-height: 250px;"> 响应情况 </el-col>
        <el-col :span="21">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 响应情况： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="5" placeholder="请输入内容" v-model="MRiskManagement.fResponseSituation"
            :disabled="true">
          </el-input>

          <div style="display:flex;justify-content:space-between;">
            <div style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: 0px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                multiple :on-success="uploadedSuccess1" :show-file-list="true" :auto-upload="true" :limit="1"
                :on-exceed="handleExceed" :file-list="fileList1">
                <el-button size="small" type="primary" :disabled="true">点击上传</el-button>
				<div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;margin-right: -15px">响应人：
                  <el-input v-model="MRiskManagement.fResponsePeople" placeholder="请输入内容" :disabled="true"
                    style="width:220px;border: 1px solid #DCDFE6;margin-left: -6px"></el-input>
                </div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" style="border: 1px solid #DCDFE6;" v-model="MRiskManagement.fResponseDate"
                    placeholder="选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd" :disabled="true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>

        </el-col>
      </el-row>

      <!-- 险情 第四行 处置 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" style="line-height: 250px;"> 处置结果 </el-col>
        <el-col :span="21">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 处置结果： </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="5" placeholder="请输入内容" v-model="MRiskManagement.fDisposalResults"
            :disabled=" true">
          </el-input>

          <div style="display:flex;justify-content:space-between;">
            <div style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: 0px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                multiple :on-success="uploadedSuccess2" :show-file-list="true" :auto-upload="true" :limit="1"
                :on-exceed="handleExceed" :file-list="fileList2">
                <el-button size="small" type="primary" :disabled="true">点击上传</el-button>
				<div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;margin-right: -15px">处置人：
                  <el-input v-model="MRiskManagement.fDisposalPeople" placeholder="请输入内容" :disabled="true"
                    style="width:220px;border: 1px solid #DCDFE6;margin-left: -6px"></el-input>
                </div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" style="border: 1px solid #DCDFE6;" v-model="MRiskManagement.fDisposalDate"
                    placeholder="选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd" :disabled="true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>

        </el-col>
      </el-row>

      <!-- 险情 第五行 检查 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col"> 处置检查 </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 检查意见： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" placeholder="请输入内容" :rows="2" v-model="MRiskManagement.fInspectionOpinions"
            :disabled="true"> </el-input>

          <div style="display: inline">
            <div style="margin-left: 10px;margin-top: 15px">
              <span style="font-size: 16px;font-weight: 700;display:inline;"> 检查结果： </span>
              <el-select v-model="MRiskManagement.fInspectionResults" clearable placeholder="请选择"
                style="border: 1px solid #DCDFE6;" :disabled="true">
                <el-option v-for="item in audit" :key="item.dictValue" :label="item.divtLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>

            <div style="text-align:right;margin-right: 15px;margin-top: -37px">
              <span>检查人：<el-input v-model="MRiskManagement.fInspectionPeople" placeholder="请输入内容"
                  style="width:180px;border: 1px solid #DCDFE6;" :disabled="true"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker style="border: 1px solid #DCDFE6;" type="date" v-model="MRiskManagement.fInspectionDate"
                  placeholder="选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd" :disabled="true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

    </div>

  </div>
</template>

<script>
  //获得系统用户
  import {
    getUserList
  } from "@/api/security/planning"
  import {
    getToken
  } from "@/utils/auth"
  import {
    getFileById
  } from "@/api/file"
  import {
    listManagement,
    getManagement,
    addManagement,
    updateManagement,
    delManagement
  } from '@/api/risk/risk'
  export default {
    props: ['MRiskManagement', 'fileList', 'fileList1', 'fileList2'],
    data() {
      return {
        // 文件上传
        upload: {
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: "http://localhost/dev-api/file/upload"
        },
        active: 1,
        info: {
          stockDate: this.getNowTime(), //日期
        },
        dialogVisible: false,
        //下一处理人 弹窗
        nextVisible: false,
        //处理人
        radio: '',
        textarea: '',
        value1: '',
        value2: '',
        value3: '',
        value4: '',
        input: '',
        value: '',
        textarea1: '',
        textarea2: '',
        audit: [],


        options: [{
            value: 1,
            label: '通过'
          },
          {
            value: 2,
            label: '未通过'
          }
        ],
        data: [{
            id: '1',
            planName: '李所长',
            planningTime: '2021-07-05 16:00:00',
            progressStatus: '查看',
          },
          {
            id: '2',
            planName: '张所长',
            planningTime: '2021-07-05 16:00:00',
            progressStatus: '批准',
            status: '待审批'
          },
          {
            id: '3',
            planName: '马所长',
            planningTime: '2021-07-05 16:00:00',
            progressStatus: '实施',
            status: '实施'
          }
        ],
      };
    },
    created() {
      this.getDict();
    },
    methods: {
      getDict(){
      	this.getDicts("risk_managementr").then(response => {
      		this.audit = response.data;
          console.log("this.audit",this.audit)
      	});
      },
       beforeAvatarUpload(file){
            const isLt100M = file.size / 1024 / 1024 < 100;
               if (!isLt100M) {
                      this.$message.error('上传文件大小不能超过 100MB!');
                      return false
                  }
            },


      handlePreview(file) {
        // window.location.href = file.url;
		window.open(file.url);
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
        console.log('上传成功', response)
        this.MRiskManagement.fRiskInfoFileId = response.data.fId
      },
      //上传成功
      uploadedSuccess1(response, file, fileList) {
        console.log('上传成功', response)
        this.MRiskManagement.fResponseInfoFileId = response.data.fId
      },
      uploadedSuccess2(response, file, fileList) {
        console.log('上传成功', response)
        this.MRiskManagement.fDisposalInfoFileId = response.data.fId
      },

      //测试接口
      test() {
        listManagement({
          pageNum: 1,
          pageSize: 10
        }).then(res => {
          console.log("测试接口", res)
        })
      },

      dialog() {
        this.dialogVisible = true
      },

      getNowTime() {
        var now = new Date();
        var year = now.getFullYear(); //得到年份
        var month = now.getMonth(); //得到月份
        var date = now.getDate(); //得到日期
        var hour = " 00:00:00"; //默认时分秒 如果传给后台的格式为年月日时分秒，就需要加这个，如若不需要，此行可忽略
        month = month + 1;
        month = month.toString().padStart(2, "0");
        date = date.toString().padStart(2, "0");
        var defaultDate = `${year}-${month}-${date}${hour}`;
        console.log(defaultDate)
        return defaultDate;
        this.$set(this.info, "stockDate", defaultDate);
      },



    }
  };
</script>
<style lang="scss">
  .color409 {
    color: #409eff;
    cursor: pointer;
  }
</style>
