package com.example.bankuinapps.Model;

public class expensesData {
    private String category;
    private int amount;
    private String note;
    private String expensesid;

    public expensesData(){}

    public expensesData(String category, int amount, String note, String expensesid) {
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.expensesid = expensesid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExpensesid() { return expensesid; }

    public void setExpensesid(String expensesid) {
        this.expensesid = expensesid;
    }


}
