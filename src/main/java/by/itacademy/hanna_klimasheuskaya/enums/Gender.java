package by.itacademy.hanna_klimasheuskaya.enums;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");
    private final String value;

    Gender(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
