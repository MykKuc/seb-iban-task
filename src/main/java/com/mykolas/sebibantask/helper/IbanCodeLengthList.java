package com.mykolas.sebibantask.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IbanCodeLengthList {

    /**
     * @author Mykolas
     * @return Returns Map with Country codes and values in the map with an appropriate
     * required length of IBAN for that country.
     */

    public Map<String,Integer> getIbanLengthByCountry() {

        HashMap<String,Integer> ibanLengthByCountry = new HashMap<>();
        ibanLengthByCountry.put("AL",28);
        ibanLengthByCountry.put("AD",24);
        ibanLengthByCountry.put("AT",20);
        ibanLengthByCountry.put("AZ",28);
        ibanLengthByCountry.put("BH",22);
        ibanLengthByCountry.put("BY",28);
        ibanLengthByCountry.put("BE",16);
        ibanLengthByCountry.put("BA",20);
        ibanLengthByCountry.put("BR",29);
        ibanLengthByCountry.put("BG",22);
        ibanLengthByCountry.put("BI",27);
        ibanLengthByCountry.put("CR",22);
        ibanLengthByCountry.put("HR",21);
        ibanLengthByCountry.put("CY",28);
        ibanLengthByCountry.put("CZ",24);
        ibanLengthByCountry.put("DK",18);
        ibanLengthByCountry.put("DJ",27);
        ibanLengthByCountry.put("DO",28);
        ibanLengthByCountry.put("EG",29);
        ibanLengthByCountry.put("SV",28);
        ibanLengthByCountry.put("EE",20);
        ibanLengthByCountry.put("FO",18);
        ibanLengthByCountry.put("FI",18);
        ibanLengthByCountry.put("FR",27);
        ibanLengthByCountry.put("GE",22);
        ibanLengthByCountry.put("DE",22);
        ibanLengthByCountry.put("GI",23);
        ibanLengthByCountry.put("GR",27);
        ibanLengthByCountry.put("GL",18);
        ibanLengthByCountry.put("GT",28);
        ibanLengthByCountry.put("VA",22);
        ibanLengthByCountry.put("HU",28);
        ibanLengthByCountry.put("IS",26);
        ibanLengthByCountry.put("IQ",23);
        ibanLengthByCountry.put("IE",22);
        ibanLengthByCountry.put("IL",23);
        ibanLengthByCountry.put("IT",27);
        ibanLengthByCountry.put("JO",30);
        ibanLengthByCountry.put("KZ",20);
        ibanLengthByCountry.put("XK",20);
        ibanLengthByCountry.put("KW",30);
        ibanLengthByCountry.put("LV",21);
        ibanLengthByCountry.put("LB",28);
        ibanLengthByCountry.put("LY",25);
        ibanLengthByCountry.put("LI",21);
        ibanLengthByCountry.put("LT",20);
        ibanLengthByCountry.put("LU",20);
        ibanLengthByCountry.put("MT",31);
        ibanLengthByCountry.put("MR",27);
        ibanLengthByCountry.put("MU",30);
        ibanLengthByCountry.put("MD",24);
        ibanLengthByCountry.put("MC",27);
        ibanLengthByCountry.put("ME",22);
        ibanLengthByCountry.put("NL",18);
        ibanLengthByCountry.put("MK",19);
        ibanLengthByCountry.put("NO",15);
        ibanLengthByCountry.put("PK",24);
        ibanLengthByCountry.put("PS",29);
        ibanLengthByCountry.put("PL",28);
        ibanLengthByCountry.put("PT",25);
        ibanLengthByCountry.put("QA",29);
        ibanLengthByCountry.put("RO",24);
        ibanLengthByCountry.put("RU",33);
        ibanLengthByCountry.put("LC",32);
        ibanLengthByCountry.put("SM",27);
        ibanLengthByCountry.put("ST",25);
        ibanLengthByCountry.put("SA",24);
        ibanLengthByCountry.put("RS",22);
        ibanLengthByCountry.put("SC",31);
        ibanLengthByCountry.put("SK",24);
        ibanLengthByCountry.put("SI",19);
        ibanLengthByCountry.put("ES",24);
        ibanLengthByCountry.put("SD",18);
        ibanLengthByCountry.put("SE",24);
        ibanLengthByCountry.put("CH",21);
        ibanLengthByCountry.put("TL",23);
        ibanLengthByCountry.put("TN",24);
        ibanLengthByCountry.put("TR",26);
        ibanLengthByCountry.put("UA",29);
        ibanLengthByCountry.put("AE",23);
        ibanLengthByCountry.put("GB",22);
        ibanLengthByCountry.put("VG",24);

        return ibanLengthByCountry;
    }
}
