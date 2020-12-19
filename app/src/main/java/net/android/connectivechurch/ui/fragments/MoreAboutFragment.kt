package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.databinding.MoreaboutFragmentBinding
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.model.MoreAboutItem
import net.android.connectivechurch.ui.adapters.MoreAdapter
import net.android.connectivechurch.ui.rootView
import net.android.connectivechurch.utility.Connection

class MoreAboutFragment : Fragment() {

    lateinit var moreaboutFragmentBinding: MoreaboutFragmentBinding
    val moreAdapter = MoreAdapter()

    companion object {
        var jsonList: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moreaboutFragmentBinding = MoreaboutFragmentBinding.inflate(inflater, container, false)
        return moreaboutFragmentBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar?.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setLogo(R.drawable.ic_header)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayUseLogoEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)

        for (more in jsonList) {
            moreaboutFragmentBinding.about = more.about
            Glide.with(this)
                .load(more.about?.background)
                .into(moreaboutFragmentBinding.imageAbout)
            moreAdapter.moreList = more.moreabout
            moreaboutFragmentBinding.moreRecycler.adapter = moreAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_moreAboutFragment_to_mainFragment)
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkConnection()
        rootView.connectionBox.setOnClickListener {
            checkConnection()
        }
    }

    fun checkConnection() {
        if (!Connection.isConnected())
            moreaboutFragmentBinding.connectionBox2.visibility = View.VISIBLE
        else
            moreaboutFragmentBinding.connectionBox2.visibility = View.GONE
    }
}