package com.example.bankuinapps.Model;

public class kidData {

    private String name;
    private String id;
    private int allowance;

    public kidData(){}

    public kidData(String name, int allowance, String id) {
        this.name = name;
        this.allowance = allowance;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
