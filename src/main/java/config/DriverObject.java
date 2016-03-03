package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class DriverObject {
    private WebDriver driver;

    public void driverInit() {

        driver = new FirefoxDriver();

    }

    public WebDriver getDriver() {
        return driver;
    }


    public void waitTillElementLoaded(String locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }

    public boolean waitForAttribute(WebElement element, String attribute, String attributeValue, int wait) {

        for (int i = 0; i < wait; i++) {
            if (element.getAttribute(attribute).equals(attributeValue)) {
                return true;
            }
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }

        return false;
    }


    public void waitTillElementClickable(WebElement locator, int coolDown) {
        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        waiter.until(ExpectedConditions.elementToBeClickable(locator));

    }

}
