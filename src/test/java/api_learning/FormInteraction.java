package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.ExecutionException;

public class FormInteraction {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
        // Navigate to the target page
        driver.get("https://the-internet.herokuapp.com/login");

        // Define selector values

        By usernameSel = By.id("username");
        By passwordSel = By.cssSelector("#password");
        By loginBtnSel = By.cssSelector("[type='submit']");

        // Find elements

        WebElement usernameElem = driver.findElement(By.id("username"));
        WebElement passwordElem = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtnElem = driver.findElement(By.cssSelector("[type='submit']"));

        // Get attribute value
        System.out.println("Login btn type" + loginBtnElem.getAttribute("type"));
        System.out.println("Login btn background color" + loginBtnElem.getCssValue("background-color"));

        // Interaction
        usernameElem.sendKeys("HelloKaitoKid");
        passwordElem.sendKeys("Abc@1234");
        loginBtnElem.click();

        // Go back
            driver.navigate().back();

        // Refresh page
            driver.navigate().refresh();

        // Re-interact with the element again
            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginBtnElem = driver.findElement(loginBtnSel);
            usernameElem.sendKeys("Tester");
            passwordElem.sendKeys("DemoDemo");
            loginBtnElem.click();

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
