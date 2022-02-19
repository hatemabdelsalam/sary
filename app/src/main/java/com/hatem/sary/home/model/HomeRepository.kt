package com.hatem.sary.home.model

import com.hatem.sary.network.RetrofitBuilder

class HomeRepository {

    val client = RetrofitBuilder.instant

    suspend fun banner() = client.banner()
    suspend fun catalog() = client.catalog()
}