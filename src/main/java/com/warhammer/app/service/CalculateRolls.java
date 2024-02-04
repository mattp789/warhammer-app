package com.warhammer.app.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculateRolls {

    private final DiceRoll diceRoll;

    public CalculateRolls(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public ArrayList<Object> getConfirmed(int diceIn, int toNumber) {
        var confirmed = new ArrayList<>();
        for (int i = 0; i < diceIn; i++){
            DiceRoll result = diceRoll;
            if (result.getDice() > toNumber) {
                confirmed.add(result.getDice());
            }
        }
        return confirmed;
    }
}
