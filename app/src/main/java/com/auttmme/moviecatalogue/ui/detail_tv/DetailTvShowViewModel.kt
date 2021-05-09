package com.auttmme.moviecatalogue.ui.detail_tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.OnSingleResponse

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private val selectedTvShow = MutableLiveData<TvShowEntity>()

    fun fetchSelectedTvShowById(id: Int){
        movieCatalogueRepository.getTvShowById(id, object : OnSingleResponse<TvShowEntity> {
            override fun onSuccess(data: TvShowEntity?) {
                data?.let {
                    selectedTvShow.value = it
                }
            }
            override fun onFailure(error: Error) {
                Log.e("DetailMovieViewModel", error.message.toString())
            }
        })
    }

    fun getSelectedTvShow() : LiveData<TvShowEntity> = selectedTvShow
}