package com.auttmme.moviecatalogue.ui.tvshow

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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvId

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        `when`(movieCatalogueRepository.getTvShowById(tvShowId)).thenReturn(dummyTvShow)
//        viewModel.setSelectedTvShow(dummyTvShow.tvId)
        val tvShowEntity = viewModel.getTvShow()
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
    }

    @Test
    fun getDummyTvShow() {
        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(DataDummy.generateDummyTvShows())
        val tvShowEntities = viewModel.getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities.size)
    }
}