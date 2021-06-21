package com.auttmme.moviecatalogue.core.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.TvShow
import com.auttmme.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class TvShowViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {

    fun getAllTvShows(): LiveData<Resource<List<TvShow>>> = movieCatalogueUseCase.getAllTvShows()
}