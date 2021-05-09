package com.auttmme.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailMovieBinding: ActivityDetailMovieBinding
    private lateinit var viewModel : DetailMovieViewModel

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)
        setSupportActionBar(detailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewModel()
        observe()
        fetchMovieDetail()

    }

    private fun observe(){
        viewModel.getSelectedMovie().observe(this, { populateMovie(it) })
    }

    private fun setLoading(isShow: Boolean){
        if(isShow){
            detailMovieBinding.progressBar.visibility = View.VISIBLE
        }else{
            detailMovieBinding.progressBar.visibility = View.GONE
        }
    }

    private fun fetchMovieDetail(){
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            setLoading(true)
            viewModel.fetchSelectedMovieById(movieId)
        }
    }

    private fun setupViewModel(){
        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        setLoading(false)
        with(detailMovieBinding.detailMovie){
            textMovieTitle.text = movieEntity.movieTitle
            textMovieYear.text = movieEntity.movieYear.toString()
            textMovieGenre.text = movieEntity.movieGenre
            textMovieDuration.text = movieEntity.movieDuration
            textMovieDesc.text = movieEntity.movieDesc

            Glide.with(this@DetailMovieActivity)
                .load(movieEntity.moviePoster)
                .transform(RoundedCorners(25))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imageMoviePoster)
        }
    }
}