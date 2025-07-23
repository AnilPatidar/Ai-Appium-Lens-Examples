package pojo;

import org.openqa.selenium.By;

public class MatchTilePage extends BasePage {

    // Define locators using XPath
    private By team1Locator = By.xpath("//android.widget.TextView[contains(@text,'APPIUM')]");
    private By team2Locator = By.xpath("//android.widget.TextView[@text='SELENIUM']");
    private By seriesNameLocator = By.xpath("//android.widget.TextView[@text='The Official Appium Conference 2024']");

    // Getter methods for locators
    public By getTeam1Locator() {
        return team1Locator;
    }

    public By getTeam2Locator() {
        return team2Locator;
    }

    public By getSeriesNameLocator() {
        return seriesNameLocator;
    }

}
