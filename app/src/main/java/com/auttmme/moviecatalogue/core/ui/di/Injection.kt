package com.auttmme.moviecatalogue.core.ui.di

import android.content.Context
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.LocalDataSource
import com.auttmme.moviecatalogue.core.data.source.local.room.MovieCatalogueDatabase
import com.auttmme.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.core.utils.AppExecutors
import com.auttmme.moviecatalogue.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieCatalogueDao())
        val appExecutors = AppExecutors()

        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}