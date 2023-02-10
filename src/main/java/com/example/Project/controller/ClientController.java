package com.example.Project.controller;

import com.example.Project.model.Client;
import com.example.Project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @PostMapping("/add")
    public ResponseEntity<Client> createClient(@RequestBody @NonNull Client client) {
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
        Client updatedClient = this.clientService.updateClient(id, client);

        if (updatedClient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedClient);
    }


}
