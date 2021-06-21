package com.auttmme.moviecatalogue.core.domain.usecase

import androidx.lifecycle.LiveData
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.domain.model.TvShow
import com.auttmme.moviecatalogue.core.domain.repository.IMovieCatalogueRepository

class MovieCatalogueInteractor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getAllMovies(): LiveData<Resource<List<Movie>>> = movieCatalogueRepository.getAllMovies()

    override fun getAllTvShows(): LiveData<Resource<List<TvShow>>> = movieCatalogueRepository.getAllTvShows()

    override fun getMovieById(movieId: Int): LiveData<Resource<Movie>> = movieCatalogueRepository.getMovieById(movieId)

    override fun getTvShowById(tvShowId: Int): LiveData<Resource<TvShow>> = movieCatalogueRepository.getTvShowById(tvShowId)

    override fun getFavoriteMovies(): LiveData<List<Movie>> = movieCatalogueRepository.getFavoriteMovies()

    override fun getFavoriteTvShow(): LiveData<List<TvShow>> = movieCatalogueRepository.getFavoriteTvShow()

    override fun setMovieFavorite(movie: Movie, state: Boolean) = movieCatalogueRepository.setMovieFavorite(movie, state)

    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) = movieCatalogueRepository.setTvShowFavorite(tvShow, state)
}