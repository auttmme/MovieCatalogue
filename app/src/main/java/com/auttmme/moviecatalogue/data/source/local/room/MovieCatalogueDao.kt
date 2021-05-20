package com.auttmme.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where movieFavorited = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tventities")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tventities where tvFavorited = 1")
    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>

    @Transaction
    @Query("SELECT * FROM tventities WHERE tvId = :tvId")
    fun getTvShowById(tvId: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}