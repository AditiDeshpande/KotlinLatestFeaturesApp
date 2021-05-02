package com.example.kotlinlatestfeaturesapp.DI

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
Container for Hilt where we will be having all out hilt dependencies
and from here it will be provided to complete app
 */
@HiltAndroidApp
class BaseApp : Application() {
}