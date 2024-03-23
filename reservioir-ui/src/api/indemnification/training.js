import request from '@/utils/request'

// 查询培训列表
export function listTraining(query) {
  return request({
    url: '/reservoir/training/list',
    method: 'get',
    params: query
  })
}

// 查询培训详细
export function getTraining(fId) {
  return request({
    url: '/reservoir/training/' + fId,
    method: 'get'
  })
}

// 新增培训
export function addTraining(data) {
  return request({
    url: '/reservoir/training',
    method: 'post',
    data: data
  })
}

// 修改培训
export function updateTraining(data) {
  return request({
    url: '/reservoir/training',
    method: 'put',
    data: data
  })
}

// 删除培训
export function delTraining(fId) {
  return request({
    url: '/reservoir/training/' + fId,
    method: 'delete'
  })
}

// 初始化培训编制表格数据
export function queryDataDictionary() {
  return request({
    url: '/reservoir/training/queryDataDictionary',
    method: 'get'
  })
}

// 初始化培训编制表格数据
export function dataQuery(query) {
  return request({
    url: '/reservoir/training/dataQuery',
    method: 'get',
    params: query
  })
}
