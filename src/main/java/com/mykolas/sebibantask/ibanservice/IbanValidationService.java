package com.mykolas.sebibantask.ibanservice;


import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import org.springframework.stereotype.Service;

@Service
public class IbanValidationService {

    public void validateSingleIbanNumber(String ibanNumber) {

        if (ibanNumber.length() > 34){
            throw new IncorrectIbanLengthException("Incorrect length of IBAN. Number is too long.");
        }
    }
}
