package com.example.Project.controller;

import com.example.Project.model.TypeOfLimit;
import com.example.Project.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/add")
    public ResponseEntity<TypeOfLimit> createType(@RequestBody @NonNull TypeOfLimit type) {
        TypeOfLimit typeOfLimit = typeService.addType(type);
        return new ResponseEntity<>(typeOfLimit, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TypeOfLimit> updateType(@PathVariable("id") int id, @RequestBody TypeOfLimit type) {
        TypeOfLimit typeOfLimit = this.typeService.updateType(id, type);

        if (typeOfLimit == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(typeOfLimit);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeOfLimit>> getAll() {
        List<TypeOfLimit> all = this.typeService.getAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TypeOfLimit>> getByAbbreviation(@RequestParam String abr) {
        List<TypeOfLimit> typeOfLimits = this.typeService.searchAbr(abr);

        if (typeOfLimits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(typeOfLimits);
    }

    @GetMapping("/searchByFullName")
    public ResponseEntity<List<TypeOfLimit>> getByFullName(@RequestParam String fullName) {
        List<TypeOfLimit> typeOfLimits = this.typeService.searchByFullName(fullName);

        if (typeOfLimits.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(typeOfLimits);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<TypeOfLimit> delete(@PathVariable int id) {
        TypeOfLimit deleted = this.typeService.delete(id);

        if (deleted == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(deleted);
    }
}
