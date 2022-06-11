import request from '@/utils/request'

// 查询航班信息管理列表
export function listFlights(query) {
  return request({
    url: '/system/flights/list',
    method: 'get',
    params: query
  })
}

// 查询航班信息管理详细
export function getFlights(flightno) {
  return request({
    url: '/system/flights/' + flightno,
    method: 'get'
  })
}

// 新增航班信息管理
export function addFlights(data) {
  return request({
    url: '/system/flights',
    method: 'post',
    data: data
  })
}

// 修改航班信息管理
export function updateFlights(data) {
  return request({
    url: '/system/flights',
    method: 'put',
    data: data
  })
}

// 删除航班信息管理
export function delFlights(flightno) {
  return request({
    url: '/system/flights/' + flightno,
    method: 'delete'
  })
}
