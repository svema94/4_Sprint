package Key;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class KeyTest {

    protected WebDriver driver;

    // Определяем URL как константу
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        // По умолчанию используем Chrome, но можно передать параметр через Maven
        String browser = System.getProperty("browser", "firefox");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(SCOOTER_URL); // Используем константу вместо жёстко закодированного URL
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

