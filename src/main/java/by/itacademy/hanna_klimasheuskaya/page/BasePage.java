package by.itacademy.hanna_klimasheuskaya.page;

import by.itacademy.hanna_klimasheuskaya.domain.User;
import by.itacademy.hanna_klimasheuskaya.driver.Driver;
import by.itacademy.hanna_klimasheuskaya.enums.Confirmation;
import by.itacademy.hanna_klimasheuskaya.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;
    private static final String URL = User.URL;

    public BasePage() {
        driver = Driver.getDriver();
    }

    public void openPage() {
        driver.navigate().to(URL);
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void inputTextToForm(By byLocator, String text) {
        WebElement webElementInputText = driver.findElement(byLocator);
        webElementInputText.sendKeys(text);
    }

    public boolean isDisplayedElement(By byLocator) {
        WebElement webElementIsDisplayed = driver.findElement(byLocator);
        return webElementIsDisplayed.isDisplayed();
    }

    public String getText(By byLocator) {
        WebElement webElementGetText = driver.findElement(byLocator);
        Util.waiter();
        String errorText = webElementGetText.getText();
        Util.waiter();
        return errorText;
    }

    public void moveToElement(By byLocator) {
        WebElement webElementUserIcon = driver.findElement(byLocator);
        Actions mouse = new Actions(driver);
        mouse.moveToElement(webElementUserIcon).build().perform();
    }

    public void choseConfirmation(By byLocator, Confirmation value) {
        WebElement webElementChoseConfirmation = driver.findElement(byLocator);
        switch (value) {
            case WORDS:
                webElementChoseConfirmation.click();
                webElementChoseConfirmation.sendKeys(Keys.ENTER);
                break;
            case DOCUMENT:
                webElementChoseConfirmation.click();
                webElementChoseConfirmation.sendKeys(Keys.DOWN);
                webElementChoseConfirmation.sendKeys(Keys.ENTER);
                break;
            case FORGOT:
                webElementChoseConfirmation.click();
                webElementChoseConfirmation.sendKeys(Keys.DOWN);
                webElementChoseConfirmation.sendKeys(Keys.DOWN);
                webElementChoseConfirmation.sendKeys(Keys.ENTER);
                break;
            default:
                System.out.println("Вы выбрали неверный тип подтверждения");
        }
    }
}

