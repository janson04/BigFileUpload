<template>
  <div id="app">
    <el-container class="my-container">
      <el-header class="my-header">
        <span style="color: aliceblue;font-size: x-large">MyUploader</span>
      </el-header>
      <el-container>
        <el-aside>
          <el-menu :default-active="defaultActive" style="height: 100%">
            <el-menu-item index="singleFileUpload" @click="redirectUrl('/singleFileUpload')">
              <i class="el-icon-menu"></i>
              <span slot="title">單檔上傳</span>
            </el-menu-item>
            <el-menu-item index="multiFileUpload" @click="redirectUrl('/multiFileUpload')">
              <i class="el-icon-date"></i>
              <span slot="title">多檔案上傳</span>
            </el-menu-item>
            <el-menu-item index="bigFileUpload" @click="redirectUrl('/bigFileUpload')">
              <i class="el-icon-tickets"></i>
              <span slot="title">大檔案上傳</span>
            </el-menu-item>
            <el-menu-item index="stopUpload" @click="redirectUrl('/stopUpload')">
              <i class="el-icon-document"></i>
              <span slot="title">斷點續傳</span>
            </el-menu-item>
            <el-menu-item index="quickUpload" @click="redirectUrl('/quickUpload')">
              <i class="el-icon-upload"></i>
              <span slot="title">檔案秒傳</span>
            </el-menu-item>
            <el-menu-item index="pictureUpload" @click="redirectUrl('/pictureUpload')">
              <i class="el-icon-picture"></i>
              <span slot="title">圖片上傳</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main class="my-main">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data () {
      return {
        defaultActive: this.$route.name
      }
    },
    methods: {
      redirectUrl(val){
        this.$router.push(val);
      }
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    width: 100%;
  }
  .my-container {
    margin: 0 auto;
    position: absolute;
    width: 100%;
    height: 100%;
  }
  .my-header {
    background-color: deepskyblue;
    height: 20px;
    font-size: large;
    display: flex;
    justify-content:center;
    align-items:center;
  }
  .my-main {
    margin: 1em 1em;
  }
</style>
