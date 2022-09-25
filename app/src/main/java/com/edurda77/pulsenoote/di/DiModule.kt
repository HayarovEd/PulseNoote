package com.edurda77.pulsenoote.di

import com.edurda77.pulsenoote.repository.WorkWithDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    @Singleton
    fun providesRemoteService(): DatabaseReference = Firebase.database.reference

    @Provides
    @Singleton
    fun provideMainRemoteData(database: DatabaseReference): WorkWithDatabase =
        WorkWithDatabase(database)
}