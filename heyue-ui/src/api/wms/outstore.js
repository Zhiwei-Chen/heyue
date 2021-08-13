import request from '@/utils/request'

// 查询出库单管理列表
export function listOutstore(query) {
  return request({
    url: '/wms/outstore/list',
    method: 'get',
    params: query
  })
}

// 查询出库单管理详细
export function getOutstore(id) {
  return request({
    url: '/wms/outstore/' + id,
    method: 'get'
  })
}

// 新增出库单管理
export function addOutstore(data) {
  return request({
    url: '/wms/outstore',
    method: 'post',
    data: data
  })
}

// 修改出库单管理
export function updateOutstore(data) {
  return request({
    url: '/wms/outstore',
    method: 'put',
    data: data
  })
}

// 删除出库单管理
export function delOutstore(id) {
  return request({
    url: '/wms/outstore/' + id,
    method: 'delete'
  })
}
