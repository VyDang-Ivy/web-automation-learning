package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;

public class LoginTestMod03 {

    public static void main(String[] args) {

        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
        // Navigate to the target page
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPageMod03 loginPage = new LoginPageMod03(driver);
        loginPage.loginFormComp().inputUsername("test@sth.com");
        loginPage.loginFormComp().inputPassword("12345678");
        loginPage.loginFormComp().clickOnLoginBtn();

        } catch (Exception e) {
        e.printStackTrace();
    }

    // Quit browser session

        driver.quit();

    // Implicit wait, explicit wait, Fluent wait
    }

}
