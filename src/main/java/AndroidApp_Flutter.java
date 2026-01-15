import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import java.net.URL;
import java.util.HashMap;

/* Start - For FlutterFinder */
import io.github.ashwith.flutter.FlutterFinder;
/* End - For FlutterFinder */

public class AndroidApp_Flutter {
    String userName = System.getenv("LT_USERNAME") == null ? "username" : System.getenv("LT_USERNAME");
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "accessKey" : System.getenv("LT_ACCESS_KEY");
    /* App ID - shoppers-app-appium-flutter-driver.apk */
    String app_id = System.getenv("LT_APP_ID") == null ? "lt://APP10160562291768200499649630"
            : System.getenv("LT_APP_ID");
    String grid_url = System.getenv("LT_GRID_URL") == null ? "mobile-hub.lambdatest.com"
            : System.getenv("LT_GRID_URL");

    AppiumDriver driver;

    @Test
    @Parameters(value = { "device", "version", "platform" })
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();

            /* Start - Appium Flutter Driver */
            ltOptions.put("automationName", "Flutter");
            ltOptions.put("nativeFlutterLaunch", true);
            /* End - Appium Flutter Driver */

            ltOptions.put("w3c", true);
            ltOptions.put("platformName", platform);
            ltOptions.put("deviceName", device);
            ltOptions.put("platformVersion", version);
            ltOptions.put("devicelog", true);
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
            ltOptions.put("language", "en");
            ltOptions.put("region", "AP");
            /* ltOptions.put("privateCloud", true); */
            /* Appium Version - Optional */
            ltOptions.put("appiumVersion", "2.2.1");
            ltOptions.put("unicodeKeyboard", true);
            ltOptions.put("resetKeyboard", true);
            ltOptions.put("locale", "en");
            ltOptions.put("autoAcceptAlerts", true);
            ltOptions.put("isRealMobile", true);
            ltOptions.put("app", app_id);
            ltOptions.put("timezone", "Kolkata");
            ltOptions.put("manualinteraction", "true");
            ltOptions.put("build", "[Automation] Appium Flutter Driver Demo on LambdaTest");
            ltOptions.put("name", "[Automation] Appium Flutter Driver Demo on LambdaTest");

            capabilities.setCapability("LT:Options", ltOptions);

            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new AndroidDriver(new URL(hub), capabilities);

            FlutterFinder finder = new FlutterFinder(driver);

            /* Enter the username */
            /* Check lib/screens/login.dart for the ValueKey */
            /*
             * TextFormField(
             * key: const ValueKey('username'),
             * decoration: const InputDecoration(hintText: 'Username'),
             * ),
             */
            WebElement elem_username = finder.byValueKey("username");
            elem_username.click();
            Thread.sleep(1000);
            elem_username.sendKeys("himanshu.sheth@gmail.com");
            Thread.sleep(3000);

            /* Enter the password */
            WebElement elem_password = finder.byValueKey("password");
            Thread.sleep(1000);
            elem_password.sendKeys("Himanshu1!");

            /* Click the login button */
            WebElement elem_login = finder.byValueKey("login_btn");
            elem_login.click();
            Thread.sleep(3000);

            /* LambdaTest Hooks */
            driver.executeScript("lambda-status=passed");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            driver.executeScript("lambda-status=failed");
            driver.quit();
        }
    }
}