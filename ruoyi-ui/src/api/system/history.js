import request from '@/utils/request'

// 查询历史订单列表
export function listHistory(query) {
  return request({
    url: '/system/history/list',
    method: 'get',
    params: query
  })
}

// 查询历史订单详细
export function getHistory(ticketId) {
  return request({
    url: '/system/history/' + ticketId,
    method: 'get'
  })
}

// 新增历史订单
export function addHistory(data) {
  return request({
    url: '/system/history',
    method: 'post',
    data: data
  })
}

// 修改历史订单
export function updateHistory(data) {
  return request({
    url: '/system/history',
    method: 'put',
    data: data
  })
}

// 删除历史订单
export function delHistory(ticketId) {
  return request({
    url: '/system/history/' + ticketId,
    method: 'delete'
  })
}
