package dependency.injection.methodinjection;

import dependency.injection.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.ioc.overview.dependency.domain.User;

import javax.annotation.Resource;

public class AnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;
    private UserHolder userHolder2;

    @Autowired
    private void init1(UserHolder userHolder){
        this.userHolder = userHolder;
    }

    @Resource
    private void init2(UserHolder userHolder2){
        this.userHolder2 = userHolder2;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnotationDependencyMethodInjectionDemo.class);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String path = "container-dependency-lookup.xml";
        reader.loadBeanDefinitions(path);
        applicationContext.refresh();
        AnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnotationDependencyMethodInjectionDemo.class);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
