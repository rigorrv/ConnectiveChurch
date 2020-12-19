package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.databinding.AboutFragmentBinding
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.ui.fragmentLocation
import net.android.connectivechurch.ui.rootView


class AboutFragment() : Fragment() {

    lateinit var aboutFragmentBinding: AboutFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutFragmentBinding = AboutFragmentBinding.inflate(inflater, container, false)
        return aboutFragmentBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (about in jsonData) {
            aboutFragmentBinding.about = about.about
            Glide.with(this)
                .load(about.about?.background)
                .into(aboutFragmentBinding.imageAbout)
        }



        aboutFragmentBinding.buttonBox4.setOnClickListener {
            rootView.pagerView.currentItem = 2
        }
        aboutFragmentBinding.button1Box6.setOnClickListener {
            MoreAboutFragment.jsonList = jsonData
            fragmentLocation = 10
            findNavController().navigate(R.id.action_mainFragment_to_moreAboutFragment)
        }
    }
}