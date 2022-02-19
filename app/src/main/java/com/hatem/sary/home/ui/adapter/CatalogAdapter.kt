package com.hatem.sary.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hatem.sary.R
import com.hatem.sary.databinding.ItemCatalogBinding
import com.hatem.sary.home.enum.CatalogDataType
import com.hatem.sary.home.model.CatalogData

class CatalogAdapter(val catalogDataList: List<CatalogData>, val dataType: String = "") :
    RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCatalogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogData: CatalogData, dataType: String = "") {
            binding.imageUrl = catalogData.image

            if (dataType == CatalogDataType.SMART.name.lowercase()) {
                binding.showTitle = true
                binding.title = catalogData.name
                binding.catalogImg.background = binding.root.context.resources.getDrawable(R.drawable.ic_circle_backcround, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catalogDataList[position], dataType)
    }

    override fun getItemCount(): Int = catalogDataList.size
}