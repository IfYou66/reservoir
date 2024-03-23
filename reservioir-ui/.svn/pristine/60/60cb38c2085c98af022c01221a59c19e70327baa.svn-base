import request from '@/utils/request'

// 查询水库大坝除险加固 列表
export function listReinforcement(query) {
  return request({
    url: '/reservoir/reinforcement/list',
    method: 'get',
    params: query
  })
}

// 查询水库大坝除险加固 详细
export function getReinforcement(fId) {
  return request({
    url: '/reservoir/reinforcement/' + fId,
    method: 'get'
  })
}

// 新增水库大坝除险加固 
export function addReinforcement(data) {
  return request({
    url: '/reservoir/reinforcement',
    method: 'post',
    data: data
  })
}

// 修改水库大坝除险加固 
export function updateReinforcement(data) {
  return request({
    url: '/reservoir/reinforcement',
    method: 'put',
    data: data
  })
}

// 删除水库大坝除险加固 
export function delReinforcement(fId) {
  return request({
    url: '/reservoir/reinforcement/' + fId,
    method: 'delete'
  })
}

// 查询最近
export function latelyReinforcement() {
  return request({
    url: '/reservoir/reinforcement/latelyReinforcement',
    method: 'get',
  })
}

// 流程
export function startWorkFlow(data) {
  return request({
    url: '/reservoir/reinforcement/startWorkFlow',
    method: 'post',
    data: data
  })
}

// 流程
export function taskReview(data) {
  return request({
    url: '/reservoir/reinforcement/taskReview',
    method: 'post',
    data: data
  })
}

// dict
export function getDictByType() {
  return request({
    url: '/reservoir/reinforcement/getDictByType',
    method: 'get',
  })
}