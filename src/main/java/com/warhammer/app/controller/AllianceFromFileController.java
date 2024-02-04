package com.warhammer.app.controller;

import com.warhammer.app.service.AllianceFromFileService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Set;


@RestController
public class AllianceFromFileController {
    private final AllianceFromFileService allianceFromFileService;

    public AllianceFromFileController(AllianceFromFileService allianceFromFileService) {
        this.allianceFromFileService = allianceFromFileService;
    }

    @GetMapping("/alliance")
    @CrossOrigin(origins = "http://localhost:5173")

    public Set<String> Alliance() throws IOException {
        return allianceFromFileService.getName();
    }

}

