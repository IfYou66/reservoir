const common = require('./common');

/**
 * 根据两个固定点（得到斜率），计算某纵坐标对应的横坐标
 * @p1 第一个固定点
 * @p2 第二个固定点
 * @y 纵坐标
 * @returns 横坐标
 */
export function getX(p1, p2, y) {
  return p1[0] + (y - p1[1]) / (p2[1] - p1[1]) * (p2[0] - p1[0]);
}

/**
 * 根据属性名和值在数组中查找一项
 * @param array 带查找的数组
 * @param attr 属性名
 * @param value 值
 * @returns {*}
 */
export function findArrayItemByAttrValue(array, attr, value) {
  for (let i = 0; i < array.length; i++) {
    if (array[i][attr] === value) {
      return array[i];
    }
  }
}

export function getDisplayText(value) {
  let text;
  if (value === common.INVALID) {
    text = "故障";
  } else if (isTooLarge(value)) {
    text = "--";
  } else {
    text = value;
  }
  return text;
}

//判断是否为极值，/1000是因为有可能被修正导致不完全相等
export function isTooLarge(value) {
  return Math.abs(value) > common.BOUNDARY / 10000;
}

export function getPointText(sensor) {
  if (sensor.value === common.INVALID) {
    return '故障';
  } else if (Math.abs(sensor.value) > common.BOUNDARY / 10000) {
    return "--";
  } else {
    return sensor.value.toFixed(sensor.precision) + sensor.unit;
  }
}

/**
 * 判断是否是该section中的第一个
 * @returns {boolean}
 * @param sensor 当前传感器
 * @param sensors 传感器组
 * @param name 名称
 * @param value 值
 */
export function exists(sensor, sensors, name, value) {
  let sens = getSensors(sensors, name, value, true);
  if (sens.length > 0) {
    return sens[0].tag === sensor.tag;
  }
}

/**
 * 判断值是否有效
 * @param value
 * @returns {boolean}
 */
export function isValid(value) {
  return !((typeof value === 'undefined') || (value == null) || (value === ''));
}

/**
 * 产生状态字符串
 * @param point 点信息
 */
export function generateStateStr(point) {
  let value = Math.abs(point.value);
  let result;
  if (typeof value === 'number') {
    result = (value === common.BOUNDARY || value === common.INVALID) ? '--' : '正常';
  } else if (typeof value === 'object') {
    if (value.x === common.BOUNDARY || value.x === common.INVALID) {
      result = '--';
    } else {
      result = '正常';
    }
  }
  return result;
}

/**
 * 产生值字符串
 * @param point 点信息
 */
export function generateValueStr(point) {
  let result = '';
  if (typeof point.value === 'number') {
    result = (Math.abs(point.value) === common.BOUNDARY || point.value === common.INVALID) ? '--' : point.value.toFixed(point.precision);
  } else if (point.value && typeof point.value === 'object') {
    if (Math.abs(point.value.x) === common.BOUNDARY || point.value.x === common.INVALID) {
      result = ('x--' + point.unit + ' ');
    } else {
      result = ('x-' + point.value.x + point.unit + ' ');
    }
    if ((Math.abs(point.value.y) === common.BOUNDARY || point.value.y === common.INVALID)) {
      result += ('y--');
    } else {
      result += ('y-' + point.value.y);
    }
  } else {
    result = '--';
  }
  return result;
}

/**
 * 让某个标签闪烁
 * @param tag 标签
 */
export function blinkTag(tag) {
  tag.style.color = '#79f9af';
  setTimeout(function () {
    tag.style.color = '#e4f3cd';
  }, 5 * 1000);
}

/**
 * 计算插值
 * @param minKey 最小键
 * @param maxKey 最大键
 * @param minValue 最小值
 * @param maxValue 最大值
 * @param key 键
 */
export function getInterpolation(minKey, maxKey, minValue, maxValue, key) {
  if (key >= minKey && key <= maxKey)
    return minValue + (maxValue - minValue) * ((key - minKey) / (maxKey - minKey));
  else
    console.log('插值计算失败');
}

