//package utils;
//
//import java.util.regex.Pattern;
//
//public class ValidationUtils {
//
//    public static boolean isValidEmail(String email) {
//        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//        return Pattern.matches(regex, email);
//    }
//
//    public static boolean isValidPhone(String phone) {
//        return phone.matches("\\d{9}"); // 9-digit number
//    }
//
//    public static boolean isStrongPassword(String password) {
//        // At least 12 characters, includes:
//        // - one uppercase
//        // - one lowercase
//        // - one number
//        // - one special character
//        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{12,}$";
//        return password.matches(regex);
//    }
//}
