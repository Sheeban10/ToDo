package com.example.todo.dependency

import com.example.todo.data.repository.NotesRepository
import com.example.todo.data.repository.UserRepository
import com.example.todo.data.sources.NotesRemoteDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(firebaseAuth: FirebaseAuth):UserRepository {
        return UserRepository(firebaseAuth)
    }

    @Singleton
    @Provides
    fun provideNotesRepository(notesRemoteDataSource: NotesRemoteDataSource):NotesRepository {
        return NotesRepository(notesRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideNotesRemoteDataSource(firebaseFirestore: FirebaseFirestore, firebaseAuth: FirebaseAuth) : NotesRemoteDataSource {
        return NotesRemoteDataSource(firebaseFirestore, firebaseAuth)
    }

}