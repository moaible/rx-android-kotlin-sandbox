package module.analytics

import android.content.Context
import android.util.Log
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker

interface GoogleAnalyticsCustomDimension {

    val dimensionIndex: Int

    val dimensionName: String

    val dimensionValue: String
}

interface GoogleAnalyticsSendable {

    var analyticsTracker: Tracker?

    fun analyticsContext(): Context

    fun getDefaultCustomDimensions(): ArrayList<GoogleAnalyticsCustomDimension> {
        return arrayListOf()
    }

    fun getGoogleAnalyticsTracker(): Tracker? {
        val instance = GoogleAnalytics.getInstance(analyticsContext())
        if (analyticsTracker == null) {
            analyticsTracker = instance.newTracker("UA-65603755-1")
        }
        return analyticsTracker
    }

    fun sendEventTracking(
            category: String,
            action: String,
            label: String?,
            customDimensions: ArrayList<GoogleAnalyticsCustomDimension> = arrayListOf())
    {
        val builder = HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label ?: "")
        Log.d("google analytics", "send event tracking: $category - $action - $label")
        val dimensions = customDimensions + getDefaultCustomDimensions()
        dimensions.forEach {
            Log.d("google analytics", "additional dimensions: $it")
            builder.setCustomDimension(it.dimensionIndex, it.dimensionValue)
        }
        getGoogleAnalyticsTracker()?.send(builder.build())
    }

    fun sendScreenTracking(
            screenName: String,
            customDimensions: ArrayList<GoogleAnalyticsCustomDimension> = arrayListOf())
    {
        Log.d("google analytics", "send screen tracking: $screenName")
        val builder = HitBuilders.ScreenViewBuilder()
        val dimensions = customDimensions + getDefaultCustomDimensions()
        dimensions.forEach {
            Log.d("google analytics", "additional dimensions: $it")
            builder.setCustomDimension(it.dimensionIndex, it.dimensionValue)
        }
        getGoogleAnalyticsTracker()?.setScreenName(screenName)
        getGoogleAnalyticsTracker()?.send(builder.build())
    }
}

class GoogleAnalyticsSender(context: Context): GoogleAnalyticsSendable {

    private val mContext = context

    private var mLastSendScreenName = ""

    override fun analyticsContext(): Context {
        return mContext
    }

    override var analyticsTracker: Tracker? = null

    override fun sendScreenTracking(screenName: String, customDimensions: ArrayList<GoogleAnalyticsCustomDimension>) {
        if (mLastSendScreenName == screenName) {
            return
        }
        super.sendScreenTracking(screenName, customDimensions)
        mLastSendScreenName = screenName
    }
}
