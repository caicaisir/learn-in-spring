package spring.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultFactory implements UserFactory, InitializingBean, DisposableBean {

    //第一
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct initialization bean");
    }

    //自定义第三
    public void initAnnotation(){
        System.out.println("Annotation initialization bean");
    }


    //第二
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet initialization bean");
    }

    //第一
    @PreDestroy
    public void prDdestory(){
        System.out.println("@PreDestroy destory bean");
    }

    //第三
    public void customDestory(){
        System.out.println("customDestory destory bean");
    }

    //第二
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destory bean");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("gc in....");
    }
}
