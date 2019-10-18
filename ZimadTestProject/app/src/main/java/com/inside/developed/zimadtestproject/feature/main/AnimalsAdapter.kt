package com.inside.developed.zimadtestproject.feature.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inside.developed.zimadtestproject.R
import com.inside.developed.zimadtestproject.core.base.BaseAdapter
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.CatsDogsModel
import com.inside.developed.zimadtestproject.util.extensions.loadFromUrl
import kotlinx.android.synthetic.main.item_model.view.*

class AnimalsAdapter : BaseAdapter<CatsDogsModel, AnimalsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflate(parent, R.layout.item_model))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run {
            holder.itemView.apply {
                ivAnimalImage.loadFromUrl(url)
                tvAnimalName.text = title
            }
        }
        holder.itemView.setOnClickListener {
            setOnItemClickListener?.invoke(getItem(position))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

