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

    @Value("${GOOGLE_CREDENTIALS:no_found}")
    private String gscCredentials;

    @Value("${ENTORNO:dev}")
    private String env;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) { return builder.build(); }

    @Bean
    public Storage storage() throws IOException {
        if(env.equals("dev")){
            return StorageOptions.newBuilder()
                    .setProjectId("ci-cd-demo-275102")
                    .build()
                    .getService();

        }else if(env.equals("prod")){

            JsonObject jsonObject = JsonParser.parseString(gscCredentials).getAsJsonObject();
            InputStream is = new ByteArrayInputStream(jsonObject.toString().getBytes());

            return StorageOptions.newBuilder()
                    .setProjectId("ci-cd-demo-275102")
                    .setCredentials(GoogleCredentials.fromStream(is))
                    .build()
                    .getService();

        }else{
            return StorageOptions.newBuilder().build().getService();
        }

    }

}
