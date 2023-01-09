package by.itacademy.hanna_klimasheuskaya.enums;

public enum Confirmation {
    WORDS("From the words"),
    DOCUMENT("Document"),
    FORGOT("Does not remember");


    private final String value;

    Confirmation(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
