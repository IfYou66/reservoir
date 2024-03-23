import request from '@/utils/request'

// 查询控制运行计划 列表
export function listControl(query) {
  return request({
    url: '/reservoir/scheduling/list',
    method: 'get',
    params: query
  })
}

// 查询控制运行计划 详细
export function getControl(fId) {
  return request({
    url: '/reservoir/scheduling/' + fId,
    method: 'get'
  })
}

// 新增控制运行计划
export function addControl(data) {
  return request({
    url: '/reservoir/scheduling',
    method: 'post',
    data: data
  })
}

// 修改控制运行计划
export function updateControl(data) {
  return request({
    url: '/reservoir/scheduling',
    method: 'put',
    data: data
  })
}

// 删除控制运行计划
export function delControl(fId) {
  return request({
    url: '/reservoir/scheduling/' + fId,
    method: 'delete'
  })
}

// 查询最近
export function latelyControl() {
  return request({
    url: '/reservoir/scheduling/latelyControl',
    method: 'get',
  })
}

// 流程
export function startWorkFlow(data) {
  return request({
    url: '/reservoir/scheduling/startWorkFlow',
    method: 'post',
    data: data
  })
}

// 流程
export function taskReview(data) {
  return request({
    url: '/reservoir/scheduling/taskReview',
    method: 'post',
    data: data
  })
}

// dict
export function getDictByType() {
  return request({
    url: '/reservoir/scheduling/getDictByType',
    method: 'get',
  })
}
