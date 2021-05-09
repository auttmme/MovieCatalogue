package com.auttmme.moviecatalogue.ui.detail_tv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        observe()
        fetchTvShowById()
    }

    private fun setupViewModel(){
        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]
    }

    private fun fetchTvShowById(){
        val extras = intent.extras
        if (extras != null) {
            setLoading(true)
            val tvShowId = extras.getInt(EXTRA_TV_SHOW, 0)
            viewModel.fetchSelectedTvShowById(tvShowId)
        }
    }

    private fun setLoading(isShow: Boolean){
        if(isShow){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun observe(){
        viewModel.getSelectedTvShow().observe(this, { populateTvShow(it) })
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        setLoading(false)
        with(binding.detailTvShow){
            textTvTitle.text = tvShowEntity.tvTitle
            textTvYear.text = tvShowEntity.tvYear.toString()
            textTvGenre.text = tvShowEntity.tvGenre
            textTvSeason.text = tvShowEntity.tvSeason.toString()
            textTvEpisode.text = tvShowEntity.tvEpisode.toString()
            textTvDesc.text = tvShowEntity.tvDesc

            Glide.with(this@DetailTvShowActivity)
                .load(tvShowEntity.tvPoster)
                .transform(RoundedCorners(25))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imageTvPoster)
        }

    }
}