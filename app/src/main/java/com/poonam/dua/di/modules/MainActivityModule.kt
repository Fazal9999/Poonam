package com.poonam.dua.di.modules
import com.poonam.dua.activities.dashboard.DashboardActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): DashboardActivity
}