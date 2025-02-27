package com.amineaytac.widgetexamplewithxml.ui.widget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.amineaytac.widgetexamplewithxml.MainActivity
import com.amineaytac.widgetexamplewithxml.R
import com.amineaytac.widgetexamplewithxml.core.network.source.RestApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SentenceWidgetProvider : AppWidgetProvider() {

    @Inject
    lateinit var restApi: RestApi

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // PendingIntent to add clickability to the button
        val views = RemoteViews(context.packageName, R.layout.widget_layout)

        val intent = Intent(context, SentenceWidgetProvider::class.java)
        intent.action = REFRESH_QUOTE_ACTION

        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // To trigger the action when the button is clicked
        views.setOnClickPendingIntent(R.id.widget_button, pendingIntent)

        // PendingIntent to add clickability to the entire widget
        val openAppIntent =
            Intent(
                context,
                MainActivity::class.java
            )  // Redirection to the main activity of the application
        val openAppPendingIntent = PendingIntent.getActivity(
            context,
            0,
            openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(
            R.id.widget_layout,
            openAppPendingIntent
        ) // Add click function to all widget

        appWidgetManager.updateAppWidget(appWidgetIds, views)

        fetchAffirmationFromApi(context)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (REFRESH_QUOTE_ACTION == intent.action) {
            fetchAffirmationFromApi(context) // When the button is pressed, retrieve data from the API
        }
    }

    private fun fetchAffirmationFromApi(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = restApi.getSentence()
                if (response.isSuccessful) {
                    response.body()?.let { affirmation ->
                        updateWidgetQuote(context, affirmation.affirmation.toString())
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @SuppressLint("RemoteViewLayout")
    private fun updateWidgetQuote(context: Context, quote: String) {
        val views = RemoteViews(context.packageName, R.layout.widget_layout)
        views.setTextViewText(R.id.widget_sentence, quote)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val widgetComponent = ComponentName(context, SentenceWidgetProvider::class.java)
        appWidgetManager.updateAppWidget(widgetComponent, views)
    }

    companion object {
        private const val REFRESH_QUOTE_ACTION =
            "com.amineaytac.widgetexamplewithxml.ui.widget.ACTION_REFRESH_SENTENCE"
    }
}