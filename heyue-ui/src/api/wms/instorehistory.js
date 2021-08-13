import request from '@/utils/request'

// 查询入库单快照列表
export function listInstorehistory(query) {
  return request({
    url: '/wms/instorehistory/list',
    method: 'get',
    params: query
  })
}

// 查询入库单快照详细
export function getInstorehistory(id) {
  return request({
    url: '/wms/instorehistory/' + id,
    method: 'get'
  })
}

// 新增入库单快照
export function addInstorehistory(data) {
  return request({
    url: '/wms/instorehistory',
    method: 'post',
    data: data
  })
}

// 修改入库单快照
export function updateInstorehistory(data) {
  return request({
    url: '/wms/instorehistory',
    method: 'put',
    data: data
  })
}

// 删除入库单快照
export function delInstorehistory(id) {
  return request({
    url: '/wms/instorehistory/' + id,
    method: 'delete'
  })
}
