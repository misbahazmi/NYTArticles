package com.nytimes.core.di.component

import com.nytimes.NYTApplication
import com.nytimes.core.di.builder.ActivityBuilder
import com.nytimes.core.di.builder.FragmentBuilder
import com.nytimes.core.di.module.AppModule
import com.nytimes.core.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class
    ]
)

interface MainComponent : AndroidInjector<NYTApplication>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: NYTApplication): Builder
        fun build(): MainComponent
    }
}