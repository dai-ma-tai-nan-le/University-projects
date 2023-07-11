<template>
  <div class="main">
    <el-container>
      <el-aside style="width:200px">
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header style="padding: 0;">
          <Header></Header>
        </el-header>
        <el-main  style="padding: 0;">
          <!-- 路由的出口 -->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

import Aside from './commont/Aside.vue'
import Header from './commont/header.vue'

export default{
    name: "main",
    data() {
        return {};
    },
    components:{
    Aside,
    Header,
  },
}
</script>

<style>
*{
  margin: 0;
  padding: 0;
}
</style>