import config.DriverObject;
import config.FactoryInit;
import org.testng.annotations.BeforeTest;
import pages.GoEuroPage;


/**
 * Created by dmytro_moskalenko2 on 2/4/2016.
 */
public class MainTest {

    public DriverObject fireFoxDriver;
    public FactoryInit pageFactory;
    public GoEuroPage goEuroFactory;


    @BeforeTest
    public void driverInit() {
        fireFoxDriver = new DriverObject();
        fireFoxDriver.driverInit();
        pageFactory = new FactoryInit();
        goEuroFactory = pageFactory.goEuroPageFactory(fireFoxDriver);


    }


}
