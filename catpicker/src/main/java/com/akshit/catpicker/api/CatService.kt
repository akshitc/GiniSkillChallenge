package com.akshit.catpicker.api

import com.akshit.catpicker.model.CatModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

internal const val API_BASE_URL = "https://api.thecatapi.com/"
internal const val API_KEY = "42aecdd4-b570-4090-9fa0-e4f31aa8a08e"

interface CatService {

    @GET("v1/images/search")
    suspend fun getCats(
        @Header("x-api-key") header: String = API_KEY,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String = "desc"
    ): List<CatModel>

    companion object {
        fun createService(): CatService {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_BASE_URL)
                .client(client)
                .build()
            return retrofit.create(CatService::class.java)
        }
    }
}
