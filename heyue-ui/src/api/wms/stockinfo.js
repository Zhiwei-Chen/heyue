import request from '@/utils/request'

// 查询库存信息列表
export function listStockinfo(query) {
  return request({
    url: '/wms/stockinfo/list',
    method: 'get',
    params: query
  })
}

// 查询库存信息详细
export function getStockinfo(id) {
  return request({
    url: '/wms/stockinfo/' + id,
    method: 'get'
  })
}

// 新增库存信息
export function addStockinfo(data) {
  return request({
    url: '/wms/stockinfo',
    method: 'post',
    data: data
  })
}

// 修改库存信息
export function updateStockinfo(data) {
  return request({
    url: '/wms/stockinfo',
    method: 'put',
    data: data
  })
}

// 删除库存信息
export function delStockinfo(id) {
  return request({
    url: '/wms/stockinfo/' + id,
    method: 'delete'
  })
}
