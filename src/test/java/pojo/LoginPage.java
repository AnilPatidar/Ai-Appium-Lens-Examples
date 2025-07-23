package pojo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    // Define locators using AppiumBy for accessibility ID
    private By mobileBy = AppiumBy.accessibilityId("reg_mobile_field");
    private By errorBy = AppiumBy.accessibilityId("reg_error_msg");

    // Define locators using By for XPath
    private By doLoginBy = By.xpath("//android.view.ViewGroup[@content-desc=\"reg_btn\"]/android.view.ViewGroup");
    private By changeNumberPathC = By.xpath("//android.widget.TextView[@text=\"Change\"]");

    // Getter methods for each locator

    public By getMobileBy() {
        return mobileBy;
    }

    public By getDoLoginBy() {
        return doLoginBy;
    }

    public By getErrorBy() {
        return errorBy;
    }

    public By getChangeNumber() {
        return changeNumberPathC;
    }

}
