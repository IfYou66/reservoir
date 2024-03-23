import request from '@/utils/request'

// 查询防汛物资 列表
export function listMaterials(query) {
  return request({
    url: '/reservoir/materials/list',
    method: 'get',
    params: query
  })
}

// 查询防汛物资 详细
export function getMaterials(fId) {
  return request({
    url: '/reservoir/materials/' + fId,
    method: 'get'
  })
}

// 新增防汛物资
export function addMaterials(data) {
  return request({
    url: '/reservoir/materials',
    method: 'post',
    data: data
  })
}

// 新增防汛物资 ALL
export function insertAllMFloodMaterials(data) {
  return request({
    url: '/reservoir/materials/insertAllMFloodMaterials',
    method: 'post',
    data: data
  })
}

// 修改防汛物资
export function updateMaterials(data) {
  return request({
    url: '/reservoir/materials',
    method: 'put',
    data: data
  })
}

// 删除防汛物资
export function delMaterials(fId) {
  return request({
    url: '/reservoir/materials/' + fId,
    method: 'delete'
  })
}

// dict
export function getDictByType() {
  return request({
    url: '/reservoir/materials/getDictByType',
    method: 'get',
  })
}
