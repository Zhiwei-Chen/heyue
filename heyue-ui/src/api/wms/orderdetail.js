import request from '@/utils/request'

// 查询用户订单详情：（最小单位）列表
export function listOrderdetail(query) {
  return request({
    url: '/wms/orderdetail/list',
    method: 'get',
    params: query
  })
}

// 查询用户订单详情：（最小单位）详细
export function getOrderdetail(id) {
  return request({
    url: '/wms/orderdetail/' + id,
    method: 'get'
  })
}

// 新增用户订单详情：（最小单位）
export function addOrderdetail(data) {
  return request({
    url: '/wms/orderdetail',
    method: 'post',
    data: data
  })
}

// 修改用户订单详情：（最小单位）
export function updateOrderdetail(data) {
  return request({
    url: '/wms/orderdetail',
    method: 'put',
    data: data
  })
}

// 删除用户订单详情：（最小单位）
export function delOrderdetail(id) {
  return request({
    url: '/wms/orderdetail/' + id,
    method: 'delete'
  })
}
