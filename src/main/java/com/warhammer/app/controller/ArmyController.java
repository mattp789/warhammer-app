package com.warhammer.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.warhammer.app.service.Army;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class ArmyController {

    private final Army army;

    public ArmyController(Army army) {
        this.army = army;
    }

    @GetMapping("/getarmy/{name}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ArrayList<Object> Army(@PathVariable String name) throws JsonProcessingException {
        return army.getArmies(name);
    }
}
