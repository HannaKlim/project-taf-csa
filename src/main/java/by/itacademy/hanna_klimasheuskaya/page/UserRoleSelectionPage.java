package by.itacademy.hanna_klimasheuskaya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserRoleSelectionPage extends BasePage {
    private final By byInputRoleLocator = By.xpath("//div[3]/div[2]/div/form/div/div/div[2]/div[1]/div/div/div/input");
    private final By bySelectButton = By.xpath("//span[@class='MuiButton-label-257']");

    public UserRoleSelectionPage() {
        super();
    }

    public WebElement inputTextToUserRoleForm(String role) {
        WebElement webElementInputText = driver.findElement(byInputRoleLocator);
        webElementInputText.sendKeys(role);
        return webElementInputText;
    }

    public void clickSelectButton() {
        clickElement(bySelectButton);
    }
}

