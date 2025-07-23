package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.HttpMethod;
import org.testng.annotations.*;
import pojo.LoginPage;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

public class AI_Test_Android extends DriverManager {

    private final ObjectMapper mapper = new ObjectMapper();
    public AppiumDriver driver;
    public static final String appPackage = "com.my11circle.android.stage";

    LoginPage loginPage = new LoginPage();


    @Parameters("platform")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("platform") String platform)
                                    throws MalformedURLException {
        //deviceId.set("EQJZH6VONZA6TSWW");
        //setDriver("android");

    }

    public void letPreviousActionPerformed() throws InterruptedException {
        Thread.sleep(5000);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void androidAskAndAIClick() throws MalformedURLException {

        //TODO- Change device id to your device id
        deviceId.set("EQJZH6VONZA6TSWW");
        setDriver("android");

        getDriver().addCommand(HttpMethod.POST,
                "/session/:sessionId/plugin/askAI",
                "askAI");
        getDriver().addCommand(HttpMethod.POST,
                "/session/:sessionId/plugin/aiClick",
                "aiClick");

        //Uses Google Vision AI
        getDriver().execute("aiClick",
                ImmutableMap.of("text","GAMES",
                        "index",1,
                        "takeANewScreenShot",true
                ));

        //Google Vertex AI
        Response result =  getDriver().execute("askAI",
                ImmutableMap.of("instruction",
                        "What is the match status of india in Australia?" ));
      //  System.out.println(result.getValue());


    }

    public void clickByAI(Response result,String text){
        System.out.println("Clicking on "+text+ " by AI");
        Map<String, Object> resultMap = (Map<String, Object>) result.getValue();
        int pixelRatio= 2;
        int X =  Integer.valueOf(String.valueOf(resultMap.get("x")))/pixelRatio;
        int Y =  Integer.valueOf(String.valueOf(resultMap.get("y")))/pixelRatio;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), X, Y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction (new Pause(finger, Duration.ofMillis(0)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(tap));
    }
}
