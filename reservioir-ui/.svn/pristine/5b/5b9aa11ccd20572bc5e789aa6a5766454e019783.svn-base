import request from '@/utils/request'

// 查询调度指令执行记录 列表
export function listLog(query) {
  return request({
    url: '/reservoir/log/list',
    method: 'get',
    params: query
  })
}

// 查询调度指令执行记录 详细
export function getLog(fLogId) {
  return request({
    url: '/reservoir/log/' + fLogId,
    method: 'get'
  })
}

// 新增调度指令执行记录
export function addLog(data) {
  return request({
    url: '/reservoir/log',
    method: 'post',
    data: data
  })
}

// 修改调度指令执行记录
export function updateLog(data) {
  return request({
    url: '/reservoir/log',
    method: 'put',
    data: data
  })
}

// 删除调度指令执行记录
export function delLog(fLogId) {
  return request({
    url: '/reservoir/log/' + fLogId,
    method: 'delete'
  })
}
