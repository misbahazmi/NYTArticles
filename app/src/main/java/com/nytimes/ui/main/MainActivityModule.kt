package com.nytimes.ui.main

import androidx.lifecycle.ViewModelProvider
import com.nytimes.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc MainActivityModule for dependencies injections
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */

@Module
class MainActivityModule {

    @Provides
    fun providesViewModel() : MainViewModel {
        return MainViewModel()
    }

    @Provides
    fun provideViewModelProvider(viewModel: MainViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }
}