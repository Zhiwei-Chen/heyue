import request from '@/utils/request'

// 查询待入库区列表
export function listWaitInstore(query) {
  return request({
    url: '/wms/waitInstore/list',
    method: 'get',
    params: query
  })
}

// 查询待入库区详细
export function getWaitInstore(id) {
  return request({
    url: '/wms/waitInstore/' + id,
    method: 'get'
  })
}

// 新增待入库区
export function addWaitInstore(data) {
  return request({
    url: '/wms/waitInstore',
    method: 'post',
    data: data
  })
}

// 修改待入库区
export function updateWaitInstore(data) {
  return request({
    url: '/wms/waitInstore',
    method: 'put',
    data: data
  })
}

// 删除待入库区
export function delWaitInstore(id) {
  return request({
    url: '/wms/waitInstore/' + id,
    method: 'delete'
  })
}
