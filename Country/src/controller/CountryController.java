/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import constants.Message;
import dto.CountryRequestDTO;
import dto.CountryResponseDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import repository.CountryRepository;
import view.CountryView;

/**
 *
 * @author LENOVOLOQ
 */
public class CountryController {
    
    //Khai bao view va repository 
    private CountryView countryView;
    private CountryRepository countryRepository;

    //Tao 2 bien doi tuong trong constuctor
    public CountryController() {
        countryView = new CountryView();
        countryRepository = new CountryRepository();
    }

    //Function 1: Them quoc gia 
    public void addCountryInformation(CountryRequestDTO requestDTO) throws Exception {
        if (countryRepository.isEnough11Countries()) {
            throw new Exception(Message.MAX_11_COUNTRIES);
        }

        if (countryRepository.isDuplicate(requestDTO.getCode())) {
            throw new Exception(Message.DUPLICATE);
        }
        countryRepository.add(requestDTO);
    }

    //Function 2: Hien thi quoc gia
    public void displayRecentInfomation() throws Exception {
        List<CountryResponseDTO> allCountries = countryRepository.getAll();

        CountryResponseDTO latestCountry = allCountries.get(allCountries.size() - 1);

        List<CountryResponseDTO> recentCountryInfo = new ArrayList<>();

        recentCountryInfo.add(latestCountry);

        countryView.setCountryInfoList(recentCountryInfo);
        countryView.display();
    }
    
    //Function 3: Tim kiem theo ten quoc gia
    public void searchInformationByName(String name) throws Exception {
        List<CountryResponseDTO> matchedCountries = countryRepository.findByName(name);

        countryView.setCountryInfoList(matchedCountries);
        countryView.display();
    }

    //Function 4: Sap xep theo ten quoc gia
    public void sortInformationByAscendingOrder() throws Exception {
        List<CountryResponseDTO> allCountries = countryRepository.getAll();

        allCountries.sort(Comparator.comparing(CountryResponseDTO::getCountryName));

        countryView.setCountryInfoList(allCountries);
        countryView.display();
    }
    
    //Lay danh sach tat ca quoc gia tu du lieu ben ResponseDTO
    public List<CountryResponseDTO> getAllCountries() {
        return countryRepository.getAll();
    }
}
