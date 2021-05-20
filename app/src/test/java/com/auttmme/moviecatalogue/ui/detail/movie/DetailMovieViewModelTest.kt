package com.auttmme.moviecatalogue.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.utils.DataDummy
import com.auttmme.moviecatalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }

//    @Test
//    fun getMovie() {
//        val movie = MutableLiveData<MovieEntity>()
//        movie.value = dummyMovie
//
//        Mockito.`when`(movieCatalogueRepository.getMovieById(movieId)).thenReturn(movie)
//        val movieEntity = viewModel.getMovie().value as MovieEntity
//        Mockito.verify(movieCatalogueRepository).getMovieById(movieId)
//        assertNotNull(movieEntity)
//        assertEquals(dummyMovie.movieId, movieEntity.movieId)
//        assertEquals(dummyMovie.movieTitle, movieEntity.movieTitle)
//        assertEquals(dummyMovie.movieDesc, movieEntity.movieDesc)
//        assertEquals(dummyMovie.movieYear, movieEntity.movieYear)
//        assertEquals(dummyMovie.moviePoster, movieEntity.moviePoster)
//        assertEquals(dummyMovie.movieGenre, movieEntity.movieGenre)
//        assertEquals(dummyMovie.movieDuration, movieEntity.movieDuration)
//
//        viewModel.getMovie().observeForever(movieObserver)
//        Mockito.verify(movieObserver).onChanged(dummyMovie)
//
//    }

    @Test
    fun getDetailMovie() {
        val dummyDetailMovie = Resource.success(DataDummy.generateDummyDetailMovie(dummyMovie, true))
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        `when`(movieCatalogueRepository.getMovieById(movieId)).thenReturn(movie)
        viewModel.getMovie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetailMovie)
    }

}