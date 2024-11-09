package com.example.springapp.controller;

import com.example.springapp.components.MockServerClient;
import io.micrometer.tracing.SpanName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private MockServerClient integrationService;

    public AppController(MockServerClient integrationService) {
        this.integrationService = integrationService;
    }


    @PostMapping("/trace")
    @SpanName("processRequest")
    public ResponseEntity<Object> processRequest(@RequestBody(required = false) Object requestData) {
        String response = integrationService.callMockService(requestData);
        return ResponseEntity.ok().body(response);
    }


}
