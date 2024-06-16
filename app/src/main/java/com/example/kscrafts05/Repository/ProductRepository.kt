package com.example.kscrafts05.Repository

import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Retrofit.Api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api:Api) {

    private val _products = MutableStateFlow<List<ProductX>>(emptyList())
    val products : StateFlow<List<ProductX>>
        get() = _products

    suspend fun getproducts(){
        val response = api.getData()

        if (response.isSuccessful && response.body()!=null){
            _products.emit(response.body()!!.products)
        }
    }
}