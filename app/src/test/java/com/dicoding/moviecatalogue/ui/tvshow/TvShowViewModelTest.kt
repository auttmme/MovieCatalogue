package com.dicoding.moviecatalogue.ui.tvshow

import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvId

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvId)
        val tvShowEntity = viewModel.getTvShow()
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
        val tvShowEntities = viewModel.getDummyTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities.size)
    }
}