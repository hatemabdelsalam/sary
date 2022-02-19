package com.hatem.sary.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hatem.sary.home.model.BannerItemModel
import com.hatem.sary.databinding.ItemBannerBinding
import com.hatem.sary.home.interfaces.OnBannerClickListener

class BannerAdapter(private val bannerList: List<BannerItemModel>, private val onBannerClickListener: OnBannerClickListener):RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: BannerItemModel, onBannerClickListener: OnBannerClickListener) {
            binding.imageUrl = "https://devcdn.sary.co/banners/2020/06/09/June_Banners-02.png"//banner.image
            binding.root.setOnClickListener {
                onBannerClickListener.onBannerClicked(banner)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bannerList[position], onBannerClickListener)
    }

    override fun getItemCount(): Int = bannerList.size
}