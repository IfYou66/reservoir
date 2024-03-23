import request from '@/utils/request'

// 查询制度分类列表
export function listType(query) {
  return request({
    url: '/reservoir/type/list',
    method: 'get',
    params: query
  })
}

// 查询制度分类详细
export function getType(fTypeId) {
  return request({
    url: '/reservoir/type/' + fTypeId,
    method: 'get'
  })
}

// 新增制度分类
export function addType(data) {
  return request({
    url: '/reservoir/type',
    method: 'post',
    data: data
  })
}

// 修改制度分类
export function updateType(data) {
  return request({
    url: '/reservoir/type',
    method: 'put',
    data: data
  })
}

// 删除制度分类
export function delType(fTypeId) {
  return request({
    url: '/reservoir/type/' + fTypeId,
    method: 'delete'
  })
}

// 制度分类树
export function treeselect() {
  return request({
    url: '/reservoir/type/treeselect',
    method: 'get'
  })
}
