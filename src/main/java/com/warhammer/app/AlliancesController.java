package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/getalliances")
public class AlliancesController {
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Object> Alliance() throws JsonProcessingException {
        return new GetAlliances().getname();
    }
}
