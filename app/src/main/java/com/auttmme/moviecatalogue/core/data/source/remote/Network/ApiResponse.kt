package com.auttmme.moviecatalogue.core.data.source.remote.Network

import com.auttmme.moviecatalogue.core.data.source.remote.StatusResponse

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}