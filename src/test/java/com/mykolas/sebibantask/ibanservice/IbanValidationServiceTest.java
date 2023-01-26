package com.mykolas.sebibantask.ibanservice;

import com.mykolas.sebibantask.helper.IbanCodeLengthList;
import com.mykolas.sebibantask.helper.LettersToNumberConverterList;
import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import com.mykolas.sebibantask.ibanexceptions.NoSuchCountryCodeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {IbanValidationService.class, IbanCodeLengthList.class, LettersToNumberConverterList.class})
class IbanValidationServiceTest {


    private IbanValidationService ibanValidationService;

    @Mock
    private IbanCodeLengthList ibanCodeLengthList;

    @Mock
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
}
