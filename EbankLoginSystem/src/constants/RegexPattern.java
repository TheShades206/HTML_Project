package constants;

public final class RegexPattern {

    //private constructor
    private RegexPattern() {
    }
    // So tai khoan: chi gom chu so, dung 10 ky tu.
    public static final String USERNAME = "\\d{10}";
    // Mat khau: 8-31 ky tu, phai co ca chu lan so.
    public static final String PASSWORD = "(?=.*\\d.*)(?=.*[a-zA-Z].*).{8,31}";
    // Captcha: chi gom chu va so, dung 6 ky tu.
    public static final String CAPTCHA = "[a-zA-Z0-9]{6}";
}
