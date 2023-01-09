package by.itacademy.hanna_klimasheuskaya.ui;

import by.itacademy.hanna_klimasheuskaya.driver.Driver;
import by.itacademy.hanna_klimasheuskaya.page.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setWebDriver() {
        BasePage page = new BasePage();
        page.openPage();
    }

    @AfterEach
    public void closeWebDiver() {
        Driver.closeDriver();
    }
}

