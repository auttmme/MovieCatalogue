package com.auttmme.moviecatalogue.core.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.domain.model.TvShow
import com.auttmme.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class FavoriteViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {

    fun getMovieFavorite(): LiveData<List<Movie>> {
        return movieCatalogueUseCase.getFavoriteMovies()
    }

    fun getTvShowFavorite(): LiveData<List<TvShow>> {
        return movieCatalogueUseCase.getFavoriteTvShow()
    }

    fun setMovieFavorite(movie: Movie) {
        val newState = !movie.movieFavorited
        movieCatalogueUseCase.setMovieFavorite(movie, newState)
    }

    fun setTvShowFavorite(tvShow: TvShow) {
        val newState = !tvShow.tvFavorited
        movieCatalogueUseCase.setTvShowFavorite(tvShow, newState)
    }
}