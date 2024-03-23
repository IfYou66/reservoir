/**
 * 核心数据模块，记录水库重要信息，便于统一修改和数据共享。
 */
const request = require('../request');
const calculator = require('../calculator');
const operator = require('../operator');
const sensorList = require('./sensorList');
const common = require('../common');
const base = require('./base');

/**
 * 发送请求
 */
export function sendInfo() {
  request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_NEW, 'HHSK'));
  request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL, 'HHSK'));
  request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL, 'DZSK0001000102'));
  request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL, 'DZSK00020002'));

  setTimeout(function () {
    let dateEnd = new Date();
    let dateStart = new Date();
    dateStart.setHours(new Date().getHours() - 1);
    let sens = operator.getSensors(sensorList.createSensors(), 'name', '沉降', true);
    for (let i = 0; i < sens.length; i++) {
      if (sens[i].id) {
        request.sendRecordRequestWithFreeTime(common.SENSOR_URL_NEW, common.SENSOR_RECORD_COMMOND, sens[i].id, dateStart.format('yyyy-MM-dd hh:mm:ss'), dateEnd.format('yyyy-MM-dd hh:mm:ss'))
      }
    }
  }, 100);
  setTimeout(function () {
    request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_CLOUD, 'HHSK0014CD1A22001'));
    request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_CLOUD, 'HHSK0014CD1A22002'));
    request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_CLOUD, 'HHSK0014CD1A22003'));
    request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_CLOUD, 'HHSK0014CD1A22004'));
    request.sendRequest(request.createUrl(common.SENSOR_LAST_COMMOND, common.SENSOR_URL_CLOUD, 'HHSK0014CD1A22005'));
  }, 100);
}


/**
 * 获取大坝数据
 */
