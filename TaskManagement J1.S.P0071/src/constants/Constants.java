package constants;

/**
 * Class stores all numeric constants and configuration values used in the
 * application.
 */
public final class Constants {

    /**
     * Private constructor to prevent instantiation
     */
    private Constants() {
    }

    // Menu range
    public static final int MENU_MIN = 1;
    public static final int MENU_MAX = 4;

    // Task type range
    public static final int TASK_TYPE_MIN = 1;
    public static final int TASK_TYPE_MAX = 4;

    // Time range
    public static final double TIME_FROM_MIN = 8.0;
    public static final double TIME_FROM_MAX = 17.0;
    public static final double TIME_TO_MIN = 8.5;
    public static final double TIME_TO_MAX = 17.5;
    public static final double TIME_STEP = 0.5;

    // Task type names
    public static final String TASK_TYPE_CODE = "Code";
    public static final String TASK_TYPE_TEST = "Test";
    public static final String TASK_TYPE_DESIGN = "Design";
    public static final String TASK_TYPE_REVIEW = "Review";
    public static final String TASK_TYPE_UNKNOWN = "Unknown";

    // Date format
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATE_REGEX = "\\d{2}-\\d{2}-\\d{4}";

    /**
     * Returns the task type name based on the task type ID. This helper method
     * is placed in Constants to keep Controller thin.
     * @param taskTypeId
     * @return 
     */
    public static String getTaskTypeName(int taskTypeId) {
        return switch (taskTypeId) {
            case 1 -> TASK_TYPE_CODE;
            case 2 -> TASK_TYPE_TEST;
            case 3 -> TASK_TYPE_DESIGN;
            case 4 -> TASK_TYPE_REVIEW;
            default -> TASK_TYPE_UNKNOWN;
        };
    }
}
