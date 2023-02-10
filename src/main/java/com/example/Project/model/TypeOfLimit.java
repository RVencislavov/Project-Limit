package com.example.Project.model;
//тип – съкращение на вида лимит;
//        пълно име – пълно наименование на лимит;

import java.util.ArrayList;
import java.util.List;

public class TypeOfLimit {
    private int id;
    private String limitTypeAbbreviation;
    private String fullNameOfTheLimit;


    public TypeOfLimit() {
    }

    public TypeOfLimit(int id, String limitTypeAbbreviation, String fullNameOfTheLimit) {
        this.id = id;
        this.limitTypeAbbreviation = limitTypeAbbreviation;
        this.fullNameOfTheLimit = fullNameOfTheLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLimitTypeAbbreviation() {
        return limitTypeAbbreviation;
    }

    public void setLimitTypeAbbreviation(String limitTypeAbbreviation) {
        this.limitTypeAbbreviation = limitTypeAbbreviation;
    }

    public String getFullNameOfTheLimit() {
        return fullNameOfTheLimit;
    }

    public void setFullNameOfTheLimit(String fullNameOfTheLimit) {
        this.fullNameOfTheLimit = fullNameOfTheLimit;
    }

    @Override
    public String toString() {
        return "TypeOfLimit{" +
                "id=" + id +
                ", limitTypeAbbreviation='" + limitTypeAbbreviation + '\'' +
                ", fullNameOfTheLimit='" + fullNameOfTheLimit + '\'' +
                '}';
    }
}
