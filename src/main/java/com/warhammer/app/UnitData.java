package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
//@Component
public class UnitData {
    int rend;
    int bravery;
    int attacks;
    int save;
    int damage;

    public UnitData(String name) throws JsonProcessingException {
        String uri = "https://aos-api.com/units/" + name;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(forEntity.getBody());
        this.rend = jsonNode.get("melee_weapons").get(2).get("rend").asInt();
        this.bravery = jsonNode.get("bravery").asInt();
        this.attacks = jsonNode.get("melee_weapons").get(2).get("attacks").asInt();
        this.save = jsonNode.get("save").asInt();
        this.damage = jsonNode.get("melee_weapons").get(2).get("damage").asInt();
    }
    public int getRend(){
        return this.rend;
    }
    public int getBravery(){
        return bravery;
    }
    public int getAttacks(){
        return attacks;
    }
    public int getSave(){
        return save;
    }
    public int getDamage(){
        return damage;
    }
}
