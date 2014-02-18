package spring.sample.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yoyojyv on 2014. 2. 18..
 */
public class GreetingApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("HelloSpringApplicationContext.xml");
        GreetingService greetingService = applicationContext.getBean("greetingService", GreetingService.class);
        System.out.println(greetingService.greeting());
    }
}
