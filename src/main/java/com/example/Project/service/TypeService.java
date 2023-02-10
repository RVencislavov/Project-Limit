package com.example.Project.service;

import com.example.Project.Dao.LimitDao;
import com.example.Project.Dao.TypeDao;
import com.example.Project.model.Limit;
import com.example.Project.model.TypeOfLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TypeService implements  ITypeService{
    private final TypeDao typeDao;
    private final LimitDao limitDao;

    @Autowired
    public TypeService(TypeDao typeDao, LimitDao limitDao) {
        this.typeDao = typeDao;
        this.limitDao = limitDao;
    }

    public TypeOfLimit getById(int id) {
        return this.typeDao.getByTypeId(id);
    }

    public TypeOfLimit addType(TypeOfLimit type) {

        return typeDao.addType(type);
    }

    public TypeOfLimit updateType(int id, TypeOfLimit type) {
        TypeOfLimit byTypeId = this.typeDao.getByTypeId(id);

        if (byTypeId == null) {
            return null;
        }

        byTypeId.setFullNameOfTheLimit(type.getFullNameOfTheLimit());
        byTypeId.setLimitTypeAbbreviation(type.getLimitTypeAbbreviation());

        return this.typeDao.updateType(id, byTypeId);
    }

    public List<TypeOfLimit> getAll() {
        return this.typeDao.getAll();
    }

    public List<TypeOfLimit> searchAbr(String abr) {

        return this.typeDao.searchAbr(abr);
    }

    public List<TypeOfLimit> searchByFullName(String fullName) {

        return this.typeDao.searchByFullName(fullName);
    }

    public TypeOfLimit delete(int id) {
        List<Limit> allLimits = limitDao.getAll();
        if (allLimits.stream().anyMatch(l -> l.getTypeOfLimitID() == id)) {
            return null;
        }

        return this.typeDao.delete(id);
    }

}
