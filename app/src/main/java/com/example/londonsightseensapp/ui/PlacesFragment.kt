package com.example.londonsightseensapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.adapters.PlacesRVAdapter
import com.example.londonsightseensapp.databinding.FragmentPlacesBinding
import com.example.londonsightseensapp.model.places.PlacesRepoImpl
import com.example.londonsightseensapp.model.places.RoomFeatureCacheImpl
import com.example.londonsightseensapp.model.retrofit.RetrofitImpl
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.navigation.AndroidScreens
import com.example.londonsightseensapp.network.AndroidNetworkStatus
import com.example.londonsightseensapp.presenter.PlacesPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.utils.GlideImageLoader
import com.example.londonsightseensapp.view.PlacesView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class PlacesFragment : MvpAppCompatFragment(), PlacesView, BackButtonListener {

    companion object {
        fun newInstance(): PlacesFragment = PlacesFragment()
    }

    private var binding: FragmentPlacesBinding? = null
    private var adapter: PlacesRVAdapter? = null

    val presenter by moxyPresenter {
        PlacesPresenter(
            PlacesRepoImpl(
                RetrofitImpl().api,
                AndroidNetworkStatus(requireContext()),
                RoomFeatureCacheImpl(DataBaseApp.getDatabase(requireContext()))
            ), App.instance.router, AndroidScreens()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlacesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        binding?.run {
            adapter = PlacesRVAdapter(presenter.placesListPresenter)
            this.recyclerViewPlace.adapter = adapter
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, error.stackTraceToString(), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}