package com.kl3jvi.iquiitask.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kl3jvi.iquiitask.R
import com.kl3jvi.iquiitask.databinding.GridItemBinding
import com.kl3jvi.iquiitask.model.entities.Children
import com.kl3jvi.iquiitask.model.entities.FavoriteImage
import com.kl3jvi.iquiitask.view.fragments.GalleryFragment
import com.maxkeppeler.sheets.options.Option
import com.maxkeppeler.sheets.options.OptionsSheet
import com.stfalcon.imageviewer.StfalconImageViewer


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
            .applyDefaultRequestOptions(
                RequestOptions()
                    .placeholder(com.kl3jvi.iquiitask.R.drawable.ic_baseline_image_not_supported_24)
                    .error(com.kl3jvi.iquiitask.R.drawable.ic_baseline_image_not_supported_24)
            )
            .load(url.data.url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.image)

        holder.image.setOnClickListener {
            val sheet = fragment?.context?.let { it ->
                OptionsSheet().build(it) {
                    with(
                        Option(R.drawable.ic_gallery, "View Image"),
                        Option(R.drawable.ic_favorite, "Save Image")
                    )
                    onPositive { index: Int, _: Option ->
                        when (index) {
                            0 -> {
                                val imageViewer =
                                    StfalconImageViewer.Builder(
                                        fragment.context,
                                        imageUrls
                                    ) { view, image ->
                                        Glide.with(view.context)
                                            .applyDefaultRequestOptions(
                                                RequestOptions()
                                                    .placeholder(com.kl3jvi.iquiitask.R.drawable.ic_baseline_image_not_supported_24)
                                                    .error(com.kl3jvi.iquiitask.R.drawable.ic_baseline_image_not_supported_24)
                                            )
                                            .load(image.data.url)
                                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                                            .into(view)
                                    }
                                imageViewer.withStartPosition(position)
                                imageViewer.show()
                            }
                            1 -> {
                                if (fragment is GalleryFragment) {
                                    fragment.saveThisImage(
                                        FavoriteImage(
                                            title = url.data.title,
                                            imageUrl = url.data.url,
                                            favorite = true
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
            sheet?.show()


        }


        holder.title.text = url.data.title
    }


    override fun getItemCount() = imageUrls.size

    fun imageList(list: List<Children>) {
        imageUrls = list
        notifyDataSetChanged()
    }
}