package net.android.connectivechurch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.video_items.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.model.VideoItem
import net.android.connectivechurch.ui.fragmentLocation
import net.android.connectivechurch.ui.fragments.VideoFragment

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    var videoItems: List<VideoItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.video_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.ViewHolder, position: Int) {
        holder.onBind(videoItems[position])
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoTitle = itemView.titleVideo
        val imageVideo = itemView.imageVideo
        fun onBind(videoList: VideoItem) {
            videoTitle.text = videoList.title
            Glide.with(itemView)
                .load(videoList.image)
                .into(imageVideo)
            itemView.setOnClickListener {
                VideoFragment.videoUrl = videoList.video
                fragmentLocation = 10
                findNavController(itemView)
                    .navigate(R.id.action_mainFragment_to_videoFragment)
            }
        }


    }

}