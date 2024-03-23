import request from '@/utils/request'

// 查询水库调度规程 列表
export function listRules(query) {
  return request({
    url: '/reservoir/rules/list',
    method: 'get',
    params: query
  })
}

// 查询水库调度规程 详细
export function getRules(fId) {
  return request({
    url: '/reservoir/rules/' + fId,
    method: 'get'
  })
}

// 新增水库调度规程 
export function addRules(data) {
  return request({
    url: '/reservoir/rules',
    method: 'post',
    data: data
  })
}

// 修改水库调度规程 
export function updateRules(data) {
  return request({
    url: '/reservoir/rules',
    method: 'put',
    data: data
  })
}

// 删除水库调度规程 
export function delRules(fId) {
  return request({
    url: '/reservoir/rules/' + fId,
    method: 'delete'
  })
}
