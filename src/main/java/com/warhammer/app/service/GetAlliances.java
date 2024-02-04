package com.warhammer.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
@Service
public class GetAlliances {

    public ArrayList<Object> getName() throws JsonProcessingException {
        var names = new ArrayList<>();
        String uri = "https://aos-api.com/grand-alliances";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(forEntity.getBody());
        int i = 0;
        while (i < jsonNode.size()) {
            names.add(jsonNode.get(i).get("name"));
            i++;
        }
        return names;
    }
}
