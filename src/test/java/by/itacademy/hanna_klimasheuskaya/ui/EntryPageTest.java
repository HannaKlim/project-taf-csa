package by.itacademy.hanna_klimasheuskaya.ui;

import by.itacademy.hanna_klimasheuskaya.page.EntryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntryPageTest extends BaseTest {
    @Test
    void testGetTextFromHeaderEntryPage(){
        EntryPage entryPage = new EntryPage();
        String actualResult = entryPage.getTextFromHeaderEntryPageLocator();
        String expectedResult = entryPage.HEADER_OF_ENTRY_FORM;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetTextFromEntrySUDIRButton(){
        EntryPage entryPage = new EntryPage();
        String actualResult = entryPage.getTextFromEntrySUDIRButton();
        String expectedResult = entryPage.NAME_OF_ENTRY_BUTTON;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
