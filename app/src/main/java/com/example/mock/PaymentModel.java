package com.example.mock;

public class PaymentModel {
    private int id;
    private double amount;
    private String status;
    private String date;
    private String boarderName;
    private String boardingHouseName;

    public PaymentModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBoarderName() {
        return boarderName;
    }

    public void setBoarderName(String boarderName) {
        this.boarderName = boarderName;
    }

    public String getBoardingHouseName() {
        return boardingHouseName;
    }

    public void setBoardingHouseName(String boardingHouseName) {
        this.boardingHouseName = boardingHouseName;
    }
}
