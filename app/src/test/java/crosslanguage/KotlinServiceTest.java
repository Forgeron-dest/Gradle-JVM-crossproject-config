package crosslanguage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import services.kotlin.KotlinServiceApp;

public class KotlinServiceTest {
    @Test
    void testKotlinService() {
        String greeting = KotlinServiceApp.INSTANCE.greet();
        assertEquals("Hello from Kotlin Service!", greeting);
    }
}
