import org.junit.Test;
import webdriver.WebConstants;
import webdriver.WebDriver;


public class Problem2Test {

    public final WebDriver webDriver = new WebDriver();

    @Test
    public void testWebDriver1() {
        assert webDriver.findAllLinks(WebConstants.GOOGLE_ADDRESS).size() > 0;
    }

    @Test
    public void testWebDriver2() {
        assert webDriver.findAllLinks(WebConstants.VECKA_ADDRESS).size() == 0;
    }

}
