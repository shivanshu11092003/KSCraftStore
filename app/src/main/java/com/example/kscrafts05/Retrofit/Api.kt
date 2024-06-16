package com.example.kscrafts05.Retrofit

import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Model.productResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("products")
    suspend fun getData() : Response<productResponse>
}