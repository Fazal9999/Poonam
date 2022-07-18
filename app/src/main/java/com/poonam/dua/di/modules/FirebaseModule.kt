package com.poonam.dua.di.modules

 import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
 import com.poonam.dua.R
 import com.poonam.dua.data.FirebaseAuthSource
import com.poonam.dua.data.FirebaseDataSource
import com.poonam.dua.dialog.LoadingDialog
import com.poonam.dua.utils.GetTimeAgo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object FirebaseModule {
    @get:Provides
    @get:Singleton
    val authInstance: FirebaseAuth
        get() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebaseInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun getAuthSource(
        firebaseAuth: FirebaseAuth?,
        firebaseFirestore: FirebaseFirestore?
    ): FirebaseAuthSource {
        return FirebaseAuthSource(firebaseAuth!!, firebaseFirestore!!)
    }

//    @Singleton
//    @Provides
//    fun provideAuthRepository(authSource: FirebaseAuthSource?): AuthRepository {
//        return AuthRepository(authSource)
//    }

    @Singleton
    @Provides
    fun provideStorageReference(): StorageReference {
        return FirebaseStorage.getInstance().getReference()
    }

    @Singleton
    @Provides
    fun provideLoadingDialog(): LoadingDialog {
        return LoadingDialog()
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions.placeholderOf(R.drawable.ic_leaves)
            .error(R.drawable.ic_leaves)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application?,
        requestOptions: RequestOptions?
    ): RequestManager {
        return Glide.with(application!!)
            .setDefaultRequestOptions(requestOptions!!)
    }

    @Provides
    fun provideFirebaseDataSource(
        firebaseAuthSource: FirebaseAuthSource?,
        firebaseFirestore: FirebaseFirestore?,
        storageReference: StorageReference?
    ): FirebaseDataSource {
        return FirebaseDataSource(firebaseAuthSource!!, firebaseFirestore, storageReference)
    }
//
//    @Provides
//    fun provideDatabaseRepository(firebaseDataSource: FirebaseDataSource?): DatabaseRepository {
//        return DatabaseRepository(firebaseDataSource)
//    }

    @Provides
    fun provideGetTimeAgo(): GetTimeAgo {
        return GetTimeAgo()
    }
}