/**
 * 产生范围字符串
 * @param highValue 上限值
 * @param lowValue 下限值
 */
export function generateScopeStr(highValue, lowValue) {
  if (highValue === common.BOUNDARY) {
    if (lowValue === -common.BOUNDARY) {
      return '--';
    } else {
      return '>' + lowValue;
    }
  } else {
    if (lowValue === -common.BOUNDARY) {
      return '<' + highValue;
    } else if (lowValue === 0) {
      return highValue;
    } else {
      return lowValue + '-' + highValue;
    }
  }
}

/**
 * 创建泄量关系表项对象
 * @param level 水位
 * @param capacity 容量
 * @param discharge 总泄量
 * @param gate 溢洪闸泄量
 * @param weir 溢流堰泄量
 * @param spillway 非常溢洪道泄量
 * @returns {weir: *, spillway: *, level: *, discharge: all, safe: *, capacity: *}
 */
export function createDischarge(level, capacity, discharge, gate, weir, spillway) {
  return {
    level: level,
    capacity: capacity,
    discharge: discharge,
    gate: gate,
    weir: weir,
    spillway: spillway
  }
}

/**
 * 创建净雨对象
 * @param dayDiff 相对天数
 * @param rainFall 当天降雨量 P降雨
 * @param rfpDays 前期影响净雨 Pa
 * @param rfpDay 当天净雨 R净雨
 * @param rfHours 降雨历时
 * @param m1 单位线参数m1
 * @param m2 单位线参数m2
 */
export function createDailyRain(dayDiff, rainFall, rfpDays, rfpDay, rfHours, m1, m2) {
  return {
    dayDiff: dayDiff,
    rainFall: rainFall,
    rfpDays: rfpDays,
    rfpDay: rfpDay,
    rfHours: rfHours,
    m1: m1,
    m2: m2
  }
}

/**
 * 创建逐个小时降雨量
 * @param hour 时段
 * @param rainFall 降雨
 * @param rainPure 分配的净雨值
 * @param unitLineValue 单位线值
 * @param floodValue 洪水线值
 * @returns 降雨对象
 */
export function createHourlyRain(hour, rainFall, rainPure, unitLineValue, floodValue) {
  return {
    hour: hour,
    rainFall: rainFall,
    rainPure: rainPure,
    unitLineValue: unitLineValue,
    floodValue: floodValue
  }
}

/**
 * 创建每日降雨量数组，使用随机值模拟
 * @param dateBefore 最早天数 1-表示昨天 以此类推
 * @param dateAfter 最晚天数 0-表示今天 -1-表示明天 以此类推
 * @returns {[]}
 */
export function createDailyRains(dateBefore, dateAfter) {
  let dailyRains = [];
  for (let i = dateBefore; i >= -dateAfter; i--) {
    if (common.DEBUG) {
      dailyRains.push(this.createDailyRain(i, Math.random() * 48,));
    } else {
      dailyRains.push(this.createDailyRain(i, 0));
    }
  }
  return dailyRains;
}

/**
 * 创建逐小时降雨量数组，使用随机值模拟
 * @param days 需要的天数
 * @returns {[]}
 */
export function createHourlyRains(days) {
  let hourlyRains = [];
  for (let i = 0; i < 24 * days; i++) {
    if (common.DEBUG) {
      hourlyRains.push(this.createHourlyRain(i, Math.random() * 4, 0));
    } else {
      hourlyRains.push(this.createHourlyRain(i, 0, 0));
    }
  }
  return hourlyRains;
}

/**
 * 创建线号项
 * @param section 分区
 * @param order 序号
 * @param line1 线1
 * @param line2 线2
 * @param line3 线3
 * @param line4 线4
 * return 线号项
 */
export function createAreaLine(section, order, line1, line2, line3, line4) {
  return {
    section: section,
    order: order,
    line1: line1,
    line2: line2,
    line3: line3,
    line4: line4
  }
}

