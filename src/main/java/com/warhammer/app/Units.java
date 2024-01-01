package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class Units {
    ArrayList<Object> armyarray;
    HashMap<String, Object> map;

    public Units(String army) throws JsonProcessingException {
        armyarray = new ArrayList<>();
        String uri = "https://aos-api.com/units?allegiance=" + army;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(forEntity.getBody());
        int i = 0;
        while (i < jsonNode.size()) {
            map = new HashMap<String, Object>();
            map.put("id", jsonNode.get(i).get("_id"));
            map.put("name", jsonNode.get(i).get("name"));
            this.armyarray.add(map);
            i++;
        }
    }

    public ArrayList<Object> getunits() {
        return this.armyarray;
    }
}