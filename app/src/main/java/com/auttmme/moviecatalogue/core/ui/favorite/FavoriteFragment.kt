package com.auttmme.moviecatalogue.core.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.auttmme.moviecatalogue.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
       fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPageAdapter = context?.let { SectionsPageAdapter(it, this.childFragmentManager) }
        fragmentFavoriteBinding.viewPager.adapter = sectionsPageAdapter
        fragmentFavoriteBinding.tabs.setupWithViewPager(fragmentFavoriteBinding.viewPager)
    }
}