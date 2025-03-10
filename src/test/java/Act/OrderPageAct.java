package Act;

import Pages.OrderPage;

public class OrderPageAct {
    OrderPage orderPage;


    public OrderPageAct(OrderPage orderPage) {
        this.orderPage = orderPage;
    }

    public void verifyOrderPageIsOpened(){
        orderPage.isMainTitleDisplayed();
    }

    public void inputNameField(String name){
        orderPage.inputNameField(name);
    }

    public void inputFamilyNameField(String familyNameValue){
        orderPage.inputFamilyNameField(familyNameValue);
    }

    public void inputAddressField(String addressValue){
        orderPage.inputAddressField(addressValue);
    }

    public void inputPhoneField(String phoneValue){
        orderPage.inputPhoneField(phoneValue);
    }

    public void selectSubwayStation(String subwayStation){
        orderPage.clickToSubWayStationsSelector();
    }

    public void clickToNextButton() {
        orderPage.clickToNextButton();
    }
}