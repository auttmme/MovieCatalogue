package com.auttmme.moviecatalogue.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.utils.OnSingleResponse

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private val selectedMovie = MutableLiveData<MovieEntity>()

    fun fetchSelectedMovieById(id: Int){
        movieCatalogueRepository.getMovieById(id, object : OnSingleResponse<MovieEntity>{
            override fun onSuccess(data: MovieEntity?) {
                data?.let {
                    selectedMovie.value = it
                }
            }
            override fun onFailure(error: Error) {
                Log.e("DetailMovieViewModel", error.message.toString())
            }
        })
    }

    fun getSelectedMovie() : LiveData<MovieEntity> = selectedMovie
}