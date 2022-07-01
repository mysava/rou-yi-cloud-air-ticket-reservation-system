import request from '@/utils/request'

// 查询订单修改列表
export function listAmend(query) {
  return request({
    url: '/system/amend/list',
    method: 'get',
    params: query
  })
}

// 查询订单修改详细
export function getAmend(flightid) {
  return request({
    url: '/system/amend/' + flightid,
    method: 'get'
  })
}

// 新增订单修改
export function addAmend(data) {
  return request({
    url: '/system/amend',
    method: 'post',
    data: data
  })
}

// 修改订单修改
export function updateAmend(data) {
  return request({
    url: '/system/amend',
    method: 'put',
    data: data
  })
}

// 删除订单修改
export function delAmend(flightid) {
  return request({
    url: '/system/amend/' + flightid,
    method: 'delete'
  })
}
