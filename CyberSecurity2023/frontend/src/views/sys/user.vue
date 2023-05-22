<template>
  <div>
    <el-card id="searchbar">
      <el-row>
        <el-col :span="16">
          <el-input v-model="searchModel.username" placeholder="Username" clearable="true"></el-input>
          <el-input v-model="searchModel.phone" placeholder="Phone Number" clearable="true"></el-input>
          <el-button type="primary" round icon="el-icon-search" @click="this.searchUser"
            >Search</el-button
          >
        </el-col>

        <el-col :span="8" align="right">
          <el-button type="primary" circle icon="el-icon-plus" @click="this.addUser"></el-button>
        </el-col>
      </el-row>
    </el-card>

    <el-card id="resultbar">
      <el-table :data="userList" stripe style="width: 100%">
        <el-table-column  label="#" width="80">
          <template slot-scope="scope">
              {{(searchModel.pageNo -1) * searchModel.pageSize +scope.$index+1 }}
          </template>
        </el-table-column>
        <el-table-column prop="id" label="User ID" width="80">
        </el-table-column>
        <el-table-column prop="username" label="Username" width="180">
        </el-table-column>
        <el-table-column prop="phone" label="Phone No." width="180">
        </el-table-column>
        <el-table-column prop="email" label="Email" > 
        </el-table-column>
        <el-table-column prop="action" label="action" width="80"> 
        </el-table-column>
      </el-table>
    </el-card>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="searchModel.pageNo"
      :page-sizes="[5, 10, 15, 30]"
      :page-size="searchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total=total>
    </el-pagination>

  </div>
</template>

<script>
import userApi from '@/api/userManage'

export default {
  name: "User",
  created(){
    this.searchUser();
  },
  data()
  {
    return{
      total: 0,
      searchModel:{
        // 初始化数值
        pageNo : 1,
        pageSize: 10
      },
      userList: []
    }
  }
  ,
  methods:{
    handleSizeChange(pageSize){
        this.searchModel.pageSize = pageSize;
        this.searchUser();
    },
    handleCurrentChange(pageNo){
       this.searchModel.pageNo = pageNo;
        this.searchUser();
    },
    searchUser(){
      userApi.searchUser(this.searchModel).then(response => {
        this.total = response.data.total;
        this.userList = response.data.rows;
        }
      )
    },
    addUser(){
      userApi.addUser(this.searchModel).then(response=>{
        window.location.reload()
      })
    }
  }
};
</script>

<style>
#searchbar .el-input {
  width: 250px;
  padding: 0 5px;
}
</style>