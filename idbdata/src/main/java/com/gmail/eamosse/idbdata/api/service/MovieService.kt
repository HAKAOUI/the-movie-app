package com.gmail.eamosse.idbdata.api.service

import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.MoviesResponse
import com.gmail.eamosse.idbdata.api.response.SeasonResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/movie/list")
    suspend fun getCategories(): Response<CategoryResponse>
    @GET("/3/discover/movie")
    suspend fun getMovies(@Query("with_genres") catId: String): Response<MoviesResponse>
    @GET("/3/discover/tv")
    suspend fun getSeason(@Query("with_genres") catIdtv: String): Response<SeasonResponse>
    @GET("genre/tv/list")
    suspend fun getCategoriestv(): Response<CategoryResponse>
}
