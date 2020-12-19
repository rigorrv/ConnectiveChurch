package net.android.connectivechurch.ui.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.more_items.view.*
import net.android.connectivechurch.R
import net.android.connectivechurch.model.MoreAboutItem

class MoreAdapter : RecyclerView.Adapter<MoreAdapter.ViewHolder>() {

    var moreList: List<MoreAboutItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.more_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreAdapter.ViewHolder, position: Int) {
        holder.onBind(moreList[position])
    }

    override fun getItemCount(): Int {
        return moreList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleMore = itemView.titleMore
        val infoMore = itemView.infoMore
        val line = itemView.lineMore
        fun onBind(moreList: MoreAboutItem) {
            titleMore.text = moreList.title
            infoMore.setText(Html.fromHtml(moreList.info));
            if (titleMore.text.isEmpty()) {
                titleMore.visibility = View.GONE
                line.visibility = View.VISIBLE
            } else {
                titleMore.visibility = View.VISIBLE
                line.visibility = View.GONE
            }

        }


    }

}