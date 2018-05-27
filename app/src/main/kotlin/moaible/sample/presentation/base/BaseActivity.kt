package moaible.sample.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.processors.PublishProcessor
import moaible.sample.presentation.App
import java.util.concurrent.TimeUnit


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.addOnBackStackChangedListener {
            val fragments = supportFragmentManager?.fragments ?: arrayListOf()
            (fragments.lastOrNull { it.isVisible } as? BaseFragment)?.getScreenName()?.let {
                App.instance.analyticsSender.sendScreenTracking(it)
            }
        }
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.d("sample", "BaseActivity.onAttachFragment")
        Log.d("sample", fragment.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("sample", "BaseActivity.onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("sample", "BaseActivity.onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("sample", "BaseActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("sample", "BaseActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("sample", "BaseActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("sample", "BaseActivity.onDestroy")
    }
}
