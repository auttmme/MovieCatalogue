package com.auttmme.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.auttmme.moviecatalogue.data.source.remote.RemoteDataSource
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auttmme.moviecatalogue.utils.DataDummy
import com.auttmme.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeAcademyRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val tvResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvId = tvResponses[0].tvId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onMoviesReceived(movieResponses)
            null
        }.`when`(remote).getMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovies())
        verify(remote).getMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onMoviesReceived(movieResponses)
            null
        }.`when`(remote).getMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovieById(movieId))
        verify(remote).getMovie(any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.movieTitle)
        assertEquals(movieResponses[0].movieTitle, movieEntities.movieTitle)
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getTvShow(any())
        val tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvShows())
        verify(remote).getTvShow(any())
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getTvShowById() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getTvShow(any())
        val tvEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowById(tvId))
        verify(remote).getTvShow(any())
        assertNotNull(tvEntities)
        assertNotNull(tvEntities.tvTitle)
        assertEquals(tvResponses[0].tvTitle, tvEntities.tvTitle)
    }
}