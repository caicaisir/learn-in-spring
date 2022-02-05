package spring.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import spring.ioc.overview.dependency.domain.User;

//3.@Import
//@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.bean");
//        applicationContext.register(AnnotationBeanDefinitionDemo.class);
//        applicationContext.register(Config.class);
        //启动上下文
//        applicationContext.refresh();


//        //1.通过@Bean注册
        User user = applicationContext.getBean("alias-user", User.class);

        beanDefinitionRegistryWithName(applicationContext,"withname");
        beanDefinitionRegistry(applicationContext);
        System.out.println(applicationContext.getBeansOfType(User.class));
        //关闭上下文
        applicationContext.close();

    }

    private static void beanDefinitionRegistryWithName(BeanDefinitionRegistry registry, String name) {
        //1.BeanDefinitionBuilder构建
        //2.AbstractBeanDefinition
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder
                .addPropertyValue("id", 2L)
                .addPropertyValue("name", "beanDefinitionRegistryWithName");
        if (StringUtils.hasText(name)) {
            registry.registerBeanDefinition(name, builder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    private static void beanDefinitionRegistry(BeanDefinitionRegistry registry) {
        beanDefinitionRegistryWithName(registry, null);
    }

    //2.Component注解
    @Component
    public static class Config {
        @Bean(name = {"user", "alias-user"})
        public User user() {
            User user = new User();
            user.setId(2L);
            user.setName("AnnotationBeanDefinitionDemo");
            return user;
        }
    }

}
