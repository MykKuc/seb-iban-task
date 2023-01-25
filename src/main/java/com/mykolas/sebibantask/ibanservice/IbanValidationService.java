package com.mykolas.sebibantask.ibanservice;


import com.mykolas.sebibantask.helper.IbanCodeLengthList;
import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import com.mykolas.sebibantask.ibanexceptions.NoSuchCountryCodeException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IbanValidationService {

    private IbanCodeLengthList ibanCodeLengthList;

    public IbanValidationService(IbanCodeLengthList ibanCodeLengthList){
        this.ibanCodeLengthList = ibanCodeLengthList;
    }


    public void validateSingleIbanNumber(String ibanNumber) {

        if (ibanNumber.length() > 34 || ibanNumber.length() < 5){
            throw new IncorrectIbanLengthException("Incorrect length of IBAN.");
        }

        final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());

        String countryCodeOfIban = ibanNumber.substring(0,2);
        if(!ISO_COUNTRIES.contains(countryCodeOfIban)){
            throw new NoSuchCountryCodeException(countryCodeOfIban);
        }

        Map<String,Integer> listOfIbanLengthByCode = ibanCodeLengthList.getIbanLengthByCountry();
        if (ibanNumber.length() != listOfIbanLengthByCode.get(countryCodeOfIban) ){
                throw new IncorrectIbanLengthException("Incorrect length of provided Iban according to the country code.");
        }

        String[] arrayOfIbanNumberCharacters = ibanNumber.split("");
        ArrayList<String> arrayListOfIbanNumberCharacters = new ArrayList<>();
        Arrays.stream(arrayOfIbanNumberCharacters).map(arrayListOfIbanNumberCharacters::add).collect(Collectors.toList());

        // Moving first 4 characters to the end of the String.
        for (int i = 0; i < 4;i++){
         String characterInArrayList = arrayListOfIbanNumberCharacters.get(0);
         arrayListOfIbanNumberCharacters.add(characterInArrayList);
         arrayListOfIbanNumberCharacters.remove(0);
        }

        //THis is good.
        System.err.print(arrayListOfIbanNumberCharacters);

        String rearrangedIbanNumber = arrayOfIbanNumberCharacters.toString();

    }
}
