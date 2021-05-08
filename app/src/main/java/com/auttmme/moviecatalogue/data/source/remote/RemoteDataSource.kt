package com.auttmme.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.utils.EspressoIdlingResource
import com.auttmme.moviecatalogue.utils.JsonHelper

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

    fun getMovie(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
          callback.onMoviesReceived(jsonHelper.loadMovies())
          EspressoIdlingResource.decrement()
                          }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShow(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onTvShowsReceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsReceived(tvShowResponse: List<TvShowResponse>)
    }
}