import request from '@/utils/request'

// 查询档案 列表
export function listArchives(query) {
  return request({
    url: '/archives/archives/list',
    method: 'get',
    params: query
  })
}

// 查询字典列表 
export function initArchivesForm() {
  return request({
    url: '/archives/archives/initArchivesForm',
    method: 'get'
  })
}

// 查询档案 详细
export function getArchives(fArchivesId) {
  return request({
    url: '/archives/archives/' + fArchivesId,
    method: 'get'
  })
}

// 新增档案 
export function addArchives(data) {
  return request({
    url: '/archives/archives',
    method: 'post',
    data: data
  })
}

// 修改档案 
export function updateArchives(data) {
  return request({
    url: '/archives/archives',
    method: 'put',
    data: data
  })
}

// 删除档案 
export function delArchives(fArchivesId) {
  return request({
    url: '/archives/archives/' + fArchivesId,
    method: 'delete'
  })
}

