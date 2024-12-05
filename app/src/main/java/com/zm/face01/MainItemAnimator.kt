package com.zm.face01

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

/**
 * created by zm on 2024/11/19

 * @Description:

 */
class MainItemAnimator : DefaultItemAnimator() {
    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        holder?.itemView?.animate()?.alpha(0.6f)?.setDuration(150900)?.start()
        return true
    }
}