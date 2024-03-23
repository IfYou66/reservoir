<template>
  <div style="width: 100%;">
    <div id="allmap" style="width:96%;margin: 0 auto;"></div>
    <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click" style="position: absolute;right: 200px;top: 50px;z-index: 9999;">
      <div class="avatar-wrapper">
          <el-button>
            附件下载<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
      </div>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item   v-for="(arr,index) in fileList" :key="index" style="padding: 5px 20px 5px 20px">
          <span style="margin-right: 10px;">{{arr.name}}</span>
          <el-button @click="download(arr.url)"   size="small"  icon="el-icon-download" >下载</el-button>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

    <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click" style="position: absolute;right: 82px;top: 50px;z-index: 9999;">
      <div class="avatar-wrapper" @click="clickWrapper">
          <el-button icon="el-icon-s-flag">
            界桩操作
          </el-button>
      </div>
      <el-dropdown-menu  v-show="false"></el-dropdown-menu>

    </el-dropdown>
    <!-- <div style="width: 40%;font-size: 22px;line-height: 35px;padding: 30px;font-weight:bold;"> -->
      <!-- <el-table
          :data="tableData"
          border
          style="width: 100%;margin-top:30px;">
          <el-table-column
            prop="annex"
            label="附件名称"
            >
          </el-table-column>
          <el-table-column
            prop="address"
            label="操作">
            下载
          </el-table-column>
        </el-table> -->
    <!-- </div> -->

    <el-dialog title="界桩操作" :visible.sync="open" width="700px" >

      <el-form   :model="form" ref="form" class="demo-form-inline" >

        <el-form-item label="中心坐标" >
          <el-input style="width:200px" v-model="form.fCenterPoint" placeholder="中心坐标" />
           <div style="color: red;margin-left: 100px;">
             注：经度纬度之间需要逗号分隔
           </div>
        </el-form-item>
        <el-form-item label="坐标">
          <el-input style="width:400px" v-model="form.fLabel" placeholder="坐标"   type="textarea"
            :rows="4"/>
            <div style="color: red;margin-left: 100px;">
              注：经度纬度之间需要逗号分隔，多个坐标之间需要分号分隔。
            </div>
        </el-form-item>
        <el-upload style="margin-left: 105px;margin-top: 15px" class="upload-demo" :headers="GLOBAL.headers()"
         :before-upload = "beforeAvatarUpload"
          :action="GLOBAL.httpUrl" :on-preview="handlePreview" :on-remove="handleRemove"
          multiple :on-success="uploadedSuccess" :show-file-list="true" :auto-upload="true" :limit="1" :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button size="small" type="primary">上传附件</el-button>
          <div slot="tip" class="el-upload__tip" style="margin-top: 15px">上传文件不得超过100M</div>
        </el-upload>


      </el-form>
      <el-row>
        <el-col :span="24">

        </el-col>
      </el-row>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm" >确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
  import icon from '../../../assets/jiezhuang.png';
import { listBorder ,update} from "@/api/classifyManage/border";
  import {
    getFileById
  } from "@/api/file";


