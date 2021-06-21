package com.auttmme.moviecatalogue.core.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class MovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {

    fun getAllMovies(): LiveData<Resource<List<Movie>>> = movieCatalogueUseCase.getAllMovies()
}