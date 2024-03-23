import request from '@/utils/request'

// 查询最近
export function latelyCancellation(query) {
  return request({
    url: '/reservoir/cancellation/getLatelyCancellation',
    method: 'get',
    params: query
  })
}

// 查询水库大坝注销 列表
export function listCancellation(query) {
  return request({
    url: '/reservoir/cancellation/list',
    method: 'get',
    params: query
  })
}

// 查询水库大坝注销 详细
export function getCancellation(fId) {
  return request({
    url: '/reservoir/cancellation/' + fId,
    method: 'get'
  })
}

// 新增水库大坝注销
export function addCancellation(data) {
  return request({
    url: '/reservoir/cancellation',
    method: 'post',
    data: data
  })
}

// 修改水库大坝注销
export function updateCancellation(data) {
  return request({
    url: '/reservoir/cancellation',
    method: 'put',
    data: data
  })
}

// 删除水库大坝注销
export function delCancellation(fId) {
  return request({
    url: '/reservoir/cancellation/' + fId,
    method: 'delete'
  })
}

// 流程
export function nextCancellationInsert(data) {
  return request({
    url: '/reservoir/cancellation/nextCancellationInsert',
    method: 'post',
    data: data
  })
}

// 流程
export function nextCancellationUpdate(data) {
  return request({
    url: '/reservoir/cancellation/nextCancellationUpdate',
    method: 'post',
    data: data
  })
}

// dict
export function getDictByType() {
  return request({
    url: '/reservoir/cancellation/getDictByType',
    method: 'get',
    // params: query
  })
}
