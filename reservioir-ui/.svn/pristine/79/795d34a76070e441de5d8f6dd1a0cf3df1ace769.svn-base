import request from '@/utils/request'

// 查询经费支出 列表
export function listExpend(query) {
  return request({
    url: '/reservoir/expend/list',
    method: 'get',
    params: query
  })
}

// 查询经费支出 详细
export function getExpend(fId) {
  return request({
    url: '/reservoir/expend/' + fId,
    method: 'get'
  })
}

// 新增经费支出
export function addExpend(data) {
  return request({
    url: '/reservoir/expend',
    method: 'post',
    data: data
  })
}

// 修改经费支出
export function updateExpend(data) {
  return request({
    url: '/reservoir/expend',
    method: 'put',
    data: data
  })
}

// 删除经费支出
export function delExpend(fId) {
  return request({
    url: '/reservoir/expend/' + fId,
    method: 'delete'
  })
}
