package dependency.injection.constructorInjection;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlDependencyConstrutorInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String path = "container-constructor-injection.xml";
        reader.loadBeanDefinitions(path);

        UserHolder holder = beanFactory.getBean(UserHolder.class);
        System.out.println(holder);
    }
}
