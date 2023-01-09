package by.itacademy.hanna_klimasheuskaya.ui;

import by.itacademy.hanna_klimasheuskaya.domain.User;
import by.itacademy.hanna_klimasheuskaya.enums.Confirmation;
import by.itacademy.hanna_klimasheuskaya.enums.Gender;
import by.itacademy.hanna_klimasheuskaya.page.UserPage;
import by.itacademy.hanna_klimasheuskaya.steps.AuthorizationSteps;
import by.itacademy.hanna_klimasheuskaya.steps.UserSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPageTest extends BaseTest {
    protected String surname = "ВасильевАвтотестОдин";
    protected String name = "Василий";
    protected String patronymic = "Васильевич";
    protected Gender genderValue = Gender.MALE;
    protected Confirmation surnameConfirmationValue = Confirmation.WORDS;
    protected Confirmation nameConfirmationValue = Confirmation.FORGOT;
    protected Confirmation patronymicConfirmationValue = Confirmation.DOCUMENT;

    @Test
    public void createCardOfPSU() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithValidData(User.login, User.password);
        authorizationSteps.entranceWithChoosingRole(User.userRole);
        UserSteps userSteps = new UserSteps();
        userSteps.createCardOfPSU(surname, name, patronymic, genderValue, surnameConfirmationValue, nameConfirmationValue, patronymicConfirmationValue);
        userSteps.searchCreatedCardOfPSU(surname, name, patronymic);
        UserPage userPage = new UserPage();
        String actualResultOne = userPage.getTextFromUserLastnameFromSearchResultLocator();
        String actualResultTwo = userPage.getTextFromCreatedCardStatusFromSearchResultLocator();
        String expectedResultOne = surname;
        String expectedResultTwo = "Активна";

        Assertions.assertEquals(expectedResultOne, actualResultOne);
        Assertions.assertEquals(expectedResultTwo, actualResultTwo);
    }

    @Test
    public void createCardOfPSUWithEmptySurname() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        String surname = "";
        authorizationSteps.loginWithValidData(User.login, User.password);
        authorizationSteps.entranceWithChoosingRole(User.userRole);
        UserSteps userSteps = new UserSteps();
        userSteps.createCardOfPSU(surname, name, patronymic, genderValue, surnameConfirmationValue, nameConfirmationValue, patronymicConfirmationValue);
        UserPage userPage = new UserPage();
        String actualResult = userPage.getTextFromEmptyDataErrorLocator();
        String expectedResult = userPage.ERROR_EMPTY_SURNAME_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void createCardOfPSUWithEmptyName() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        String name = "";
        authorizationSteps.loginWithValidData(User.login, User.password);
        authorizationSteps.entranceWithChoosingRole(User.userRole);
        UserSteps userSteps = new UserSteps();
        userSteps.createCardOfPSU(surname, name, patronymic, genderValue, surnameConfirmationValue, nameConfirmationValue, patronymicConfirmationValue);
        UserPage userPage = new UserPage();
        String actualResult = userPage.getTextFromEmptyDataErrorLocator();
        String expectedResult = userPage.ERROR_EMPTY_NAME_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void createCardOfPSUWithEmptyGender() {
        surname = "ВасильевАвтотест";
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        authorizationSteps.loginWithValidData(User.login, User.password);
        authorizationSteps.entranceWithChoosingRole(User.userRole);
        UserSteps userSteps = new UserSteps();
        userSteps.createCardOfPSUWithoutGender(surname, name, patronymic, surnameConfirmationValue, nameConfirmationValue, patronymicConfirmationValue);
        UserPage userPage = new UserPage();
        String actualResult = userPage.getTextFromEmptyDataErrorLocator();
        String expectedResult = userPage.ERROR_EMPTY_GENDER_MESSAGE;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}

