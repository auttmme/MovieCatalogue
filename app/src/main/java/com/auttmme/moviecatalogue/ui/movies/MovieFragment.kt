package com.auttmme.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auttmme.moviecatalogue.databinding.FragmentMovieBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory
import com.auttmme.moviecatalogue.vo.Status

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

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
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            viewModel.getAllMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
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