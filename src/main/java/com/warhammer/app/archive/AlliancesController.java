package com.warhammer.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.warhammer.app.service.GetAlliances;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AlliancesController {

    private final GetAlliances getAlliances;

    public AlliancesController(GetAlliances getAlliances) {
        this.getAlliances = getAlliances;
    }

    @GetMapping("/getalliances")
    @CrossOrigin(origins = "http://localhost:5173")
    public ArrayList<Object> Unit() throws JsonProcessingException {
        return getAlliances.getName();
    }
}
