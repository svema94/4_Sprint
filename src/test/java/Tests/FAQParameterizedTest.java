package Tests;

import Act.MainPageAct;
import Key.KeyTest;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FAQParameterizedTest extends KeyTest {

    private MainPageAct mainPageSteps;

    // Локаторы вопросов в FAQ
    private static final String QUESTION_LOCATOR_TEMPLATE = "//div[text()='%s']";

    // Параметры для теста
    @Parameterized.Parameter(0)
    public String questionText; // Текст вопроса

    @Parameterized.Parameter(1)
    public String expectedAnswer; // Ожидаемый текст ответа

    @Parameterized.Parameters(name = "Проверка FAQ: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один" +
                        " самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. " +
                        "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, " +
                        "когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если " +
                        "что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой." +
                        " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои."},
                {"Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        });
    }

    @Before
    public void setUp() {
        super.setUp(); // Инициализация WebDriver из BaseTest
        mainPageSteps = new MainPageAct(new Pages.MainPage(driver));
    }

    @Test
    @Description("Проверка соответствия вопросов и ответов в FAQ")
    public void checkFaqAnswer() {
        mainPageSteps.scrollToBottomOfPage(); // Скроллим страницу до блока с вопросами

        // Формируем XPath локатора для текущего вопроса
        String questionLocator = String.format(QUESTION_LOCATOR_TEMPLATE, questionText);

        // Проверяем вопрос и ответ
        boolean isAnswerCorrect = mainPageSteps.checkFaqAnswerPar(questionLocator, expectedAnswer);

        // Проверяем, что ответ отображается корректно
        assertTrue("Ответ не соответствует ожидаемому для вопроса: " + questionText, isAnswerCorrect);
    }
}
