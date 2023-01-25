package com.mykolas.sebibantask.ibanservice;


import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import com.mykolas.sebibantask.ibanexceptions.NoSuchCountryCodeException;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Set;

@Service
public class IbanValidationService {


    public void validateSingleIbanNumber(String ibanNumber) {

        if (ibanNumber.length() > 34){
            throw new IncorrectIbanLengthException("Incorrect length of IBAN. Number is too long.");
        }

        final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());

        String countryCodeOfIban = ibanNumber.substring(0,2);
        if(!ISO_COUNTRIES.contains(countryCodeOfIban)){
            throw new NoSuchCountryCodeException(countryCodeOfIban);
        }
    }
}
