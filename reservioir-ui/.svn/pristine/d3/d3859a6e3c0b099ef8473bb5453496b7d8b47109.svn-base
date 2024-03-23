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
            <div :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              2.审核</div>
          </div>
          <div style="position: relative;">
            <img :src="require(active>=3? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              3.审批</div>
          </div>
          <div style="position: relative;">
            <img :src="require(active==4? '../../../assets/images/jin.png':'../../../assets/images/jin1.png')" />
            <div :style="active>1? 'position: absolute;top: 10px;left: 100px;width: 50%;color: #FFFFFF;':'position: absolute;top: 10px;left: 100px;width: 50%;color: #757575;'">
              4.完成</div>
          </div>
        </div>
      </el-col>
    </el-row>
    <div class="from-div">
      <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
            <el-button type="primary" size="small" @click="newNull">注销登记</el-button>
            <el-button type="primary" size="small" @click="addSubmits">提交</el-button>
          </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="24" class="from-div-title">
          <span>
            水库大坝注销登记表
          </span>
          <!--          <img src="../../../assets/u16149.png" />-->


          <div class="from-div" style="width: 95%;">
            <el-row>
              <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">

              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                水库名称
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fReservoirName" placeholder="" style="width: 100%;"></el-input>
              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                注册登记号
              </el-col>
              <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fCancellationNumber" placeholder="" style="width: 100%;"></el-input>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                建设地点
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fAddress" placeholder="" style="width: 100%;">
                </el-input>
              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                坝型 材料/结构
              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-select disabled v-model="mCancellation.fDamTypeMaterial" placeholder="请选择" style="width: 100%;">
                  <el-option v-for="item in result1.dam_material" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </el-col>
              <el-col :span="4" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-select disabled v-model="mCancellation.fDamTypeStructure" placeholder="请选择" style="width: 100%;">
                  <el-option v-for="item in result1.dam_structure" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                所在河流
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fRiver" placeholder="" style="width: 100%;">
                </el-input>
              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                最高坝高
              </el-col>
              <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fMaximumDamHeight" placeholder="" style="width: 100%;"></el-input>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                管理单位
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fManagementUnit" placeholder="" style="width: 100%;"></el-input>
              </el-col>
              <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 40px;">
                建设
              </el-col>
              <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                开工
              </el-col>
              <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <div class="block">
                  <el-date-picker disabled format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
                    v-model="mCancellation.fStartDate" type="date" placeholder="选择开工日期">
                  </el-date-picker>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                总库容
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <el-input disabled v-model="mCancellation.fTotalStorageCapacity" placeholder="" style="width: 100%;"
                  size="mini"></el-input>
              </el-col>
              <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                日期
              </el-col>
              <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                竣工
              </el-col>
              <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                <div class="block">
                  <el-date-picker disabled format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
                    v-model="mCancellation.fCompletionDate" type="date" placeholder="选择竣工日期">
                  </el-date-picker>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 60px;">
                <div>废</div>
                <div>弃</div>
                <div>原</div>
                <div>因</div>
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;height: 241px;">
                <el-input  disabled type="textarea" :rows="6" placeholder="请输入内容" v-model="mCancellation.fDiscardReason">
                </el-input>

              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;height: 238px;line-height: 60px;">
                <div>批</div>
                <div>准</div>
                <div>单</div>
                <div>位</div>
                <div>意</div>
                <div>见</div>
              </el-col>
              <el-col :span="8" style="height: 100px;padding: 10px; text-align: left">
                <div>
                  批准文号：
                  <el-input disabled v-model="mCancellation.fApprovalNumber" placeholder="" style="width: 40%"></el-input>
                </div>
                <div>
                  内容摘要：
                  <el-input disabled type="textarea" :rows="2" placeholder="" v-model="mCancellation.fContentAbstract">
                  </el-input>
                </div>

              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 150px;">
                废弃后果与相应原因
              </el-col>
              <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 150px;">
                <el-input disabled type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellation.fReasonRemarks">
                </el-input>
              </el-col>
              <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 150px; color: #FFFFFF;">
                .
              </el-col>
              <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;height: 150px; text-align: left">
                <div>
                  批准单位：
                  <el-input disabled v-model="mCancellation.fApprovalUnit" placeholder="" style="width: 50%;"></el-input>
                </div>
                <div>
                  （盖章）
                </div>
                <div style="text-align: right;margin-top: 0px;">
                  <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" v-model="mCancellation.fApprovalDate"
                    style="width: 250px;" type="date" placeholder="选择日期" disabled>
                  </el-date-picker>
                </div>
              </el-col>
            </el-row>
          </div>

          <div style="width: 200px;margin-top: 20px;margin-left: 20px;">
            <el-upload style="margin-left: 15px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
             :before-upload = "beforeAvatarUpload"
              :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
              multiple :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1" :on-exceed="handleExceed"
              :file-list="fileList">
              <el-button size="small" type="primary">点击上传</el-button>
              <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
            </el-upload>
          </div>

          <div class="from-select" style="font-size: 20px;margin-top: 50px;margin-right: 10px;font-weight: 400;float:right">
            <div style="margin-top:20px;">
              <span>编制人：<el-input :disabled="active != 1" v-model="mCancellation.fPreparedBy" placeholder="编制人" style="width:180px; height: 45px"></el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" v-model="mCancellation.fPreparationTime"
                  type="datetime" placeholder="选择日期" :disabled="active != 1">
                </el-date-picker>
              </div>
            </div>
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
          <el-input :disabled="active != 2"  maxlength="500" show-word-limit  type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellation.fReviewComments">
          </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 600;display:inline;">
                审核结果：
              </div>
              <el-select :disabled="active != 2" v-model="mCancellation.fReviewResult" placeholder="请选择">
                <el-option v-for="item in result1.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div style="margin-top:20px;">
              <span>审核人：<el-input :disabled="active != 2" v-model="mCancellation.fReviewPeople" placeholder="审核人" style="width:180px;">
                </el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker :disabled="active != 2" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="mCancellation.fReviewDate" type="datetime" placeholder="选择日期">
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
          <el-input  maxlength="500" show-word-limit  :disabled="active != 3" type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellation.fAuditComments">
          </el-input>
          <div class="from-select">
            <div style="margin-top: 20px;margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 600;display:inline;">
                审批结果：
              </div>
              <el-select :disabled="active != 3" v-model="mCancellation.fAuditResult" placeholder="请选择">
                <el-option v-for="item in result1.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                </el-option>
              </el-select>
            </div>
            <div style="margin-top:20px;">
              <span>审批人：<el-input :disabled="active != 3" v-model="mCancellation.fAuditPeople" placeholder="审批人" style="width:180px;">
                </el-input></span>
              <div class="block" style="display:inline;margin-left:10px;">
                <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                <el-date-picker :disabled="active != 3" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="mCancellation.fAuditDate" type="datetime" placeholder="选择日期">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

    </div>

    <el-dialog title="详情" :visible.sync="dialogVisible" width="1500px">
      <div class="from-div" style="width: 90%">
        <el-row>
          <el-col :span="24" class="from-div-title">
            <span>
              水库大坝注销登记表
            </span>
            <div class="from-div" style="width: 95%;">
              <el-row>
                <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">

                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  水库名称
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fReservoirName" placeholder="" style="width: 100%;"></el-input>
                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  注册登记号
                </el-col>
                <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fCancellationNumber" placeholder="" style="width: 100%;"></el-input>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  建设地点
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fAddress" placeholder="" style="width: 100%;"></el-input>
                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  坝型 材料/结构
                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-select disabled v-model="mCancellationRow.fDamTypeMaterial" placeholder="请选择" style="width: 100%;">
                    <el-option v-for="item in result1.dam_material" :key="item.dictValue" :label="item.dictLabel"
                      :value="item.dictValue">
                    </el-option>
                  </el-select>
                </el-col>
                <el-col :span="4" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-select disabled v-model="mCancellationRow.fDamTypeStructure" placeholder="请选择" style="width: 100%;">
                    <el-option v-for="item in result1.dam_structure" :key="item.dictValue" :label="item.dictLabel"
                      :value="item.dictValue">
                    </el-option>
                  </el-select>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  所在河流
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fRiver" placeholder="" style="width: 100%;">
                  </el-input>
                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  最高坝高
                </el-col>
                <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fMaximumDamHeight" placeholder="" style="width: 100%;"></el-input>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  管理单位
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fManagementUnit" placeholder="" style="width: 100%;"></el-input>
                </el-col>
                <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 40px;">
                  建设
                </el-col>
                <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  开工
                </el-col>
                <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <div class="block">
                    <el-date-picker disabled format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
                      v-model="mCancellationRow.fStartDate" type="date" placeholder="选择开工日期">
                    </el-date-picker>
                  </div>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  总库容
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <el-input disabled v-model="mCancellationRow.fTotalStorageCapacity" placeholder="" style="width: 100%;"
                    size="mini"></el-input>
                </el-col>
                <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  日期
                </el-col>
                <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
                  竣工
                </el-col>
                <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
                  <div class="block">
                    <el-date-picker disabled format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
                      v-model="mCancellationRow.fCompletionDate" type="date" placeholder="选择竣工日期">
                    </el-date-picker>
                  </div>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 60px;">
                  <div>废</div>
                  <div>弃</div>
                  <div>原</div>
                  <div>因</div>
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;height: 241px;">
                  <el-input disabled type="textarea" :rows="6" placeholder="请输入内容" v-model="mCancellationRow.fDiscardReason">
                  </el-input>

                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;height: 238px;line-height: 60px;">
                  <div>批</div>
                  <div>准</div>
                  <div>单</div>
                  <div>位</div>
                  <div>意</div>
                  <div>见</div>
                </el-col>
                <el-col :span="8" style="height: 100px;padding: 10px; text-align: left">
                  <div>
                    批准文号：
                    <el-input disabled v-model="mCancellationRow.fApprovalNumber" placeholder="" style="width: 40%"></el-input>
                  </div>
                  <div>
                    内容摘要：
                    <el-input disabled type="textarea" :rows="2" placeholder="" v-model="mCancellationRow.fContentAbstract">
                    </el-input>
                  </div>

                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 150px;">
                  废弃后果与相应原因
                </el-col>
                <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 150px;">
                  <el-input  maxlength="500" show-word-limit  disabled type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellationRow.fReasonRemarks">
                  </el-input>
                </el-col>
                <el-col :span="4" style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 150px; color: #FFFFFF;">
                  .
                </el-col>
                <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;height: 150px; text-align: left">
                  <div>
                    批准单位：
                    <el-input disabled v-model="mCancellationRow.fApprovalUnit" placeholder="" style="width: 50%;"></el-input>
                  </div>
                  <div>
                    （盖章）
                  </div>
                  <div style="text-align: right;margin-top: 0px;">
                    <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" v-model="mCancellationRow.fApprovalDate"
                      style="width: 250px;" type="date" placeholder="选择日期" disabled>
                    </el-date-picker>
                  </div>
                </el-col>
              </el-row>
            </div>

            <div style="width: 200px;margin-top: 20px;margin-left: 20px;">
              <div style="width: 200px;margin-top: 20px;margin-left: 20px;">
                <el-upload style="margin-left: 15px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
                 :before-upload = "beforeAvatarUpload"
                  :action="GLOBAL.httpUrl" :on-preview="handlePreview"  multiple
                  :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1" :on-exceed="handleExceed"
                  :file-list="fileList">
                </el-upload>
              </div>
            </div>

            <div class="from-select" style="font-size: 20px;margin-top: 50px;margin-right: 10px;font-weight: 400;float:right">
              <div style="margin-top:20px;">
                <span>编制人：<el-input :disabled="active != 1" v-model="mCancellationRow.fPreparedBy" placeholder="编制人"
                    style="width:180px; height: 45px"></el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="active != 1" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                    v-model="mCancellationRow.fPreparationTime" type="datetime" placeholder="选择日期">
                  </el-date-picker>
                </div>
              </div>
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
            <el-input :disabled="active != 2" type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellationRow.fReviewComments">
            </el-input>
            <div class="from-select">
              <div style="margin-top: 20px;margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 600;display:inline;">
                  审核结果：
                </div>
                <el-select :disabled="active != 2" v-model="mCancellationRow.fReviewResult" placeholder="请选择">
                  <el-option v-for="item in result1.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div style="margin-top:20px;">
                <span>审核人：<el-input :disabled="active != 2" v-model="mCancellationRow.fReviewPeople" placeholder="审核人"
                    style="width:180px;">
                  </el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="active != 2" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                    v-model="mCancellationRow.fReviewDate" type="datetime" placeholder="选择日期" disabled>
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>

        <el-row v-if="mCancellationRow.fReviewDate">
          <el-col :span="3" class="from-align" style="line-height:200px;">
            计划批准
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审批意见：
            </div>
            <el-input :disabled="active != 4" type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellationRow.fAuditComments">
            </el-input>
            <div class="from-select">
              <div style="margin-top: 20px;margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 600;display:inline;">
                  审批结果：
                </div>
                <el-select :disabled="active != 4" v-model="mCancellationRow.fAuditResult" placeholder="请选择">
                  <el-option v-for="item in result1.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div style="margin-top:20px;">
                <span>审批人：<el-input :disabled="active != 4" v-model="mCancellationRow.fAuditPeople" placeholder="审批人"
                    style="width:180px;">
                  </el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker :disabled="active != 4" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
                    v-model="mCancellationRow.fAuditDate" type="datetime" placeholder="选择日期" disabled>
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row v-else>
          <el-col :span="3" class="from-align" style="line-height:200px;">
            计划批准
          </el-col>
          <el-col :span="21" style="height: 50px;">
            <div style="font-size: 16px;font-weight: 700;padding: 10px;">
              审批意见：
            </div>
            <el-input  maxlength="500" show-word-limit  disabled type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellationRow.fAuditComments">
            </el-input>
            <div class="from-select">
              <div style="margin-top: 20px;margin-left: 10px;">
                <div style="font-size: 16px;font-weight: 600;display:inline;">
                  审批结果：
                </div>
                <el-select disabled v-model="mCancellationRow.fAuditResult" placeholder="请选择">
                  <el-option v-for="item in result1.result" :key="item.dictValue" :label="item.dictLabel" :value="item.dictValue">
                  </el-option>
                </el-select>
              </div>
              <div style="margin-top:20px;">
                <span>审批人：<el-input disabled v-model="mCancellationRow.fAuditPeople" placeholder="审批人" style="width:180px;"></el-input></span>
                <div class="block" style="display:inline;margin-left:10px;">
                  <span class="demonstration" v-html="'时&ensp;&ensp;间：'" />
                  <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" v-model="mCancellationRow.fAuditDate"
                    type="datetime" placeholder="选择日期" disabled>
                  </el-date-picker>
                </div>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
      <span slot="footer" class="dialog-footer">
      </span>
    </el-dialog>

    <div class="from-div" style="border: 0px">
      <el-dialog title="详情" :visible.sync="zhuceVisible" width="1500px">
        <!-- {{mCancellation}} -->
        <Logout :fileList="fileList" :mCancellation="mCancellation" @zhuceVisiblea="zhuceVisiblea" :result1="result1"></Logout>
        <!-- <span slot="footer" class="dialog-footer">
          <el-button @click="zhuceVisible = false">取 消</el-button>
          <el-button type="primary" @click="zhuceVisible = false">确 定</el-button>
        </span> -->
      </el-dialog>
      <div class="table-head" style="margin-top:40px;margin:0 auto;width:100%">
        注销登记编制记录
      </div>
      <el-table :data="cancellationList" class="from-top" border style="margin:0 auto;width:100%">
        <el-table-column label=" 序号" align="center" type="index" width="300" />
        <el-table-column label="编制时间" align="center" prop="fPreparationTime">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.fPreparationTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="编制人" align="center" prop="fPreparedBy" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button size="mini" type="text" @click="dialog(scope.row)">
              查看
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  import {
    getDictByType,
    latelyCancellation,
    listCancellation,
    getCancellation,
    delCancellation,
    addCancellation,
    updateCancellation,
    nextCancellationInsert,
    nextCancellationUpdate
  } from "@/api/security/cancellation";
  // import {
  //   getUserList,
  //   startWorkFlow,
  //   getReviewTask,
  //   taskReview,
  //   taskApprove
  // } from "@/api/security/planning";
  import Logout from './logout.vue'

  export default {
    components: {
      Logout
    },
    data() {
      return {
        mCancellationRow: {},
        // 总条数
        total: 0,
        cancellationList: [],
        result1: [],
        radio: '',
        list: [],
        nextVisible: false,
        readonly: true,
        fileList: [{
          name: null,
          url: null
        }],
        disabled: true,
        // 遮罩层
        loading: true,
        fApprovalDate: {},
        mCancellation: {},
        active: 1,
        zhuceVisible: false,
        dialogVisible: false,
      };
    },
    created() {
      this.getLatelyCancellation();
      // this.Personnel();
      this.getResult();
      this.getList();
    },
    methods: {
      beforeAvatarUpload(file){
            const isLt100M = file.size / 1024 / 1024 < 100;
               if (!isLt100M) {
                      this.$message.error('上传文件大小不能超过 100MB!');
                      return false
                  }
            },
      zhuceVisiblea(){
        this.zhuceVisible = false
      },
      submit() {
        if (this.mCancellation.fCancellationNumber == null) {
          this.$message.error("请填写注册登记号")
          return false
        } else if (this.mCancellation.fReservoirName == null) {
          this.$message.error("请填写水库名称")
          return false
        } else if (this.mCancellation.fDeclareUnit == null) {
          this.$message.error("请填写申报单位")
          return false
        } else if (this.mCancellation.fCompetentDepartment == null) {
          this.$message.error("请填写主管部门")
          return false
        } else if (this.mCancellation.fAddress == null) {
          this.$message.error("请填写所在地址")
          return false
        } else if (this.mCancellation.fPostalCode == null) {
          this.$message.error("请填写邮政编码")
          return false
        } else if (this.mCancellation.fRegistrationMechanism == null) {
          this.$message.error("请填写注册登记机构")
          return false
        } else if (this.mCancellation.fRegistrationDate == null) {
          this.$message.error("请填写注册登记日期")
          return false
        } else if (this.mCancellation.fReservoirName == null) {
          this.$message.error("请填写水库名称")
          return false
        } else if (this.mCancellation.fDamTypeMaterial == null) {
          this.$message.error("请填写坝型(材料)")
          return false
        } else if (this.mCancellation.fDamTypeStructure == null) {
          this.$message.error("请填写坝型(结构)")
          return false
        } else if (this.mCancellation.fRiver == null) {
          this.$message.error("请填写所在河流")
          return false
        } else if (this.mCancellation.fMaximumDamHeight == null) {
          this.$message.error("请填写最高坝高")
          return false
        } else if (this.mCancellation.fManagementUnit == null) {
          this.$message.error("请填写管理单位")
          return false
        } else if (this.mCancellation.fStartDate == null) {
          this.$message.error("请填写开工日期")
          return false
        } else if (this.mCancellation.fCompletionDate == null) {
          this.$message.error("请填写竣工日期")
          return false
        } else if (this.mCancellation.fTotalStorageCapacity == null) {
          this.$message.error("请填写总库容")
          return false
        } else if (this.mCancellation.fDiscardReason == null) {
          this.$message.error("请填写废弃原因")
          return false
        } else if (this.mCancellation.fApprovalNumber == null) {
          this.$message.error("请填写批准文号")
          return false
        } else if (this.mCancellation.fContentAbstract == null) {
          this.$message.error("请填写内容摘要")
          return false
        } else if (this.mCancellation.fApprovalUnit == null) {
          this.$message.error("请填写批准单位")
          return false
        } else if (this.mCancellation.fApprovalDate == null) {
          this.$message.error("请填写批准日期")
          return false
        } else if (this.mCancellation.fReasonRemarks == null) {
          this.$message.error("请填写废弃后果与相应原因")
          return false
        } else if (this.mCancellation.fPreparedBy == null) {
          this.$message.error("请填写编制人")
          return false
        } else {
          this.setNextCancellationInsert()
        }
      },

      /** 查询水库大坝注销 列表 */
      getList() {
        listCancellation().then(response => {
          this.cancellationList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      getResult() {
        getDictByType().then(response => {
          this.result1 = response.data
        })
      },
      // Personnel() {
      //   getUserList().then(response => {
      //     this.list = response.data
      //   })
      // },
      addSubmits() {
        if (this.active == 1) {
          this.setNextCancellationInsert();
        } else {
          this.setNextCancellationUpdate();
        }
      },
      setNextCancellationInsert() {
        this.mCancellation.fActPersion = this.radio;
        nextCancellationInsert(this.mCancellation).then(response => {
          this.msgSuccess("提交成功");
          this.getLatelyCancellation();
          this.nextVisible = false;
          this.zhuceVisible = false;
        });
      },
      setNextCancellationUpdate() {
        console.log("this.setNextCancellationUpdate();")
        this.mCancellation.fActPersion = this.radio;
        nextCancellationUpdate(this.mCancellation).then(response => {
          this.msgSuccess("提交成功");
          this.getLatelyCancellation();
          this.nextVisible = false;
          this.zhuceVisible = false;
        });
      },
      getFile() {
        this.loading = true;
        this.fileList = [];
        console.log('22222222222222',this.mCancellation.fCancellationFileId)
        if (this.mCancellation.fCancellationFileId) {
          getFileById({
            id: this.mCancellation.fCancellationFileId
          }).then(result => {
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              this.loading = false;
              console.log(this.fileList);
            }
          })
        }
      },
      getLatelyCancellation() {
        this.loading = true;
        latelyCancellation().then(response => {
          this.mCancellation = response;
          this.loading = false;
          if(this.mCancellation.fCancellationFileId){
            this.getFile();
          }

          if (this.mCancellation.fDamTypeMaterial) {
            this.mCancellation.fDamTypeMaterial = this.mCancellation.fDamTypeMaterial.toString();
          }
          if (this.mCancellation.fDamTypeStructure) {
            this.mCancellation.fDamTypeStructure = this.mCancellation.fDamTypeStructure.toString();
          }
          if (this.mCancellation.fAuditResult) {
            this.mCancellation.fAuditResult = this.mCancellation.fAuditResult.toString();
          }
          if (this.mCancellation.fReviewResult) {
            this.mCancellation.fReviewResult = this.mCancellation.fReviewResult.toString();
          }
          if (this.mCancellation.fAuditResult) {
            this.mCancellation.fAuditResult = this.mCancellation.fAuditResult.toString();
          }

          if (this.mCancellation.fAuditDate) {
            this.active = 4;
          } else if (this.mCancellation.fReviewDate && this.mCancellation.fReviewResult == 1) {
            this.active = 3;
          } else if (this.mCancellation.fPreparationTime && !this.mCancellation.fReviewResult) {
            this.active = 2;
          } else {
            this.active = 1;
          }
        });
      },
      /** 新增按钮操作 */
      handleAdd() {
        console.log("新增按钮操作");
        addCancellation(this.mCancellation).then(response => {
          this.msgSuccess("新增成功");
          this.getLatelyCancellation();
        });
      },
      /** 变更按钮操作 */
      handleUpdate() {
        console.log("变更按钮操作");
        updateCancellation(this.mCancellation).then(response => {
          this.msgSuccess("变更成功");
          this.getLatelyCancellation();
        });
      },
      newNull() {
        this.active = 1;
        this.zhuceVisible = true;
        this.fileList = [];
        this.mCancellation = {};
      },
      dialog(row) {
        this.dialogVisible = true;
        this.mCancellationRow = row;
        if (this.mCancellationRow.fDamTypeMaterial) {
          this.mCancellationRow.fDamTypeMaterial = this.mCancellationRow.fDamTypeMaterial.toString();
        }
        if (this.mCancellationRow.fDamTypeStructure) {
          this.mCancellationRow.fDamTypeStructure = this.mCancellationRow.fDamTypeStructure.toString();
        }
        if (this.mCancellationRow.fAuditResult) {
          this.mCancellationRow.fAuditResult = this.mCancellationRow.fAuditResult.toString();
        }
        if (this.mCancellationRow.fReviewResult) {
          this.mCancellationRow.fReviewResult = this.mCancellationRow.fReviewResult.toString();
        }
        if (this.mCancellationRow.fAuditResult) {
          this.mCancellationRow.fAuditResult = this.mCancellationRow.fAuditResult.toString();
        }
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.mCancellation.fCancellationFileId);
        this.mCancellation.fCancellationFileId = '';
      },
      uploadedSuccess(response, file, fileList) {
        this.mCancellation.fCancellationFileId = response.data.fId;
        this.getFile();
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      handlePreview() {
        // window.location.href = this.fileList[0].url;
		window.open(this.fileList[0].url);
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
