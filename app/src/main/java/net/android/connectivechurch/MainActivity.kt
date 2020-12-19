package net.android.connectivechurch

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.connectivechurch.ui.MainFragment
import net.android.connectivechurch.ui.fragmentLocation
import net.android.connectivechurch.ui.rootView
import net.android.connectivechurch.viewmodel.MyViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (fragmentLocation == 10) {
            super.onBackPressed()
            fragmentLocation = 0
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        rootView.pagerView.currentItem = fragmentLocation

    }
}