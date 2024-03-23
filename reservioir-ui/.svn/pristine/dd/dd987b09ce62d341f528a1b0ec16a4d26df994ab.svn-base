import request from '@/utils/request'

// 查询年度调度总结 列表
export function listScheduling(query) {
  return request({
    url: '/reservoir/scheduling/list',
    method: 'get',
    params: query
  })
}

// 查询年度调度总结 详细
export function getScheduling(fId) {
  return request({
    url: '/reservoir/scheduling/' + fId,
    method: 'get'
  })
}

// 新增年度调度总结 
export function addScheduling(data) {
  return request({
    url: '/reservoir/scheduling',
    method: 'post',
    data: data
  })
}

// 修改年度调度总结 
export function updateScheduling(data) {
  return request({
    url: '/reservoir/scheduling',
    method: 'put',
    data: data
  })
}

// 删除年度调度总结 
export function delScheduling(fId) {
  return request({
    url: '/reservoir/scheduling/' + fId,
    method: 'delete'
  })
}
