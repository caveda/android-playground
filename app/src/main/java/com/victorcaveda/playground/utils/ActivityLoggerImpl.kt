package com.victorcaveda.playground.utils

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class ActivityLoggerImpl : ActivityLogger, LifecycleEventObserver {

    companion object {
        private const val TAG = "ActivityLogger"
    }

    private var activityName: String = "unknown"

    override fun registerActivity(name: String, owner: LifecycleOwner) {
        activityName = name
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> Log.d(
                TAG,
                "User enters the screen $activityName"
            )
            Lifecycle.Event.ON_PAUSE -> Log.d(
                TAG,
                "User leaves the the screen $activityName"
            )
            else -> Unit
        }
    }
}