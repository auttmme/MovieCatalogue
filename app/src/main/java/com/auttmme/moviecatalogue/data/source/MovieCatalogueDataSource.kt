package com.auttmme.moviecatalogue.data.source

import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.OnArrayResponse
import com.auttmme.moviecatalogue.utils.OnSingleResponse

interface MovieCatalogueDataSource {
    fun getAllMovies(listener: OnArrayResponse<MovieEntity>)

    fun getAllTvShows(listener: OnArrayResponse<TvShowEntity>)

    fun getMovieById(movieId: Int, listener: OnSingleResponse<MovieEntity>)

    fun getTvShowById(tvShowId: Int, listener: OnSingleResponse<TvShowEntity>)
}