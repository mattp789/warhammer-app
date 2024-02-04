package com.warhammer.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@Service
public class Army {
    public static ArrayList<Object> getArmies(String name) throws JsonProcessingException {
        var armyarray = new ArrayList<>();
        String uri = "https://aos-api.com/allegiances?grand_alliance=" + name;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(forEntity.getBody());
        int i = 0;
        while (i < jsonNode.size()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", jsonNode.get(i).get("_id"));
            map.put("name", jsonNode.get(i).get("name"));
            armyarray.add(map);
            i++;
        }
        return armyarray;
    }
}
