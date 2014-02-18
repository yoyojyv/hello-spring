package spring.sample.lifecycle;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by yoyojyv on 2014. 2. 18..
 */
public class DeprecatedSimpleBeanWithInterface implements InitializingBean, DisposableBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name = null;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myInit() {
        System.out.println("custum init... My Init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet... Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " + DeprecatedSimpleBean.class);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy... Destorying bean");

        name = null;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {

        ConfigurableListableBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
                "src/main/resources/BeanLifeCycleApplicationContext.xml"));

        DeprecatedSimpleBeanWithInterface simpleBean1 = getBean("simpleBeanI1", factory);
//        DeprecatedSimpleBeanWithInterface simpleBean2 = getBean("simpleBeanI2", factory);
//        DeprecatedSimpleBeanWithInterface simpleBean3 = getBean("simpleBeanI3", factory);

        factory.destroySingletons();
    }

    private static DeprecatedSimpleBeanWithInterface getBean(String beanName,
                                                   BeanFactory factory) {
        try {
            DeprecatedSimpleBeanWithInterface bean = (DeprecatedSimpleBeanWithInterface) factory.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }

}