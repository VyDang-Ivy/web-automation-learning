package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.WaitMoreThanOneTab;
import url.Urls;

import java.time.Duration;

public class ExplicitWait_Lesson18 {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(Urls.baseUrl.concat(Urls.loginSlug));

            // Dropdown locator and element
            By testSel = By.cssSelector("#Test");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(testSel));
            wait.until(new WaitMoreThanOneTab());

            // windows/ tabs --> waitUntil tabs > 1

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
