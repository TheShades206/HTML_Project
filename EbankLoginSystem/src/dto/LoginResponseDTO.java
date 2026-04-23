package dto;

public class LoginResponseDTO {

    private boolean success;
    private String message;
    //contructor chua tham so

    public LoginResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    //kiem tra chinh xac
    public boolean isSuccess() {
        return success;
    }

    //getter
    public String getMessage() {
        return message;
    }
}
