package net.android.connectivechurch.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.ui.fragments.*
import net.android.connectivechurch.ui.fragments.AboutFragment

class MainViewPager(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    val items = 8

    override fun getItemCount(): Int {
        return items
    }



    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BelongFragment()
            }
            1 -> {
                AboutFragment()
            }
            2 -> {
                VisitFragment()
            }
            3 -> {
                MessageFragment()
            }
            4 -> {
                GiveFragment()
            }
            5 -> {
                GroupsFragment()
            }
            6 -> {
                CommentsFragment()
            }
            7 -> {
                ContactFragment()
            }
            else -> {
                BelongFragment()
            }
        }
    }
}