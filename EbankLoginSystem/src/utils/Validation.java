package utils;

import constants.RegexPattern;

public final class Validation {

    //private constructor
    private Validation() {
    }

    //Kiem tra va tra ve so tai khoan hop le
    public static String getUsername(String input, String errorMessage) throws Exception {
        String trimmedInput = (input != null) ? input.trim() : null;
        if ((trimmedInput == null) || (!trimmedInput.matches(RegexPattern.USERNAME))) {
            throw new Exception(errorMessage);
        }
        return trimmedInput;
    }

    //Kiem tra va tra ve mat khau hop le
    public static String getPassword(String input, String errorMessage) throws Exception {
        String trimmedInput = (input != null) ? input.trim() : null;
        if ((trimmedInput == null) || (!trimmedInput.matches(RegexPattern.PASSWORD))) {
            throw new Exception(errorMessage);
        }
        return trimmedInput;
    }

    //Kiem tra va tra ve captcha hop le
    public static String getCaptcha(String input, String errorMessage) throws Exception {
        String trimmedInput = (input != null) ? input.trim() : null;
        if ((trimmedInput == null) || (!trimmedInput.matches(RegexPattern.CAPTCHA))) {
            throw new Exception(errorMessage);
        }
        return trimmedInput;
    }

    //Kiem tra va tra ve lua chon menu hop le
    public static int getMenuOption(String input, String errorMessage) throws Exception {
        try {
            String trimmedInput = (input != null) ? input.trim() : "";
            int option = Integer.parseInt(trimmedInput);
            if ((option < 1) || (option > 3)) {
                throw new Exception(errorMessage);
            }
            return option;
        } catch (NumberFormatException e) {
            throw new Exception(errorMessage);
        }
    }

}
