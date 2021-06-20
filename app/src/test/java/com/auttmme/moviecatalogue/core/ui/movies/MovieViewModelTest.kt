package com.auttmme.moviecatalogue.core.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getAllMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(14)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getAllMovies().value?.data
        verify(movieCatalogueRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(14, movieEntities?.size)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}