/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author LENOVOLOQ
 */
public class CountryResponseDTO {

    //Khai bao thuoc tinh
    private String countryCode;
    private String countryName;
    private float countryArea;
    private String countryTerrain;

    //Contructor co tham so
    public CountryResponseDTO(String countryCode, String countryName, float countryArea, String countryTerrain) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
        this.countryTerrain = countryTerrain;
    }

    //Getter
    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public float getCountryArea() {
        return countryArea;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    //Chuyen thong tin quoc gia thanh chuoi duoi dang bang
    @Override
    public String toString() {
        return String.format("%-15s%-20s%-15.2f%-15s",
                countryCode, countryName, countryArea, countryTerrain);
    }
}
