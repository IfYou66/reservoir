<template>
  <div class="app-container">
    <!-- 顶部 箭头 -->
    <el-row class="from-top">
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">

          <!-- 计划编制 -->
          <div style="position: relative;">
            <img :src="require(rMaintenance.fStatus != 5? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')"/>
            <div  :style="rMaintenance.fStatus != 5? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">1.计划编制</div>
          </div>
          <!-- 计划编制 -->
          <div  style="position: relative;">
            <img :src="require((rMaintenance.fStatus >= 1 && rMaintenance.fStatus <= 3)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rMaintenance.fStatus >= 1 && rMaintenance.fStatus <= 3)? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">2.计划审核</div>
          </div>
          <!-- 计划批准 -->
          <div   style="position: relative;">
            <img :src="require((rMaintenance.fStatus >= 2 && rMaintenance.fStatus <= 3)? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="(rMaintenance.fStatus >= 2 && rMaintenance.fStatus <= 3)? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">3.计划批准</div>
          </div>
          <!-- 计划完成 -->
          <div   style="position: relative;">
            <img :src="require(rMaintenance.fStatus == 3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="rMaintenance.fStatus == 3? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">4.计划完成</div>
          </div>

        </div>
      </el-col>
    </el-row>

    <!-- 表格 -->
    <div  class="from-div" style="width: 100%;">

      <!-- 顶部 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div>
          <el-button type="primary" @click="addPla"
          v-if="rMaintenance.fStatus == 0 ">提 交</el-button>

          <el-button type="primary" @click="modify"
          v-if="rMaintenance.fStatus == 4 ">修 改</el-button>

          <el-button type="primary" @click="review"
          v-if="rMaintenance.fStatus == 1 ">提交审核</el-button>

          <el-button type="primary" @click="approve"
          v-if="rMaintenance.fStatus == 2 ">提交审批</el-button>

          <el-button type="primary" @click="close"
          v-if="rMaintenance.fStatus == 3 ">确 定</el-button>
        </div>
        </el-col>
      </el-row>

      <!-- 顶部 表名 -->
      <el-row>
        <el-col :span="24" class="from-div-title">维修养护计划编制审批表</el-col>
      </el-row>

      <!-- 表内 第一行 -->
      <el-row class="from-border-bottom" >

        <el-col :span="3" class="from-col-left" > 计划名称 </el-col>
        <el-col :span="8" class="from-border-right" >
          <el-input v-model="rMaintenance.fPlanName" placeholder="请输入内容"
          :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true"></el-input>
        </el-col>

        <el-col :span="3" class="from-col-left" > 计划类型 </el-col>
        <el-col :span="3" style="line-height: 40px;border-right: #a4d5ff 1px solid;">
            <div>
              <el-select v-model="rMaintenance.fPlanType" placeholder="请选择" :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true">
                <el-option v-for="item in options" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
        </el-col>

        <el-col :span="3" class="from-col-left" > 预算（元） </el-col>
        <el-col :span="4" class="from-border-right" >
          <el-input v-model="rMaintenance.fBudget" placeholder="预算（元）"
          :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true"></el-input>
        </el-col>

      </el-row>

      <!-- 表内 第二行 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" > 计划内容 </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 计划概述：</div>
          <el-input type="textarea"  maxlength="500" show-word-limit  :rows="8" placeholder="请输入内容" v-model="rMaintenance.fPlanContent"
          :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true"> </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 70px;">
           <div  style="width: 200px;margin-left: 20px;">
              <el-upload
              :before-upload = "beforeAvatarUpload"
                class="upload-demo"
                :headers="GLOBAL.headers()"
                :action="GLOBAL.httpUrl"
                :on-preview="handlePreview"
                :on-remove="handleRemove"

                multiple
                :on-success="uploadedSuccess"
                :show-file-list="true"
                :auto-upload="true"
                :limit="1"
                :on-exceed="handleExceed"
                :file-list="fileList">
                <el-button size="small" type="primary"
                :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true">点击上传</el-button>
				<div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>

          <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
            <div style="text-align: left">
             <div style="display:inline;">编制人：<el-input
             :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true"
             v-model="rMaintenance.fPreparedBy"  placeholder="请输入内容" style="width:220px;border: 1px solid #DCDFE6;"></el-input></div>
              <div class="block" style="transform:translateY(10%)">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date" style="border: 1px solid #DCDFE6;"
                  v-model="rMaintenance.fPreparationTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="rMaintenance.fStatus == 0 || rMaintenance.fStatus == 4 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>

        </el-col>
      </el-row>

      <!-- 表内 第三行 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col"> 计划审核 </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审核意见： </div>
          <el-input type="textarea" :rows="3"  placeholder="请输入内容"  maxlength="500" show-word-limit
          v-model="rMaintenance.fReviewComments"
          :disabled="rMaintenance.fStatus == 1? false : true"> </el-input>

          <div class="from-select">
            <div style="margin-left: 10px;">
               <div style="font-size: 16px;font-weight: 700;display:inline;"> 审核结果： </div>
                <el-select v-model="rMaintenance.fReviewResult" clearable
                placeholder="请选择"
                :disabled="rMaintenance.fStatus == 1? false : true">
                  <el-option v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
              </el-select>
            </div>

            <div>
              <span >审核人：<el-input v-model="rMaintenance.fReviewPeople"
              placeholder="请输入内容" style="width:180px;"
              :disabled="rMaintenance.fStatus == 1 ? false : true"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rMaintenance.fReviewDate"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="rMaintenance.fStatus == 1 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>

        </el-col>
      </el-row>

      <!-- 表内 第四 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col"> 计划批准 </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审批意见： </div>
          <el-input type="textarea" placeholder="请输入内容" :rows="3"  maxlength="500" show-word-limit
          v-model="rMaintenance.fAuditComments"
          :disabled="rMaintenance.fStatus == 2 ? false : true">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审批结果： </div>
              <el-select v-model="rMaintenance.fAuditResult" clearable placeholder="请选择"
              :disabled="rMaintenance.fStatus == 2 ? false : true">
                <el-option v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审批人：<el-input v-model="rMaintenance.fAuditPeople"
              placeholder="请输入内容" style="width:180px;"
              :disabled="rMaintenance.fStatus == 2 ? false : true"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rMaintenance.fAuditDate"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="rMaintenance.fStatus == 2 ? false : true">
                </el-date-picker>
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
//计划 API
import {listMaintenance, getMaintenance, addMaintenance, updateMaintenance, delMaintenance} from "@/api/repair/rmaintenance"

