package com.auttmme.moviecatalogue.ui.detail.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.auttmme.moviecatalogue.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var tvObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(movieCatalogueRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value as TvShowEntity
        Mockito.verify(movieCatalogueRepository).getTvShowById(tvShowId)
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
        Mockito.verify(tvObserver).onChanged(dummyTvShow)
    }
}