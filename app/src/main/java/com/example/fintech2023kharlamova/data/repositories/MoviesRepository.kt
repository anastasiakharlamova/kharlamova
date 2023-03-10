package com.example.fintech2023kharlamova.data.repositories

import com.example.fintech2023kharlamova.data.model.Film
import com.example.fintech2023kharlamova.data.model.FilmTopResponse
import com.example.fintech2023kharlamova.data.model.FilmTopResponse_films
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MoviesRepository {

    fun getMoviesRemote(): Observable<FilmTopResponse>

    fun getMovieForId(id: Int): Observable<Film>

    fun getMoviesLocal(): Single<List<FilmTopResponse_films>>

    suspend fun checkMovieLocal(film: FilmTopResponse_films)

    suspend fun saveMovieLocal(film: FilmTopResponse_films)

    suspend fun createMovieDetailsLocal(film: Film)

    fun getForIdMovieDetailsLocal(id: Int): Single<List<Film>>

    suspend fun deleteMovieDetailsLocal(id: Int)

    suspend fun existsMovieDetailsLocal(id: Int): Boolean

}