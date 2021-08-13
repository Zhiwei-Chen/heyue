import request from '@/utils/request'

// 查询传感器管理列表
export function listSensor(query) {
  return request({
    url: '/tms/sensor/list',
    method: 'get',
    params: query
  })
}

// 查询传感器管理详细
export function getSensor(id) {
  return request({
    url: '/tms/sensor/' + id,
    method: 'get'
  })
}

// 新增传感器管理
export function addSensor(data) {
  return request({
    url: '/tms/sensor',
    method: 'post',
    data: data
  })
}

// 修改传感器管理
export function updateSensor(data) {
  return request({
    url: '/tms/sensor',
    method: 'put',
    data: data
  })
}

// 删除传感器管理
export function delSensor(id) {
  return request({
    url: '/tms/sensor/' + id,
    method: 'delete'
  })
}
