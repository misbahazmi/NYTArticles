package com.nytimes.ui.articles
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nytimes.BuildConfig
import com.nytimes.core.data.model.ArticleListResponse
import javax.inject.Inject
/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticlesViewModel for the articles
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
open class ArticlesViewModel @Inject constructor(private val repository: ArticlesRepository) : ViewModel(){

    var _showProgress = MutableLiveData<Boolean>(true)
    val showProgressLiveData : LiveData<Boolean> = _showProgress
    var _articlesList = MutableLiveData<ArticleListResponse>()
    val articleListLiveData : LiveData<ArticleListResponse> = _articlesList

    val articlesObservable by lazy {
        repository.observeArticles(BuildConfig.Section, BuildConfig.Period)
    }

    fun getAllArticlesList() = articlesObservable.value?.data?.results
}