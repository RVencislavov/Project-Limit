package com.example.Project.service;

import com.example.Project.model.Client;

public interface IClientService {
    public Client addClient(Client client);
    public Client updateClient(int id, Client client);
}
