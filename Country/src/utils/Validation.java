package utils;

import constants.Message;
import java.util.List;

public final class Validation {

    // Khoa constructor de khong cho phep tao object tu class nay
    private Validation() {
    }

    //Kiem tra chuoi dau vao khong duoc de trong
    public static String getString(String input) throws Exception {

        if (input.equals(null) || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    //Kiem tra va chuyen doi chuoi sang so thuc duong 
    public static float getPositiveFloat(String input) throws Exception {
        try {
            float number = Float.parseFloat(input);
            // Kiem tra so am hoac bang 0
            if (number <= 0) {
                throw new Exception(Message.POSITIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            // Bat loi khi nguoi dung nhap chu cai vao o nhap so
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Kiem tra lua chon Menu phai nam trong khoang 1 den 5
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input);
            // Kiem tra ranh gioi lua chon
            if (choice < min || choice > max) {
                throw new Exception(String.format(Message.INVALID_RANGE, min, max));
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Kiem tra danh sach co dang bi rong hay khong (Dung cho chuc nang 2, 3, 4)
    public static void checkEmptyList(List<?> list) throws Exception {
        //Kiem tra danh sach co bi rong khong
        if (list.equals(null) || list.isEmpty()) {
            throw new Exception(Message.NO_COUNTRY_AVAILABLE);
        }
    }
}
