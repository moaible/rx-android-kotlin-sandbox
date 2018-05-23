package moaible.sample.presentation.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import moaible.sample.R


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sample", "BaseActivity.onCreate")
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
