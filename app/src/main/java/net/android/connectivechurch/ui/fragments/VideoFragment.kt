package net.android.connectivechurch.ui.fragments

import android.content.Context
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.MediaController;
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.video_fragment.*
import kotlinx.android.synthetic.main.video_fragment.view.*
import net.android.connectivechurch.R

class VideoFragment : Fragment() {

    companion object {
        var videoUrl: String? = null
    }


    lateinit var viewRoot: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewRoot = inflater.inflate(R.layout.video_fragment, container, false)
        var mediaController = MediaController(requireActivity())
        mediaController.setAnchorView(videoPlayer)
        viewRoot.videoPlayer.setMediaController(mediaController)
        return viewRoot
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
        getActivity()?.setRequestedOrientation(
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        )
        Log.d("TAG", "onViewCreated: ${videoUrl}")
        val uri: Uri = Uri.parse(videoUrl)
        viewRoot.videoPlayer.setVideoURI(uri)
        viewRoot.videoPlayer.requestFocus()
        viewRoot.videoPlayer.start()
    }


}