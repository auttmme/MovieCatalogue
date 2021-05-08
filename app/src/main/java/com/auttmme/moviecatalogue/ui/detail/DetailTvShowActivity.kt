package com.auttmme.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.auttmme.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.auttmme.moviecatalogue.ui.tvshow.TvShowViewModel
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvShow

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW, 0)

            activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.setSelectedTvShow(tvShowId)
            viewModel.getTvShow().observe(this, { tvShow ->
                activityDetailTvShowBinding.progressBar.visibility = View.GONE
                populateTvShow(tvShow)
            })
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailTvShowBinding.textTvTitle.text = tvShowEntity.tvTitle
        detailTvShowBinding.textTvYear.text = tvShowEntity.tvYear.toString()
        detailTvShowBinding.textTvGenre.text = tvShowEntity.tvGenre
        detailTvShowBinding.textTvSeason.text = tvShowEntity.tvSeason.toString()
        detailTvShowBinding.textTvEpisode.text = tvShowEntity.tvEpisode.toString()
        detailTvShowBinding.textTvDesc.text = tvShowEntity.tvDesc

        Glide.with(this)
            .load(tvShowEntity.tvPoster)
            .transform(RoundedCorners(25))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailTvShowBinding.imageTvPoster)
    }
}