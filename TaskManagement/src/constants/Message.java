package constants;

/**
 * Class stores all messages and labels used in the application.
 * All messages and labels must be declared here, not hardcoded in other classes.
 */
public final class Message {

    /** Private constructor to prevent instantiation */
    private Message() {
    }

    // ==================== MENU ====================
    public static final String MENU
            = """
              ========= Task Program =========
              1. Add Task
              2. Delete Task
              3. Display Task
              4. Exit""";

    // ==================== INPUT LABELS ====================
    public static final String INPUT_CHOICE = "Select choice: ";
    public static final String LABEL_NAME = "Requirement Name: ";
    public static final String LABEL_TYPE = "Task Type (1-4): ";
    public static final String LABEL_DATE = "Date (dd-MM-yyyy): ";
    public static final String LABEL_FROM = "From: ";
    public static final String LABEL_TO = "To: ";
    public static final String LABEL_ASSIGNEE = "Assignee: ";
    public static final String LABEL_REVIEWER = "Reviewer: ";
    public static final String LABEL_ID = "Enter Task Id: ";

    // ==================== ERROR MESSAGES ====================
    public static final String ERR_EMPTY = "Input cannot be empty!";
    public static final String ERR_NUMBER = "Please input a valid number!";
    public static final String ERR_RANGE = "Must be in range [%d, %d]";
    public static final String ERR_TIME = "Time must be in range 8.0 - 17.5 and divisible by 0.5!";
    public static final String ERR_TIME_LIMIT = "'To' time must be greater than 'From' time!";
    public static final String ERR_NOT_FOUND = "Task Id does not exist!";
    public static final String ERR_DATE_FORMAT = "Date must be in format dd-MM-yyyy!";
    public static final String ERR_DATE_NOT_EXIST = "Date does not exist!";
    public static final String ERR_DATE_FUTURE = "Date must be less than or equal to current date!";

//    // ==================== SUCCESS MESSAGES ====================
//    public static final String SUCCESS_ADD = "Task added successfully.";
//    public static final String SUCCESS_DELETE = "Deleted successfully.";
//    public static final String EXIT_PROGRAM = "Exiting program...";
    public static final String LIST_EMPTY = "The task list is empty!";

}