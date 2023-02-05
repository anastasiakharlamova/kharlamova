package com.example.fintech2023kharlamova.app

import android.app.Application
import com.example.fintech2023kharlamova.di.AppComponent
import com.example.fintech2023kharlamova.di.DaggerAppComponent

class FintechApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }
}