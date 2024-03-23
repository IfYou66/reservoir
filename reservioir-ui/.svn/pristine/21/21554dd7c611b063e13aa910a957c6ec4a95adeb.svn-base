import request from '@/utils/request'

// 查询调度指令 列表
export function listInstruction(query) {
  return request({
    url: '/reservoir/instruction/list',
    method: 'get',
    params: query
  })
}

// 查询调度指令 详细
export function getInstruction(fInstructionId) {
  return request({
    url: '/reservoir/instruction/' + fInstructionId,
    method: 'get'
  })
}

// 新增调度指令
export function addInstruction(data) {
  return request({
    url: '/reservoir/instruction',
    method: 'post',
    data: data
  })
}

// 修改调度指令
export function updateInstruction(data) {
  return request({
    url: '/reservoir/instruction',
    method: 'put',
    data: data
  })
}

// 删除调度指令
export function delInstruction(fInstructionId) {
  return request({
    url: '/reservoir/instruction/' + fInstructionId,
    method: 'delete'
  })
}
