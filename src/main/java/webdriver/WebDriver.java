package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriver {

    public List<String> findAllLinks(String address) {

        List<String> links = startDriver(address);
        printAllLinks(links, address);

        return links;
    }

    private List<String> startDriver(String address) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--headless=new");

        org.openqa.selenium.WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(address);

        List<String> links = driver.findElements(By.tagName("a")).stream().map(a -> a.getText() + " - " + a.getDomAttribute("href")).toList();

        driver.close();

        return links;
    }

    public void printAllLinks(List<String> links, String adress) {
        System.out.println("Adress: " + adress);
        System.out.println("Number of links found: " + links.size());
        links.forEach(System.out::println);
    }

}
