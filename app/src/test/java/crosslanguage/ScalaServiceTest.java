package crosslanguage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import services.scala.ScalaServiceApp;

public class ScalaServiceTest {
    @Test
    void testScalaService() {
        String greeting = ScalaServiceApp.greet();
        assertEquals("Hello from Scala Service!", greeting);
    }
}