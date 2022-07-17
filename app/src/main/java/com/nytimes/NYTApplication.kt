package com.nytimes

import com.nytimes.core.di.component.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
class NYTApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerMainComponent.builder().application(this).build()
}