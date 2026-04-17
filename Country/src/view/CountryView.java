package view;

import dto.CountryResponseDTO;
import java.util.List;

/**
 *
 * @author LENOVOLOQ
 */
public class CountryView {

    //Khai bao mang kieu du lieu response da xu ly 
    private List<CountryResponseDTO> countryInfoList;

    //Setter
    public void setCountryInfoList(List<CountryResponseDTO> countryInfoList) {
        this.countryInfoList = countryInfoList;
    }

    //In ra tieu de cua bang khi display thong tin nhap gan nhat
    public void display() {
        System.out.printf("%-15s%-20s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");

        //In ra thong tin vua nhap
        for (CountryResponseDTO info : countryInfoList) {
            System.out.println(info);
        }
    }
}
