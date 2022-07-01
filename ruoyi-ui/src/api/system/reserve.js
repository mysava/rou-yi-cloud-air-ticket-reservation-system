import request from '@/utils/request'

// 查询航班预定列表
export function listReserve(query) {
  return request({
    url: '/system/reserve/list',
    method: 'get',
    params: query
  })
}

// 查询航班预定详细
export function getReserve(flightid) {
  return request({
    url: '/system/reserve/' + flightid,
    method: 'get'
  })
}

// 新增航班预定
export function addReserve(data) {
  return request({
    url: '/system/reserve',
    method: 'post',
    data: data
  })
}

// 修改航班预定
export function updateReserve(data) {
  return request({
    url: '/system/reserve',
    method: 'put',
    data: data
  })
}

// 删除航班预定
export function delReserve(flightid) {
  return request({
    url: '/system/reserve/' + flightid,
    method: 'delete'
  })
}
