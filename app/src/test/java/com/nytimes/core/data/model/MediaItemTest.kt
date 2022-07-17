package com.nytimes.core.data.model

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MediaItemTest {

    private lateinit var subject: MediaItem

    @Before
    fun setup(){
        subject = MediaItem()
    }

    @Test
    fun getMediaMetadata() {
        assertNull(subject.mediaMetadata)
    }
}