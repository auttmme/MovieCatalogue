package com.auttmme.moviecatalogue.core.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
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
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovieFavorite() {
        val dummyMovies = moviePagedList
        `when`(dummyMovies.size).thenReturn(14)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        `when`(movieCatalogueRepository.getFavoriteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovieFavorite().value
        verify(movieCatalogueRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(14, movieEntities?.size)

        viewModel.getMovieFavorite().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowFavorite() {
        val dummyTvShows = tvPagedList
        `when`(dummyTvShows.size).thenReturn(12)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getFavoriteTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShowFavorite().value
        verify(movieCatalogueRepository).getFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities?.size)

        viewModel.getTvShowFavorite().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }
}