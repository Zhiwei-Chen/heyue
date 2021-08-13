import request from '@/utils/request'

// 查询库存列表
export function listStock(query) {
  return request({
    url: '/wms/stock/list',
    method: 'get',
    params: query
  })
}

// 查询库存详细
export function getStock(id) {
  return request({
    url: '/wms/stock/' + id,
    method: 'get'
  })
}

// 新增库存
export function addStock(data) {
  return request({
    url: '/wms/stock',
    method: 'post',
    data: data
  })
}

// 修改库存
export function updateStock(data) {
  return request({
    url: '/wms/stock',
    method: 'put',
    data: data
  })
}

// 删除库存
export function delStock(id) {
  return request({
    url: '/wms/stock/' + id,
    method: 'delete'
  })
}
