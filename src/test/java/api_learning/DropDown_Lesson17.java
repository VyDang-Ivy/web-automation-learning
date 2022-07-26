package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class DropDown_Lesson17 implements Urls {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(baseUrl.concat(dropdownSlug));

            // Dropdown locator & element
            By dropdownSel = By.id("dropdown");
            WebElement dropdownElement = driver.findElement(dropdownSel);

            // Select dropdown
            Select select = new Select(dropdownElement);

            // Select by visible text | Option 1
            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            // Select by index | Option 2
            select.selectByIndex(2);
            Thread.sleep(1000);

            // Select by value | Option 1
            select.selectByValue("1");
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
