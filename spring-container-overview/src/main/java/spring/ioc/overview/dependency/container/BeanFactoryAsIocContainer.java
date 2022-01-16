package spring.ioc.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.ioc.overview.dependency.domain.User;

import java.util.Map;

public class BeanFactoryAsIocContainer {
    public static void main(String[] args) {
        //通过BeanFactory实现ioc
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "container-dependency-lookup.xml";
        //Returns:the number of bean definitions found
        int beanCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println(beanCount);
        lookupCollectionByType(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合查找" + users);
        }
    }

}
