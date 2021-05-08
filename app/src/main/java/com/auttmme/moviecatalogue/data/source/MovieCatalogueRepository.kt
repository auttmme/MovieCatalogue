package com.auttmme.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    private val _movieResults = MutableLiveData<List<MovieEntity>>()
    private val _movieResultDetail = MutableLiveData<MovieEntity>()

    private val _tvShowResults = MutableLiveData<List<TvShowEntity>>()
    private val _tvShowResultDetail = MutableLiveData<TvShowEntity>()

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults: LiveData<List<MovieEntity>> = _movieResults
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMoviesCallback {
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
                _movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getMovieById(movieId: Int): LiveData<MovieEntity> {
        val movieResult: LiveData<MovieEntity> = _movieResultDetail
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponse) {
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
                _movieResultDetail.postValue(movie)
            }
        })

        return movieResult
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResults: LiveData<List<TvShowEntity>> = _tvShowResults
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowsCallback {
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
                _tvShowResults.postValue(tvList)
            }
        })
        return tvShowResults
    }

    override fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> {
        val tvShowResult: LiveData<TvShowEntity> = _tvShowResultDetail
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowResponse) {
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
                _tvShowResultDetail.postValue(tvShow)
            }
        })

        return tvShowResult
    }
}