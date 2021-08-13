import request from '@/utils/request'

// 查询客户下单列表
export function listOrder(query) {
  return request({
    url: '/tms/order/list',
    method: 'get',
    params: query
  })
}

// 查询客户下单详细
export function getOrder(id) {
  return request({
    url: '/tms/order/' + id,
    method: 'get'
  })
}

// 新增客户下单
export function addOrder(data) {
  return request({
    url: '/tms/order',
    method: 'post',
    data: data
  })
}

// 修改客户下单
export function updateOrder(data) {
  return request({
    url: '/tms/order',
    method: 'put',
    data: data
  })
}

// 删除客户下单
export function delOrder(id) {
  return request({
    url: '/tms/order/' + id,
    method: 'delete'
  })
}
