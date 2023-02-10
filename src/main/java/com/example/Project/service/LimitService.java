package com.example.Project.service;

import com.example.Project.Dao.ILimitDao;
import com.example.Project.Dao.LimitDao;
import com.example.Project.model.Client;
import com.example.Project.model.Limit;
import com.example.Project.model.TypeOfLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LimitService implements ILimitService {

    private final TypeService typeService;
    private final ClientService clientService;

    private final LimitDao dao;

    @Autowired
    public LimitService(TypeService typeService, ClientService clientService, LimitDao dao) {
        this.typeService = typeService;
        this.clientService = clientService;
        this.dao = dao;
    }


    public Limit add(Limit limit) {
        TypeOfLimit type = this.typeService.getById(limit.getTypeOfLimitID());
        if (type == null) {
            return null;
        }

        Client client = this.clientService.getById(limit.getClientID());
        if (client == null) {
            return null;
        }

        return this.dao.add(limit);
    }

    public List<Limit> getAll() {
        return this.dao.getAll();
    }
}
