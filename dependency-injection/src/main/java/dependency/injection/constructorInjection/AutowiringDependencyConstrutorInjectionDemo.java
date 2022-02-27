package dependency.injection.constructorInjection;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringDependencyConstrutorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String path = "autowiring-container-construtor-injection.xml";
        reader.loadBeanDefinitions(path);
        applicationContext.refresh();
        UserHolder holder = applicationContext.getBean(UserHolder.class);
        System.out.println(holder);
        applicationContext.close();
    }
}
