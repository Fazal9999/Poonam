package com.poonam.dua.di.modules
import com.poonam.dua.fragments.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeImagesListFragment(): LoginFragment

}