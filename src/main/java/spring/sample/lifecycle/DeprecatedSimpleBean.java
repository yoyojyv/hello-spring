package spring.sample.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by yoyojyv on 2014. 2. 18..
 *
 * http://javajigi.net/pages/viewpage.action?pageId=1040 참조
 */
public class DeprecatedSimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name = null;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " + DeprecatedSimpleBean.class);
        }
    }

    public void destory() {
        System.out.println("Destorying bean");

        name = null;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "./src/main/resources/BeanLifeCycleApplicationContext.xml"));

        DeprecatedSimpleBean simpleBean1 = getBean("simpleBean1", factory);
        DeprecatedSimpleBean simpleBean2 = getBean("simpleBean2", factory);
        DeprecatedSimpleBean simpleBean3 = getBean("simpleBean3", factory);

        factory.destroySingletons();
    }

    private static DeprecatedSimpleBean getBean(String beanName, BeanFactory factory) {
        try {
            DeprecatedSimpleBean bean =(DeprecatedSimpleBean) factory.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}