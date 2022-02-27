package spring.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.overview.dependency.domain.User;

/**
 * DefaultListableBeanFactory既是单一类型、又是集合类型、也是层次类型
 */
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);
        applicationContext.refresh();
//        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetBean(applicationContext);
        applicationContext.close();
    }
    private static void displayObjectFactoryGetBean(AnnotationConfigApplicationContext applicationContext){
        ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("objectFactory",()->objectFactory.getObject());

    }

    private static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printBeansException("BeanFactory",()->beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source, Runnable runnable){
        System.err.println("---"+source);
        try {
            runnable.run();
        }catch (BeansException exception){
            exception.printStackTrace();
        }
    }
}
