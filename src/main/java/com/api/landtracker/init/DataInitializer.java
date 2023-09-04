package com.api.landtracker.init;

import com.api.landtracker.model.entities.Lote;
import com.api.landtracker.repository.LoteRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
//@Profile("data-init")
public class DataInitializer implements ApplicationRunner {

    private final LoteRepository loteRepository;

    @Autowired
    public DataInitializer(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        cargarDatosDesdeJSON("data.json");
    }

    private void cargarDatosDesdeJSON(String jsonFilePath) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Lote> lotes = objectMapper.readValue(jsonContent, new TypeReference<>() {
            });

            loteRepository.saveAll(lotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
