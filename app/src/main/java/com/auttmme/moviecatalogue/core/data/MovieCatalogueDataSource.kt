package com.auttmme.moviecatalogue.core.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<Movie>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovieById(movieId: Int): LiveData<Resource<Movie>>

    fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovies(): LiveData<List<Movie>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setMovieFavorite(movie: Movie, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
}