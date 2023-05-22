import request from '@/utils/request'

export default{
  // 接收参数
  searchUser(searchModel){
    return request({
      url: '/api/user/search',
      method: 'get',
      params:{username: searchModel.username
             ,phone: searchModel.phone
             , pageNo: searchModel.pageNo
             , pageSize: searchModel.pageSize}
    })
  },
  addUser(searchModel){
    return request({
      url: "/api/user/addUser",
      method: "get",
      params:{
        username: searchModel.username,
        phone: searchModel.phone
      }
    })
  }
}