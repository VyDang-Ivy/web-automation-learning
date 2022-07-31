package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import url.Urls;

public class JSExecutor_Lesson18 implements Urls {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(baseUrl.concat(floatingMenuSlug));

            // Scroll to bottom
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // DEBUG purpose ONLY
            Thread.sleep(2000);

            // Scroll to top
            javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0);");

            // DEBUG purpose ONLY
            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
