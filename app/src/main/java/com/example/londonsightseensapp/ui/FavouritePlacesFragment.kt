package com.example.londonsightseensapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.R
import com.example.londonsightseensapp.adapters.FavouritePlacesRVAdapter
import com.example.londonsightseensapp.databinding.FragmentFavouritePlacesBinding
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.presenter.FavouritePlacesPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.view.IFavouriteView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class FavouritePlacesFragment : MvpAppCompatFragment(), IFavouriteView, BackButtonListener {

    companion object {
        fun newInstance(): FavouritePlacesFragment = FavouritePlacesFragment()
        private const val TAG = "TAG"
    }

    @Inject
    lateinit var dataBase: DataBaseApp

    private var binding: FragmentFavouritePlacesBinding? = null
    private var adapter: FavouritePlacesRVAdapter? = null

    val presenter by moxyPresenter {
        FavouritePlacesPresenter().apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFavouritePlacesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun init() {
        binding?.run {
            adapter = FavouritePlacesRVAdapter(presenter.favPlacesListPresenter)
            this.recyclerViewPlace.adapter = adapter
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, getString(R.string.place_info_error), Toast.LENGTH_SHORT).show()
        Log.e(TAG, error.printStackTrace().toString())
    }

    override fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding?.progressBar?.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}