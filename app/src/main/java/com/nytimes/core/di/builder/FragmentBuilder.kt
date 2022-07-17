package com.nytimes.core.di.builder


import com.nytimes.ui.articleDetail.ArticleDetailFragment
import com.nytimes.ui.articleDetail.ArticleDetailFragmentModule
import com.nytimes.ui.articles.ArticlesFragment
import com.nytimes.ui.articles.ArticlesFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [ArticlesFragmentModule::class])
    abstract fun contributeArticlesFragment(): ArticlesFragment

    @ContributesAndroidInjector(modules = [ArticleDetailFragmentModule::class])
    abstract fun contributeArticleDetailFragment(): ArticleDetailFragment

}