/**
 * 通用 API 响应结构
 */
export interface ApiResponse<T> {
  code: number;
  message: string;
  data: T | null; // 允许 data 为 null
}

/**
 * 登录接口响应数据结构
 */
export interface LoginResponseData {
  token: string;
}

/**
 * 登录接口请求数据结构
 */
export interface LoginRequest {
  username: string;
  password: string;
}