package net.android.connectivechurch.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comments_items.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.model.Comment
import net.android.connectivechurch.model.CommentItem
import net.android.connectivechurch.ui.fragments.commentsFragment

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    var commentList: List<CommentItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.comments_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsAdapter.ViewHolder, position: Int) {
        holder.onBind(commentList[position])
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d("TAG", "onViewAttachedToWindow: Loaded")
        commentsFragment.progressBar.visibility = View.GONE

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val commentText = itemView.commentText
        val commentDate = itemView.dateText
        val imageUser = itemView.imageUser

        private var myImageList = intArrayOf(
            R.drawable.icon_0001,
            R.drawable.icon_0002,
            R.drawable.icon_0003,
            R.drawable.icon_0004,
            R.drawable.icon_0005,
            R.drawable.icon_0006,
            R.drawable.icon_0007,
            R.drawable.icon_0008,
            R.drawable.icon_0009
        )


        fun onBind(commentList: CommentItem) {
            commentText.text = commentList.comments
            commentDate.text = commentList.dates
            val randomImg = (0..8).random()
            imageUser.setBackgroundResource(myImageList[randomImg])
        }


    }

}