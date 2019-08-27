package com.nagabinding.shared

sealed class Response<in T> {

    data class Success<T>(val result: T) : Response<T>()
    data class Error(val throwable: Throwable) : Response<Any?>()
}
