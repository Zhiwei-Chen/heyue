import request from '@/utils/request'

// 查询物料表单列表
export function listMaterial(query) {
  return request({
    url: '/tms/material/list',
    method: 'get',
    params: query
  })
}
// 查询物料分类下拉树结构
export function treeselect() {
  return request({
    url: '/tms/materialClass/treeselect',
    method: 'get'
  })
}
// 查询物料表单详细
export function getMaterial(id) {
  return request({
    url: '/tms/material/' + id,
    method: 'get'
  })
}

// 新增物料表单
export function addMaterial(data) {
  return request({
    url: '/tms/material',
    method: 'post',
    data: data
  })
}

// 修改物料表单
export function updateMaterial(data) {
  return request({
    url: '/tms/material',
    method: 'put',
    data: data
  })
}

// 删除物料表单
export function delMaterial(id) {
  return request({
    url: '/tms/material/' + id,
    method: 'delete'
  })
}
