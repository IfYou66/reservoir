import request from '@/utils/request'

// 查询安检检查实施 列表
export function listImpl(query) {
  return request({
    url: '/reservoir/SecuImpl/list',
    method: 'get',
    params: query
  })
}

// 查询安检检查实施 详细
export function getImpl(fId) {
  return request({
    url: '/reservoir/SecuImpl/' + fId,
    method: 'get'
  })
}

// 查询安检检查实施 详细
export function getEntity(query) {
  return request({
    url: '/reservoir/SecuImpl/getEntity',
    method: 'get',
    params: query
  })
}

// 新增安检检查实施
export function addImpl(data) {
  return request({
    url: '/reservoir/SecuImpl',
    method: 'post',
    data: data
  })
}

// 修改安检检查实施
export function updateImpl(data) {
  return request({
    url: '/reservoir/SecuImpl',
    method: 'put',
    data: data
  })
}

// 删除安检检查实施
export function delImpl(fId) {
  return request({
    url: '/reservoir/SecuImpl/' + fId,
    method: 'delete'
  })
}
