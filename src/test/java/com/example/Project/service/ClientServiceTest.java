package com.example.Project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.example.Project.Dao.ClientDao;
import com.example.Project.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class ClientServiceTest {

    @Mock
    private ClientDao clientDao;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientService = new ClientService(clientDao);
    }

    @Test
    public void testGetById() {
        Client client = new Client();
        client.setId(1);
        client.setPersonName("Rado Vencislavov");

        when(clientDao.getByClientId(1)).thenReturn(client);

        Client result = clientService.getById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Rado Vencislavov", result.getPersonName());
    }

    @Test
    public void testAddClient() {
        Client client = new Client();
        client.setPersonName("Ivan Vanchev");

        when(clientDao.addClient(client)).thenReturn(client);

        Client result = clientService.addClient(client);
        assertNotNull(result);
        assertEquals("Ivan Vanchev", result.getPersonName());
    }

    @Test
    public void testUpdateClient() {
        Client byId = new Client();
        byId.setId(1);
        byId.setPersonName("Ivailo Ivanov");

        when(clientDao.getByClientId(1)).thenReturn(byId);
        when(clientDao.updateClient(1, byId)).thenReturn(byId);

        Client client = new Client();
        client.setPersonName("Ivailo Ivanov");

        Client result = clientService.updateClient(1, client);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Ivailo Ivanov", result.getPersonName());
    }

    @Test
    public void testUpdateClient_ClientNotFound() {
        when(clientDao.getByClientId(2)).thenReturn(null);

        Client client = new Client();
        client.setPersonName("Kiril Kirilov");

        Client result = clientService.updateClient(2, client);
        assertNull(result);
    }
}