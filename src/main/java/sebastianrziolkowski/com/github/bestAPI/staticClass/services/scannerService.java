package sebastianrziolkowski.com.github.bestAPI.staticClass.services;

import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.DeviceCategory;

import java.net.Proxy;
import java.util.Scanner;

public class scannerService {


    public static String getString() {
        return new Scanner(System.in).next();

    }

    public static long getLong() {
        return new Scanner(System.in).nextLong();
    }

    public static DeviceCategory getDeviceCategory() {
        return DeviceCategory.valueOf(new Scanner(System.in).next().toUpperCase());
    }
}
