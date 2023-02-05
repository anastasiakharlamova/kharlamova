package com.example.fintech2023kharlamova.data.repositories.remote

import com.example.fintech2023kharlamova.data.model.Film
import com.example.fintech2023kharlamova.data.model.FilmTopResponse
import io.reactivex.rxjava3.core.Observable

interface MoviesRemoteDataSource {

    fun getMoviesRemote(): Observable<FilmTopResponse>

    fun getMovieForId(id: Int): Observable<Film>
}