/**
 * 创建单位线参数项
 * @param place 平原%
 * @param normal 一般山区瞬时单位线参数K
 * @param flood 入黄山区瞬时单位线参数K
 * @param k 单位线参数
 * return 单位线参数项
 */
export function createUnitLineK(place, normal, flood, k) {
  return {
    place: place,
    normal: normal,
    flood: flood,
    k: k
  }
}

/**
 * 创建径流关系表项
 * @param rain 雨量
 * @param l1
 * @param l2
 * @param l3
 * @param l4
 * @param l5
 * @param l6
 * @param l7
 * @param l8
 * @param l9
 * @param l10
 * @param l11
 * @param l12
 * @param l13
 * @param l14
 * @param l15
 * @param l16
 */
export function createRainFlowRelation(rain, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16) {
  return {
    rain: rain,
    l1: l1,
    l2: l2,
    l3: l3,
    l4: l4,
    l5: l5,
    l6: l6,
    l7: l7,
    l8: l8,
    l9: l9,
    l10: l10,
    l11: l11,
    l12: l12,
    l13: l13,
    l14: l14,
    l15: l15,
    l16: l16
  }
}

/**
 * 创建一个点
 * @param {Object} sectionName 状态组的名称
 * @param {Object} categoryName 分类名称，用于不同闸门
 * @param id 编号
 * @param {Object} pointName 探测点的名称
 * @param {Object} value 探测值
 * @param {Object} bias 偏差值
 * @param {Object} unit 值的单位
 * @param {Object} limitName 设限名称：如安全沉降速率等
 * @param {Object} highValue 上限值
 * @param {Object} lowValue 下限值
 * @param {Object} tag 标签名称：自动生成html使用
 * @param {Object} img 图片名称
 * @param {Object} receiveTime 接收时间
 * @param url 数据请求地址
 * @returns
 */
export function createPoint(sectionName, categoryName,
                            id, pointName, value, bias,
                            unit, limitName, highValue, lowValue,
                            tag, img, receiveTime, url) {
  return {
    sectionName: sectionName,
    categoryName: categoryName,
    id: id,
    pointName: pointName,
    value: value,
    bias: bias ? bias : 0,
    unit: unit,
    limitName: limitName,
    highValue: highValue,
    lowValue: lowValue,
    tag: tag,
    img: img,
    receiveTime: receiveTime,
    url: url
  }
}

/**
 * 创建一个矩形
 * @returns {*[][]} 使用一个数组表达矩形的点
 * @param left 左边位置
 * @param right 右边位置
 * @param top 上边位置
 * @param bottom 下边位置
 */
export function createRectangle(left, right, top, bottom) {
  return [[left, bottom], [right, bottom], [right, top], [left, top], [left, bottom]];
}

/**
 * 创建一个矩形
 * @param x 左下角横坐标
 * @param y 左下角纵坐标
 * @param width 宽度
 * @param height 高度
 * @returns {*[][]}
 */
export function createRect(x, y, width, height) {
  return this.createRectangle(x, x + width, y + height, y);
}

/**
 * 创建一个位移监测的监测点背景矩形
 * @param x 左下角横坐标
 * @param y 左下角纵坐标
 * @returns {*[][]}
 */
export function createBackgroundRect(x, y, width, height) {
  if (!width) width = 160;
  if (!height) height = 50;
  return this.createRect(x - 20, y - 5, width, height);
}

/**
 * 创建一个位移监测的监测点背景矩形
 * @param x 左下角横坐标
 * @param y 左下角纵坐标
 * @returns {*[][]}
 */
export function createSmallBackgroundRect(x, y) {
  return this.createRect(x - 20, y - 5, 80, 50);
}


/**
 * 创建一个图型
 * @param name 名称
 * @param data 数据
 * @param symbolSize 标记大小
 * @param value 标点值
 * @param type 类型
 * @param color 颜色
 * @param lineColor 线条颜色
 * @param areaColor 区域颜色
 */
export function createShape(name, data, symbolSize, value, type, color, lineColor, areaColor) {
  return {
    name: name,
    data: data,
    symbolSize: symbolSize,
    value: value,
    type: type,
    color: color,
    lineColor: lineColor,
    areaColor: areaColor,
  }
}

