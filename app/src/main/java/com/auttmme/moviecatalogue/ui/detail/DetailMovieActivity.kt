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
import com.auttmme.moviecatalogue.databinding.ContentDetailMovieBinding
import com.auttmme.moviecatalogue.ui.movies.MovieViewModel
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailMovieBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailMovie

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)

            activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.setSelectedMovie(movieId)
            viewModel.getMovie().observe(this, { movie ->
                activityDetailMovieBinding.progressBar.visibility = View.GONE
                populateMovie(movie)
            })
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailMovieBinding.textMovieTitle.text = movieEntity.movieTitle
        detailMovieBinding.textMovieYear.text = movieEntity.movieYear.toString()
        detailMovieBinding.textMovieGenre.text = movieEntity.movieGenre
        detailMovieBinding.textMovieDuration.text = movieEntity.movieDuration
        detailMovieBinding.textMovieDesc.text = movieEntity.movieDesc

        Glide.with(this)
            .load(movieEntity.moviePoster)
            .transform(RoundedCorners(25))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailMovieBinding.imageMoviePoster)
    }
}