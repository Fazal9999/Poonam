package com.poonam.dua.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.poonam.dua.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseDB() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage() = FirebaseStorage.getInstance()

//    @Provides
//    @Singleton
//    fun provideNoteUseCases(repository: FirebaseRepository): NoteUseCases {
//        return NoteUseCases(
//            postNoteUseCase = PostNoteUseCase(repository),
//            editNoteUseCase = EditNoteUseCase(repository),
//            loadNotesListUseCase = LoadNotesListUseCase(repository),
//            deleteNoteUseCase = DeleteNoteUseCase(repository)
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideUserUseCases(repository: FirebaseRepository): UserUseCases {
//        return UserUseCases(
//            registerUserUseCase = RegisterUserUseCase(repository),
//            loginUserUseCase = LoginUserUseCase(repository),
//            isUserLoggedInUseCase = IsUserLoggedInUseCase(repository),
//            getUserDataUseCase = GetUserDataUseCase(repository),
//            logoutUserUseCase = LogoutUserUseCase(repository)
//        )
//    }

}