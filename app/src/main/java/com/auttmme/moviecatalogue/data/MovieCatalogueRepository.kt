package com.auttmme.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.data.source.local.LocalDataSource
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.data.source.remote.ApiResponse
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.utils.AppExecutors
import com.auttmme.moviecatalogue.vo.Resource

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

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

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

    override fun getMovieById(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
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

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

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

    override fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
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

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
    }
}