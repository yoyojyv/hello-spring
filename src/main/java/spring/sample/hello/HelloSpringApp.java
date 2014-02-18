package spring.sample.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yoyojyv on 2014. 2. 18..
 */
public class HelloSpringApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("HelloSpringApplicationContext.xml");

        // Hello hello = (Hello) applicationContext.getBean("hello");
        Hello hello = applicationContext.getBean("hello", Hello.class);

        System.out.println(hello.hello());

    }

}
