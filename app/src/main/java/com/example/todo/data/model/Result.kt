package com.example.todo.data.model

sealed class Result<out T : Any?>{
    data class Success<out R>(val result:R) : Result<R>()
    data class Error(val message: String) : Result<Nothing>()
    object Progress : Result<Nothing>()
}