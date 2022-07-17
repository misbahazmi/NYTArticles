package com.nytimes.ui.articleDetail

import androidx.lifecycle.ViewModelProvider
import com.nytimes.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticleDetailFragmentModule for DI
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
@Module
class ArticleDetailFragmentModule {

    @Provides
    fun provideViewModel() : ArticleDetailViewModel {
        return ArticleDetailViewModel()
    }

    @Provides
    fun provideViewModelProvider(viewModel: ArticleDetailViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

}