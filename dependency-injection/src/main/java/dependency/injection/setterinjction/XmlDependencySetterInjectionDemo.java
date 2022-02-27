package dependency.injection.setterinjction;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String path = "container-setting-injection.xml";
        reader.loadBeanDefinitions(path);

        UserHolder holder = beanFactory.getBean(UserHolder.class);
        System.out.println(holder);
    }
}
