package com.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kafka.services.KafkaProducerService;

@RestController
public class KafkasController {

    private final KafkaProducerService kafkaProducerService;

    public KafkasController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent successfully";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
            return ResponseEntity.badRequest().body("Please upload a valid CSV file.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            List<String[]> rows = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(","); // You can use a CSV parser like OpenCSV for more complex needs
                rows.add(columns);
            }

            // Optional: log or process data
            for (String[] row : rows) {
                kafkaProducerService.sendMessage(Arrays.toString(row));
            }
            return ResponseEntity.ok("CSV file uploaded and processed successfully.");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error processing CSV file: " + e.getMessage());
        }
    }
}
