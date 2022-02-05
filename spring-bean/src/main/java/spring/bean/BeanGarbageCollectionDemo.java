package spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import spring.factory.DefaultFactory;
import spring.factory.UserFactory;

public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        //启动上下文
        applicationContext.refresh();
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        //关闭上下文
        applicationContext.close();
        System.out.println("关闭上下文...");
        Thread.sleep(5000);
        System.gc();
        Thread.sleep(5000);

    }

}
