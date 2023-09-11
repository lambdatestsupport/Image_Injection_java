import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class vanilla_android {
    public static String userName = "rishabhsinghlambdatest"; // Add username here
    public static String accessKey = "7f4Xoi2I7A1H7f4Y84emKmZKhE0Cn440Obyy1WGIcud425cWei"; // Add accessKey here
    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Galaxy S20");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("enableImageInjection", true);
            capabilities.setCapability("media", "lt://MEDIA6adda9b4865e43499f3a684daec33dd2"); // Replace with the
                                                                                               // actual URL of the
                                                                                               // image you want to
                                                                                               // inject
            capabilities.setCapability("app", "lt://APP10160361191690887738058576"); // Enter your app URL
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("build", "Java Vanilla - Android");
            capabilities.setCapability("name", "Sample Test Java");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);

            driver = new AppiumDriver(
                    new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                    capabilities);

            WebDriverWait wait = new WebDriverWait(driver, 30); // Define the WebDriverWait object

            // Handling permissions
            MobileElement allowButton = (MobileElement) wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
            allowButton.click();

            // Clicking on button with id "com.bsstag.cameraimage:id/button"
            MobileElement buttonElement = (MobileElement) wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("com.bsstag.cameraimage:id/button")));
            buttonElement.click();

            String mediaUrl = "lt://MEDIA6adda9b4865e43499f3a684daec33dd2"; // Replace with the actual URL of the image
                                                                            // you want to inject
            driver.executeScript("lambda-image-injection=" + mediaUrl);

            // Clicking on shutter button
            MobileElement shutterButton = (MobileElement) wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("com.google.android.GoogleCamera:id/shutter_button")));
            shutterButton.click();

            // Clicking on shutter button again
            MobileElement shutterButton2 = (MobileElement) wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("com.google.android.GoogleCamera:id/shutter_button")));
            shutterButton2.click();

            // Close the driver after the test execution is complete
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
