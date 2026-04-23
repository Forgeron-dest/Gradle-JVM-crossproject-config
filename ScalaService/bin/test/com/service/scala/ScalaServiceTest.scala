package com.service.scala

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import com.service.scala.ScalaServiceApp

class ScalaServiceTest:
  @Test
  def testScalaService(): Unit =
    val greeting = ScalaServiceApp.greet()
    assertEquals("Hello from Scala Service!", greeting)