package com.mykolas.sebibantask.ibancontroller;


import com.mykolas.sebibantask.ibanservice.IbanValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IbanNumbersController {

    private final IbanValidationService ibanValidationService;

    @Autowired
    public IbanNumbersController(IbanValidationService ibanValidationService){
        this.ibanValidationService = ibanValidationService;
    }

    @PostMapping
    public void validateSingleIbanNumber(String ibanNumber) {
        ibanValidationService.validateSingleIbanNumber();
    }
}
