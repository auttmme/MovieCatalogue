package com.auttmme.moviecatalogue.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.vo.Resource

class FavoriteViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovieFavorite(): LiveData<List<MovieEntity>> {
        return movieCatalogueRepository.getFavoriteMovies()
    }

    fun getTvShowFavorite(): LiveData<List<TvShowEntity>> {
        return movieCatalogueRepository.getFavoriteTvShow()
    }
}