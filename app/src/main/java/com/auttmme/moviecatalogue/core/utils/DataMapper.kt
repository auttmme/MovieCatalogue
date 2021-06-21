package com.auttmme.moviecatalogue.core.utils

import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.core.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.domain.model.TvShow

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

    fun mapTvResponseToEntities(input: List<TvShowResponse>): List<TvShowEntity> {
        val tvList = ArrayList<TvShowEntity>()
        input.map {
            val tvShow = TvShowEntity (
                tvId = it.tvId,
                tvTitle = it.tvTitle,
                tvDesc = it.tvDesc,
                tvYear = it.tvYear,
                tvPoster = it.tvPoster,
                tvSeason = it.tvSeason,
                tvEpisode = it.tvEpisode,
                tvGenre = it.tvGenre,
                tvFavorited = false
                    )
            tvList.add(tvShow)
        }
        return tvList
    }

    fun mapTvEntitiesToDomain(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                tvId = it.tvId,
                tvTitle = it.tvTitle,
                tvDesc = it.tvDesc,
                tvYear = it.tvYear,
                tvPoster = it.tvPoster,
                tvSeason = it.tvSeason,
                tvEpisode = it.tvEpisode,
                tvGenre = it.tvGenre,
                tvFavorited = it.tvFavorited
            )
        }

    fun mapTvDomainToEntity(input: TvShow) = TvShowEntity(
        tvId = input.tvId,
        tvTitle = input.tvTitle,
        tvDesc = input.tvDesc,
        tvYear = input.tvYear,
        tvPoster = input.tvPoster,
        tvSeason = input.tvSeason,
        tvEpisode = input.tvEpisode,
        tvGenre = input.tvGenre,
        tvFavorited = input.tvFavorited
    )
}