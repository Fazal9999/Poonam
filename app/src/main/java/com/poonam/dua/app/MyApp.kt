package com.poonam.dua.app

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp: DaggerApplication() {
   //private val applicationInjector = DaggerAppComponent.builder().application(this).build()
   //override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
   override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
       return null
   }

}