package com.kl3jvi.iquiitask.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kl3jvi.iquiitask.databinding.GridItemBinding
import com.kl3jvi.iquiitask.model.entities.Children

class CustomGridItemAdapter(
    private val fragment: Fragment
) : RecyclerView.Adapter<CustomGridItemAdapter.ViewHolder>() {

    private var imageUrls: List<Children> = listOf()

    inner class ViewHolder(view: GridItemBinding) : RecyclerView.ViewHolder(view.root) {
        val title = view.textView
        val image = view.ivRedditImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GridItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = imageUrls[position]
        Glide.with(fragment)
            .load(url.data.url)
            .into(holder.image)
        holder.title.text = url.data.title
    }

    override fun getItemCount() = imageUrls.size

    fun imageList(list: List<Children>) {
        imageUrls = list
        notifyDataSetChanged()
    }
}