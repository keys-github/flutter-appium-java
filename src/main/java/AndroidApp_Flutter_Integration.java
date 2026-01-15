import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import java.net.URL;
import java.util.HashMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.flutter.FlutterIntegrationTestDriver;
import io.appium.java_client.flutter.android.FlutterAndroidDriver;

public class AndroidApp_Flutter_Integration {
    String userName = System.getenv("LT_USERNAME") == null ? "username" : System.getenv("LT_USERNAME");
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "accessKey" : System.getenv("LT_ACCESS_KEY");
    /* Flutter Integration Driver App */
    /* App ID - shoppers-app-appium-flutter-integration-driver.apk */
    String app_id = System.getenv("LT_APP_ID") == null ? "lt://APP1016046451768200860063613"
            : System.getenv("LT_APP_ID");
    String grid_url = System.getenv("LT_GRID_URL") == null ? "mobile-hub.lambdatest.com"
            : System.getenv("LT_GRID_URL");

    FlutterIntegrationTestDriver driver;

    @Test
    @Parameters(value = { "device", "version", "platform" })
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();

            ltOptions.put("w3c", true);
            /* Start - Appium Flutter Integration Driver */
            ltOptions.put("automationName", "FlutterIntegration");
            ltOptions.put("nativeFlutterLaunch", true);
            /* End - Appium Flutter Integration Driver */
            ltOptions.put("platformName", platform);
            ltOptions.put("deviceName", device);
            ltOptions.put("platformVersion", version);
            ltOptions.put("devicelog", true);
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
            ltOptions.put("region", "AP");
            ltOptions.put("build", "[Automation] Appium Flutter Integration Driver Demo on LambdaTest");
            ltOptions.put("name", "[Automation] Appium Flutter Integration Driver Demo on LambdaTest");
            ltOptions.put("app", app_id);
            ltOptions.put("language", "en");
            ltOptions.put("timezone", "Kolkata");
            ltOptions.put("manualinteraction", "true");
            /* ltOptions.put("privateCloud", true); */
            /* Appium Version - Optional */
            ltOptions.put("appiumVersion", "2.2.1");
            ltOptions.put("unicodeKeyboard", true);
            ltOptions.put("resetKeyboard", true);
            ltOptions.put("locale", "en");
            ltOptions.put("autoAcceptAlerts", true);
            ltOptions.put("isRealMobile", true);

            capabilities.setCapability("LT:Options", ltOptions);

            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new FlutterAndroidDriver(new URL(hub), capabilities);

            /* Enter the username */
            /* Check lib/screens/login.dart for the ValueKey */
            /*
             * TextFormField(
             * key: const ValueKey('username'),
             * decoration: const InputDecoration(hintText: 'Username'),
             * ),
             */
            /* For Appium Flutter Integration Driver */
            WebElement elem_username = driver.findElement(AppiumBy.flutterKey("username"));
            elem_username.click();
            Thread.sleep(1000);
            elem_username.sendKeys("himanshu.sheth@gmail.com");
            Thread.sleep(5000);

            /* Enter the password */
            WebElement elem_password = driver.findElement(AppiumBy.flutterKey("password"));
            Thread.sleep(1000);
            elem_password.sendKeys("Himanshu1!");

            Thread.sleep(3000);

            /* Click the login button */
            WebElement elem_login = driver.findElement(AppiumBy.flutterKey("login_btn"));
            elem_login.click();

            Thread.sleep(3000);

            /* Should be dynamic, only for etsting */
            driver.executeScript("lambda-status=passed");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            driver.executeScript("lambda-status=failed");
            driver.quit();
        }
    }
}