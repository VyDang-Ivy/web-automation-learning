package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.WaitForElementEnable;
import url.Urls;

import java.time.Duration;

public class DynamicControl_Lesson18 implements Urls {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(baseUrl.concat(dynamicControlSlug));

            // Define parent locator | 2 forms | checkbox form + input form
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            // Checkbox form interaction
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
            if (!checkboxElem.isSelected()) checkboxElem.click();
            Thread.sleep(1000);

            // Input form interaction
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));
            if (!inputFieldElem.isEnabled()) inputBtnElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            wait.until(new WaitForElementEnable(By.cssSelector("#input-example input")));
            inputFieldElem.sendKeys("Hello i'm testing");

            // DEBUG purpose ONLY
            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
