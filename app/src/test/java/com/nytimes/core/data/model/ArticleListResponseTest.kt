package com.nytimes.core.data.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ArticleListResponseTest {

    private lateinit var subject: ArticleListResponse

    @Before
    fun setup(){
        subject = ArticleListResponse()
        subject.copyright = "Copyright (c) 2022 The New York Times Company.  All Rights Reserved."
        subject.status = "OK"
    }

    @Test
    fun getCopyright() {
        Assert.assertEquals("Copyright (c) 2022 The New York Times Company.  All Rights Reserved.", subject.copyright)
        Assert.assertNotNull(subject.copyright)
    }

    @Test
    fun getResults() {
        Assert.assertNotEquals(0,subject.results?.size)
    }

    @Test
    fun getNumResults() {
        Assert.assertNotEquals(0,subject.numResults)
    }

    @Test
    fun getStatus() {
        Assert.assertEquals("OK", subject.status)
        Assert.assertNotNull(subject.status)
    }
}