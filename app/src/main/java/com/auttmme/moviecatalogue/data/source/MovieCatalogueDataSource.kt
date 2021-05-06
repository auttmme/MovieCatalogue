package com.auttmme.moviecatalogue.data.source

import com.auttmme.moviecatalogue.data.MovieEntity
import com.auttmme.moviecatalogue.data.TvShowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShows(): List<TvShowEntity>

    fun getMovieById(movieId: Int): MovieEntity

    fun getTvShowById(tvShowId: Int): TvShowEntity
}