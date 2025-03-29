package hello;
import dep1.Dep1;
import org.joda.time.LocalTime;
import dep1.Dep2;
public class HelloWorld {
    public static void main(String[] args) {
      LocalTime currentTime = new LocalTime();
		  System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
       Dep1.main(new String[]{});
       Dep2.main(new String[]{});

    }
}