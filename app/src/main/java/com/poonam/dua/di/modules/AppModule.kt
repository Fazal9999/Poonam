package com.poonam.dua.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        FirebaseModule::class,
        DataModule::class,
        PrefModule::class
    ]
)
class AppModule