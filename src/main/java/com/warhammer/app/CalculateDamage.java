package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;

public class CalculateDamage {
    int damageNumber;
    public CalculateDamage(String name1, String name2) throws JsonProcessingException {
        ArrayList<Integer> damageList = new ArrayList<>();
        UnitData unitdata1 = new UnitData(name1);
        UnitData unitdata2 = new UnitData(name2);
        for (int i = 0; i < 1000; i++) {
            CalculateRolls calculate_hit = new CalculateRolls(1000, 3);
            CalculateRolls calculate_wound = new CalculateRolls(calculate_hit.getConfirmed().size(), 4);
            int rollsave = new CalculateRolls(calculate_wound
                    .getConfirmed().size(), unitdata2.getSave()
                    + unitdata1.getRend())
                    .getConfirmed().size();
            int damage = unitdata1.getDamage();
            int damagenumber = rollsave * damage;
            damageList.add(damagenumber);
        }
        this.damageNumber =  damageList.stream().mapToInt(damagenumber -> damagenumber).sum() / 1000;
    }

    public int getDamageNumber(){return this.damageNumber;}
}

