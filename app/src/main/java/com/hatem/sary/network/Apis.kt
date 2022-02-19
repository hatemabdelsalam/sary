package com.hatem.sary.network

import com.hatem.sary.home.model.BannerModel
import com.hatem.sary.home.model.CatalogModel
import retrofit2.http.*

interface Apis {

    @GET(Urls.BANNER)
    suspend fun banner(): NetworkResponse<BannerModel, Error>

    @GET(Urls.CATALOG)
    suspend fun catalog(): NetworkResponse<CatalogModel, Error>



}