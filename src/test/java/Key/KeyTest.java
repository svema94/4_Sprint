package Key;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyTest {
    protected WebDriver driver;
    private static String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        // Определяем браузер
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        // Устанавливаем драйвер и создаем экземпляр браузера
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        // Максимизируем окно браузера и открываем URL
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void teardown() {
            driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}