export default {
    props: ['rMaintenance','fileList'],
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
        //箭头 状态
        active:0,

        //对象 初始化
        rMaintenanceInit:{
          //id
          fId:'',
          //计划名称
          fPlanName:'',
          //计划类型
          fPlanType:'',
          //预算
          fBudget:'',
          //计划概述
          fPlanContent:'',
          //计划附件
          fPlanId:'',
          //编制人
          fPreparedBy:'',
          //编制时间
          fPreparationTime:'',

          //审核意见
          fReviewComments:'',
          //审核结果
          fReviewResult:'',
          //审核人
          fReviewPeople:'',
          //审核时间
          fReviewDate:'',

          //审批意见
          fAuditComments:'',
          //审批结果
          fAuditResult:'',
          //审批人
          fAuditPeople:'',
          //审批时间
          fAuditDate:'',

          //创建人
          fCreatePeople:'',
          //创建时间
          fCreateTime:'',
          //状态 0:失效1：有效
          fStatus:'',
          //流程实例id
          fActId:'',
          //流程下一节点审核人
          fActPersion:'',
          //流程状态 流程状态
          fActStatus:'',
          //流程节点
          fActNode:'',
        },

        info: {stockDate:this.getNowTime(),  //日期
        },

        audit: [
          { value: 1, label: '通过'},
          { value: 2, label: '未通过'},
          { value: 3, label: '驳回'},
        ],

        options: [],

      };
    },
    created() {
      this.personnel()
      this.getDict()
    },
    methods: {
      getDict(){
      	this.getDicts("maintenance_type").then(response => {
      		this.options = response.data;
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
        console.log(file);
		// window.location.href =  this.fileList[0].url
		window.open(this.fileList[0].url);
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      //删除文件的
      beforeRemove(file, fileList) {
        if(this.rMaintenance.fStatus != 0 || rMaintenance.fStatus != 4) {
          this.$message.warning("您没有权限进行删除")
          return false
        }
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      //上传数量 限制
      handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      //上传成功
      uploadedSuccess(response, file, fileList) {
        console.log('上传成功',response)
        this.rMaintenance.fPlanId = response.data.fId
      },

      //获取处理人集合
      personnel(){
        console.log('获取处理人集合')
        getUserList().then(response => {
           console.log('获取处理人集合执行成功',response)
          this.list = response.data
        })
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

      //提交 保存
      save() {
        this.rMaintenance.fStatus = 0
        addMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
      },

      //提交 打开 <下一个处理人> 弹窗
      submit() {
        //是否填写 计划名称
        if(this.rMaintenance.fPlanName == null || this.rMaintenance.fPlanName == '') {
          this.$message({
            showClose: true,
            message: '请填写计划名称',
            type: 'error'
          });
          return false
        }
        //是否填写 计划类型
        if(this.rMaintenance.fPlanType == null || this.rMaintenance.fPlanType == '') {
          this.$message({
            showClose: true,
            message: '请选择计划类型',
            type: 'error'
          });
          return false
        }
        //是否填写 预算
        if(this.rMaintenance.fBudget == null || this.rMaintenance.fBudget == '') {
          this.$message({
            showClose: true,
            message: '请填写预算',
            type: 'error'
          });
          return false
        }
        //是否填写 计划概述
        if(this.rMaintenance.fPlanContent == null || this.rMaintenance.fPlanContent == '') {
          this.$message({
            showClose: true,
            message: '请填写计划概述',
            type: 'error'
          });
          return false
        }
        //是否填写 编制人
        if(this.rMaintenance.fPreparedBy == null || this.rMaintenance.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
        }
        //是否填写 编制时间
        if(this.rMaintenance.fPreparationTime == null || this.rMaintenance.fPreparationTime == '') {
          this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
          return false
        }
        this.rMaintenance.fStatus = 1
        addMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.nextVisible = false
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      },//提交
    addPla() {
      //是否填写 计划名称
      if(this.rMaintenance.fPlanName == null || this.rMaintenance.fPlanName == '') {
          this.$message({
            showClose: true,
            message: '请填写计划名称',
            type: 'error'
          });
          return false
      }
      //是否填写 计划类型
      if(this.rMaintenance.fPlanType == null || this.rMaintenance.fPlanType == '') {
          this.$message({
            showClose: true,
            message: '请选择计划类型',
            type: 'error'
          });
          return false
      }
      //是否填写 预算
      if(this.rMaintenance.fBudget == null || this.rMaintenance.fBudget == '') {
          this.$message({
            showClose: true,
            message: '请填写预算',
            type: 'error'
          });
          return false
      }
      //是否填写 计划概述
      if(this.rMaintenance.fPlanContent == null || this.rMaintenance.fPlanContent == '') {
          this.$message({
            showClose: true,
            message: '请填写计划概述',
            type: 'error'
          });
          return false
      }
      //是否填写 编制人
      if(this.rMaintenance.fPreparedBy == null || this.rMaintenance.fPreparedBy == '') {
          this.$message({
            showClose: true,
            message: '请填写编制人',
            type: 'error'
          });
          return false
      }
      //是否填写 编制时间
      if(this.rMaintenance.fPreparationTime == null || this.rMaintenance.fPreparationTime == '') {
        this.$message({
            showClose: true,
            message: '请选择编制时间',
            type: 'error'
          });
        return false
      }

      this.rMaintenance.fStatus = 1
      updateMaintenance(this.rMaintenance).then(res => {
        if(res.code == 200) {
          this.msgSuccess("提交成功")
          this.nextVisible = false
            this.$emit("close1")
          this.rMaintenance.fStatus = ''
          this.rMaintenance = this.rMaintenanceInit
          this.fileList = []
          this.radio = ''
        }
      })
      this.$emit("close1")
      console.log("点击 点击 点击")
    },
    //审核提交
    review() {
      //是否填写 审核意见
      if(this.rMaintenance.fReviewComments == null || this.rMaintenance.fReviewComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审核意见',
            type: 'error'
          });
          return false
      }
      //是否填写 审核结果
      if(this.rMaintenance.fReviewResult == null || this.rMaintenance.fReviewResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审核结果',
            type: 'error'
          });
          return false
      }
      //是否填写 审核人
      if(this.rMaintenance.fReviewPeople == null || this.rMaintenance.fReviewPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审核人',
            type: 'error'
          });
          return false
      }
      //是否填写 审核时间
      if(this.rMaintenance.fReviewDate == null || this.rMaintenance.fReviewDate == '') {
        this.$message({
            showClose: true,
            message: '请选择审核时间',
            type: 'error'
          });
        return false
      }
      //审批 未通过
      if(this.rMaintenance.fReviewResult == 2) {
        this.rMaintenance.fStatus = 5
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审批提交成功")
            this.nextVisible = false
            this.$emit("close1")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
      //审批 驳回
      else if(this.rMaintenance.fReviewResult == 3) {
        this.rMaintenance.fStatus = 4
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审批提交成功")
            this.nextVisible = false
            this.$emit("close1")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
      //审批 通过
      else if(this.rMaintenance.fReviewResult == 1) {
        this.rMaintenance.fStatus = 2
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审核提交成功")
            this.nextVisible = false
            this.$emit("close1")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
    },
    approve() {
      //是否填写 审批意见
      if(this.rMaintenance.fAuditComments == null || this.rMaintenance.fAuditComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审批意见',
            type: 'error'
          });
          return false
      }
      //是否填写 审批结果
      if(this.rMaintenance.fAuditResult == null || this.rMaintenance.fAuditResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审批结果',
            type: 'error'
          });
          return false
      }
      //是否填写 审核人
      if(this.rMaintenance.fAuditPeople == null || this.rMaintenance.fAuditPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审批人',
            type: 'error'
          });
          return false
      }
      //是否填写 审批时间
      if(this.rMaintenance.fAuditDate == null || this.rMaintenance.fAuditDate == '') {
        this.$message({
            showClose: true,
            message: '请选择审批时间',
            type: 'error'
          });
        return false
      }
      //审批 未通过
      if(this.rMaintenance.fAuditResult == 2) {
        this.rMaintenance.fStatus = 5
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审批提交成功")
            this.nextVisible = false
            this.$emit("close1")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
      //审批 驳回
      else if(this.rMaintenance.fAuditResult == 3) {
        this.rMaintenance.fStatus = 4
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审批提交成功")
            this.nextVisible = false
            this.$emit("close1");
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
      //审批 通过
      else if(this.rMaintenance.fAuditResult == 1) {
        this.rMaintenance.fStatus = 3
        updateMaintenance(this.rMaintenance).then(res => {
          if(res.code == 200) {
            this.msgSuccess("审批提交成功")
            this.nextVisible = false
            this.$emit("close1")
            this.rMaintenance.fStatus = ''
            this.rMaintenance = this.rMaintenanceInit
            this.fileList = []
          }
        })
        this.$emit("close1")
      }
    },
    close() {
        this.$emit("close1")
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
