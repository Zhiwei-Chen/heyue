import request from '@/utils/request'

// 查询注册验证列表
export function listCompany(query) {
  return request({
    url: '/system/company/list',
    method: 'get',
    params: query
  })
}

// 查询注册验证详细
export function getCompany(qmsId) {
  return request({
    url: '/system/company/' + qmsId,
    method: 'get'
  })
}

// 新增注册验证
export function addCompany(data) {
  return request({
    url: '/system/company',
    method: 'post',
    data: data
  })
}

// 修改注册验证
export function updateCompany(data) {
  return request({
    url: '/system/company',
    method: 'put',
    data: data
  })
}

// 删除注册验证
export function delCompany(qmsId) {
  return request({
    url: '/system/company/' + qmsId,
    method: 'delete'
  })
}
