package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinktestInteraction {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        // Navigate to the target page
        driver.get("https://the-internet.herokuapp.com/login");

        // Define selector values

//        By powerByLinkTextSel = By.linkText("Elemental Selenium");
        By powerByLinkTextSel = By.partialLinkText("Elemental");

        // Find elements

        WebElement powerByLinktextElem = driver.findElement(powerByLinkTextSel);

        // Interaction
        powerByLinktextElem.click();

        // DEBUG PURPOSE ONLY
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser session

        driver.quit();

        // Implicit wait, explicit wait, Fluent wait


    }
}
