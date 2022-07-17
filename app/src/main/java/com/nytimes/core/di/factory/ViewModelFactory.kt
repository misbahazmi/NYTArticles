package com.nytimes.core.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory<V: ViewModel>(private val viewModel: V) : ViewModelProvider.Factory {

    @SuppressWarnings("unchecked")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(viewModel::class.java))
            return  viewModel as T
        throw IllegalAccessException("Unknown class name")
    }

}