import request from '@/utils/request'

// 查询汛期调度运行计划 列表
export function listSeason(query) {
  return request({
    url: '/reservoir/season/list',
    method: 'get',
    params: query
  })
}

// 查询汛期调度运行计划 详细
export function getSeason(fId) {
  return request({
    url: '/reservoir/season/' + fId,
    method: 'get'
  })
}

// 新增汛期调度运行计划 
export function addSeason(data) {
  return request({
    url: '/reservoir/season',
    method: 'post',
    data: data
  })
}

// 修改汛期调度运行计划 
export function updateSeason(data) {
  return request({
    url: '/reservoir/season',
    method: 'put',
    data: data
  })
}

// 删除汛期调度运行计划 
export function delSeason(fId) {
  return request({
    url: '/reservoir/season/' + fId,
    method: 'delete'
  })
}
