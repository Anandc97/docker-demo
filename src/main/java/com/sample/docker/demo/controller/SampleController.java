package com.sample.docker.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class SampleController {
    private static final String FILE_PATH = "/var/file/file.txt";

    @GetMapping("/docker/demo")
    public ResponseEntity<String> demo() {
        String response = "Successfully completed request";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("docker/demo/volume")
    public ResponseEntity<String> demoVolume() {
        StringBuilder resultStringBuilder = new StringBuilder();
        String message = "null";
        HttpStatus ok = HttpStatus.OK;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                resultStringBuilder.append(line).append(" ");
            }
            message = resultStringBuilder.toString();
            reader.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
            ok = HttpStatus.I_AM_A_TEAPOT;
            message = ok.getReasonPhrase();
        }
        return new ResponseEntity<>(message, ok);
    }
}
