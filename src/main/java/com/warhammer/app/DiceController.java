package com.warhammer.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("roll")
public class DiceController {
    @GetMapping
    ResponseEntity<String> getDiceRoll() {
        Random random = new Random();
        int min = 1;
        int max = 5;
        int result = random.nextInt(max + min) + min;
        return ResponseEntity.ok(String.valueOf(result));
    }
}
