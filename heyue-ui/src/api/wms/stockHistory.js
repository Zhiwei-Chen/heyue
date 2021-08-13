import request from '@/utils/request'

// 查询库存快照列表
export function listStockHistory(query) {
  return request({
    url: '/wms/stockHistory/list',
    method: 'get',
    params: query
  })
}

// 查询库存快照详细
export function getStockHistory(id) {
  return request({
    url: '/wms/stockHistory/' + id,
    method: 'get'
  })
}

// 新增库存快照
export function addStockHistory(data) {
  return request({
    url: '/wms/stockHistory',
    method: 'post',
    data: data
  })
}

// 修改库存快照
export function updateStockHistory(data) {
  return request({
    url: '/wms/stockHistory',
    method: 'put',
    data: data
  })
}

// 删除库存快照
export function delStockHistory(id) {
  return request({
    url: '/wms/stockHistory/' + id,
    method: 'delete'
  })
}
