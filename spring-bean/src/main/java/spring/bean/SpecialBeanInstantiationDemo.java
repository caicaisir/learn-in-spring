package spring.bean;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.factory.DefaultFactory;
import spring.factory.UserFactory;
import spring.ioc.overview.dependency.domain.User;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("special-bean-instrantiation.xml");
        //1.ServiceLoader实例化Bean
//        ServiceLoader<UserFactory> serviceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);
//        displayServiceLoaderDemo();
//        displayServiceLoader(serviceLoader);
        //2.AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        DefaultFactory factory = beanFactory.createBean(DefaultFactory.class);
        System.out.println(factory.createUser());
    }

    //java spi
    private static void displayServiceLoaderDemo(){
        ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class,Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
