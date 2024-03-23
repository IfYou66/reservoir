import request from '@/utils/request'

// 查询物资台账信息 列表
export function listMaterialsDetail(query) {
  return request({
    url: '/reservoir/materialsDetail/list',
    method: 'get',
    params: query
  })
}

// 查询物资台账信息 详细
export function getMaterialsDetail(fId) {
  return request({
    url: '/reservoir/materialsDetail/' + fId,
    method: 'get'
  })
}

// 新增物资台账信息 
export function addMaterialsDetail(data) {
  return request({
    url: '/reservoir/materialsDetail',
    method: 'post',
    data: data
  })
}

// 修改物资台账信息 
export function updateMaterialsDetail(data) {
  return request({
    url: '/reservoir/materialsDetail',
    method: 'put',
    data: data
  })
}

// 删除物资台账信息 
export function delMaterialsDetail(fId) {
  return request({
    url: '/reservoir/materialsDetail/' + fId,
    method: 'delete'
  })
}
