package com.poonam.dua.di.modules

import com.poonam.dua.api.UnSplashService
import com.poonam.dua.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRepository(unSplashService: UnSplashService): Repository =
        Repository(unSplashService)
}