import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listFlight(query) {
  return request({
    url: '/system/flight/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addFlight(data) {
  return request({
    url: '/system/flight',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateFlight(data) {
  return request({
    url: '/system/flight',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delFlight(flightid) {
  return request({
    url: '/system/flight/' + flightid,
    method: 'delete'
  })
}
