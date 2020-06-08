package sebastianrziolkowski.com.github.bestAPI.models.DeviceModels;

import sebastianrziolkowski.com.github.bestAPI.staticClass.messages;
import sebastianrziolkowski.com.github.bestAPI.staticClass.services.scannerService;

import javax.persistence.*;
import java.util.Arrays;

import static sebastianrziolkowski.com.github.bestAPI.staticClass.messages.DEVICE_CATEGORY;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private DeviceCategory deviceCategory;
    private String name;
    private boolean available;

    @OneToOne(mappedBy = "device")
    private DeviceRental deviceRental;

    public Device() {
        setAvailable(true);
    }

    public Device(DeviceCategory deviceCategory, String name, DeviceRental deviceRental) {
        this.deviceCategory = deviceCategory;
        this.name = name;
        this.deviceRental = deviceRental;
        available = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceRental getDeviceRental() {
        return deviceRental;
    }

    public void setDeviceRental(DeviceRental deviceRental) {
        this.deviceRental = deviceRental;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public void setNewDevice() {
        System.out.println(messages.NAME);
        this.setName(scannerService.getString());
        System.out.println(messages.DEVICE_CATEGORY +
                messages.OPEN_PARENTHESIS +
                Arrays.toString(DeviceCategory.values()) +
                messages.CLOSE_PARENTHESIS +
                messages.COLON);
        this.setDeviceCategory(scannerService.getDeviceCategory());
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceCategory=" + deviceCategory +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", deviceRental=" + deviceRental +
                '}';
    }
}
