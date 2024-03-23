import request from '@/utils/request'

// 查询参数配置列表
export function listConfig(query) {
  return request({
    url: '/api/config/pageList.do',
    method: 'get',
    params: query
  })
}

// 查询参数配置详细
export function getConfig(configId) {
  return request({
    url: '/api/config/load.do',
    method: 'get',
    data: configId
  })
}

// 新增参数配置
export function addConfig(data) {
  return request({
    url: '/api/config/insert.do',
    method: 'post',
    data: data
  })
}

// 修改参数配置
export function updateConfig(data) {
  return request({
    url: '/api/config/update.do',
    method: 'post',
    data: data
  })
}

// 删除参数配置
export function delConfig(configId) {
  return request({
    url: '/api/config/delete.do',
    method: 'delete',
    data: configId
  })

}
