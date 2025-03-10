package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;


    // Локатор
    private final By faqTextLocator = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    private final By orderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    private final By scooterLogo = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]");
    private final By closePopUpCookiesButton = By.xpath(".//button[text()='да все привыкли']");

    // Метод для нажатия на кнопку "Заказать" на хедере
    public void clickOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    // Метод для нажатия на кнопку "Заказать" и в дальнейшем в отдельный шаг
    public void clickToSecondOrderButton() {
        closeCookiesIfPresent(); // Закрытие cookies, если они отображаются
        driver.findElement(orderButton).click(); // Кликаем по кнопке "Заказать"
    }

    // Метод прокрутки страницы вниз
    public void scrollDownToBottom() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    // Метод для проверки наличия текста "Вопросы о важном"
    public boolean isFaqTextDisplayed() {
        WebElement element = driver.findElement(faqTextLocator);
        return element.isDisplayed();
    }

    // Метод проверки списков
    public boolean verifyFaqAnswer(String questionLocator, String expectedAnswerText) {
        closeCookiesIfPresent(); // Закрытие cookies, если они отображаются

        // Находим элемент вопроса
        By questionBy = By.xpath(questionLocator);
        WebElement questionElement = driver.findElement(questionBy);

        // Кликаем по вопросу, чтобы раскрыть ответ
        questionElement.click();

        // Ждём, пока ответ станет видимым (если он скрыт)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By answerLocator = By.xpath(questionLocator + "/parent::div/" +
                "following-sibling::div[@data-accordion-component='AccordionItemPanel']");
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        // Проверяем, что элемент ответа существует и его текст совпадает с ожидаемым
        if (answerElement != null && answerElement.isDisplayed()) {
            return answerElement.getText().trim().equals(expectedAnswerText);
        }

        return false;
    }

    public void clickToScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void closePopUpCookies() {
        driver.findElement(closePopUpCookiesButton).click();
    }

    // Метод для закрытия pop-up с cookies, если они отображаются
    public void closeCookiesIfPresent() {
        if (driver.findElement(closePopUpCookiesButton).isDisplayed()) {
            closePopUpCookies();
        }
    }
}
