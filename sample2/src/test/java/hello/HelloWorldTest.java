package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HelloWorldTest {

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> HelloWorld.main(new String[]{}), "Main method should run without exceptions");
    }
}
