package com.auttmme.moviecatalogue.data.source

import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.utils.OnArrayResponse
import com.auttmme.moviecatalogue.utils.OnSingleResponse

class MovieCatalogueRepository (private val rds: RemoteDataSource) : MovieCatalogueDataSource {
    override fun getAllMovies(listener: OnArrayResponse<MovieEntity>) {
        rds.getMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(response.movieId,
                        response.movieTitle,
                        response.movieDesc,
                        response.movieYear,
                        response.moviePoster,
                        response.movieGenre,
                        response.movieDuration)

                    movieList.add(movie)
                }
                listener.onSuccess(movieList)
            }
        })
    }

    override fun getAllTvShows(listener: OnArrayResponse<TvShowEntity>) {
        rds.getTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                val tvList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val tvShow = TvShowEntity(response.tvId,
                        response.tvTitle,
                        response.tvDesc,
                        response.tvYear,
                        response.tvPoster,
                        response.tvSeason,
                        response.tvEpisode,
                        response.tvGenre)

                    tvList.add(tvShow)
                }
                listener.onSuccess(tvList)
            }
        })
    }

    override fun getMovieById(movieId: Int, listener: OnSingleResponse<MovieEntity>) {
        rds.getMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                val movieFound = movieResponse.find { m -> m.movieId == movieId }
                movieFound?.let { m ->
                    movie = MovieEntity(
                        m.movieId,
                        m.movieTitle,
                        m.movieDesc,
                        m.movieYear,
                        m.moviePoster,
                        m.movieGenre,
                        m.movieDuration)
                    listener.onSuccess(movie)
                } ?: listener.onFailure(Error("Data not found"))
             }
        })
    }

    override fun getTvShowById(tvShowId: Int, listener: OnSingleResponse<TvShowEntity>) {
        rds.getTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                val tvShowFound = tvShowResponse.find { t -> t.tvId == tvShowId }
                tvShowFound?.let { t ->
                    tvShow = TvShowEntity(
                        t.tvId,
                        t.tvTitle,
                        t.tvDesc,
                        t.tvYear,
                        t.tvPoster,
                        t.tvSeason,
                        t.tvEpisode,
                        t.tvGenre)
                    listener.onSuccess(tvShow)
                } ?: listener.onFailure(Error("Data not found"))

            }
        })
    }

}