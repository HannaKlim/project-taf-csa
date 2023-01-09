package by.itacademy.hanna_klimasheuskaya.page;

import org.openqa.selenium.By;

public class EntryPage extends BasePage {
    private final By byNameOFHeaderEntryPageLocator = By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignCenter']");
    private final By byEntrySUDIRButton = By.xpath("//span[@class='MuiButton-label']");
    public final String HEADER_OF_ENTRY_FORM = "Авторизация ***";
    public final String NAME_OF_ENTRY_BUTTON = "ВОЙТИ ЧЕРЕЗ ***";

    public EntryPage() {
        super();
    }

    public String getTextFromHeaderEntryPageLocator() {
        return getText(byNameOFHeaderEntryPageLocator);
    }

    public String getTextFromEntrySUDIRButton() {
        return getText(byEntrySUDIRButton);
    }

    public void clickEntrySUDIRButton() {
        clickElement(byEntrySUDIRButton);
    }
}
