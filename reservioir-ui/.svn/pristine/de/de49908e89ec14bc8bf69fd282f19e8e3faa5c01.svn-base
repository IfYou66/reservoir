<template>
  <div class="app-container">

    <!-- 顶部流程箭头 -->
    <el-row class="from-top" >
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img style="width: 100%;height: 45px;" src="../../../assets/images/jin.png"/>
            <div  style="position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;">1.编制</div>
          </div>
          <div  style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require(active>1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>1? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">2.审核</div>
          </div>
          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require(active>2? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>2? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">3.批准</div>
          </div>
          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require(active>3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>3? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">4.发布</div>
          </div>
          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require(active>4? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active>4? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">5.预案演练</div>
          </div>
          <div   style="position: relative;">
            <img style="width: 100%;height: 45px;" :src="require(active==6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div  :style="active==6? 'position: absolute;top: 10px;left: 60px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 60px;width: 50%;color: #757575;'">6.预案执行</div>
          </div>
        </div>
      </el-col>
    </el-row>

    <div  class="from-div" >

      <!-- 头部 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
            <!-- 第一次创建 提交按钮 -->
            <el-button type="primary" size="small" @click="temporaryStorage"  >保 存</el-button>
            <!-- 第一次创建 提交按钮 -->
            <el-button type="primary" size="small" @click="submitEmergency"  >提 交</el-button>


          </div>
        </el-col>
      </el-row>

      <!-- 表 标题 -->
      <el-row>
        <el-col :span="24" class="from-div-title" >
          水库预案编制审批表
        </el-col>
      </el-row>

      <!-- 提交填写  -->
      <el-row class="from-border-bottom" >
        <el-col :span="3" class="from-col-left" > 预案名称 </el-col>
        <el-col :span="4" class="from-border-right" >
          <el-input v-model="emergency.fPlanName" placeholder="请输入内容" :disabled="active < 2 ? false : true"></el-input>
        </el-col>

        <el-col :span="2" class="from-col-left" > 预案编号 </el-col>
        <el-col :span="2" class="from-border-right" >
          <el-input v-model="emergency.fPlanNumber" placeholder="请输入内容" :disabled="active < 2 ? false : true"></el-input>
        </el-col>
        <el-col :span="2" class="from-col-left" > 预案分类 </el-col>
        <el-col :span="2" class="from-border-right" >
          <div>
            <el-select v-model="emergency.fPlanType" placeholder="请选择">
              <el-option v-for="item in approvalPlanType" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
              </el-option>
            </el-select>
          </div>
        </el-col>

        <el-col :span="3" class="from-col-left" > 发布时间 </el-col>
        <el-col :span="6" style="text-align: center ;line-height: 40px;">
          <el-date-picker v-model="emergency.fPublishStartDate" type="date" value-format="yyyy-MM-dd" style="width: 44%;" placeholder="开始时间" :disabled="active < 2 ? false : true"> </el-date-picker>
          ~
          <el-date-picker v-model="emergency.fPublishEndDate" type="date" value-format="yyyy-MM-dd" style="width: 44%;" placeholder="结束时间" :disabled="active < 2 ? false : true"> </el-date-picker>
        </el-col>
      </el-row>

      <!-- 提交填写  -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" > 预案概述 </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 预案概述： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="8"   placeholder="请输入内容" v-model="emergency.fPlanSummary" :disabled="active < 2 ? false : true">
          </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 70px;">
            <div  style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;"
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
                <el-button size="small" type="primary" :disabled="active < 2 ? false : true">文件上传</el-button>
                <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;">编制人：<el-input v-model="emergency.fPreparedBy"  placeholder="请输入内容" style="width:220px;border: 1px solid #DCDFE6;"></el-input></div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                  <el-date-picker
                    type="date" style="border: 1px solid #DCDFE6;"
                    v-model="emergency.fPreparationTime"
                    placeholder="选择日期"
                    format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    :disabled="active < 2 ? false : true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 审核填写 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:188px;"> 审核信息 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审核意见： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fReviewComments" :disabled="active == 2 ? false : true"> </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审核结果： </div>
              <el-select v-model="value4" placeholder="请选择" :disabled="active == 2 ? false : true">
                <el-option v-for="item in fReviewResultList" :key="item.value" :label="item.label" :value="item.value"> </el-option>
              </el-select>
            </div>
            <div  style="margin-top:20px;">
              <span >审核人：<el-input v-model="emergency.fReviewPeople"  placeholder="请输入内容" style="width:180px;" :disabled="active == 2 ? false : true"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="emergency.fReviewDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="active == 2 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 批准填写 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:228px;"> 批准信息 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审批意见：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fAuditComments" :disabled="active == 3 ? false : true"> </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审批结果： </div>
              <el-select v-model="emergency.fAuditResult" placeholder="请选择" :disabled="active == 3 ? false : true">
                <el-option v-for="item in fReviewResultList" :key="item.value" :label="item.label" :value="item.value"></el-option>
              </el-select>
            </div>
            <div  style="margin-top:20px;">
              <span >审批人：<el-input v-model="emergency.fAuditPeople"  placeholder="请输入内容" style="width:180px;" :disabled="active == 3 ? false : true"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                <el-date-picker
                  type="date"
                  v-model="emergency.fAuditDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="active == 3 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
          <div  style="width: 200px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;margin-top: 10px"
             :before-upload = "beforeAvatarUpload"
                       class="upload-demo"
                       :headers="GLOBAL.headers()"
                       :action="GLOBAL.httpUrl"
                       :on-preview="handlePreviewa"
                       :on-remove="handleRemovesss"

                       multiple
                       :on-success="uploadedSuccesssss"
                       :show-file-list="true"
                       :auto-upload="true"
                       :limit="1"
                       :on-exceed="handleExceed"
                       :file-list="fileList">
              <el-button size="small" type="primary" :disabled="active == 3 ? false : true">文件上传</el-button>
            </el-upload>
          </div>
        </el-col>
      </el-row>

      <!-- 发布填写 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:188px;"> 预案发布 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 预案发布：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fPublishContent" :disabled="active == 4 ? false : true"> </el-input>
          <div  style="margin-top:20px;text-align:right;">
            <span >发布人：<el-input v-model="emergency.fPublishPeople"  placeholder="请输入内容" style="width:180px;border: 1px solid #DCDFE6;" :disabled="active == 4 ? false : true"></el-input></span>
            <div class="block"  style="display:inline;margin-left:14px;">
              <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
              <el-date-picker
                type="date"
                style="width:220px;margin-right:10px;border: 1px solid #DCDFE6;"
                v-model="emergency.fPublishConfirmDate"
                placeholder="选择日期"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd HH:mm:ss"
                :disabled="active == 4 ? false : true">
              </el-date-picker>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 预案演练  -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-borderibht" > 预案演练 </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 演练概述： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="8"   placeholder="请输入内容" v-model="emergency.fDrillOutline" :disabled="active == 5 ? false : true">
          </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 80px;">
            <div  style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;"
                         class="upload-demo"
                          :before-upload = "beforeAvatarUpload"
                         :headers="GLOBAL.headers()"
                         :action="GLOBAL.httpUrl"
                         :on-preview="handlePreviewb"
                         :on-remove="handleRemoves"

                         multiple
                         :on-success="uploadedSuccesss"
                         :show-file-list="true"
                         :auto-upload="true"
                         :limit="1"
                         :on-exceed="handleExceed"
                         :file-list="fileList">
                <el-button size="small" type="primary" :disabled="active == 5 ? false : true">文件上传</el-button>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;">记录人：<el-input v-model="emergency.fDrillPeople"  placeholder="请输入内容" style="width:220px;border: 1px solid #DCDFE6;" :disabled="active == 5 ? false : true"></el-input></div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                  <el-date-picker
                    type="date" style="border: 1px solid #DCDFE6;"
                    v-model="emergency.fDrillDate"
                    placeholder="选择日期"
                    format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    :disabled="active == 5 ? false : true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 预案执行 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:455px;"> 预案执行 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 启动记录：</div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fExecutiveStartRecord" :disabled="active == 6 ? false : true"> </el-input>
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 执行过程：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fExecutiveProcessRecord" :disabled="active == 6 ? false : true"> </el-input>
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 终止记录：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergency.fExecutiveEndRecord" :disabled="active == 6 ? false : true"> </el-input>
          <div  style="width: 200px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;"
                       class="upload-demo"
                        :before-upload = "beforeAvatarUpload"
                       :headers="GLOBAL.headers()"
                       :action="GLOBAL.httpUrl"
                       :on-preview="handlePreviewc"
                       :on-remove="handleRemovess"

                       multiple
                       :on-success="uploadedSuccessss"
                       :show-file-list="true"
                       :auto-upload="true"
                       :limit="1"
                       :on-exceed="handleExceed"
                       :file-list="fileList">
              <el-button size="small" type="primary" :disabled="active == 5 ? false : true">文件上传</el-button>
            </el-upload>
          </div>
          <div  style="margin-top:20px;text-align:right;">
            <span >演练记录人：<el-input v-model="emergency.fExecutivePeople"  placeholder="请输入内容" style="width:180px;border: 1px solid #DCDFE6;" :disabled="active == 6 ? false : true"></el-input></span>
            <div class="block"  style="display:inline;margin-left:14px;">
              <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
              <el-date-picker
                type="date"
                style="width:220px;margin-right:10px;border: 1px solid #DCDFE6;"
                v-model="emergency.fExecutiveDate"
                placeholder="选择日期"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd HH:mm:ss"
                :disabled="active == 6 ? false : true">
              </el-date-picker>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import {getToken} from "@/utils/auth";
import { listPlanning, getPlanning, delPlanning, addPlanning, updatePlanning } from "@/api/emergency/emergency"
import {getUserList } from "@/api/security/planning"
//文件上传
import {getFileById} from "@/api/file";

import {
  planDataQuery
} from "@/api/emergency/emergency";
export default {

  data() {
    return {
      approvalPlanType:[],
      // 文件上传
      upload: {
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: "http://localhost/dev-api/file/upload"
      },
      //当前状态
      active:1,

      //审核结果 列表
      fReviewResultList:[
        { value: 1, label: '通过' },
        { value: 2, label: '不通过' },
        { value: 3, label: '驳回' },
      ],
      //下一处理人
      radio:'',
      info: {
        stockDate:this.getNowTime(),  //日期
      },

      dialogVisible:false,

      textarea:'',
      value1: '',
      value2: '',
      value3: '',
      value4: '',
      value: '',

      //处理人 弹窗
      nextVisible:false,
      //文件显示 列表
      fileList: [],
      fileListb: [],
      fileListc: [],
      fileLista: [],

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
      //预案编制对象
      emergency: {
        //预案编制ID
        fId:'',
        //预案分类
        fPlanType:'',
        //预案名称
        fPlanName:'',
        //预案编号
        fPlanNumber:'',
        //发布开始时间
        fPublishStartDate:'',
        //发布结束时间
        fPublishEndDate:'',
        //预案概述
        fPlanSummary:'',
        //编制时间
        fPreparationTime:'',
        //编制人
        fPreparedBy:'',

        //预案文件ID
        fPlanFileId:'',

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
        //审批文件ID
        fAuditFileId:'',

        //发布内容
        fPublishContent:'',
        //发布人
        fPublishPeople:'',
        //发布确认时间
        fPublishConfirmDate:'',

        //演练概述
        fDrillOutline:'',
        //演练文件ID
        fDrillFileId:'',
        //演练记录人
        fDrillPeople:'',
        //演练时间
        fDrillDate:'',

        //执行启动记录
        fExecutiveStartRecord:'',
        //执行过程
        fExecutiveProcessRecord:'',
        //执行终止记录
        fExecutiveEndRecord:'',
        //执行文件ID
        fExecutiveFileId:'',
        //执行记录人
        fExecutivePeople:'',
        //执行时间
        fExecutiveDate:'',


        //流程实例ID
        fActId:'',
        //下一节点审核人
        fActPersion:'',
        //流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除
        fActStatus:'',
        //流程节点
        fActNode:'',

        //创建人
        fCreateBy:'',
        //创建时间
        fCreateTime:'',

      },
      //预案编制对象
      emergencyInit: {
        //预案编制ID
        fId:'',
        //预案分类
        fPlanType:'',
        //预案名称
        fPlanName:'',
        //预案编号
        fPlanNumber:'',
        //发布开始时间
        fPublishStartDate:'',
        //发布结束时间
        fPublishEndDate:'',
        //预案概述
        fPlanSummary:'',
        //编制时间
        fPreparationTime:'',
        //编制人
        fPreparedBy:'',

        //预案文件ID
        fPlanFileId:'',

        //审核意见
        fReviewComments:'',
        //审核结果
        fReviewResult:'',
        //审核人
        fReviewPeople:'',
        //审核时间
        fReviewDate:'',
        //审批文件ID
        fAuditFileId:'',

        //审批意见
        fAuditComments:'',
        //审批结果
        fAuditResult:'',
        //审批人
        fAuditPeople:'',
        //审批时间
        fAuditDate:'',

        //发布内容
        fPublishContent:'',
        //发布人
        fPublishPeople:'',
        //发布确认时间
        fPublishConfirmDate:'',

        //演练概述
        fDrillOutline:'',
        //演练文件ID
        fDrillFileId:'',
        //演练记录人
        fDrillPeople:'',
        //演练时间
        fDrillDate:'',

        //执行启动记录
        fExecutiveStartRecord:'',
        //执行过程
        fExecutiveProcessRecord:'',
        //执行终止记录
        fExecutiveEndRecord:'',
        //执行文件ID
        fExecutiveFileId:'',
        //执行记录人
        fExecutivePeople:'',
        //执行时间
        fExecutiveDate:'',


        //流程实例ID
        fActId:'',
        //下一节点审核人
        fActPersion:'',
        //流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除
        fActStatus:'',
        //流程节点
        fActNode:'',

        //创建人
        fCreateBy:'',
        //创建时间
        fCreateTime:'',

      },
      //作为子组件时 状态
      status:0,
    };
  },
  created() {
    this.personnel()
    this.dataQuery()
  },
  methods: {

    dataQuery() {
      var query = { dictType: 'Plan_Classification' }
      planDataQuery(query).then(res => {
        if (res.code == 200) {
          this.approvalPlanType = res.data
        }
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
	    window.open(this.fileList[0].url);
    },
    handlePreviewa(file) {
      console.log(file);
      window.open(this.fileLista[0].url);
    },
    handlePreviewb(file) {
      console.log(file);
      window.open(this.fileListb[0].url);
    },
    handlePreviewc(file) {
      console.log(file);
      window.open(this.fileListc[0].url);
    },
    handleRemove(file, fileList) {
      this.GLOBAL.commonFun(this.emergency.fPlanFileId);
    },
    //预案演练文件上传后
    handleRemoves(file, fileList) {
      this.GLOBAL.commonFun(this.emergency.fDrillFileId);
    },
    //预案执行文件上传后
    handleRemovess(file, fileList) {
      this.GLOBAL.commonFun(this.emergency.fExecutiveFileId);
    },
    //批准信息文件上传后
    handleRemovesss(file, fileList) {
      this.GLOBAL.commonFun(this.emergency.fExecutiveFileId);
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
      this.emergency.fPlanFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileList = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //预案演练上传成功
    uploadedSuccesss(response, file, fileList) {
      this.emergency.fDrillFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileListb = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //预案执行上传成功
    uploadedSuccessss(response, file, fileList) {
      this.emergency.fExecutiveFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileListc = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //批准信息上传成功
    uploadedSuccesssss(response, file, fileList) {
      this.emergency.fAuditFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileLista = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },

    //获取处理人集合
    personnel(){
      console.log('获取处理人集合')
      getUserList().then(response => {
        console.log('获取处理人集合执行成功',response)
        this.list = response.data
      })
    },
    init() {
      console.log('初始化')
      if( this.status == 1 ) {
        console.log('初始化',this.emergencyPass)

        //查询是否 为暂存
        if(this.emergencyPass.fActStatus == 0) {
          this.active = 1
          console.log("为暂存")
        }
        //查询是否  为待审核
        else if(this.emergencyPass.fActStatus == 1){
          this.active = 2
          console.log("为待审核")
        }
        //查询是否  为待批准
        else if(this.emergencyPass.fActStatus == 2){
          this.active = 3
          console.log("为待审核批准")
        }
        //查询是否  为待发布
        else if(this.emergencyPass.fActStatus == 3){
          this.active = 4
          console.log("为待发布")
        }
        //查询是否  已发布
        else if(this.emergencyPass.fActStatus == 4){
          this.active = 5
          console.log("已发布")
        }
        //查询是否  为驳回
        else if(this.emergencyPass.fActStatus == 5){
          this.active = 0
          console.log("为驳回")
        }
        //查询是否  不同意删除
        else if(this.emergencyPass.fActStatus == 6){
          this.active = 5
          console.log("不同意删除")
        }
      }

    },
    //提交 表单 （第一次创建 提交）
    submitEmergency() {
      //是否填写 预案名称
      if(this.emergency.fPlanName == null || this.emergency.fPlanName == '') {
        this.$message({
          showClose: true,
          message: '请填写预案名称',
          type: 'error'
        });
        return false
      }
      //是否填写 预案编号
      if(this.emergency.fPlanNumber == null || this.emergency.fPlanNumber == '') {
        this.$message({
          showClose: true,
          message: '请填写预案编号',
          type: 'error'
        });
        return false
      }
      //是否填写 发布开始时间
      if(this.emergency.fPublishStartDate == null || this.emergency.fPublishStartDate == '') {
        this.$message({
          showClose: true,
          message: '请选择发布开始时间',
          type: 'error'
        });
        return false
      }
      //是否填写 发布结束时间
      if(this.emergency.fPublishEndDate == null || this.emergency.fPublishEndDate == '') {
        this.$message({
          showClose: true,
          message: '请选择发布结束时间',
          type: 'error'
        });
        return false
      }
      //是否填写 预案概述
      if(this.emergency.fPlanSummary == null || this.emergency.fPlanSummary == '') {
        this.$message({
          showClose: true,
          message: '请填写预案概述',
          type: 'error'
        });
        return false
      }
      //是否填写 编制时间
      if(this.emergency.fPreparationTime == null || this.emergency.fPreparationTime == '') {
        this.$message({
          showClose: true,
          message: '请选择编制时间',
          type: 'error'
        });
        return false
      }
      //是否填写 编制人
      if(this.emergency.fPreparedBy == null || this.emergency.fPreparedBy == '') {
        this.$message({
          showClose: true,
          message: '请填写编制人',
          type: 'error'
        });
        return false
      }

      this.addSubmits();

    },
    //选择处理人 弹窗 确定按钮
    addSubmits() {
      //将状态 设为 审核中
      this.emergency.fActStatus = 1
      this.emergency.fActPersion = this.radio
      //判断完  提交表单
      addPlanning(this.emergency).then(res => {
        if( res.code == 200 ) {
          this.msgSuccess("预案编制提交成功");
          this.init()
          this.emergency = this.emergencyInit
          this.fileList = []
          this.nextVisible = false
        }
      })
    },
    //暂存 表单
    temporaryStorage() {
      //将状态 设为 暂存
      this.emergency.fActStatus = 0
      // 提交表单  暂存
      addPlanning(this.emergency).then(res => {
        if( res.code == 200 ) {
          this.msgSuccess("预案编制保存成功");
          this.emergency = this.emergencyInit
          this.fileList = []
        }
      })
    },
    dialog(){
      this.dialogVisible = true
    },
    //获得当前时间
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
  }
};
</script>
<style lang="scss" >
.color409 {
  color: #409eff;
  cursor: pointer;
}
  .el-upload-list__item .el-icon-close-tip {
      top: 100000px;
      z-index: -98;
  }




</style>
