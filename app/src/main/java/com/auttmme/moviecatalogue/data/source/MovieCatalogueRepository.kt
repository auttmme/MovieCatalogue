package com.auttmme.moviecatalogue.data.source

import com.auttmme.moviecatalogue.data.MovieEntity
import com.auttmme.moviecatalogue.data.TvShowEntity
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getMovie()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(response.movieId,
            response.movieTitle,
            response.movieDesc,
            response.movieYear,
            response.moviePoster,
            response.movieGenre,
            response.movieDuration)

            movieList.add(movie)
        }
        return movieList
    }

    override fun getMovieById(movieId: Int): MovieEntity {
        val movieResponses = remoteDataSource.getMovie()
        lateinit var movie: MovieEntity
        for (response in movieResponses) {
            if (response.movieId == movieId) {
                movie = MovieEntity(response.movieId,
                response.movieTitle,
                response.movieDesc,
                response.movieYear,
                response.moviePoster,
                response.movieGenre,
                response.movieDuration)
            }
        }
        return movie
    }

    override fun getAllTvShows(): List<TvShowEntity> {
        val tvShowResponses = remoteDataSource.getTvShow()
        val tvList = ArrayList<TvShowEntity>()
        for (response in tvShowResponses) {
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

        return tvList
    }

    override fun getTvShowById(tvShowId: Int): TvShowEntity {
        val tvShowResponses = remoteDataSource.getTvShow()
        lateinit var tvShow: TvShowEntity
        for (response in tvShowResponses) {
            if (response.tvId == tvShowId) {
                tvShow = TvShowEntity(response.tvId,
                response.tvTitle,
                response.tvDesc,
                response.tvYear,
                response.tvPoster,
                response.tvSeason,
                response.tvEpisode,
                response.tvGenre)
            }
        }
        return tvShow
    }
}