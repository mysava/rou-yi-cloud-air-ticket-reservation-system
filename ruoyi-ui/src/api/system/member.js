import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listMember(query) {
  return request({
    url: '/system/member/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getMember(idcard) {
  return request({
    url: '/system/member/' + idcard,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addMember(data) {
  return request({
    url: '/system/member',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateMember(data) {
  return request({
    url: '/system/member',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delMember(idcard) {
  return request({
    url: '/system/member/' + idcard,
    method: 'delete'
  })
}
