package com.example.londonsightseensapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.R
import com.example.londonsightseensapp.databinding.FragmentPlaceInfoBinding
import com.example.londonsightseensapp.model.dataDTO.places.Feature
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
    private var isFavourite = false

    val presenter by moxyPresenter {
        PlaceInfoPresenter(arguments?.getParcelable(PLACE)).apply {
            App.instance.appComponent.inject(
                    this
            )
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPlaceInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showDescription(description: String) {
        binding?.includeBottomSheetLayout?.bottomSheetDescription?.text = description
    }

    override fun showName(name: String?) {
        binding?.textViewPlaceName?.text = name
        binding?.includeBottomSheetLayout?.bottomSheetDescriptionHeader?.text = name
    }

    override fun showCity(city: String?) {
        binding?.textViewCity?.text = city
    }

    override fun showImage(imageUrl: String?) {
        requireContext().let {
            binding?.imageViewPlacePicture?.let { imageView ->
                Glide.with(it)
                        .load(imageUrl)
                        .placeholder(R.drawable.progress_animation)
                        .error(R.drawable.ic_load_error_vector)
                        .into(imageView)
            }
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, "Error: Check your Internet. ${error.cause?.message}", Toast.LENGTH_LONG).show()
        binding?.iconToOpenTripMapSite?.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding?.infoProgressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding?.infoProgressBar?.visibility = View.INVISIBLE
    }

    override fun clickToFavouriteIcon() {
        binding?.includeBottomSheetLayout?.addToFavImageView?.setOnClickListener {
            if (!isFavourite) {
                presenter.addNewPlaceToFavourite()
                setFavIcon()
            } else {
                presenter.deletePlaceFromFavourite()
                setNotFavIcon()
            }
        }
    }

    override fun showSuccessSaveToast() {
        Toast.makeText(requireContext(), "Add To Favourite", Toast.LENGTH_SHORT).show()
        binding?.includeBottomSheetLayout?.addToFavImageView?.setImageResource(R.drawable.ic_baseline_favorite_24)
    }

    override fun showErrorSavingFav(error: Throwable) {
        Toast.makeText(requireContext(), "Error Add To Favourite: ${error.message}", Toast.LENGTH_SHORT).show()
    }

    override fun setFavIcon() {
        binding?.includeBottomSheetLayout?.addToFavImageView?.setImageResource(R.drawable.ic_baseline_favorite_24)
        isFavourite = true
    }

    override fun setNotFavIcon() {
        binding?.includeBottomSheetLayout?.addToFavImageView?.setImageResource(R.drawable.ic_no_favorite_border)
        isFavourite = false
    }

    override fun showSuccessDeleteToast() {
        Toast.makeText(requireContext(), "Success Delete From Favourite", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorDeleteToast(error: Throwable) {
        Toast.makeText(requireContext(), "Error Delete From Favourite: ${error.message}", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    override fun showState(state: String?) {
        binding?.textViewState?.text = "State: $state"
    }

    @SuppressLint("SetTextI18n")
    override fun showRoad(road: String?) {
        binding?.textViewRoad?.text = "Road: $road"
    }

    @SuppressLint("SetTextI18n")
    override fun showSuburb(suburb: String?) {
        binding?.textViewSuburb?.text = "Suburb: $suburb"
    }

    override fun showRating(rate: String?) {
        binding?.textViewRate?.text = rate
    }

    override fun openTripMap(url: String?) {
        binding?.iconToOpenTripMapSite?.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(i)
        }
    }
}