package com.auttmme.moviecatalogue.core.ui.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.auttmme.moviecatalogue.databinding.ContentDetailMovieBinding
import com.auttmme.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import com.auttmme.moviecatalogue.core.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    private var menu: Menu? = null

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailMovie

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            viewModel.setSelectedMovie(movieId)


            viewModel.getMovie.observe(this, { movieResource ->
                if (movieResource != null) {
//                    when (movieResource) {
//                        is mov -> activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
//                        Status.SUCCESS -> if (movieResource.data != null) {
//                            activityDetailMovieBinding.progressBar.visibility = View.GONE
//                            populateMovie(movieResource.data)
//                        }
//                        Status.ERROR -> {
//                            activityDetailMovieBinding.progressBar.visibility = View.GONE
//                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
//                        }
//                    }
                    movieResource.data?.let { populateMovie(it) }
                }
            })
        }
    }

    private fun populateMovie(movie: Movie) {
        supportActionBar?.title = movie.movieTitle
        detailMovieBinding.textMovieTitle.text = movie.movieTitle
        detailMovieBinding.textMovieYear.text = movie.movieYear.toString()
        detailMovieBinding.textMovieGenre.text = movie.movieGenre
        detailMovieBinding.textMovieDuration.text = movie.movieDuration
        detailMovieBinding.textMovieDesc.text = movie.movieDesc

        Glide.with(this)
            .load(movie.moviePoster)
            .transform(RoundedCorners(25))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailMovieBinding.imageMoviePoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getMovie.observe(this, { movie ->
            if (movie != null) {
                    if (movie.data != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        val state = movie.data.movieFavorited
                        setFavoriteState(state)
                    }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_full_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }
}