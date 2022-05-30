import request from '@/utils/request'

// 查询地区列表
export function listCity(query) {
  return request({
    url: '/system/city/list',
    method: 'get',
    params: query
  })
}

// 查询地区详细
export function getCity(id) {
  return request({
    url: '/system/city/' + id,
    method: 'get'
  })
}

// 新增地区
export function addCity(data) {
  return request({
    url: '/system/city',
    method: 'post',
    data: data
  })
}

// 修改地区
export function updateCity(data) {
  return request({
    url: '/system/city',
    method: 'put',
    data: data
  })
}

// 删除地区
export function delCity(id) {
  return request({
    url: '/system/city/' + id,
    method: 'delete'
  })
}
