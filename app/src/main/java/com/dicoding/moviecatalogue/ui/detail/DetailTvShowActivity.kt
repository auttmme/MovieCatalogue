package com.dicoding.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.TvShowEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.dicoding.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.dicoding.moviecatalogue.ui.tvshow.TvShowViewModel

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvShow

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TVSHOW, 0)
            viewModel.setSelectedTvShow(tvShowId)
            populateTvShow(viewModel.getTvShow())
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