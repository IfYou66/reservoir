<template>
  <div class="app-container">
    <el-row v-if="type==0">
      <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div style="margin-right: 15px">
          <el-button @click="zhuceVisible">取 消</el-button>
          <el-button type="primary" size="small" v-if="status ==  0" @click="auditPass">提交</el-button>
          <el-button type="primary" size="small" v-if="status == -1" @click="auditApprove">修改</el-button>
        </div>
      </el-col>
    </el-row>
    <div class="registrationDetail-top" v-if="type==0">
      <div class="registrationDetail-top-titel"> 中型水库大坝注册登记表 </div>

      <div class="registrationDetail-top-div">
        <span>注册登记号：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegistrationNumber"
          placeholder="" class="registrationDetail-top-input"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>水库名称：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fReservoirName" placeholder=""
          class="registrationDetail-top-input" style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>申报单位：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDeclareUnit" placeholder=""
          class="registrationDetail-top-input" style="width: 250px;"> 0"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>主管部门：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCompetentDepartment"
          placeholder="" class="registrationDetail-top-input" style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>所在地址：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fAddress" placeholder=""
          class="registrationDetail-top-input" style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>邮政编码：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fPostalCode" placeholder=""
          class="registrationDetail-top-input" style="width: 250px;"></el-input>
      </div>

      <div class="registrationDetail-top-div1" style="letter-spacing:2px;margin-left: -10px;">
        <span>注册登记机构：</span>
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegistrationMechanism"
          placeholder="" class="registrationDetail-top-input" style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:2px;margin-left: -10px;">
        <span>注册登记日期：</span>
        <!-- <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegistrationDate" placeholder=""
          class="registrationDetail-top-input" style="width: 250px;"></el-input> -->
        <el-date-picker type="date" v-model="input.fRegistrationDate" placeholder="选择日期" format="yyyy-MM-dd"
          value-format="yyyy-MM-dd" :disabled="(status < 1 && ifXian > 0 )? false : true">
        </el-date-picker>
      </div>
      <div class="registrationDetail-top-div" style="margin-top: 50px;margin-left: -200px;">
        水利部大坝安全管理中心 编制
      </div>
    </div>

    <el-divider v-if="type == 0"></el-divider>

    <div class="registrationDetail-center" v-if="type==0">
      <div class="registrationDetail-top-div">
        <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fReservoirName" placeholder=""
          class="registrationDetail-top-input"></el-input>水库大坝注册登记审查意见表
      </div>
      <div style="text-align: right;">
        注册登记号：<el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegistrationNumber"
          placeholder="" class="registrationDetail-top-input" style="width: 250px;border: none !important;"></el-input>
      </div>
      <div>

        <div class="from-div" style="width: 100%;">
          <el-row>
            <el-col :span="8" class="registrationDetail-div1">
              申报单位核查意见
            </el-col>
            <el-col :span="8" class="registrationDetail-div1">
              主管部门审查意见
            </el-col>
            <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              注册登记机构审批意见
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="8"
              style="border-bottom: #a4d5ff 1px solid;border-right: #a4d5ff 1px solid;text-align: left;height: 500px;">
              <div style="margin-top: 100px;">
                主管负责人
              </div>
              <div>
                （签章）
              </div>
              <div style="margin-top: 150px;">
                单位印章
              </div>
            </el-col>
            <el-col :span="8"
              style="border-bottom: #a4d5ff 1px solid;border-right: #a4d5ff 1px solid;text-align: left;height: 500px;">
              <div style="margin-top: 100px;">
                主管负责人
              </div>
              <div>
                （签章）
              </div>
              <div style="margin-top: 150px;">
                单位印章
              </div>
            </el-col>
            <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;text-align: left;height: 500px;">
              <div style="margin-top: 100px;">
                主管负责人
              </div>
              <div>
                （签章）
              </div>
              <div style="margin-top: 150px;">
                单位印章
              </div>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>

    <el-divider v-if="type == 0"></el-divider>

    <div class="registrationDetail-center" v-if="type==0 || type==1">
      <div class="registrationDetail-top-div" v-if="type == 0">
        中型水库大坝注册登记表
      </div>
      <div style="text-align: left;">
        注册登记号：<el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegistrationNumber"
          placeholder="" class="registrationDetail-top-input" style="width: 250px;border: none !important;"></el-input>
      </div>
      <div style="text-align: right;margin-top: -20px;">
        填表日期：
        <el-input v-model="time.yy" placeholder="" class="registrationDetail-top-input"
          style="width: 60px;border: none !important;" disabled="disabled"></el-input> 年
        <el-input v-model="time.mm" placeholder="" class="registrationDetail-top-input"
          style="width: 50px;border: none !important;" disabled="disabled"></el-input> 月
        <el-input v-model="time.dd" placeholder="" class="registrationDetail-top-input"
          style="width: 50px;border: none !important;" disabled="disabled"></el-input> 日
      </div>
      <div>

        <div class="from-div" style="width: 100%;font-size: 17px;">
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              水库名称
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fReservoirName"
                placeholder="" class="registrationDetail-top-input" style="width: 100%;border: none !important;">
              </el-input>
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              灌溉面积
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fIrrigationArea"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万亩
            </el-col>
            <el-col :span="2" class="registrationDetail-div2 " style="border-right: #a4d5ff 1px solid;">
              .
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              管理职工人数
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fManagementStaffPeople"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>人
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              所在河流
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRiver" placeholder=""
                class="registrationDetail-top-input" style="width: 100%;border: none !important;"></el-input>
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              乡镇供水
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fTownWaterSupply"
                placeholder="" class="registrationDetail-top-input" style="width: 50%;border: none !important;">
              </el-input>万立方米
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              管
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              固定资源值
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fFixedResourceValue"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万元
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              管理单位
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fManagementUnit"
                placeholder="" class="registrationDetail-top-input" style="width: 100%;border: none !important;">
              </el-input>
            </el-col>

            <el-col :span="1" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              放
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              型式
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDewateringTunnelType"
                placeholder="" class="registrationDetail-top-input"
                style="width: 70%;border: none !important;text-align: right;"></el-input>管道
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              理
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              年管理费用
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fAnnualManagementExpenses"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万元
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              所在地点
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fAddress" placeholder=""
                class="registrationDetail-top-input" style="width: 100%;border: none !important;"></el-input>
            </el-col>
            <el-col :span="1" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              水
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              洞泾
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDewateringTunnelDiameter"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              情
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              年水费收入
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fAnnualWaterRevenue"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万元
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              邮政编码
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fPostalCode" placeholder=""
                class="registrationDetail-top-input" style="width: 100%;border: none !important;"></el-input>
            </el-col>
            <el-col :span="1" class="registrationDetail-div1">
              洞
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              最大放水量
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDewateringTunnelDischarge"
                placeholder="" class="registrationDetail-top-input" style="width: 40%;border: none !important;">
              </el-input>立方米/秒
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              况
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              年电费收入
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fAnnualElectricityRevenue"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万元
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              主管部门
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCompetentDepartment"
                placeholder="" class="registrationDetail-top-input" style="width: 100%;border: none !important;">
              </el-input>
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 80px;height: 40px;">
              溢
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              型式
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSpillwayType"
                placeholder="" class="registrationDetail-top-input" style="width: 60%;border: none !important;">
              </el-input>宽顶堰
            </el-col>
            <el-col :span="2"
              style="border-bottom: #a4d5ff 1px solid;border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px; color: #FFFFFF;">
              .
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              多种经营纯收入
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fNetOperatingIncome"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>万元
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              集水面积
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCatchmentArea"
                placeholder="" class="registrationDetail-top-input" style="width: 60%;border: none !important;">
              </el-input>平方公里
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 80px;height: 40px;">
              洪
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              底高程
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSpillwayBottomElevation"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="2" class="registrationDetail-div2" style="border-right: #a4d5ff 1px solid;">
              .
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3" class="registrationDetail-div3">

            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              总库容
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fTotalStorageCapacity"
                placeholder="" class="registrationDetail-top-input" style="width: 60%;border: none !important;">
              </el-input>亿立方米
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 80px;height: 40px;">
              道
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              底宽
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSpillwayTopWidth"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="2" class="registrationDetail-div2" style="border-right: #a4d5ff 1px solid;">
              .
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;">
              安全类别：
            </el-col>
            <el-col :span="3" style="border-right: #a4d5ff 1px solid;text-align: right;line-height: 40px;">
              <el-select :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamSecurityCategory"
                placeholder="请选择" style="width: 70%; display: inline-block;">
                <el-option v-for="item in fDamSecurityCategoryOptions" :key="item.dictValue" :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
              <!-- <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamSecurityCategory"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input> -->
              类坝
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              兴利库容
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fBeneficialStorageCapacity"
                placeholder="" class="registrationDetail-top-input" style="width: 60%;border: none !important;">
              </el-input>亿立方米
            </el-col>
            <el-col :span="1" class="registrationDetail-div1">
              .
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              最大泄量
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSpillwayBottomDischarge"
                placeholder="" class="registrationDetail-top-input" style="width: 40%;border: none !important;">
              </el-input>立方米/米
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              大
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3" class="registrationDetail-div3">

            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              调洪库容
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fRegulationStorageCapacity"
                placeholder="" class="registrationDetail-top-input" style="width: 60%;border: none !important;">
              </el-input>亿立方米
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 30px;height: 40px;">
              <div>洪</div>水
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              设计
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fFloodStandardDesign"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>年
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              坝
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;">
              鉴定与否：
            </el-col>
            <el-col :span="3" style="border-right: #a4d5ff 1px solid;text-align: right;line-height: 40px;">
              <!-- <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamIsAppraisal"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input> -->
              <el-select :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamIsAppraisal"
                placeholder="请选择" style="width: 100%; display: inline-block;">
                <el-option v-for="item in fDamIsAppraisalOptions" :key="item.dictValue" :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              总投资
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fTotalInvestment"
                placeholder="" class="registrationDetail-top-input" style="width:80%;border: none !important;">
              </el-input>万元
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 60px;height: 40px;">
              <div>标</div>
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              校核
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fFloodStandardCheck"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>年
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              安
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3" class="registrationDetail-div3">

            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              竣工日期
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <!-- <el-input  :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCompletionDate" placeholder="" class="registrationDetail-top-input"
                style="width: 100%;border: none !important;"></el-input> -->
              <el-date-picker type="date" v-model="input.fCompletionDate" placeholder="选择日期" format="yyyy-MM-dd"
                value-format="yyyy-MM-dd" style="width: 100%;" :disabled="(status < 1 && ifXian > 0 )? false : true">
              </el-date-picker>
            </el-col>
            <el-col :span="1" class="registrationDetail-div1">
              准
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              实际
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fFloodStandardActual"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>年
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              全
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;">
              安全状况：
            </el-col>
            <el-col :span="3" style="border-right: #a4d5ff 1px solid;text-align: right;line-height: 40px;">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSafetyStatus"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              坝型 材料/结构
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-select :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamTypeMaterial"
                placeholder="请选择" style="width: 50%; display: inline-block;">
                <el-option v-for="item in result1.dam_material" :key="item.dictValue" :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
              <el-select :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamTypeStructure"
                placeholder="请选择" style="width: 50%; display: inline-block;">
                <el-option v-for="item in result1.dam_structure" :key="item.dictValue" :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
              <!-- <el-input  :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDamTypeStructure" placeholder="" class="registrationDetail-top-input"
                style="width: 100%;border: none !important;"></el-input> -->
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 50px;height: 40px;">
              水
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              铁路
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDownstreamImpactRailway"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>公里
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              状
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3" class="registrationDetail-div3">

            </el-col>
          </el-row>

          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              坝顶高程
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCrestElevation"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="1"
              style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 30px;height: 40px;">
              库
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              公路
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDownstreamImpactHighway"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>公里
            </el-col>
            <el-col :span="2" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;">
              况
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3" class="registrationDetail-div3">

            </el-col>
          </el-row>


          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              最大坝高
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fMaximumDamHeight"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="1" style="border-right: #a4d5ff 1px solid;text-align: center;line-height:15px;height: 40px;">
              下
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              村庄
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDownstreamImpactVillage"
                placeholder="" class="registrationDetail-top-input" style="width: 70%;border: none !important;">
              </el-input>公里
            </el-col>
            <el-col :span="2" class="registrationDetail-div2" style="border-right: #a4d5ff 1px solid;">
              .
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3"
              style="border-right: #a4d5ff 1px solid;text-align: right;line-height: 40px;color: #FFFFFF;">

            </el-col>
          </el-row>

          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              坝顶长度
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fCrestLength"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>米
            </el-col>
            <el-col :span="1" style="border-right: #a4d5ff 1px solid;text-align: center;line-height: 0px;height: 40px;">
              游<div style="margin-top: 30px;">影</div>
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              人口
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDownstreamImpactPeople"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>人
            </el-col>
            <el-col :span="2" class="registrationDetail-div2" style="border-right: #a4d5ff 1px solid;">
              .
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">

            </el-col>
            <el-col :span="3"
              style="border-right: #a4d5ff 1px solid;text-align: right;line-height: 40px;color: #FFFFFF;">

            </el-col>
          </el-row>

          <el-row>
            <el-col :span="4" class="registrationDetail-div1">
              坝基防渗型式
            </el-col>
            <el-col :span="4" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fSeepagePreventionType"
                placeholder="" class="registrationDetail-top-input" style="width: 100%;border: none !important;">
              </el-input>
            </el-col>
            <el-col :span="1"
              style="border-bottom: #a4d5ff 1px solid;border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;height: 40px;">
              响
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              耕地
            </el-col>
            <el-col :span="3" class="registrationDetail-div1">
              <el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fDownstreamImpactFarmland"
                placeholder="" class="registrationDetail-top-input" style="width: 80%;border: none !important;">
              </el-input>亩
            </el-col>
            <el-col :span="2"
              style="border-bottom: #a4d5ff 1px solid;border-right: #a4d5ff 1px solid;text-align: center;line-height: 40px;color: #FFFFFF;">
              .
            </el-col>
            <el-col :span="4" style="text-align: center;line-height: 40px;color: #FFFFFF;">
            </el-col>
            <el-col :span="3" class="registrationDetail-div3">
            </el-col>
          </el-row>




        </div>
        <el-row>

          <el-col :span="4">
            <div style="width: 200px;margin-top: 20px;margin-left: 20px;">
              <el-upload style="margin-left: 15px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
               :before-upload = "beforeAvatarUpload"
                :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                 multiple :on-success="uploadedSuccess" :show-file-list="true"
                :auto-upload="true" :limit="1" :on-exceed="handleExceed" :file-list="fileList">
                <el-button size="small" type="primary" :disabled="(status < 1 && ifXian > 0 )? false : true"
                  v-if="type == 0 || type==1">文件上传</el-button>
				  <div v-if="type == 0 || type==1" slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
              </el-upload>
            </div>
          </el-col>
          <el-col :span="20">
            <div class="from-select"
              style="font-size: 20px;margin-top: 10px;margin-right: 0px;font-weight: 400;float:right">
              <div style="margin-top:20px;">
                <span>编制人：<el-input :disabled="(status < 1 && ifXian > 0 )? false : true" v-model="input.fPreparedBy"
                    placeholder="编制人" style="width:180px; height: 45px"></el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker type="date" v-model="input.fPreparationTime" placeholder="选择日期" format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd" :disabled="(status < 1 && ifXian > 0 )? false : true">
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>

      </div>



    </div>


    <el-divider v-if="type == 0"></el-divider>

    <div class="registrationDetail-center" v-if="type==0">
      <div class="registrationDetail-top-div" style="letter-spacing:20px;">
        填表说明
      </div>
      <div class="registrationDetail-text">
        1、注册登记号:由有关注册登记机构按规定填写。<br />
        2、水库名称:填写水库现用名的全称。<br />
        3、所在河流:填入水库大坝所在的河流名。<br />
        4、管理单位:填写水库管理单位的全称。<br />
        5、所在地点。填入水库大坝所在市(县)、镇(乡）和村，填成“××市(县)××镇(乡)××村”，最低填到村级。<br />
        6、邮政编码:填入水库大坝所在地的邮政编码。<br />
        7、主管部门:填写现在水库管理单位的上一级主管部门的全称。<br />
        8、集水面积:水库流域周围分水线与坝址断面之间所包围的面积。<br />
        9、总库容:指校核洪水位的相应库容。<br />
        10、兴利库容:正常蓄水位以下、死水位以上的库容。<br />
        11、调洪库容:校核洪水位以下、汛期限制水位以上的库容。<br />
        12、总投资:完成现有工程规模的投资总金额。<br />
        13、竣工日期:水库大坝工程全部完工的日期。指原工程，不包括加固扩建。<br />
        14、圳型:水库大圳的坝型。王坝分?均质坝、心墙坝、斜墙坝、面板坝寺﹔混凝土坝分:混凝土重力坝、混凝土拱坝等;浆砌石坝分:浆砌石重力坝、浆砌石拱坝等。<br />
        15、坝顶高程:填主坝顶的高程。<br />
        16、最大坝高:按现有工程实际情况填主坝最大断面的坝高。<br />
        17、坝顶长度:按现有工程实际情况填主坝顶的长度。<br />
        18、坝基防渗型式:按竣工资料填，如截水槽、铺盖、帷幕灌浆等。<br />
        19、灌溉面积:目前工程规模投入运行后可能实现的最大灌溉面积。<br />
        20、乡镇供水:运行期实际发生的多年平均供水量。<br />
        21、放水洞一型式:填明材料、是否有压、洞型和结构。如钢筋混凝土有压圆管。<br />
        22、放水洞一洞径:填明几孔，孔径或每孔高度X宽度。<br />
        23、放水洞一最大放水流量:正常蓄水位下可放出的最大流量。<br />
        24、溢洪道-型式:填明是宽顶堰、实用堰或其他型式。<br />
        25、溢洪道-底高程:堰面最高点的高程。<br />
        26、溢洪道一底宽:堰顶过水断面的净宽度。有闸[门]的可填明几孔X每孔净宽几米。<br />
        27、溢洪道一最大泄量:在水库最高洪水位下溢洪道能泄放的最大流量。<br />
        28、洪水标准-设计:指现有工程规模正常运用设计洪水的重现期(填阿拉伯数字，下
        同)。<br />
        29、洪水标准-校核:指非常运用校核洪水的重现期:<br />
        30、洪水标准一实际: 指有工程规模条件下保证工程安全前提下所能抗御的最大洪水的
        重现期。<br />
        31、水库下游影响一铁路: 填明水库下游的铁路名称和距坝址的行洪距离。<br />


      </div>
    </div>






  </div>
</template>

<script>
  import {
    getDictByType
  } from "@/api/security/cancellation";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  export default {
    props: ['type', 'input', 'time', 'status', 'ifXian'],

    data() {
      return {
        //鉴定与否
        fDamIsAppraisalOptions: [],
        //安全类别
        fDamSecurityCategoryOptions: [],
        //文件集合
        fileList: [],
        // 文件上传
        upload: {
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: "http://localhost/dev-api/file/upload"
        },
        result1: [],
        dialogVisible: false,
        textarea: '',
        value1: '',
        value2: '',
        value3: '',
        value4: ''
      };
    },
    created() {
      this.createTime()
      //console.log('111111111111111',this.status)
      //console.log(typeof this.ifXian,this.ifXian)
      //console.log(this.status < 1 && this.ifXian > 0)
      this.getResult();
      this.getFile();
      this.getDict();
    },

    watch: {
      input: function(){
        this.getFile();
      }
    },

    methods: {
      getDict(){
      	this.getDicts("dam_security").then(response => {
      		this.fDamSecurityCategoryOptions = response.data;
      	});
      	this.getDicts("dam_is_appraisal").then(response => {
      		this.fDamIsAppraisalOptions = response.data;
      	});
      },
      beforeAvatarUpload(file){
            const isLt100M = file.size / 1024 / 1024 < 100;
               if (!isLt100M) {
                      this.$message.error('上传文件大小不能超过 100MB!');
                      return false
                  }
            },
      getFile() {
        console.log('this.input', this.input);
        if (this.ifXian == 0) {
          console.log('this.input.fEngineeringFileId  => 执行了', this.input.fEngineeringFileId);
          this.fileList = [];
          if (this.input.fEngineeringFileId) {
            getFileById({
              id: this.input.fEngineeringFileId
            }).then(result => {
              if (result) {
                this.fileList = [{
                  name: result.data.fOldFileName,
                  url: result.data.fFilePath
                }];
                console.log("fileList.url:", this.fileList[0].url);
                console.log("fileList.name:", this.fileList[0].name);
              }
            })
          }
        }


      },
      zhuceVisible(){
        this.$emit('zhuceVisible');
      },
      auditPass(){
        this.$emit('submitInput');

      },
      auditApprove(){
        this.$emit('reviseInput');
      },
      handlePreview(file) {
        // window.location.href = file.url;
		window.open(this.fileList[0].url);
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.input.fEngineeringFileId);
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
        this.input.fEngineeringFileId = response.data.fId
      },

      //拆分填表日期
      createTime() {
        var now = new Date();
        this.time.yy = now.getFullYear() //得到年份
        this.time.mm = now.getMonth() + 1 //得到月份
        this.time.dd = now.getDate() //得到日期
      },
      dialog() {
        this.dialogVisible = true
      },

      getResult() {
        getDictByType().then(response => {
          this.result1 = response.data
        })
      }
    }
  };
