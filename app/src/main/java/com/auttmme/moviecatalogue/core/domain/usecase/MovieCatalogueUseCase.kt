package com.auttmme.moviecatalogue.core.domain.usecase

import androidx.lifecycle.LiveData
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.domain.model.TvShow

interface MovieCatalogueUseCase {
    fun getAllMovies(): LiveData<Resource<List<Movie>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShow>>>

    fun getMovieById(movieId: Int): LiveData<Resource<Movie>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShow>>

    fun getFavoriteMovies(): LiveData<List<Movie>>

    fun getFavoriteTvShow(): LiveData<List<TvShow>>

    fun setMovieFavorite(movie: Movie, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShow, state: Boolean)
}