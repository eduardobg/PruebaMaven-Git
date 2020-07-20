package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
  public static void main(String[] args) {
    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
	System.out.println("----------------------");
	System.out.println("Modificacion añadida desde branch dev-edu");
	System.out.println("Modificacion añadida después del primer merge !!!!");
  }
}