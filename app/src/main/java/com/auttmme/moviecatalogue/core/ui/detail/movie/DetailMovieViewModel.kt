package com.auttmme.moviecatalogue.core.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class DetailMovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    var getMovie: LiveData<Resource<Movie>> = Transformations.switchMap(movieId) { mDetailMovieId ->
        movieCatalogueUseCase.getMovieById(mDetailMovieId)
    }

    fun setFavorite() {
        val movieResource = getMovie.value
        if (movieResource != null) {
            val movieDetail = movieResource.data
            val newState = !movieDetail?.movieFavorited!!
            movieCatalogueUseCase.setMovieFavorite(movieDetail, newState)
        }
    }
}