package com.example.Project.Dao;

import com.example.Project.model.TypeOfLimit;

import java.util.List;

public interface ITypeDao {
    public TypeOfLimit addType(TypeOfLimit type);
    public TypeOfLimit getByTypeId(int id);
    public TypeOfLimit updateType(int id, TypeOfLimit type);
    public List<TypeOfLimit> getAll();
    public List<TypeOfLimit> searchAbr(String abr);
    public List<TypeOfLimit> searchByFullName(String fullName);
    public TypeOfLimit delete(int id);
}
