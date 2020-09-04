package com.jquispeluyo.faceserviceazure.face.controllers.rest;

import com.jquispeluyo.faceserviceazure.face.domian.models.Url;
import com.jquispeluyo.faceserviceazure.face.domian.service.FacialRecognition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/face")
public class FacialRecognitionRest {

    private FacialRecognition facialRecognition;

    public FacialRecognitionRest(FacialRecognition facialRecognition) {
        this.facialRecognition = facialRecognition;
    }

    @PostMapping("/recognition")
    public Object facialRecognition (@RequestBody Url url){
        return facialRecognition.byUrl(url);
    }

}
