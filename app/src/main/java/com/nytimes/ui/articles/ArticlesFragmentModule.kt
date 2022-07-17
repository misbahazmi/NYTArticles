package com.nytimes.ui.articles

import androidx.lifecycle.ViewModelProvider
import com.nytimes.core.data.remote.RemoteDataSource
import com.nytimes.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides


/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticlesFragmentModule module for DI
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
@Module
class ArticlesFragmentModule {

    @Provides
    fun provideViewModel(repository: ArticlesRepository) : ArticlesViewModel {
        return ArticlesViewModel(repository)
    }

    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource) : ArticlesRepository {
        return ArticlesRepository(remoteDataSource)
    }


    @Provides
    fun provideViewModelProvider(viewModel: ArticlesViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

}