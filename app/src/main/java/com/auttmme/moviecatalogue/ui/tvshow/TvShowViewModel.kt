package com.auttmme.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.vo.Resource

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = movieCatalogueRepository.getAllTvShows()
}