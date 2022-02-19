package com.hatem.sary.home.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CatalogItemModel(
    val `data`: List<CatalogData>,
    @SerializedName("data_type")
    val dataType: String,
    val id: Int,
    @SerializedName("row_count")
    val rowCount: Int,
    @SerializedName("show_title")
    val showTitle: Boolean,
    val title: String,
    @SerializedName("ui_type")
    val uiType: String
)