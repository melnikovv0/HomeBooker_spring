package com.example.homebooker.controller;

import com.example.homebooker.model.Accommodation;
import com.example.homebooker.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> getAll() {
        return accommodationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Accommodation> getById(@PathVariable Long id) {
        return accommodationService.getById(id);
    }

    @PostMapping
    public Accommodation create(@RequestBody Accommodation accommodation) {
        return accommodationService.create(accommodation);
    }

    @PutMapping("/{id}")
    public Accommodation update(@PathVariable Long id, @RequestBody Accommodation updated) {
        return accommodationService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accommodationService.delete(id);
    }
}
