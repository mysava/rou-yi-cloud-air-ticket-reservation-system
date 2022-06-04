import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listSeat(query) {
  return request({
    url: '/system/seat/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getSeat(seatid) {
  return request({
    url: '/system/seat/' + seatid,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addSeat(data) {
  return request({
    url: '/system/seat',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateSeat(data) {
  return request({
    url: '/system/seat',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delSeat(seatid) {
  return request({
    url: '/system/seat/' + seatid,
    method: 'delete'
  })
}
