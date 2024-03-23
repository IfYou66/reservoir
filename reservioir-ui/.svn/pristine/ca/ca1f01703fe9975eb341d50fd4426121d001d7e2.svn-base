<template>
  <div class="app-container">
     <el-row class="from-top">
      <!-- <el-col :span="24">
        <el-steps :active="1" simple>
          <el-step title="物资编制" icon="el-icon-edit"></el-step>
          <el-step title="物资审核" icon="el-icon-upload"></el-step>
          <el-step title="物资批准" icon="el-icon-picture"></el-step>
          <el-step title="入库完成" icon="el-icon-picture"></el-step>
        </el-steps>
      </el-col> -->
      <el-col :span="24">
        <div style="margin: 0 auto;display: flex;align-items: center;justify-content:center;width: 80% ;">
          <div style="position: relative;">
            <img src="../../../assets/images/01s.png"/>
            <div  style="position: absolute;top: 17px;left: 23px;width: 50%;color: #FFFFFF;">物资编制</div>
          </div>
          <div  style="position: relative;width: 20%;" >
            <img :src="require(active>1? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
            <img v-if="active==1" src="../../../assets/images/07.gif" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
            </div>
          <div  style="position: relative;">
            <img :src="require(active>1? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
            <div  :style="active>1? 'position: absolute;top:17px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 17px;left: 23px;width: 50%;color: #999999;'">物资审核</div>
            </div>
          <div  style="position: relative;width: 20%;">
            <img :src="require(active>2? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
            <img v-if="active==2 || active==1" src="../../../assets/images/07.gif" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
            </div>
          <div   style="position: relative;">
            <img :src="require(active>2? '../../../assets/images/01s.png':'../../../assets/images/01.png')"/>
            <div  :style="active>1? 'position: absolute;top:17px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 17px;left: 23px;width: 50%;color: #999999;'">物资批准</div>
            </div>
            <div  style="position: relative;width: 20%;">
              <img :src="require(active==4? '../../../assets/images/04.png':'../../../assets/images/05.png')" style="width: 100%;height: 18px;"/>
              <img v-if="active!=4" src="../../../assets/images/07.gif" style="position: absolute;top: 0px;left: 100px;height: 80%;width: 10%;"/>
              </div>
            <div   style="position: relative;">
              <img :src="require(active==4? '../../../assets/images/01s.png':'../../../assets/images/01.png')" />
              <div  :style="active>1? 'position: absolute;top: 17px;left: 23px;width: 50%;color: #FFFFFF;':'position: absolute;top: 17px;left: 23px;width: 50%;color: #999999;'">入库完成</div>
              </div>
        </div>
      </el-col>
    </el-row>
    <div  class="from-div">

      <el-row>
        <el-col :span="24"
        class="from-div-title"
        style="background-color: rgba(215, 215, 215, 1); text-align: right;"
         >
        <div>
          <el-button type="primary"  size="small">提交</el-button>
          <el-button type="primary" size="small">审核</el-button>
          <el-button type="primary" style="margin-right:10px;" size="small">批准</el-button>
        </div>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="24"
        class="from-div-title">物资入库审批表</el-col>
      </el-row>
      <el-row class="from-border-bottom" >
        <el-col :span="3" class="from-col-left" >
          物资名称
        </el-col>
        <el-col :span="8" class="from-border-right" >
          <el-input v-model="input" placeholder="请输入内容"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left" >
          规格型号
        </el-col>
        <el-col :span="3" style="line-height: 40px;border-right: #a4d5ff 1px solid;">
            <div>
              <el-select v-model="value" placeholder="请选择">
                <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
        </el-col>
        <el-col :span="3" class="from-col-left" >
          单位
        </el-col>
        <el-col :span="4" class="from-border-right" >
          <el-input v-model="input" placeholder="单位"></el-input>
        </el-col>
      </el-row>


       <el-row class="from-border-bottom" >
        <el-col :span="3" class="from-col-left" >
          数量
        </el-col>
        <el-col :span="8" class="from-border-right" >
          <el-input v-model="input" placeholder="请输入内容"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left" >
          单价
        </el-col>
        <el-col :span="3" class="from-border-right" >
          <el-input v-model="input" placeholder="金额"></el-input>
        </el-col>
        <el-col :span="3" class="from-col-left" >
          金额
        </el-col>
        <el-col :span="4" class="from-border-right" >
          <el-input v-model="input" placeholder="金额"></el-input>
        </el-col>
      </el-row>



      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          备注
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            备注：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" v-model="textarea"   placeholder="请输入内容">
          </el-input>
            <div style="text-align:right">
              <span >编制人：<el-input v-model="input"  placeholder="请输入内容" style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration">时间：</span>
                <el-date-picker
                  type="dates"
                  v-model="info.stockDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="disabled">
                </el-date-picker>
              </div>
          </div>
        </el-col>
      </el-row>


      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          入库说明
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            入库说明：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" v-model="textarea"   placeholder="请输入内容">
          </el-input>
            <div style="text-align:right">
              <span >入库人：<el-input v-model="input"  placeholder="请输入内容" style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration">时间：</span>
                <el-date-picker
                  type="dates"
                  v-model="info.stockDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="disabled">
                </el-date-picker>
              </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          保管说明
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            保管说明：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" v-model="textarea"   placeholder="请输入内容">
          </el-input>
            <div style="text-align:right">
              <span >保管人：<el-input v-model="input"  placeholder="请输入内容" style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration">时间：</span>
                <el-date-picker
                  type="dates"
                  v-model="info.stockDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="disabled">
                </el-date-picker>
              </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          物资审核
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审核意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" v-model="textarea"   placeholder="请输入内容">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审核结果：
              </div>
              <el-select v-model="value2" clearable placeholder="请选择">
                <el-option v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审核人：<el-input v-model="input"  placeholder="请输入内容" style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration">时间：</span>
                <el-date-picker
                  type="dates"
                  v-model="info.stockDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="disabled">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row class="from-border-bottom">
        <el-col :span="3" class="from-col">
          物资批准
        </el-col>
        <el-col :span="21" style="height: 50px;">
          <div style="font-size: 16px;font-weight: 700;padding: 10px;">
            审批意见：
          </div>
          <el-input  maxlength="500" show-word-limit  type="textarea" :rows="3" v-model="textarea"   placeholder="请输入内容">
          </el-input>
          <div class="from-select">
            <div style="margin-left: 10px;">
              <div style="font-size: 16px;font-weight: 700;display:inline;">
                审批结果：
              </div>
              <el-select v-model="value2" clearable placeholder="请选择">
                <el-option v-for="item in audit" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div>
              <span >审批人：<el-input v-model="input"  placeholder="请输入内容" style="width:180px;"></el-input></span>
              <div class="block"  style="display:inline;margin-left:10px;">
                <span class="demonstration">时间：</span>
                <el-date-picker
                  type="dates"
                  v-model="info.stockDate"
                  placeholder="选择日期"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  :disabled="disabled">
                </el-date-picker>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
      <el-table v-loading="loading" :data="data" border>
        <el-table-column label="序号" align="center" prop="id" width="120"/>
        <el-table-column label="物资名称" align="center" prop="planName" :show-overflow-tooltip="true" />
        <el-table-column label="规格型号" align="center" prop="num" :show-overflow-tooltip="true" />
        <el-table-column label="单位" align="center" prop="status" />
        <el-table-column label="数量" align="center" prop="progressStatus" />
        <el-table-column label="单价" align="center" prop="progressStatus" />
        <el-table-column label="金额" align="center" prop="status" />
        <el-table-column label="备注" align="center" prop="status" />
        <el-table-column label="时间" align="center" prop="planningTime" :show-overflow-tooltip="true" />
        <el-table-column label="入库人" align="center" prop="status" />
        <el-table-column label="保管人" align="center" prop="status" />
        <el-table-column label="审核人" align="center" prop="status" />
        <el-table-column label="批准人" align="center" prop="status" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="188">
          <template slot-scope="scope" >
              <el-button
                size="mini"
                type="text"
              >删除
              </el-button>
              <el-button
                size="mini"
                type="text"
              >编辑
              </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
