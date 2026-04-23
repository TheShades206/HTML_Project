package controller;

import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import service.EbankService;
import view.EbankView;

public class EbankController {

    private EbankService ebankService;
    private EbankView ebankView;

    //contructor khoi tao Service va View
    public EbankController() {
        ebankService = new EbankService();
        ebankView = new EbankView();
    }

    //Ham kiem tra qua trinh dang nhap
    public void processLogin(LoginRequestDTO loginRequestDTO, String successMessage, String failMessage) {

        // Khai bao bien tap trung dau block 
        LoginResponseDTO responseDTO = ebankService.authenticate(loginRequestDTO);
        String resultMessage;

        // Chon thong bao phu hop theo ket qua trong response
        if (responseDTO.isSuccess()) {
            resultMessage = successMessage;
        } else {
            resultMessage = failMessage;
        }

        // Truyen ket qua sang view va hien thi
        ebankView.setLoginResultMessage(resultMessage);
        ebankView.displayLoginResult();
    }
}
