package com.example.Project.model;
//idInvoice – primary key, уникална референция за лимит;
//сума – сума на лимит;
//валута – валута на лимит;
//idPerson - уникална референция за клиент;
//начална дата – дата, от която влиза в сила лимита;
//крайна дата – дата, до която е валиден лимита;
//тип – тип на лимита;
//дата на промяна – дата, на която лимита е бил променен (не създаден);
//import jdk.vm.ci.meta.Local;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Limit {
    private int id ;
    private int sumOfLimit;
    private String currencyOfLimit;
    private int clientID;

    private LocalDate startingDate;

    private LocalDate endingDate;
    private int typeOfLimitID;

    private LocalDate updatedDate;

    public Limit() {
        this.startingDate = LocalDate.now();
    }



    public Limit(int id, int sumOfLimit, String currencyOfLimit, int clientID,
                 LocalDate endingDate, int typeOfLimitID) {
        this.id = id;
        this.sumOfLimit = sumOfLimit;
        this.currencyOfLimit = currencyOfLimit;
        this.clientID = clientID;
        this.startingDate = LocalDate.now();
        this.endingDate = endingDate;
       this.typeOfLimitID = typeOfLimitID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSumOfLimit() {
        return sumOfLimit;
    }

    public void setSumOfLimit(int sumOfLimit) {
        this.sumOfLimit = sumOfLimit;
    }

    public String getCurrencyOfLimit() {
        return currencyOfLimit;
    }

    public void setCurrencyOfLimit(String currencyOfLimit) {
        this.currencyOfLimit = currencyOfLimit;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public int getTypeOfLimitID() {
        return typeOfLimitID;
    }

    public void setTypeOfLimitID(int typeOfLimitID) {
        this.typeOfLimitID = typeOfLimitID;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + id +
                ", sumOfLimit=" + sumOfLimit +
                ", currencyOfLimit='" + currencyOfLimit + '\'' +
                ", clientID=" + clientID +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
