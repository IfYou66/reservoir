<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="名称" prop="roleName">
        <el-input v-model="queryParams.fMaterialsName" placeholder="请输入物资名称" clearable size="small" style="width: 240px"
          @keyup.enter.native="selMaterials" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="selMaterials">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="newNull">重置</el-button>
        <el-button icon="el-icon-plus" type="primary" size="mini" @click="resetQuery('1')">物资录入</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="materialsList" style="margin:0 auto;" border>
      <el-table-column label="序号" align="center" type="index" width="75" />
      <el-table-column label="物资名称" align="center" width="150px;" prop="fMaterialsName" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column label="分类" align="center" width="120px;" prop="fClassify">
        <template slot-scope="scope">
          <span v-for="(item,index) in audit.floodMaterialsType" :key="index"
            v-if="item.dictValue == scope.row.fClassify">
            {{ item.dictLabel }}
          </span>
        </template>
      </el-table-column>
      <el-table-column label="规格型号" align="center" width="150px;" prop="fSpecification" :show-overflow-tooltip="true" />
      <el-table-column label="有效期" align="center" width="200px;" prop="fEffective" :show-overflow-tooltip="true" />
      <el-table-column label="存储地点" align="center" width="200px;" prop="fStorageAddress" />
      <el-table-column label="存储要求" align="center" width="200px;" prop="fStorageRequirement" />
      <el-table-column label="用途" align="center" width="200px;" prop="fPurpose" />
      <el-table-column label="生产厂家" align="center" width="200px;" prop="fManufacturer" />
      <el-table-column label="单位" align="center" width="100px;" prop="fUnit" />
      <el-table-column label="单价" align="center" width="100px;" prop="fPrice" />
      <el-table-column label="定额数量" align="center" width="100px;" prop="fExpectNum" />
      <el-table-column label="数量" align="center" width="100px;" prop="fNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="resetQuery('2', scope.row)">台账
          </el-button>
          <el-button size="mini" type="text" @click="setMaterialsDetail('1', scope.row)">入库
          </el-button>
          <el-button size="mini" type="text" @click="setMaterialsDetail('2', scope.row)">
            出库
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="防汛物资录入" :visible.sync="addAllMaterials" width="1500px">
      <div class="from-div" style="border-bottom: none !important;">
        <el-row>
          <el-col :span="24" class="from-div-title">
            物资信息采集
          </el-col>
        </el-row>
        <div v-for="(items,index) in setMaterialsArr" :key="index" style="margin-bottom: 20px;">
          <el-row class="from-border-bottom" style="border-top: #a4d5ff 1px solid;">
            <el-col :span="3" class="from-col-left">
              物资名称
            </el-col>
            <el-col :span="5" class="from-border-right">
              <el-input v-model="items.fMaterialsName" placeholder="请输入内容"></el-input>
            </el-col>
            <el-col :span="2" class="from-col-left">
              规格型号
            </el-col>
            <el-col :span="4" class="from-border-right">
              <el-input v-model="items.fSpecification" placeholder="请输入内容"></el-input>
            </el-col>
            <el-col :span="3" class="from-col-left">
              有效期
            </el-col>
            <el-col :span="6" style="text-align: center ;line-height: 40px;">
              <el-date-picker type="date" v-model="items.fEffective" style="width:100%;" placeholder="时间"
                format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
              </el-date-picker>
            </el-col>
          </el-row>
          <el-row class="from-border-bottom">
            <el-col :span="3" class="from-col-left">
              储存地点
            </el-col>
            <el-col :span="5" class="from-border-right">
              <el-input v-model="items.fStorageAddress" placeholder="请输入内容"></el-input>
            </el-col>
            <el-col :span="2" class="from-col-left">
              用途
            </el-col>
            <el-col :span="4" class="from-border-right">
              <el-input v-model="items.fPurpose" placeholder="请输入内容"></el-input>
            </el-col>
            <el-col :span="3" class="from-col-left">
              生产厂家
            </el-col>
            <el-col :span="7" class="from-col-left">
              <el-input v-model="items.fManufacturer" placeholder="请输入内容"></el-input>
            </el-col>
          </el-row>
          <el-row class="from-border-bottom">
            <el-col :span="3" class="from-col-left">
              分类
            </el-col>
            <el-col :span="5" class="from-border-right">
              <el-select v-model="items.fClassify" placeholder="请选择">
                <el-option v-for="item in audit.floodMaterialsType" :key="item.dictValue" :label="item.dictLabel"
                  :value="item.dictValue">
                </el-option>
              </el-select>
            </el-col>
            <el-col :span="2" class="from-col-left">
              存储要求
            </el-col>
            <el-col :span="4" class="from-border-right">
              <el-input v-model="items.fStorageRequirement" placeholder="请输入内容"></el-input>
            </el-col>
            <el-col :span="3" class="from-col-left">
              单位 | 单价
            </el-col>
            <el-col :span="3" class="from-col-left">
              <el-input v-model="items.fUnit" placeholder="请输入单位" width="100%"></el-input>
            </el-col>
            <el-col :span="4" class="from-col-left">
              <el-input v-model="items.fPrice" placeholder="请输入单价" width="100%"></el-input>
            </el-col>
          </el-row>
          <el-row class="from-border-bottom">
            <el-col :span="3" class="from-col-left">
              定额数量
            </el-col>
            <el-col :span="5" class="from-border-right">
              <el-input v-model="items.fExpectNum" placeholder="请输入内容"></el-input>
            </el-col>
          </el-row>
          <el-button v-if="setMaterialsArr.length>1" type="danger" @click="danger(index)">-删除</el-button>
        </div>
      </div>
      <div style="width: 80%;margin:0 auto;">
        <el-button type="primary" @click="addMaterialsArr">+添加</el-button>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addAllMaterials = false">取 消</el-button>
        <el-button type="primary" @click="insertMaterials">提交</el-button>
      </span>
    </el-dialog>
    <el-dialog title="预案详情" :visible.sync="dialogVisible1" width="1500px">
      <el-form :model="queryDetailParams" ref="queryForm" v-show="showSearch" :inline="true">
        <el-form-item label="时间" prop="roleName">
          <el-date-picker type="date" v-model="queryDetailParams.startTime" style="width:200px;" placeholder="结束时间"
            format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
          </el-date-picker>
          ~
          <el-date-picker type="date" v-model="queryDetailParams.endTime" style="width:200px;" placeholder="结束时间"
            format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="selLinklist">搜索</el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="loading" :data="linkList" border>
        <el-table-column label="序号" align="center" type="index" width="75" />
        <el-table-column width="100px" label="操作类型" align="center" prop="fAccountType" :show-overflow-tooltip="true">
          <template slot-scope="scope">
            <span v-if="scope.row.fAccountType == 1">入库</span>
            <span v-else>出库 </span>
          </template>
        </el-table-column>
        <el-table-column label="时间" width="200px" align="center" prop="fAccountDate" :show-overflow-tooltip="true" />
        <!-- <el-table-column label="名称" align="center" :prop="fMaterialsName" width="230" /> -->
        <el-table-column width="100px" label="名称" align="center" :show-overflow-tooltip="true">
          <span>{{ fMaterialsName }}</span>
        </el-table-column>
        <el-table-column width="100px" label="名称" align="center" :show-overflow-tooltip="true">
          <span>{{ fSpecification }}</span>
        </el-table-column>
        <el-table-column label="单位" align="center" prop="fUnit" width="100" />
        <el-table-column label="数量" align="center" prop="fAccountNum" />
        <el-table-column label="单价" align="center" prop="fPrice" />
        <el-table-column label="金额" align="center" prop="fTotalPrice" />
        <el-table-column label="备注" align="center" prop="fRemarks" width="300" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible1 = false">关闭</el-button>
      </span>
    </el-dialog>

    <el-dialog :title="materialsDetailTitle" :visible.sync="openMaterialsDetail" width="700px">
      <el-form ref="form" :model="materialsDetail" :rules="materialsDetail" label-width="120px" :inline="true"
        class="demo-form-inline">
        <el-form-item label="单号" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fAccountCode" placeholder="请输入单号" />
        </el-form-item>
        <el-form-item label="数量" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fAccountNum" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="单位" prop="">
          <el-input readonly style="width:200px;" v-model="materialsDetail.fUnit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="时间" prop="">
          <el-date-picker type="date" v-model="materialsDetail.fAccountDate" style="width:200px;" placeholder="时间"
            format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd HH:mm:ss">
          </el-date-picker>
        </el-form-item>
        <el-form-item :label="fAccountPeopleLabel" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fAccountPeople"
            :placeholder="fAccountPeoplePlaceholder" />
        </el-form-item>
        <el-form-item label="保管人" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fSafekeepingPeople" placeholder="请输入物资保管人" />
        </el-form-item>
        <el-form-item label="审核人" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fReviewPeople" placeholder="请输入物资审核人" />
        </el-form-item>
        <el-form-item label="批准人" prop="">
          <el-input style="width:200px;" v-model="materialsDetail.fAuditPeople" placeholder="请输入物资批准人" />
        </el-form-item>
        <el-form-item label="备注">
          <el-input style="width: 510px;" v-model="materialsDetail.fRemarks" :autosize="{ minRows: 4, maxRows: 6}"
            maxlength="500" show-word-limit   type="textarea" placeholder="请输入备注内容"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="insertMaterialsDetail">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" />
  </div>
