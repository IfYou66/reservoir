import request from '@/utils/request'

// 查询维修养护编制 列表
export function listMaintenance(query) {
  return request({
    url: '/reservoir/maintenance/list',
    method: 'get',
    params: query
  })
}



// 查询维修养护编制 详细
export function getMaintenance(fId) {
  return request({
    url: '/reservoir/maintenance/' + fId,
    method: 'get'
  })
}

// 新增维修养护编制 
export function addMaintenance(data) {
  return request({
    url: '/reservoir/maintenance',
    method: 'post',
    data: data
  })
}

// 修改维修养护编制 
export function updateMaintenance(data) {
  return request({
    url: '/reservoir/maintenance',
    method: 'put',
    data: data
  })
}

// 删除维修养护编制 
export function delMaintenance(fId) {
  return request({
    url: '/reservoir/maintenance/' + fId,
    method: 'delete'
  })
 
}