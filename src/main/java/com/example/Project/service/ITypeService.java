package com.example.Project.service;

import com.example.Project.model.TypeOfLimit;

import java.util.List;

public interface ITypeService  {
    public TypeOfLimit updateType(int id, TypeOfLimit type);
    public List<TypeOfLimit> getAll();
    public List<TypeOfLimit> searchAbr(String abr);
    public List<TypeOfLimit> searchByFullName(String fullName);
    public TypeOfLimit delete(int id);
    public TypeOfLimit addType(TypeOfLimit type);
    public TypeOfLimit getById(int id);
}
