package com.example.bankuinapps.Model;

import android.content.Intent;

import java.util.Map;

public class childrenData {
    private String name;
    private String id;
    private int allowance;
    //Map<String, String> expenses;

    public childrenData(String name, String id, int allowance) {
        this.name = name;
        this.id = id;
        this.allowance = allowance;
        //this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }


}
