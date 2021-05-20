package com.auttmme.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.DataDummy
import com.auttmme.moviecatalogue.vo.Resource
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp() {
    viewModel = TvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getAllTvShows() {
        val dummyTvShows = Resource.success(DataDummy.generateDummyTvShows())
        val tvShows = MutableLiveData<Resource<List<TvShowEntity>>>()
        tvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getAllTvShows().value?.data
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities?.size)

        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}