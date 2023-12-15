package com.warhammer.app;


import java.util.ArrayList;

public class CalculateRolls {
    ArrayList<Object> confirmed;
    public CalculateRolls(int dice_in, int to_number) {
        confirmed = new ArrayList<>();
        for (int i = 0; i < dice_in; i++){
            DiceRoll result = new DiceRoll();
            if (result.getDice() > to_number) {
                this.confirmed.add(result.getDice());
            }
        }

    }
    public ArrayList<Object> getConfirmed() {
        return this.confirmed;
    }
}
