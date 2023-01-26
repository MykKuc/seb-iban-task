package com.mykolas.sebibantask.ibanservice;

import com.mykolas.sebibantask.helper.IbanCodeLengthList;
import com.mykolas.sebibantask.helper.LettersToNumberConverterList;
import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import com.mykolas.sebibantask.ibanexceptions.NoSuchCountryCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {IbanValidationService.class, IbanCodeLengthList.class, LettersToNumberConverterList.class})
class IbanValidationServiceTest {


    private IbanValidationService ibanValidationService;

    @Autowired
    private IbanCodeLengthList ibanCodeLengthList;

    @Autowired
    private LettersToNumberConverterList lettersToNumberConverterList;

    @BeforeEach
    void init() {
        ibanValidationService = new IbanValidationService(ibanCodeLengthList, lettersToNumberConverterList);
    }

    @Test
    void should_return_IncorrectIbanLengthException () {
        String incorrectLengthIbanTooShort = "BA85" ;
        assertThrows(IncorrectIbanLengthException.class, () -> ibanValidationService.validateSingleIbanNumber(incorrectLengthIbanTooShort));
    }

    @Test
    void should_return_NoSuchCountryCodeException() {
        String incorrectCountryCodeIbanNumber = "AA47892255255";
        assertThrows(NoSuchCountryCodeException.class, () -> ibanValidationService.validateSingleIbanNumber(incorrectCountryCodeIbanNumber));
    }

    @Test
    void should_return_boolean_false_after_validation() {
        String incorrectIbanNumber = "GB33BUKB20201555555558";
        assertFalse(ibanValidationService.validateSingleIbanNumber(incorrectIbanNumber));

    }

    @Test
    void should_return_boolean_true_after_validation() {
        String correctIbanNumber = "GB33BUKB20201555555555";
        assertTrue(ibanValidationService.validateSingleIbanNumber(correctIbanNumber));
    }
}
