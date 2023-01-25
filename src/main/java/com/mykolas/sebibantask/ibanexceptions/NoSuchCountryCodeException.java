package com.mykolas.sebibantask.ibanexceptions;

public class NoSuchCountryCodeException extends RuntimeException{

    public NoSuchCountryCodeException(String code){
        super("No such country with code " + code + " exists.");
    }
}
