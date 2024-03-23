import request from '@/utils/request'

// 查询控制运行计划 列表
export function listControl(query) {
  return request({
    url: '/reservoir/control/list',
    method: 'get',
    params: query
  })
}

// 查询控制运行计划 详细
export function getControl(fId) {
  return request({
    url: '/reservoir/control/' + fId,
    method: 'get'
  })
}

// 新增控制运行计划
export function addControl(data) {
  return request({
    url: '/reservoir/control',
    method: 'post',
    data: data
  })
}

// 修改控制运行计划
export function updateControl(data) {
  return request({
    url: '/reservoir/control',
    method: 'put',
    data: data
  })
}

// 删除控制运行计划
export function delControl(fId) {
  return request({
    url: '/reservoir/control/' + fId,
    method: 'delete'
  })
}

// 查询最近
export function latelyControl() {
  return request({
    url: '/reservoir/control/latelyControl',
    method: 'get',
  })
}

// 流程
export function startWorkFlow(data) {
  return request({
    url: '/reservoir/control/startWorkFlow',
    method: 'post',
    data: data
  })
}

// 流程
export function taskReview(data) {
  return request({
    url: '/reservoir/control/taskReview',
    method: 'post',
    data: data
  })
}

// dict
export function getDictByType() {
  return request({
    url: '/reservoir/control/getDictByType',
    method: 'get',
  })
}
