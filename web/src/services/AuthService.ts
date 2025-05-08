import type { ApiResponse, LoginResponseData } from '@/types/auth';
import axios, {AxiosError} from "axios";

// 配置axios默认值
// axios.defaults.baseURL = 'http://localhost:8888';  // 删除这行，使用相对路径
axios.defaults.headers.common['Content-Type'] = 'application/json';
axios.defaults.withCredentials = true;

const TOKEN_KEY = 'authToken';

/**
 * 用户登录
 * @param username 用户名
 * @param password 密码
 * @returns Promise 包含 API 响应
 */
async function login(username: string, password: string): Promise<ApiResponse<LoginResponseData>> {
  try {
    const response = await axios.post<ApiResponse<LoginResponseData>>(
      '/api/login',
      { username, password }
    );
    if (response.data && response.data.code === 0 && response.data.data?.token) {
      storeToken(response.data.data.token);
    }
    return response.data;
  } catch (error) {
    if (axios.isAxiosError(error)) {
      const axiosError = error as AxiosError<ApiResponse<LoginResponseData>>;
      if (axiosError.response) {
        return axiosError.response.data;
      }
    }
    // 对于网络错误或其他非 Axios 错误，返回一个标准的错误响应
    return {
      code: 1,
      message: '登录请求失败，请检查网络连接或稍后再试。',
      data: null,
    };
  }
}

/**
 * 存储认证 Token
 * @param token 认证 Token
 */
function storeToken(token: string): void {
  localStorage.setItem(TOKEN_KEY, token);
}

/**
 * 获取认证 Token
 * @returns 认证 Token，如果不存在则返回 null
 */
function getToken(): string | null {
  return localStorage.getItem(TOKEN_KEY);
}

/**
 * 移除认证 Token
 */
function removeToken(): void {
  localStorage.removeItem(TOKEN_KEY);
}

export const AuthService = {
  login,
  storeToken,
  getToken,
  removeToken,
};