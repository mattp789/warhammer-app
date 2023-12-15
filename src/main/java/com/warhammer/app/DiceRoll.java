package com.warhammer.app;

import java.util.Random;

public class DiceRoll {
    int dice;
    public DiceRoll(){
        Random random = new Random();
        int min = 1;
        int max = 5;
        this.dice = random.nextInt(max + min) + min;
    }
    public int getDice(){return this.dice;}
}
