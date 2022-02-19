package com.hatem.sary.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hatem.sary.databinding.ItemBaseCatalogBinding
import com.hatem.sary.home.enum.CatalogUiType
import com.hatem.sary.home.model.CatalogItemModel

class CatalogBaseAdapter(private val catalogItemList: List<CatalogItemModel>) :
    RecyclerView.Adapter<CatalogBaseAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBaseCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogItem: CatalogItemModel) {
            binding.showTitle = catalogItem.showTitle
            binding.title = catalogItem.title

            when (catalogItem.uiType) {
                CatalogUiType.GRID.name.lowercase() -> {
                    binding.catalogRv.layoutManager = GridLayoutManager(binding.root.context, catalogItem.rowCount)
                }
                CatalogUiType.LINEAR.name.lowercase() -> {
                    binding.catalogRv.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                }
                CatalogUiType.SLIDER.name.lowercase() -> {}
            }
            binding.catalogRv.adapter = CatalogAdapter(catalogItem.data, catalogItem.dataType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBaseCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catalogItemList[position])
    }

    override fun getItemCount(): Int = catalogItemList.size
}