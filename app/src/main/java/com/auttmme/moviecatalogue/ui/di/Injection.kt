package com.auttmme.moviecatalogue.ui.di

import android.content.Context
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepo(context: Context) : MovieCatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieCatalogueRepository(remoteDataSource)
    }
}