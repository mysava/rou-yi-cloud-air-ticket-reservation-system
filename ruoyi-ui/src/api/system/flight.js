import request from '@/utils/request'

// 查询航班管理列表
export function listFlight(query) {
  return request({
    url: '/system/flight/list',
    method: 'get',
    params: query
  })
}

// 查询航班管理详细
export function getFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'get'
  })
}

// 新增航班管理
export function addFlight(data) {
  return request({
    url: '/system/flight',
    method: 'post',
    data: data
  })
}

// 修改航班管理
export function updateFlight(data) {
  return request({
    url: '/system/flight',
    method: 'put',
    data: data
  })
}

// 删除航班管理
export function delFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'delete'
  })
}
