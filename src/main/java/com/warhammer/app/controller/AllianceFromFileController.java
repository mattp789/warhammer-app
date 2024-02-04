package com.warhammer.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.regex.Matcher;


@RestController
public class AllianceFromFileController {

    @GetMapping("/alliance")
    @CrossOrigin(origins = "http://localhost:5173")

    public Set<String> Alliance() throws IOException {
        Path directory = Path.of("/Users/matt/repos/warhammer-app/src/main/resources/Datafiles");
        Pattern pattern = Pattern.compile("^\\w*");
        return Files.list(directory)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .map(Path::toString)
                .map(fileName -> pattern.matcher(fileName))
                .filter(Matcher::find)
                .map(Matcher::group)
                .collect(Collectors.toSet());
    }

}
