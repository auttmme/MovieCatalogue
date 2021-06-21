package com.auttmme.moviecatalogue.core.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.TvShow

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getAllTvShows(): LiveData<Resource<List<TvShow>>> = movieCatalogueRepository.getAllTvShows()
}