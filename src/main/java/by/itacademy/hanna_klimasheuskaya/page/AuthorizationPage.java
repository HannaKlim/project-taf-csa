package by.itacademy.hanna_klimasheuskaya.page;

import org.openqa.selenium.By;

public class AuthorizationPage extends BasePage {
    private final By byNameOfHeaderAuthorizationPageLocator = By.xpath("//h1[@class='system-name']");
    private final By byNameOfAuthorizationFormLocator = By.xpath("//span[@class='app-name']/strong");
    private final By byInputLoginLocator = By.xpath("//*[@id='login']");
    private final By byInputPasswordLocator = By.xpath("//*[@id='password']");
    private final By byNameOfInstructionForIncognitoLocator = By.xpath("//div[@class='incognito-container']");
    private final By byErrorEmptyPasswordMessageLocator = By.xpath("//*[@id='parsley-id-6']/span");
    private final By byErrorEmptyLoginMessageLocator = By.xpath("//*[@id='parsley-id-4']/span");
    private final By byErrorInvalidDataOrTimeConnectionMessageLocator = By.xpath("//p[@class='fs14']");
    private final By byAuthorizationButton = By.xpath("//*[@id='bind']");
    public final String HEADER_OF_AUTHORIZATION_PAGE = "Единая ***";
    public final String NAME_OF_AUTHORIZATION_FORM = "Комплексная ***";
    public final String NAME_AUTHORIZATION_BUTTON = "Войти";
    public final String NAME_OF_INSTRUCTION_INCOGNITO_AUTHORIZATION = "Используйте инкогнито для входа с чужого устройства";
    public final String ERROR_EMPTY_PASSWORD_MESSAGE = "Введите пароль";
    public final String ERROR_EMPTY_LOGIN_MESSAGE = "Введите логин";
    public final String ERROR_INVALID_LOGIN_MESSAGE = "Введен некорректный логин или пароль. Убедитесь, что вводите корректные данные, или нажмите «Сменить пользователя» и введите логин и пароль еще раз.\n" +
            "Используйте тот же пароль, что и для почтового аккаунта ***";
    public final String ERROR_INVALID_PASSWORD_MESSAGE = "Введен некорректный логин или пароль или ваша учетная запись заблокирована.\n" +
            "Убедитесь, что вводите корректные данные, или нажмите «Сменить пользователя» и введите логин и пароль еще раз.\n" +
            "Используйте тот же пароль, что и для почтового аккаунта ***";

    public final String ERROR_INVALID_TIME_CONNECTION_MESSAGE = "Не удалось выполнить проверку за отведенное время. Попробуйте повторить вход.";

    public AuthorizationPage() {
        super();
    }

    public String getTextFromNameOfHeaderAuthorizationPageLocator() {
        return getText(byNameOfHeaderAuthorizationPageLocator);
    }

    public String getTextFromNameOfAuthorizationFormLocator() {
        return getText(byNameOfAuthorizationFormLocator);
    }

    public String getTextFromAuthorizationButton() {
        return getText(byAuthorizationButton);
    }

    public String getTextFromNameOfInstructionForIncognitoLocator() {
        return getText(byNameOfInstructionForIncognitoLocator);
    }

    public void typeInputLogin(String login) {
        inputTextToForm(byInputLoginLocator, login);
    }

    public void typeInputPassword(String password) {
        inputTextToForm(byInputPasswordLocator, password);
    }

    public void clickAuthorizationButton() {
        clickElement(byAuthorizationButton);
    }

    public String getTextFromErrorEmptyPasswordMessageLocator() {
        return getText(byErrorEmptyPasswordMessageLocator);
    }

    public String getTextFromErrorEmptyLoginMessageLocator() {
        return getText(byErrorEmptyLoginMessageLocator);
    }

    public String getTextFromErrorInvalidLoginOrPasswordMessageLocator() {
        return getText(byErrorInvalidDataOrTimeConnectionMessageLocator);
    }

    public boolean isDisplayedErrorMessage() {
        return isDisplayedElement(byErrorInvalidDataOrTimeConnectionMessageLocator);
    }

}