export function getDam() {
  return {
    /**
     * 滑坡监测传感器
     */
    getLandslideSafe: function () {
      common.switchContent();
    },

    /** 大坝变形监测数据 */
    getTransformSafe: function () {

    },

    getSeepageSafe: function () {
      /**
       * 矫正函数 用来对坐标上的X横坐标值做矫正
       * @param aspect
       * @param value 纵坐标
       */
      function getPointOffset(aspect, value) {
        let x = 0;
        if (value < aspect.getBoundaryShapes().damShell[1][1]) {
          x = operator.getX(aspect.getBoundaryShapes().damShell[0], aspect.getBoundaryShapes().damShell[1], value);
        }
        return x;
      }

      /**
       * 创建浸润线
       * @returns {[]}
       */
      function createBodySinkLine(aspect) {
        let points = createDamWaterShape(aspect, operator.getWaterLevel());
        let resultArr = [];
        for (let i = 1; i < points.length - 2; i++) {
          resultArr.push(points[i]);
        }
        let sensors = operator.getSensors(aspect.sensors, 'category', 'body');

        for (let i = 0; i < sensors.length; i++) {
          resultArr.push([sensors[i].pos, sensors[i].value]);
        }
        resultArr.push([aspect.base.maxX - 10, aspect.base.minY + 10.5]);
        resultArr.push([aspect.base.minX + 20, aspect.base.minY + 10.5]);
        return resultArr;
      }

      /**
       * 创建浸润线
       * @returns {[]}
       */
      function createBaseSinkLine(aspect) {
        let resultArr = [];
        let sensors = operator.getSensors(aspect.sensors, 'category', 'base');
        for (let i = 0; i < sensors.length; i++) {
          resultArr.push([sensors[i].pos, sensors[i].value]);
        }
        return resultArr;
      }

      function createWaterLevel(aspect, waterLevel) {
        return [[aspect.base.minX, waterLevel], [getPointOffset(aspect, waterLevel), waterLevel]];
      }

      /*
      渗流线
       */
      function getPhreaticLines() {
        return {
          276: [276.00, 275.63, 275.33, 275.03, 274.72, 274.24, 273.75,
            273.33, 272.91, 272.43, 271.90, 271.43, 270.94, 270.45, 269.98,
            269.53, 269.05, 268.49, 267.94, 267.62, 267.61, 267.01],
          277: [277.00, 276.64, 276.35, 276.06, 275.77, 275.31, 274.83,
            274.42, 274.02, 273.53, 272.97, 272.41, 271.81, 271.19, 270.57,
            269.99, 269.37, 268.67, 268.02, 267.66, 267.65, 267.01],
          278: [278.00, 277.66, 277.38, 277.10, 276.82, 276.37, 275.91,
            275.52, 275.13, 274.64, 274.04, 273.38, 272.68, 271.93, 271.17,
            270.45, 269.69, 268.85, 268.09, 267.71, 267.70, 267.01],
          279: [279.00, 278.67, 278.40, 278.13, 277.86, 277.43, 276.99,
            276.61, 276.24, 275.74, 275.11, 274.36, 273.55, 272.67, 271.76,
            270.91, 270.02, 269.04, 268.17, 267.76, 267.74, 267.01],
          280: [280.00, 279.68, 279.42, 279.17, 278.91, 278.49, 278.07,
            277.71, 277.35, 276.84, 276.18, 275.34, 274.42, 273.41, 272.35,
            271.37, 270.34, 269.22, 268.24, 267.81, 267.79, 267.01],
          281: [281.00, 280.70, 280.45, 280.20, 279.95, 279.56, 279.15,
            278.80, 278.47, 277.94, 277.25, 276.32, 275.29, 274.15, 272.95,
            271.83, 270.66, 269.40, 268.32, 267.86, 267.83, 267.01],
          282: [282.00, 281.71, 281.47, 281.23, 281.00, 280.62, 280.23,
            279.90, 279.58, 279.04, 278.32, 277.29, 276.16, 274.89, 273.54,
            272.29, 270.99, 269.59, 268.39, 267.91, 267.88, 267.01],
          283: [283.00, 282.72, 282.50, 282.27, 282.04, 281.68, 281.31,
            281.00, 280.69, 280.14, 279.39, 278.27, 277.02, 275.62, 274.13,
            272.75, 271.31, 269.77, 268.46, 267.96, 267.92, 267.01],
          284: [284.00, 283.74, 283.52, 283.30, 283.09, 282.75, 282.39,
            282.09, 281.80, 281.25, 280.46, 279.25, 277.89, 276.36, 274.72,
            273.21, 271.63, 269.95, 268.54, 268.01, 267.96, 267.01],
          285: [285.00, 284.75, 284.54, 284.34, 284.13, 283.81, 283.47,
            283.19, 282.91, 282.35, 281.53, 280.23, 278.76, 277.10, 275.32,
            273.68, 271.96, 270.14, 268.61, 268.06, 268.01, 267.01],
          286: [286.00, 285.76, 285.57, 285.37, 285.18, 284.87, 284.55,
            284.28, 284.02, 283.45, 282.60, 281.20, 279.63, 277.84, 275.91,
            274.14, 272.28, 270.32, 268.69, 268.11, 268.05, 267.01],
          287: [287.00, 286.78, 286.59, 286.41, 286.23, 285.93, 285.63,
            285.38, 285.13, 284.55, 283.66, 282.18, 280.50, 278.58, 276.50,
            274.60, 272.60, 270.51, 268.76, 268.16, 268.10, 267.01],
          288: [288.00, 287.79, 287.62, 287.44, 287.27, 287.00, 286.71,
            286.47, 286.24, 285.65, 284.73, 283.16, 281.37, 279.32, 277.10,
            275.06, 272.93, 270.69, 268.84, 268.20, 268.14, 267.01,],
          289: [289.00, 288.80, 288.64, 288.48, 288.32, 288.06, 287.79,
            287.57, 287.35, 286.76, 285.80, 284.13, 282.24, 280.06, 277.69,
            275.52, 273.25, 270.87, 268.91, 268.25, 268.19, 267.01],
          290: [290.00, 289.82, 289.66, 289.51, 289.36, 289.12, 288.87,
            288.66, 288.46, 287.86, 286.87, 285.11, 283.11, 280.79, 278.28,
            275.98, 273.57, 271.06, 268.98, 268.30, 268.23, 267.01],
          291: [291.00, 290.83, 290.69, 290.55, 290.41, 290.18, 289.95,
            289.76, 289.57, 288.96, 287.94, 286.09, 283.98, 281.53, 278.87,
            276.44, 273.90, 271.24, 269.06, 268.35, 268.28, 267.01],
          292: [292.00, 291.84, 291.71, 291.58, 291.45, 291.25, 291.03,
            290.85, 290.68, 290.06, 289.01, 287.07, 284.85, 282.27, 279.47,
            276.90, 274.22, 271.42, 269.13, 268.40, 268.32, 267.01],
          293: [293.00, 292.85, 292.74, 292.62, 292.50, 292.31, 292.12,
            291.95, 291.79, 291.16, 290.08, 288.04, 285.71, 283.01, 280.06,
            277.36, 274.54, 271.61, 269.21, 268.45, 268.37, 267.01],
          294: [294.00, 293.87, 293.76, 293.65, 293.54, 293.37, 293.20,
            293.05, 292.90, 292.26, 291.15, 289.02, 286.58, 283.75, 280.65,
            277.83, 274.87, 271.79, 269.28, 268.50, 268.41, 267.01],
          295: [295.00, 294.88, 294.78, 294.69, 294.59, 294.44, 294.28,
            294.14, 294.01, 293.37, 292.22, 290.00, 287.45, 284.49, 281.25,
            278.29, 275.19, 271.97, 269.36, 268.55, 268.46, 267.01],
          296: [296.00, 295.89, 295.81, 295.72, 295.64, 295.50, 295.36,
            295.24, 295.12, 294.47, 293.29, 290.97, 288.32, 285.23, 281.84,
            278.75, 275.51, 272.16, 269.43, 268.60, 268.50, 267.01],
          297: [297.00, 296.91, 296.83, 296.76, 296.68, 296.56, 296.44,
            296.33, 296.23, 295.57, 294.36, 291.95, 289.19, 285.96, 282.43,
            279.21, 275.84, 272.34, 269.51, 268.65, 268.55, 267.01],
          298: [298.00, 297.92, 297.86, 297.79, 297.73, 297.62, 297.52,
            297.43, 297.34, 296.67, 295.43, 292.93, 290.06, 286.70, 283.02,
            279.67, 276.16, 272.52, 269.58, 268.70, 268.59, 267.01],
          299: [299.00, 298.93, 298.88, 298.83, 298.77, 298.69, 298.60,
            298.52, 298.45, 297.77, 296.50, 293.91, 290.93, 287.44, 283.62,
            280.13, 276.48, 272.71, 269.65, 268.75, 268.63, 267.02],
          300: [300.00, 299.95, 299.90, 299.86, 299.82, 299.75, 299.68,
            299.62, 299.56, 298.88, 297.57, 294.88, 291.80, 288.18, 284.21,
            280.59, 276.81, 272.89, 269.73, 268.79, 268.68, 267.02],
          301: [301.00, 300.96, 300.93, 300.90, 300.86, 300.81, 300.76,
            300.71, 300.67, 299.98, 298.64, 295.86, 292.67, 288.92, 284.80,
            281.05, 277.13, 273.08, 269.80, 268.84, 268.72, 267.02],
          302: [302.00, 301.97, 301.95, 301.93, 301.91, 301.87, 301.84,
            301.81, 301.78, 301.08, 299.71, 296.84, 293.53, 289.66, 285.40,
            281.51, 277.46, 273.26, 269.88, 268.89, 268.77, 267.02],
          303: [303.00, 302.99, 302.98, 302.97, 302.95, 302.94, 302.92,
            302.90, 302.89, 302.18, 300.77, 297.81, 294.40, 290.39, 285.99,
            281.98, 277.78, 273.44, 269.95, 268.94, 268.81, 267.02],
          304: [304.00, 304.00, 304.00, 304.00, 304.00, 304.00, 304.00,
            304.00, 304.00, 303.28, 301.84, 298.79, 295.27, 291.13, 286.58,
            282.44, 278.10, 273.63, 270.03, 268.99, 268.86, 267.02],
          305: [305.00, 307.00, 307.00, 307.00, 307.00, 307.00, 307.00,
            307.00, 307.00, 304.38, 302.91, 299.77, 296.14, 291.87, 287.17,
            282.90, 278.43, 273.81, 270.10, 269.04, 268.90, 267.02],
          306: [306.00, 307.00, 307.00, 307.00, 307.00, 307.00, 307.00,
            307.00, 307.00, 305.49, 303.98, 300.75, 297.01, 292.61, 287.77,
            283.36, 278.75, 273.99, 270.18, 269.09, 268.95, 267.02],
          307: [307.00, 307.00, 307.00, 307.00, 307.00, 307.00, 307.00,
            307.00, 307.00, 306.59, 305.05, 301.72, 297.88, 293.35, 288.36,
            283.82, 279.07, 274.18, 270.25, 269.14, 268.99, 267.02],
        }
      }

      function createDamOption(type, aspect) {
        return {
          title: {
            textStyle: {
              color: '#fff0cd'
            }
          },
          tooltip: {
            trigger: "axis",
            show: false,
          },
          xAxis: [{
            name: '',
            type: 'value',
            max: aspect.base.maxX,
            min: aspect.base.minX,
            nameLocation: 'end',
            axisLabel: {
              show: true,
              textStyle: {
                color: '#fff0cd'
              }
            },
            splitLine: {
              show: false     //去掉网格线
            },
            axisLine: {
              show: true,
              onZero: false,
              color: '#e4f3cd',
            },
          }],
          yAxis: [
            {
              name: '高程(m)',
              type: 'value',
              position: 'left',
              max: aspect.base.maxY,
              min: aspect.base.minY,
              axisLine: {
                onZero: false,
                lineStyle: {
                  color: '#8edfb9',
                }
              },
              splitLine: {
                show: false     //去掉网格线
              },
              axisLabel: {
                formatter: '{value} m',
                textStyle: {
                  color: '#b6d377'
                }
              }
            }
          ],
          series: getShapes(aspect, type),
        };
      }

      /**
       * 创建一个不规则形状，表示大坝水体
       * @returns {*[][]} 使用一个数组表达矩形的点
       * @param aspect
       * @param waterLevel
       */
      function createDamWaterShape(aspect, waterLevel) {
        let pointsData = aspect.getBoundaryShapes().damShell;
        let points = [[-20, pointsData[0][1]]];
        points.push(pointsData[0]);
        if (waterLevel < pointsData[1][1]) {   //第一斜坡范围内
          points.push([operator.getX(pointsData[0], pointsData[1], waterLevel), waterLevel]);
        } else if (waterLevel < pointsData[3][1]) {
          points.push(pointsData[1]);        //第二斜坡范围内
          points.push(pointsData[2]);
          points.push([operator.getX(pointsData[2], pointsData[3], waterLevel), waterLevel]);
        } else {                                 //第三斜坡范围内
          points.push(pointsData[1]);
          points.push(pointsData[2]);
          points.push(pointsData[3]);
          points.push(pointsData[4]);
          points.push([operator.getX(pointsData[4], pointsData[5], waterLevel), waterLevel]);
        }
        points.push([-20, waterLevel]);
        points.push([-20, pointsData[0][1]]);
        return points;
      }

      /*
      插值计算渗流线
       */
      function createPhreaticLine(aspect) {
        let waterLevel = operator.getWaterLevel(true);
        //得到相邻的两条线
        let low = Math.floor(waterLevel);
        let high = Math.ceil(waterLevel);
        let percentage = waterLevel - low;
        let points = [];
        for (let i = 0; i < getPhreaticLines()[low].length; i++) {
          let scope = getPhreaticLines()[high][i] - getPhreaticLines()[low][i];
          points.push(getPhreaticLines()[low][i] + scope * percentage);
        }
        let offset = getPointOffset(aspect, points[0]) + 20;
        points = points.map((x, index) => [(-20 + index * 2 * (0.55) + offset), x]);
        points[points.length - 1] = [126 + offset, points[points.length - 1][1]];
        return points;
      }

      function createBoundaryShapes(aspect) {
        return [
          operator.createShape('', aspect.getBoundaryShapes().baseRock, 4, {}, {isArea: true}, '#9b3812'),
          operator.createShape('', aspect.getBoundaryShapes().damShell, 4, {}, {
            isArea: true,
          }, '#006a35ff'),
          operator.createShape('防浪墙', operator.createRect(100, 172.5, 1.5, 4), 1, {}, {
            isSmooth: true,
            isMarkPoint: true,
            isArea: true,
          }, '#9f9f00'),
        ]
      }

      function createWaterLevelShapes(aspect) {
        return [
          operator.createShape('实时水位', createDamWaterShape(aspect, operator.getWaterLevel()), 65, {}, {
            isMarkPoint: true,
            isArea: true,
            showSymbol: true
          }, '#0080ff',),
        ]
      }


      function createSensorShapes(aspect) {
        let sensorShapes = [
          operator.createShape('死水位', createDamWaterShape(aspect, base.getBaseInfo().deadWaterLevel), 1, {
            xAxis: 4.4,
            yAxis: base.getBaseInfo().deadWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true,
            isArea: true,
          }, '#b4ecff'),
          operator.createShape('防洪限制水位', createWaterLevel(aspect, base.getBaseInfo().highWaterLevel), 1, {
            xAxis: 24,
            yAxis: base.getBaseInfo().highWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true
          }, '#616130',),
          operator.createShape('兴利水位', createWaterLevel(aspect, base.getBaseInfo().headWaterLevel), 1, {
            xAxis: -2,
            yAxis: base.getBaseInfo().headWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true,
            lineWidth: 4
          }, '#F00078'),
          operator.createShape('防洪高水位', createWaterLevel(aspect, base.getBaseInfo().floodDesignWaterLevel), 2, {
            xAxis: 65,
            yAxis: base.getBaseInfo().floodDesignWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true
          }, '#D200D2'),
          operator.createShape('设计洪水位', createWaterLevel(aspect, base.getBaseInfo().designWaterLevel), 2, {
            xAxis: 12,
            yAxis: base.getBaseInfo().designWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true
          }, '#8600FF',),
          operator.createShape('校核洪水位', createWaterLevel(aspect, base.getBaseInfo().checkWaterLevel), 2, {
            xAxis: 55,
            yAxis: base.getBaseInfo().checkWaterLevel
          }, {
            isMarkPoint: true,
            showValue: true
          }, '#8600FF'),
        ];

        let sensors = operator.getSensors(aspect.sensors, 'category', 'body');
        if (sensors.length > 0) {
          for (let i = 0; i < sensors.length; i++) {
            sensorShapes.push(createBodySensorShape(aspect.base, sensors, sensors[i].name.substr(0, 2), i));
            sensorShapes.push(createBodyValueShape(aspect.base, sensors, sensors[i].name, i));
          }
          sensorShapes.push(operator.createShape('浸润线', createBodySinkLine(aspect), 1, {}, {
            isSmooth: false,
            isArea: true,
          }, '#00AEAE'));
        }

        sensors = operator.getSensors(aspect.sensors, 'category', 'base');
        if (sensors.length > 0) {
          for (let i = 0; i < sensors.length; i++) {
            sensorShapes.push(createBaseSensorShape(aspect.base, sensors, sensors[i].name.substr(0, 2), i));
            sensorShapes.push(createBaseValueShape(aspect.base, sensors, sensors[i].name, i));
          }
          sensorShapes.push(operator.createShape('浸润线', createBaseSinkLine(aspect), 1, {}, {
            isSmooth: false,
            isArea: true,
            lineWidth: 3
          }, '#4200ae'),);
        }
        return sensorShapes;
      }

      function createBodySensorShape(base, sensors, name, index) {
        return operator.createShape(name, operator.createRect(sensors[index].pos, sensors[index].low, 0.5, sensors[index].height - sensors[index].low), 1, {}, {
          isSmooth: true,
          isMarkPoint: true,
          isArea: true,
        }, '#ffbf6c', '#cbcb00', '#ffbf6c')
      }


      function createBodyValueShape(base, sensors, name, index) {
        return operator.createShape(name, operator.createRect(sensors[index].pos, sensors[index].low, 0.5, sensors[index].value - sensors[index].low), 65, {}, {
          isMarkPoint: true,
          isArea: true,
          showSymbol: true
        }, '#00836C')
      }

      function createBaseSensorShape(base, sensors, name, index) {
        return operator.createShape(name, operator.createRect(sensors[index].pos, sensors[index].low, 0.5, sensors[index].height - sensors[index].low), 1, {}, {
          isSmooth: true,
          isMarkPoint: true,
          isArea: true,
        }, '#ffbf6c', '#d0e165', '#0c8289')
      }


      function createBaseValueShape(base, sensors, name, index) {
        return operator.createShape(name, operator.createRect(sensors[index].pos, sensors[index].low, 0.5, sensors[index].value - sensors[index].low), 65, {}, {
          isMarkPoint: true,
          isArea: true,
          showSymbol: true
        }, '#122483')
      }

      function createPhreaticShape(aspect) {
        return [
          operator.createShape('理论浸润线', createPhreaticLine(aspect), 3, {}, {
            showSymbol: true
          }, '#ae1b23', '#ae1b23', '#ae1b23')
        ]
      }

      function createStreamShapes(aspect) {
        return [
          operator.createShape('上游滑弧', aspect.getBoundaryShapes().upStream, 1, {
            xAxis: 80,
            yAxis: 302
          }, {isArea: true, isMarkPoint: true}, '#a8153c'),
          operator.createShape('下游滑弧', aspect.getBoundaryShapes().downStream, 1, {
            xAxis: 190,
            yAxis: 275
          }, {isArea: true, isMarkPoint: true}, '#a8153c')
        ]
      }

      function getShapes(aspect, type) {
        let series = [];
        let sens;
        if (type === 1) {       //无浸润线，有数据,无滑弧
          sens = createWaterLevelShapes(aspect).concat(createBoundaryShapes(aspect)).concat(createSensorShapes(aspect));
        } else if (type === 2) {  //有浸润线，无数据,无滑弧
          sens = createWaterLevelShapes(aspect).concat(createBoundaryShapes(aspect)).concat(createPhreaticShape(aspect));
        } else if (type === 3) {  //只有滑弧
          sens = createBoundaryShapes(aspect).concat(createStreamShapes(aspect));
        }
        for (let i = 0; i < sens.length; i++) {
          series.push(operator.createShapeSeries(sens[i]));
        }
        return series;
      }

      return [
        {
          sensors: operator.getSensors(common.loadSensors(), 'section', '0+030断面'),
          name: '0+030断面',
          base: {
            minY: 112,                          //y轴最小值
            maxY: 180,                          //y轴最大值
            minX: -20,                          //x轴最小值
            maxX: 210,                          //x轴最大值
            bias: 11,                           //偏移
            thick: 10,
            top: 172.5
          },
          imageArray: Array.from({length: 18}, (v, k) => k + 290),
          createDam: function (type) {
            return createDamOption(type, this);
          },

          getBoundaryShapes: function () {
            let bias = 195.5;
            let prop = 1.3;
            return {
              //基岩
              baseRock: [
                [this.base.minX, this.base.minY],
                [this.base.minX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY],
              ],

              //坝壳
              damShell: [
                [0, this.base.minY + this.base.thick],
                [100, this.base.top],
                [120, this.base.top],
                [140, 158],
                [145, 158],
                [160, 146],
                [165, 146],
                [200, this.base.minY + this.base.thick],
              ],
            }
          },
        },
        {
          name: '0+300断面',
          sensors: operator.getSensors(common.loadSensors(), 'section', '0+300断面'),
          base: {
            minY: 112,                          //y轴最小值
            maxY: 180,                          //y轴最大值
            minX: -20,                          //x轴最小值
            maxX: 210,                          //x轴最大值
            bias: 11,                           //偏移
            thick: 10,
            top: 172.5
          },
          imageArray: Array.from({length: 18}, (v, k) => k + 290),
          createDam: function (type) {
            return createDamOption(type, this);
          },

          getBoundaryShapes: function () {
            let bias = 195.5;
            let prop = 1.3;
            return {
              //基岩
              baseRock: [
                [this.base.minX, this.base.minY],
                [this.base.minX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY],
              ],

              //坝壳
              damShell: [
                [0, this.base.minY + this.base.thick],
                [100, this.base.top],
                [120, this.base.top],
                [140, 158],
                [145, 158],
                [160, 146],
                [165, 146],
                [200, this.base.minY + this.base.thick],
              ],
            }
          },
        },
        {
          sensors: operator.getSensors(common.loadSensors(), 'section', '0+410断面'),
          name: '0+410断面',
          base: {
            minY: 112,                          //y轴最小值
            maxY: 180,                          //y轴最大值
            minX: -20,                          //x轴最小值
            maxX: 210,                          //x轴最大值
            bias: 11,                           //偏移
            thick: 10,
            top: 172.5
          },
          imageArray: Array.from({length: 18}, (v, k) => k + 290),
          createDam: function (type) {
            return createDamOption(type, this);
          },

          getBoundaryShapes: function () {
            let bias = 195.5;
            let prop = 1.3;
            return {
              //基岩
              baseRock: [
                [this.base.minX, this.base.minY],
                [this.base.minX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY],
              ],

              //坝壳
              damShell: [
                [0, this.base.minY + this.base.thick],
                [100, this.base.top],
                [120, this.base.top],
                [140, 158],
                [145, 158],
                [160, 146],
                [165, 146],
                [200, this.base.minY + this.base.thick],
              ],
            }
          },
        },
        {
          sensors: operator.getSensors(common.loadSensors(), 'section', '0+520断面'),
          name: '0+520断面',
          base: {
            minY: 112,                          //y轴最小值
            maxY: 180,                          //y轴最大值
            minX: -20,                          //x轴最小值
            maxX: 210,                          //x轴最大值
            bias: 11,                           //偏移
            thick: 10,
            top: 172.5
          },
          imageArray: Array.from({length: 18}, (v, k) => k + 290),
          createDam: function (type) {
            return createDamOption(type, this);
          },

          getBoundaryShapes: function () {
            let bias = 195.5;
            let prop = 1.3;
            return {
              //基岩
              baseRock: [
                [this.base.minX, this.base.minY],
                [this.base.minX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY],
              ],

              //坝壳
              damShell: [
                [0, this.base.minY + this.base.thick],
                [100, this.base.top],
                [120, this.base.top],
                [140, 158],
                [145, 158],
                [160, 146],
                [165, 146],
                [200, this.base.minY + this.base.thick],
              ],
            }
          },
        },
        {
          sensors: operator.getSensors(common.loadSensors(), 'section', '0+700断面'),
          name: '0+700断面',
          base: {
            minY: 117,                          //y轴最小值
            maxY: 180,                          //y轴最大值
            minX: -20,                          //x轴最小值
            maxX: 210,                          //x轴最大值
            bias: 11,                           //偏移
            thick: 10,
            top: 172.5
          },
          imageArray: Array.from({length: 18}, (v, k) => k + 290),
          createDam: function (type) {
            return createDamOption(type, this);
          },

          getBoundaryShapes: function () {
            let bias = 195.5;
            let prop = 1.3;
            return {
              //基岩
              baseRock: [
                [this.base.minX, this.base.minY],
                [this.base.minX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY + this.base.thick],
                [this.base.maxX, this.base.minY],
              ],

              //坝壳
              damShell: [
                [0, this.base.minY + this.base.thick],
                [100, this.base.top],
                [120, this.base.top],
                [140, 158],
                [145, 158],
                [160, 146],
                [165, 146],
                [200, this.base.minY + this.base.thick],
              ],
            }
          },
        },
      ]
    },

    /**
     * 大坝分析-稳定计算
     */
    getStableAnalysis: function () {
      let result = this.getSeepageSafe();
      result.stables = [
        {
          name: '0+030断面',
          stableUp: 0.3,
          stableDown: 0.5,
        }
      ];
      return result;
    },

    /**
     * 大坝分析-稳定计算
     */
    getSeepageAnalysis: function (isControl) {
      if (isControl) {
        common.switchContent();
      } else {
        return this.getSeepageSafe();
      }
    }
  }
}