export default {
    data() {
      return {
        open:false,
        form:{},
        fileList:[],
        tableData: [{
          annex: '划界依据.xls'
        }, {
          annex: '划界批文.xls'
        }],
        queryParams: {},
        // 坐标数据
        LabelList: [],
      };
    },
    created() {

    },
    mounted:function(){

      this.getList();
    },
    methods: {
      download(val){
        window.open(val)
      },
      beforeAvatarUpload(file){
            const isLt100M = file.size / 1024 / 1024 < 100;
               if (!isLt100M) {
                      this.$message.error('上传文件大小不能超过 100MB!');
                      return false
                  }
            },
      handlePreview(file) {
        window.location.href = file.url;
      },
      uploadedSuccess(response, file, fileList) {
        this.form.fFileId = response.data.fId;
        // this.getFile();
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },
      handleRemove(file, fileList) {
        this.GLOBAL.commonFun(this.form.fFileId);
        // this.rControl.fPlanId = '';
        // this.getFile();
      },
      cancel(){
      this.open = false
      },
      submitForm(){
        if (this.form.fCenterPoint == null) {
          this.$message.error("请填写中心坐标")
          return false
        }
         if (this.form.fLabel == null) {
          this.$message.error("请填写坐标")
          return false
        }
         if (this.form.fFileId == null) {
          this.$message.error("请上传文件")
          return false
        }
        this.form.params = null
          update(this.form).then(result => {
            if (result) {
              this.msgSuccess("保存成功");
              this.open = false
              this.getList();
            }
          })
      },
      clickWrapper(){
        this.getList();
        if(this.LabelList[0]){
          this.form = this.LabelList[0]
          this.getFile()
        }

        this.open = true
      },
      getFile() {
        console.log('fileList = []');
        this.fileList = [];
        if (this.LabelList[0].fFileId) {
          getFileById({
            id: this.LabelList[0].fFileId
          }).then(result => {
            if (result) {
              this.fileList = [{
                name: result.data.fOldFileName,
                url: result.data.fFilePath
              }];
              console.log("fileList.url:", this.fileList);
            }
          })
        }
      },
    /** 查询坐标列表 */
    getList() {
      listBorder(this.queryParams).then(response => {
        this.LabelList = response.data;
        this.getFile()
        this.loadJScript();
      });
    },
      loadJScript(){
          var script = document.createElement('script');
          script.type = "text/javascript";
          script.src = "https://api.map.baidu.com/getscript??v=1.0&ak=epzuneKMNwBO9DunUSojeQlPGfz6NfM3&services=&t=20200927172029";
          script.onload = () =>{
            this.init();
          }
          document.body.appendChild(script);
      },
    init(){
    let BMap = window.BMap;
    // console.log(BMap);
    // 百度地图API功能
    let  fCenterPoint = this.LabelList[0].fCenterPoint.split(',');
    var map = new BMap.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(fCenterPoint[0],fCenterPoint[1]), 14);  // 初始化地图,设置中心点坐标和地图级别
    map.setCurrentCity("山东");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
// 绘制面
var arrr =[];
let labels = this.LabelList[0].fChangeLabel.split(";");

for(var a=0 ;a < labels.length ; a++ ){
      var qwe =  labels[a].split(',')
      arrr.push(new BMap.Point(parseFloat(qwe[0]),parseFloat(qwe[1])))
}

const deviceSize = new BMap.Size(30,50);
const deviceIcon = new BMap.Icon(icon, deviceSize, { //会以base64的方式传参iconCar
    imageSize: new BMap.Size(30,30),
    imageOffset:new BMap.Size(1,-1)
});
for(var b=0 ; b<arrr.length ; b++){
   const markers = new BMap.Marker(arrr[b], {
       icon: deviceIcon
   });
  map.addOverlay(markers);
}
  var point = new BMap.Point(fCenterPoint[0],fCenterPoint[1]);
  var marker = new BMap.Marker(point);        // 创建标注
  map.addOverlay(marker);



  var ponint = new BMap.Polygon(
    arrr
  , {
    strokeColor: 'blue',
    strokeWeight: 2,
    strokeOpacity: 0,
    fillOpacity:0.1,
})
ponint.setFillColor("none");
 map.addOverlay(ponint);
 // ponint.enableEditing();

// var Polyline = new BMap.Polygon([
//   // this.LabelList.forEach(function (item, index, LabelList) {
//   //   new BMap.Point(item.fLabel)
//   // })

//     new BMap.Point(117.207417,35.263976),
//     new BMap.Point(117.202961,35.25702),
//     new BMap.Point(117.196781,35.263504),
//     new BMap.Point(117.185714,35.264094),
//     new BMap.Point(117.195344,35.233909),
//     new BMap.Point(117.20253,35.217279),
//     new BMap.Point(117.220209,35.21256),
//     new BMap.Point(117.235875,35.220345),
//     new BMap.Point(117.238606,35.244286),
//     new BMap.Point(117.238606,35.244286),
//     new BMap.Point(117.21719,35.2503),
//     new BMap.Point(117.217047,35.261618),


// ], {
//     strokeColor: 'blue',
//     strokeWeight: 2,
//     strokeOpacity: 0,
//     fillOpacity:0.1
// });
// console.log('88888888888888',Polyline)
// map.addOverlay(Polyline);
//  Polyline.enableEditing();

  var myIcon = new BMap.Icon("../../../assets/images/baidu.jpeg", new BMap.Size(23, 25), {
      // 指定定位位置。
      // 当标注显示在地图上时，其所指向的地理位置距离图标左上
      // 角各偏移10像素和25像素。您可以看到在本例中该位置即是
      // 图标中央下端的尖角位置。
      anchor: new BMap.Size(10, 25),
      // 设置图片偏移。
      // 当您需要从一幅较大的图片中截取某部分作为标注图标时，您
      // 需要指定大图的偏移位置，此做法与css sprites技术类似。
      imageOffset: new BMap.Size(0, 0 - 25)   // 设置图片偏移
  });
      // 创建标注对象并添加到地图
  var marker = new BMap.Marker(point, {icon: myIcon});
  map.addOverlay(marker);
},

    }
  };
</script>
<style type="text/css">
#allmap {
  width: 60%;
  height: 85vh;
  }
</style>
