package net.android.connectivechurch.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.connectivechurch.databinding.VisitFragmentBinding
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.ui.rootView

class VisitFragment : Fragment() {

    lateinit var visitFragmentBinding: VisitFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        visitFragmentBinding = VisitFragmentBinding.inflate(inflater, container, false)
        return visitFragmentBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (visit in jsonData) {
            visitFragmentBinding.visit = visit.visit
            Glide.with(this)
                .load(visit.visit?.background)
                .into(visitFragmentBinding.imageHeadVisit)
            Glide.with(this)
                .load(visit.visit?.image)
                .into(visitFragmentBinding.imagePastor)
            Glide.with(this)
                .load(visit.visit?.btn1)
                .into(visitFragmentBinding.btn1Box7)
            Glide.with(this)
                .load(visit.visit?.btn2)
                .into(visitFragmentBinding.btn2Box7)
            Glide.with(this)
                .load(visit.visit?.btn3)
                .into(visitFragmentBinding.btn3Box7)
            Glide.with(this)
                .load(visit.visit?.btn2)
                .into(visitFragmentBinding.btn1Box8)
            Glide.with(this)
                .load(visit.visit?.btn3)
                .into(visitFragmentBinding.btn2Box8)
            visitFragmentBinding.btn1Box7.setOnClickListener {
                val uri: Uri =
                    Uri.parse(visit.visit?.link1) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            visitFragmentBinding.btn2Box7.setOnClickListener {
                val uri: Uri =
                    Uri.parse(visit.visit?.link2) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            visitFragmentBinding.btn3Box7.setOnClickListener {
                val uri: Uri =
                    Uri.parse(visit.visit?.link3) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            visitFragmentBinding.btn1Box8.setOnClickListener {
                val uri: Uri =
                    Uri.parse(visit.visit?.link4) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            visitFragmentBinding.btn2Box8.setOnClickListener {
                val uri: Uri =
                    Uri.parse(visit.visit?.link5) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            visitFragmentBinding.infoBox9.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val data: Uri = Uri.parse(
                    "mailto:" + visit.contact?.email
                )
                intent.data = data
                startActivity(intent)
            }
            visitFragmentBinding.textView9.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(visit.visit?.linkaddress))
                startActivity(intent)
            }
            visitFragmentBinding.buttonBox5.setOnClickListener {
                rootView.pagerView.currentItem = 1
            }


        }

    }

}