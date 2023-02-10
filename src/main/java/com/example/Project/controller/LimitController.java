package com.example.Project.controller;

import com.example.Project.model.Limit;
import com.example.Project.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/limit")
public class LimitController {

    private final LimitService service;

    @Autowired
    public LimitController(LimitService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Limit> addLimit(@RequestBody Limit limit) {
        Limit newLimit = this.service.add(limit);
        if(newLimit == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(newLimit);
    }
}
