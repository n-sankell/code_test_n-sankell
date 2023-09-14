import org.junit.Test;
import webdriver.WebConstants;
import webdriver.WebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Problem2Test {

    public final WebDriver webDriver = new WebDriver();

    @Test
    public void testWebDriver1() {
        assertFalse(webDriver.findAllLinks(WebConstants.GOOGLE_ADDRESS).isEmpty());
    }

    @Test
    public void testWebDriver2() {
        assertTrue(webDriver.findAllLinks(WebConstants.VECKA_ADDRESS).isEmpty());
    }

}
