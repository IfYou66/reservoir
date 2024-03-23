import request from '@/utils/request'

// 查询水库大坝安全鉴定一览 列表
export function listAppraisal(query) {
  return request({
    url: '/reservoir/appraisal/list',
    method: 'get',
    params: query
  })
}

// 查询水库大坝安全鉴定一览 详细
export function getAppraisal(fId) {
  return request({
    url: '/reservoir/appraisal/' + fId,
    method: 'get'
  })
}

// 新增水库大坝安全鉴定一览
export function addAppraisal(data) {
  return request({
    url: '/reservoir/appraisal',
    method: 'post',
    data: data
  })
}

// 修改水库大坝安全鉴定一览
export function updateAppraisal(data) {
  return request({
    url: '/reservoir/appraisal',
    method: 'put',
    data: data
  })
}

// 删除水库大坝安全鉴定一览
export function delAppraisal(fId) {
  return request({
    url: '/reservoir/appraisal/' + fId,
    method: 'delete'
  })
}

// 查询最近
export function latelySafetyAppraisal() {
  return request({
    url: '/reservoir/appraisal/latelySafetyAppraisal',
    method: 'get',
  })
}


// 流程
export function startWorkFlow(data) {
  return request({
    url: '/reservoir/appraisal/startWorkFlow',
    method: 'post',
    data: data
  })
}

// 流程
export function taskReview(data) {
  return request({
    url: '/reservoir/appraisal/taskReview',
    method: 'post',
    data: data
  })
}


// dict
export function getDictByType() {
  return request({
    url: '/reservoir/appraisal/getDictByType',
    method: 'get',
  })
}
