package com.example.kscrafts05.Retrofit

import com.example.kscrafts05.Model.productResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("products")
    suspend fun getData(@Query("limit")limit:Int) : Response<productResponse>
}