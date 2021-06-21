package com.auttmme.moviecatalogue.core.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auttmme.moviecatalogue.core.data.Resource
import com.auttmme.moviecatalogue.databinding.FragmentTvshowBinding
import com.auttmme.moviecatalogue.core.ui.viewmodel.ViewModelFactory
import com.auttmme.moviecatalogue.core.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvshowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()
            viewModel.getAllTvShows().observe(viewLifecycleOwner, { tvShows ->
                Log.d("Yeay", tvShows.toString())
                if (tvShows != null) {
                    when (tvShows) {
                        is Resource.Loading -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            tvShowAdapter.setTvShow(tvShows.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvshow) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }
}