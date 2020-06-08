package sebastianrziolkowski.com.github.bestAPI.models;


import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.DeviceRental;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="user")
    private Set<DeviceRental> deviceRentals;


    private String loginName;
    private String password;
    private String name;
    private String surname;
    private Integer age;


    public User(Set<DeviceRental> deviceRentals, String loginName, String password, String name, String surname, Integer age) {
        this.deviceRentals = deviceRentals;
        this.loginName = loginName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<DeviceRental> getDeviceRentals() {
        return deviceRentals;
    }

    public void setDeviceRentals(Set<DeviceRental> deviceRentals) {
        this.deviceRentals = deviceRentals;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", deviceRentals=" + deviceRentals +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
