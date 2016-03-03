import org.testng.Assert;

/**
 * Created by dmytro_moskalenko2 on 2/2/2016.
 */
public class Test extends MainTest {

    @org.testng.annotations.Test
    public void testRunner() {
        goEuroFactory.loadPage();
        goEuroFactory.startTheSearch("Berlin", "Prague");
        Assert.assertEquals(goEuroFactory.isSorted(), true);

    }
}
