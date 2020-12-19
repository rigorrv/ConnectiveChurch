package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.giving_webview.*
import net.android.connectivechurch.R

class WebViewFragment : Fragment() {

    lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.giving_webview, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://connective.churchcenter.com/giving"
        val view = webview
        view.settings.javaScriptEnabled = true
        view.loadUrl(url)
    }
}