package com.auttmme.moviecatalogue.core.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie

class FavoriteViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovieFavorite(): LiveData<List<Movie>> {
        return movieCatalogueRepository.getFavoriteMovies()
    }

    fun getTvShowFavorite(): LiveData<PagedList<TvShowEntity>> {
        return movieCatalogueRepository.getFavoriteTvShow()
    }

    fun setMovieFavorite(movieEntity: Movie) {
        val newState = !movieEntity.movieFavorited
        movieCatalogueRepository.setMovieFavorite(movieEntity, newState)
    }

    fun setTvShowFavorite(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.tvFavorited
        movieCatalogueRepository.setTvShowFavorite(tvShowEntity, newState)
    }
}