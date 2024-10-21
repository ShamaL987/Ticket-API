package com.example.oopcw.controller;

import com.example.oopcw.model.Configuration;
import com.example.oopcw.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {
    private final ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping
    public Configuration getConfiguration() throws IOException {
        return configurationService.loadConfiguration();
    }

    @PostMapping
    public void setConfiguration(@RequestBody Configuration configuration) throws IOException {
        configurationService.saveConfiguration(configuration);
    }
}
