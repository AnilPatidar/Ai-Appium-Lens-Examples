package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> wait  = new ThreadLocal<>();
    public ThreadLocal<JavascriptExecutor> js  = new ThreadLocal<>();
    public static final String appPackage = "com.my11circle.android.stage";
    public ThreadLocal<String> deviceId = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return driver.get();
    }
    public void setDriver(String testPlatform) throws MalformedURLException {
        switch (testPlatform) {
            case "android": {
                // TO DO
                System.out.println("***** Android App Setup *****");

                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability("appium:deviceName", "oppo");
                androidCaps.setCapability("appium:automationName", "UIAutomator2");
                androidCaps.setCapability("appium:udid", deviceId.get()); //DeviceId from "adb devices" command
                androidCaps.setCapability("appium:platformName", "Android");
                androidCaps.setCapability("appium:platformVersion", "8.0.0");
                androidCaps.setCapability("appium:skipUnlock", "true");
                androidCaps.setCapability("appium:app", System.getProperty("user.dir") + "/src/test/resources/swiggy.apk");
                androidCaps.setCapability("appium:fullReset", "true");
                androidCaps.setCapability("appium:noReset", "false");

                androidCaps.setCapability("appium:autoGrantPermissions", "true");
                androidCaps.setCapability("appium:ignoreHiddenApiPolicyError", "true");
                androidCaps.setCapability("appium:newCommandTimeout", 600);

                androidCaps.setCapability("appium:intercept", "true");
                androidCaps.setCapability("appium:settings[ocrInvertColors]", "false");
                androidCaps.setCapability("appium:settings[ocrContrast]", -1.0);

                driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), androidCaps));
                //wait = new WebDriverWait(driver, 10);
                System.out.println("***** App session is created successfully *****");

                break;
            }
            case "ios": {
                // TO DO
                System.out.println("***** iOS App *****");
                break;
            }

            default: {
                throw  new IllegalArgumentException("Invalid platform value. Please provide a valid platform value.");
           }
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //wait = new WebDriverWait(driver, 20);
        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));
    }


    public void setDriverAlreadyLoggedIn(String testPlatform) throws MalformedURLException {
        switch (testPlatform) {
            case "android": {
                // TO DO
                System.out.println("***** Android App Setup *****");

                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability("appium:deviceName", "oppo");
                androidCaps.setCapability("appium:automationName", "UIAutomator2");
                androidCaps.setCapability("appium:udid", "540c2bae"); //DeviceId from "adb devices" command
                androidCaps.setCapability("appium:platformName", "Android");
                androidCaps.setCapability("appium:platformVersion", "8.0.0");
                androidCaps.setCapability("appium:skipUnlock", "true");
                androidCaps.setCapability("appium:app", System.getProperty("user.dir") + "/src/test/resources/files/My11circle.apk");

                androidCaps.setCapability("appium:fullReset", "false");
                androidCaps.setCapability("appium:noReset", "true");
                androidCaps.setCapability("appium:autoGrantPermissions", "true");
                androidCaps.setCapability("appium:ignoreHiddenApiPolicyError", "true");
                androidCaps.setCapability("appium:newCommandTimeout", 600);

                androidCaps.setCapability("appium:intercept", "true");

                driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), androidCaps));
                //wait = new WebDriverWait(driver, 10);
                System.out.println("***** App session is created successfully *****");

                break;
            }
            case "ios": {
                // TO DO
                System.out.println("***** iOS App *****");
                break;
            }

            default: {
                throw  new IllegalArgumentException("Invalid platform value. Please provide a valid platform value.");
            }
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //wait = new WebDriverWait(driver, 20);
        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10)));
    }

    public void infoLogs(String message) {
        System.out.println(message);
    }

}
