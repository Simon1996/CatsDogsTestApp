package com.inside.developed.zimadtestproject.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    private val items: MutableList<M> = ArrayList()

    var setOnItemClickListener: ((M) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    protected fun inflate(parent: ViewGroup, @LayoutRes layoutRes: Int) =
            LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)

    fun add(item: M) {
        this.items.add(item)
        notifyItemInserted(items.size - 1)
    }

    private fun add(items: Collection<M>) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size, items.size)
    }

    fun item(position: Int): M = this.items[position]

    fun items(): MutableList<M> = this.items

    fun previous(position: Int): Boolean {
        return position - 1 >= 0
    }

    fun next(position: Int): Boolean {
        return position + 1 < itemCount
    }

    fun replace(items: Collection<M>) {
        this.items.clear()
        notifyDataSetChanged()
        add(items)
    }

    fun remove(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(item: M) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    fun clear() {
        items.clear()
        notifyItemRangeRemoved(0, items.size)
    }

    fun isEmpty(): Boolean = this.items.isEmpty()

    open fun getItem(position: Int) = this.items[position]

    protected fun onItemClickListener(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener {
            setOnItemClickListener?.invoke(items[holder.adapterPosition])
        }
    }
}