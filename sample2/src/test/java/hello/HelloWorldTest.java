package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;

class HelloWorldTest {

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> HelloWorld.main(new String[]{}), "Main method should run without exceptions");
    }
    @Test
    public void testConcatWithRegularInput() {
      String st1 = "Hello";
      String st2 = "World";
      String st3 = "!";
      String expect = st1 + st2 + st3;
      String actual = StringUtils.concat(st1, st2, st3);
      assertEquals(expect, actual);
    }

    @Disabled
    @Test
    public void testConcatWithNullInput() {
      String st1 = "Hello";
      String st2 = "World";
      String st3 = null;
      String expect = st1 + st2;
      String actual = StringUtils.concat(st1, st2, st3);
      assertEquals(expect, actual);
    }

    @Test
    public void testConcatWithAllNullInput() {
      String actual = StringUtils.concat();
      assertNull(actual);
    }
}
