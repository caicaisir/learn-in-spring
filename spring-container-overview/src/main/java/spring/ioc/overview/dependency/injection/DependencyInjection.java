package spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.anotation.Super;
import spring.ioc.overview.dependency.domain.User;
import spring.ioc.overview.dependency.repository.UserRepository;

import java.util.Map;

public class DependencyInjection {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("container-dependency-injection.xml");
        UserRepository userReposiry = beanFactory.getBean("userReposiry", UserRepository.class);
//        System.out.println(userReposiry);
//        System.out.println(userReposiry.getBeanFactory());
//        System.out.println(beanFactory==userReposiry.getBeanFactory());
        //No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
//        System.out.println(beanFactory.getBean(BeanFactory.class));
        ObjectFactory<ApplicationContext> objectFactory = userReposiry.getObjectFactory();
        System.out.println(objectFactory.getObject());
        System.out.println(beanFactory==objectFactory.getObject());
    }

}
