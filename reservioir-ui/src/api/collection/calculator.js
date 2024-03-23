/**
 * 此文件用于创建各种数据对象，主要供数据文件调用
 */

/**
 * 计算前期雨量Pa
 * 水库流域前期影响雨量是衡量水库流域土壤水分含量的指标，与前期降雨有关，根据《山东省水文图集》，计算公式如下：
 * Pa=∑Ht×Kt ）<=Imax                 (t=1,2,……15)
 * 式中 Pa—期影响雨量，mm；
 * Ht—期t日降水量，mm；
 * K—保水系数；
 * t—前期降水相隔天数；
 * Imax—流域最大吸水量。
 * 流域最大吸水量Imax取60mm。保水系数K取0.85。
 * @param dailyRains 期影响雨量
 * @param dayIndex 前期降水相隔天数
 * @param maxHt 流域最大吸水量
 */
export function calculatePa(dailyRains, dayIndex, maxHt) {
  let pa = 0;
  for (let i = dayIndex; i < 15 + dayIndex; i++) {
    pa += dailyRains[i].rainFall * Math.pow(0.85, dailyRains[i].dayDiff + dayIndex);
  }
  return pa > maxHt ? maxHt : pa;
}

/**
 *由暴雨推算洪水过程，采用《山东省大、中型水库防洪安全复核洪水计算办法》中我省综合的瞬时单位线。瞬时单位线参数：
 * M1＝K*F^0.33*J^-0.27*R^-0.2*Tc^0.17
 * @param k——系数，根据平原区面积比例选用
 * @param area——流域面积，km2；
 * @param slope——干流平均坡度，m/m；
 * @param rfPure——净雨深，mm，取各日净雨深；
 * @param hourPure——净雨历时，小时，取各日净雨时段总历时。
 * @returns number
 */

export function computeM1(k, area, slope, rfPure, hourPure) {
  if (rfPure === 0) {
    return 10;
  }
  if (hourPure === 0) {
    return 10;
  }
  return k * Math.pow(area, 0.33) * Math.pow(slope, -0.27)
    * Math.pow(rfPure, -0.2) * Math.pow(hourPure, 0.17);
}

/**
 * 计算瞬时单位线参数M2：
 * 山区及山区与平原混合区：
 * M2=0.34*M1*e-0.12
 * @param m1
 */
export function computeM2(m1) {
  return 0.34 * Math.pow(m1, -0.12);
}

/**
 * 计算近似值 比如原始值323，得到近似值320
 * @param value 原始值
 * @returns number
 */
export function computeApproximate(value) {
  return Math.round(value / 10) * 10;
}


/**
 * s(t)用GAMMADIST函数求取,excel中GAMMADIST函数的4个参数分别为：
 * t/(m1*m2),1/m2,1,true
 * @param x——系数，根据平原区面积比例选用；
 * @param a——流域面积，km2；
 * @param b——流域面积，km2；
 * @returns 瞬时单位线值
 */
export function outputGamma(x, a, b) {
  let result;
  if (a <= 0) {
    console.log("alpha must be positive");
    return null;
  } else if (b <= 0) {
    console.log("beta must be positive");
    return null;
  } else {
    result = gammaCdf(x / b, a)
  }
  result = Math.round(result * 100000) / 100000;
  return result;
}

/**
 * 计算log值
 * 下面几个函数都是摘至https://www.math.ucla.edu/~tom/distributions/gamma.html
 * @param Z
 * @returns {number}
 */
function logGamma(Z) {
  let S = 1 + 76.18009173 / Z - 86.50532033 / (Z + 1) + 24.01409822 / (Z + 2) - 1.231739516 / (Z + 3) + .00120858003 / (Z + 4) - .00000536382 / (Z + 5);
  return (Z - .5) * Math.log(Z + 4.5) - (Z + 4.5) + Math.log(S * 2.50662827465);
}

function gcf(X, A) {
  let A0 = 0;
  let B0 = 1;
  let A1 = 1;
  let B1 = X;
  let AOLD = 0;
  let N = 0;
  while (Math.abs((A1 - AOLD) / A1) > .00001) {
    AOLD = A1;
    N = N + 1;
    A0 = A1 + (N - A) * A0;
    B0 = B1 + (N - A) * B0;
    A1 = X * A0 + N * A1;
    B1 = X * B0 + N * B1;
    A0 = A0 / B1;
    B0 = B0 / B1;
    A1 = A1 / B1;
    B1 = 1;
  }
  let Prob = Math.exp(A * Math.log(X) - X - logGamma(A)) * A1;
  return 1 - Prob;
}

function gser(X, A) {        // Good for X<A+1.
  let T9 = 1 / A;
  let G = T9;
  let I = 1;
  while (T9 > G * .00001) {
    T9 = T9 * X / (A + I);
    G = G + T9;
    I = I + 1;
  }
  G = G * Math.exp(A * Math.log(X) - X - logGamma(A));
  return G;
}

function normalCdf(X) {   //HASTINGS.  MAX ERROR = .000001
  let T = 1 / (1 + .2316419 * Math.abs(X));
  let D = .3989423 * Math.exp(-X * X / 2);
  let Prob = D * T * (.3193815 + T * (-.3565638 + T * (1.781478 + T * (-1.821256 + T * 1.330274))));
  if (X > 0) {
    Prob = 1 - Prob
  }
  return Prob;
}

function gammaCdf(x, a) {
  let GI;
  if (x <= 0) {
    GI = 0;
  } else if (a > 200) {
    let z = (x - a) / Math.sqrt(a);
    y = normalCdf(z);
    let b1 = 2 / Math.sqrt(a);
    let phiz = .39894228 * Math.exp(-z * z / 2);
    let w = y - b1 * (z * z - 1) * phiz / 6;         //Edgeworth1
    let b2 = 6 / a;
    let u = 3 * b2 * (z * z - 3) + b1 * b1 * (z ^ 4 - 10 * z * z + 15);
    GI = w - phiz * z * u / 72;                     //Edgeworth2
  } else if (x < a + 1) {
    GI = gser(x, a);
  } else {
    GI = gcf(x, a);
  }
  return GI;
}


