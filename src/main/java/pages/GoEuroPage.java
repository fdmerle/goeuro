package pages;

import config.DriverObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 3/3/2016.
 */
public class GoEuroPage extends MainPage {

    @FindBy(xpath = ".//*[@id='from_filter']")
    private WebElement departureAirportField;
    @FindBy(xpath = ".//*[@id='to_filter']")
    private WebElement arialAirportField;
    @FindBy(xpath = ".//*[@id='search-form__submit-btn']")
    private WebElement submitButton;
    @FindBy(xpath = ".//*[@id='header-langswitch']/a/div")
    private WebElement languageOption;
    @FindBy(xpath = ".//*[@id='lang-switch--en']/a")
    private WebElement englishLocal;
    @FindBy(xpath = "//div[@class='checkboxv2']//div[@data-partner='booking']//span")
    private WebElement hotelProvider;
    private String xpathForPriceInt = ".//*[@id='results-train']//span[@class='price-no ']//span[2]";
    private String xpathForPriceDec = ".//*[@id='results-train']//span[@class='price-no ']//span[4]";


    public GoEuroPage(DriverObject _driver) {
        driver = _driver;

    }

    public DriverObject getDriverObject() {
        return driver;
    }

    public void loadPage() {
        driver.getDriver().get("http://www.goeuro.es/");

    }

    public void startTheSearch(String nameOfDepartureAirport, String nameOfArrivalAirport) {
        if (hotelProvider.getAttribute("class").equals("custom checkbox checked")) hotelProvider.click();
        changeLocal();
        driver.waitForAttribute(departureAirportField, "placeholder", "From: City, Town or Village", 10);
        departureAirportField.sendKeys(nameOfDepartureAirport);
        arialAirportField.sendKeys(nameOfArrivalAirport);
        submitButton.click();
        submitButton.submit();

    }

    public boolean isSorted() {
        List<Float> list = priceListBuilder();
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }


    public List<Float> priceListBuilder() {
        List<WebElement> intPrices = driver.getDriver().findElements(By.xpath(xpathForPriceInt));
        List<WebElement> decPrices = driver.getDriver().findElements(By.xpath(xpathForPriceDec));


        return priceBuilder(intPrices, decPrices);

    }

    private List<Float> priceBuilder(List<WebElement> list1, List<WebElement> list2) {
        List<Float> prices = new ArrayList<Float>();
        for (int i = 0; i < list1.size(); i++) {
            prices.add(Float.parseFloat(list1.get(i).getText() + "." + list2.get(i).getText()));
        }
        return prices;
    }


    private void changeLocal() {
        languageOption.click();
        englishLocal.click();


    }


}
