package com.amineaytac.widgetexamplewithxml.network.di

import com.amineaytac.widgetexamplewithxml.network.source.RestDataSource
import com.amineaytac.widgetexamplewithxml.network.source.RestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    @Singleton
    abstract fun bindRestDataSource(restDataSourceImpl: RestDataSourceImpl): RestDataSource
}