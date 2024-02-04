package com.warhammer.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.warhammer.app.UnitData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CalculateDamageService {

    private final CalculateRolls calculateRolls;

    public CalculateDamageService(CalculateRolls calculateRolls) {
        this.calculateRolls = calculateRolls;
    }


    public int getDamageNumber(String name1, String name2)  {
        ArrayList<Integer> damageList = new ArrayList<>();
        UnitData unitdata1 = null;
        UnitData unitdata2 = null;
        try {
            unitdata1 = new UnitData(name1);
            unitdata2 = new UnitData(name2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 1000; i++) {
            ArrayList<Object> calculate_hit = calculateRolls.getConfirmed(1000, 3);
            ArrayList<Object> calculate_wound = calculateRolls.getConfirmed(calculate_hit.size(), 4);
            int rollsave = calculateRolls.getConfirmed(calculate_wound
                    .size(), unitdata2.getSave()
                    + unitdata1.getRend())
                    .size();
            int damage = unitdata1.getDamage();
            int damagenumber = rollsave * damage;
            damageList.add(damagenumber);
        }
        return  damageList.stream().mapToInt(damagenumber -> damagenumber).sum() / 1000;}
}

