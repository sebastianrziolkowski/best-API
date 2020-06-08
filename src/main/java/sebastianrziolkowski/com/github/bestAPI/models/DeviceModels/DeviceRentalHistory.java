package sebastianrziolkowski.com.github.bestAPI.models.DeviceModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import sebastianrziolkowski.com.github.bestAPI.models.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "device_rental_history")
public class DeviceRentalHistory extends DeviceRental {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentEndDate;

    public DeviceRentalHistory() {
    }

    public DeviceRentalHistory(User user, Device device) {
        super(user, device);
    }

    public Date getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    @Override
    public String toString() {
        return "DeviceRentalHistory{" +
                super.toString() + " " +
                "rentEndDate=" + rentEndDate +
                '}';
    }
}