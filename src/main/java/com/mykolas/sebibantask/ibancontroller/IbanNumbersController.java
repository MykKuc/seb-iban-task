package com.mykolas.sebibantask.ibancontroller;


import com.mykolas.sebibantask.ibanservice.IbanValidationService;
import com.mykolas.sebibantask.model.ListOfIbans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("iban")
public class IbanNumbersController {

    private final IbanValidationService ibanValidationService;

    @Autowired
    public IbanNumbersController(IbanValidationService ibanValidationService){
        this.ibanValidationService = ibanValidationService;
    }

    /**
     * @author Mykolas
     * @param ibanNumber The single provided IBAN number by the user.
     * @return boolean value true if IBAN has been successfully validated.
     */
    @PostMapping("single")
    public boolean validateSingleIbanNumber(String ibanNumber) {
       return ibanValidationService.validateSingleIbanNumber(ibanNumber);
    }

    /**
     * @author Mykolas
     * @param listOfIbans The Object with the list of IBAN numbers provided by the user.
     * @return Returns a HashMap with IBAN as a key and boolean value if IABN is valid as a value in HashMap.
     */
    @PostMapping("multiple")
    public Map<String,Boolean> validateListOfIbans(@RequestBody ListOfIbans listOfIbans) {

        Map<String,Boolean> validatePairsOfIbans = new HashMap<>();

        for(String iban : listOfIbans.getIbans()){
            Boolean validationOfIban = ibanValidationService.validateSingleIbanNumber(iban);
            validatePairsOfIbans.put(iban,validationOfIban);
        }

        return validatePairsOfIbans;
    }
}
