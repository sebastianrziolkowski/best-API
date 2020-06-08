package sebastianrziolkowski.com.github.bestAPI.models.DeviceModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import sebastianrziolkowski.com.github.bestAPI.models.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Scanner;

@Entity
@Table(name = "device_rental")
public class DeviceRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deviceId", referencedColumnName = "id")
    private Device device;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rentStartDate;



    public DeviceRental() {
    }


    public DeviceRental(User user, Device device) {
        this.user = user;
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    @Override
    public String toString() {
        return "DeviceRental{" +
                "id=" + id +
                ", user=" + user +
                ", device=" + device +
                ", rentStartDate=" + rentStartDate +
                '}';
    }
}
