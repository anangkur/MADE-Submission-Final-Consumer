package com.anangkur.madesubmission2.feature.custom

import com.anangkur.madesubmission2.widget.StackRemoteViewsFactory
import android.content.Intent
import android.widget.RemoteViewsService


class StackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return StackRemoteViewsFactory(this.applicationContext)
    }
}