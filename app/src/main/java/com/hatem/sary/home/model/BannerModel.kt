package com.hatem.sary.home.model


import androidx.annotation.Keep

@Keep
data class BannerModel(
    val result: List<BannerItemModel>,
    val status: Boolean
)