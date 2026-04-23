package constants;

// Class này giữ mấy cái hằng số với cấu hình xài chung cho app
public final class Constants {

    // Khóa constructor lại không cho tạo object linh tinh
    private Constants() {
    }

    // Khoảng menu hợp lệ
    public static final int MENU_MIN = 1;
    public static final int MENU_MAX = 4;

    // Khoảng ID cho loại task
    public static final int TASK_TYPE_MIN = 1;
    public static final int TASK_TYPE_MAX = 4;

    // Khoảng thời gian hợp lệ
    public static final double TIME_FROM_MIN = 8.0;
    public static final double TIME_FROM_MAX = 17.0;
    public static final double TIME_TO_MIN = 8.5;
    public static final double TIME_TO_MAX = 17.5;
    public static final double TIME_STEP = 0.5;

    // Tên của mấy loại task
    public static final String TASK_TYPE_CODE = "Code";
    public static final String TASK_TYPE_TEST = "Test";
    public static final String TASK_TYPE_DESIGN = "Design";
    public static final String TASK_TYPE_REVIEW = "Review";
    public static final String TASK_TYPE_UNKNOWN = "Unknown";

    // Định dạng ngày tháng
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATE_REGEX = "\\d{2}-\\d{2}-\\d{4}";

    // Lấy tên loại task dựa theo ID.
    // Để hàm này ở đây cho Controller bớt cồng kềnh.
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