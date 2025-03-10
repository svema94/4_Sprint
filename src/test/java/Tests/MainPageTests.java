package Tests;

import Act.MainPageAct;
import Act.OrderPageAct;
import Act.RentPageAct;
import Key.KeyTest;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import Pages.MainPage;
import Pages.OrderPage;
import Pages.RentPage;

public class MainPageTests extends KeyTest {

    private MainPageAct mainPageAct;
    private OrderPageAct orderPageAct;
    private RentPageAct rentPageAct;

    @Before
    public void setUp() {
        super.setUp(); // Инициализация WebDriver в KeyTest

        // Инициализация страниц и шагов с готовым driver
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentPage rentPage = new RentPage(driver);

        mainPageAct = new MainPageAct(mainPage);
        orderPageAct = new OrderPageAct(orderPage);
        rentPageAct = new RentPageAct(rentPage);
    }

    @Test
    @Description("Проверка заказа скутера через кнопку 'Заказать' из хедера")
    public void checkOrderOpportunityThroughHeaderButton() {
        mainPageAct.clickOrderButtonWithCookieHandling();
        placeOrder("Кутузовская", "Ирина", "Иванова", "Кутузовская 32", "+7981234568", "Здравствуйте",
                "серая безысходность", "трое суток", "20.03.2025");
    }

    @Test
    @Description("Проверка заказа скутера через кнопку 'Заказать' из середины страницы")
    public void checkOrderOpportunityThroughMiddleButton() {
        mainPageAct.scrollToBottomOfPage();
        mainPageAct.clickOrderButtonWithCookieHandling();
        placeOrder("Кутузовская 95", "Павел", "Попов", "Кутузовская 32", "+7901234567", "Привет",
                "чёрный жемчуг", "сутки", "19.03.2025");
    }

    @Test
    @Description("Проверка работы возврата на главную страницу")
    public void checkReturnToMainPageByScooterLogo() {
        mainPageAct.clickOrderButtonWithCookieHandling();
        mainPageAct.clickOnScooterLogo();
        mainPageAct.verifyFaqTextDisplayed();
    }

    // Вспомогательный метод для размещения заказа
    private void placeOrder(String subwayStation, String name, String surname, String address, String phoneNumber, String comment,
                            String colour, String period, String orderDate) {
        orderPageAct.verifyOrderPageIsOpened();
        orderPageAct.inputNameField(name);
        orderPageAct.inputFamilyNameField(surname);
        orderPageAct.inputAddressField(address);
        orderPageAct.inputPhoneField(phoneNumber);
        orderPageAct.selectSubwayStation(subwayStation);
        orderPageAct.clickToNextButton();

        rentPageAct.verifyRentPageIsOpened();
        rentPageAct.selectDateFromCalendar(orderDate);
        rentPageAct.selectPartOfDay(period);
        rentPageAct.selectScooterColour(colour);
        rentPageAct.fillCommentField(comment);
        rentPageAct.clickOrderButtonToCompleteRent();
        rentPageAct.verifyPreCompletePopUpIsOpened();
        rentPageAct.clickAgreeButtonOnPreCompletePopUp();
        rentPageAct.verifyCompleteScooterOrder();
    }
}