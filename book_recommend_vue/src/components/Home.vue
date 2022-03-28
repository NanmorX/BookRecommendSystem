<template>
  <div>
    <el-header>
      <nav-menu style=""></nav-menu>
    </el-header>
    <el-main style="padding-right: 0px; padding-height: auto; padding-bottom: 0px">
      <router-view style="padding-top:10px; height: 650px"/>
    </el-main>
  </div>
</template>

<script>
import NavMenu from './common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style scoped>

</style>
