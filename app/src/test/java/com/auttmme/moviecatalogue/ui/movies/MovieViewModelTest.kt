package com.auttmme.moviecatalogue.ui.movies

import com.auttmme.moviecatalogue.data.MovieEntity
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        `when`(movieCatalogueRepository.getMovieById(movieId)).thenReturn(dummyMovie)
//        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        verify(movieCatalogueRepository).getMovieById(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.movieTitle, movieEntity.movieTitle)
        assertEquals(dummyMovie.movieDesc, movieEntity.movieDesc)
        assertEquals(dummyMovie.movieYear, movieEntity.movieYear)
        assertEquals(dummyMovie.moviePoster, movieEntity.moviePoster)
        assertEquals(dummyMovie.movieGenre, movieEntity.movieGenre)
        assertEquals(dummyMovie.movieDuration, movieEntity.movieDuration)
    }

    @Test
    fun getAllMovies() {
        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies() as ArrayList<MovieEntity>)
        val movieEntities = viewModel.getAllMovies()
        verify<MovieCatalogueRepository>(movieCatalogueRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(14, movieEntities.size)
    }
}