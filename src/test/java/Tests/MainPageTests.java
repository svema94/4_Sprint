package Tests;

import Pages.MainPage;
import Pages.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Key.KeyTest;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainPageTests extends KeyTest {

    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;

    // Конструктор для получения параметров
    public MainPageTests(String name, String surname, String address, String metroStation, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    // Аннотируем метод, который будет предоставлять параметры для каждого теста
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Ирина", "Иванова", "Кутузовская 32", "Кутузовская", "+7981234568"},
                {"Павел", "Попов", "Кутузовская 32", "Кутузовская", "+7901234567"}
        });
    }

    @Test
    public void orderScooterTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonOrderTop();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.createOrderFirstStep(name, surname, address, metroStation, phoneNumber)
                .createOrderSecondStep()
                .checkOrderStatus();
    }

    @Test
    public void orderScooterBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBottomOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.createOrderFirstStep(name, surname, address, metroStation, phoneNumber)
                .createOrderSecondStep()
                .checkOrderStatus();
    }
}