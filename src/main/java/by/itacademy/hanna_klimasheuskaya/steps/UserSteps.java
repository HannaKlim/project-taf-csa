package by.itacademy.hanna_klimasheuskaya.steps;

import by.itacademy.hanna_klimasheuskaya.enums.Confirmation;
import by.itacademy.hanna_klimasheuskaya.enums.Gender;
import by.itacademy.hanna_klimasheuskaya.page.UserPage;
import by.itacademy.hanna_klimasheuskaya.util.Util;

public class UserSteps {
    public void createCardOfPSU(String surname, String name, String patronymic, Gender value,
                                Confirmation surnameConfirmationValue, Confirmation nameConfirmationValue, Confirmation patronymicConfirmationValue) {
        UserPage userPage = new UserPage();
        userPage.clickCreateUserFormButton();
        userPage.typeInputSurname(surname);
        userPage.typeInputSurnameConfirmation(surnameConfirmationValue);
        userPage.typeInputName(name);
        userPage.typeInputNameConfirmation(nameConfirmationValue);
        userPage.typeInputPatronymic(patronymic);
        userPage.typeInputPatronymicConfirmation(patronymicConfirmationValue);
        userPage.clickInputGender(value);
        userPage.clickSaveUserFormButton();
        Util.waiter();
        userPage.clickCloseUserFormButton();
    }

    public void createCardOfPSUWithoutGender(String surname, String name, String patronymic,
                                             Confirmation surnameConfirmationValue, Confirmation nameConfirmationValue, Confirmation patronymicConfirmationValue) {
        UserPage userPage = new UserPage();
        userPage.clickCreateUserFormButton();
        userPage.typeInputSurname(surname);
        userPage.typeInputSurnameConfirmation(surnameConfirmationValue);
        userPage.typeInputName(name);
        userPage.typeInputNameConfirmation(nameConfirmationValue);
        userPage.typeInputPatronymic(patronymic);
        userPage.typeInputPatronymicConfirmation(patronymicConfirmationValue);
        userPage.clickSaveUserFormButton();
    }

    public void searchCreatedCardOfPSU(String surname, String name, String patronymic) {
        UserPage userPage = new UserPage();
        userPage.typeInputLastnameSearch(surname);
        userPage.typeInputFirstnameSearch(name);
        userPage.typeInputPatronymicSearch(patronymic);
        userPage.clickSearchUserFormButton();
    }
}

