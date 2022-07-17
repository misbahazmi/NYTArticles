package com.nytimes.ui.articles

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class ArticlesViewModelTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var repository: ArticlesRepository

    private lateinit var subject: ArticlesViewModel

    @Before
    fun setup(){
        subject = ArticlesViewModel(repository)
    }

    @Test
    fun get_showProgress() {
    }

    @Test
    fun set_showProgress() {
    }

    @Test
    fun getShowProgressLiveData() {
    }

    @Test
    fun get_articlesList() {
    }

    @Test
    fun set_articlesList() {
    }

    @Test
    fun getArticleListLiveData() {
    }

    @Test
    fun getArticlesObservable() {
    }

    @Test
    fun getAllArticlesList() {
//        = runTest{
//            withContext(Dispatchers.Default) {
//                Assert.assertNull(subject.getAllArticlesList())
//            }
//            Mockito.verify(subject).getAllArticlesList()
    }

}