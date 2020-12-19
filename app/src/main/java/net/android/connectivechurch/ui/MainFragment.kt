package net.android.connectivechurch.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.ui.adapters.MainViewPager
import net.android.connectivechurch.ui.fragments.*
import net.android.connectivechurch.utility.Connection
import net.android.connectivechurch.viewmodel.MyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

lateinit var rootView: View
var fragmentLocation = 0

class MainFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.main_fragment, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar?.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setLogo(R.drawable.ic_header)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayUseLogoEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myViewModel.jsonLiveData.observe(viewLifecycleOwner, Observer {
            AboutFragment.jsonData = listOf(it)
            VisitFragment.jsonData = listOf(it)
            MessageFragment.jsonData = listOf(it)
            GiveFragment.jsonData = listOf(it)
            GroupsFragment.jsonData = listOf(it)
            CommentsFragment.jsonData = listOf(it)
            ContactFragment.jsonData = listOf(it)
            BelongFragment.jsonData = listOf(it)
            MoreAboutFragment.jsonList = listOf(it)
            MessageFragment.jsonData = listOf(it)
            val adapter = MainViewPager(childFragmentManager, lifecycle)
            rootView.pagerView.adapter = adapter
        })
        myViewModel.commentLiveData.observe(viewLifecycleOwner, Observer {
            CommentsFragment.commentsList = listOf(it)
        })
        checkConnection()
        rootView.connectionBox.setOnClickListener {
            checkConnection()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        fragmentLocation = rootView.pagerView.getCurrentItem()
        when (item.itemId) {
            R.id.nav_belong -> {
                Log.d("TAG", "onOptionsItemSelected: BELONG")
                rootView.pagerView.currentItem = 0

            }
            R.id.nav_about -> {
                Log.d("TAG", "onOptionsItemSelected: ABOUT")
                rootView.pagerView.currentItem = 1

            }
            R.id.nav_visit -> {
                Log.d("TAG", "onOptionsItemSelected: PLAN A VISIT")
                rootView.pagerView.currentItem = 2

            }
            R.id.nav_message -> {
                Log.d("TAG", "onOptionsItemSelected: MESSAGES")
                rootView.pagerView.currentItem = 3

            }
            R.id.nav_giving -> {
                Log.d("TAG", "onOptionsItemSelected: GIVING")
                rootView.pagerView.currentItem = 4

            }
            R.id.nav_groups -> {
                Log.d("TAG", "onOptionsItemSelected: GROUPS")
                rootView.pagerView.currentItem = 5

            }
            R.id.nav_comments -> {
                myViewModel.getComments()
                myViewModel.commentLiveData.observe(viewLifecycleOwner, Observer {
                    //CommentsFragment.commentsList = listOf(it)
                })
                Log.d("TAG", "onOptionsItemSelected: CONTACT")
                rootView.pagerView.currentItem = 6
            }
            R.id.nav_contact -> {
                Log.d("TAG", "onOptionsItemSelected: CONTACT")
                rootView.pagerView.currentItem = 7

            }
            R.id.nav_facebook -> {
                Log.d("TAG", "onOptionsItemSelected: Facebook")

            }
            R.id.nav_instagram -> {
                Log.d("TAG", "onOptionsItemSelected: Instagram")

            }
            else -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun checkConnection() {
        if (!Connection.isConnected())
            rootView.connectionBox.visibility = View.VISIBLE
        else
            rootView.connectionBox.visibility = View.GONE
    }

}

