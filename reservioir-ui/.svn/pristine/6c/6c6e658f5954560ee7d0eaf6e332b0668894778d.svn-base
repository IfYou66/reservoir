import request from '@/utils/request'

// 查询维修养护实施 列表
export function listImpl(query) {
  return request({
    url: '/reservoir/impl/list',
    method: 'get',
    params: query
  })
}

// 查询维修养护实施 详细
export function getImpl(fId) {
  return request({
    url: '/reservoir/impl/' + fId,
    method: 'get'
  })
}

// 新增维修养护实施 
export function addImpl(data) {
  return request({
    url: '/reservoir/impl',
    method: 'post',
    data: data
  })
}

// 修改维修养护实施 
export function updateImpl(data) {
  return request({
    url: '/reservoir/impl',
    method: 'put',
    data: data
  })
}

// 删除维修养护实施 
export function delImpl(fId) {
  return request({
    url: '/reservoir/impl/' + fId,
    method: 'delete'
  })
}