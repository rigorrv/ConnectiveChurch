package net.android.connectivechurch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import net.android.connectivechurch.databinding.GroupsFragmentBinding
import net.android.connectivechurch.model.JsonData


class GroupsFragment : Fragment() {

    lateinit var groupsFragment: GroupsFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupsFragment = GroupsFragmentBinding.inflate(inflater, container, false)
        return groupsFragment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (groups in AboutFragment.jsonData) {
            groupsFragment.groups = groups.groups
            Glide.with(this)
                .load(groups.about?.background)
                .into(groupsFragment.imageGroups)
        }
    }
}