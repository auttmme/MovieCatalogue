package com.auttmme.moviecatalogue.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.databinding.FragmentMovieBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private lateinit var viewModel: MovieViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMovieBinding = FragmentMovieBinding.bind(view)
        setupViewModel()
        setupRecyclerView()
        observe()
        fetchAllMovies()
    }

    private fun fetchAllMovies(){
        setLoading(true)
        viewModel.fetchAllMovies()
    }

    private fun setupViewModel(){
        val factory = ViewModelFactory.getInstance(requireActivity().applicationContext)
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
    }

    private fun setupRecyclerView(){
        fragmentMovieBinding?.rvMovie?.apply{
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = MovieAdapter()
        }
    }

    private fun observe(){
        viewModel.getMovies().observe(viewLifecycleOwner, { handleMoviesChange(it) })
    }

    private fun setLoading(isShow: Boolean){
        if(isShow){
            fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE
        }else{
            fragmentMovieBinding?.progressBar?.visibility = View.GONE
        }
    }

    private fun handleMoviesChange(movies: List<MovieEntity>){
        fragmentMovieBinding?.rvMovie?.adapter?.let { adapter ->
            if(adapter is MovieAdapter){
                adapter.setMovie(movies)
                adapter.notifyDataSetChanged()
                setLoading(false)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieBinding = null
    }
}