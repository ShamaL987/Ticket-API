package com.example.oopcw.service;

import com.example.oopcw.model.Configuration;
import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ConfigurationService {
    private static final String CONFIG_FILE_PATH = "config.json";

    public Configuration loadConfiguration() throws IOException {
        Resource resource = new ClassPathResource(CONFIG_FILE_PATH);
        String content = new String(Files.readAllBytes(Paths.get(resource.getURI())));
        return new Gson().fromJson(content, Configuration.class);
    }

    public void saveConfiguration(Configuration configuration) throws IOException {
        Resource resource = new ClassPathResource(CONFIG_FILE_PATH);
        Files.write(Paths.get(resource.getURI()), new Gson().toJson(configuration).getBytes());
    }
}
