package com.auttmme.moviecatalogue.core.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.data.Resource

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    var getMovie: LiveData<Resource<Movie>> = Transformations.switchMap(movieId) { mDetailMovieId ->
        movieCatalogueRepository.getMovieById(mDetailMovieId)
    }

    fun setFavorite() {
        val movieResource = getMovie.value
        if (movieResource != null) {
            val movieDetail = movieResource.data
            val newState = !movieDetail?.movieFavorited!!
            movieCatalogueRepository.setMovieFavorite(movieDetail, newState)
        }
    }
}