package spring.factory;

import spring.ioc.overview.dependency.domain.User;

public interface UserFactory {
    default User createUser() {
        return new User();
    }
}
