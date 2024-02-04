package com.warhammer.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Service
public class AllianceFromFileService {
    public static Set<String> getName() throws IOException {

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
