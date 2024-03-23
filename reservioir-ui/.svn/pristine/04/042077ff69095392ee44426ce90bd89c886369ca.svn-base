import request from '@/utils/request'

// 查询事件记录 列表
export function listEventRecord(query) {
  return request({
    url: '/reservoir/eventRecord/list',
    method: 'get',
    params: query
  })
}

// 查询事件记录 详细
export function getEventRecord(fId) {
  return request({
    url: '/reservoir/eventRecord/' + fId,
    method: 'get'
  })
}

// 新增事件记录
export function addEventRecord(data) {
  return request({
    url: '/reservoir/eventRecord',
    method: 'post',
    data: data
  })
}

// 修改事件记录
export function updateEventRecord(data) {
  return request({
    url: '/reservoir/eventRecord',
    method: 'put',
    data: data
  })
}

// 删除事件记录
export function delEventRecord(fId) {
  return request({
    url: '/reservoir/eventRecord/' + fId,
    method: 'delete'
  })
}
