package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import net.android.connectivechurch.databinding.MessagesFragmentBinding
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.model.Video
import net.android.connectivechurch.model.VideoItem
import net.android.connectivechurch.ui.adapters.VideoAdapter

class MessageFragment : Fragment() {

    lateinit var messageFragment: MessagesFragmentBinding
    val videoAdapter = VideoAdapter()

    companion object {
        var jsonData: List<JsonData> = mutableListOf()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        messageFragment = MessagesFragmentBinding.inflate(inflater, container, false)
        return messageFragment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (message in jsonData) {
            messageFragment.message = message.message
            Glide.with(this)
                .load(message.message?.background)
                .into(messageFragment.imageMessage)
            Glide.with(this)
                .load(message.message?.btn1)
                .into(messageFragment.btn1Box3)
            Glide.with(this)
                .load(message.message?.btn2)
                .into(messageFragment.btn2Box3)
            Glide.with(this)
                .load(message.message?.btn3)
                .into(messageFragment.btn3Box3)
            messageFragment.recyclerViewMessage.layoutManager = GridLayoutManager(context, 2)
            videoAdapter.videoItems = message.video
            messageFragment.recyclerViewMessage.adapter = videoAdapter
        }
    }
}