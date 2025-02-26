package com.amineaytac.widgetexamplewithxml.core.data.di

import com.amineaytac.widgetexamplewithxml.core.data.repo.SentenceRepository
import com.amineaytac.widgetexamplewithxml.core.data.repo.SentenceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBookRepository(sentenceRepositoryImpl: SentenceRepositoryImpl): SentenceRepository
}