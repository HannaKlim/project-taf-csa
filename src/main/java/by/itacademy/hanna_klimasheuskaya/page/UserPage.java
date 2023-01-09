package by.itacademy.hanna_klimasheuskaya.page;

import by.itacademy.hanna_klimasheuskaya.enums.Confirmation;
import by.itacademy.hanna_klimasheuskaya.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static by.itacademy.hanna_klimasheuskaya.enums.Gender.FEMALE;


public class UserPage extends BasePage {
    private final By byUserNameLocator = By.xpath("//div[@role='tooltip']");
    private final By byUserIconLocator = By.xpath("//*[@id='app']/div/div[1]/div/div[2]/div/*[name()='svg'][@data-v-11f52bdc][4]");
    private final By byCreateUserFormButton = By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[2]/form/div/div[20]/div/button[2]");
    private final By byInputSurnameLocator = By.id("form_item_mainInformationSurname");
    private final By byInputNameLocator = By.id("form_item_mainInformationName");
    private final By byInputPatronymicLocator = By.id("form_item_mainInformationPatronymic");
    private final By byInputSurnameConfirmationLocator = By.id("form_item_mainInformationSurnameConfirmation");
    private final By byInputNameConfirmationLocator = By.id("form_item_mainInformationNameConfirmation");
    private final By byInputPatronymicConfirmationLocator = By.id("form_item_mainInformationPatronymicConfirmation");
    private final By byInputMaleRadioButton = By.xpath("//*[@id='form_item_mainInformationSex']/label[1]/span[1]/input");
    private final By byInputFemaleRadioButton = By.xpath("//*[@id='form_item_mainInformationSex']/label[2]/span[1]/input");
    private final By bySaveUserFormButton = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[2]");
    private final By byCloseUserFormButton = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[8]");
    private final By byInputLastnameSearchLocator = By.id("form_item_lastName");
    private final By byInputFirstnameSearchLocator = By.id("form_item_firstName");
    private final By byInputPatronymicSearchLocator = By.id("form_item_patrName");
    private final By bySearchUserFormButton = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div[2]/form/div/div[18]/div/button[2]");
    private final By byUserLastnameFromSearchResultLocator = By.xpath("//div[@class='ant-table-wrapper ant-table-striped']//td[2]");
    private final By byStatusOfCreatedCardFromSearchResultLocator = By.xpath("//div[@class='ant-table-wrapper ant-table-striped']//td[6]");
    private final By byEmptyDataErrorLocator = By.xpath("//div[@class='ant-notification-notice-description']");

    public final String USER_NAME = "Сотрудник ПОССП Максим";
    public final String ERROR_EMPTY_SURNAME_MESSAGE = "Поле \"Фамилия\" обязательно для заполнения";
    public final String ERROR_EMPTY_NAME_MESSAGE = "Поле \"Имя\" обязательно для заполнения";
    public final String ERROR_EMPTY_GENDER_MESSAGE = "Поле \"Пол\" обязательно для заполнения";

    public UserPage() {
        super();
    }

    public String getTextFromUserNameLocator() {
        moveToElement(byUserIconLocator);
        WebElement webElementGetUserName = driver.findElement(byUserNameLocator);
        return webElementGetUserName.getText();
    }

    public void clickCreateUserFormButton() {
        clickElement(byCreateUserFormButton);
    }

    public void typeInputSurname(String surname) {
        inputTextToForm(byInputSurnameLocator, surname);
    }

    public void typeInputName(String name) {
        inputTextToForm(byInputNameLocator, name);
    }

    public void typeInputPatronymic(String patronymic) {
        inputTextToForm(byInputPatronymicLocator, patronymic);
    }

    public void typeInputSurnameConfirmation(Confirmation value) {
        choseConfirmation(byInputSurnameConfirmationLocator, value);
    }

    public void typeInputNameConfirmation(Confirmation value) {
        choseConfirmation(byInputNameConfirmationLocator, value);
    }

    public void typeInputPatronymicConfirmation(Confirmation value) {
        choseConfirmation(byInputPatronymicConfirmationLocator, value);
    }

    public void clickInputGender(Gender value) {
        if (value.equals(FEMALE)) {
            clickElement(byInputFemaleRadioButton);
        } else {
            clickElement(byInputMaleRadioButton);
        }
    }

    public void clickSaveUserFormButton() {
        clickElement(bySaveUserFormButton);
    }

    public void clickCloseUserFormButton() {
        clickElement(byCloseUserFormButton);
    }

    public void typeInputLastnameSearch(String surname) {
        inputTextToForm(byInputLastnameSearchLocator, surname);
    }

    public void typeInputFirstnameSearch(String name) {
        inputTextToForm(byInputFirstnameSearchLocator, name);
    }

    public void typeInputPatronymicSearch(String patronymic) {
        inputTextToForm(byInputPatronymicSearchLocator, patronymic);
    }

    public void clickSearchUserFormButton() {
        clickElement(bySearchUserFormButton);
    }

    public String getTextFromUserLastnameFromSearchResultLocator() {
        return getText(byUserLastnameFromSearchResultLocator);
    }

    public String getTextFromCreatedCardStatusFromSearchResultLocator() {
        return getText(byStatusOfCreatedCardFromSearchResultLocator);
    }

    public String getTextFromEmptyDataErrorLocator() {
        return getText(byEmptyDataErrorLocator);
    }
}

