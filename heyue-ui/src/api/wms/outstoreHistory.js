import request from '@/utils/request'

// 查询出库单快照列表
export function listOutstoreHistory(query) {
  return request({
    url: '/wms/outstoreHistory/list',
    method: 'get',
    params: query
  })
}

// 查询出库单快照详细
export function getOutstoreHistory(id) {
  return request({
    url: '/wms/outstoreHistory/' + id,
    method: 'get'
  })
}

// 新增出库单快照
export function addOutstoreHistory(data) {
  return request({
    url: '/wms/outstoreHistory',
    method: 'post',
    data: data
  })
}

// 修改出库单快照
export function updateOutstoreHistory(data) {
  return request({
    url: '/wms/outstoreHistory',
    method: 'put',
    data: data
  })
}

// 删除出库单快照
export function delOutstoreHistory(id) {
  return request({
    url: '/wms/outstoreHistory/' + id,
    method: 'delete'
  })
}
