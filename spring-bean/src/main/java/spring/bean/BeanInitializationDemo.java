package spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import spring.factory.DefaultFactory;
import spring.factory.UserFactory;
import spring.ioc.overview.dependency.domain.User;

@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        //启动上下文
        applicationContext.refresh();
        System.out.println("applicationContext start...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println("上下文正关闭...");
        //关闭上下文
        applicationContext.close();
        System.out.println("关闭上下文...");

    }

    @Bean(initMethod = "initAnnotation",destroyMethod = "customDestory")
    @Lazy //延时初始化和非延时初始化的区别在于Bean的初始化是在上下文启动前还是后
    public UserFactory userFactory() {
        return new DefaultFactory();
    }


}
