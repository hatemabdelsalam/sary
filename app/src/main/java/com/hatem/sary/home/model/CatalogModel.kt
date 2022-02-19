package com.hatem.sary.home.model


import androidx.annotation.Keep

@Keep
data class CatalogModel(
    val message: String,
    val result: List<CatalogItemModel>,
    val status: Boolean
)