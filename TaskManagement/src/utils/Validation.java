package utils;

import constants.Constants;
import constants.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Class tiện ích chuyên để check lỗi đầu vào nè.
// Chỉ chứa hàm static thôi, cấm khởi tạo object nha.
public final class Validation {

    // Giấu constructor đi để không ai tạo mới được
    private Validation() {
    }

    // Check xem chuỗi có bị trống hay null không
    // Bắt lỗi rỗng cho chắc kèo
    public static String getString(String input) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.ERR_EMPTY);
        }
        return input.trim();
    }

    // Check số nguyên xem có nằm trong khoảng cho phép không
    // Ném lỗi nếu nhập linh tinh hoặc ngoài vùng phủ sóng
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

    // Check thời gian kiểu số thập phân (như 8.0, 8.5)
    // Phải nằm trong khoảng quy định và chia hết cho 0.5 nha
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

    // Check ngày tháng xem đúng format, có tồn tại không
    // Và quan trọng là không được nhập ngày của tương lai nhé
    public static String checkDate(String input) throws Exception {
        SimpleDateFormat parser;
        Date parsedDate;
        Date currentDate;

        // Bước 1: Check format bằng Regex sương sương
        if (!input.matches(Constants.DATE_REGEX)) {
            throw new Exception(Message.ERR_DATE_FORMAT);
        }

        // Bước 2: Ép kiểu ngày với chế độ khắt khe (không tự bù ngày ảo)
        parser = new SimpleDateFormat(Constants.DATE_FORMAT);
        parser.setLenient(false);

        try {
            parsedDate = parser.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.ERR_DATE_NOT_EXIST);
        }

        // Bước 3: Đảm bảo ngày không lố sang tương lai
        currentDate = Calendar.getInstance().getTime();
        if (parsedDate.after(currentDate)) {
            throw new Exception(Message.ERR_DATE_FUTURE);
        }

        return input;
    }
    
    // Logic bắt lỗi: Giờ kết thúc (planTo) phải lớn hơn giờ bắt đầu (planFrom)
    public static void validatePlanTime(double planFrom, double planTo) throws Exception {
        if (planTo <= planFrom) {
            throw new Exception(Message.ERR_TIME_LIMIT);
        }
    }
    
     //Kiem tra danh sach co dang bi rong hay khong (Dung cho chuc nang 2, 3, 4)
    public static void checkEmptyList(List<?> list) throws Exception {
        //Kiem tra danh sach co bi rong khong
        if (list.equals(null) || list.isEmpty()) {
            throw new Exception(Message.LIST_EMPTY);
        }
    }
}