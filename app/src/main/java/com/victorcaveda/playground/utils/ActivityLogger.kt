package com.victorcaveda.playground.utils

import androidx.lifecycle.LifecycleOwner

interface ActivityLogger {
    fun registerActivity(name: String, owner: LifecycleOwner)
}