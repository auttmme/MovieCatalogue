package com.auttmme.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Mock
    private lateinit var tvObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShowById() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(movieCatalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value as TvShowEntity
        verify(movieCatalogueRepository).getTvShowById(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvId, tvShowEntity.tvId)
        assertEquals(dummyTvShow.tvTitle, tvShowEntity.tvTitle)
        assertEquals(dummyTvShow.tvDesc, tvShowEntity.tvDesc)
        assertEquals(dummyTvShow.tvYear, tvShowEntity.tvYear)
        assertEquals(dummyTvShow.tvPoster, tvShowEntity.tvPoster)
        assertEquals(dummyTvShow.tvSeason, tvShowEntity.tvSeason)
        assertEquals(dummyTvShow.tvEpisode, tvShowEntity.tvEpisode)
        assertEquals(dummyTvShow.tvGenre, tvShowEntity.tvGenre)

        viewModel.getTvShow().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTvShow)
    }

    @Test
    fun getAllTvShows() {
        val dummyTvShows = DataDummy.generateDummyTvShows()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getAllTvShows().value
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities?.size)

        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}