<template>
  <div class="app-container">
    <el-row class="from-top">
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;width: 100%;justify-content:center;">
          <div style="position: relative;">
            <img src="../../../assets/images/jin.png" />
            <div style="position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;">1.编制</div>
          </div>
          <div style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">2.审核</div>
          </div>
          <div style="position: relative;">
            <img :src="require(active==3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">3.审批</div>
          </div>
        </div>
      </el-col>
    </el-row>
    <!-- 页面主体 -->
    <div class="from-div">
      <!-- 头部 注册登记 审核提交 按钮 -->
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
            <el-button type="primary" size="small" @click="zhuce" v-if="status <= 0">{{this.status == 0 ? '注册登记':'修改'}}</el-button>
            <el-button type="primary" size="small" v-if="status == 1" @click="auditPass">审核提交</el-button>
            <el-button type="primary" size="small" v-if="status == 2" @click="auditApprove">审批提交</el-button>
          </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="24" class="from-div-title">
          <div>水库大坝注册登记表</div>
          <div>
            <registrationDetail :type="1" :input="input" :time='time' :status="status" v-if="status >= -1" :ifXian="0"></registrationDetail>
          </div>



        </el-col>
      </el-row>
      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col" style="line-height:200px;">
          计划审核
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审核意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="4" placeholder="请输入内容" v-model="input.fReviewComments" v-bind:disabled="status == 1 ? false : true">
          </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 600;display:inline;">
                审核结果：
              </div>
              <el-select v-model="input.fReviewResult" placeholder="请选择" v-bind:disabled="status == 1 ? false : true">
                  <el-option v-bind:disabled="status == 1 ? false : true" v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div style="margin-top:20px;">
              <span>审核人：<el-input v-model="input.fReviewPeople" placeholder="审核人" style="width:180px;" v-bind:disabled="status == 1 ? false : true"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker v-bind:disabled="status == 1 ? false : true" type="date" v-model="input.fReviewDate"
                  placeholder="选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="3" class="from-align" style="line-height:200px;">
          计划批准
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审批意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="4" placeholder="请输入内容" v-model="input.fAuditComments" v-bind:disabled="this.status ==2 ? false : true">
          </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 600;display:inline;">
                审批结果：
              </div>
              <el-select v-model="value4" placeholder="请选择" v-bind:disabled="status == 2 ? false : true">
                <!-- <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"
                  v-bind:disabled="status ==2 ?  false: true">
                </el-option> -->
                <el-option v-bind:disabled="status == 2 ? false : true" v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div style="margin-top:20px;">
              <span>审批人：<el-input v-model="input.fAuditPeople" placeholder="审批人" style="width:180px;" v-bind:disabled="status ==2 ? false : true"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker type="date" v-model="input.fAuditDate" placeholder="选择日期" format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd" v-bind:disabled="status ==2 ? false : true">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

    <!-- 审核弹窗 -->
    <el-dialog title="详情" :visible.sync="dialogVisible" width="1500px">
      <div class="from-div">
        <el-row >
          <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
            <div style="margin-right: 15px">
              <el-button size="small"  @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" size="small"  @click="dialogVisible = false">确 定</el-button>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24" class="from-div-title">
            <div>水库大坝注册登记表</div>
            <div>
              <registrationDetail :ifXian="0" :type="1" :input="inputCheck" :time='time' :status="status"></registrationDetail>
            </div>
          </el-col>
        </el-row>
        <el-row class="from-border-bottom">
          <el-col :span="3" class="from-col" style="line-height:200px;">
            计划审核
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审核意见：
            </div>
            <el-input  maxlength="500" show-word-limit disabled  type="textarea" :rows="4" placeholder="请输入内容" v-model="inputCheck.fReviewComments">
            </el-input>
            <div class="from-select">
              <div style="margin-top: 20px;margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 600;display:inline;">
                  审核结果：
                </div>
                <el-select v-model="inputCheck.fReviewResult" placeholder="请选择" disabled>
                  <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div style="margin-top:20px;">
                <span>审核人：<el-input v-model="inputCheck.fReviewPeople" disabled placeholder="审核人" style="width:180px;"></el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" v-model="inputCheck.fReviewDate" placeholder="选择日期" format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd" disabled>
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="3" class="from-align" style="line-height:200px;">
            计划批准
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审批意见：
            </div>
            <el-input  maxlength="500" show-word-limit disabled  type="textarea" :rows="4" placeholder="请输入内容" v-model="inputCheck.fAuditComments">
            </el-input>
            <div class="from-select">
              <div style="margin-top: 20px;margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 600;display:inline;">
                  审批结果：
                </div>
                <el-select v-model="inputCheck.fAuditResult" placeholder="请选择" disabled>
                  <el-option v-for="item in dict.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div style="margin-top:20px;">
                <span>审批人：<el-input disabled v-model="inputCheck.fAuditPeople" placeholder="审批人" style="width:180px;"></el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" v-model="inputCheck.fAuditDate" placeholder="选择日期" format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd" disabled>
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>



      <!-- <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span> -->
    </el-dialog>

    <!-- 下一流程 处理人 弹窗 -->
    <!-- <el-dialog title="选择处理人" :visible.sync="nextVisible" width="30%" >
      <el-radio v-model="radio" :label="item.userId" v-for="(item,index) in list" :key="index">{{item.nickName}}</el-radio>
      <el-radio v-model="radio" label="2">备选项</el-radio>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSubmits">确 定</el-button>
      </span>
    </el-dialog> -->

    <!-- 注册登记弹窗 -->
    <el-dialog title="详情" :visible.sync="zhuceVisible" width="1500px">
      <registrationDetail @submitInput="submitInput" @reviseInput="reviseInput" @zhuceVisible="zhuceVisiblefalse"  :type="0" :input="this.input" :time='this.time' :status="status" :ifXian="1"></registrationDetail>
      <!-- <span slot="footer" class="dialog-footer">
        <el-button @click="zhuceVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitInput()" v-if="status ==  0">提 交</el-button>
        <el-button type="primary" @click="reviseInput()" v-if="status == -1">修 改</el-button>
      </span> -->
    </el-dialog>

    <!-- 注册登记编制记录 -->
    <div class="from-div" style="border: 0px">
      <div class="table-head" style="margin-top:40px;margin:0 auto;width:100%">
        注册登记编制记录
      </div>
      <el-table :data="data" class="from-top" border style="margin:0 auto;width:100%">
        <el-table-column label="序号" align="center">
          <template slot-scope="scope">
            {{ scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column label="变更时间" align="center" prop="fPreparationTime" />
        <el-table-column label="编制人" align="center" prop="fPreparedBy" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button size="mini" type="text" @click="check(scope.row)">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  //mengineeringInformation

  import {
    getUserList
  } from "@/api/security/planning"

  import {
    listInformation,
    getInformation,
    addInformation,
    updateInformation,
    delInformation
  } from "@/api/security/mengineeringInformation"
import {
  queryDataDictionary
} from "@/api/indemnification/training";
  import registrationDetail from './registrationDetail.vue'
  export default {
    components: {
      registrationDetail
    },
    data() {
      return {
        data:'',
        inputCheck: '',
        input55: {
          //下一节点审核人
          nextId: '',
          //下一节点参数
          nextParameter: '',
          //申报单位
          fDeclareUnit: '',
          //注册登记机构
          fRegistrationMechanism: '',
          //注册登记日期
          fRegistrationDate: '',
          //编制时间
          fPreparationTime: '',
          //编制人
          fPreparedBy: '',

          //工程ID
          fId: '',
          //注册登记号
          fRegistrationNumberl: '',
          //水库名称
          fReservoirName: '',
          //水库类型
          fReservoirType: '',
          //水库等别
          fReservoirLevel: '',
          //经度
          fLongitude: '',
          //纬度
          fLatitude: '',

          //灌溉面积
          fIrrigationArea: '',
          //所在河流
          fRiver: '',
          //乡镇供水
          fTownWaterSupply: '',
          //管理单位
          fManagementUnit: '',
          //所在地址
          fAddress: '',
          //邮政编码
          fPostalCode: '',
          //主管部门
          fCompetentDepartment: '',

          //集水面积
          fCatchmentArea: '',
          //总库容
          fTotalStorageCapacity: '',
          //兴利库容
          fRegulationStorageCapacity: '',
          //调洪库容
          fRegulationStorageCapacity: '',
          //总投资
          fTotalInvestment: '',
          //完成时间
          fFinishDate: '',
          //是否竣工验收 0=否,1=是
          fIfCompletion: '',

          //竣工日期
          fCompletionDate: '',
          //坝型    结=构划分
          fDamTypeStructure: '',
          //主要功能
          fMajorFunction: '',
          //坝顶高程
          fCrestElevation: '',
          //最大坝高
          fMaximumDamHeight: '',
          //坝顶长度
          fCrestLength: '',
          //坝顶宽度
          fCrestWidth: '',

          //坝基防渗型式
          fSeepagePreventionType: '',
          //放水洞型式
          fDewateringTunnelType: '',
          //放水洞洞泾
          fDewateringTunnelDiameter: '',
          //放水洞最大放水量
          fDewateringTunnelDischarge: '',
          //副坝座数
          fAuxiliaryDamNum: '',
          //工作闸门总数
          fSluiceGateNum: '',
          //工作闸门名称
          fSluiceGateName: '',

          //溢洪道型式
          fSpillwayType: '',
          //溢洪道底高程
          fSpillwayBottomElevation: '',
          //溢洪道顶高程
          fSpillwayTopElevation: '',
          //溢洪道顶宽
          fSpillwayTopWidth: '',
          //溢洪道最大泄量
          fSpillwayBottomDischarge: '',
          //洪水标准设计
          fFloodStandardDesign: '',
          //洪水标准校核
          fFloodStandardCheck: '',

          //洪水标准实际
          fFloodStandardActual: '',
          //水库下游影响铁路
          fDownstreamImpactRailway: '',
          //水库下游影响公路
          fDownstreamImpactHighway: '',
          //水库下游影响村庄
          fDownstreamImpactVillage: '',
          //水库下游影响人口
          fDownstreamImpactPeople: '',
          //水库下游影响耕地
          fDownstreamImpactFarmland: '',
          //管理职工人数
          fManagementStaffPeople: '',

          //固定资源值
          fFixedResourceValue: '',
          //年度管理费用
          fAnnualManagementExpenses: '',
          //年度水费收入
          fAnnualWaterRevenue: '',
          //年度电费收入
          fAnnualElectricityRevenue: '',
          //多种经营纯收入
          fNetOperatingIncome: '',
          //大坝安全类别
          fDamSecurityCategory: '',
          //大坝鉴定与否
          fDamIsAppraisal: '',

          //大坝安全状态
          fSafetyStatus: '',
          //工程信息附件ID
          fEngineeringFileId: '',
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
          //流程实例ID
          fActId: '',
          //下一节点审核人
          fActPersion: '',
          //流程状态 1已提交启动 2：审核中 3：审核完成 4：驳回修改 5：不同意删除
          fActStatus: '',
          //流程节点
          fActNode: '',
        },
        //当前数据状态
        status: '',
        //下一节点审核人 弹窗
        nextVisible: false,

        info: {
          stockDate: this.getNowTime(), //日期
        },
        //下一节点审核人
        radio: '',

        active: 1,
        zhuceVisible: false,
        dialogVisible: false,
        textarea: '',
        value1: '',
        value2: '',
        value3: '',
        value4: '',
        //处理人  集合
        list: [],
        //填表时间
        time: {
          yy: '',
          mm: '',
          dd: '',
        },
        input: {
          //下一节点审核人
          nextId: '',
          //下一节点参数
          nextParameter: '',

          //申报单位
          fDeclareUnit: '',
          //注册登记机构
          fRegistrationMechanism: '',
          //注册登记日期
          fRegistrationDate: '',
          //编制时间
          fPreparationTime: '',
          //编制人
          fPreparedBy: '',

          //工程ID
          fId: '',
          //注册登记号
          fRegistrationNumberl: '',
          //水库名称
          fReservoirName: '',
          //水库类型
          fReservoirType: '',
          //水库等别
          fReservoirLevel: '',
          //经度
          fLongitude: '',
          //纬度
          fLatitude: '',

          //灌溉面积
          fIrrigationArea: '',
          //所在河流
          fRiver: '',
          //乡镇供水
          fTownWaterSupply: '',
          //管理单位
          fManagementUnit: '',
          //所在地址
          fAddress: '',
          //邮政编码
          fPostalCode: '',
          //主管部门
          fCompetentDepartment: '',

          //集水面积
          fCatchmentArea: '',
          //总库容
          fTotalStorageCapacity: '',
          //兴利库容
          fBeneficialStorageCapacity: '',
          //调洪库容
          fRegulationStorageCapacity: '',
          //总投资
          fTotalInvestment: '',
          //完成时间
          fFinishDate: '',
          //是否竣工验收 0=否,1=是
          fIfCompletion: '',

          //竣工日期
          fCompletionDate: '',
          //坝型    结=构划分
          fDamTypeStructure: '',
          //主要功能
          fMajorFunction: '',
          //坝顶高程
          fCrestElevation: '',
          //最大坝高
          fMaximumDamHeight: '',
          //坝顶长度
          fCrestLength: '',
          //坝顶宽度
          fCrestWidth: '',

          //坝基防渗型式
          fSeepagePreventionType: '',
          //放水洞型式
          fDewateringTunnelType: '',
          //放水洞洞泾
          fDewateringTunnelDiameter: '',
          //放水洞最大放水量
          fDewateringTunnelDischarge: '',
          //副坝座数
          fAuxiliaryDamNum: '',
          //工作闸门总数
          fSluiceGateNum: '',
          //工作闸门名称
          fSluiceGateName: '',

          //溢洪道型式
          fSpillwayType: '',
          //溢洪道底高程
          fSpillwayBottomElevation: '',
          //溢洪道顶高程
          fSpillwayTopElevation: '',
          //溢洪道顶宽
          fSpillwayTopWidth: '',
          //溢洪道最大泄量
          fSpillwayBottomDischarge: '',
          //洪水标准设计
          fFloodStandardDesign: '',
          //洪水标准校核
          fFloodStandardCheck: '',

          //洪水标准实际
          fFloodStandardActual: '',
          //水库下游影响铁路
          fDownstreamImpactRailway: '',
          //水库下游影响公路
          fDownstreamImpactHighway: '',
          //水库下游影响村庄
          fDownstreamImpactVillage: '',
          //水库下游影响人口
          fDownstreamImpactPeople: '',
          //水库下游影响耕地
          fDownstreamImpactFarmland: '',
          //管理职工人数
          fManagementStaffPeople: '',

          //固定资源值
          fFixedResourceValue: '',
          //年度管理费用
          fAnnualManagementExpenses: '',
          //年度水费收入
          fAnnualWaterRevenue: '',
          //年度电费收入
          fAnnualElectricityRevenue: '',
          //多种经营纯收入
          fNetOperatingIncome: '',
          //大坝安全类别
          fDamSecurityCategory: '',
          //大坝鉴定与否
          fDamIsAppraisal: '',

          //大坝安全状态
          fSafetyStatus: '',
          //工程信息附件ID
          fEngineeringFileId: '',
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
          //流程实例ID
          fActId: '',
          //下一节点审核人
          fActPersion: '',
          //流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成
          fActStatus: '',
          //流程节点
          fActNode: '',
        },
        value: '',
        textarea1: '',
        textarea2: '',
        fileList: [],
        dict:{
          result:[]
        }
      };
    },
    created() {
      this.init()
      this.queryDataDictionary()

    },
    methods: {
      zhuceVisiblefalse(){
        this.zhuceVisible = false
      },
      queryDataDictionary() {
        queryDataDictionary().then(res => {
          this.dict.result = res.data.result
        });
      },
      //审批提交按钮
      auditApprove() {
        //判断是否填写审批意见
        if (this.input.fAuditComments == null || this.input.fAuditComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审批意见',
            type: 'error'
          });
          return false
        }
        //判断是否填写审批结果
        if (this.value4 == null || this.value4 == '') {
          this.$message({
            showClose: true,
            message: '请选择审批结果',
            type: 'error'
          });
          return false
        }
        //判断是否填写审批人
        if (this.input.fAuditPeople == null || this.input.fAuditPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审批人',
            type: 'error'
          });
          return false
        }
        //判断是否填写审批时间
        if (this.input.fAuditDate == null || this.input.fAuditDate == '') {
          this.$message({
            showClose: true,
            message: '请选择审批时间',
            type: 'error'
          });
          return false
        }
        //审批通过
        if (this.value4 == 1) {
          this.input.fActStatus = 3
          this.input.fAuditResult = 1
          updateInformation(this.input).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审批提交成功");
              this.init()
              this.init()
            }
          })
        }
        //审批未通过
        else if (this.value4 == 2) {
          this.input.fActStatus = 5
          this.input.fAuditResult = 2
          updateInformation(this.input).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审批提交成功");
              this.init()
              this.init()
            }
          })
        }
        //驳回
        else if (this.value4 == 3) {
          this.input.fActStatus = 4
          this.input.fAuditResult = 3
          updateInformation(this.input).then(res => {
            if (res.code == 200) {
              this.msgSuccess("审批提交成功");
              this.init()
              this.init()
            }
          })
        }
      },
      //审核提交按钮
      auditPass() {
        //判断是否填写审核意见
        if (this.input.fReviewComments == null || this.input.fReviewComments == '') {
          this.$message({
            showClose: true,
            message: '请填写审核意见',
            type: 'error'
          });
          return false
        }
        //判断是否填写审核结果
        if (this.input.fReviewResult == null || this.input.fReviewResult == '') {
          this.$message({
            showClose: true,
            message: '请选择审核结果',
            type: 'error'
          });
          return false
        }
        //判断是否填写审核人
        if (this.input.fReviewPeople == null || this.input.fReviewPeople == '') {
          this.$message({
            showClose: true,
            message: '请填写审核人',
            type: 'error'
          });
          return false
        }
        //判断是否填写审核时间
        if (this.input.fReviewDate == null || this.input.fReviewDate == '') {
          this.$message({
            showClose: true,
            message: '请选择审核时间',
            type: 'error'
          });
          return false
        }
        console.log(this.input.fReviewResult)
        //如果审核通过  打开 <下一处理人> 弹窗
        if (this.input.fReviewResult == 1) {
          this.addSubmits()
        }
        //如果审核不通过  提交状态为 <不同意删除>
        else if (this.input.fReviewResult == 2) {
          this.input.fActStatus = 5
          //this.input.fReviewDate = this.input.fReviewDate[0]
          this.input.fReviewResult = 2
          updateInformation(this.input).then(res => {
            console.log("提交结果", res)
            if (res.code == 200) {
              this.msgSuccess("审核提交成功");
              this.nextVisible = false
              this.init()
              this.init()
            }
          })
        }
        //如果审核驳回  打开 <下一处理人> 弹窗
        else if (this.input.fReviewResult == 3) {
          //如果审核驳回  提交状态为 <驳回>

          this.input.fActStatus = 4
          this.input.fReviewResult = 3
          console.log("时间", this.input.fReviewDate)
          console.log("上传数据： ====>", this.input)
          updateInformation(this.input).then(res => {
            console.log("提交结果", res)
            if (res.code == 200) {
              this.msgSuccess("审核成功");
              this.nextVisible = false
              this.init()
              this.init()
            }
          })

        }
      },
      //初始化 查询是否有审核中 审批中的 登记信息
      init() {
        listInformation().then(res => {
          this.data = res.rows
        })
        //初始化状态状态
        this.status = 0
        this.active = 1
        //查询待审核
        listInformation({
          pageNum: 1,
          pageSize: 1,
          fActStatus: 1,
        }).then(res => {
          if (res.total >= 1) {
            this.input = res.rows[0]
            if(this.input.fReviewResult){
              this.input.fReviewResult = this.input.fReviewResult.toString()
            }

            this.status = 1
            this.active = 2
            console.log("当前状态", this.status)
            console.log("初始化", res)
          } else {
            //查询待审批
            listInformation({
              pageNum: 1,
              pageSize: 1,
              fActStatus: 2,
            }).then(res => {
              if (res.total >= 1) {
                this.input = res.rows[0]
                if(this.input.fReviewResult){
                  this.input.fReviewResult = this.input.fReviewResult.toString()
                }
                this.status = 2
                this.active = 3
                console.log("初始化", res)
              } else {
                //查询被驳回 待修改
                listInformation({
                  pageNum: 1,
                  pageSize: 1,
                  fActStatus: 4,
                }).then(res => {
                  if (res.total >= 1) {
                    this.input = res.rows[0]
                    if(this.input.fReviewResult){
                      this.input.fReviewResult = this.input.fReviewResult.toString()
                    }
                    this.status = -1
                    this.active = 1
                    console.log("初始化", res)
                  } else {
                    this.input = this.input55
                    this.input.fReviewResult = ''
                    this.input.fReviewResult = ''
                  }
                })
              }
            })
          }
        })
      },
      //选择处理人 弹窗 确定按钮
      addSubmits() {
        this.input.fActPersion = null;
        //选完下一节点审核人 提交数据 关闭两个弹窗
        if (this.status == 0) {
          this.input.fPreparationTime = this.time.yy + '-' + this.time.mm + '-' + this.time.dd
          this.input.nextId = this.radio
          addInformation(this.input).then(res => {
            console.log("提交结果", res)
            if (res.code == 200) {
              this.msgSuccess("注册登记成功");
              this.zhuceVisible = false
              this.nextVisible = false
              this.init()
              this.init()
            }
          })
          return
        } else if (this.status == 1) {
          this.input.nextId = this.radio
          //同意 通过审核 进行下一步 <审批>
          if (this.input.fReviewResult == 1) {
            this.input.fActStatus = 2

            this.input.fReviewResult = 1
            console.log("提交时间", this.input.fReviewDate)
            //this.input.fReviewDate = this.input.fReviewDate
            updateInformation(this.input).then(res => {
              console.log("提交结果", res)
              if (res.code == 200) {
                this.msgSuccess("审核成功");
                this.nextVisible = false
                this.init()
              }
            })
          }
        } else if (this.status == -1) {
          this.input.nextId = this.radio
          this.input.fPreparationTime = this.time.yy + '-' + this.time.mm + '-' + this.time.dd
          this.input.fActStatus = 1
          updateInformation(this.input).then(res => {
            console.log("提交结果", res)
            if (res.code == 200) {
              this.msgSuccess("修改成功");
              this.nextVisible = false
              this.zhuceVisible = false
              this.init()
            }
          })
        }
      },
      //提交注册登记信息
      submitInput() {
        this.addSubmits();
      },
      //提交 修改的 注册登记信息
      reviseInput() {
        this.addSubmits();
      },
      //处理默认选中当前日期
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
      zhuce() {
        console.log("点击 注册登记按钮")
        this.zhuceVisible = true
      },
      check(data) {
        this.inputCheck = data
        if(this.inputCheck.fReviewResult){
          this.inputCheck.fReviewResult = this.inputCheck.fReviewResult.toString()
        }
        if(this.inputCheck.fAuditResult){
          this.inputCheck.fAuditResult = this.inputCheck.fAuditResult.toString()
        }
        if(this.inputCheck.fDamIsAppraisal){
          this.inputCheck.fDamIsAppraisal = this.inputCheck.fDamIsAppraisal.toString()
        }
        if(this.inputCheck.fDamSecurityCategory){
          this.inputCheck.fDamSecurityCategory = this.inputCheck.fDamSecurityCategory.toString()
        }
        if(this.inputCheck.fDamTypeMaterial){
          this.inputCheck.fDamTypeMaterial = this.inputCheck.fDamTypeMaterial.toString()
        }
        if(this.inputCheck.fDamTypeStructure){
          this.inputCheck.fDamTypeStructure = this.inputCheck.fDamTypeStructure.toString()
        }
        this.dialogVisible = true
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
		window.open(this.fileList[0].url);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      }


    }
  };
</script>
<style lang="scss">
  .color409 {
    color: #409eff;
    cursor: pointer;
  }
  .el-upload-list__item .el-icon-close-tip{
    top: 100000px;
    z-index: -98;
  }
</style>
