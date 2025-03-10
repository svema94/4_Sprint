package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser) {
        if ("firefox".equalsIgnoreCase(browser)) {
            // Устанавливаем путь к драйверу GeckoDriver
            System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/bin/geckodriver.exe");
            return new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(browser)) {
            // Устанавливаем путь к драйверу ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:/Program Files/WebDriver/bin/chromedriver-win64/chromedriver.exe");
            return new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
