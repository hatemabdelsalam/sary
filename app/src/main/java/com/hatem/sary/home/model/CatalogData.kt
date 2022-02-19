package com.hatem.sary.home.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CatalogData(
    @SerializedName("deep_link")
    val deepLink: String,
    @SerializedName("empty_content_image")
    val emptyContentImage: String?,
    @SerializedName("empty_content_message")
    val emptyContentMessage: String?,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("has_data")
    val hasData: Boolean,
    val image: String,
    val name: String,
    @SerializedName("show_in_brochure_link")
    val showInBrochureLink: Boolean,
    @SerializedName("show_unavailable_items")
    val showUnavailableItems: Boolean
)