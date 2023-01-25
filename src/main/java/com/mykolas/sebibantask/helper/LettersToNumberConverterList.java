package com.mykolas.sebibantask.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LettersToNumberConverterList {

    public Map<String,Integer> getNumberByLetterInAlphabet() {

        HashMap<String,Integer> numberByAlphabetCharacter = new HashMap<>();

        numberByAlphabetCharacter.put("A",10);
        numberByAlphabetCharacter.put("B",11);
        numberByAlphabetCharacter.put("C",12);
        numberByAlphabetCharacter.put("D",13);
        numberByAlphabetCharacter.put("E",14);
        numberByAlphabetCharacter.put("F",15);
        numberByAlphabetCharacter.put("G",16);
        numberByAlphabetCharacter.put("H",17);
        numberByAlphabetCharacter.put("I",18);
        numberByAlphabetCharacter.put("J",19);
        numberByAlphabetCharacter.put("K",20);
        numberByAlphabetCharacter.put("L",21);
        numberByAlphabetCharacter.put("M",22);
        numberByAlphabetCharacter.put("N",23);
        numberByAlphabetCharacter.put("O",24);
        numberByAlphabetCharacter.put("P",25);
        numberByAlphabetCharacter.put("Q",26);
        numberByAlphabetCharacter.put("R",27);
        numberByAlphabetCharacter.put("S",28);
        numberByAlphabetCharacter.put("T",29);
        numberByAlphabetCharacter.put("U",30);
        numberByAlphabetCharacter.put("V",31);
        numberByAlphabetCharacter.put("W",32);
        numberByAlphabetCharacter.put("X",33);
        numberByAlphabetCharacter.put("Y",34);
        numberByAlphabetCharacter.put("Z",35);

        return numberByAlphabetCharacter;
    }
}
