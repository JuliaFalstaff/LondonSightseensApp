package com.example.londonsightseensapp.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.londonsightseensapp.databinding.FavPlaceItemRecyclerBinding
import com.example.londonsightseensapp.databinding.PlaceItemRecyclerBinding
import com.example.londonsightseensapp.utils.convertToReadable
import com.example.londonsightseensapp.view.FavPlacesItemView
import com.example.londonsightseensapp.view.IFavouritePlacesListPresenter
import com.example.londonsightseensapp.view.IPlacesListPresenter
import com.example.londonsightseensapp.view.PlacesItemView


class FavouritePlacesRVAdapter(
        val presenter: IFavouritePlacesListPresenter,
) : RecyclerView.Adapter<FavouritePlacesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritePlacesRVAdapter.ViewHolder {
        return ViewHolder(
                FavPlaceItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }
    }

    override fun onBindViewHolder(holder: FavouritePlacesRVAdapter.ViewHolder, position: Int) {
        return presenter.bindView(holder.apply {
            positionItem = position
        })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(val binding: FavPlaceItemRecyclerBinding) :
            RecyclerView.ViewHolder(binding.root),
            FavPlacesItemView {

        override var positionItem: Int = -1

        override fun setName(name: String) {
            binding.textViewNameOfPlace.text = name
        }

        @SuppressLint("SetTextI18n")
        override fun setKind(kind: String) {
            kind.convertToReadable(kind).apply {
                binding.textViewKind.text = "Kinds: $this"
            }
        }

        override fun setAddress(address: String) {
            binding.textViewAddress.text = address
        }
    }
}