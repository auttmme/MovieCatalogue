package com.auttmme.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.databinding.ItemTvshowBinding
import com.auttmme.moviecatalogue.ui.detail_tv.DetailTvShowActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(tvShows: List<TvShowEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowAdapter.TvShowViewHolder {
        val itemTvShowBinding = ItemTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    inner class TvShowViewHolder(private val binding: ItemTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTvshowTitle.text = tvShow.tvTitle
                tvTvshowYear.text = tvShow.tvYear.toString()
                tvTvshowGenre.text = tvShow.tvGenre
                tvTvshowSeason.text = tvShow.tvSeason.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.tvId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.tvPoster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgTvshowPoster)
            }
        }

    }

}