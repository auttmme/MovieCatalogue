package com.dicoding.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.TvShowEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

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

    fun getDummyTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}