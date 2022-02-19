package com.hatem.sary.baseApp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    open fun variableInitialization(view: View) {}
    open fun setupListeners() {}
    open fun observePosts() {}
    open fun observeLoadStatus() {}
    open fun observerErrorStatus() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        variableInitialization(view)
        setupListeners()
        observeLoadStatus()
        observerErrorStatus()
        observePosts()
    }
}