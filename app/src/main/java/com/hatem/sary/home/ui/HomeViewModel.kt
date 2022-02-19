package com.hatem.sary.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hatem.sary.home.model.BannerModel
import com.hatem.sary.home.model.CatalogModel
import com.hatem.sary.R
import com.hatem.sary.home.model.HomeRepository
import com.hatem.sary.network.NetworkResponse
import kotlinx.coroutines.launch

class HomeViewModel(val homeRepository: HomeRepository= HomeRepository()):ViewModel() {

    val bannerData = MutableLiveData<BannerModel>()
    val catalogData = MutableLiveData<CatalogModel>()
    val loading = MutableLiveData<Boolean>(true)
    val errorWithMessage = MutableLiveData<String>()
    val errorWithResources = MutableLiveData<Int>()

    fun getHomeData() {
        kotlin.run {
            getBannerData()
            getCatalogData()
        }
        loading.value = false
    }

    private fun getBannerData() {
        viewModelScope.launch {
            when (val result = homeRepository.banner()) {
                is NetworkResponse.ApiError -> {
                    result.body.message?.let { errorWithMessage.value = it }
                }
                is NetworkResponse.NetworkError -> {
                    result.error.message?.let { errorWithMessage.value = it }
                }
                is NetworkResponse.Success -> {
                    bannerData.value = result.body
                }
                is NetworkResponse.UnknownError -> {
                    errorWithResources.value = R.string.try_again
                }
            }
        }
    }

    private fun getCatalogData() {
        viewModelScope.launch {
            when (val result=homeRepository.catalog()) {
                is NetworkResponse.ApiError -> {
                    result.body.message?.let { errorWithMessage.value = it }
                }
                is NetworkResponse.NetworkError -> {
                    result.error.message?.let { errorWithMessage.value = it }
                }
                is NetworkResponse.Success -> {
                    catalogData.value = result.body
                }
                is NetworkResponse.UnknownError -> {
                    errorWithResources.value = R.string.try_again
                }
            }
        }
    }

}