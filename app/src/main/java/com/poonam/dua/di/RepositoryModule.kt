package com.poonam.dua.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.poonam.dua.repo.FirebaseRepository
import com.poonam.dua.repo.FirebaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideFirebaseRepository(
        firebaseAuth: FirebaseAuth,
        db: FirebaseFirestore,
        storage: FirebaseStorage
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(
            firebaseAuth, db, storage
        )
    }

}