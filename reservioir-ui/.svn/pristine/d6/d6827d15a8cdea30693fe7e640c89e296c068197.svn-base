<template>
  <div class="app-container">
    <!-- 顶部 箭头 -->
    <el-row class="from-top">
      <el-col :span="24">
        <el-col :span="24">
          <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
            <div style="position: relative;">
              <img src="../../../assets/images/jin.png"/>
              <div  style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.实施</div>
            </div>
            <div  style="position: relative;">
              <img :src="require(rMainImpl.fStatus == 1 || rMainImpl.fStatus == 2 ? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
              <div  :style="rMainImpl.fStatus == 1 || rMainImpl.fStatus == 2? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">2.审核</div>
              </div>
            <div   style="position: relative;">
              <img :src="require(rMainImpl.fStatus==2? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
              <div  :style="rMainImpl.fStatus == 2? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">3.完成</div>
              </div>
          </div>
        </el-col>
      </el-col>
    </el-row>
    <div class="from-div" style="width: 100%;">

      <!-- 顶部 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div>
          <el-button type="primary" @click="addPlaImpl"
          v-if="rMainImpl.fStatus == 0 ">提 交</el-button>

          <el-button type="primary" @click="modifyImpl"
          v-if="rMainImpl.fStatus == 3 ">修 改</el-button>

          <el-button type="primary" @click="reviewImpl"
          v-if="rMainImpl.fStatus == 1 ">提交审批</el-button>

          <el-button type="primary" @click="close" v-if="rMainImpl.fStatus == 2 ">确 定</el-button>
        </div>
        </el-col>
      </el-row>

      <!-- 顶部 表名 -->
      <el-row>
        <el-col :span="24" class="from-div-title">维修养护实施一览表</el-col>
      </el-row>

      <!-- 选择 计划 -->
      <el-row class="from-border-bottom" >
        <el-col :span="3" class="from-col-left" > 计划名称 </el-col>
        <el-col :span="8" style="line-height: 40px;">
            <div>
              <el-select v-model="rMainImpl.fPreparedId" placeholder="请选择" :disabled="true">
                <el-option v-for="item in options" :key="item.fId" :label="item.fPlanName" :value="item.fId"
                >
                </el-option>
              </el-select>
            </div>
        </el-col>
      </el-row>

      <!-- 第一行 实施 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" >  实施内容 </el-col>
        <el-col :span="21" style="height: 400px;">
           <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 实施内容： </div>
          <el-input type="textarea" :rows="8"  maxlength="500" show-word-limit
            :disabled="rMainImpl.fStatus == 0 || rMainImpl.fStatus == 3 ? false : true"
            placeholder="请输入内容" v-model="rMainImpl.fImplContent">
          </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 70px;">
           <div  style="width: 200px;margin-left: 20px;">
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
              <el-button size="small" type="primary" :disabled="rMainImpl.fStatus == 0 || rMainImpl.fStatus == 3 ? false : true">点击上传</el-button>
			  <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>

          <div style="font-size: 20px;margin-right: 10px;margin-top: -10px;">
            <div>
              <span >实施人：<el-input v-model="rMainImpl.fImplPeople"  placeholder="请输入内容"
              style="width:220px;border: 1px solid #DCDFE6;"
              :disabled="rMainImpl.fStatus == 0 || rMainImpl.fStatus == 3 ? false : true"></el-input></span>
              <div class="block"  style="transform:translateY(10%)">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  style="border: 1px solid #DCDFE6;"
                  v-model="rMainImpl.fImplTime"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="rMainImpl.fStatus == 0 || rMainImpl.fStatus == 3 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
          </div>
        </el-col>
      </el-row>

      <!-- 第二行 审核 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col"> 实施审核 </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审核意见： </div>
          <el-input type="textarea" :rows="3"   placeholder="请输入内容"   maxlength="500" show-word-limit
          v-model="rMainImpl.fReviewComments"
          :disabled="rMainImpl.fStatus == 1 ? false : true">
          </el-input>

          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审核结果： </div>
              <el-select v-model="rMainImpl.fReviewResult" clearable placeholder="请选择" :disabled="rMainImpl.fStatus == 1 ? false : true">
                <el-option v-for="item in audit" :key="item.value" :label="item.label"
                :value="item.value" >
                </el-option>
              </el-select>
            </div>

            <div>
              <span >审核人：<el-input v-model="rMainImpl.fReviewPeople"
              placeholder="请输入内容" style="width:180px;"
              :disabled="rMainImpl.fStatus == 1 ? false : true"></el-input>
              </span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="rMainImpl.fReviewDate"
                  placeholder="选择日期"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  :disabled="rMainImpl.fStatus == 1 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <!-- 下一流程 处理人 弹窗 -->
    <el-dialog
      title="选择处理人"
      :visible.sync="nextVisible"
      width="600px"
      :before-close="handleClose"
      >
      <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}</el-radio>
      <span slot="footer" class="dialog-footer">
        <el-button @click="nextVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSubmits">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
