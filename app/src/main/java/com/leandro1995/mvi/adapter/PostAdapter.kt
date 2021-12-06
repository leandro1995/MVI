package com.leandro1995.mvi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.mvi.R
import com.leandro1995.mvi.model.Post

class PostAdapter constructor(private val postList: MutableList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {

        return PostHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {

        holder.apply {

            titleText.text = postList[position].title
            bodyText.text = postList[position].body
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val titleText: TextView = view.findViewById(R.id.titleText)
        val bodyText: TextView = view.findViewById(R.id.bodyText)
    }
}