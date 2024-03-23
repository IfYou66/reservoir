import request from '@/utils/request'

// 查询档案室列表
export function listBorder(query) {
  return request({
    url: '/reservoir/border/getLabelList',
    method: 'post',
    params: query
  })
}
// 界限提交
export function update(query) {
  return request({
    url: '/reservoir/border/update',
    method: 'post',
    data: query
    // data: data
  })
}
