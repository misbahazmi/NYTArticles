package com.nytimes.interfaces

import androidx.fragment.app.Fragment
import com.nytimes.core.data.model.ResultsItem


/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc OnArticleClickListener to open details screen
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
interface OnArticleClickListener {
    fun onArticleClick(article: ResultsItem)
}