package sebastianrziolkowski.com.github.bestAPI.controller.deviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.Device;
import sebastianrziolkowski.com.github.bestAPI.repo.DeviceRepository.DeviceRepository;
import sebastianrziolkowski.com.github.bestAPI.staticClass.mappingPath;
import sebastianrziolkowski.com.github.bestAPI.staticClass.messages;
import sebastianrziolkowski.com.github.bestAPI.staticClass.services.arrayListService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeviceController {


    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping(mappingPath.DEVICES)
    public List getAllDevices() {
        System.out.println(messages.GET_ALL_DEVICES_LIST);
        List list = new ArrayList<>(deviceRepository.findAll());
        return arrayListService.listOfDeviceWithoutSpecificElement(list);
    }


    @PostMapping(mappingPath.GET_DEVICE_BY_ID)
    public Device getDeviceById(@RequestBody long deviceId) {
        return deviceRepository.findById(deviceId);
    }


    @PostMapping(mappingPath.SET_DEVICE_UNAVAILABLE)
    public void setDeviceUnavailable(@RequestBody long deviceId) {
        try {
            Device device = deviceRepository.findById(deviceId);
            device.setAvailable(false);
            deviceRepository.save(device);
            System.out.println(messages.UPDATE_DEVICE);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    @GetMapping(mappingPath.ADD_DEVICE)
    public boolean addDevice() {
        try {
            Device device = new Device();
            device.setNewDevice();
            deviceRepository.save(device);
            System.out.println(messages.DEVICE_ADDED +
                    device.toString());
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
