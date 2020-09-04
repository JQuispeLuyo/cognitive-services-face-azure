package com.jquispeluyo.faceserviceazure.face.domian.service;

import com.jquispeluyo.faceserviceazure.face.domian.models.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacialRecognitionAzure implements FacialRecognition{

    @Autowired
    RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();

    String BASE_URL = "https://eastus2.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01";
    String API_KEY = "2c7b0d46afe146f798df04e142cf67ba";

    @Override
    public Object byUrl(Url url) {

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Ocp-Apim-Subscription-Key", API_KEY);

        HttpEntity<Object> entity = new HttpEntity<>(url, headers);
        ResponseEntity<Object> response = restTemplate.postForEntity(BASE_URL, entity, Object.class);

        return response.getBody();
    }
}
