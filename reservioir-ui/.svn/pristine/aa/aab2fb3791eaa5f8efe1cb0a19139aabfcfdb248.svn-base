/*
此模块文件负责处理url相关操作
 */
import req from '@/utils/request'

const datetime = require('@/api/collection/datetime');
const common = require('@/api/collection/common');

/**
 * 根据参数名称获取url参数
 * @param name
 * @returns {string|null}
 */
export function getUrlParamValue(name) {
  let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  let r = window.location.search.substr(1).match(reg);
  if (r != null) return decodeURIComponent(r[2]);
  return null;
}

/**
 * 获取url中的最后参数
 * @returns 参数构成的对象
 */
export function getRequest() {
  let url = location.search; //获取url中"?"符后的字串
  let theRequest = {};
  if (url.indexOf("?") !== -1) {
    let str = url.substr(1);
    let strs = str.split("&");
    for (let i = 0; i < strs.length; i++) {
      theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
    }
  }
  return theRequest;
}


/**
 * 发送ajax请求，doSuccess为成功回调函数，在自己的页面中定义,具体时间可自定义
 * @param url
 * @param name
 * @param value
 * @param dateStart
 * @param dateEnd
 * @param handle
 */
//http://58.58.27.77:10304/getSensor/serverSensor.ashx?name=getSensorRecord&value=DZSK00030002000100&start=2020-10-31%2000:00:00&end=2020-10-31%2023:59:59
export function sendRecordRequestWithFreeTime(url, name, value, dateStart, dateEnd, handle) {
  if (!url) {
    return;
  }
  url = url + "?name=" + name + "&value=" + value + "&start=" + dateStart + "&end=" + dateEnd;
  sendRequest(url, handle);
}

/**
 * 发送ajax请求，获取某时段范围内数据，时间固定
 * @param url
 * @param name
 * @param value
 * @param dateStart
 * @param dateEnd
 * @param handle 处理函数
 */
export function sendRecordRequest(url, name, value, dateStart, dateEnd, handle) {
  this.sendRecordRequestWithFreeTime(url, name, value, dateStart + ' 00:00:00', dateEnd + ' 23:59:59', handle);
}


export function getBaseUrl(url) {
  let baseURL = process.env.VUE_APP_BASE_API;
  if (url.indexOf(process.env.VUE_APP_FIRST_API) >= 0) {
    baseURL = process.env.VUE_APP_FIRST_API;
  } else if (url.indexOf(process.env.VUE_APP_SECOND_API) >= 0) {
    baseURL = process.env.VUE_APP_SECOND_API;
  } else if (url.indexOf(process.env.VUE_APP_CLOUD_API) >= 0) {
    baseURL = process.env.VUE_APP_CLOUD_API;
  } else if (url.indexOf(process.env.VUE_APP_RAIN_API) >= 0) {
    baseURL = process.env.VUE_APP_RAIN_API;
  } else if (url.indexOf(process.env.VUE_APP_OUT_API) >= 0) {
    baseURL = process.env.VUE_APP_OUT_API;
  } else if (url.indexOf(process.env.VUE_APP_VIDEO_API) >= 0) {
    baseURL = process.env.VUE_APP_VIDEO_API;
  }
  return baseURL;
}

/**
 * 发送Get请求，doSuccess为成功回调函数，在自己的页面中定义
 * @param url 请求网址
 * @param handle 处理函数
 */
export function sendRequest(url, handle) {
  let that = this;
  let baseURL = getBaseUrl(url);
  url = url.replace(baseURL, '');
  req({
    url: url,
    method: 'get',
    baseURL: baseURL,
  }).then(res => {
    handle ? handle(handleResult(res)) : doSuccess(handleResult(res));
  }).catch(error => {
    console.log(error)
  });
}

/**
 * 发送POST请求，doSuccess为成功回调函数，在自己的页面中定义
 * @param url 请求网址
 * @param data 参数
 * @param handle 处理函数
 */
export function sendPostRequest(url, data, handle) {
  let baseURL = getBaseUrl(url);
  url = url.replace(baseURL, '');
  req({
    url: url,
    method: 'post',
    baseURL: baseURL,
    data: data
  }).then(res => {
    handle ? handle(handleResult(res)) : doSuccess(handleResult(res));
  }).catch(error => {
    console.log(error)
  });
}

/**
 * 根据名称，服务器域名和值构造一个url
 * @param name 名称，通常为getPointLast，getSensorLast，getPointRecord，getSensorRecord之一
 * @param host 域名
 * @param value 具体的id值
 * @returns string
 */
export function createUrl(name, host, value) {
  return host + "?name=" + name + "&value=" + value;
}

/**
 * 同步发送请求
 * @param url 请求网址
 * @param params 参数
 * @returns {null}
 */
export function sendRequestSync(url, params) {
  let result = null;
  let baseURL = getBaseUrl(url);
  url = url.replace(baseURL, '');
  return req({
    url: url,
    method: 'post',
    baseURL: baseURL,
    params: params
  })
}

/**
 * 获取历史降雨数据
 * @param day 日期
 * @param rainPoint 传感器对象
 * @returns {*}
 */
export function requestHistoryRain(day, rainPoint) {
  let date = datetime.getDateWithFormat(day, 'yyyy-MM-dd');
  let dateStart = date + " 00:00:00";
  let dateEnd = date + " 23:59:59";
  let params = {name: common.SENSOR_RECORD_COMMOND, value: rainPoint.id, start: dateStart, end: dateEnd};
  let result;
  return sendRequestSync(rainPoint.url, params);
}

/**
 * 通过远程连接获取和风天气数据数组，三天逐小时
 * @returns {*} 降雨数据
 * @param longitude 经度
 * @param latitude 纬度
 */
export function requestForecastRain(longitude, latitude) {
  let url = "/rain-api/v7/weather/168h?location=" + longitude + ',' + latitude + "&key=bcc82de499fa4abcbce9a61eb9960282";
  let that = this;
  let baseURL = getBaseUrl(url);
  url = url.replace(baseURL, '');
  return req({
    url: url,
    method: 'GET',
    baseURL: baseURL,
  })
}

/**
 * ajax请求后的字符串进行过滤，获取'getPointLast$[{...},...]'中$之后部分
 * @param result 服务器返回的信息
 * @returns json对象
 */
export function handleResult(result) {
  let pos = result.indexOf("$");
  let value = "";
  if (result.length > pos) {
    value = result.substring(pos + 1, result.length);
    return (new Function("return " + value))();   //将字符串转换为json对象
  }
}






