package hello;
import org.joda.time.LocalTime;

import dep1.dep1Mainrunner;
import dep2.Dep2Mainrunner;
import dep3.Dep3Mainrunner;
import dep4.Dep4Mainrunner;
public class HelloWorld {
    public static void main(String[] args) {
      LocalTime currentTime = new LocalTime();
		  System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        dep1Mainrunner.main(new String[]{});
        Dep2Mainrunner.main(new String[]{});
        Dep3Mainrunner.main(new String[]{});
        Dep4Mainrunner.main(new String[]{});
    }
}