package com.auttmme.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.vo.Resource

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieCatalogueRepository.getAllMovies()
}