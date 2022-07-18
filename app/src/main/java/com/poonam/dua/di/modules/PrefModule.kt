package com.poonam.dua.di.modules

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.poonam.dua.utils.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
class PrefModule {

    //a different scenerio in which Sharedpref helper takes a parameter..we can use qualifier,,provide sharedpref helper
    //class with different parameters i.e app context or activity context

    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_APP)
    fun provideSharedPreferences(app: Application): SharedPreferencesHelper {
        return SharedPreferencesHelper(app)
    }
    //so we can Inject this in any activity
    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_ACTIVITY)
    fun provideActivitySharedPreferences(activity: AppCompatActivity): SharedPreferencesHelper {
        return SharedPreferencesHelper(activity)
    }
}
const val CONTEXT_APP="Application Context"
const val CONTEXT_ACTIVITY="Activity Context"

@Qualifier
annotation class TypeOfContext(val type:String)