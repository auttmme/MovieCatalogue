package com.auttmme.moviecatalogue.core.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.ui.detail.movie.DetailMovieViewModel
import com.auttmme.moviecatalogue.core.ui.detail.tvShow.DetailTvShowViewModel
import com.auttmme.moviecatalogue.core.ui.di.Injection
import com.auttmme.moviecatalogue.core.ui.favorite.FavoriteViewModel
import com.auttmme.moviecatalogue.core.ui.movies.MovieViewModel
import com.auttmme.moviecatalogue.core.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieCatalogueRepository: MovieCatalogueRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(mMovieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}