package by.itacademy.hanna_klimasheuskaya.ui;

import by.itacademy.hanna_klimasheuskaya.domain.User;
import by.itacademy.hanna_klimasheuskaya.page.AuthorizationPage;
import by.itacademy.hanna_klimasheuskaya.page.UserPage;
import by.itacademy.hanna_klimasheuskaya.steps.AuthorizationSteps;
import by.itacademy.hanna_klimasheuskaya.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorizationPageTest extends BaseTest {
    @Test
    void testGetTextFromNameOfHeaderAuthorizationPageLocator() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.entranceThoughSUDIR();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromNameOfHeaderAuthorizationPageLocator();
        String expectedResult = authorizationPage.HEADER_OF_AUTHORIZATION_PAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetTextFromNameOfLoginFormLocator() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.entranceThoughSUDIR();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromNameOfAuthorizationFormLocator();
        String expectedResult = authorizationPage.NAME_OF_AUTHORIZATION_FORM;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetTextFromAuthorizationButton() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.entranceThoughSUDIR();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromAuthorizationButton();
        String expectedResult = authorizationPage.NAME_AUTHORIZATION_BUTTON;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetTextFromNameOfInstructionForIncognitoLocator() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.entranceThoughSUDIR();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromNameOfInstructionForIncognitoLocator();
        String expectedResult = authorizationPage.NAME_OF_INSTRUCTION_INCOGNITO_AUTHORIZATION;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEnterWithEmptyPassword() {
        String password = "";
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithAuthorization(User.login, password);
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromErrorEmptyPasswordMessageLocator();
        String expectedResult = authorizationPage.ERROR_EMPTY_PASSWORD_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEnterWithEmptyLogin() {
        String login = "";
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithAuthorization(login, User.password);
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromErrorEmptyLoginMessageLocator();
        String expectedResult = authorizationPage.ERROR_EMPTY_LOGIN_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEnterWithInvalidLogin() {
        String login = Util.generateRandomString(5);
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithAuthorization(login, User.password);
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromErrorInvalidLoginOrPasswordMessageLocator();
        String expectedResult = authorizationPage.ERROR_INVALID_LOGIN_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEnterWithInvalidPassword() {
        String password = Util.generateRandomString(5);
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithAuthorization(User.login, password);
        AuthorizationPage authorizationPage = new AuthorizationPage();
        String actualResult = authorizationPage.getTextFromErrorInvalidLoginOrPasswordMessageLocator();
        String expectedResult = authorizationPage.ERROR_INVALID_PASSWORD_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEnterWithValidData() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithAuthorization(User.login, User.password);
        authorizationSteps.entranceWithChoosingRole(User.userRole);
        UserPage userPage = new UserPage();
        String actualResult = userPage.getTextFromUserNameLocator();
        String expectedResult = userPage.USER_NAME;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
