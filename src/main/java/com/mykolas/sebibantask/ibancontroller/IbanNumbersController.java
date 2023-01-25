package com.mykolas.sebibantask.ibancontroller;


import com.mykolas.sebibantask.ibanservice.IbanValidationService;
import com.mykolas.sebibantask.model.ListOfIbans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("iban")
public class IbanNumbersController {

    private final IbanValidationService ibanValidationService;

    @Autowired
    public IbanNumbersController(IbanValidationService ibanValidationService){
        this.ibanValidationService = ibanValidationService;
    }

    @PostMapping("single")
    public boolean validateSingleIbanNumber(String ibanNumber) {
       return ibanValidationService.validateSingleIbanNumber(ibanNumber);
    }

    @PostMapping("multiple")
    public List<Boolean> validateListOfIbans(@RequestBody ListOfIbans listOfIbans) {

        List<Boolean> validateListOfIbans = new ArrayList<>();

        for(String iban : listOfIbans.getIbans()){
            Boolean validationOfIban = ibanValidationService.validateSingleIbanNumber(iban);
            validateListOfIbans.add(validationOfIban);
        }

        return validateListOfIbans;
    }
}
