package moaible.sample.presentation.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.main_fragment.view.*
import moaible.sample.R
import moaible.sample.presentation.base.BaseFragment

class MainFragment : BaseFragment() {

    var age = 0

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
                fragmentManager.popBackStack()
            }
        }

        return root
    }
}
