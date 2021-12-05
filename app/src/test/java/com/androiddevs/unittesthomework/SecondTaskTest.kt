package com.androiddevs.unittesthomework

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class) // let Junit know to use parameterized test runner
class SecondTaskTest(
    private val expected:Boolean,
    private val input:String,
    private val scenario:String
) {
    companion object{
        @JvmStatic
        @Parameterized.Parameters(name = "cases: {2}")
        fun testCases() = listOf(
            arrayOf(false,"(a * b))","num of left braces is less than right braces"),
            arrayOf(false,"(a*b","num of left braces is greater than right braces"),
            arrayOf(false,"a*b)","num of left braces is less than right braces"),
            arrayOf(false,"((a * b)","num of left braces is greater than right braces"),
            arrayOf(true,"(a*b)","num of left braces is equal to right braces")
        )
    }

    @Test
    fun testBracesInString(){
        val actual = Homework.checkBraces(input)
        assertEquals(actual,expected)
    }
}