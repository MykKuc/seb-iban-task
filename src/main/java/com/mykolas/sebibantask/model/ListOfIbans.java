package com.mykolas.sebibantask.model;

import java.util.List;

public class ListOfIbans {

    private List<String> ibans;

    public List<String> getIbans() {
        return ibans;
    }

    public void setIbans(List<String> ibans) {
        this.ibans = ibans;
    }

    public ListOfIbans() {
    }

    public ListOfIbans(List<String> ibans) {
        this.ibans = ibans;
    }
}