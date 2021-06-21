package com.auttmme.moviecatalogue.core.ui.detail.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.core.data.MovieCatalogueRepository
import com.auttmme.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.domain.model.TvShow

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId.value = tvShowId
    }

    var getTvShow: LiveData<Resource<TvShow>> = Transformations.switchMap(tvShowId) { mDetailTvId ->
        movieCatalogueRepository.getTvShowById(mDetailTvId)
    }

    fun setFavorite() {
        val tvShowResource = getTvShow.value
        if (tvShowResource != null) {
            val tvShowDetail = tvShowResource.data
            val newState = !tvShowDetail?.tvFavorited!!
            movieCatalogueRepository.setTvShowFavorite(tvShowDetail, newState)
        }
    }
}