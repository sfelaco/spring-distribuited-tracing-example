package com.example.springapp.config;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InterceptorConfig {


    public InterceptorConfig() {

    }

    @Bean
    OtlpGrpcSpanExporter otlpHttpSpanExporter(@Value("${OTEL_ENDOPOINT:http://localhost:4317}") String url) {
        return  OtlpGrpcSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }



    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

}
