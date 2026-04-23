package com.service.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class KotlinServiceTest {
    @Test
    fun testKotlinService() {
        val greeting = KotlinServiceApp.greet()
        assertEquals("Hello from Kotlin Service!", greeting)
    }
}