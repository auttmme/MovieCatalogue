package com.dicoding.moviecatalogue.ui.movies

import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
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
    fun getDummyMovie() {
        val movieEntities = viewModel.getDummyMovie()
        assertNotNull(movieEntities)
        assertEquals(14, movieEntities.size)
    }
}