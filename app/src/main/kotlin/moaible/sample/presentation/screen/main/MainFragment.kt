package moaible.sample.presentation.screen.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.main_fragment.view.*
import moaible.sample.R
import moaible.sample.presentation.App
import moaible.sample.presentation.base.BaseFragment

class MainFragment : BaseFragment() {

    var age = 0

    companion object {
        fun newInstance(text: String, age: Int = 0): MainFragment {
            var fragment = MainFragment()
            var bundle = Bundle()
            bundle.putString("text_key", text)
            bundle.putInt("age", age + 1)
            fragment.arguments = bundle
            fragment.age = age + 1
            return fragment
        }
    }

    override fun getScreenName(): String? {
        return "next - " + arguments.getInt("age").toString()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater?.inflate(R.layout.main_fragment, container, false)
        val appIcon = root?.app_icon
        if (appIcon != null) {
            RxView.clicks(appIcon).subscribe {
                App.instance.analyticsSender.sendEventTracking("main", "tap", "appIcon")
                fragmentManager.beginTransaction()
                        .add(R.id.content, MainFragment.newInstance("next - " + arguments.getInt("age").toString(), age))
                        .addToBackStack("next - " + arguments.getInt("age").toString())
                        .commit()
            }
        }

        val currency = root?.currency
        if (currency != null) {
            currency.text = arguments.getString("text_key")
            RxView.clicks(currency).subscribe {
                App.instance.analyticsSender.sendEventTracking("main", "tap", "currency" + currency.text)
                fragmentManager.popBackStack()
            }
        }

        return root
    }
}
