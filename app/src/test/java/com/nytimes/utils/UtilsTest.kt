package com.nytimes.utils

import android.content.Context
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UtilsTest {

    @Mock
    private lateinit var context: Context

    private lateinit var subject: Utils

    @Before
    fun setup(){
        subject = Utils(context)
    }


    @Test
    fun showToast(){
        assertNotNull(subject.showToast(""))
    }
}