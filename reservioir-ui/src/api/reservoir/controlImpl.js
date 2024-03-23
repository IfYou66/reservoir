import request from '@/utils/request'

// 查询控制运行计划实施列表
export function listControlImpl(query) {
  return request({
    url: '/reservoir/controlImpl/list',
    method: 'get',
    params: query
  })
}

// 查询控制运行计划实施详细
export function getControlImpl(fId) {
  return request({
    url: '/reservoir/controlImpl/' + fId,
    method: 'get'
  })
}

// 新增控制运行计划实施
export function addControlImpl(data) {
  return request({
    url: '/reservoir/controlImpl',
    method: 'post',
    data: data
  })
}

// 修改控制运行计划实施
export function updateControlImpl(data) {
  return request({
    url: '/reservoir/controlImpl',
    method: 'put',
    data: data
  })
}

// 删除控制运行计划实施
export function delControlImpl(fId) {
  return request({
    url: '/reservoir/controlImpl/' + fId,
    method: 'delete'
  })
}

export function latelyControl() {
  return request({
    url: '/reservoir/controlImpl/latelyControl',
    method: 'get',
  })
}

// 流程
export function startWorkFlowControlImpl(data) {
  return request({
    url: '/reservoir/controlImpl/startWorkFlow',
    method: 'post',
    data: data
  })
}

// 流程
export function taskReviewControlImpl(data) {
  return request({
    url: '/reservoir/controlImpl/taskReview',
    method: 'post',
    data: data
  })
}
