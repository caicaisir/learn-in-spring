package spring.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring.ioc.overview.dependency.domain.User;

public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //1.BeanDefinitionBuilder构建
//        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
//        builder.addPropertyValue("id",3L);
//        builder.addPropertyValue("name","test3");
//        //这里的定义并非终态，后续可修改
//        BeanDefinition beanDefinition = builder.getBeanDefinition();

        //2.AbstractBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id",3L).add("name","test3");
        genericBeanDefinition.setPropertyValues(propertyValues);

        System.out.println(genericBeanDefinition);
    }
}
