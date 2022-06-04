import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTicket(query) {
  return request({
    url: '/system/ticket/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTicket(ticketid) {
  return request({
    url: '/system/ticket/' + ticketid,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTicket(data) {
  return request({
    url: '/system/ticket',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTicket(data) {
  return request({
    url: '/system/ticket',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTicket(ticketid) {
  return request({
    url: '/system/ticket/' + ticketid,
    method: 'delete'
  })
}
