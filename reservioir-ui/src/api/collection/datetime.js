/*
时间模块，提供时间的各种处理函数
 */

/**
 * 将"2020-06-21T15:25:15"格式化为"2020年06月21日15时25分15秒"
 * @param timeStr 时间字符串
 * @returns string
 */
export function formatTime(timeStr) {
  if (!timeStr) {
    return '';
  }
  let partList = timeStr.replace("T", " ").split(" ");
  if (partList.length !== 2) {
    return "";
  }
  let firstPart = partList[0];
  let firstList = firstPart.split('-');
  if (firstList.length !== 3) {
    return "";
  }
  let secondPart = partList[1];
  let secondList = secondPart.split(':');
  if (secondList.length !== 3) {
    return "";
  }
  return firstList[0] + '年' + firstList[1] + '月' + firstList[2] + '日  ' + secondList[0] + '时' + secondList[1] + '分' +
    secondList[2] + '秒';
}


/**
 * 格式化时间，将时间变成"2020-23-04 12:05:56"
 * @param strTime 服务器时间
 * @returns 格式化时间字符串
 */
export function formatDateTime(strTime) {
  strTime = strTime.replace(/-/g, '/');
  strTime = strTime.replace(/T/g, ' ');
  var date = new Date(strTime);
  return date.getFullYear() + "-" + formalize(date.getMonth() + 1) + "-" +
    formalize(date.getDate()) + " " + formalize(date.getHours()) +
    ":" + formalize(date.getMinutes()) + ":" + formalize(date.getSeconds());
}

/**
 * 将时间规范化，比如3：3：43变为03：03：43
 * @returns 规范化后的值，如03
 * @param value
 */
export function formalize(value) {
  return value < 10 ? '0' + value : value
}

/**
 * 计算两个日期天数差的函数
 * @param sDate1
 * @param sDate2
 * @returns {number}
 * @constructor
 */
export function dateDiff(sDate1, sDate2) { //sDate1和sDate2是yyyy-MM-dd格式
  let aDate, oDate1, oDate2;
  oDate1 = new Date(sDate1.replace(/-/g, '/')); //转换为yyyy-MM-dd格式
  oDate2 = new Date(sDate2.replace(/-/g, '/'));
  return parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
}

export function sameHour(firstDate, secondDate) {
  let fd = new Date(firstDate);
  let sd = new Date(secondDate);
  return fd.getHours() === sd.getHours();
}

export function getHour(date) {
  let d = new Date(date);
  return parseInt(d.getHours());
}

//2020-07-29T20:00+08:00  转为index
export function transDateToIndex(t) {
  let now = new Date().format('yyyy-MM-dd');
  let date = t.split('T')[0];
  let hour = t.split('T')[1].substring(0, 2);
  return this.dateDiff(date, now) * 24 + parseInt(hour);
}

/**
 * 根据和今天的天数之差获取某天的日期
 * @param dayDiff
 * @returns {*}
 */
export function getDateWithDiff(dayDiff) {
  let day = new Date();
  day.setDate(day.getDate() - dayDiff);
  return day.format("yyyy-MM-dd");
}

/**
 * 判断某时间是否在两个时间范围内
 * @param beginDateStr 起始时间
 * @param endDateStr 结束时间
 * @returns {boolean}
 */
export function isDuringDate(beginDateStr, endDateStr) {
  let curDate = new Date(),
    beginDate = new Date(beginDateStr),
    endDate = new Date(endDateStr);
  return curDate >= beginDate && curDate <= endDate;
}

/**
 * 判断某时间是否在讯期，汛期6月20日-9月30日
 * @returns {boolean}
 */
export function isFloodDate(){
  let dateBegin = new Date();
  dateBegin.setMonth(5);
  dateBegin.setDate(1);
  let strDateBegin = dateBegin.format('yyyy/MM/dd');

  let dateEnd = new Date();
  dateEnd.setMonth(8);
  dateEnd.setDate(30);
  let strDateEnd = dateEnd.format('yyyy/MM/dd');
  return this.isDuringDate(strDateBegin, strDateEnd);
}

