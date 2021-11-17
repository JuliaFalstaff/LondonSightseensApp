package com.example.londonsightseensapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.londonsightseensapp.databinding.PlaceItemRecyclerBinding
import com.example.londonsightseensapp.utils.convertToReadable
import com.example.londonsightseensapp.view.IPlacesListPresenter
import com.example.londonsightseensapp.view.PlacesItemView


class PlacesRVAdapter(
    val presenter: IPlacesListPresenter
) : RecyclerView.Adapter<PlacesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesRVAdapter.ViewHolder {
        return ViewHolder(
            PlaceItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }
    }

    override fun onBindViewHolder(holder: PlacesRVAdapter.ViewHolder, position: Int) {
        return presenter.bindView(holder.apply {
            positionItem = position
        })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(val binding: PlaceItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root),
        PlacesItemView {

        override var positionItem: Int = -1

        override fun setName(name: String) {
            binding.textViewNameOfPlace.text = name
        }

        override fun setKind(kind: String) {
            kind.convertToReadable(kind).apply {
                binding.textViewKind.text = "kinds: $this"}
        }

        override fun setRate(rate: Int) {
            binding.textViewRate.text = rate.toString()
        }
    }
}