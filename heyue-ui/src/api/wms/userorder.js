import request from '@/utils/request'

// 查询用户订单列表
export function listUserorder(query) {
  return request({
    url: '/wms/userorder/list',
    method: 'get',
    params: query
  })
}

// 查询用户订单详细
export function getUserorder(id) {
  return request({
    url: '/wms/userorder/' + id,
    method: 'get'
  })
}

// 新增用户订单
export function addUserorder(data) {
  return request({
    url: '/wms/userorder',
    method: 'post',
    data: data
  })
}

// 修改用户订单
export function updateUserorder(data) {
  return request({
    url: '/wms/userorder',
    method: 'put',
    data: data
  })
}

// 删除用户订单
export function delUserorder(id) {
  return request({
    url: '/wms/userorder/' + id,
    method: 'delete'
  })
}
