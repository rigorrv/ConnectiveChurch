package net.android.connectivechurch.ui.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import net.android.connectivechurch.databinding.CommentsFragmentBinding
import net.android.connectivechurch.model.Comment
import net.android.connectivechurch.model.CommentItem
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.ui.adapters.CommentsAdapter
import net.android.connectivechurch.utility.Connection
import net.android.connectivechurch.viewmodel.MyViewModel
import org.koin.android.viewmodel.ext.android.viewModel


lateinit var commentsFragment: CommentsFragmentBinding

class CommentsFragment : Fragment() {

    val commentAdapter = CommentsAdapter()

    val myViewModel: MyViewModel by viewModel()

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
        var commentsList: List<Comment> = mutableListOf()

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        commentsFragment = CommentsFragmentBinding.inflate(inflater, container, false)
        return commentsFragment.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (!Connection.isConnected())
            commentsFragment.commentsText.visibility = View.GONE
        for (comments in AboutFragment.jsonData) {
            commentsFragment.coments = comments.comments
            Glide.with(this)
                .load(comments.comments?.background)
                .into(commentsFragment.imageComments)
        }

        myViewModel.commentLiveData.observe(viewLifecycleOwner, Observer {
            commentAdapter.commentList = it.comment
            commentsFragment.recyclerViewComments.adapter = commentAdapter
        })

        commentsFragment.commentsText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                myViewModel.putComment(commentsFragment.commentsText.text.toString())
                myViewModel.commentLiveData.observe(viewLifecycleOwner, Observer {
                    //commentAdapter.commentList = it
                    commentsFragment.recyclerViewComments.adapter = commentAdapter
                })
                commentsFragment.commentsText.setText("")

                commentsFragment.commentsText.clearFocus()
                val `in`: InputMethodManager =
                    requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                `in`.hideSoftInputFromWindow(commentsFragment.commentsText.getWindowToken(), 0)

                true
            } else false
        })
    }
}