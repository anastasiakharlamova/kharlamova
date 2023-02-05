package com.example.fintech2023kharlamova.di.modules

import com.example.fintech2023kharlamova.data.api.MoviesApi
import com.example.fintech2023kharlamova.data.database.MoviesRoomDatabase
import com.example.fintech2023kharlamova.data.repositories.MoviesRepository
import com.example.fintech2023kharlamova.data.repositories.MoviesRepositoryImpl
import com.example.fintech2023kharlamova.data.repositories.local.MoviesLocalDataSource
import com.example.fintech2023kharlamova.data.repositories.local.room.RoomMoviesDataSource
import com.example.fintech2023kharlamova.data.repositories.remote.MoviesRemoteDataSource
import com.example.fintech2023kharlamova.data.repositories.remote.retrofit.RetrofitMoviesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesDataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(moviesApi: MoviesApi): MoviesRemoteDataSource =
        RetrofitMoviesDataSource(moviesApi = moviesApi)

    @Provides
    @Singleton
    fun provideLocalDataSource(roomDatabase: MoviesRoomDatabase): MoviesLocalDataSource =
        RoomMoviesDataSource(roomDatabase.moviesDao(), roomDatabase.movieDetailsDao())

    @Provides
    @Singleton
    fun provideMoviesRepository(
        remote: MoviesRemoteDataSource,
        local: MoviesLocalDataSource
    ): MoviesRepository = MoviesRepositoryImpl(remote, local)
}