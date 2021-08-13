import request from '@/utils/request'

// 查询仓库区域列表
export function listAreas(query) {
  return request({
    url: '/wms/areas/list',
    method: 'get',
    params: query
  })
}

// 查询仓库区域详细
export function getAreas(id) {
  return request({
    url: '/wms/areas/' + id,
    method: 'get'
  })
}

// 新增仓库区域
export function addAreas(data) {
  return request({
    url: '/wms/areas',
    method: 'post',
    data: data
  })
}

// 修改仓库区域
export function updateAreas(data) {
  return request({
    url: '/wms/areas',
    method: 'put',
    data: data
  })
}

// 删除仓库区域
export function delAreas(id) {
  return request({
    url: '/wms/areas/' + id,
    method: 'delete'
  })
}
