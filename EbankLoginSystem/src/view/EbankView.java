package view;

public class EbankView {

    private String loginResultMessage;

    //Hien thi ket qua dang nhap
    public void displayLoginResult() {
        System.out.println(loginResultMessage);
    }

    // Nhan thong bao ket qua tu Controller
    public void setLoginResultMessage(String loginResultMessage) {
        this.loginResultMessage = loginResultMessage;
    }

}
