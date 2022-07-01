import request from '@/utils/request'

// 查询订单管理列表
export function listTickets(query) {
  return request({
    url: '/system/tickets/list',
    method: 'get',
    params: query
  })
}

// 查询订单管理详细
export function getTickets(ticketId) {
  return request({
    url: '/system/tickets/' + ticketId,
    method: 'get'
  })
}

// 新增订单管理
export function addTickets(data,flightid) {
  return request({
    url: '/system/tickets/'+flightid,
    method: 'post',
    data: data
  })
}

export function alterTickets(data,ticketId) {
  return request({
    url: '/system/tickets/alter/'+ ticketId,
    method: 'post',
    data: data
  })
}

// 修改订单管理
export function updateTickets(data) {
  return request({
    url: '/system/tickets',
    method: 'put',
    data: data
  })
}

// 删除订单管理
export function delTickets(ticketId) {
  return request({
    url: '/system/tickets/' + ticketId,
    method: 'delete'
  })
}
