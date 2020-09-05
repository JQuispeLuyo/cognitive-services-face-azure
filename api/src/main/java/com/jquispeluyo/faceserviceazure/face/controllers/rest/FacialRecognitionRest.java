package com.jquispeluyo.faceserviceazure.face.controllers.rest;

import com.jquispeluyo.faceserviceazure.face.domian.models.Url;
import com.jquispeluyo.faceserviceazure.face.domian.service.FacialRecognition;
import com.jquispeluyo.faceserviceazure.gcs.GcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/face-recognition")
@CrossOrigin
public class FacialRecognitionRest {

    private FacialRecognition facialRecognition;

    @Autowired
    GcsService gcsService;
    public FacialRecognitionRest(FacialRecognition facialRecognition) {
        this.facialRecognition = facialRecognition;
    }

    @PostMapping("/url")
    public Object facialRecognitionUrl (@RequestBody Url url){
        return facialRecognition.byUrl(url);
    }

    @PostMapping(value = "/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile filePart) throws IOException {

        String link = gcsService.upload(filePart);
        return facialRecognition.byUrl(new Url(link));

    }

}
