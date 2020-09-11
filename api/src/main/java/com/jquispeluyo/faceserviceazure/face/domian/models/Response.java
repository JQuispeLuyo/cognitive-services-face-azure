package com.jquispeluyo.faceserviceazure.face.domian.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String faceId;
    private FaceRectangle faceRectangle;
    private FaceAttributes faceAttributes;
    private String recognitionModel;

}
