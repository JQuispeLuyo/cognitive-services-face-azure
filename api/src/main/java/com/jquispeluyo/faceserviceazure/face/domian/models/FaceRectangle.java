package com.jquispeluyo.faceserviceazure.face.domian.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceRectangle {

    private Integer top;
    private Integer left;
    private Integer width;
    private Integer height;

}
