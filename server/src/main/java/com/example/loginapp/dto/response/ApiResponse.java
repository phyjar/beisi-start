package com.example.loginapp.dto.response;

public class ApiResponse<T> {

    private Integer code;
    private String message;
    private T data;

    // Private constructor to enforce usage of static factory methods
    private ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    // Static factory methods
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(0, message, data);
    }

    public static <T> ApiResponse<T> success(T data) {
        return success(data, "Success");
    }

    public static ApiResponse<Void> fail(String message) {
        return new ApiResponse<>(1, message, null);
    }

    public static ApiResponse<Void> fail() {
        return fail("Operation failed");
    }
}