//计划 API
import { listMaintenance, getMaintenance, addMaintenance, updateMaintenance, delMaintenance} from "@/api/repair/rmaintenance"
//实施 API
import {listImpl, getImpl, addImpl, updateImpl, delImpl} from "@/api/repair/rmainimpl"
//获得系统用户
import {getUserList } from "@/api/security/planning"
//获得Token
import {getToken} from "@/utils/auth"
export default {
props: ['rMainImpl','options','fileList'],
    data() {

      return {

        // 文件上传
        upload: {
          // 设置上传的请求头部
          headers: {Authorization: "Bearer " + getToken()},
          // 上传的地址
          url: "http://localhost/dev-api/file/upload"
        },
        active:1,
        info: {
          stockDate:this.getNowTime(),  //日期
        },
        //下一处理人
        radio:'',
        //下一处理人  弹窗
        nextVisible:false,
        //处理人 列表
        list:[],
        //文件 存放 <name> <url> 集合
        //fileList: [],
        //审核结果 选项 集合
        audit: [
          {value: 1,label: '通过'},
          {value: 2,label: '未通过'},
          {value: 3,label: '驳回'},
          ],

      };
    },
    created() {

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
        console.log(file);
		// window.location.href =  this.fileList[0].url
		window.open(this.fileList[0].url);
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      //删除文件的
      beforeRemove(file, fileList) {
        if(this.rMainImpl.fStatus == 2 || this.rMainImpl.fStatus == 1) {
          this.$message.warning(`暂无权限删除`)
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
        this.rMainImpl.fImplId = response.data.fId
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


      // <保存> 按钮 提交
      save() {
        this.rMainImpl.fStatus = 0
        addImpl(this.rMainImpl).then(res =>{
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.rMainImpl = this.rMainImplInit
            this.fileList = []
          }
        })
      },

      //<提交> 按钮 提交
      submit() {
        //是否填写 计划编制
        if(this.rMainImpl.fPreparedId == null || this.rMainImpl.fPreparedId == '') {
            this.$message({
              showClose: true,
              message: '请选择计划名称',
              type: 'error'
            });
            return false
        }
        //是否填写 实施内容
        if(this.rMainImpl.fImplContent == null || this.rMainImpl.fImplContent == '') {
            this.$message({
              showClose: true,
              message: '请填写实施内容',
              type: 'error'
            });
            return false
        }
        //是否填写 实施人
        if(this.rMainImpl.fImplPeople == null || this.rMainImpl.fImplPeople == '') {
            this.$message({
              showClose: true,
              message: '请填写实施人',
              type: 'error'
            });
            return false
        }
        //是否填写 实施时间
        if(this.rMainImpl.fImplTime == null || this.rMainImpl.fImplTime == '') {
            this.$message({
              showClose: true,
              message: '请选择实施时间',
              type: 'error'
            });
            return false
        }
        //打开 处理人 选择 弹窗
        this.nextVisible = true
      },

      // <处理人> <确定> 按钮
      addSubmits() {
        if(this.radio == null || this.radio == '') {
          this.$message({
            showClose: true,
            message: '请选择处理人',
            type: 'error'
          });
          return false
        }
        this.rMainImpl.fStatus = 0
        this.rMainImpl.fActPersion = this.radio
        console.log("提交对象",this.rMainImpl)
        addImpl(this.rMainImpl).then(res =>{
          if(res.code == 200) {
            this.msgSuccess("提交成功")
            this.rMainImpl = this.rMainImplInit
            this.nextVisible = false
            this.fileList = []
            this.radio = ''
          }
        })
      },

      //测试 接口 是否能用
      test() {
        listImpl().then(res => {
          console.log('接口测试',res)
        })
      },
      addPlaImpl() {
          //是否填写 计划编制
          if(this.rMainImpl.fPreparedId == null || this.rMainImpl.fPreparedId == '') {
              this.$message({
                showClose: true,
                message: '请选择计划名称',
                type: 'error'
              });
              return false
          }
          //是否填写 实施内容
          if(this.rMainImpl.fImplContent == null || this.rMainImpl.fImplContent == '') {
              this.$message({
                showClose: true,
                message: '请填写实施内容',
                type: 'error'
              });
              return false
          }
          //是否填写 实施人
          if(this.rMainImpl.fImplPeople == null || this.rMainImpl.fImplPeople == '') {
              this.$message({
                showClose: true,
                message: '请填写实施人',
                type: 'error'
              });
              return false
          }
          //是否填写 实施时间
          if(this.rMainImpl.fImplTime == null || this.rMainImpl.fImplTime == '') {
              this.$message({
                showClose: true,
                message: '请选择实施时间',
                type: 'error'
              });
              return false
          }

          this.rMainImpl.fStatus = 1
          updateImpl(this.rMainImpl).then(res => {
            if(res.code == 200) {
              updateMaintenance({fId:this.rMainImpl.fPreparedId,fStatus:7,fActPersion:this.radioImpl}).then(res => {
                if(res.code == 200) {
                  console.log('提交成功')
                  this.rMainImpl = this.rMainImplInit
                  this.getList()
                  this.nextVisibleImpl = false
                  this.$emit("close1")
                  this.fileListImpl = []
                  this.radioImpl = ''
                }
              })
            }
          })
          this.$emit("close1")
      },
      reviewImpl() {
        //是否填写 审核意见
        if(this.rMainImpl.fReviewComments == null || this.rMainImpl.fReviewComments == '') {
            this.$message({
              showClose: true,
              message: '请填写审核意见',
              type: 'error'
            });
            return false
        }
        //是否选择 审核结果
        if(this.rMainImpl.fReviewResult == null || this.rMainImpl.fReviewResult == '') {
            this.$message({
              showClose: true,
              message: '请选择审核结果',
              type: 'error'
            });
            return false
        }
        //是否填写 审核人
        if(this.rMainImpl.fReviewPeople == null || this.rMainImpl.fReviewPeople == '') {
            this.$message({
              showClose: true,
              message: '请填写审核人',
              type: 'error'
            });
            return false
        }
        //是否填写 实施时间
        if(this.rMainImpl.fReviewDate == null || this.rMainImpl.fReviewDate == '') {
            this.$message({
              showClose: true,
              message: '请选择审核时间',
              type: 'error'
            });
            return false
        }
        if(this.rMainImpl.fReviewResult == 1) {
          this.rMainImpl.fStatus = 2
          updateImpl(this.rMainImpl).then(res => {
            if(res.code == 200) {
              updateMaintenance({fId:this.rMainImpl.fPreparedId,fStatus:8,fActPersion:this.radioImpl}).then(res => {
                if(res.code == 200) {
                  console.log('提交成功')
                  this.rMainImpl = this.rMainImplInit
                  this.getList()
                  this.nextVisibleImpl = false
                  this.$emit("close1")
                  this.fileListImpl = []
                  this.radioImpl = ''
                }
              })
            }
          })
          this.$emit("close1")
        }
        else if(this.rMainImpl.fReviewResult == 2) {
          this.rMainImpl.fStatus = 4
          updateImpl(this.rMainImpl).then(res => {
            if(res.code == 200) {
              updateMaintenance({fId:this.rMainImpl.fPreparedId,fStatus:3}).then(res => {
                if(res.code == 200) {
                  console.log('提交成功')
                  this.rMainImpl = this.rMainImplInit
                  this.getList()
                  this.nextVisibleImpl = false
                  this.$emit("close1")
                  this.fileListImpl = []
                  this.radioImpl = ''
                }
              })
            }
          })
          this.$emit("close1")
        }
        else if(this.rMainImpl.fReviewResult == 3) {
          this.rMainImpl.fStatus = 3
          updateImpl(this.rMainImpl).then(res => {
            if(res.code == 200) {
              updateMaintenance({fId:this.rMainImpl.fPreparedId,fStatus:9}).then(res => {
                if(res.code == 200) {
                  console.log('提交成功')
                  this.rMainImpl = this.rMainImplInit
                  this.getList()
                  this.nextVisibleImpl = false
                  this.$emit("close1")
                  this.fileListImpl = []
                  this.radioImpl = ''
                }
              })
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
