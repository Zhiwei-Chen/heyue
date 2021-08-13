import request from '@/utils/request'

// 查询货位信息列表
export function listLocation(query) {
  return request({
    url: '/wms/location/list',
    method: 'get',
    params: query
  })
}

// 查询货位信息详细
export function getLocation(id) {
  return request({
    url: '/wms/location/' + id,
    method: 'get'
  })
}

// 新增货位信息
export function addLocation(data) {
  return request({
    url: '/wms/location',
    method: 'post',
    data: data
  })
}

// 修改货位信息
export function updateLocation(data) {
  return request({
    url: '/wms/location',
    method: 'put',
    data: data
  })
}

// 删除货位信息
export function delLocation(id) {
  return request({
    url: '/wms/location/' + id,
    method: 'delete'
  })
}
