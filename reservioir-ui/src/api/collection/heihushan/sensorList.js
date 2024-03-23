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
      id: 'HHSK000100020001000FF0',
      name: '水位',
      unit: 'm',
      limit: datetime.isFloodDate() ? '汛限水位' : '兴利水位',
      max: datetime.isFloodDate() ? base.getBaseInfo().floodWaterLevel : base.getBaseInfo().highWaterLevel,
      tag: 'water-level',
      index: 0,
      high: 190,
      low: 100,
      image: 'water-level'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态', part: 'realtime', name: '累计沉降量', unit: 'mm',
      limit: '安全累计沉降量', max: 3,
      tag: 'dam-accumulate-down', image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态', part: 'realtime', name: '沉降速率', unit: 'mm/h',
      limit: '安全沉降速率', max: 3, value: -common.BOUNDARY,
      tag: 'dam-accumulate-down-speed', image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态', part: 'realtime', name: '坝坡稳定系数K',
      limit: '允许稳定系数K', max: 1.3, value: common.BOUNDARY,
      tag: 'stability-argument', image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '坝体安全实时状态', part: 'realtime', name: '渗透坡降J',
      limit: '允许渗透坡降J', min: 3, value: common.BOUNDARY,
      tag: 'seepage-slope', image: 'flood-discharge'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态', category: '1#闸门', part: 'realtime', name: '累计沉降量',
      limit: '安全累计沉降量', max: 3, unit: 'mm',
      tag: 'gate-accumulate-down', image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态', category: '1#闸门', part: 'realtime', name: '沉降速率',
      limit: '安全沉降速率', max: 3, unit: 'mm/h', value: -common.BOUNDARY,
      tag: 'gate-accumulate-down-speed', image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态', category: '1#闸门', part: 'realtime', name: '闸墩倾斜',
      limit: '允许倾斜', max: 0.6, min: 0, unit: '°',
      tag: 'pier-inclination', image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态', category: '1#闸门', part: 'realtime', name: '抗滑稳定系数K',
      limit: '允许稳定系数K', value: common.BOUNDARY, min: 1.08,
      tag: 'stability-coefficient', image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '溢洪闸安全实时状态', category: '1#闸门', part: 'realtime', name: '溢洪闸振动烈度',
      limit: '允许溢洪闸振动烈度', value: common.BOUNDARY, max: 3.00, unit: 'g',
      tag: 'gate-vibration-severity', image: 'discharge-water'
    }),
    sensor.createSensor({
      section: '放水洞安全实时状态', part: 'realtime', name: '竖井稳定系数K',
      limit: '允许稳定系数K', value: common.BOUNDARY, min: 1.08,
      tag: 'shaft-factor', image: 'discharge-water'
    }),

    sensor.createSensor({
      part: 'data', name: '电压', section: '', value: common.BOUNDARY, id: 'HHSK000100030001000100',
      unit: 'v', tag: 'voltage', image: 'storage-capacity', category: ''
    }),
    sensor.createSensor({
      part: 'data', section: '', name: '风向', value: common.BOUNDARY,
      unit: '°', high: 360, low: 0, tag: 'wind-direction', image: 'storage-capacity', category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水库关键参数监测',
      id: 'HHSK000100020001000FF0',
      bias: function (value) {
        return reservoir.getRelations().getCapacityRelationShip('capacity', value)
      },
      name: '库容',
      unit: '万m³',
      tag: 'storage-capacity',
      image: 'storage-capacity',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '水库关键参数监测', name: '水面面积', id: 'HHSK000100020001000FF0',
      unit: 'km²', tag: 'water-area', image: 'storage-capacity', bias: function (value) {
        return reservoir.getRelations().getArea('area', value)
      },
    }),
    sensor.createSensor({
      part: 'data', section: '水库关键参数监测', name: '可用水量', id: 'HHSK000100020001000FF0',
      unit: '万m³', tag: 'water-volume', image: 'storage-capacity', bias: function (value) {
        return reservoir.getRelations().getCapacityRelationShip('capacity', value) - base.getBaseInfo().deadCapacity
      }
    }),

    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '1#闸门', name: '溢洪道流量', id: 'HHSK000300030000011000',
      unit: 'm³/s', tag: 'flood-flow-1', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '1#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011100',
      unit: 'm³',
      tag: 'accumulate-flow-1',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '1#闸门', name: '闸门开度', id: 'HHSK000300030100010800',
      unit: 'm', tag: 'gate-opening-1', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '1#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-1', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '2#闸门', name: '溢洪道流量', id: 'HHSK000300030000011200',
      unit: 'm³/s', tag: 'flood-flow-2', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '2#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011300',
      unit: 'm³',
      tag: 'accumulate-flow-2',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '2#闸门', name: '闸门开度', id: 'HHSK000300030200010800',
      unit: 'm', tag: 'gate-opening-2', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '2#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-2', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '3#闸门', name: '溢洪道流量', id: 'HHSK000300030000011400',
      unit: 'm³/s', tag: 'flood-flow-3', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '3#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011500',
      unit: 'm³',
      tag: 'accumulate-flow-3',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '3#闸门', name: '闸门开度', id: 'HHSK000300030300010800',
      unit: 'm', tag: 'gate-opening-3', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '3#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-3', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '4#闸门', name: '溢洪道流量', id: 'HHSK000300030000011600',
      unit: 'm³/s', tag: 'flood-flow-4', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '4#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011700',
      unit: 'm³',
      tag: 'accumulate-flow-4',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '4#闸门', name: '闸门开度', id: 'HHSK000300030400010800',
      unit: 'm', tag: 'gate-opening-4', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '4#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-4', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '5#闸门', name: '溢洪道流量', id: 'HHSK000300030000011800',
      unit: 'm³/s', tag: 'flood-flow-5', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '5#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011900',
      unit: 'm³',
      tag: 'accumulate-flow-5',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '5#闸门', name: '闸门开度', id: 'HHSK000300030500010800',
      unit: 'm', tag: 'gate-opening-5', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '5#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-5', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '6#闸门', name: '溢洪道流量', id: 'HHSK000300030000011A00',
      unit: 'm³/s', tag: 'flood-flow-6', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '溢洪闸关键参数监测',
      text: '6#闸门',
      name: '溢洪道累积流量',
      id: 'HHSK000300030000011B00',
      unit: 'm³',
      tag: 'accumulate-flow-6',
      high: 100000000,
      low: 0,
      image: 'flood-discharge',
      category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '6#闸门', name: '闸门开度', id: 'HHSK000300030600010800',
      unit: 'm', tag: 'gate-opening-6', image: 'flood-discharge', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '溢洪闸关键参数监测', text: '6#闸门', name: '闸前水深', id: 'HHSK000300030000010F00',
      unit: 'm', tag: 'downstream-level-6', image: 'flood-discharge', category: '关键参数'
    }),

    sensor.createSensor({
      part: 'data', section: '放水洞关键参数监测', name: '放水洞瞬时流量',
      unit: 'm³/s', tag: 'tunnel-flow', image: 'discharge-water', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'data', section: '放水洞关键参数监测', name: '放水洞累积水量',
      unit: 'm³', tag: 'accumulate-volume', image: 'discharge-water', category: '关键参数'
    }),
    sensor.createSensor({
      part: 'realtime-data', section: '放水洞安全实时状态-放水洞关键参数监测', name: '放水管振动烈度',
      limit: '允许放水管振动烈度', max: 3.00,
      unit: 'g', tag: 'pipe-vibration-severity', image: 'discharge-water', category: '关键参数'
    }),

    sensor.createSensor({
      part: 'data-tunnelSeepage',
      section: '放水洞关键参数监测',
      name: '放水洞渗流量',
      id: 'HHSK0000000001',
      unit: 'm³/h',
      tag: 'tunnel-seepage',
      image: 'discharge-water',
      category: '关键参数',
      type: 0,
      pos: [930, 300],
      high: 40,
      low: 2,
      value: 32,
      title: '渗流量',
      text: ''
    }),
    sensor.createSensor({
      part: 'data-tunnelSeepage',
      section: '放水洞关键参数监测',
      name: '放水洞渗流总量',
      id: 'HHSK0000000002',
      unit: 'm³',
      tag: 'tunnel-total-seepage',
      image: 'discharge-water',
      category: '关键参数',
      type: 1,
      pos: [930, 250],
      high: common.BOUNDARY,
      low: 0,
      value: 2333,
      title: '渗流总量',
      text: ''
    }),
    sensor.createSensor({
      part: 'realtime-data', section: '放水洞安全实时状态-放水洞关键参数监测', name: '竖井振动烈度',
      limit: '允许竖井振动烈度', max: 3.00,
      unit: 'g', tag: 'well-vibration-severity', image: 'discharge-water', category: '关键参数'
    }),

    //气象传感器开始
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '雨强',
      id: 'MSSK000100040000010A00',
      value: common.BOUNDARY,
      unit: 'mm',
      tag: 'rain-intensity',
      image: 'rain-intensity',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '雨量',
      id: 'DZSK000100010010',
      value: common.BOUNDARY,
      unit: 'mm',
      tag: 'rain',
      image: 'evaporation',
      url: common.SENSOR_URL,
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '太阳辐射',
      id: '',
      value: common.BOUNDARY,
      unit: 'W/㎡',
      tag: 'solar-radiation',
      image: 'solar-radiation',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '风速',
      id: 'MSSK000100040000010900',
      value: common.BOUNDARY,
      unit: 'm/s',
      tag: 'wind-speed',
      image: 'wind-speed',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '气温',
      id: 'MSSK000100040000011000',
      value: common.BOUNDARY,
      unit: '℃',
      tag: 'temperature',
      image: 'temperature',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '湿度',
      id: 'MSSK000100040000011000',
      value: common.BOUNDARY,
      unit: '%',
      tag: 'humidity',
      image: 'humidity',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '土壤含水',
      id: 'MSSK000100040000010A00',
      value: common.BOUNDARY,
      unit: '%',
      tag: 'soil-water',
      image: 'soil-water',
      category: '气象参数'
    }),
    sensor.createSensor({
      part: 'data',
      section: '水文气象监测',
      name: '大气压',
      id: 'MSSK000100040000011200',
      value: common.BOUNDARY,
      unit: 'hPa',
      tag: 'atmospheric-pressure',
      image: 'atmospheric-pressure',
      category: '气象参数'
    }),

    //水质安全传感器
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: 'PH值',
      limit: '允许PH范围', max: 9, min: 6, id: 'DZSK000100010218', category: '水质参数',
      tag: 'ph-value', image: 'ph', url: common.SENSOR_URL
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: '水温', unit: '℃',
      limit: '允许水温范围', id: 'DZSK000100010220', category: '水质参数',
      tag: 'water-temperature', image: 'water-temperature', url: common.SENSOR_URL
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: '溶解氧', unit: 'mg/L',
      limit: '允许溶解氧范围', min: 5, id: 'DZSK000100010216', category: '水质参数',
      tag: 'dissolved-oxygen', image: 'dissolved-oxygen', url: common.SENSOR_URL
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: '电导率', unit: 'μS/cm',
      limit: '允许电导率范围', min: 5, id: 'DZSK000100010217', category: '水质参数',
      tag: 'conductivity', image: 'conductivity', url: common.SENSOR_URL
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: '浊度', unit: 'NTU',
      limit: '允许浊度范围', min: 5, id: 'DZSK000100010215', category: '水质参数',
      tag: 'turbidity', image: 'turbidity', url: common.SENSOR_URL
    }),
    sensor.createSensor({
      section: '水质安全实时状态-水质参数监测', part: 'realtime-data', name: 'ORP', unit: 'mv',
      limit: '允许ORP范围', id: 'DZSK000100010219', category: '水质参数',
      tag: 'orp', image: 'orp', url: common.SENSOR_URL
    }),


    //流域上游水库
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '实时水位',
      id: 'HHSK000100090000010200',
      unit: 'm',
      high: 300,
      low: 200,
      tag: 'dyt-water-level',
      image: 'discharge-water',
      category: '流域水库',
      text: '钓鱼台水库'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '水库库容',
      unit: 'm³',
      tag: 'dyt-capacity',
      image: 'discharge-water',
      category: '流域水库',
      text: '钓鱼台水库'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      id: 'HHSK000100090000010F00',
      name: '钓鱼台水库降雨量',
      tag: 'dyt-reservoir-rain',
      unit: 'mm',
      image: 'discharge-water',
      category: '流域水库',
      text: '雨量监测点'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '东胡降雨量',
      tag: 'dh-rain',
      unit: 'mm',
      image: 'discharge-water',
      category: '流域水库',
      text: '雨量监测点'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '孙王降雨量',
      tag: 'sw-rain',
      unit: 'mm',
      image: 'discharge-water',
      category: '流域水库',
      text: '雨量监测点'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '钓鱼台降雨量',
      tag: 'dyt-rain',
      unit: 'mm',
      image: 'discharge-water',
      category: '流域水库',
      text: '雨量监测点'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '测流断面水深',
      id: 'HHSK000100010001000200',
      tag: 'middle-bridge-water-level',
      unit: 'm',
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪中桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '瞬时流量',
      id: 'HHSK000100010001000400',
      tag: 'middle-bridge-current-flow',
      unit: 'm³/s',
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪中桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '累积水量',
      id: 'HHSK000100010001000500',
      tag: 'middle-bridge-accumulate-flow',
      unit: 'm³',
      high: common.BOUNDARY,
      low: 0,
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪中桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '水流速度',
      id: 'HHSK000100010001000600',
      tag: 'middle-bridge-flow-speed',
      unit: 'm/s',
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪中桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '测流断面水深',
      id: 'HHSK000100100001000200',
      tag: 'product-bridge-water-level',
      unit: 'm',
      high: 10,
      low: 0,
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪生产桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '瞬时流量',
      id: 'HHSK000100100001000400',
      tag: 'product-bridge-current-flow',
      unit: 'm³/s',
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪生产桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '累积水量',
      id: 'HHSK000100100001000500',
      tag: 'product-bridge-accumulate-flow',
      unit: 'm³',
      high: common.BOUNDARY,
      low: 0,
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪生产桥入库径流'
    }),
    sensor.createSensor({
      part: 'data',
      section: '上游河道、水库监测',
      name: '水流速度',
      id: 'HHSK000100100001000600',
      tag: 'product-bridge-flow-speed',
      unit: 'm/s',
      image: 'discharge-water',
      category: '流域水库',
      text: '逄峪生产桥入库径流'
    }),


    //大坝变形传感器开始
    sensor.createSensor({
      part: 'damTransform',
      section: '基准点',
      name: '沉降',
      max: 20,
      min: -20,
      unit: 'mm',
      category: '沉降位移',
      high: 5,
      low: -5,
      type: 0,
      pos: [70, 620],
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
      url: common.SENSOR_URL_CLOUD,
      id: '',
      category: '水平距离',
      high: 120,
      low: 0,
      type: 0,
      pos: [70, 620],
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
      id: 'HHSK0003000100010011F2',
      category: '沉降位移',
      high: 5,
      low: -5,
      type: 1,
      pos: [210, 500],
      size: 12,
      dimension: 15,
      title: '[1#  0+030]',
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
      url: common.SENSOR_URL_CLOUD,
      id: 'HHSK0014CD1A22001',
      high: 120,
      low: 0,
      category: '水平距离',
      type: 1,
      pos: [210, 500],
      size: 12,
      bias: '*0.1',
      dimension: 15,
      title: '[1# 0+030]',
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
      id: 'HHSK0003000100010013F2',
      high: 5,
      low: -5,
      type: 2,
      category: '沉降位移',
      pos: [350, 440],
      size: 12,
      dimension: 15,
      title: '[2#  0+200]',
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
      url: common.SENSOR_URL_CLOUD,
      id: 'HHSK0014CD1A22002',
      high: 120,
      low: 0,
      category: '水平距离',
      type: 2,
      pos: [350, 440],
      size: 12,
      bias: '*0.1',
      dimension: 15,
      title: '[2# 0+200]',
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
      id: 'HHSK0003000100010015F2',
      high: 5,
      low: -5,
      type: 3,
      category: '沉降位移',
      pos: [470, 380],
      size: 12,
      dimension: 15,
      title: '[3#  0+300]',
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
      url: common.SENSOR_URL_CLOUD,
      id: 'HHSK0014CD1A22003',
      high: 120,
      low: 0,
      category: '水平距离',
      type: 3,
      pos: [470, 380],
      size: 12,
      bias: '*0.1',
      dimension: 15,
      title: '[3# 0+300]',
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
      id: 'HHSK0003000100010017F2',
      high: 5,
      low: -5,
      type: 4,
      category: '沉降位移',
      pos: [570, 320],
      size: 12,
      dimension: 15,
      title: '[4#  0+410]',
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
      url: common.SENSOR_URL_CLOUD,
      id: 'HHSK0014CD1A22004',
      high: 120,
      low: 0,
      category: '水平距离',
      type: 4,
      bias: '*0.1',
      pos: [570, 320],
      size: 12,
      dimension: 15,
      title: '[4#  0+410]',
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
      id: 'HHSK0003000100010019F2',
      high: 5,
      low: -5,
      type: 5,
      category: '沉降位移',
      pos: [670, 260],
      size: 12,
      dimension: 15,
      title: '[5#  0+520]',
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
      url: common.SENSOR_URL_CLOUD,
      id: 'HHSK0014CD1A22005',
      high: 120,
      low: 0,
      category: '水平距离',
      type: 5,
      pos: [670, 260],
      size: 12,
      bias: '*0.1',
      dimension: 15,
      title: '[5#  0+520]',
      image: 'horizontal.png',
      text: '水平:0.0mm'
    }),

    //大坝渗流开始
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+030断面',
      id: 'HHSK000200300100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 139.36,
      unit: 'm',
      pos: 95,
      height: 172.36,
      index: 11,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+030断面',
      id: 'HHSK000200300200010200',
      name: 'T2',
      bias: '-4',
      value: 140,
      high: 190,
      low: 142.00,
      unit: 'm',
      pos: 123,
      height: 172.11,
      index: 13,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+030断面',
      id: 'HHSK000200300300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 142.18,
      unit: 'm',
      pos: 135,
      height: 162.83,
      index: 15,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+030断面',
      id: 'HHSK000200300400010200',
      name: 'T4',
      value: 140,
      high: 190,
      low: 120,
      unit: 'm',
      pos: 157,
      height: 148.75,
      index: 17,
      category: 'body'
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 131.42,
      unit: 'm',
      pos: 95,
      height: 172.15,
      index: 11,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000200010200',
      name: 'T2',
      value: 140,
      bias: '-10',
      high: 190,
      low: 134.64,
      unit: 'm',
      pos: 123,
      height: 171.89,
      index: 13,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 130.96,
      unit: 'm',
      pos: 135,
      height: 162.87,
      index: 15,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000400010200',
      name: 'T4',
      value: 140,
      high: 190,
      low: 129.38,
      unit: 'm',
      pos: 156,
      height: 149.12,
      index: 17,
      category: 'body'
    }),
    // sensor.createSensor({
    //     part: 'damSeepage',
    //     section: '0+300断面',
    //     id: 'HHSK000203000500010200',
    //     name: 'T5',
    //     value: 140,
    //     high: 190,
    //     low: 100,
    //     unit: 'm',
    //     pos: 162,
    //     height: 147,
    //     index: 19,
    //     category: 'body'
    // }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000600010200',
      name: 'J1',
      value: 140,
      high: 190,
      low: 123.01,
      unit: 'm',
      pos: 125,
      height: 171.84,
      index: 20,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000700010200',
      name: 'J2',
      value: 140,
      high: 190,
      low: 116.75,
      unit: 'm',
      pos: 182,
      height: 134.41,
      index: 22,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+300断面',
      id: 'HHSK000203000800010200',
      name: 'J3',
      value: 140,
      high: 190,
      low: 101.84,
      unit: 'm',
      pos: 206,
      height: 121.29,
      index: 24,
      category: 'base'
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 132.21,
      unit: 'm',
      pos: 95,
      height: 171.89,
      index: 11,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100200010200',
      name: 'T2',
      value: 140,
      bias: '-5',
      high: 190,
      low: 134.13,
      unit: 'm',
      pos: 123,
      height: 171.40,
      index: 13,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 129.76,
      unit: 'm',
      pos: 135,
      height: 162.90,
      index: 15,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100400010200',
      name: 'T4',
      value: 140,
      high: 190,
      low: 128.84,
      unit: 'm',
      pos: 157,
      height: 148.65,
      index: 17,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100500010200',
      name: 'J1',
      value: 140,
      high: 190,
      low: 119.8,
      unit: 'm',
      pos: 125,
      height: 171.43,
      index: 20,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+410断面',
      id: 'HHSK000204100600010200',
      name: 'J2',
      value: 140,
      high: 190,
      low: 117.19,
      unit: 'm',
      pos: 175,
      height: 139.85,
      index: 22,
      category: 'base'
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 150.31,
      unit: 'm',
      pos: 95,
      height: 172.11,
      index: 11,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200200010200',
      name: 'T2',
      value: 140,
      bias: '-5',
      high: 190,
      low: 143.00,
      unit: 'm',
      pos: 124,
      height: 171.43,
      index: 13,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200300010200',
      name: 'T3',
      value: 140,
      bias: '-8',
      high: 190,
      low: 139.00,
      unit: 'm',
      pos: 135,
      height: 163.56,
      index: 15,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200400010F00',
      name: 'T4',
      value: 100,
      bias: '-16',
      high: 190,
      low: 135.00,
      unit: 'm',
      pos: 147,
      height: 156.52,
      index: 17,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200500010200',
      name: 'J1',
      value: 100,
      high: 190,
      low: 120.70,
      unit: 'm',
      pos: 126,
      height: 171.50,
      index: 20,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200600010200',
      name: 'J2',
      value: 100,
      high: 190,
      low: 119.97,
      unit: 'm',
      pos: 137,
      height: 163.55,
      index: 22,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+520断面',
      id: 'HHSK000205200700010200',
      name: 'J3',
      value: 100,
      high: 190,
      low: 112.84,
      unit: 'm',
      pos: 149,
      height: 156.72,
      index: 24,
      category: 'base'
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 152.11,
      unit: 'm',
      pos: 93,
      height: 172.03,
      index: 11,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000200010200',
      name: 'T2',
      value: 140,
      bias: '-5',
      high: 190,
      low: 146,
      unit: 'm',
      pos: 123,
      height: 171.78,
      index: 13,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 140,
      bias: '-8',
      unit: 'm',
      pos: 134,
      height: 163.32,
      index: 15,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000400010F00',
      name: 'T4',
      value: 140,
      high: 190,
      low: 138,
      bias: '-10',
      unit: 'm',
      pos: 146,
      height: 158.32,
      index: 17,
      category: 'body'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000500010200',
      name: 'J1',
      value: 140,
      high: 190,
      low: 130,
      unit: 'm',
      pos: 95,
      height: 171.87,
      index: 20,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000600010200',
      name: 'J2',
      value: 140,
      high: 190,
      low: 130,
      unit: 'm',
      pos: 136,
      height: 163.43,
      index: 22,
      category: 'base'
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+700断面',
      id: 'HHSK000207000700010200',
      name: 'J3',
      value: 140,
      high: 190,
      low: 122,
      unit: 'm',
      pos: 153,
      height: 151.86,
      index: 24,
      category: 'base'
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500200010200',
      name: 'T2',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500400010200',
      name: 'T4',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500500010200',
      name: 'J1',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '0+850断面' + 'TBD',
      id: 'HHSK000208500600010200',
      name: 'J2',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),

    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000100010200',
      name: 'T1',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000200010200',
      name: 'T2',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000300010200',
      name: 'T3',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000400010200',
      name: 'T4',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000500010200',
      name: 'J1',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),
    sensor.createSensor({
      part: 'damSeepage',
      section: '1+000断面' + 'TBD',
      id: 'HHSK000210000600010200',
      name: 'J2',
      value: 140,
      high: 190,
      low: 100,
      unit: 'm',
      pos: 89,
      height: 84.5,
      index: 16
    }),

    //闸门位移传感器
    sensor.createSensor({
      part: 'gateDisplacement',
      section: '基准点',
      name: '沉降',
      high: 2,
      low: -2,
      unit: 'mm',
      id: '',
      type: 0,
      category: '沉降位移',
      pos: [880, 240],
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
      id: 'HHSK0003000200010011F4',
      type: 1,
      category: '沉降位移',
      pos: [700, 260],
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
      id: 'HHSK0003000200010013F4',
      type: 2,
      category: '沉降位移',
      pos: [480, 270],
      size: 12,
      dimension: 15,
      title: '2#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),
    sensor.createSensor({
      part: 'gateDisplacement',
      section: '3#测点',
      name: '沉降',
      high: 2,
      low: -2,
      unit: 'mm',
      id: 'HHSK0003000200010015F4',
      type: 3,
      category: '沉降位移',
      pos: [220, 280],
      size: 12,
      dimension: 15,
      title: '3#测点',
      image: 'horizontal.png',
      text: '沉降:0.0mm'
    }),


    //闸墩倾斜传感器开始
    sensor.createSensor({
      section: '1#', part: 'gateDeclination', name: 'x倾斜', pos: [10, 290], type: 0,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001001F00', bias: '-4.58',
      size: 12, dimension: 15, title: '1#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '1#', part: 'gateDeclination', name: 'y倾斜', pos: [10, 290], type: 0,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002000', bias: '-0.05',
      size: 12, dimension: 15, title: '1#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '2#', part: 'gateDeclination', name: 'x倾斜', pos: [130, 285], type: 1,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002400', bias: '+0.68',
      size: 12, dimension: 15, title: '2#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '2#', part: 'gateDeclination', name: 'y倾斜', pos: [130, 285], type: 1,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002500', bias: '-0.09',
      size: 12, dimension: 15, title: '2#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '3#', part: 'gateDeclination', name: 'x倾斜', pos: [250, 280], type: 2,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002900', bias: '+0.74',
      size: 12, dimension: 15, title: '3#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '3#', part: 'gateDeclination', name: 'y倾斜', pos: [250, 280], type: 2,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002A00', bias: '-0.4',
      size: 12, dimension: 15, title: '3#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '4#', part: 'gateDeclination', name: 'x倾斜', pos: [370, 275], type: 3,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002E00', bias: '+1.91',
      size: 12, dimension: 15, title: '4#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '4#', part: 'gateDeclination', name: 'y倾斜', pos: [370, 275], type: 3,
      high: 5, low: -5, unit: '°', id: 'HHSK000200040001002F00', bias: '-0.6',
      size: 12, dimension: 15, title: '4#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '5#', part: 'gateDeclination', name: 'x倾斜', pos: [490, 270], type: 4,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001001F00', bias: '-0.20',
      size: 12, dimension: 15, title: '5#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '5#', part: 'gateDeclination', name: 'y倾斜', pos: [490, 270], type: 4,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002000', bias: '-1.79',
      size: 12, dimension: 15, title: '5#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '6#', part: 'gateDeclination', name: 'x倾斜', pos: [610, 265], type: 5,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002400', bias: '+0.62',
      size: 12, dimension: 15, title: '6#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '6#', part: 'gateDeclination', name: 'y倾斜', pos: [610, 265], type: 5,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002500', bias: '-0.12',
      size: 12, dimension: 15, title: '6#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '7#', part: 'gateDeclination', name: 'x倾斜', pos: [730, 260], type: 6,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002900', bias: '+1.13',
      size: 12, dimension: 15, title: '7#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '7#', part: 'gateDeclination', name: 'y倾斜', pos: [730, 260], type: 6,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002A00', bias: '-1.28',
      size: 12, dimension: 15, title: '7#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '8#', part: 'gateDeclination', name: 'x倾斜', pos: [850, 255], type: 7,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002E00', bias: '+0.44',
      size: 12, dimension: 15, title: '8#', image: 'horizontal.png', text: '0.00°'
    }),
    sensor.createSensor({
      section: '8#', part: 'gateDeclination', name: 'y倾斜', pos: [850, 255], type: 7,
      high: 5, low: -5, unit: '°', id: 'HHSK000200030001002F00', bias: '-1.05',
      size: 12, dimension: 15, title: '8#', image: 'horizontal.png', text: '0.00°'
    }),


    //扬压力渗流传感器开始
    sensor.createSensor({
      section: '1#断面', part: 'gateSeepage', name: '井1水', pos: 0, url: common.SENSOR_URL,
      high: 400, low: 200, unit: 'm', id: 'DZSK00020002003', type: '1', index: 9
    }),
    sensor.createSensor({
      section: '1#断面', part: 'gateSeepage', name: '井2水', pos: 105, url: common.SENSOR_URL,
      high: 400, low: 200, unit: 'm', id: 'DZSK00020002002', type: '1', index: 10
    }),
    sensor.createSensor({
      section: '1#断面', part: 'gateSeepage', name: '井3水', pos: 200, url: common.SENSOR_URL,
      high: 400, low: 200, unit: 'm', id: 'DZSK00020002001', type: '1', index: 11
    }),

    //放水洞传感器开始
    sensor.createSensor({
      section: '1#测点', part: 'pipe', name: 'x方向', type: 0, value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002100',
      pos: [930, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '1#测点', part: 'pipe', name: 'y方向', type: 0,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002200',
      pos: [930, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '1#测点', part: 'pipe', name: 'z方向', type: 0,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002300',
      pos: [930, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'pipe', name: 'x方向', type: 1,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002600',
      pos: [930, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'pipe', name: 'y方向', type: 1,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002700',
      pos: [930, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'pipe', name: 'z方向', type: 1,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002800',
      pos: [930, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'pipe', name: 'x方向', type: 2,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002B00',
      pos: [930, 350], title: '3#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'pipe', name: 'y方向', type: 2,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002C00',
      pos: [930, 350], title: '3#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'pipe', name: 'z方向', type: 2,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100090001002D00',
      pos: [930, 350], title: '3#测点'
    }),

    //竖井传感器开始
    sensor.createSensor({
      section: '1#测点', part: 'well', name: 'x方向', type: 3,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002100',
      pos: [65, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '1#测点', part: 'well', name: 'y方向', type: 3,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002200',
      pos: [65, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '1#测点', part: 'well', name: 'z方向', type: 3,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002300',
      pos: [65, 250], title: '1#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'well', name: 'x方向', type: 4,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002600',
      pos: [65, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'well', name: 'y方向', type: 4,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002700',
      pos: [65, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '2#测点', part: 'well', name: 'z方向', type: 4,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002800',
      pos: [65, 300], title: '2#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'well', name: 'x方向', type: 5,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002B00',
      pos: [65, 350], title: '3#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'well', name: 'y方向', type: 5,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002C00',
      pos: [65, 350], title: '3#测点'
    }),
    sensor.createSensor({
      section: '3#测点', part: 'well', name: 'z方向', type: 5,value:0.3,
      high: 5, low: -5, unit: 'g', id: 'MSSK000100080001002D00',
      pos: [65, 350], title: '3#测点'
    }),
  ]
}
