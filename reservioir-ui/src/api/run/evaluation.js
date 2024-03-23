import request from '@/utils/request'

// 查询洪水调度考评 列表
export function listEvaluation(query) {
  return request({
    url: '/reservoir/evaluation/list',
    method: 'get',
    params: query
  })
}

// 查询洪水调度考评 详细
export function getEvaluation(fId) {
  return request({
    url: '/reservoir/evaluation/' + fId,
    method: 'get'
  })
}

// 新增洪水调度考评 
export function addEvaluation(data) {
  return request({
    url: '/reservoir/evaluation',
    method: 'post',
    data: data
  })
}

// 修改洪水调度考评 
export function updateEvaluation(data) {
  return request({
    url: '/reservoir/evaluation',
    method: 'put',
    data: data
  })
}

// 删除洪水调度考评 
export function delEvaluation(fId) {
  return request({
    url: '/reservoir/evaluation/' + fId,
    method: 'delete'
  })
}
