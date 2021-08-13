import request from '@/utils/request'

// 查询仓库信息列表
export function listWarehouse(query) {
  return request({
    url: '/wms/warehouse/list',
    method: 'get',
    params: query
  })
}

// 查询仓库信息详细
export function getWarehouse(id) {
  return request({
    url: '/wms/warehouse/' + id,
    method: 'get'
  })
}

// 新增仓库信息
export function addWarehouse(data) {
  return request({
    url: '/wms/warehouse',
    method: 'post',
    data: data
  })
}

// 修改仓库信息
export function updateWarehouse(data) {
  return request({
    url: '/wms/warehouse',
    method: 'put',
    data: data
  })
}

// 删除仓库信息
export function delWarehouse(id) {
  return request({
    url: '/wms/warehouse/' + id,
    method: 'delete'
  })
}
