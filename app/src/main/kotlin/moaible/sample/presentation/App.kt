/**
 * Copyright 2017 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package moaible.sample.presentation

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.gms.analytics.Tracker
import module.analytics.GoogleAnalyticsSendable

class App : Application(), GoogleAnalyticsSendable {

    companion object {
        private var sInstance: App? = null
        val instance: App
            get() = sInstance!!
    }

    override var analyticsTracker: Tracker? = null
    override fun analyticsContext(): Context {
        return this
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Log.d("sample", "App.onCreate")
        registerActivityLifecycleCallbacks(AppLifecycleCallbacks())
    }
}

private class AppLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityCreated")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityStarted")
//        activity?.let{
//            if(it is BaseActivity){
//
//            }
//        }
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
        Log.d("sample", "AppLifecycleCallbacks.onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d("sample", "AppLifecycleCallbacks.onActivityDestroyed")
    }
}
