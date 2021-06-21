package com.auttmme.moviecatalogue.core.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase
import com.auttmme.moviecatalogue.core.ui.detail.movie.DetailMovieViewModel
import com.auttmme.moviecatalogue.core.ui.detail.tvShow.DetailTvShowViewModel
import com.auttmme.moviecatalogue.core.ui.di.Injection
import com.auttmme.moviecatalogue.core.ui.favorite.FavoriteViewModel
import com.auttmme.moviecatalogue.core.ui.movies.MovieViewModel
import com.auttmme.moviecatalogue.core.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideMovieCatalogueUseCase(context)).apply { instance = this }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(movieCatalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}