export default {

    data() {
      return {
        active:1,
        info: {
          stockDate:this.getNowTime(),  //日期
        },
        data: [{
        id: '1',
        planName: '抢险物资1',
        num:'A10001',
        planningTime: '2021-07-05 16:00:00',
        progressStatus: '2卷',
        status: '第一仓库',
        time:'2年'
      },
        {
          id: '2',
          planName: '抢险物资3',
          num:'A10002',
          planningTime: '2021-07-05 16:00:00',
          progressStatus: '3卷',
          status: '第一仓库',
          time:'2年'
        },
        {
          id: '3',
          num:'A10003',
          planName: '抢险物资3',
          planningTime: '2021-07-05 16:00:00',
          progressStatus: '2张',
          status: '第一仓库',
          time:'2年'
        }],

        data1: [{
          id: '1',
          planName: '入库',
          num:'1卷说明',
          planningTime: '2021-07-05 16:00:00',
          progressStatus: '100卷',
          status: '2卷',
          time:'李所长'
        },
          {
            id: '2',
            planName: '出库',
            num:'1卷说明',
            planningTime: '2021-07-05 16:00:00',
            progressStatus: '100卷',
            status: '2卷',
            time:'李所长'
          },
          {
            id: '3',
            num:'1卷说明',
            planName: '入库',
            planningTime: '2021-07-05 16:00:00',
            progressStatus: '100张',
            status: '2卷',
            time:'李所长'
          }],
        textarea:'',
        value1: '',
        value2: '',
        value3: '',
        value4: '',
        input:'',
        value: '',
        textarea1:'',
        textarea2:'',
        fileList: [{
          name: '计划内容.docx',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }],
        audit: [{
          value: '选项1',
          label: '通过'
        }, {
          value: '选项2',
          label: '未通过'
        }],
        options: [{
          value: '选项1',
          label: '年度养护'
        }, {
          value: '选项2',
          label: '汛前养护'
        }, {
          value: '选项3',
          label: '汛后养护'
        }, {
          value: '选项3',
          label: '日常养护'
        }],
      };
    },
    created() {

    },
    methods: {
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


    }
  };
</script>
<style lang="scss" >
  .color409 {
    color: #409eff;
    cursor: pointer;
  }




</style>
