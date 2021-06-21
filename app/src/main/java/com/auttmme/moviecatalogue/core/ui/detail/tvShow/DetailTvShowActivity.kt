package com.auttmme.moviecatalogue.core.ui.detail.tvShow

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.core.domain.model.TvShow
import com.auttmme.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.auttmme.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.auttmme.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    private var menu: Menu? = null

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvShow

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW, 0)
            viewModel.setSelectedTvShow(tvShowId)

            viewModel.getTvShow.observe(this, { tvShowResource ->
                if (tvShowResource != null) {
//                    when(tvShowResource.status) {
//                        Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
//                        Status.SUCCESS -> if (tvShowResource.data != null) {
//                            activityDetailTvShowBinding.progressBar.visibility = View.GONE
//                            populateTvShow(tvShowResource.data)
//                        }
//                        Status.ERROR -> {
//                            activityDetailTvShowBinding.progressBar.visibility = View.GONE
//                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
//                        }
//                    }
                    tvShowResource.data?.let { populateTvShow(it) }
                }
            })
        }
    }

    private fun populateTvShow(tvShow: TvShow) {
        supportActionBar?.title = tvShow.tvTitle
        detailTvShowBinding.textTvTitle.text = tvShow.tvTitle
        detailTvShowBinding.textTvYear.text = tvShow.tvYear.toString()
        detailTvShowBinding.textTvGenre.text = tvShow.tvGenre
        detailTvShowBinding.textTvSeason.text = tvShow.tvSeason.toString()
        detailTvShowBinding.textTvEpisode.text = tvShow.tvEpisode.toString()
        detailTvShowBinding.textTvDesc.text = tvShow.tvDesc

        Glide.with(this)
            .load(tvShow.tvPoster)
            .transform(RoundedCorners(25))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailTvShowBinding.imageTvPoster)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getTvShow.observe(this, { tvShow ->
            if (tvShow != null) {
                if (tvShow.data != null) {
                        activityDetailTvShowBinding.progressBar.visibility = View.GONE
                        val state = tvShow.data.tvFavorited
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