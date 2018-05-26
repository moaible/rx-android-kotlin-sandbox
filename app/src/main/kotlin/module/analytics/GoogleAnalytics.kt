package module.analytics

import android.content.Context
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
        val dimensions = customDimensions
        dimensions.forEach {
            builder.setCustomDimension(it.dimensionIndex, it.dimensionValue)
        }
        getGoogleAnalyticsTracker()?.send(builder.build())
    }

    fun sendScreenTracking(
            screenName: String,
            customDimensions: ArrayList<GoogleAnalyticsCustomDimension>)
    {
        val builder = HitBuilders.ScreenViewBuilder()
        val dimensions = customDimensions
        dimensions.forEach {
            builder.setCustomDimension(it.dimensionIndex, it.dimensionValue)
        }
        getGoogleAnalyticsTracker()?.setScreenName(screenName)
        getGoogleAnalyticsTracker()?.send(builder.build())
    }
}
