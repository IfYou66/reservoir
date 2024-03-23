import request from '@/utils/request'

// 查询水库预案编制 列表
export function listPlanning(query) {
  return request({
    url: '/reservoir/planning/list',
    method: 'get',
    params: query
  })
}

// 查询水库预案编制 详细
export function getPlanning(fId) {
  return request({
    url: '/reservoir/planning/' + fId,
    method: 'get'
  })
}

// 新增水库预案编制
export function addPlanning(data) {
  return request({
    url: '/reservoir/planning',
    method: 'post',
    data: data
  })
}

// 修改水库预案编制
export function updatePlanning(data) {
  return request({
    url: '/reservoir/planning',
    method: 'put',
    data: data
  })
}

// 删除水库预案编制
export function delPlanning(fId) {
  return request({
    url: '/reservoir/planning/' + fId,
    method: 'delete'
  })
}

// 初始化水库预案编制表格数据
export function planDataQuery(query) {
  return request({
    url: '/reservoir/planning/planDataQuery',
    method: 'get',
    params: query
  })
}
