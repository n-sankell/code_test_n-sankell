package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriver {

    public List<String> findAllLinks(String address) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        org.openqa.selenium.WebDriver driver = new ChromeDriver();
        driver.get(address);

        List<WebElement> plants = driver.findElements(By.tagName("a"));

        return plants.stream().map(WebElement::getText).toList();
    }

    public void printAllLinks(List<String> links) {
        links.stream().filter(link -> !link.isEmpty()).forEach(System.out::println);
    }

}
