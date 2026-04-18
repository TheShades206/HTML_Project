package utils;

import constants.Constants;
import constants.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class for validating input data.
 * All methods are static and this class cannot be instantiated.
 */
public final class Validation {

    /** Private constructor to prevent instantiation */
    private Validation() {
    }

    /**
     * Validates that the input string is not null or empty.
     * 
     * @param input raw input from scanner
     * @return trimmed string
     * @throws Exception if input is null or empty
     */
    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.ERR_EMPTY);
        }
        return input.trim();
    }

    /**
     * Validates integer input within a specific range.
     * 
     * @param input raw input from scanner
     * @param min   minimum allowed value
     * @param max   maximum allowed value
     * @return valid integer within the range
     * @throws Exception if input is not a number or out of range
     */
    public static int getInt(String input, int min, int max) throws Exception {
        int number;

        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERR_NUMBER);
        }

        if (number < min || number > max) {
            throw new Exception(String.format(Message.ERR_RANGE, min, max));
        }

        return number;
    }

    /**
     * Validates double time input (e.g. 8.0, 8.5, 9.0).
     * Time must be within range and divisible by 0.5.
     * 
     * @param input raw input from scanner
     * @param min   minimum allowed time
     * @param max   maximum allowed time
     * @return valid double time value
     * @throws Exception if format is invalid or value is out of bounds
     */
    public static double getDoubleTime(String input, double min, double max) throws Exception {
        double number;

        try {
            number = Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERR_TIME);
        }

        if (number < min || number > max || (number % Constants.TIME_STEP) != 0) {
            throw new Exception(Message.ERR_TIME);
        }

        return number;
    }

    /**
     * Validates date string for correct format, existence, 
     * and ensures the date is not in the future.
     * 
     * @param input raw date input string
     * @return valid date string in dd-MM-yyyy format
     * @throws Exception for invalid format, non-existent date, or future date
     */
    public static String checkDate(String input) throws Exception {
        SimpleDateFormat parser;
        Date parsedDate;
        Date currentDate;

        // Step 1: Check format using regex
        if (!input.matches(Constants.DATE_REGEX)) {
            throw new Exception(Message.ERR_DATE_FORMAT);
        }

        // Step 2: Parse date with strict mode to check existence
        parser = new SimpleDateFormat(Constants.DATE_FORMAT);
        parser.setLenient(false);

        try {
            parsedDate = parser.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.ERR_DATE_NOT_EXIST);
        }

        // Step 3: Check that date is not in the future
        currentDate = Calendar.getInstance().getTime();
        if (parsedDate.after(currentDate)) {
            throw new Exception(Message.ERR_DATE_FUTURE);
        }

        return input;
    }
    
    /**
     * Validates business rule: planTo must be greater than planFrom
     * @param planFrom
     * @param planTo
     * @throws java.lang.Exception
     */
    public static void validatePlanTime(double planFrom, double planTo) throws Exception {
        if (planTo <= planFrom) {
            throw new Exception(Message.ERR_TIME_LIMIT);
        }
    }
}