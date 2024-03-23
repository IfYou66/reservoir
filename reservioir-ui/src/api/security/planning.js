import request from '@/utils/request'

//发起流程或暂存
export function startWorkFlow(params) {
  return request({
    url: 'reservoir/planEdit/startWorkFlow',
    method: 'post',
    data: params
  })
}

//提交流程
export function submit(params) {
  return request({
    url: 'reservoir/planEdit/submit',
    method: 'post',
    data: params
  })
}

//审核
export function taskReview(params) {
  return request({
    url: 'reservoir/planEdit/taskReview',
    method: 'post',
    data: params
  })
}
//审核
export function taskApprove(params) {
  return request({
    url: 'reservoir/planEdit/taskApprove',
    method: 'post',
    data: params
  })
}
//查询人员
export function getUserList() {
  return request({
    url: 'reservoir/planEdit/getUserList',
    method: 'post',

  })
}
//查询
export function getReviewTask(params) {
  return request({
    url: 'reservoir/planEdit/getReviewTask',
    method: 'post',
    data: params

  })
}

//安全检查列表
export function getPlanList(params) {
  return request({
    url: 'reservoir/planEdit/getPlanList',
    method: 'get',
    params: params
  })
}

//安全检查列表
export function getList() {
  return request({
    url: 'reservoir/planEdit/processComplete',
    method: 'get'
    // params: params
  })
}


// // 刷新方法
// export function refreshToken() {
//   return request({
//     url: '/auth/refresh',
//     method: 'post'
//   })
// }

// // 获取用户详细信息
// export function getInfo() {
//   return request({
//     url: '/system/user/getInfo',
//     method: 'get'
//   })
// }

// // 退出方法
// export function logout() {
//   return request({
//     url: '/auth/logout',
//     method: 'delete'
//   })
// }

// // 获取验证码
// export function getCodeImg() {
//   return request({
//     url: '/code',
//     method: 'get'
//   })
// }
