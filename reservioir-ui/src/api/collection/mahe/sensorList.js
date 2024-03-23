const sensor = require('../sensor');
const datetime = require('../datetime');
const common = require('../common');
const base = require('./base');
const reservoir = require('./reservoir');

export function createSensors() {
  return [
    sensor.createSensor({
      section: '水库安全实时状态-水库关键参数监测',   //有连接符表示既可以用于实时状态，也用于实时数据
      part: 'realtime-data-gateSeepage',       //这里注意顺序，realtime和data必须在前两个位置，后面随意
      category: '关键参数',
      id: 'MHSK000100050000010200',
      // bias: '-0.0',
      name: '水位',
      unit: 'm',
      limit: datetime.isFloodDate() ? '汛限水位' : '兴利水位',
      max: datetime.isFloodDate() ? base.getBaseInfo().floodWaterLevel : base.getBaseInfo().designWaterLevel,
      tag: 'water-level',
      index: 0,
      high: 190,
      low: 100,
      image: 'water-level'
    }),
    //大坝实时状态
    sensor.createSensor({
      section: '坝体安全实时状态',
      part: 'realtime',
      name: '累计沉降量',
      unit: 'mm',
      limit: '安全累计沉降量',
      max: 3,
      tag: 'dam-accumulate-down',
      image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态',
      part: 'realtime',
      name: '沉降速率',
      unit: 'mm/h',
      limit: '安全沉降速率',
      max: 3,
      value: -common.BOUNDARY,
      tag: 'dam-accumulate-down-speed',
      image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态',
      part: 'realtime',
      name: '坝坡稳定系数K',
      limit: '允许稳定系数K',
      max: common.BOUNDARY,
      value: common.BOUNDARY,
      min: 1.3,
      tag: 'stability-argument',
      image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态',
      part: 'realtime',
      name: '渗透坡降J',
      limit: '允许渗透坡降J',
      max: 3,
      value: common.BOUNDARY,
      tag: 'seepage-slope',
      image: 'flood-discharge'
    }),
    //闸门实时状态
    sensor.createSensor({
      section: '溢洪闸安全实时状态',
      category: '1#闸门',
      part: 'realtime',
      name: '累计沉降量',
      limit: '安全累计沉降量',
      max: 3,
      unit: 'mm',
      tag: 'gate-accumulate-down',
      image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态',
      category: '1#闸门',
      part: 'realtime',
      name: '沉降速率',
      limit: '安全沉降速率',
      max: 3,
      unit: 'mm/h',
      value: -common.BOUNDARY,
      tag: 'gate-accumulate-down-speed',
      image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态',
      category: '1#闸门',
      part: 'realtime',
      name: '闸墩倾斜',
      limit: '允许闸墩倾斜',
      max: 0.6, unit: '°',
      id: 'MSSK000100070001',
      tag: 'pier-inclination',
      image: 'discharge-water'
    }),

    sensor.createSensor({
      section: '溢洪闸安全实时状态',
      category: '1#闸门',
      part: 'realtime',
      name: '抗滑稳定系数K',
      limit: '允许稳定系数K',
      value: common.BOUNDARY,
      min: 1.08,
      tag: 'stability-coefficient',
      image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态',
      category: '1#闸门',
      part: 'realtime',
      name: '溢洪闸振动烈度',
      limit: '允许溢洪闸振动烈度',
      value: common.BOUNDARY,
      max: 3.00,
      unit: 'g',
      tag: 'gate-vibration-severity',
      image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '放水洞安全实时状态',
      part: 'realtime',
      name: '竖井稳定系数K',
      limit: '允许稳定系数K',
      value: common.BOUNDARY,
      min: 1.08,
      tag: 'shaft-factor',
      image: 'discharge-water'
    }),

    sensor.createSensor({
      part: 'data',
      name: '电压',
      section: '',
      value: common.BOUNDARY,
      unit: 'v',
      tag: 'voltage',
      image: 'storage-capacity',
      category: ''
    }),

    sensor.createSensor({
      part: 'data',
      section: '水库关键参数监测',
      id: '',
      name: '库容',
      unit: '万m³',
      tag: 'storage-capacity',
      image: 'storage-capacity',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水库关键参数监测',
      name: '水面面积',
      unit: 'km²',
      tag: 'water-area',
      image: 'storage-capacity'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水库关键参数监测',
      name: '可用水量',
      unit: '万m³',
      tag: 'water-volume',
      image: 'storage-capacity'
    }),

    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      name: '溢洪道流量',
      unit: 'm³/s',
      tag: 'flood-flow',
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      name: '闸前水深',
      id: 'MHSK000100100000010F0',
      unit: 'm',
      tag: 'gate-opening',
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      name: '溢洪道累积流量',
      unit: 'm³',
      tag: 'accumulate-flow',
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      name: '上游水位',
      unit: 'm',
      tag: 'downstream-level',
      image: 'flood-discharge',
      category: '关键参数'
    }),
    //监测数据下——放水洞倾斜(要关联到安全监测下放水洞安全监测——竖井倾斜)
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '东放水洞竖井1#倾斜x值:',
      id: 'MHSK000100110001001F00',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '东放水洞竖井1#倾斜Y值:',
      id: 'MHSK000100110001002000',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '东放水洞竖井2#倾斜x值:',
      id: 'MHSK000100110001002400',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '东放水洞竖井2#倾斜Y值:',
      id: 'MHSK000100110001002500',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '西放水洞竖井1#倾斜x值:',
      id: 'MHSK000100120001001F00',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '西放水洞竖井1#倾斜Y值:',
      id: 'MHSK000100120001002000',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '西放水洞竖井2#倾斜x值:',
      id: 'MHSK000100120001002400',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '放水洞关键参数监测',
      name: '西放水洞竖井2#倾斜Y值:',
      id: 'MHSK000100120001002500',
      unit: '°',
      tag: 'tunnel-flow',
      image: 'discharge-water',
      category: '关键参数'
    }),
    //  sensor.createSensor({
    //    part: 'realtime-data',
    // section: '放水洞安全实时状态-放水洞关键参数监测',
    // name: '竖井振动烈度',
    //    limit: '允许竖井振动烈度',
    // max: 3,
    //    unit: 'g',
    // tag: 'well-vibration-severity',
    // image: 'discharge-water',
    // category: '关键参数'
    //  }),

    //气象传感器开始
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '风向',
      value: common.BOUNDARY,
      id: 'MHSK00010017009',
      unit: '°',
      high: 360,
      low: 0,
      tag: 'wind-direction',
      image: 'storage-capacity',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '雨强',
      id: 'MHSK000100170010',
      unit: 'mm',
      tag: 'rain-intensity',
      image: 'rain-intensity',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '雨量',
      id: 'MHSK000100170015',
      unit: 'mm',
      tag: 'rain',
      image: 'evaporation',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '太阳辐射',
      id: 'MHSK000100170025',
      unit: 'W/㎡',
      tag: 'solar-radiation',
      image: 'solar-radiation',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '风速',
      id: 'MHSK00010017001',
      unit: 'm/s',
      tag: 'wind-speed',
      image: 'wind-speed',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '气温',
      id: 'MHSK000100170016',
      unit: '℃',
      tag: 'temperature',
      image: 'temperature',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '湿度',
      id: 'MHSK000100170017',
      unit: '%',
      tag: 'humidity',
      image: 'humidity',
      category: '气象参数',
      url: common.SENSOR_URL
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '大气压',
      id: 'MHSK000100170018',
      unit: 'hPa',
      high: 1100,
      low: 800,
      tag: 'atmospheric-pressure',
      image: 'atmospheric-pressure',
      category: '气象参数',
      url: common.SENSOR_URL
    }),


    //水质安全传感器
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测',
      part: 'realtime-data',
      name: 'PH值',
      limit: '允许PH范围',
      max: 9,
      min: 6,
      id: 'MHSK000100030000011000',
      category: '水质参数',
      tag: 'ph-value',
      image: 'ph',
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测',
      part: 'realtime-data',
      name: '溶解氧',
      unit: 'mg/L',
      limit: '允许溶解氧范围',
      bias: '*100',
      min: 5,
      id: 'MHSK000100030000011300',
      category: '水质参数',
      tag: 'dissolved-oxygen',
      image: 'dissolved-oxygen',
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测',
      part: 'realtime-data',
      name: '电导率',
      unit: 'μS/cm',
      limit: '允许电导率范围',
      min: 5,
      high: 320,
      low: 100,
      id: 'MHSK000100030000011200',
      category: '水质参数',
      tag: 'conductivity',
      image: 'conductivity',
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测',
      part: 'realtime-data',
      name: '浊度',
      unit: 'NTU',
      limit: '允许浊度范围',
      max: 50,
      high: 50,
      low: -500,
      id: 'MHSK000100030000011400',
      category: '水质参数',
      tag: 'turbidity',
      image: 'turbidity',
    }),

    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测',
      part: 'realtime-data',
      name: 'ORP',
      unit: 'mv',
      limit: '允许ORP范围',
      id: 'MHSK000100030000011100',
      category: '水质参数',
      tag: 'orp',
      high: 300,
      low: 0,
      image: 'orp',
    }),


    //流域上游水库
    sensor.createSensor({
      part: 'data',
      section: '控制流域内上游水库参数监测',
      name: '--',
      // unit: 'm',
      tag: 'yty-level',
      image: 'discharge-water',
      category: '流域水库'
    }),
    sensor.createSensor({
      part: 'data',
      section: '控制流域内上游水库参数监测',
      name: '--',
      // unit: 'm³',
      tag: 'yty-capacity',
      image: 'discharge-water',
      category: '流域水库'
    }),
    // sensor.createSensor({
    //     part: 'data',
    //     section: '控制流域内上游水库参数监测',
    //     name: '樱桃园水库降雨量',
    //     tag: 'yty-rain',
    //     unit: 'm',
    //     image: 'discharge-water',
    //     category: '流域水库'
    // }),
    // sensor.createSensor({
    //     part: 'data',
    //     section: '控制流域内上游水库参数监测',
    //     name: '樱桃园水库泄洪流量',
    //     unit: 'm³',
    //     tag: 'yty-flow',
    //     image: 'discharge-water',
    //     category: '流域水库'
    // }),
    // sensor.createSensor({
    //     part: 'data',
    //     section: '控制流域内上游水库参数监测',
    //     name: '石腊河支流洪水流量',
    //     tag: 'slh-flow',
    //     unit: 'm³',
    //     image: 'discharge-water',
    //     category: '流域水库'
    // }),
    // sensor.createSensor({
    //     part: 'data',
    //     section: '控制流域内上游水库参数监测',
    //     name: '重河连拱坝洪水流量',
    //     tag: 'zh-flow',
    //     unit: 'm³',
    //     image: 'discharge-water',
    //     category: '流域水库'
    // }),

    //大坝变形传感器开始
    sensor.createSensor({
      part: 'damTransform',
      section: '基准点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      category: '沉降',
      high: 5,
      low: -5,
      type: 0,
      pos: [350, 475],
      size: 15,
      dimension: 15,
      title: '基准点[0]',
      image: 'base.png',
      text: '高程:' + base.getBaseInfo().damHeight + 'm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '基准点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: '',
      category: '水平距离',
      high: 120,
      low: 0,
      type: 0,
      pos: [350, 475],
      size: 15,
      dimension: 15,
      title: '基准点[0]',
      image: 'base.png',
      text: '高程:' + base.getBaseInfo().damHeight + 'm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '1#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000100010013F2',
      category: '沉降',
      high: 5,
      low: -5,
      type: 1,
      pos: [450, 425],
      size: 12,
      dimension: 15,
      title: '1#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '1#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'HHSK000200050001002300',
      high: 15,
      low: -15,
      invalid: true,
      category: '水平距离',
      type: 1,
      pos: [450, 425],
      size: 12,
      bias: '*1',
      dimension: 15,
      title: '1#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '2#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000100010011F2',
      high: 5,
      low: -5,
      type: 2,
      category: '沉降',
      pos: [550, 375],
      size: 12,
      dimension: 15,
      title: '2#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '2#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'HHSK000100050001000500',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 2,
      value: -100,
      pos: [550, 375],
      size: 12,
      invalid: true,
      bias: '*0.3',
      dimension: 15,
      title: '2#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '3#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000100010015F2',
      high: 5,
      low: -5,
      type: 3,
      category: '沉降',
      pos: [650, 325],
      size: 12,
      dimension: 15,
      title: '3#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '3#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'MHSKWYJCD01',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 3,
      bias: '*1',
      pos: [650, 325],
      size: 12,
      dimension: 15,
      title: '3#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '4#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000100010017F2',
      high: 5,
      low: -5,
      type: 4,
      category: '沉降',
      pos: [750, 275],
      size: 12,
      dimension: 15,
      title: '4#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '4#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'MHSKWYJCD02',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 4,
      pos: [750, 275],
      size: 12,
      bias: '*0.3',
      dimension: 15,
      title: '4#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '5#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000100010019F2',
      high: 15,
      low: -15,
      type: 5,
      category: '沉降',
      pos: [850, 225],
      size: 12,
      dimension: 15,
      title: '5#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'damTransform',
      section: '5#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'MHSKWYJCD03',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 5,
      pos: [850, 225],
      size: 12,
      bias: '*0.1',
      dimension: 15,
      title: '5#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '6#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK000100010001001BF2',
      high: 15,
      low: -15,
      type: 6,
      category: '沉降',
      pos: [950, 175],
      size: 12,
      dimension: 15,
      title: '6#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '6#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'MHSKWYJCD04',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 6,
      pos: [950, 175],
      size: 12,
      bias: '*1',
      dimension: 15,
      title: '6#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '7#测点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      id: 'MHSK0001000600010011F2',
      high: 15,
      low: -15,
      type: 7,
      category: '沉降',
      pos: [1020, 125],
      size: 12,
      dimension: 15,
      title: '7#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),
    sensor.createSensor({
      part: 'damTransform',
      section: '7#测点',
      name: '水平',
      max: 20,
      min: -20,
      unit: 'mm',
      url: common.SENSOR_URL,
      id: 'MHSKWYJCD05',
      high: 15,
      low: -15,
      category: '水平距离',
      type: 7,
      pos: [1020, 125],
      size: 12,
      bias: '*1',
      dimension: 15,
      title: '7#测点',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),


    //大坝渗流开始
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+100断面',
      id: 'MHSKSYP11001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return 104.15 + common.makePositive(value);
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 104.15,
      unit: 'm',
      pos: 93,
      height: 115.8,
      category: 'base',
      index: 1
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+100断面',
      id: 'MHSKSYP11002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 104.49;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 117,
      low: 104.49,
      unit: 'm',
      pos: 117,
      height: 116.24,
      category: 'base',
      index: 2
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+100断面',
      id: 'MHSKSYP11003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value - 2) + 104.68 ;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 115,
      low: 104.68,
      unit: 'm',
      pos: 142,
      height: 113.33,
      category: 'base',
      index: 3
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+100断面',
      id: 'MHSKSYP11004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 104.09 - 0.8;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 112,
      low: 104.09,
      unit: 'm',
      pos: 164,
      height: 110.94,
      category: 'base',
      index: 4
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+210断面',
      id: 'MHSKSY00000001',
      /*bias:function(value){
          if (value >= common.BOUNDARY / 10000) return value;
          return common.makePositive(value) + 98.94;
      },*/
      url: common.SENSOR_URL,
      name: 'T1',
      high: 117,
      low: 98.94,
      unit: 'm',
      pos: 86,
      height: 115.98,
      category: 'body',
      index: 5
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+210断面',
      id: 'MHSKSY00000002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 2.2;
      },
      url: common.SENSOR_URL,
      name: 'T2',
      high: 117,
      low: 98.60,
      unit: 'm',
      pos: 106,
      height: 116.24,
      category: 'body',
      index: 6
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+210断面',
      id: 'MHSKSY00000003',
      /*bias:function(value){
          if (value >= common.BOUNDARY / 10000) return value;
          return common.makePositive(value) + 96.9;
      },*/
      url: common.SENSOR_URL,
      name: 'T3',
      bias: '-0',
      high: 112,
      low: 96.9,
      unit: 'm',
      pos: 125,
      height: 110.95,
      category: 'body',
      index: 7
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+210断面',
      id: 'MHSKSY00000004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 0.5;
      },
      url: common.SENSOR_URL,
      name: 'T4',
      high: 106,
      low: 98.02,
      unit: 'm',
      pos: 150,
      height: 105.87,
      category: 'body',
      index: 8
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYP14001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.53;
      },
      url: common.SENSOR_URL,
      name: 'T1',
      high: 117,
      low: 95.53,
      unit: 'm',
      pos: 86,
      height: 115.88,
      category: 'body',
      index: 9
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYP14002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.91 - 3.0;
      },
      url: common.SENSOR_URL,
      name: 'T2',
      high: 117,
      low: 95.91,
      unit: 'm',
      pos: 107,
      height: 115.86,
      category: 'body',
      index: 10
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYP14003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.6;
      },
      url: common.SENSOR_URL,
      name: 'T3',
      high: 108,
      low: 95.6,
      unit: 'm',
      pos: 143,
      height: 105.95,
      category: 'body',
      index: 11
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYP14004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.82 - 0.8;
      },
      url: common.SENSOR_URL,
      name: 'T4',
      high: 100,
      low: 95.82,
      unit: 'm',
      pos: 177,
      height: 99.07,
      category: 'body',
      index: 12
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYPJ14001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 85.93 - 1.0;
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 85.93,
      unit: 'm',
      pos: 87,
      height: 115.9,
      category: 'base',
      index: 13
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYPJ14002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 86.3 - 3.3;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 116,
      low: 86.3,
      unit: 'm',
      pos: 108,
      height: 115.86,
      category: 'base',
      index: 14
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYPJ14003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 86.6;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 107,
      low: 86.6,
      unit: 'm',
      pos: 145,
      height: 105.95,
      category: 'base',
      index: 15
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+400断面',
      id: 'MHSKSYPJ14004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 91.03 - 0.41;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 100,
      low: 91.03,
      unit: 'm',
      pos: 178,
      height: 99.08,
      category: 'base',
      index: 16
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYP16001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 89.25;
      },
      url: common.SENSOR_URL,
      name: 'T1',
      high: 117,
      low: 89.25,
      unit: 'm',
      pos: 86,
      height: 115.89,
      category: 'body',
      index: 17
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYP16002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 92.51 + 3;
      },
      url: common.SENSOR_URL,
      name: 'T2',
      high: 117,
      low: 92.51,
      unit: 'm',
      pos: 106,
      height: 115.88,
      category: 'body',
      index: 18
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYP16003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 92.43 - 0.62;
      },
      url: common.SENSOR_URL,
      name: 'T3',
      high: 107,
      low: 92.43,
      unit: 'm',
      pos: 143,
      height: 105.98,
      category: 'body',
      index: 19
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYP16004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 91.91;
      },
      url: common.SENSOR_URL,
      name: 'T4',
      high: 100,
      low: 91.91,
      unit: 'm',
      pos: 171,
      height: 99.56,
      category: 'body',
      index: 20
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYPJ16001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 84.03 + 5;
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 84.03,
      unit: 'm',
      pos: 87,
      height: 115.92,
      category: 'base',
      index: 21
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYPJ16002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 84.52 - 4;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 117,
      low: 84.52,
      unit: 'm',
      pos: 107,
      height: 115.87,
      category: 'base',
      index: 22
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYPJ16003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 87.22 - 2 - 1.98;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 107,
      low: 87.22,
      unit: 'm',
      pos: 144,
      height: 105.97,
      category: 'base',
      index: 23
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+600断面',
      id: 'MHSKSYPJ16004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 85.34 - 5 - 2;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 100,
      low: 85.34,
      unit: 'm',
      pos: 172,
      height: 99.59,
      category: 'base',
      index: 24
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYP17001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 90.48;
      },
      url: common.SENSOR_URL,
      name: 'T1',
      high: 117,
      low: 90.48,
      unit: 'm',
      pos: 86,
      category: 'body',
      height: 115.88,
      index: 25
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYP17002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 91.33 + 2;
      },
      url: common.SENSOR_URL,
      name: 'T2',
      high: 117,
      low: 91.33,
      unit: 'm',
      pos: 106,
      height: 115.85,
      category: 'body',
      index: 26
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYP17003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 91.28 + 2 - 0.34;
      },
      url: common.SENSOR_URL,
      name: 'T3',
      high: 107,
      low: 91.28,
      unit: 'm',
      pos: 142,
      height: 106.03,
      category: 'body',
      index: 27
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYP17004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 90.93 + 2;
      },
      url: common.SENSOR_URL,
      name: 'T4',
      high: 100,
      low: 90.93,
      unit: 'm',
      pos: 171,
      height: 99.58,
      category: 'body',
      index: 28
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYPJ17001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 83.25 - 14;
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 83.25,
      unit: 'm',
      pos: 87,
      height: 115.88,
      category: 'base',
      index: 29
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYPJ17002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 84.03 - 4;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 117,
      low: 84.03,
      unit: 'm',
      pos: 107,
      height: 115.87,
      category: 'base',
      index: 30
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYPJ17003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 84.16 - 2 - 0.39;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 107,
      low: 84.16,
      unit: 'm',
      pos: 143,
      height: 106.01,
      category: 'base',
      index: 31
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+700断面',
      id: 'MHSKSYPJ17004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 83.74 - 2 - 0.93;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 100,
      low: 83.74,
      unit: 'm',
      pos: 172,
      height: 99.59,
      category: 'base',
      index: 32
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYP18001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 93.57;
      },
      url: common.SENSOR_URL,
      name: 'T1',
      high: 117,
      low: 93.57,
      unit: 'm',
      pos: 86,
      height: 115.90,
      category: 'body',
      index: 33
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYP18002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 93.92;
      },
      url: common.SENSOR_URL,
      name: 'T2',
      high: 117,
      low: 93.92,
      unit: 'm',
      pos: 106,
      height: 115.88,
      category: 'body',
      index: 34
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYP18003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.36;
      },
      url: common.SENSOR_URL,
      name: 'T3',
      high: 107,
      low: 95.36,
      unit: 'm',
      pos: 142,
      height: 106.01,
      category: 'body',
      index: 35
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYP18004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 95.31;
      },
      url: common.SENSOR_URL,
      name: 'T4',
      high: 107,
      low: 95.31,
      unit: 'm',
      pos: 171,
      height: 99.56,
      category: 'body',
      index: 36
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYPJ18001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 88.97 - 8;
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 88.97,
      unit: 'm',
      pos: 87,
      height: 115.92,
      category: 'base',
      index: 37
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYPJ18002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 88.53 - 6;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 117,
      low: 88.53,
      unit: 'm',
      pos: 107,
      height: 115.88,
      category: 'base',
      index: 38
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYPJ18003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 90.13 - 2.91;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 107,
      low: 90.13,
      unit: 'm',
      pos: 143,
      height: 105.98,
      category: 'base',
      index: 39
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+800断面',
      id: 'MHSKSYPJ18004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 90.84 - 2.11;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 100,
      low: 90.84,
      unit: 'm',
      pos: 172,
      height: 99.59,
      category: 'base',
      index: 40
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '2+100断面',
      id: 'MHSKSYP21001',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 103.34;
      },
      url: common.SENSOR_URL,
      name: 'J1',
      high: 117,
      low: 103.34,
      unit: 'm',
      pos: 93,
      height: 115.89,
      category: 'base',
      index: 41
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '2+100断面',
      id: 'MHSKSYP21002',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 103.23;
      },
      url: common.SENSOR_URL,
      name: 'J2',
      high: 118,
      low: 103.23,
      unit: 'm',
      pos: 117,
      height: 116.18,
      category: 'base',
      index: 42
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '2+100断面',
      id: 'MHSKSYP21003',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 103.23;
      },
      url: common.SENSOR_URL,
      name: 'J3',
      high: 115,
      low: 103.23,
      unit: 'm',
      pos: 142,
      height: 113.28,
      category: 'base',
      index: 43
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '2+100断面',
      id: 'MHSKSYP21004',
      bias: function (value) {
        if (value >= common.BOUNDARY / 10000) return value;
        return common.makePositive(value) + 103.16;
      },
      url: common.SENSOR_URL,
      name: 'J4',
      high: 112,
      low: 103.16,
      unit: 'm',
      pos: 164,
      height: 110.91,
      category: 'base',
      index: 44
    }),

    //闸门位移传感器
    sensor.createSensor({
      part: 'gateDisplacement',
      section: '基准点',
      name: '沉降',
      high: 2,
      low: -2,
      unit: 'mm',
      type: 0,
      category: '沉降位移',
      pos: [130, 280],
      size: 15,
      dimension: 15,
      title: '基准点',
      image: 'base.png',
      text: '高程' + base.getBaseInfo().damHeight + 'm'
    }),
    sensor.createSensor({
      part: 'gateDisplacement',
      section: '1#测点',
      name: '沉降',
      high: 2,
      low: -2,
      unit: 'mm',
      id: 'MHSK0001000200010013F2',
      bias: function (value) {
        return Math.abs(value) > 2 ? 0.83 : value;
      },
      type: 1,
      category: '沉降位移',
      pos: [300, 300],
      size: 12,
      dimension: 15,
      title: '1#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),

    sensor.createSensor({
      part: 'gateDisplacement',
      section: '2#测点',
      name: '沉降',
      high: 2,
      low: -2,
      unit: 'mm',
      id: 'MHSK0001000200010011F2',
      bias: function (value) {
        return Math.abs(value) > 2 ? 0.12 : value;
      },
      type: 2,
      category: '沉降位移',
      pos: [455, 300],
      size: 12,
      dimension: 15,
      title: '2#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),


    //闸墩倾斜传感器开始,总共有4个监测点
    sensor.createSensor({
      section: '1#',
      part: 'gateDeclination',
      name: 'x倾斜',
      pos: [50, 300],
      type: 0,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK0001000200010013F2',
      bias: '',
      size: 12,
      dimension: 15,
      title: '1#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '1#',
      part: 'gateDeclination',
      name: 'y倾斜',
      pos: [50, 300],
      type: 0,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100080001002000',
      bias: '',
      size: 12,
      dimension: 15,
      title: '1#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '2#',
      part: 'gateDeclination',
      name: 'x倾斜',
      pos: [200, 300],
      type: 1,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100080001002400',
      bias: '',
      size: 12,
      dimension: 15,
      title: '2#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '2#',
      part: 'gateDeclination',
      name: 'y倾斜',
      pos: [200, 300],
      type: 1,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100080001002500',
      bias: '',
      size: 12,
      dimension: 15,
      title: '2#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '3#',
      part: 'gateDeclination',
      name: 'x倾斜',
      pos: [400, 300],
      type: 2,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100090001001F00',
      bias: '',
      size: 12,
      dimension: 15,
      title: '3#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '3#',
      part: 'gateDeclination',
      name: 'y倾斜',
      pos: [400, 300],
      type: 2,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100090001002000',
      bias: '',
      size: 12,
      dimension: 15,
      title: '3#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '4#',
      part: 'gateDeclination',
      name: 'x倾斜',
      pos: [600, 300],
      type: 3,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100090001002400',
      bias: '',
      size: 12,
      dimension: 15,
      title: '4#',
      image: 'horizontal.png',
      text: '0.00°'
    }),
    sensor.createSensor({
      section: '4#',
      part: 'gateDeclination',
      name: 'y倾斜',
      pos: [600, 300],
      type: 3,
      high: 2,
      low: -2,
      unit: '°',
      id: 'MHSK000100090001002500',
      bias: '',
      size: 12,
      dimension: 15,
      title: '4#',
      image: 'horizontal.png',
      text: '0.00°'
    }),


    //闸墩扬压力渗流传感器开始  总共4个闸墩 每个闸墩有三个测点
    sensor.createSensor({
      section: '1#断面',
      part: 'gateSeepage',
      name: '井1水',
      pos: 0,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100130000010400',
      type: '1',
      index: 9
    }),
    sensor.createSensor({
      section: '1#断面',
      part: 'gateSeepage',
      name: '井2水',
      pos: 105,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100130000010500',
      type: '1',
      index: 10
    }),
    sensor.createSensor({
      section: '1#断面',
      part: 'gateSeepage',
      name: '井3水',
      pos: 200,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100130000010600',
      type: '1',
      index: 11
    }),
    sensor.createSensor({
      section: '2#断面',
      part: 'gateSeepage',
      name: '井1水', pos: 0,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100140000010400',
      type: '2',
      index: 12
    }),
    sensor.createSensor({
      section: '2#断面',
      part: 'gateSeepage',
      name: '井2水',
      pos: 105,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100140000010500',
      type: '2',
      index: 13
    }),
    sensor.createSensor({
      section: '2#断面',
      part: 'gateSeepage',
      name: '井3水',
      pos: 200,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100140000010600',
      type: '2',
      index: 14
    }),
    sensor.createSensor({
      section: '3#断面',
      part: 'gateSeepage',
      name: '井1水',
      pos: 0,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100150000010400',
      type: '3',
      index: 15
    }),
    sensor.createSensor({
      section: '3#断面',
      part: 'gateSeepage',
      name: '井2水',
      pos: 105,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100150000010500',
      type: '3',
      index: 16
    }),
    sensor.createSensor({
      section: '3#断面',
      part: 'gateSeepage',
      name: '井3水',
      pos: 200,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100150000010600',
      type: '3',
      index: 11
    }),
    sensor.createSensor({
      section: '4#断面',
      part: 'gateSeepage',
      name: '井1水',
      pos: 0,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100160000010400',
      type: '4',
      index: 17
    }),
    sensor.createSensor({
      section: '4#断面',
      part: 'gateSeepage',
      name: '井2水',
      pos: 105,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100160000010500',
      type: '4',
      index: 18
    }),
    sensor.createSensor({
      section: '4#断面',
      part: 'gateSeepage',
      name: '井3水',
      pos: 200,
      high: 90,
      low: 75,
      unit: 'm',
      id: 'MHSK000100160000010600',
      type: '4',
      index: 19
    }),

    //放水洞传感器开始

    sensor.createSensor({
      section: '东1#测点',
      part: 'well',
      name: 'x方向',
      type: 0,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100110001001F00',
      pos: [65, 250],
      title: '东1#测点'
    }),
    sensor.createSensor({
      section: '东1#测点',
      part: 'well',
      name: '东1y方向',
      type: 0,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100110001002000',
      pos: [65, 250],
      title: '东1#测点'
    }),

    sensor.createSensor({
      section: '东2#测点',
      part: 'well',
      name: '东2x方向',
      type: 1,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100110001002400',
      pos: [65, 300],
      title: '东2#测点'
    }),
    sensor.createSensor({
      section: '东2#测点',
      part: 'well',
      name: '东y方向',
      type: 1,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100110001002500',
      pos: [65, 300],
      title: '东2#测点'
    }),

    sensor.createSensor({
      section: '西1#测点',
      part: 'well',
      name: '西1x方向',
      type: 2,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100120001001F00',
      pos: [65, 350],
      title: '西1#测点'
    }),
    sensor.createSensor({
      section: '西1#测点',
      part: 'well',
      name: '西1y方向',
      type: 2,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100120001002000',
      pos: [65, 350],
      title: '西1#测点'
    }),
    sensor.createSensor({
      section: '西2#测点',
      part: 'well',
      name: '西2X方向',
      type: 2,
      high: 2,
      low: -2,
      unit: 'g',
      id: 'MHSK000100120001002400',
      pos: [65, 350],
      title: '西2#测点'
    }),
    sensor.createSensor({
      section: '西2#测点',
      part: 'well',
      name: '西2y方向',
      type: 2,
      high: 2,
      low: -2,
      unit: 'g', id: 'MHSK000100120001002500',
      pos: [65, 350],
      title: '西2#测点'
    }),


    //竖井传感器开始
    // sensor.createSensor({
    //   section: '1#测点', part: 'well', name: 'x方向', type: 3,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002100',
    //   pos: [930, 250], title: '1#测点'
    // }),
    // sensor.createSensor({
    //   section: '1#测点', part: 'well', name: 'y方向', type: 3,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002200',
    //   pos: [930, 250], title: '1#测点'
    // }),
    // sensor.createSensor({
    //   section: '1#测点', part: 'well', name: 'z方向', type: 3,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002300',
    //   pos: [930, 250], title: '1#测点'
    // }),
    // sensor.createSensor({
    //   section: '2#测点', part: 'well', name: 'x方向', type: 4,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002600',
    //   pos: [930, 300], title: '2#测点'
    // }),
    // sensor.createSensor({
    //   section: '2#测点', part: 'well', name: 'y方向', type: 4,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002700',
    //   pos: [930, 300], title: '2#测点'
    // }),
    // sensor.createSensor({
    //   section: '2#测点', part: 'well', name: 'z方向', type: 4,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002800',
    //   pos: [930, 300], title: '2#测点'
    // }),
    // sensor.createSensor({
    //   section: '3#测点', part: 'well', name: 'x方向', type: 5,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002B00',
    //   pos: [930, 350], title: '3#测点'
    // }),
    // sensor.createSensor({
    //   section: '3#测点', part: 'well', name: 'y方向', type: 5,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002C00',
    //   pos: [930, 350], title: '3#测点'
    // }),
    // sensor.createSensor({
    //   section: '3#测点', part: 'well', name: 'z方向', type: 5,
    //   high: 2, low: -2, unit: 'g', id: 'MSSK000100080001002D00',
    //   pos: [930, 350], title: '3#测点'
    // }),
  ]
}
