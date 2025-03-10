package Key;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class KeyTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        // По умолчанию используем Chrome, но можно передать параметр через Maven
        String browser = System.getProperty("browser", "firefox");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/"); // URL тестового сервиса
    }

    @After
    public void tearDown() {
            driver.quit();
        }
    }

