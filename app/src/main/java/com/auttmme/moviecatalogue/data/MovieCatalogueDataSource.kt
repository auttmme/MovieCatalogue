package com.auttmme.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovieById(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
}