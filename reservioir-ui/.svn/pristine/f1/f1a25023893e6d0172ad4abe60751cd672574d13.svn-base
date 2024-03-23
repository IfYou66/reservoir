import request from '@/utils/request'

// 查询项目申报 列表
export function listReport(query) {
  return request({
    url: '/reservoir/report/list',
    method: 'get',
    params: query
  })
}

// 查询项目申报 详细
export function getReport(fId) {
  return request({
    url: '/reservoir/report/' + fId,
    method: 'get'
  })
}

// 新增项目申报 
export function addReport(data) {
  return request({
    url: '/reservoir/report',
    method: 'post',
    data: data
  })
}

// 修改项目申报 
export function updateReport(data) {
  return request({
    url: '/reservoir/report',
    method: 'put',
    data: data
  })
}

// 删除项目申报 
export function delReport(fId) {
  return request({
    url: '/reservoir/report/' + fId,
    method: 'delete'
  })
}