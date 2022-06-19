import request from '@/utils/request'

// 查询flight列表
export function listFlight(query) {
  return request({
    url: '/system/flight/list',
    method: 'get',
    params: query
  })
}

// 查询flight详细
export function getFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'get'
  })
}

// 新增flight
export function addFlight(data) {
  return request({
    url: '/system/flight',
    method: 'post',
    data: data
  })
}

// 预订flight
export function bookFlight(data) {
  return request({
    url: '/system/flight',
    method: 'put',
    data: data
  })
}

// 修改flight
export function updateFlight(data) {
  return request({
    url: '/system/flight',
    method: 'put',
    data: data
  })
}

// 删除flight
export function delFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'delete'
  })
}
