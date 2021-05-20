package com.auttmme.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getMovies()

    fun getMovieById(movieId: Int): LiveData<MovieEntity> = mMovieCatalogueDao.getMovieById(movieId)

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getFavoriteMovie()

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.movieFavorited = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvShows()

    fun getTvShowById(tvId: Int): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShowById(tvId)

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getFavoriteTvShow()

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShows(tvShows)

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.tvFavorited = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }
}