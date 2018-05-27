package moaible.sample.presentation.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import io.reactivex.processors.PublishProcessor
import moaible.sample.presentation.App

open class BaseFragment : Fragment() {

    open fun getScreenName(): String? {
        return null
    }

    private var onDisplaySubject = PublishProcessor.create<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sample", "BaseFragment.onCreate: " + this.getScreenName())
    }

    override fun onStart() {
        super.onStart()
        Log.d("sample", "BaseFragment.onStart: " + this.getScreenName())
    }

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
        Log.d("sample", "BaseFragment.onAttachFragment: " + this.getScreenName())
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("sample", "BaseFragment.onViewCreated: " + this.getScreenName())
    }

    override fun onResume() {
        super.onResume()
        Log.d("sample", "BaseFragment.onResume: " + this.getScreenName())
        getScreenName()?.let {
            App.instance.analyticsSender.sendScreenTracking(it)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("sample", "BaseFragment.onActivityCreated: " + this.getScreenName())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("sample", "BaseFragment.onActivityResult: " + this.getScreenName())
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("sample", "BaseFragment.onAttach: " + this.getScreenName())
    }

    override fun onPause() {
        super.onPause()
        Log.d("sample", "BaseFragment.onPause: " + this.getScreenName())
    }
}
