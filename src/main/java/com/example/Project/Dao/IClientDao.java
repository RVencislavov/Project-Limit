package com.example.Project.Dao;

import com.example.Project.model.Client;

public interface IClientDao {
    public Client getByClientId(int id) ;
    public Client addClient(Client client);
    public Client updateClient(int id, Client client);

}

