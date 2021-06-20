package com.auttmme.moviecatalogue.core.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.core.domain.model.Movie
import com.auttmme.moviecatalogue.core.ui.detail.movie.DetailMovieActivity
import com.auttmme.moviecatalogue.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<Movie>()

    fun setMovie(movies: List<Movie>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
        notifyDataSetChanged()
    }

//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
//            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
//                return oldItem.movieId == newItem.movieId
//            }
//
//            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvMovieTitle.text = movie.movieTitle
                tvMovieYear.text = movie.movieYear.toString()
                tvMovieGenre.text = movie.movieGenre
                tvMovieDuration.text = movie.movieDuration
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(movie.moviePoster)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgMoviePoster)
            }
        }
    }

//    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)
}