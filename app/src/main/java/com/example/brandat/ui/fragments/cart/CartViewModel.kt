package com.example.brandat.ui.fragments.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brandat.data.repos.products.IProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private var repo: IProductsRepository) : ViewModel() {
    private val _cartProduct: MutableLiveData<List<Cart>> = MutableLiveData<List<Cart>>()
    var cartProduct: LiveData<List<Cart>> = _cartProduct

    private val _allPrice: MutableLiveData<Double> = MutableLiveData<Double>()
    var allPrice: LiveData<Double> = _allPrice


    fun getAllCartproduct() = viewModelScope.launch {
        val result = repo.getAllCartProducts()
        _cartProduct.postValue(result)
        Log.e("Cart", "viewModelCart${result.size}: ", )
    }

    fun removeProductFromCart(product: Cart) = viewModelScope.launch {
        repo.removeProductFromCart(product)
    }
    fun removeSelectedProductsFromCart(product: ArrayList<Cart>) = viewModelScope.launch {
        repo.removeSelectedProductsFromCart(product)
    }
    fun updateOrder(product: Cart)=viewModelScope.launch {
        repo.updateOrder(product)
    }
    fun getAllPrice() =viewModelScope.launch {
        val price = repo.getAllPrice()
        _allPrice.postValue(price)
    }

    fun addProductToCart(cart: Cart) = viewModelScope.launch {
        repo.addProductToCart(cart)
    }
}