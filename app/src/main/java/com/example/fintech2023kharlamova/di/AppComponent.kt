package com.example.fintech2023kharlamova.di

import android.content.Context
import com.example.fintech2023kharlamova.di.modules.MoviesDataModule
import com.example.fintech2023kharlamova.di.modules.RemoteModule
import com.example.fintech2023kharlamova.di.modules.RoomModule
import com.example.fintech2023kharlamova.ui.moviedetails.presentation.MovieDetailsViewModel
import com.example.fintech2023kharlamova.ui.moviedetails.ui.MovieDetailsFragment
import com.example.fintech2023kharlamova.ui.movieslist.presentation.MoviesListViewModel
import com.example.fintech2023kharlamova.ui.movieslist.ui.MoviesListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RemoteModule::class, MoviesDataModule::class, RoomModule::class])
@Singleton
interface AppComponent {
    fun inject(fragment: MoviesListFragment)
    fun inject(fragment: MovieDetailsFragment)
    fun injectMoviesListViewModel(): MoviesListViewModel.Factory
    fun injectMovieDetailsViewModel(): MovieDetailsViewModel.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }
}