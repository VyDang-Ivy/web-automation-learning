package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class IFrame_Lesson17 implements Urls {

    public static void main(String[] args) {
        // Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to target base

            driver.get(baseUrl.concat(iframeSlug));

            // Locate iframe
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameEle = driver.findElement(iFrameSel);

            // Switch to the iframe
            driver.switchTo().frame(iFrameEle);

            // Locate element inside the iframe
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("This is the new text value....");
            Thread.sleep(1000);

            // Switch back to parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
