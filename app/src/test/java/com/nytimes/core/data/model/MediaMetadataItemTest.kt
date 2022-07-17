package com.nytimes.core.data.model

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MediaMetadataItemTest {

    private lateinit var subject: MediaMetadataItem

    @Before
    fun setup(){
        subject = MediaMetadataItem()
        subject.url = "http...";
    }

    @Test
    fun getFormat() {
        assertNull(subject.format)
    }

    @Test
    fun getWidth() {
        assertNull(subject.width)
        assertTrue(subject.width !=0 )
    }

    @Test
    fun getUrl() {
        assertTrue(subject.url?.startsWith("http")!!)
        assertNotNull(subject.url)
    }

    @Test
    fun getHeight() {
        assertNull(subject.height)
        assertTrue(subject.height !=0 )
    }
}