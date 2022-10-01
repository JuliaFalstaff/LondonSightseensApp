package com.example.londonsightseensapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.ui.adapters.FavouritePlacesRVAdapter
import com.example.londonsightseensapp.databinding.FragmentFavouritePlacesBinding
import com.example.londonsightseensapp.presenter.FavouritePlacesPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.view.IFavouriteView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FavouritePlacesFragment : MvpAppCompatFragment(), IFavouriteView, BackButtonListener {

    companion object {
        fun newInstance(): FavouritePlacesFragment = FavouritePlacesFragment()
    }

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
        Toast.makeText(context, "Error: Check your Internet. ${error.cause?.message}", Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding?.progressBar?.visibility = View.INVISIBLE
    }

    override fun showSuccessDeleteToast() {
        Toast.makeText(context, "Success delete", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorDeleteToast(error: Throwable) {
        Toast.makeText(context, "Error delete", Toast.LENGTH_SHORT).show()
    }

    override fun openTripMap(otm: String) {
        val i = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(otm)
        }
        startActivity(i)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}