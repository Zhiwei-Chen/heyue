import request from '@/utils/request'

// 查询货架信息列表
export function listShelves(query) {
  return request({
    url: '/wms/shelves/list',
    method: 'get',
    params: query
  })
}

// 查询货架信息详细
export function getShelves(id) {
  return request({
    url: '/wms/shelves/' + id,
    method: 'get'
  })
}

// 新增货架信息
export function addShelves(data) {
  return request({
    url: '/wms/shelves',
    method: 'post',
    data: data
  })
}

// 修改货架信息
export function updateShelves(data) {
  return request({
    url: '/wms/shelves',
    method: 'put',
    data: data
  })
}

// 删除货架信息
export function delShelves(id) {
  return request({
    url: '/wms/shelves/' + id,
    method: 'delete'
  })
}