/**
 * 根据和今天的天数之差获取某天的日期
 * @param dayDiff
 * @param format
 * @returns {*}
 */
export function getDateWithFormat(dayDiff, format) {
  let day = new Date();
  day.setDate(day.getDate() - dayDiff);
  return day.format(format);
}

export function getDayStr(dayDiff, end) {
  let day = new Date();
  day.setDate(day.getDate() + dayDiff);
  let month = day.getMonth() + 1;
  let date = day.getDate();
  month = month > 9 ? month : "0" + month;
  date = date > 9 ? date : "0" + date;
  return month + "-" + date + (end ? " 23:00" : " 0:00");
}

/**
 * 时间转换，现在时刻2020-10-22 13:00:00 如果hour为34，结果为2020-10-23 10:00:00
 * @param hour 时间段
 * @returns {Date} 具体日期
 */
export function convertHourToTime(hour) {
  let day = new Date();
  let hourDiff = day.getHours() - hour;
  day.setHours(day.getHours() - hourDiff);
  return day;
}

/**
 * 格式化日期对象
 * @param date 日期对象
 * @returns {*} 日期字符串
 */
export function formatToDate(date) {
  return date.format('yyyy-MM-dd');
}

/**
 * 格式化日期对象
 * @param date 日期对象
 * @returns {*} 日期字符串
 */
export function formatToYearMonth(date) {
  return date.format('yyyy年MM月');
}

/**
 * 格式化日期对象
 * @param date 日期对象
 * @returns {*} 日期字符串
 */
export function formatToYearMonthDate(date) {
  return date.format('yyyy年MM月dd日');
}

/**
 * 格式化日期对象
 * @param date 日期对象
 * @returns {*} 日期时间字符串
 */
export function formatToDateTime(date) {
  return date.format('yyyy-MM-dd hh:mm:ss');
}

/**
 * 获取两个日期之间的每一天
 * @param start 开始日期
 * @param end 结束日期
 * @returns {[]} 每日列表
 */
export function getDayList(start, end) {
  let dateList = [];
  let startTime = this.getDate(start);
  let endTime = this.getDate(end);

  while ((endTime.getTime() - startTime.getTime()) >= 0) {
    let year = startTime.getFullYear();
    let month = startTime.getMonth() + 1 < 10 ? '0' + (startTime.getMonth() + 1) : startTime.getMonth() + 1;
    let day = startTime.getDate().toString().length === 1 ? "0" + startTime.getDate() : startTime.getDate();
    dateList.push(year + "-" + month + "-" + day);
    startTime.setDate(startTime.getDate() + 1);
  }
  return dateList;
}

/**
 * 将日期字符串转化为日期对象（忽略时间）
 * @param strDate 日期字符串
 * @returns {Date} 日期对象
 */
export function getDate(strDate) {
  let temp = strDate.split("-");
  return new Date(temp[0], temp[1] - 1, temp[2]);
}


/**
 * 格式化日期类型对象，此对象不是日期格式
 * @param date
 * @returns {string}
 */
export function formatDate(date) {
  return date.year + "-" + this.add0(date.month) + "-" + this.add0(date.date);
}

/**
 * 将日期添加若干小时，然后得到新日期
 * @param date
 * @param hour
 * @returns {*}
 */
export function addHour(date, hour) {
  let time = date.getTime() + hour * 3600 * 1000;
  return getFormatTime(time);

  function getFormatTime(time) {
    date.setTime(time);
    return date.format("yyyy-MM-dd hh:mm:ss");
  }
}

/**
 * 加0格式化日期
 * @param m 日期值
 * @returns {*} 格式化的字符串
 */
export function add0(m) {
  return m < 10 ? '0' + m : m
}

/**
 * 获取两个日期中间间隔的天数
 * @param strStart 起始日期
 * @param strEnd 结束日期
 * @returns {number} 间隔天数
 */
export function getDaysBetween(strStart, strEnd) {
  let dateStart = new Date(strStart.replace(/-/g, '/'));
  let dateEnd = new Date(strEnd.replace(/-/g, '/'));
  return parseInt(Math.abs(dateEnd - dateStart) / 1000 / 60 / 60 / 24);
}



