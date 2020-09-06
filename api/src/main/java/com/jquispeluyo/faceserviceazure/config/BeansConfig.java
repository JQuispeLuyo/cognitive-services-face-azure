package com.jquispeluyo.faceserviceazure.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class BeansConfig {

    @Value("${CREDENTIALS_GMAIL}")
    private String gservicesConfig;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        System.out.println(gservicesConfig);
        return builder.build();

    }

    @Bean
    public Storage storage() throws IOException {

        ///System.out.println(env.getProperty("GOOGLE_CREDENTIALS"));
        System.out.println(gservicesConfig);
        JsonObject jsonObject = JsonParser.parseString(gservicesConfig).getAsJsonObject();
        InputStream is = new ByteArrayInputStream(jsonObject.toString().getBytes());

        return StorageOptions.newBuilder()
                .setProjectId("ci-cd-demo-275102")
                .setCredentials(GoogleCredentials.fromStream(is))
                .build()
                .getService();
    }

}
