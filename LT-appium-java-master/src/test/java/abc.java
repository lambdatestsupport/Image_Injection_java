import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class abc {
    public static final String LAMBDATEST_USERNAME = "rishabhsinghlambdatest";
    public static final String LAMBDATEST_ACCESS_KEY = "MtmThl1OkRKinMaMQ9qg9BZ2xgf8NhK0G30HMJ7VCudgcFvNt9";
    public static final String LAMBDATEST_URL = "https://" + LAMBDATEST_USERNAME + ":" + LAMBDATEST_ACCESS_KEY
            + "@hub.lambdatest.com/wd/hub";

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

        // Perform actions on the webpage, e.g., clicking buttons or interacting with
        // elements
        // In your case, you might interact with the location popup here

        // Sleep for a few seconds to allow interaction with the webpage
        Thread.sleep(5000);

        // Quit the WebDriver session
        driver.quit();
    }
}

public class abc {

}
