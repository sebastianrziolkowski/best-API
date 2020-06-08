package sebastianrziolkowski.com.github.bestAPI.staticClass.services;

import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.Device;

import java.util.ArrayList;
import java.util.List;

public class arrayListService {

    public static List<Device> listOfDeviceWithoutSpecificElement(List<Device> list) {
        list.removeIf(device -> !device.isAvailable());
        return list;
    }
}
