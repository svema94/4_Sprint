package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
    private final By mainRentTitle = By.xpath("//div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    private final By dateSelectorPlaceholder = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodPlaceHolder = By.xpath("//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final By commentFieldPlaceholder = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By colorBlackCheckBox = By.xpath("//*[@id='black']");
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By preCompletePopUpTitle = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    private final By preCompletePopUpAgreeButton = By.xpath("//div[@class='Order_Modal__YZ-d3'] //button[text()='Да']");
    private final By successMessageFromCompletePopUp = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    // Конструктор класса
    public RentPage(WebDriver driver) {
        this.driver = driver;
        // Инициализируем WebDriverWait с таймаутом для всех элементов
        this.wait = new WebDriverWait(driver, 10);
    }

    // Метод для проверки тайтла страницы
    public boolean isMainTitleDisplayed() {
        return driver.findElement(mainRentTitle).isDisplayed();
    }

    // Метод для выбора даты из календаря
    public void selectDate(String date) {
        // Откройте календарь и выберите дату
        WebElement calendarInput = driver.findElement(dateSelectorPlaceholder);
        calendarInput.click();

        // Используйте динамическое формирование локатора
        By dateElementLocator = By.xpath(String.format(".//div[@class='react-datepicker__month']//div[text()='%s']", date));

        // Ожидайте появления нужного элемента и нажмите на него
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateElementLocator));
        dateElement.click();
    }

    // Метод для выбора времени суток
    public void selectPartOfDay(String period) {
        WebElement calendarInput = driver.findElement(rentalPeriodPlaceHolder);
        calendarInput.click();

        // Используйте динамическое формирование локатора
        By dayElementLocator = By.xpath(String.format(".//div[@class='Dropdown-menu']//div[text()='%s']", period));

        // Ожидайте появления нужного элемента и нажмите на него
        WebElement dayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dayElementLocator));
        dayElement.click();
    }

    // Метод для выбора цвета
    public void selectColour(String colour) {
        driver.findElement(colorBlackCheckBox).click();
    }

    // Метод для заполнения поля комментария
    public void fillCommentField(String commentValue) {
        driver.findElement(commentFieldPlaceholder).sendKeys(commentValue);
    }

    // Метод для нажатия кнопки "Заказать"
    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Метод для проверки тайтла pop-up
    public boolean isPreCompletePopUpTitleDisplayed() {
        return driver.findElement(preCompletePopUpTitle).isDisplayed();
    }

    // Метод для нажатия кнопки "Да" на pop-up
    public void clickToAgreeButtonOnPreCompletePopUp() {
        driver.findElement(preCompletePopUpAgreeButton).click();
    }

    // Метод для проверки подтверждения заказа самоката
    public boolean checkCompleteTitleFormSuccessPopUp() {
        return driver.findElement(successMessageFromCompletePopUp).isDisplayed();
    }
}
