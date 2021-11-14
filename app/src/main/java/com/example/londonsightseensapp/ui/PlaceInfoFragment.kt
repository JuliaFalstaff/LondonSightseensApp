package com.example.londonsightseensapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.databinding.FragmentPlaceInfoBinding
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.placeinfo.PlaceInfoImpl
import com.example.londonsightseensapp.model.placeinfo.RoomPlaceCacheImpl
import com.example.londonsightseensapp.model.retrofit.RetrofitImpl
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.navigation.AndroidScreens
import com.example.londonsightseensapp.network.AndroidNetworkStatus
import com.example.londonsightseensapp.presenter.PlaceInfoPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.view.PlacesInfoView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class PlaceInfoFragment : MvpAppCompatFragment(), PlacesInfoView, BackButtonListener {

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
        PlaceInfoPresenter(
            arguments?.getParcelable(PLACE),
            PlaceInfoImpl(RetrofitImpl().api, AndroidNetworkStatus(requireContext()), RoomPlaceCacheImpl(
                DataBaseApp.getDatabase(requireContext()))),
            App.instance.router,
            AndroidScreens()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showDescription(description: String) {
        binding?.textViewPlaceDescription?.text = description
    }

    override fun showName(name: String) {
        binding?.textViewPlaceName?.text = name
    }

    override fun showAddress(address: String) {

    }

    override fun showImage(imageUrl: String) {
        requireContext().let {
            binding?.imageViewPlacePicture?.let { imageView ->
                Glide.with(it)
                    .load(imageUrl)
                    .into(imageView)
            }
        }
    }

    override fun showError(error: Throwable) {
        TODO("Not yet implemented")
    }
}