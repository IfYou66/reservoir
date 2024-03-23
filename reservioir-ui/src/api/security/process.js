import request from '@/utils/request'

// 查询事件处置列表
export function listProcess(query) {
  return request({
    url: '/reservoir/process/list',
    method: 'get',
    params: query
  })
}

// 查询事件处置详细
export function getProcess(fId) {
  return request({
    url: '/reservoir/process/' + fId,
    method: 'get'
  })
}

// 新增事件处置
export function addProcess(data) {
  return request({
    url: '/reservoir/process',
    method: 'post',
    data: data
  })
}

// 修改事件处置
export function updateProcess(data) {
  return request({
    url: '/reservoir/process',
    method: 'put',
    data: data
  })
}

// 删除事件处置
export function delProcess(fId) {
  return request({
    url: '/reservoir/process/' + fId,
    method: 'delete'
  })
}
