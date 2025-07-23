package pojo;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class SportsTabsPage extends BasePage{

    // Define locators using AppiumBy for accessibility ID
    private By footballTab = AppiumBy.accessibilityId("football-home");
    private By cricketTab = AppiumBy.accessibilityId("cricket-home");
    private By kabaddiTab = AppiumBy.accessibilityId("kabaddi-home");
    private By basketBallTab = AppiumBy.accessibilityId("basketball-home");
    private By error = By.xpath("//android.widget.TextView[@text='No matches Available']");

    // Getter methods for each locator
    public By getFootballTab() {
        return footballTab;
    }

    public By getCricketTab() {
        return cricketTab;
    }

    public By getBasketBallTabTab() {
        return basketBallTab;
    }

    public By getErrorMessage() {
        return error;
    }

}