export function createShapeSeries(shape) {
  return {
    name: shape.name,
    type: 'line',
    data: shape.data,
    symbol: 'none',
    showSymbol: shape.type.showSymbol,
    smooth: shape.type.isSmooth,
    markPoint: this.createMarkPoint(shape),
    itemStyle: this.createItemStyle(shape)
  }
}

export function createItemStyle(shape) {
  if (!shape.type.isArea) {
    return {
      normal: {
        color: shape.color,
        lineStyle: {
          color: shape.color,
          type: shape.type.isSolid ? 'solid' : 'dashed',
          width: shape.type.lineWidth ? shape.type.lineWidth : 1
        }
      }
    }
  } else {
    return {
      normal: {
        color: shape.color,
        lineStyle: {
          color: shape.lineColor
        },
        areaStyle: {
          color: shape.areaColor
        }
      }
    }
  }
}

export function createMarkPoint(shape) {
  if (!shape.type.isMarkPoint) {
    return {}
  } else {
    let bias = shape.name.indexOf('T') >= 0 ? -14: 14;
    return {
      symbolSize: shape.symbolSize,
      symbolOffset: [-1 + bias, 5],//位置偏移
      data: [
        function () {
          if (shape.value.xAxis) {
            return {
              value: shape.value.yAxis,
              name: shape.name,
              xAxis: shape.value.xAxis,
              yAxis: shape.value.yAxis
            }
          } else {
            return {
              type: 'max',
              name: shape.name
            }
          }
        }()
      ],
      itemStyle: function () {
        if (shape.type.showSymbol) {
          return {}
        } else {
          return {
            normal: {
              label: {
                show: true,
                position: shape.type.isBase ? [-6, -20] : (shape.type.isBody ? [-14, -20] : [-10, -20]),
                formatter: function (param) {
                  if (shape.type.showValue) {
                    return param.name + "：" + param.value + "m";
                  } else {
                    return param.name;
                  }
                },
                textStyle: {color: shape.lineColor, fontSize: 14, fontWeight: 'bolder'}
              }
            }
          }
        }
      }()
    }
  }
}

/**
 * 判断是否平滑区域
 * @param shape
 * @returns {boolean}
 */
export function createMarkPointTips(shape) {
  if (shape.type.isMax) {
    return {type: 'max', name: shape.name};
  } else {

  }
}

/**
 * 创建一个固定大小的矩形
 * @param left 矩形左边位置
 * @param bottom 矩形下边位置
 * @returns {[[*, *], [*, *], [*, *], [*, *], [*, *]]} 矩形
 */
export function createBar(left, bottom) {
  return this.createRectangle(left, left + 1, bottom + 1.2, bottom);
}

/**
 * 创建一个井水条
 * @param left 矩形左边位置
 * @param bottom 矩形下边位置
 * @param value 水位
 * @returns {[[*, *], [*, *], [*, *], [*, *], [*, *]]} 矩形
 */
export function createBarData(left, bottom, value) {
  return this.createRectangle(left, left + 1, value, bottom);
}

/**
 * 创建百度地图上的一个标记点
 * @param title 标记名称
 * @param type 类型
 * @param content 显示内容
 * @param href 超链接
 * @param point 点位置
 * @param isOpen 是否展开
 * @param icon 图标
 * @returns {{isOpen: *, icon: *, href: *, title: *, type: *, content: *, point: *}}
 */
export function createMarker(title, type, content, href, point, isOpen, icon) {
  return {
    title: title,
    type: type,
    content: content,
    href: href,
    point: point,
    isOpen: isOpen,
    icon: icon
  }
}

/**
 * 成功获取数据后的处理函数
 */
export function updateSensors(part, setData) {
  let sens = common.getData(part);
  let newestTime = sens[0].time;
  for (let i = 0; i < sens.length; i++) {
    if (sens[i].time > newestTime) {
      newestTime = sens[i].time;
    }
    let sensorID = sens[i].id;
    let sensor = this.findArrayItemByAttrValue(sens, 'id', sensorID);
    let selType = $("input[name='type']:checked").val();
    if (sensor && selType === sensor.name) {
      setData(sensor);
    }
  }
  $('#newest-time').html((new Date(newestTime)).format("yyyy-MM-dd hh:mm:ss"));
}


