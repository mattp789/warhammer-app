package com.warhammer.app.service;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class DiceRoll {

    public int getDice(){
        Random random = new Random();
        int min = 1;
        int max = 5;
        return random.nextInt(max + min) + min;};
}
