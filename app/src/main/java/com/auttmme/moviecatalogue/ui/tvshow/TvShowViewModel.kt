package com.auttmme.moviecatalogue.ui.tvshow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.utils.OnArrayResponse

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    private val tvShows = MutableLiveData<List<TvShowEntity>>()

    fun fetchAllTvShows(){
        movieCatalogueRepository.getAllTvShows(object : OnArrayResponse<TvShowEntity> {
            override fun onSuccess(datas: List<TvShowEntity>?) {
                datas?.let {
                    tvShows.postValue(it)
                }
            }
            override fun onFailure(error: Error) {
                Log.e("TvShowViewModel", error.message.toString())
            }
        })
    }

    //get means listen/observe the live data
    fun getTvShows() : LiveData<List<TvShowEntity>> = tvShows
}