package com.auttmme.moviecatalogue.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auttmme.moviecatalogue.data.source.MovieCatalogueRepository
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.utils.OnArrayResponse

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private val movies = MutableLiveData<List<MovieEntity>>()

    //fetch means get data from source
    fun fetchAllMovies(){
        movieCatalogueRepository.getAllMovies(object : OnArrayResponse<MovieEntity>{
            override fun onSuccess(datas: List<MovieEntity>?) {
                datas?.let {
                    movies.postValue(it)
                }
            }
            override fun onFailure(error: Error) {
                Log.e("MovieViewModel", error.message.toString())
            }
        })
    }

    //get means listen/observe the live data
    fun getMovies() : LiveData<List<MovieEntity>> = movies

}