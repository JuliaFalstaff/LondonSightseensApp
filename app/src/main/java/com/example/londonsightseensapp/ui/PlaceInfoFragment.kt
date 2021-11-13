package com.example.londonsightseensapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.databinding.FragmentPlaceInfoBinding
import com.example.londonsightseensapp.model.data.placeinfo.Place
import com.example.londonsightseensapp.model.data.places.Feature
import com.example.londonsightseensapp.model.placeinfo.IPlaceInfo
import com.example.londonsightseensapp.model.placeinfo.PlaceInfoImpl
import com.example.londonsightseensapp.model.places.PlacesRepoImpl
import com.example.londonsightseensapp.model.retrofit.RetrofitImpl
import com.example.londonsightseensapp.navigation.AndroidScreens
import com.example.londonsightseensapp.presenter.PlaceInfoPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.view.PlacesInfoView
import io.reactivex.rxjava3.core.Single
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class PlaceInfoFragment: MvpAppCompatFragment(), PlacesInfoView, BackButtonListener {

        companion object {
        const val PLACE = "Place"
        fun newInstance(placeId: Feature): PlaceInfoFragment {
            val args = Bundle().apply { putParcelable(PLACE, placeId) }
            val fragment = PlaceInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var binding: FragmentPlaceInfoBinding? = null

    val presenter by moxyPresenter {
        PlaceInfoPresenter(arguments?.getParcelable(PLACE), PlaceInfoImpl(RetrofitImpl().api), App.instance.router, AndroidScreens())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }



    override fun backPressed(): Boolean {
        TODO("Not yet implemented")
    }

    override fun showDescription(description: String) {
        binding?.textViewPlaceDescription?.text = description
    }

    override fun showName(name: String) {
        binding?.textViewPlaceName?.text = name
    }

    override fun showAddress(address: String) {
        TODO("Not yet implemented")
    }

    override fun showImage(imageUrl: String) {
        TODO("Not yet implemented")
    }

    override fun showError(error: Throwable) {
        TODO("Not yet implemented")
    }
}