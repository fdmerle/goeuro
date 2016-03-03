package config;

import org.openqa.selenium.support.PageFactory;
import pages.GoEuroPage;


/**
 * Created by dmytro_moskalenko2 on 2/1/2016.
 */
public class FactoryInit {

    public GoEuroPage goEuroPageFactory(DriverObject driver) {
        GoEuroPage goEuroPageExemplar = new GoEuroPage(driver);
        PageFactory.initElements(goEuroPageExemplar.getDriverObject().getDriver(), goEuroPageExemplar);
        return goEuroPageExemplar;
    }


}
