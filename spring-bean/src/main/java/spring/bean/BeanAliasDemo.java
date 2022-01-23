package spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.anotation.Super;
import spring.ioc.overview.dependency.domain.User;

import java.util.Map;

public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-definition.xml");
        User aliasUser = beanFactory.getBean("aliasUser", User.class);
        User originUser = beanFactory.getBean("user", User.class);
        //true
        System.out.println(aliasUser == originUser);
    }
}
