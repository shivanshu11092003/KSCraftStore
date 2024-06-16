package com.example.kscrafts05.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository) : ViewModel() {
        val product : StateFlow<List<ProductX>>
            get()= productRepository.products

    init {
        viewModelScope.launch {
            productRepository.getproducts()
        }
    }

}