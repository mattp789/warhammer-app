package com.warhammer.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/getalliances")
public class AlliancesController {
    Logger logger = LoggerFactory.getLogger(AlliancesController.class);

    @GetMapping
    public ArrayList<Object> Alliance() throws JsonProcessingException {
        logger.debug("GET /getalliances");
        return new GetAlliances().getname();
    }
}
