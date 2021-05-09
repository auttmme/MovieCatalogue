package com.auttmme.moviecatalogue.utils

interface OnSingleResponse<T>{
    fun onSuccess(data: T?)
    fun onFailure(error: Error)
}

interface OnArrayResponse<T>{
    fun onSuccess(datas: List<T>?)
    fun onFailure(error: Error)
}