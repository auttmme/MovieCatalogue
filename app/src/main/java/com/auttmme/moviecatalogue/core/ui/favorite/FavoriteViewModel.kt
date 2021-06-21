package com.auttmme.moviecatalogue.core.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.domain.model.TvShow

class FavoriteViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovieFavorite(): LiveData<List<Movie>> {
        return movieCatalogueRepository.getFavoriteMovies()
    }

    fun getTvShowFavorite(): LiveData<List<TvShow>> {
        return movieCatalogueRepository.getFavoriteTvShow()
    }

    fun setMovieFavorite(movie: Movie) {
        val newState = !movie.movieFavorited
        movieCatalogueRepository.setMovieFavorite(movie, newState)
    }

    fun setTvShowFavorite(tvShow: TvShow) {
        val newState = !tvShow.tvFavorited
        movieCatalogueRepository.setTvShowFavorite(tvShow, newState)
    }
}