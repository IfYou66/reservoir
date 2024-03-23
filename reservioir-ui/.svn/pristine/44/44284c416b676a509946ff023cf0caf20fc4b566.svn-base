<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
        <div style="margin-right: 15px">
          <el-button type="primary" size="small" @click="zhuceVisiblea">取消</el-button>
          <el-button type="primary" size="small" @click="zhuceVisiblea">保存</el-button>
        </div>
      </el-col>
    </el-row>
    <div class="registrationDetail-top">
      <div class="registrationDetail-top-titel">
        中型水库大坝注销登记表
      </div>
      <div class="registrationDetail-top-div">
        <span>注册登记号：</span>
        <el-input v-model="mCancellation.fCancellationNumber" placeholder="" class="registrationDetail-top-input">
        </el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>水库名称：</span>
        <el-input v-model="mCancellation.fReservoirName" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>申报单位：</span>
        <el-input v-model="mCancellation.fDeclareUnit" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>主管部门：</span>
        <el-input v-model="mCancellation.fCompetentDepartment" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>所在地址：</span>
        <el-input v-model="mCancellation.fAddress" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:10px;">
        <span>邮政编码：</span>
        <el-input v-model="mCancellation.fPostalCode" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:2px;margin-left: -10px;">
        <span>注册登记机构：</span>
        <el-input v-model="mCancellation.fRegistrationMechanism" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;"></el-input>
      </div>
      <div class="registrationDetail-top-div1" style="letter-spacing:2px;margin-left: -10px;">
        <span>注册登记日期：</span>
        <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
          v-model="mCancellation.fRegistrationDate" style="width: 250px;" type="date" placeholder="选择日期">
        </el-date-picker>
      </div>
      <div class="registrationDetail-top-div" style="margin-top: 50px;margin-left: -200px;">
        水利部大坝安全管理中心 编制
      </div>
    </div>

    <el-divider></el-divider>

    <div class="registrationDetail-center">
      <div class="registrationDetail-top-div">
        <el-input v-model="mCancellation.fReservoirName" placeholder="" class="registrationDetail-top-input"></el-input>
        水库大坝注销登记审查意见表
      </div>
      <div style="text-align: right;">
        注册登记号：
        <el-input v-model="mCancellation.fCancellationNumber" placeholder="" class="registrationDetail-top-input"
          style="width: 250px;border: none !important;"></el-input>
      </div>
    </div>
    <div class="from-div">
      <!-- <el-row>
        <el-col :span="24" class="from-div-title" style="background-color: rgba(215, 215, 215, 1); text-align: right;">
          <div style="margin-right: 15px">
            <el-button type="primary" size="small">注销</el-button>
          </div>
        </el-col>
      </el-row> -->
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

    <el-divider></el-divider>

    <div class="from-div">
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          水库名称
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fReservoirName" placeholder="" style="width: 100%;"></el-input>
        </el-col>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          注册登记号
        </el-col>
        <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fCancellationNumber" placeholder="" style="width: 100%;"></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          建设地点
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fAddress" placeholder="" style="width: 100%;"></el-input>
        </el-col>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          坝型 材料/结构
        </el-col>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-select v-model="mCancellation.fDamTypeMaterial" placeholder="请选择" style="width: 100%;">
            <el-option v-for="item in result1.dam_material" :key="item.dictValue" :label="item.dictLabel"
              :value="item.dictValue">
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="4" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-select v-model="mCancellation.fDamTypeStructure" placeholder="请选择" style="width: 100%;">
            <el-option v-for="item in result1.dam_structure" :key="item.dictValue" :label="item.dictLabel"
              :value="item.dictValue" style="width: 100%;">
            </el-option>
          </el-select>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          所在河流
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fRiver" placeholder="" style="width: 100%;"></el-input>
        </el-col>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          最高坝高
        </el-col>
        <el-col :span="8" style=" text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fMaximumDamHeight" placeholder="" style="width: 100%;"></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          管理单位
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fManagementUnit" placeholder="" style="width: 100%;"></el-input>
        </el-col>
        <el-col :span="2" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 40px;">
          建设
        </el-col>
        <el-col :span="2"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          开工
        </el-col>
        <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <div class="block">
            <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
              v-model="mCancellation.fStartDate" type="date" placeholder="选择开工日期">
            </el-date-picker>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          总库容
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <el-input v-model="mCancellation.fTotalStorageCapacity" placeholder="" style="width: 100%;" size="mini">
          </el-input>
        </el-col>
        <el-col :span="2"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          日期
        </el-col>
        <el-col :span="2"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 40px;">
          竣工
        </el-col>
        <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;line-height: 39px;">
          <div class="block">
            <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"
              v-model="mCancellation.fCompletionDate" type="date" placeholder="选择竣工日期">
            </el-date-picker>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 60px;">
          <div>废</div>
          <div>弃</div>
          <div>原</div>
          <div>因</div>
        </el-col>
        <el-col :span="8"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;height: 237px;">
          <el-input  maxlength="500" show-word-limit type="textarea" :rows="6" placeholder="请输入内容" v-model="mCancellation.fDiscardReason">
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
        <el-col :span="8" style="height: 220px;padding: 10px;">
          <div>
            批准文号：
            <el-input v-model="mCancellation.fApprovalNumber" placeholder="" style="width: 50%;"></el-input>
          </div>
          <div>
            内容摘要：
            <el-input maxlength="500" show-word-limit  type="textarea" :rows="6" placeholder="" v-model="mCancellation.fContentAbstract">
            </el-input>
          </div>
          </el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 110px;">
          废弃后果与相应原因
        </el-col>
        <el-col :span="8" style="border-right: #a4d5ff 1px solid; text-align: center;line-height: 110px;">
          <el-input maxlength="500" show-word-limit  type="textarea" :rows="4" placeholder="请输入内容" v-model="mCancellation.fReasonRemarks">
          </el-input>
        </el-col>
        <el-col :span="4"
          style="border-right: #a4d5ff 1px solid; text-align: center;border-bottom: #a4d5ff 1px solid;line-height: 110px; color: #FFFFFF;">
          是
        </el-col>
        <el-col :span="8" style="border-bottom: #a4d5ff 1px solid;height: 110px;">
          <div>
            批准单位：
            <el-input v-model="mCancellation.fApprovalUnit" placeholder="" style="width: 50%;"></el-input>
          </div>
          <div>
            （盖章）
          </div>
          <div style="text-align: right;margin-top: 0px;">
            <el-date-picker format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss"
              v-model="mCancellation.fApprovalDate" style="width: 250px;" type="date" placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-col>
      </el-row>
    </div>

    <el-divider></el-divider>

    <div class="registrationDetail-center">
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
        14、圳型:水库大圳的坝型。王坝分?均质坝、心墙坝、斜墙坝、面板坝寺﹔混j土坝分:混凝土重力坝、混凝土拱坝等;浆砌石坝分:浆砌石重力坝、浆砌石拱坝等。<br />
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
    getToken
  } from "@/utils/auth";
  import {
    getFileById
  } from "@/api/file";
  export default {
    props: ['fileList', 'mCancellation', 'result1'],
    data() {
      return {
        // 文件上传
        upload: {
          headers: {
            Authorization: "Bearer " + getToken()
          },
          url: process.env.VUE_APP_BASE_API + "/file/upload"
        },

        dialogVisible: false,
        textarea: '',
        value1: '',
        value2: '',
        value3: '',
        value4: '',
        input: '',
        value: '',
        textarea1: '',
        textarea2: '',
        options: [{
          value: '选项1',
          label: '通过'
        }, {
          value: '选项2',
          label: '未通过'
        }],
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
      console.log("fileList", this.fileList, "mCancellation", this.mCancellation);

    },
    methods: {
      zhuceVisiblea(){
        this.$emit('zhuceVisiblea');
      },
      dialog() {
        this.dialogVisible = true
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(
          `当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      uploadedSuccess(response, file, fileList) {
        this.mCancellation.fCancellationFileId = response.data.fId
      },
      handleRemove(file, fileList) {
        this.mCancellation.fCancellationFileId = '';
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      handleExceed(files, fileList) {
        this.$message.warning(
          `当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      handlePreview() {}
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
