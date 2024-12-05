package com.zm.face01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zm.face01.databinding.MainItemLayout2Binding
import com.zm.face01.databinding.MainItemLayoutBinding

/**
 * created by zm on 2024/11/19

 * @Description:

 */
class MainAdapter(val context: Context, val list: List<String>) :
    RecyclerView.Adapter<ViewHolder>() {

    class MainViewHolder(val binding: MainItemLayoutBinding) : ViewHolder(binding.root)
    class MainViewHolder2(val binding: MainItemLayout2Binding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            0 -> {
                return MainViewHolder(MainItemLayoutBinding.inflate(LayoutInflater.from(context)))

            }

            else -> {
                return MainViewHolder2(MainItemLayout2Binding.inflate(LayoutInflater.from(context)))

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position].contains("6"))
            return 1
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is MainViewHolder -> {
                with(holder.binding) {
                    tvName.text = list[position]

                }
            }

            is MainViewHolder2 -> {
                with(holder.binding) {
                    tvName.text = list[position]

                }
            }
        }

    }

    fun removeItem(i: Int) {
        notifyItemRemoved(i)

    }
}