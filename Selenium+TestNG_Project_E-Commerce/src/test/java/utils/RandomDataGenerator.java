package utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {

    private static final String[] firstNames = {"Alex", "Jamie", "Taylor", "Jordan", "Morgan", "Riley","Michel"};
    private static final String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Davis","Krish"};

    public static String generateFirstName() {
        return firstNames[new Random().nextInt(firstNames.length)];
    }

    public static String generateLastName() {
        return lastNames[new Random().nextInt(lastNames.length)];
    }

    public static String generateEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
    }

    public static String generatePhone() {
        // 9-digit number starting with '7' (excluding leading 0)
        return "7" + String.format("%08d", new Random().nextInt(100000000));
    }


    public static String generateStrongPassword() {
        return "Aa@" + UUID.randomUUID().toString().substring(0, 10); // Password need to have length > 12 and mixed chars
    }

    public static String getWeakPassword() {
        return "12345@1"; // Less than 12 characters
    }

    public static String getInvalidEmail() {
        return "invalidEmail.com"; // Missing @
    }

    public static String getInvalidPhoneNumber() {
        return "123ABC!@#"; // Not digits only
    }


}
