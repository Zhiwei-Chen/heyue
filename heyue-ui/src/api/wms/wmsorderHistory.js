import request from '@/utils/request'

// 查询仓储信息快照列表
export function listWmsorderHistory(query) {
  return request({
    url: '/wms/wmsorderHistory/list',
    method: 'get',
    params: query
  })
}

// 查询仓储信息快照详细
export function getWmsorderHistory(id) {
  return request({
    url: '/wms/wmsorderHistory/' + id,
    method: 'get'
  })
}

// 新增仓储信息快照
export function addWmsorderHistory(data) {
  return request({
    url: '/wms/wmsorderHistory',
    method: 'post',
    data: data
  })
}

// 修改仓储信息快照
export function updateWmsorderHistory(data) {
  return request({
    url: '/wms/wmsorderHistory',
    method: 'put',
    data: data
  })
}

// 删除仓储信息快照
export function delWmsorderHistory(id) {
  return request({
    url: '/wms/wmsorderHistory/' + id,
    method: 'delete'
  })
}
