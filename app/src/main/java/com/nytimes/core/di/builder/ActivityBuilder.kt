package com.nytimes.core.di.builder


import com.nytimes.ui.main.MainActivity
import com.nytimes.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}