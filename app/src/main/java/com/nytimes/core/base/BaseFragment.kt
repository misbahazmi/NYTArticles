package com.nytimes.core.base

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerDialogFragment

abstract class BaseFragment<V: ViewModel> : DaggerDialogFragment() {

    private lateinit var  viewModel: V
    abstract fun getViewModel() : V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.viewModel=getViewModel()
    }
}