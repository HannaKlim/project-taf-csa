package by.itacademy.hanna_klimasheuskaya.util;

public class Util {
    public static String generateRandomString(int count) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < count; i++) {

            result += abc.charAt((int) (Math.random() * abc.length()));
        }
        return result;
    }

    public static void waiter() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