</template>

<script>
  import {
    listMaterialsDetail,
    getMaterialsDetail,
    delMaterialsDetail,
    addMaterialsDetail,
    updateMaterialsDetail
  } from "@/api/security/materialsDetail";
  import {
    getDictByType,
    listMaterials,
    getMaterials,
    delMaterials,
    addMaterials,
    updateMaterials,
    insertAllMFloodMaterials
  } from "@/api/security/materials.js";
  export default {
    data() {
      return {
        audit: {},
        fSpecification: '',
        fMaterialsName: '',
        fAccountPeoplePlaceholder: '',
        fAccountPeopleLabel: '',
        materialsDetailTitle: '',
        materialsDetail: {},
        company: '',
        form: {
          number: '',
          time: '',
          outGoer: '',
          custodian: '',
          check: '',
          approve: '',
          remark: ''
        },
        setMaterialsArr: [{
          fMaterialsName: '',
          fClassify: '',
          fSpecification: '',
          fEffective: '',
          fStorageAddress: '',
          fStorageRequirement: '',
          fExpectNum: '',
          fPurpose: '',
          fManufacturer: '',
          fPrice: '',
          fUnit: ''
        }],
        textarea: '',
        value1: '',
        value2: '',
        values2: '',
        input: '',
        addAllMaterials: false,
        dialogVisible1: false,
        dialogVisible2: false,
        openMaterialsDetail: false,
        // 遮罩层
        loading: false,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 数据
        materialsList: [],
        linkList: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          fMaterialsName: undefined
        },
        // 查询参数
        queryDetailParams: {
          pageNum: 1,
          pageSize: 10,
          fFloodMaterialsId: undefined,
          startTime: undefined,
          endTime: undefined,
        },
      };
    },
    created() {
      this.getMaterialsList();
      this.getDitc();
    },
    methods: {
      newNull() {
        this.queryParams = {
          pageNum: 1,
          pageSize: 10,
          fMaterialsName: undefined
        },
        this.getMaterialsList();
      },
      getDitc() {
        getDictByType().then(response => {
          this.audit = response.data
        })
      },
      /** 查询物资台账信息 列表 */
      getDetailList() {
        listMaterialsDetail(this.queryDetailParams).then(response => {
          this.linkList = response.rows;
          // this.total = response.total;
        });
      },
      insertMaterials() {
        var flag = true;
        for(var i = 0; i < this.setMaterialsArr.length; i++){
          if(this.setMaterialsArr[i].fPrice.length == 0){
            this.$message.error("请填单价")
            flag = false;
          }
        }
        if(flag){
          insertAllMFloodMaterials(this.setMaterialsArr).then(response => {
            this.msgSuccess("物资录入成功");
            this.addAllMaterials = false;
            this.getMaterialsList();
          });
        }
      },
      insertMaterialsDetail() {
        addMaterialsDetail(this.materialsDetail).then(response => {
          this.msgSuccess("修改成功");
          this.openMaterialsDetail = false;
          this.materialsDetail = {};
          this.getMaterialsList();
        });
      },
      setMaterialsDetail(val, row) {
        if (val == 1) {
          this.materialsDetailTitle = "防汛物资入库";
          this.fAccountPeopleLabel = "入库人";
          this.fAccountPeoplePlaceholder = "请输入物资入库人";
        }
        if (val == 2) {
          this.materialsDetailTitle = "防汛物资出库";
          this.fAccountPeopleLabel = "出库人";
          this.fAccountPeoplePlaceholder = "请输入物资出库人";
        }
        this.materialsDetail.fFloodMaterialsId = row.fId;
        this.materialsDetail.fUnit = row.fUnit;
        this.materialsDetail.fPrice = row.fPrice;
        this.materialsDetail.fAccountType = val;
        this.openMaterialsDetail = true;
      },
      /** 查询防汛物资 列表 */
      getMaterialsList() {
        this.loading = true;
        listMaterials(this.queryParams).then(response => {
          this.materialsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      danger(val) {
        this.setMaterialsArr.splice(1, 1);
        console.log("splice", this.setMaterialsArr);
      },
      addMaterialsArr() {
        var item = {
          fMaterialsName: '',
          fClassify: '',
          fSpecification: '',
          fEffective: '',
          fStorageAddress: '',
          fStorageRequirement: '',
          fExpectNum: '',
          fPurpose: '',
          fManufacturer: '',
          fPrice: '',
          fUnit: ''
        }
        this.setMaterialsArr.push(item);
      },
      resetQuery(val, row) {
        if (val == '1') {
          this.addAllMaterials = true
        }
        if (val == '2') {
          this.queryDetailParams.fFloodMaterialsId = row.fId;
          this.fMaterialsName = row.fMaterialsName;
          this.fSpecification = row.fSpecification;
          this.dialogVisible1 = true;
          this.startTime = undefined;
          this.endTime = undefined;
          this.getDetailList();
        }
      },
      cancel() {
        this.dialogVisible2 = false;
        this.openMaterialsDetail = false;
      },
      /** 搜索按钮操作 */
      selMaterials() {
        this.queryParams.pageNum = 1;
        this.getMaterialsList();
      },
      /** 搜索按钮操作 */
      selLinklist() {
        this.queryParams.pageNum = 1;
        this.getDetailList();
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
