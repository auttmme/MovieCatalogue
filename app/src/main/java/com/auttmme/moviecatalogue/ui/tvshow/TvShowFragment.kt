package com.auttmme.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auttmme.moviecatalogue.R
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.databinding.FragmentTvshowBinding
import com.auttmme.moviecatalogue.ui.viewmodel.ViewModelFactory

class TvShowFragment : Fragment(R.layout.fragment_tvshow) {

    //it can be null when fragment destroyed. we need to re-assign it,
    //avoid double view inflating
    private var fragmentTvShowBinding: FragmentTvshowBinding? = null
    private lateinit var viewModel: TvShowViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTvShowBinding = FragmentTvshowBinding.bind(view)
        setupViewModel()
        setupRecyclerView()
        observe()
        fetchTvShows()
    }

    private fun fetchTvShows(){
        setLoading(true)
        viewModel.fetchAllTvShows()
    }

    private fun setLoading(isShow: Boolean){
        if(isShow){
            fragmentTvShowBinding?.progressBar?.visibility = View.VISIBLE
        }else{
            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
        }
    }

    //it will be great if one function should do one thing only
    //if it too big, you can separate with other function
    private fun setupViewModel(){
        val factory = ViewModelFactory.getInstance(requireActivity().applicationContext)
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
    }

    //observe should be called once, no need to call this again
    private fun observe(){
        viewModel.getTvShows().observe(viewLifecycleOwner, { handleTvShowsChange(it) })
    }

    private fun setupRecyclerView(){
        fragmentTvShowBinding?.rvTvshow?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = TvShowAdapter()
        }
    }

    private fun handleTvShowsChange(tvShows: List<TvShowEntity>){
        fragmentTvShowBinding?.rvTvshow?.adapter?.let { adapter ->
            if(adapter is TvShowAdapter){
                adapter.setTvShow(tvShows)
                adapter.notifyDataSetChanged()
                setLoading(false)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentTvShowBinding = null
    }

}