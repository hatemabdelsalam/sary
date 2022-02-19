package com.hatem.sary.home.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class BannerItemModel(
    val branches: List<Any>,
    @SerializedName("button_text")
    val buttonText: String,
    val cities: List<Int>,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String,
    @SerializedName("expiry_date")
    val expiryDate: String,
    @SerializedName("expiry_status")
    val expiryStatus: Boolean,
    val id: Int,
    val image: String,
    @SerializedName("is_available")
    val isAvailable: Boolean,
    val level: String,
    val link: String?,
    val photo: String,
    val priority: Int,
    @SerializedName("promo_code")
    val promoCode: Any?,
    @SerializedName("start_date")
    val startDate: String,
    val title: String
)