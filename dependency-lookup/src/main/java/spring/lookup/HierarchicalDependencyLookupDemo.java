package spring.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @link HierarchyDependencyLookup
 *  BeanFactoryUtils.beanOfTypeIncludingAncestors() 递归查找整个上下文
 *
 */
class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);
        applicationContext.refresh();
//        HierarchicalBeanFactory<--ConfigurableBeanFactory<--ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println(beanFactory.getParentBeanFactory());
        beanFactory.setParentBeanFactory(setParentBeanfactory());
        System.out.println(beanFactory.getParentBeanFactory());
        applicationContext.close();
    }

    private static BeanFactory setParentBeanfactory() {
        //通过BeanFactory实现ioc
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath*:container-dependency-injection.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(location);
        return beanFactory;
    }

}
