package com.warhammer.app;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ArmyController {
    @GetMapping("/getarmy/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Object> Army(@PathVariable String name) throws JsonProcessingException {
        return new Army(name).getarmies();
    }
}
