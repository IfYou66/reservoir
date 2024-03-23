import request from '@/utils/request'

// 查询经费申请 列表
export function listApply(query) {
  return request({
    url: '/reservoir/apply/list',
    method: 'get',
    params: query
  })
}

// 查询经费申请 详细
export function getApply(fId) {
  return request({
    url: '/reservoir/apply/' + fId,
    method: 'get'
  })
}

// 新增经费申请
export function addApply(data) {
  return request({
    url: '/reservoir/apply',
    method: 'post',
    data: data
  })
}

// 修改经费申请
export function updateApply(data) {
  return request({
    url: '/reservoir/apply',
    method: 'put',
    data: data
  })
}

// 删除经费申请
export function delApply(fId) {
  return request({
    url: 'reservoir/apply/' + fId,
    method: 'delete'
  })
}

// 初始化培训编制表格数据
export function inquiry() {
  return request({
    url: '/reservoir/apply/inquiry',
    method: 'get'
  })
}
