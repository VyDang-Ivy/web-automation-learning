package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if (OS.isFamilyWindows()){
            System.out.println(currentProjectLocation);
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }

        if (OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/drivers/chromedriver.exe";
        }

        if (chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS Type!");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
 //       driver.manage().window().maximize();
        driver.get("https://learn.sdetpro.com");

        //DEBUG PURPOSE ONLY
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
