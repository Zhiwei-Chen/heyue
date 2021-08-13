import request from '@/utils/request'

// 查询入库单列表
export function listInstore(query) {
  return request({
    url: '/wms/instore/list',
    method: 'get',
    params: query
  })
}

// 查询入库单详细
export function getInstore(id) {
  return request({
    url: '/wms/instore/' + id,
    method: 'get'
  })
}

// 新增入库单
export function addInstore(data) {
  return request({
    url: '/wms/instore',
    method: 'post',
    data: data
  })
}

// 修改入库单
export function updateInstore(data) {
  return request({
    url: '/wms/instore',
    method: 'put',
    data: data
  })
}

// 删除入库单
export function delInstore(id) {
  return request({
    url: '/wms/instore/' + id,
    method: 'delete'
  })
}
