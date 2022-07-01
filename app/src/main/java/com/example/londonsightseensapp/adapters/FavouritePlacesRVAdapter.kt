package com.example.londonsightseensapp.adapters


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.londonsightseensapp.R
import com.example.londonsightseensapp.databinding.FavPlaceItemRecyclerBinding
import com.example.londonsightseensapp.utils.convertToReadable
import com.example.londonsightseensapp.view.FavPlacesItemView
import com.example.londonsightseensapp.view.IFavouritePlacesListPresenter


class FavouritePlacesRVAdapter(
        val presenter: IFavouritePlacesListPresenter,
) : RecyclerView.Adapter<FavouritePlacesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
    ): FavouritePlacesRVAdapter.ViewHolder {
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

        override fun setDescription(address: String) {
            binding.favPlaceDescription.text = address
        }

        override fun setIcon() {
            binding.favIconImageView.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

        override fun setNoFavIcon() {
            binding.favIconImageView.setImageResource(R.drawable.ic_no_favorite_border)
        }

        override fun showImage(imageUrl: String?) {
            Glide.with(itemView.context)
                    .load(imageUrl)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.ic_load_error_vector)
                    .into(binding.imageViewFavPlace)
        }

        override fun setClickIcon(view: FavPlacesItemView) {
            binding.favIconImageView.setOnClickListener {
                presenter.deleteFromFav(view)
            }
        }
    }
}