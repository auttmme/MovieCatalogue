package com.auttmme.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}