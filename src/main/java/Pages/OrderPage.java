package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;


public class OrderPage extends KeyPage {
    // Поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция Метро
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    // Выбор найденной станции метро
    private final By firstMetroStationSelectOption = By.xpath(
            ".//button[contains(@class, 'select-search__option') and @value='1']");
    // Поле номер телефона
    private final By mobilePhoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By buttonNext = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");
    // Поле "Когда привезти самокат"
    private final By datePicker = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле срок аренды
    private final By rentalButton = By.className("Dropdown-control");
    // Элемент списка срока аренды "сутки"
    private final By oneDayRentalPeriod = By.xpath(".//div[@class = 'Dropdown-option' and text() = 'сутки']");
    // Чек-бокс цвета самоката = чёрный жемчуг
    private final By checkBoxColourBlack = By.id("black");
    // Чек-бокс цвета самоката = серая безысходность
    private final By checkBoxColourGray = By.id("grey");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text() = 'Заказать']");
    // Кнопка "Да"
    private final By confirmButton = By.xpath(".//div[contains(@class, 'Order_Modal')]//button[text() = 'Да']");
    // Сообщение о создании заказа
    private final By orderCreatedText = By.xpath(".//div[text() = 'Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

    public void setName(String name) {
        getWebDriver().findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        getWebDriver().findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        getWebDriver().findElement(addressField).sendKeys(address);
    }

    public void setMetroStation(String metroStation) {
        getWebDriver().findElement(metroStationField).click();
        getWebDriver().findElement(firstMetroStationSelectOption).click();
    }

    public void setMobileNumber(String mobilePhoneNumber) {
        getWebDriver().findElement(mobilePhoneNumberField).sendKeys(mobilePhoneNumber);
    }

    public void clickButtonNext() {
        getWebDriver().findElement(buttonNext).click();
        new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(datePicker));
    }

    public void inputDateNextDay() {
        String date = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        getWebDriver().findElement(datePicker).sendKeys(date);
        getWebDriver().findElement(datePicker).sendKeys(Keys.ENTER);
    }

    public void selectRentalPeriod() {
        getWebDriver().findElement(rentalButton).click();
        new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(oneDayRentalPeriod));
        getWebDriver().findElement(oneDayRentalPeriod).click();
    }

    public void selectBlackColour() {
        getWebDriver().findElement(checkBoxColourBlack).click();
    }

    public void selectGrayColour() {
        getWebDriver().findElement(checkBoxColourGray).click();
    }

    public void clickOrderButton() {
        getWebDriver().findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        new WebDriverWait(getWebDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
        getWebDriver().findElement(confirmButton).click();
    }

    public void checkOrderStatus() {
        new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderCreatedText));
        Assert.assertTrue("Не отобразилось сообщение об успешном создании заказа",
                getWebDriver().findElement(orderCreatedText).isDisplayed());
    }

    public OrderPage createOrderFirstStep(String name, String surname, String address, String metroStation, String mobilePhoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStation);
        setMobileNumber(mobilePhoneNumber);
        clickButtonNext();
        return this;
    }

    public OrderPage createOrderSecondStep() {
        inputDateNextDay();
        selectRentalPeriod();
        selectBlackColour();
        selectGrayColour();
        clickOrderButton();
        clickConfirmButton();
        return this;
    }
}