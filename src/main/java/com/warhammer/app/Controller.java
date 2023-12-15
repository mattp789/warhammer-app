package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
//@ComponentScan(basePackageClasses = UnitData.class)
@RestController
public class Controller {
    @CrossOrigin(origins = "http://localhost:3000")
    //    @Bean
    @GetMapping("/getunit/{name1}/{name2}")
    public int Unit(@PathVariable String name1, @PathVariable String name2) throws JsonProcessingException {
        int damageNumber = new CalculateDamage(name1, name2).getDamageNumber();
        return damageNumber;
    }
}