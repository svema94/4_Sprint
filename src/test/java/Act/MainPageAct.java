package Act;

import Pages.MainPage;


public class MainPageAct {
    MainPage mainPage;

    public MainPageAct(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    /**
     * Нажатие на кнопку "Заказать" через хедер
     */
    public void clickOrderButtonFromHeader() {
        mainPage.clickOrderButton();
    }

    /**
     * Нажатие на кнопку "Заказать" с обработкой всплывающих окон с куками
     */
    public void clickOrderButtonWithCookieHandling() {
        mainPage.closeCookiesIfPresent();
        mainPage.clickToSecondOrderButton();
    }

    /**
     * Прокрутка страницы до конца
     */
    public void scrollToBottomOfPage() {
        mainPage.scrollDownToBottom();
    }

    /**
     * Проверка соответствия вопроса и ответа в разделе FAQ
     *
     * @param questionLocator Локатор вопроса
     * @param expectedAnswerText Ожидаемый текст ответа
     * @return true, если вопрос и ответ соответствуют друг другу
     */
    public boolean checkFaqAnswerPar(String questionLocator, String expectedAnswerText) {
        return mainPage.verifyFaqAnswer(questionLocator, expectedAnswerText);
    }

    /**
     * Нажатие на логотип самоката
     */
    public void clickOnScooterLogo() {
        mainPage.clickToScooterLogo();
    }

    /**
     * Проверка отображения текста из раздела FAQ
     */
    public void verifyFaqTextDisplayed() {
        mainPage.isFaqTextDisplayed();
    }
}