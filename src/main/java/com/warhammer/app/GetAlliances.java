package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class GetAlliances {
    ArrayList<Object> names;

    public GetAlliances() throws JsonProcessingException {
        names = new ArrayList<>();
        String uri = "https://aos-api.com/grand-alliances";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(forEntity.getBody());
        int i = 0;
        while (i < jsonNode.size()) {
            this.names.add(jsonNode.get(i).get("name"));
            i++;
        }
    }

    public ArrayList<Object> getname() {
        return this.names;
    }
}
