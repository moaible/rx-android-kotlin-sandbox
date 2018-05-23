package moaible.sample.presentation.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View


open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sample", "BaseFragment.onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("sample", "BaseFragment.onStart")
    }

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
        Log.d("sample", "BaseFragment.onAttachFragment")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("sample", "BaseFragment.onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.d("sample", "BaseFragment.onResume")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("sample", "BaseFragment.onActivityCreated")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("sample", "BaseFragment.onActivityResult")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("sample", "BaseFragment.onAttach")
    }

    override fun onPause() {
        super.onPause()
        Log.d("sample", "BaseFragment.onPause")
    }
}
