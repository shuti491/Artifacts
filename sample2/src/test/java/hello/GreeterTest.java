package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GreeterTest {

    @Test
    void testSayHello() {
        Greeter greeter = new Greeter();
        String result = greeter.sayHello();
        System.out.println(result);
        
        assertEquals("Main Project Running...", result, "Greeting message should be 'Main Project Running..'");
    }
}
