package Act;

import Pages.RentPage;

public class RentPageAct {
    RentPage rentPage;

    public RentPageAct(RentPage rentPage) {
        this.rentPage = rentPage;
    }

    public void verifyRentPageIsOpened() {
        rentPage.isMainTitleDisplayed();
    }

    public void selectDateFromCalendar(String date) {
        rentPage.selectDate(date);
    }

    public void selectPartOfDay(String partOfDay) {
        rentPage.selectPartOfDay(partOfDay);
    }

    public void selectScooterColour(String colour) {
        rentPage.selectColour(colour);
    }

    public void fillCommentField(String comment) {
        rentPage.fillCommentField(comment);
    }

    public void clickOrderButtonToCompleteRent() {
        rentPage.clickToOrderButton();
    }

    public void verifyPreCompletePopUpIsOpened() {
        rentPage.isPreCompletePopUpTitleDisplayed();
    }

    public void clickAgreeButtonOnPreCompletePopUp() {
        rentPage.clickToAgreeButtonOnPreCompletePopUp();
    }

    public void verifyCompleteScooterOrder() {
        rentPage.checkCompleteTitleFormSuccessPopUp();
    }
}
