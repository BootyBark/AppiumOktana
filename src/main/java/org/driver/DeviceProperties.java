package org.driver;

import java.util.HashMap;
import java.util.Map;

public class DeviceProperties {

    String [] iOSDeviceName = {"iPhone 14 Pro", "iPhone 11", "iPhone 12 Pro", "iPhone 14"};
    String [] androidDeviceName = {"Google Pixel 5", "Google Pixel 6 Pro", "Samsung Galaxy S22 Ultra"};

    public String getiOSDeviceName(){
        int randomNumber = Utils.getRandomIntFromZeroTo(iOSDeviceName.length);
        System.out.println(randomNumber);
        return iOSDeviceName[randomNumber];
    }

    public String getiOSDeviceVersion(String key){
        System.out.println(key);
        Map<String, String> iOSDeviceAndVersion = new HashMap<>();
        iOSDeviceAndVersion.put("iPhone 14 Pro", "17.0");
        iOSDeviceAndVersion.put("iPhone 14", "17.0");
        iOSDeviceAndVersion.put("iPhone 11", "17.0");
        iOSDeviceAndVersion.put("iPhone 12 Pro", "17.0");

        return iOSDeviceAndVersion.get(key);
    }

    public String getAndroidDeviceName(){
        int randomNumber = Utils.getRandomIntFromZeroTo(androidDeviceName.length);
        System.out.println(randomNumber);
        return androidDeviceName[randomNumber];
    }

    public String getAndroidDeviceVersion(String key){
        System.out.println(key);
        Map<String, String> androidDeviceAndVersion = new HashMap<>();
        androidDeviceAndVersion.put("Google Pixel 5", "12.0");
        androidDeviceAndVersion.put("Google Pixel 6 Pro", "12.0");
        androidDeviceAndVersion.put("Samsung Galaxy S22 Ultra", "12.0");

        return androidDeviceAndVersion.get(key);
    }

}
