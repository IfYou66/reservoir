/**
 * 核心数据模块，记录水库重要信息，便于统一修改和数据共享。
 */
export function getBaseInfo() {
  return {
    name: '马河水库',                        //水库名称
    maxHt: 60,                              //最大日降水量
    line: 'l6',                             //属于第几号线
    slope: 0.0116,                          //总流域坡度
    k: 0.196,                               //M1计算系数
    daysBefore: 15,                         //前面多少天
    daysAfter: 3,                           //后面多少天
    forecast: 0.36,                         //预测系数
    downstreamStandard: 218,                //超过下游河道标准

    designWaterLevel: 112.36,                //设计水位
    floodWaterLevel: 107.85,                 //汛限水位
    checkWaterLevel: 114.60,                 //校核洪水位
    designFloodWaterLevel: 112.36,           //设计洪水位
    highWaterLevel: 111.76,                  //防洪高水位
    headWaterLevel: 110.85,                  //兴利水位
    floodDesignWaterLevel: 112.36,           //防洪设计水位
    deadWaterLevel: 100.35,                  //死水位

    benefitCapacity: 7564.00,                //兴利库容
    designCapacity: 14806,                   //设计库容
    storageCapacity: 6401,                   //汛限水位库容
    deadCapacity: 840.5296,                  //死库容

    damHeight: '--',                         //基准高程

    info:                                    //水库介绍
      ' <strong>马河水库</strong>为滕州市第一大水库，仅次于枣庄市岩马水库的第二大水库，在鲁南地区发挥着防洪、灌溉、' +
      '供水、发电、养殖等重要的功能，收到良好的综合效益。库区风景优美，交通方便，是重要的旅游地。 ' +
      ' 马河水库于1959年11月动工兴建，1960年5月建成蓄水。水库控制流域面积240平方千米，水面跨邹城、滕州两市，南北约6千米，' +
      '总库容1.38亿立方米，兴利库容0.7亿立方米。水库工程主要包括主坝、副坝、溢洪道、放水洞、发电站等。主坝为黏土心墙砂壳坝，' +
      '长926米，最大坝高23.30米。马河水库位于鲁中南中低山区西部边缘， 区内河床宽约200米。库区地貌按成因可分为剥蚀地形、堆积' +
      '地形两种。剥蚀地形包括剥蚀残丘、台地，后者在区内广泛分布。堆积地形包括堆积阶地、冲积平原及河漫滩三种形式。',
  };
}

