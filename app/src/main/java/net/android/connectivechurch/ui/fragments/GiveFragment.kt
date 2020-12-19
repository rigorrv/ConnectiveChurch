package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import net.android.connectivechurch.R
import net.android.connectivechurch.databinding.GivingFragmentBinding
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.ui.fragmentLocation


class GiveFragment : Fragment() {

    lateinit var giveFragment: GivingFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        giveFragment = GivingFragmentBinding.inflate(inflater, container, false)
        return giveFragment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (give in AboutFragment.jsonData) {
            giveFragment.give = give.giving
            Glide.with(this)
                .load(give.giving?.background)
                .into(giveFragment.imageGiving)
        }
        giveFragment.buttonBox2.setOnClickListener {
            fragmentLocation = 10
            findNavController().navigate(R.id.action_mainFragment_to_webViewFragment)
        }
    }
}