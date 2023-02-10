package com.example.Project.service;


import com.example.Project.Dao.ClientDao;
import com.example.Project.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ClientService implements IClientService{


    private final ClientDao clientDao;

    @Autowired
    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client getById(int id) {
        return this.clientDao.getByClientId(id);
    }

    public Client addClient(Client client) {

        return clientDao.addClient(client);
    }

    public Client updateClient(int id, Client client) {
        Client byId = this.clientDao.getByClientId(id);

        if (byId == null) {
            return null;
        }

        byId.setPersonName(client.getPersonName());
        Client updatedClient = this.clientDao.updateClient(id, byId);

        return updatedClient;
    }


}
