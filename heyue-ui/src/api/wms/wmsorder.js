import request from '@/utils/request'

// 查询仓储信息列表
export function listWmsorder(query) {
  return request({
    url: '/wms/wmsorder/list',
    method: 'get',
    params: query
  })
}

// 查询仓储信息详细
export function getWmsorder(id) {
  return request({
    url: '/wms/wmsorder/' + id,
    method: 'get'
  })
}

// 新增仓储信息
export function addWmsorder(data) {
  return request({
    url: '/wms/wmsorder',
    method: 'post',
    data: data
  })
}

// 修改仓储信息
export function updateWmsorder(data) {
  return request({
    url: '/wms/wmsorder',
    method: 'put',
    data: data
  })
}

// 删除仓储信息
export function delWmsorder(id) {
  return request({
    url: '/wms/wmsorder/' + id,
    method: 'delete'
  })
}
