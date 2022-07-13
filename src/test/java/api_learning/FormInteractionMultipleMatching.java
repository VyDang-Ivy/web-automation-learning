package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

        // Navigate to the target page
        driver.get("https://the-internet.herokuapp.com/login");

        // Define selector values

        By loginInputFieldSel = By.tagName("username");

        // Interaction
        List<WebElement> loginFormFieldsElem = driver.findElements(loginInputFieldSel);
        final int USERNAME_INDEX = 0;
        final int PASSWORD_INDEX = 1;
        loginFormFieldsElem.get(USERNAME_INDEX).sendKeys("testing@hello.com");
        loginFormFieldsElem.get(PASSWORD_INDEX).sendKeys("Abc@1234");

        // DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser session

        driver.quit();

        // Implicit wait, explicit wait, Fluent wait


    }
}
