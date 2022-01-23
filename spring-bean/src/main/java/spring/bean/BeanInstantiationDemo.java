package spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.domain.User;

public class BeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-instrantiation.xml");
//        User user = applicationContext.getBean("static-factory-user", User.class);
//        User user = applicationContext.getBean("factory-user", User.class);
        User user = applicationContext.getBean("factoryBean-user", User.class);
        System.out.println(user);
    }
}
