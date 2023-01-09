package by.itacademy.hanna_klimasheuskaya.page;

import org.openqa.selenium.By;

public class ServicesPage extends BasePage {
    private final By byStandLocator = By.xpath("//*[@id='root']/div/div/div[2]/div/div[3]/a");

    public ServicesPage() {
        super();
    }

    public void clickStandLocator() {
        clickElement(byStandLocator);
    }
}
