package com.warhammer.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.warhammer.app.service.CalculateDamageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    private final CalculateDamageService calculateDamageService;

    public Controller(CalculateDamageService calculateDamageService) {
        this.calculateDamageService = calculateDamageService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getunit/{name1}/{name2}")
    public int Unit(@PathVariable String name1, @PathVariable String name2) throws JsonProcessingException {
        int damageNumber = calculateDamageService.getDamageNumber(name1, name2);
        return damageNumber;
    }
}