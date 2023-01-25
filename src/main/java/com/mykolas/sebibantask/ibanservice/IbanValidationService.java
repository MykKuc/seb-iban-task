package com.mykolas.sebibantask.ibanservice;


import com.mykolas.sebibantask.helper.IbanCodeLengthList;
import com.mykolas.sebibantask.helper.LettersToNumberConverterList;
import com.mykolas.sebibantask.ibanexceptions.IncorrectIbanLengthException;
import com.mykolas.sebibantask.ibanexceptions.NoSuchCountryCodeException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class IbanValidationService {

    private final IbanCodeLengthList ibanCodeLengthList;

    private final LettersToNumberConverterList lettersToNumberConverterList;

    public IbanValidationService(IbanCodeLengthList ibanCodeLengthList, LettersToNumberConverterList lettersToNumberConverterList){
        this.ibanCodeLengthList = ibanCodeLengthList;
        this.lettersToNumberConverterList = lettersToNumberConverterList;
    }


    public boolean validateSingleIbanNumber(String ibanNumber) {

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

        Map<String,Integer> letterToDigitConverterList = lettersToNumberConverterList.getNumberByLetterInAlphabet();

        for (int i = 0;i < arrayListOfIbanNumberCharacters.size() - 1;i++) {

            String currentCharacter = arrayListOfIbanNumberCharacters.get(i);

          if(!Character.isDigit(currentCharacter.charAt(0))) {
                Integer neededInteger =  letterToDigitConverterList.get(currentCharacter);
                arrayListOfIbanNumberCharacters.set(i,neededInteger.toString());
          }
        }

        // Convert List into one big String and convert String to Integer.
        String fullStringOfConvertedIban = arrayListOfIbanNumberCharacters.stream().collect(Collectors.joining(""));

        BigInteger modifiedStringConvertedToBigInteger = new BigInteger(fullStringOfConvertedIban);
        BigInteger ninetySevenNumber = new BigInteger("97");
        BigInteger resultAfterApplyingMod = modifiedStringConvertedToBigInteger.mod(ninetySevenNumber);

        if(resultAfterApplyingMod.intValue() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
