package com.dicoding.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.MovieEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.moviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.moviecatalogue.ui.movies.MovieViewModel

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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            viewModel.setSelectedMovie(movieId)
            populateMovie(viewModel.getMovie())
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