package com.auttmme.moviecatalogue.ui.detail.tvShow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.auttmme.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory
import com.auttmme.moviecatalogue.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

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

            viewModel.getTvShow.observe(this, { tvShow ->
                if (tvShow != null) {
                    when(tvShow.status) {
                        Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (tvShow.data != null) {
                            activityDetailTvShowBinding.progressBar.visibility = View.GONE
                            populateTvShow(tvShow.data)
                        }
                        Status.ERROR -> {
                            activityDetailTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
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