package com.auttmme.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getMovieById(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>
}