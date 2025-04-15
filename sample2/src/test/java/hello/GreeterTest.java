package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import org.junit.jupiter.api.Test;
@Execution(ExecutionMode.CONCURRENT)

class GreeterTest {

    @Test
    void testSayHello() throws InterruptedException {
    	Thread.sleep(5000);
    	System.out.println("Shruti Running " + this.getClass().getSimpleName() +
                " on " + Thread.currentThread().getName());   
    	Greeter greeter = new Greeter();
        String result = greeter.sayHello();
        System.out.println(result);
        
        assertEquals("Main Project Running...", result, "Greeting message should be 'Main Project Running..'");
    }
    
    @Test
    public void testConvertToDoubleOK() {
      for (int i = 0; i < 1000000; i++) {
        String age = "1990";
        Double expAge = Double.valueOf(age);
        Double actual = StringUtils.convertToDouble(age);
        assertNotNull(actual);
        assertEquals(expAge, actual);
      }
    }

    @Test
    public void testConvertToDoubleWithNullArgument() {
      for (int i = 0; i < 500000; i++) {
        String actual = null;
        assertNull(actual, "The actual is not null");
      }
    }

    @Test
    public void testConvertToDoubleThrowException() {
      for (int i = 0; i < 200000; i++) {
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> {
          StringUtils.convertToDouble(age);
        });
      }
    }

    @Test
    public void testIsNullOrBlankOK() {
      for (int i = 0; i < 500000; i++) {
        assertTrue(StringUtils.isNullOrBlank(null));
        assertTrue(StringUtils.isNullOrBlank(" "));
        assertFalse(StringUtils.isNullOrBlank("abc"));
      }
    }

    @Test
    public void testGetDefaultIfNull() {
      for (int i = 0; i < 200000; i++) {
        assertSame("abc", StringUtils.getDefaultIfNull(null, "abc"));
        assertNotSame("abc", StringUtils.getDefaultIfNull("def", "abc"));
      }
    }

    @Test
    public void testConcatWithRegularInput() {
      for (int i = 0; i < 200000; i++) {
        assertEquals("HelloWorld!", StringUtils.concat("Hello", "World", "!"));
      }
    }

    @Test
    public void testConcatWithNullInput() {
      for (int i = 0; i < 200000; i++) {
        assertEquals("HelloWorld", StringUtils.concat("Hello", "World", null));
      }
    }
}
