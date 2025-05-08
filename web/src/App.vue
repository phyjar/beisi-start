<script setup lang="ts">
// 移除了 RouterLink, RouterView 和 HelloWorld 的导入，因为它们不再直接使用
import LoginPage from './views/LoginPage.vue'; // 导入登录页面
</script>

<template>
  <div id="app">
    <LoginPage /> <!-- 正确的 Vue 注释格式 -->
  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
}
</style>
