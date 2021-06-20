package com.auttmme.moviecatalogue.core.utils

import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.core.domain.model.Movie

object DataMapper {
    fun mapMovieResponseToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity (
                movieId = it.movieId,
                movieTitle = it.movieTitle,
                movieDesc = it.movieDesc,
                movieYear = it.movieYear,
                moviePoster = it.moviePoster,
                movieGenre = it.movieGenre,
                movieDuration = it.movieDuration,
                movieFavorited = false
                    )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                movieTitle = it.movieTitle,
                movieDesc = it.movieDesc,
                movieYear = it.movieYear,
                moviePoster = it.moviePoster,
                movieGenre = it.movieGenre,
                movieDuration = it.movieDuration,
                movieFavorited = it.movieFavorited
            )
        }

    fun mapMovieDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        movieTitle = input.movieTitle,
        movieDesc = input.movieDesc,
        movieYear = input.movieYear,
        moviePoster = input.moviePoster,
        movieGenre = input.movieGenre,
        movieDuration = input.movieDuration,
        movieFavorited = input.movieFavorited
    )
}