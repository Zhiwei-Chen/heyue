import request from '@/utils/request'

// 查询待出库区列表
export function listWaitOutstore(query) {
  return request({
    url: '/wms/waitOutstore/list',
    method: 'get',
    params: query
  })
}

// 查询待出库区详细
export function getWaitOutstore(id) {
  return request({
    url: '/wms/waitOutstore/' + id,
    method: 'get'
  })
}

// 新增待出库区
export function addWaitOutstore(data) {
  return request({
    url: '/wms/waitOutstore',
    method: 'post',
    data: data
  })
}

// 修改待出库区
export function updateWaitOutstore(data) {
  return request({
    url: '/wms/waitOutstore',
    method: 'put',
    data: data
  })
}

// 删除待出库区
export function delWaitOutstore(id) {
  return request({
    url: '/wms/waitOutstore/' + id,
    method: 'delete'
  })
}
