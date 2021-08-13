import request from '@/utils/request'

// 查询产品类别列表
export function listType(query) {
  return request({
    url: '/shop/type/list',
    method: 'get',
    params: query
  })
}

// 查询产品类别详细
export function getType(id) {
  return request({
    url: '/shop/type/' + id,
    method: 'get'
  })
}

// 新增产品类别
export function addType(data) {
  return request({
    url: '/shop/type',
    method: 'post',
    data: data
  })
}

// 修改产品类别
export function updateType(data) {
  return request({
    url: '/shop/type',
    method: 'put',
    data: data
  })
}

// 删除产品类别
export function delType(id) {
  return request({
    url: '/shop/type/' + id,
    method: 'delete'
  })
}
