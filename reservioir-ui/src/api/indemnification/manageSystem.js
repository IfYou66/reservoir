import request from '@/utils/request'

// 查询制度管理 列表
export function listManageSystem(query) {
  return request({
    url: '/reservoir/manageSystem/list',
    method: 'get',
    params: query
  })
}

// 查询制度管理 详细
export function getManageSystem(fSystemId) {
  return request({
    url: '/reservoir/manageSystem/' + fSystemId,
    method: 'get'
  })
}

// 新增制度管理
export function addManageSystem(data) {
  return request({
    url: '/reservoir/manageSystem',
    method: 'post',
    data: data
  })
}

// 修改制度管理
export function updateManageSystem(data) {
  return request({
    url: '/reservoir/manageSystem/update',
    method: 'post',
    data: data
  })
}

// 删除制度管理
export function delManageSystem(fSystemId) {
  return request({
    url: '/reservoir/manageSystem/' + fSystemId,
    method: 'delete'
  })
}
//档案制度、管理保障首页、两册一表等文章类查询使用 
export function getManagementInfoByCode(code) {
  return request({
    url: '/reservoir/manageSystem/getManagementInfoByCode',
    method: 'get',
    params: {
    	code
      }
  })
}
