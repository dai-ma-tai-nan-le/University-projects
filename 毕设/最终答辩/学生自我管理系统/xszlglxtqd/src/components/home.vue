<template>
  <div class="home">
    <el-container>
      <el-header style="padding: 0;">
        <Headerxs></Headerxs>
      </el-header>
      <el-main style="padding: 0;">
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>

import Headerxs from './commont/header(xs).vue'

export default {
  name: "main",
  data() {
    return {};
  },
  components: {
    Headerxs,
  },
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>