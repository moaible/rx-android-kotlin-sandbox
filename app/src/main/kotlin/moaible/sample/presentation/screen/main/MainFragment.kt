package moaible.sample.presentation.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moaible.sample.R
import moaible.sample.presentation.base.BaseFragment

class MainFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.main_fragment, container, false)
    }
}
