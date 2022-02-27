package dependency.injection.setterinjction;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.ioc.overview.dependency.domain.User;

public class ApiDependencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder",userHolderBeanDefinition);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String path = "container-dependency-lookup.xml";
        reader.loadBeanDefinitions(path);
        applicationContext.refresh();
        UserHolder holder = applicationContext.getBean(UserHolder.class);
        System.out.println(holder);
        applicationContext.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user", "superuser");
        return builder.getBeanDefinition();
    }
}
