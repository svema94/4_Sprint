package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



// Страница заказа самокат
public class OrderPage {
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    //Локаторы
    private final By mainOrderTitle = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");
    private final By inputNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputFamilyNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputPhoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By subWayStationsSelector = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By subWayStationNameCherkizovskaya = By.xpath(".//div[text()='Черкизовская']");
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']");

    public void isMainTitleDisplayed() {
        driver.findElement(mainOrderTitle).isDisplayed();
    }

    public void inputNameField(String nameValue) {
        driver.findElement(inputNameField).sendKeys(nameValue);
    }

    public void inputFamilyNameField(String familyNameValue) {
        driver.findElement(inputFamilyNameField).sendKeys(familyNameValue);
    }

    public void inputAddressField(String addressValue) {
        driver.findElement(inputAddressField).sendKeys(addressValue);
    }

    public void inputPhoneField(String phoneValue) {
        driver.findElement(inputPhoneField).sendKeys(phoneValue);
    }

    public void clickToSubWayStationsSelector() {
        WebElement dropdown = driver.findElement(subWayStationsSelector);
        dropdown.click();
        // Выбрать станцию метро "Черкизовская"
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(subWayStationNameCherkizovskaya));
        option.click();
    }

    public void clickToNextButton() {
        driver.findElement(nextButton).click();
    }
}
