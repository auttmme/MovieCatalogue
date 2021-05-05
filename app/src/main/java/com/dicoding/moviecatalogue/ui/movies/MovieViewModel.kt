package com.dicoding.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.MovieEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    private var movieId: Int = 0

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getDummyMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()
}