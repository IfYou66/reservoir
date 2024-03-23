import request from '@/utils/request'

// 查询水库信息列表
export function listReservoirInfo(query) {
  return request({
    url: '/reservoir/reservoirInfo/list',
    method: 'get',
    params: query
  })
}

// 查询水库信息详细
export function getReservoirInfo(id) {
  return request({
    url: '/reservoir/reservoirInfo/' + id,
    method: 'get'
  })
}

// 新增水库信息
export function addReservoirInfo(data) {
  return request({
    url: '/reservoir/reservoirInfo',
    method: 'post',
    data: data
  })
}

// 修改水库信息
export function updateReservoirInfo(data) {
  return request({
    url: '/reservoir/reservoirInfo',
    method: 'put',
    data: data
  })
}

// 删除水库信息
export function delReservoirInfo(id) {
  return request({
    url: '/reservoir/reservoirInfo/' + id,
    method: 'delete'
  })
}
