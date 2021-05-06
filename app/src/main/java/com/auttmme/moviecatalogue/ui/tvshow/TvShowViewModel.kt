package com.auttmme.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.TvShowEntity
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.utils.DataDummy

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    private var tvShowId: Int = 0

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.tvId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

    fun getAllTvShows(): List<TvShowEntity> = movieCatalogueRepository.getAllTvShows()
}