/**
 * 获取闸门数据
 */
export function getGate() {
  return {
    /** 获取位移数据 */
    getDisplacementSafe: function () {

    },

    /** 获取扬压力及实时渗流数据 */
    getSeepageSafe: function () {
      return {
        base: {
          yMin: 77,               //y轴最小值
          yMax: 90,               //y轴最大值
          xMin: -100,             //x轴最小值
          xMax: 300,              //x轴最大值
          pierHeight: 88.85,      //闸墩高程
          gateHeight: 88.44,      //闸门高程
          plateHeight: 78.3,      //闸底板高程
        },
        sensors: common.getData('gateSeepage'),
        getShapes: function (type) {
          let bias = 75;
          return [
            operator.createShape(
              '实时水位', [[this.base.xMin, this.base.plateHeight], [this.base.xMin, this.sensors[0].value - bias],
                [50, this.sensors[0].value - bias], [50, this.base.plateHeight], [this.base.xMin, this.base.plateHeight]],
              65, {}, {
                isMarkPoint: true,
                isArea: true,
                showSymbol: true
              }, '#0080ff', '#0080ff', '#0080ff'),
            operator.createShape('闸底板高程', [[this.base.xMin, this.base.yMin], [this.base.xMin, this.base.plateHeight],
                [88, this.base.plateHeight], [92, this.base.plateHeight], [220, this.base.plateHeight], [this.base.xMax, this.base.yMin]], 1,
              {xAxis: 132, yAxis: 82.6},
              {
                isMarkPoint: true,
                isArea: true,
              }, '#424200', '#424200', '#868600'),
            operator.createShape(
              '浸润线', [[this.sensors[(type - 1) * 3 + 1].pos, this.sensors[(type - 1) * 3 + 1].value],
                [this.sensors[(type - 1) * 3 + 2].pos, this.sensors[(type - 1) * 3 + 2].value],
                [this.sensors[(type - 1) * 3 + 3].pos, this.sensors[(type - 1) * 3 + 3].value]],
              2, {}, {
                isSmooth: true,
                isSolid: true,
                lineWidth: 3
              }, '#eed8ff', '#7fbfff', '#0080ff'),
            operator.createShape(
              '闸墩顶高程', [[-20, this.base.plateHeight], [-20, this.base.pierHeight], [220, this.base.pierHeight],
                [220, this.base.plateHeight], [-20, this.base.plateHeight]], 1,
              {xAxis: 130, yAxis: 308},
              {
                isMarkPoint: true,
                isArea: true,
              }, '#424200', '#272727',
              '#8d8d8d'),
            operator.createShape('闸门顶高程', [[50, this.base.plateHeight], [50, this.base.gateHeight], [56, this.base.gateHeight],
                [56, this.base.plateHeight], [50, this.base.plateHeight]], 1,
              {xAxis: 50, yAxis: 305.1},
              {
                isMarkPoint: true,
                isArea: true,
              }, '#424200', '#272727', '#3c3c3c'),
            operator.createShape(
              '设计洪水位', [[this.base.xMin, base.getBaseInfo().designFloodWaterLevel], [this.base.xMax, base.getBaseInfo().designFloodWaterLevel]],
              1, {xAxis: 0, yAxis: 306.66},
              {
                isMarkPoint: true,
                isArea: false,
              }, '#0000FF', '#272727', '#272727'),
            operator.createShape(
              '井1', operator.createBar(this.sensors[(type - 1) * 3 + 1].pos, this.base.yMin + 0.5), 1,
              {}, {
                isMarkPoint: true,
                isArea: true,
              }, '#FFF0AC', '#FFF0AC', '#FFF0AC'),
            operator.createShape(
              '井2', operator.createBar(this.sensors[(type - 1) * 3 + 2].pos, this.base.yMin + 0.5), 1,
              {}, {
                isMarkPoint: true,
                isArea: true,
              }, '#FFF0AC', '#FFF0AC', '#FFF0AC'),
            operator.createShape(
              '井3', operator.createBar(this.sensors[(type - 1) * 3 + 3].pos, this.base.yMin + 0.5), 1,
              {}, {
                isMarkPoint: true,
                isArea: true,
              }, '#FFF0AC', '#FFF0AC', '#FFF0AC'),
            operator.createShape(
              '井1水', operator.createBarData(this.sensors[(type - 1) * 3 + 1].pos, this.base.yMin + 0.5, (this.sensors[(type - 1) * 3 + 1].value  - 220).toFixed(2)), 65,
              {},
              {
                isMarkPoint: true,
                isArea: true,
                showSymbol: true
              }, '#0080ff', '#0080ff', '#0080ff'),
            operator.createShape(
              '井2水', operator.createBarData(this.sensors[(type - 1) * 3 + 2].pos, this.base.yMin + 0.5, (this.sensors[(type - 1) * 3 + 2].value - 220).toFixed(2)), 65,
              {},
              {
                isMarkPoint: true,
                isArea: true,
                showSymbol: true
              }, '#0080ff', '#0080ff', '#0080ff'),
            operator.createShape(
              '井3水', operator.createBarData(this.sensors[(type - 1) * 3 + 3].pos, this.base.yMin + 0.5, (this.sensors[(type - 1) * 3 + 3].value - 220).toFixed(2)), 65,
              {}, {
                isMarkPoint: true,
                isArea: true,
                showSymbol: true
              }, '#0080ff', '#0080ff', '#0080ff')
          ]
        },

        createGateOption: function (type) {
          return {
            title: {
              text: '',
              subtext: '',
              y: 'bottom',
              textStyle: {
                color: '#eceebc'
              }
            },
            tooltip: {
              trigger: "axis",
              show: false,
            },
            xAxis: [
              {
                name: '',
                type: 'value',
                max: this.base.xMax,
                min: this.base.xMin,
                nameLocation: 'end',
                axisLabel: {
                  show: false,
                  textStyle: {
                    color: '#eceebc'
                  }
                },
                splitLine: {
                  show: false     //去掉网格线
                },
                axisLine: {
                  show: true,
                  onZero: false,
                  color: '#e4f3cd',
                },
              }
            ],
            yAxis: [
              {
                name: '高程(m)',
                type: 'value',
                max: this.base.yMax,
                min: this.base.yMin,
                position: 'right',
                interval: (this.base.yMax - this.base.yMin) / 5,
                axisLine: {
                  onZero: false,
                  lineStyle: {
                    color: '#8edfb9',
                  }
                },
                axisLabel: {
                  formatter: '{value} ',
                  textStyle: {
                    color: '#eceebc'
                  }
                }
              }
            ],
            series: this.createAllSeries(type),
          };
        },

        createAllSeries: function (type) {
          let series = [];
          for (let i = 0; i < this.getShapes(type).length; i++) {
            series.push(operator.createShapeSeries(this.getShapes(type)[i]));
          }
          return series;
        },
      }
    },

    /**
     * 溢洪闸安全-倾斜监测
     */
    getDeclinationSafe: function () {
    },

    /**
     * 溢洪闸安全-振动监测
     */
    getVibrationSafe: function () {
      common.switchContent();
    },

    /**
     * 溢洪闸分析-控制建筑物分析
     */
    getBuildingAnalysis: function () {
      let highLevel = 299.1;
      let that = this;
      //自重
      let weight = {
        闸中墩: {
          厚: function () {
            return 1.5;
          }, 高: function () {
            return 308 - highLevel;
          }, 长: function () {
            return 16.5;
          }, 力臂: function () {
            return 0;
          }, 力: function () {
            return this.厚() * this.高() * this.长() * 2.5 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        闸边墩: {
          厚: function () {
            return 1.5;
          }, 高: function () {
            return 8.9;
          }, 长: function () {
            return 16.5;
          }, 力臂: function () {
            return 0;
          }, 力: function () {
            return this.厚() * this.高() * this.长() * 2.5 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        底板: {
          厚: function () {
            return 1.1;
          }, 宽: function () {
            return 18;
          }, 长: function () {
            return 16.5;
          }, 力臂: function () {
            return 0;
          }, 力: function () {
            return this.厚() * this.宽() * this.长() * 2.5 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        交通桥: {
          厚: function () {
            return 0.77;
          }, 宽: function () {
            return 7;
          }, 长: function () {
            return 18;
          }, 力臂: function () {
            return -(16.5 / 2 - 1.5 / 2 - 7 / 2);
          }, 力: function () {
            return this.厚() * this.宽() * this.长() * 2.5 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        启闭机房: {
          重: function () {
            return 115.2;
          }, 力臂: function () {
            return 16.5 / 2 - 1.5 / 2 - 1.2 - 0.6 - 0.7 / 2 - 1.8;
          }, 力: function () {
            return this.重() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        排架: {
          高: function () {
            return 7;
          }, 断面: function () {
            return 0.36;
          }, 宽: function () {
            return 3;
          }, 牛腿: function () {
            return 1.8;
          }, 力臂: function () {
            return 16.5 / 2 - 1.5 / 2 - 1.2 - 0.6 - 0.7 / 2 - 1.8;
          }, 力: function () {
            return (this.高() * this.断面() * 2 + this.断面() * this.宽() * 2 + this.牛腿() * 2 + 4 * 1) * 2.5 * 2 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        机架桥: {
          断面: function () {
            return 1.536;
          }, 长: function () {
            return 18;
          }, 力臂: function () {
            return 16.5 / 2 - 1.5 / 2 - 1.2 - 0.6 - 0.7 / 2 - 1.8;
          }, 力: function () {
            return (this.断面() * this.长()) * 2.5 * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        汽车: {
          重: function () {
            return 20;
          }, 力臂: function () {
            return -(16.5 / 2 - 1.5 / 2 - 7 / 2);
          }, 力: function () {
            return this.重() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        getAllPower: function () {
          return weight.底板.力() + weight.闸中墩.力() + weight.机架桥.力() +
            weight.交通桥.力() + weight.闸边墩.力() +
            weight.排架.力() + weight.启闭机房.力() + weight.汽车.力();
        },
        getAllForce: function () {
          return weight.底板.力矩() + weight.闸中墩.力矩() + weight.机架桥.力矩() +
            weight.交通桥.力矩() + weight.闸边墩.力矩() +
            weight.排架.力矩() + weight.启闭机房.力矩() + weight.汽车.力矩();
        }
      };

      //竖向水压力
      let verticalWaterPressure = {
        上游: {
          宽: function () {
            return 15;
          }, 高: function () {
            return operator.getWaterLevel(true) - highLevel;
          }, 长: function () {
            return 1.5 / 2 + 1.2 + 0.6 + 1.8;
          }, 力臂: function () {
            return 16.5 / 2 - this.长() / 2;
          }, 力: function () {
            return this.宽() * this.高() * this.长() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        }, 下游: {
          宽: function () {
            return 15;
          }, 高: function () {
            return 0;
          }, 长: function () {
            return 16.5 - verticalWaterPressure.上游.长();
          }, 力臂: function () {
            return this.长() / 2 - 16.5 / 2;
          }, 力: function () {
            return this.宽() * this.高() * this.长() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        getAllPower: function () {
          return verticalWaterPressure.下游.力() + verticalWaterPressure.上游.力();
        },
        getAllForce: function () {
          return verticalWaterPressure.下游.力矩() + verticalWaterPressure.上游.力矩();
        }
      };

      //扬压力
      let upliftPressure = {
        浮托力: {
          宽: function () {
            return 18;
          }, 高: function () {
            return weight.底板.厚() + verticalWaterPressure.下游.高();
          }, 长: function () {
            return 16.5;
          }, 力臂: function () {
            return 0;
          }, 力: function () {
            return this.宽() * this.高() * this.长() * 10 * (-1);
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        }, 渗透压力: {
          宽: function () {
            return 18;
          }, 高: function () {
            return (verticalWaterPressure.上游.高() - verticalWaterPressure.下游.高()) * 16.5 / 36.5;
          }, 长: function () {
            return 16.5;
          }, 力臂: function () {
            return -16.5 / 3 + 16.5 / 2;
          }, 力: function () {
            return this.宽() * this.高() * this.长() / (-2) * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        getAllPower: function () {
          return upliftPressure.浮托力.力() + upliftPressure.渗透压力.力();
        },
        getAllForce: function () {
          return upliftPressure.渗透压力.力矩() + upliftPressure.浮托力.力矩();
        }
      };

      //关闭闸门
      let closeGate = {
        上游: {
          宽: function () {
            return 18;
          }, 高: function () {
            return operator.getWaterLevel(true) - highLevel;
          }, 底板: function () {
            return 1.1;
          }, 力臂: function () {
            return (this.高() + this.底板()) / 3 * (-1);
          }, 力: function () {
            return Math.pow(this.高() + this.底板(), 2) / 2 * this.宽() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        }, 下游: {
          宽: function () {
            return 18;
          }, 高: function () {
            return 0;
          }, 底板: function () {
            return 1.1;
          }, 力臂: function () {
            return (this.高() + this.底板()) / 3;
          }, 力: function () {
            return Math.pow(this.高() + this.底板(), 2) / 2 * this.宽() * -10;
          }, 力矩: function () {
            return this.力() * this.力臂() * (-1);
          }
        },
        getAllPower: function () {
          return closeGate.上游.力() + closeGate.下游.力();
        },
        getAllForce: function () {
          return closeGate.上游.力矩() + closeGate.下游.力矩();
        }
      };

      //开启闸门
      let openGate = {
        上游闸门: {
          闸门挡水高度: function () {
            return 2.5;
          }, 宽: function () {
            return 15;
          }, 底板: function () {
            return 1.1;
          }, 闸门开启高度: function () {
            return 0.5;
          }, 力臂: function () {
            return this.闸门挡水高度() / -3 - this.闸门开启高度() - this.底板();
          }, 力: function () {
            return Math.pow(this.闸门挡水高度(), 2) / 2 * this.宽() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        上游闸墩: {
          高: function () {
            return openGate.上游闸门.闸门挡水高度() + openGate.上游闸门.闸门开启高度();
          }, 宽: function () {
            return 1.5;
          }, 力臂: function () {
            return this.高() / -3 - openGate.上游闸门.底板();
          }, 力: function () {
            return Math.pow(this.高(), 2) / 2 * this.宽() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        下游: {
          高: function () {
            return 0.5;
          }, 宽: function () {
            return 18;
          }, 底板: function () {
            return 1.1;
          }, 力臂: function () {
            return 0;
          }, 力: function () {
            return 0;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        上游底板: {
          高: function () {
            return 3;
          }, 宽: function () {
            return 1.5;
          }, 底板: function () {
            return 1.1;
          }, 力臂: function () {
            return this.底板() / -2;
          }, 力: function () {
            return (this.高() - openGate.下游.高()) * openGate.下游.宽() * 10;
          }, 力矩: function () {
            return this.力() * this.力臂();
          }
        },
        getAllPower: function () {
          return openGate.上游底板.力() + openGate.下游.力() +
            openGate.上游闸墩.力() + openGate.上游闸门.力();
        },
        getAllForce: function () {
          return openGate.上游底板.力矩() + openGate.下游.力矩() +
            openGate.上游闸墩.力矩() + openGate.上游闸门.力矩();
        }
      };

      return {
        weight: weight,
        verticalWaterPressure: verticalWaterPressure,
        upliftPressure: upliftPressure,
        openGate: openGate,
        closeGate: closeGate,
        data: {
          xMin: 0,
          xMax: 100,
          yMin: 298.5,
          yMax: 325,
          backgroundOffset: '31.5% 10px',
          backgroundSize: '79% 108%'
        },
        getPoints: function () {
          return [[0, 298.5], [36.9, 298.5], [36.9 + 1.3, 298.5 + 0.65], [47.5, 298.5 + 0.65], [47.5, operator.getWaterLevel(true)], [0, operator.getWaterLevel(true)]]
        },

        /**
         * 计算开启闸门力矩
         * @returns {*}
         */
        computeOpenGateForce: function () {
          return this.weight.getAllForce() + this.closeGate.getAllForce()
            + this.upliftPressure.getAllForce() + this.verticalWaterPressure.getAllForce();
        },

        /**
         * 计算开启闸门时垂直力
         * @returns {*}
         */
        computeOpenVerticalPower: function () {
          return this.weight.getAllPower()
            + this.upliftPressure.getAllPower() + this.verticalWaterPressure.getAllPower();
        },

        /**
         * 计算开启闸门时水平力
         * @returns {*}
         */
        computeOpenHorizontalPower: function () {
          return this.openGate.getAllPower();
        },

        /**
         * 计算关闭闸门时力矩
         * @returns {*}
         */
        computeCloseGateForce: function () {
          return this.weight.getAllForce() + this.openGate.getAllForce()
            + this.upliftPressure.getAllForce() + this.verticalWaterPressure.getAllForce();
        },

        /**
         * 计算关闭闸门时垂直力
         * @returns {*}
         */
        computeCloseVerticalPower: function () {
          return this.computeOpenVerticalPower()
        },

        /**
         * 计算关闭闸门时水平
         * @returns {*}
         */
        computeCloseHorizontalPower: function () {
          return this.closeGate.getAllPower();
        },

        /**
         * 计算开启闸门时抗滑稳定系数K
         * @returns {*}
         */
        computeOpenK: function () {
          let result = 0.5 * this.computeOpenVerticalPower() / this.computeOpenHorizontalPower();//？
          return result.toFixed(2);
        },

        /**
         * 计算开启闸门时最大应力
         * @returns {*}
         */
        computeOpenMaxPressure: function () {
          let result = this.computeOpenVerticalPower() * 10 / 18 / 16.5 + this.computeOpenGateForce() * 6 / 18 / 16.5 / 16.5 * 10;
          return result.toFixed(2);
        },

        /**
         * 计算开启闸门时最小应力
         * @returns {*}
         */
        computeOpenMinPressure: function () {
          let result = this.computeOpenVerticalPower() * 10 / 18 / 16.5 - this.computeOpenGateForce() * 6 / 18 / 16.5 / 16.5 * 10;
          return result.toFixed(2);
        },

        /**
         * 计算关闭闸门时抗滑稳定系数K
         * @returns {*}
         */
        computeCloseK: function () {
          let result = 0.5 * this.computeCloseVerticalPower() / this.computeCloseHorizontalPower();//？
          return result.toFixed(2);
        },

        /**
         * 计算关闭闸门时最大应力
         * @returns {*}
         */
        computeCloseMaxPressure: function () {
          let result = this.computeCloseVerticalPower() * 10 / 18 / 16.5 + this.computeCloseGateForce() * 6 / 18 / 16.5 / 16.5 * 10;
          return result.toFixed(2);
        },

        /**
         * 计算关闭闸门时最小应力
         * @returns {*}
         */
        computeCloseMinPressure: function () {
          let result = this.computeCloseVerticalPower() * 10 / 18 / 16.5 - this.computeCloseGateForce() * 6 / 18 / 16.5 / 16.5 * 10;
          return result.toFixed(2);
        },
      };
    },

    /**
     * 溢洪闸分析-翼墙分析
     */
    getWallAnalysis: function () {
      let that = this;
      //恒载
      let deadLoad = {
        竖向力: {
          力: function () {
            return 282.409 * 4.301;
          }, 力矩: function () {
            return 0;
          }, 倾覆力矩: function () {
            return 0;
          }, 抗倾覆力矩: function () {
            return 0;
          }
        }, 水平力: {
          力: function () {
            return 225.693;
          }, 力矩: function () {
            return -(287.6 - 277.3) * 4.301 * 4.301 / 6 / 2;
          }, 倾覆力矩: function () {
            return 988;
          }, 抗倾覆力矩: function () {
            return 3616;
          }
        }
      };

      //活载
      let liveLoad = {
        浮力: {
          力: function () {
            if (operator.getWaterLevel(true) < 297.5) {
              return 0;
            } else {
              return -10 * 5 * (operator.getWaterLevel(true) - 297.5);
            }
          }, 力矩: function () {
            return 0;
          }, 倾覆力矩: function () {
            return -1 * this.力() * 2.5;
          }, 抗倾覆力矩: function () {
            return 0;
          }
        }, 水平土压力: {
          力: function () {
            if (operator.getWaterLevel(true) < 297.5) {
              return 0;
            } else {
              return -10 * 0.27 * (operator.getWaterLevel(true) - 297.5) * (operator.getWaterLevel(true) - 297.5) / 2;
            }
          }, 力矩: function () {
            return this.力() * (-1) * (operator.getWaterLevel(true) - 297.5) / 3;
          }, 倾覆力矩: function () {
            return this.力矩();
          }, 抗倾覆力矩: function () {
            return 0;
          }
        }
      };

      return {
        liveLoad: liveLoad,
        deadLoad: deadLoad,
        data: {
          xMin: 0,
          xMax: 100,
          yMin: 297.5,
          yMax: 315,
          backgroundOffset: '56.8% -18px',
          backgroundSize: '60% 100%'
        },
        getPoints: function () {
          return [
            [0, 297.5], [47.5, 297.5], [47.5, operator.getWaterLevel(true)], [0, operator.getWaterLevel(true)]
          ]
        },

        /**
         * 计算抗滑稳定系数K
         * @returns {*}
         */
        computeK: function () {
          let result = (this.deadLoad.竖向力.力() + this.liveLoad.浮力.力()) * 0.55 /
            (this.deadLoad.水平力.力() + this.liveLoad.水平土压力.力());
          return result.toFixed(2);
        },

        /**
         * 计算最大应力
         * @returns {*}
         */
        computeMaxPressure: function () {
          let result = (this.deadLoad.竖向力.力() + this.liveLoad.浮力.力()) / 4.301 +
            6 * (this.liveLoad.水平土压力.力矩()) / 4.301 / 4.301;
          return result.toFixed(2);
        },

        /**
         * 计算最小应力
         * @returns {*}
         */
        computeMinPressure: function () {
          let result = (this.deadLoad.竖向力.力() + this.liveLoad.浮力.力()) / 4.301
            - 6 * (this.liveLoad.水平土压力.力矩() + this.liveLoad.浮力.力矩()
              + this.deadLoad.水平力.力矩() + this.deadLoad.竖向力.力矩()) / 4.301 / 4.301;
          return result.toFixed(2);
        },

        /**
         * 计算抗倾覆安全系数R
         * @returns {*}
         */
        computeR: function () {
          let result = (this.deadLoad.竖向力.抗倾覆力矩() + this.liveLoad.浮力.抗倾覆力矩() +
            this.deadLoad.水平力.抗倾覆力矩() + this.liveLoad.水平土压力.抗倾覆力矩()) /
            (this.deadLoad.竖向力.倾覆力矩() + this.liveLoad.浮力.倾覆力矩() +
              this.deadLoad.水平力.倾覆力矩() + this.liveLoad.水平土压力.倾覆力矩());
          return result.toFixed(2);
        }
      };
    }
  }
}

/**
 * 放水洞数据
 */
export function getTunnel() {
  return {
    /**
     * 放水洞安全-实时渗流
     */
    getSeepageSafe: function () {
    },

    /**
     * 放水洞安全-振动监测
     */
    getVibrationSafe: function () {
    },

    /**
     * 放水洞分析-控制闸稳定分析
     */
    getControlAnalysis: function () {
      let that = this;
      let soilWeight = 22;   //土容重
      let floatWeight = 12; //浮容重
      let internalAngle = 35; //内摩擦角
      let ka = 0.270668209;  //系数

      //竖向水压力
      let weight = {
        边墙: {
          重: function () {
            return 16 * 0.5 * 25 * (308 - 279);
          }, 力矩: function () {
            return 0;
          }
        }, 底板: {
          重: function () {
            return 5 * 5 * 0.6 * 25;
          }, 力矩: function () {
            return 0;
          }
        }, 管理房: {
          重: function () {
            return (4 * 4 * 0.5 * 2 + 16 * 3 * 0.3) * 25;
          }, 力矩: function () {
            return 0;
          }
        }, 密封块压重: {
          重: function () {
            return 10 * 2 * 1 * 25;
          }, 力矩: function () {
            return this.重() * 3;
          }
        },
        getAllWeight: function () {
          return weight.边墙.重() + weight.底板.重() + weight.管理房.重() + weight.密封块压重.重();
        },
        getAllForce: function () {
          return (-1) * (weight.边墙.力矩() + weight.底板.力矩() + weight.管理房.力矩() + weight.密封块压重.力矩());
        }
      };

      //竖向压力
      let verticalPressure = {
        竖向水压力: {
          重: function () {
            return 10 * (operator.getWaterLevel(true) - 279) * 0.5 * 4.5 * 4;
          }, 力矩: function () {
            return 0;
          }
        }, 浮托力: {
          重: function () {
            return -10 * (operator.getWaterLevel(true) - 278.4) * 4 * 4;
          }, 力矩: function () {
            return 0;
          }
        }, 竖向土压力1: {
          重: function () {
            return operator.getWaterLevel(true) > 298.6 ? floatWeight * (298.6 - 279) * 4.5 * 4.5 * 0.5 :
              (floatWeight * (operator.getWaterLevel(true) - 279) * 4.5 * 4.5 * 0.5) +
              soilWeight * (298.6 - operator.getWaterLevel(true)) * 4.5 * 4.5 * 0.5;
          }, 力矩: function () {
            return 0;
          }
        }, 竖向土压力2: {
          重: function () {
            return 1.62 * 4.5 * 0.5 * floatWeight + 1.62 / 2 * 3 * 2 * 0.5 * floatWeight;
          }, 力矩: function () {
            return -this.重() * 2;
          }
        },
        getAllWeight: function () {
          return verticalPressure.竖向水压力.重() + verticalPressure.浮托力.重() +
            verticalPressure.竖向土压力1.重() + verticalPressure.竖向土压力2.重();
        },
        getAllForce: function () {
          return verticalPressure.竖向水压力.力矩() + verticalPressure.浮托力.力矩() +
            verticalPressure.竖向土压力1.力矩() + verticalPressure.竖向土压力2.力矩();
        }
      };

      //水平压力
      let horizontalPressure = {
        水平土压力: {
          重: function () {
            let pMax, pMin;
            if (operator.getWaterLevel(true) > 300.22) {
              pMax = floatWeight * 1.62 * 1.62 / 2 * ka;
              pMin = floatWeight * 1.62 * 20.2 * ka;
            } else if (operator.getWaterLevel(true) < 298.6) {
              pMax = soilWeight * 1.62 * 1.62 / 2 * ka;
              pMin = soilWeight * 1.62 * 20.2 * ka;
            } else {
              pMax = (floatWeight * Math.pow((300.22 - operator.getWaterLevel(true)), 2) / 2 +
                floatWeight * (300.22 - operator.getWaterLevel(true)) * (operator.getWaterLevel(true) - 298.6) +
                soilWeight * Math.pow((operator.getWaterLevel(true) - 298.6), 2) / 2) * ka;
              pMin = ((floatWeight * (300.22 - operator.getWaterLevel(true)) + soilWeight * (operator.getWaterLevel(true) - 298.6)) * 20.2) * ka;
            }
            return pMax + pMin;
          }, 力矩: function () {
            return this.重() * (20.2 + 1.62 / 2) / 2;
          }
        },
        getAllWeight: function () {
          return horizontalPressure.水平土压力.重();
        },
        getAllForce: function () {
          return horizontalPressure.水平土压力.力矩();
        }
      };

      return {
        weight: weight,
        horizontalPressure: horizontalPressure,
        verticalPressure: verticalPressure,
        data: {
          xMin: 0,
          xMax: 100,
          yMin: 279,
          yMax: 325,
          backgroundOffset: '70% 80px',
          backgroundSize: '80% 74%'
        },
        getPoints: function () {
          return [
            [0, 279], [21.5, 279],
            [18.8, 286.4], [21.4, 287.5], [23.9, 287.5], [51.2, 302.2],
            [52, 302.2], [52, operator.getWaterLevel(true)], [0, operator.getWaterLevel(true)]
          ]
        },

        /**
         * 计算抗滑稳定系数K
         * @returns {*}
         */
        computeK: function () {
          let result = (this.verticalPressure.getAllWeight() +
            this.weight.getAllWeight()) * 0.55 / this.horizontalPressure.getAllWeight();
          return result.toFixed(2);
        },

        /**
         * 计算最大应力
         * @returns {*}
         */
        computeMaxPressure: function () {
          let result = (this.verticalPressure.getAllWeight() + this.weight.getAllWeight()) / 25 + 6 * (this.weight.getAllForce() +
            this.horizontalPressure.getAllForce() + this.verticalPressure.getAllForce()) / 5 / 5 / 5;

          return result.toFixed(2);
        },

        /**
         * 计算最小应力
         * @returns {*}
         */
        computeMinPressure: function () {
          let result = (this.verticalPressure.getAllWeight() + this.weight.getAllWeight()) / 25
            - 6 * (this.weight.getAllForce() +
              this.horizontalPressure.getAllForce() + this.verticalPressure.getAllForce()) / 5 / 5 / 5;
          return result.toFixed(2);
        },
      };
    }
  }
}

/**
 * 此函数返回水库每个单元的数据
 */
export function getUnits() {
  if (this.units) {
    return this.units;
  } else {
    return [
      {
        name: 'qujian',
        title: '区间',
        area: 13.0,
        slope: 0.008,
        longitude: 117.423068,            //经度
        latitude: 36.491903,              //纬度
        dischargeRelations: [
          operator.createDischarge(269.3, 0, 0, 0, 0, 0),
          operator.createDischarge(278, 19.25, 0, 0, 0, 0),
          operator.createDischarge(279, 30, 0, 0, 0, 0),
          operator.createDischarge(280, 39.75, 0, 0, 0, 0),
          operator.createDischarge(282, 68.75, 0, 0, 0, 0),
          operator.createDischarge(284, 104.13, 0, 0, 0, 0),
          operator.createDischarge(286, 145.38, 0, 0, 0, 0),
          operator.createDischarge(288, 190.26, 0, 0, 0, 0),
          operator.createDischarge(290, 264.76, 0, 0, 0, 0),
          operator.createDischarge(291.4, 320, 0, 0, 0, 0),
          operator.createDischarge(292, 348.76, 0, 0, 0, 0),
          operator.createDischarge(294, 424, 0, 0, 0, 0),
          operator.createDischarge(296, 548.87, 0, 0, 0, 0),
          operator.createDischarge(298, 671, 0, 0, 0, 0),
          operator.createDischarge(298.3, 690, 0, 0, 0, 0),
          operator.createDischarge(299, 731, 31, 0, 0, 31),
          operator.createDischarge(300, 798.38, 100, 0, 0, 100),
          operator.createDischarge(301, 866, 202, 0, 0, 202),
          operator.createDischarge(302, 936.63, 320, 0, 0, 320),
          operator.createDischarge(303, 1010, 455, 0, 0, 455),
          operator.createDischarge(304, 1074, 661, 0, 0, 661),
          operator.createDischarge(304.3, 1094, 698, 3, 0, 695),
          operator.createDischarge(305, 1177, 795, 15, 0, 780),
          operator.createDischarge(305.1, 1189, 815, 16.4, 0, 798.6),
          operator.createDischarge(306, 1260, 996, 40, 0, 956),
          operator.createDischarge(306.3, 1286, 1080, 62, 0, 1018),
          operator.createDischarge(306.9, 1337, 1210, 100, 0, 1110),
          operator.createDischarge(307, 1376, 2263, 107, 981, 1175),
        ],
        waterLevelSensor: {id: 'DZSK0001402', url: common.POINT_URL, command: common.POINT_LAST_COMMOND, value: 303},
        dailyRains: operator.createDailyRains(base.getBaseInfo().daysBefore, base.getBaseInfo().daysAfter),
        hourlyRains: operator.createHourlyRains(base.getBaseInfo().daysAfter + 1),
      },
      {
        name: 'baizhangya',     //水库单元名称
        title: '百丈崖',
        area: 24.5,             //面积 单位平方千米
        slope: 0.015,           //流域坡度
        longitude: 117.387266,            //经度
        latitude: 36.502902,              //纬度
        dischargeRelations: [
          operator.createDischarge(343, 0, 0),
          operator.createDischarge(345, 0, 0),
          operator.createDischarge(349, 20, 0),
          operator.createDischarge(352, 42, 0),
          operator.createDischarge(355, 72, 0),
          operator.createDischarge(357, 95, 0),
          operator.createDischarge(359, 121, 0),
          operator.createDischarge(361, 151, 0),
          operator.createDischarge(363, 183, 0),
          operator.createDischarge(365, 217, 0),
          operator.createDischarge(367, 255, 0),
          operator.createDischarge(369, 295, 0),
          operator.createDischarge(371, 338, 0),
          operator.createDischarge(371.4, 345, 0),
          operator.createDischarge(372, 362, 15.3),
          operator.createDischarge(372.5, 376, 41.1),
          operator.createDischarge(373, 390, 76.7),
          operator.createDischarge(373.5, 405, 118.2),
          operator.createDischarge(374, 423, 166.5),
          operator.createDischarge(374.5, 438, 221.3),
          operator.createDischarge(375, 455, 280.4),
          operator.createDischarge(375.5, 469, 344.2),
          operator.createDischarge(376, 485, 412.5),
          operator.createDischarge(376.3, 497, 469.0),
          operator.createDischarge(376.5, 502, 551.3)
        ],
        waterLevelSensor: {
          name: 'baizhangya',
          id: 'DZSK000100060000010200',
          url: common.SENSOR_URL_NEW,
          command: common.SENSOR_LAST_COMMOND,
          value: 369
        },
        dailyRains: operator.createDailyRains(base.getBaseInfo().daysBefore, base.getBaseInfo().daysAfter),
        hourlyRains: operator.createHourlyRains(base.getBaseInfo().daysAfter + 1),
      },
      {
        name: 'yuejin',
        title: '跃进',
        area: 18.5,
        slope: 0.015,
        longitude: 117.40318,            //经度
        latitude: 36.489842,              //纬度
        dischargeRelations: [
          operator.createDischarge(293, 0, 0),
          operator.createDischarge(297.5, 5, 0),
          operator.createDischarge(300, 9, 0),
          operator.createDischarge(305, 21, 0),
          operator.createDischarge(310, 35, 0),
          operator.createDischarge(315, 52, 0),
          operator.createDischarge(320, 70, 0),
          operator.createDischarge(321.7, 74, 0),
          operator.createDischarge(322, 78.08, 3.6),
          operator.createDischarge(323, 91.68, 32.2),
          operator.createDischarge(324, 105.28, 75.7),
          operator.createDischarge(325, 118.88, 130.1),
          operator.createDischarge(326, 134.48, 193.6),
          operator.createDischarge(326.5, 143.28, 228.3),
          operator.createDischarge(327.5, 156.88, 343.5),
        ],
        waterLevelSensor: {
          id: 'DZSK00010005002',
          url: common.SENSOR_URL,
          command: common.SENSOR_LAST_COMMOND,
          value: 303
        },
        dailyRains: operator.createDailyRains(base.getBaseInfo().daysBefore, base.getBaseInfo().daysAfter),
        hourlyRains: operator.createHourlyRains(base.getBaseInfo().daysAfter + 1),
      },

    ]
  }
}

/**
 * 此函数返回水库各种关系表数据
 */
export function getRelations() {
  return {
    /**
     * 降雨径流关系线号
     */
    AREA_LINES: [
      operator.createAreaLine("胶东半岛区", "1", "2", "4", "6", "13"),
      operator.createAreaLine("胶莱河谷南部山丘", "2", "6", "8", "10", "14"),
      operator.createAreaLine("胶莱河谷北部山丘", "3", "7", "9", "11", "14"),
      operator.createAreaLine("泰沂山北区一般地区", "4", "6", "8", "10", "14"),
      operator.createAreaLine("泰沂山北区张店以西", "5", "8", "10", "12", "14"),
      operator.createAreaLine("泰沂山南区一般地区", "6", "1", "3", "5", "10"),
      operator.createAreaLine("泰沂山南区郯苍地区", "7", "4", "5", "6", "10"),
      operator.createAreaLine("大汶河津浦铁路以东", "8", "4", "6", "8", "13"),
      operator.createAreaLine("大汶河津浦铁路以西", "9", "6", "8", "10", "13"),
      operator.createAreaLine("南四湖东区", "10", "4", "0", "8", "12"),
      operator.createAreaLine("南四湖西区万福河以南", "11", "　", "　", "　", "12"),
      operator.createAreaLine("南四湖西区万福河以北", "12", "　", "　", "　", "14"),
      operator.createAreaLine("鲁北平原区徒骇河", "13", "　", "　", "　", "15"),
      operator.createAreaLine("鲁北平原区马颊河", "14", "　", "　", "　", "16")
    ],

    /**
     *瞬时单位线参数
     */
    UNIT_LINE_KS: [
      operator.createUnitLineK("0", "0.196", "0.196", "0.196"),
      operator.createUnitLineK("20", "0.208", "0.245", "0.06"),
      operator.createUnitLineK("30", "0.221", "0.25", "0.12"),
      operator.createUnitLineK("40", "0.233", "0.255", "0.2"),
      operator.createUnitLineK("50", "0.246", "0.26", "0.3"),
      operator.createUnitLineK("60", "0.258", "0.265", "0.41"),
      operator.createUnitLineK("70", "0.27", "0.27", "0.53"),
      operator.createUnitLineK("80", "", "", "0.68"),
      operator.createUnitLineK("90", "", "", "0.83"),
      operator.createUnitLineK("100", "", "", "1")
    ],

    /**
     *径流关系
     */
    RAIN_FLOW_RELATIONS: [
      operator.createRainFlowRelation(50, 6, 4, 4, 4, 4, 4, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0),
      operator.createRainFlowRelation(60, 12, 10, 9, 8, 8, 7, 7, 6, 3, 3, 2, 1, 1, 1, 1, 0),
      operator.createRainFlowRelation(70, 19, 16, 14, 13, 13, 12, 12, 10, 7, 6, 5, 4, 3, 2, 1, 1),
      operator.createRainFlowRelation(80, 25, 22, 20, 18, 18, 17, 17, 15, 12, 10, 9, 7, 6, 4, 3, 2),
      operator.createRainFlowRelation(90, 33, 30, 26, 24, 24, 22, 22, 20, 17, 15, 13, 11, 9, 7, 6, 5),
      operator.createRainFlowRelation(100, 41, 38, 34, 33, 30, 28, 28, 25, 22, 20, 18, 15, 13, 11, 9, 7),
      operator.createRainFlowRelation(110, 50, 46, 41, 40, 37, 35, 35, 31, 28, 25, 23, 19, 17, 14, 12, 10),
      operator.createRainFlowRelation(120, 59, 55, 49, 48, 44, 43, 42, 38, 34, 30, 28, 24, 21, 18, 15, 13),
      operator.createRainFlowRelation(130, 68, 64, 58, 57, 52, 51, 49, 44, 41, 36, 34, 29, 26, 23, 19, 17),
      operator.createRainFlowRelation(140, 78, 73, 67, 65, 61, 59, 57, 51, 47, 43, 40, 34, 31, 28, 24, 21),
      operator.createRainFlowRelation(150, 87, 82, 76, 74, 70, 67, 65, 59, 54, 50, 47, 41, 37, 33, 29, 24),
      operator.createRainFlowRelation(160, 97, 91, 85, 83, 79, 75, 73, 66, 61, 57, 54, 47, 44, 39, 34, 28),
      operator.createRainFlowRelation(170, 106, 101, 95, 92, 88, 84, 81, 74, 68, 64, 61, 54, 51, 46, 39, 33),
      operator.createRainFlowRelation(180, 116, 110, 104, 101, 97, 92, 89, 82, 76, 72, 69, 62, 58, 53, 45, 38),
      operator.createRainFlowRelation(190, 126, 120, 113, 111, 106, 101, 98, 91, 84, 79, 76, 69, 65, 60, 51, 44),
      operator.createRainFlowRelation(200, 135, 129, 123, 120, 115, 110, 106, 100, 92, 87, 83, 76, 73, 68, 56, 49),
      operator.createRainFlowRelation(210, 145, 139, 133, 130, 125, 119, 115, 108, 101, 95, 91, 85, 80, 76, 62, 55),
      operator.createRainFlowRelation(220, 154, 148, 143, 139, 134, 128, 124, 117, 109, 103, 99, 93, 88, 84, 68, 61),
      operator.createRainFlowRelation(230, 164, 158, 152, 148, 143, 137, 133, 125, 117, 111, 107, 101, 96, 92, 75, 67),
      operator.createRainFlowRelation(240, 173, 167, 162, 157, 153, 146, 141, 134, 126, 120, 115, 110, 104, 100, 82, 74),
      operator.createRainFlowRelation(250, 183, 177, 170, 167, 162, 155, 150, 142, 134, 128, 124, 118, 113, 108, 89, 81),
      operator.createRainFlowRelation(260, 193, 187, 180, 177, 172, 164, 159, 151, 143, 137, 133, 127, 121, 117, 96, 88),
      operator.createRainFlowRelation(270, 203, 197, 189, 186, 181, 173, 168, 159, 151, 145, 142, 135, 129, 125, 103, 95),
      operator.createRainFlowRelation(280, 212, 206, 199, 196, 191, 182, 177, 168, 159, 154, 150, 144, 138, 133, 111, 102),
      operator.createRainFlowRelation(290, 222, 216, 208, 205, 200, 191, 186, 176, 168, 162, 158, 152, 146, 142, 118, 109),
      operator.createRainFlowRelation(300, 232, 226, 218, 214, 209, 200, 195, 185, 176, 171, 167, 161, 155, 150, 126, 117),
      operator.createRainFlowRelation(310, 242, 236, 228, 224, 219, 209, 204, 194, 185, 179, 175, 170, 163, 158, 133, 124),
      operator.createRainFlowRelation(320, 252, 246, 238, 233, 228, 218, 212, 202, 193, 188, 184, 178, 171, 166, 141, 131),
      operator.createRainFlowRelation(330, 261, 255, 247, 243, 238, 227, 221, 211, 202, 196, 192, 187, 180, 175, 148, 138),
      operator.createRainFlowRelation(340, 271, 265, 257, 252, 247, 236, 230, 219, 210, 205, 201, 195, 188, 183, 156, 146),
      operator.createRainFlowRelation(350, 281, 275, 267, 262, 257, 245, 239, 228, 218, 213, 209, 204, 196, 191, 163, 152),
      operator.createRainFlowRelation(360, 291, 285, 277, 271, 266, 254, 247, 237, 227, 222, 217, 212, 204, 199, 171, 160),
      operator.createRainFlowRelation(370, 301, 295, 287, 281, 275, 263, 256, 245, 235, 230, 226, 220, 213, 207, 178, 167),
      operator.createRainFlowRelation(380, 310, 304, 296, 290, 285, 272, 265, 254, 243, 238, 234, 229, 221, 215, 186, 174),
      operator.createRainFlowRelation(390, 320, 314, 306, 299, 294, 281, 274, 262, 251, 247, 242, 237, 229, 224, 193, 181),
      operator.createRainFlowRelation(400, 330, 324, 316, 308, 303, 290, 283, 271, 260, 255, 251, 245, 237, 232, 201, 188),
      operator.createRainFlowRelation(410, 340, 334, 326, 317, 312, 299, 292, 280, 269, 263, 259, 253, 245, 240, 209, 195),
      operator.createRainFlowRelation(420, 350, 344, 336, 326, 321, 308, 301, 289, 278, 271, 267, 261, 253, 248, 217, 202),
      operator.createRainFlowRelation(430, 360, 354, 346, 335, 330, 317, 310, 298, 287, 279, 275, 269, 261, 256, 225, 209),
      operator.createRainFlowRelation(440, 370, 364, 356, 344, 339, 326, 319, 307, 296, 287, 283, 277, 269, 264, 233, 216),
      operator.createRainFlowRelation(450, 380, 374, 366, 353, 348, 335, 328, 316, 305, 295, 291, 285, 277, 272, 241, 223),
      operator.createRainFlowRelation(460, 390, 384, 376, 362, 357, 344, 337, 325, 314, 303, 299, 293, 285, 280, 249, 230),
      operator.createRainFlowRelation(470, 400, 394, 386, 371, 366, 353, 346, 334, 323, 311, 307, 301, 293, 288, 257, 237),
      operator.createRainFlowRelation(480, 410, 404, 396, 380, 375, 362, 355, 343, 332, 319, 315, 309, 301, 296, 265, 244),
      operator.createRainFlowRelation(490, 420, 414, 406, 389, 384, 371, 364, 352, 341, 327, 323, 317, 309, 304, 273, 251),
      operator.createRainFlowRelation(500, 430, 424, 416, 398, 393, 380, 373, 361, 350, 335, 331, 325, 317, 312, 281, 258),
      operator.createRainFlowRelation(510, 440, 434, 426, 407, 402, 389, 382, 370, 359, 343, 339, 333, 325, 320, 289, 265),
      operator.createRainFlowRelation(520, 450, 444, 436, 416, 411, 398, 391, 379, 368, 351, 347, 341, 333, 328, 297, 272),
    ],

    /**
     * 上游坡安全系数
     */
    WATER_LEVEL_PARAS: [
      {waterLevel: 307.22, k: 1.3},
      {waterLevel: 307, k: 1.301},
      {waterLevel: 304, k: 1.308},
      {waterLevel: 300, k: 1.342},
      {waterLevel: 298.6, k: 1.343},
    ],

    /**
     * 库容关系表
     */
    CAPACITY_RELATIONSHIP: [
      {waterLevel: 134.50, area: 0.0000, capacity: 0.0000},
      {waterLevel: 135.00, area: 0.0002, capacity: 0.0007},
      {waterLevel: 135.50, area: 0.0066, capacity: 0.1233},
      {waterLevel: 136.00, area: 0.0182, capacity: 0.7379},
      {waterLevel: 136.50, area: 0.0766, capacity: 2.3573},
      {waterLevel: 137.00, area: 0.1660, capacity: 9.1216},
      {waterLevel: 137.50, area: 0.1858, capacity: 17.9331},
      {waterLevel: 138.00, area: 0.2095, capacity: 27.7696},
      {waterLevel: 138.50, area: 0.2428, capacity: 38.9856},
      {waterLevel: 139.00, area: 0.2717, capacity: 51.7782},
      {waterLevel: 139.50, area: 0.3263, capacity: 66.6118},
      {waterLevel: 140.00, area: 0.3695, capacity: 83.9151},
      {waterLevel: 140.50, area: 0.4095, capacity: 103.3027},
      {waterLevel: 141.00, area: 0.4543, capacity: 124.8050},
      {waterLevel: 141.50, area: 0.4994, capacity: 148.7205},
      {waterLevel: 142.00, area: 0.5318, capacity: 174.5585},
      {waterLevel: 142.50, area: 0.5640, capacity: 201.8591},
      {waterLevel: 143.00, area: 0.6008, capacity: 230.9016},
      {waterLevel: 143.50, area: 0.6344, capacity: 261.7244},
      {waterLevel: 144.00, area: 0.6674, capacity: 294.2369},
      {waterLevel: 144.50, area: 0.7035, capacity: 328.5141},
      {waterLevel: 145.00, area: 0.7400, capacity: 364.5630},
      {waterLevel: 145.50, area: 0.7802, capacity: 402.4413},
      {waterLevel: 146.00, area: 0.8254, capacity: 442.5041},
      {waterLevel: 146.50, area: 0.8718, capacity: 484.8642},
      {waterLevel: 147.00, area: 0.9149, capacity: 529.4436},
      {waterLevel: 147.50, area: 0.9558, capacity: 576.1436},
      {waterLevel: 148.00, area: 0.9910, capacity: 624.8057},
      {waterLevel: 148.50, area: 1.0251, capacity: 675.2024},
      {waterLevel: 149.00, area: 1.0588, capacity: 727.2458},
      {waterLevel: 149.50, area: 1.0950, capacity: 781.0751},
      {waterLevel: 150.00, area: 1.1298, capacity: 836.6929},
      {waterLevel: 150.50, area: 1.1640, capacity: 894.0119},
      {waterLevel: 151.00, area: 1.1986, capacity: 953.0237},
      {waterLevel: 151.50, area: 1.2386, capacity: 1013.8933},
      {waterLevel: 152.00, area: 1.2742, capacity: 1076.7383},
      {waterLevel: 152.50, area: 1.3093, capacity: 1141.2961},
      {waterLevel: 153.00, area: 1.3517, capacity: 1207.7313},
      {waterLevel: 153.50, area: 1.4086, capacity: 1276.6052},
      {waterLevel: 154.00, area: 1.4629, capacity: 1348.3577},
      {waterLevel: 154.50, area: 1.5208, capacity: 1422.9396},
      {waterLevel: 155.00, area: 1.5686, capacity: 1500.0955},
      {waterLevel: 155.50, area: 1.6222, capacity: 1579.8156},
      {waterLevel: 156.00, area: 1.6717, capacity: 1662.1581},
      {waterLevel: 156.50, area: 1.7233, capacity: 1746.9973},
      {waterLevel: 157.00, area: 1.7806, capacity: 1834.5373},
      {waterLevel: 157.50, area: 1.8414, capacity: 1925.1025},
      {waterLevel: 158.00, area: 1.8996, capacity: 2018.5495},
      {waterLevel: 158.50, area: 1.9596, capacity: 2114.9273},
      {waterLevel: 159.00, area: 2.0211, capacity: 2214.2893},
      {waterLevel: 159.50, area: 2.0806, capacity: 2316.7389},
      {waterLevel: 160.00, area: 2.1350, capacity: 2422.1601},
      {waterLevel: 160.50, area: 2.1911, capacity: 2530.2741},
      {waterLevel: 161.00, area: 2.2387, capacity: 2641.0221},
      {waterLevel: 161.50, area: 2.3039, capacity: 2754.3101},
      {waterLevel: 162.00, area: 2.3740, capacity: 2870.9268},
      {waterLevel: 162.50, area: 2.4772, capacity: 2991.7376},
      {waterLevel: 163.00, area: 2.5504, capacity: 3117.5546},
      {waterLevel: 163.50, area: 2.5961, capacity: 3246.4158},
      {waterLevel: 164.00, area: 2.6434, capacity: 3377.1663},
      {waterLevel: 164.50, area: 2.7111, capacity: 3511.1509},
      {waterLevel: 165.00, area: 2.7863, capacity: 3648.3629},
      {waterLevel: 165.50, area: 2.8491, capacity: 3789.2716},
      {waterLevel: 166.00, area: 2.9231, capacity: 3933.3545},
      {waterLevel: 166.50, area: 2.9633, capacity: 4080.5947},
      {waterLevel: 167.00, area: 3.0119, capacity: 4229.7915},
      {waterLevel: 167.50, area: 3.0708, capacity: 4381.9527},
      {waterLevel: 168.00, area: 3.1385, capacity: 4536.9947},
      {waterLevel: 168.50, area: 3.1888, capacity: 4695.1724},
      {waterLevel: 169.00, area: 3.2585, capacity: 4856.1143},
      {waterLevel: 169.50, area: 3.3225, capacity: 5020.7240},
      {waterLevel: 170.00, area: 3.3960, capacity: 5188.4375},
      {waterLevel: 170.50, area: 3.4686, capacity: 5360.2106},
      {waterLevel: 171.00, area: 3.5487, capacity: 5535.3737},
      {waterLevel: 171.50, area: 3.6223, capacity: 5714.8028},
      {waterLevel: 172.00, area: 3.7016, capacity: 5897.6850},
      {waterLevel: 172.50, area: 3.7948, capacity: 6085.1627},
      {waterLevel: 173.00, area: 3.8837, capacity: 6276.9022},
    ],

    /**
     * 获取某雨量和线之间的对应值
     * @param rain
     * @param line
     * @returns {number}
     */
    getLineValue: function (rain, line) {
      if (rain < 50) {
        return 0;
      }
      for (let i = 0; i < this.RAIN_FLOW_RELATIONS.length; i++) {
        if (Math.abs(this.RAIN_FLOW_RELATIONS[i].rain - calculator.computeApproximate(rain)) < 0.01) {
          return this.RAIN_FLOW_RELATIONS[i][line];
        }
      }
    },

    /**
     * 获取库容关系插值
     * @returns {number} 面积或者库容
     * @param itemName 名称
     * @param waterLevel 水位
     */
    getCapacityRelationShip: function (itemName, waterLevel) {
      let index = 0;
      let item = this.CAPACITY_RELATIONSHIP;
      if (waterLevel <= item[0].waterLevel) return item[0][itemName];
      if (waterLevel >= item[item.length - 1].waterLevel) return item[item.length - 1][itemName];
      for (let i = 0; i < item.length - 1; i++) {
        if (waterLevel >= item[i].waterLevel &&
          waterLevel <= item[i + 1].waterLevel) {
          index = i;
          break;
        }
      }
      return (waterLevel - item[index].waterLevel) / 0.5 * (item[index + 1][itemName] - item[index][itemName]) + item[index][itemName];
    },

    getArea: function (itemName, waterLevel) {
      return this.getCapacityRelationShip(itemName, waterLevel);
    }

  }
}


/**
 *  用于控制流域与雨量分布页面数据
 */
export function getBasinControlInfo() {
  //标注点数组
  return {
    markers: [
      operator.createMarker("雨量计1#", '2', "水文气象监测站", "#",
        "117.40539|36.484773", 0, {w: 21, h: 21, l: 23, t: 0, x: 1, lb: 1}),
      operator.createMarker("雨量计2#", '2', "水文气象监测站",
        "#", "117.349483|36.489431", 0, {w: 21, h: 21, l: 23, t: 0, x: 1, lb: 1}),
      operator.createMarker("雨量计3#", '2', "水文气象监测站",
        "#", "117.372063|36.512011", 0, {w: 21, h: 21, l: 23, t: 0, x: 1, lb: 1}),
      operator.createMarker("雨量计4#", '2', "水文气象监测站",
        "#", "117.375562|36.472248", 0, {w: 21, h: 21, l: 23, t: 0, x: 1, lb: 1}),
      operator.createMarker("垛庄水库", '0', "位于济南市章丘区垛庄镇",
        "#", "117.425043|36.491721", 0, {w: 21, h: 21, l: 46, t: 46, x: 1, lb: 10}),
      operator.createMarker("跃进水库", '1', "位于济南市章丘区垛庄镇",
        "http://shuiku.succld.com/xxsk/05310002/project.html", "117.403209|36.489102",
        0, {w: 21, h: 21, l: 46, t: 46, x: 1, lb: 10}),
      operator.createMarker("百丈崖水库", '1', "位于济南市章丘区垛庄镇",
        "http://shuiku.succld.com/xxsk/05310001/project.html", "117.389483|36.499431", 0,
        {w: 21, h: 21, l: 46, t: 46, x: 1, lb: 10})
      , operator.createMarker("流域气象站", '2', "南明庄村水文气象监测站",
        "#", "117.485293|36.531245",
        0, {w: 21, h: 21, l: 23, t: 0, x: 1, lb: 1}),
    ],
    boundaryDots:
      [
        [117.408107, 36.446272], [117.412583, 36.445853], [117.413877, 36.446442], [117.414426, 36.447209],
        [117.414154, 36.448727], [117.413692, 36.450211], [117.412198, 36.451713], [117.409976, 36.45321],
        [117.405961, 36.454827], [117.407342, 36.459366], [117.407363, 36.460581], [117.406863, 36.461788],
        [117.40512, 36.461925], [117.404345, 36.462565], [117.404376, 36.463345], [117.405421, 36.464292],
        [117.40696, 36.465323], [117.417305, 36.473628], [117.426371, 36.476244], [117.431847, 36.479045],
        [117.437135, 36.479764], [117.442832, 36.479818], [117.44325, 36.481886], [117.442453, 36.484133],
        [117.441438, 36.487044], [117.440433, 36.489239], [117.438591, 36.490758], [117.437389, 36.49363],
        [117.435167, 36.493808], [117.433103, 36.493335], [117.429994, 36.491323], [117.424438, 36.491478],
        [117.424532, 36.495478], [117.424188, 36.496933], [117.423695, 36.498404], [117.422679, 36.499913],
        [117.421575, 36.501442], [117.422122, 36.502971], [117.421077, 36.509068], [117.418105, 36.514819],
        [117.414617, 36.514713], [117.40931, 36.512341], [117.407991, 36.512245], [117.40722, 36.51309],
        [117.406168, 36.516226], [117.404834, 36.516279], [117.403463, 36.516963], [117.402091, 36.518682],
        [117.401621, 36.521245], [117.399975, 36.522194], [117.397139, 36.522594], [117.395008, 36.522245],
        [117.393034, 36.523342], [117.391447, 36.525269], [117.389894, 36.525806], [117.387986, 36.525765],
        [117.386036, 36.52862], [117.382496, 36.529452], [117.37632, 36.528824], [117.370137, 36.52637],
        [117.364425, 36.52598], [117.359073, 36.525112], [117.352614, 36.522564], [117.352583, 36.519584],
        [117.349589, 36.515311], [117.345874, 36.511982], [117.344647, 36.505403], [117.341326, 36.504665],
        [117.339063, 36.502237], [117.33703, 36.496475], [117.333631, 36.495684], [117.327908, 36.496528],
        [117.323073, 36.496866], [117.320723, 36.49624], [117.317992, 36.496051], [117.317636, 36.492758],
        [117.317439, 36.490828], [117.3161, 36.486265], [117.314269, 36.484095], [117.31182, 36.482683],
        [117.311441, 36.481089], [117.311036, 36.479812], [117.311064, 36.478366], [117.311807, 36.477065],
        [117.312319, 36.475648], [117.312959, 36.474882], [117.314009, 36.474736], [117.315115, 36.474771],
        [117.317368, 36.475885], [117.318867, 36.47594], [117.320204, 36.475352], [117.321714, 36.475279],
        [117.322687, 36.47625], [117.324132, 36.476786], [117.325892, 36.476624], [117.327816, 36.476067],
        [117.330168, 36.47497], [117.336851, 36.479949], [117.339903, 36.480029], [117.343653, 36.478667],
        [117.346841, 36.476642], [117.34973, 36.472697], [117.351429, 36.469679], [117.352273, 36.469116],
        [117.355244, 36.468815], [117.357106, 36.467956], [117.359234, 36.466052], [117.360214, 36.464845],
        [117.36099, 36.463087], [117.361122, 36.461307], [117.361019, 36.459516], [117.360897, 36.457595],
        [117.361993, 36.453543], [117.362374, 36.45252], [117.363139, 36.45147], [117.365101, 36.449797],
        [117.366993, 36.450255], [117.368961, 36.450029], [117.369468, 36.449142], [117.36914, 36.447749],
        [117.36974, 36.445555], [117.370238, 36.443415], [117.371456, 36.441522], [117.372193, 36.440588],
        [117.373846, 36.440092], [117.376161, 36.441417], [117.377757, 36.441836], [117.378994, 36.442226],
        [117.381977, 36.442068], [117.385077, 36.442197], [117.387028, 36.442441], [117.38973, 36.442383],
        [117.392248, 36.442209], [117.394474, 36.441692], [117.396773, 36.441665], [117.398473, 36.442717],
        [117.399967, 36.444091], [117.400814, 36.445808], [117.402348, 36.44932]
      ],
    areaLines: [
      [
        [117.345523, 36.511012], [117.353859, 36.506371], [117.361333, 36.502774], [117.369238, 36.496855],
        [117.374987, 36.492677], [117.374987, 36.492677]
      ],
      [
        [117.350841, 36.470971], [117.361333, 36.480142], [117.368807, 36.486178], [117.375562, 36.492445]
      ],
      [
        [117.40747, 36.512404], [117.399708, 36.505675], [117.389791, 36.497203], [117.383036, 36.494998],
        [117.376137, 36.492445], [117.375849, 36.492445], [117.375849, 36.492445]
      ],
      [
        [117.406607, 36.456923], [117.390797, 36.478053], [117.381599, 36.486062], [117.375706, 36.492329],
        [117.375706, 36.492329], [117.375706, 36.492329]
      ]
    ]
  }
}

/**
 * 获取摄像头数据
 */
export function getVideo() {
  return [
    {
      name: '黑虎山溢洪闸',
      videoId: 'HHSK000104',
      id: 0,
      points:
        [
          {name: '库面全景', id: 1,},
          {name: '放水洞', id: 2,},
          {name: '东水尺1米', id: 3,},
          {name: '东2米', id: 4,},
          {name: '东3米', id: 5,},
          {name: '东4米', id: 6,},
          {name: '西5米', id: 7,},
          {name: '东6米', id: 8,},
          {name: '西水尺1米', id: 9,},
          {name: '西2米', id: 10,},
          {name: '西3米', id: 11,},
          {name: '[165-167]', id: 12,},
          {name: '[167-169]', id: 13,},
          {name: '[169-171]', id: 14,},
        ]
    },
    {
      name: '钓鱼台水库',
      videoId: 'HHSK000106',
      id: 1,
      points:
        [
          {name: '位置1', id: 1,}
        ]
    },
    {
      name: '逄峪中桥入流点',
      id: 2,
      videoId: 'HHSK000105',
      points:
        [
          {name: '位置1', id: 1,},
          {name: '位置2', id: 2,},
          {name: '位置3', id: 3,},
          {name: '位置4', id: 4,}
        ]
    },
    {
      name: '孙王量雨点',
      id: 3,
      videoId: 'HHSK000101',
      points:
        [
          {name: '库面全景', id: 1,}
        ]
    },
    {
      name: '钓鱼台量雨点',
      id: 4,
      videoId: 'HHSK000102',
      points:
        [
          {name: '位置1', id: 1,}
        ]
    },
    {
      name: '东胡量雨点',
      id: 5,
      videoId: 'HHSK000103',
      points:
        [
          {name: '位置1', id: 1,}
        ]
    },
    {
      name: '逄峪生产桥',
      id: 6,
      videoId: 'HHSK000107',
      points:
        [
          {name: '位置1', id: 1,}
        ]
    }
  ]
}

