package net.android.connectivechurch.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import net.android.connectivechurch.databinding.BelongFragmentBinding
import net.android.connectivechurch.model.JsonData

class BelongFragment : Fragment() {

    lateinit var belongFragment: BelongFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        belongFragment = BelongFragmentBinding.inflate(inflater, container, false)
        return belongFragment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (belong in AboutFragment.jsonData) {
            belongFragment.belong = belong.belong
            Glide.with(this)
                .load(belong.belong?.background)
                .into(belongFragment.imageBelong)
            Glide.with(this)
                .load(belong.belong?.backgroundbox)
                .into(belongFragment.imageBox3)
            Glide.with(this)
                .load(belong.belong?.btn1)
                .into(belongFragment.btn1Box4)
            Glide.with(this)
                .load(belong.belong?.btn2)
                .into(belongFragment.btn2Box4)
            belongFragment.btn1Box4.setOnClickListener {
                val uri: Uri =
                    Uri.parse(belong.belong?.link1) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            belongFragment.btn2Box4.setOnClickListener {
                val uri: Uri =
                    Uri.parse(belong.belong?.link2) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            belongFragment.info2Box2.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(belong.belong?.linkaddress))
                startActivity(intent)

            }
        }
    }
}