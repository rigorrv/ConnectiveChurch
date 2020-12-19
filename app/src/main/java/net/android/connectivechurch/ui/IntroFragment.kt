package net.android.connectivechurch.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import net.android.connectivechurch.R
import net.android.connectivechurch.databinding.IntroFragmentBinding
import java.io.IOException

class IntroFragment : Fragment() {

    lateinit var fragment: IntroFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragment = IntroFragmentBinding.inflate(inflater, container, false)
        fragment.callback = this
        return fragment.root
    }

    @Throws(IllegalAccessException::class, IOException::class)
    fun isConnected(): Boolean {
        val command = "ping -c 1 nonstopcode.com"
        return Runtime.getRuntime().exec(command).waitFor() == 0
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
        if (isConnected()) {
            val uri: Uri = Uri.parse("http://nonstopcode.com/rigo/connectivechurch/video/intro.mp4")
            fragment.videoView.setVideoURI(uri)
            fragment.videoView.requestFocus()
            fragment.videoView.start()
            fragment.videoView.setOnCompletionListener {
                findNavController().navigate(R.id.action_introFragment2_to_mainFragment)
            }
        } else {
            findNavController().navigate(R.id.action_introFragment2_to_mainFragment)
        }
    }
}