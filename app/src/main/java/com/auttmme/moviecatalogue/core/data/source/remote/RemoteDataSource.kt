package com.auttmme.moviecatalogue.core.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.auttmme.moviecatalogue.core.data.source.remote.Network.ApiResponse
import com.auttmme.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.core.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.core.utils.EspressoIdlingResource
import com.auttmme.moviecatalogue.core.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
          resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
          EspressoIdlingResource.decrement()
                          }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getMovieById(movieId: Int): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieById = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovieById.value = ApiResponse.success(jsonHelper.loadMovieById(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovieById
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getTvShowById(tvId: Int): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowById = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvShowById.value = ApiResponse.success(jsonHelper.loadTvShowById(tvId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShowById
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsReceived(tvShowResponse: List<TvShowResponse>)
    }
}