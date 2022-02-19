package com.hatem.sary.home.ui

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.hatem.sary.home.model.BannerItemModel
import com.hatem.sary.R
import com.hatem.sary.baseApp.BaseFragment
import com.hatem.sary.databinding.FragmentHomeBinding
import com.hatem.sary.home.interfaces.OnBannerClickListener
import com.hatem.sary.home.ui.adapter.BannerAdapter
import com.hatem.sary.home.ui.adapter.CatalogBaseAdapter
import com.hatem.sary.utils.hideLoadingDialog
import com.hatem.sary.utils.showLoadingDialog
import com.hatem.sary.utils.snack

class HomeFragment : BaseFragment(R.layout.fragment_home), OnBannerClickListener {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var dialog: Dialog
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHomeData()
    }
    override fun variableInitialization(view: View) {
        _binding = FragmentHomeBinding.bind(view)
        dialog = Dialog(requireContext())

    }

    override fun setupListeners() {

    }

    override fun observePosts() {
        viewModel.bannerData.observe(viewLifecycleOwner){
            if (it.status) {
            binding.bannerVp.adapter = BannerAdapter(it.result, this)

            }

        }

        viewModel.catalogData.observe(viewLifecycleOwner) {
            if (it.status) {
                binding.baseCatalogRv.adapter = CatalogBaseAdapter(it.result)
            } else {
                view?.snack(it.message) {}
            }
        }

    }

    override fun observeLoadStatus() {
        viewModel.loading.observe(viewLifecycleOwner) {
            if (it)
                dialog.showLoadingDialog()
            else
                dialog.hideLoadingDialog()

        }
    }

    override fun observerErrorStatus() {
        viewModel.errorWithMessage.observe(viewLifecycleOwner) {
            view?.snack(it) {}
        }

        viewModel.errorWithResources.observe(viewLifecycleOwner) {
            view?.snack(it) {}
        }
    }

    override fun onBannerClicked(banner: BannerItemModel) {
        Toast.makeText(requireContext(), banner.buttonText, Toast.LENGTH_LONG).show()
    }

}