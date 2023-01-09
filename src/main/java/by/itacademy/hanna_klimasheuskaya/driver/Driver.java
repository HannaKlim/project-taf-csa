package by.itacademy.hanna_klimasheuskaya.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    private static final long IMPLICIT_WAIT = 25;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage()
                    .window()
                    .maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}