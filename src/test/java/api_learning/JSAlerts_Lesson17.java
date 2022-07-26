package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JSAlerts_Lesson17 implements Urls {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.cssSelector("#result");


    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(baseUrl.concat(jsAlertsSlug));
            WebElement triggerJSAlertBtnElem;
            Alert alert;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            //JS Alert
            triggerJSAlertBtnElem = driver.findElement(jsAlertSel);
            triggerJSAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Content: " + alert.getText());
            alert.accept();
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            //JS Confirm | Cancel
            triggerJSAlertBtnElem = driver.findElement(jsAlertConfirmSel);
            triggerJSAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Content: " + alert.getText());
            alert.dismiss();
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            //JS Prompt
            triggerJSAlertBtnElem = driver.findElement(jsAlertSel);
            triggerJSAlertBtnElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Content: " + alert.getText());
            alert.sendKeys("Hello world");
            alert.accept();
            System.out.println("Result: " + driver.findElement(resultSel).getText());


        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