/**
 * 显示历史数据
 * @param sensor 传感器
 */
export function lineShow(sensor) {
  if (sensor) {
    if (sensor.name === '沉降' && sensor.type === 0) {   //处理沉降中的基准点，让它不显示曲线
      sensor.url = '';
    }
    showRecord(sensor);
  }
}

/**
 * 获取水位
 */
export function getWaterLevel(isFake = false) {
  if (isFake) {
    return 304;
  } else {
    return this.findArrayItemByAttrValue(common.loadSensors(), 'name', '水位').value;
  }
}

/**
 * 获取水位
 */
export function getWaterLevelSensor() {
  return this.findArrayItemByAttrValue(common.loadSensors(), 'name', '水位');
}

/**
 * 获取水位
 */
export function findSensorById(id) {
  return this.findArrayItemByAttrValue(common.loadSensors(), 'id', id);
}

/**
 * 用于获取传感器
 */
export function getDamSensor(name) {
  return this.getSensor(common.loadSensors(), 'name', name);
}

/**
 * 获取传感器列表
 * @param sensors 所有传感器
 * @param attr 属性
 * @param value 值
 * @param isAccurate 是否精确查找
 * @returns {[]}
 */
export function getSensors(sensors, attr, value, isAccurate) {
  let sensorArr = [];
  for (let i = 0; i < sensors.length; i++) {
    if (isAccurate) {
      if (sensors[i][attr] === value) {
        sensorArr.push(sensors[i]);
      }
    } else {
      if (sensors[i][attr] !== undefined) {
        if (typeof sensors[i][attr] === 'string' && sensors[i][attr].indexOf(value) >= 0) {
          sensorArr.push(sensors[i]);
        } else if (typeof sensors[i][attr] !== 'string' && sensors[i][attr] === value) {
          sensorArr.push(sensors[i]);
        }
      }
    }
  }
  return sensorArr;
}

/**
 * 查找传感器数据
 * @param sensors 所有传感器
 * @param attr 属性名
 * @param value 属性值
 * @param isAccurate 是否精确查找
 * @returns {*}
 */
export function getSensor(sensors, attr, value, isAccurate) {
  let sens = this.getSensors(sensors, attr, value, isAccurate);
  if (sens.length > 0) {
    return sens[0];
  }
}

/**
 * 获取数组中某属性的分类汇总
 * @param sensors 传感器列表
 * @param attr 属性
 * @returns {[]}
 */
export function getAttrArray(sensors, attr) {
  let sensorArr = [];
  for (let i = 0; i < sensors.length; i++) {
    if (sensors[i][attr] !== undefined && !sensorArr.includes(sensors[i][attr]) && sensors[i][attr].indexOf('-') < 0) {
      sensorArr.push(sensors[i][attr]);
    }
  }
  return sensorArr;
}

export function isSafe(value, max, min) {
  if ((value > min && value < max) || (value === '--')) {
    return true;
  } else if ((value < min || value > max)) {
    return false;
  }
  return true;
}

/**
 * 将某个值保留一定的精度
 * @param value 值
 * @param precision 精度对应位数
 */
export function fix(value, precision = 2) {
  let val = Number.parseFloat(value);
  return val ? Number.parseFloat(val.toFixed(precision)) : 0;
}

/***
 * 生成result组件的config参数
 * @param value 显示值
 * @param unit 单位
 * @param state 显示状态
 * @returns {{number: [number], toFixed: number, style: {fontSize: number, fill: string}, content: string}}
 */
export function getConfig(value, unit, state) {
  return {
    number: [parseFloat(value)],
    content: '{nt}' + unit,
    toFixed: 1,
    style: {
      fontSize: 26,
      fill: state ? '#3de7c9' : '#e72b33'
    }
  };
}


