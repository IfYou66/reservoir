import request from '@/utils/request'

// 查询水库大坝工程基本信息 列表
export function listInformation(query) {
  return request({
    url: '/reservoir/information/list',
    method: 'get',
    params: query
  })
}

// 查询水库大坝工程基本信息 详细
export function getInformation(fId) {
  return request({
    url: '/reservoir/information/' + fId,
    method: 'get'
  })
}

// 新增水库大坝工程基本信息 
export function addInformation(data) {
  return request({
    url: '/reservoir/information',
    method: 'post',
    data: data
  })
}

// 修改水库大坝工程基本信息 
export function updateInformation(data) {
  return request({
    url: '/reservoir/information',
    method: 'put',
    data: data
  })
}

// 删除水库大坝工程基本信息 
export function delInformation(fId) {
  return request({
    url: '/reservoir/information/' + fId,
    method: 'delete'
  })
}