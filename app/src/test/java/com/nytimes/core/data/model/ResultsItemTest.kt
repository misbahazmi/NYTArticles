package com.nytimes.core.data.model

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResultsItemTest {
    private lateinit var subject: ResultsItem

    @Before
    fun setup(){
        subject = ResultsItem()
    }
    @Test
    fun getSection() {
        assertNull(subject.section)
    }

    @Test
    fun getSource() {
        assertNull(subject.source)
    }

    @Test
    fun getJsonMemberAbstract() {
        assertNull(subject.jsonMemberAbstract)
    }


    @Test
    fun getMedia() {
        assertNull(subject.media)
    }

    @Test
    fun getTitle() {
        assertNull(subject.title)
    }

    @Test
    fun getAdxKeywords() {
        assertNull(subject.adxKeywords)
    }

    @Test
    fun getPublishedDate() {
        assertNull(subject.publishedDate)
    }

    @Test
    fun getByline() {
        assertNull(subject.byline)
    }
}