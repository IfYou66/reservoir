<template>
  <div class="app-container">

    <!-- 子组件 -->
    <!-- 顶部流程箭头 -->
    <el-row class="from-top">
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img style="width: 100%;height: 45px;" src="../../../assets/images/jin.png" />
            <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.编制</div>
          </div>
          <div style="position: relative;">
            <img
              style="width: 100%;height: 45px;" :src="require((emergencyPass.fActStatus >= 1 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              style="width: 100%;height: 45px;" :style="(emergencyPass.fActStatus >= 1 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              2.审核</div>
          </div>
          <div style="position: relative;">
            <img
              style="width: 100%;height: 45px;" :src="require((emergencyPass.fActStatus >= 2 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              :style="(emergencyPass.fActStatus >= 2 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              3.批准</div>
          </div>
          <div style="position: relative;">
            <img
              style="width: 100%;height: 45px;" :src="require((emergencyPass.fActStatus >= 3 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              style="width: 100%;height: 45px;" :style="(emergencyPass.fActStatus >= 3 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              4.发布</div>
          </div>
          <div style="position: relative;">
            <img
              style="width: 100%;height: 45px;" :src="require((emergencyPass.fActStatus >= 4 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              style="width: 100%;height: 45px;" :style="(emergencyPass.fActStatus >= 4 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              5.演练</div>
          </div>
          <div style="position: relative;">
            <img
              style="width: 100%;height: 45px;" :src="require((emergencyPass.fActStatus >= 5 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div
              style="width: 100%;height: 45px;" :style="(emergencyPass.fActStatus >= 5 && emergencyPass.fActStatus <= 6) || emergencyPass.fActStatus == 6? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              6.执行</div>
          </div>
        </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div style="margin-right: 10px">
          <el-button type="primary" size="small" @click="editFormVisible2 = false">取消</el-button>
          <el-button type="primary" size="small" @click="tijiao">提交</el-button>
        </div>
      </el-col>
    </el-row>

    <!-- 子组件 -->
    <div class="from-div">

      <!-- 头部 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
            <!-- 第一次创建 提交按钮 -->
            <el-button type="primary" size="small" @click="temporaryStorage" v-if="status = 0">暂 存</el-button>
            <!-- 第一次创建 提交按钮 -->
            <el-button type="primary" size="small" @click="submitemergency" v-if="status = 0">提 交</el-button>


          </div>
        </el-col>
      </el-row>

      <!-- 表 标题 -->
      <el-row>
        <el-col :span="24" class="from-div-title">
          水库预案编制审批表
        </el-col>
      </el-row>

      <!-- 提交填写  -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col-left"> 预案名称 </el-col>
        <el-col :span="4" class="from-border-right">
          <el-input v-model="emergencyPass.fPlanName" placeholder="请输入内容"
                    :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true"></el-input>
        </el-col>

        <el-col :span="2" class="from-col-left"> 预案编号 </el-col>
        <el-col :span="2" class="from-border-right">
          <el-input v-model="emergencyPass.fPlanNumber" placeholder="请输入内容"
                    :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true"></el-input>
        </el-col>

        <el-col :span="2" class="from-col-left" > 预案分类 </el-col>
        <el-col :span="2" class="from-border-right" >
          <div>
            <el-select v-model="emergencyPass.fPlanType" placeholder="请选择" :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true">
              <el-option v-for="item in approvalPlanType" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </div>
        </el-col>

        <el-col :span="3" class="from-col-left"> 发布时间 </el-col>
        <el-col :span="6" style="text-align: center ;line-height: 40px;">
          <el-date-picker v-model="emergencyPass.fPublishStartDate" type="date" value-format="yyyy-MM-dd"
                          style="width: 44%;" placeholder="开始时间"
                          :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true"> </el-date-picker>
          ~
          <el-date-picker v-model="emergencyPass.fPublishEndDate" type="date" value-format="yyyy-MM-dd"
                          style="width: 44%;" placeholder="结束时间"
                          :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true"> </el-date-picker>
        </el-col>
      </el-row>

      <!-- 提交填写  -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-borderibht"> 预案概述 </el-col>
        <el-col :span="21" style="height: 400px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 预案概述： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="8" placeholder="请输入内容" v-model="emergencyPass.fPlanSummary"
                    :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true">
          </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 80px;">
            <div style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: -20px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                         :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                         multiple :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1"
                         :on-exceed="handleExceed" :file-list="fileList">
                <el-button size="small" type="primary"
                           v-if=" emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ">文件上传</el-button>
                <div slot="tip" class="el-upload__tip" style="margin-top: 15px" v-if=" emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 5 ">上传文件不得超过100M</div>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;">编制人：<el-input v-model="emergencyPass.fPreparedBy" placeholder="请输入内容"
                                                           style="width:220px;border: 1px solid #DCDFE6;" :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true"></el-input>
                </div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" style="border: 1px solid #DCDFE6;"
                                  v-model="emergencyPass.fPreparationTime" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                                  value-format="yyyy-MM-dd HH:mm:ss" :disabled="emergencyPass.fActStatus == 0 || emergencyPass.fActStatus == 7 ? false : true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 审核填写 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:188px;"> 审核信息 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审核意见： </div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fReviewComments"
                    :disabled="emergencyPass.fActStatus == 1 ? false : true"> </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审核结果： </div>
              <el-select v-model="emergencyPass.fReviewResult" placeholder="请选择"
                         :disabled="emergencyPass.fActStatus == 1 ? false : true">
                <el-option v-for="item in fReviewResultList" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div style="margin-top:20px;">
              <span>审核人：<el-input v-model="emergencyPass.fReviewPeople" placeholder="请输入内容" style="width:180px;"
                                  :disabled="emergencyPass.fActStatus == 1 ? false : true"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker type="date" v-model="emergencyPass.fReviewDate" placeholder="选择日期"
                                format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                                :disabled="emergencyPass.fActStatus == 1 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 批准填写 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:275px;"> 批准信息 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 审批意见：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fAuditComments"
                    :disabled="emergencyPass.fActStatus == 2 ? false : true"> </el-input>
          <div  style="width: 200px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;"
                       class="upload-demo"
                        :before-upload = "beforeAvatarUpload"
                       :headers="GLOBAL.headers()"
                       :action="GLOBAL.httpUrl"
                       :on-preview="handlePreview1"
                       :on-remove="handleRemovesss"

                       multiple
                       :on-success="uploadedSuccesssss"
                       :show-file-list="true"
                       :auto-upload="true"
                       :limit="1"
                       :on-exceed="handleExceed"
                       :file-list="fileList2">
              <el-button size="small" type="primary" :disabled="emergencyPass.fActStatus == 2 ? false : true">文件上传</el-button>
            </el-upload>
          </div>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;"> 审批结果： </div>
              <el-select v-model="emergencyPass.fAuditResult" placeholder="请选择"
                         :disabled="emergencyPass.fActStatus == 2 ? false : true">
                <el-option v-for="item in fReviewResultList" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>

            <div style="margin-top:20px;">
              <span>审批人：<el-input v-model="emergencyPass.fAuditPeople" placeholder="请输入内容" style="width:180px;"
                                  :disabled="emergencyPass.fActStatus == 2 ? false : true"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker type="date" v-model="emergencyPass.fAuditDate" placeholder="选择日期"
                                format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                                :disabled="emergencyPass.fActStatus == 2 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 发布填写 -->
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:188px;"> 预案发布 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 预案发布：</div>
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fPublishContent"
                    :disabled="emergencyPass.fActStatus == 3 ? false : true"> </el-input>
          <div style="margin-top:20px;text-align:right;">
            <span>发布人：<el-input v-model="emergencyPass.fPublishPeople" placeholder="请输入内容"
                                style="width:180px;border: 1px solid #DCDFE6;" :disabled="emergencyPass.fActStatus == 3 ? false : true">
              </el-input></span>
            <div class="block" style="display:inline;margin-left:14px;">
              <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
              <el-date-picker type="date" style="width:220px;margin-right:10px;border: 1px solid #DCDFE6;"
                              v-model="emergencyPass.fPublishConfirmDate" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                              value-format="yyyy-MM-dd HH:mm:ss" :disabled="emergencyPass.fActStatus == 3 ? false : true">
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
          <el-input type="textarea" :rows="8"   placeholder="请输入内容" v-model="emergencyPass.fDrillOutline" :disabled="emergencyPass.fActStatus == 4 ? false : true">
          </el-input>

          <div style="display:flex;justify-content:space-between;margin-top: 60px;">
            <div  style="width: 200px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;"
                         class="upload-demo"
                          :before-upload = "beforeAvatarUpload"
                         :headers="GLOBAL.headers()"
                         :action="GLOBAL.httpUrl"
                         :on-preview="handlePreview2"
                         :on-remove="handleRemoves"

                         multiple
                         :on-success="uploadedSuccesss"
                         :show-file-list="true"
                         :auto-upload="true"
                         :limit="1"
                         :on-exceed="handleExceed"
                         :file-list="fileList3">
                <el-button size="small" type="primary" :disabled="emergencyPass.fActStatus == 4 ? false : true">文件上传</el-button>
              </el-upload>
            </div>

            <div style="font-size: 20px;margin-right: 10px;margin-top: -5px;">
              <div style="text-align: left">
                <div style="display:inline;">演练记录人：<el-input v-model="emergencyPass.fDrillPeople"  placeholder="请输入内容" style="width:220px;border: 1px solid #DCDFE6;" :disabled="emergencyPass.fActStatus == 4 ? false : true"></el-input></div>
                <div class="block" style="transform:translateY(10%)">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
                  <el-date-picker
                    type="date" style="border: 1px solid #DCDFE6;"
                    v-model="emergencyPass.fDrillDate"
                    placeholder="选择日期"
                    format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    :disabled="emergencyPass.fActStatus == 4 ? false : true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <!-- 预案执行 -->
      <el-row  class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:500px;"> 预案执行 </el-col>
        <el-col :span="21" style="height: 70px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 启动记录：</div>
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fExecutiveStartRecord" :disabled="emergencyPass.fActStatus == 5 ? false : true"> </el-input>
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 执行过程：</div>
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fExecutiveProcessRecord" :disabled="emergencyPass.fActStatus == 5 ? false : true"> </el-input>
          <div style="font-size: 16px;font-weight: 700;padding: 10px;"> 终止记录：</div>
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="emergencyPass.fExecutiveEndRecord" :disabled="emergencyPass.fActStatus == 5 ? false : true"> </el-input>
          <div  style="width: 200px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;"
                       class="upload-demo"
                        :before-upload = "beforeAvatarUpload"
                       :headers="GLOBAL.headers()"
                       :action="GLOBAL.httpUrl"
                       :on-preview="handlePreview3"
                       :on-remove="handleRemovess"

                       multiple
                       :on-success="uploadedSuccessss"
                       :show-file-list="true"
                       :auto-upload="true"
                       :limit="1"
                       :on-exceed="handleExceed"
                       :file-list="fileList4">
              <el-button size="small" type="primary" :disabled="emergencyPass.fActStatus == 5 ? false : true">文件上传</el-button>
            </el-upload>
          </div>
          <div  style="margin-top:20px;text-align:right;">
            <span >执行记录人：<el-input v-model="emergencyPass.fExecutivePeople"  placeholder="请输入内容" style="width:180px;border: 1px solid #DCDFE6;" :disabled="emergencyPass.fActStatus == 5 ? false : true"></el-input></span>
            <div class="block"  style="display:inline;margin-left:14px;">
              <span class="demonstration" v-html="'时&ensp;&ensp;间：'"/>
              <el-date-picker
                type="date"
                style="width:220px;margin-right:10px;border: 1px solid #DCDFE6;"
                v-model="emergencyPass.fExecutiveDate"
                placeholder="选择日期"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd HH:mm:ss"
                :disabled="emergencyPass.fActStatus == 5 ? false : true">
              </el-date-picker>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import {
  listPlanning,
  getPlanning,
  delPlanning,
  addPlanning,
  updatePlanning
} from "@/api/emergency/emergency"
import {
  getUserList
} from "@/api/security/planning"
//文件上传
import {
  getFileById
} from "@/api/file"
import {
  getToken
} from "@/utils/auth"

import {
  planDataQuery
} from "@/api/emergency/emergency";
export default {

  props: ['emergencyPass', 'status', 'fileList', 'fileList2', 'fileList3', 'fileList4'],
  data() {
    return {

      approvalPlanType:[
        {
          value:0,
          label:'水库大坝管理运行预案'
        },
        {
          value:1,
          label:'水库防汛抢险应急预案'
        },
        {
          value:2,
          label:'水库防御洪水预案'
        },
        {
          value:3,
          label:'其他预案'
        },
      ],
      //当前状态
      active: 1,

      //审核结果 列表
      fReviewResultList: [{
        value: 1,
        label: '通过'
      },
        {
          value: 2,
          label: '不通过'
        },
        {
          value: 3,
          label: '驳回'
        },
      ],
      //下一处理人
      radio: '',
      dialogVisible: false,

      textarea: '',
      value1: '',
      value2: '',
      value3: '',
      value4: '',
      value: '',

      //预案编制对象
      emergency: {
        //预案编制ID
        fId: '',
        //预案类型
        fPlanType:'',
        //预案名称
        fPlanName: '',
        //预案编号
        fPlanNumber: '',
        //发布开始时间
        fPublishStartDate: '',
        //发布结束时间
        fPublishEndDate: '',
        //预案概述
        fPlanSummary: '',
        //编制时间
        fPreparationTime: '',
        //编制人
        fPreparedBy: '',

        //预案文件ID
        fPlanFileId: '',

        //审核意见
        fReviewComments: '',
        //审核结果
        fReviewResult: '',
        //审核人
        fReviewPeople: '',
        //审核时间
        fReviewDate: '',

        //审批意见
        fAuditComments: '',
        //审批结果
        fAuditResult: '',
        //审批人
        fAuditPeople: '',
        //审批时间
        fAuditDate: '',
        //审批文件ID
        fAuditFileId:'',

        //发布内容
        fPublishContent: '',
        //发布人
        fPublishPeople: '',
        //发布确认时间
        fPublishConfirmDate: '',

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
        fActId: '',
        //下一节点审核人
        fActPersion: '',
        //流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除
        fActStatus: '',
        //流程节点
        fActNode: '',

        //创建人
        fCreateBy: '',
        //创建时间
        fCreateTime: '',

      },
      //预案编制对象
      emergencyInit: {
        //预案编制ID
        fId: '',
        //预案分类
        fPlanType:'',
        //预案名称
        fPlanName: '',
        //预案编号
        fPlanNumber: '',
        //发布开始时间
        fPublishStartDate: '',
        //发布结束时间
        fPublishEndDate: '',
        //预案概述
        fPlanSummary: '',
        //编制时间
        fPreparationTime: '',
        //编制人
        fPreparedBy: '',

        //预案文件ID
        fPlanFileId: '',

        //审核意见
        fReviewComments: '',
        //审核结果
        fReviewResult: '',
        //审核人
        fReviewPeople: '',
        //审核时间
        fReviewDate: '',

        //审批意见
        fAuditComments: '',
        //审批结果
        fAuditResult: '',
        //审批人
        fAuditPeople: '',
        //审批时间
        fAuditDate: '',
        //审批文件ID
        fAuditFileId:'',

        //发布内容
        fPublishContent: '',
        //发布人
        fPublishPeople: '',
        //发布确认时间
        fPublishConfirmDate: '',

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
        fActId: '',
        //下一节点审核人
        fActPersion: '',
        //流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除
        fActStatus: '',
        //流程节点
        fActNode: '',

        //创建人
        fCreateBy: '',
        //创建时间
        fCreateTime: '',

      },
      //作为子组件时 状态
      status: 0,
      nextVisible: false,
    };
  },
  created() {
  },
  methods: {

    tijiao(){
      this.$emit('show', "");
    },
    beforeAvatarUpload(file){
          const isLt100M = file.size / 1024 / 1024 < 100;
             if (!isLt100M) {
                    this.$message.error('上传文件大小不能超过 100MB!');
                    return false
                }
          },
    init() {
      console.log('初始化')
      if (this.status == 1) {
        console.log('初始化', this.emergencyPass)

        //查询是否 为暂存
        if (this.emergencyPass.fActStatus == 0) {
          this.active = 1
          console.log("为暂存")
        }
        //查询是否  为待审核
        else if (this.emergencyPass.fActStatus == 1) {
          this.active = 2
          console.log("为待审核")
        }
        //查询是否  为待批准
        else if (this.emergencyPass.fActStatus == 2) {
          this.active = 3
          console.log("为待审核批准")
        }
        //查询是否  为待发布
        else if (this.emergencyPass.fActStatus == 3) {
          this.active = 4
          console.log("为待发布")
        }
        //查询是否  已发布
        else if (this.emergencyPass.fActStatus == 4) {
          this.active = 5
          console.log("已发布")
        }
        //查询是否  为驳回
        else if (this.emergencyPass.fActStatus == 5) {
          this.active = 0
          console.log("为驳回")
        }
        //查询是否  不同意删除
        else if (this.emergencyPass.fActStatus == 6) {
          this.active = 5
          console.log("不同意删除")
        }
      }

    },
    //提交 表单 （第一次创建 提交）
    submitEmergency() {
      //是否填写 预案名称
      if (this.emergencyPass.fPlanName == null || this.emergencyPass.fPlanName == '') {
        this.$message({
          showClose: true,
          message: '请填写预案名称',
          type: 'error'
        });
        return false
      }
      //是否填写 预案编号
      if (this.emergencyPass.fPlanNumber == null || this.emergencyPass.fPlanNumber == '') {
        this.$message({
          showClose: true,
          message: '请填写预案编号',
          type: 'error'
        });
        return false
      }
      //是否填写 发布开始时间
      if (this.emergencyPass.fPublishStartDate == null || this.emergencyPass.fPublishStartDate == '') {
        this.$message({
          showClose: true,
          message: '请选择发布开始时间',
          type: 'error'
        });
        return false
      }
      //是否填写 发布结束时间
      if (this.emergencyPass.fPublishEndDate == null || this.emergencyPass.fPublishEndDate == '') {
        this.$message({
          showClose: true,
          message: '请选择发布结束时间',
          type: 'error'
        });
        return false
      }
      //是否填写 预案概述
      if (this.emergencyPass.fPlanSummary == null || this.emergencyPass.fPlanSummary == '') {
        this.$message({
          showClose: true,
          message: '请填写预案概述',
          type: 'error'
        });
        return false
      }
      //是否填写 编制时间
      if (this.emergencyPass.fPreparationTime == null || this.emergencyPass.fPreparationTime == '') {
        this.$message({
          showClose: true,
          message: '请选择编制时间',
          type: 'error'
        });
        return false
      }
      //是否填写 编制人
      if (this.emergencyPass.fPreparedBy == null || this.emergencyPass.fPreparedBy == '') {
        this.$message({
          showClose: true,
          message: '请填写编制人',
          type: 'error'
        });
        return false
      }
      //将状态 设为 审核中
      this.emergencyPass.fActStatus = 1
      this.nextVisible = true

    },
    //选择处理人 弹窗 确定按钮
    addSubmits() {
      //判断是否 选择了下一处理人
      if (this.radio == '') {
        this.$message({
          showClose: true,
          message: '请选择审批人',
          type: 'error'
        });
        return false
      }
      this.emergencyPass.fActPersion = this.radio
      //判断完  提交表单
      addPlanning(this.emergencyPass).then(res => {
        if (res.code == 200) {
          this.msgSuccess("预案编制提交成功");
          this.init()
          this.emergencyPass = this.emergencyInit
          this.nextVisible = false
        }
      })
    },
    //暂存 表单
    temporaryStorage() {
      //将状态 设为 暂存
      this.emergencyPass.fActStatus = 0
      // 提交表单  暂存
      addPlanning(this.emergencyPass).then(res => {
        if (res.code == 200) {
          this.msgSuccess("预案编制暂存成功");
          this.emergencyPass = this.emergencyInit
        }
      })
    },
    dialog() {
      this.dialogVisible = true
    },
    handlePreview(file) {
      // window.location.href = this.fileList[0].url;
	  window.open(this.fileList[0].url);
    },
    handlePreview1(file) {
      // window.location.href = this.fileList1[0].url;
      window.open(this.fileList2[0].url);
    },
    handlePreview2(file) {
      // window.location.href = this.fileList3[0].url;
      window.open(this.fileList3[0].url);
    },
    handlePreview3(file) {
      // window.location.href = this.fileList4[0].url;
      window.open(this.fileList4[0].url);
    },
    handleRemove(file, fileList) {
      this.GLOBAL.commonFun(this.emergencyPass.fPlanFileId);
      console.log(file, fileList);
    },
    //预案演练文件上传后
    handleRemoves(file, fileList) {
      this.GLOBAL.commonFun(this.emergencyPass.fDrillFileId);
    },
    //预案执行文件上传后
    handleRemovess(file, fileList) {
      this.GLOBAL.commonFun(this.emergencyPass.fExecutiveFileId);
    },
    //批准信息文件上传后
    handleRemovesss(file, fileList) {
      this.GLOBAL.commonFun(this.emergencyPass.fExecutiveFileId);
    },
    //删除文件的
    beforeRemove(file, fileList) {
      if (this.emergencyPass.fActStatus != 0 &&
        this.emergencyPass.fActStatus != 5) {
        this.$message.warning(`当前状态无法删除文件`)
        return false
      }
      return this.$confirm(`确定移除 ${file.name}？`);
    },

    //上传数量 限制
    handleExceed(files, fileList) {
      // fileList[0].url
    },
    //上传成功
    uploadedSuccess(response, file, fileList) {
      this.emergencyPass.fPlanFileId = response.data.fId
      this.fileList = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //预案演练上传成功
    uploadedSuccesss(response, file, fileList) {
      this.emergencyPass.fDrillFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileList3 = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //预案执行上传成功
    uploadedSuccessss(response, file, fileList) {
      this.emergencyPass.fExecutiveFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileList4 = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
    //批准信息上传成功
    uploadedSuccesssss(response, file, fileList) {
      this.emergencyPass.fAuditFileId = response.data.fId
      this.msgSuccess("上传成功")
      this.fileList2 = [{
        name:response.data.fOldFileName,
        url:response.data.fFilePath
      }]
    },
  }
};
</script>
<style lang="scss">
.color409 {
  color: #409eff;
  cursor: pointer;
}
  .el-upload-list__item .el-icon-close-tip {
      top: 100000px;
      z-index: -98;
  }
</style>
