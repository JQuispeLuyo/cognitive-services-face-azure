package com.jquispeluyo.faceserviceazure.face.domian.service;

import com.jquispeluyo.faceserviceazure.face.domian.models.Response;
import com.jquispeluyo.faceserviceazure.face.domian.models.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class FacialRecognitionAzure implements FacialRecognition{

    @Autowired
    RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();

    String BASE_URL = "https://eastus2.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01";
    String API_KEY = "2c7b0d46afe146f798df04e142cf67ba";

    @Override
    public List<Response> byUrl(Url url) {

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Ocp-Apim-Subscription-Key", API_KEY);

        //HttpEntity<Url> entity = new HttpEntity<>(url, headers);
        //ResponseEntity<Object> response = restTemplate.postForEntity(BASE_URL, entity, Object.class);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("returnFaceId", "true")
                .queryParam("returnFaceLandmarks", "false")
                .queryParam("returnFaceAttributes", "Glasses,Smile,Age,Gender,Emotion")
                .queryParam("recognitionModel", "recognition_01")
                .queryParam("returnRecognitionModel", "true")
                .queryParam("detectionModel", "detection_01");

        HttpEntity<Url> entity = new HttpEntity<>(url, headers);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<Response[]> response = restTemplate.postForEntity(builder.toUriString(), entity, (Response[].class));

        return Arrays.asList(response.getBody().clone());
    }
}
