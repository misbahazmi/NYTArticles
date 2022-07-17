package com.nytimes.ui.articleDetail


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nytimes.core.data.model.ResultsItem
import javax.inject.Inject

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticleDetailViewModel for article details
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
class ArticleDetailViewModel @Inject constructor() : ViewModel(){

    var articleData = MutableLiveData<ResultsItem>()



}