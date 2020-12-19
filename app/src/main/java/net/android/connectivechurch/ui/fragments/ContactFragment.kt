package net.android.connectivechurch.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import net.android.connectivechurch.databinding.ContactFragmentBinding
import net.android.connectivechurch.model.JsonData

class ContactFragment : Fragment() {

    lateinit var contactFragment: ContactFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactFragment = ContactFragmentBinding.inflate(inflater, container, false)
        return contactFragment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (contact in AboutFragment.jsonData) {
            contactFragment.contact = contact.contact
            Glide.with(this)
                .load(contact.contact?.background)
                .into(contactFragment.imageContact)
            Glide.with(this)
                .load(contact.contact?.phoneicon)
                .into(contactFragment.phoneIcon)
            Glide.with(this)
                .load(contact.contact?.emailicon)
                .into(contactFragment.emailIcon)
            Glide.with(this)
                .load(contact.contact?.btn1)
                .into(contactFragment.btn1Box3)
            Glide.with(this)
                .load(contact.contact?.btn2)
                .into(contactFragment.btn2Box3)
            Glide.with(this)
                .load(contact.contact?.btn3)
                .into(contactFragment.btn3Box3)

            contactFragment.emailText.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                val data: Uri = Uri.parse(
                    "mailto:" + contact.contact?.email
                )
                intent.data = data
                startActivity(intent)
            }
            contactFragment.phoneText.setOnClickListener {
                val number = contact.contact?.phone
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$number")
                startActivity(intent)
            }
            contactFragment.infoBox2.setOnClickListener {
                val uri = "https://www.google.com.mx/maps/place/22424+S+Ellsworth+Loop+%232106,+Queen+Creek,+AZ+85142,+USA/@33.2447316,-111.6407854,17z/data=!3m1!4b1!4m5!3m4!1s0x872a4d15a32b0949:0xb492bd241fb533a3!8m2!3d33.2447271!4d-111.6385967"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(intent)
            }
            contactFragment.btn1Box3.setOnClickListener {
                val uri: Uri =
                    Uri.parse(contact.contact?.link1) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            contactFragment.btn2Box3.setOnClickListener {
                val uri: Uri =
                    Uri.parse(contact.contact?.link2) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            contactFragment.btn3Box3.setOnClickListener {
                val uri: Uri =
                    Uri.parse(contact.contact?.link3) // missing 'http://' will cause crashed
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }
}