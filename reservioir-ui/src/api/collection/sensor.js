/**
 * 此文件用于创建各种数据对象，主要供数据文件调用
 */
const common = require('@/api/collection/common');

export function Sensor(sensorInfo) {
  this.setId = function (id) {
    this.id = this.getProp(id, '');
  };

  this.getId = function () {
    return this.id;
  };

  this.setName = function (name) {
    this.name = name;
  };

  this.getName = function () {
    return this.name;
  };

  this.setValue = function (value) {
    this.data = value;
    if (this.getName() === 'x方向') {  //测试用
      this.data = value;
    }
    value = parseFloat(this.getProp(value, common.BOUNDARY));
    this.value = Math.round(common.correct(value, this.getBias()) * 10 ** this.getPrecision()
    ) / (10 ** this.getPrecision());    //获取对应精度
  };

  this.getValue = function () {
    return this.value;
  };

  this.setMax = function (max) {
    this.max = this.getProp(max, common.BOUNDARY);
  };

  this.getMax = function () {
    return this.max;
  };

  this.setMin = function (min) {
    this.min = this.getProp(min, -common.BOUNDARY);
  };

  this.getMin = function () {
    return this.min;
  };

  this.setUnit = function (unit) {
    this.unit = this.getProp(unit, '');
  };

  this.getUnit = function () {
    return this.unit;
  };

  this.setType = function (type) {
    this.type = type;
  };

  this.getType = function () {
    return this.type;
  };

  this.setTime = function (time) {
    this.time = this.getProp(time, new Date().getTime());
  };

  this.getTime = function () {
    return this.time;
  };

  this.setPos = function (pos) {
    this.pos = pos;
  };

  this.getPos = function () {
    return this.pos;
  };

  this.setIndex = function (index) {
    this.index = index;
  };

  this.getIndex = function () {
    return this.index;
  };

  this.setBias = function (bias) {
    this.bias = this.getProp(bias, '+0');
  };

  this.getBias = function () {
    return this.bias;
  };

  this.setUrl = function (url) {
    this.url = this.getProp(url, common.SENSOR_URL_NEW);
  };

  this.getUrl = function () {
    return this.url;
  };

  this.setTitle = function (title) {
    this.title = title;
  };

  this.getTitle = function () {
    return this.title;
  };

  this.setSection = function (section) {
    this.section = section;
  };

  this.getSection = function () {
    return this.section;
  };

  this.setCategory = function (category) {
    this.category = category;
  };

  this.getCategory = function () {
    return this.category;
  };

  this.setLimit = function (limit) {
    this.limit = limit;
  };

  this.getLimit = function () {
    return this.limit;
  };

  this.setTag = function (tag) {
    this.tag = tag;
  };

  this.getTag = function () {
    return this.tag;
  };

  this.setImage = function (image) {
    this.image = image;
  };

  this.getImage = function () {
    return this.image;
  };

  this.setHigh = function (high) {
    this.high = this.getProp(high, common.BOUNDARY);
  };

  this.getHigh = function () {
    return this.high;
  };

  this.setLow = function (low) {
    this.low = this.getProp(low, -common.BOUNDARY);
  };

  this.getLow = function () {
    return this.low;
  };

  this.setPrecision = function (precision) {
    this.precision = this.getProp(precision, 2);
  };

  this.getPrecision = function () {
    return this.precision;
  };

  this.setPart = function (part) {
    this.part = part;
  };

  this.getPart = function () {
    return this.part;
  };

  this.setSize = function (size) {
    this.size = this.getProp(size, 15);
  };

  this.getSize = function () {
    return this.size;
  };

  this.setDimension = function (dimension) {
    this.dimension = this.getProp(dimension, 15);
  };

  this.getDimension = function () {
    return this.dimension;
  };

  this.setText = function (text) {
    this.text = this.getProp(text, '');
  };

  this.getText = function () {
    return this.text;
  };

  this.setHeight = function (height) {
    this.height = this.getProp(height, 0);
  };

  this.getHeight = function () {
    return this.height;
  };

  this.setInvalid = function (invalid) {
    this.invalid = this.getProp(invalid, false);
  };

  this.getInvalid = function () {
    return this.invalid;
  };

  this.setData = function (data) {
    this.data = this.getProp(data, 0);
  };

  this.getData = function () {
    return this.data;
  };

  this.setSmooth = function (smooth) {
    this.smooth = this.getProp(smooth, false);
  };

  this.getSmooth = function () {
    return this.smooth;
  };

  /**
   * @param prop 属性名称
   * @param defValue 默认值
   * @returns {*} 获取默认值
   */
  this.getProp = function (prop, defValue) {
    return (prop !== undefined) ? prop : defValue;
  };

  this.setId(sensorInfo.id);                  //编号
  this.setName(sensorInfo.name);              //名称
  this.setBias(sensorInfo.bias);              //偏转处理字符串
  this.setPrecision(sensorInfo.precision);    //精度，默认2
  this.setValue(sensorInfo.value);            //值
  this.setData(sensorInfo.data);              //原始数据
  this.setMax(sensorInfo.max);                //最大值，用来表示范围最大值，默认common.BOUNDARY
  this.setMin(sensorInfo.min);                //最小值，用来表示范围最小值，默认-common.BOUNDARY
  this.setUnit(sensorInfo.unit);              //单位
  this.setType(sensorInfo.type);              //类别
  this.setTime(sensorInfo.time);              //时间
  this.setPos(sensorInfo.pos);                //位置 [x, y]
  this.setTag(sensorInfo.tag);                //HTML标签ID
  this.setIndex(sensorInfo.index);            //索引
  this.setUrl(sensorInfo.url);                //获取数据url,默认10304
  this.setTitle(sensorInfo.title);            //标题
  this.setSection(sensorInfo.section);        //所属区域
  this.setCategory(sensorInfo.category);      //所属种类
  this.setLimit(sensorInfo.limit);            //范围名称
  this.setImage(sensorInfo.image);            //对应图片
  this.setHigh(sensorInfo.high);              //过滤最大值，用于显示历史曲线中过滤无效值使用，默认100
  this.setLow(sensorInfo.low);                //过滤最小值，用于显示历史曲线中过滤无效值使用，默认0
  this.setPart(sensorInfo.part);              //部分，用来表示该浏览器对应页面，比如"realtime-data",则该页面属于实时状态，也属于实时数据页面
  this.setSize(sensorInfo.size);              //图片大小
  this.setDimension(sensorInfo.dimension);    //图片切换大小
  this.setText(sensorInfo.text);              //显示文本
  this.setHeight(sensorInfo.height);          //大坝中的传感器对应管的高度
  this.setSmooth(sensorInfo.smooth);          //是否需要平滑
  this.setInvalid(sensorInfo.invalid);        //是否有效，用于有些水库不让打开历史界面
}

export function createSensor(sensorInfo) {
  return new Sensor(sensorInfo);
}


