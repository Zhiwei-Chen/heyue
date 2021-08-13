import request from '@/utils/request'

// 查询传感器明细列表
export function listSensordetail(query) {
  return request({
    url: '/tms/sensordetail/list',
    method: 'get',
    params: query
  })
}

// 查询传感器明细详细
export function getSensordetail(id) {
  return request({
    url: '/tms/sensordetail/' + id,
    method: 'get'
  })
}

// 新增传感器明细
export function addSensordetail(data) {
  return request({
    url: '/tms/sensordetail',
    method: 'post',
    data: data
  })
}

// 修改传感器明细
export function updateSensordetail(data) {
  return request({
    url: '/tms/sensordetail',
    method: 'put',
    data: data
  })
}

// 删除传感器明细
export function delSensordetail(id) {
  return request({
    url: '/tms/sensordetail/' + id,
    method: 'delete'
  })
}
