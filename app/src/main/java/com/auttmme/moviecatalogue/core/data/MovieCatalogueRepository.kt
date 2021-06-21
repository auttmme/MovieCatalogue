package com.auttmme.moviecatalogue.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.source.local.LocalDataSource
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.data.source.remote.Network.ApiResponse
import com.auttmme.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.core.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.utils.AppExecutors
import com.auttmme.moviecatalogue.core.utils.DataMapper
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.TvShow

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors) :
    MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> {
                return Transformations.map(localDataSource.getAllMovies()) {
                    DataMapper.mapMovieEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapMovieResponseToEntities(data)
//                for (response in data) {
//                    val movie = MovieEntity(response.movieId,
//                            response.movieTitle,
//                            response.movieDesc,
//                            response.movieYear,
//                            response.moviePoster,
//                            response.movieGenre,
//                            response.movieDuration,
//                            false)
//
//                    movieList.add(movie)
//                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()

    override fun getMovieById(movieId: Int): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<Movie> =
                localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: Movie?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovieById(movieId)

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(response.movieId,
                        response.movieTitle,
                        response.movieDesc,
                        response.movieYear,
                        response.moviePoster,
                        response.movieGenre,
                        response.movieDuration,
                        false)

                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShow>>> {
        return object : NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShow>> {
                return Transformations.map(localDataSource.getAllTvShows()) {
                    DataMapper.mapTvEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvList = DataMapper.mapTvResponseToEntities(data)
//                for (response in data) {
//                    val tvShow = TvShowEntity(response.tvId,
//                        response.tvTitle,
//                        response.tvDesc,
//                        response.tvYear,
//                        response.tvPoster,
//                        response.tvSeason,
//                        response.tvEpisode,
//                        response.tvGenre,
//                        false)
//
//                    tvList.add(tvShow)
//                }
                localDataSource.insertTvShows(tvList)
            }
        }.asLiveData()
    }

    override fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShow>> {
        return object : NetworkBoundResource<TvShow, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShow> =
                localDataSource.getTvShowById(tvShowId)

            override fun shouldFetch(data: TvShow?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getTvShowById(tvShowId)

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(response.tvId,
                        response.tvTitle,
                        response.tvDesc,
                        response.tvYear,
                        response.tvPoster,
                        response.tvSeason,
                        response.tvEpisode,
                        response.tvGenre,
                        false)

                    tvList.add(tvShow)
                }
                localDataSource.insertTvShows(tvList)
            }

        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<List<Movie>> {
        return Transformations.map(localDataSource.getFavoriteMovies()) {
            DataMapper.mapMovieEntitiesToDomain(it)
        }
    }

    override fun getFavoriteTvShow(): LiveData<List<TvShow>> {
        return Transformations.map(localDataSource.getFavoriteTvShows()) {
            DataMapper.mapTvEntitiesToDomain(it)
        }
    }

    override fun setMovieFavorite(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapMovieDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movieEntity, state) }
    }


    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) {
        val tvEntity = DataMapper.mapTvDomainToEntity(tvShow)
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvEntity, state) }
    }
}