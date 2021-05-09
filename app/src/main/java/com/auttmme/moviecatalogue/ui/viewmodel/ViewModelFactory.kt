package com.auttmme.moviecatalogue.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.ui.detail.DetailMovieViewModel
import com.auttmme.moviecatalogue.ui.detail_tv.DetailTvShowViewModel
import com.auttmme.moviecatalogue.ui.di.Injection
import com.auttmme.moviecatalogue.ui.movies.MovieViewModel
import com.auttmme.moviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(
    private val movieRepository: MovieCatalogueRepository
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepo(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepository) as T
            }

            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}