</script>
<style lang="scss" scoped>
  .registrationDetail-top {
    width: 90%;
    margin: 0 auto;
  }

  .registrationDetail-top-titel {
    text-align: center;
    font-size: 32px;
    color: #000000;
    font-weight: 600;
    letter-spacing: 5px
  }

  .registrationDetail-top-div {
    text-align: center;
    color: #000000;
    font-weight: 600;
    letter-spacing: 3px;
    font-size: 18px;
    margin-top: 40px;
    margin-bottom: 40px;
  }

  .registrationDetail-top-div1 {
    text-align: center;
    color: #000000;
    font-weight: 600;
    // letter-spacing:10px;
    font-size: 18px;
    // margin-top: 40px;
    margin-bottom: 20px;
  }

  .registrationDetail-top-input {
    width: 200px;
    border-bottom: #000000 1px solid !important;

    .el-input__inner {

      border-bottom: #000000 1px solid !important;
    }
  }

  .registrationDetail-center {
    width: 90%;
    margin: 0 auto;
  }

  .registrationDetail-text {
    color: #000000;
    font-size: 18px;
    width: 90%;
    margin: 0 auto;
    line-height: 40px;
    letter-spacing: 2px;
  }

  .registrationDetail-div1 {
    border-bottom: #a4d5ff 1px solid;
    border-right: #a4d5ff 1px solid;
    text-align: center;
    line-height: 40px;
  }

  .registrationDetail-div2 {
    bborder-right: #a4d5ff 1px solid;
    text-align: center;
    line-height: 40px;
    color: #FFFFFF;
  }

  .registrationDetail-div3 {
    border-right: #a4d5ff 1px solid;
    text-align: right;
    line-height: 40px;
    color: #FFFFFF;
  }
</style>
