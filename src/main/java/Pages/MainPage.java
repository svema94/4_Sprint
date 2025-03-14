package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Шаблоны XPath
    private final String orderButtonXpathTemplate = "(.//button[text() = 'Заказать'])[%s]";
    private final String questionXpathTemplate = ".//div[@id='accordion__heading-%s']/parent::div";
    private final String answerXpathTemplate = ".//div[@id='accordion__panel-%s']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Кликаем по верхней кнопке "Заказать"
    public void clickButtonOrderTop() {
        WebElement button = findElementAndScroll(By.xpath(String.format(orderButtonXpathTemplate, 1)));
        button.click();
    }

    // Проверяем, что ответ скрыт
    public MainPage checkAnswerIsHidden(int index) {
        By answerLocator = By.xpath(String.format(answerXpathTemplate, index));
        WebElement answerElement = wait.until(ExpectedConditions.presenceOfElementLocated(answerLocator)); // Ждем присутствия элемента
        Assert.assertFalse(answerElement.isDisplayed()); // Проверяем, что элемент скрыт
        return this;
    }

    // Проверяем, что ответ отображается с правильным текстом
    public void checkAnswerIsDisplayedWithText(int index, String expectedText) {
        By answerLocator = By.xpath(String.format(answerXpathTemplate, index));
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator)); // Ждем видимости элемента
        String actualText = answerElement.getText();
        Assert.assertEquals("Фактический текст ответа не совпал с ожидаемым", expectedText, actualText);
    }

    // Кликаем по вопросу
    public MainPage clickQuestionButton(int number) {
        WebElement question = findElementAndScroll(By.xpath(String.format(questionXpathTemplate, number)));
        question.click();
        return this;
    }

    // Кликаем по нижней кнопке "Заказать"
    public void clickBottomOrderButton() {
        WebElement orderButton = findElementAndScroll(By.xpath(String.format(orderButtonXpathTemplate, 1)));
        orderButton.click();
    }

    // Вспомогательные методы

    // Найти элемент и прокрутить к нему
    private WebElement findElementAndScroll(By locator) {
        WebElement element = driver.findElement(locator);
        scrollTo(element);
        return element;
    }

    // Прокрутка к элементу
    private void scrollTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}