package com.auttmme.moviecatalogue.core.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auttmme.moviecatalogue.databinding.FragmentMovieBinding
import com.auttmme.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.core.vo.Status

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            movieViewModel.getAllMovies().observe(viewLifecycleOwner, { movies ->
                Log.d("bismillah", movies.toString())
                if (movies != null) {
                    when (movies) {
                        is Resource.Loading -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.setMovie(movies.data)
//                            movieAdapter.submitList(movies.data)
                        }
                        is Resource.Error -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentMovieBinding.rvMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }
}