package moaible.sample.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sample", "BaseActivity.onCreate")
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
