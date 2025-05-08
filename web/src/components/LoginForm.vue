<template>
  <form @submit.prevent="handleSubmit" class="login-form">
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <div v-if="successMessage" class="success-message">{{ successMessage }}</div>

    <div class="form-group">
      <label for="username">用户名</label>
      <input 
        type="text" 
        id="username" 
        v-model="username" 
        :disabled="isLoading" 
        required 
        placeholder="请输入用户名"
      />
    </div>

    <div class="form-group">
      <label for="password">密码</label>
      <input 
        type="password" 
        id="password" 
        v-model="password" 
        :disabled="isLoading" 
        required 
        placeholder="请输入密码"
      />
    </div>

    <button type="submit" :disabled="isLoading" class="submit-button">
      <LoadingSpinner v-if="isLoading" class="button-spinner" :size="16" />
      <span>{{ isLoading ? '登录中...' : '登录' }}</span>
    </button>
  </form>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { AuthService } from '../services/AuthService'
import LoadingSpinner from './LoadingSpinner.vue'

const emit = defineEmits(['login-success'])

const username = ref('')
const password = ref('')
const isLoading = ref(false)
const errorMessage = ref<string | null>(null)
const successMessage = ref<string | null>(null)

const handleSubmit = async () => {
  errorMessage.value = null
  successMessage.value = null

  if (!username.value || !password.value) {
    errorMessage.value = '用户名和密码不能为空'
    return
  }

  isLoading.value = true
  try {
    const response = await AuthService.login(username.value, password.value)

    if (response.code === 0 && response.data?.token) {
      AuthService.storeToken(response.data.token)
      successMessage.value = '登录成功！'
      emit('login-success', username.value)
      username.value = ''
      password.value = ''
    } else {
      errorMessage.value = response.message || '登录失败，请检查用户名和密码'
    }
  } catch (error: any) {
    console.error('Login error:', error)
    errorMessage.value = error.response?.data?.message || error.message || '登录失败，请稍后再试'
  } finally {
    isLoading.value = false
  }
}
</script>

<style scoped>
.login-form {
  width: 100%;
  padding: 24px;
  background-color: var(--background-color);
  border: 1px solid var(--border-color);
  border-radius: 8px;
}

.form-group {
  margin-bottom: 16px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  color: var(--text-color);
  font-weight: 500;
}

.form-group input {
  width: 100%;
  padding: 8px 12px;
  border: 1px solid var(--border-color);
  border-radius: 4px;
  font-size: 14px;
  transition: border-color 0.2s;
}

.form-group input:focus {
  outline: none;
  border-color: var(--primary-color);
}

.submit-button {
  width: 100%;
  padding: 10px;
  background-color: var(--primary-color);
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  font-weight: 500;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  min-height: 42px;
}

.submit-button:disabled {
  opacity: 0.7;
  cursor: not-allowed;
}

.submit-button:not(:disabled):hover {
  background-color: var(--primary-hover);
}

.button-spinner {
  color: white;
}

.error-message {
  margin-bottom: 16px;
  padding: 12px;
  background-color: #fef2f2;
  border: 1px solid #fee2e2;
  border-radius: 4px;
  color: var(--error-color);
}

.success-message {
  margin-bottom: 16px;
  padding: 12px;
  background-color: #f0fdf4;
  border: 1px solid #dcfce7;
  border-radius: 4px;
  color: var(--success-color);
}
</style>