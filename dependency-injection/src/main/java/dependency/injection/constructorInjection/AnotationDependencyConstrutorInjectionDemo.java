package dependency.injection.constructorInjection;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.ioc.overview.dependency.domain.User;

public class AnotationDependencyConstrutorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnotationDependencyConstrutorInjectionDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String path = "container-dependency-lookup.xml";
        reader.loadBeanDefinitions(path);
        applicationContext.refresh();
        UserHolder holder = applicationContext.getBean(UserHolder.class);
        System.out.println(holder);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
