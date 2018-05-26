package moaible.sample.presentation.screen.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.analytics.Tracker
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.main_fragment.view.*
import moaible.sample.R
import moaible.sample.presentation.App
import moaible.sample.presentation.GoogleAnalyticsSendable
import moaible.sample.presentation.base.BaseFragment

class MainFragment : BaseFragment(), GoogleAnalyticsSendable {

    var age = 0

    override var analyticsTracker: Tracker? = null
    override fun analyticsContext(): Context {
        return this.context
    }

    companion object {
        fun newInstance(text : String): MainFragment {
            var fragment = MainFragment()
            var bundle = Bundle()
            bundle.putString("text_key", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater?.inflate(R.layout.main_fragment, container, false)

        val appIcon = root?.app_icon
        if (appIcon != null) {
            RxView.clicks(appIcon).subscribe {
                sendEventTracking("main", "tap", "appIcon")
                fragmentManager.beginTransaction()
                        .add(R.id.content, MainFragment.newInstance("next"))
                        .addToBackStack("test")
                        .commit()
            }
        }

        val currency = root?.currency
        if (currency != null) {
            currency.text = arguments.getString("text_key")
            RxView.clicks(currency).subscribe {
                sendEventTracking("main", "tap", "currency" + currency.text)
                fragmentManager.popBackStack()
            }
        }

        return root
    }
}
