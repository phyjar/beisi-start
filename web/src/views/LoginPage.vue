<template>
  <div class="login-page">
    <div v-if="isLoggedIn" class="welcome-message">
      <h2>欢迎回来, {{ loggedInUser }}!</h2>
      <button @click="handleLogout">退出登录</button>
    </div>
    <LoginForm v-else @login-success="handleLoginSuccess" />
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import LoginForm from '../components/LoginForm.vue'
import { AuthService } from '../services/AuthService'

const isLoggedIn = ref(false)
const loggedInUser = ref<string | null>(null)

const handleLoginSuccess = (username: string) => {
  isLoggedIn.value = true
  loggedInUser.value = username
}

const handleLogout = () => {
  AuthService.removeToken()
  isLoggedIn.value = false
  loggedInUser.value = null
}
</script>

<style scoped>
.login-page {
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

.welcome-message {
  text-align: center;
  padding: 20px;
  background-color: var(--background-color);
  border: 1px solid var(--border-color);
  border-radius: 8px;
}

.welcome-message h2 {
  margin-bottom: 20px;
  color: var(--text-color);
}

.welcome-message button {
  padding: 8px 16px;
  background-color: var(--primary-color);
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.welcome-message button:hover {
  background-color: var(--primary-hover);
}
</style>