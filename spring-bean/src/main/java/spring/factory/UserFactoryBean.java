package spring.factory;

import org.springframework.beans.factory.FactoryBean;
import spring.ioc.overview.dependency.domain.User;

public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
