import request from '@/utils/request'

// 查询安全检查记录 列表
export function listCheckRecord(query) {
  return request({
    url: '/reservoir/checkRecord/list',
    method: 'get',
    params: query
  })
}

// 查询安全检查记录 详细
export function getCheckRecord(fId) {
  return request({
    url: '/reservoir/checkRecord/' + fId,
    method: 'get'
  })
}

// 根据安全检查实施表id获取安全检查记录集合
export function getMuster(query) {
  return request({
    url: '/reservoir/checkRecord/getMuster',
    method: 'get',
    params: query
  })
}

// 新增安全检查记录
export function addCheckRecord(data) {
  return request({
    url: '/reservoir/checkRecord',
    method: 'post',
    data: data
  })
}

// 修改安全检查记录
export function updateCheckRecord(data) {
  return request({
    url: '/reservoir/checkRecord',
    method: 'put',
    data: data
  })
}

// 删除安全检查记录
export function delCheckRecord(fId) {
  return request({
    url: '/reservoir/checkRecord/' + fId,
    method: 'delete'
  })
}
