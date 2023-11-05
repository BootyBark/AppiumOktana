package org.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class MobileDriver {
    public static AppiumDriver driver = null;
    public static Properties properties;
    private static String stringURL = "http://0.0.0.0:4723/wd/hub";
    private static String platform;

    private static String sessionId = null;

    public static AppiumDriver setUpDriver() {
        properties = new Properties();
        try {
            InputStream input = MobileDriver.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
        } catch (Exception ignored) {
        }

        boolean browserstackExecution = Boolean.parseBoolean(properties.getProperty("browserstack.execution"));
        //String deviceName = properties.getProperty("device.name");
        //String platformVersion = properties.getProperty("platform.version");
        platform = properties.getProperty("platform");
        String appPath = properties.getProperty("app");

        DeviceProperties deviceProperties = new DeviceProperties();

        URL url = null;

        try {
            url = new URL(stringURL);
        } catch (Exception ignored) {
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability(MobileCapabilityType.APP, appPath);

        switch (platform.toLowerCase()) {
            case "ios":
                String iOSDeviceName = deviceProperties.getiOSDeviceName();
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, iOSDeviceName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceProperties.getiOSDeviceVersion(iOSDeviceName));
                if (sessionId == null && !browserstackExecution) {
                    driver = new IOSDriver(url, capabilities);
                } else if (sessionId == null) {
                    driver = new IOSDriver(getBrowserStackURL(), capabilities);
                }
                break;
            case "android":
                String androidDeviceName = deviceProperties.getAndroidDeviceName();
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability("appWaitPackage", "com.wdiodemoapp");
                capabilities.setCapability("appWaitActivity", "com.wdiodemoapp.MainActivity");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, androidDeviceName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceProperties.getAndroidDeviceVersion(androidDeviceName));
                if (sessionId == null && !browserstackExecution) {
                    driver = new AndroidDriver(url, capabilities);
                } else if (sessionId == null) {
                    driver = new AndroidDriver(getBrowserStackURL(), capabilities);
                }
        }
        return driver;
    }

    public static AppiumDriver getInstance() {
        try {
            sessionId = null;
            sessionId = driver.getSessionId().toString();
        } catch (NullPointerException ignored) {

        }
        if (sessionId == null) {
            setUpDriver();
        }
        return driver;
    }

    public static URL getBrowserStackURL(){
        properties = new Properties();
        try {
            InputStream input = MobileDriver.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
        } catch (Exception ignored) {
        }

        URL url;
        String BSUsername = properties.getProperty("browserstack.user.name");
        String BSAccessKey = properties.getProperty("browserstack.access.key");
        try {
            url = new URL(
                    "https://"
                            + BSUsername
                            + ":"
                            + BSAccessKey
                            + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
