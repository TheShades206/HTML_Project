package constants;

public final class Message {

    //private constructor
    private Message() {
    }
    // Language codes
    // Ma ngon ngu tieng Viet.
    public static final String LANG_VIETNAMESE = "vi";
    // Ma ngon ngu tieng Anh.
    public static final String LANG_ENGLISH = "en";

    // Resource Bundle
    // Ten base cua resource bundle.
    public static final String BUNDLE_BASE_NAME = "language/message";
    // Key lay nhan hien thi tieu de menu.
    public static final String KEY_MENU_TITLE = "messageMenuTitle";
    // Key lay nhan hien thi menu.
    public static final String KEY_MENU = "messageMenu";
    // Key lay prompt nhap lua chon chuc nang.
    public static final String KEY_MENU_CHOICE = "messageMenuChoice";
    // Key lay thong bao loi chon menu.
    public static final String KEY_ERR_INVALID_OPTION = "messageErrInvalidOption";
    // Key lay prompt nhap tai khoan.
    public static final String KEY_USERNAME = "messageUsername";
    // Key lay thong bao loi tai khoan.
    public static final String KEY_USERNAME_ERROR = "messageUsernameError";
    // Key lay prompt nhap mat khau.
    public static final String KEY_PASSWORD = "messagePassword";
    // Key lay thong bao loi mat khau.
    public static final String KEY_PASSWORD_ERROR = "messagePasswordError";
    // Key lay nhan hien thi captcha.
    public static final String KEY_CAPTCHA = "messageCaptcha";
    // Key lay prompt nhap captcha.
    public static final String KEY_CAPTCHA_INPUT = "messageCaptchaInput";
    // Key lay thong bao loi captcha sai.
    public static final String KEY_CAPTCHA_ERROR = "messageCaptchaError";
    // Key lay thong bao dang nhap thanh cong.
    public static final String KEY_LOGIN_SUCCESS = "messageLoginSuccess";
    // Key lay thong bao dang nhap that bai.
    public static final String KEY_LOGIN_FAIL = "messageLoginFail";
}
