import request from '@/utils/request'

// 查询险情管理 列表
export function listManagement(query) {
  return request({
    url: '/reservoir/management/list',
    method: 'get',
    params: query
  })
}

// 查询险情管理 详细
export function getManagement(fId) {
  return request({
    url: '/reservoir/management/' + fId,
    method: 'get'
  })
}

// 新增险情管理 
export function addManagement(data) {
  return request({
    url: '/reservoir/management',
    method: 'post',
    data: data
  })
}

// 修改险情管理 
export function updateManagement(data) {
  return request({
    url: '/reservoir/management',
    method: 'put',
    data: data
  })
}

// 删除险情管理 
export function delManagement(fId) {
  return request({
    url: '/reservoir/management/' + fId,
    method: 'delete'
  })
}