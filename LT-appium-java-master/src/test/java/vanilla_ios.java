// import java.net.MalformedURLException;
// import java.net.URL;

// import org.openqa.selenium.By;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import io.appium.java_client.AppiumDriver;
// import io.appium.java_client.MobileElement;

// public class vanilla_ios {
//     public static String userName = "rishabhsinghlambdatest"; // Add username here
//     public static String accessKey = "MtmThl1OkRKinMaMQ9qg9BZ2xgf8NhK0G30HMJ7VCudgcFvNt9"; // Add accessKey here
//     private static AppiumDriver driver;

//     public static void main(String args[]) throws MalformedURLException {
//         try {
//             DesiredCapabilities capabilities = new DesiredCapabilities();
//             capabilities.setCapability("deviceName", "iPhone.*");
//             capabilities.setCapability("platformVersion", "16");
//             capabilities.setCapability("platformName", "iOS");
//             capabilities.setCapability("isRealMobile", true);
//             capabilities.setCapability("enableImageInjection", true);
//             capabilities.setCapability("media", "lt://MEDIA6adda9b4865e43499f3a684daec33dd2"); // Replace with the

//             capabilities.setCapability("app", "lt://APP10160601911694074417895483"); // Enter your app URL
//             capabilities.setCapability("deviceOrientation", "PORTRAIT");
//             capabilities.setCapability("build", "Java Vanilla - Android");
//             capabilities.setCapability("name", "Sample Test Java");
//             capabilities.setCapability("console", true);
//             capabilities.setCapability("network", false);
//             capabilities.setCapability("visual", true);
//             capabilities.setCapability("devicelog", true);

//             driver = new AppiumDriver(
//                     new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
//                     capabilities);

//             WebDriverWait wait = new WebDriverWait(driver, 30); // Define the WebDriverWait object

//             // Handling permissions
//             MobileElement allowButton = (MobileElement) wait.until(ExpectedConditions
//                     .elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name='Take Picture']")));
//             allowButton.click();

//             String mediaUrl = "lt://MEDIA6adda9b4865e43499f3a684daec33dd2";
//             driver.executeScript("lambda-image-injection=" + mediaUrl);

//             // Clicking on shutter button
//             MobileElement shutterButton = (MobileElement) wait.until(ExpectedConditions
//                     .elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"PhotoCapture\"]")));
//             shutterButton.click();

//             // Clicking on shutter button again
//             MobileElement shutterButton2 = (MobileElement) wait.until(ExpectedConditions
//                     .elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name=\"Use Photo\"]")));
//             shutterButton2.click();

//             // Close the driver after the test execution is complete
//             driver.quit();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AllowGeoLocationPopupInLambdaTest {
    public static final String LAMBDATEST_USERNAME = "YOUR_USERNAME";
    public static final String LAMBDATEST_ACCESS_KEY = "YOUR_ACCESS_KEY";
    public static final String LAMBDATEST_URL = "https://" + LAMBDATEST_USERNAME + ":" + LAMBDATEST_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();

        // Set Chrome options to allow geolocation
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        // Set capability for ChromeOptions
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        // Initialize WebDriver with LambdaTest URL and capabilities
        WebDriver driver = new RemoteWebDriver(new URL(LAMBDATEST_URL), caps);

        // Open a website that requests geolocation
        driver.get("https://the-internet.herokuapp.com/geolocation");

        // Perform actions on the webpage, e.g., clicking buttons or interacting with elements
        // In your case, you might interact with the location popup here

        // Sleep for a few seconds to allow interaction with the webpage
        Thread.sleep(5000);

        // Quit the WebDriver session
        driver.quit();
    }
}

