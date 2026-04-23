package services.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import services.java.JavaServiceApp;

class JavaServiceTest {
  @Test
  void testJavaService() {
    String greeting = JavaServiceApp.greet();
    assertEquals("Hello from Java Service!", greeting);
  }
}