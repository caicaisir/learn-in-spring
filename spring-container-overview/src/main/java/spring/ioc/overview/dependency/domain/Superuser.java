package spring.ioc.overview.dependency.domain;

import spring.ioc.overview.dependency.anotation.Super;

@Super
public class Superuser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Superuser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
