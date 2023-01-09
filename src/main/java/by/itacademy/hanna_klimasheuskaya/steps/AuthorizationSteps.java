package by.itacademy.hanna_klimasheuskaya.steps;

import by.itacademy.hanna_klimasheuskaya.page.AuthorizationPage;
import by.itacademy.hanna_klimasheuskaya.page.EntryPage;
import by.itacademy.hanna_klimasheuskaya.page.ServicesPage;
import by.itacademy.hanna_klimasheuskaya.page.UserRoleSelectionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AuthorizationSteps {
    public void entranceThoughSUDIR() {
        EntryPage entryPage = new EntryPage();
        entryPage.clickEntrySUDIRButton();
    }

    public void loginWithAuthorization(String login, String password) {
        EntryPage entryPage = new EntryPage();
        entryPage.clickEntrySUDIRButton();

        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.typeInputLogin(login);
        authorizationPage.typeInputPassword(password);
        authorizationPage.clickAuthorizationButton();
        try {
            if (authorizationPage.isDisplayedErrorMessage()) {
                if (authorizationPage.getTextFromErrorInvalidLoginOrPasswordMessageLocator()
                        .equals(authorizationPage.ERROR_INVALID_TIME_CONNECTION_MESSAGE)) {
                    authorizationPage.typeInputPassword(password);
                    authorizationPage.clickAuthorizationButton();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void entranceWithChoosingRole(String userRole) {
        UserRoleSelectionPage roleSelectionPage = new UserRoleSelectionPage();
        WebElement webElementInputRole = roleSelectionPage.inputTextToUserRoleForm(userRole);
        webElementInputRole.sendKeys(Keys.DOWN);
        webElementInputRole.sendKeys(Keys.ENTER);
        roleSelectionPage.clickSelectButton();

        ServicesPage servicesPage = new ServicesPage();
        servicesPage.clickStandLocator();
    }

    public void loginWithValidData(String login, String password) {
        EntryPage entryPage = new EntryPage();
        entryPage.clickEntrySUDIRButton();

        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.typeInputLogin(login);
        authorizationPage.typeInputPassword(password);
        authorizationPage.clickAuthorizationButton();
    }
}
