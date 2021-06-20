package com.auttmme.moviecatalogue.core.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.vo.Resource

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<Resource<List<Movie>>> = movieCatalogueRepository.getAllMovies()
}